package p286h;

import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import p286h.p289g2.AbstractC5314x1;
import p286h.p289g2.C5294r;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5584u;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: UIntArray.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0014\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006B\u0014\b\u0001\u0012\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\tJ\u001b\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\u001b\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0004H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J\u000f\u0010\u001f\u001a\u00020\u000fH\u0016¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020#H\u0096\u0002¢\u0006\u0004\b$\u0010%J#\u0010&\u001a\u00020'2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0002H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\t\u0010+\u001a\u00020,HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006."}, m23546d2 = {"Lkotlin/UIntArray;", "", "Lkotlin/UInt;", "size", "", "constructor-impl", "(I)[I", "storage", "", "([I)[I", "getSize-impl", "([I)I", "storage$annotations", "()V", "contains", "", "element", "contains-WZ4Q5Ns", "([II)Z", "containsAll", "elements", "containsAll-impl", "([ILjava/util/Collection;)Z", "equals", DispatchConstants.OTHER, "", "get", "index", "get-impl", "([II)I", "hashCode", "isEmpty", "isEmpty-impl", "([I)Z", "iterator", "Lkotlin/collections/UIntIterator;", "iterator-impl", "([I)Lkotlin/collections/UIntIterator;", "set", "", SurveyH5Bean.VALUE, "set-VXSXFK8", "([III)V", "toString", "", "Iterator", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
@InterfaceC5610t0(version = "1.3")
@InterfaceC5352k
/* renamed from: h.k1 */
/* loaded from: classes2.dex */
public final class C5354k1 implements Collection<C5341j1>, InterfaceC5569a {

    /* renamed from: a */
    @InterfaceC5816d
    private final int[] f20226a;

    /* compiled from: UIntArray.kt */
    /* renamed from: h.k1$a */
    private static final class a extends AbstractC5314x1 {

        /* renamed from: a */
        private int f20227a;

        /* renamed from: b */
        private final int[] f20228b;

        public a(@InterfaceC5816d int[] iArr) {
            C5544i0.m22546f(iArr, "array");
            this.f20228b = iArr;
        }

        @Override // p286h.p289g2.AbstractC5314x1
        /* renamed from: b */
        public int mo21756b() {
            int i2 = this.f20227a;
            int[] iArr = this.f20228b;
            if (i2 >= iArr.length) {
                throw new NoSuchElementException(String.valueOf(i2));
            }
            this.f20227a = i2 + 1;
            return C5341j1.m21929c(iArr[i2]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f20227a < this.f20228b.length;
        }
    }

    @InterfaceC5440n0
    private /* synthetic */ C5354k1(@InterfaceC5816d int[] iArr) {
        C5544i0.m22546f(iArr, "storage");
        this.f20226a = iArr;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final /* synthetic */ C5354k1 m21976a(@InterfaceC5816d int[] iArr) {
        C5544i0.m22546f(iArr, "v");
        return new C5354k1(iArr);
    }

    /* renamed from: a */
    public static final void m21977a(int[] iArr, int i2, int i3) {
        iArr[i2] = i3;
    }

    /* renamed from: a */
    public static boolean m21979a(int[] iArr, @InterfaceC5817e Object obj) {
        return (obj instanceof C5354k1) && C5544i0.m22531a(iArr, ((C5354k1) obj).m21994c());
    }

    /* renamed from: a */
    public static final boolean m21981a(@InterfaceC5816d int[] iArr, @InterfaceC5816d int[] iArr2) {
        return C5544i0.m22531a(iArr, iArr2);
    }

    @InterfaceC5440n0
    @InterfaceC5816d
    /* renamed from: b */
    public static int[] m21983b(@InterfaceC5816d int[] iArr) {
        C5544i0.m22546f(iArr, "storage");
        return iArr;
    }

    @InterfaceC5816d
    /* renamed from: c */
    public static int[] m21985c(int i2) {
        return m21983b(new int[i2]);
    }

    /* renamed from: d */
    public static int m21986d(int[] iArr) {
        if (iArr != null) {
            return Arrays.hashCode(iArr);
        }
        return 0;
    }

    @InterfaceC5440n0
    /* renamed from: d */
    public static /* synthetic */ void m21987d() {
    }

    /* renamed from: e */
    public static boolean m21988e(int[] iArr) {
        return iArr.length == 0;
    }

    @InterfaceC5816d
    /* renamed from: f */
    public static AbstractC5314x1 m21989f(int[] iArr) {
        return new a(iArr);
    }

    @InterfaceC5816d
    /* renamed from: g */
    public static String m21990g(int[] iArr) {
        return "UIntArray(storage=" + Arrays.toString(iArr) + ")";
    }

    /* renamed from: a */
    public boolean m21991a(int i2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* synthetic */ boolean add(C5341j1 c5341j1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends C5341j1> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: b */
    public boolean m21993b(int i2) {
        return m21978a(this.f20226a, i2);
    }

    @InterfaceC5816d
    /* renamed from: c */
    public final /* synthetic */ int[] m21994c() {
        return this.f20226a;
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof C5341j1) {
            return m21993b(((C5341j1) obj).m21968a());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@InterfaceC5816d Collection<? extends Object> collection) {
        return m21980a(this.f20226a, (Collection<C5341j1>) collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return m21979a(this.f20226a, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m21986d(this.f20226a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m21988e(this.f20226a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @InterfaceC5816d
    public AbstractC5314x1 iterator() {
        return m21989f(this.f20226a);
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
        return m21992b();
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
        return m21990g(this.f20226a);
    }

    /* renamed from: a */
    public static boolean m21978a(int[] iArr, int i2) {
        return C5294r.m20837a(iArr, i2);
    }

    /* renamed from: c */
    public static int m21984c(int[] iArr) {
        return iArr.length;
    }

    /* renamed from: b */
    public int m21992b() {
        return m21984c(this.f20226a);
    }

    /* renamed from: a */
    public static boolean m21980a(int[] iArr, @InterfaceC5816d Collection<C5341j1> collection) {
        C5544i0.m22546f(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!((obj instanceof C5341j1) && C5294r.m20837a(iArr, ((C5341j1) obj).m21968a()))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static final int m21982b(int[] iArr, int i2) {
        return C5341j1.m21929c(iArr[i2]);
    }
}
