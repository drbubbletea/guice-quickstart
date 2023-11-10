package net.timeboxing.adapter.guice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class GuiceAOPAdaptMethodInterceptor implements MethodInterceptor {

    private static final Logger LOG = LoggerFactory.getLogger(GuiceAOPAdaptMethodInterceptor.class);
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        LOG.debug("Invoked");
        return Optional.empty();
    }
}
