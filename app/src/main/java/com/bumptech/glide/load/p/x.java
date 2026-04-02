package com.bumptech.glide.load.p;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: ResourceCacheKey.java */
/* JADX INFO: loaded from: classes.dex */
final class x implements com.bumptech.glide.load.g {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final com.bumptech.glide.util.g<Class<?>, byte[]> f3037k = new com.bumptech.glide.util.g<>(50);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.p.a0.b f3038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.g f3039d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.g f3040e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f3041f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f3042g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Class<?> f3043h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.bumptech.glide.load.j f3044i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.bumptech.glide.load.n<?> f3045j;

    x(com.bumptech.glide.load.p.a0.b bVar, com.bumptech.glide.load.g gVar, com.bumptech.glide.load.g gVar2, int i2, int i3, com.bumptech.glide.load.n<?> nVar, Class<?> cls, com.bumptech.glide.load.j jVar) {
        this.f3038c = bVar;
        this.f3039d = gVar;
        this.f3040e = gVar2;
        this.f3041f = i2;
        this.f3042g = i3;
        this.f3045j = nVar;
        this.f3043h = cls;
        this.f3044i = jVar;
    }

    @Override // com.bumptech.glide.load.g
    public void a(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f3038c.a(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f3041f).putInt(this.f3042g).array();
        this.f3040e.a(messageDigest);
        this.f3039d.a(messageDigest);
        messageDigest.update(bArr);
        com.bumptech.glide.load.n<?> nVar = this.f3045j;
        if (nVar != null) {
            nVar.a(messageDigest);
        }
        this.f3044i.a(messageDigest);
        messageDigest.update(a());
        this.f3038c.put(bArr);
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object obj) {
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return this.f3042g == xVar.f3042g && this.f3041f == xVar.f3041f && com.bumptech.glide.util.l.b(this.f3045j, xVar.f3045j) && this.f3043h.equals(xVar.f3043h) && this.f3039d.equals(xVar.f3039d) && this.f3040e.equals(xVar.f3040e) && this.f3044i.equals(xVar.f3044i);
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        int iHashCode = (((((this.f3039d.hashCode() * 31) + this.f3040e.hashCode()) * 31) + this.f3041f) * 31) + this.f3042g;
        com.bumptech.glide.load.n<?> nVar = this.f3045j;
        if (nVar != null) {
            iHashCode = (iHashCode * 31) + nVar.hashCode();
        }
        return (((iHashCode * 31) + this.f3043h.hashCode()) * 31) + this.f3044i.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f3039d + ", signature=" + this.f3040e + ", width=" + this.f3041f + ", height=" + this.f3042g + ", decodedResourceClass=" + this.f3043h + ", transformation='" + this.f3045j + "', options=" + this.f3044i + '}';
    }

    private byte[] a() {
        byte[] bArrB = f3037k.b(this.f3043h);
        if (bArrB != null) {
            return bArrB;
        }
        byte[] bytes = this.f3043h.getName().getBytes(com.bumptech.glide.load.g.f2715b);
        f3037k.b(this.f3043h, bytes);
        return bytes;
    }
}
