package p251g.p252a.p268y0.p273e.p277d;

import java.util.Iterator;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4572c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: ObservableZipIterable.java */
/* renamed from: g.a.y0.e.d.g4 */
/* loaded from: classes2.dex */
public final class C4948g4<T, U, V> extends AbstractC4469b0<V> {

    /* renamed from: a */
    final AbstractC4469b0<? extends T> f19020a;

    /* renamed from: b */
    final Iterable<U> f19021b;

    /* renamed from: c */
    final InterfaceC4572c<? super T, ? super U, ? extends V> f19022c;

    /* compiled from: ObservableZipIterable.java */
    /* renamed from: g.a.y0.e.d.g4$a */
    static final class a<T, U, V> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4514i0<? super V> f19023a;

        /* renamed from: b */
        final Iterator<U> f19024b;

        /* renamed from: c */
        final InterfaceC4572c<? super T, ? super U, ? extends V> f19025c;

        /* renamed from: d */
        InterfaceC4552c f19026d;

        /* renamed from: e */
        boolean f19027e;

        a(InterfaceC4514i0<? super V> interfaceC4514i0, Iterator<U> it, InterfaceC4572c<? super T, ? super U, ? extends V> interfaceC4572c) {
            this.f19023a = interfaceC4514i0;
            this.f19024b = it;
            this.f19025c = interfaceC4572c;
        }

        /* renamed from: a */
        void m18448a(Throwable th) {
            this.f19027e = true;
            this.f19026d.dispose();
            this.f19023a.onError(th);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19026d.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19026d.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f19027e) {
                return;
            }
            this.f19027e = true;
            this.f19023a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.f19027e) {
                C4476a.m17152b(th);
            } else {
                this.f19027e = true;
                this.f19023a.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.f19027e) {
                return;
            }
            try {
                try {
                    this.f19023a.onNext(C4601b.m18284a(this.f19025c.apply(t, C4601b.m18284a(this.f19024b.next(), "The iterator returned a null value")), "The zipper function returned a null value"));
                    try {
                        if (this.f19024b.hasNext()) {
                            return;
                        }
                        this.f19027e = true;
                        this.f19026d.dispose();
                        this.f19023a.onComplete();
                    } catch (Throwable th) {
                        C4561b.m18199b(th);
                        m18448a(th);
                    }
                } catch (Throwable th2) {
                    C4561b.m18199b(th2);
                    m18448a(th2);
                }
            } catch (Throwable th3) {
                C4561b.m18199b(th3);
                m18448a(th3);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19026d, interfaceC4552c)) {
                this.f19026d = interfaceC4552c;
                this.f19023a.onSubscribe(this);
            }
        }
    }

    public C4948g4(AbstractC4469b0<? extends T> abstractC4469b0, Iterable<U> iterable, InterfaceC4572c<? super T, ? super U, ? extends V> interfaceC4572c) {
        this.f19020a = abstractC4469b0;
        this.f19021b = iterable;
        this.f19022c = interfaceC4572c;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super V> interfaceC4514i0) {
        try {
            Iterator it = (Iterator) C4601b.m18284a(this.f19021b.iterator(), "The iterator returned by other is null");
            try {
                if (it.hasNext()) {
                    this.f19020a.subscribe(new a(interfaceC4514i0, it, this.f19022c));
                } else {
                    EnumC4593e.complete(interfaceC4514i0);
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                EnumC4593e.error(th, interfaceC4514i0);
            }
        } catch (Throwable th2) {
            C4561b.m18199b(th2);
            EnumC4593e.error(th2, interfaceC4514i0);
        }
    }
}
