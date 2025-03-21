package p251g.p252a.p268y0.p273e.p276c;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p271c.InterfaceC4607f;

/* compiled from: MaybeSwitchIfEmptySingle.java */
/* renamed from: g.a.y0.e.c.e1 */
/* loaded from: classes2.dex */
public final class C4850e1<T> extends AbstractC4518k0<T> implements InterfaceC4607f<T> {

    /* renamed from: a */
    final InterfaceC4588y<T> f18600a;

    /* renamed from: b */
    final InterfaceC4530q0<? extends T> f18601b;

    /* compiled from: MaybeSwitchIfEmptySingle.java */
    /* renamed from: g.a.y0.e.c.e1$a */
    static final class a<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4559v<T>, InterfaceC4552c {
        private static final long serialVersionUID = 4603919676453758899L;
        final InterfaceC4524n0<? super T> actual;
        final InterfaceC4530q0<? extends T> other;

        /* compiled from: MaybeSwitchIfEmptySingle.java */
        /* renamed from: g.a.y0.e.c.e1$a$a, reason: collision with other inner class name */
        static final class C7403a<T> implements InterfaceC4524n0<T> {

            /* renamed from: a */
            final InterfaceC4524n0<? super T> f18602a;

            /* renamed from: b */
            final AtomicReference<InterfaceC4552c> f18603b;

            C7403a(InterfaceC4524n0<? super T> interfaceC4524n0, AtomicReference<InterfaceC4552c> atomicReference) {
                this.f18602a = interfaceC4524n0;
                this.f18603b = atomicReference;
            }

            @Override // p251g.p252a.InterfaceC4524n0
            public void onError(Throwable th) {
                this.f18602a.onError(th);
            }

            @Override // p251g.p252a.InterfaceC4524n0
            public void onSubscribe(InterfaceC4552c interfaceC4552c) {
                EnumC4592d.setOnce(this.f18603b, interfaceC4552c);
            }

            @Override // p251g.p252a.InterfaceC4524n0
            public void onSuccess(T t) {
                this.f18602a.onSuccess(t);
            }
        }

        a(InterfaceC4524n0<? super T> interfaceC4524n0, InterfaceC4530q0<? extends T> interfaceC4530q0) {
            this.actual = interfaceC4524n0;
            this.other = interfaceC4530q0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC4592d.isDisposed(get());
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            InterfaceC4552c interfaceC4552c = get();
            if (interfaceC4552c == EnumC4592d.DISPOSED || !compareAndSet(interfaceC4552c, null)) {
                return;
            }
            this.other.mo17490a(new C7403a(this.actual, this));
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.setOnce(this, interfaceC4552c)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }
    }

    public C4850e1(InterfaceC4588y<T> interfaceC4588y, InterfaceC4530q0<? extends T> interfaceC4530q0) {
        this.f18600a = interfaceC4588y;
        this.f18601b = interfaceC4530q0;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        this.f18600a.mo18100a(new a(interfaceC4524n0, this.f18601b));
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4607f
    public InterfaceC4588y<T> source() {
        return this.f18600a;
    }
}
