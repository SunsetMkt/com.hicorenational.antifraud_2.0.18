package p251g.p252a.p268y0.p273e.p277d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p257e1.C4490c;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4608g;
import p251g.p252a.p268y0.p284j.C5171k;
import p251g.p252a.p268y0.p284j.EnumC5177q;
import p251g.p252a.p285z0.AbstractC5187a;

/* compiled from: ObservableReplay.java */
/* renamed from: g.a.y0.e.d.m2 */
/* loaded from: classes2.dex */
public final class C4978m2<T> extends AbstractC5187a<T> implements InterfaceC4608g<T>, InterfaceC4552c {

    /* renamed from: e */
    static final b f19173e = new o();

    /* renamed from: a */
    final InterfaceC4504g0<T> f19174a;

    /* renamed from: b */
    final AtomicReference<j<T>> f19175b;

    /* renamed from: c */
    final b<T> f19176c;

    /* renamed from: d */
    final InterfaceC4504g0<T> f19177d;

    /* compiled from: ObservableReplay.java */
    /* renamed from: g.a.y0.e.d.m2$a */
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
                Object leaveTransform = leaveTransform(head.value);
                if (EnumC5177q.isComplete(leaveTransform) || EnumC5177q.isError(leaveTransform)) {
                    return;
                } else {
                    collection.add((Object) EnumC5177q.getValue(leaveTransform));
                }
            }
        }

        @Override // p251g.p252a.p268y0.p273e.p277d.C4978m2.h
        public final void complete() {
            addLast(new f(enterTransform(EnumC5177q.complete())));
            truncateFinal();
        }

        Object enterTransform(Object obj) {
            return obj;
        }

        @Override // p251g.p252a.p268y0.p273e.p277d.C4978m2.h
        public final void error(Throwable th) {
            addLast(new f(enterTransform(EnumC5177q.error(th))));
            truncateFinal();
        }

        f getHead() {
            return get();
        }

        boolean hasCompleted() {
            Object obj = this.tail.value;
            return obj != null && EnumC5177q.isComplete(leaveTransform(obj));
        }

        boolean hasError() {
            Object obj = this.tail.value;
            return obj != null && EnumC5177q.isError(leaveTransform(obj));
        }

        Object leaveTransform(Object obj) {
            return obj;
        }

        @Override // p251g.p252a.p268y0.p273e.p277d.C4978m2.h
        public final void next(T t) {
            addLast(new f(enterTransform(EnumC5177q.next(t))));
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

        @Override // p251g.p252a.p268y0.p273e.p277d.C4978m2.h
        public final void replay(d<T> dVar) {
            if (dVar.getAndIncrement() != 0) {
                return;
            }
            int i2 = 1;
            do {
                f fVar = (f) dVar.index();
                if (fVar == null) {
                    fVar = getHead();
                    dVar.index = fVar;
                }
                while (!dVar.isDisposed()) {
                    f fVar2 = fVar.get();
                    if (fVar2 == null) {
                        dVar.index = fVar;
                        i2 = dVar.addAndGet(-i2);
                    } else {
                        if (EnumC5177q.accept(leaveTransform(fVar2.value), dVar.child)) {
                            dVar.index = null;
                            return;
                        }
                        fVar = fVar2;
                    }
                }
                return;
            } while (i2 != 0);
        }

        final void setFirst(f fVar) {
            set(fVar);
        }

        abstract void truncate();

        void truncateFinal() {
        }
    }

    /* compiled from: ObservableReplay.java */
    /* renamed from: g.a.y0.e.d.m2$b */
    interface b<T> {
        h<T> call();
    }

    /* compiled from: ObservableReplay.java */
    /* renamed from: g.a.y0.e.d.m2$c */
    static final class c<R> implements InterfaceC4576g<InterfaceC4552c> {

        /* renamed from: a */
        private final C4954h4<R> f19178a;

        c(C4954h4<R> c4954h4) {
            this.f19178a = c4954h4;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4576g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(InterfaceC4552c interfaceC4552c) {
            this.f19178a.setResource(interfaceC4552c);
        }
    }

    /* compiled from: ObservableReplay.java */
    /* renamed from: g.a.y0.e.d.m2$d */
    static final class d<T> extends AtomicInteger implements InterfaceC4552c {
        private static final long serialVersionUID = 2728361546769921047L;
        volatile boolean cancelled;
        final InterfaceC4514i0<? super T> child;
        Object index;
        final j<T> parent;

        d(j<T> jVar, InterfaceC4514i0<? super T> interfaceC4514i0) {
            this.parent = jVar;
            this.child = interfaceC4514i0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
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

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    /* compiled from: ObservableReplay.java */
    /* renamed from: g.a.y0.e.d.m2$e */
    static final class e<R, U> extends AbstractC4469b0<R> {

        /* renamed from: a */
        private final Callable<? extends AbstractC5187a<U>> f19179a;

        /* renamed from: b */
        private final InterfaceC4584o<? super AbstractC4469b0<U>, ? extends InterfaceC4504g0<R>> f19180b;

        e(Callable<? extends AbstractC5187a<U>> callable, InterfaceC4584o<? super AbstractC4469b0<U>, ? extends InterfaceC4504g0<R>> interfaceC4584o) {
            this.f19179a = callable;
            this.f19180b = interfaceC4584o;
        }

        @Override // p251g.p252a.AbstractC4469b0
        /* renamed from: d */
        protected void mo16855d(InterfaceC4514i0<? super R> interfaceC4514i0) {
            try {
                AbstractC5187a abstractC5187a = (AbstractC5187a) C4601b.m18284a(this.f19179a.call(), "The connectableFactory returned a null ConnectableObservable");
                InterfaceC4504g0 interfaceC4504g0 = (InterfaceC4504g0) C4601b.m18284a(this.f19180b.apply(abstractC5187a), "The selector returned a null ObservableSource");
                C4954h4 c4954h4 = new C4954h4(interfaceC4514i0);
                interfaceC4504g0.subscribe(c4954h4);
                abstractC5187a.mo18422k((InterfaceC4576g<? super InterfaceC4552c>) new c(c4954h4));
            } catch (Throwable th) {
                C4561b.m18199b(th);
                EnumC4593e.error(th, interfaceC4514i0);
            }
        }
    }

    /* compiled from: ObservableReplay.java */
    /* renamed from: g.a.y0.e.d.m2$f */
    static final class f extends AtomicReference<f> {
        private static final long serialVersionUID = 245354315435971818L;
        final Object value;

        f(Object obj) {
            this.value = obj;
        }
    }

    /* compiled from: ObservableReplay.java */
    /* renamed from: g.a.y0.e.d.m2$g */
    static final class g<T> extends AbstractC5187a<T> {

        /* renamed from: a */
        private final AbstractC5187a<T> f19181a;

        /* renamed from: b */
        private final AbstractC4469b0<T> f19182b;

        g(AbstractC5187a<T> abstractC5187a, AbstractC4469b0<T> abstractC4469b0) {
            this.f19181a = abstractC5187a;
            this.f19182b = abstractC4469b0;
        }

        @Override // p251g.p252a.AbstractC4469b0
        /* renamed from: d */
        protected void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
            this.f19182b.subscribe(interfaceC4514i0);
        }

        @Override // p251g.p252a.p285z0.AbstractC5187a
        /* renamed from: k */
        public void mo18422k(InterfaceC4576g<? super InterfaceC4552c> interfaceC4576g) {
            this.f19181a.mo18422k(interfaceC4576g);
        }
    }

    /* compiled from: ObservableReplay.java */
    /* renamed from: g.a.y0.e.d.m2$h */
    interface h<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(d<T> dVar);
    }

    /* compiled from: ObservableReplay.java */
    /* renamed from: g.a.y0.e.d.m2$i */
    static final class i<T> implements b<T> {

        /* renamed from: a */
        private final int f19183a;

        i(int i2) {
            this.f19183a = i2;
        }

        @Override // p251g.p252a.p268y0.p273e.p277d.C4978m2.b
        public h<T> call() {
            return new n(this.f19183a);
        }
    }

    /* compiled from: ObservableReplay.java */
    /* renamed from: g.a.y0.e.d.m2$j */
    static final class j<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4514i0<T>, InterfaceC4552c {
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

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.observers.set(TERMINATED);
            EnumC4592d.dispose(this);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.observers.get() == TERMINATED;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.buffer.complete();
            replayFinal();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.done) {
                C4476a.m17152b(th);
                return;
            }
            this.done = true;
            this.buffer.error(th);
            replayFinal();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            this.buffer.next(t);
            replay();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.setOnce(this, interfaceC4552c)) {
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

    /* compiled from: ObservableReplay.java */
    /* renamed from: g.a.y0.e.d.m2$k */
    static final class k<T> implements InterfaceC4504g0<T> {

        /* renamed from: a */
        private final AtomicReference<j<T>> f19184a;

        /* renamed from: b */
        private final b<T> f19185b;

        k(AtomicReference<j<T>> atomicReference, b<T> bVar) {
            this.f19184a = atomicReference;
            this.f19185b = bVar;
        }

        @Override // p251g.p252a.InterfaceC4504g0
        public void subscribe(InterfaceC4514i0<? super T> interfaceC4514i0) {
            j<T> jVar;
            while (true) {
                jVar = this.f19184a.get();
                if (jVar != null) {
                    break;
                }
                j<T> jVar2 = new j<>(this.f19185b.call());
                if (this.f19184a.compareAndSet(null, jVar2)) {
                    jVar = jVar2;
                    break;
                }
            }
            d<T> dVar = new d<>(jVar, interfaceC4514i0);
            interfaceC4514i0.onSubscribe(dVar);
            jVar.add(dVar);
            if (dVar.isDisposed()) {
                jVar.remove(dVar);
            } else {
                jVar.buffer.replay(dVar);
            }
        }
    }

    /* compiled from: ObservableReplay.java */
    /* renamed from: g.a.y0.e.d.m2$l */
    static final class l<T> implements b<T> {

        /* renamed from: a */
        private final int f19186a;

        /* renamed from: b */
        private final long f19187b;

        /* renamed from: c */
        private final TimeUnit f19188c;

        /* renamed from: d */
        private final AbstractC4516j0 f19189d;

        l(int i2, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
            this.f19186a = i2;
            this.f19187b = j2;
            this.f19188c = timeUnit;
            this.f19189d = abstractC4516j0;
        }

        @Override // p251g.p252a.p268y0.p273e.p277d.C4978m2.b
        public h<T> call() {
            return new m(this.f19186a, this.f19187b, this.f19188c, this.f19189d);
        }
    }

    /* compiled from: ObservableReplay.java */
    /* renamed from: g.a.y0.e.d.m2$m */
    static final class m<T> extends a<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        final int limit;
        final long maxAge;
        final AbstractC4516j0 scheduler;
        final TimeUnit unit;

        m(int i2, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
            this.scheduler = abstractC4516j0;
            this.limit = i2;
            this.maxAge = j2;
            this.unit = timeUnit;
        }

        @Override // p251g.p252a.p268y0.p273e.p277d.C4978m2.a
        Object enterTransform(Object obj) {
            return new C4490c(obj, this.scheduler.mo17276a(this.unit), this.unit);
        }

        @Override // p251g.p252a.p268y0.p273e.p277d.C4978m2.a
        f getHead() {
            f fVar;
            long mo17276a = this.scheduler.mo17276a(this.unit) - this.maxAge;
            f fVar2 = get();
            f fVar3 = fVar2.get();
            while (true) {
                f fVar4 = fVar3;
                fVar = fVar2;
                fVar2 = fVar4;
                if (fVar2 != null) {
                    C4490c c4490c = (C4490c) fVar2.value;
                    if (EnumC5177q.isComplete(c4490c.m17288c()) || EnumC5177q.isError(c4490c.m17288c()) || c4490c.m17285a() > mo17276a) {
                        break;
                    }
                    fVar3 = fVar2.get();
                } else {
                    break;
                }
            }
            return fVar;
        }

        @Override // p251g.p252a.p268y0.p273e.p277d.C4978m2.a
        Object leaveTransform(Object obj) {
            return ((C4490c) obj).m17288c();
        }

        @Override // p251g.p252a.p268y0.p273e.p277d.C4978m2.a
        void truncate() {
            f fVar;
            long mo17276a = this.scheduler.mo17276a(this.unit) - this.maxAge;
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
                        if (((C4490c) fVar2.value).m17285a() > mo17276a) {
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

        /* JADX WARN: Code restructure failed: missing block: B:11:0x003e, code lost:
        
            setFirst(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0041, code lost:
        
            return;
         */
        @Override // p251g.p252a.p268y0.p273e.p277d.C4978m2.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void truncateFinal() {
            /*
                r10 = this;
                g.a.j0 r0 = r10.scheduler
                java.util.concurrent.TimeUnit r1 = r10.unit
                long r0 = r0.mo17276a(r1)
                long r2 = r10.maxAge
                long r0 = r0 - r2
                java.lang.Object r2 = r10.get()
                g.a.y0.e.d.m2$f r2 = (p251g.p252a.p268y0.p273e.p277d.C4978m2.f) r2
                java.lang.Object r3 = r2.get()
                g.a.y0.e.d.m2$f r3 = (p251g.p252a.p268y0.p273e.p277d.C4978m2.f) r3
                r4 = 0
            L18:
                r9 = r3
                r3 = r2
                r2 = r9
                if (r2 == 0) goto L3c
                int r5 = r10.size
                r6 = 1
                if (r5 <= r6) goto L3c
                java.lang.Object r5 = r2.value
                g.a.e1.c r5 = (p251g.p252a.p257e1.C4490c) r5
                long r7 = r5.m17285a()
                int r5 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r5 > 0) goto L3c
                int r4 = r4 + 1
                int r3 = r10.size
                int r3 = r3 - r6
                r10.size = r3
                java.lang.Object r3 = r2.get()
                g.a.y0.e.d.m2$f r3 = (p251g.p252a.p268y0.p273e.p277d.C4978m2.f) r3
                goto L18
            L3c:
                if (r4 == 0) goto L41
                r10.setFirst(r3)
            L41:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p251g.p252a.p268y0.p273e.p277d.C4978m2.m.truncateFinal():void");
        }
    }

    /* compiled from: ObservableReplay.java */
    /* renamed from: g.a.y0.e.d.m2$n */
    static final class n<T> extends a<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        n(int i2) {
            this.limit = i2;
        }

        @Override // p251g.p252a.p268y0.p273e.p277d.C4978m2.a
        void truncate() {
            if (this.size > this.limit) {
                removeFirst();
            }
        }
    }

    /* compiled from: ObservableReplay.java */
    /* renamed from: g.a.y0.e.d.m2$o */
    static final class o implements b<Object> {
        o() {
        }

        @Override // p251g.p252a.p268y0.p273e.p277d.C4978m2.b
        public h<Object> call() {
            return new p(16);
        }
    }

    /* compiled from: ObservableReplay.java */
    /* renamed from: g.a.y0.e.d.m2$p */
    static final class p<T> extends ArrayList<Object> implements h<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;

        p(int i2) {
            super(i2);
        }

        @Override // p251g.p252a.p268y0.p273e.p277d.C4978m2.h
        public void complete() {
            add(EnumC5177q.complete());
            this.size++;
        }

        @Override // p251g.p252a.p268y0.p273e.p277d.C4978m2.h
        public void error(Throwable th) {
            add(EnumC5177q.error(th));
            this.size++;
        }

        @Override // p251g.p252a.p268y0.p273e.p277d.C4978m2.h
        public void next(T t) {
            add(EnumC5177q.next(t));
            this.size++;
        }

        @Override // p251g.p252a.p268y0.p273e.p277d.C4978m2.h
        public void replay(d<T> dVar) {
            if (dVar.getAndIncrement() != 0) {
                return;
            }
            InterfaceC4514i0<? super T> interfaceC4514i0 = dVar.child;
            int i2 = 1;
            while (!dVar.isDisposed()) {
                int i3 = this.size;
                Integer num = (Integer) dVar.index();
                int intValue = num != null ? num.intValue() : 0;
                while (intValue < i3) {
                    if (EnumC5177q.accept(get(intValue), interfaceC4514i0) || dVar.isDisposed()) {
                        return;
                    } else {
                        intValue++;
                    }
                }
                dVar.index = Integer.valueOf(intValue);
                i2 = dVar.addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
        }
    }

    private C4978m2(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4504g0<T> interfaceC4504g02, AtomicReference<j<T>> atomicReference, b<T> bVar) {
        this.f19177d = interfaceC4504g0;
        this.f19174a = interfaceC4504g02;
        this.f19175b = atomicReference;
        this.f19176c = bVar;
    }

    /* renamed from: a */
    public static <U, R> AbstractC4469b0<R> m18487a(Callable<? extends AbstractC5187a<U>> callable, InterfaceC4584o<? super AbstractC4469b0<U>, ? extends InterfaceC4504g0<R>> interfaceC4584o) {
        return C4476a.m17119a(new e(callable, interfaceC4584o));
    }

    /* renamed from: h */
    public static <T> AbstractC5187a<T> m18492h(InterfaceC4504g0<T> interfaceC4504g0, int i2) {
        return i2 == Integer.MAX_VALUE ? m18493w(interfaceC4504g0) : m18490a((InterfaceC4504g0) interfaceC4504g0, (b) new i(i2));
    }

    /* renamed from: w */
    public static <T> AbstractC5187a<T> m18493w(InterfaceC4504g0<? extends T> interfaceC4504g0) {
        return m18490a((InterfaceC4504g0) interfaceC4504g0, f19173e);
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f19177d.subscribe(interfaceC4514i0);
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
        this.f19175b.lazySet(null);
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        j<T> jVar = this.f19175b.get();
        return jVar == null || jVar.isDisposed();
    }

    @Override // p251g.p252a.p285z0.AbstractC5187a
    /* renamed from: k */
    public void mo18422k(InterfaceC4576g<? super InterfaceC4552c> interfaceC4576g) {
        j<T> jVar;
        while (true) {
            jVar = this.f19175b.get();
            if (jVar != null && !jVar.isDisposed()) {
                break;
            }
            j<T> jVar2 = new j<>(this.f19176c.call());
            if (this.f19175b.compareAndSet(jVar, jVar2)) {
                jVar = jVar2;
                break;
            }
        }
        boolean z = !jVar.shouldConnect.get() && jVar.shouldConnect.compareAndSet(false, true);
        try {
            interfaceC4576g.accept(jVar);
            if (z) {
                this.f19174a.subscribe(jVar);
            }
        } catch (Throwable th) {
            if (z) {
                jVar.shouldConnect.compareAndSet(true, false);
            }
            C4561b.m18199b(th);
            throw C5171k.m18626c(th);
        }
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4608g
    public InterfaceC4504g0<T> source() {
        return this.f19174a;
    }

    /* renamed from: a */
    public static <T> AbstractC5187a<T> m18491a(AbstractC5187a<T> abstractC5187a, AbstractC4516j0 abstractC4516j0) {
        return C4476a.m17135a((AbstractC5187a) new g(abstractC5187a, abstractC5187a.m16706a(abstractC4516j0)));
    }

    /* renamed from: a */
    public static <T> AbstractC5187a<T> m18488a(InterfaceC4504g0<T> interfaceC4504g0, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        return m18489a(interfaceC4504g0, j2, timeUnit, abstractC4516j0, Integer.MAX_VALUE);
    }

    /* renamed from: a */
    public static <T> AbstractC5187a<T> m18489a(InterfaceC4504g0<T> interfaceC4504g0, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, int i2) {
        return m18490a((InterfaceC4504g0) interfaceC4504g0, (b) new l(i2, j2, timeUnit, abstractC4516j0));
    }

    /* renamed from: a */
    static <T> AbstractC5187a<T> m18490a(InterfaceC4504g0<T> interfaceC4504g0, b<T> bVar) {
        AtomicReference atomicReference = new AtomicReference();
        return C4476a.m17135a((AbstractC5187a) new C4978m2(new k(atomicReference, bVar), interfaceC4504g0, atomicReference, bVar));
    }
}
