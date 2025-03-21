package com.bumptech.glide.load.p118p.p122d0;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.C1876j;

/* compiled from: PreFillType.java */
/* renamed from: com.bumptech.glide.load.p.d0.d */
/* loaded from: classes.dex */
public final class C1659d {

    /* renamed from: e */
    @VisibleForTesting
    static final Bitmap.Config f4456e = Bitmap.Config.RGB_565;

    /* renamed from: a */
    private final int f4457a;

    /* renamed from: b */
    private final int f4458b;

    /* renamed from: c */
    private final Bitmap.Config f4459c;

    /* renamed from: d */
    private final int f4460d;

    /* compiled from: PreFillType.java */
    /* renamed from: com.bumptech.glide.load.p.d0.d$a */
    public static class a {

        /* renamed from: a */
        private final int f4461a;

        /* renamed from: b */
        private final int f4462b;

        /* renamed from: c */
        private Bitmap.Config f4463c;

        /* renamed from: d */
        private int f4464d;

        public a(int i2) {
            this(i2, i2);
        }

        /* renamed from: a */
        public a m4066a(@Nullable Bitmap.Config config) {
            this.f4463c = config;
            return this;
        }

        /* renamed from: b */
        Bitmap.Config m4068b() {
            return this.f4463c;
        }

        public a(int i2, int i3) {
            this.f4464d = 1;
            if (i2 <= 0) {
                throw new IllegalArgumentException("Width must be > 0");
            }
            if (i3 <= 0) {
                throw new IllegalArgumentException("Height must be > 0");
            }
            this.f4461a = i2;
            this.f4462b = i3;
        }

        /* renamed from: a */
        public a m4065a(int i2) {
            if (i2 <= 0) {
                throw new IllegalArgumentException("Weight must be > 0");
            }
            this.f4464d = i2;
            return this;
        }

        /* renamed from: a */
        C1659d m4067a() {
            return new C1659d(this.f4461a, this.f4462b, this.f4463c, this.f4464d);
        }
    }

    C1659d(int i2, int i3, Bitmap.Config config, int i4) {
        this.f4459c = (Bitmap.Config) C1876j.m4986a(config, "Config must not be null");
        this.f4457a = i2;
        this.f4458b = i3;
        this.f4460d = i4;
    }

    /* renamed from: a */
    Bitmap.Config m4061a() {
        return this.f4459c;
    }

    /* renamed from: b */
    int m4062b() {
        return this.f4458b;
    }

    /* renamed from: c */
    int m4063c() {
        return this.f4460d;
    }

    /* renamed from: d */
    int m4064d() {
        return this.f4457a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1659d)) {
            return false;
        }
        C1659d c1659d = (C1659d) obj;
        return this.f4458b == c1659d.f4458b && this.f4457a == c1659d.f4457a && this.f4460d == c1659d.f4460d && this.f4459c == c1659d.f4459c;
    }

    public int hashCode() {
        return (((((this.f4457a * 31) + this.f4458b) * 31) + this.f4459c.hashCode()) * 31) + this.f4460d;
    }

    public String toString() {
        return "PreFillSize{width=" + this.f4457a + ", height=" + this.f4458b + ", config=" + this.f4459c + ", weight=" + this.f4460d + '}';
    }
}
