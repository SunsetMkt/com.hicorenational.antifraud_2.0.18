package com.bumptech.glide.load.r.h;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.p.v;
import java.io.ByteArrayOutputStream;

/* JADX INFO: compiled from: BitmapBytesTranscoder.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements e<Bitmap, byte[]> {
    private final Bitmap.CompressFormat a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3255b;

    public a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Override // com.bumptech.glide.load.r.h.e
    @Nullable
    public v<byte[]> a(@NonNull v<Bitmap> vVar, @NonNull j jVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        vVar.get().compress(this.a, this.f3255b, byteArrayOutputStream);
        vVar.recycle();
        return new com.bumptech.glide.load.r.e.b(byteArrayOutputStream.toByteArray());
    }

    public a(@NonNull Bitmap.CompressFormat compressFormat, int i2) {
        this.a = compressFormat;
        this.f3255b = i2;
    }
}
