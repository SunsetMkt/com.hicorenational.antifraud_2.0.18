package i.v2;

import bean.SurveyH5Bean;
import i.q2.t.i0;
import i.v2.g;
import java.lang.Comparable;

/* JADX INFO: compiled from: Ranges.kt */
/* JADX INFO: loaded from: classes2.dex */
class h<T extends Comparable<? super T>> implements g<T> {

    @j.c.a.d
    private final T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @j.c.a.d
    private final T f12305b;

    public h(@j.c.a.d T t, @j.c.a.d T t2) {
        i0.f(t, "start");
        i0.f(t2, "endInclusive");
        this.a = t;
        this.f12305b = t2;
    }

    @Override // i.v2.g
    public boolean contains(@j.c.a.d T t) {
        i0.f(t, SurveyH5Bean.VALUE);
        return g.a.a(this, t);
    }

    public boolean equals(@j.c.a.e Object obj) {
        if (obj instanceof h) {
            if (!isEmpty() || !((h) obj).isEmpty()) {
                h hVar = (h) obj;
                if (!i0.a(getStart(), hVar.getStart()) || !i0.a(getEndInclusive(), hVar.getEndInclusive())) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // i.v2.g
    @j.c.a.d
    public T getEndInclusive() {
        return this.f12305b;
    }

    @Override // i.v2.g
    @j.c.a.d
    public T getStart() {
        return this.a;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getStart().hashCode() * 31) + getEndInclusive().hashCode();
    }

    @Override // i.v2.g
    public boolean isEmpty() {
        return g.a.a(this);
    }

    @j.c.a.d
    public String toString() {
        return getStart() + ".." + getEndInclusive();
    }
}
