package com.bumptech.glide.load.p118p.p120b0;

import android.util.Log;
import com.bumptech.glide.load.InterfaceC1593g;
import com.bumptech.glide.load.p118p.p120b0.InterfaceC1639a;
import com.bumptech.glide.p133n.C1801a;
import java.io.File;
import java.io.IOException;

/* compiled from: DiskLruCacheWrapper.java */
/* renamed from: com.bumptech.glide.load.p.b0.e */
/* loaded from: classes.dex */
public class C1643e implements InterfaceC1639a {

    /* renamed from: f */
    private static final String f4348f = "DiskLruCacheWrapper";

    /* renamed from: g */
    private static final int f4349g = 1;

    /* renamed from: h */
    private static final int f4350h = 1;

    /* renamed from: i */
    private static C1643e f4351i;

    /* renamed from: b */
    private final File f4353b;

    /* renamed from: c */
    private final long f4354c;

    /* renamed from: e */
    private C1801a f4356e;

    /* renamed from: d */
    private final C1641c f4355d = new C1641c();

    /* renamed from: a */
    private final C1651m f4352a = new C1651m();

    @Deprecated
    protected C1643e(File file, long j2) {
        this.f4353b = file;
        this.f4354c = j2;
    }

    /* renamed from: a */
    public static InterfaceC1639a m3989a(File file, long j2) {
        return new C1643e(file, j2);
    }

    @Deprecated
    /* renamed from: b */
    public static synchronized InterfaceC1639a m3991b(File file, long j2) {
        C1643e c1643e;
        synchronized (C1643e.class) {
            if (f4351i == null) {
                f4351i = new C1643e(file, j2);
            }
            c1643e = f4351i;
        }
        return c1643e;
    }

    @Override // com.bumptech.glide.load.p118p.p120b0.InterfaceC1639a
    public synchronized void clear() {
        try {
            try {
                m3990a().m4595c();
            } catch (IOException unused) {
                Log.isLoggable(f4348f, 5);
            }
        } finally {
            m3992b();
        }
    }

    /* renamed from: a */
    private synchronized C1801a m3990a() throws IOException {
        if (this.f4356e == null) {
            this.f4356e = C1801a.m4570a(this.f4353b, 1, 1, this.f4354c);
        }
        return this.f4356e;
    }

    @Override // com.bumptech.glide.load.p118p.p120b0.InterfaceC1639a
    /* renamed from: b */
    public void mo3982b(InterfaceC1593g interfaceC1593g) {
        try {
            m3990a().m4596c(this.f4352a.m4023a(interfaceC1593g));
        } catch (IOException unused) {
            Log.isLoggable(f4348f, 5);
        }
    }

    @Override // com.bumptech.glide.load.p118p.p120b0.InterfaceC1639a
    /* renamed from: a */
    public File mo3980a(InterfaceC1593g interfaceC1593g) {
        String m4023a = this.f4352a.m4023a(interfaceC1593g);
        if (Log.isLoggable(f4348f, 2)) {
            String str = "Get: Obtained: " + m4023a + " for for Key: " + interfaceC1593g;
        }
        try {
            C1801a.e m4594b = m3990a().m4594b(m4023a);
            if (m4594b != null) {
                return m4594b.m4624a(0);
            }
            return null;
        } catch (IOException unused) {
            Log.isLoggable(f4348f, 5);
            return null;
        }
    }

    /* renamed from: b */
    private synchronized void m3992b() {
        this.f4356e = null;
    }

    @Override // com.bumptech.glide.load.p118p.p120b0.InterfaceC1639a
    /* renamed from: a */
    public void mo3981a(InterfaceC1593g interfaceC1593g, InterfaceC1639a.b bVar) {
        C1801a m3990a;
        String m4023a = this.f4352a.m4023a(interfaceC1593g);
        this.f4355d.m3984a(m4023a);
        try {
            if (Log.isLoggable(f4348f, 2)) {
                String str = "Put: Obtained: " + m4023a + " for for Key: " + interfaceC1593g;
            }
            try {
                m3990a = m3990a();
            } catch (IOException unused) {
                Log.isLoggable(f4348f, 5);
            }
            if (m3990a.m4594b(m4023a) != null) {
                return;
            }
            C1801a.c m4592a = m3990a.m4592a(m4023a);
            if (m4592a != null) {
                try {
                    if (bVar.mo3983a(m4592a.m4603a(0))) {
                        m4592a.m4608c();
                    }
                    m4592a.m4607b();
                    return;
                } catch (Throwable th) {
                    m4592a.m4607b();
                    throw th;
                }
            }
            throw new IllegalStateException("Had two simultaneous puts for: " + m4023a);
        } finally {
            this.f4355d.m3985b(m4023a);
        }
    }
}
