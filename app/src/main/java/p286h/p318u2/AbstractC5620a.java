package p286h.p318u2;

import java.util.Random;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: PlatformRandom.kt */
/* renamed from: h.u2.a */
/* loaded from: classes2.dex */
public abstract class AbstractC5620a extends AbstractC5625f {
    @Override // p286h.p318u2.AbstractC5625f
    /* renamed from: a */
    public int mo22943a(int i2) {
        return C5626g.m22975b(mo22951g().nextInt(), i2);
    }

    @Override // p286h.p318u2.AbstractC5625f
    /* renamed from: b */
    public double mo22946b() {
        return mo22951g().nextDouble();
    }

    @Override // p286h.p318u2.AbstractC5625f
    /* renamed from: c */
    public int mo22948c(int i2) {
        return mo22951g().nextInt(i2);
    }

    @Override // p286h.p318u2.AbstractC5625f
    /* renamed from: d */
    public int mo22949d() {
        return mo22951g().nextInt();
    }

    @Override // p286h.p318u2.AbstractC5625f
    /* renamed from: e */
    public long mo22950e() {
        return mo22951g().nextLong();
    }

    @InterfaceC5816d
    /* renamed from: g */
    public abstract Random mo22951g();

    @Override // p286h.p318u2.AbstractC5625f
    /* renamed from: a */
    public boolean mo22944a() {
        return mo22951g().nextBoolean();
    }

    @Override // p286h.p318u2.AbstractC5625f
    /* renamed from: c */
    public float mo22947c() {
        return mo22951g().nextFloat();
    }

    @Override // p286h.p318u2.AbstractC5625f
    @InterfaceC5816d
    /* renamed from: a */
    public byte[] mo22945a(@InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(bArr, "array");
        mo22951g().nextBytes(bArr);
        return bArr;
    }
}
