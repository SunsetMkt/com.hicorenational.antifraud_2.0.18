package com.bumptech.glide.load.p.a0;

/* JADX INFO: compiled from: IntegerArrayAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class i implements a<int[]> {
    private static final String a = "IntegerArrayPool";

    @Override // com.bumptech.glide.load.p.a0.a
    public int a() {
        return 4;
    }

    @Override // com.bumptech.glide.load.p.a0.a
    public String getTag() {
        return a;
    }

    @Override // com.bumptech.glide.load.p.a0.a
    public int a(int[] iArr) {
        return iArr.length;
    }

    @Override // com.bumptech.glide.load.p.a0.a
    public int[] newArray(int i2) {
        return new int[i2];
    }
}
