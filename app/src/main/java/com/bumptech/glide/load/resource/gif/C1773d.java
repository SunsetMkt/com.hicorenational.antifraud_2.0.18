package com.bumptech.glide.load.resource.gif;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.p118p.InterfaceC1673r;
import com.bumptech.glide.load.p125r.p128f.AbstractC1755b;

/* compiled from: GifDrawableResource.java */
/* renamed from: com.bumptech.glide.load.resource.gif.d */
/* loaded from: classes.dex */
public class C1773d extends AbstractC1755b<GifDrawable> implements InterfaceC1673r {
    public C1773d(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    /* renamed from: a */
    public int mo4183a() {
        return ((GifDrawable) this.f4970a).m4455g();
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    @NonNull
    /* renamed from: b */
    public Class<GifDrawable> mo4184b() {
        return GifDrawable.class;
    }

    @Override // com.bumptech.glide.load.p125r.p128f.AbstractC1755b, com.bumptech.glide.load.p118p.InterfaceC1673r
    /* renamed from: c */
    public void mo4195c() {
        ((GifDrawable) this.f4970a).m4451c().prepareToDraw();
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    public void recycle() {
        ((GifDrawable) this.f4970a).stop();
        ((GifDrawable) this.f4970a).m4457i();
    }
}
