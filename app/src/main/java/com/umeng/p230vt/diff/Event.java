package com.umeng.p230vt.diff;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.p230vt.diff.util.ClassLoadUtil;
import com.umeng.tunnel.UMChannelAgent;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: classes2.dex */
public class Event {
    private static final int MAX_PROPERTY_LENGTH = 128;

    public static void commit(Context context, View view, String str, Map<String, Object> map, Boolean bool) {
        if (!bool.booleanValue()) {
            if (view != null) {
                String textPropertyFromView = textPropertyFromView(view);
                if (!TextUtils.isEmpty(textPropertyFromView)) {
                    map.put(C3822V.VISUAL_TRACK_TEXT, textPropertyFromView);
                }
                map.put(C3822V.VISUAL_TRACK_PG, view.getContext().getClass().getName());
            } else {
                map.put(C3822V.VISUAL_TRACK_PG, context.getClass().getName());
            }
            map.put(C3822V.VISUAL_TRACK_STYLE, 1);
            map.put(C3822V.VISUAL_TRACK_UAPP_PG, getPageName());
            UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "release:事件名: " + str);
            if (map.containsKey(C3822V.VISUAL_TRACK_TEXT)) {
                UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "release:事件名: " + str + "; 参数：" + ((String) map.get(C3822V.VISUAL_TRACK_TEXT)));
            }
            if (map.containsKey(C3822V.VISUAL_TRACK_PG)) {
                UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "release:事件名: " + str + "; 页面：" + ((String) map.get(C3822V.VISUAL_TRACK_PG)));
            }
            if (map.containsKey(C3822V.VISUAL_TRACK_UAPP_PG)) {
                UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "release:事件名: " + str + "; UApp页面路径：" + ((String) map.get(C3822V.VISUAL_TRACK_UAPP_PG)));
            }
            MobclickAgent.onEventObject(context, str, map);
            return;
        }
        if (UMChannelAgent.init()) {
            if (view != null) {
                String textPropertyFromView2 = textPropertyFromView(view);
                if (!TextUtils.isEmpty(textPropertyFromView2)) {
                    map.put(C3822V.VISUAL_TRACK_TEXT, textPropertyFromView2);
                }
                map.put(C3822V.VISUAL_TRACK_PG, view.getContext().getClass().getName());
            } else {
                map.put(C3822V.VISUAL_TRACK_PG, context.getClass().getName());
            }
            map.put(C3822V.VISUAL_TRACK_STYLE, 1);
            map.put(C3822V.VISUAL_TRACK_UAPP_PG, getPageName());
            UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "config:事件名: " + str);
            if (map.containsKey(C3822V.VISUAL_TRACK_TEXT)) {
                UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "config:事件名: " + str + "; 参数：" + ((String) map.get(C3822V.VISUAL_TRACK_TEXT)));
            }
            if (map.containsKey(C3822V.VISUAL_TRACK_PG)) {
                UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "config:事件名: " + str + "; 页面：" + ((String) map.get(C3822V.VISUAL_TRACK_PG)));
            }
            if (map.containsKey(C3822V.VISUAL_TRACK_UAPP_PG)) {
                UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "config:事件名: " + str + "; UApp页面路径：" + ((String) map.get(C3822V.VISUAL_TRACK_UAPP_PG)));
            }
            UMChannelAgent.onDebugEvent(context, str, map);
        }
    }

    public static String getActivityName(View view) {
        Context context;
        if (view == null || (context = view.getContext()) == null) {
            return null;
        }
        if (context instanceof ContextWrapper) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (context instanceof Activity) {
            return context.getClass().getCanonicalName();
        }
        return null;
    }

    public static String getPageName(View view) {
        String pageName = getPageName();
        if (pageName != null && !pageName.equals("") && !pageName.equals("VT")) {
            return pageName;
        }
        String activityName = getActivityName(view);
        return (activityName == null || activityName.equals("")) ? "VT" : activityName;
    }

    public static void init(Context context, String str, String str2, int i2, String str3) {
    }

    public static void openDebug(String str) {
    }

    private static void reflectTrack(Context context, String str, Map<String, Object> map) {
        Method method;
        try {
            Class<?> findClass = ClassLoadUtil.findClass("com.umeng.analytics.MobclickAgent");
            if (findClass == null || (method = findClass.getMethod("onEvent", Context.class, String.class, Map.class)) == null) {
                return;
            }
            method.invoke(null, context, str, map);
        } catch (Exception unused) {
        }
    }

    private static String textPropertyFromView(View view) {
        if (view instanceof TextView) {
            CharSequence text = ((TextView) view).getText();
            if (text != null) {
                return text.toString();
            }
            return null;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        boolean z = false;
        for (int i2 = 0; i2 < childCount && sb.length() < 128; i2++) {
            String textPropertyFromView = textPropertyFromView(viewGroup.getChildAt(i2));
            if (textPropertyFromView != null && textPropertyFromView.length() > 0) {
                if (z) {
                    sb.append(", ");
                }
                sb.append(textPropertyFromView);
                z = true;
            }
        }
        if (sb.length() > 128) {
            return sb.substring(0, 128);
        }
        if (z) {
            return sb.toString();
        }
        return null;
    }

    public static String getPageName() {
        String currenPageName = PageNameMonitor.getInstance().getCurrenPageName();
        return TextUtils.isEmpty(currenPageName) ? "" : currenPageName;
    }
}
