package i.k2.n.a;

import i.q2.t.b0;
import i.q2.t.h1;
import i.q2.t.i0;
import i.t0;

/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@t0(version = "1.3")
public abstract class o extends d implements b0<Object>, n {
    private final int arity;

    public o(int i2, @j.c.a.e i.k2.d<Object> dVar) {
        super(dVar);
        this.arity = i2;
    }

    @Override // i.q2.t.b0
    public int getArity() {
        return this.arity;
    }

    @Override // i.k2.n.a.a
    @j.c.a.d
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String strA = h1.a(this);
        i0.a((Object) strA, "Reflection.renderLambdaToString(this)");
        return strA;
    }

    public o(int i2) {
        this(i2, null);
    }
}
