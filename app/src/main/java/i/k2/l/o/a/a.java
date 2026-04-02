package i.k2.l.o.a;

import i.e1;
import i.k2.l.c;
import i.k2.l.e;
import i.q2.t.i0;
import i.q2.t.j0;
import i.y1;
import j.c.a.d;

/* JADX INFO: compiled from: CoroutineImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends j0<Object> implements c<Object> {
    private final e _context;
    private c<Object> _facade;

    @j.c.a.e
    @i.q2.c
    protected c<Object> completion;

    @i.q2.c
    protected int label;

    public a(int i2, @j.c.a.e c<Object> cVar) {
        super(i2);
        this.completion = cVar;
        this.label = this.completion != null ? 0 : -1;
        c<Object> cVar2 = this.completion;
        this._context = cVar2 != null ? cVar2.getContext() : null;
    }

    @d
    public c<y1> create(@d c<?> cVar) {
        i0.f(cVar, "completion");
        throw new IllegalStateException("create(Continuation) has not been overridden");
    }

    @j.c.a.e
    protected abstract Object doResume(@j.c.a.e Object obj, @j.c.a.e Throwable th);

    @Override // i.k2.l.c
    @d
    public e getContext() {
        e eVar = this._context;
        if (eVar == null) {
            i0.f();
        }
        return eVar;
    }

    @d
    public final c<Object> getFacade() {
        if (this._facade == null) {
            e eVar = this._context;
            if (eVar == null) {
                i0.f();
            }
            this._facade = b.a(eVar, this);
        }
        c<Object> cVar = this._facade;
        if (cVar == null) {
            i0.f();
        }
        return cVar;
    }

    @Override // i.k2.l.c
    public void resume(@j.c.a.e Object obj) {
        c<Object> cVar = this.completion;
        if (cVar == null) {
            i0.f();
        }
        try {
            Object objDoResume = doResume(obj, null);
            if (objDoResume != i.k2.l.n.b.b()) {
                if (cVar == null) {
                    throw new e1("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
                }
                cVar.resume(objDoResume);
            }
        } catch (Throwable th) {
            cVar.resumeWithException(th);
        }
    }

    @Override // i.k2.l.c
    public void resumeWithException(@d Throwable th) {
        i0.f(th, "exception");
        c<Object> cVar = this.completion;
        if (cVar == null) {
            i0.f();
        }
        try {
            Object objDoResume = doResume(null, th);
            if (objDoResume != i.k2.l.n.b.b()) {
                if (cVar == null) {
                    throw new e1("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
                }
                cVar.resume(objDoResume);
            }
        } catch (Throwable th2) {
            cVar.resumeWithException(th2);
        }
    }

    @d
    public c<y1> create(@j.c.a.e Object obj, @d c<?> cVar) {
        i0.f(cVar, "completion");
        throw new IllegalStateException("create(Any?;Continuation) has not been overridden");
    }
}
