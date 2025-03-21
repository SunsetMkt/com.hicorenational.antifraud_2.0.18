package com.bumptech.glide.load.p.b0;

import android.util.Log;
import com.bumptech.glide.load.p.b0.a;
import com.bumptech.glide.n.a;
import java.io.File;
import java.io.IOException;

/* compiled from: DiskLruCacheWrapper.java */
/* loaded from: classes.dex */
public class e implements a {

    /* renamed from: f, reason: collision with root package name */
    private static final String f4406f = "DiskLruCacheWrapper";

    /* renamed from: g, reason: collision with root package name */
    private static final int f4407g = 1;

    /* renamed from: h, reason: collision with root package name */
    private static final int f4408h = 1;

    /* renamed from: i, reason: collision with root package name */
    private static e f4409i;

    /* renamed from: b, reason: collision with root package name */
    private final File f4411b;

    /* renamed from: c, reason: collision with root package name */
    private final long f4412c;

    /* renamed from: e, reason: collision with root package name */
    private com.bumptech.glide.n.a f4414e;

    /* renamed from: d, reason: collision with root package name */
    private final c f4413d = new c();

    /* renamed from: a, reason: collision with root package name */
    private final m f4410a = new m();

    @Deprecated
    protected e(File file, long j2) {
        this.f4411b = file;
        this.f4412c = j2;
    }

    public static a a(File file, long j2) {
        return new e(file, j2);
    }

    @Deprecated
    public static synchronized a b(File file, long j2) {
        e eVar;
        synchronized (e.class) {
            if (f4409i == null) {
                f4409i = new e(file, j2);
            }
            eVar = f4409i;
        }
        return eVar;
    }

    @Override // com.bumptech.glide.load.p.b0.a
    public synchronized void clear() {
        try {
            try {
                a().c();
            } catch (IOException unused) {
                Log.isLoggable(f4406f, 5);
            }
        } finally {
            b();
        }
    }

    private synchronized com.bumptech.glide.n.a a() throws IOException {
        if (this.f4414e == null) {
            this.f4414e = com.bumptech.glide.n.a.a(this.f4411b, 1, 1, this.f4412c);
        }
        return this.f4414e;
    }

    @Override // com.bumptech.glide.load.p.b0.a
    public void b(com.bumptech.glide.load.g gVar) {
        try {
            a().c(this.f4410a.a(gVar));
        } catch (IOException unused) {
            Log.isLoggable(f4406f, 5);
        }
    }

    @Override // com.bumptech.glide.load.p.b0.a
    public File a(com.bumptech.glide.load.g gVar) {
        String a2 = this.f4410a.a(gVar);
        if (Log.isLoggable(f4406f, 2)) {
            String str = "Get: Obtained: " + a2 + " for for Key: " + gVar;
        }
        try {
            a.e b2 = a().b(a2);
            if (b2 != null) {
                return b2.a(0);
            }
            return null;
        } catch (IOException unused) {
            Log.isLoggable(f4406f, 5);
            return null;
        }
    }

    private synchronized void b() {
        this.f4414e = null;
    }

    @Override // com.bumptech.glide.load.p.b0.a
    public void a(com.bumptech.glide.load.g gVar, a.b bVar) {
        com.bumptech.glide.n.a a2;
        String a3 = this.f4410a.a(gVar);
        this.f4413d.a(a3);
        try {
            if (Log.isLoggable(f4406f, 2)) {
                String str = "Put: Obtained: " + a3 + " for for Key: " + gVar;
            }
            try {
                a2 = a();
            } catch (IOException unused) {
                Log.isLoggable(f4406f, 5);
            }
            if (a2.b(a3) != null) {
                return;
            }
            a.c a4 = a2.a(a3);
            if (a4 != null) {
                try {
                    if (bVar.a(a4.a(0))) {
                        a4.c();
                    }
                    a4.b();
                    return;
                } catch (Throwable th) {
                    a4.b();
                    throw th;
                }
            }
            throw new IllegalStateException("Had two simultaneous puts for: " + a3);
        } finally {
            this.f4413d.b(a3);
        }
    }
}
