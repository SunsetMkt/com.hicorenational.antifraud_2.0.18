package p286h.p294k2.p301n.p302a;

import p286h.InterfaceC5610t0;
import p286h.p294k2.InterfaceC5358d;
import p286h.p294k2.InterfaceC5359e;
import p286h.p294k2.InterfaceC5361g;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: ContinuationImpl.kt */
@InterfaceC5610t0(version = "1.3")
/* renamed from: h.k2.n.a.d */
/* loaded from: classes2.dex */
public abstract class AbstractC5401d extends AbstractC5398a {
    private final InterfaceC5361g _context;

    /* renamed from: a */
    private transient InterfaceC5358d<Object> f20288a;

    public AbstractC5401d(@InterfaceC5817e InterfaceC5358d<Object> interfaceC5358d, @InterfaceC5817e InterfaceC5361g interfaceC5361g) {
        super(interfaceC5358d);
        this._context = interfaceC5361g;
    }

    @Override // p286h.p294k2.InterfaceC5358d
    @InterfaceC5816d
    public InterfaceC5361g getContext() {
        InterfaceC5361g interfaceC5361g = this._context;
        if (interfaceC5361g == null) {
            C5544i0.m22545f();
        }
        return interfaceC5361g;
    }

    @InterfaceC5816d
    public final InterfaceC5358d<Object> intercepted() {
        InterfaceC5358d<Object> interfaceC5358d = this.f20288a;
        if (interfaceC5358d == null) {
            InterfaceC5359e interfaceC5359e = (InterfaceC5359e) getContext().get(InterfaceC5359e.f20232V);
            if (interfaceC5359e == null || (interfaceC5358d = interfaceC5359e.mo22001b(this)) == null) {
                interfaceC5358d = this;
            }
            this.f20288a = interfaceC5358d;
        }
        return interfaceC5358d;
    }

    @Override // p286h.p294k2.p301n.p302a.AbstractC5398a
    protected void releaseIntercepted() {
        InterfaceC5358d<?> interfaceC5358d = this.f20288a;
        if (interfaceC5358d != null && interfaceC5358d != this) {
            InterfaceC5361g.b bVar = getContext().get(InterfaceC5359e.f20232V);
            if (bVar == null) {
                C5544i0.m22545f();
            }
            ((InterfaceC5359e) bVar).mo22000a(interfaceC5358d);
        }
        this.f20288a = C5400c.f20287a;
    }

    public AbstractC5401d(@InterfaceC5817e InterfaceC5358d<Object> interfaceC5358d) {
        this(interfaceC5358d, interfaceC5358d != null ? interfaceC5358d.getContext() : null);
    }
}
