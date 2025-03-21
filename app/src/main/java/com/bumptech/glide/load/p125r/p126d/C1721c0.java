package com.bumptech.glide.load.p125r.p126d;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.InterfaceC1598l;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e;
import com.bumptech.glide.load.p125r.p128f.C1758e;

/* compiled from: ResourceBitmapDecoder.java */
/* renamed from: com.bumptech.glide.load.r.d.c0 */
/* loaded from: classes.dex */
public class C1721c0 implements InterfaceC1598l<Uri, Bitmap> {

    /* renamed from: a */
    private final C1758e f4824a;

    /* renamed from: b */
    private final InterfaceC1626e f4825b;

    public C1721c0(C1758e c1758e, InterfaceC1626e interfaceC1626e) {
        this.f4824a = c1758e;
        this.f4825b = interfaceC1626e;
    }

    @Override // com.bumptech.glide.load.InterfaceC1598l
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo3843a(@NonNull Uri uri, @NonNull C1596j c1596j) {
        return "android.resource".equals(uri.getScheme());
    }

    @Override // com.bumptech.glide.load.InterfaceC1598l
    @Nullable
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC1677v<Bitmap> mo3842a(@NonNull Uri uri, int i2, int i3, @NonNull C1596j c1596j) {
        InterfaceC1677v<Drawable> mo3842a = this.f4824a.mo3842a(uri, i2, i3, c1596j);
        if (mo3842a == null) {
            return null;
        }
        return C1743r.m4397a(this.f4825b, mo3842a.get(), i2, i3);
    }
}
