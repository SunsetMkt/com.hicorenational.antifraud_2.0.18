package p251g.p252a.p268y0.p273e.p276c;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4533s;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p263t0.InterfaceC4545e;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: MaybeFlatMapSingleElement.java */
@InterfaceC4545e
/* renamed from: g.a.y0.e.c.f0 */
/* loaded from: classes2.dex */
public final class C4852f0<T, R> extends AbstractC4533s<R> {

    /* renamed from: a */
    final InterfaceC4588y<T> f18605a;

    /* renamed from: b */
    final InterfaceC4584o<? super T, ? extends InterfaceC4530q0<? extends R>> f18606b;

    /* compiled from: MaybeFlatMapSingleElement.java */
    /* renamed from: g.a.y0.e.c.f0$a */
    static final class a<T, R> extends AtomicReference<InterfaceC4552c> implements InterfaceC4559v<T>, InterfaceC4552c {
        private static final long serialVersionUID = 4827726964688405508L;
        final InterfaceC4559v<? super R> actual;
        final InterfaceC4584o<? super T, ? extends InterfaceC4530q0<? extends R>> mapper;

        a(InterfaceC4559v<? super R> interfaceC4559v, InterfaceC4584o<? super T, ? extends InterfaceC4530q0<? extends R>> interfaceC4584o) {
            this.actual = interfaceC4559v;
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
            this.actual.onComplete();
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
                ((InterfaceC4530q0) C4601b.m18284a(this.mapper.apply(t), "The mapper returned a null SingleSource")).mo17490a(new b(this, this.actual));
            } catch (Throwable th) {
                C4561b.m18199b(th);
                onError(th);
            }
        }
    }

    /* compiled from: MaybeFlatMapSingleElement.java */
    /* renamed from: g.a.y0.e.c.f0$b */
    static final class b<R> implements InterfaceC4524n0<R> {

        /* renamed from: a */
        final AtomicReference<InterfaceC4552c> f18607a;

        /* renamed from: b */
        final InterfaceC4559v<? super R> f18608b;

        b(AtomicReference<InterfaceC4552c> atomicReference, InterfaceC4559v<? super R> interfaceC4559v) {
            this.f18607a = atomicReference;
            this.f18608b = interfaceC4559v;
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onError(Throwable th) {
            this.f18608b.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.replace(this.f18607a, interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(R r) {
            this.f18608b.onSuccess(r);
        }
    }

    public C4852f0(InterfaceC4588y<T> interfaceC4588y, InterfaceC4584o<? super T, ? extends InterfaceC4530q0<? extends R>> interfaceC4584o) {
        this.f18605a = interfaceC4588y;
        this.f18606b = interfaceC4584o;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super R> interfaceC4559v) {
        this.f18605a.mo18100a(new a(interfaceC4559v, this.f18606b));
    }
}
