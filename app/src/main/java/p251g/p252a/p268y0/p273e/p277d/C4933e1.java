package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5823d;

/* compiled from: ObservableFromPublisher.java */
/* renamed from: g.a.y0.e.d.e1 */
/* loaded from: classes2.dex */
public final class C4933e1<T> extends AbstractC4469b0<T> {

    /* renamed from: a */
    final InterfaceC5821b<? extends T> f18940a;

    /* compiled from: ObservableFromPublisher.java */
    /* renamed from: g.a.y0.e.d.e1$a */
    static final class a<T> implements InterfaceC4529q<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4514i0<? super T> f18941a;

        /* renamed from: b */
        InterfaceC5823d f18942b;

        a(InterfaceC4514i0<? super T> interfaceC4514i0) {
            this.f18941a = interfaceC4514i0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18942b.cancel();
            this.f18942b = EnumC5160j.CANCELLED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18942b == EnumC5160j.CANCELLED;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.f18941a.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.f18941a.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            this.f18941a.onNext(t);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18942b, interfaceC5823d)) {
                this.f18942b = interfaceC5823d;
                this.f18941a.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    public C4933e1(InterfaceC5821b<? extends T> interfaceC5821b) {
        this.f18940a = interfaceC5821b;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f18940a.subscribe(new a(interfaceC4514i0));
    }
}
