package com.xiaomi.push.service;

import android.content.SharedPreferences;
import android.util.Base64;
import com.xiaomi.push.Cdo;
import com.xiaomi.push.af;
import com.xiaomi.push.ci;
import com.xiaomi.push.dp;
import com.xiaomi.push.fy;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ax {
    private static ax a = new ax();

    /* JADX INFO: renamed from: a */
    private static String f1015a;

    /* JADX INFO: renamed from: a */
    private af.b f1016a;

    /* JADX INFO: renamed from: a */
    private Cdo.a f1017a;

    /* JADX INFO: renamed from: a */
    private List<a> f1018a = new ArrayList();

    /* JADX INFO: renamed from: com.xiaomi.push.service.ax$1 */
    class AnonymousClass1 extends af.b {

        /* JADX INFO: renamed from: a */
        boolean f1019a = false;

        AnonymousClass1() {
        }

        @Override // com.xiaomi.push.af.b
        public void b() {
            try {
                Cdo.a aVarA = Cdo.a.a(Base64.decode(ci.a(com.xiaomi.push.r.m634a(), "https://resolver.msg.xiaomi.net/psc/?t=a", (List<com.xiaomi.push.at>) null), 10));
                if (aVarA != null) {
                    ax.this.f1017a = aVarA;
                    this.f1019a = true;
                    ax.this.e();
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m48a("fetch config failure: " + e2.getMessage());
            }
        }

        @Override // com.xiaomi.push.af.b
        /* JADX INFO: renamed from: c */
        public void mo263c() {
            a[] aVarArr;
            ax.this.f1016a = null;
            if (this.f1019a) {
                synchronized (ax.this) {
                    aVarArr = (a[]) ax.this.f1018a.toArray(new a[ax.this.f1018a.size()]);
                }
                for (a aVar : aVarArr) {
                    aVar.a(ax.this.f1017a);
                }
            }
        }
    }

    public static abstract class a {
        public void a(Cdo.a aVar) {
        }

        public void a(dp.b bVar) {
        }
    }

    private ax() {
    }

    private void b() throws Throwable {
        if (this.f1017a == null) {
            d();
        }
    }

    private void c() {
        if (this.f1016a != null) {
            return;
        }
        this.f1016a = new af.b() { // from class: com.xiaomi.push.service.ax.1

            /* JADX INFO: renamed from: a */
            boolean f1019a = false;

            AnonymousClass1() {
            }

            @Override // com.xiaomi.push.af.b
            public void b() {
                try {
                    Cdo.a aVarA = Cdo.a.a(Base64.decode(ci.a(com.xiaomi.push.r.m634a(), "https://resolver.msg.xiaomi.net/psc/?t=a", (List<com.xiaomi.push.at>) null), 10));
                    if (aVarA != null) {
                        ax.this.f1017a = aVarA;
                        this.f1019a = true;
                        ax.this.e();
                    }
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m48a("fetch config failure: " + e2.getMessage());
                }
            }

            @Override // com.xiaomi.push.af.b
            /* JADX INFO: renamed from: c */
            public void mo263c() {
                a[] aVarArr;
                ax.this.f1016a = null;
                if (this.f1019a) {
                    synchronized (ax.this) {
                        aVarArr = (a[]) ax.this.f1018a.toArray(new a[ax.this.f1018a.size()]);
                    }
                    for (a aVar : aVarArr) {
                        aVar.a(ax.this.f1017a);
                    }
                }
            }
        };
        fy.a(this.f1016a);
    }

    private void d() throws Throwable {
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(com.xiaomi.push.r.m634a().openFileInput("XMCloudCfg"));
                try {
                    this.f1017a = Cdo.a.b(com.xiaomi.push.b.a(bufferedInputStream2));
                    bufferedInputStream2.close();
                    com.xiaomi.push.w.a((Closeable) bufferedInputStream2);
                } catch (Exception e2) {
                    e = e2;
                    bufferedInputStream = bufferedInputStream2;
                    com.xiaomi.channel.commonutils.logger.b.m48a("load config failure: " + e.getMessage());
                    com.xiaomi.push.w.a((Closeable) bufferedInputStream);
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    com.xiaomi.push.w.a((Closeable) bufferedInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
        if (this.f1017a == null) {
            this.f1017a = new Cdo.a();
        }
    }

    public void e() {
        try {
            if (this.f1017a != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(com.xiaomi.push.r.m634a().openFileOutput("XMCloudCfg", 0));
                com.xiaomi.push.c cVarA = com.xiaomi.push.c.a(bufferedOutputStream);
                this.f1017a.a(cVarA);
                cVarA.m194a();
                bufferedOutputStream.close();
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m48a("save config failure: " + e2.getMessage());
        }
    }

    public static ax a() {
        return a;
    }

    public synchronized void a(a aVar) {
        this.f1018a.add(aVar);
    }

    /* JADX INFO: renamed from: a */
    synchronized void m708a() {
        this.f1018a.clear();
    }

    /* JADX INFO: renamed from: a */
    int m706a() throws Throwable {
        b();
        Cdo.a aVar = this.f1017a;
        if (aVar != null) {
            return aVar.c();
        }
        return 0;
    }

    /* JADX INFO: renamed from: a */
    public Cdo.a m707a() throws Throwable {
        b();
        return this.f1017a;
    }

    void a(dp.b bVar) {
        a[] aVarArr;
        if (bVar.m298d() && bVar.d() > m706a()) {
            c();
        }
        synchronized (this) {
            aVarArr = (a[]) this.f1018a.toArray(new a[this.f1018a.size()]);
        }
        for (a aVar : aVarArr) {
            aVar.a(bVar);
        }
    }

    /* JADX INFO: renamed from: a */
    public static synchronized String m703a() {
        if (f1015a == null) {
            SharedPreferences sharedPreferences = com.xiaomi.push.r.m634a().getSharedPreferences("XMPushServiceConfig", 0);
            f1015a = sharedPreferences.getString("DeviceUUID", null);
            if (f1015a == null) {
                f1015a = com.xiaomi.push.i.a(com.xiaomi.push.r.m634a(), false);
                if (f1015a != null) {
                    sharedPreferences.edit().putString("DeviceUUID", f1015a).commit();
                }
            }
        }
        return f1015a;
    }
}
