package p286h.p289g2;

import java.util.List;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: ReversedViews.kt */
/* renamed from: h.g2.i1 */
/* loaded from: classes2.dex */
class C5269i1<T> extends AbstractC5252d<T> {

    /* renamed from: a */
    private final List<T> f20127a;

    /* JADX WARN: Multi-variable type inference failed */
    public C5269i1(@InterfaceC5816d List<? extends T> list) {
        C5544i0.m22546f(list, "delegate");
        this.f20127a = list;
    }

    @Override // p286h.p289g2.AbstractC5252d, java.util.List
    public T get(int i2) {
        int m19728c;
        List<T> list = this.f20127a;
        m19728c = C5256e0.m19728c((List<?>) this, i2);
        return list.get(m19728c);
    }

    @Override // p286h.p289g2.AbstractC5252d, p286h.p289g2.AbstractC5240a
    public int getSize() {
        return this.f20127a.size();
    }
}
