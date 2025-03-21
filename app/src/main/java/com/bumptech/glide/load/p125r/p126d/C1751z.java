package com.bumptech.glide.load.p125r.p126d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.ComponentCallbacks2C1576b;
import com.bumptech.glide.load.p118p.InterfaceC1673r;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e;
import com.bumptech.glide.util.C1876j;

/* compiled from: LazyBitmapDrawableResource.java */
/* renamed from: com.bumptech.glide.load.r.d.z */
/* loaded from: classes.dex */
public final class C1751z implements InterfaceC1677v<BitmapDrawable>, InterfaceC1673r {

    /* renamed from: a */
    private final Resources f4965a;

    /* renamed from: b */
    private final InterfaceC1677v<Bitmap> f4966b;

    private C1751z(@NonNull Resources resources, @NonNull InterfaceC1677v<Bitmap> interfaceC1677v) {
        this.f4965a = (Resources) C1876j.m4985a(resources);
        this.f4966b = (InterfaceC1677v) C1876j.m4985a(interfaceC1677v);
    }

    @Deprecated
    /* renamed from: a */
    public static C1751z m4411a(Context context, Bitmap bitmap) {
        return (C1751z) m4410a(context.getResources(), C1728g.m4315a(bitmap, ComponentCallbacks2C1576b.m3633a(context).m3660d()));
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    @NonNull
    /* renamed from: b */
    public Class<BitmapDrawable> mo4184b() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1673r
    /* renamed from: c */
    public void mo4195c() {
        InterfaceC1677v<Bitmap> interfaceC1677v = this.f4966b;
        if (interfaceC1677v instanceof InterfaceC1673r) {
            ((InterfaceC1673r) interfaceC1677v).mo4195c();
        }
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    public void recycle() {
        this.f4966b.recycle();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    @NonNull
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f4965a, this.f4966b.get());
    }

    @Deprecated
    /* renamed from: a */
    public static C1751z m4412a(Resources resources, InterfaceC1626e interfaceC1626e, Bitmap bitmap) {
        return (C1751z) m4410a(resources, C1728g.m4315a(bitmap, interfaceC1626e));
    }

    @Nullable
    /* renamed from: a */
    public static InterfaceC1677v<BitmapDrawable> m4410a(@NonNull Resources resources, @Nullable InterfaceC1677v<Bitmap> interfaceC1677v) {
        if (interfaceC1677v == null) {
            return null;
        }
        return new C1751z(resources, interfaceC1677v);
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    /* renamed from: a */
    public int mo4183a() {
        return this.f4966b.mo4183a();
    }
}
