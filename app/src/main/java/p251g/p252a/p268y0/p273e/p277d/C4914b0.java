package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p253a1.AbstractC4458e;
import p251g.p252a.p253a1.C4466m;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: ObservableDebounce.java */
/* renamed from: g.a.y0.e.d.b0 */
/* loaded from: classes2.dex */
public final class C4914b0<T, U> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final InterfaceC4584o<? super T, ? extends InterfaceC4504g0<U>> f18777b;

    /* compiled from: ObservableDebounce.java */
    /* renamed from: g.a.y0.e.d.b0$a */
    static final class a<T, U> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4514i0<? super T> f18778a;

        /* renamed from: b */
        final InterfaceC4584o<? super T, ? extends InterfaceC4504g0<U>> f18779b;

        /* renamed from: c */
        InterfaceC4552c f18780c;

        /* renamed from: d */
        final AtomicReference<InterfaceC4552c> f18781d = new AtomicReference<>();

        /* renamed from: e */
        volatile long f18782e;

        /* renamed from: f */
        boolean f18783f;

        /* compiled from: ObservableDebounce.java */
        /* renamed from: g.a.y0.e.d.b0$a$a, reason: collision with other inner class name */
        static final class C7409a<T, U> extends AbstractC4458e<U> {

            /* renamed from: b */
            final a<T, U> f18784b;

            /* renamed from: c */
            final long f18785c;

            /* renamed from: d */
            final T f18786d;

            /* renamed from: e */
            boolean f18787e;

            /* renamed from: f */
            final AtomicBoolean f18788f = new AtomicBoolean();

            C7409a(a<T, U> aVar, long j2, T t) {
                this.f18784b = aVar;
                this.f18785c = j2;
                this.f18786d = t;
            }

            /* renamed from: b */
            void m18420b() {
                if (this.f18788f.compareAndSet(false, true)) {
                    this.f18784b.m18419a(this.f18785c, this.f18786d);
                }
            }

            @Override // p251g.p252a.InterfaceC4514i0
            public void onComplete() {
                if (this.f18787e) {
                    return;
                }
                this.f18787e = true;
                m18420b();
            }

            @Override // p251g.p252a.InterfaceC4514i0
            public void onError(Throwable th) {
                if (this.f18787e) {
                    C4476a.m17152b(th);
                } else {
                    this.f18787e = true;
                    this.f18784b.onError(th);
                }
            }

            @Override // p251g.p252a.InterfaceC4514i0
            public void onNext(U u) {
                if (this.f18787e) {
                    return;
                }
                this.f18787e = true;
                dispose();
                m18420b();
            }
        }

        a(InterfaceC4514i0<? super T> interfaceC4514i0, InterfaceC4584o<? super T, ? extends InterfaceC4504g0<U>> interfaceC4584o) {
            this.f18778a = interfaceC4514i0;
            this.f18779b = interfaceC4584o;
        }

        /* renamed from: a */
        void m18419a(long j2, T t) {
            if (j2 == this.f18782e) {
                this.f18778a.onNext(t);
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18780c.dispose();
            EnumC4592d.dispose(this.f18781d);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18780c.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f18783f) {
                return;
            }
            this.f18783f = true;
            InterfaceC4552c interfaceC4552c = this.f18781d.get();
            if (interfaceC4552c != EnumC4592d.DISPOSED) {
                ((C7409a) interfaceC4552c).m18420b();
                EnumC4592d.dispose(this.f18781d);
                this.f18778a.onComplete();
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            EnumC4592d.dispose(this.f18781d);
            this.f18778a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.f18783f) {
                return;
            }
            long j2 = this.f18782e + 1;
            this.f18782e = j2;
            InterfaceC4552c interfaceC4552c = this.f18781d.get();
            if (interfaceC4552c != null) {
                interfaceC4552c.dispose();
            }
            try {
                InterfaceC4504g0 interfaceC4504g0 = (InterfaceC4504g0) C4601b.m18284a(this.f18779b.apply(t), "The ObservableSource supplied is null");
                C7409a c7409a = new C7409a(this, j2, t);
                if (this.f18781d.compareAndSet(interfaceC4552c, c7409a)) {
                    interfaceC4504g0.subscribe(c7409a);
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                dispose();
                this.f18778a.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18780c, interfaceC4552c)) {
                this.f18780c = interfaceC4552c;
                this.f18778a.onSubscribe(this);
            }
        }
    }

    public C4914b0(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4584o<? super T, ? extends InterfaceC4504g0<U>> interfaceC4584o) {
        super(interfaceC4504g0);
        this.f18777b = interfaceC4584o;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f18742a.subscribe(new a(new C4466m(interfaceC4514i0), this.f18777b));
    }
}
