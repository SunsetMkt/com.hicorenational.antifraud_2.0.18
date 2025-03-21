package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.heytap.mcssdk.constant.C2084a;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C4073ab;
import com.xiaomi.push.C4076ae;
import com.xiaomi.push.C4092au;
import com.xiaomi.push.C4306p;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.xiaomi.push.service.ay */
/* loaded from: classes2.dex */
public final class C4373ay implements InterfaceC4349aa {

    /* renamed from: a */
    private static volatile C4373ay f16660a;

    /* renamed from: a */
    private long f16661a;

    /* renamed from: a */
    Context f16662a;

    /* renamed from: a */
    private SharedPreferences f16663a;

    /* renamed from: a */
    private volatile boolean f16665a = false;

    /* renamed from: a */
    private ConcurrentHashMap<String, a> f16664a = new ConcurrentHashMap<>();

    /* renamed from: com.xiaomi.push.service.ay$a */
    public static abstract class a implements Runnable {

        /* renamed from: a */
        long f16667a;

        /* renamed from: a */
        String f16668a;

        a(String str, long j2) {
            this.f16668a = str;
            this.f16667a = j2;
        }

        /* renamed from: a */
        abstract void mo16038a(C4373ay c4373ay);

        @Override // java.lang.Runnable
        public void run() {
            if (C4373ay.f16660a != null) {
                Context context = C4373ay.f16660a.f16662a;
                if (C4092au.m13802c(context)) {
                    if (System.currentTimeMillis() - C4373ay.f16660a.f16663a.getLong(":ts-" + this.f16668a, 0L) > this.f16667a || C4073ab.m13692a(context)) {
                        C4306p.m15711a(C4373ay.f16660a.f16663a.edit().putLong(":ts-" + this.f16668a, System.currentTimeMillis()));
                        mo16038a(C4373ay.f16660a);
                    }
                }
            }
        }
    }

    private C4373ay(Context context) {
        this.f16662a = context.getApplicationContext();
        this.f16663a = context.getSharedPreferences("sync", 0);
    }

    /* renamed from: a */
    public static C4373ay m16032a(Context context) {
        if (f16660a == null) {
            synchronized (C4373ay.class) {
                if (f16660a == null) {
                    f16660a = new C4373ay(context);
                }
            }
        }
        return f16660a;
    }

    @Override // com.xiaomi.push.service.InterfaceC4349aa
    /* renamed from: a */
    public void mo15822a() {
        if (this.f16665a) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f16661a < C2084a.f6123e) {
            return;
        }
        this.f16661a = currentTimeMillis;
        this.f16665a = true;
        C4076ae.m13698a(this.f16662a).m13704a(new Runnable() { // from class: com.xiaomi.push.service.ay.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Iterator it = C4373ay.this.f16664a.values().iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).run();
                    }
                } catch (Exception e2) {
                    AbstractC4022b.m13347a("Sync job exception :" + e2.getMessage());
                }
                C4373ay.this.f16665a = false;
            }
        }, (int) (Math.random() * 10.0d));
    }

    /* renamed from: a */
    public String m16035a(String str, String str2) {
        return this.f16663a.getString(str + Constants.COLON_SEPARATOR + str2, "");
    }

    /* renamed from: a */
    public void m16037a(String str, String str2, String str3) {
        C4306p.m15711a(f16660a.f16663a.edit().putString(str + Constants.COLON_SEPARATOR + str2, str3));
    }

    /* renamed from: a */
    public void m16036a(a aVar) {
        if (this.f16664a.putIfAbsent(aVar.f16668a, aVar) == null) {
            C4076ae.m13698a(this.f16662a).m13704a(aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }
}
