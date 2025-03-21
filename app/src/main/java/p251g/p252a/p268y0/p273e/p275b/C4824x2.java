package p251g.p252a.p268y0.p273e.p275b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p257e1.C4490c;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p266w0.AbstractC4567a;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4609h;
import p251g.p252a.p268y0.p282h.C5150u;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p251g.p252a.p268y0.p284j.C5171k;
import p251g.p252a.p268y0.p284j.EnumC5177q;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableReplay.java */
/* renamed from: g.a.y0.e.b.x2 */
/* loaded from: classes2.dex */
public final class C4824x2<T> extends AbstractC4567a<T> implements InterfaceC4609h<T>, InterfaceC4552c {

    /* renamed from: f */
    static final Callable f18490f = new c();

    /* renamed from: b */
    final AbstractC4519l<T> f18491b;

    /* renamed from: c */
    final AtomicReference<j<T>> f18492c;

    /* renamed from: d */
    final Callable<? extends g<T>> f18493d;

    /* renamed from: e */
    final InterfaceC5821b<T> f18494e;

    /* compiled from: FlowableReplay.java */
    /* renamed from: g.a.y0.e.b.x2$a */
    static class a<T> extends AtomicReference<f> implements g<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        long index;
        int size;
        f tail;

        a() {
            f fVar = new f(null, 0L);
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

        @Override // p251g.p252a.p268y0.p273e.p275b.C4824x2.g
        public final void complete() {
            Object enterTransform = enterTransform(EnumC5177q.complete());
            long j2 = this.index + 1;
            this.index = j2;
            addLast(new f(enterTransform, j2));
            truncateFinal();
        }

        Object enterTransform(Object obj) {
            return obj;
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4824x2.g
        public final void error(Throwable th) {
            Object enterTransform = enterTransform(EnumC5177q.error(th));
            long j2 = this.index + 1;
            this.index = j2;
            addLast(new f(enterTransform, j2));
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

        @Override // p251g.p252a.p268y0.p273e.p275b.C4824x2.g
        public final void next(T t) {
            Object enterTransform = enterTransform(EnumC5177q.next(t));
            long j2 = this.index + 1;
            this.index = j2;
            addLast(new f(enterTransform, j2));
            truncate();
        }

        final void removeFirst() {
            f fVar = get().get();
            if (fVar == null) {
                throw new IllegalStateException("Empty list!");
            }
            this.size--;
            setFirst(fVar);
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

        @Override // p251g.p252a.p268y0.p273e.p275b.C4824x2.g
        public final void replay(d<T> dVar) {
            f fVar;
            synchronized (dVar) {
                if (dVar.emitting) {
                    dVar.missed = true;
                    return;
                }
                dVar.emitting = true;
                while (!dVar.isDisposed()) {
                    long j2 = dVar.get();
                    boolean z = j2 == C5556m0.f20396b;
                    f fVar2 = (f) dVar.index();
                    if (fVar2 == null) {
                        fVar2 = getHead();
                        dVar.index = fVar2;
                        C5164d.m18607a(dVar.totalRequested, fVar2.index);
                    }
                    long j3 = 0;
                    while (j2 != 0 && (fVar = fVar2.get()) != null) {
                        Object leaveTransform = leaveTransform(fVar.value);
                        try {
                            if (EnumC5177q.accept(leaveTransform, dVar.child)) {
                                dVar.index = null;
                                return;
                            }
                            j3++;
                            j2--;
                            if (dVar.isDisposed()) {
                                return;
                            } else {
                                fVar2 = fVar;
                            }
                        } catch (Throwable th) {
                            C4561b.m18199b(th);
                            dVar.index = null;
                            dVar.dispose();
                            if (EnumC5177q.isError(leaveTransform) || EnumC5177q.isComplete(leaveTransform)) {
                                return;
                            }
                            dVar.child.onError(th);
                            return;
                        }
                    }
                    if (j3 != 0) {
                        dVar.index = fVar2;
                        if (!z) {
                            dVar.produced(j3);
                        }
                    }
                    synchronized (dVar) {
                        if (!dVar.missed) {
                            dVar.emitting = false;
                            return;
                        }
                        dVar.missed = false;
                    }
                }
            }
        }

        final void setFirst(f fVar) {
            set(fVar);
        }

        void truncate() {
        }

        void truncateFinal() {
        }
    }

    /* compiled from: FlowableReplay.java */
    /* renamed from: g.a.y0.e.b.x2$b */
    static final class b<T> extends AbstractC4567a<T> {

        /* renamed from: b */
        private final AbstractC4567a<T> f18495b;

        /* renamed from: c */
        private final AbstractC4519l<T> f18496c;

        b(AbstractC4567a<T> abstractC4567a, AbstractC4519l<T> abstractC4519l) {
            this.f18495b = abstractC4567a;
            this.f18496c = abstractC4519l;
        }

        @Override // p251g.p252a.AbstractC4519l
        /* renamed from: d */
        protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
            this.f18496c.subscribe(interfaceC5822c);
        }

        @Override // p251g.p252a.p266w0.AbstractC4567a
        /* renamed from: l */
        public void mo18205l(InterfaceC4576g<? super InterfaceC4552c> interfaceC4576g) {
            this.f18495b.mo18205l(interfaceC4576g);
        }
    }

    /* compiled from: FlowableReplay.java */
    /* renamed from: g.a.y0.e.b.x2$c */
    static final class c implements Callable<Object> {
        c() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return new n(16);
        }
    }

    /* compiled from: FlowableReplay.java */
    /* renamed from: g.a.y0.e.b.x2$d */
    static final class d<T> extends AtomicLong implements InterfaceC5823d, InterfaceC4552c {
        static final long CANCELLED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        final InterfaceC5822c<? super T> child;
        boolean emitting;
        Object index;
        boolean missed;
        final j<T> parent;
        final AtomicLong totalRequested = new AtomicLong();

        d(j<T> jVar, InterfaceC5822c<? super T> interfaceC5822c) {
            this.parent = jVar;
            this.child = interfaceC5822c;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
                this.parent.manageRequests();
            }
        }

        <U> U index() {
            return (U) this.index;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return get() == Long.MIN_VALUE;
        }

        public long produced(long j2) {
            return C5164d.m18611d(this, j2);
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            long j3;
            if (EnumC5160j.validate(j2)) {
                do {
                    j3 = get();
                    if (j3 == Long.MIN_VALUE) {
                        return;
                    }
                    if (j3 >= 0 && j2 == 0) {
                        return;
                    }
                } while (!compareAndSet(j3, C5164d.m18606a(j3, j2)));
                C5164d.m18607a(this.totalRequested, j2);
                this.parent.manageRequests();
                this.parent.buffer.replay(this);
            }
        }
    }

    /* compiled from: FlowableReplay.java */
    /* renamed from: g.a.y0.e.b.x2$e */
    static final class e<R, U> implements InterfaceC5821b<R> {

        /* renamed from: a */
        private final Callable<? extends AbstractC4567a<U>> f18497a;

        /* renamed from: b */
        private final InterfaceC4584o<? super AbstractC4519l<U>, ? extends InterfaceC5821b<R>> f18498b;

        /* compiled from: FlowableReplay.java */
        /* renamed from: g.a.y0.e.b.x2$e$a */
        final class a implements InterfaceC4576g<InterfaceC4552c> {

            /* renamed from: a */
            private final C5150u<R> f18499a;

            a(C5150u<R> c5150u) {
                this.f18499a = c5150u;
            }

            @Override // p251g.p252a.p267x0.InterfaceC4576g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(InterfaceC4552c interfaceC4552c) {
                this.f18499a.setResource(interfaceC4552c);
            }
        }

        e(Callable<? extends AbstractC4567a<U>> callable, InterfaceC4584o<? super AbstractC4519l<U>, ? extends InterfaceC5821b<R>> interfaceC4584o) {
            this.f18497a = callable;
            this.f18498b = interfaceC4584o;
        }

        @Override // p324i.p338d.InterfaceC5821b
        public void subscribe(InterfaceC5822c<? super R> interfaceC5822c) {
            try {
                AbstractC4567a abstractC4567a = (AbstractC4567a) C4601b.m18284a(this.f18497a.call(), "The connectableFactory returned null");
                try {
                    InterfaceC5821b interfaceC5821b = (InterfaceC5821b) C4601b.m18284a(this.f18498b.apply(abstractC4567a), "The selector returned a null Publisher");
                    C5150u c5150u = new C5150u(interfaceC5822c);
                    interfaceC5821b.subscribe(c5150u);
                    abstractC4567a.mo18205l((InterfaceC4576g<? super InterfaceC4552c>) new a(c5150u));
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    EnumC5157g.error(th, interfaceC5822c);
                }
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                EnumC5157g.error(th2, interfaceC5822c);
            }
        }
    }

    /* compiled from: FlowableReplay.java */
    /* renamed from: g.a.y0.e.b.x2$f */
    static final class f extends AtomicReference<f> {
        private static final long serialVersionUID = 245354315435971818L;
        final long index;
        final Object value;

        f(Object obj, long j2) {
            this.value = obj;
            this.index = j2;
        }
    }

    /* compiled from: FlowableReplay.java */
    /* renamed from: g.a.y0.e.b.x2$g */
    interface g<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(d<T> dVar);
    }

    /* compiled from: FlowableReplay.java */
    /* renamed from: g.a.y0.e.b.x2$h */
    static final class h<T> implements Callable<g<T>> {

        /* renamed from: a */
        private final int f18501a;

        h(int i2) {
            this.f18501a = i2;
        }

        @Override // java.util.concurrent.Callable
        public g<T> call() {
            return new m(this.f18501a);
        }
    }

    /* compiled from: FlowableReplay.java */
    /* renamed from: g.a.y0.e.b.x2$i */
    static final class i<T> implements InterfaceC5821b<T> {

        /* renamed from: a */
        private final AtomicReference<j<T>> f18502a;

        /* renamed from: b */
        private final Callable<? extends g<T>> f18503b;

        i(AtomicReference<j<T>> atomicReference, Callable<? extends g<T>> callable) {
            this.f18502a = atomicReference;
            this.f18503b = callable;
        }

        @Override // p324i.p338d.InterfaceC5821b
        public void subscribe(InterfaceC5822c<? super T> interfaceC5822c) {
            j<T> jVar;
            while (true) {
                jVar = this.f18502a.get();
                if (jVar != null) {
                    break;
                }
                try {
                    j<T> jVar2 = new j<>(this.f18503b.call());
                    if (this.f18502a.compareAndSet(null, jVar2)) {
                        jVar = jVar2;
                        break;
                    }
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    throw C5171k.m18626c(th);
                }
            }
            d<T> dVar = new d<>(jVar, interfaceC5822c);
            interfaceC5822c.onSubscribe(dVar);
            jVar.add(dVar);
            if (dVar.isDisposed()) {
                jVar.remove(dVar);
            } else {
                jVar.manageRequests();
                jVar.buffer.replay(dVar);
            }
        }
    }

    /* compiled from: FlowableReplay.java */
    /* renamed from: g.a.y0.e.b.x2$j */
    static final class j<T> extends AtomicReference<InterfaceC5823d> implements InterfaceC4529q<T>, InterfaceC4552c {
        static final d[] EMPTY = new d[0];
        static final d[] TERMINATED = new d[0];
        private static final long serialVersionUID = 7224554242710036740L;
        final g<T> buffer;
        boolean done;
        long maxChildRequested;
        long maxUpstreamRequested;
        final AtomicInteger management = new AtomicInteger();
        final AtomicReference<d<T>[]> subscribers = new AtomicReference<>(EMPTY);
        final AtomicBoolean shouldConnect = new AtomicBoolean();

        j(g<T> gVar) {
            this.buffer = gVar;
        }

        boolean add(d<T> dVar) {
            d<T>[] dVarArr;
            d<T>[] dVarArr2;
            if (dVar == null) {
                throw new NullPointerException();
            }
            do {
                dVarArr = this.subscribers.get();
                if (dVarArr == TERMINATED) {
                    return false;
                }
                int length = dVarArr.length;
                dVarArr2 = new d[length + 1];
                System.arraycopy(dVarArr, 0, dVarArr2, 0, length);
                dVarArr2[length] = dVar;
            } while (!this.subscribers.compareAndSet(dVarArr, dVarArr2));
            return true;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.subscribers.set(TERMINATED);
            EnumC5160j.cancel(this);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.subscribers.get() == TERMINATED;
        }

        void manageRequests() {
            if (this.management.getAndIncrement() != 0) {
                return;
            }
            int i2 = 1;
            while (!isDisposed()) {
                d<T>[] dVarArr = this.subscribers.get();
                long j2 = this.maxChildRequested;
                long j3 = j2;
                for (d<T> dVar : dVarArr) {
                    j3 = Math.max(j3, dVar.totalRequested.get());
                }
                long j4 = this.maxUpstreamRequested;
                InterfaceC5823d interfaceC5823d = get();
                long j5 = j3 - j2;
                if (j5 != 0) {
                    this.maxChildRequested = j3;
                    if (interfaceC5823d == null) {
                        long j6 = j4 + j5;
                        if (j6 < 0) {
                            j6 = C5556m0.f20396b;
                        }
                        this.maxUpstreamRequested = j6;
                    } else if (j4 != 0) {
                        this.maxUpstreamRequested = 0L;
                        interfaceC5823d.request(j4 + j5);
                    } else {
                        interfaceC5823d.request(j5);
                    }
                } else if (j4 != 0 && interfaceC5823d != null) {
                    this.maxUpstreamRequested = 0L;
                    interfaceC5823d.request(j4);
                }
                i2 = this.management.addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.buffer.complete();
            for (d<T> dVar : this.subscribers.getAndSet(TERMINATED)) {
                this.buffer.replay(dVar);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.done) {
                C4476a.m17152b(th);
                return;
            }
            this.done = true;
            this.buffer.error(th);
            for (d<T> dVar : this.subscribers.getAndSet(TERMINATED)) {
                this.buffer.replay(dVar);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            this.buffer.next(t);
            for (d<T> dVar : this.subscribers.get()) {
                this.buffer.replay(dVar);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.setOnce(this, interfaceC5823d)) {
                manageRequests();
                for (d<T> dVar : this.subscribers.get()) {
                    this.buffer.replay(dVar);
                }
            }
        }

        void remove(d<T> dVar) {
            d<T>[] dVarArr;
            d<T>[] dVarArr2;
            do {
                dVarArr = this.subscribers.get();
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
                    d<T>[] dVarArr3 = new d[length - 1];
                    System.arraycopy(dVarArr, 0, dVarArr3, 0, i2);
                    System.arraycopy(dVarArr, i2 + 1, dVarArr3, i2, (length - i2) - 1);
                    dVarArr2 = dVarArr3;
                }
            } while (!this.subscribers.compareAndSet(dVarArr, dVarArr2));
        }
    }

    /* compiled from: FlowableReplay.java */
    /* renamed from: g.a.y0.e.b.x2$k */
    static final class k<T> implements Callable<g<T>> {

        /* renamed from: a */
        private final int f18504a;

        /* renamed from: b */
        private final long f18505b;

        /* renamed from: c */
        private final TimeUnit f18506c;

        /* renamed from: d */
        private final AbstractC4516j0 f18507d;

        k(int i2, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
            this.f18504a = i2;
            this.f18505b = j2;
            this.f18506c = timeUnit;
            this.f18507d = abstractC4516j0;
        }

        @Override // java.util.concurrent.Callable
        public g<T> call() {
            return new l(this.f18504a, this.f18505b, this.f18506c, this.f18507d);
        }
    }

    /* compiled from: FlowableReplay.java */
    /* renamed from: g.a.y0.e.b.x2$l */
    static final class l<T> extends a<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        final int limit;
        final long maxAge;
        final AbstractC4516j0 scheduler;
        final TimeUnit unit;

        l(int i2, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
            this.scheduler = abstractC4516j0;
            this.limit = i2;
            this.maxAge = j2;
            this.unit = timeUnit;
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4824x2.a
        Object enterTransform(Object obj) {
            return new C4490c(obj, this.scheduler.mo17276a(this.unit), this.unit);
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4824x2.a
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

        @Override // p251g.p252a.p268y0.p273e.p275b.C4824x2.a
        Object leaveTransform(Object obj) {
            return ((C4490c) obj).m17288c();
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4824x2.a
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
        @Override // p251g.p252a.p268y0.p273e.p275b.C4824x2.a
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
                g.a.y0.e.b.x2$f r2 = (p251g.p252a.p268y0.p273e.p275b.C4824x2.f) r2
                java.lang.Object r3 = r2.get()
                g.a.y0.e.b.x2$f r3 = (p251g.p252a.p268y0.p273e.p275b.C4824x2.f) r3
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
                g.a.y0.e.b.x2$f r3 = (p251g.p252a.p268y0.p273e.p275b.C4824x2.f) r3
                goto L18
            L3c:
                if (r4 == 0) goto L41
                r10.setFirst(r3)
            L41:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p251g.p252a.p268y0.p273e.p275b.C4824x2.l.truncateFinal():void");
        }
    }

    /* compiled from: FlowableReplay.java */
    /* renamed from: g.a.y0.e.b.x2$m */
    static final class m<T> extends a<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        m(int i2) {
            this.limit = i2;
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4824x2.a
        void truncate() {
            if (this.size > this.limit) {
                removeFirst();
            }
        }
    }

    /* compiled from: FlowableReplay.java */
    /* renamed from: g.a.y0.e.b.x2$n */
    static final class n<T> extends ArrayList<Object> implements g<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;

        n(int i2) {
            super(i2);
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4824x2.g
        public void complete() {
            add(EnumC5177q.complete());
            this.size++;
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4824x2.g
        public void error(Throwable th) {
            add(EnumC5177q.error(th));
            this.size++;
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4824x2.g
        public void next(T t) {
            add(EnumC5177q.next(t));
            this.size++;
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4824x2.g
        public void replay(d<T> dVar) {
            synchronized (dVar) {
                if (dVar.emitting) {
                    dVar.missed = true;
                    return;
                }
                dVar.emitting = true;
                InterfaceC5822c<? super T> interfaceC5822c = dVar.child;
                while (!dVar.isDisposed()) {
                    int i2 = this.size;
                    Integer num = (Integer) dVar.index();
                    int intValue = num != null ? num.intValue() : 0;
                    long j2 = dVar.get();
                    long j3 = j2;
                    long j4 = 0;
                    while (j3 != 0 && intValue < i2) {
                        Object obj = get(intValue);
                        try {
                            if (EnumC5177q.accept(obj, interfaceC5822c) || dVar.isDisposed()) {
                                return;
                            }
                            intValue++;
                            j3--;
                            j4++;
                        } catch (Throwable th) {
                            C4561b.m18199b(th);
                            dVar.dispose();
                            if (EnumC5177q.isError(obj) || EnumC5177q.isComplete(obj)) {
                                return;
                            }
                            interfaceC5822c.onError(th);
                            return;
                        }
                    }
                    if (j4 != 0) {
                        dVar.index = Integer.valueOf(intValue);
                        if (j2 != C5556m0.f20396b) {
                            dVar.produced(j4);
                        }
                    }
                    synchronized (dVar) {
                        if (!dVar.missed) {
                            dVar.emitting = false;
                            return;
                        }
                        dVar.missed = false;
                    }
                }
            }
        }
    }

    private C4824x2(InterfaceC5821b<T> interfaceC5821b, AbstractC4519l<T> abstractC4519l, AtomicReference<j<T>> atomicReference, Callable<? extends g<T>> callable) {
        this.f18494e = interfaceC5821b;
        this.f18491b = abstractC4519l;
        this.f18492c = atomicReference;
        this.f18493d = callable;
    }

    /* renamed from: a */
    public static <U, R> AbstractC4519l<R> m18399a(Callable<? extends AbstractC4567a<U>> callable, InterfaceC4584o<? super AbstractC4519l<U>, ? extends InterfaceC5821b<R>> interfaceC4584o) {
        return AbstractC4519l.m17664v(new e(callable, interfaceC4584o));
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f18494e.subscribe(interfaceC5822c);
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
        this.f18492c.lazySet(null);
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        j<T> jVar = this.f18492c.get();
        return jVar == null || jVar.isDisposed();
    }

    @Override // p251g.p252a.p266w0.AbstractC4567a
    /* renamed from: l */
    public void mo18205l(InterfaceC4576g<? super InterfaceC4552c> interfaceC4576g) {
        j<T> jVar;
        while (true) {
            jVar = this.f18492c.get();
            if (jVar != null && !jVar.isDisposed()) {
                break;
            }
            try {
                j<T> jVar2 = new j<>(this.f18493d.call());
                if (this.f18492c.compareAndSet(jVar, jVar2)) {
                    jVar = jVar2;
                    break;
                }
            } finally {
                C4561b.m18199b(th);
                RuntimeException m18626c = C5171k.m18626c(th);
            }
        }
        boolean z = !jVar.shouldConnect.get() && jVar.shouldConnect.compareAndSet(false, true);
        try {
            interfaceC4576g.accept(jVar);
            if (z) {
                this.f18491b.m17799a((InterfaceC4529q) jVar);
            }
        } catch (Throwable th) {
            if (z) {
                jVar.shouldConnect.compareAndSet(true, false);
            }
            throw C5171k.m18626c(th);
        }
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4609h
    public InterfaceC5821b<T> source() {
        return this.f18491b;
    }

    /* renamed from: a */
    public static <T> AbstractC4567a<T> m18405a(AbstractC4567a<T> abstractC4567a, AbstractC4516j0 abstractC4516j0) {
        return C4476a.m17133a((AbstractC4567a) new b(abstractC4567a, abstractC4567a.m17722a(abstractC4516j0)));
    }

    /* renamed from: a */
    public static <T> AbstractC4567a<T> m18400a(AbstractC4519l<? extends T> abstractC4519l) {
        return m18404a((AbstractC4519l) abstractC4519l, f18490f);
    }

    /* renamed from: a */
    public static <T> AbstractC4567a<T> m18401a(AbstractC4519l<T> abstractC4519l, int i2) {
        if (i2 == Integer.MAX_VALUE) {
            return m18400a((AbstractC4519l) abstractC4519l);
        }
        return m18404a((AbstractC4519l) abstractC4519l, (Callable) new h(i2));
    }

    /* renamed from: a */
    public static <T> AbstractC4567a<T> m18402a(AbstractC4519l<T> abstractC4519l, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        return m18403a(abstractC4519l, j2, timeUnit, abstractC4516j0, Integer.MAX_VALUE);
    }

    /* renamed from: a */
    public static <T> AbstractC4567a<T> m18403a(AbstractC4519l<T> abstractC4519l, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, int i2) {
        return m18404a((AbstractC4519l) abstractC4519l, (Callable) new k(i2, j2, timeUnit, abstractC4516j0));
    }

    /* renamed from: a */
    static <T> AbstractC4567a<T> m18404a(AbstractC4519l<T> abstractC4519l, Callable<? extends g<T>> callable) {
        AtomicReference atomicReference = new AtomicReference();
        return C4476a.m17133a((AbstractC4567a) new C4824x2(new i(atomicReference, callable), abstractC4519l, atomicReference, callable));
    }
}
