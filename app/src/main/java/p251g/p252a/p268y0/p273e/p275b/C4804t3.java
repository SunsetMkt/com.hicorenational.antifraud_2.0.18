package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p265v0.C4562c;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4613l;
import p251g.p252a.p268y0.p271c.InterfaceC4616o;
import p251g.p252a.p268y0.p280f.C5110b;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5163c;
import p251g.p252a.p268y0.p284j.C5164d;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableSwitchMap.java */
/* renamed from: g.a.y0.e.b.t3 */
/* loaded from: classes2.dex */
public final class C4804t3<T, R> extends AbstractC4686a<T, R> {

    /* renamed from: c */
    final InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> f18423c;

    /* renamed from: d */
    final int f18424d;

    /* renamed from: e */
    final boolean f18425e;

    /* compiled from: FlowableSwitchMap.java */
    /* renamed from: g.a.y0.e.b.t3$a */
    static final class a<T, R> extends AtomicReference<InterfaceC5823d> implements InterfaceC4529q<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        final int bufferSize;
        volatile boolean done;
        int fusionMode;
        final long index;
        final b<T, R> parent;
        volatile InterfaceC4616o<R> queue;

        a(b<T, R> bVar, long j2, int i2) {
            this.parent = bVar;
            this.index = j2;
            this.bufferSize = i2;
        }

        public void cancel() {
            EnumC5160j.cancel(this);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            b<T, R> bVar = this.parent;
            if (this.index == bVar.unique) {
                this.done = true;
                bVar.drain();
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            b<T, R> bVar = this.parent;
            if (this.index != bVar.unique || !bVar.error.addThrowable(th)) {
                C4476a.m17152b(th);
                return;
            }
            if (!bVar.delayErrors) {
                bVar.f18426s.cancel();
            }
            this.done = true;
            bVar.drain();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(R r) {
            b<T, R> bVar = this.parent;
            if (this.index == bVar.unique) {
                if (this.fusionMode != 0 || this.queue.offer(r)) {
                    bVar.drain();
                } else {
                    onError(new C4562c("Queue full?!"));
                }
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.setOnce(this, interfaceC5823d)) {
                if (interfaceC5823d instanceof InterfaceC4613l) {
                    InterfaceC4613l interfaceC4613l = (InterfaceC4613l) interfaceC5823d;
                    int requestFusion = interfaceC4613l.requestFusion(3);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = interfaceC4613l;
                        this.done = true;
                        this.parent.drain();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = interfaceC4613l;
                        interfaceC5823d.request(this.bufferSize);
                        return;
                    }
                }
                this.queue = new C5110b(this.bufferSize);
                interfaceC5823d.request(this.bufferSize);
            }
        }
    }

    /* compiled from: FlowableSwitchMap.java */
    /* renamed from: g.a.y0.e.b.t3$b */
    static final class b<T, R> extends AtomicInteger implements InterfaceC4529q<T>, InterfaceC5823d {
        static final a<Object, Object> CANCELLED = new a<>(null, -1, 1);
        private static final long serialVersionUID = -3491074160481096299L;
        final InterfaceC5822c<? super R> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> mapper;

        /* renamed from: s */
        InterfaceC5823d f18426s;
        volatile long unique;
        final AtomicReference<a<T, R>> active = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();
        final C5163c error = new C5163c();

        static {
            CANCELLED.cancel();
        }

        b(InterfaceC5822c<? super R> interfaceC5822c, InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> interfaceC4584o, int i2, boolean z) {
            this.actual = interfaceC5822c;
            this.mapper = interfaceC4584o;
            this.bufferSize = i2;
            this.delayErrors = z;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f18426s.cancel();
            disposeInner();
        }

        void disposeInner() {
            a<Object, Object> aVar;
            a<T, R> aVar2 = this.active.get();
            a<Object, Object> aVar3 = CANCELLED;
            if (aVar2 == aVar3 || (aVar = (a) this.active.getAndSet(aVar3)) == CANCELLED || aVar == null) {
                return;
            }
            aVar.cancel();
        }

        /* JADX WARN: Code restructure failed: missing block: B:67:0x00e5, code lost:
        
            r14 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x011d, code lost:
        
            if (r12 == 0) goto L87;
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x0121, code lost:
        
            if (r17.cancelled != false) goto L87;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x012a, code lost:
        
            if (r8 == p286h.p309q2.p311t.C5556m0.f20396b) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x012c, code lost:
        
            r17.requested.addAndGet(-r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x0132, code lost:
        
            r6.get().request(r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x013b, code lost:
        
            if (r14 == false) goto L105;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x000c, code lost:
        
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drain() {
            /*
                Method dump skipped, instructions count: 327
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p251g.p252a.p268y0.p273e.p275b.C4804t3.b.drain():void");
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.done || !this.error.addThrowable(th)) {
                C4476a.m17152b(th);
                return;
            }
            if (!this.delayErrors) {
                disposeInner();
            }
            this.done = true;
            drain();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            a<T, R> aVar;
            if (this.done) {
                return;
            }
            long j2 = this.unique + 1;
            this.unique = j2;
            a<T, R> aVar2 = this.active.get();
            if (aVar2 != null) {
                aVar2.cancel();
            }
            try {
                InterfaceC5821b interfaceC5821b = (InterfaceC5821b) C4601b.m18284a(this.mapper.apply(t), "The publisher returned is null");
                a<T, R> aVar3 = new a<>(this, j2, this.bufferSize);
                do {
                    aVar = this.active.get();
                    if (aVar == CANCELLED) {
                        return;
                    }
                } while (!this.active.compareAndSet(aVar, aVar3));
                interfaceC5821b.subscribe(aVar3);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f18426s.cancel();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18426s, interfaceC5823d)) {
                this.f18426s = interfaceC5823d;
                this.actual.onSubscribe(this);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                C5164d.m18607a(this.requested, j2);
                if (this.unique == 0) {
                    this.f18426s.request(C5556m0.f20396b);
                } else {
                    drain();
                }
            }
        }
    }

    public C4804t3(AbstractC4519l<T> abstractC4519l, InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> interfaceC4584o, int i2, boolean z) {
        super(abstractC4519l);
        this.f18423c = interfaceC4584o;
        this.f18424d = i2;
        this.f18425e = z;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super R> interfaceC5822c) {
        if (C4708d3.m18317a(this.f17759b, interfaceC5822c, this.f18423c)) {
            return;
        }
        this.f17759b.m17799a((InterfaceC4529q) new b(interfaceC5822c, this.f18423c, this.f18424d, this.f18425e));
    }
}
