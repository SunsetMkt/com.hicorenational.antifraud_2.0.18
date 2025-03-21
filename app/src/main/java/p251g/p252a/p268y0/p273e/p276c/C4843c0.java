package p251g.p252a.p268y0.p273e.p276c;

import java.util.Iterator;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p272d.AbstractC4621c;

/* compiled from: MaybeFlatMapIterableObservable.java */
/* renamed from: g.a.y0.e.c.c0 */
/* loaded from: classes2.dex */
public final class C4843c0<T, R> extends AbstractC4469b0<R> {

    /* renamed from: a */
    final InterfaceC4588y<T> f18576a;

    /* renamed from: b */
    final InterfaceC4584o<? super T, ? extends Iterable<? extends R>> f18577b;

    /* compiled from: MaybeFlatMapIterableObservable.java */
    /* renamed from: g.a.y0.e.c.c0$a */
    static final class a<T, R> extends AbstractC4621c<R> implements InterfaceC4559v<T> {

        /* renamed from: a */
        final InterfaceC4514i0<? super R> f18578a;

        /* renamed from: b */
        final InterfaceC4584o<? super T, ? extends Iterable<? extends R>> f18579b;

        /* renamed from: c */
        InterfaceC4552c f18580c;

        /* renamed from: d */
        volatile Iterator<? extends R> f18581d;

        /* renamed from: e */
        volatile boolean f18582e;

        /* renamed from: f */
        boolean f18583f;

        a(InterfaceC4514i0<? super R> interfaceC4514i0, InterfaceC4584o<? super T, ? extends Iterable<? extends R>> interfaceC4584o) {
            this.f18578a = interfaceC4514i0;
            this.f18579b = interfaceC4584o;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public void clear() {
            this.f18581d = null;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18582e = true;
            this.f18580c.dispose();
            this.f18580c = EnumC4592d.DISPOSED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18582e;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public boolean isEmpty() {
            return this.f18581d == null;
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            this.f18578a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            this.f18580c = EnumC4592d.DISPOSED;
            this.f18578a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18580c, interfaceC4552c)) {
                this.f18580c = interfaceC4552c;
                this.f18578a.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            InterfaceC4514i0<? super R> interfaceC4514i0 = this.f18578a;
            try {
                Iterator<? extends R> it = this.f18579b.apply(t).iterator();
                if (!it.hasNext()) {
                    interfaceC4514i0.onComplete();
                    return;
                }
                this.f18581d = it;
                if (this.f18583f) {
                    interfaceC4514i0.onNext(null);
                    interfaceC4514i0.onComplete();
                    return;
                }
                while (!this.f18582e) {
                    try {
                        interfaceC4514i0.onNext(it.next());
                        if (this.f18582e) {
                            return;
                        }
                        try {
                            if (!it.hasNext()) {
                                interfaceC4514i0.onComplete();
                                return;
                            }
                        } catch (Throwable th) {
                            C4561b.m18199b(th);
                            interfaceC4514i0.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        C4561b.m18199b(th2);
                        interfaceC4514i0.onError(th2);
                        return;
                    }
                }
            } catch (Throwable th3) {
                C4561b.m18199b(th3);
                interfaceC4514i0.onError(th3);
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public R poll() throws Exception {
            Iterator<? extends R> it = this.f18581d;
            if (it == null) {
                return null;
            }
            R r = (R) C4601b.m18284a(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f18581d = null;
            }
            return r;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.f18583f = true;
            return 2;
        }
    }

    public C4843c0(InterfaceC4588y<T> interfaceC4588y, InterfaceC4584o<? super T, ? extends Iterable<? extends R>> interfaceC4584o) {
        this.f18576a = interfaceC4588y;
        this.f18577b = interfaceC4584o;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super R> interfaceC4514i0) {
        this.f18576a.mo18100a(new a(interfaceC4514i0, this.f18577b));
    }
}
