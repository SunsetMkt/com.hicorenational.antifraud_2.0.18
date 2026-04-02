package i;

import com.taobao.accs.common.Constants;

/* JADX INFO: compiled from: LazyJVM.kt */
/* JADX INFO: loaded from: classes2.dex */
public class v {
    @j.c.a.d
    public static <T> s<T> a(@j.c.a.d i.q2.s.a<? extends T> aVar) {
        i.q2.t.i0.f(aVar, "initializer");
        return new a1(aVar, null, 2, null);
    }

    @j.c.a.d
    public static <T> s<T> a(@j.c.a.d x xVar, @j.c.a.d i.q2.s.a<? extends T> aVar) {
        i.q2.t.i0.f(xVar, Constants.KEY_MODE);
        i.q2.t.i0.f(aVar, "initializer");
        int i2 = t.a[xVar.ordinal()];
        if (i2 == 1) {
            return new a1(aVar, null, 2, null);
        }
        if (i2 == 2) {
            return new s0(aVar);
        }
        if (i2 == 3) {
            return new z1(aVar);
        }
        throw new z();
    }

    @j.c.a.d
    public static final <T> s<T> a(@j.c.a.e Object obj, @j.c.a.d i.q2.s.a<? extends T> aVar) {
        i.q2.t.i0.f(aVar, "initializer");
        return new a1(aVar, obj);
    }
}
