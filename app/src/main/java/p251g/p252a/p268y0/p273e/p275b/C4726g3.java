package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p265v0.C4562c;
import p251g.p252a.p267x0.InterfaceC4573d;
import p251g.p252a.p268y0.p271c.InterfaceC4613l;
import p251g.p252a.p268y0.p271c.InterfaceC4616o;
import p251g.p252a.p268y0.p280f.C5110b;
import p251g.p252a.p268y0.p283i.C5156f;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5163c;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableSequenceEqual.java */
/* renamed from: g.a.y0.e.b.g3 */
/* loaded from: classes2.dex */
public final class C4726g3<T> extends AbstractC4519l<Boolean> {

    /* renamed from: b */
    final InterfaceC5821b<? extends T> f17916b;

    /* renamed from: c */
    final InterfaceC5821b<? extends T> f17917c;

    /* renamed from: d */
    final InterfaceC4573d<? super T, ? super T> f17918d;

    /* renamed from: e */
    final int f17919e;

    /* compiled from: FlowableSequenceEqual.java */
    /* renamed from: g.a.y0.e.b.g3$a */
    static final class a<T> extends C5156f<Boolean> implements b {
        private static final long serialVersionUID = -6178010334400373240L;
        final InterfaceC4573d<? super T, ? super T> comparer;
        final C5163c error;
        final c<T> first;
        final c<T> second;

        /* renamed from: v1 */
        T f17920v1;

        /* renamed from: v2 */
        T f17921v2;
        final AtomicInteger wip;

        a(InterfaceC5822c<? super Boolean> interfaceC5822c, int i2, InterfaceC4573d<? super T, ? super T> interfaceC4573d) {
            super(interfaceC5822c);
            this.comparer = interfaceC4573d;
            this.wip = new AtomicInteger();
            this.first = new c<>(this, i2);
            this.second = new c<>(this, i2);
            this.error = new C5163c();
        }

        @Override // p251g.p252a.p268y0.p283i.C5156f, p324i.p338d.InterfaceC5823d
        public void cancel() {
            super.cancel();
            this.first.cancel();
            this.second.cancel();
            if (this.wip.getAndIncrement() == 0) {
                this.first.clear();
                this.second.clear();
            }
        }

        void cancelAndClear() {
            this.first.cancel();
            this.first.clear();
            this.second.cancel();
            this.second.clear();
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4726g3.b
        public void drain() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            int i2 = 1;
            do {
                InterfaceC4616o<T> interfaceC4616o = this.first.queue;
                InterfaceC4616o<T> interfaceC4616o2 = this.second.queue;
                if (interfaceC4616o != null && interfaceC4616o2 != null) {
                    while (!isCancelled()) {
                        if (this.error.get() != null) {
                            cancelAndClear();
                            this.actual.onError(this.error.terminate());
                            return;
                        }
                        boolean z = this.first.done;
                        T t = this.f17920v1;
                        if (t == null) {
                            try {
                                t = interfaceC4616o.poll();
                                this.f17920v1 = t;
                            } catch (Throwable th) {
                                C4561b.m18199b(th);
                                cancelAndClear();
                                this.error.addThrowable(th);
                                this.actual.onError(this.error.terminate());
                                return;
                            }
                        }
                        boolean z2 = t == null;
                        boolean z3 = this.second.done;
                        T t2 = this.f17921v2;
                        if (t2 == null) {
                            try {
                                t2 = interfaceC4616o2.poll();
                                this.f17921v2 = t2;
                            } catch (Throwable th2) {
                                C4561b.m18199b(th2);
                                cancelAndClear();
                                this.error.addThrowable(th2);
                                this.actual.onError(this.error.terminate());
                                return;
                            }
                        }
                        boolean z4 = t2 == null;
                        if (z && z3 && z2 && z4) {
                            complete(true);
                            return;
                        }
                        if (z && z3 && z2 != z4) {
                            cancelAndClear();
                            complete(false);
                            return;
                        }
                        if (!z2 && !z4) {
                            try {
                                if (!this.comparer.mo18210a(t, t2)) {
                                    cancelAndClear();
                                    complete(false);
                                    return;
                                } else {
                                    this.f17920v1 = null;
                                    this.f17921v2 = null;
                                    this.first.request();
                                    this.second.request();
                                }
                            } catch (Throwable th3) {
                                C4561b.m18199b(th3);
                                cancelAndClear();
                                this.error.addThrowable(th3);
                                this.actual.onError(this.error.terminate());
                                return;
                            }
                        }
                    }
                    this.first.clear();
                    this.second.clear();
                    return;
                }
                if (isCancelled()) {
                    this.first.clear();
                    this.second.clear();
                    return;
                } else if (this.error.get() != null) {
                    cancelAndClear();
                    this.actual.onError(this.error.terminate());
                    return;
                }
                i2 = this.wip.addAndGet(-i2);
            } while (i2 != 0);
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4726g3.b
        public void innerError(Throwable th) {
            if (this.error.addThrowable(th)) {
                drain();
            } else {
                C4476a.m17152b(th);
            }
        }

        void subscribe(InterfaceC5821b<? extends T> interfaceC5821b, InterfaceC5821b<? extends T> interfaceC5821b2) {
            interfaceC5821b.subscribe(this.first);
            interfaceC5821b2.subscribe(this.second);
        }
    }

    /* compiled from: FlowableSequenceEqual.java */
    /* renamed from: g.a.y0.e.b.g3$b */
    interface b {
        void drain();

        void innerError(Throwable th);
    }

    /* compiled from: FlowableSequenceEqual.java */
    /* renamed from: g.a.y0.e.b.g3$c */
    static final class c<T> extends AtomicReference<InterfaceC5823d> implements InterfaceC4529q<T> {
        private static final long serialVersionUID = 4804128302091633067L;
        volatile boolean done;
        final int limit;
        final b parent;
        final int prefetch;
        long produced;
        volatile InterfaceC4616o<T> queue;
        int sourceMode;

        c(b bVar, int i2) {
            this.parent = bVar;
            this.limit = i2 - (i2 >> 2);
            this.prefetch = i2;
        }

        public void cancel() {
            EnumC5160j.cancel(this);
        }

        void clear() {
            InterfaceC4616o<T> interfaceC4616o = this.queue;
            if (interfaceC4616o != null) {
                interfaceC4616o.clear();
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.parent.innerError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.sourceMode != 0 || this.queue.offer(t)) {
                this.parent.drain();
            } else {
                onError(new C4562c());
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.setOnce(this, interfaceC5823d)) {
                if (interfaceC5823d instanceof InterfaceC4613l) {
                    InterfaceC4613l interfaceC4613l = (InterfaceC4613l) interfaceC5823d;
                    int requestFusion = interfaceC4613l.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = interfaceC4613l;
                        this.done = true;
                        this.parent.drain();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = interfaceC4613l;
                        interfaceC5823d.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new C5110b(this.prefetch);
                interfaceC5823d.request(this.prefetch);
            }
        }

        public void request() {
            if (this.sourceMode != 1) {
                long j2 = this.produced + 1;
                if (j2 < this.limit) {
                    this.produced = j2;
                } else {
                    this.produced = 0L;
                    get().request(j2);
                }
            }
        }
    }

    public C4726g3(InterfaceC5821b<? extends T> interfaceC5821b, InterfaceC5821b<? extends T> interfaceC5821b2, InterfaceC4573d<? super T, ? super T> interfaceC4573d, int i2) {
        this.f17916b = interfaceC5821b;
        this.f17917c = interfaceC5821b2;
        this.f17918d = interfaceC4573d;
        this.f17919e = i2;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super Boolean> interfaceC5822c) {
        a aVar = new a(interfaceC5822c, this.f17919e, this.f17918d);
        interfaceC5822c.onSubscribe(aVar);
        aVar.subscribe(this.f17916b, this.f17917c);
    }
}
