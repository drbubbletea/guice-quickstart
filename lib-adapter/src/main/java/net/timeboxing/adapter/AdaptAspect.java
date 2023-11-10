package net.timeboxing.adapter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Aspect
public class AdaptAspect {

    private static final Logger LOG = LoggerFactory.getLogger(AdaptAspect.class);

//    @Around("execution(* net.timeboxing.adapter.Adaptable.*(..))")
    @Around("execution( * net.timeboxing.adapter.Adaptable.adaptTo(Class)) && target(net.timeboxing.adapter.Adaptable)")
    public Object around(ProceedingJoinPoint pjp) {
        LOG.debug("Around triggered for {}", pjp.getThis().getClass().getCanonicalName());
        try {
            return Optional.of(Integer.valueOf(1));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
