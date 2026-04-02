package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: ResourceBitmapDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class c0 implements com.bumptech.glide.load.l<Uri, Bitmap> {
    private final com.bumptech.glide.load.r.f.e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.p.a0.e f3145b;

    public c0(com.bumptech.glide.load.r.f.e eVar, com.bumptech.glide.load.p.a0.e eVar2) {
        this.a = eVar;
        this.f3145b = eVar2;
    }

    @Override // com.bumptech.glide.load.l
    public boolean a(@NonNull Uri uri, @NonNull com.bumptech.glide.load.j jVar) {
        return "android.resource".equals(uri.getScheme());
    }

    @Override // com.bumptech.glide.load.l
    @Nullable
    public com.bumptech.glide.load.p.v<Bitmap> a(@NonNull Uri uri, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) {
        com.bumptech.glide.load.p.v<Drawable> vVarA = this.a.a(uri, i2, i3, jVar);
        if (vVarA == null) {
            return null;
        }
        return r.a(this.f3145b, vVarA.get(), i2, i3);
    }
}
