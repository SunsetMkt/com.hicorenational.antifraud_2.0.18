package com.bumptech.glide.load.p.b0;

import android.util.Log;
import com.bumptech.glide.load.p.b0.a;
import com.bumptech.glide.n.a;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: DiskLruCacheWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements a {

    /* JADX INFO: renamed from: f */
    private static final String f2828f = "DiskLruCacheWrapper";

    /* JADX INFO: renamed from: g */
    private static final int f2829g = 1;

    /* JADX INFO: renamed from: h */
    private static final int f2830h = 1;

    /* JADX INFO: renamed from: i */
    private static e f2831i;

    /* JADX INFO: renamed from: b */
    private final File f2832b;

    /* JADX INFO: renamed from: c */
    private final long f2833c;

    /* JADX INFO: renamed from: e */
    private com.bumptech.glide.n.a f2835e;

    /* JADX INFO: renamed from: d */
    private final c f2834d = new c();
    private final m a = new m();

    @Deprecated
    protected e(File file, long j2) {
        this.f2832b = file;
        this.f2833c = j2;
    }

    public static a a(File file, long j2) {
        return new e(file, j2);
    }

    @Deprecated
    public static synchronized a b(File file, long j2) {
        if (f2831i == null) {
            f2831i = new e(file, j2);
        }
        return f2831i;
    }

    @Override // com.bumptech.glide.load.p.b0.a
    public synchronized void clear() {
        try {
            try {
                a().c();
            } catch (IOException unused) {
                Log.isLoggable(f2828f, 5);
            }
        } finally {
            b();
        }
    }

    private synchronized com.bumptech.glide.n.a a() throws IOException {
        if (this.f2835e == null) {
            this.f2835e = com.bumptech.glide.n.a.a(this.f2832b, 1, 1, this.f2833c);
        }
        return this.f2835e;
    }

    @Override // com.bumptech.glide.load.p.b0.a
    public void b(com.bumptech.glide.load.g gVar) {
        try {
            a().c(this.a.a(gVar));
        } catch (IOException unused) {
            Log.isLoggable(f2828f, 5);
        }
    }

    @Override // com.bumptech.glide.load.p.b0.a
    public File a(com.bumptech.glide.load.g gVar) {
        String strA = this.a.a(gVar);
        if (Log.isLoggable(f2828f, 2)) {
            String str = "Get: Obtained: " + strA + " for for Key: " + gVar;
        }
        try {
            a.e eVarB = a().b(strA);
            if (eVarB != null) {
                return eVarB.a(0);
            }
            return null;
        } catch (IOException unused) {
            Log.isLoggable(f2828f, 5);
            return null;
        }
    }

    private synchronized void b() {
        this.f2835e = null;
    }

    @Override // com.bumptech.glide.load.p.b0.a
    public void a(com.bumptech.glide.load.g gVar, a.b bVar) {
        com.bumptech.glide.n.a aVarA;
        String strA = this.a.a(gVar);
        this.f2834d.a(strA);
        try {
            if (Log.isLoggable(f2828f, 2)) {
                String str = "Put: Obtained: " + strA + " for for Key: " + gVar;
            }
            try {
                aVarA = a();
            } catch (IOException unused) {
                Log.isLoggable(f2828f, 5);
            }
            if (aVarA.b(strA) != null) {
                return;
            }
            a.c cVarA = aVarA.a(strA);
            if (cVarA != null) {
                try {
                    if (bVar.a(cVarA.a(0))) {
                        cVarA.c();
                    }
                    cVarA.b();
                    return;
                } catch (Throwable th) {
                    cVarA.b();
                    throw th;
                }
            }
            throw new IllegalStateException("Had two simultaneous puts for: " + strA);
        } finally {
            this.f2834d.b(strA);
        }
    }
}
