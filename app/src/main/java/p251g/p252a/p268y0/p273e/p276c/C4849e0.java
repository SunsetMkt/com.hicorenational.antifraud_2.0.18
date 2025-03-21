package p251g.p252a.p268y0.p273e.p276c;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: MaybeFlatMapSingle.java */
/* renamed from: g.a.y0.e.c.e0 */
/* loaded from: classes2.dex */
public final class C4849e0<T, R> extends AbstractC4518k0<R> {

    /* renamed from: a */
    final InterfaceC4588y<T> f18596a;

    /* renamed from: b */
    final InterfaceC4584o<? super T, ? extends InterfaceC4530q0<? extends R>> f18597b;

    /* compiled from: MaybeFlatMapSingle.java */
    /* renamed from: g.a.y0.e.c.e0$a */
    static final class a<T, R> extends AtomicReference<InterfaceC4552c> implements InterfaceC4559v<T>, InterfaceC4552c {
        private static final long serialVersionUID = 4827726964688405508L;
        final InterfaceC4524n0<? super R> actual;
        final InterfaceC4584o<? super T, ? extends InterfaceC4530q0<? extends R>> mapper;

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

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            this.actual.onError(new NoSuchElementException());
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
            try {
                InterfaceC4530q0 interfaceC4530q0 = (InterfaceC4530q0) C4601b.m18284a(this.mapper.apply(t), "The mapper returned a null SingleSource");
                if (isDisposed()) {
                    return;
                }
                interfaceC4530q0.mo17490a(new b(this, this.actual));
            } catch (Throwable th) {
                C4561b.m18199b(th);
                onError(th);
            }
        }
    }

    /* compiled from: MaybeFlatMapSingle.java */
    /* renamed from: g.a.y0.e.c.e0$b */
    static final class b<R> implements InterfaceC4524n0<R> {

        /* renamed from: a */
        final AtomicReference<InterfaceC4552c> f18598a;

        /* renamed from: b */
        final InterfaceC4524n0<? super R> f18599b;

        b(AtomicReference<InterfaceC4552c> atomicReference, InterfaceC4524n0<? super R> interfaceC4524n0) {
            this.f18598a = atomicReference;
            this.f18599b = interfaceC4524n0;
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onError(Throwable th) {
            this.f18599b.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.replace(this.f18598a, interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(R r) {
            this.f18599b.onSuccess(r);
        }
    }

    public C4849e0(InterfaceC4588y<T> interfaceC4588y, InterfaceC4584o<? super T, ? extends InterfaceC4530q0<? extends R>> interfaceC4584o) {
        this.f18596a = interfaceC4588y;
        this.f18597b = interfaceC4584o;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super R> interfaceC4524n0) {
        this.f18596a.mo18100a(new a(interfaceC4524n0, this.f18597b));
    }
}
