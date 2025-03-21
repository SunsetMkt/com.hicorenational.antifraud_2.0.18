package com.bumptech.glide.load.p125r.p126d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.ComponentCallbacks2C1576b;
import com.bumptech.glide.load.InterfaceC1600n;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e;
import java.security.MessageDigest;

/* compiled from: DrawableTransformation.java */
/* renamed from: com.bumptech.glide.load.r.d.s */
/* loaded from: classes.dex */
public class C1744s implements InterfaceC1600n<Drawable> {

    /* renamed from: c */
    private final InterfaceC1600n<Bitmap> f4936c;

    /* renamed from: d */
    private final boolean f4937d;

    public C1744s(InterfaceC1600n<Bitmap> interfaceC1600n, boolean z) {
        this.f4936c = interfaceC1600n;
        this.f4937d = z;
    }

    /* renamed from: a */
    public InterfaceC1600n<BitmapDrawable> m4400a() {
        return this;
    }

    @Override // com.bumptech.glide.load.InterfaceC1600n
    @NonNull
    /* renamed from: a */
    public InterfaceC1677v<Drawable> mo3828a(@NonNull Context context, @NonNull InterfaceC1677v<Drawable> interfaceC1677v, int i2, int i3) {
        InterfaceC1626e m3660d = ComponentCallbacks2C1576b.m3633a(context).m3660d();
        Drawable drawable = interfaceC1677v.get();
        InterfaceC1677v<Bitmap> m4397a = C1743r.m4397a(m3660d, drawable, i2, i3);
        if (m4397a != null) {
            InterfaceC1677v<Bitmap> mo3828a = this.f4936c.mo3828a(context, m4397a, i2, i3);
            if (!mo3828a.equals(m4397a)) {
                return m4399a(context, mo3828a);
            }
            mo3828a.recycle();
            return interfaceC1677v;
        }
        if (!this.f4937d) {
            return interfaceC1677v;
        }
        throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    public boolean equals(Object obj) {
        if (obj instanceof C1744s) {
            return this.f4936c.equals(((C1744s) obj).f4936c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    public int hashCode() {
        return this.f4936c.hashCode();
    }

    /* renamed from: a */
    private InterfaceC1677v<Drawable> m4399a(Context context, InterfaceC1677v<Bitmap> interfaceC1677v) {
        return C1751z.m4410a(context.getResources(), interfaceC1677v);
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    /* renamed from: a */
    public void mo3827a(@NonNull MessageDigest messageDigest) {
        this.f4936c.mo3827a(messageDigest);
    }
}
