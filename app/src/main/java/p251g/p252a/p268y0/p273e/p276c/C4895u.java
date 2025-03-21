package p251g.p252a.p268y0.p273e.p276c;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4573d;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: MaybeEqualSingle.java */
/* renamed from: g.a.y0.e.c.u */
/* loaded from: classes2.dex */
public final class C4895u<T> extends AbstractC4518k0<Boolean> {

    /* renamed from: a */
    final InterfaceC4588y<? extends T> f18709a;

    /* renamed from: b */
    final InterfaceC4588y<? extends T> f18710b;

    /* renamed from: c */
    final InterfaceC4573d<? super T, ? super T> f18711c;

    /* compiled from: MaybeEqualSingle.java */
    /* renamed from: g.a.y0.e.c.u$a */
    static final class a<T> extends AtomicInteger implements InterfaceC4552c {
        final InterfaceC4524n0<? super Boolean> actual;
        final InterfaceC4573d<? super T, ? super T> isEqual;
        final b<T> observer1;
        final b<T> observer2;

        a(InterfaceC4524n0<? super Boolean> interfaceC4524n0, InterfaceC4573d<? super T, ? super T> interfaceC4573d) {
            super(2);
            this.actual = interfaceC4524n0;
            this.isEqual = interfaceC4573d;
            this.observer1 = new b<>(this);
            this.observer2 = new b<>(this);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.observer1.dispose();
            this.observer2.dispose();
        }

        void done() {
            if (decrementAndGet() == 0) {
                Object obj = this.observer1.value;
                Object obj2 = this.observer2.value;
                if (obj == null || obj2 == null) {
                    this.actual.onSuccess(Boolean.valueOf(obj == null && obj2 == null));
                    return;
                }
                try {
                    this.actual.onSuccess(Boolean.valueOf(this.isEqual.mo18210a(obj, obj2)));
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    this.actual.onError(th);
                }
            }
        }

        void error(b<T> bVar, Throwable th) {
            if (getAndSet(0) <= 0) {
                C4476a.m17152b(th);
                return;
            }
            b<T> bVar2 = this.observer1;
            if (bVar == bVar2) {
                this.observer2.dispose();
            } else {
                bVar2.dispose();
            }
            this.actual.onError(th);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC4592d.isDisposed(this.observer1.get());
        }

        void subscribe(InterfaceC4588y<? extends T> interfaceC4588y, InterfaceC4588y<? extends T> interfaceC4588y2) {
            interfaceC4588y.mo18100a(this.observer1);
            interfaceC4588y2.mo18100a(this.observer2);
        }
    }

    /* compiled from: MaybeEqualSingle.java */
    /* renamed from: g.a.y0.e.c.u$b */
    static final class b<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4559v<T> {
        private static final long serialVersionUID = -3031974433025990931L;
        final a<T> parent;
        Object value;

        b(a<T> aVar) {
            this.parent = aVar;
        }

        public void dispose() {
            EnumC4592d.dispose(this);
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            this.parent.done();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            this.parent.error(this, th);
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.setOnce(this, interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.value = t;
            this.parent.done();
        }
    }

    public C4895u(InterfaceC4588y<? extends T> interfaceC4588y, InterfaceC4588y<? extends T> interfaceC4588y2, InterfaceC4573d<? super T, ? super T> interfaceC4573d) {
        this.f18709a = interfaceC4588y;
        this.f18710b = interfaceC4588y2;
        this.f18711c = interfaceC4573d;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super Boolean> interfaceC4524n0) {
        a aVar = new a(interfaceC4524n0, this.f18711c);
        interfaceC4524n0.onSubscribe(aVar);
        aVar.subscribe(this.f18709a, this.f18710b);
    }
}
