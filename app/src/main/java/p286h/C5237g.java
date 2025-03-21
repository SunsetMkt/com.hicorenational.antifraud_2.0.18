package p286h;

import java.io.PrintStream;
import java.io.PrintWriter;
import p286h.p304m2.C5432l;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Exceptions.kt */
/* renamed from: h.g */
/* loaded from: classes2.dex */
public class C5237g {
    @InterfaceC5426f
    /* renamed from: a */
    private static final void m18968a(@InterfaceC5816d Throwable th, PrintWriter printWriter) {
        if (th == null) {
            throw new C5226e1("null cannot be cast to non-null type java.lang.Throwable");
        }
        th.printStackTrace(printWriter);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final void m18971b(@InterfaceC5816d Throwable th) {
        if (th == null) {
            throw new C5226e1("null cannot be cast to non-null type java.lang.Throwable");
        }
        th.printStackTrace();
    }

    /* renamed from: c */
    public static /* synthetic */ void m18972c(Throwable th) {
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final void m18967a(@InterfaceC5816d Throwable th, PrintStream printStream) {
        if (th == null) {
            throw new C5226e1("null cannot be cast to non-null type java.lang.Throwable");
        }
        th.printStackTrace(printStream);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final StackTraceElement[] m18970a(@InterfaceC5816d Throwable th) {
        C5544i0.m22546f(th, "$this$stackTrace");
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace == null) {
            C5544i0.m22545f();
        }
        return stackTrace;
    }

    /* renamed from: a */
    public static void m18969a(@InterfaceC5816d Throwable th, @InterfaceC5816d Throwable th2) {
        C5544i0.m22546f(th, "$this$addSuppressed");
        C5544i0.m22546f(th2, "exception");
        C5432l.f20299a.mo22178a(th, th2);
    }
}
