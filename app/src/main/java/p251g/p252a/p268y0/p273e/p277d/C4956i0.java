package p251g.p252a.p268y0.p273e.p277d;

import java.util.Collection;
import java.util.concurrent.Callable;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p272d.AbstractC4617a;

/* compiled from: ObservableDistinct.java */
/* renamed from: g.a.y0.e.d.i0 */
/* loaded from: classes2.dex */
public final class C4956i0<T, K> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final InterfaceC4584o<? super T, K> f19053b;

    /* renamed from: c */
    final Callable<? extends Collection<? super K>> f19054c;

    /* compiled from: ObservableDistinct.java */
    /* renamed from: g.a.y0.e.d.i0$a */
    static final class a<T, K> extends AbstractC4617a<T, T> {

        /* renamed from: f */
        final Collection<? super K> f19055f;

        /* renamed from: g */
        final InterfaceC4584o<? super T, K> f19056g;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, InterfaceC4584o<? super T, K> interfaceC4584o, Collection<? super K> collection) {
            super(interfaceC4514i0);
            this.f19056g = interfaceC4584o;
            this.f19055f = collection;
        }

        @Override // p251g.p252a.p268y0.p272d.AbstractC4617a, p251g.p252a.p268y0.p271c.InterfaceC4616o
        public void clear() {
            this.f19055f.clear();
            super.clear();
        }

        @Override // p251g.p252a.p268y0.p272d.AbstractC4617a, p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f17564d) {
                return;
            }
            this.f17564d = true;
            this.f19055f.clear();
            this.f17561a.onComplete();
        }

        @Override // p251g.p252a.p268y0.p272d.AbstractC4617a, p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.f17564d) {
                C4476a.m17152b(th);
                return;
            }
            this.f17564d = true;
            this.f19055f.clear();
            this.f17561a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.f17564d) {
                return;
            }
            if (this.f17565e != 0) {
                this.f17561a.onNext(null);
                return;
            }
            try {
                if (this.f19055f.add(C4601b.m18284a(this.f19056g.apply(t), "The keySelector returned a null key"))) {
                    this.f17561a.onNext(t);
                }
            } catch (Throwable th) {
                m18291a(th);
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public T poll() throws Exception {
            T poll;
            do {
                poll = this.f17563c.poll();
                if (poll == null) {
                    break;
                }
            } while (!this.f19055f.add((Object) C4601b.m18284a(this.f19056g.apply(poll), "The keySelector returned a null key")));
            return poll;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public int requestFusion(int i2) {
            return m18289a(i2);
        }
    }

    public C4956i0(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4584o<? super T, K> interfaceC4584o, Callable<? extends Collection<? super K>> callable) {
        super(interfaceC4504g0);
        this.f19053b = interfaceC4584o;
        this.f19054c = callable;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        try {
            this.f18742a.subscribe(new a(interfaceC4514i0, this.f19053b, (Collection) C4601b.m18284a(this.f19054c.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            C4561b.m18199b(th);
            EnumC4593e.error(th, interfaceC4514i0);
        }
    }
}
