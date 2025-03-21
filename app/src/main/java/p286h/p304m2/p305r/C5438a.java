package p286h.p304m2.p305r;

import p286h.p304m2.C5431k;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: JDK7PlatformImplementations.kt */
/* renamed from: h.m2.r.a */
/* loaded from: classes2.dex */
public class C5438a extends C5431k {
    @Override // p286h.p304m2.C5431k
    /* renamed from: a */
    public void mo22178a(@InterfaceC5816d Throwable th, @InterfaceC5816d Throwable th2) {
        C5544i0.m22546f(th, "cause");
        C5544i0.m22546f(th2, "exception");
        th.addSuppressed(th2);
    }
}
