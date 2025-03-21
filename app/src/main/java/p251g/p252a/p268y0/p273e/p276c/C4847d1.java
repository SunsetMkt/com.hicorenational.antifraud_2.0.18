package p251g.p252a.p268y0.p273e.p276c;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: MaybeSwitchIfEmpty.java */
/* renamed from: g.a.y0.e.c.d1 */
/* loaded from: classes2.dex */
public final class C4847d1<T> extends AbstractC4836a<T, T> {

    /* renamed from: b */
    final InterfaceC4588y<? extends T> f18592b;

    /* compiled from: MaybeSwitchIfEmpty.java */
    /* renamed from: g.a.y0.e.c.d1$a */
    static final class a<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4559v<T>, InterfaceC4552c {
        private static final long serialVersionUID = -2223459372976438024L;
        final InterfaceC4559v<? super T> actual;
        final InterfaceC4588y<? extends T> other;

        /* compiled from: MaybeSwitchIfEmpty.java */
        /* renamed from: g.a.y0.e.c.d1$a$a, reason: collision with other inner class name */
        static final class C7402a<T> implements InterfaceC4559v<T> {

            /* renamed from: a */
            final InterfaceC4559v<? super T> f18593a;

            /* renamed from: b */
            final AtomicReference<InterfaceC4552c> f18594b;

            C7402a(InterfaceC4559v<? super T> interfaceC4559v, AtomicReference<InterfaceC4552c> atomicReference) {
                this.f18593a = interfaceC4559v;
                this.f18594b = atomicReference;
            }

            @Override // p251g.p252a.InterfaceC4559v
            public void onComplete() {
                this.f18593a.onComplete();
            }

            @Override // p251g.p252a.InterfaceC4559v
            public void onError(Throwable th) {
                this.f18593a.onError(th);
            }

            @Override // p251g.p252a.InterfaceC4559v
            public void onSubscribe(InterfaceC4552c interfaceC4552c) {
                EnumC4592d.setOnce(this.f18594b, interfaceC4552c);
            }

            @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
            public void onSuccess(T t) {
                this.f18593a.onSuccess(t);
            }
        }

        a(InterfaceC4559v<? super T> interfaceC4559v, InterfaceC4588y<? extends T> interfaceC4588y) {
            this.actual = interfaceC4559v;
            this.other = interfaceC4588y;
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
            this.other.mo18100a(new C7402a(this.actual, this));
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

    public C4847d1(InterfaceC4588y<T> interfaceC4588y, InterfaceC4588y<? extends T> interfaceC4588y2) {
        super(interfaceC4588y);
        this.f18592b = interfaceC4588y2;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        this.f18548a.mo18100a(new a(interfaceC4559v, this.f18592b));
    }
}
