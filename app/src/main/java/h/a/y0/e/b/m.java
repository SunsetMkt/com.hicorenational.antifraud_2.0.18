package h.a.y0.e.b;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: FlowableBuffer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m<T, C extends Collection<? super T>> extends h.a.y0.e.b.a<T, C> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f10776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f10777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Callable<C> f10778e;

    /* JADX INFO: compiled from: FlowableBuffer.java */
    static final class a<T, C extends Collection<? super T>> implements h.a.q<T>, j.d.d {
        final j.d.c<? super C> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Callable<C> f10779b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f10780c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        C f10781d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        j.d.d f10782e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f10783f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f10784g;

        a(j.d.c<? super C> cVar, int i2, Callable<C> callable) {
            this.a = cVar;
            this.f10780c = i2;
            this.f10779b = callable;
        }

        @Override // j.d.d
        public void cancel() {
            this.f10782e.cancel();
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f10783f) {
                return;
            }
            this.f10783f = true;
            C c2 = this.f10781d;
            if (c2 != null && !c2.isEmpty()) {
                this.a.onNext(c2);
            }
            this.a.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f10783f) {
                h.a.c1.a.b(th);
            } else {
                this.f10783f = true;
                this.a.onError(th);
            }
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.f10783f) {
                return;
            }
            C c2 = this.f10781d;
            if (c2 == null) {
                try {
                    c2 = (C) h.a.y0.b.b.a(this.f10779b.call(), "The bufferSupplier returned a null buffer");
                    this.f10781d = c2;
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            c2.add(t);
            int i2 = this.f10784g + 1;
            if (i2 != this.f10780c) {
                this.f10784g = i2;
                return;
            }
            this.f10784g = 0;
            this.f10781d = null;
            this.a.onNext(c2);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f10782e, dVar)) {
                this.f10782e = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            if (h.a.y0.i.j.validate(j2)) {
                this.f10782e.request(h.a.y0.j.d.b(j2, this.f10780c));
            }
        }
    }

    /* JADX INFO: compiled from: FlowableBuffer.java */
    static final class b<T, C extends Collection<? super T>> extends AtomicLong implements h.a.q<T>, j.d.d, h.a.x0.e {
        private static final long serialVersionUID = -7370244972039324525L;
        final j.d.c<? super C> actual;
        final Callable<C> bufferSupplier;
        volatile boolean cancelled;
        boolean done;
        int index;
        long produced;
        j.d.d s;
        final int size;
        final int skip;
        final AtomicBoolean once = new AtomicBoolean();
        final ArrayDeque<C> buffers = new ArrayDeque<>();

        b(j.d.c<? super C> cVar, int i2, int i3, Callable<C> callable) {
            this.actual = cVar;
            this.size = i2;
            this.skip = i3;
            this.bufferSupplier = callable;
        }

        @Override // j.d.d
        public void cancel() {
            this.cancelled = true;
            this.s.cancel();
        }

        @Override // h.a.x0.e
        public boolean getAsBoolean() {
            return this.cancelled;
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            long j2 = this.produced;
            if (j2 != 0) {
                h.a.y0.j.d.c(this, j2);
            }
            h.a.y0.j.v.a(this.actual, this.buffers, this, this);
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.done) {
                h.a.c1.a.b(th);
                return;
            }
            this.done = true;
            this.buffers.clear();
            this.actual.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            ArrayDeque<C> arrayDeque = this.buffers;
            int i2 = this.index;
            int i3 = i2 + 1;
            if (i2 == 0) {
                try {
                    arrayDeque.offer((C) ((Collection) h.a.y0.b.b.a(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer")));
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            C cPeek = arrayDeque.peek();
            if (cPeek != null && cPeek.size() + 1 == this.size) {
                arrayDeque.poll();
                cPeek.add(t);
                this.produced++;
                this.actual.onNext(cPeek);
            }
            Iterator<C> it = arrayDeque.iterator();
            while (it.hasNext()) {
                it.next().add(t);
            }
            if (i3 == this.skip) {
                i3 = 0;
            }
            this.index = i3;
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            if (!h.a.y0.i.j.validate(j2) || h.a.y0.j.v.b(j2, this.actual, this.buffers, this, this)) {
                return;
            }
            if (this.once.get() || !this.once.compareAndSet(false, true)) {
                this.s.request(h.a.y0.j.d.b(this.skip, j2));
            } else {
                this.s.request(h.a.y0.j.d.a(this.size, h.a.y0.j.d.b(this.skip, j2 - 1)));
            }
        }
    }

    /* JADX INFO: compiled from: FlowableBuffer.java */
    static final class c<T, C extends Collection<? super T>> extends AtomicInteger implements h.a.q<T>, j.d.d {
        private static final long serialVersionUID = -5616169793639412593L;
        final j.d.c<? super C> actual;
        C buffer;
        final Callable<C> bufferSupplier;
        boolean done;
        int index;
        j.d.d s;
        final int size;
        final int skip;

        c(j.d.c<? super C> cVar, int i2, int i3, Callable<C> callable) {
            this.actual = cVar;
            this.size = i2;
            this.skip = i3;
            this.bufferSupplier = callable;
        }

        @Override // j.d.d
        public void cancel() {
            this.s.cancel();
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            C c2 = this.buffer;
            this.buffer = null;
            if (c2 != null) {
                this.actual.onNext(c2);
            }
            this.actual.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.done) {
                h.a.c1.a.b(th);
                return;
            }
            this.done = true;
            this.buffer = null;
            this.actual.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            C c2 = this.buffer;
            int i2 = this.index;
            int i3 = i2 + 1;
            if (i2 == 0) {
                try {
                    c2 = (C) h.a.y0.b.b.a(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer");
                    this.buffer = c2;
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            if (c2 != null) {
                c2.add(t);
                if (c2.size() == this.size) {
                    this.buffer = null;
                    this.actual.onNext(c2);
                }
            }
            if (i3 == this.skip) {
                i3 = 0;
            }
            this.index = i3;
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            if (h.a.y0.i.j.validate(j2)) {
                if (get() != 0 || !compareAndSet(0, 1)) {
                    this.s.request(h.a.y0.j.d.b(this.skip, j2));
                    return;
                }
                this.s.request(h.a.y0.j.d.a(h.a.y0.j.d.b(j2, this.size), h.a.y0.j.d.b(this.skip - this.size, j2 - 1)));
            }
        }
    }

    public m(h.a.l<T> lVar, int i2, int i3, Callable<C> callable) {
        super(lVar);
        this.f10776c = i2;
        this.f10777d = i3;
        this.f10778e = callable;
    }

    @Override // h.a.l
    public void d(j.d.c<? super C> cVar) {
        int i2 = this.f10776c;
        int i3 = this.f10777d;
        if (i2 == i3) {
            this.f10561b.a((h.a.q) new a(cVar, i2, this.f10778e));
        } else if (i3 > i2) {
            this.f10561b.a((h.a.q) new c(cVar, i2, i3, this.f10778e));
        } else {
            this.f10561b.a((h.a.q) new b(cVar, i2, i3, this.f10778e));
        }
    }
}
