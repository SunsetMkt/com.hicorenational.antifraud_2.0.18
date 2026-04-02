package com.bumptech.glide.load.r.h;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.p.v;
import com.bumptech.glide.load.r.d.z;

/* JADX INFO: compiled from: BitmapDrawableTranscoder.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements e<Bitmap, BitmapDrawable> {
    private final Resources a;

    public b(@NonNull Context context) {
        this(context.getResources());
    }

    @Override // com.bumptech.glide.load.r.h.e
    @Nullable
    public v<BitmapDrawable> a(@NonNull v<Bitmap> vVar, @NonNull j jVar) {
        return z.a(this.a, vVar);
    }

    @Deprecated
    public b(@NonNull Resources resources, com.bumptech.glide.load.p.a0.e eVar) {
        this(resources);
    }

    public b(@NonNull Resources resources) {
        this.a = (Resources) com.bumptech.glide.util.j.a(resources);
    }
}
