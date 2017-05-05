package com.android.browser.extras;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by zhangdi on 2017/4/16 0016.
 */
public class Reflect {

    public static <T> T doMethod(Object receiver, String methodName, Object... args)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if(null == receiver) {
            throw new IllegalArgumentException("Receiver must is not null.");
        }
        Class<?>[] argClasses = new Class<?>[args.length];
        for (int i = 0; i < args.length; i++) {
            argClasses[i] = args[i].getClass();
        }

        final Method method = receiver.getClass().getDeclaredMethod(methodName, argClasses);
        method.setAccessible(true);
        return (T) method.invoke(receiver, args);
    }
}
