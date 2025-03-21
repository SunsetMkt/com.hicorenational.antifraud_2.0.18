package p251g.p252a.p268y0.p273e.p276c;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4572c;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: MaybeFlatMapBiSelector.java */
/* renamed from: g.a.y0.e.c.z */
/* loaded from: classes2.dex */
public final class C4905z<T, U, R> extends AbstractC4836a<T, R> {

    /* renamed from: b */
    final InterfaceC4584o<? super T, ? extends InterfaceC4588y<? extends U>> f18734b;

    /* renamed from: c */
    final InterfaceC4572c<? super T, ? super U, ? extends R> f18735c;

    /* compiled from: MaybeFlatMapBiSelector.java */
    /* renamed from: g.a.y0.e.c.z$a */
    static final class a<T, U, R> implements InterfaceC4559v<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4584o<? super T, ? extends InterfaceC4588y<? extends U>> f18736a;

        /* renamed from: b */
        final C7407a<T, U, R> f18737b;

        /* compiled from: MaybeFlatMapBiSelector.java */
        /* renamed from: g.a.y0.e.c.z$a$a, reason: collision with other inner class name */
        static final class C7407a<T, U, R> extends AtomicReference<InterfaceC4552c> implements InterfaceC4559v<U> {
            private static final long serialVersionUID = -2897979525538174559L;
            final InterfaceC4559v<? super R> actual;
            final InterfaceC4572c<? super T, ? super U, ? extends R> resultSelector;
            T value;

            C7407a(InterfaceC4559v<? super R> interfaceC4559v, InterfaceC4572c<? super T, ? super U, ? extends R> interfaceC4572c) {
                this.actual = interfaceC4559v;
                this.resultSelector = interfaceC4572c;
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
                EnumC4592d.setOnce(this, interfaceC4552c);
            }

            @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
            public void onSuccess(U u) {
                T t = this.value;
                this.value = null;
                try {
                    this.actual.onSuccess(C4601b.m18284a(this.resultSelector.apply(t, u), "The resultSelector returned a null value"));
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    this.actual.onError(th);
                }
            }
        }

        a(InterfaceC4559v<? super R> interfaceC4559v, InterfaceC4584o<? super T, ? extends InterfaceC4588y<? extends U>> interfaceC4584o, InterfaceC4572c<? super T, ? super U, ? extends R> interfaceC4572c) {
            this.f18737b = new C7407a<>(interfaceC4559v, interfaceC4572c);
            this.f18736a = interfaceC4584o;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this.f18737b);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC4592d.isDisposed(this.f18737b.get());
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            this.f18737b.actual.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            this.f18737b.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.setOnce(this.f18737b, interfaceC4552c)) {
                this.f18737b.actual.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            try {
                InterfaceC4588y interfaceC4588y = (InterfaceC4588y) C4601b.m18284a(this.f18736a.apply(t), "The mapper returned a null MaybeSource");
                if (EnumC4592d.replace(this.f18737b, null)) {
                    C7407a<T, U, R> c7407a = this.f18737b;
                    c7407a.value = t;
                    interfaceC4588y.mo18100a(c7407a);
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f18737b.actual.onError(th);
            }
        }
    }

    public C4905z(InterfaceC4588y<T> interfaceC4588y, InterfaceC4584o<? super T, ? extends InterfaceC4588y<? extends U>> interfaceC4584o, InterfaceC4572c<? super T, ? super U, ? extends R> interfaceC4572c) {
        super(interfaceC4588y);
        this.f18734b = interfaceC4584o;
        this.f18735c = interfaceC4572c;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super R> interfaceC4559v) {
        this.f18548a.mo18100a(new a(interfaceC4559v, this.f18734b, this.f18735c));
    }
}
