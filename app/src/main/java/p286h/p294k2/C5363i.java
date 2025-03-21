package p286h.p294k2;

import com.umeng.analytics.pro.C3397d;
import java.io.Serializable;
import p286h.InterfaceC5610t0;
import p286h.p294k2.InterfaceC5361g;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: CoroutineContextImpl.kt */
@InterfaceC5610t0(version = "1.3")
/* renamed from: h.k2.i */
/* loaded from: classes2.dex */
public final class C5363i implements InterfaceC5361g, Serializable {
    public static final C5363i INSTANCE = new C5363i();
    private static final long serialVersionUID = 0;

    private C5363i() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    @Override // p286h.p294k2.InterfaceC5361g
    public <R> R fold(R r, @InterfaceC5816d InterfaceC5510p<? super R, ? super InterfaceC5361g.b, ? extends R> interfaceC5510p) {
        C5544i0.m22546f(interfaceC5510p, "operation");
        return r;
    }

    @Override // p286h.p294k2.InterfaceC5361g
    @InterfaceC5817e
    public <E extends InterfaceC5361g.b> E get(@InterfaceC5816d InterfaceC5361g.c<E> cVar) {
        C5544i0.m22546f(cVar, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // p286h.p294k2.InterfaceC5361g
    @InterfaceC5816d
    public InterfaceC5361g minusKey(@InterfaceC5816d InterfaceC5361g.c<?> cVar) {
        C5544i0.m22546f(cVar, "key");
        return this;
    }

    @Override // p286h.p294k2.InterfaceC5361g
    @InterfaceC5816d
    public InterfaceC5361g plus(@InterfaceC5816d InterfaceC5361g interfaceC5361g) {
        C5544i0.m22546f(interfaceC5361g, C3397d.f11892R);
        return interfaceC5361g;
    }

    @InterfaceC5816d
    public String toString() {
        return "EmptyCoroutineContext";
    }
}
