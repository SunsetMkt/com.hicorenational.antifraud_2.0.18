package com.vivo.push.util;

import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: ConvertMsgToIntentImpl.java */
/* renamed from: com.vivo.push.util.i */
/* loaded from: classes2.dex */
public final class C3998i extends AbstractC3991b {

    /* renamed from: e */
    private int f14251e = 0;

    /* JADX WARN: Removed duplicated region for block: B:45:0x00df A[Catch: Exception -> 0x0153, TryCatch #1 {Exception -> 0x0153, blocks: (B:3:0x0005, B:5:0x000b, B:8:0x0013, B:17:0x003b, B:20:0x011f, B:23:0x0135, B:25:0x0045, B:26:0x0062, B:28:0x007f, B:35:0x00a1, B:36:0x00b3, B:37:0x00bd, B:39:0x00c7, B:41:0x00d3, B:45:0x00df, B:46:0x0105, B:48:0x0115, B:49:0x014b, B:30:0x0084, B:32:0x009d), top: B:2:0x0005, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0105 A[Catch: Exception -> 0x0153, TryCatch #1 {Exception -> 0x0153, blocks: (B:3:0x0005, B:5:0x000b, B:8:0x0013, B:17:0x003b, B:20:0x011f, B:23:0x0135, B:25:0x0045, B:26:0x0062, B:28:0x007f, B:35:0x00a1, B:36:0x00b3, B:37:0x00bd, B:39:0x00c7, B:41:0x00d3, B:45:0x00df, B:46:0x0105, B:48:0x0115, B:49:0x014b, B:30:0x0084, B:32:0x009d), top: B:2:0x0005, inners: #0 }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.content.Intent m13257b(android.content.Context r9, com.vivo.push.model.InsideNotificationItem r10, com.vivo.push.model.NotifyArriveCallbackByUser r11) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.C3998i.m13257b(android.content.Context, com.vivo.push.model.InsideNotificationItem, com.vivo.push.model.NotifyArriveCallbackByUser):android.content.Intent");
    }

    @Override // com.vivo.push.util.AbstractC3991b
    /* renamed from: a */
    protected final int mo13229a() {
        return this.f14251e;
    }

    @Override // com.vivo.push.util.AbstractC3991b
    /* renamed from: a */
    protected final Intent mo13231a(Context context, InsideNotificationItem insideNotificationItem, NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        return m13257b(context, insideNotificationItem, notifyArriveCallbackByUser);
    }

    @Override // com.vivo.push.util.AbstractC3991b
    /* renamed from: a */
    protected final PendingIntent mo13230a(Context context, Intent intent) {
        return PendingIntent.getActivity(context, (int) SystemClock.uptimeMillis(), intent, 201326592);
    }

    /* renamed from: a */
    private Intent m13254a(String str, String str2, InsideNotificationItem insideNotificationItem, Context context) {
        try {
            Intent parseUri = Intent.parseUri(str, 1);
            parseUri.setSelector(null);
            parseUri.setPackage(str2);
            parseUri.setFlags(335544320);
            m13253a(parseUri, insideNotificationItem.getParams());
            int m13252a = m13252a(parseUri, str2);
            if (m13252a <= 0) {
                return parseUri;
            }
            this.f14251e = m13252a;
            C4010u.m13308c(context, " 落地页未找到，通知不展示：  " + this.f14251e);
            return null;
        } catch (Exception e2) {
            C4010u.m13293a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient open activity error : ".concat(String.valueOf(str)), e2);
            this.f14251e = 2158;
            return null;
        }
    }

    /* renamed from: a */
    private static Intent m13255a(Map<String, String> map, String str, Context context) {
        Intent intent = new Intent();
        intent.setPackage(str);
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(50);
            if (runningTasks != null) {
                Iterator<ActivityManager.RunningTaskInfo> it = runningTasks.iterator();
                while (it.hasNext()) {
                    ComponentName componentName = it.next().topActivity;
                    if (componentName.getPackageName().equals(str)) {
                        C4010u.m13309d("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient topClassName=" + componentName.getClassName());
                        intent.setComponent(componentName);
                        intent.setFlags(335544320);
                        m13253a(intent, map);
                        return intent;
                    }
                }
            }
        } catch (Exception e2) {
            C4010u.m13293a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient ActivityManager", e2);
        }
        try {
            intent = context.getPackageManager().getLaunchIntentForPackage(str);
            if (intent != null) {
                intent.setFlags(335544320);
                m13253a(intent, map);
            } else {
                C4010u.m13292a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient LaunchIntent is null");
            }
        } catch (Exception e3) {
            C4010u.m13292a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient LaunchIntent Exception" + e3.getMessage());
        }
        return intent;
    }

    /* renamed from: a */
    private static Intent m13253a(Intent intent, Map<String, String> map) {
        if (map != null && map.entrySet() != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && entry.getKey() != null) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
        }
        return intent;
    }

    /* renamed from: a */
    private int m13252a(Intent intent, String str) {
        int m13251a = m13251a(intent);
        C4010u.m13309d("AndroidTwelveNotifyClickIntentParam", "checkSkipContentParameterLegal canfindactivity code : ".concat(String.valueOf(m13251a)));
        if (m13251a != 0) {
            return m13251a;
        }
        int m13256b = m13256b(intent, str);
        C4010u.m13309d("AndroidTwelveNotifyClickIntentParam", "checkSkipContentParameterLegal packagefit code : ".concat(String.valueOf(m13256b)));
        if (m13256b != 0) {
            return m13256b;
        }
        return 0;
    }

    /* renamed from: a */
    private int m13251a(Intent intent) {
        if (intent.resolveActivityInfo(this.f14237c.getPackageManager(), 65536) != null) {
            return 0;
        }
        C4010u.m13292a("AndroidTwelveNotifyClickIntentParam", "activity is null  ");
        C4010u.m13308c(this.f14237c, " 跳转参数对应的Activity找不到 通知不展示   2162");
        return 2162;
    }

    /* renamed from: b */
    private static Intent m13258b(Intent intent, Map<String, String> map) {
        if (map != null && map.entrySet() != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && entry.getKey() != null && !intent.hasExtra(entry.getKey())) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
        }
        return intent;
    }

    /* renamed from: b */
    private int m13256b(Intent intent, String str) {
        if (intent != null && !TextUtils.isEmpty(str)) {
            try {
                String packageName = intent.getComponent() != null ? intent.getComponent().getPackageName() : intent.getPackage();
                if (TextUtils.isEmpty(packageName) || TextUtils.equals(str, packageName)) {
                    return 0;
                }
                C4010u.m13309d("AndroidTwelveNotifyClickIntentParam", "activity component error : local pkgName is " + str + "; but remote pkgName is " + packageName);
                C4010u.m13297a(this.f14237c, " 跳转参数对应的包名不是当前应用包名    local pkgName is " + str + "; but remote pkgName is " + packageName + " code =2813");
                return 2813;
            } catch (Exception e2) {
                C4010u.m13292a("AndroidTwelveNotifyClickIntentParam", "checkSkipContentPackage open activity error :  error " + e2.getMessage());
                return 2158;
            }
        }
        StringBuilder sb = new StringBuilder("checkSkipContentPackageFit intent = : ");
        Object obj = intent;
        if (intent == null) {
            obj = "";
        }
        sb.append(obj);
        sb.append(" mPkgName = ");
        sb.append(str);
        C4010u.m13292a("AndroidTwelveNotifyClickIntentParam", sb.toString());
        return 2158;
    }
}
