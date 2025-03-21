package com.xiaomi.push.service;

import android.content.SharedPreferences;
import android.util.Base64;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.AbstractC4134ci;
import com.xiaomi.push.C4077af;
import com.xiaomi.push.C4125c;
import com.xiaomi.push.C4167do;
import com.xiaomi.push.C4168dp;
import com.xiaomi.push.C4231fy;
import com.xiaomi.push.C4287i;
import com.xiaomi.push.C4309r;
import com.xiaomi.push.InterfaceC4091at;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.xiaomi.push.service.ax */
/* loaded from: classes2.dex */
public class C4372ax {

    /* renamed from: a */
    private static C4372ax f16653a = new C4372ax();

    /* renamed from: a */
    private static String f16654a;

    /* renamed from: a */
    private C4077af.b f16655a;

    /* renamed from: a */
    private C4167do.a f16656a;

    /* renamed from: a */
    private List<a> f16657a = new ArrayList();

    /* renamed from: com.xiaomi.push.service.ax$a */
    public static abstract class a {
        /* renamed from: a */
        public void mo15984a(C4167do.a aVar) {
        }

        /* renamed from: a */
        public void mo14666a(C4168dp.b bVar) {
        }
    }

    private C4372ax() {
    }

    /* renamed from: b */
    private void m16021b() {
        if (this.f16656a == null) {
            m16023d();
        }
    }

    /* renamed from: c */
    private void m16022c() {
        if (this.f16655a != null) {
            return;
        }
        this.f16655a = new C4077af.b() { // from class: com.xiaomi.push.service.ax.1

            /* renamed from: a */
            boolean f16659a = false;

            @Override // com.xiaomi.push.C4077af.b
            /* renamed from: b */
            public void mo13724b() {
                try {
                    C4167do.a m14312a = C4167do.a.m14312a(Base64.decode(AbstractC4134ci.m14107a(C4309r.m15715a(), "https://resolver.msg.xiaomi.net/psc/?t=a", (List<InterfaceC4091at>) null), 10));
                    if (m14312a != null) {
                        C4372ax.this.f16656a = m14312a;
                        this.f16659a = true;
                        C4372ax.this.m16024e();
                    }
                } catch (Exception e2) {
                    AbstractC4022b.m13347a("fetch config failure: " + e2.getMessage());
                }
            }

            @Override // com.xiaomi.push.C4077af.b
            /* renamed from: c */
            public void mo13725c() {
                a[] aVarArr;
                C4372ax.this.f16655a = null;
                if (this.f16659a) {
                    synchronized (C4372ax.this) {
                        aVarArr = (a[]) C4372ax.this.f16657a.toArray(new a[C4372ax.this.f16657a.size()]);
                    }
                    for (a aVar : aVarArr) {
                        aVar.mo15984a(C4372ax.this.f16656a);
                    }
                }
            }
        };
        C4231fy.m14905a(this.f16655a);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m16023d() {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = com.xiaomi.push.C4309r.m15715a()     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            java.lang.String r2 = "XMCloudCfg"
            java.io.FileInputStream r1 = r1.openFileInput(r2)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            com.xiaomi.push.b r0 = com.xiaomi.push.C4098b.m13848a(r2)     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L25
            com.xiaomi.push.do$a r0 = com.xiaomi.push.C4167do.a.m14313b(r0)     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L25
            r4.f16656a = r0     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L25
            r2.close()     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L25
            com.xiaomi.push.C4408w.m16356a(r2)
            goto L47
        L21:
            r0 = move-exception
            r1 = r0
            r0 = r2
            goto L53
        L25:
            r0 = move-exception
            r1 = r0
            r0 = r2
            goto L2c
        L29:
            r1 = move-exception
            goto L53
        L2b:
            r1 = move-exception
        L2c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L29
            r2.<init>()     // Catch: java.lang.Throwable -> L29
            java.lang.String r3 = "load config failure: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L29
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L29
            r2.append(r1)     // Catch: java.lang.Throwable -> L29
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L29
            com.xiaomi.channel.commonutils.logger.AbstractC4022b.m13347a(r1)     // Catch: java.lang.Throwable -> L29
            com.xiaomi.push.C4408w.m16356a(r0)
        L47:
            com.xiaomi.push.do$a r0 = r4.f16656a
            if (r0 != 0) goto L52
            com.xiaomi.push.do$a r0 = new com.xiaomi.push.do$a
            r0.<init>()
            r4.f16656a = r0
        L52:
            return
        L53:
            com.xiaomi.push.C4408w.m16356a(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C4372ax.m16023d():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m16024e() {
        try {
            if (this.f16656a != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(C4309r.m15715a().openFileOutput("XMCloudCfg", 0));
                C4125c m13990a = C4125c.m13990a(bufferedOutputStream);
                this.f16656a.mo14320a(m13990a);
                m13990a.m14002a();
                bufferedOutputStream.close();
            }
        } catch (Exception e2) {
            AbstractC4022b.m13347a("save config failure: " + e2.getMessage());
        }
    }

    /* renamed from: a */
    public static C4372ax m16017a() {
        return f16653a;
    }

    /* renamed from: a */
    public synchronized void m16029a(a aVar) {
        this.f16657a.add(aVar);
    }

    /* renamed from: a */
    synchronized void m16027a() {
        this.f16657a.clear();
    }

    /* renamed from: a */
    int m16025a() {
        m16021b();
        C4167do.a aVar = this.f16656a;
        if (aVar != null) {
            return aVar.m14326c();
        }
        return 0;
    }

    /* renamed from: a */
    public C4167do.a m16026a() {
        m16021b();
        return this.f16656a;
    }

    /* renamed from: a */
    void m16028a(C4168dp.b bVar) {
        a[] aVarArr;
        if (bVar.m14383d() && bVar.m14382d() > m16025a()) {
            m16022c();
        }
        synchronized (this) {
            aVarArr = (a[]) this.f16657a.toArray(new a[this.f16657a.size()]);
        }
        for (a aVar : aVarArr) {
            aVar.mo14666a(bVar);
        }
    }

    /* renamed from: a */
    public static synchronized String m16018a() {
        String str;
        synchronized (C4372ax.class) {
            if (f16654a == null) {
                SharedPreferences sharedPreferences = C4309r.m15715a().getSharedPreferences("XMPushServiceConfig", 0);
                f16654a = sharedPreferences.getString("DeviceUUID", null);
                if (f16654a == null) {
                    f16654a = C4287i.m15635a(C4309r.m15715a(), false);
                    if (f16654a != null) {
                        sharedPreferences.edit().putString("DeviceUUID", f16654a).commit();
                    }
                }
            }
            str = f16654a;
        }
        return str;
    }
}
