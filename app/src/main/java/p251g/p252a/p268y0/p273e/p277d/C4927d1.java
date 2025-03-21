package p251g.p252a.p268y0.p273e.p277d;

import java.util.Iterator;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p272d.AbstractC4621c;

/* compiled from: ObservableFromIterable.java */
/* renamed from: g.a.y0.e.d.d1 */
/* loaded from: classes2.dex */
public final class C4927d1<T> extends AbstractC4469b0<T> {

    /* renamed from: a */
    final Iterable<? extends T> f18890a;

    /* compiled from: ObservableFromIterable.java */
    /* renamed from: g.a.y0.e.d.d1$a */
    static final class a<T> extends AbstractC4621c<T> {

        /* renamed from: a */
        final InterfaceC4514i0<? super T> f18891a;

        /* renamed from: b */
        final Iterator<? extends T> f18892b;

        /* renamed from: c */
        volatile boolean f18893c;

        /* renamed from: d */
        boolean f18894d;

        /* renamed from: e */
        boolean f18895e;

        /* renamed from: f */
        boolean f18896f;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, Iterator<? extends T> it) {
            this.f18891a = interfaceC4514i0;
            this.f18892b = it;
        }

        /* renamed from: a */
        void m18439a() {
            while (!isDisposed()) {
                try {
                    this.f18891a.onNext(C4601b.m18284a((Object) this.f18892b.next(), "The iterator returned a null value"));
                    if (isDisposed()) {
                        return;
                    }
                    try {
                        if (!this.f18892b.hasNext()) {
                            if (isDisposed()) {
                                return;
                            }
                            this.f18891a.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        C4561b.m18199b(th);
                        this.f18891a.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    C4561b.m18199b(th2);
                    this.f18891a.onError(th2);
                    return;
                }
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public void clear() {
            this.f18895e = true;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18893c = true;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18893c;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public boolean isEmpty() {
            return this.f18895e;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public T poll() {
            if (this.f18895e) {
                return null;
            }
            if (!this.f18896f) {
                this.f18896f = true;
            } else if (!this.f18892b.hasNext()) {
                this.f18895e = true;
                return null;
            }
            return (T) C4601b.m18284a((Object) this.f18892b.next(), "The iterator returned a null value");
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public int requestFusion(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            this.f18894d = true;
            return 1;
        }
    }

    public C4927d1(Iterable<? extends T> iterable) {
        this.f18890a = iterable;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        try {
            Iterator<? extends T> it = this.f18890a.iterator();
            try {
                if (!it.hasNext()) {
                    EnumC4593e.complete(interfaceC4514i0);
                    return;
                }
                a aVar = new a(interfaceC4514i0, it);
                interfaceC4514i0.onSubscribe(aVar);
                if (aVar.f18894d) {
                    return;
                }
                aVar.m18439a();
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
