package p286h.p289g2;

import java.util.Iterator;
import p286h.C5230f1;
import p286h.InterfaceC5352k;
import p286h.InterfaceC5610t0;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: UIterators.kt */
@InterfaceC5610t0(version = "1.3")
@InterfaceC5352k
/* renamed from: h.g2.u1 */
/* loaded from: classes2.dex */
public abstract class AbstractC5305u1 implements Iterator<C5230f1>, InterfaceC5569a {
    /* renamed from: b */
    public abstract byte mo18992b();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @InterfaceC5816d
    public final C5230f1 next() {
        return C5230f1.m18921a(mo18992b());
    }
}
