package p251g.p252a.p268y0.p273e.p277d;

import java.util.Iterator;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: ObservableFlattenIterable.java */
/* renamed from: g.a.y0.e.d.z0 */
/* loaded from: classes2.dex */
public final class C5041z0<T, R> extends AbstractC4907a<T, R> {

    /* renamed from: b */
    final InterfaceC4584o<? super T, ? extends Iterable<? extends R>> f19530b;

    /* compiled from: ObservableFlattenIterable.java */
    /* renamed from: g.a.y0.e.d.z0$a */
    static final class a<T, R> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4514i0<? super R> f19531a;

        /* renamed from: b */
        final InterfaceC4584o<? super T, ? extends Iterable<? extends R>> f19532b;

        /* renamed from: c */
        InterfaceC4552c f19533c;

        a(InterfaceC4514i0<? super R> interfaceC4514i0, InterfaceC4584o<? super T, ? extends Iterable<? extends R>> interfaceC4584o) {
            this.f19531a = interfaceC4514i0;
            this.f19532b = interfaceC4584o;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19533c.dispose();
            this.f19533c = EnumC4592d.DISPOSED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19533c.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            InterfaceC4552c interfaceC4552c = this.f19533c;
            EnumC4592d enumC4592d = EnumC4592d.DISPOSED;
            if (interfaceC4552c == enumC4592d) {
                return;
            }
            this.f19533c = enumC4592d;
            this.f19531a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            InterfaceC4552c interfaceC4552c = this.f19533c;
            EnumC4592d enumC4592d = EnumC4592d.DISPOSED;
            if (interfaceC4552c == enumC4592d) {
                C4476a.m17152b(th);
            } else {
                this.f19533c = enumC4592d;
                this.f19531a.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.f19533c == EnumC4592d.DISPOSED) {
                return;
            }
            try {
                Iterator<? extends R> it = this.f19532b.apply(t).iterator();
                InterfaceC4514i0<? super R> interfaceC4514i0 = this.f19531a;
                while (it.hasNext()) {
                    try {
                        try {
                            interfaceC4514i0.onNext((Object) C4601b.m18284a(it.next(), "The iterator returned a null value"));
                        } catch (Throwable th) {
                            C4561b.m18199b(th);
                            this.f19533c.dispose();
                            onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        C4561b.m18199b(th2);
                        this.f19533c.dispose();
                        onError(th2);
                        return;
                    }
                }
            } catch (Throwable th3) {
                C4561b.m18199b(th3);
                this.f19533c.dispose();
                onError(th3);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19533c, interfaceC4552c)) {
                this.f19533c = interfaceC4552c;
                this.f19531a.onSubscribe(this);
            }
        }
    }

    public C5041z0(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4584o<? super T, ? extends Iterable<? extends R>> interfaceC4584o) {
        super(interfaceC4504g0);
        this.f19530b = interfaceC4584o;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super R> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0, this.f19530b));
    }
}
