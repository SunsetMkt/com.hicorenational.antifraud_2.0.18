package p286h.p289g2;

import java.util.Iterator;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Iterators.kt */
/* renamed from: h.g2.o1 */
/* loaded from: classes2.dex */
public abstract class AbstractC5287o1 implements Iterator<Short>, InterfaceC5569a {
    /* renamed from: b */
    public abstract short mo20129b();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    @InterfaceC5816d
    public final Short next() {
        return Short.valueOf(mo20129b());
    }
}
