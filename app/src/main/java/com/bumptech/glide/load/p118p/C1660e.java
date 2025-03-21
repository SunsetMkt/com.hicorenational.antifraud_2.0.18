package com.bumptech.glide.load.p118p;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.InterfaceC1590d;
import com.bumptech.glide.load.p118p.p120b0.InterfaceC1639a;
import java.io.File;

/* compiled from: DataCacheWriter.java */
/* renamed from: com.bumptech.glide.load.p.e */
/* loaded from: classes.dex */
class C1660e<DataType> implements InterfaceC1639a.b {

    /* renamed from: a */
    private final InterfaceC1590d<DataType> f4465a;

    /* renamed from: b */
    private final DataType f4466b;

    /* renamed from: c */
    private final C1596j f4467c;

    C1660e(InterfaceC1590d<DataType> interfaceC1590d, DataType datatype, C1596j c1596j) {
        this.f4465a = interfaceC1590d;
        this.f4466b = datatype;
        this.f4467c = c1596j;
    }

    @Override // com.bumptech.glide.load.p118p.p120b0.InterfaceC1639a.b
    /* renamed from: a */
    public boolean mo3983a(@NonNull File file) {
        return this.f4465a.mo3817a(this.f4466b, file, this.f4467c);
    }
}
