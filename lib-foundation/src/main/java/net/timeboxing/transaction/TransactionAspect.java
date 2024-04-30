package net.timeboxing.transaction;


import jakarta.inject.Inject;
import jakarta.transaction.TransactionManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class TransactionAspect {

    private static final Logger LOG = LoggerFactory.getLogger(TransactionAspect.class);

    @Inject
    private TransactionManager transactionManager;

    @Around("@annotation(net.timeboxing.transaction.Transactional)")
    public Object wrapTransaction(ProceedingJoinPoint pjp) throws Exception {
        Transactional annotation = ((MethodSignature) pjp.getSignature()).getMethod().getAnnotation(Transactional.class);
        boolean doRollback = false;
        try {
            if (0 == transactionManager.getStatus()) {
                LOG.trace("Existing transaction found");
            } else {
                LOG.trace("Starting transaction");
                transactionManager.begin();
            }
            return pjp.proceed(pjp.getArgs());
        } catch (Exception e) {
            doRollback = shouldRollback(annotation, e);
            throw e;
        } catch (Throwable e) {
            doRollback = true;
            throw new TransactionException("Unexpected Throwable", e);
        } finally {
            if (!doRollback) {
                transactionManager.commit();
            } else {
                transactionManager.rollback();
            }
        }
    }

    private boolean shouldRollback(Transactional annotation, Throwable e) {
        for (Class<?> noRollback: annotation.dontRollbackOn()) {
            if (noRollback.isAssignableFrom(e.getClass())) {
                LOG.trace("No rollback for exception '{}'", e.getClass().getCanonicalName());
                return false;
            }
        }
        for (Class<?> doRollback: annotation.rollbackOn()) {
            if (doRollback.isAssignableFrom(e.getClass())) {
                LOG.trace("Rollback for exception '{}'", e.getClass().getCanonicalName());
                return true;
            }
        }
    }

}
