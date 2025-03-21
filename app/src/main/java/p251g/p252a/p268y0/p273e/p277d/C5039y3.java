package p251g.p252a.p268y0.p273e.p277d;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p258f1.C4502j;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: ObservableWindow.java */
/* renamed from: g.a.y0.e.d.y3 */
/* loaded from: classes2.dex */
public final class C5039y3<T> extends AbstractC4907a<T, AbstractC4469b0<T>> {

    /* renamed from: b */
    final long f19521b;

    /* renamed from: c */
    final long f19522c;

    /* renamed from: d */
    final int f19523d;

    /* compiled from: ObservableWindow.java */
    /* renamed from: g.a.y0.e.d.y3$a */
    static final class a<T> extends AtomicInteger implements InterfaceC4514i0<T>, InterfaceC4552c, Runnable {
        private static final long serialVersionUID = -7481782523886138128L;
        final InterfaceC4514i0<? super AbstractC4469b0<T>> actual;
        volatile boolean cancelled;
        final int capacityHint;
        final long count;

        /* renamed from: s */
        InterfaceC4552c f19524s;
        long size;
        C4502j<T> window;

        a(InterfaceC4514i0<? super AbstractC4469b0<T>> interfaceC4514i0, long j2, int i2) {
            this.actual = interfaceC4514i0;
            this.count = j2;
            this.capacityHint = i2;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.cancelled = true;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            C4502j<T> c4502j = this.window;
            if (c4502j != null) {
                this.window = null;
                c4502j.onComplete();
            }
            this.actual.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            C4502j<T> c4502j = this.window;
            if (c4502j != null) {
                this.window = null;
                c4502j.onError(th);
            }
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            C4502j<T> c4502j = this.window;
            if (c4502j == null && !this.cancelled) {
                c4502j = C4502j.m17366a(this.capacityHint, (Runnable) this);
                this.window = c4502j;
                this.actual.onNext(c4502j);
            }
            if (c4502j != null) {
                c4502j.onNext(t);
                long j2 = this.size + 1;
                this.size = j2;
                if (j2 >= this.count) {
                    this.size = 0L;
                    this.window = null;
                    c4502j.onComplete();
                    if (this.cancelled) {
                        this.f19524s.dispose();
                    }
                }
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19524s, interfaceC4552c)) {
                this.f19524s = interfaceC4552c;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled) {
                this.f19524s.dispose();
            }
        }
    }

    /* compiled from: ObservableWindow.java */
    /* renamed from: g.a.y0.e.d.y3$b */
    static final class b<T> extends AtomicBoolean implements InterfaceC4514i0<T>, InterfaceC4552c, Runnable {
        private static final long serialVersionUID = 3366976432059579510L;
        final InterfaceC4514i0<? super AbstractC4469b0<T>> actual;
        volatile boolean cancelled;
        final int capacityHint;
        final long count;
        long firstEmission;
        long index;

        /* renamed from: s */
        InterfaceC4552c f19525s;
        final long skip;
        final AtomicInteger wip = new AtomicInteger();
        final ArrayDeque<C4502j<T>> windows = new ArrayDeque<>();

        b(InterfaceC4514i0<? super AbstractC4469b0<T>> interfaceC4514i0, long j2, long j3, int i2) {
            this.actual = interfaceC4514i0;
            this.count = j2;
            this.skip = j3;
            this.capacityHint = i2;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.cancelled = true;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            ArrayDeque<C4502j<T>> arrayDeque = this.windows;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onComplete();
            }
            this.actual.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            ArrayDeque<C4502j<T>> arrayDeque = this.windows;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onError(th);
            }
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            ArrayDeque<C4502j<T>> arrayDeque = this.windows;
            long j2 = this.index;
            long j3 = this.skip;
            if (j2 % j3 == 0 && !this.cancelled) {
                this.wip.getAndIncrement();
                C4502j<T> m17366a = C4502j.m17366a(this.capacityHint, (Runnable) this);
                arrayDeque.offer(m17366a);
                this.actual.onNext(m17366a);
            }
            long j4 = this.firstEmission + 1;
            Iterator<C4502j<T>> it = arrayDeque.iterator();
            while (it.hasNext()) {
                it.next().onNext(t);
            }
            if (j4 >= this.count) {
                arrayDeque.poll().onComplete();
                if (arrayDeque.isEmpty() && this.cancelled) {
                    this.f19525s.dispose();
                    return;
                }
                this.firstEmission = j4 - j3;
            } else {
                this.firstEmission = j4;
            }
            this.index = j2 + 1;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19525s, interfaceC4552c)) {
                this.f19525s = interfaceC4552c;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wip.decrementAndGet() == 0 && this.cancelled) {
                this.f19525s.dispose();
            }
        }
    }

    public C5039y3(InterfaceC4504g0<T> interfaceC4504g0, long j2, long j3, int i2) {
        super(interfaceC4504g0);
        this.f19521b = j2;
        this.f19522c = j3;
        this.f19523d = i2;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super AbstractC4469b0<T>> interfaceC4514i0) {
        long j2 = this.f19521b;
        long j3 = this.f19522c;
        if (j2 == j3) {
            this.f18742a.subscribe(new a(interfaceC4514i0, j2, this.f19523d));
        } else {
            this.f18742a.subscribe(new b(interfaceC4514i0, j2, j3, this.f19523d));
        }
    }
}
