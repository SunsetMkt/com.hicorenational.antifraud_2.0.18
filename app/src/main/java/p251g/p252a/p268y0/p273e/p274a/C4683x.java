package p251g.p252a.p268y0.p273e.p274a;

import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4511h;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4561b;

/* compiled from: CompletableLift.java */
/* renamed from: g.a.y0.e.a.x */
/* loaded from: classes2.dex */
public final class C4683x extends AbstractC4474c {

    /* renamed from: a */
    final InterfaceC4513i f17752a;

    /* renamed from: b */
    final InterfaceC4511h f17753b;

    public C4683x(InterfaceC4513i interfaceC4513i, InterfaceC4511h interfaceC4511h) {
        this.f17752a = interfaceC4513i;
        this.f17753b = interfaceC4511h;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    protected void mo17086b(InterfaceC4491f interfaceC4491f) {
        try {
            this.f17752a.mo17074a(this.f17753b.m17402a(interfaceC4491f));
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            C4561b.m18199b(th);
            C4476a.m17152b(th);
        }
    }
}
