package com.bumptech.glide.load.p125r;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import com.bumptech.glide.util.C1876j;

/* compiled from: SimpleResource.java */
/* renamed from: com.bumptech.glide.load.r.b */
/* loaded from: classes.dex */
public class C1714b<T> implements InterfaceC1677v<T> {

    /* renamed from: a */
    protected final T f4810a;

    public C1714b(@NonNull T t) {
        this.f4810a = (T) C1876j.m4985a(t);
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    /* renamed from: a */
    public final int mo4183a() {
        return 1;
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    @NonNull
    /* renamed from: b */
    public Class<T> mo4184b() {
        return (Class<T>) this.f4810a.getClass();
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    @NonNull
    public final T get() {
        return this.f4810a;
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    public void recycle() {
    }
}
