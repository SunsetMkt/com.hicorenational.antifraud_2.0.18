package com.bumptech.glide.load.p125r.p126d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.InterfaceC1598l;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e;
import com.bumptech.glide.util.C1876j;
import java.io.IOException;

/* compiled from: BitmapDrawableDecoder.java */
/* renamed from: com.bumptech.glide.load.r.d.a */
/* loaded from: classes.dex */
public class C1716a<DataType> implements InterfaceC1598l<DataType, BitmapDrawable> {

    /* renamed from: a */
    private final InterfaceC1598l<DataType, Bitmap> f4812a;

    /* renamed from: b */
    private final Resources f4813b;

    public C1716a(Context context, InterfaceC1598l<DataType, Bitmap> interfaceC1598l) {
        this(context.getResources(), interfaceC1598l);
    }

    @Override // com.bumptech.glide.load.InterfaceC1598l
    /* renamed from: a */
    public boolean mo3843a(@NonNull DataType datatype, @NonNull C1596j c1596j) throws IOException {
        return this.f4812a.mo3843a(datatype, c1596j);
    }

    @Deprecated
    public C1716a(Resources resources, InterfaceC1626e interfaceC1626e, InterfaceC1598l<DataType, Bitmap> interfaceC1598l) {
        this(resources, interfaceC1598l);
    }

    @Override // com.bumptech.glide.load.InterfaceC1598l
    /* renamed from: a */
    public InterfaceC1677v<BitmapDrawable> mo3842a(@NonNull DataType datatype, int i2, int i3, @NonNull C1596j c1596j) throws IOException {
        return C1751z.m4410a(this.f4813b, this.f4812a.mo3842a(datatype, i2, i3, c1596j));
    }

    public C1716a(@NonNull Resources resources, @NonNull InterfaceC1598l<DataType, Bitmap> interfaceC1598l) {
        this.f4813b = (Resources) C1876j.m4985a(resources);
        this.f4812a = (InterfaceC1598l) C1876j.m4985a(interfaceC1598l);
    }
}
