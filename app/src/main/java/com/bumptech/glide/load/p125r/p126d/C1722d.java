package com.bumptech.glide.load.p125r.p126d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.InterfaceC1600n;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import com.bumptech.glide.util.C1876j;
import java.security.MessageDigest;

/* compiled from: BitmapDrawableTransformation.java */
@Deprecated
/* renamed from: com.bumptech.glide.load.r.d.d */
/* loaded from: classes.dex */
public class C1722d implements InterfaceC1600n<BitmapDrawable> {

    /* renamed from: c */
    private final InterfaceC1600n<Drawable> f4826c;

    public C1722d(InterfaceC1600n<Bitmap> interfaceC1600n) {
        this.f4826c = (InterfaceC1600n) C1876j.m4985a(new C1744s(interfaceC1600n, false));
    }

    /* renamed from: b */
    private static InterfaceC1677v<Drawable> m4309b(InterfaceC1677v<BitmapDrawable> interfaceC1677v) {
        return interfaceC1677v;
    }

    @Override // com.bumptech.glide.load.InterfaceC1600n
    @NonNull
    /* renamed from: a */
    public InterfaceC1677v<BitmapDrawable> mo3828a(@NonNull Context context, @NonNull InterfaceC1677v<BitmapDrawable> interfaceC1677v, int i2, int i3) {
        return m4308a(this.f4826c.mo3828a(context, m4309b(interfaceC1677v), i2, i3));
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    public boolean equals(Object obj) {
        if (obj instanceof C1722d) {
            return this.f4826c.equals(((C1722d) obj).f4826c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    public int hashCode() {
        return this.f4826c.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private static InterfaceC1677v<BitmapDrawable> m4308a(InterfaceC1677v<Drawable> interfaceC1677v) {
        if (interfaceC1677v.get() instanceof BitmapDrawable) {
            return interfaceC1677v;
        }
        throw new IllegalArgumentException("Wrapped transformation unexpectedly returned a non BitmapDrawable resource: " + interfaceC1677v.get());
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    /* renamed from: a */
    public void mo3827a(@NonNull MessageDigest messageDigest) {
        this.f4826c.mo3827a(messageDigest);
    }
}
