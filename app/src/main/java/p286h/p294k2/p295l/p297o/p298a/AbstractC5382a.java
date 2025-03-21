package p286h.p294k2.p295l.p297o.p298a;

import p286h.C5226e1;
import p286h.C5715y1;
import p286h.p294k2.p295l.InterfaceC5368c;
import p286h.p294k2.p295l.InterfaceC5370e;
import p286h.p294k2.p295l.p296n.C5380b;
import p286h.p309q2.InterfaceC5479c;
import p286h.p309q2.p311t.AbstractC5547j0;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: CoroutineImpl.kt */
/* renamed from: h.k2.l.o.a.a */
/* loaded from: classes2.dex */
public abstract class AbstractC5382a extends AbstractC5547j0<Object> implements InterfaceC5368c<Object> {
    private final InterfaceC5370e _context;
    private InterfaceC5368c<Object> _facade;

    @InterfaceC5479c
    @InterfaceC5817e
    protected InterfaceC5368c<Object> completion;

    @InterfaceC5479c
    protected int label;

    public AbstractC5382a(int i2, @InterfaceC5817e InterfaceC5368c<Object> interfaceC5368c) {
        super(i2);
        this.completion = interfaceC5368c;
        this.label = this.completion != null ? 0 : -1;
        InterfaceC5368c<Object> interfaceC5368c2 = this.completion;
        this._context = interfaceC5368c2 != null ? interfaceC5368c2.getContext() : null;
    }

    @InterfaceC5816d
    public InterfaceC5368c<C5715y1> create(@InterfaceC5816d InterfaceC5368c<?> interfaceC5368c) {
        C5544i0.m22546f(interfaceC5368c, "completion");
        throw new IllegalStateException("create(Continuation) has not been overridden");
    }

    @InterfaceC5817e
    protected abstract Object doResume(@InterfaceC5817e Object obj, @InterfaceC5817e Throwable th);

    @Override // p286h.p294k2.p295l.InterfaceC5368c
    @InterfaceC5816d
    public InterfaceC5370e getContext() {
        InterfaceC5370e interfaceC5370e = this._context;
        if (interfaceC5370e == null) {
            C5544i0.m22545f();
        }
        return interfaceC5370e;
    }

    @InterfaceC5816d
    public final InterfaceC5368c<Object> getFacade() {
        if (this._facade == null) {
            InterfaceC5370e interfaceC5370e = this._context;
            if (interfaceC5370e == null) {
                C5544i0.m22545f();
            }
            this._facade = C5383b.m22084a(interfaceC5370e, this);
        }
        InterfaceC5368c<Object> interfaceC5368c = this._facade;
        if (interfaceC5368c == null) {
            C5544i0.m22545f();
        }
        return interfaceC5368c;
    }

    @Override // p286h.p294k2.p295l.InterfaceC5368c
    public void resume(@InterfaceC5817e Object obj) {
        Object m22074b;
        InterfaceC5368c<Object> interfaceC5368c = this.completion;
        if (interfaceC5368c == null) {
            C5544i0.m22545f();
        }
        try {
            Object doResume = doResume(obj, null);
            m22074b = C5380b.m22074b();
            if (doResume != m22074b) {
                if (interfaceC5368c == null) {
                    throw new C5226e1("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
                }
                interfaceC5368c.resume(doResume);
            }
        } catch (Throwable th) {
            interfaceC5368c.resumeWithException(th);
        }
    }

    @Override // p286h.p294k2.p295l.InterfaceC5368c
    public void resumeWithException(@InterfaceC5816d Throwable th) {
        Object m22074b;
        C5544i0.m22546f(th, "exception");
        InterfaceC5368c<Object> interfaceC5368c = this.completion;
        if (interfaceC5368c == null) {
            C5544i0.m22545f();
        }
        try {
            Object doResume = doResume(null, th);
            m22074b = C5380b.m22074b();
            if (doResume != m22074b) {
                if (interfaceC5368c == null) {
                    throw new C5226e1("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
                }
                interfaceC5368c.resume(doResume);
            }
        } catch (Throwable th2) {
            interfaceC5368c.resumeWithException(th2);
        }
    }

    @InterfaceC5816d
    public InterfaceC5368c<C5715y1> create(@InterfaceC5817e Object obj, @InterfaceC5816d InterfaceC5368c<?> interfaceC5368c) {
        C5544i0.m22546f(interfaceC5368c, "completion");
        throw new IllegalStateException("create(Any?;Continuation) has not been overridden");
    }
}
