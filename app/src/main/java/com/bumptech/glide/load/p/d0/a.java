package com.bumptech.glide.load.p.d0;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.p.a0.e;
import com.bumptech.glide.load.p.b0.j;
import com.bumptech.glide.util.l;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: BitmapPreFillRunner.java */
/* JADX INFO: loaded from: classes.dex */
final class a implements Runnable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @VisibleForTesting
    static final String f2894i = "PreFillRunner";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final long f2896k = 32;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final long f2897l = 40;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final int f2898m = 4;
    private final e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j f2900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f2901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final C0051a f2902d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set<d> f2903e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Handler f2904f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f2905g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f2906h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final C0051a f2895j = new C0051a();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final long f2899n = TimeUnit.SECONDS.toMillis(1);

    /* JADX INFO: renamed from: com.bumptech.glide.load.p.d0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BitmapPreFillRunner.java */
    @VisibleForTesting
    static class C0051a {
        C0051a() {
        }

        long a() {
            return SystemClock.currentThreadTimeMillis();
        }
    }

    /* JADX INFO: compiled from: BitmapPreFillRunner.java */
    private static final class b implements g {
        b() {
        }

        @Override // com.bumptech.glide.load.g
        public void a(@NonNull MessageDigest messageDigest) {
            throw new UnsupportedOperationException();
        }
    }

    public a(e eVar, j jVar, c cVar) {
        this(eVar, jVar, cVar, f2895j, new Handler(Looper.getMainLooper()));
    }

    private long c() {
        return this.f2900b.b() - this.f2900b.getCurrentSize();
    }

    private long d() {
        long j2 = this.f2905g;
        this.f2905g = Math.min(4 * j2, f2899n);
        return j2;
    }

    @VisibleForTesting
    boolean a() {
        Bitmap bitmapCreateBitmap;
        long jA = this.f2902d.a();
        while (!this.f2901c.b() && !a(jA)) {
            d dVarC = this.f2901c.c();
            if (this.f2903e.contains(dVarC)) {
                bitmapCreateBitmap = Bitmap.createBitmap(dVarC.d(), dVarC.b(), dVarC.a());
            } else {
                this.f2903e.add(dVarC);
                bitmapCreateBitmap = this.a.b(dVarC.d(), dVarC.b(), dVarC.a());
            }
            int iA = l.a(bitmapCreateBitmap);
            if (c() >= iA) {
                this.f2900b.a(new b(), com.bumptech.glide.load.r.d.g.a(bitmapCreateBitmap, this.a));
            } else {
                this.a.a(bitmapCreateBitmap);
            }
            if (Log.isLoggable(f2894i, 3)) {
                String str = "allocated [" + dVarC.d() + "x" + dVarC.b() + "] " + dVarC.a() + " size: " + iA;
            }
        }
        return (this.f2906h || this.f2901c.b()) ? false : true;
    }

    public void b() {
        this.f2906h = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (a()) {
            this.f2904f.postDelayed(this, d());
        }
    }

    @VisibleForTesting
    a(e eVar, j jVar, c cVar, C0051a c0051a, Handler handler) {
        this.f2903e = new HashSet();
        this.f2905g = f2897l;
        this.a = eVar;
        this.f2900b = jVar;
        this.f2901c = cVar;
        this.f2902d = c0051a;
        this.f2904f = handler;
    }

    private boolean a(long j2) {
        return this.f2902d.a() - j2 >= 32;
    }
}
