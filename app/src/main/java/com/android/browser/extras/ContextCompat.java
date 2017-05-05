package com.android.browser.extras;

import android.content.Context;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by ZhangDi on 2017/5/4.
 */

public class ContextCompat {

    public static File getSharedPrefsFile(Context ctx, String name) {
        try {
            return reflectGetSharedPrefsFile(ctx, name);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static File reflectGetSharedPrefsFile(Context ctx, String name) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final Method getSharedPrefsFile = ctx.getClass().getDeclaredMethod("getSharedPrefsFile", String.class);
        getSharedPrefsFile.setAccessible(true);
        return (File) getSharedPrefsFile.invoke(ctx, name);
    }
}
