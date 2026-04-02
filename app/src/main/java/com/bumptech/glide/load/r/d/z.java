package com.bumptech.glide.load.r.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: LazyBitmapDrawableResource.java */
/* JADX INFO: loaded from: classes.dex */
public final class z implements com.bumptech.glide.load.p.v<BitmapDrawable>, com.bumptech.glide.load.p.r {
    private final Resources a;

    /* JADX INFO: renamed from: b */
    private final com.bumptech.glide.load.p.v<Bitmap> f3247b;

    private z(@NonNull Resources resources, @NonNull com.bumptech.glide.load.p.v<Bitmap> vVar) {
        this.a = (Resources) com.bumptech.glide.util.j.a(resources);
        this.f3247b = (com.bumptech.glide.load.p.v) com.bumptech.glide.util.j.a(vVar);
    }

    @Deprecated
    public static z a(Context context, Bitmap bitmap) {
        return (z) a(context.getResources(), g.a(bitmap, com.bumptech.glide.b.a(context).d()));
    }

    @Override // com.bumptech.glide.load.p.v
    @NonNull
    public Class<BitmapDrawable> b() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.p.r
    public void initialize() {
        com.bumptech.glide.load.p.v<Bitmap> vVar = this.f3247b;
        if (vVar instanceof com.bumptech.glide.load.p.r) {
            ((com.bumptech.glide.load.p.r) vVar).initialize();
        }
    }

    @Override // com.bumptech.glide.load.p.v
    public void recycle() {
        this.f3247b.recycle();
    }

    @Override // com.bumptech.glide.load.p.v
    @NonNull
    public BitmapDrawable get() {
        return new BitmapDrawable(this.a, this.f3247b.get());
    }

    @Deprecated
    public static z a(Resources resources, com.bumptech.glide.load.p.a0.e eVar, Bitmap bitmap) {
        return (z) a(resources, g.a(bitmap, eVar));
    }

    @Nullable
    public static com.bumptech.glide.load.p.v<BitmapDrawable> a(@NonNull Resources resources, @Nullable com.bumptech.glide.load.p.v<Bitmap> vVar) {
        if (vVar == null) {
            return null;
        }
        return new z(resources, vVar);
    }

    @Override // com.bumptech.glide.load.p.v
    public int a() {
        return this.f3247b.a();
    }
}
