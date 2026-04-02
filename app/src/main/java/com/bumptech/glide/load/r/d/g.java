package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: BitmapResource.java */
/* JADX INFO: loaded from: classes.dex */
public class g implements com.bumptech.glide.load.p.v<Bitmap>, com.bumptech.glide.load.p.r {
    private final Bitmap a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.p.a0.e f3160b;

    public g(@NonNull Bitmap bitmap, @NonNull com.bumptech.glide.load.p.a0.e eVar) {
        this.a = (Bitmap) com.bumptech.glide.util.j.a(bitmap, "Bitmap must not be null");
        this.f3160b = (com.bumptech.glide.load.p.a0.e) com.bumptech.glide.util.j.a(eVar, "BitmapPool must not be null");
    }

    @Nullable
    public static g a(@Nullable Bitmap bitmap, @NonNull com.bumptech.glide.load.p.a0.e eVar) {
        if (bitmap == null) {
            return null;
        }
        return new g(bitmap, eVar);
    }

    @Override // com.bumptech.glide.load.p.v
    @NonNull
    public Class<Bitmap> b() {
        return Bitmap.class;
    }

    @Override // com.bumptech.glide.load.p.r
    public void initialize() {
        this.a.prepareToDraw();
    }

    @Override // com.bumptech.glide.load.p.v
    public void recycle() {
        this.f3160b.a(this.a);
    }

    @Override // com.bumptech.glide.load.p.v
    public int a() {
        return com.bumptech.glide.util.l.a(this.a);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.p.v
    @NonNull
    public Bitmap get() {
        return this.a;
    }
}
