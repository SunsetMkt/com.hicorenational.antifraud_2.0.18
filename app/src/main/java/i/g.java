package i;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public class g {
    @i.m2.f
    private static final void a(@j.c.a.d Throwable th, PrintWriter printWriter) {
        if (th == null) {
            throw new e1("null cannot be cast to non-null type java.lang.Throwable");
        }
        th.printStackTrace(printWriter);
    }

    @i.m2.f
    private static final void b(@j.c.a.d Throwable th) {
        if (th == null) {
            throw new e1("null cannot be cast to non-null type java.lang.Throwable");
        }
        th.printStackTrace();
    }

    public static /* synthetic */ void c(Throwable th) {
    }

    @i.m2.f
    private static final void a(@j.c.a.d Throwable th, PrintStream printStream) {
        if (th == null) {
            throw new e1("null cannot be cast to non-null type java.lang.Throwable");
        }
        th.printStackTrace(printStream);
    }

    @j.c.a.d
    public static final StackTraceElement[] a(@j.c.a.d Throwable th) {
        i.q2.t.i0.f(th, "$this$stackTrace");
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace == null) {
            i.q2.t.i0.f();
        }
        return stackTrace;
    }

    public static void a(@j.c.a.d Throwable th, @j.c.a.d Throwable th2) throws IllegalAccessException, InvocationTargetException {
        i.q2.t.i0.f(th, "$this$addSuppressed");
        i.q2.t.i0.f(th2, "exception");
        i.m2.l.a.a(th, th2);
    }
}
