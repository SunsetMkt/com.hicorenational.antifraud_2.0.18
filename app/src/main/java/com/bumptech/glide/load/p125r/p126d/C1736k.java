package com.bumptech.glide.load.p125r.p126d;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.InterfaceC1598l;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferBitmapImageDecoderResourceDecoder.java */
@RequiresApi(api = 28)
/* renamed from: com.bumptech.glide.load.r.d.k */
/* loaded from: classes.dex */
public final class C1736k implements InterfaceC1598l<ByteBuffer, Bitmap> {

    /* renamed from: a */
    private final C1726f f4873a = new C1726f();

    @Override // com.bumptech.glide.load.InterfaceC1598l
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo3843a(@NonNull ByteBuffer byteBuffer, @NonNull C1596j c1596j) throws IOException {
        return true;
    }

    @Override // com.bumptech.glide.load.InterfaceC1598l
    @Nullable
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC1677v<Bitmap> mo3842a(@NonNull ByteBuffer byteBuffer, int i2, int i3, @NonNull C1596j c1596j) throws IOException {
        return this.f4873a.mo3842a(ImageDecoder.createSource(byteBuffer), i2, i3, c1596j);
    }
}
