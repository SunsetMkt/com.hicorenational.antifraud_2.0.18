package com.bumptech.glide.load.p.a0;

/* JADX INFO: compiled from: ByteArrayAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class g implements a<byte[]> {
    private static final String a = "ByteArrayPool";

    @Override // com.bumptech.glide.load.p.a0.a
    public int a() {
        return 1;
    }

    @Override // com.bumptech.glide.load.p.a0.a
    public String getTag() {
        return a;
    }

    @Override // com.bumptech.glide.load.p.a0.a
    public int a(byte[] bArr) {
        return bArr.length;
    }

    @Override // com.bumptech.glide.load.p.a0.a
    public byte[] newArray(int i2) {
        return new byte[i2];
    }
}
