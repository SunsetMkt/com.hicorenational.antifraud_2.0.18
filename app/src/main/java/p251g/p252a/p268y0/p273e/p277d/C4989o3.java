package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4587r;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: ObservableTakeWhile.java */
/* renamed from: g.a.y0.e.d.o3 */
/* loaded from: classes2.dex */
public final class C4989o3<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final InterfaceC4587r<? super T> f19251b;

    /* compiled from: ObservableTakeWhile.java */
    /* renamed from: g.a.y0.e.d.o3$a */
    static final class a<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4514i0<? super T> f19252a;

        /* renamed from: b */
        final InterfaceC4587r<? super T> f19253b;

        /* renamed from: c */
        InterfaceC4552c f19254c;

        /* renamed from: d */
        boolean f19255d;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, InterfaceC4587r<? super T> interfaceC4587r) {
            this.f19252a = interfaceC4514i0;
            this.f19253b = interfaceC4587r;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19254c.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19254c.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f19255d) {
                return;
            }
            this.f19255d = true;
            this.f19252a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.f19255d) {
                C4476a.m17152b(th);
            } else {
                this.f19255d = true;
                this.f19252a.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.f19255d) {
                return;
            }
            try {
                if (this.f19253b.test(t)) {
                    this.f19252a.onNext(t);
                    return;
                }
                this.f19255d = true;
                this.f19254c.dispose();
                this.f19252a.onComplete();
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f19254c.dispose();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19254c, interfaceC4552c)) {
                this.f19254c = interfaceC4552c;
                this.f19252a.onSubscribe(this);
            }
        }
    }

    public C4989o3(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4587r<? super T> interfaceC4587r) {
        super(interfaceC4504g0);
        this.f19251b = interfaceC4587r;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0, this.f19251b));
    }
}
