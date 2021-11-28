package task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {

    private SomeInterfaceWithMethods methodsOriginal;

    public CustomInvocationHandler(SomeInterfaceWithMethods methodsOriginal) {
        this.methodsOriginal = methodsOriginal;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(method.getName() + " in");

        Object result = method.invoke(methodsOriginal, args);

        System.out.println(method.getName() + " out");

        return result;
    }
}



