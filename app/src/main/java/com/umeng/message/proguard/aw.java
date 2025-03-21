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

/* loaded from: classes2.dex */
public final class aw {

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f11314a;

    /* renamed from: b, reason: collision with root package name */
    private static int f11315b;

    /* renamed from: c, reason: collision with root package name */
    private static final Handler f11316c = new Handler(Looper.getMainLooper()) { // from class: com.umeng.message.proguard.aw.4
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i2 = message.what;
            if (1 == i2) {
                aw.a(message.arg1);
                removeMessages(2);
                Message obtainMessage = obtainMessage(2);
                obtainMessage.obj = message.obj;
                message.obj = null;
                sendMessageDelayed(obtainMessage, 500L);
                return;
            }
            if (2 == i2) {
                final int i3 = aw.f11315b;
                aw.c();
                final Context context = (Context) message.obj;
                message.obj = null;
                if (context == null) {
                    return;
                }
                b.c(new Runnable() { // from class: com.umeng.message.proguard.aw.4.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        String str;
                        if (aw.f11314a == null || aw.f11314a.booleanValue()) {
                            try {
                                ComponentName a2 = aw.a(context);
                                if (a2 == null) {
                                    Boolean unused = aw.f11314a = Boolean.FALSE;
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
                                    Boolean unused3 = aw.f11314a = Boolean.FALSE;
                                    return;
                                }
                                UPLog.i("Badge", "hw changeBadgeNum:", Integer.valueOf(i3));
                                Bundle bundle = new Bundle();
                                bundle.putString("package", a2.getPackageName());
                                bundle.putString("class", a2.getClassName());
                                Bundle call = context.getContentResolver().call(parse, "getbadgeNumber", (String) null, bundle);
                                int i4 = call != null ? call.getInt("badgenumber", 0) : 0;
                                int max = Math.max(0, i3 + i4);
                                if (i4 != max) {
                                    bundle.putInt("badgenumber", max);
                                    context.getContentResolver().call(parse, "change_badge", (String) null, bundle);
                                }
                                UPLog.d("Badge", "hw changeBadgeNum cur:", Integer.valueOf(max), "last:", Integer.valueOf(i4));
                                Boolean unused4 = aw.f11314a = Boolean.TRUE;
                            } catch (Throwable unused5) {
                                Boolean unused6 = aw.f11314a = Boolean.FALSE;
                            }
                        }
                    }
                });
            }
        }
    };

    static /* synthetic */ int a(int i2) {
        int i3 = f11315b + i2;
        f11315b = i3;
        return i3;
    }

    static /* synthetic */ int c() {
        f11315b = 0;
        return 0;
    }

    public static void b(Context context, int i2) {
        Boolean bool = f11314a;
        if (bool == null || bool.booleanValue()) {
            String str = Build.MANUFACTURER;
            if ("huawei".equalsIgnoreCase(str) || "honor".equalsIgnoreCase(str)) {
                Message obtainMessage = f11316c.obtainMessage(1);
                obtainMessage.arg1 = i2;
                obtainMessage.obj = context;
                f11316c.sendMessage(obtainMessage);
            }
        }
    }

    public static void a(final Context context, final int i2) {
        Boolean bool = f11314a;
        if (bool == null || bool.booleanValue()) {
            String str = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if ("oppo".equalsIgnoreCase(str)) {
                b.b(new Runnable() { // from class: com.umeng.message.proguard.aw.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (aw.f11314a == null || aw.f11314a.booleanValue()) {
                            try {
                                Bundle bundle = new Bundle();
                                bundle.putInt("app_badge_count", i2);
                                context.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", (String) null, bundle);
                                UPLog.d("Badge", "oppo setBadgeNum:", Integer.valueOf(i2));
                                Boolean unused = aw.f11314a = Boolean.TRUE;
                            } catch (Throwable unused2) {
                                Boolean unused3 = aw.f11314a = Boolean.FALSE;
                            }
                        }
                    }
                });
                return;
            }
            if ("vivo".equalsIgnoreCase(str)) {
                b.b(new Runnable() { // from class: com.umeng.message.proguard.aw.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (aw.f11314a == null || aw.f11314a.booleanValue()) {
                            try {
                                ComponentName a2 = aw.a(context);
                                if (a2 == null) {
                                    Boolean unused = aw.f11314a = Boolean.FALSE;
                                    return;
                                }
                                Intent intent = new Intent();
                                intent.setAction("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
                                intent.putExtra(Constants.KEY_PACKAGE_NAME, a2.getPackageName());
                                intent.putExtra(PushClientConstants.TAG_CLASS_NAME, a2.getClassName());
                                intent.putExtra("notificationNum", i2);
                                if (Build.VERSION.SDK_INT >= 26) {
                                    intent.addFlags(16777216);
                                }
                                context.sendBroadcast(intent);
                                UPLog.d("Badge", "vivo setBadgeNum:", Integer.valueOf(i2));
                                Boolean unused2 = aw.f11314a = Boolean.TRUE;
                            } catch (Throwable unused3) {
                                Boolean unused4 = aw.f11314a = Boolean.FALSE;
                            }
                        }
                    }
                });
            } else if ("huawei".equalsIgnoreCase(str) || "honor".equalsIgnoreCase(str)) {
                b.b(new Runnable() { // from class: com.umeng.message.proguard.aw.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        String str2;
                        if (aw.f11314a == null || aw.f11314a.booleanValue()) {
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
                                    Boolean unused2 = aw.f11314a = Boolean.FALSE;
                                    return;
                                }
                                ComponentName a2 = aw.a(context);
                                if (a2 == null) {
                                    Boolean unused3 = aw.f11314a = Boolean.FALSE;
                                    return;
                                }
                                Bundle bundle = new Bundle();
                                bundle.putString("package", a2.getPackageName());
                                bundle.putString("class", a2.getClassName());
                                bundle.putInt("badgenumber", i2);
                                context.getContentResolver().call(parse, "change_badge", (String) null, bundle);
                                UPLog.d("Badge", "hw setBadgeNum:", Integer.valueOf(i2));
                                Boolean unused4 = aw.f11314a = Boolean.TRUE;
                            } catch (Throwable unused5) {
                                Boolean unused6 = aw.f11314a = Boolean.FALSE;
                            }
                        }
                    }
                });
            }
        }
    }

    static /* synthetic */ ComponentName a(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage != null) {
            return launchIntentForPackage.getComponent();
        }
        return null;
    }
}
