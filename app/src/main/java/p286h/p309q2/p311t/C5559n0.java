package p286h.p309q2.p311t;

import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: PrimitiveSpreadBuilders.kt */
/* renamed from: h.q2.t.n0 */
/* loaded from: classes2.dex */
public final class C5559n0 extends AbstractC5593y0<long[]> {

    /* renamed from: d */
    private final long[] f20406d;

    public C5559n0(int i2) {
        super(i2);
        this.f20406d = new long[i2];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p286h.p309q2.p311t.AbstractC5593y0
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int mo22466b(@InterfaceC5816d long[] jArr) {
        C5544i0.m22546f(jArr, "$this$getSize");
        return jArr.length;
    }

    @InterfaceC5816d
    /* renamed from: c */
    public final long[] m22584c() {
        return m22699a(this.f20406d, new long[m22702b()]);
    }

    /* renamed from: a */
    public final void m22583a(long j2) {
        long[] jArr = this.f20406d;
        int m22698a = m22698a();
        m22700a(m22698a + 1);
        jArr[m22698a] = j2;
    }
}
