package com.umeng.analytics.pro;

/* compiled from: TTransport.java */
/* renamed from: com.umeng.analytics.pro.dd */
/* loaded from: classes2.dex */
public abstract class AbstractC3401dd {
    /* renamed from: a */
    public abstract int mo11189a(byte[] bArr, int i2, int i3) throws C3402de;

    /* renamed from: a */
    public void mo11195a(int i2) {
    }

    /* renamed from: a */
    public abstract boolean mo11190a();

    /* renamed from: b */
    public abstract void mo11191b() throws C3402de;

    /* renamed from: b */
    public void m11202b(byte[] bArr) throws C3402de {
        mo11192b(bArr, 0, bArr.length);
    }

    /* renamed from: b */
    public abstract void mo11192b(byte[] bArr, int i2, int i3) throws C3402de;

    /* renamed from: c */
    public abstract void mo11193c();

    /* renamed from: d */
    public int m11203d(byte[] bArr, int i2, int i3) throws C3402de {
        int i4 = 0;
        while (i4 < i3) {
            int mo11189a = mo11189a(bArr, i2 + i4, i3 - i4);
            if (mo11189a <= 0) {
                throw new C3402de("Cannot read. Remote side has closed. Tried to read " + i3 + " bytes, but only got " + i4 + " bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)");
            }
            i4 += mo11189a;
        }
        return i4;
    }

    /* renamed from: d */
    public void mo11194d() throws C3402de {
    }

    /* renamed from: f */
    public byte[] mo11199f() {
        return null;
    }

    /* renamed from: g */
    public int mo11200g() {
        return 0;
    }

    /* renamed from: h */
    public int mo11201h() {
        return -1;
    }

    /* renamed from: i */
    public boolean m11204i() {
        return mo11190a();
    }
}
