package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p253a1.C4466m;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: ObservableSampleWithObservable.java */
/* renamed from: g.a.y0.e.d.r2 */
/* loaded from: classes2.dex */
public final class C5003r2<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final InterfaceC4504g0<?> f19353b;

    /* renamed from: c */
    final boolean f19354c;

    /* compiled from: ObservableSampleWithObservable.java */
    /* renamed from: g.a.y0.e.d.r2$a */
    static final class a<T> extends c<T> {
        private static final long serialVersionUID = -3029755663834015785L;
        volatile boolean done;
        final AtomicInteger wip;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, InterfaceC4504g0<?> interfaceC4504g0) {
            super(interfaceC4514i0, interfaceC4504g0);
            this.wip = new AtomicInteger();
        }

        @Override // p251g.p252a.p268y0.p273e.p277d.C5003r2.c
        void completeMain() {
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                emit();
                this.actual.onComplete();
            }
        }

        @Override // p251g.p252a.p268y0.p273e.p277d.C5003r2.c
        void completeOther() {
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                emit();
                this.actual.onComplete();
            }
        }

        @Override // p251g.p252a.p268y0.p273e.p277d.C5003r2.c
        void run() {
            if (this.wip.getAndIncrement() == 0) {
                do {
                    boolean z = this.done;
                    emit();
                    if (z) {
                        this.actual.onComplete();
                        return;
                    }
                } while (this.wip.decrementAndGet() != 0);
            }
        }
    }

    /* compiled from: ObservableSampleWithObservable.java */
    /* renamed from: g.a.y0.e.d.r2$b */
    static final class b<T> extends c<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        b(InterfaceC4514i0<? super T> interfaceC4514i0, InterfaceC4504g0<?> interfaceC4504g0) {
            super(interfaceC4514i0, interfaceC4504g0);
        }

        @Override // p251g.p252a.p268y0.p273e.p277d.C5003r2.c
        void completeMain() {
            this.actual.onComplete();
        }

        @Override // p251g.p252a.p268y0.p273e.p277d.C5003r2.c
        void completeOther() {
            this.actual.onComplete();
        }

        @Override // p251g.p252a.p268y0.p273e.p277d.C5003r2.c
        void run() {
            emit();
        }
    }

    /* compiled from: ObservableSampleWithObservable.java */
    /* renamed from: g.a.y0.e.d.r2$c */
    static abstract class c<T> extends AtomicReference<T> implements InterfaceC4514i0<T>, InterfaceC4552c {
        private static final long serialVersionUID = -3517602651313910099L;
        final InterfaceC4514i0<? super T> actual;
        final AtomicReference<InterfaceC4552c> other = new AtomicReference<>();

        /* renamed from: s */
        InterfaceC4552c f19355s;
        final InterfaceC4504g0<?> sampler;

        c(InterfaceC4514i0<? super T> interfaceC4514i0, InterfaceC4504g0<?> interfaceC4504g0) {
            this.actual = interfaceC4514i0;
            this.sampler = interfaceC4504g0;
        }

        public void complete() {
            this.f19355s.dispose();
            completeOther();
        }

        abstract void completeMain();

        abstract void completeOther();

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this.other);
            this.f19355s.dispose();
        }

        void emit() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.actual.onNext(andSet);
            }
        }

        public void error(Throwable th) {
            this.f19355s.dispose();
            this.actual.onError(th);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.other.get() == EnumC4592d.DISPOSED;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            EnumC4592d.dispose(this.other);
            completeMain();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            EnumC4592d.dispose(this.other);
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19355s, interfaceC4552c)) {
                this.f19355s = interfaceC4552c;
                this.actual.onSubscribe(this);
                if (this.other.get() == null) {
                    this.sampler.subscribe(new d(this));
                }
            }
        }

        abstract void run();

        boolean setOther(InterfaceC4552c interfaceC4552c) {
            return EnumC4592d.setOnce(this.other, interfaceC4552c);
        }
    }

    /* compiled from: ObservableSampleWithObservable.java */
    /* renamed from: g.a.y0.e.d.r2$d */
    static final class d<T> implements InterfaceC4514i0<Object> {

        /* renamed from: a */
        final c<T> f19356a;

        d(c<T> cVar) {
            this.f19356a = cVar;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.f19356a.complete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f19356a.error(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(Object obj) {
            this.f19356a.run();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f19356a.setOther(interfaceC4552c);
        }
    }

    public C5003r2(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4504g0<?> interfaceC4504g02, boolean z) {
        super(interfaceC4504g0);
        this.f19353b = interfaceC4504g02;
        this.f19354c = z;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        C4466m c4466m = new C4466m(interfaceC4514i0);
        if (this.f19354c) {
            this.f18742a.subscribe(new a(c4466m, this.f19353b));
        } else {
            this.f18742a.subscribe(new b(c4466m, this.f19353b));
        }
    }
}
