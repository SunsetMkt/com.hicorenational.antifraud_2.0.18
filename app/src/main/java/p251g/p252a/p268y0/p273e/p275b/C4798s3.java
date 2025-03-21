package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p268y0.p283i.C5159i;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableSwitchIfEmpty.java */
/* renamed from: g.a.y0.e.b.s3 */
/* loaded from: classes2.dex */
public final class C4798s3<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final InterfaceC5821b<? extends T> f18394c;

    /* compiled from: FlowableSwitchIfEmpty.java */
    /* renamed from: g.a.y0.e.b.s3$a */
    static final class a<T> implements InterfaceC4529q<T> {

        /* renamed from: a */
        final InterfaceC5822c<? super T> f18395a;

        /* renamed from: b */
        final InterfaceC5821b<? extends T> f18396b;

        /* renamed from: d */
        boolean f18398d = true;

        /* renamed from: c */
        final C5159i f18397c = new C5159i();

        a(InterfaceC5822c<? super T> interfaceC5822c, InterfaceC5821b<? extends T> interfaceC5821b) {
            this.f18395a = interfaceC5822c;
            this.f18396b = interfaceC5821b;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (!this.f18398d) {
                this.f18395a.onComplete();
            } else {
                this.f18398d = false;
                this.f18396b.subscribe(this);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.f18395a.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.f18398d) {
                this.f18398d = false;
            }
            this.f18395a.onNext(t);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            this.f18397c.setSubscription(interfaceC5823d);
        }
    }

    public C4798s3(AbstractC4519l<T> abstractC4519l, InterfaceC5821b<? extends T> interfaceC5821b) {
        super(abstractC4519l);
        this.f18394c = interfaceC5821b;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        a aVar = new a(interfaceC5822c, this.f18394c);
        interfaceC5822c.onSubscribe(aVar.f18397c);
        this.f17759b.m17799a((InterfaceC4529q) aVar);
    }
}
