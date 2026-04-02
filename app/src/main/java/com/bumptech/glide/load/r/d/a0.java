package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;

/* JADX INFO: compiled from: ParcelFileDescriptorBitmapDecoder.java */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class a0 implements com.bumptech.glide.load.l<ParcelFileDescriptor, Bitmap> {
    private final q a;

    public a0(q qVar) {
        this.a = qVar;
    }

    @Override // com.bumptech.glide.load.l
    public boolean a(@NonNull ParcelFileDescriptor parcelFileDescriptor, @NonNull com.bumptech.glide.load.j jVar) {
        return this.a.a(parcelFileDescriptor);
    }

    @Override // com.bumptech.glide.load.l
    @Nullable
    public com.bumptech.glide.load.p.v<Bitmap> a(@NonNull ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) throws IOException {
        return this.a.a(parcelFileDescriptor, i2, i3, jVar);
    }
}
