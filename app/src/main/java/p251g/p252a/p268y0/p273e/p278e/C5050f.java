package p251g.p252a.p268y0.p273e.p278e;

import p251g.p252a.p254b1.AbstractC4471b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p273e.p275b.C4817w0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;

/* compiled from: ParallelFlatMap.java */
/* renamed from: g.a.y0.e.e.f */
/* loaded from: classes2.dex */
public final class C5050f<T, R> extends AbstractC4471b<R> {

    /* renamed from: a */
    final AbstractC4471b<T> f19598a;

    /* renamed from: b */
    final InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> f19599b;

    /* renamed from: c */
    final boolean f19600c;

    /* renamed from: d */
    final int f19601d;

    /* renamed from: e */
    final int f19602e;

    public C5050f(AbstractC4471b<T> abstractC4471b, InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> interfaceC4584o, boolean z, int i2, int i3) {
        this.f19598a = abstractC4471b;
        this.f19599b = interfaceC4584o;
        this.f19600c = z;
        this.f19601d = i2;
        this.f19602e = i3;
    }

    @Override // p251g.p252a.p254b1.AbstractC4471b
    /* renamed from: a */
    public int mo16967a() {
        return this.f19598a.mo16967a();
    }

    @Override // p251g.p252a.p254b1.AbstractC4471b
    /* renamed from: a */
    public void mo16994a(InterfaceC5822c<? super R>[] interfaceC5822cArr) {
        if (m17003b(interfaceC5822cArr)) {
            int length = interfaceC5822cArr.length;
            InterfaceC5822c<? super T>[] interfaceC5822cArr2 = new InterfaceC5822c[length];
            for (int i2 = 0; i2 < length; i2++) {
                interfaceC5822cArr2[i2] = C4817w0.m18398a(interfaceC5822cArr[i2], this.f19599b, this.f19600c, this.f19601d, this.f19602e);
            }
            this.f19598a.mo16994a(interfaceC5822cArr2);
        }
    }
}
