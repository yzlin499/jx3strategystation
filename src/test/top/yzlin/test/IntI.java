package top.yzlin.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class IntI implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            try {
                return method.invoke(this, args);
            } catch (Throwable t) {
                t.printStackTrace();
                return null;
            }
        } else {
            return method.getName();
        }
    }
}
