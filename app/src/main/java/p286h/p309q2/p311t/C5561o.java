package p286h.p309q2.p311t;

import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: PrimitiveSpreadBuilders.kt */
/* renamed from: h.q2.t.o */
/* loaded from: classes2.dex */
public final class C5561o extends AbstractC5593y0<byte[]> {

    /* renamed from: d */
    private final byte[] f20407d;

    public C5561o(int i2) {
        super(i2);
        this.f20407d = new byte[i2];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p286h.p309q2.p311t.AbstractC5593y0
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int mo22466b(@InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(bArr, "$this$getSize");
        return bArr.length;
    }

    @InterfaceC5816d
    /* renamed from: c */
    public final byte[] m22627c() {
        return m22699a(this.f20407d, new byte[m22702b()]);
    }

    /* renamed from: a */
    public final void m22626a(byte b2) {
        byte[] bArr = this.f20407d;
        int m22698a = m22698a();
        m22700a(m22698a + 1);
        bArr[m22698a] = b2;
    }
}
