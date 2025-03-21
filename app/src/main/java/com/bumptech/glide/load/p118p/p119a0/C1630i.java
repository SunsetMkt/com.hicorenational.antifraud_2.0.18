package com.bumptech.glide.load.p118p.p119a0;

/* compiled from: IntegerArrayAdapter.java */
/* renamed from: com.bumptech.glide.load.p.a0.i */
/* loaded from: classes.dex */
public final class C1630i implements InterfaceC1622a<int[]> {

    /* renamed from: a */
    private static final String f4290a = "IntegerArrayPool";

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1622a
    /* renamed from: a */
    public int mo3901a() {
        return 4;
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1622a
    public String getTag() {
        return f4290a;
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1622a
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public int mo3902a(int[] iArr) {
        return iArr.length;
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1622a
    public int[] newArray(int i2) {
        return new int[i2];
    }
}
