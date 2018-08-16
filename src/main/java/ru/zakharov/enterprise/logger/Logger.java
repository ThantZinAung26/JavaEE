package ru.zakharov.enterprise.logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class Logger {
    @AroundInvoke
    public Object printLog(InvocationContext context) throws Exception {
        System.out.println("METHOD CALL: " + context.getMethod().getName());
        return context.proceed();
    }
}
