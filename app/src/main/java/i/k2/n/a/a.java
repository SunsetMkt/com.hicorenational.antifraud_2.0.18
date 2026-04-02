package i.k2.n.a;

import i.q0;
import i.q2.t.i0;
import i.r0;
import i.t0;
import i.y1;
import java.io.Serializable;

/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@t0(version = "1.3")
public abstract class a implements i.k2.d<Object>, e, Serializable {

    @j.c.a.e
    private final i.k2.d<Object> completion;

    public a(@j.c.a.e i.k2.d<Object> dVar) {
        this.completion = dVar;
    }

    @j.c.a.d
    public i.k2.d<y1> create(@j.c.a.d i.k2.d<?> dVar) {
        i0.f(dVar, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // i.k2.n.a.e
    @j.c.a.e
    public e getCallerFrame() {
        i.k2.d<Object> dVar = this.completion;
        if (!(dVar instanceof e)) {
            dVar = null;
        }
        return (e) dVar;
    }

    @j.c.a.e
    public final i.k2.d<Object> getCompletion() {
        return this.completion;
    }

    @Override // i.k2.n.a.e
    @j.c.a.e
    public StackTraceElement getStackTraceElement() {
        return g.d(this);
    }

    @j.c.a.e
    protected abstract Object invokeSuspend(@j.c.a.d Object obj);

    protected void releaseIntercepted() {
    }

    @Override // i.k2.d
    public final void resumeWith(@j.c.a.d Object obj) {
        Object objInvokeSuspend;
        Object objM772constructorimpl = obj;
        a aVar = this;
        while (true) {
            h.b(aVar);
            i.k2.d<Object> dVar = aVar.completion;
            if (dVar == null) {
                i0.f();
            }
            try {
                objInvokeSuspend = aVar.invokeSuspend(objM772constructorimpl);
            } catch (Throwable th) {
                q0.a aVar2 = q0.Companion;
                objM772constructorimpl = q0.m772constructorimpl(r0.a(th));
            }
            if (objInvokeSuspend == i.k2.m.d.b()) {
                return;
            }
            q0.a aVar3 = q0.Companion;
            objM772constructorimpl = q0.m772constructorimpl(objInvokeSuspend);
            aVar.releaseIntercepted();
            if (!(dVar instanceof a)) {
                dVar.resumeWith(objM772constructorimpl);
                return;
            }
            aVar = (a) dVar;
        }
    }

    @j.c.a.d
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

    @j.c.a.d
    public i.k2.d<y1> create(@j.c.a.e Object obj, @j.c.a.d i.k2.d<?> dVar) {
        i0.f(dVar, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
