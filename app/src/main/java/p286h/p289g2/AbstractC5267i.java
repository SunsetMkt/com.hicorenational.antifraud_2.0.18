package p286h.p289g2;

import java.util.AbstractSet;
import java.util.Set;
import p286h.InterfaceC5610t0;
import p286h.p309q2.p311t.p312q1.InterfaceC5576h;

/* compiled from: AbstractMutableSet.kt */
@InterfaceC5610t0(version = "1.1")
/* renamed from: h.g2.i */
/* loaded from: classes2.dex */
public abstract class AbstractC5267i<E> extends AbstractSet<E> implements Set<E>, InterfaceC5576h {
    protected AbstractC5267i() {
    }

    /* renamed from: a */
    public abstract int m19961a();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean add(E e2);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return m19961a();
    }
}
