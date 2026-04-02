package i.w2;

import i.e1;
import i.q2.t.i0;
import i.t0;

/* JADX INFO: compiled from: KClasses.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.q2.e(name = "KClasses")
public final class d {
    /* JADX WARN: Multi-variable type inference failed */
    @t0(version = "1.3")
    @i.j
    @i.m2.g
    @j.c.a.d
    public static final <T> T a(@j.c.a.d c<T> cVar, @j.c.a.e Object obj) {
        i0.f(cVar, "$this$cast");
        if (cVar.a(obj)) {
            if (obj != 0) {
                return obj;
            }
            throw new e1("null cannot be cast to non-null type T");
        }
        throw new ClassCastException("Value cannot be cast to " + cVar.b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @t0(version = "1.3")
    @i.j
    @j.c.a.e
    @i.m2.g
    public static final <T> T b(@j.c.a.d c<T> cVar, @j.c.a.e Object obj) {
        i0.f(cVar, "$this$safeCast");
        if (!cVar.a(obj)) {
            return null;
        }
        if (obj != 0) {
            return obj;
        }
        throw new e1("null cannot be cast to non-null type T");
    }
}
