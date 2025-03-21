package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.TimeUnit;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p253a1.C4466m;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: ObservableDelay.java */
/* renamed from: g.a.y0.e.d.e0 */
/* loaded from: classes2.dex */
public final class C4932e0<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final long f18925b;

    /* renamed from: c */
    final TimeUnit f18926c;

    /* renamed from: d */
    final AbstractC4516j0 f18927d;

    /* renamed from: e */
    final boolean f18928e;

    /* compiled from: ObservableDelay.java */
    /* renamed from: g.a.y0.e.d.e0$a */
    static final class a<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4514i0<? super T> f18929a;

        /* renamed from: b */
        final long f18930b;

        /* renamed from: c */
        final TimeUnit f18931c;

        /* renamed from: d */
        final AbstractC4516j0.c f18932d;

        /* renamed from: e */
        final boolean f18933e;

        /* renamed from: f */
        InterfaceC4552c f18934f;

        /* compiled from: ObservableDelay.java */
        /* renamed from: g.a.y0.e.d.e0$a$a, reason: collision with other inner class name */
        final class RunnableC7412a implements Runnable {
            RunnableC7412a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.f18929a.onComplete();
                } finally {
                    a.this.f18932d.dispose();
                }
            }
        }

        /* compiled from: ObservableDelay.java */
        /* renamed from: g.a.y0.e.d.e0$a$b */
        final class b implements Runnable {

            /* renamed from: a */
            private final Throwable f18936a;

            b(Throwable th) {
                this.f18936a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.f18929a.onError(this.f18936a);
                } finally {
                    a.this.f18932d.dispose();
                }
            }
        }

        /* compiled from: ObservableDelay.java */
        /* renamed from: g.a.y0.e.d.e0$a$c */
        final class c implements Runnable {

            /* renamed from: a */
            private final T f18938a;

            c(T t) {
                this.f18938a = t;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f18929a.onNext(this.f18938a);
            }
        }

        a(InterfaceC4514i0<? super T> interfaceC4514i0, long j2, TimeUnit timeUnit, AbstractC4516j0.c cVar, boolean z) {
            this.f18929a = interfaceC4514i0;
            this.f18930b = j2;
            this.f18931c = timeUnit;
            this.f18932d = cVar;
            this.f18933e = z;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18934f.dispose();
            this.f18932d.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18932d.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.f18932d.mo17283a(new RunnableC7412a(), this.f18930b, this.f18931c);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f18932d.mo17283a(new b(th), this.f18933e ? this.f18930b : 0L, this.f18931c);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            this.f18932d.mo17283a(new c(t), this.f18930b, this.f18931c);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18934f, interfaceC4552c)) {
                this.f18934f = interfaceC4552c;
                this.f18929a.onSubscribe(this);
            }
        }
    }

    public C4932e0(InterfaceC4504g0<T> interfaceC4504g0, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, boolean z) {
        super(interfaceC4504g0);
        this.f18925b = j2;
        this.f18926c = timeUnit;
        this.f18927d = abstractC4516j0;
        this.f18928e = z;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f18742a.subscribe(new a(this.f18928e ? interfaceC4514i0 : new C4466m(interfaceC4514i0), this.f18925b, this.f18926c, this.f18927d.mo17277a(), this.f18928e));
    }
}
