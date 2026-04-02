package com.bumptech.glide.load.r.e;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.p.v;
import com.bumptech.glide.util.j;

/* JADX INFO: compiled from: BytesResource.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements v<byte[]> {
    private final byte[] a;

    public b(byte[] bArr) {
        this.a = (byte[]) j.a(bArr);
    }

    @Override // com.bumptech.glide.load.p.v
    public int a() {
        return this.a.length;
    }

    @Override // com.bumptech.glide.load.p.v
    @NonNull
    public Class<byte[]> b() {
        return byte[].class;
    }

    @Override // com.bumptech.glide.load.p.v
    public void recycle() {
    }

    @Override // com.bumptech.glide.load.p.v
    @NonNull
    public byte[] get() {
        return this.a;
    }
}
