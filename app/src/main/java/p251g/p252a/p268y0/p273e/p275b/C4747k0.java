package p251g.p252a.p268y0.p273e.p275b;

import java.util.Collection;
import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p282h.AbstractC5131b;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p324i.p338d.InterfaceC5822c;

/* compiled from: FlowableDistinct.java */
/* renamed from: g.a.y0.e.b.k0 */
/* loaded from: classes2.dex */
public final class C4747k0<T, K> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final InterfaceC4584o<? super T, K> f17991c;

    /* renamed from: d */
    final Callable<? extends Collection<? super K>> f17992d;

    /* compiled from: FlowableDistinct.java */
    /* renamed from: g.a.y0.e.b.k0$a */
    static final class a<T, K> extends AbstractC5131b<T, T> {

        /* renamed from: f */
        final Collection<? super K> f17993f;

        /* renamed from: g */
        final InterfaceC4584o<? super T, K> f17994g;

        a(InterfaceC5822c<? super T> interfaceC5822c, InterfaceC4584o<? super T, K> interfaceC4584o, Collection<? super K> collection) {
            super(interfaceC5822c);
            this.f17994g = interfaceC4584o;
            this.f17993f = collection;
        }

        @Override // p251g.p252a.p268y0.p282h.AbstractC5131b, p251g.p252a.p268y0.p271c.InterfaceC4616o
        public void clear() {
            this.f17993f.clear();
            super.clear();
        }

        @Override // p251g.p252a.p268y0.p282h.AbstractC5131b, p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f19956d) {
                return;
            }
            this.f19956d = true;
            this.f17993f.clear();
            this.f19953a.onComplete();
        }

        @Override // p251g.p252a.p268y0.p282h.AbstractC5131b, p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f19956d) {
                C4476a.m17152b(th);
                return;
            }
            this.f19956d = true;
            this.f17993f.clear();
            this.f19953a.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.f19956d) {
                return;
            }
            if (this.f19957e != 0) {
                this.f19953a.onNext(null);
                return;
            }
            try {
                if (this.f17993f.add(C4601b.m18284a(this.f17994g.apply(t), "The keySelector returned a null key"))) {
                    this.f19953a.onNext(t);
                } else {
                    this.f19954b.request(1L);
                }
            } catch (Throwable th) {
                m18587a(th);
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public T poll() throws Exception {
            T poll;
            while (true) {
                poll = this.f19955c.poll();
                if (poll == null || this.f17993f.add((Object) C4601b.m18284a(this.f17994g.apply(poll), "The keySelector returned a null key"))) {
                    break;
                }
                if (this.f19957e == 2) {
                    this.f19954b.request(1L);
                }
            }
            return poll;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public int requestFusion(int i2) {
            return m18585a(i2);
        }
    }

    public C4747k0(AbstractC4519l<T> abstractC4519l, InterfaceC4584o<? super T, K> interfaceC4584o, Callable<? extends Collection<? super K>> callable) {
        super(abstractC4519l);
        this.f17991c = interfaceC4584o;
        this.f17992d = callable;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        try {
            this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c, this.f17991c, (Collection) C4601b.m18284a(this.f17992d.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            C4561b.m18199b(th);
            EnumC5157g.error(th, interfaceC5822c);
        }
    }
}
