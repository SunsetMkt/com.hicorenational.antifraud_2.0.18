package p286h.p289g2;

import androidx.exifinterface.media.ExifInterface;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.umeng.analytics.pro.C3351bh;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import p286h.InterfaceC5610t0;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5586v;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: AbstractList.kt */
@InterfaceC5610t0(version = "1.1")
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\b\b'\u0018\u0000 \u001c*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004\u001c\u001d\u001e\u001fB\u0007\b\u0004¢\u0006\u0002\u0010\u0004J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\u0016\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u0006H¦\u0002¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0015\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0096\u0002J\u0015\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0016R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006 "}, m23546d2 = {"Lkotlin/collections/AbstractList;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/AbstractCollection;", "", "()V", "size", "", "getSize", "()I", "equals", "", DispatchConstants.OTHER, "", "get", "index", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "element", "(Ljava/lang/Object;)I", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "Companion", "IteratorImpl", "ListIteratorImpl", "SubList", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.g2.d */
/* loaded from: classes2.dex */
public abstract class AbstractC5252d<E> extends AbstractC5240a<E> implements List<E>, InterfaceC5569a {
    public static final a Companion = new a(null);

    /* compiled from: AbstractList.kt */
    /* renamed from: h.g2.d$a */
    public static final class a {
        private a() {
        }

        /* renamed from: a */
        public final void m19651a(int i2, int i3) {
            if (i2 < 0 || i2 >= i3) {
                throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + i3);
            }
        }

        /* renamed from: b */
        public final void m19654b(int i2, int i3) {
            if (i2 < 0 || i2 > i3) {
                throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + i3);
            }
        }

        public /* synthetic */ a(C5586v c5586v) {
            this();
        }

        /* renamed from: a */
        public final void m19652a(int i2, int i3, int i4) {
            if (i2 < 0 || i3 > i4) {
                throw new IndexOutOfBoundsException("startIndex: " + i2 + ", endIndex: " + i3 + ", size: " + i4);
            }
            if (i2 <= i3) {
                return;
            }
            throw new IllegalArgumentException("startIndex: " + i2 + " > endIndex: " + i3);
        }

        /* renamed from: b */
        public final void m19655b(int i2, int i3, int i4) {
            if (i2 < 0 || i3 > i4) {
                throw new IndexOutOfBoundsException("fromIndex: " + i2 + ", toIndex: " + i3 + ", size: " + i4);
            }
            if (i2 <= i3) {
                return;
            }
            throw new IllegalArgumentException("fromIndex: " + i2 + " > toIndex: " + i3);
        }

        /* renamed from: a */
        public final int m19650a(@InterfaceC5816d Collection<?> collection) {
            C5544i0.m22546f(collection, C3351bh.f11584aI);
            Iterator<?> it = collection.iterator();
            int i2 = 1;
            while (it.hasNext()) {
                Object next = it.next();
                i2 = (i2 * 31) + (next != null ? next.hashCode() : 0);
            }
            return i2;
        }

        /* renamed from: a */
        public final boolean m19653a(@InterfaceC5816d Collection<?> collection, @InterfaceC5816d Collection<?> collection2) {
            C5544i0.m22546f(collection, C3351bh.f11584aI);
            C5544i0.m22546f(collection2, DispatchConstants.OTHER);
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator<?> it = collection2.iterator();
            Iterator<?> it2 = collection.iterator();
            while (it2.hasNext()) {
                if (!C5544i0.m22531a(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }
    }

    /* compiled from: AbstractList.kt */
    /* renamed from: h.g2.d$b */
    private class b implements Iterator<E>, InterfaceC5569a {

        /* renamed from: a */
        private int f20104a;

        public b() {
        }

        /* renamed from: a */
        protected final void m19656a(int i2) {
            this.f20104a = i2;
        }

        /* renamed from: b */
        protected final int m19657b() {
            return this.f20104a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f20104a < AbstractC5252d.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            AbstractC5252d abstractC5252d = AbstractC5252d.this;
            int i2 = this.f20104a;
            this.f20104a = i2 + 1;
            return (E) abstractC5252d.get(i2);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* compiled from: AbstractList.kt */
    /* renamed from: h.g2.d$c */
    private class c extends AbstractC5252d<E>.b implements ListIterator<E>, InterfaceC5569a {
        public c(int i2) {
            super();
            AbstractC5252d.Companion.m19654b(i2, AbstractC5252d.this.size());
            m19656a(i2);
        }

        @Override // java.util.ListIterator
        public void add(E e2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return m19657b() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return m19657b();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            AbstractC5252d abstractC5252d = AbstractC5252d.this;
            m19656a(m19657b() - 1);
            return (E) abstractC5252d.get(m19657b());
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return m19657b() - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* compiled from: AbstractList.kt */
    /* renamed from: h.g2.d$d */
    private static final class d<E> extends AbstractC5252d<E> implements RandomAccess {

        /* renamed from: a */
        private int f20107a;

        /* renamed from: b */
        private final AbstractC5252d<E> f20108b;

        /* renamed from: c */
        private final int f20109c;

        /* JADX WARN: Multi-variable type inference failed */
        public d(@InterfaceC5816d AbstractC5252d<? extends E> abstractC5252d, int i2, int i3) {
            C5544i0.m22546f(abstractC5252d, "list");
            this.f20108b = abstractC5252d;
            this.f20109c = i2;
            AbstractC5252d.Companion.m19655b(this.f20109c, i3, this.f20108b.size());
            this.f20107a = i3 - this.f20109c;
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        public E get(int i2) {
            AbstractC5252d.Companion.m19651a(i2, this.f20107a);
            return this.f20108b.get(this.f20109c + i2);
        }

        @Override // p286h.p289g2.AbstractC5252d, p286h.p289g2.AbstractC5240a
        public int getSize() {
            return this.f20107a;
        }
    }

    protected AbstractC5252d() {
    }

    @Override // java.util.List
    public void add(int i2, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i2, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@InterfaceC5817e Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return Companion.m19653a(this, (Collection<?>) obj);
        }
        return false;
    }

    public abstract E get(int i2);

    @Override // p286h.p289g2.AbstractC5240a
    public abstract int getSize();

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return Companion.m19650a(this);
    }

    public int indexOf(Object obj) {
        Iterator<E> it = iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (C5544i0.m22531a(it.next(), obj)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    @Override // p286h.p289g2.AbstractC5240a, java.util.Collection, java.lang.Iterable
    @InterfaceC5816d
    public Iterator<E> iterator() {
        return new b();
    }

    public int lastIndexOf(Object obj) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (C5544i0.m22531a(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    @InterfaceC5816d
    public ListIterator<E> listIterator() {
        return new c(0);
    }

    @Override // java.util.List
    public E remove(int i2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i2, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    @InterfaceC5816d
    public List<E> subList(int i2, int i3) {
        return new d(this, i2, i3);
    }

    @Override // java.util.List
    @InterfaceC5816d
    public ListIterator<E> listIterator(int i2) {
        return new c(i2);
    }
}
