package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: InputStreamBitmapImageDecoderResourceDecoder.java */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 28)
public final class y implements com.bumptech.glide.load.l<InputStream, Bitmap> {
    private final f a = new f();

    @Override // com.bumptech.glide.load.l
    public boolean a(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.j jVar) throws IOException {
        return true;
    }

    @Override // com.bumptech.glide.load.l
    @Nullable
    public com.bumptech.glide.load.p.v<Bitmap> a(@NonNull InputStream inputStream, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) throws IOException {
        return this.a.a(ImageDecoder.createSource(com.bumptech.glide.util.a.a(inputStream)), i2, i3, jVar);
    }
}
