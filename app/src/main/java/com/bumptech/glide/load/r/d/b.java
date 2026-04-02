package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import java.io.File;

/* JADX INFO: compiled from: BitmapDrawableEncoder.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements com.bumptech.glide.load.m<BitmapDrawable> {
    private final com.bumptech.glide.load.p.a0.e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.m<Bitmap> f3138b;

    public b(com.bumptech.glide.load.p.a0.e eVar, com.bumptech.glide.load.m<Bitmap> mVar) {
        this.a = eVar;
        this.f3138b = mVar;
    }

    @Override // com.bumptech.glide.load.d
    public boolean a(@NonNull com.bumptech.glide.load.p.v<BitmapDrawable> vVar, @NonNull File file, @NonNull com.bumptech.glide.load.j jVar) {
        return this.f3138b.a((Bitmap) new g(vVar.get().getBitmap(), this.a), file, jVar);
    }

    @Override // com.bumptech.glide.load.m
    @NonNull
    public com.bumptech.glide.load.c a(@NonNull com.bumptech.glide.load.j jVar) {
        return this.f3138b.a(jVar);
    }
}
