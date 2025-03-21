package p251g.p252a.p268y0.p273e.p274a;

import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p264u0.InterfaceC4552c;

/* compiled from: CompletableFromSingle.java */
/* renamed from: g.a.y0.e.a.u */
/* loaded from: classes2.dex */
public final class C4680u<T> extends AbstractC4474c {

    /* renamed from: a */
    final InterfaceC4530q0<T> f17746a;

    /* compiled from: CompletableFromSingle.java */
    /* renamed from: g.a.y0.e.a.u$a */
    static final class a<T> implements InterfaceC4524n0<T> {

        /* renamed from: a */
        final InterfaceC4491f f17747a;

        a(InterfaceC4491f interfaceC4491f) {
            this.f17747a = interfaceC4491f;
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onError(Throwable th) {
            this.f17747a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f17747a.onSubscribe(interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.f17747a.onComplete();
        }
    }

    public C4680u(InterfaceC4530q0<T> interfaceC4530q0) {
        this.f17746a = interfaceC4530q0;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    protected void mo17086b(InterfaceC4491f interfaceC4491f) {
        this.f17746a.mo17490a(new a(interfaceC4491f));
    }
}
