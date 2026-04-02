package i.a3;

import i.o0;
import i.q2.t.i0;
import i.t0;

/* JADX INFO: compiled from: TimeSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class q {
    @t0(version = "1.3")
    @i.c(level = i.d.ERROR, message = "Comparing one TimeMark to another is not a well defined operation because these time marks could have been obtained from the different time sources.")
    @j
    @i.m2.f
    private static final int a(@j.c.a.d o oVar, o oVar2) {
        i0.f(oVar, "$this$compareTo");
        throw new Error("Operation is disallowed.");
    }

    @i.c(message = "Use TimeSource interface instead.", replaceWith = @o0(expression = "TimeSource", imports = {"kotlin.time.TimeSource"}))
    @j
    @t0(version = "1.3")
    public static /* synthetic */ void a() {
    }

    @t0(version = "1.3")
    @i.c(level = i.d.ERROR, message = "Subtracting one TimeMark from another is not a well defined operation because these time marks could have been obtained from the different time sources.")
    @j
    @i.m2.f
    private static final double b(@j.c.a.d o oVar, o oVar2) {
        i0.f(oVar, "$this$minus");
        throw new Error("Operation is disallowed.");
    }

    @i.c(message = "Use TimeMark class instead.", replaceWith = @o0(expression = "TimeMark", imports = {"kotlin.time.TimeMark"}))
    @j
    @t0(version = "1.3")
    public static /* synthetic */ void b() {
    }
}
