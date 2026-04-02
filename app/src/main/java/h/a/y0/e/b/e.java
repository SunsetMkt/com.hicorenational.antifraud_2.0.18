package h.a.y0.e.b;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: BlockingFlowableNext.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e<T> implements Iterable<T> {
    final j.d.b<? extends T> a;

    /* JADX INFO: compiled from: BlockingFlowableNext.java */
    static final class a<T> implements Iterator<T> {
        private final b<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final j.d.b<? extends T> f10623b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private T f10624c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f10625d = true;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f10626e = true;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Throwable f10627f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f10628g;

        a(j.d.b<? extends T> bVar, b<T> bVar2) {
            this.f10623b = bVar;
            this.a = bVar2;
        }

        private boolean a() {
            try {
                if (!this.f10628g) {
                    this.f10628g = true;
                    this.a.c();
                    h.a.l.q(this.f10623b).t().a((h.a.q<? super h.a.a0<T>>) this.a);
                }
                h.a.a0<T> a0VarD = this.a.d();
                if (a0VarD.e()) {
                    this.f10626e = false;
                    this.f10624c = a0VarD.b();
                    return true;
                }
                this.f10625d = false;
                if (a0VarD.c()) {
                    return false;
                }
                if (!a0VarD.d()) {
                    throw new IllegalStateException("Should not reach here");
                }
                this.f10627f = a0VarD.a();
                throw h.a.y0.j.k.c(this.f10627f);
            } catch (InterruptedException e2) {
                this.a.dispose();
                this.f10627f = e2;
                throw h.a.y0.j.k.c(e2);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Throwable th = this.f10627f;
            if (th != null) {
                throw h.a.y0.j.k.c(th);
            }
            if (this.f10625d) {
                return !this.f10626e || a();
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            Throwable th = this.f10627f;
            if (th != null) {
                throw h.a.y0.j.k.c(th);
            }
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            this.f10626e = true;
            return this.f10624c;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    /* JADX INFO: compiled from: BlockingFlowableNext.java */
    static final class b<T> extends h.a.g1.b<h.a.a0<T>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final BlockingQueue<h.a.a0<T>> f10629b = new ArrayBlockingQueue(1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicInteger f10630c = new AtomicInteger();

        b() {
        }

        @Override // j.d.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(h.a.a0<T> a0Var) {
            if (this.f10630c.getAndSet(0) == 1 || !a0Var.e()) {
                while (!this.f10629b.offer(a0Var)) {
                    h.a.a0<T> a0VarPoll = this.f10629b.poll();
                    if (a0VarPoll != null && !a0VarPoll.e()) {
                        a0Var = a0VarPoll;
                    }
                }
            }
        }

        void c() {
            this.f10630c.set(1);
        }

        public h.a.a0<T> d() throws InterruptedException {
            c();
            h.a.y0.j.e.a();
            return this.f10629b.take();
        }

        @Override // j.d.c
        public void onComplete() {
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            h.a.c1.a.b(th);
        }
    }

    public e(j.d.b<? extends T> bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new a(this.a, new b());
    }
}
