package p251g.p252a.p268y0.p273e.p277d;

import java.util.NoSuchElementException;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: ObservableSingleSingle.java */
/* renamed from: g.a.y0.e.d.z2 */
/* loaded from: classes2.dex */
public final class C5043z2<T> extends AbstractC4518k0<T> {

    /* renamed from: a */
    final InterfaceC4504g0<? extends T> f19542a;

    /* renamed from: b */
    final T f19543b;

    /* compiled from: ObservableSingleSingle.java */
    /* renamed from: g.a.y0.e.d.z2$a */
    static final class a<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4524n0<? super T> f19544a;

        /* renamed from: b */
        final T f19545b;

        /* renamed from: c */
        InterfaceC4552c f19546c;

        /* renamed from: d */
        T f19547d;

        /* renamed from: e */
        boolean f19548e;

        a(InterfaceC4524n0<? super T> interfaceC4524n0, T t) {
            this.f19544a = interfaceC4524n0;
            this.f19545b = t;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19546c.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19546c.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f19548e) {
                return;
            }
            this.f19548e = true;
            T t = this.f19547d;
            this.f19547d = null;
            if (t == null) {
                t = this.f19545b;
            }
            if (t != null) {
                this.f19544a.onSuccess(t);
            } else {
                this.f19544a.onError(new NoSuchElementException());
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.f19548e) {
                C4476a.m17152b(th);
            } else {
                this.f19548e = true;
                this.f19544a.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.f19548e) {
                return;
            }
            if (this.f19547d == null) {
                this.f19547d = t;
                return;
            }
            this.f19548e = true;
            this.f19546c.dispose();
            this.f19544a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19546c, interfaceC4552c)) {
                this.f19546c = interfaceC4552c;
                this.f19544a.onSubscribe(this);
            }
        }
    }

    public C5043z2(InterfaceC4504g0<? extends T> interfaceC4504g0, T t) {
        this.f19542a = interfaceC4504g0;
        this.f19543b = t;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    public void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        this.f19542a.subscribe(new a(interfaceC4524n0, this.f19543b));
    }
}
