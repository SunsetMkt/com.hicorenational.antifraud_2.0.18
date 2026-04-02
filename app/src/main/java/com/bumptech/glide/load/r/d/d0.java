package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: Rotate.java */
/* JADX INFO: loaded from: classes.dex */
public class d0 extends h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f3147d = "com.bumptech.glide.load.resource.bitmap.Rotate";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final byte[] f3148e = f3147d.getBytes(com.bumptech.glide.load.g.f2715b);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f3149c;

    public d0(int i2) {
        this.f3149c = i2;
    }

    @Override // com.bumptech.glide.load.r.d.h
    protected Bitmap a(@NonNull com.bumptech.glide.load.p.a0.e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        return g0.a(bitmap, this.f3149c);
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object obj) {
        return (obj instanceof d0) && this.f3149c == ((d0) obj).f3149c;
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        return com.bumptech.glide.util.l.a(f3147d.hashCode(), com.bumptech.glide.util.l.b(this.f3149c));
    }

    @Override // com.bumptech.glide.load.g
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f3148e);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f3149c).array());
    }
}
