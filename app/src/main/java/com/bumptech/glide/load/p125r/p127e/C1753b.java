package com.bumptech.glide.load.p125r.p127e;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import com.bumptech.glide.util.C1876j;

/* compiled from: BytesResource.java */
/* renamed from: com.bumptech.glide.load.r.e.b */
/* loaded from: classes.dex */
public class C1753b implements InterfaceC1677v<byte[]> {

    /* renamed from: a */
    private final byte[] f4968a;

    public C1753b(byte[] bArr) {
        this.f4968a = (byte[]) C1876j.m4985a(bArr);
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    /* renamed from: a */
    public int mo4183a() {
        return this.f4968a.length;
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    @NonNull
    /* renamed from: b */
    public Class<byte[]> mo4184b() {
        return byte[].class;
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    public void recycle() {
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    @NonNull
    public byte[] get() {
        return this.f4968a;
    }
}
