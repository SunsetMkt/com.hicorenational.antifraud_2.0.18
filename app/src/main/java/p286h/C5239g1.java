package p286h;

import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import p286h.p289g2.AbstractC5305u1;
import p286h.p289g2.C5294r;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5584u;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: UByteArray.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0014\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006B\u0014\b\u0001\u0012\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\tJ\u001b\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\u001b\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0004H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J\u000f\u0010\u001f\u001a\u00020\u000fH\u0016¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020#H\u0096\u0002¢\u0006\u0004\b$\u0010%J#\u0010&\u001a\u00020'2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0002H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\t\u0010+\u001a\u00020,HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006."}, m23546d2 = {"Lkotlin/UByteArray;", "", "Lkotlin/UByte;", "size", "", "constructor-impl", "(I)[B", "storage", "", "([B)[B", "getSize-impl", "([B)I", "storage$annotations", "()V", "contains", "", "element", "contains-7apg3OU", "([BB)Z", "containsAll", "elements", "containsAll-impl", "([BLjava/util/Collection;)Z", "equals", DispatchConstants.OTHER, "", "get", "index", "get-impl", "([BI)B", "hashCode", "isEmpty", "isEmpty-impl", "([B)Z", "iterator", "Lkotlin/collections/UByteIterator;", "iterator-impl", "([B)Lkotlin/collections/UByteIterator;", "set", "", SurveyH5Bean.VALUE, "set-VurrAj0", "([BIB)V", "toString", "", "Iterator", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
@InterfaceC5610t0(version = "1.3")
@InterfaceC5352k
/* renamed from: h.g1 */
/* loaded from: classes2.dex */
public final class C5239g1 implements Collection<C5230f1>, InterfaceC5569a {

    /* renamed from: a */
    @InterfaceC5816d
    private final byte[] f20092a;

    /* compiled from: UByteArray.kt */
    /* renamed from: h.g1$a */
    private static final class a extends AbstractC5305u1 {

        /* renamed from: a */
        private int f20093a;

        /* renamed from: b */
        private final byte[] f20094b;

        public a(@InterfaceC5816d byte[] bArr) {
            C5544i0.m22546f(bArr, "array");
            this.f20094b = bArr;
        }

        @Override // p286h.p289g2.AbstractC5305u1
        /* renamed from: b */
        public byte mo18992b() {
            int i2 = this.f20093a;
            byte[] bArr = this.f20094b;
            if (i2 >= bArr.length) {
                throw new NoSuchElementException(String.valueOf(i2));
            }
            this.f20093a = i2 + 1;
            return C5230f1.m18929c(bArr[i2]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f20093a < this.f20094b.length;
        }
    }

    @InterfaceC5440n0
    private /* synthetic */ C5239g1(@InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(bArr, "storage");
        this.f20092a = bArr;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final /* synthetic */ C5239g1 m18974a(@InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(bArr, "v");
        return new C5239g1(bArr);
    }

    /* renamed from: a */
    public static boolean m18977a(byte[] bArr, @InterfaceC5817e Object obj) {
        return (obj instanceof C5239g1) && C5544i0.m22531a(bArr, ((C5239g1) obj).m18991c());
    }

    /* renamed from: a */
    public static final boolean m18979a(@InterfaceC5816d byte[] bArr, @InterfaceC5816d byte[] bArr2) {
        return C5544i0.m22531a(bArr, bArr2);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static byte[] m18980a(int i2) {
        return m18981b(new byte[i2]);
    }

    @InterfaceC5440n0
    @InterfaceC5816d
    /* renamed from: b */
    public static byte[] m18981b(@InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(bArr, "storage");
        return bArr;
    }

    /* renamed from: c */
    public static int m18982c(byte[] bArr) {
        return bArr.length;
    }

    /* renamed from: d */
    public static int m18983d(byte[] bArr) {
        if (bArr != null) {
            return Arrays.hashCode(bArr);
        }
        return 0;
    }

    @InterfaceC5440n0
    /* renamed from: d */
    public static /* synthetic */ void m18984d() {
    }

    /* renamed from: e */
    public static boolean m18985e(byte[] bArr) {
        return bArr.length == 0;
    }

    @InterfaceC5816d
    /* renamed from: f */
    public static AbstractC5305u1 m18986f(byte[] bArr) {
        return new a(bArr);
    }

    @InterfaceC5816d
    /* renamed from: g */
    public static String m18987g(byte[] bArr) {
        return "UByteArray(storage=" + Arrays.toString(bArr) + ")";
    }

    /* renamed from: a */
    public boolean m18988a(byte b2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* synthetic */ boolean add(C5230f1 c5230f1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends C5230f1> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: b */
    public boolean m18990b(byte b2) {
        return m18976a(this.f20092a, b2);
    }

    @InterfaceC5816d
    /* renamed from: c */
    public final /* synthetic */ byte[] m18991c() {
        return this.f20092a;
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof C5230f1) {
            return m18990b(((C5230f1) obj).m18966a());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@InterfaceC5816d Collection<? extends Object> collection) {
        return m18978a(this.f20092a, (Collection<C5230f1>) collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return m18977a(this.f20092a, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m18983d(this.f20092a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m18985e(this.f20092a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @InterfaceC5816d
    public AbstractC5305u1 iterator() {
        return m18986f(this.f20092a);
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
        return m18989b();
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
        return m18987g(this.f20092a);
    }

    /* renamed from: a */
    public static final byte m18973a(byte[] bArr, int i2) {
        return C5230f1.m18929c(bArr[i2]);
    }

    /* renamed from: b */
    public int m18989b() {
        return m18982c(this.f20092a);
    }

    /* renamed from: a */
    public static final void m18975a(byte[] bArr, int i2, byte b2) {
        bArr[i2] = b2;
    }

    /* renamed from: a */
    public static boolean m18976a(byte[] bArr, byte b2) {
        return C5294r.m20980b(bArr, b2);
    }

    /* renamed from: a */
    public static boolean m18978a(byte[] bArr, @InterfaceC5816d Collection<C5230f1> collection) {
        C5544i0.m22546f(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!((obj instanceof C5230f1) && C5294r.m20980b(bArr, ((C5230f1) obj).m18966a()))) {
                return false;
            }
        }
        return true;
    }
}
