package p286h;

import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import p286h.p289g2.AbstractC5317y1;
import p286h.p289g2.C5294r;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5584u;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: ULongArray.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0014\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006B\u0014\b\u0001\u0012\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\tJ\u001b\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\u001b\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0004H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J\u000f\u0010\u001f\u001a\u00020\u000fH\u0016¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020#H\u0096\u0002¢\u0006\u0004\b$\u0010%J#\u0010&\u001a\u00020'2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0002H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\t\u0010+\u001a\u00020,HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006."}, m23546d2 = {"Lkotlin/ULongArray;", "", "Lkotlin/ULong;", "size", "", "constructor-impl", "(I)[J", "storage", "", "([J)[J", "getSize-impl", "([J)I", "storage$annotations", "()V", "contains", "", "element", "contains-VKZWuLQ", "([JJ)Z", "containsAll", "elements", "containsAll-impl", "([JLjava/util/Collection;)Z", "equals", DispatchConstants.OTHER, "", "get", "index", "get-impl", "([JI)J", "hashCode", "isEmpty", "isEmpty-impl", "([J)Z", "iterator", "Lkotlin/collections/ULongIterator;", "iterator-impl", "([J)Lkotlin/collections/ULongIterator;", "set", "", SurveyH5Bean.VALUE, "set-k8EXiF4", "([JIJ)V", "toString", "", "Iterator", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
@InterfaceC5610t0(version = "1.3")
@InterfaceC5352k
/* renamed from: h.o1 */
/* loaded from: classes2.dex */
public final class C5468o1 implements Collection<C5441n1>, InterfaceC5569a {

    /* renamed from: a */
    @InterfaceC5816d
    private final long[] f20346a;

    /* compiled from: ULongArray.kt */
    /* renamed from: h.o1$a */
    private static final class a extends AbstractC5317y1 {

        /* renamed from: a */
        private int f20347a;

        /* renamed from: b */
        private final long[] f20348b;

        public a(@InterfaceC5816d long[] jArr) {
            C5544i0.m22546f(jArr, "array");
            this.f20348b = jArr;
        }

        @Override // p286h.p289g2.AbstractC5317y1
        /* renamed from: b */
        public long mo21795b() {
            int i2 = this.f20347a;
            long[] jArr = this.f20348b;
            if (i2 >= jArr.length) {
                throw new NoSuchElementException(String.valueOf(i2));
            }
            this.f20347a = i2 + 1;
            return C5441n1.m22205c(jArr[i2]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f20347a < this.f20348b.length;
        }
    }

    @InterfaceC5440n0
    private /* synthetic */ C5468o1(@InterfaceC5816d long[] jArr) {
        C5544i0.m22546f(jArr, "storage");
        this.f20346a = jArr;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final /* synthetic */ C5468o1 m22415a(@InterfaceC5816d long[] jArr) {
        C5544i0.m22546f(jArr, "v");
        return new C5468o1(jArr);
    }

    /* renamed from: a */
    public static boolean m22418a(long[] jArr, @InterfaceC5817e Object obj) {
        return (obj instanceof C5468o1) && C5544i0.m22531a(jArr, ((C5468o1) obj).m22432c());
    }

    /* renamed from: a */
    public static final boolean m22420a(@InterfaceC5816d long[] jArr, @InterfaceC5816d long[] jArr2) {
        return C5544i0.m22531a(jArr, jArr2);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static long[] m22421a(int i2) {
        return m22422b(new long[i2]);
    }

    @InterfaceC5440n0
    @InterfaceC5816d
    /* renamed from: b */
    public static long[] m22422b(@InterfaceC5816d long[] jArr) {
        C5544i0.m22546f(jArr, "storage");
        return jArr;
    }

    /* renamed from: c */
    public static int m22423c(long[] jArr) {
        return jArr.length;
    }

    /* renamed from: d */
    public static int m22424d(long[] jArr) {
        if (jArr != null) {
            return Arrays.hashCode(jArr);
        }
        return 0;
    }

    @InterfaceC5440n0
    /* renamed from: d */
    public static /* synthetic */ void m22425d() {
    }

    /* renamed from: e */
    public static boolean m22426e(long[] jArr) {
        return jArr.length == 0;
    }

    @InterfaceC5816d
    /* renamed from: f */
    public static AbstractC5317y1 m22427f(long[] jArr) {
        return new a(jArr);
    }

    @InterfaceC5816d
    /* renamed from: g */
    public static String m22428g(long[] jArr) {
        return "ULongArray(storage=" + Arrays.toString(jArr) + ")";
    }

    /* renamed from: a */
    public boolean m22429a(long j2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* synthetic */ boolean add(C5441n1 c5441n1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends C5441n1> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: b */
    public boolean m22431b(long j2) {
        return m22417a(this.f20346a, j2);
    }

    @InterfaceC5816d
    /* renamed from: c */
    public final /* synthetic */ long[] m22432c() {
        return this.f20346a;
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof C5441n1) {
            return m22431b(((C5441n1) obj).m22244a());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@InterfaceC5816d Collection<? extends Object> collection) {
        return m22419a(this.f20346a, (Collection<C5441n1>) collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return m22418a(this.f20346a, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m22424d(this.f20346a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m22426e(this.f20346a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @InterfaceC5816d
    public AbstractC5317y1 iterator() {
        return m22427f(this.f20346a);
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
        return m22430b();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return C5584u.m22686a(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) C5584u.m22688a(this, tArr);
    }

    public String toString() {
        return m22428g(this.f20346a);
    }

    /* renamed from: a */
    public static final long m22414a(long[] jArr, int i2) {
        return C5441n1.m22205c(jArr[i2]);
    }

    /* renamed from: b */
    public int m22430b() {
        return m22423c(this.f20346a);
    }

    /* renamed from: a */
    public static final void m22416a(long[] jArr, int i2, long j2) {
        jArr[i2] = j2;
    }

    /* renamed from: a */
    public static boolean m22417a(long[] jArr, long j2) {
        return C5294r.m20994b(jArr, j2);
    }

    /* renamed from: a */
    public static boolean m22419a(long[] jArr, @InterfaceC5816d Collection<C5441n1> collection) {
        C5544i0.m22546f(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!((obj instanceof C5441n1) && C5294r.m20994b(jArr, ((C5441n1) obj).m22244a()))) {
                return false;
            }
        }
        return true;
    }
}
