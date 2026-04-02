package i.k2.n.a;

import i.k2.g;
import i.q2.t.i0;
import i.t0;

/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@t0(version = "1.3")
public abstract class d extends a {
    private final i.k2.g _context;
    private transient i.k2.d<Object> a;

    public d(@j.c.a.e i.k2.d<Object> dVar, @j.c.a.e i.k2.g gVar) {
        super(dVar);
        this._context = gVar;
    }

    @Override // i.k2.d
    @j.c.a.d
    public i.k2.g getContext() {
        i.k2.g gVar = this._context;
        if (gVar == null) {
            i0.f();
        }
        return gVar;
    }

    @j.c.a.d
    public final i.k2.d<Object> intercepted() {
        i.k2.d<Object> dVarB = this.a;
        if (dVarB == null) {
            i.k2.e eVar = (i.k2.e) getContext().get(i.k2.e.V);
            if (eVar == null || (dVarB = eVar.b(this)) == null) {
                dVarB = this;
            }
            this.a = dVarB;
        }
        return dVarB;
    }

    @Override // i.k2.n.a.a
    protected void releaseIntercepted() {
        i.k2.d<?> dVar = this.a;
        if (dVar != null && dVar != this) {
            g.b bVar = getContext().get(i.k2.e.V);
            if (bVar == null) {
                i0.f();
            }
            ((i.k2.e) bVar).a(dVar);
        }
        this.a = c.a;
    }

    public d(@j.c.a.e i.k2.d<Object> dVar) {
        this(dVar, dVar != null ? dVar.getContext() : null);
    }
}
