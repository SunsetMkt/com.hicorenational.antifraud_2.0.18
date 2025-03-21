package p251g.p252a.p268y0.p273e.p275b;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.EnumC4452a;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p265v0.C4562c;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableOnBackpressureBufferStrategy.java */
/* renamed from: g.a.y0.e.b.f2 */
/* loaded from: classes2.dex */
public final class C4719f2<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final long f17875c;

    /* renamed from: d */
    final InterfaceC4570a f17876d;

    /* renamed from: e */
    final EnumC4452a f17877e;

    /* compiled from: FlowableOnBackpressureBufferStrategy.java */
    /* renamed from: g.a.y0.e.b.f2$a */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f17878a = new int[EnumC4452a.values().length];

        static {
            try {
                f17878a[EnumC4452a.DROP_LATEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17878a[EnumC4452a.DROP_OLDEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: FlowableOnBackpressureBufferStrategy.java */
    /* renamed from: g.a.y0.e.b.f2$b */
    static final class b<T> extends AtomicInteger implements InterfaceC4529q<T>, InterfaceC5823d {
        private static final long serialVersionUID = 3240706908776709697L;
        final InterfaceC5822c<? super T> actual;
        final long bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        Throwable error;
        final InterfaceC4570a onOverflow;

        /* renamed from: s */
        InterfaceC5823d f17879s;
        final EnumC4452a strategy;
        final AtomicLong requested = new AtomicLong();
        final Deque<T> deque = new ArrayDeque();

        b(InterfaceC5822c<? super T> interfaceC5822c, InterfaceC4570a interfaceC4570a, EnumC4452a enumC4452a, long j2) {
            this.actual = interfaceC5822c;
            this.onOverflow = interfaceC4570a;
            this.strategy = enumC4452a;
            this.bufferSize = j2;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.cancelled = true;
            this.f17879s.cancel();
            if (getAndIncrement() == 0) {
                clear(this.deque);
            }
        }

        void clear(Deque<T> deque) {
            synchronized (deque) {
                deque.clear();
            }
        }

        void drain() {
            boolean isEmpty;
            T poll;
            if (getAndIncrement() != 0) {
                return;
            }
            Deque<T> deque = this.deque;
            InterfaceC5822c<? super T> interfaceC5822c = this.actual;
            int i2 = 1;
            do {
                long j2 = this.requested.get();
                long j3 = 0;
                while (j3 != j2) {
                    if (this.cancelled) {
                        clear(deque);
                        return;
                    }
                    boolean z = this.done;
                    synchronized (deque) {
                        poll = deque.poll();
                    }
                    boolean z2 = poll == null;
                    if (z) {
                        Throwable th = this.error;
                        if (th != null) {
                            clear(deque);
                            interfaceC5822c.onError(th);
                            return;
                        } else if (z2) {
                            interfaceC5822c.onComplete();
                            return;
                        }
                    }
                    if (z2) {
                        break;
                    }
                    interfaceC5822c.onNext(poll);
                    j3++;
                }
                if (j3 == j2) {
                    if (this.cancelled) {
                        clear(deque);
                        return;
                    }
                    boolean z3 = this.done;
                    synchronized (deque) {
                        isEmpty = deque.isEmpty();
                    }
                    if (z3) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            clear(deque);
                            interfaceC5822c.onError(th2);
                            return;
                        } else if (isEmpty) {
                            interfaceC5822c.onComplete();
                            return;
                        }
                    }
                }
                if (j3 != 0) {
                    C5164d.m18610c(this.requested, j3);
                }
                i2 = addAndGet(-i2);
            } while (i2 != 0);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
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
            boolean z;
            boolean z2;
            if (this.done) {
                return;
            }
            Deque<T> deque = this.deque;
            synchronized (deque) {
                z = false;
                z2 = true;
                if (deque.size() == this.bufferSize) {
                    int i2 = a.f17878a[this.strategy.ordinal()];
                    if (i2 == 1) {
                        deque.pollLast();
                        deque.offer(t);
                    } else if (i2 == 2) {
                        deque.poll();
                        deque.offer(t);
                    }
                    z = true;
                } else {
                    deque.offer(t);
                }
                z2 = false;
            }
            if (!z) {
                if (!z2) {
                    drain();
                    return;
                } else {
                    this.f17879s.cancel();
                    onError(new C4562c());
                    return;
                }
            }
            InterfaceC4570a interfaceC4570a = this.onOverflow;
            if (interfaceC4570a != null) {
                try {
                    interfaceC4570a.run();
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    this.f17879s.cancel();
                    onError(th);
                }
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f17879s, interfaceC5823d)) {
                this.f17879s = interfaceC5823d;
                this.actual.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
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

    public C4719f2(AbstractC4519l<T> abstractC4519l, long j2, InterfaceC4570a interfaceC4570a, EnumC4452a enumC4452a) {
        super(abstractC4519l);
        this.f17875c = j2;
        this.f17876d = interfaceC4570a;
        this.f17877e = enumC4452a;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new b(interfaceC5822c, this.f17876d, this.f17877e, this.f17875c));
    }
}
