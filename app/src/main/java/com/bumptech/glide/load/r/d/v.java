package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: GranularRoundedCorners.java */
/* JADX INFO: loaded from: classes.dex */
public final class v extends h {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f3226g = "com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final byte[] f3227h = f3226g.getBytes(com.bumptech.glide.load.g.f2715b);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f3228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f3229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f3230e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f3231f;

    public v(float f2, float f3, float f4, float f5) {
        this.f3228c = f2;
        this.f3229d = f3;
        this.f3230e = f4;
        this.f3231f = f5;
    }

    @Override // com.bumptech.glide.load.r.d.h
    protected Bitmap a(@NonNull com.bumptech.glide.load.p.a0.e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        return g0.a(eVar, bitmap, this.f3228c, this.f3229d, this.f3230e, this.f3231f);
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object obj) {
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.f3228c == vVar.f3228c && this.f3229d == vVar.f3229d && this.f3230e == vVar.f3230e && this.f3231f == vVar.f3231f;
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        return com.bumptech.glide.util.l.a(this.f3231f, com.bumptech.glide.util.l.a(this.f3230e, com.bumptech.glide.util.l.a(this.f3229d, com.bumptech.glide.util.l.a(f3226g.hashCode(), com.bumptech.glide.util.l.a(this.f3228c)))));
    }

    @Override // com.bumptech.glide.load.g
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f3227h);
        messageDigest.update(ByteBuffer.allocate(16).putFloat(this.f3228c).putFloat(this.f3229d).putFloat(this.f3230e).putFloat(this.f3231f).array());
    }
}
