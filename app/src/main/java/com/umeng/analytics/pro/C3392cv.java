package com.umeng.analytics.pro;

import java.util.BitSet;

/* compiled from: TTupleProtocol.java */
/* renamed from: com.umeng.analytics.pro.cv */
/* loaded from: classes2.dex */
public final class C3392cv extends C3380cj {

    /* compiled from: TTupleProtocol.java */
    /* renamed from: com.umeng.analytics.pro.cv$a */
    public static class a implements InterfaceC3388cr {
        @Override // com.umeng.analytics.pro.InterfaceC3388cr
        /* renamed from: a */
        public AbstractC3386cp mo11154a(AbstractC3401dd abstractC3401dd) {
            return new C3392cv(abstractC3401dd);
        }
    }

    public C3392cv(AbstractC3401dd abstractC3401dd) {
        super(abstractC3401dd);
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: D */
    public Class<? extends InterfaceC3394cx> mo11179D() {
        return AbstractC3398da.class;
    }

    /* renamed from: a */
    public void m11187a(BitSet bitSet, int i2) throws C3366bw {
        for (byte b2 : m11186b(bitSet, i2)) {
            mo11112a(b2);
        }
    }

    /* renamed from: b */
    public BitSet m11188b(int i2) throws C3366bw {
        int ceil = (int) Math.ceil(i2 / 8.0d);
        byte[] bArr = new byte[ceil];
        for (int i3 = 0; i3 < ceil; i3++) {
            bArr[i3] = mo11148u();
        }
        return m11185a(bArr);
    }

    /* renamed from: a */
    public static BitSet m11185a(byte[] bArr) {
        BitSet bitSet = new BitSet();
        for (int i2 = 0; i2 < bArr.length * 8; i2++) {
            if ((bArr[(bArr.length - (i2 / 8)) - 1] & (1 << (i2 % 8))) > 0) {
                bitSet.set(i2);
            }
        }
        return bitSet;
    }

    /* renamed from: b */
    public static byte[] m11186b(BitSet bitSet, int i2) {
        byte[] bArr = new byte[(int) Math.ceil(i2 / 8.0d)];
        for (int i3 = 0; i3 < bitSet.length(); i3++) {
            if (bitSet.get(i3)) {
                int length = (bArr.length - (i3 / 8)) - 1;
                bArr[length] = (byte) ((1 << (i3 % 8)) | bArr[length]);
            }
        }
        return bArr;
    }
}
