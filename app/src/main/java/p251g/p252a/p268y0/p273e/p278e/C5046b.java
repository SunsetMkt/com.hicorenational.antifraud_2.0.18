package p251g.p252a.p268y0.p273e.p278e;

import p251g.p252a.p254b1.AbstractC4471b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p273e.p275b.C4816w;
import p251g.p252a.p268y0.p284j.EnumC5170j;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;

/* compiled from: ParallelConcatMap.java */
/* renamed from: g.a.y0.e.e.b */
/* loaded from: classes2.dex */
public final class C5046b<T, R> extends AbstractC4471b<R> {

    /* renamed from: a */
    final AbstractC4471b<T> f19563a;

    /* renamed from: b */
    final InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> f19564b;

    /* renamed from: c */
    final int f19565c;

    /* renamed from: d */
    final EnumC5170j f19566d;

    public C5046b(AbstractC4471b<T> abstractC4471b, InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> interfaceC4584o, int i2, EnumC5170j enumC5170j) {
        this.f19563a = abstractC4471b;
        this.f19564b = (InterfaceC4584o) C4601b.m18284a(interfaceC4584o, "mapper");
        this.f19565c = i2;
        this.f19566d = (EnumC5170j) C4601b.m18284a(enumC5170j, "errorMode");
    }

    @Override // p251g.p252a.p254b1.AbstractC4471b
    /* renamed from: a */
    public int mo16967a() {
        return this.f19563a.mo16967a();
    }

    @Override // p251g.p252a.p254b1.AbstractC4471b
    /* renamed from: a */
    public void mo16994a(InterfaceC5822c<? super R>[] interfaceC5822cArr) {
        if (m17003b(interfaceC5822cArr)) {
            int length = interfaceC5822cArr.length;
            InterfaceC5822c<? super T>[] interfaceC5822cArr2 = new InterfaceC5822c[length];
            for (int i2 = 0; i2 < length; i2++) {
                interfaceC5822cArr2[i2] = C4816w.m18397a(interfaceC5822cArr[i2], this.f19564b, this.f19565c, this.f19566d);
            }
            this.f19563a.mo16994a(interfaceC5822cArr2);
        }
    }
}
