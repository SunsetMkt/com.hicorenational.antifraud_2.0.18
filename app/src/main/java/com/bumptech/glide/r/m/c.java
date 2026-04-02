package com.bumptech.glide.r.m;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: DrawableCrossFadeFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements g<Drawable> {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f3537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d f3538c;

    /* JADX INFO: compiled from: DrawableCrossFadeFactory.java */
    public static class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int f3539c = 300;
        private final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f3540b;

        public a() {
            this(300);
        }

        public a a(boolean z) {
            this.f3540b = z;
            return this;
        }

        public a(int i2) {
            this.a = i2;
        }

        public c a() {
            return new c(this.a, this.f3540b);
        }
    }

    protected c(int i2, boolean z) {
        this.a = i2;
        this.f3537b = z;
    }

    @Override // com.bumptech.glide.r.m.g
    public f<Drawable> a(com.bumptech.glide.load.a aVar, boolean z) {
        return aVar == com.bumptech.glide.load.a.MEMORY_CACHE ? e.a() : a();
    }

    private f<Drawable> a() {
        if (this.f3538c == null) {
            this.f3538c = new d(this.a, this.f3537b);
        }
        return this.f3538c;
    }
}
