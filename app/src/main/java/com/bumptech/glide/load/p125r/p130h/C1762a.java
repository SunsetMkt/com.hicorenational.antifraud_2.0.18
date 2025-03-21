package com.bumptech.glide.load.p125r.p130h;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import com.bumptech.glide.load.p125r.p127e.C1753b;
import java.io.ByteArrayOutputStream;

/* compiled from: BitmapBytesTranscoder.java */
/* renamed from: com.bumptech.glide.load.r.h.a */
/* loaded from: classes.dex */
public class C1762a implements InterfaceC1766e<Bitmap, byte[]> {

    /* renamed from: a */
    private final Bitmap.CompressFormat f4979a;

    /* renamed from: b */
    private final int f4980b;

    public C1762a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Override // com.bumptech.glide.load.p125r.p130h.InterfaceC1766e
    @Nullable
    /* renamed from: a */
    public InterfaceC1677v<byte[]> mo4432a(@NonNull InterfaceC1677v<Bitmap> interfaceC1677v, @NonNull C1596j c1596j) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        interfaceC1677v.get().compress(this.f4979a, this.f4980b, byteArrayOutputStream);
        interfaceC1677v.recycle();
        return new C1753b(byteArrayOutputStream.toByteArray());
    }

    public C1762a(@NonNull Bitmap.CompressFormat compressFormat, int i2) {
        this.f4979a = compressFormat;
        this.f4980b = i2;
    }
}
