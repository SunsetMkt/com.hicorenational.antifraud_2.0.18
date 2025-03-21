package com.bumptech.glide.load.p125r.p126d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.InterfaceC1593g;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e;
import com.bumptech.glide.util.C1878l;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: Rotate.java */
/* renamed from: com.bumptech.glide.load.r.d.d0 */
/* loaded from: classes.dex */
public class C1723d0 extends AbstractC1730h {

    /* renamed from: d */
    private static final String f4827d = "com.bumptech.glide.load.resource.bitmap.Rotate";

    /* renamed from: e */
    private static final byte[] f4828e = f4827d.getBytes(InterfaceC1593g.f4191b);

    /* renamed from: c */
    private final int f4829c;

    public C1723d0(int i2) {
        this.f4829c = i2;
    }

    @Override // com.bumptech.glide.load.p125r.p126d.AbstractC1730h
    /* renamed from: a */
    protected Bitmap mo4310a(@NonNull InterfaceC1626e interfaceC1626e, @NonNull Bitmap bitmap, int i2, int i3) {
        return C1729g0.m4318a(bitmap, this.f4829c);
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    public boolean equals(Object obj) {
        return (obj instanceof C1723d0) && this.f4829c == ((C1723d0) obj).f4829c;
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    public int hashCode() {
        return C1878l.m4992a(f4827d.hashCode(), C1878l.m5005b(this.f4829c));
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    /* renamed from: a */
    public void mo3827a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f4828e);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f4829c).array());
    }
}
