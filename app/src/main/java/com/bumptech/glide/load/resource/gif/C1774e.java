package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.ComponentCallbacks2C1576b;
import com.bumptech.glide.load.InterfaceC1600n;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import com.bumptech.glide.load.p125r.p126d.C1728g;
import com.bumptech.glide.util.C1876j;
import java.security.MessageDigest;

/* compiled from: GifDrawableTransformation.java */
/* renamed from: com.bumptech.glide.load.resource.gif.e */
/* loaded from: classes.dex */
public class C1774e implements InterfaceC1600n<GifDrawable> {

    /* renamed from: c */
    private final InterfaceC1600n<Bitmap> f5017c;

    public C1774e(InterfaceC1600n<Bitmap> interfaceC1600n) {
        this.f5017c = (InterfaceC1600n) C1876j.m4985a(interfaceC1600n);
    }

    @Override // com.bumptech.glide.load.InterfaceC1600n
    @NonNull
    /* renamed from: a */
    public InterfaceC1677v<GifDrawable> mo3828a(@NonNull Context context, @NonNull InterfaceC1677v<GifDrawable> interfaceC1677v, int i2, int i3) {
        GifDrawable gifDrawable = interfaceC1677v.get();
        InterfaceC1677v<Bitmap> c1728g = new C1728g(gifDrawable.m4451c(), ComponentCallbacks2C1576b.m3633a(context).m3660d());
        InterfaceC1677v<Bitmap> mo3828a = this.f5017c.mo3828a(context, c1728g, i2, i3);
        if (!c1728g.equals(mo3828a)) {
            c1728g.recycle();
        }
        gifDrawable.m4448a(this.f5017c, mo3828a.get());
        return interfaceC1677v;
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    public boolean equals(Object obj) {
        if (obj instanceof C1774e) {
            return this.f5017c.equals(((C1774e) obj).f5017c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    public int hashCode() {
        return this.f5017c.hashCode();
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    /* renamed from: a */
    public void mo3827a(@NonNull MessageDigest messageDigest) {
        this.f5017c.mo3827a(messageDigest);
    }
}
