package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.l;
import com.bumptech.glide.load.p.v;

/* JADX INFO: compiled from: GifFrameResourceDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class g implements l<com.bumptech.glide.o.a, Bitmap> {
    private final com.bumptech.glide.load.p.a0.e a;

    public g(com.bumptech.glide.load.p.a0.e eVar) {
        this.a = eVar;
    }

    @Override // com.bumptech.glide.load.l
    public boolean a(@NonNull com.bumptech.glide.o.a aVar, @NonNull j jVar) {
        return true;
    }

    @Override // com.bumptech.glide.load.l
    public v<Bitmap> a(@NonNull com.bumptech.glide.o.a aVar, int i2, int i3, @NonNull j jVar) {
        return com.bumptech.glide.load.r.d.g.a(aVar.a(), this.a);
    }
}
