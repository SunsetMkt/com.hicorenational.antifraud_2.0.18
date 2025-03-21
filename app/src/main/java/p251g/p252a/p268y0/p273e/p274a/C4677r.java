package p251g.p252a.p268y0.p273e.p274a;

import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;

/* compiled from: CompletableFromObservable.java */
/* renamed from: g.a.y0.e.a.r */
/* loaded from: classes2.dex */
public final class C4677r<T> extends AbstractC4474c {

    /* renamed from: a */
    final InterfaceC4504g0<T> f17740a;

    /* compiled from: CompletableFromObservable.java */
    /* renamed from: g.a.y0.e.a.r$a */
    static final class a<T> implements InterfaceC4514i0<T> {

        /* renamed from: a */
        final InterfaceC4491f f17741a;

        a(InterfaceC4491f interfaceC4491f) {
            this.f17741a = interfaceC4491f;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.f17741a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f17741a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f17741a.onSubscribe(interfaceC4552c);
        }
    }

    public C4677r(InterfaceC4504g0<T> interfaceC4504g0) {
        this.f17740a = interfaceC4504g0;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    protected void mo17086b(InterfaceC4491f interfaceC4491f) {
        this.f17740a.subscribe(new a(interfaceC4491f));
    }
}
