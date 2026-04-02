package i.n2;

import i.n0;
import i.q2.t.f0;
import i.t0;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: Closeable.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.q2.e(name = "CloseableKt")
public final class c {
    @i.m2.f
    private static final <T extends Closeable, R> R a(T t, i.q2.s.l<? super T, ? extends R> lVar) throws IllegalAccessException, IOException, InvocationTargetException {
        try {
            R rInvoke = lVar.invoke(t);
            f0.b(1);
            if (i.m2.l.a(1, 1, 0)) {
                a(t, (Throwable) null);
            } else if (t != null) {
                t.close();
            }
            f0.a(1);
            return rInvoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                f0.b(1);
                if (i.m2.l.a(1, 1, 0)) {
                    a(t, th);
                } else if (t != null) {
                    try {
                        t.close();
                    } catch (Throwable unused) {
                    }
                }
                f0.a(1);
                throw th2;
            }
        }
    }

    @n0
    @t0(version = "1.1")
    public static final void a(@j.c.a.e Closeable closeable, @j.c.a.e Throwable th) throws IllegalAccessException, IOException, InvocationTargetException {
        if (closeable == null) {
            return;
        }
        if (th == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th2) {
            i.g.a(th, th2);
        }
    }
}
