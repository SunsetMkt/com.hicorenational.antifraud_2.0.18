package p251g.p252a.p268y0.p273e.p279f;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5823d;

/* compiled from: SingleTakeUntil.java */
/* renamed from: g.a.y0.e.f.n0 */
/* loaded from: classes2.dex */
public final class C5088n0<T, U> extends AbstractC4518k0<T> {

    /* renamed from: a */
    final InterfaceC4530q0<T> f19751a;

    /* renamed from: b */
    final InterfaceC5821b<U> f19752b;

    /* compiled from: SingleTakeUntil.java */
    /* renamed from: g.a.y0.e.f.n0$a */
    static final class a<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4524n0<T>, InterfaceC4552c {
        private static final long serialVersionUID = -622603812305745221L;
        final InterfaceC4524n0<? super T> actual;
        final b other = new b(this);

        a(InterfaceC4524n0<? super T> interfaceC4524n0) {
            this.actual = interfaceC4524n0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC4592d.isDisposed(get());
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onError(Throwable th) {
            this.other.dispose();
            InterfaceC4552c interfaceC4552c = get();
            EnumC4592d enumC4592d = EnumC4592d.DISPOSED;
            if (interfaceC4552c == enumC4592d || getAndSet(enumC4592d) == EnumC4592d.DISPOSED) {
                C4476a.m17152b(th);
            } else {
                this.actual.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.setOnce(this, interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.other.dispose();
            InterfaceC4552c interfaceC4552c = get();
            EnumC4592d enumC4592d = EnumC4592d.DISPOSED;
            if (interfaceC4552c == enumC4592d || getAndSet(enumC4592d) == EnumC4592d.DISPOSED) {
                return;
            }
            this.actual.onSuccess(t);
        }

        void otherError(Throwable th) {
            InterfaceC4552c andSet;
            InterfaceC4552c interfaceC4552c = get();
            EnumC4592d enumC4592d = EnumC4592d.DISPOSED;
            if (interfaceC4552c == enumC4592d || (andSet = getAndSet(enumC4592d)) == EnumC4592d.DISPOSED) {
                C4476a.m17152b(th);
                return;
            }
            if (andSet != null) {
                andSet.dispose();
            }
            this.actual.onError(th);
        }
    }

    /* compiled from: SingleTakeUntil.java */
    /* renamed from: g.a.y0.e.f.n0$b */
    static final class b extends AtomicReference<InterfaceC5823d> implements InterfaceC4529q<Object> {
        private static final long serialVersionUID = 5170026210238877381L;
        final a<?> parent;

        b(a<?> aVar) {
            this.parent = aVar;
        }

        public void dispose() {
            EnumC5160j.cancel(this);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            InterfaceC5823d interfaceC5823d = get();
            EnumC5160j enumC5160j = EnumC5160j.CANCELLED;
            if (interfaceC5823d != enumC5160j) {
                lazySet(enumC5160j);
                this.parent.otherError(new CancellationException());
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.parent.otherError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(Object obj) {
            if (EnumC5160j.cancel(this)) {
                this.parent.otherError(new CancellationException());
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.setOnce(this, interfaceC5823d)) {
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    public C5088n0(InterfaceC4530q0<T> interfaceC4530q0, InterfaceC5821b<U> interfaceC5821b) {
        this.f19751a = interfaceC4530q0;
        this.f19752b = interfaceC5821b;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        a aVar = new a(interfaceC4524n0);
        interfaceC4524n0.onSubscribe(aVar);
        this.f19752b.subscribe(aVar.other);
        this.f19751a.mo17490a(aVar);
    }
}
