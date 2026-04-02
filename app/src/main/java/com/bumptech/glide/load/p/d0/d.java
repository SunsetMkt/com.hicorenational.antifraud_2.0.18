package com.bumptech.glide.load.p.d0;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.j;

/* JADX INFO: compiled from: PreFillType.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @VisibleForTesting
    static final Bitmap.Config f2914e = Bitmap.Config.RGB_565;
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Bitmap.Config f2916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f2917d;

    /* JADX INFO: compiled from: PreFillType.java */
    public static class a {
        private final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f2918b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Bitmap.Config f2919c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f2920d;

        public a(int i2) {
            this(i2, i2);
        }

        public a a(@Nullable Bitmap.Config config) {
            this.f2919c = config;
            return this;
        }

        Bitmap.Config b() {
            return this.f2919c;
        }

        public a(int i2, int i3) {
            this.f2920d = 1;
            if (i2 <= 0) {
                throw new IllegalArgumentException("Width must be > 0");
            }
            if (i3 <= 0) {
                throw new IllegalArgumentException("Height must be > 0");
            }
            this.a = i2;
            this.f2918b = i3;
        }

        public a a(int i2) {
            if (i2 <= 0) {
                throw new IllegalArgumentException("Weight must be > 0");
            }
            this.f2920d = i2;
            return this;
        }

        d a() {
            return new d(this.a, this.f2918b, this.f2919c, this.f2920d);
        }
    }

    d(int i2, int i3, Bitmap.Config config, int i4) {
        this.f2916c = (Bitmap.Config) j.a(config, "Config must not be null");
        this.a = i2;
        this.f2915b = i3;
        this.f2917d = i4;
    }

    Bitmap.Config a() {
        return this.f2916c;
    }

    int b() {
        return this.f2915b;
    }

    int c() {
        return this.f2917d;
    }

    int d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f2915b == dVar.f2915b && this.a == dVar.a && this.f2917d == dVar.f2917d && this.f2916c == dVar.f2916c;
    }

    public int hashCode() {
        return (((((this.a * 31) + this.f2915b) * 31) + this.f2916c.hashCode()) * 31) + this.f2917d;
    }

    public String toString() {
        return "PreFillSize{width=" + this.a + ", height=" + this.f2915b + ", config=" + this.f2916c + ", weight=" + this.f2917d + '}';
    }
}
