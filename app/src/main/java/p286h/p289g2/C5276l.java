package p286h.p289g2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import p286h.C5226e1;
import p286h.C5715y1;
import p286h.InterfaceC5339j;
import p286h.InterfaceC5610t0;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p311t.C5544i0;
import p286h.p319v2.C5648q;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: ArrayDeque.kt */
@InterfaceC5610t0(version = "1.3")
@InterfaceC5339j
/* renamed from: h.g2.l */
/* loaded from: classes2.dex */
public final class C5276l<E> extends AbstractC5261g<E> {

    /* renamed from: a */
    private int f20138a;

    /* renamed from: b */
    private Object[] f20139b;

    /* renamed from: c */
    private int f20140c;

    public C5276l(int i2) {
        Object[] objArr;
        if (i2 == 0) {
            objArr = C5279m.f20141a;
        } else {
            if (i2 <= 0) {
                throw new IllegalArgumentException("Illegal Capacity: " + i2);
            }
            objArr = new Object[i2];
        }
        this.f20139b = objArr;
    }

    @InterfaceC5426f
    /* renamed from: f */
    private final E m19998f(int i2) {
        return (E) this.f20139b[i2];
    }

    @InterfaceC5426f
    /* renamed from: g */
    private final int m19999g(int i2) {
        return m20001i(this.f20138a + i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public final int m20000h(int i2) {
        return i2 < 0 ? i2 + this.f20139b.length : i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public final int m20001i(int i2) {
        Object[] objArr = this.f20139b;
        return i2 >= objArr.length ? i2 - objArr.length : i2;
    }

    /* renamed from: a */
    public final int m20002a(int i2, int i3) {
        int i4 = i2 + (i2 >> 1);
        if (i4 - i3 < 0) {
            i4 = i3;
        }
        return i4 - 2147483639 > 0 ? i3 > 2147483639 ? Integer.MAX_VALUE : 2147483639 : i4;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e2) {
        addLast(e2);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(@InterfaceC5816d Collection<? extends E> collection) {
        C5544i0.m22546f(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        m19994d(size() + collection.size());
        m19984a(m20001i(this.f20138a + size()), collection);
        return true;
    }

    public final void addFirst(E e2) {
        m19994d(size() + 1);
        this.f20138a = m19991c(this.f20138a);
        this.f20139b[this.f20138a] = e2;
        this.f20140c = size() + 1;
    }

    public final void addLast(E e2) {
        m19994d(size() + 1);
        this.f20139b[m20001i(this.f20138a + size())] = e2;
        this.f20140c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int m20001i = m20001i(this.f20138a + size());
        int i2 = this.f20138a;
        if (i2 < m20001i) {
            C5291q.m20273b(this.f20139b, (Object) null, i2, m20001i);
        } else if (!isEmpty()) {
            Object[] objArr = this.f20139b;
            C5291q.m20273b(objArr, (Object) null, this.f20138a, objArr.length);
            C5291q.m20273b(this.f20139b, (Object) null, 0, m20001i);
        }
        this.f20138a = 0;
        this.f20140c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i2) {
        AbstractC5252d.Companion.m19651a(i2, size());
        return (E) this.f20139b[m20001i(this.f20138a + i2)];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i2;
        int m20001i = m20001i(this.f20138a + size());
        int i3 = this.f20138a;
        if (i3 < m20001i) {
            while (i3 < m20001i) {
                if (C5544i0.m22531a(obj, this.f20139b[i3])) {
                    i2 = this.f20138a;
                } else {
                    i3++;
                }
            }
            return -1;
        }
        if (i3 < m20001i) {
            return -1;
        }
        int length = this.f20139b.length;
        while (true) {
            if (i3 >= length) {
                for (int i4 = 0; i4 < m20001i; i4++) {
                    if (C5544i0.m22531a(obj, this.f20139b[i4])) {
                        i3 = i4 + this.f20139b.length;
                        i2 = this.f20138a;
                    }
                }
                return -1;
            }
            if (C5544i0.m22531a(obj, this.f20139b[i3])) {
                i2 = this.f20138a;
                break;
            }
            i3++;
        }
        return i3 - i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int m21555u;
        int i2;
        int m20001i = m20001i(this.f20138a + size());
        int i3 = this.f20138a;
        if (i3 < m20001i) {
            m21555u = m20001i - 1;
            if (m21555u < i3) {
                return -1;
            }
            while (!C5544i0.m22531a(obj, this.f20139b[m21555u])) {
                if (m21555u == i3) {
                    return -1;
                }
                m21555u--;
            }
            i2 = this.f20138a;
        } else {
            if (i3 <= m20001i) {
                return -1;
            }
            int i4 = m20001i - 1;
            while (true) {
                if (i4 < 0) {
                    m21555u = C5294r.m21555u(this.f20139b);
                    int i5 = this.f20138a;
                    if (m21555u < i5) {
                        return -1;
                    }
                    while (!C5544i0.m22531a(obj, this.f20139b[m21555u])) {
                        if (m21555u == i5) {
                            return -1;
                        }
                        m21555u--;
                    }
                    i2 = this.f20138a;
                } else {
                    if (C5544i0.m22531a(obj, this.f20139b[i4])) {
                        m21555u = i4 + this.f20139b.length;
                        i2 = this.f20138a;
                        break;
                    }
                    i4--;
                }
            }
        }
        return m21555u - i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(@InterfaceC5816d Collection<? extends Object> collection) {
        C5544i0.m22546f(collection, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty()) {
            if (!(this.f20139b.length == 0)) {
                int m20001i = m20001i(this.f20138a + size());
                int i2 = this.f20138a;
                if (this.f20138a < m20001i) {
                    for (int i3 = this.f20138a; i3 < m20001i; i3++) {
                        Object obj = this.f20139b[i3];
                        if (!collection.contains(obj)) {
                            this.f20139b[i2] = obj;
                            i2++;
                        } else {
                            z = true;
                        }
                    }
                    C5291q.m20273b(this.f20139b, (Object) null, i2, m20001i);
                } else {
                    int length = this.f20139b.length;
                    boolean z2 = false;
                    for (int i4 = this.f20138a; i4 < length; i4++) {
                        Object obj2 = this.f20139b[i4];
                        this.f20139b[i4] = null;
                        if (!collection.contains(obj2)) {
                            this.f20139b[i2] = obj2;
                            i2++;
                        } else {
                            z2 = true;
                        }
                    }
                    i2 = m20001i(i2);
                    for (int i5 = 0; i5 < m20001i; i5++) {
                        Object obj3 = this.f20139b[i5];
                        this.f20139b[i5] = null;
                        if (!collection.contains(obj3)) {
                            this.f20139b[i2] = obj3;
                            i2 = m19996e(i2);
                        } else {
                            z2 = true;
                        }
                    }
                    z = z2;
                }
                if (z) {
                    this.f20140c = m20000h(i2 - this.f20138a);
                }
            }
        }
        return z;
    }

    public final E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        E e2 = (E) this.f20139b[this.f20138a];
        Object[] objArr = this.f20139b;
        int i2 = this.f20138a;
        objArr[i2] = null;
        this.f20138a = m19996e(i2);
        this.f20140c = size() - 1;
        return e2;
    }

    public final E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        int m20001i = m20001i(this.f20138a + C5315y.m21757a((List) this));
        E e2 = (E) this.f20139b[m20001i];
        this.f20139b[m20001i] = null;
        this.f20140c = size() - 1;
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(@InterfaceC5816d Collection<? extends Object> collection) {
        C5544i0.m22546f(collection, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty()) {
            if (!(this.f20139b.length == 0)) {
                int m20001i = m20001i(this.f20138a + size());
                int i2 = this.f20138a;
                if (this.f20138a < m20001i) {
                    for (int i3 = this.f20138a; i3 < m20001i; i3++) {
                        Object obj = this.f20139b[i3];
                        if (collection.contains(obj)) {
                            this.f20139b[i2] = obj;
                            i2++;
                        } else {
                            z = true;
                        }
                    }
                    C5291q.m20273b(this.f20139b, (Object) null, i2, m20001i);
                } else {
                    int length = this.f20139b.length;
                    boolean z2 = false;
                    for (int i4 = this.f20138a; i4 < length; i4++) {
                        Object obj2 = this.f20139b[i4];
                        this.f20139b[i4] = null;
                        if (collection.contains(obj2)) {
                            this.f20139b[i2] = obj2;
                            i2++;
                        } else {
                            z2 = true;
                        }
                    }
                    i2 = m20001i(i2);
                    for (int i5 = 0; i5 < m20001i; i5++) {
                        Object obj3 = this.f20139b[i5];
                        this.f20139b[i5] = null;
                        if (collection.contains(obj3)) {
                            this.f20139b[i2] = obj3;
                            i2 = m19996e(i2);
                        } else {
                            z2 = true;
                        }
                    }
                    z = z2;
                }
                if (z) {
                    this.f20140c = m20000h(i2 - this.f20138a);
                }
            }
        }
        return z;
    }

    @Override // p286h.p289g2.AbstractC5261g, java.util.AbstractList, java.util.List
    public E set(int i2, E e2) {
        AbstractC5252d.Companion.m19651a(i2, size());
        int m20001i = m20001i(this.f20138a + i2);
        E e3 = (E) this.f20139b[m20001i];
        this.f20139b[m20001i] = e2;
        return e3;
    }

    /* renamed from: d */
    private final void m19994d(int i2) {
        Object[] objArr;
        int m23050a;
        if (i2 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr2 = this.f20139b;
        if (i2 <= objArr2.length) {
            return;
        }
        objArr = C5279m.f20141a;
        if (objArr2 != objArr) {
            m19990b(m20002a(this.f20139b.length, i2));
        } else {
            m23050a = C5648q.m23050a(i2, 10);
            this.f20139b = new Object[m23050a];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public final int m19996e(int i2) {
        if (i2 == C5294r.m21555u(this.f20139b)) {
            return 0;
        }
        return i2 + 1;
    }

    @Override // p286h.p289g2.AbstractC5261g, java.util.AbstractList, java.util.List
    public void add(int i2, E e2) {
        AbstractC5252d.Companion.m19654b(i2, size());
        if (i2 == size()) {
            addLast(e2);
            return;
        }
        if (i2 == 0) {
            addFirst(e2);
            return;
        }
        m19994d(size() + 1);
        int m20001i = m20001i(this.f20138a + i2);
        if (i2 < ((size() + 1) >> 1)) {
            int m19991c = m19991c(m20001i);
            int m19991c2 = m19991c(this.f20138a);
            int i3 = this.f20138a;
            if (m19991c >= i3) {
                Object[] objArr = this.f20139b;
                objArr[m19991c2] = objArr[i3];
                C5291q.m20230a(objArr, objArr, i3, i3 + 1, m19991c + 1);
            } else {
                Object[] objArr2 = this.f20139b;
                C5291q.m20230a(objArr2, objArr2, i3 - 1, i3, objArr2.length);
                Object[] objArr3 = this.f20139b;
                objArr3[objArr3.length - 1] = objArr3[0];
                C5291q.m20230a(objArr3, objArr3, 0, 1, m19991c + 1);
            }
            this.f20139b[m19991c] = e2;
            this.f20138a = m19991c2;
        } else {
            int m20001i2 = m20001i(this.f20138a + size());
            if (m20001i < m20001i2) {
                Object[] objArr4 = this.f20139b;
                C5291q.m20230a(objArr4, objArr4, m20001i + 1, m20001i, m20001i2);
            } else {
                Object[] objArr5 = this.f20139b;
                C5291q.m20230a(objArr5, objArr5, 1, 0, m20001i2);
                Object[] objArr6 = this.f20139b;
                objArr6[0] = objArr6[objArr6.length - 1];
                C5291q.m20230a(objArr6, objArr6, m20001i + 1, m20001i, objArr6.length - 1);
            }
            this.f20139b[m20001i] = e2;
        }
        this.f20140c = size() + 1;
    }

    @InterfaceC5817e
    /* renamed from: f */
    public final E m20008f() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    @InterfaceC5817e
    /* renamed from: g */
    public final E m20009g() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    /* renamed from: b */
    private final void m19990b(int i2) {
        Object[] objArr = new Object[i2];
        Object[] objArr2 = this.f20139b;
        C5291q.m20230a(objArr2, objArr, 0, this.f20138a, objArr2.length);
        Object[] objArr3 = this.f20139b;
        int length = objArr3.length;
        int i3 = this.f20138a;
        C5291q.m20230a(objArr3, objArr, length - i3, 0, i3);
        this.f20138a = 0;
        this.f20139b = objArr;
    }

    /* renamed from: c */
    private final int m19991c(int i2) {
        return i2 == 0 ? C5294r.m21555u(this.f20139b) : i2 - 1;
    }

    @InterfaceC5817e
    /* renamed from: e */
    public final E m20007e() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.f20139b[m20001i(this.f20138a + C5315y.m21757a((List) this))];
    }

    @Override // p286h.p289g2.AbstractC5261g
    /* renamed from: a */
    public int mo19740a() {
        return this.f20140c;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i2, @InterfaceC5816d Collection<? extends E> collection) {
        C5544i0.m22546f(collection, "elements");
        AbstractC5252d.Companion.m19654b(i2, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (i2 == size()) {
            return addAll(collection);
        }
        m19994d(size() + collection.size());
        int m20001i = m20001i(this.f20138a + size());
        int m20001i2 = m20001i(this.f20138a + i2);
        int size = collection.size();
        if (i2 < ((size() + 1) >> 1)) {
            int i3 = this.f20138a;
            int i4 = i3 - size;
            if (m20001i2 < i3) {
                Object[] objArr = this.f20139b;
                C5291q.m20230a(objArr, objArr, i4, i3, objArr.length);
                if (size >= m20001i2) {
                    Object[] objArr2 = this.f20139b;
                    C5291q.m20230a(objArr2, objArr2, objArr2.length - size, 0, m20001i2);
                } else {
                    Object[] objArr3 = this.f20139b;
                    C5291q.m20230a(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f20139b;
                    C5291q.m20230a(objArr4, objArr4, 0, size, m20001i2);
                }
            } else if (i4 >= 0) {
                Object[] objArr5 = this.f20139b;
                C5291q.m20230a(objArr5, objArr5, i4, i3, m20001i2);
            } else {
                Object[] objArr6 = this.f20139b;
                i4 += objArr6.length;
                int i5 = m20001i2 - i3;
                int length = objArr6.length - i4;
                if (length >= i5) {
                    C5291q.m20230a(objArr6, objArr6, i4, i3, m20001i2);
                } else {
                    C5291q.m20230a(objArr6, objArr6, i4, i3, i3 + length);
                    Object[] objArr7 = this.f20139b;
                    C5291q.m20230a(objArr7, objArr7, 0, this.f20138a + length, m20001i2);
                }
            }
            this.f20138a = i4;
            m19984a(m20000h(m20001i2 - size), collection);
        } else {
            int i6 = m20001i2 + size;
            if (m20001i2 < m20001i) {
                int i7 = size + m20001i;
                Object[] objArr8 = this.f20139b;
                if (i7 <= objArr8.length) {
                    C5291q.m20230a(objArr8, objArr8, i6, m20001i2, m20001i);
                } else if (i6 >= objArr8.length) {
                    C5291q.m20230a(objArr8, objArr8, i6 - objArr8.length, m20001i2, m20001i);
                } else {
                    int length2 = m20001i - (i7 - objArr8.length);
                    C5291q.m20230a(objArr8, objArr8, 0, length2, m20001i);
                    Object[] objArr9 = this.f20139b;
                    C5291q.m20230a(objArr9, objArr9, i6, m20001i2, length2);
                }
            } else {
                Object[] objArr10 = this.f20139b;
                C5291q.m20230a(objArr10, objArr10, size, 0, m20001i);
                Object[] objArr11 = this.f20139b;
                if (i6 >= objArr11.length) {
                    C5291q.m20230a(objArr11, objArr11, i6 - objArr11.length, m20001i2, objArr11.length);
                } else {
                    C5291q.m20230a(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f20139b;
                    C5291q.m20230a(objArr12, objArr12, i6, m20001i2, objArr12.length - size);
                }
            }
            m19984a(m20001i2, collection);
        }
        return true;
    }

    @InterfaceC5817e
    /* renamed from: c */
    public final E m20005c() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.f20139b[this.f20138a];
    }

    /* renamed from: a */
    private final void m19984a(int i2, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.f20139b.length;
        while (i2 < length && it.hasNext()) {
            this.f20139b[i2] = it.next();
            i2++;
        }
        int i3 = this.f20138a;
        for (int i4 = 0; i4 < i3 && it.hasNext(); i4++) {
            this.f20139b[i4] = it.next();
        }
        this.f20140c = size() + collection.size();
    }

    public C5276l() {
        Object[] objArr;
        objArr = C5279m.f20141a;
        this.f20139b = objArr;
    }

    public C5276l(@InterfaceC5816d Collection<? extends E> collection) {
        Object[] objArr;
        C5544i0.m22546f(collection, "elements");
        Object[] array = collection.toArray(new Object[0]);
        if (array != null) {
            this.f20139b = array;
            Object[] objArr2 = this.f20139b;
            this.f20140c = objArr2.length;
            if (objArr2.length == 0) {
                objArr = C5279m.f20141a;
                this.f20139b = objArr;
                return;
            }
            return;
        }
        throw new C5226e1("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* renamed from: b */
    public final E m20004b() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.f20139b[this.f20138a];
    }

    /* renamed from: d */
    public final E m20006d() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.f20139b[m20001i(this.f20138a + C5315y.m21757a((List) this))];
    }

    @Override // p286h.p289g2.AbstractC5261g
    /* renamed from: a */
    public E mo19741a(int i2) {
        AbstractC5252d.Companion.m19651a(i2, size());
        if (i2 == C5315y.m21757a((List) this)) {
            return removeLast();
        }
        if (i2 != 0) {
            int m20001i = m20001i(this.f20138a + i2);
            E e2 = (E) this.f20139b[m20001i];
            if (i2 < (size() >> 1)) {
                int i3 = this.f20138a;
                if (m20001i >= i3) {
                    Object[] objArr = this.f20139b;
                    C5291q.m20230a(objArr, objArr, i3 + 1, i3, m20001i);
                } else {
                    Object[] objArr2 = this.f20139b;
                    C5291q.m20230a(objArr2, objArr2, 1, 0, m20001i);
                    Object[] objArr3 = this.f20139b;
                    objArr3[0] = objArr3[objArr3.length - 1];
                    int i4 = this.f20138a;
                    C5291q.m20230a(objArr3, objArr3, i4 + 1, i4, objArr3.length - 1);
                }
                Object[] objArr4 = this.f20139b;
                int i5 = this.f20138a;
                objArr4[i5] = null;
                this.f20138a = m19996e(i5);
            } else {
                int m20001i2 = m20001i(this.f20138a + C5315y.m21757a((List) this));
                if (m20001i <= m20001i2) {
                    Object[] objArr5 = this.f20139b;
                    C5291q.m20230a(objArr5, objArr5, m20001i, m20001i + 1, m20001i2 + 1);
                } else {
                    Object[] objArr6 = this.f20139b;
                    C5291q.m20230a(objArr6, objArr6, m20001i, m20001i + 1, objArr6.length);
                    Object[] objArr7 = this.f20139b;
                    objArr7[objArr7.length - 1] = objArr7[0];
                    C5291q.m20230a(objArr7, objArr7, 0, 1, m20001i2 + 1);
                }
                this.f20139b[m20001i2] = null;
            }
            this.f20140c = size() - 1;
            return e2;
        }
        return removeFirst();
    }

    /* renamed from: a */
    private final boolean m19986a(InterfaceC5506l<? super E, Boolean> interfaceC5506l) {
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty()) {
            if (!(this.f20139b.length == 0)) {
                int m20001i = m20001i(this.f20138a + size());
                int i2 = this.f20138a;
                if (this.f20138a < m20001i) {
                    for (int i3 = this.f20138a; i3 < m20001i; i3++) {
                        Object obj = this.f20139b[i3];
                        if (interfaceC5506l.invoke(obj).booleanValue()) {
                            this.f20139b[i2] = obj;
                            i2++;
                        } else {
                            z = true;
                        }
                    }
                    C5291q.m20273b(this.f20139b, (Object) null, i2, m20001i);
                } else {
                    int length = this.f20139b.length;
                    boolean z2 = false;
                    for (int i4 = this.f20138a; i4 < length; i4++) {
                        Object obj2 = this.f20139b[i4];
                        this.f20139b[i4] = null;
                        if (interfaceC5506l.invoke(obj2).booleanValue()) {
                            this.f20139b[i2] = obj2;
                            i2++;
                        } else {
                            z2 = true;
                        }
                    }
                    i2 = m20001i(i2);
                    for (int i5 = 0; i5 < m20001i; i5++) {
                        Object obj3 = this.f20139b[i5];
                        this.f20139b[i5] = null;
                        if (interfaceC5506l.invoke(obj3).booleanValue()) {
                            this.f20139b[i2] = obj3;
                            i2 = m19996e(i2);
                        } else {
                            z2 = true;
                        }
                    }
                    z = z2;
                }
                if (z) {
                    this.f20140c = m20000h(i2 - this.f20138a);
                }
            }
        }
        return z;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, java.lang.Object[]] */
    /* renamed from: a */
    public final void m20003a(@InterfaceC5816d InterfaceC5510p<? super Integer, ? super Object[], C5715y1> interfaceC5510p) {
        C5544i0.m22546f(interfaceC5510p, "structure");
        int m20001i = m20001i(this.f20138a + size());
        if (isEmpty()) {
            interfaceC5510p.invoke(Integer.valueOf(this.f20138a), new Object[0]);
            return;
        }
        ?? r0 = new Object[size()];
        int i2 = this.f20138a;
        if (i2 < m20001i) {
            C5291q.m20231a(this.f20139b, (Object[]) r0, 0, i2, m20001i, 2, (Object) null);
            interfaceC5510p.invoke(Integer.valueOf(this.f20138a), r0);
        } else {
            C5291q.m20231a(this.f20139b, (Object[]) r0, 0, i2, 0, 10, (Object) null);
            Object[] objArr = this.f20139b;
            C5291q.m20230a(objArr, (Object[]) r0, objArr.length - this.f20138a, 0, m20001i);
            interfaceC5510p.invoke(Integer.valueOf(this.f20138a - this.f20139b.length), r0);
        }
    }
}
