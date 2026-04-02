package i.t2;

import i.q2.t.i0;
import i.w2.m;

/* JADX INFO: compiled from: ObservableProperty.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c<T> implements e<Object, T> {
    private T a;

    public c(T t) {
        this.a = t;
    }

    @Override // i.t2.e
    public T a(@j.c.a.e Object obj, @j.c.a.d m<?> mVar) {
        i0.f(mVar, "property");
        return this.a;
    }

    protected void a(@j.c.a.d m<?> mVar, T t, T t2) {
        i0.f(mVar, "property");
    }

    protected boolean b(@j.c.a.d m<?> mVar, T t, T t2) {
        i0.f(mVar, "property");
        return true;
    }

    @Override // i.t2.e
    public void a(@j.c.a.e Object obj, @j.c.a.d m<?> mVar, T t) {
        i0.f(mVar, "property");
        T t2 = this.a;
        if (b(mVar, t2, t)) {
            this.a = t;
            a(mVar, t2, t);
        }
    }
}
