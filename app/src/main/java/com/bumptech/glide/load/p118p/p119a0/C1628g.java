package com.bumptech.glide.load.p118p.p119a0;

/* compiled from: ByteArrayAdapter.java */
/* renamed from: com.bumptech.glide.load.p.a0.g */
/* loaded from: classes.dex */
public final class C1628g implements InterfaceC1622a<byte[]> {

    /* renamed from: a */
    private static final String f4283a = "ByteArrayPool";

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1622a
    /* renamed from: a */
    public int mo3901a() {
        return 1;
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1622a
    public String getTag() {
        return f4283a;
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1622a
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public int mo3902a(byte[] bArr) {
        return bArr.length;
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1622a
    public byte[] newArray(int i2) {
        return new byte[i2];
    }
}
