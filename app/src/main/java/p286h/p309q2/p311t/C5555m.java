package p286h.p309q2.p311t;

import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: PrimitiveSpreadBuilders.kt */
/* renamed from: h.q2.t.m */
/* loaded from: classes2.dex */
public final class C5555m extends AbstractC5593y0<boolean[]> {

    /* renamed from: d */
    private final boolean[] f20394d;

    public C5555m(int i2) {
        super(i2);
        this.f20394d = new boolean[i2];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p286h.p309q2.p311t.AbstractC5593y0
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int mo22466b(@InterfaceC5816d boolean[] zArr) {
        C5544i0.m22546f(zArr, "$this$getSize");
        return zArr.length;
    }

    @InterfaceC5816d
    /* renamed from: c */
    public final boolean[] m22581c() {
        return m22699a(this.f20394d, new boolean[m22702b()]);
    }

    /* renamed from: a */
    public final void m22580a(boolean z) {
        boolean[] zArr = this.f20394d;
        int m22698a = m22698a();
        m22700a(m22698a + 1);
        zArr[m22698a] = z;
    }
}
