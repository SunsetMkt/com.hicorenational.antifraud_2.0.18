package i.a3;

import i.q2.t.i0;
import i.t0;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: DurationUnitJvm.kt */
/* JADX INFO: loaded from: classes2.dex */
class h {
    @j
    @t0(version = "1.3")
    public static final double a(double d2, @j.c.a.d TimeUnit timeUnit, @j.c.a.d TimeUnit timeUnit2) {
        i0.f(timeUnit, "sourceUnit");
        i0.f(timeUnit2, "targetUnit");
        long jConvert = timeUnit2.convert(1L, timeUnit);
        return jConvert > 0 ? d2 * jConvert : d2 / timeUnit.convert(1L, timeUnit2);
    }

    @j
    @t0(version = "1.3")
    public static /* synthetic */ void a() {
    }
}
