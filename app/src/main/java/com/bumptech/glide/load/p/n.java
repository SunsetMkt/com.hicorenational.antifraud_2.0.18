package com.bumptech.glide.load.p;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: compiled from: EngineKey.java */
/* JADX INFO: loaded from: classes.dex */
class n implements com.bumptech.glide.load.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f3002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f3003d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f3004e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Class<?> f3005f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Class<?> f3006g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.bumptech.glide.load.g f3007h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<Class<?>, com.bumptech.glide.load.n<?>> f3008i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.bumptech.glide.load.j f3009j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f3010k;

    n(Object obj, com.bumptech.glide.load.g gVar, int i2, int i3, Map<Class<?>, com.bumptech.glide.load.n<?>> map, Class<?> cls, Class<?> cls2, com.bumptech.glide.load.j jVar) {
        this.f3002c = com.bumptech.glide.util.j.a(obj);
        this.f3007h = (com.bumptech.glide.load.g) com.bumptech.glide.util.j.a(gVar, "Signature must not be null");
        this.f3003d = i2;
        this.f3004e = i3;
        this.f3008i = (Map) com.bumptech.glide.util.j.a(map);
        this.f3005f = (Class) com.bumptech.glide.util.j.a(cls, "Resource class must not be null");
        this.f3006g = (Class) com.bumptech.glide.util.j.a(cls2, "Transcode class must not be null");
        this.f3009j = (com.bumptech.glide.load.j) com.bumptech.glide.util.j.a(jVar);
    }

    @Override // com.bumptech.glide.load.g
    public void a(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.f3002c.equals(nVar.f3002c) && this.f3007h.equals(nVar.f3007h) && this.f3004e == nVar.f3004e && this.f3003d == nVar.f3003d && this.f3008i.equals(nVar.f3008i) && this.f3005f.equals(nVar.f3005f) && this.f3006g.equals(nVar.f3006g) && this.f3009j.equals(nVar.f3009j);
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        if (this.f3010k == 0) {
            this.f3010k = this.f3002c.hashCode();
            this.f3010k = (this.f3010k * 31) + this.f3007h.hashCode();
            this.f3010k = (this.f3010k * 31) + this.f3003d;
            this.f3010k = (this.f3010k * 31) + this.f3004e;
            this.f3010k = (this.f3010k * 31) + this.f3008i.hashCode();
            this.f3010k = (this.f3010k * 31) + this.f3005f.hashCode();
            this.f3010k = (this.f3010k * 31) + this.f3006g.hashCode();
            this.f3010k = (this.f3010k * 31) + this.f3009j.hashCode();
        }
        return this.f3010k;
    }

    public String toString() {
        return "EngineKey{model=" + this.f3002c + ", width=" + this.f3003d + ", height=" + this.f3004e + ", resourceClass=" + this.f3005f + ", transcodeClass=" + this.f3006g + ", signature=" + this.f3007h + ", hashCode=" + this.f3010k + ", transformations=" + this.f3008i + ", options=" + this.f3009j + '}';
    }
}
