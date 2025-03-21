package com.bumptech.glide.load.p125r.p126d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.p118p.InterfaceC1673r;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e;
import com.bumptech.glide.util.C1876j;
import com.bumptech.glide.util.C1878l;

/* compiled from: BitmapResource.java */
/* renamed from: com.bumptech.glide.load.r.d.g */
/* loaded from: classes.dex */
public class C1728g implements InterfaceC1677v<Bitmap>, InterfaceC1673r {

    /* renamed from: a */
    private final Bitmap f4843a;

    /* renamed from: b */
    private final InterfaceC1626e f4844b;

    public C1728g(@NonNull Bitmap bitmap, @NonNull InterfaceC1626e interfaceC1626e) {
        this.f4843a = (Bitmap) C1876j.m4986a(bitmap, "Bitmap must not be null");
        this.f4844b = (InterfaceC1626e) C1876j.m4986a(interfaceC1626e, "BitmapPool must not be null");
    }

    @Nullable
    /* renamed from: a */
    public static C1728g m4315a(@Nullable Bitmap bitmap, @NonNull InterfaceC1626e interfaceC1626e) {
        if (bitmap == null) {
            return null;
        }
        return new C1728g(bitmap, interfaceC1626e);
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    @NonNull
    /* renamed from: b */
    public Class<Bitmap> mo4184b() {
        return Bitmap.class;
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1673r
    /* renamed from: c */
    public void mo4195c() {
        this.f4843a.prepareToDraw();
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    public void recycle() {
        this.f4844b.mo3924a(this.f4843a);
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    /* renamed from: a */
    public int mo4183a() {
        return C1878l.m4995a(this.f4843a);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    @NonNull
    public Bitmap get() {
        return this.f4843a;
    }
}
