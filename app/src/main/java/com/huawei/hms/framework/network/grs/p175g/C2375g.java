package com.huawei.hms.framework.network.grs.p175g;

import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.InterfaceC2358b;
import com.huawei.hms.framework.network.grs.p173e.C2361a;
import com.huawei.hms.framework.network.grs.p173e.C2363c;
import com.huawei.hms.framework.network.grs.p175g.p177j.C2379b;
import com.huawei.hms.framework.network.grs.p175g.p177j.C2380c;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* renamed from: com.huawei.hms.framework.network.grs.g.g */
/* loaded from: classes.dex */
public class C2375g {

    /* renamed from: b */
    private static final ExecutorService f7414b = ExecutorsUtils.newCachedThreadPool("GRS_RequestController-Task");

    /* renamed from: c */
    private static final Map<String, C2379b> f7415c = new ConcurrentHashMap(16);

    /* renamed from: d */
    private static final Object f7416d = new Object();

    /* renamed from: a */
    private C2361a f7417a;

    /* renamed from: com.huawei.hms.framework.network.grs.g.g$a */
    class a implements Callable<C2372d> {

        /* renamed from: a */
        final /* synthetic */ C2380c f7418a;

        /* renamed from: b */
        final /* synthetic */ String f7419b;

        /* renamed from: c */
        final /* synthetic */ C2363c f7420c;

        a(C2380c c2380c, String str, C2363c c2363c) {
            this.f7418a = c2380c;
            this.f7419b = str;
            this.f7420c = c2363c;
        }

        @Override // java.util.concurrent.Callable
        public C2372d call() {
            return new C2371c(this.f7418a, C2375g.this.f7417a).m6905a(C2375g.f7414b, this.f7419b, this.f7420c);
        }
    }

    /* renamed from: com.huawei.hms.framework.network.grs.g.g$b */
    class b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C2380c f7422a;

        /* renamed from: b */
        final /* synthetic */ String f7423b;

        /* renamed from: c */
        final /* synthetic */ C2363c f7424c;

        /* renamed from: d */
        final /* synthetic */ int f7425d;

        /* renamed from: e */
        final /* synthetic */ InterfaceC2358b f7426e;

        b(C2380c c2380c, String str, C2363c c2363c, int i2, InterfaceC2358b interfaceC2358b) {
            this.f7422a = c2380c;
            this.f7423b = str;
            this.f7424c = c2363c;
            this.f7425d = i2;
            this.f7426e = interfaceC2358b;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2375g c2375g = C2375g.this;
            c2375g.m6948a(c2375g.m6950a(this.f7422a, this.f7423b, this.f7424c, this.f7425d), this.f7426e);
        }
    }

    /* renamed from: a */
    public void m6948a(C2372d c2372d, InterfaceC2358b interfaceC2358b) {
        if (interfaceC2358b != null) {
            if (c2372d == null) {
                Logger.m6801v("RequestController", "GrsResponse is null");
                interfaceC2358b.mo6817a();
            } else {
                Logger.m6801v("RequestController", "GrsResponse is not null");
                interfaceC2358b.mo6818a(c2372d);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0069, code lost:
    
        if (r3.m6983a() != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x006d, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008f  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hms.framework.network.grs.p175g.C2372d m6950a(com.huawei.hms.framework.network.grs.p175g.p177j.C2380c r8, java.lang.String r9, com.huawei.hms.framework.network.grs.p173e.C2363c r10, int r11) {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.p175g.C2375g.m6950a(com.huawei.hms.framework.network.grs.g.j.c, java.lang.String, com.huawei.hms.framework.network.grs.e.c, int):com.huawei.hms.framework.network.grs.g.d");
    }

    /* renamed from: a */
    public void m6951a(C2361a c2361a) {
        this.f7417a = c2361a;
    }

    /* renamed from: a */
    public void m6952a(C2380c c2380c, InterfaceC2358b interfaceC2358b, String str, C2363c c2363c, int i2) {
        f7414b.execute(new b(c2380c, str, c2363c, i2, interfaceC2358b));
    }

    /* renamed from: a */
    public void m6953a(String str) {
        synchronized (f7416d) {
            f7415c.remove(str);
        }
    }
}
