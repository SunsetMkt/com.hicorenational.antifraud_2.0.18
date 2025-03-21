package p286h;

import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import p286h.p289g2.AbstractC5320z1;
import p286h.p289g2.C5294r;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5584u;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: UShortArray.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0017\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0014\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006B\u0014\b\u0001\u0012\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\tJ\u001b\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\u001b\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0004H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J\u000f\u0010\u001f\u001a\u00020\u000fH\u0016¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020#H\u0096\u0002¢\u0006\u0004\b$\u0010%J#\u0010&\u001a\u00020'2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0002H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\t\u0010+\u001a\u00020,HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006."}, m23546d2 = {"Lkotlin/UShortArray;", "", "Lkotlin/UShort;", "size", "", "constructor-impl", "(I)[S", "storage", "", "([S)[S", "getSize-impl", "([S)I", "storage$annotations", "()V", "contains", "", "element", "contains-xj2QHRw", "([SS)Z", "containsAll", "elements", "containsAll-impl", "([SLjava/util/Collection;)Z", "equals", DispatchConstants.OTHER, "", "get", "index", "get-impl", "([SI)S", "hashCode", "isEmpty", "isEmpty-impl", "([S)Z", "iterator", "Lkotlin/collections/UShortIterator;", "iterator-impl", "([S)Lkotlin/collections/UShortIterator;", "set", "", SurveyH5Bean.VALUE, "set-01HTLdE", "([SIS)V", "toString", "", "Iterator", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
@InterfaceC5610t0(version = "1.3")
@InterfaceC5352k
/* renamed from: h.u1 */
/* loaded from: classes2.dex */
public final class C5619u1 implements Collection<C5611t1>, InterfaceC5569a {

    /* renamed from: a */
    @InterfaceC5816d
    private final short[] f20479a;

    /* compiled from: UShortArray.kt */
    /* renamed from: h.u1$a */
    private static final class a extends AbstractC5320z1 {

        /* renamed from: a */
        private int f20480a;

        /* renamed from: b */
        private final short[] f20481b;

        public a(@InterfaceC5816d short[] sArr) {
            C5544i0.m22546f(sArr, "array");
            this.f20481b = sArr;
        }

        @Override // p286h.p289g2.AbstractC5320z1
        /* renamed from: b */
        public short mo21806b() {
            int i2 = this.f20480a;
            short[] sArr = this.f20481b;
            if (i2 >= sArr.length) {
                throw new NoSuchElementException(String.valueOf(i2));
            }
            this.f20480a = i2 + 1;
            return C5611t1.m22880c(sArr[i2]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f20480a < this.f20481b.length;
        }
    }

    @InterfaceC5440n0
    private /* synthetic */ C5619u1(@InterfaceC5816d short[] sArr) {
        C5544i0.m22546f(sArr, "storage");
        this.f20479a = sArr;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final /* synthetic */ C5619u1 m22924a(@InterfaceC5816d short[] sArr) {
        C5544i0.m22546f(sArr, "v");
        return new C5619u1(sArr);
    }

    /* renamed from: a */
    public static boolean m22927a(short[] sArr, @InterfaceC5817e Object obj) {
        return (obj instanceof C5619u1) && C5544i0.m22531a(sArr, ((C5619u1) obj).m22942c());
    }

    /* renamed from: a */
    public static final boolean m22930a(@InterfaceC5816d short[] sArr, @InterfaceC5816d short[] sArr2) {
        return C5544i0.m22531a(sArr, sArr2);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static short[] m22931a(int i2) {
        return m22932b(new short[i2]);
    }

    @InterfaceC5440n0
    @InterfaceC5816d
    /* renamed from: b */
    public static short[] m22932b(@InterfaceC5816d short[] sArr) {
        C5544i0.m22546f(sArr, "storage");
        return sArr;
    }

    /* renamed from: c */
    public static int m22933c(short[] sArr) {
        return sArr.length;
    }

    /* renamed from: d */
    public static int m22934d(short[] sArr) {
        if (sArr != null) {
            return Arrays.hashCode(sArr);
        }
        return 0;
    }

    @InterfaceC5440n0
    /* renamed from: d */
    public static /* synthetic */ void m22935d() {
    }

    /* renamed from: e */
    public static boolean m22936e(short[] sArr) {
        return sArr.length == 0;
    }

    @InterfaceC5816d
    /* renamed from: f */
    public static AbstractC5320z1 m22937f(short[] sArr) {
        return new a(sArr);
    }

    @InterfaceC5816d
    /* renamed from: g */
    public static String m22938g(short[] sArr) {
        return "UShortArray(storage=" + Arrays.toString(sArr) + ")";
    }

    /* renamed from: a */
    public boolean m22939a(short s) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* synthetic */ boolean add(C5611t1 c5611t1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends C5611t1> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: b */
    public boolean m22941b(short s) {
        return m22929a(this.f20479a, s);
    }

    @InterfaceC5816d
    /* renamed from: c */
    public final /* synthetic */ short[] m22942c() {
        return this.f20479a;
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof C5611t1) {
            return m22941b(((C5611t1) obj).m22913a());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@InterfaceC5816d Collection<? extends Object> collection) {
        return m22928a(this.f20479a, (Collection<C5611t1>) collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return m22927a(this.f20479a, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m22934d(this.f20479a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m22936e(this.f20479a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @InterfaceC5816d
    public AbstractC5320z1 iterator() {
        return m22937f(this.f20479a);
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
        return m22940b();
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
        return m22938g(this.f20479a);
    }

    /* renamed from: a */
    public static final short m22925a(short[] sArr, int i2) {
        return C5611t1.m22880c(sArr[i2]);
    }

    /* renamed from: b */
    public int m22940b() {
        return m22933c(this.f20479a);
    }

    /* renamed from: a */
    public static final void m22926a(short[] sArr, int i2, short s) {
        sArr[i2] = s;
    }

    /* renamed from: a */
    public static boolean m22929a(short[] sArr, short s) {
        return C5294r.m21000b(sArr, s);
    }

    /* renamed from: a */
    public static boolean m22928a(short[] sArr, @InterfaceC5816d Collection<C5611t1> collection) {
        C5544i0.m22546f(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!((obj instanceof C5611t1) && C5294r.m21000b(sArr, ((C5611t1) obj).m22913a()))) {
                return false;
            }
        }
        return true;
    }
}
