package com.taobao.accs.client;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.IProcessName;
import com.taobao.accs.utl.ALog;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f5729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f5730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f5731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static IProcessName f5732e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static AtomicInteger f5733f = new AtomicInteger(-1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile a f5734g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Context f5735h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ActivityManager f5736i;

    private a(Context context) {
        if (context == null) {
            throw new RuntimeException("Context is null!!");
        }
        if (f5735h == null) {
            f5735h = context.getApplicationContext();
        }
    }

    public static a a(Context context) {
        if (f5734g == null) {
            synchronized (a.class) {
                if (f5734g == null) {
                    f5734g = new a(context);
                }
            }
        }
        return f5734g;
    }

    public static String b() {
        String str = TextUtils.isEmpty(a) ? "com.umeng.message.component.UmengIntentService" : a;
        ALog.d("AdapterGlobalClientInfo", "getAgooCustomServiceName", "serviceName", str);
        return str;
    }

    public static boolean c() {
        return f5733f.intValue() == 0;
    }

    public ActivityManager a() {
        if (this.f5736i == null) {
            this.f5736i = (ActivityManager) f5735h.getSystemService("activity");
        }
        return this.f5736i;
    }
}
