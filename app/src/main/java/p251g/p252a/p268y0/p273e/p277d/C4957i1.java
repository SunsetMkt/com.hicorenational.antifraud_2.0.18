package p251g.p252a.p268y0.p273e.p277d;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p258f1.C4502j;
import p251g.p252a.p264u0.C4551b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4572c;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p280f.C5111c;
import p251g.p252a.p268y0.p284j.C5171k;

/* compiled from: ObservableGroupJoin.java */
/* renamed from: g.a.y0.e.d.i1 */
/* loaded from: classes2.dex */
public final class C4957i1<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractC4907a<TLeft, R> {

    /* renamed from: b */
    final InterfaceC4504g0<? extends TRight> f19057b;

    /* renamed from: c */
    final InterfaceC4584o<? super TLeft, ? extends InterfaceC4504g0<TLeftEnd>> f19058c;

    /* renamed from: d */
    final InterfaceC4584o<? super TRight, ? extends InterfaceC4504g0<TRightEnd>> f19059d;

    /* renamed from: e */
    final InterfaceC4572c<? super TLeft, ? super AbstractC4469b0<TRight>, ? extends R> f19060e;

    /* compiled from: ObservableGroupJoin.java */
    /* renamed from: g.a.y0.e.d.i1$a */
    static final class a<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements InterfaceC4552c, b {
        private static final long serialVersionUID = -6071216598687999801L;
        final InterfaceC4514i0<? super R> actual;
        volatile boolean cancelled;
        final InterfaceC4584o<? super TLeft, ? extends InterfaceC4504g0<TLeftEnd>> leftEnd;
        int leftIndex;
        final InterfaceC4572c<? super TLeft, ? super AbstractC4469b0<TRight>, ? extends R> resultSelector;
        final InterfaceC4584o<? super TRight, ? extends InterfaceC4504g0<TRightEnd>> rightEnd;
        int rightIndex;
        static final Integer LEFT_VALUE = 1;
        static final Integer RIGHT_VALUE = 2;
        static final Integer LEFT_CLOSE = 3;
        static final Integer RIGHT_CLOSE = 4;
        final C4551b disposables = new C4551b();
        final C5111c<Object> queue = new C5111c<>(AbstractC4469b0.m16521L());
        final Map<Integer, C4502j<TRight>> lefts = new LinkedHashMap();
        final Map<Integer, TRight> rights = new LinkedHashMap();
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final AtomicInteger active = new AtomicInteger(2);

        a(InterfaceC4514i0<? super R> interfaceC4514i0, InterfaceC4584o<? super TLeft, ? extends InterfaceC4504g0<TLeftEnd>> interfaceC4584o, InterfaceC4584o<? super TRight, ? extends InterfaceC4504g0<TRightEnd>> interfaceC4584o2, InterfaceC4572c<? super TLeft, ? super AbstractC4469b0<TRight>, ? extends R> interfaceC4572c) {
            this.actual = interfaceC4514i0;
            this.leftEnd = interfaceC4584o;
            this.rightEnd = interfaceC4584o2;
            this.resultSelector = interfaceC4572c;
        }

        void cancelAll() {
            this.disposables.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            C5111c<?> c5111c = this.queue;
            InterfaceC4514i0<? super R> interfaceC4514i0 = this.actual;
            int i2 = 1;
            while (!this.cancelled) {
                if (this.error.get() != null) {
                    c5111c.clear();
                    cancelAll();
                    errorAll(interfaceC4514i0);
                    return;
                }
                boolean z = this.active.get() == 0;
                Integer num = (Integer) c5111c.poll();
                boolean z2 = num == null;
                if (z && z2) {
                    Iterator<C4502j<TRight>> it = this.lefts.values().iterator();
                    while (it.hasNext()) {
                        it.next().onComplete();
                    }
                    this.lefts.clear();
                    this.rights.clear();
                    this.disposables.dispose();
                    interfaceC4514i0.onComplete();
                    return;
                }
                if (z2) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    Object poll = c5111c.poll();
                    if (num == LEFT_VALUE) {
                        C4502j m17365V = C4502j.m17365V();
                        int i3 = this.leftIndex;
                        this.leftIndex = i3 + 1;
                        this.lefts.put(Integer.valueOf(i3), m17365V);
                        try {
                            InterfaceC4504g0 interfaceC4504g0 = (InterfaceC4504g0) C4601b.m18284a(this.leftEnd.apply(poll), "The leftEnd returned a null ObservableSource");
                            c cVar = new c(this, true, i3);
                            this.disposables.mo18181b(cVar);
                            interfaceC4504g0.subscribe(cVar);
                            if (this.error.get() != null) {
                                c5111c.clear();
                                cancelAll();
                                errorAll(interfaceC4514i0);
                                return;
                            } else {
                                try {
                                    interfaceC4514i0.onNext((Object) C4601b.m18284a(this.resultSelector.apply(poll, m17365V), "The resultSelector returned a null value"));
                                    Iterator<TRight> it2 = this.rights.values().iterator();
                                    while (it2.hasNext()) {
                                        m17365V.onNext(it2.next());
                                    }
                                } catch (Throwable th) {
                                    fail(th, interfaceC4514i0, c5111c);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            fail(th2, interfaceC4514i0, c5111c);
                            return;
                        }
                    } else if (num == RIGHT_VALUE) {
                        int i4 = this.rightIndex;
                        this.rightIndex = i4 + 1;
                        this.rights.put(Integer.valueOf(i4), poll);
                        try {
                            InterfaceC4504g0 interfaceC4504g02 = (InterfaceC4504g0) C4601b.m18284a(this.rightEnd.apply(poll), "The rightEnd returned a null ObservableSource");
                            c cVar2 = new c(this, false, i4);
                            this.disposables.mo18181b(cVar2);
                            interfaceC4504g02.subscribe(cVar2);
                            if (this.error.get() != null) {
                                c5111c.clear();
                                cancelAll();
                                errorAll(interfaceC4514i0);
                                return;
                            } else {
                                Iterator<C4502j<TRight>> it3 = this.lefts.values().iterator();
                                while (it3.hasNext()) {
                                    it3.next().onNext(poll);
                                }
                            }
                        } catch (Throwable th3) {
                            fail(th3, interfaceC4514i0, c5111c);
                            return;
                        }
                    } else if (num == LEFT_CLOSE) {
                        c cVar3 = (c) poll;
                        C4502j<TRight> remove = this.lefts.remove(Integer.valueOf(cVar3.index));
                        this.disposables.mo18178a(cVar3);
                        if (remove != null) {
                            remove.onComplete();
                        }
                    } else if (num == RIGHT_CLOSE) {
                        c cVar4 = (c) poll;
                        this.rights.remove(Integer.valueOf(cVar4.index));
                        this.disposables.mo18178a(cVar4);
                    }
                }
            }
            c5111c.clear();
        }

        void errorAll(InterfaceC4514i0<?> interfaceC4514i0) {
            Throwable m18622a = C5171k.m18622a(this.error);
            Iterator<C4502j<TRight>> it = this.lefts.values().iterator();
            while (it.hasNext()) {
                it.next().onError(m18622a);
            }
            this.lefts.clear();
            this.rights.clear();
            interfaceC4514i0.onError(m18622a);
        }

        void fail(Throwable th, InterfaceC4514i0<?> interfaceC4514i0, C5111c<?> c5111c) {
            C4561b.m18199b(th);
            C5171k.m18624a(this.error, th);
            c5111c.clear();
            cancelAll();
            errorAll(interfaceC4514i0);
        }

        @Override // p251g.p252a.p268y0.p273e.p277d.C4957i1.b
        public void innerClose(boolean z, c cVar) {
            synchronized (this) {
                this.queue.offer(z ? LEFT_CLOSE : RIGHT_CLOSE, cVar);
            }
            drain();
        }

        @Override // p251g.p252a.p268y0.p273e.p277d.C4957i1.b
        public void innerCloseError(Throwable th) {
            if (C5171k.m18624a(this.error, th)) {
                drain();
            } else {
                C4476a.m17152b(th);
            }
        }

        @Override // p251g.p252a.p268y0.p273e.p277d.C4957i1.b
        public void innerComplete(d dVar) {
            this.disposables.mo18182c(dVar);
            this.active.decrementAndGet();
            drain();
        }

        @Override // p251g.p252a.p268y0.p273e.p277d.C4957i1.b
        public void innerError(Throwable th) {
            if (!C5171k.m18624a(this.error, th)) {
                C4476a.m17152b(th);
            } else {
                this.active.decrementAndGet();
                drain();
            }
        }

        @Override // p251g.p252a.p268y0.p273e.p277d.C4957i1.b
        public void innerValue(boolean z, Object obj) {
            synchronized (this) {
                this.queue.offer(z ? LEFT_VALUE : RIGHT_VALUE, obj);
            }
            drain();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    /* compiled from: ObservableGroupJoin.java */
    /* renamed from: g.a.y0.e.d.i1$b */
    interface b {
        void innerClose(boolean z, c cVar);

        void innerCloseError(Throwable th);

        void innerComplete(d dVar);

        void innerError(Throwable th);

        void innerValue(boolean z, Object obj);
    }

    /* compiled from: ObservableGroupJoin.java */
    /* renamed from: g.a.y0.e.d.i1$c */
    static final class c extends AtomicReference<InterfaceC4552c> implements InterfaceC4514i0<Object>, InterfaceC4552c {
        private static final long serialVersionUID = 1883890389173668373L;
        final int index;
        final boolean isLeft;
        final b parent;

        c(b bVar, boolean z, int i2) {
            this.parent = bVar;
            this.isLeft = z;
            this.index = i2;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC4592d.isDisposed(get());
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.parent.innerClose(this.isLeft, this);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.parent.innerCloseError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(Object obj) {
            if (EnumC4592d.dispose(this)) {
                this.parent.innerClose(this.isLeft, this);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.setOnce(this, interfaceC4552c);
        }
    }

    /* compiled from: ObservableGroupJoin.java */
    /* renamed from: g.a.y0.e.d.i1$d */
    static final class d extends AtomicReference<InterfaceC4552c> implements InterfaceC4514i0<Object>, InterfaceC4552c {
        private static final long serialVersionUID = 1883890389173668373L;
        final boolean isLeft;
        final b parent;

        d(b bVar, boolean z) {
            this.parent = bVar;
            this.isLeft = z;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC4592d.isDisposed(get());
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.parent.innerComplete(this);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.parent.innerError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(Object obj) {
            this.parent.innerValue(this.isLeft, obj);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.setOnce(this, interfaceC4552c);
        }
    }

    public C4957i1(InterfaceC4504g0<TLeft> interfaceC4504g0, InterfaceC4504g0<? extends TRight> interfaceC4504g02, InterfaceC4584o<? super TLeft, ? extends InterfaceC4504g0<TLeftEnd>> interfaceC4584o, InterfaceC4584o<? super TRight, ? extends InterfaceC4504g0<TRightEnd>> interfaceC4584o2, InterfaceC4572c<? super TLeft, ? super AbstractC4469b0<TRight>, ? extends R> interfaceC4572c) {
        super(interfaceC4504g0);
        this.f19057b = interfaceC4504g02;
        this.f19058c = interfaceC4584o;
        this.f19059d = interfaceC4584o2;
        this.f19060e = interfaceC4572c;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super R> interfaceC4514i0) {
        a aVar = new a(interfaceC4514i0, this.f19058c, this.f19059d, this.f19060e);
        interfaceC4514i0.onSubscribe(aVar);
        d dVar = new d(aVar, true);
        aVar.disposables.mo18181b(dVar);
        d dVar2 = new d(aVar, false);
        aVar.disposables.mo18181b(dVar2);
        this.f18742a.subscribe(dVar);
        this.f19057b.subscribe(dVar2);
    }
}
