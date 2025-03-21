package com.bumptech.glide.p137r.p139m;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.EnumC1587a;
import com.bumptech.glide.p137r.p139m.InterfaceC1856f;

/* compiled from: BitmapContainerTransitionFactory.java */
/* renamed from: com.bumptech.glide.r.m.a */
/* loaded from: classes.dex */
public abstract class AbstractC1851a<R> implements InterfaceC1857g<R> {

    /* renamed from: a */
    private final InterfaceC1857g<Drawable> f5435a;

    /* compiled from: BitmapContainerTransitionFactory.java */
    /* renamed from: com.bumptech.glide.r.m.a$a */
    private final class a implements InterfaceC1856f<R> {

        /* renamed from: a */
        private final InterfaceC1856f<Drawable> f5436a;

        a(InterfaceC1856f<Drawable> interfaceC1856f) {
            this.f5436a = interfaceC1856f;
        }

        @Override // com.bumptech.glide.p137r.p139m.InterfaceC1856f
        /* renamed from: a */
        public boolean mo4935a(R r, InterfaceC1856f.a aVar) {
            return this.f5436a.mo4935a(new BitmapDrawable(aVar.getView().getResources(), AbstractC1851a.this.mo4933a(r)), aVar);
        }
    }

    public AbstractC1851a(InterfaceC1857g<Drawable> interfaceC1857g) {
        this.f5435a = interfaceC1857g;
    }

    /* renamed from: a */
    protected abstract Bitmap mo4933a(R r);

    @Override // com.bumptech.glide.p137r.p139m.InterfaceC1857g
    /* renamed from: a */
    public InterfaceC1856f<R> mo4934a(EnumC1587a enumC1587a, boolean z) {
        return new a(this.f5435a.mo4934a(enumC1587a, z));
    }
}
