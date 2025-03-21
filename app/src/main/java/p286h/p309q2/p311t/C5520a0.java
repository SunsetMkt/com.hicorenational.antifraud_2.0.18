package p286h.p309q2.p311t;

import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: PrimitiveSpreadBuilders.kt */
/* renamed from: h.q2.t.a0 */
/* loaded from: classes2.dex */
public final class C5520a0 extends AbstractC5593y0<float[]> {

    /* renamed from: d */
    private final float[] f20359d;

    public C5520a0(int i2) {
        super(i2);
        this.f20359d = new float[i2];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p286h.p309q2.p311t.AbstractC5593y0
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int mo22466b(@InterfaceC5816d float[] fArr) {
        C5544i0.m22546f(fArr, "$this$getSize");
        return fArr.length;
    }

    @InterfaceC5816d
    /* renamed from: c */
    public final float[] m22467c() {
        return m22699a(this.f20359d, new float[m22702b()]);
    }

    /* renamed from: a */
    public final void m22465a(float f2) {
        float[] fArr = this.f20359d;
        int m22698a = m22698a();
        m22700a(m22698a + 1);
        fArr[m22698a] = f2;
    }
}
