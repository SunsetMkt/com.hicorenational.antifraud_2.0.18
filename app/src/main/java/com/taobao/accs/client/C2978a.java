package com.taobao.accs.client;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.IProcessName;
import com.taobao.accs.utl.ALog;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.client.a */
/* loaded from: classes.dex */
public class C2978a {

    /* renamed from: a */
    public static String f9400a;

    /* renamed from: b */
    public static String f9401b;

    /* renamed from: c */
    public static String f9402c;

    /* renamed from: d */
    public static String f9403d;

    /* renamed from: e */
    public static IProcessName f9404e;

    /* renamed from: f */
    public static AtomicInteger f9405f = new AtomicInteger(-1);

    /* renamed from: g */
    private static volatile C2978a f9406g;

    /* renamed from: h */
    private static Context f9407h;

    /* renamed from: i */
    private ActivityManager f9408i;

    private C2978a(Context context) {
        if (context == null) {
            throw new RuntimeException("Context is null!!");
        }
        if (f9407h == null) {
            f9407h = context.getApplicationContext();
        }
    }

    /* renamed from: a */
    public static C2978a m8976a(Context context) {
        if (f9406g == null) {
            synchronized (C2978a.class) {
                if (f9406g == null) {
                    f9406g = new C2978a(context);
                }
            }
        }
        return f9406g;
    }

    /* renamed from: b */
    public static String m8977b() {
        String str = TextUtils.isEmpty(f9400a) ? "com.umeng.message.component.UmengIntentService" : f9400a;
        ALog.m9180d("AdapterGlobalClientInfo", "getAgooCustomServiceName", "serviceName", str);
        return str;
    }

    /* renamed from: c */
    public static boolean m8978c() {
        return f9405f.intValue() == 0;
    }

    /* renamed from: a */
    public ActivityManager m8979a() {
        if (this.f9408i == null) {
            this.f9408i = (ActivityManager) f9407h.getSystemService("activity");
        }
        return this.f9408i;
    }
}
