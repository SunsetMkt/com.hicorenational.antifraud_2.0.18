package i.k2.l;

import bean.SurveyH5Bean;
import i.q2.t.i0;
import i.y1;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: SequenceBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
final class k<T> extends j<T> implements Iterator<T>, c<y1>, i.q2.t.q1.a {
    private int a;

    /* JADX INFO: renamed from: b */
    private T f12133b;

    /* JADX INFO: renamed from: c */
    private Iterator<? extends T> f12134c;

    /* JADX INFO: renamed from: d */
    @j.c.a.e
    private c<? super y1> f12135d;

    private final Throwable c() {
        int i2 = this.a;
        if (i2 == 4) {
            return new NoSuchElementException();
        }
        if (i2 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.a);
    }

    private final T d() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    public final void a(@j.c.a.e c<? super y1> cVar) {
        this.f12135d = cVar;
    }

    @j.c.a.e
    public final c<y1> b() {
        return this.f12135d;
    }

    @Override // i.k2.l.c
    @j.c.a.d
    public e getContext() {
        return g.f12127b;
    }

    @Override // java.util.Iterator
    public boolean hasNext() throws Throwable {
        while (true) {
            int i2 = this.a;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2 || i2 == 3) {
                        return true;
                    }
                    if (i2 == 4) {
                        return false;
                    }
                    throw c();
                }
                Iterator<? extends T> it = this.f12134c;
                if (it == null) {
                    i0.f();
                }
                if (it.hasNext()) {
                    this.a = 2;
                    return true;
                }
                this.f12134c = null;
            }
            this.a = 5;
            c<? super y1> cVar = this.f12135d;
            if (cVar == null) {
                i0.f();
            }
            this.f12135d = null;
            cVar.resume(y1.a);
        }
    }

    @Override // java.util.Iterator
    public T next() throws Throwable {
        int i2 = this.a;
        if (i2 == 0 || i2 == 1) {
            return d();
        }
        if (i2 == 2) {
            this.a = 1;
            Iterator<? extends T> it = this.f12134c;
            if (it == null) {
                i0.f();
            }
            return it.next();
        }
        if (i2 != 3) {
            throw c();
        }
        this.a = 0;
        T t = this.f12133b;
        this.f12133b = null;
        return t;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // i.k2.l.c
    public void resumeWithException(@j.c.a.d Throwable th) throws Throwable {
        i0.f(th, "exception");
        throw th;
    }

    @Override // i.k2.l.j
    @j.c.a.e
    public Object a(T t, @j.c.a.d c<? super y1> cVar) {
        this.f12133b = t;
        this.a = 3;
        a(i.k2.l.o.a.b.a(cVar));
        return i.k2.l.n.b.b();
    }

    @Override // i.k2.l.j
    @j.c.a.e
    public Object a(@j.c.a.d Iterator<? extends T> it, @j.c.a.d c<? super y1> cVar) {
        if (!it.hasNext()) {
            return y1.a;
        }
        this.f12134c = it;
        this.a = 2;
        a(i.k2.l.o.a.b.a(cVar));
        return i.k2.l.n.b.b();
    }

    @Override // i.k2.l.c
    /* JADX INFO: renamed from: a */
    public void resume(@j.c.a.d y1 y1Var) {
        i0.f(y1Var, SurveyH5Bean.VALUE);
        this.a = 4;
    }
}
