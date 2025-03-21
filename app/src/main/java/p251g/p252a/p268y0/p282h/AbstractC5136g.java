package p251g.p252a.p268y0.p282h;

import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p268y0.p283i.C5156f;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: DeferredScalarSubscriber.java */
/* renamed from: g.a.y0.h.g */
/* loaded from: classes2.dex */
public abstract class AbstractC5136g<T, R> extends C5156f<R> implements InterfaceC4529q<T> {
    private static final long serialVersionUID = 2984505488220891551L;
    protected boolean hasValue;

    /* renamed from: s */
    protected InterfaceC5823d f19962s;

    public AbstractC5136g(InterfaceC5822c<? super R> interfaceC5822c) {
        super(interfaceC5822c);
    }

    @Override // p251g.p252a.p268y0.p283i.C5156f, p324i.p338d.InterfaceC5823d
    public void cancel() {
        super.cancel();
        this.f19962s.cancel();
    }

    public void onComplete() {
        if (this.hasValue) {
            complete(this.value);
        } else {
            this.actual.onComplete();
        }
    }

    public void onError(Throwable th) {
        this.value = null;
        this.actual.onError(th);
    }

    public void onSubscribe(InterfaceC5823d interfaceC5823d) {
        if (EnumC5160j.validate(this.f19962s, interfaceC5823d)) {
            this.f19962s = interfaceC5823d;
            this.actual.onSubscribe(this);
            interfaceC5823d.request(C5556m0.f20396b);
        }
    }
}
