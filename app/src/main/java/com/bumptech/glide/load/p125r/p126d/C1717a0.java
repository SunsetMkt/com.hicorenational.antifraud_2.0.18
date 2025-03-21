package com.bumptech.glide.load.p125r.p126d;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.InterfaceC1598l;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import java.io.IOException;

/* compiled from: ParcelFileDescriptorBitmapDecoder.java */
@RequiresApi(21)
/* renamed from: com.bumptech.glide.load.r.d.a0 */
/* loaded from: classes.dex */
public final class C1717a0 implements InterfaceC1598l<ParcelFileDescriptor, Bitmap> {

    /* renamed from: a */
    private final C1742q f4814a;

    public C1717a0(C1742q c1742q) {
        this.f4814a = c1742q;
    }

    @Override // com.bumptech.glide.load.InterfaceC1598l
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo3843a(@NonNull ParcelFileDescriptor parcelFileDescriptor, @NonNull C1596j c1596j) {
        return this.f4814a.m4394a(parcelFileDescriptor);
    }

    @Override // com.bumptech.glide.load.InterfaceC1598l
    @Nullable
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC1677v<Bitmap> mo3842a(@NonNull ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, @NonNull C1596j c1596j) throws IOException {
        return this.f4814a.m4391a(parcelFileDescriptor, i2, i3, c1596j);
    }
}
