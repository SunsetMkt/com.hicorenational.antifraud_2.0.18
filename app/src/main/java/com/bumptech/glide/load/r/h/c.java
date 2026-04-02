package com.bumptech.glide.load.r.h;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.p.v;
import com.bumptech.glide.load.resource.gif.GifDrawable;

/* JADX INFO: compiled from: DrawableBytesTranscoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements e<Drawable, byte[]> {
    private final com.bumptech.glide.load.p.a0.e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e<Bitmap, byte[]> f3256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e<GifDrawable, byte[]> f3257c;

    public c(@NonNull com.bumptech.glide.load.p.a0.e eVar, @NonNull e<Bitmap, byte[]> eVar2, @NonNull e<GifDrawable, byte[]> eVar3) {
        this.a = eVar;
        this.f3256b = eVar2;
        this.f3257c = eVar3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    private static v<GifDrawable> a(@NonNull v<Drawable> vVar) {
        return vVar;
    }

    @Override // com.bumptech.glide.load.r.h.e
    @Nullable
    public v<byte[]> a(@NonNull v<Drawable> vVar, @NonNull j jVar) {
        Drawable drawable = vVar.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f3256b.a(com.bumptech.glide.load.r.d.g.a(((BitmapDrawable) drawable).getBitmap(), this.a), jVar);
        }
        if (drawable instanceof GifDrawable) {
            return this.f3257c.a(a(vVar), jVar);
        }
        return null;
    }
}
