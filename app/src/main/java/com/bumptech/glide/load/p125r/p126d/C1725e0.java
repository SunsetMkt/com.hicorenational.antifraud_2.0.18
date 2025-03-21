package com.bumptech.glide.load.p125r.p126d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.InterfaceC1593g;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e;
import com.bumptech.glide.util.C1876j;
import com.bumptech.glide.util.C1878l;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: RoundedCorners.java */
/* renamed from: com.bumptech.glide.load.r.d.e0 */
/* loaded from: classes.dex */
public final class C1725e0 extends AbstractC1730h {

    /* renamed from: d */
    private static final String f4834d = "com.bumptech.glide.load.resource.bitmap.RoundedCorners";

    /* renamed from: e */
    private static final byte[] f4835e = f4834d.getBytes(InterfaceC1593g.f4191b);

    /* renamed from: c */
    private final int f4836c;

    public C1725e0(int i2) {
        C1876j.m4989a(i2 > 0, "roundingRadius must be greater than 0.");
        this.f4836c = i2;
    }

    @Override // com.bumptech.glide.load.p125r.p126d.AbstractC1730h
    /* renamed from: a */
    protected Bitmap mo4310a(@NonNull InterfaceC1626e interfaceC1626e, @NonNull Bitmap bitmap, int i2, int i3) {
        return C1729g0.m4331b(interfaceC1626e, bitmap, this.f4836c);
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    public boolean equals(Object obj) {
        return (obj instanceof C1725e0) && this.f4836c == ((C1725e0) obj).f4836c;
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    public int hashCode() {
        return C1878l.m4992a(f4834d.hashCode(), C1878l.m5005b(this.f4836c));
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    /* renamed from: a */
    public void mo3827a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f4835e);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f4836c).array());
    }
}
