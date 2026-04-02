package com.bumptech.glide.load.r.d;

import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: BitmapDrawableResource.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends com.bumptech.glide.load.r.f.b<BitmapDrawable> implements com.bumptech.glide.load.p.r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.p.a0.e f3144b;

    public c(BitmapDrawable bitmapDrawable, com.bumptech.glide.load.p.a0.e eVar) {
        super(bitmapDrawable);
        this.f3144b = eVar;
    }

    @Override // com.bumptech.glide.load.p.v
    public int a() {
        return com.bumptech.glide.util.l.a(((BitmapDrawable) this.a).getBitmap());
    }

    @Override // com.bumptech.glide.load.p.v
    @NonNull
    public Class<BitmapDrawable> b() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.r.f.b, com.bumptech.glide.load.p.r
    public void initialize() {
        ((BitmapDrawable) this.a).getBitmap().prepareToDraw();
    }

    @Override // com.bumptech.glide.load.p.v
    public void recycle() {
        this.f3144b.a(((BitmapDrawable) this.a).getBitmap());
    }
}
