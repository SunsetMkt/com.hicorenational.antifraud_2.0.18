package p286h.p309q2.p311t;

import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: PrimitiveSpreadBuilders.kt */
/* renamed from: h.q2.t.r */
/* loaded from: classes2.dex */
public final class C5577r extends AbstractC5593y0<char[]> {

    /* renamed from: d */
    private final char[] f20425d;

    public C5577r(int i2) {
        super(i2);
        this.f20425d = new char[i2];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p286h.p309q2.p311t.AbstractC5593y0
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int mo22466b(@InterfaceC5816d char[] cArr) {
        C5544i0.m22546f(cArr, "$this$getSize");
        return cArr.length;
    }

    @InterfaceC5816d
    /* renamed from: c */
    public final char[] m22651c() {
        return m22699a(this.f20425d, new char[m22702b()]);
    }

    /* renamed from: a */
    public final void m22650a(char c2) {
        char[] cArr = this.f20425d;
        int m22698a = m22698a();
        m22700a(m22698a + 1);
        cArr[m22698a] = c2;
    }
}
