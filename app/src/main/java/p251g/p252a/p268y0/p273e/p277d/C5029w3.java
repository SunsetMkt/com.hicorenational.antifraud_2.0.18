package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.atomic.AtomicBoolean;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: ObservableUnsubscribeOn.java */
/* renamed from: g.a.y0.e.d.w3 */
/* loaded from: classes2.dex */
public final class C5029w3<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final AbstractC4516j0 f19489b;

    /* compiled from: ObservableUnsubscribeOn.java */
    /* renamed from: g.a.y0.e.d.w3$a */
    static final class a<T> extends AtomicBoolean implements InterfaceC4514i0<T>, InterfaceC4552c {
        private static final long serialVersionUID = 1015244841293359600L;
        final InterfaceC4514i0<? super T> actual;

        /* renamed from: s */
        InterfaceC4552c f19490s;
        final AbstractC4516j0 scheduler;

        /* compiled from: ObservableUnsubscribeOn.java */
        /* renamed from: g.a.y0.e.d.w3$a$a, reason: collision with other inner class name */
        final class RunnableC7420a implements Runnable {
            RunnableC7420a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f19490s.dispose();
            }
        }

        a(InterfaceC4514i0<? super T> interfaceC4514i0, AbstractC4516j0 abstractC4516j0) {
            this.actual = interfaceC4514i0;
            this.scheduler = abstractC4516j0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.scheduler.mo17407a(new RunnableC7420a());
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return get();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (get()) {
                return;
            }
            this.actual.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (get()) {
                C4476a.m17152b(th);
            } else {
                this.actual.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (get()) {
                return;
            }
            this.actual.onNext(t);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19490s, interfaceC4552c)) {
                this.f19490s = interfaceC4552c;
                this.actual.onSubscribe(this);
            }
        }
    }

    public C5029w3(InterfaceC4504g0<T> interfaceC4504g0, AbstractC4516j0 abstractC4516j0) {
        super(interfaceC4504g0);
        this.f19489b = abstractC4516j0;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0, this.f19489b));
    }
}
