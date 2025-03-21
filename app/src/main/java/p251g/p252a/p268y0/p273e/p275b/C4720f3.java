package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4572c;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4615n;
import p251g.p252a.p268y0.p280f.C5110b;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableScanSeed.java */
/* renamed from: g.a.y0.e.b.f3 */
/* loaded from: classes2.dex */
public final class C4720f3<T, R> extends AbstractC4686a<T, R> {

    /* renamed from: c */
    final InterfaceC4572c<R, ? super T, R> f17880c;

    /* renamed from: d */
    final Callable<R> f17881d;

    /* compiled from: FlowableScanSeed.java */
    /* renamed from: g.a.y0.e.b.f3$a */
    static final class a<T, R> extends AtomicInteger implements InterfaceC4529q<T>, InterfaceC5823d {
        private static final long serialVersionUID = -1776795561228106469L;
        final InterfaceC4572c<R, ? super T, R> accumulator;
        final InterfaceC5822c<? super R> actual;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        Throwable error;
        final int limit;
        final int prefetch;
        final InterfaceC4615n<R> queue;
        final AtomicLong requested;

        /* renamed from: s */
        InterfaceC5823d f17882s;
        R value;

        a(InterfaceC5822c<? super R> interfaceC5822c, InterfaceC4572c<R, ? super T, R> interfaceC4572c, R r, int i2) {
            this.actual = interfaceC5822c;
            this.accumulator = interfaceC4572c;
            this.value = r;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
            this.queue = new C5110b(i2);
            this.queue.offer(r);
            this.requested = new AtomicLong();
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.cancelled = true;
            this.f17882s.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void drain() {
            Throwable th;
            if (getAndIncrement() != 0) {
                return;
            }
            InterfaceC5822c<? super R> interfaceC5822c = this.actual;
            InterfaceC4615n<R> interfaceC4615n = this.queue;
            int i2 = this.limit;
            int i3 = this.consumed;
            int i4 = 1;
            do {
                long j2 = this.requested.get();
                long j3 = 0;
                while (j3 != j2) {
                    if (this.cancelled) {
                        interfaceC4615n.clear();
                        return;
                    }
                    boolean z = this.done;
                    if (z && (th = this.error) != null) {
                        interfaceC4615n.clear();
                        interfaceC5822c.onError(th);
                        return;
                    }
                    R poll = interfaceC4615n.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        interfaceC5822c.onComplete();
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    interfaceC5822c.onNext(poll);
                    j3++;
                    i3++;
                    if (i3 == i2) {
                        this.f17882s.request(i2);
                        i3 = 0;
                    }
                }
                if (j3 == j2 && this.done) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        interfaceC4615n.clear();
                        interfaceC5822c.onError(th2);
                        return;
                    } else if (interfaceC4615n.isEmpty()) {
                        interfaceC5822c.onComplete();
                        return;
                    }
                }
                if (j3 != 0) {
                    C5164d.m18610c(this.requested, j3);
                }
                this.consumed = i3;
                i4 = addAndGet(-i4);
            } while (i4 != 0);
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
            if (this.done) {
                C4476a.m17152b(th);
                return;
            }
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                R r = (R) C4601b.m18284a(this.accumulator.apply(this.value, t), "The accumulator returned a null value");
                this.value = r;
                this.queue.offer(r);
                drain();
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f17882s.cancel();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f17882s, interfaceC5823d)) {
                this.f17882s = interfaceC5823d;
                this.actual.onSubscribe(this);
                interfaceC5823d.request(this.prefetch - 1);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                C5164d.m18607a(this.requested, j2);
                drain();
            }
        }
    }

    public C4720f3(AbstractC4519l<T> abstractC4519l, Callable<R> callable, InterfaceC4572c<R, ? super T, R> interfaceC4572c) {
        super(abstractC4519l);
        this.f17880c = interfaceC4572c;
        this.f17881d = callable;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super R> interfaceC5822c) {
        try {
            this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c, this.f17880c, C4601b.m18284a(this.f17881d.call(), "The seed supplied is null"), AbstractC4519l.m17539Q()));
        } catch (Throwable th) {
            C4561b.m18199b(th);
            EnumC5157g.error(th, interfaceC5822c);
        }
    }
}
