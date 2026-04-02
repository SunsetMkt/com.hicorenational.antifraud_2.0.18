package com.bumptech.glide.load.r.d;

import android.os.Build;

/* JADX INFO: compiled from: DownsampleStrategy.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class p {
    public static final p a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p f3200b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final p f3201c = new e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final p f3202d = new c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final p f3203e = new d();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final p f3204f = new f();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final p f3205g = f3203e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final com.bumptech.glide.load.i<p> f3206h = com.bumptech.glide.load.i.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", f3205g);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final boolean f3207i;

    /* JADX INFO: compiled from: DownsampleStrategy.java */
    private static class a extends p {
        a() {
        }

        @Override // com.bumptech.glide.load.r.d.p
        public g a(int i2, int i3, int i4, int i5) {
            return g.QUALITY;
        }

        @Override // com.bumptech.glide.load.r.d.p
        public float b(int i2, int i3, int i4, int i5) {
            if (Math.min(i3 / i5, i2 / i4) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r1);
        }
    }

    /* JADX INFO: compiled from: DownsampleStrategy.java */
    private static class b extends p {
        b() {
        }

        @Override // com.bumptech.glide.load.r.d.p
        public g a(int i2, int i3, int i4, int i5) {
            return g.MEMORY;
        }

        @Override // com.bumptech.glide.load.r.d.p
        public float b(int i2, int i3, int i4, int i5) {
            int iCeil = (int) Math.ceil(Math.max(i3 / i5, i2 / i4));
            return 1.0f / (r2 << (Math.max(1, Integer.highestOneBit(iCeil)) >= iCeil ? 0 : 1));
        }
    }

    /* JADX INFO: compiled from: DownsampleStrategy.java */
    private static class c extends p {
        c() {
        }

        @Override // com.bumptech.glide.load.r.d.p
        public g a(int i2, int i3, int i4, int i5) {
            return b(i2, i3, i4, i5) == 1.0f ? g.QUALITY : p.f3201c.a(i2, i3, i4, i5);
        }

        @Override // com.bumptech.glide.load.r.d.p
        public float b(int i2, int i3, int i4, int i5) {
            return Math.min(1.0f, p.f3201c.b(i2, i3, i4, i5));
        }
    }

    /* JADX INFO: compiled from: DownsampleStrategy.java */
    private static class d extends p {
        d() {
        }

        @Override // com.bumptech.glide.load.r.d.p
        public g a(int i2, int i3, int i4, int i5) {
            return g.QUALITY;
        }

        @Override // com.bumptech.glide.load.r.d.p
        public float b(int i2, int i3, int i4, int i5) {
            return Math.max(i4 / i2, i5 / i3);
        }
    }

    /* JADX INFO: compiled from: DownsampleStrategy.java */
    private static class e extends p {
        e() {
        }

        @Override // com.bumptech.glide.load.r.d.p
        public g a(int i2, int i3, int i4, int i5) {
            return p.f3207i ? g.QUALITY : g.MEMORY;
        }

        @Override // com.bumptech.glide.load.r.d.p
        public float b(int i2, int i3, int i4, int i5) {
            if (p.f3207i) {
                return Math.min(i4 / i2, i5 / i3);
            }
            if (Math.max(i3 / i5, i2 / i4) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r2);
        }
    }

    /* JADX INFO: compiled from: DownsampleStrategy.java */
    private static class f extends p {
        f() {
        }

        @Override // com.bumptech.glide.load.r.d.p
        public g a(int i2, int i3, int i4, int i5) {
            return g.QUALITY;
        }

        @Override // com.bumptech.glide.load.r.d.p
        public float b(int i2, int i3, int i4, int i5) {
            return 1.0f;
        }
    }

    /* JADX INFO: compiled from: DownsampleStrategy.java */
    public enum g {
        MEMORY,
        QUALITY
    }

    static {
        f3207i = Build.VERSION.SDK_INT >= 19;
    }

    public abstract g a(int i2, int i3, int i4, int i5);

    public abstract float b(int i2, int i3, int i4, int i5);
}
