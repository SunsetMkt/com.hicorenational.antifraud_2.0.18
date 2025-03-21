package p251g.p252a.p268y0.p273e.p279f;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: SingleFlatMap.java */
/* renamed from: g.a.y0.e.f.v */
/* loaded from: classes2.dex */
public final class C5103v<T, R> extends AbstractC4518k0<R> {

    /* renamed from: a */
    final InterfaceC4530q0<? extends T> f19805a;

    /* renamed from: b */
    final InterfaceC4584o<? super T, ? extends InterfaceC4530q0<? extends R>> f19806b;

    /* compiled from: SingleFlatMap.java */
    /* renamed from: g.a.y0.e.f.v$a */
    static final class a<T, R> extends AtomicReference<InterfaceC4552c> implements InterfaceC4524n0<T>, InterfaceC4552c {
        private static final long serialVersionUID = 3258103020495908596L;
        final InterfaceC4524n0<? super R> actual;
        final InterfaceC4584o<? super T, ? extends InterfaceC4530q0<? extends R>> mapper;

        /* compiled from: SingleFlatMap.java */
        /* renamed from: g.a.y0.e.f.v$a$a, reason: collision with other inner class name */
        static final class C7426a<R> implements InterfaceC4524n0<R> {

            /* renamed from: a */
            final AtomicReference<InterfaceC4552c> f19807a;

            /* renamed from: b */
            final InterfaceC4524n0<? super R> f19808b;

            C7426a(AtomicReference<InterfaceC4552c> atomicReference, InterfaceC4524n0<? super R> interfaceC4524n0) {
                this.f19807a = atomicReference;
                this.f19808b = interfaceC4524n0;
            }

            @Override // p251g.p252a.InterfaceC4524n0
            public void onError(Throwable th) {
                this.f19808b.onError(th);
            }

            @Override // p251g.p252a.InterfaceC4524n0
            public void onSubscribe(InterfaceC4552c interfaceC4552c) {
                EnumC4592d.replace(this.f19807a, interfaceC4552c);
            }

            @Override // p251g.p252a.InterfaceC4524n0
            public void onSuccess(R r) {
                this.f19808b.onSuccess(r);
            }
        }

        a(InterfaceC4524n0<? super R> interfaceC4524n0, InterfaceC4584o<? super T, ? extends InterfaceC4530q0<? extends R>> interfaceC4584o) {
            this.actual = interfaceC4524n0;
            this.mapper = interfaceC4584o;
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
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.setOnce(this, interfaceC4552c)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            try {
                InterfaceC4530q0 interfaceC4530q0 = (InterfaceC4530q0) C4601b.m18284a(this.mapper.apply(t), "The single returned by the mapper is null");
                if (isDisposed()) {
                    return;
                }
                interfaceC4530q0.mo17490a(new C7426a(this, this.actual));
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.actual.onError(th);
            }
        }
    }

    public C5103v(InterfaceC4530q0<? extends T> interfaceC4530q0, InterfaceC4584o<? super T, ? extends InterfaceC4530q0<? extends R>> interfaceC4584o) {
        this.f19806b = interfaceC4584o;
        this.f19805a = interfaceC4530q0;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super R> interfaceC4524n0) {
        this.f19805a.mo17490a(new a(interfaceC4524n0, this.f19806b));
    }
}
