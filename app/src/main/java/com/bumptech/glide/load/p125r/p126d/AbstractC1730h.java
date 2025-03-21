package com.bumptech.glide.load.p125r.p126d;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.ComponentCallbacks2C1576b;
import com.bumptech.glide.load.InterfaceC1600n;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e;
import com.bumptech.glide.util.C1878l;

/* compiled from: BitmapTransformation.java */
/* renamed from: com.bumptech.glide.load.r.d.h */
/* loaded from: classes.dex */
public abstract class AbstractC1730h implements InterfaceC1600n<Bitmap> {
    /* renamed from: a */
    protected abstract Bitmap mo4310a(@NonNull InterfaceC1626e interfaceC1626e, @NonNull Bitmap bitmap, int i2, int i3);

    @Override // com.bumptech.glide.load.InterfaceC1600n
    @NonNull
    /* renamed from: a */
    public final InterfaceC1677v<Bitmap> mo3828a(@NonNull Context context, @NonNull InterfaceC1677v<Bitmap> interfaceC1677v, int i2, int i3) {
        if (!C1878l.m5008b(i2, i3)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i2 + " or height: " + i3 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        InterfaceC1626e m3660d = ComponentCallbacks2C1576b.m3633a(context).m3660d();
        Bitmap bitmap = interfaceC1677v.get();
        if (i2 == Integer.MIN_VALUE) {
            i2 = bitmap.getWidth();
        }
        if (i3 == Integer.MIN_VALUE) {
            i3 = bitmap.getHeight();
        }
        Bitmap mo4310a = mo4310a(m3660d, bitmap, i2, i3);
        return bitmap.equals(mo4310a) ? interfaceC1677v : C1728g.m4315a(mo4310a, m3660d);
    }
}
