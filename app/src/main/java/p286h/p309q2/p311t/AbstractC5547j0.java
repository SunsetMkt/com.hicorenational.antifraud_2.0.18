package p286h.p309q2.p311t;

import java.io.Serializable;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Lambda.kt */
/* renamed from: h.q2.t.j0 */
/* loaded from: classes2.dex */
public abstract class AbstractC5547j0<R> implements InterfaceC5523b0<R>, Serializable {
    private final int arity;

    public AbstractC5547j0(int i2) {
        this.arity = i2;
    }

    @Override // p286h.p309q2.p311t.InterfaceC5523b0
    public int getArity() {
        return this.arity;
    }

    @InterfaceC5816d
    public String toString() {
        String m22494a = C5542h1.m22494a((AbstractC5547j0) this);
        C5544i0.m22521a((Object) m22494a, "Reflection.renderLambdaToString(this)");
        return m22494a;
    }
}
