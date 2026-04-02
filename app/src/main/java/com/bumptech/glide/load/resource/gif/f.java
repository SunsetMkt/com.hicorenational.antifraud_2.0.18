package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.j;
import com.bumptech.glide.k;
import com.bumptech.glide.load.n;
import com.bumptech.glide.r.l.p;
import com.bumptech.glide.util.l;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: GifFrameLoader.java */
/* JADX INFO: loaded from: classes.dex */
class f {
    private final com.bumptech.glide.o.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f3282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<b> f3283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final k f3284d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.p.a0.e f3285e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f3286f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f3287g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f3288h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private j<Bitmap> f3289i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private a f3290j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f3291k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private a f3292l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Bitmap f3293m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private n<Bitmap> f3294n;
    private a o;

    @Nullable
    private d p;
    private int q;
    private int r;
    private int s;

    /* JADX INFO: compiled from: GifFrameLoader.java */
    @VisibleForTesting
    static class a extends com.bumptech.glide.r.l.e<Bitmap> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Handler f3295d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final int f3296e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final long f3297f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Bitmap f3298g;

        a(Handler handler, int i2, long j2) {
            this.f3295d = handler;
            this.f3296e = i2;
            this.f3297f = j2;
        }

        @Override // com.bumptech.glide.r.l.p
        public /* bridge */ /* synthetic */ void a(@NonNull Object obj, @Nullable com.bumptech.glide.r.m.f fVar) {
            a((Bitmap) obj, (com.bumptech.glide.r.m.f<? super Bitmap>) fVar);
        }

        Bitmap b() {
            return this.f3298g;
        }

        @Override // com.bumptech.glide.r.l.p
        public void c(@Nullable Drawable drawable) {
            this.f3298g = null;
        }

        public void a(@NonNull Bitmap bitmap, @Nullable com.bumptech.glide.r.m.f<? super Bitmap> fVar) {
            this.f3298g = bitmap;
            this.f3295d.sendMessageAtTime(this.f3295d.obtainMessage(1, this), this.f3297f);
        }
    }

    /* JADX INFO: compiled from: GifFrameLoader.java */
    public interface b {
        void a();
    }

    /* JADX INFO: compiled from: GifFrameLoader.java */
    private class c implements Handler.Callback {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final int f3299b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final int f3300c = 2;

        c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                f.this.a((a) message.obj);
                return true;
            }
            if (i2 != 2) {
                return false;
            }
            f.this.f3284d.a((p<?>) message.obj);
            return false;
        }
    }

    /* JADX INFO: compiled from: GifFrameLoader.java */
    @VisibleForTesting
    interface d {
        void a();
    }

    f(com.bumptech.glide.b bVar, com.bumptech.glide.o.a aVar, int i2, int i3, n<Bitmap> nVar, Bitmap bitmap) {
        this(bVar.d(), com.bumptech.glide.b.e(bVar.f()), aVar, null, a(com.bumptech.glide.b.e(bVar.f()), i2, i3), nVar, bitmap);
    }

    private static com.bumptech.glide.load.g m() {
        return new com.bumptech.glide.s.e(Double.valueOf(Math.random()));
    }

    private void n() {
        if (!this.f3286f || this.f3287g) {
            return;
        }
        if (this.f3288h) {
            com.bumptech.glide.util.j.a(this.o == null, "Pending target must be null when starting from the first frame");
            this.a.f();
            this.f3288h = false;
        }
        a aVar = this.o;
        if (aVar != null) {
            this.o = null;
            a(aVar);
            return;
        }
        this.f3287g = true;
        long jUptimeMillis = SystemClock.uptimeMillis() + ((long) this.a.d());
        this.a.b();
        this.f3292l = new a(this.f3282b, this.a.g(), jUptimeMillis);
        this.f3289i.a((com.bumptech.glide.r.a<?>) com.bumptech.glide.r.h.b(m())).a((Object) this.a).b(this.f3292l);
    }

    private void o() {
        Bitmap bitmap = this.f3293m;
        if (bitmap != null) {
            this.f3285e.a(bitmap);
            this.f3293m = null;
        }
    }

    private void p() {
        if (this.f3286f) {
            return;
        }
        this.f3286f = true;
        this.f3291k = false;
        n();
    }

    private void q() {
        this.f3286f = false;
    }

    void a(n<Bitmap> nVar, Bitmap bitmap) {
        this.f3294n = (n) com.bumptech.glide.util.j.a(nVar);
        this.f3293m = (Bitmap) com.bumptech.glide.util.j.a(bitmap);
        this.f3289i = this.f3289i.a((com.bumptech.glide.r.a<?>) new com.bumptech.glide.r.h().b(nVar));
        this.q = l.a(bitmap);
        this.r = bitmap.getWidth();
        this.s = bitmap.getHeight();
    }

    void b(b bVar) {
        this.f3283c.remove(bVar);
        if (this.f3283c.isEmpty()) {
            q();
        }
    }

    Bitmap c() {
        a aVar = this.f3290j;
        return aVar != null ? aVar.b() : this.f3293m;
    }

    int d() {
        a aVar = this.f3290j;
        if (aVar != null) {
            return aVar.f3296e;
        }
        return -1;
    }

    Bitmap e() {
        return this.f3293m;
    }

    int f() {
        return this.a.c();
    }

    n<Bitmap> g() {
        return this.f3294n;
    }

    int h() {
        return this.s;
    }

    int i() {
        return this.a.k();
    }

    int j() {
        return this.a.j() + this.q;
    }

    int k() {
        return this.r;
    }

    void l() {
        com.bumptech.glide.util.j.a(!this.f3286f, "Can't restart a running animation");
        this.f3288h = true;
        a aVar = this.o;
        if (aVar != null) {
            this.f3284d.a((p<?>) aVar);
            this.o = null;
        }
    }

    @VisibleForTesting
    void setOnEveryFrameReadyListener(@Nullable d dVar) {
        this.p = dVar;
    }

    ByteBuffer b() {
        return this.a.e().asReadOnlyBuffer();
    }

    f(com.bumptech.glide.load.p.a0.e eVar, k kVar, com.bumptech.glide.o.a aVar, Handler handler, j<Bitmap> jVar, n<Bitmap> nVar, Bitmap bitmap) {
        this.f3283c = new ArrayList();
        this.f3284d = kVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f3285e = eVar;
        this.f3282b = handler;
        this.f3289i = jVar;
        this.a = aVar;
        a(nVar, bitmap);
    }

    void a(b bVar) {
        if (!this.f3291k) {
            if (!this.f3283c.contains(bVar)) {
                boolean zIsEmpty = this.f3283c.isEmpty();
                this.f3283c.add(bVar);
                if (zIsEmpty) {
                    p();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
    }

    void a() {
        this.f3283c.clear();
        o();
        q();
        a aVar = this.f3290j;
        if (aVar != null) {
            this.f3284d.a((p<?>) aVar);
            this.f3290j = null;
        }
        a aVar2 = this.f3292l;
        if (aVar2 != null) {
            this.f3284d.a((p<?>) aVar2);
            this.f3292l = null;
        }
        a aVar3 = this.o;
        if (aVar3 != null) {
            this.f3284d.a((p<?>) aVar3);
            this.o = null;
        }
        this.a.clear();
        this.f3291k = true;
    }

    @VisibleForTesting
    void a(a aVar) {
        d dVar = this.p;
        if (dVar != null) {
            dVar.a();
        }
        this.f3287g = false;
        if (this.f3291k) {
            this.f3282b.obtainMessage(2, aVar).sendToTarget();
            return;
        }
        if (!this.f3286f) {
            this.o = aVar;
            return;
        }
        if (aVar.b() != null) {
            o();
            a aVar2 = this.f3290j;
            this.f3290j = aVar;
            for (int size = this.f3283c.size() - 1; size >= 0; size--) {
                this.f3283c.get(size).a();
            }
            if (aVar2 != null) {
                this.f3282b.obtainMessage(2, aVar2).sendToTarget();
            }
        }
        n();
    }

    private static j<Bitmap> a(k kVar, int i2, int i3) {
        return kVar.b().a((com.bumptech.glide.r.a<?>) com.bumptech.glide.r.h.b(com.bumptech.glide.load.p.j.f2961b).c(true).b(true).a(i2, i3));
    }
}
