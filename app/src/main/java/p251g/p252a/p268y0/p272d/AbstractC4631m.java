package p251g.p252a.p268y0.p272d;

import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: DeferredScalarObserver.java */
/* renamed from: g.a.y0.d.m */
/* loaded from: classes2.dex */
public abstract class AbstractC4631m<T, R> extends C4630l<R> implements InterfaceC4514i0<T> {
    private static final long serialVersionUID = -266195175408988651L;

    /* renamed from: s */
    protected InterfaceC4552c f17578s;

    public AbstractC4631m(InterfaceC4514i0<? super R> interfaceC4514i0) {
        super(interfaceC4514i0);
    }

    @Override // p251g.p252a.p268y0.p272d.C4630l, p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
        super.dispose();
        this.f17578s.dispose();
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onComplete() {
        T t = this.value;
        if (t == null) {
            complete();
        } else {
            this.value = null;
            complete(t);
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onError(Throwable th) {
        this.value = null;
        error(th);
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onSubscribe(InterfaceC4552c interfaceC4552c) {
        if (EnumC4592d.validate(this.f17578s, interfaceC4552c)) {
            this.f17578s = interfaceC4552c;
            this.actual.onSubscribe(this);
        }
    }
}
