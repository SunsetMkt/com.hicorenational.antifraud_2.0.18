package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p283i.C5159i;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableOnErrorNext.java */
/* renamed from: g.a.y0.e.b.j2 */
/* loaded from: classes2.dex */
public final class C4743j2<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final InterfaceC4584o<? super Throwable, ? extends InterfaceC5821b<? extends T>> f17974c;

    /* renamed from: d */
    final boolean f17975d;

    /* compiled from: FlowableOnErrorNext.java */
    /* renamed from: g.a.y0.e.b.j2$a */
    static final class a<T> implements InterfaceC4529q<T> {

        /* renamed from: a */
        final InterfaceC5822c<? super T> f17976a;

        /* renamed from: b */
        final InterfaceC4584o<? super Throwable, ? extends InterfaceC5821b<? extends T>> f17977b;

        /* renamed from: c */
        final boolean f17978c;

        /* renamed from: d */
        final C5159i f17979d = new C5159i();

        /* renamed from: e */
        boolean f17980e;

        /* renamed from: f */
        boolean f17981f;

        a(InterfaceC5822c<? super T> interfaceC5822c, InterfaceC4584o<? super Throwable, ? extends InterfaceC5821b<? extends T>> interfaceC4584o, boolean z) {
            this.f17976a = interfaceC5822c;
            this.f17977b = interfaceC4584o;
            this.f17978c = z;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.f17981f) {
                return;
            }
            this.f17981f = true;
            this.f17980e = true;
            this.f17976a.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.f17980e) {
                if (this.f17981f) {
                    C4476a.m17152b(th);
                    return;
                } else {
                    this.f17976a.onError(th);
                    return;
                }
            }
            this.f17980e = true;
            if (this.f17978c && !(th instanceof Exception)) {
                this.f17976a.onError(th);
                return;
            }
            try {
                InterfaceC5821b<? extends T> apply = this.f17977b.apply(th);
                if (apply != null) {
                    apply.subscribe(this);
                    return;
                }
                NullPointerException nullPointerException = new NullPointerException("Publisher is null");
                nullPointerException.initCause(th);
                this.f17976a.onError(nullPointerException);
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                this.f17976a.onError(new C4560a(th, th2));
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.f17981f) {
                return;
            }
            this.f17976a.onNext(t);
            if (this.f17980e) {
                return;
            }
            this.f17979d.produced(1L);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            this.f17979d.setSubscription(interfaceC5823d);
        }
    }

    public C4743j2(AbstractC4519l<T> abstractC4519l, InterfaceC4584o<? super Throwable, ? extends InterfaceC5821b<? extends T>> interfaceC4584o, boolean z) {
        super(abstractC4519l);
        this.f17974c = interfaceC4584o;
        this.f17975d = z;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        a aVar = new a(interfaceC5822c, this.f17974c, this.f17975d);
        interfaceC5822c.onSubscribe(aVar.f17979d);
        this.f17759b.m17799a((InterfaceC4529q) aVar);
    }
}
