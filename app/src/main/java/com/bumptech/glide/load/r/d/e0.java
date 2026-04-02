package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: RoundedCorners.java */
/* JADX INFO: loaded from: classes.dex */
public final class e0 extends h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f3153d = "com.bumptech.glide.load.resource.bitmap.RoundedCorners";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final byte[] f3154e = f3153d.getBytes(com.bumptech.glide.load.g.f2715b);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f3155c;

    public e0(int i2) {
        com.bumptech.glide.util.j.a(i2 > 0, "roundingRadius must be greater than 0.");
        this.f3155c = i2;
    }

    @Override // com.bumptech.glide.load.r.d.h
    protected Bitmap a(@NonNull com.bumptech.glide.load.p.a0.e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        return g0.b(eVar, bitmap, this.f3155c);
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object obj) {
        return (obj instanceof e0) && this.f3155c == ((e0) obj).f3155c;
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        return com.bumptech.glide.util.l.a(f3153d.hashCode(), com.bumptech.glide.util.l.b(this.f3155c));
    }

    @Override // com.bumptech.glide.load.g
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f3154e);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f3155c).array());
    }
}
