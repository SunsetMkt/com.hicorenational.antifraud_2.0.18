package p286h.p294k2.p301n.p302a;

import java.io.Serializable;
import p286h.C5475q0;
import p286h.C5597r0;
import p286h.C5715y1;
import p286h.InterfaceC5610t0;
import p286h.p294k2.InterfaceC5358d;
import p286h.p294k2.p300m.C5397d;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: ContinuationImpl.kt */
@InterfaceC5610t0(version = "1.3")
/* renamed from: h.k2.n.a.a */
/* loaded from: classes2.dex */
public abstract class AbstractC5398a implements InterfaceC5358d<Object>, InterfaceC5402e, Serializable {

    @InterfaceC5817e
    private final InterfaceC5358d<Object> completion;

    public AbstractC5398a(@InterfaceC5817e InterfaceC5358d<Object> interfaceC5358d) {
        this.completion = interfaceC5358d;
    }

    @InterfaceC5816d
    public InterfaceC5358d<C5715y1> create(@InterfaceC5816d InterfaceC5358d<?> interfaceC5358d) {
        C5544i0.m22546f(interfaceC5358d, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // p286h.p294k2.p301n.p302a.InterfaceC5402e
    @InterfaceC5817e
    public InterfaceC5402e getCallerFrame() {
        InterfaceC5358d<Object> interfaceC5358d = this.completion;
        if (!(interfaceC5358d instanceof InterfaceC5402e)) {
            interfaceC5358d = null;
        }
        return (InterfaceC5402e) interfaceC5358d;
    }

    @InterfaceC5817e
    public final InterfaceC5358d<Object> getCompletion() {
        return this.completion;
    }

    @Override // p286h.p294k2.p301n.p302a.InterfaceC5402e
    @InterfaceC5817e
    public StackTraceElement getStackTraceElement() {
        return C5404g.m22139d(this);
    }

    @InterfaceC5817e
    protected abstract Object invokeSuspend(@InterfaceC5816d Object obj);

    protected void releaseIntercepted() {
    }

    @Override // p286h.p294k2.InterfaceC5358d
    public final void resumeWith(@InterfaceC5816d Object obj) {
        Object invokeSuspend;
        Object m22117b;
        Object obj2 = obj;
        AbstractC5398a abstractC5398a = this;
        while (true) {
            C5405h.m22141b(abstractC5398a);
            InterfaceC5358d<Object> interfaceC5358d = abstractC5398a.completion;
            if (interfaceC5358d == null) {
                C5544i0.m22545f();
            }
            try {
                invokeSuspend = abstractC5398a.invokeSuspend(obj2);
                m22117b = C5397d.m22117b();
            } catch (Throwable th) {
                C5475q0.a aVar = C5475q0.Companion;
                obj2 = C5475q0.m26855constructorimpl(C5597r0.m22715a(th));
            }
            if (invokeSuspend == m22117b) {
                return;
            }
            C5475q0.a aVar2 = C5475q0.Companion;
            obj2 = C5475q0.m26855constructorimpl(invokeSuspend);
            abstractC5398a.releaseIntercepted();
            if (!(interfaceC5358d instanceof AbstractC5398a)) {
                interfaceC5358d.resumeWith(obj2);
                return;
            }
            abstractC5398a = (AbstractC5398a) interfaceC5358d;
        }
    }

    @InterfaceC5816d
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    @InterfaceC5816d
    public InterfaceC5358d<C5715y1> create(@InterfaceC5817e Object obj, @InterfaceC5816d InterfaceC5358d<?> interfaceC5358d) {
        C5544i0.m22546f(interfaceC5358d, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
