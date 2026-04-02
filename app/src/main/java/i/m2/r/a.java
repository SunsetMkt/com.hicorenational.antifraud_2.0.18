package i.m2.r;

import i.m2.k;
import i.q2.t.i0;
import j.c.a.d;

/* JADX INFO: compiled from: JDK7PlatformImplementations.kt */
/* JADX INFO: loaded from: classes2.dex */
public class a extends k {
    @Override // i.m2.k
    public void a(@d Throwable th, @d Throwable th2) {
        i0.f(th, "cause");
        i0.f(th2, "exception");
        th.addSuppressed(th2);
    }
}
