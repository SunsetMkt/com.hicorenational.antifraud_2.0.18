package p251g.p252a.p268y0.p273e.p276c;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: MaybeFlatten.java */
/* renamed from: g.a.y0.e.c.g0 */
/* loaded from: classes2.dex */
public final class C4855g0<T, R> extends AbstractC4836a<T, R> {

    /* renamed from: b */
    final InterfaceC4584o<? super T, ? extends InterfaceC4588y<? extends R>> f18611b;

    /* compiled from: MaybeFlatten.java */
    /* renamed from: g.a.y0.e.c.g0$a */
    static final class a<T, R> extends AtomicReference<InterfaceC4552c> implements InterfaceC4559v<T>, InterfaceC4552c {
        private static final long serialVersionUID = 4375739915521278546L;
        final InterfaceC4559v<? super R> actual;

        /* renamed from: d */
        InterfaceC4552c f18612d;
        final InterfaceC4584o<? super T, ? extends InterfaceC4588y<? extends R>> mapper;

        /* compiled from: MaybeFlatten.java */
        /* renamed from: g.a.y0.e.c.g0$a$a, reason: collision with other inner class name */
        final class C7405a implements InterfaceC4559v<R> {
            C7405a() {
            }

            @Override // p251g.p252a.InterfaceC4559v
            public void onComplete() {
                a.this.actual.onComplete();
            }

            @Override // p251g.p252a.InterfaceC4559v
            public void onError(Throwable th) {
                a.this.actual.onError(th);
            }

            @Override // p251g.p252a.InterfaceC4559v
            public void onSubscribe(InterfaceC4552c interfaceC4552c) {
                EnumC4592d.setOnce(a.this, interfaceC4552c);
            }

            @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
            public void onSuccess(R r) {
                a.this.actual.onSuccess(r);
            }
        }

        a(InterfaceC4559v<? super R> interfaceC4559v, InterfaceC4584o<? super T, ? extends InterfaceC4588y<? extends R>> interfaceC4584o) {
            this.actual = interfaceC4559v;
            this.mapper = interfaceC4584o;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this);
            this.f18612d.dispose();
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
            if (EnumC4592d.validate(this.f18612d, interfaceC4552c)) {
                this.f18612d = interfaceC4552c;
                this.actual.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            try {
                InterfaceC4588y interfaceC4588y = (InterfaceC4588y) C4601b.m18284a(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                if (isDisposed()) {
                    return;
                }
                interfaceC4588y.mo18100a(new C7405a());
            } catch (Exception e2) {
                C4561b.m18199b(e2);
                this.actual.onError(e2);
            }
        }
    }

    public C4855g0(InterfaceC4588y<T> interfaceC4588y, InterfaceC4584o<? super T, ? extends InterfaceC4588y<? extends R>> interfaceC4584o) {
        super(interfaceC4588y);
        this.f18611b = interfaceC4584o;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super R> interfaceC4559v) {
        this.f18548a.mo18100a(new a(interfaceC4559v, this.f18611b));
    }
}
