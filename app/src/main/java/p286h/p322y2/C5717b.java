package p286h.p322y2;

import p286h.C5715y1;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Timing.kt */
@InterfaceC5481e(name = "TimingKt")
/* renamed from: h.y2.b */
/* loaded from: classes2.dex */
public final class C5717b {
    /* renamed from: a */
    public static final long m23553a(@InterfaceC5816d InterfaceC5495a<C5715y1> interfaceC5495a) {
        C5544i0.m22546f(interfaceC5495a, "block");
        long nanoTime = System.nanoTime();
        interfaceC5495a.invoke();
        return System.nanoTime() - nanoTime;
    }

    /* renamed from: b */
    public static final long m23554b(@InterfaceC5816d InterfaceC5495a<C5715y1> interfaceC5495a) {
        C5544i0.m22546f(interfaceC5495a, "block");
        long currentTimeMillis = System.currentTimeMillis();
        interfaceC5495a.invoke();
        return System.currentTimeMillis() - currentTimeMillis;
    }
}
