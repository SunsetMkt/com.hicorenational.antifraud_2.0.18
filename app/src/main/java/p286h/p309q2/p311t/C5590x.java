package p286h.p309q2.p311t;

import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: PrimitiveSpreadBuilders.kt */
/* renamed from: h.q2.t.x */
/* loaded from: classes2.dex */
public final class C5590x extends AbstractC5593y0<double[]> {

    /* renamed from: d */
    private final double[] f20441d;

    public C5590x(int i2) {
        super(i2);
        this.f20441d = new double[i2];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p286h.p309q2.p311t.AbstractC5593y0
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int mo22466b(@InterfaceC5816d double[] dArr) {
        C5544i0.m22546f(dArr, "$this$getSize");
        return dArr.length;
    }

    @InterfaceC5816d
    /* renamed from: c */
    public final double[] m22696c() {
        return m22699a(this.f20441d, new double[m22702b()]);
    }

    /* renamed from: a */
    public final void m22695a(double d2) {
        double[] dArr = this.f20441d;
        int m22698a = m22698a();
        m22700a(m22698a + 1);
        dArr[m22698a] = d2;
    }
}
