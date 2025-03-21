package p286h.p309q2.p311t;

import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: PrimitiveSpreadBuilders.kt */
/* renamed from: h.q2.t.h0 */
/* loaded from: classes2.dex */
public final class C5541h0 extends AbstractC5593y0<int[]> {

    /* renamed from: d */
    private final int[] f20377d;

    public C5541h0(int i2) {
        super(i2);
        this.f20377d = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p286h.p309q2.p311t.AbstractC5593y0
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int mo22466b(@InterfaceC5816d int[] iArr) {
        C5544i0.m22546f(iArr, "$this$getSize");
        return iArr.length;
    }

    @InterfaceC5816d
    /* renamed from: c */
    public final int[] m22480c() {
        return m22699a(this.f20377d, new int[m22702b()]);
    }

    /* renamed from: b */
    public final void m22479b(int i2) {
        int[] iArr = this.f20377d;
        int m22698a = m22698a();
        m22700a(m22698a + 1);
        iArr[m22698a] = i2;
    }
}
