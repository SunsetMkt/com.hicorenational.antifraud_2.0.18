package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.InterfaceC1598l;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e;
import com.bumptech.glide.load.p125r.p126d.C1728g;
import com.bumptech.glide.p134o.InterfaceC1804a;

/* compiled from: GifFrameResourceDecoder.java */
/* renamed from: com.bumptech.glide.load.resource.gif.g */
/* loaded from: classes.dex */
public final class C1776g implements InterfaceC1598l<InterfaceC1804a, Bitmap> {

    /* renamed from: a */
    private final InterfaceC1626e f5044a;

    public C1776g(InterfaceC1626e interfaceC1626e) {
        this.f5044a = interfaceC1626e;
    }

    @Override // com.bumptech.glide.load.InterfaceC1598l
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo3843a(@NonNull InterfaceC1804a interfaceC1804a, @NonNull C1596j c1596j) {
        return true;
    }

    @Override // com.bumptech.glide.load.InterfaceC1598l
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC1677v<Bitmap> mo3842a(@NonNull InterfaceC1804a interfaceC1804a, int i2, int i3, @NonNull C1596j c1596j) {
        return C1728g.m4315a(interfaceC1804a.mo4636a(), this.f5044a);
    }
}
