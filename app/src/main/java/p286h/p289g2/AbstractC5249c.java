package p286h.p289g2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;

/* compiled from: AbstractIterator.kt */
/* renamed from: h.g2.c */
/* loaded from: classes2.dex */
public abstract class AbstractC5249c<T> implements Iterator<T>, InterfaceC5569a {

    /* renamed from: a */
    private EnumC5293q1 f20102a = EnumC5293q1.NotReady;

    /* renamed from: b */
    private T f20103b;

    /* renamed from: d */
    private final boolean m19566d() {
        this.f20102a = EnumC5293q1.Failed;
        mo19567b();
        return this.f20102a == EnumC5293q1.Ready;
    }

    /* renamed from: b */
    protected abstract void mo19567b();

    /* renamed from: b */
    protected final void m19568b(T t) {
        this.f20103b = t;
        this.f20102a = EnumC5293q1.Ready;
    }

    /* renamed from: c */
    protected final void m19569c() {
        this.f20102a = EnumC5293q1.Done;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!(this.f20102a != EnumC5293q1.Failed)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i2 = C5246b.f20100a[this.f20102a.ordinal()];
        if (i2 == 1) {
            return false;
        }
        if (i2 != 2) {
            return m19566d();
        }
        return true;
    }

    @Override // java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f20102a = EnumC5293q1.NotReady;
        return this.f20103b;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
