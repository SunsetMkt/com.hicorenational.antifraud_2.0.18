package i.y2;

import i.q2.e;
import i.q2.t.i0;
import i.y1;
import j.c.a.d;

/* JADX INFO: compiled from: Timing.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(name = "TimingKt")
public final class b {
    public static final long a(@d i.q2.s.a<y1> aVar) {
        i0.f(aVar, "block");
        long jNanoTime = System.nanoTime();
        aVar.invoke();
        return System.nanoTime() - jNanoTime;
    }

    public static final long b(@d i.q2.s.a<y1> aVar) {
        i0.f(aVar, "block");
        long jCurrentTimeMillis = System.currentTimeMillis();
        aVar.invoke();
        return System.currentTimeMillis() - jCurrentTimeMillis;
    }
}
