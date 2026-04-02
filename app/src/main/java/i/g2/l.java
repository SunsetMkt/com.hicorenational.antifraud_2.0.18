package i.g2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ArrayDeque.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.j
@i.t0(version = "1.3")
public final class l<E> extends g<E> {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object[] f12090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f12091c;

    public l(int i2) {
        Object[] objArr;
        if (i2 == 0) {
            objArr = m.a;
        } else {
            if (i2 <= 0) {
                throw new IllegalArgumentException("Illegal Capacity: " + i2);
            }
            objArr = new Object[i2];
        }
        this.f12090b = objArr;
    }

    @i.m2.f
    private final E f(int i2) {
        return (E) this.f12090b[i2];
    }

    @i.m2.f
    private final int g(int i2) {
        return i(this.a + i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int h(int i2) {
        return i2 < 0 ? i2 + this.f12090b.length : i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int i(int i2) {
        Object[] objArr = this.f12090b;
        return i2 >= objArr.length ? i2 - objArr.length : i2;
    }

    public final int a(int i2, int i3) {
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
    public boolean addAll(@j.c.a.d Collection<? extends E> collection) {
        i.q2.t.i0.f(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        d(size() + collection.size());
        a(i(this.a + size()), collection);
        return true;
    }

    public final void addFirst(E e2) {
        d(size() + 1);
        this.a = c(this.a);
        this.f12090b[this.a] = e2;
        this.f12091c = size() + 1;
    }

    public final void addLast(E e2) {
        d(size() + 1);
        this.f12090b[i(this.a + size())] = e2;
        this.f12091c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int i2 = i(this.a + size());
        int i3 = this.a;
        if (i3 < i2) {
            q.b(this.f12090b, (Object) null, i3, i2);
        } else if (!isEmpty()) {
            Object[] objArr = this.f12090b;
            q.b(objArr, (Object) null, this.a, objArr.length);
            q.b(this.f12090b, (Object) null, 0, i2);
        }
        this.a = 0;
        this.f12091c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i2) {
        d.Companion.a(i2, size());
        return (E) this.f12090b[i(this.a + i2)];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i2;
        int i3 = i(this.a + size());
        int length = this.a;
        if (length < i3) {
            while (length < i3) {
                if (i.q2.t.i0.a(obj, this.f12090b[length])) {
                    i2 = this.a;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < i3) {
            return -1;
        }
        int length2 = this.f12090b.length;
        while (true) {
            if (length >= length2) {
                for (int i4 = 0; i4 < i3; i4++) {
                    if (i.q2.t.i0.a(obj, this.f12090b[i4])) {
                        length = i4 + this.f12090b.length;
                        i2 = this.a;
                    }
                }
                return -1;
            }
            if (i.q2.t.i0.a(obj, this.f12090b[length])) {
                i2 = this.a;
                break;
            }
            length++;
        }
        return length - i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int iU;
        int i2;
        int i3 = i(this.a + size());
        int i4 = this.a;
        if (i4 < i3) {
            iU = i3 - 1;
            if (iU < i4) {
                return -1;
            }
            while (!i.q2.t.i0.a(obj, this.f12090b[iU])) {
                if (iU == i4) {
                    return -1;
                }
                iU--;
            }
            i2 = this.a;
        } else {
            if (i4 <= i3) {
                return -1;
            }
            int i5 = i3 - 1;
            while (true) {
                if (i5 < 0) {
                    iU = r.u(this.f12090b);
                    int i6 = this.a;
                    if (iU < i6) {
                        return -1;
                    }
                    while (!i.q2.t.i0.a(obj, this.f12090b[iU])) {
                        if (iU == i6) {
                            return -1;
                        }
                        iU--;
                    }
                    i2 = this.a;
                } else {
                    if (i.q2.t.i0.a(obj, this.f12090b[i5])) {
                        iU = i5 + this.f12090b.length;
                        i2 = this.a;
                        break;
                    }
                    i5--;
                }
            }
        }
        return iU - i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(@j.c.a.d Collection<? extends Object> collection) {
        i.q2.t.i0.f(collection, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty()) {
            if (!(this.f12090b.length == 0)) {
                int i2 = i(this.a + size());
                int i3 = this.a;
                if (this.a < i2) {
                    for (int i4 = this.a; i4 < i2; i4++) {
                        Object obj = this.f12090b[i4];
                        if (!collection.contains(obj)) {
                            this.f12090b[i3] = obj;
                            i3++;
                        } else {
                            z = true;
                        }
                    }
                    q.b(this.f12090b, (Object) null, i3, i2);
                } else {
                    int length = this.f12090b.length;
                    boolean z2 = false;
                    for (int i5 = this.a; i5 < length; i5++) {
                        Object obj2 = this.f12090b[i5];
                        this.f12090b[i5] = null;
                        if (!collection.contains(obj2)) {
                            this.f12090b[i3] = obj2;
                            i3++;
                        } else {
                            z2 = true;
                        }
                    }
                    i3 = i(i3);
                    for (int i6 = 0; i6 < i2; i6++) {
                        Object obj3 = this.f12090b[i6];
                        this.f12090b[i6] = null;
                        if (!collection.contains(obj3)) {
                            this.f12090b[i3] = obj3;
                            i3 = e(i3);
                        } else {
                            z2 = true;
                        }
                    }
                    z = z2;
                }
                if (z) {
                    this.f12091c = h(i3 - this.a);
                }
            }
        }
        return z;
    }

    public final E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        E e2 = (E) this.f12090b[this.a];
        Object[] objArr = this.f12090b;
        int i2 = this.a;
        objArr[i2] = null;
        this.a = e(i2);
        this.f12091c = size() - 1;
        return e2;
    }

    public final E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        int i2 = i(this.a + y.a((List) this));
        E e2 = (E) this.f12090b[i2];
        this.f12090b[i2] = null;
        this.f12091c = size() - 1;
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(@j.c.a.d Collection<? extends Object> collection) {
        i.q2.t.i0.f(collection, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty()) {
            if (!(this.f12090b.length == 0)) {
                int i2 = i(this.a + size());
                int i3 = this.a;
                if (this.a < i2) {
                    for (int i4 = this.a; i4 < i2; i4++) {
                        Object obj = this.f12090b[i4];
                        if (collection.contains(obj)) {
                            this.f12090b[i3] = obj;
                            i3++;
                        } else {
                            z = true;
                        }
                    }
                    q.b(this.f12090b, (Object) null, i3, i2);
                } else {
                    int length = this.f12090b.length;
                    boolean z2 = false;
                    for (int i5 = this.a; i5 < length; i5++) {
                        Object obj2 = this.f12090b[i5];
                        this.f12090b[i5] = null;
                        if (collection.contains(obj2)) {
                            this.f12090b[i3] = obj2;
                            i3++;
                        } else {
                            z2 = true;
                        }
                    }
                    i3 = i(i3);
                    for (int i6 = 0; i6 < i2; i6++) {
                        Object obj3 = this.f12090b[i6];
                        this.f12090b[i6] = null;
                        if (collection.contains(obj3)) {
                            this.f12090b[i3] = obj3;
                            i3 = e(i3);
                        } else {
                            z2 = true;
                        }
                    }
                    z = z2;
                }
                if (z) {
                    this.f12091c = h(i3 - this.a);
                }
            }
        }
        return z;
    }

    @Override // i.g2.g, java.util.AbstractList, java.util.List
    public E set(int i2, E e2) {
        d.Companion.a(i2, size());
        int i3 = i(this.a + i2);
        E e3 = (E) this.f12090b[i3];
        this.f12090b[i3] = e2;
        return e3;
    }

    private final void d(int i2) {
        if (i2 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f12090b;
        if (i2 <= objArr.length) {
            return;
        }
        if (objArr == m.a) {
            this.f12090b = new Object[i.v2.q.a(i2, 10)];
        } else {
            b(a(this.f12090b.length, i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int e(int i2) {
        if (i2 == r.u(this.f12090b)) {
            return 0;
        }
        return i2 + 1;
    }

    @Override // i.g2.g, java.util.AbstractList, java.util.List
    public void add(int i2, E e2) {
        d.Companion.b(i2, size());
        if (i2 == size()) {
            addLast(e2);
            return;
        }
        if (i2 == 0) {
            addFirst(e2);
            return;
        }
        d(size() + 1);
        int i3 = i(this.a + i2);
        if (i2 < ((size() + 1) >> 1)) {
            int iC = c(i3);
            int iC2 = c(this.a);
            int i4 = this.a;
            if (iC >= i4) {
                Object[] objArr = this.f12090b;
                objArr[iC2] = objArr[i4];
                q.a(objArr, objArr, i4, i4 + 1, iC + 1);
            } else {
                Object[] objArr2 = this.f12090b;
                q.a(objArr2, objArr2, i4 - 1, i4, objArr2.length);
                Object[] objArr3 = this.f12090b;
                objArr3[objArr3.length - 1] = objArr3[0];
                q.a(objArr3, objArr3, 0, 1, iC + 1);
            }
            this.f12090b[iC] = e2;
            this.a = iC2;
        } else {
            int i5 = i(this.a + size());
            if (i3 < i5) {
                Object[] objArr4 = this.f12090b;
                q.a(objArr4, objArr4, i3 + 1, i3, i5);
            } else {
                Object[] objArr5 = this.f12090b;
                q.a(objArr5, objArr5, 1, 0, i5);
                Object[] objArr6 = this.f12090b;
                objArr6[0] = objArr6[objArr6.length - 1];
                q.a(objArr6, objArr6, i3 + 1, i3, objArr6.length - 1);
            }
            this.f12090b[i3] = e2;
        }
        this.f12091c = size() + 1;
    }

    @j.c.a.e
    public final E f() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    @j.c.a.e
    public final E g() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    private final void b(int i2) {
        Object[] objArr = new Object[i2];
        Object[] objArr2 = this.f12090b;
        q.a(objArr2, objArr, 0, this.a, objArr2.length);
        Object[] objArr3 = this.f12090b;
        int length = objArr3.length;
        int i3 = this.a;
        q.a(objArr3, objArr, length - i3, 0, i3);
        this.a = 0;
        this.f12090b = objArr;
    }

    private final int c(int i2) {
        return i2 == 0 ? r.u(this.f12090b) : i2 - 1;
    }

    @j.c.a.e
    public final E e() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.f12090b[i(this.a + y.a((List) this))];
    }

    @Override // i.g2.g
    public int a() {
        return this.f12091c;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i2, @j.c.a.d Collection<? extends E> collection) {
        i.q2.t.i0.f(collection, "elements");
        d.Companion.b(i2, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (i2 == size()) {
            return addAll(collection);
        }
        d(size() + collection.size());
        int i3 = i(this.a + size());
        int i4 = i(this.a + i2);
        int size = collection.size();
        if (i2 < ((size() + 1) >> 1)) {
            int i5 = this.a;
            int length = i5 - size;
            if (i4 < i5) {
                Object[] objArr = this.f12090b;
                q.a(objArr, objArr, length, i5, objArr.length);
                if (size >= i4) {
                    Object[] objArr2 = this.f12090b;
                    q.a(objArr2, objArr2, objArr2.length - size, 0, i4);
                } else {
                    Object[] objArr3 = this.f12090b;
                    q.a(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f12090b;
                    q.a(objArr4, objArr4, 0, size, i4);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.f12090b;
                q.a(objArr5, objArr5, length, i5, i4);
            } else {
                Object[] objArr6 = this.f12090b;
                length += objArr6.length;
                int i6 = i4 - i5;
                int length2 = objArr6.length - length;
                if (length2 >= i6) {
                    q.a(objArr6, objArr6, length, i5, i4);
                } else {
                    q.a(objArr6, objArr6, length, i5, i5 + length2);
                    Object[] objArr7 = this.f12090b;
                    q.a(objArr7, objArr7, 0, this.a + length2, i4);
                }
            }
            this.a = length;
            a(h(i4 - size), collection);
        } else {
            int i7 = i4 + size;
            if (i4 < i3) {
                int i8 = size + i3;
                Object[] objArr8 = this.f12090b;
                if (i8 <= objArr8.length) {
                    q.a(objArr8, objArr8, i7, i4, i3);
                } else if (i7 >= objArr8.length) {
                    q.a(objArr8, objArr8, i7 - objArr8.length, i4, i3);
                } else {
                    int length3 = i3 - (i8 - objArr8.length);
                    q.a(objArr8, objArr8, 0, length3, i3);
                    Object[] objArr9 = this.f12090b;
                    q.a(objArr9, objArr9, i7, i4, length3);
                }
            } else {
                Object[] objArr10 = this.f12090b;
                q.a(objArr10, objArr10, size, 0, i3);
                Object[] objArr11 = this.f12090b;
                if (i7 >= objArr11.length) {
                    q.a(objArr11, objArr11, i7 - objArr11.length, i4, objArr11.length);
                } else {
                    q.a(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f12090b;
                    q.a(objArr12, objArr12, i7, i4, objArr12.length - size);
                }
            }
            a(i4, collection);
        }
        return true;
    }

    @j.c.a.e
    public final E c() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.f12090b[this.a];
    }

    private final void a(int i2, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.f12090b.length;
        while (i2 < length && it.hasNext()) {
            this.f12090b[i2] = it.next();
            i2++;
        }
        int i3 = this.a;
        for (int i4 = 0; i4 < i3 && it.hasNext(); i4++) {
            this.f12090b[i4] = it.next();
        }
        this.f12091c = size() + collection.size();
    }

    public l() {
        this.f12090b = m.a;
    }

    public l(@j.c.a.d Collection<? extends E> collection) {
        i.q2.t.i0.f(collection, "elements");
        Object[] array = collection.toArray(new Object[0]);
        if (array != null) {
            this.f12090b = array;
            Object[] objArr = this.f12090b;
            this.f12091c = objArr.length;
            if (objArr.length == 0) {
                this.f12090b = m.a;
                return;
            }
            return;
        }
        throw new i.e1("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final E b() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.f12090b[this.a];
    }

    public final E d() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.f12090b[i(this.a + y.a((List) this))];
    }

    @Override // i.g2.g
    public E a(int i2) {
        d.Companion.a(i2, size());
        if (i2 == y.a((List) this)) {
            return removeLast();
        }
        if (i2 != 0) {
            int i3 = i(this.a + i2);
            E e2 = (E) this.f12090b[i3];
            if (i2 < (size() >> 1)) {
                int i4 = this.a;
                if (i3 >= i4) {
                    Object[] objArr = this.f12090b;
                    q.a(objArr, objArr, i4 + 1, i4, i3);
                } else {
                    Object[] objArr2 = this.f12090b;
                    q.a(objArr2, objArr2, 1, 0, i3);
                    Object[] objArr3 = this.f12090b;
                    objArr3[0] = objArr3[objArr3.length - 1];
                    int i5 = this.a;
                    q.a(objArr3, objArr3, i5 + 1, i5, objArr3.length - 1);
                }
                Object[] objArr4 = this.f12090b;
                int i6 = this.a;
                objArr4[i6] = null;
                this.a = e(i6);
            } else {
                int i7 = i(this.a + y.a((List) this));
                if (i3 <= i7) {
                    Object[] objArr5 = this.f12090b;
                    q.a(objArr5, objArr5, i3, i3 + 1, i7 + 1);
                } else {
                    Object[] objArr6 = this.f12090b;
                    q.a(objArr6, objArr6, i3, i3 + 1, objArr6.length);
                    Object[] objArr7 = this.f12090b;
                    objArr7[objArr7.length - 1] = objArr7[0];
                    q.a(objArr7, objArr7, 0, 1, i7 + 1);
                }
                this.f12090b[i7] = null;
            }
            this.f12091c = size() - 1;
            return e2;
        }
        return removeFirst();
    }

    private final boolean a(i.q2.s.l<? super E, Boolean> lVar) {
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty()) {
            if (!(this.f12090b.length == 0)) {
                int i2 = i(this.a + size());
                int i3 = this.a;
                if (this.a < i2) {
                    for (int i4 = this.a; i4 < i2; i4++) {
                        Object obj = this.f12090b[i4];
                        if (lVar.invoke(obj).booleanValue()) {
                            this.f12090b[i3] = obj;
                            i3++;
                        } else {
                            z = true;
                        }
                    }
                    q.b(this.f12090b, (Object) null, i3, i2);
                } else {
                    int length = this.f12090b.length;
                    boolean z2 = false;
                    for (int i5 = this.a; i5 < length; i5++) {
                        Object obj2 = this.f12090b[i5];
                        this.f12090b[i5] = null;
                        if (lVar.invoke(obj2).booleanValue()) {
                            this.f12090b[i3] = obj2;
                            i3++;
                        } else {
                            z2 = true;
                        }
                    }
                    i3 = i(i3);
                    for (int i6 = 0; i6 < i2; i6++) {
                        Object obj3 = this.f12090b[i6];
                        this.f12090b[i6] = null;
                        if (lVar.invoke(obj3).booleanValue()) {
                            this.f12090b[i3] = obj3;
                            i3 = e(i3);
                        } else {
                            z2 = true;
                        }
                    }
                    z = z2;
                }
                if (z) {
                    this.f12091c = h(i3 - this.a);
                }
            }
        }
        return z;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, java.lang.Object[]] */
    public final void a(@j.c.a.d i.q2.s.p<? super Integer, ? super Object[], i.y1> pVar) {
        i.q2.t.i0.f(pVar, "structure");
        int i2 = i(this.a + size());
        if (isEmpty()) {
            pVar.invoke(Integer.valueOf(this.a), new Object[0]);
            return;
        }
        ?? r0 = new Object[size()];
        int i3 = this.a;
        if (i3 < i2) {
            q.a(this.f12090b, (Object[]) r0, 0, i3, i2, 2, (Object) null);
            pVar.invoke(Integer.valueOf(this.a), r0);
        } else {
            q.a(this.f12090b, (Object[]) r0, 0, i3, 0, 10, (Object) null);
            Object[] objArr = this.f12090b;
            q.a(objArr, (Object[]) r0, objArr.length - this.a, 0, i2);
            pVar.invoke(Integer.valueOf(this.a - this.f12090b.length), r0);
        }
    }
}
