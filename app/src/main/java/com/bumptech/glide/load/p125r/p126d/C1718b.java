package com.bumptech.glide.load.p125r.p126d;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.EnumC1589c;
import com.bumptech.glide.load.InterfaceC1599m;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e;
import java.io.File;

/* compiled from: BitmapDrawableEncoder.java */
/* renamed from: com.bumptech.glide.load.r.d.b */
/* loaded from: classes.dex */
public class C1718b implements InterfaceC1599m<BitmapDrawable> {

    /* renamed from: a */
    private final InterfaceC1626e f4815a;

    /* renamed from: b */
    private final InterfaceC1599m<Bitmap> f4816b;

    public C1718b(InterfaceC1626e interfaceC1626e, InterfaceC1599m<Bitmap> interfaceC1599m) {
        this.f4815a = interfaceC1626e;
        this.f4816b = interfaceC1599m;
    }

    @Override // com.bumptech.glide.load.InterfaceC1590d
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean mo3817a(@NonNull InterfaceC1677v<BitmapDrawable> interfaceC1677v, @NonNull File file, @NonNull C1596j c1596j) {
        return this.f4816b.mo3817a(new C1728g(interfaceC1677v.get().getBitmap(), this.f4815a), file, c1596j);
    }

    @Override // com.bumptech.glide.load.InterfaceC1599m
    @NonNull
    /* renamed from: a */
    public EnumC1589c mo3844a(@NonNull C1596j c1596j) {
        return this.f4816b.mo3844a(c1596j);
    }
}
