package p286h.p309q2.p311t;

import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: PrimitiveSpreadBuilders.kt */
/* renamed from: h.q2.t.k1 */
/* loaded from: classes2.dex */
public final class C5551k1 extends AbstractC5593y0<short[]> {

    /* renamed from: d */
    private final short[] f20391d;

    public C5551k1(int i2) {
        super(i2);
        this.f20391d = new short[i2];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p286h.p309q2.p311t.AbstractC5593y0
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int mo22466b(@InterfaceC5816d short[] sArr) {
        C5544i0.m22546f(sArr, "$this$getSize");
        return sArr.length;
    }

    @InterfaceC5816d
    /* renamed from: c */
    public final short[] m22572c() {
        return m22699a(this.f20391d, new short[m22702b()]);
    }

    /* renamed from: a */
    public final void m22571a(short s) {
        short[] sArr = this.f20391d;
        int m22698a = m22698a();
        m22700a(m22698a + 1);
        sArr[m22698a] = s;
    }
}
