package i.a3;

import com.umeng.analytics.pro.bh;
import i.q2.t.i0;
import i.t0;
import i.z;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: DurationUnit.kt */
/* JADX INFO: loaded from: classes2.dex */
class i extends h {
    @j
    @t0(version = "1.3")
    @j.c.a.d
    public static final String a(@j.c.a.d TimeUnit timeUnit) {
        i0.f(timeUnit, "$this$shortName");
        switch (f.a[timeUnit.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "us";
            case 3:
                return "ms";
            case 4:
                return bh.aE;
            case 5:
                return "m";
            case 6:
                return bh.aJ;
            case 7:
                return "d";
            default:
                throw new z();
        }
    }
}
