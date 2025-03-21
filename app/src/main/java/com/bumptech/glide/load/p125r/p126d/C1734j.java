package com.bumptech.glide.load.p125r.p126d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.InterfaceC1598l;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import com.bumptech.glide.util.C1867a;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferBitmapDecoder.java */
/* renamed from: com.bumptech.glide.load.r.d.j */
/* loaded from: classes.dex */
public class C1734j implements InterfaceC1598l<ByteBuffer, Bitmap> {

    /* renamed from: a */
    private final C1742q f4859a;

    public C1734j(C1742q c1742q) {
        this.f4859a = c1742q;
    }

    @Override // com.bumptech.glide.load.InterfaceC1598l
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo3843a(@NonNull ByteBuffer byteBuffer, @NonNull C1596j c1596j) {
        return this.f4859a.m4396a(byteBuffer);
    }

    @Override // com.bumptech.glide.load.InterfaceC1598l
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC1677v<Bitmap> mo3842a(@NonNull ByteBuffer byteBuffer, int i2, int i3, @NonNull C1596j c1596j) throws IOException {
        return this.f4859a.m4392a(C1867a.m4956c(byteBuffer), i2, i3, c1596j);
    }
}
