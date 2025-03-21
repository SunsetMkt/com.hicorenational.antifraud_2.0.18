package p251g.p252a.p268y0.p273e.p275b;

import java.util.Iterator;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4572c;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableZipIterable.java */
/* renamed from: g.a.y0.e.b.t4 */
/* loaded from: classes2.dex */
public final class C4805t4<T, U, V> extends AbstractC4686a<T, V> {

    /* renamed from: c */
    final Iterable<U> f18427c;

    /* renamed from: d */
    final InterfaceC4572c<? super T, ? super U, ? extends V> f18428d;

    /* compiled from: FlowableZipIterable.java */
    /* renamed from: g.a.y0.e.b.t4$a */
    static final class a<T, U, V> implements InterfaceC4529q<T>, InterfaceC5823d {

        /* renamed from: a */
        final InterfaceC5822c<? super V> f18429a;

        /* renamed from: b */
        final Iterator<U> f18430b;

        /* renamed from: c */
        final InterfaceC4572c<? super T, ? super U, ? extends V> f18431c;

        /* renamed from: d */
        InterfaceC5823d f18432d;

        /* renamed from: e */
        boolean f18433e;

        a(InterfaceC5822c<? super V> interfaceC5822c, Iterator<U> it, InterfaceC4572c<? super T, ? super U, ? extends V> interfaceC4572c) {
            this.f18429a = interfaceC5822c;
            this.f18430b = it;
            this.f18431c = interfaceC4572c;
        }

        /* renamed from: a */
        void m18396a(Throwable th) {
            C4561b.m18199b(th);
            this.f18433e = true;
            this.f18432d.cancel();
            this.f18429a.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.f18432d.cancel();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f18433e) {
                return;
            }
            this.f18433e = true;
            this.f18429a.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f18433e) {
                C4476a.m17152b(th);
            } else {
                this.f18433e = true;
                this.f18429a.onError(th);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.f18433e) {
                return;
            }
            try {
                try {
                    this.f18429a.onNext(C4601b.m18284a(this.f18431c.apply(t, C4601b.m18284a(this.f18430b.next(), "The iterator returned a null value")), "The zipper function returned a null value"));
                    try {
                        if (this.f18430b.hasNext()) {
                            return;
                        }
                        this.f18433e = true;
                        this.f18432d.cancel();
                        this.f18429a.onComplete();
                    } catch (Throwable th) {
                        m18396a(th);
                    }
                } catch (Throwable th2) {
                    m18396a(th2);
                }
            } catch (Throwable th3) {
                m18396a(th3);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18432d, interfaceC5823d)) {
                this.f18432d = interfaceC5823d;
                this.f18429a.onSubscribe(this);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            this.f18432d.request(j2);
        }
    }

    public C4805t4(AbstractC4519l<T> abstractC4519l, Iterable<U> iterable, InterfaceC4572c<? super T, ? super U, ? extends V> interfaceC4572c) {
        super(abstractC4519l);
        this.f18427c = iterable;
        this.f18428d = interfaceC4572c;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super V> interfaceC5822c) {
        try {
            Iterator it = (Iterator) C4601b.m18284a(this.f18427c.iterator(), "The iterator returned by other is null");
            try {
                if (it.hasNext()) {
                    this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c, it, this.f18428d));
                } else {
                    EnumC5157g.complete(interfaceC5822c);
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                EnumC5157g.error(th, interfaceC5822c);
            }
        } catch (Throwable th2) {
            C4561b.m18199b(th2);
            EnumC5157g.error(th2, interfaceC5822c);
        }
    }
}
