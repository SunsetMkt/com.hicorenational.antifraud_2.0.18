package p286h.p289g2;

import java.util.AbstractCollection;
import java.util.Collection;
import p286h.InterfaceC5610t0;
import p286h.p309q2.p311t.p312q1.InterfaceC5570b;

/* compiled from: AbstractMutableCollection.kt */
@InterfaceC5610t0(version = "1.1")
/* renamed from: h.g2.f */
/* loaded from: classes2.dex */
public abstract class AbstractC5258f<E> extends AbstractCollection<E> implements Collection<E>, InterfaceC5570b {
    protected AbstractC5258f() {
    }

    /* renamed from: a */
    public abstract int m19733a();

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract boolean add(E e2);

    @Override // java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return m19733a();
    }
}
