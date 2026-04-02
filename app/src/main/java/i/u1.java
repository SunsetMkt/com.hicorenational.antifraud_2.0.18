package i;

import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: UShortArray.kt */
/* JADX INFO: loaded from: classes2.dex */
@t0(version = "1.3")
@y(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0017\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0014\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006B\u0014\b\u0001\u0012\u0006\u0010\u0007\u001a\u00020\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\tJ\u001b\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u00d6\u0003J\u001b\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0004H\u0086\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u001e\u001a\u00020\u0004H\u00d6\u0001J\u000f\u0010\u001f\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020#H\u0096\u0002\u00a2\u0006\u0004\b$\u0010%J#\u0010&\u001a\u00020'2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0002H\u0086\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b)\u0010*J\t\u0010+\u001a\u00020,H\u00d6\u0001R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\f\u0010\r\u00f8\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006."}, d2 = {"Lkotlin/UShortArray;", "", "Lkotlin/UShort;", "size", "", "constructor-impl", "(I)[S", "storage", "", "([S)[S", "getSize-impl", "([S)I", "storage$annotations", "()V", "contains", "", "element", "contains-xj2QHRw", "([SS)Z", "containsAll", "elements", "containsAll-impl", "([SLjava/util/Collection;)Z", "equals", DispatchConstants.OTHER, "", "get", "index", "get-impl", "([SI)S", "hashCode", "isEmpty", "isEmpty-impl", "([S)Z", "iterator", "Lkotlin/collections/UShortIterator;", "iterator-impl", "([S)Lkotlin/collections/UShortIterator;", "set", "", SurveyH5Bean.VALUE, "set-01HTLdE", "([SIS)V", "toString", "", "Iterator", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
@k
public final class u1 implements Collection<t1>, i.q2.t.q1.a {

    @j.c.a.d
    private final short[] a;

    /* JADX INFO: compiled from: UShortArray.kt */
    private static final class a extends i.g2.z1 {
        private int a;

        /* JADX INFO: renamed from: b */
        private final short[] f12283b;

        public a(@j.c.a.d short[] sArr) {
            i.q2.t.i0.f(sArr, "array");
            this.f12283b = sArr;
        }

        @Override // i.g2.z1
        public short b() {
            int i2 = this.a;
            short[] sArr = this.f12283b;
            if (i2 >= sArr.length) {
                throw new NoSuchElementException(String.valueOf(i2));
            }
            this.a = i2 + 1;
            return t1.c(sArr[i2]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < this.f12283b.length;
        }
    }

    @n0
    private /* synthetic */ u1(@j.c.a.d short[] sArr) {
        i.q2.t.i0.f(sArr, "storage");
        this.a = sArr;
    }

    @j.c.a.d
    public static final /* synthetic */ u1 a(@j.c.a.d short[] sArr) {
        i.q2.t.i0.f(sArr, "v");
        return new u1(sArr);
    }

    public static boolean a(short[] sArr, @j.c.a.e Object obj) {
        return (obj instanceof u1) && i.q2.t.i0.a(sArr, ((u1) obj).c());
    }

    public static final boolean a(@j.c.a.d short[] sArr, @j.c.a.d short[] sArr2) {
        return i.q2.t.i0.a(sArr, sArr2);
    }

    @j.c.a.d
    public static short[] a(int i2) {
        return b(new short[i2]);
    }

    @n0
    @j.c.a.d
    public static short[] b(@j.c.a.d short[] sArr) {
        i.q2.t.i0.f(sArr, "storage");
        return sArr;
    }

    public static int c(short[] sArr) {
        return sArr.length;
    }

    public static int d(short[] sArr) {
        if (sArr != null) {
            return Arrays.hashCode(sArr);
        }
        return 0;
    }

    @n0
    public static /* synthetic */ void d() {
    }

    public static boolean e(short[] sArr) {
        return sArr.length == 0;
    }

    @j.c.a.d
    public static i.g2.z1 f(short[] sArr) {
        return new a(sArr);
    }

    @j.c.a.d
    public static String g(short[] sArr) {
        return "UShortArray(storage=" + Arrays.toString(sArr) + ")";
    }

    public boolean a(short s) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* synthetic */ boolean add(t1 t1Var) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends t1> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean b(short s) {
        return a(this.a, s);
    }

    @j.c.a.d
    public final /* synthetic */ short[] c() {
        return this.a;
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof t1) {
            return b(((t1) obj).a());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@j.c.a.d Collection<? extends Object> collection) {
        return a(this.a, (Collection<t1>) collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return a(this.a, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return d(this.a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return e(this.a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @j.c.a.d
    public i.g2.z1 iterator() {
        return f(this.a);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return b();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return i.q2.t.u.a(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) i.q2.t.u.a(this, tArr);
    }

    public String toString() {
        return g(this.a);
    }

    public static final short a(short[] sArr, int i2) {
        return t1.c(sArr[i2]);
    }

    public int b() {
        return c(this.a);
    }

    public static final void a(short[] sArr, int i2, short s) {
        sArr[i2] = s;
    }

    public static boolean a(short[] sArr, short s) {
        return i.g2.r.b(sArr, s);
    }

    public static boolean a(short[] sArr, @j.c.a.d Collection<t1> collection) {
        i.q2.t.i0.f(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!((obj instanceof t1) && i.g2.r.b(sArr, ((t1) obj).a()))) {
                return false;
            }
        }
        return true;
    }
}
