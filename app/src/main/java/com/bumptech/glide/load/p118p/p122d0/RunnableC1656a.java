package com.bumptech.glide.load.p118p.p122d0;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.InterfaceC1593g;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e;
import com.bumptech.glide.load.p118p.p120b0.InterfaceC1648j;
import com.bumptech.glide.load.p125r.p126d.C1728g;
import com.bumptech.glide.util.C1878l;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* compiled from: BitmapPreFillRunner.java */
/* renamed from: com.bumptech.glide.load.p.d0.a */
/* loaded from: classes.dex */
final class RunnableC1656a implements Runnable {

    /* renamed from: i */
    @VisibleForTesting
    static final String f4433i = "PreFillRunner";

    /* renamed from: k */
    static final long f4435k = 32;

    /* renamed from: l */
    static final long f4436l = 40;

    /* renamed from: m */
    static final int f4437m = 4;

    /* renamed from: a */
    private final InterfaceC1626e f4439a;

    /* renamed from: b */
    private final InterfaceC1648j f4440b;

    /* renamed from: c */
    private final C1658c f4441c;

    /* renamed from: d */
    private final a f4442d;

    /* renamed from: e */
    private final Set<C1659d> f4443e;

    /* renamed from: f */
    private final Handler f4444f;

    /* renamed from: g */
    private long f4445g;

    /* renamed from: h */
    private boolean f4446h;

    /* renamed from: j */
    private static final a f4434j = new a();

    /* renamed from: n */
    static final long f4438n = TimeUnit.SECONDS.toMillis(1);

    /* compiled from: BitmapPreFillRunner.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.p.d0.a$a */
    static class a {
        a() {
        }

        /* renamed from: a */
        long m4054a() {
            return SystemClock.currentThreadTimeMillis();
        }
    }

    /* compiled from: BitmapPreFillRunner.java */
    /* renamed from: com.bumptech.glide.load.p.d0.a$b */
    private static final class b implements InterfaceC1593g {
        b() {
        }

        @Override // com.bumptech.glide.load.InterfaceC1593g
        /* renamed from: a */
        public void mo3827a(@NonNull MessageDigest messageDigest) {
            throw new UnsupportedOperationException();
        }
    }

    public RunnableC1656a(InterfaceC1626e interfaceC1626e, InterfaceC1648j interfaceC1648j, C1658c c1658c) {
        this(interfaceC1626e, interfaceC1648j, c1658c, f4434j, new Handler(Looper.getMainLooper()));
    }

    /* renamed from: c */
    private long m4050c() {
        return this.f4440b.mo4004b() - this.f4440b.getCurrentSize();
    }

    /* renamed from: d */
    private long m4051d() {
        long j2 = this.f4445g;
        this.f4445g = Math.min(4 * j2, f4438n);
        return j2;
    }

    @VisibleForTesting
    /* renamed from: a */
    boolean m4052a() {
        Bitmap createBitmap;
        long m4054a = this.f4442d.m4054a();
        while (!this.f4441c.m4059b() && !m4049a(m4054a)) {
            C1659d m4060c = this.f4441c.m4060c();
            if (this.f4443e.contains(m4060c)) {
                createBitmap = Bitmap.createBitmap(m4060c.m4064d(), m4060c.m4062b(), m4060c.m4061a());
            } else {
                this.f4443e.add(m4060c);
                createBitmap = this.f4439a.mo3926b(m4060c.m4064d(), m4060c.m4062b(), m4060c.m4061a());
            }
            int m4995a = C1878l.m4995a(createBitmap);
            if (m4050c() >= m4995a) {
                this.f4440b.mo3996a(new b(), C1728g.m4315a(createBitmap, this.f4439a));
            } else {
                this.f4439a.mo3924a(createBitmap);
            }
            if (Log.isLoggable(f4433i, 3)) {
                String str = "allocated [" + m4060c.m4064d() + "x" + m4060c.m4062b() + "] " + m4060c.m4061a() + " size: " + m4995a;
            }
        }
        return (this.f4446h || this.f4441c.m4059b()) ? false : true;
    }

    /* renamed from: b */
    public void m4053b() {
        this.f4446h = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (m4052a()) {
            this.f4444f.postDelayed(this, m4051d());
        }
    }

    @VisibleForTesting
    RunnableC1656a(InterfaceC1626e interfaceC1626e, InterfaceC1648j interfaceC1648j, C1658c c1658c, a aVar, Handler handler) {
        this.f4443e = new HashSet();
        this.f4445g = f4436l;
        this.f4439a = interfaceC1626e;
        this.f4440b = interfaceC1648j;
        this.f4441c = c1658c;
        this.f4442d = aVar;
        this.f4444f = handler;
    }

    /* renamed from: a */
    private boolean m4049a(long j2) {
        return this.f4442d.m4054a() - j2 >= 32;
    }
}
