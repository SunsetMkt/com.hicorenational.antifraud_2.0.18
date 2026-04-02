package h.a.y0.e.d;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: BlockingObservableNext.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e<T> implements Iterable<T> {
    final h.a.g0<T> a;

    /* JADX INFO: compiled from: BlockingObservableNext.java */
    static final class a<T> implements Iterator<T> {
        private final b<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final h.a.g0<T> f11309b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private T f11310c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f11311d = true;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f11312e = true;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Throwable f11313f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f11314g;

        a(h.a.g0<T> g0Var, b<T> bVar) {
            this.f11309b = g0Var;
            this.a = bVar;
        }

        private boolean a() {
            if (!this.f11314g) {
                this.f11314g = true;
                this.a.b();
                new w1(this.f11309b).subscribe(this.a);
            }
            try {
                h.a.a0<T> a0VarC = this.a.c();
                if (a0VarC.e()) {
                    this.f11312e = false;
                    this.f11310c = a0VarC.b();
                    return true;
                }
                this.f11311d = false;
                if (a0VarC.c()) {
                    return false;
                }
                this.f11313f = a0VarC.a();
                throw h.a.y0.j.k.c(this.f11313f);
            } catch (InterruptedException e2) {
                this.a.dispose();
                this.f11313f = e2;
                throw h.a.y0.j.k.c(e2);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Throwable th = this.f11313f;
            if (th != null) {
                throw h.a.y0.j.k.c(th);
            }
            if (this.f11311d) {
                return !this.f11312e || a();
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            Throwable th = this.f11313f;
            if (th != null) {
                throw h.a.y0.j.k.c(th);
            }
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            this.f11312e = true;
            return this.f11310c;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    /* JADX INFO: compiled from: BlockingObservableNext.java */
    static final class b<T> extends h.a.a1.e<h.a.a0<T>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final BlockingQueue<h.a.a0<T>> f11315b = new ArrayBlockingQueue(1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicInteger f11316c = new AtomicInteger();

        b() {
        }

        @Override // h.a.i0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(h.a.a0<T> a0Var) {
            if (this.f11316c.getAndSet(0) == 1 || !a0Var.e()) {
                while (!this.f11315b.offer(a0Var)) {
                    h.a.a0<T> a0VarPoll = this.f11315b.poll();
                    if (a0VarPoll != null && !a0VarPoll.e()) {
                        a0Var = a0VarPoll;
                    }
                }
            }
        }

        void b() {
            this.f11316c.set(1);
        }

        public h.a.a0<T> c() throws InterruptedException {
            b();
            h.a.y0.j.e.a();
            return this.f11315b.take();
        }

        @Override // h.a.i0
        public void onComplete() {
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            h.a.c1.a.b(th);
        }
    }

    public e(h.a.g0<T> g0Var) {
        this.a = g0Var;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new a(this.a, new b());
    }
}
