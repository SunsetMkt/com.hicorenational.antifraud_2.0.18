package p286h.p289g2;

import java.util.AbstractList;
import java.util.List;
import p286h.InterfaceC5610t0;
import p286h.p309q2.p311t.p312q1.InterfaceC5573e;

/* compiled from: AbstractMutableList.kt */
@InterfaceC5610t0(version = "1.1")
/* renamed from: h.g2.g */
/* loaded from: classes2.dex */
public abstract class AbstractC5261g<E> extends AbstractList<E> implements List<E>, InterfaceC5573e {
    protected AbstractC5261g() {
    }

    /* renamed from: a */
    public abstract int mo19740a();

    /* renamed from: a */
    public abstract E mo19741a(int i2);

    @Override // java.util.AbstractList, java.util.List
    public abstract void add(int i2, E e2);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int i2) {
        return mo19741a(i2);
    }

    @Override // java.util.AbstractList, java.util.List
    public abstract E set(int i2, E e2);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return mo19740a();
    }
}
