package net.timeboxing.transaction;


import jakarta.inject.Inject;
import jakarta.transaction.TransactionManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class TransactionAspect {

    @Inject
    private TransactionManager transactionManager;

    @Around("@annotation(net.timeboxing.transaction.Transactional)")
    public Object wrapTransaction(ProceedingJoinPoint pjp) throws Exception {
        Transactional annotation = ((MethodSignature) pjp.getSignature()).getMethod().getAnnotation(Transactional.class);
        try {
            transactionManager.begin();
            return pjp.proceed(pjp.getArgs());
        } catch (Throwable e) {
            rollbackOrCommit(annotation, e);
        } finally {
            transactionManager.commit();
        }
    }

    private void rollbackOrCommit(Transactional annotation, Throwable e) throws Exception {
        for (Class<?> noRollback: annotation.dontRollbackOn()) {
            if (noRollback.isAssignableFrom(e.getClass())) {
                transactionManager.commit();
                return;
            }
        }
        for (Class<?> doRollback: annotation.rollbackOn()) {
            if (doRollback.isAssignableFrom(e.getClass())) {
                transactionManager.rollback();
                return;
            }
        }
    }

}
