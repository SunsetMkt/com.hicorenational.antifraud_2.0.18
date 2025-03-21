package p251g.p252a.p268y0.p273e.p278e;

import p251g.p252a.p254b1.AbstractC4471b;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;

/* compiled from: ParallelFromArray.java */
/* renamed from: g.a.y0.e.e.g */
/* loaded from: classes2.dex */
public final class C5051g<T> extends AbstractC4471b<T> {

    /* renamed from: a */
    final InterfaceC5821b<T>[] f19603a;

    public C5051g(InterfaceC5821b<T>[] interfaceC5821bArr) {
        this.f19603a = interfaceC5821bArr;
    }

    @Override // p251g.p252a.p254b1.AbstractC4471b
    /* renamed from: a */
    public int mo16967a() {
        return this.f19603a.length;
    }

    @Override // p251g.p252a.p254b1.AbstractC4471b
    /* renamed from: a */
    public void mo16994a(InterfaceC5822c<? super T>[] interfaceC5822cArr) {
        if (m17003b(interfaceC5822cArr)) {
            int length = interfaceC5822cArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.f19603a[i2].subscribe(interfaceC5822cArr[i2]);
            }
        }
    }
}
