package p286h.p289g2;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Collections.kt */
/* renamed from: h.g2.i0 */
/* loaded from: classes2.dex */
public final class C5268i0 implements ListIterator, InterfaceC5569a {

    /* renamed from: a */
    public static final C5268i0 f20126a = new C5268i0();

    private C5268i0() {
    }

    /* renamed from: a */
    public void m19962a(Void r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: b */
    public void m19963b(Void r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return false;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return false;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return 0;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return -1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    @InterfaceC5816d
    public Void next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    @InterfaceC5816d
    public Void previous() {
        throw new NoSuchElementException();
    }
}
