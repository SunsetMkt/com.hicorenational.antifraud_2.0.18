package com.bumptech.glide.load.resource.gif;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.p.r;

/* JADX INFO: compiled from: GifDrawableResource.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends com.bumptech.glide.load.r.f.b<GifDrawable> implements r {
    public d(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    @Override // com.bumptech.glide.load.p.v
    public int a() {
        return ((GifDrawable) this.a).g();
    }

    @Override // com.bumptech.glide.load.p.v
    @NonNull
    public Class<GifDrawable> b() {
        return GifDrawable.class;
    }

    @Override // com.bumptech.glide.load.r.f.b, com.bumptech.glide.load.p.r
    public void initialize() {
        ((GifDrawable) this.a).c().prepareToDraw();
    }

    @Override // com.bumptech.glide.load.p.v
    public void recycle() {
        ((GifDrawable) this.a).stop();
        ((GifDrawable) this.a).i();
    }
}
