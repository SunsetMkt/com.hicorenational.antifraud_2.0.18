package p286h.p289g2;

import java.util.Iterator;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Iterators.kt */
/* renamed from: h.g2.v */
/* loaded from: classes2.dex */
public abstract class AbstractC5306v implements Iterator<Character>, InterfaceC5569a {
    /* renamed from: b */
    public abstract char mo21708b();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @InterfaceC5816d
    public final Character next() {
        return Character.valueOf(mo21708b());
    }
}
