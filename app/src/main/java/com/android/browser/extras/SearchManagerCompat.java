package com.android.browser.extras;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.pm.ServiceInfo;
import android.database.Cursor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by ZhangDi on 2017/5/4.
 */

public class SearchManagerCompat {

    public static ComponentName getWebSearchActivity(SearchManager manager) {
        try {
            return reflectGetWebSearchActivity(manager);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static ComponentName reflectGetWebSearchActivity(SearchManager manager) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final Method getWebSearchActiviy = manager.getClass().getDeclaredMethod("getWebSearchActivity");
        getWebSearchActiviy.setAccessible(true);
        return (ComponentName) getWebSearchActiviy.invoke(manager);
    }

    public static Cursor getSuggestions(SearchManager manager, SearchableInfo searchable, String query) {
        try {
            return reflectGetSuggestions(manager, searchable, query);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Cursor reflectGetSuggestions(SearchManager manager, SearchableInfo searchable, String query) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final Method getSuggestions = manager.getClass().getDeclaredMethod("getSuggestions", SearchableInfo.class, String.class);
        getSuggestions.setAccessible(true);
        return (Cursor) getSuggestions.invoke(manager, searchable, query);
    }
}
