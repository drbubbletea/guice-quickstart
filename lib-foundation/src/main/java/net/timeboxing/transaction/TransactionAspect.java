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
    public Object wrapTransaction(ProceedingJoinPoint pjp) {
        Transactional annotation = ((MethodSignature) pjp.getSignature()).getMethod().getAnnotation(Transactional.class);
        try {
            transactionManager.begin();
            return pjp.proceed(pjp.getArgs());
        } catch (Throwable e) {
            // TODO: do not rollback: assignable to exception class defined in annotation?
            // TODO: rollback: assignable to exception class defined in annotation?
        } finally {
            transactionManager.commit();
        }
    }

}
