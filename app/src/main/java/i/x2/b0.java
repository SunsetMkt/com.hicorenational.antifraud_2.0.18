package i.x2;

import i.f1;
import i.j1;
import i.n1;
import i.q2.t.i0;
import i.t0;
import i.t1;
import java.util.Iterator;

/* JADX INFO: compiled from: _USequences.kt */
/* JADX INFO: loaded from: classes2.dex */
class b0 {
    @i.k
    @i.q2.e(name = "sumOfUByte")
    @t0(version = "1.3")
    public static final int a(@j.c.a.d m<f1> mVar) {
        i0.f(mVar, "$this$sum");
        Iterator<f1> it = mVar.iterator();
        int iC = 0;
        while (it.hasNext()) {
            iC = j1.c(iC + j1.c(it.next().a() & f1.f12066c));
        }
        return iC;
    }

    @i.k
    @i.q2.e(name = "sumOfUInt")
    @t0(version = "1.3")
    public static final int b(@j.c.a.d m<j1> mVar) {
        i0.f(mVar, "$this$sum");
        Iterator<j1> it = mVar.iterator();
        int iC = 0;
        while (it.hasNext()) {
            iC = j1.c(iC + it.next().a());
        }
        return iC;
    }

    @i.k
    @i.q2.e(name = "sumOfULong")
    @t0(version = "1.3")
    public static final long c(@j.c.a.d m<n1> mVar) {
        i0.f(mVar, "$this$sum");
        Iterator<n1> it = mVar.iterator();
        long jC = 0;
        while (it.hasNext()) {
            jC = n1.c(jC + it.next().a());
        }
        return jC;
    }

    @i.k
    @i.q2.e(name = "sumOfUShort")
    @t0(version = "1.3")
    public static final int d(@j.c.a.d m<t1> mVar) {
        i0.f(mVar, "$this$sum");
        Iterator<t1> it = mVar.iterator();
        int iC = 0;
        while (it.hasNext()) {
            iC = j1.c(iC + j1.c(it.next().a() & t1.f12275c));
        }
        return iC;
    }
}
