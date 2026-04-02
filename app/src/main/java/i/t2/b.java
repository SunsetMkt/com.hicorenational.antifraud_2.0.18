package i.t2;

import bean.SurveyH5Bean;
import i.q2.t.i0;
import i.w2.m;

/* JADX INFO: compiled from: Delegates.kt */
/* JADX INFO: loaded from: classes2.dex */
final class b<T> implements e<Object, T> {
    private T a;

    @Override // i.t2.e
    @j.c.a.d
    public T a(@j.c.a.e Object obj, @j.c.a.d m<?> mVar) {
        i0.f(mVar, "property");
        T t = this.a;
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("Property " + mVar.getName() + " should be initialized before get.");
    }

    @Override // i.t2.e
    public void a(@j.c.a.e Object obj, @j.c.a.d m<?> mVar, @j.c.a.d T t) {
        i0.f(mVar, "property");
        i0.f(t, SurveyH5Bean.VALUE);
        this.a = t;
    }
}
