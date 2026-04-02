package h.a.y0.e.d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableReplay.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m2<T> extends h.a.z0.a<T> implements h.a.y0.c.g<T>, h.a.u0.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final b f11490e = new o();
    final h.a.g0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference<j<T>> f11491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final b<T> f11492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final h.a.g0<T> f11493d;

    /* JADX INFO: compiled from: ObservableReplay.java */
    static abstract class a<T> extends AtomicReference<f> implements h<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        int size;
        f tail;

        a() {
            f fVar = new f(null);
            this.tail = fVar;
            set(fVar);
        }

        final void addLast(f fVar) {
            this.tail.set(fVar);
            this.tail = fVar;
            this.size++;
        }

        final void collect(Collection<? super T> collection) {
            f head = getHead();
            while (true) {
                head = head.get();
                if (head == null) {
                    return;
                }
                Object objLeaveTransform = leaveTransform(head.value);
                if (h.a.y0.j.q.isComplete(objLeaveTransform) || h.a.y0.j.q.isError(objLeaveTransform)) {
                    return;
                } else {
                    collection.add((Object) h.a.y0.j.q.getValue(objLeaveTransform));
                }
            }
        }

        @Override // h.a.y0.e.d.m2.h
        public final void complete() {
            addLast(new f(enterTransform(h.a.y0.j.q.complete())));
            truncateFinal();
        }

        Object enterTransform(Object obj) {
            return obj;
        }

        @Override // h.a.y0.e.d.m2.h
        public final void error(Throwable th) {
            addLast(new f(enterTransform(h.a.y0.j.q.error(th))));
            truncateFinal();
        }

        f getHead() {
            return get();
        }

        boolean hasCompleted() {
            Object obj = this.tail.value;
            return obj != null && h.a.y0.j.q.isComplete(leaveTransform(obj));
        }

        boolean hasError() {
            Object obj = this.tail.value;
            return obj != null && h.a.y0.j.q.isError(leaveTransform(obj));
        }

        Object leaveTransform(Object obj) {
            return obj;
        }

        @Override // h.a.y0.e.d.m2.h
        public final void next(T t) {
            addLast(new f(enterTransform(h.a.y0.j.q.next(t))));
            truncate();
        }

        final void removeFirst() {
            this.size--;
            setFirst(get().get());
        }

        final void removeSome(int i2) {
            f fVar = get();
            while (i2 > 0) {
                fVar = fVar.get();
                i2--;
                this.size--;
            }
            setFirst(fVar);
        }

        @Override // h.a.y0.e.d.m2.h
        public final void replay(d<T> dVar) {
            if (dVar.getAndIncrement() != 0) {
                return;
            }
            int iAddAndGet = 1;
            do {
                f head = (f) dVar.index();
                if (head == null) {
                    head = getHead();
                    dVar.index = head;
                }
                while (!dVar.isDisposed()) {
                    f fVar = head.get();
                    if (fVar == null) {
                        dVar.index = head;
                        iAddAndGet = dVar.addAndGet(-iAddAndGet);
                    } else {
                        if (h.a.y0.j.q.accept(leaveTransform(fVar.value), dVar.child)) {
                            dVar.index = null;
                            return;
                        }
                        head = fVar;
                    }
                }
                return;
            } while (iAddAndGet != 0);
        }

        final void setFirst(f fVar) {
            set(fVar);
        }

        abstract void truncate();

        void truncateFinal() {
        }
    }

    /* JADX INFO: compiled from: ObservableReplay.java */
    interface b<T> {
        h<T> call();
    }

    /* JADX INFO: compiled from: ObservableReplay.java */
    static final class c<R> implements h.a.x0.g<h.a.u0.c> {
        private final h4<R> a;

        c(h4<R> h4Var) {
            this.a = h4Var;
        }

        @Override // h.a.x0.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(h.a.u0.c cVar) {
            this.a.setResource(cVar);
        }
    }

    /* JADX INFO: compiled from: ObservableReplay.java */
    static final class d<T> extends AtomicInteger implements h.a.u0.c {
        private static final long serialVersionUID = 2728361546769921047L;
        volatile boolean cancelled;
        final h.a.i0<? super T> child;
        Object index;
        final j<T> parent;

        d(j<T> jVar, h.a.i0<? super T> i0Var) {
            this.parent = jVar;
            this.child = i0Var;
        }

        @Override // h.a.u0.c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.parent.remove(this);
        }

        <U> U index() {
            return (U) this.index;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    /* JADX INFO: compiled from: ObservableReplay.java */
    static final class e<R, U> extends h.a.b0<R> {
        private final Callable<? extends h.a.z0.a<U>> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final h.a.x0.o<? super h.a.b0<U>, ? extends h.a.g0<R>> f11494b;

        e(Callable<? extends h.a.z0.a<U>> callable, h.a.x0.o<? super h.a.b0<U>, ? extends h.a.g0<R>> oVar) {
            this.a = callable;
            this.f11494b = oVar;
        }

        @Override // h.a.b0
        protected void d(h.a.i0<? super R> i0Var) {
            try {
                h.a.z0.a aVar = (h.a.z0.a) h.a.y0.b.b.a(this.a.call(), "The connectableFactory returned a null ConnectableObservable");
                h.a.g0 g0Var = (h.a.g0) h.a.y0.b.b.a(this.f11494b.apply(aVar), "The selector returned a null ObservableSource");
                h4 h4Var = new h4(i0Var);
                g0Var.subscribe(h4Var);
                aVar.k((h.a.x0.g<? super h.a.u0.c>) new c(h4Var));
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                h.a.y0.a.e.error(th, i0Var);
            }
        }
    }

    /* JADX INFO: compiled from: ObservableReplay.java */
    static final class f extends AtomicReference<f> {
        private static final long serialVersionUID = 245354315435971818L;
        final Object value;

        f(Object obj) {
            this.value = obj;
        }
    }

    /* JADX INFO: compiled from: ObservableReplay.java */
    static final class g<T> extends h.a.z0.a<T> {
        private final h.a.z0.a<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final h.a.b0<T> f11495b;

        g(h.a.z0.a<T> aVar, h.a.b0<T> b0Var) {
            this.a = aVar;
            this.f11495b = b0Var;
        }

        @Override // h.a.b0
        protected void d(h.a.i0<? super T> i0Var) {
            this.f11495b.subscribe(i0Var);
        }

        @Override // h.a.z0.a
        public void k(h.a.x0.g<? super h.a.u0.c> gVar) {
            this.a.k(gVar);
        }
    }

    /* JADX INFO: compiled from: ObservableReplay.java */
    interface h<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(d<T> dVar);
    }

    /* JADX INFO: compiled from: ObservableReplay.java */
    static final class i<T> implements b<T> {
        private final int a;

        i(int i2) {
            this.a = i2;
        }

        @Override // h.a.y0.e.d.m2.b
        public h<T> call() {
            return new n(this.a);
        }
    }

    /* JADX INFO: compiled from: ObservableReplay.java */
    static final class j<T> extends AtomicReference<h.a.u0.c> implements h.a.i0<T>, h.a.u0.c {
        static final d[] EMPTY = new d[0];
        static final d[] TERMINATED = new d[0];
        private static final long serialVersionUID = -533785617179540163L;
        final h<T> buffer;
        boolean done;
        final AtomicReference<d[]> observers = new AtomicReference<>(EMPTY);
        final AtomicBoolean shouldConnect = new AtomicBoolean();

        j(h<T> hVar) {
            this.buffer = hVar;
        }

        boolean add(d<T> dVar) {
            d[] dVarArr;
            d[] dVarArr2;
            do {
                dVarArr = this.observers.get();
                if (dVarArr == TERMINATED) {
                    return false;
                }
                int length = dVarArr.length;
                dVarArr2 = new d[length + 1];
                System.arraycopy(dVarArr, 0, dVarArr2, 0, length);
                dVarArr2[length] = dVar;
            } while (!this.observers.compareAndSet(dVarArr, dVarArr2));
            return true;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.observers.set(TERMINATED);
            h.a.y0.a.d.dispose(this);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.observers.get() == TERMINATED;
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.buffer.complete();
            replayFinal();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.done) {
                h.a.c1.a.b(th);
                return;
            }
            this.done = true;
            this.buffer.error(th);
            replayFinal();
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            this.buffer.next(t);
            replay();
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.setOnce(this, cVar)) {
                replay();
            }
        }

        void remove(d<T> dVar) {
            d[] dVarArr;
            d[] dVarArr2;
            do {
                dVarArr = this.observers.get();
                int length = dVarArr.length;
                if (length == 0) {
                    return;
                }
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    if (dVarArr[i3].equals(dVar)) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    dVarArr2 = EMPTY;
                } else {
                    d[] dVarArr3 = new d[length - 1];
                    System.arraycopy(dVarArr, 0, dVarArr3, 0, i2);
                    System.arraycopy(dVarArr, i2 + 1, dVarArr3, i2, (length - i2) - 1);
                    dVarArr2 = dVarArr3;
                }
            } while (!this.observers.compareAndSet(dVarArr, dVarArr2));
        }

        void replay() {
            for (d<T> dVar : this.observers.get()) {
                this.buffer.replay(dVar);
            }
        }

        void replayFinal() {
            for (d<T> dVar : this.observers.getAndSet(TERMINATED)) {
                this.buffer.replay(dVar);
            }
        }
    }

    /* JADX INFO: compiled from: ObservableReplay.java */
    static final class k<T> implements h.a.g0<T> {
        private final AtomicReference<j<T>> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b<T> f11496b;

        k(AtomicReference<j<T>> atomicReference, b<T> bVar) {
            this.a = atomicReference;
            this.f11496b = bVar;
        }

        @Override // h.a.g0
        public void subscribe(h.a.i0<? super T> i0Var) {
            j<T> jVar;
            while (true) {
                jVar = this.a.get();
                if (jVar != null) {
                    break;
                }
                j<T> jVar2 = new j<>(this.f11496b.call());
                if (this.a.compareAndSet(null, jVar2)) {
                    jVar = jVar2;
                    break;
                }
            }
            d<T> dVar = new d<>(jVar, i0Var);
            i0Var.onSubscribe(dVar);
            jVar.add(dVar);
            if (dVar.isDisposed()) {
                jVar.remove(dVar);
            } else {
                jVar.buffer.replay(dVar);
            }
        }
    }

    /* JADX INFO: compiled from: ObservableReplay.java */
    static final class l<T> implements b<T> {
        private final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f11497b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final TimeUnit f11498c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final h.a.j0 f11499d;

        l(int i2, long j2, TimeUnit timeUnit, h.a.j0 j0Var) {
            this.a = i2;
            this.f11497b = j2;
            this.f11498c = timeUnit;
            this.f11499d = j0Var;
        }

        @Override // h.a.y0.e.d.m2.b
        public h<T> call() {
            return new m(this.a, this.f11497b, this.f11498c, this.f11499d);
        }
    }

    /* JADX INFO: compiled from: ObservableReplay.java */
    static final class m<T> extends a<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        final int limit;
        final long maxAge;
        final h.a.j0 scheduler;
        final TimeUnit unit;

        m(int i2, long j2, TimeUnit timeUnit, h.a.j0 j0Var) {
            this.scheduler = j0Var;
            this.limit = i2;
            this.maxAge = j2;
            this.unit = timeUnit;
        }

        @Override // h.a.y0.e.d.m2.a
        Object enterTransform(Object obj) {
            return new h.a.e1.c(obj, this.scheduler.a(this.unit), this.unit);
        }

        @Override // h.a.y0.e.d.m2.a
        f getHead() {
            f fVar;
            long jA = this.scheduler.a(this.unit) - this.maxAge;
            f fVar2 = get();
            f fVar3 = fVar2.get();
            while (true) {
                f fVar4 = fVar3;
                fVar = fVar2;
                fVar2 = fVar4;
                if (fVar2 == null) {
                    break;
                }
                h.a.e1.c cVar = (h.a.e1.c) fVar2.value;
                if (h.a.y0.j.q.isComplete(cVar.c()) || h.a.y0.j.q.isError(cVar.c()) || cVar.a() > jA) {
                    break;
                }
                fVar3 = fVar2.get();
            }
            return fVar;
        }

        @Override // h.a.y0.e.d.m2.a
        Object leaveTransform(Object obj) {
            return ((h.a.e1.c) obj).c();
        }

        @Override // h.a.y0.e.d.m2.a
        void truncate() {
            f fVar;
            long jA = this.scheduler.a(this.unit) - this.maxAge;
            f fVar2 = get();
            f fVar3 = fVar2.get();
            int i2 = 0;
            while (true) {
                f fVar4 = fVar3;
                fVar = fVar2;
                fVar2 = fVar4;
                if (fVar2 != null) {
                    int i3 = this.size;
                    if (i3 <= this.limit) {
                        if (((h.a.e1.c) fVar2.value).a() > jA) {
                            break;
                        }
                        i2++;
                        this.size--;
                        fVar3 = fVar2.get();
                    } else {
                        i2++;
                        this.size = i3 - 1;
                        fVar3 = fVar2.get();
                    }
                } else {
                    break;
                }
            }
            if (i2 != 0) {
                setFirst(fVar);
            }
        }

        @Override // h.a.y0.e.d.m2.a
        void truncateFinal() {
            f fVar;
            long jA = this.scheduler.a(this.unit) - this.maxAge;
            f fVar2 = get();
            f fVar3 = fVar2.get();
            int i2 = 0;
            while (true) {
                f fVar4 = fVar3;
                fVar = fVar2;
                fVar2 = fVar4;
                if (fVar2 == null || this.size <= 1 || ((h.a.e1.c) fVar2.value).a() > jA) {
                    break;
                }
                i2++;
                this.size--;
                fVar3 = fVar2.get();
            }
            if (i2 != 0) {
                setFirst(fVar);
            }
        }
    }

    /* JADX INFO: compiled from: ObservableReplay.java */
    static final class n<T> extends a<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        n(int i2) {
            this.limit = i2;
        }

        @Override // h.a.y0.e.d.m2.a
        void truncate() {
            if (this.size > this.limit) {
                removeFirst();
            }
        }
    }

    /* JADX INFO: compiled from: ObservableReplay.java */
    static final class o implements b<Object> {
        o() {
        }

        @Override // h.a.y0.e.d.m2.b
        public h<Object> call() {
            return new p(16);
        }
    }

    /* JADX INFO: compiled from: ObservableReplay.java */
    static final class p<T> extends ArrayList<Object> implements h<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;

        p(int i2) {
            super(i2);
        }

        @Override // h.a.y0.e.d.m2.h
        public void complete() {
            add(h.a.y0.j.q.complete());
            this.size++;
        }

        @Override // h.a.y0.e.d.m2.h
        public void error(Throwable th) {
            add(h.a.y0.j.q.error(th));
            this.size++;
        }

        @Override // h.a.y0.e.d.m2.h
        public void next(T t) {
            add(h.a.y0.j.q.next(t));
            this.size++;
        }

        @Override // h.a.y0.e.d.m2.h
        public void replay(d<T> dVar) {
            if (dVar.getAndIncrement() != 0) {
                return;
            }
            h.a.i0<? super T> i0Var = dVar.child;
            int iAddAndGet = 1;
            while (!dVar.isDisposed()) {
                int i2 = this.size;
                Integer num = (Integer) dVar.index();
                int iIntValue = num != null ? num.intValue() : 0;
                while (iIntValue < i2) {
                    if (h.a.y0.j.q.accept(get(iIntValue), i0Var) || dVar.isDisposed()) {
                        return;
                    } else {
                        iIntValue++;
                    }
                }
                dVar.index = Integer.valueOf(iIntValue);
                iAddAndGet = dVar.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }
    }

    private m2(h.a.g0<T> g0Var, h.a.g0<T> g0Var2, AtomicReference<j<T>> atomicReference, b<T> bVar) {
        this.f11493d = g0Var;
        this.a = g0Var2;
        this.f11491b = atomicReference;
        this.f11492c = bVar;
    }

    public static <U, R> h.a.b0<R> a(Callable<? extends h.a.z0.a<U>> callable, h.a.x0.o<? super h.a.b0<U>, ? extends h.a.g0<R>> oVar) {
        return h.a.c1.a.a(new e(callable, oVar));
    }

    public static <T> h.a.z0.a<T> h(h.a.g0<T> g0Var, int i2) {
        return i2 == Integer.MAX_VALUE ? w(g0Var) : a((h.a.g0) g0Var, (b) new i(i2));
    }

    public static <T> h.a.z0.a<T> w(h.a.g0<? extends T> g0Var) {
        return a((h.a.g0) g0Var, f11490e);
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super T> i0Var) {
        this.f11493d.subscribe(i0Var);
    }

    @Override // h.a.u0.c
    public void dispose() {
        this.f11491b.lazySet(null);
    }

    @Override // h.a.u0.c
    public boolean isDisposed() {
        j<T> jVar = this.f11491b.get();
        return jVar == null || jVar.isDisposed();
    }

    @Override // h.a.z0.a
    public void k(h.a.x0.g<? super h.a.u0.c> gVar) {
        j<T> jVar;
        while (true) {
            jVar = this.f11491b.get();
            if (jVar != null && !jVar.isDisposed()) {
                break;
            }
            j<T> jVar2 = new j<>(this.f11492c.call());
            if (this.f11491b.compareAndSet(jVar, jVar2)) {
                jVar = jVar2;
                break;
            }
        }
        boolean z = !jVar.shouldConnect.get() && jVar.shouldConnect.compareAndSet(false, true);
        try {
            gVar.accept(jVar);
            if (z) {
                this.a.subscribe(jVar);
            }
        } catch (Throwable th) {
            if (z) {
                jVar.shouldConnect.compareAndSet(true, false);
            }
            h.a.v0.b.b(th);
            throw h.a.y0.j.k.c(th);
        }
    }

    @Override // h.a.y0.c.g
    public h.a.g0<T> source() {
        return this.a;
    }

    public static <T> h.a.z0.a<T> a(h.a.z0.a<T> aVar, h.a.j0 j0Var) {
        return h.a.c1.a.a((h.a.z0.a) new g(aVar, aVar.a(j0Var)));
    }

    public static <T> h.a.z0.a<T> a(h.a.g0<T> g0Var, long j2, TimeUnit timeUnit, h.a.j0 j0Var) {
        return a(g0Var, j2, timeUnit, j0Var, Integer.MAX_VALUE);
    }

    public static <T> h.a.z0.a<T> a(h.a.g0<T> g0Var, long j2, TimeUnit timeUnit, h.a.j0 j0Var, int i2) {
        return a((h.a.g0) g0Var, (b) new l(i2, j2, timeUnit, j0Var));
    }

    static <T> h.a.z0.a<T> a(h.a.g0<T> g0Var, b<T> bVar) {
        AtomicReference atomicReference = new AtomicReference();
        return h.a.c1.a.a((h.a.z0.a) new m2(new k(atomicReference, bVar), g0Var, atomicReference, bVar));
    }
}
