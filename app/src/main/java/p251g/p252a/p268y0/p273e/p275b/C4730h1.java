package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4469b0;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableFromObservable.java */
/* renamed from: g.a.y0.e.b.h1 */
/* loaded from: classes2.dex */
public final class C4730h1<T> extends AbstractC4519l<T> {

    /* renamed from: b */
    private final AbstractC4469b0<T> f17939b;

    /* compiled from: FlowableFromObservable.java */
    /* renamed from: g.a.y0.e.b.h1$a */
    static class a<T> implements InterfaceC4514i0<T>, InterfaceC5823d {

        /* renamed from: a */
        private final InterfaceC5822c<? super T> f17940a;

        /* renamed from: b */
        private InterfaceC4552c f17941b;

        a(InterfaceC5822c<? super T> interfaceC5822c) {
            this.f17940a = interfaceC5822c;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.f17941b.dispose();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.f17940a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f17940a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            this.f17940a.onNext(t);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f17941b = interfaceC4552c;
            this.f17940a.onSubscribe(this);
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
        }
    }

    public C4730h1(AbstractC4469b0<T> abstractC4469b0) {
        this.f17939b = abstractC4469b0;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17939b.subscribe(new a(interfaceC5822c));
    }
}
