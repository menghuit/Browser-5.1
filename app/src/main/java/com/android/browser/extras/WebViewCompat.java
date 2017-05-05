package com.android.browser.extras;

import android.webkit.WebView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by zhangdi on 2017/4/16 0016.
 */
public class WebViewCompat {

    public static int getContentWidth(WebView webView) {
        try {
            return reflectGetContentWidth(webView);
        } catch (Exception e) {
            return 0;
        }
    }

    private static int reflectGetContentWidth(WebView webView) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final Method getContentWidth = webView.getClass().getDeclaredMethod("getContentWidth");
        getContentWidth.setAccessible(true);
        return (int) getContentWidth.invoke(webView);
    }

    public static int getVisibleTitleHeight(WebView view) {
        try {
            return reflectGetVisibleTitleHeight(view);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static int reflectGetVisibleTitleHeight(WebView view) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final Method getVisibleTitleHeight = view.getClass().getDeclaredMethod("getVisibleTitleHeight");
        getVisibleTitleHeight.setAccessible(true);
        return (int) getVisibleTitleHeight.invoke(view);
    }

    public static String getTouchIconUrl(WebView view) {
        try {
            return reflectGetTouchIconUrl(view);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "";
    }

    // A:by zd. {WebView#getTouchIconUrl} is hide
    private static String reflectGetTouchIconUrl(WebView view) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final Method getTouchIconUrl = view.getClass().getDeclaredMethod("getTouchIconUrl");
        getTouchIconUrl.setAccessible(true);
        return (String) getTouchIconUrl.invoke(view);
    }
}
