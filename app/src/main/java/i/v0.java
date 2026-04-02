package i;

/* JADX INFO: compiled from: Standard.kt */
/* JADX INFO: loaded from: classes2.dex */
class v0 {
    @i.m2.f
    private static final Void a() {
        throw new a0(null, 1, null);
    }

    @i.m2.f
    private static final <T> T b(T t, i.q2.s.l<? super T, y1> lVar) {
        lVar.invoke(t);
        return t;
    }

    @i.m2.f
    private static final <T, R> R c(T t, i.q2.s.l<? super T, ? extends R> lVar) {
        return lVar.invoke(t);
    }

    @i.m2.f
    private static final <T, R> R d(T t, i.q2.s.l<? super T, ? extends R> lVar) {
        return lVar.invoke(t);
    }

    @t0(version = "1.1")
    @i.m2.f
    private static final <T> T e(T t, i.q2.s.l<? super T, Boolean> lVar) {
        if (lVar.invoke(t).booleanValue()) {
            return t;
        }
        return null;
    }

    @t0(version = "1.1")
    @i.m2.f
    private static final <T> T f(T t, i.q2.s.l<? super T, Boolean> lVar) {
        if (lVar.invoke(t).booleanValue()) {
            return null;
        }
        return t;
    }

    @i.m2.f
    private static final <T, R> R g(T t, i.q2.s.l<? super T, ? extends R> lVar) {
        return lVar.invoke(t);
    }

    @i.m2.f
    private static final Void a(String str) {
        throw new a0("An operation is not implemented: " + str);
    }

    @i.m2.f
    private static final <R> R a(i.q2.s.a<? extends R> aVar) {
        return aVar.invoke();
    }

    @t0(version = "1.1")
    @i.m2.f
    private static final <T> T a(T t, i.q2.s.l<? super T, y1> lVar) {
        lVar.invoke(t);
        return t;
    }

    @i.m2.f
    private static final void a(int i2, i.q2.s.l<? super Integer, y1> lVar) {
        for (int i3 = 0; i3 < i2; i3++) {
            lVar.invoke(Integer.valueOf(i3));
        }
    }
}
