package p031c.p035b.p043c.p062f0.p063c;

import p031c.p035b.p043c.C1109t;

/* compiled from: QRCodeDecoderMetaData.java */
/* renamed from: c.b.c.f0.c.i */
/* loaded from: classes.dex */
public final class C1082i {

    /* renamed from: a */
    private final boolean f2135a;

    C1082i(boolean z) {
        this.f2135a = z;
    }

    /* renamed from: a */
    public boolean m1767a() {
        return this.f2135a;
    }

    /* renamed from: a */
    public void m1766a(C1109t[] c1109tArr) {
        if (!this.f2135a || c1109tArr == null || c1109tArr.length < 3) {
            return;
        }
        C1109t c1109t = c1109tArr[0];
        c1109tArr[0] = c1109tArr[2];
        c1109tArr[2] = c1109t;
    }
}
