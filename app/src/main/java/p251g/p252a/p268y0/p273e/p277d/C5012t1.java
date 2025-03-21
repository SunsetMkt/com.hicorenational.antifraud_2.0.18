package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.InterfaceC4492f0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: ObservableLift.java */
/* renamed from: g.a.y0.e.d.t1 */
/* loaded from: classes2.dex */
public final class C5012t1<R, T> extends AbstractC4907a<T, R> {

    /* renamed from: b */
    final InterfaceC4492f0<? extends R, ? super T> f19402b;

    public C5012t1(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4492f0<? extends R, ? super T> interfaceC4492f0) {
        super(interfaceC4504g0);
        this.f19402b = interfaceC4492f0;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super R> interfaceC4514i0) {
        try {
            this.f18742a.subscribe((InterfaceC4514i0) C4601b.m18284a(this.f19402b.m17289a(interfaceC4514i0), "Operator " + this.f19402b + " returned a null Observer"));
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            C4561b.m18199b(th);
            C4476a.m17152b(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
