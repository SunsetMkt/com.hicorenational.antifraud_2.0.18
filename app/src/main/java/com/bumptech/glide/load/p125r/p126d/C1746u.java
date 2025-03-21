package com.bumptech.glide.load.p125r.p126d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.InterfaceC1593g;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e;
import java.security.MessageDigest;

/* compiled from: FitCenter.java */
/* renamed from: com.bumptech.glide.load.r.d.u */
/* loaded from: classes.dex */
public class C1746u extends AbstractC1730h {

    /* renamed from: c */
    private static final String f4938c = "com.bumptech.glide.load.resource.bitmap.FitCenter";

    /* renamed from: d */
    private static final byte[] f4939d = f4938c.getBytes(InterfaceC1593g.f4191b);

    @Override // com.bumptech.glide.load.p125r.p126d.AbstractC1730h
    /* renamed from: a */
    protected Bitmap mo4310a(@NonNull InterfaceC1626e interfaceC1626e, @NonNull Bitmap bitmap, int i2, int i3) {
        return C1729g0.m4335d(interfaceC1626e, bitmap, i2, i3);
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    public boolean equals(Object obj) {
        return obj instanceof C1746u;
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    public int hashCode() {
        return f4938c.hashCode();
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    /* renamed from: a */
    public void mo3827a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f4939d);
    }
}
