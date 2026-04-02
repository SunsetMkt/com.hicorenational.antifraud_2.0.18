package i.x2;

import i.q0;
import i.q2.t.i0;
import i.r0;
import i.y1;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: SequenceBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
final class n<T> extends o<T> implements Iterator<T>, i.k2.d<y1>, i.q2.t.q1.a {
    private int a;

    /* JADX INFO: renamed from: b */
    private T f12370b;

    /* JADX INFO: renamed from: c */
    private Iterator<? extends T> f12371c;

    /* JADX INFO: renamed from: d */
    @j.c.a.e
    private i.k2.d<? super y1> f12372d;

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

    public final void a(@j.c.a.e i.k2.d<? super y1> dVar) {
        this.f12372d = dVar;
    }

    @j.c.a.e
    public final i.k2.d<y1> b() {
        return this.f12372d;
    }

    @Override // i.k2.d
    @j.c.a.d
    public i.k2.g getContext() {
        return i.k2.i.INSTANCE;
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
                Iterator<? extends T> it = this.f12371c;
                if (it == null) {
                    i0.f();
                }
                if (it.hasNext()) {
                    this.a = 2;
                    return true;
                }
                this.f12371c = null;
            }
            this.a = 5;
            i.k2.d<? super y1> dVar = this.f12372d;
            if (dVar == null) {
                i0.f();
            }
            this.f12372d = null;
            y1 y1Var = y1.a;
            q0.a aVar = q0.Companion;
            dVar.resumeWith(q0.m772constructorimpl(y1Var));
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
            Iterator<? extends T> it = this.f12371c;
            if (it == null) {
                i0.f();
            }
            return it.next();
        }
        if (i2 != 3) {
            throw c();
        }
        this.a = 0;
        T t = this.f12370b;
        this.f12370b = null;
        return t;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // i.k2.d
    public void resumeWith(@j.c.a.d Object obj) {
        r0.b(obj);
        this.a = 4;
    }

    @Override // i.x2.o
    @j.c.a.e
    public Object a(T t, @j.c.a.d i.k2.d<? super y1> dVar) {
        this.f12370b = t;
        this.a = 3;
        this.f12372d = dVar;
        Object objB = i.k2.m.d.b();
        if (objB == i.k2.m.d.b()) {
            i.k2.n.a.h.c(dVar);
        }
        return objB == i.k2.m.d.b() ? objB : y1.a;
    }

    @Override // i.x2.o
    @j.c.a.e
    public Object a(@j.c.a.d Iterator<? extends T> it, @j.c.a.d i.k2.d<? super y1> dVar) {
        if (!it.hasNext()) {
            return y1.a;
        }
        this.f12371c = it;
        this.a = 2;
        this.f12372d = dVar;
        Object objB = i.k2.m.d.b();
        if (objB == i.k2.m.d.b()) {
            i.k2.n.a.h.c(dVar);
        }
        return objB == i.k2.m.d.b() ? objB : y1.a;
    }
}
