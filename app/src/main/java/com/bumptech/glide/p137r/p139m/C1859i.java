package com.bumptech.glide.p137r.p139m;

import com.bumptech.glide.load.EnumC1587a;
import com.bumptech.glide.p137r.p139m.C1860j;

/* compiled from: ViewPropertyAnimationFactory.java */
/* renamed from: com.bumptech.glide.r.m.i */
/* loaded from: classes.dex */
public class C1859i<R> implements InterfaceC1857g<R> {

    /* renamed from: a */
    private final C1860j.a f5452a;

    /* renamed from: b */
    private C1860j<R> f5453b;

    public C1859i(C1860j.a aVar) {
        this.f5452a = aVar;
    }

    @Override // com.bumptech.glide.p137r.p139m.InterfaceC1857g
    /* renamed from: a */
    public InterfaceC1856f<R> mo4934a(EnumC1587a enumC1587a, boolean z) {
        if (enumC1587a == EnumC1587a.MEMORY_CACHE || !z) {
            return C1855e.m4939a();
        }
        if (this.f5453b == null) {
            this.f5453b = new C1860j<>(this.f5452a);
        }
        return this.f5453b;
    }
}
