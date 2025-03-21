package com.bumptech.glide.load.p125r.p126d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.InterfaceC1593g;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e;
import com.bumptech.glide.util.C1878l;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: GranularRoundedCorners.java */
/* renamed from: com.bumptech.glide.load.r.d.v */
/* loaded from: classes.dex */
public final class C1747v extends AbstractC1730h {

    /* renamed from: g */
    private static final String f4940g = "com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners";

    /* renamed from: h */
    private static final byte[] f4941h = f4940g.getBytes(InterfaceC1593g.f4191b);

    /* renamed from: c */
    private final float f4942c;

    /* renamed from: d */
    private final float f4943d;

    /* renamed from: e */
    private final float f4944e;

    /* renamed from: f */
    private final float f4945f;

    public C1747v(float f2, float f3, float f4, float f5) {
        this.f4942c = f2;
        this.f4943d = f3;
        this.f4944e = f4;
        this.f4945f = f5;
    }

    @Override // com.bumptech.glide.load.p125r.p126d.AbstractC1730h
    /* renamed from: a */
    protected Bitmap mo4310a(@NonNull InterfaceC1626e interfaceC1626e, @NonNull Bitmap bitmap, int i2, int i3) {
        return C1729g0.m4320a(interfaceC1626e, bitmap, this.f4942c, this.f4943d, this.f4944e, this.f4945f);
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    public boolean equals(Object obj) {
        if (!(obj instanceof C1747v)) {
            return false;
        }
        C1747v c1747v = (C1747v) obj;
        return this.f4942c == c1747v.f4942c && this.f4943d == c1747v.f4943d && this.f4944e == c1747v.f4944e && this.f4945f == c1747v.f4945f;
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    public int hashCode() {
        return C1878l.m4991a(this.f4945f, C1878l.m4991a(this.f4944e, C1878l.m4991a(this.f4943d, C1878l.m4992a(f4940g.hashCode(), C1878l.m4990a(this.f4942c)))));
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    /* renamed from: a */
    public void mo3827a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f4941h);
        messageDigest.update(ByteBuffer.allocate(16).putFloat(this.f4942c).putFloat(this.f4943d).putFloat(this.f4944e).putFloat(this.f4945f).array());
    }
}
