package p251g.p252a.p268y0.p273e.p274a;

import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.p268y0.p269a.EnumC4593e;

/* compiled from: CompletableError.java */
/* renamed from: g.a.y0.e.a.n */
/* loaded from: classes2.dex */
public final class C4671n extends AbstractC4474c {

    /* renamed from: a */
    final Throwable f17726a;

    public C4671n(Throwable th) {
        this.f17726a = th;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    protected void mo17086b(InterfaceC4491f interfaceC4491f) {
        EnumC4593e.error(this.f17726a, interfaceC4491f);
    }
}
