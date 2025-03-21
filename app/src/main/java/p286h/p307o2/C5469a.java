package p286h.p307o2;

import p286h.InterfaceC5440n0;
import p286h.InterfaceC5610t0;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5535f0;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: AutoCloseable.kt */
@InterfaceC5481e(name = "AutoCloseableKt")
/* renamed from: h.o2.a */
/* loaded from: classes2.dex */
public final class C5469a {
    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final <T extends AutoCloseable, R> R m22433a(T t, InterfaceC5506l<? super T, ? extends R> interfaceC5506l) {
        try {
            R invoke = interfaceC5506l.invoke(t);
            C5535f0.m22474b(1);
            m22434a(t, (Throwable) null);
            C5535f0.m22471a(1);
            return invoke;
        } finally {
        }
    }

    @InterfaceC5610t0(version = "1.2")
    @InterfaceC5440n0
    /* renamed from: a */
    public static final void m22434a(@InterfaceC5817e AutoCloseable autoCloseable, @InterfaceC5817e Throwable th) {
        if (autoCloseable == null) {
            return;
        }
        if (th == null) {
            autoCloseable.close();
            return;
        }
        try {
            autoCloseable.close();
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }
}
