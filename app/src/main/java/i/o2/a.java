package i.o2;

import i.m2.f;
import i.n0;
import i.q2.e;
import i.q2.s.l;
import i.q2.t.f0;
import i.t0;

/* JADX INFO: compiled from: AutoCloseable.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(name = "AutoCloseableKt")
public final class a {
    @t0(version = "1.2")
    @f
    private static final <T extends AutoCloseable, R> R a(T t, l<? super T, ? extends R> lVar) throws Exception {
        try {
            R rInvoke = lVar.invoke(t);
            f0.b(1);
            a(t, (Throwable) null);
            f0.a(1);
            return rInvoke;
        } finally {
        }
    }

    @n0
    @t0(version = "1.2")
    public static final void a(@j.c.a.e AutoCloseable autoCloseable, @j.c.a.e Throwable th) throws Exception {
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
