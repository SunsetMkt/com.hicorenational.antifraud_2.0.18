package com.bumptech.glide.load.p.a0;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: compiled from: AttributeStrategy.java */
/* JADX INFO: loaded from: classes.dex */
class c implements l {
    private final b a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h<a, Bitmap> f2776b = new h<>();

    /* JADX INFO: compiled from: AttributeStrategy.java */
    @VisibleForTesting
    static class a implements m {
        private final b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2777b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f2778c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Bitmap.Config f2779d;

        public a(b bVar) {
            this.a = bVar;
        }

        public void a(int i2, int i3, Bitmap.Config config) {
            this.f2777b = i2;
            this.f2778c = i3;
            this.f2779d = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f2777b == aVar.f2777b && this.f2778c == aVar.f2778c && this.f2779d == aVar.f2779d;
        }

        public int hashCode() {
            int i2 = ((this.f2777b * 31) + this.f2778c) * 31;
            Bitmap.Config config = this.f2779d;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        @Override // com.bumptech.glide.load.p.a0.m
        public void offer() {
            this.a.a(this);
        }

        public String toString() {
            return c.c(this.f2777b, this.f2778c, this.f2779d);
        }
    }

    /* JADX INFO: compiled from: AttributeStrategy.java */
    @VisibleForTesting
    static class b extends d<a> {
        b() {
        }

        a a(int i2, int i3, Bitmap.Config config) {
            a aVarB = b();
            aVarB.a(i2, i3, config);
            return aVarB;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.p.a0.d
        public a a() {
            return new a(this);
        }
    }

    c() {
    }

    private static String d(Bitmap bitmap) {
        return c(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.p.a0.l
    public void a(Bitmap bitmap) {
        this.f2776b.a(this.a.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.bumptech.glide.load.p.a0.l
    public String b(int i2, int i3, Bitmap.Config config) {
        return c(i2, i3, config);
    }

    @Override // com.bumptech.glide.load.p.a0.l
    public String c(Bitmap bitmap) {
        return d(bitmap);
    }

    @Override // com.bumptech.glide.load.p.a0.l
    public Bitmap removeLast() {
        return this.f2776b.a();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f2776b;
    }

    static String c(int i2, int i3, Bitmap.Config config) {
        return "[" + i2 + "x" + i3 + "], " + config;
    }

    @Override // com.bumptech.glide.load.p.a0.l
    public int b(Bitmap bitmap) {
        return com.bumptech.glide.util.l.a(bitmap);
    }

    @Override // com.bumptech.glide.load.p.a0.l
    public Bitmap a(int i2, int i3, Bitmap.Config config) {
        return this.f2776b.a(this.a.a(i2, i3, config));
    }
}
