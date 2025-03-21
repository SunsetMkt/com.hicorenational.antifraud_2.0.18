package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4527p;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4561b;
import p324i.p338d.InterfaceC5822c;

/* compiled from: FlowableLift.java */
/* renamed from: g.a.y0.e.b.w1 */
/* loaded from: classes2.dex */
public final class C4818w1<R, T> extends AbstractC4686a<T, R> {

    /* renamed from: c */
    final InterfaceC4527p<? extends R, ? super T> f18477c;

    public C4818w1(AbstractC4519l<T> abstractC4519l, InterfaceC4527p<? extends R, ? super T> interfaceC4527p) {
        super(abstractC4519l);
        this.f18477c = interfaceC4527p;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super R> interfaceC5822c) {
        try {
            InterfaceC5822c<? super Object> m18005a = this.f18477c.m18005a(interfaceC5822c);
            if (m18005a != null) {
                this.f17759b.subscribe(m18005a);
                return;
            }
            throw new NullPointerException("Operator " + this.f18477c + " returned a null Subscriber");
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
