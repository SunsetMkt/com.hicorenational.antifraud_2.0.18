package com.umeng.ccg;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class CcgAgent {
    private static Object lock = new Object();
    private static ArrayList<ConfigListener> callbacks = new ArrayList<>();
    private static Object actionInfoLock = new Object();
    private static Map<String, ActionInfo> actionInfoTable = new HashMap();
    private static Map<String, ArrayList<String>> forbidSdkTable = new HashMap();

    static {
        forbidSdkTable.put(C3438a.f12332e, new ArrayList<>());
        forbidSdkTable.put(C3438a.f12331d, new ArrayList<>());
        forbidSdkTable.put(C3438a.f12329b, new ArrayList<>());
        forbidSdkTable.put(C3438a.f12330c, new ArrayList<>());
    }

    public static ActionInfo getActionInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (actionInfoLock) {
                r1 = actionInfoTable.containsKey(str) ? actionInfoTable.get(str) : null;
            }
        }
        return r1;
    }

    public static String[] getCollectItemList() {
        return new String[]{C3438a.f12332e, C3438a.f12331d, C3438a.f12329b, C3438a.f12330c};
    }

    public static ArrayList<String> getForbidSdkArray(String str) {
        if (forbidSdkTable.containsKey(str)) {
            return forbidSdkTable.get(str);
        }
        return null;
    }

    public static ArrayList<String> getRegistedModuleList() {
        ArrayList<String> arrayList;
        synchronized (actionInfoLock) {
            arrayList = new ArrayList<>(actionInfoTable.keySet());
        }
        return arrayList;
    }

    public static boolean hasRegistedActionInfo() {
        boolean z;
        synchronized (actionInfoLock) {
            z = actionInfoTable.size() > 0;
        }
        return z;
    }

    public static void init(Context context) {
        C3441d.m11471a().m11492a(context);
    }

    public static void notifyConfigReady(JSONObject jSONObject) {
        synchronized (lock) {
            int size = callbacks.size();
            if (size > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    callbacks.get(i2).onConfigReady(jSONObject);
                }
            }
        }
    }

    public static void registerActionInfo(ActionInfo actionInfo) {
        Context appContext = UMGlobalContext.getAppContext();
        if (actionInfo != null) {
            synchronized (actionInfoLock) {
                try {
                    String module = actionInfo.getModule(UMGlobalContext.getAppContext());
                    if (!TextUtils.isEmpty(module) && !actionInfoTable.containsKey(module)) {
                        String[] supportAction = actionInfo.getSupportAction(appContext);
                        if (supportAction != null) {
                            for (String str : supportAction) {
                                boolean switchState = actionInfo.getSwitchState(appContext, str);
                                if (forbidSdkTable.containsKey(str)) {
                                    ArrayList<String> arrayList = forbidSdkTable.get(str);
                                    if (!switchState) {
                                        arrayList.add(module);
                                    }
                                }
                            }
                        }
                        actionInfoTable.put(module, actionInfo);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static void registerConfigListener(ConfigListener configListener) {
        if (configListener != null) {
            synchronized (lock) {
                callbacks.add(configListener);
            }
        }
    }
}
