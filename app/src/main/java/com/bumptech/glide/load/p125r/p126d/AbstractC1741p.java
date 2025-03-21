package com.bumptech.glide.load.p125r.p126d;

import android.os.Build;
import com.bumptech.glide.load.C1595i;

/* compiled from: DownsampleStrategy.java */
/* renamed from: com.bumptech.glide.load.r.d.p */
/* loaded from: classes.dex */
public abstract class AbstractC1741p {

    /* renamed from: a */
    public static final AbstractC1741p f4907a = new a();

    /* renamed from: b */
    public static final AbstractC1741p f4908b = new b();

    /* renamed from: c */
    public static final AbstractC1741p f4909c = new e();

    /* renamed from: d */
    public static final AbstractC1741p f4910d = new c();

    /* renamed from: e */
    public static final AbstractC1741p f4911e = new d();

    /* renamed from: f */
    public static final AbstractC1741p f4912f = new f();

    /* renamed from: g */
    public static final AbstractC1741p f4913g = f4911e;

    /* renamed from: h */
    public static final C1595i<AbstractC1741p> f4914h = C1595i.m3831a("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", f4913g);

    /* renamed from: i */
    static final boolean f4915i;

    /* compiled from: DownsampleStrategy.java */
    /* renamed from: com.bumptech.glide.load.r.d.p$a */
    private static class a extends AbstractC1741p {
        a() {
        }

        @Override // com.bumptech.glide.load.p125r.p126d.AbstractC1741p
        /* renamed from: a */
        public g mo4369a(int i2, int i3, int i4, int i5) {
            return g.QUALITY;
        }

        @Override // com.bumptech.glide.load.p125r.p126d.AbstractC1741p
        /* renamed from: b */
        public float mo4370b(int i2, int i3, int i4, int i5) {
            if (Math.min(i3 / i5, i2 / i4) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r1);
        }
    }

    /* compiled from: DownsampleStrategy.java */
    /* renamed from: com.bumptech.glide.load.r.d.p$b */
    private static class b extends AbstractC1741p {
        b() {
        }

        @Override // com.bumptech.glide.load.p125r.p126d.AbstractC1741p
        /* renamed from: a */
        public g mo4369a(int i2, int i3, int i4, int i5) {
            return g.MEMORY;
        }

        @Override // com.bumptech.glide.load.p125r.p126d.AbstractC1741p
        /* renamed from: b */
        public float mo4370b(int i2, int i3, int i4, int i5) {
            int ceil = (int) Math.ceil(Math.max(i3 / i5, i2 / i4));
            return 1.0f / (r2 << (Math.max(1, Integer.highestOneBit(ceil)) >= ceil ? 0 : 1));
        }
    }

    /* compiled from: DownsampleStrategy.java */
    /* renamed from: com.bumptech.glide.load.r.d.p$c */
    private static class c extends AbstractC1741p {
        c() {
        }

        @Override // com.bumptech.glide.load.p125r.p126d.AbstractC1741p
        /* renamed from: a */
        public g mo4369a(int i2, int i3, int i4, int i5) {
            return mo4370b(i2, i3, i4, i5) == 1.0f ? g.QUALITY : AbstractC1741p.f4909c.mo4369a(i2, i3, i4, i5);
        }

        @Override // com.bumptech.glide.load.p125r.p126d.AbstractC1741p
        /* renamed from: b */
        public float mo4370b(int i2, int i3, int i4, int i5) {
            return Math.min(1.0f, AbstractC1741p.f4909c.mo4370b(i2, i3, i4, i5));
        }
    }

    /* compiled from: DownsampleStrategy.java */
    /* renamed from: com.bumptech.glide.load.r.d.p$d */
    private static class d extends AbstractC1741p {
        d() {
        }

        @Override // com.bumptech.glide.load.p125r.p126d.AbstractC1741p
        /* renamed from: a */
        public g mo4369a(int i2, int i3, int i4, int i5) {
            return g.QUALITY;
        }

        @Override // com.bumptech.glide.load.p125r.p126d.AbstractC1741p
        /* renamed from: b */
        public float mo4370b(int i2, int i3, int i4, int i5) {
            return Math.max(i4 / i2, i5 / i3);
        }
    }

    /* compiled from: DownsampleStrategy.java */
    /* renamed from: com.bumptech.glide.load.r.d.p$e */
    private static class e extends AbstractC1741p {
        e() {
        }

        @Override // com.bumptech.glide.load.p125r.p126d.AbstractC1741p
        /* renamed from: a */
        public g mo4369a(int i2, int i3, int i4, int i5) {
            return AbstractC1741p.f4915i ? g.QUALITY : g.MEMORY;
        }

        @Override // com.bumptech.glide.load.p125r.p126d.AbstractC1741p
        /* renamed from: b */
        public float mo4370b(int i2, int i3, int i4, int i5) {
            if (AbstractC1741p.f4915i) {
                return Math.min(i4 / i2, i5 / i3);
            }
            if (Math.max(i3 / i5, i2 / i4) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r2);
        }
    }

    /* compiled from: DownsampleStrategy.java */
    /* renamed from: com.bumptech.glide.load.r.d.p$f */
    private static class f extends AbstractC1741p {
        f() {
        }

        @Override // com.bumptech.glide.load.p125r.p126d.AbstractC1741p
        /* renamed from: a */
        public g mo4369a(int i2, int i3, int i4, int i5) {
            return g.QUALITY;
        }

        @Override // com.bumptech.glide.load.p125r.p126d.AbstractC1741p
        /* renamed from: b */
        public float mo4370b(int i2, int i3, int i4, int i5) {
            return 1.0f;
        }
    }

    /* compiled from: DownsampleStrategy.java */
    /* renamed from: com.bumptech.glide.load.r.d.p$g */
    public enum g {
        MEMORY,
        QUALITY
    }

    static {
        f4915i = Build.VERSION.SDK_INT >= 19;
    }

    /* renamed from: a */
    public abstract g mo4369a(int i2, int i3, int i4, int i5);

    /* renamed from: b */
    public abstract float mo4370b(int i2, int i3, int i4, int i5);
}
