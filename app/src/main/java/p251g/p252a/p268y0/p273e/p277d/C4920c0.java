package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p253a1.C4466m;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: ObservableDebounceTimed.java */
/* renamed from: g.a.y0.e.d.c0 */
/* loaded from: classes2.dex */
public final class C4920c0<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final long f18817b;

    /* renamed from: c */
    final TimeUnit f18818c;

    /* renamed from: d */
    final AbstractC4516j0 f18819d;

    /* compiled from: ObservableDebounceTimed.java */
    /* renamed from: g.a.y0.e.d.c0$a */
    static final class a<T> extends AtomicReference<InterfaceC4552c> implements Runnable, InterfaceC4552c {
        private static final long serialVersionUID = 6812032969491025141L;
        final long idx;
        final AtomicBoolean once = new AtomicBoolean();
        final b<T> parent;
        final T value;

        a(T t, long j2, b<T> bVar) {
            this.value = t;
            this.idx = j2;
            this.parent = bVar;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return get() == EnumC4592d.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.m18428a(this.idx, this.value, this);
            }
        }

        public void setResource(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.replace(this, interfaceC4552c);
        }
    }

    /* compiled from: ObservableDebounceTimed.java */
    /* renamed from: g.a.y0.e.d.c0$b */
    static final class b<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4514i0<? super T> f18820a;

        /* renamed from: b */
        final long f18821b;

        /* renamed from: c */
        final TimeUnit f18822c;

        /* renamed from: d */
        final AbstractC4516j0.c f18823d;

        /* renamed from: e */
        InterfaceC4552c f18824e;

        /* renamed from: f */
        final AtomicReference<InterfaceC4552c> f18825f = new AtomicReference<>();

        /* renamed from: g */
        volatile long f18826g;

        /* renamed from: h */
        boolean f18827h;

        b(InterfaceC4514i0<? super T> interfaceC4514i0, long j2, TimeUnit timeUnit, AbstractC4516j0.c cVar) {
            this.f18820a = interfaceC4514i0;
            this.f18821b = j2;
            this.f18822c = timeUnit;
            this.f18823d = cVar;
        }

        /* renamed from: a */
        void m18428a(long j2, T t, a<T> aVar) {
            if (j2 == this.f18826g) {
                this.f18820a.onNext(t);
                aVar.dispose();
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18824e.dispose();
            this.f18823d.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18823d.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f18827h) {
                return;
            }
            this.f18827h = true;
            InterfaceC4552c interfaceC4552c = this.f18825f.get();
            if (interfaceC4552c != EnumC4592d.DISPOSED) {
                a aVar = (a) interfaceC4552c;
                if (aVar != null) {
                    aVar.run();
                }
                this.f18820a.onComplete();
                this.f18823d.dispose();
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.f18827h) {
                C4476a.m17152b(th);
                return;
            }
            this.f18827h = true;
            this.f18820a.onError(th);
            this.f18823d.dispose();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.f18827h) {
                return;
            }
            long j2 = this.f18826g + 1;
            this.f18826g = j2;
            InterfaceC4552c interfaceC4552c = this.f18825f.get();
            if (interfaceC4552c != null) {
                interfaceC4552c.dispose();
            }
            a aVar = new a(t, j2, this);
            if (this.f18825f.compareAndSet(interfaceC4552c, aVar)) {
                aVar.setResource(this.f18823d.mo17283a(aVar, this.f18821b, this.f18822c));
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18824e, interfaceC4552c)) {
                this.f18824e = interfaceC4552c;
                this.f18820a.onSubscribe(this);
            }
        }
    }

    public C4920c0(InterfaceC4504g0<T> interfaceC4504g0, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        super(interfaceC4504g0);
        this.f18817b = j2;
        this.f18818c = timeUnit;
        this.f18819d = abstractC4516j0;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f18742a.subscribe(new b(new C4466m(interfaceC4514i0), this.f18817b, this.f18818c, this.f18819d.mo17277a()));
    }
}
