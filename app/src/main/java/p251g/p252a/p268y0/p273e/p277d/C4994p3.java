package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p253a1.C4466m;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: ObservableThrottleFirstTimed.java */
/* renamed from: g.a.y0.e.d.p3 */
/* loaded from: classes2.dex */
public final class C4994p3<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final long f19277b;

    /* renamed from: c */
    final TimeUnit f19278c;

    /* renamed from: d */
    final AbstractC4516j0 f19279d;

    /* compiled from: ObservableThrottleFirstTimed.java */
    /* renamed from: g.a.y0.e.d.p3$a */
    static final class a<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4514i0<T>, InterfaceC4552c, Runnable {
        private static final long serialVersionUID = 786994795061867455L;
        final InterfaceC4514i0<? super T> actual;
        boolean done;
        volatile boolean gate;

        /* renamed from: s */
        InterfaceC4552c f19280s;
        final long timeout;
        final TimeUnit unit;
        final AbstractC4516j0.c worker;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, long j2, TimeUnit timeUnit, AbstractC4516j0.c cVar) {
            this.actual = interfaceC4514i0;
            this.timeout = j2;
            this.unit = timeUnit;
            this.worker = cVar;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19280s.dispose();
            this.worker.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.worker.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
            this.worker.dispose();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.done) {
                C4476a.m17152b(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
            this.worker.dispose();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.gate || this.done) {
                return;
            }
            this.gate = true;
            this.actual.onNext(t);
            InterfaceC4552c interfaceC4552c = get();
            if (interfaceC4552c != null) {
                interfaceC4552c.dispose();
            }
            EnumC4592d.replace(this, this.worker.mo17283a(this, this.timeout, this.unit));
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19280s, interfaceC4552c)) {
                this.f19280s = interfaceC4552c;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.gate = false;
        }
    }

    public C4994p3(InterfaceC4504g0<T> interfaceC4504g0, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        super(interfaceC4504g0);
        this.f19277b = j2;
        this.f19278c = timeUnit;
        this.f19279d = abstractC4516j0;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f18742a.subscribe(new a(new C4466m(interfaceC4514i0), this.f19277b, this.f19278c, this.f19279d.mo17277a()));
    }
}
