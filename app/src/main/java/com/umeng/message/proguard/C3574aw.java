package com.umeng.message.proguard;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.umeng.message.common.UPLog;
import com.vivo.push.PushClientConstants;

/* renamed from: com.umeng.message.proguard.aw */
/* loaded from: classes2.dex */
public final class C3574aw {

    /* renamed from: a */
    private static Boolean f13242a;

    /* renamed from: b */
    private static int f13243b;

    /* renamed from: c */
    private static final Handler f13244c = new Handler(Looper.getMainLooper()) { // from class: com.umeng.message.proguard.aw.4
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i2 = message.what;
            if (1 == i2) {
                C3574aw.m12308a(message.arg1);
                removeMessages(2);
                Message obtainMessage = obtainMessage(2);
                obtainMessage.obj = message.obj;
                message.obj = null;
                sendMessageDelayed(obtainMessage, 500L);
                return;
            }
            if (2 == i2) {
                final int i3 = C3574aw.f13243b;
                C3574aw.m12315c();
                final Context context = (Context) message.obj;
                message.obj = null;
                if (context == null) {
                    return;
                }
                C3578b.m12327c(new Runnable() { // from class: com.umeng.message.proguard.aw.4.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        String str;
                        if (C3574aw.f13242a == null || C3574aw.f13242a.booleanValue()) {
                            try {
                                ComponentName m12309a = C3574aw.m12309a(context);
                                if (m12309a == null) {
                                    Boolean unused = C3574aw.f13242a = Boolean.FALSE;
                                    return;
                                }
                                Uri parse = Uri.parse("content://com.huawei.android.launcher.settings/badge/");
                                try {
                                    str = context.getContentResolver().getType(parse);
                                } catch (Throwable unused2) {
                                    str = null;
                                }
                                if (TextUtils.isEmpty(str)) {
                                    parse = Uri.parse("content://com.hihonor.android.launcher.settings/badge/");
                                    str = context.getContentResolver().getType(parse);
                                }
                                if (str == null) {
                                    Boolean unused3 = C3574aw.f13242a = Boolean.FALSE;
                                    return;
                                }
                                UPLog.m12145i("Badge", "hw changeBadgeNum:", Integer.valueOf(i3));
                                Bundle bundle = new Bundle();
                                bundle.putString("package", m12309a.getPackageName());
                                bundle.putString("class", m12309a.getClassName());
                                Bundle call = context.getContentResolver().call(parse, "getbadgeNumber", (String) null, bundle);
                                int i4 = call != null ? call.getInt("badgenumber", 0) : 0;
                                int max = Math.max(0, i3 + i4);
                                if (i4 != max) {
                                    bundle.putInt("badgenumber", max);
                                    context.getContentResolver().call(parse, "change_badge", (String) null, bundle);
                                }
                                UPLog.m12142d("Badge", "hw changeBadgeNum cur:", Integer.valueOf(max), "last:", Integer.valueOf(i4));
                                Boolean unused4 = C3574aw.f13242a = Boolean.TRUE;
                            } catch (Throwable unused5) {
                                Boolean unused6 = C3574aw.f13242a = Boolean.FALSE;
                            }
                        }
                    }
                });
            }
        }
    };

    /* renamed from: a */
    static /* synthetic */ int m12308a(int i2) {
        int i3 = f13243b + i2;
        f13243b = i3;
        return i3;
    }

    /* renamed from: c */
    static /* synthetic */ int m12315c() {
        f13243b = 0;
        return 0;
    }

    /* renamed from: b */
    public static void m12314b(Context context, int i2) {
        Boolean bool = f13242a;
        if (bool == null || bool.booleanValue()) {
            String str = Build.MANUFACTURER;
            if ("huawei".equalsIgnoreCase(str) || "honor".equalsIgnoreCase(str)) {
                Message obtainMessage = f13244c.obtainMessage(1);
                obtainMessage.arg1 = i2;
                obtainMessage.obj = context;
                f13244c.sendMessage(obtainMessage);
            }
        }
    }

    /* renamed from: a */
    public static void m12312a(final Context context, final int i2) {
        Boolean bool = f13242a;
        if (bool == null || bool.booleanValue()) {
            String str = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if ("oppo".equalsIgnoreCase(str)) {
                C3578b.m12325b(new Runnable() { // from class: com.umeng.message.proguard.aw.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (C3574aw.f13242a == null || C3574aw.f13242a.booleanValue()) {
                            try {
                                Bundle bundle = new Bundle();
                                bundle.putInt("app_badge_count", i2);
                                context.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", (String) null, bundle);
                                UPLog.m12142d("Badge", "oppo setBadgeNum:", Integer.valueOf(i2));
                                Boolean unused = C3574aw.f13242a = Boolean.TRUE;
                            } catch (Throwable unused2) {
                                Boolean unused3 = C3574aw.f13242a = Boolean.FALSE;
                            }
                        }
                    }
                });
                return;
            }
            if ("vivo".equalsIgnoreCase(str)) {
                C3578b.m12325b(new Runnable() { // from class: com.umeng.message.proguard.aw.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (C3574aw.f13242a == null || C3574aw.f13242a.booleanValue()) {
                            try {
                                ComponentName m12309a = C3574aw.m12309a(context);
                                if (m12309a == null) {
                                    Boolean unused = C3574aw.f13242a = Boolean.FALSE;
                                    return;
                                }
                                Intent intent = new Intent();
                                intent.setAction("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
                                intent.putExtra(Constants.KEY_PACKAGE_NAME, m12309a.getPackageName());
                                intent.putExtra(PushClientConstants.TAG_CLASS_NAME, m12309a.getClassName());
                                intent.putExtra("notificationNum", i2);
                                if (Build.VERSION.SDK_INT >= 26) {
                                    intent.addFlags(16777216);
                                }
                                context.sendBroadcast(intent);
                                UPLog.m12142d("Badge", "vivo setBadgeNum:", Integer.valueOf(i2));
                                Boolean unused2 = C3574aw.f13242a = Boolean.TRUE;
                            } catch (Throwable unused3) {
                                Boolean unused4 = C3574aw.f13242a = Boolean.FALSE;
                            }
                        }
                    }
                });
            } else if ("huawei".equalsIgnoreCase(str) || "honor".equalsIgnoreCase(str)) {
                C3578b.m12325b(new Runnable() { // from class: com.umeng.message.proguard.aw.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        String str2;
                        if (C3574aw.f13242a == null || C3574aw.f13242a.booleanValue()) {
                            try {
                                Uri parse = Uri.parse("content://com.huawei.android.launcher.settings/badge/");
                                try {
                                    str2 = context.getContentResolver().getType(parse);
                                } catch (Throwable unused) {
                                    str2 = null;
                                }
                                if (TextUtils.isEmpty(str2)) {
                                    parse = Uri.parse("content://com.hihonor.android.launcher.settings/badge/");
                                    str2 = context.getContentResolver().getType(parse);
                                }
                                if (str2 == null) {
                                    Boolean unused2 = C3574aw.f13242a = Boolean.FALSE;
                                    return;
                                }
                                ComponentName m12309a = C3574aw.m12309a(context);
                                if (m12309a == null) {
                                    Boolean unused3 = C3574aw.f13242a = Boolean.FALSE;
                                    return;
                                }
                                Bundle bundle = new Bundle();
                                bundle.putString("package", m12309a.getPackageName());
                                bundle.putString("class", m12309a.getClassName());
                                bundle.putInt("badgenumber", i2);
                                context.getContentResolver().call(parse, "change_badge", (String) null, bundle);
                                UPLog.m12142d("Badge", "hw setBadgeNum:", Integer.valueOf(i2));
                                Boolean unused4 = C3574aw.f13242a = Boolean.TRUE;
                            } catch (Throwable unused5) {
                                Boolean unused6 = C3574aw.f13242a = Boolean.FALSE;
                            }
                        }
                    }
                });
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ ComponentName m12309a(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage != null) {
            return launchIntentForPackage.getComponent();
        }
        return null;
    }
}
