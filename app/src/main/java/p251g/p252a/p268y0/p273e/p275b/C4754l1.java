package p251g.p252a.p268y0.p273e.p275b;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p000a.p001a.InterfaceC0000a;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p256d1.C4485g;
import p251g.p252a.p264u0.C4551b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p265v0.C4562c;
import p251g.p252a.p267x0.InterfaceC4572c;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4616o;
import p251g.p252a.p268y0.p280f.C5111c;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p251g.p252a.p268y0.p284j.C5171k;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableGroupJoin.java */
/* renamed from: g.a.y0.e.b.l1 */
/* loaded from: classes2.dex */
public final class C4754l1<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractC4686a<TLeft, R> {

    /* renamed from: c */
    final InterfaceC5821b<? extends TRight> f18022c;

    /* renamed from: d */
    final InterfaceC4584o<? super TLeft, ? extends InterfaceC5821b<TLeftEnd>> f18023d;

    /* renamed from: e */
    final InterfaceC4584o<? super TRight, ? extends InterfaceC5821b<TRightEnd>> f18024e;

    /* renamed from: f */
    final InterfaceC4572c<? super TLeft, ? super AbstractC4519l<TRight>, ? extends R> f18025f;

    /* compiled from: FlowableGroupJoin.java */
    /* renamed from: g.a.y0.e.b.l1$a */
    static final class a<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements InterfaceC5823d, b {
        private static final long serialVersionUID = -6071216598687999801L;
        final InterfaceC5822c<? super R> actual;
        volatile boolean cancelled;
        final InterfaceC4584o<? super TLeft, ? extends InterfaceC5821b<TLeftEnd>> leftEnd;
        int leftIndex;
        final InterfaceC4572c<? super TLeft, ? super AbstractC4519l<TRight>, ? extends R> resultSelector;
        final InterfaceC4584o<? super TRight, ? extends InterfaceC5821b<TRightEnd>> rightEnd;
        int rightIndex;
        static final Integer LEFT_VALUE = 1;
        static final Integer RIGHT_VALUE = 2;
        static final Integer LEFT_CLOSE = 3;
        static final Integer RIGHT_CLOSE = 4;
        final AtomicLong requested = new AtomicLong();
        final C4551b disposables = new C4551b();
        final C5111c<Object> queue = new C5111c<>(AbstractC4519l.m17539Q());
        final Map<Integer, C4485g<TRight>> lefts = new LinkedHashMap();
        final Map<Integer, TRight> rights = new LinkedHashMap();
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final AtomicInteger active = new AtomicInteger(2);

        a(InterfaceC5822c<? super R> interfaceC5822c, InterfaceC4584o<? super TLeft, ? extends InterfaceC5821b<TLeftEnd>> interfaceC4584o, InterfaceC4584o<? super TRight, ? extends InterfaceC5821b<TRightEnd>> interfaceC4584o2, InterfaceC4572c<? super TLeft, ? super AbstractC4519l<TRight>, ? extends R> interfaceC4572c) {
            this.actual = interfaceC5822c;
            this.leftEnd = interfaceC4584o;
            this.rightEnd = interfaceC4584o2;
            this.resultSelector = interfaceC4572c;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void cancelAll() {
            this.disposables.dispose();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            C5111c<Object> c5111c = this.queue;
            InterfaceC5822c<? super R> interfaceC5822c = this.actual;
            int i2 = 1;
            while (!this.cancelled) {
                if (this.error.get() != null) {
                    c5111c.clear();
                    cancelAll();
                    errorAll(interfaceC5822c);
                    return;
                }
                boolean z = this.active.get() == 0;
                Integer num = (Integer) c5111c.poll();
                boolean z2 = num == null;
                if (z && z2) {
                    Iterator<C4485g<TRight>> it = this.lefts.values().iterator();
                    while (it.hasNext()) {
                        it.next().onComplete();
                    }
                    this.lefts.clear();
                    this.rights.clear();
                    this.disposables.dispose();
                    interfaceC5822c.onComplete();
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
                        C4485g m17258a0 = C4485g.m17258a0();
                        int i3 = this.leftIndex;
                        this.leftIndex = i3 + 1;
                        this.lefts.put(Integer.valueOf(i3), m17258a0);
                        try {
                            InterfaceC5821b interfaceC5821b = (InterfaceC5821b) C4601b.m18284a(this.leftEnd.apply(poll), "The leftEnd returned a null Publisher");
                            c cVar = new c(this, true, i3);
                            this.disposables.mo18181b(cVar);
                            interfaceC5821b.subscribe(cVar);
                            if (this.error.get() != null) {
                                c5111c.clear();
                                cancelAll();
                                errorAll(interfaceC5822c);
                                return;
                            }
                            try {
                                InterfaceC0000a interfaceC0000a = (Object) C4601b.m18284a(this.resultSelector.apply(poll, m17258a0), "The resultSelector returned a null value");
                                if (this.requested.get() == 0) {
                                    fail(new C4562c("Could not emit value due to lack of requests"), interfaceC5822c, c5111c);
                                    return;
                                }
                                interfaceC5822c.onNext(interfaceC0000a);
                                C5164d.m18610c(this.requested, 1L);
                                Iterator<TRight> it2 = this.rights.values().iterator();
                                while (it2.hasNext()) {
                                    m17258a0.onNext(it2.next());
                                }
                            } catch (Throwable th) {
                                fail(th, interfaceC5822c, c5111c);
                                return;
                            }
                        } catch (Throwable th2) {
                            fail(th2, interfaceC5822c, c5111c);
                            return;
                        }
                    } else if (num == RIGHT_VALUE) {
                        int i4 = this.rightIndex;
                        this.rightIndex = i4 + 1;
                        this.rights.put(Integer.valueOf(i4), poll);
                        try {
                            InterfaceC5821b interfaceC5821b2 = (InterfaceC5821b) C4601b.m18284a(this.rightEnd.apply(poll), "The rightEnd returned a null Publisher");
                            c cVar2 = new c(this, false, i4);
                            this.disposables.mo18181b(cVar2);
                            interfaceC5821b2.subscribe(cVar2);
                            if (this.error.get() != null) {
                                c5111c.clear();
                                cancelAll();
                                errorAll(interfaceC5822c);
                                return;
                            } else {
                                Iterator<C4485g<TRight>> it3 = this.lefts.values().iterator();
                                while (it3.hasNext()) {
                                    it3.next().onNext(poll);
                                }
                            }
                        } catch (Throwable th3) {
                            fail(th3, interfaceC5822c, c5111c);
                            return;
                        }
                    } else if (num == LEFT_CLOSE) {
                        c cVar3 = (c) poll;
                        C4485g<TRight> remove = this.lefts.remove(Integer.valueOf(cVar3.index));
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

        void errorAll(InterfaceC5822c<?> interfaceC5822c) {
            Throwable m18622a = C5171k.m18622a(this.error);
            Iterator<C4485g<TRight>> it = this.lefts.values().iterator();
            while (it.hasNext()) {
                it.next().onError(m18622a);
            }
            this.lefts.clear();
            this.rights.clear();
            interfaceC5822c.onError(m18622a);
        }

        void fail(Throwable th, InterfaceC5822c<?> interfaceC5822c, InterfaceC4616o<?> interfaceC4616o) {
            C4561b.m18199b(th);
            C5171k.m18624a(this.error, th);
            interfaceC4616o.clear();
            cancelAll();
            errorAll(interfaceC5822c);
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4754l1.b
        public void innerClose(boolean z, c cVar) {
            synchronized (this) {
                this.queue.offer(z ? LEFT_CLOSE : RIGHT_CLOSE, cVar);
            }
            drain();
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4754l1.b
        public void innerCloseError(Throwable th) {
            if (C5171k.m18624a(this.error, th)) {
                drain();
            } else {
                C4476a.m17152b(th);
            }
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4754l1.b
        public void innerComplete(d dVar) {
            this.disposables.mo18182c(dVar);
            this.active.decrementAndGet();
            drain();
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4754l1.b
        public void innerError(Throwable th) {
            if (!C5171k.m18624a(this.error, th)) {
                C4476a.m17152b(th);
            } else {
                this.active.decrementAndGet();
                drain();
            }
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4754l1.b
        public void innerValue(boolean z, Object obj) {
            synchronized (this) {
                this.queue.offer(z ? LEFT_VALUE : RIGHT_VALUE, obj);
            }
            drain();
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                C5164d.m18607a(this.requested, j2);
            }
        }
    }

    /* compiled from: FlowableGroupJoin.java */
    /* renamed from: g.a.y0.e.b.l1$b */
    interface b {
        void innerClose(boolean z, c cVar);

        void innerCloseError(Throwable th);

        void innerComplete(d dVar);

        void innerError(Throwable th);

        void innerValue(boolean z, Object obj);
    }

    /* compiled from: FlowableGroupJoin.java */
    /* renamed from: g.a.y0.e.b.l1$c */
    static final class c extends AtomicReference<InterfaceC5823d> implements InterfaceC4529q<Object>, InterfaceC4552c {
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
            EnumC5160j.cancel(this);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC5160j.isCancelled(get());
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.parent.innerClose(this.isLeft, this);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.parent.innerCloseError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(Object obj) {
            if (EnumC5160j.cancel(this)) {
                this.parent.innerClose(this.isLeft, this);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.setOnce(this, interfaceC5823d)) {
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    /* compiled from: FlowableGroupJoin.java */
    /* renamed from: g.a.y0.e.b.l1$d */
    static final class d extends AtomicReference<InterfaceC5823d> implements InterfaceC4529q<Object>, InterfaceC4552c {
        private static final long serialVersionUID = 1883890389173668373L;
        final boolean isLeft;
        final b parent;

        d(b bVar, boolean z) {
            this.parent = bVar;
            this.isLeft = z;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC5160j.cancel(this);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC5160j.isCancelled(get());
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.parent.innerComplete(this);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.parent.innerError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(Object obj) {
            this.parent.innerValue(this.isLeft, obj);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.setOnce(this, interfaceC5823d)) {
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    public C4754l1(AbstractC4519l<TLeft> abstractC4519l, InterfaceC5821b<? extends TRight> interfaceC5821b, InterfaceC4584o<? super TLeft, ? extends InterfaceC5821b<TLeftEnd>> interfaceC4584o, InterfaceC4584o<? super TRight, ? extends InterfaceC5821b<TRightEnd>> interfaceC4584o2, InterfaceC4572c<? super TLeft, ? super AbstractC4519l<TRight>, ? extends R> interfaceC4572c) {
        super(abstractC4519l);
        this.f18022c = interfaceC5821b;
        this.f18023d = interfaceC4584o;
        this.f18024e = interfaceC4584o2;
        this.f18025f = interfaceC4572c;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super R> interfaceC5822c) {
        a aVar = new a(interfaceC5822c, this.f18023d, this.f18024e, this.f18025f);
        interfaceC5822c.onSubscribe(aVar);
        d dVar = new d(aVar, true);
        aVar.disposables.mo18181b(dVar);
        d dVar2 = new d(aVar, false);
        aVar.disposables.mo18181b(dVar2);
        this.f17759b.m17799a((InterfaceC4529q) dVar);
        this.f18022c.subscribe(dVar2);
    }
}
