package p286h.p294k2.p301n.p302a;

import p286h.InterfaceC5610t0;
import p286h.p294k2.InterfaceC5358d;
import p286h.p309q2.p311t.C5542h1;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.InterfaceC5523b0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: ContinuationImpl.kt */
@InterfaceC5610t0(version = "1.3")
/* renamed from: h.k2.n.a.o */
/* loaded from: classes2.dex */
public abstract class AbstractC5412o extends AbstractC5401d implements InterfaceC5523b0<Object>, InterfaceC5411n {
    private final int arity;

    public AbstractC5412o(int i2, @InterfaceC5817e InterfaceC5358d<Object> interfaceC5358d) {
        super(interfaceC5358d);
        this.arity = i2;
    }

    @Override // p286h.p309q2.p311t.InterfaceC5523b0
    public int getArity() {
        return this.arity;
    }

    @Override // p286h.p294k2.p301n.p302a.AbstractC5398a
    @InterfaceC5816d
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String m22493a = C5542h1.m22493a(this);
        C5544i0.m22521a((Object) m22493a, "Reflection.renderLambdaToString(this)");
        return m22493a;
    }

    public AbstractC5412o(int i2) {
        this(i2, null);
    }
}
