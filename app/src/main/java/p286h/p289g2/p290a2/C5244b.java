package p286h.p289g2.p290a2;

import java.util.List;
import java.util.RandomAccess;
import p286h.C5215b2;
import p286h.C5230f1;
import p286h.C5239g1;
import p286h.C5341j1;
import p286h.C5354k1;
import p286h.C5441n1;
import p286h.C5468o1;
import p286h.C5611t1;
import p286h.C5619u1;
import p286h.InterfaceC5352k;
import p286h.InterfaceC5610t0;
import p286h.InterfaceC5713y;
import p286h.p289g2.AbstractC5252d;
import p286h.p289g2.C5294r;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: _UArraysJvm.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000>\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\n0\u0001*\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001*\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001f\u0010\u001f\u001a\u00020\u0002*\u00020\u00032\u0006\u0010 \u001a\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001f\u0010\u001f\u001a\u00020\u0006*\u00020\u00072\u0006\u0010 \u001a\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u001f\u0010\u001f\u001a\u00020\n*\u00020\u000b2\u0006\u0010 \u001a\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u001f\u0010\u001f\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010 \u001a\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\b'\u0010(\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, m23546d2 = {"asList", "", "Lkotlin/UByte;", "Lkotlin/UByteArray;", "asList-GBYM_sE", "([B)Ljava/util/List;", "Lkotlin/UInt;", "Lkotlin/UIntArray;", "asList--ajY-9A", "([I)Ljava/util/List;", "Lkotlin/ULong;", "Lkotlin/ULongArray;", "asList-QwZRm1k", "([J)Ljava/util/List;", "Lkotlin/UShort;", "Lkotlin/UShortArray;", "asList-rL5Bavg", "([S)Ljava/util/List;", "binarySearch", "", "element", "fromIndex", "toIndex", "binarySearch-WpHrYlw", "([BBII)I", "binarySearch-2fe2U9s", "([IIII)I", "binarySearch-K6DWlUc", "([JJII)I", "binarySearch-EtDCXyQ", "([SSII)I", "elementAt", "index", "elementAt-PpDY95g", "([BI)B", "elementAt-qFRl0hI", "([II)I", "elementAt-r7IrZao", "([JI)J", "elementAt-nggk6HY", "([SI)S", "kotlin-stdlib"}, m23547k = 5, m23548mv = {1, 1, 16}, m23549pn = "kotlin.collections", m23550xi = 1, m23551xs = "kotlin/collections/unsigned/UArraysKt")
/* renamed from: h.g2.a2.b */
/* loaded from: classes2.dex */
class C5244b {

    /* compiled from: _UArraysJvm.kt */
    /* renamed from: h.g2.a2.b$a */
    public static final class a extends AbstractC5252d<C5341j1> implements RandomAccess {

        /* renamed from: a */
        final /* synthetic */ int[] f20096a;

        a(int[] iArr) {
            this.f20096a = iArr;
        }

        /* renamed from: a */
        public boolean m19021a(int i2) {
            return C5354k1.m21978a(this.f20096a, i2);
        }

        /* renamed from: b */
        public int m19022b(int i2) {
            return C5294r.m21284g(this.f20096a, i2);
        }

        /* renamed from: c */
        public int m19023c(int i2) {
            return C5294r.m21314h(this.f20096a, i2);
        }

        @Override // p286h.p289g2.AbstractC5240a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof C5341j1) {
                return m19021a(((C5341j1) obj).m21968a());
            }
            return false;
        }

        @Override // p286h.p289g2.AbstractC5252d, p286h.p289g2.AbstractC5240a
        public int getSize() {
            return C5354k1.m21984c(this.f20096a);
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof C5341j1) {
                return m19022b(((C5341j1) obj).m21968a());
            }
            return -1;
        }

        @Override // p286h.p289g2.AbstractC5240a, java.util.Collection
        public boolean isEmpty() {
            return C5354k1.m21988e(this.f20096a);
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof C5341j1) {
                return m19023c(((C5341j1) obj).m21968a());
            }
            return -1;
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        @InterfaceC5816d
        public C5341j1 get(int i2) {
            return C5341j1.m21921a(C5354k1.m21982b(this.f20096a, i2));
        }
    }

    /* compiled from: _UArraysJvm.kt */
    /* renamed from: h.g2.a2.b$b */
    public static final class b extends AbstractC5252d<C5441n1> implements RandomAccess {

        /* renamed from: a */
        final /* synthetic */ long[] f20097a;

        b(long[] jArr) {
            this.f20097a = jArr;
        }

        /* renamed from: a */
        public boolean m19024a(long j2) {
            return C5468o1.m22417a(this.f20097a, j2);
        }

        /* renamed from: b */
        public int m19025b(long j2) {
            return C5294r.m21027c(this.f20097a, j2);
        }

        /* renamed from: c */
        public int m19026c(long j2) {
            return C5294r.m21156d(this.f20097a, j2);
        }

        @Override // p286h.p289g2.AbstractC5240a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof C5441n1) {
                return m19024a(((C5441n1) obj).m22244a());
            }
            return false;
        }

        @Override // p286h.p289g2.AbstractC5252d, p286h.p289g2.AbstractC5240a
        public int getSize() {
            return C5468o1.m22423c(this.f20097a);
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof C5441n1) {
                return m19025b(((C5441n1) obj).m22244a());
            }
            return -1;
        }

        @Override // p286h.p289g2.AbstractC5240a, java.util.Collection
        public boolean isEmpty() {
            return C5468o1.m22426e(this.f20097a);
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof C5441n1) {
                return m19026c(((C5441n1) obj).m22244a());
            }
            return -1;
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        @InterfaceC5816d
        public C5441n1 get(int i2) {
            return C5441n1.m22197a(C5468o1.m22414a(this.f20097a, i2));
        }
    }

    /* compiled from: _UArraysJvm.kt */
    /* renamed from: h.g2.a2.b$c */
    public static final class c extends AbstractC5252d<C5230f1> implements RandomAccess {

        /* renamed from: a */
        final /* synthetic */ byte[] f20098a;

        c(byte[] bArr) {
            this.f20098a = bArr;
        }

        /* renamed from: a */
        public boolean m19027a(byte b2) {
            return C5239g1.m18976a(this.f20098a, b2);
        }

        /* renamed from: b */
        public int m19028b(byte b2) {
            return C5294r.m21023c(this.f20098a, b2);
        }

        /* renamed from: c */
        public int m19029c(byte b2) {
            return C5294r.m21151d(this.f20098a, b2);
        }

        @Override // p286h.p289g2.AbstractC5240a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof C5230f1) {
                return m19027a(((C5230f1) obj).m18966a());
            }
            return false;
        }

        @Override // p286h.p289g2.AbstractC5252d, p286h.p289g2.AbstractC5240a
        public int getSize() {
            return C5239g1.m18982c(this.f20098a);
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof C5230f1) {
                return m19028b(((C5230f1) obj).m18966a());
            }
            return -1;
        }

        @Override // p286h.p289g2.AbstractC5240a, java.util.Collection
        public boolean isEmpty() {
            return C5239g1.m18985e(this.f20098a);
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof C5230f1) {
                return m19029c(((C5230f1) obj).m18966a());
            }
            return -1;
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        @InterfaceC5816d
        public C5230f1 get(int i2) {
            return C5230f1.m18921a(C5239g1.m18973a(this.f20098a, i2));
        }
    }

    /* compiled from: _UArraysJvm.kt */
    /* renamed from: h.g2.a2.b$d */
    public static final class d extends AbstractC5252d<C5611t1> implements RandomAccess {

        /* renamed from: a */
        final /* synthetic */ short[] f20099a;

        d(short[] sArr) {
            this.f20099a = sArr;
        }

        /* renamed from: a */
        public boolean m19030a(short s) {
            return C5619u1.m22929a(this.f20099a, s);
        }

        /* renamed from: b */
        public int m19031b(short s) {
            return C5294r.m21029c(this.f20099a, s);
        }

        /* renamed from: c */
        public int m19032c(short s) {
            return C5294r.m21158d(this.f20099a, s);
        }

        @Override // p286h.p289g2.AbstractC5240a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof C5611t1) {
                return m19030a(((C5611t1) obj).m22913a());
            }
            return false;
        }

        @Override // p286h.p289g2.AbstractC5252d, p286h.p289g2.AbstractC5240a
        public int getSize() {
            return C5619u1.m22933c(this.f20099a);
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof C5611t1) {
                return m19031b(((C5611t1) obj).m22913a());
            }
            return -1;
        }

        @Override // p286h.p289g2.AbstractC5240a, java.util.Collection
        public boolean isEmpty() {
            return C5619u1.m22936e(this.f20099a);
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof C5611t1) {
                return m19032c(((C5611t1) obj).m22913a());
            }
            return -1;
        }

        @Override // p286h.p289g2.AbstractC5252d, java.util.List
        @InterfaceC5816d
        public C5611t1 get(int i2) {
            return C5611t1.m22867a(C5619u1.m22925a(this.f20099a, i2));
        }
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    private static final int m19008a(@InterfaceC5816d int[] iArr, int i2) {
        return C5354k1.m21982b(iArr, i2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    private static final long m19015a(@InterfaceC5816d long[] jArr, int i2) {
        return C5468o1.m22414a(jArr, i2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    private static final byte m19005a(@InterfaceC5816d byte[] bArr, int i2) {
        return C5239g1.m18973a(bArr, i2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    private static final short m19020a(@InterfaceC5816d short[] sArr, int i2) {
        return C5619u1.m22925a(sArr, i2);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5816d
    /* renamed from: a */
    public static final List<C5341j1> m19017a(@InterfaceC5816d int[] iArr) {
        C5544i0.m22546f(iArr, "$this$asList");
        return new a(iArr);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5816d
    /* renamed from: a */
    public static final List<C5441n1> m19018a(@InterfaceC5816d long[] jArr) {
        C5544i0.m22546f(jArr, "$this$asList");
        return new b(jArr);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5816d
    /* renamed from: a */
    public static final List<C5230f1> m19016a(@InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(bArr, "$this$asList");
        return new c(bArr);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5816d
    /* renamed from: a */
    public static final List<C5611t1> m19019a(@InterfaceC5816d short[] sArr) {
        C5544i0.m22546f(sArr, "$this$asList");
        return new d(sArr);
    }

    /* renamed from: a */
    public static /* synthetic */ int m19010a(int[] iArr, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = C5354k1.m21984c(iArr);
        }
        return m19009a(iArr, i2, i3, i4);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final int m19009a(@InterfaceC5816d int[] iArr, int i2, int i3, int i4) {
        C5544i0.m22546f(iArr, "$this$binarySearch");
        AbstractC5252d.Companion.m19655b(i3, i4, C5354k1.m21984c(iArr));
        int i5 = i4 - 1;
        while (i3 <= i5) {
            int i6 = (i3 + i5) >>> 1;
            int m18812a = C5215b2.m18812a(iArr[i6], i2);
            if (m18812a < 0) {
                i3 = i6 + 1;
            } else {
                if (m18812a <= 0) {
                    return i6;
                }
                i5 = i6 - 1;
            }
        }
        return -(i3 + 1);
    }

    /* renamed from: a */
    public static /* synthetic */ int m19012a(long[] jArr, long j2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = C5468o1.m22423c(jArr);
        }
        return m19011a(jArr, j2, i2, i3);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final int m19011a(@InterfaceC5816d long[] jArr, long j2, int i2, int i3) {
        C5544i0.m22546f(jArr, "$this$binarySearch");
        AbstractC5252d.Companion.m19655b(i2, i3, C5468o1.m22423c(jArr));
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int m18813a = C5215b2.m18813a(jArr[i5], j2);
            if (m18813a < 0) {
                i2 = i5 + 1;
            } else {
                if (m18813a <= 0) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    /* renamed from: a */
    public static /* synthetic */ int m19007a(byte[] bArr, byte b2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = C5239g1.m18982c(bArr);
        }
        return m19006a(bArr, b2, i2, i3);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final int m19006a(@InterfaceC5816d byte[] bArr, byte b2, int i2, int i3) {
        C5544i0.m22546f(bArr, "$this$binarySearch");
        AbstractC5252d.Companion.m19655b(i2, i3, C5239g1.m18982c(bArr));
        int i4 = b2 & C5230f1.f20085c;
        int i5 = i3 - 1;
        while (i2 <= i5) {
            int i6 = (i2 + i5) >>> 1;
            int m18812a = C5215b2.m18812a((int) bArr[i6], i4);
            if (m18812a < 0) {
                i2 = i6 + 1;
            } else {
                if (m18812a <= 0) {
                    return i6;
                }
                i5 = i6 - 1;
            }
        }
        return -(i2 + 1);
    }

    /* renamed from: a */
    public static /* synthetic */ int m19014a(short[] sArr, short s, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = C5619u1.m22933c(sArr);
        }
        return m19013a(sArr, s, i2, i3);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final int m19013a(@InterfaceC5816d short[] sArr, short s, int i2, int i3) {
        C5544i0.m22546f(sArr, "$this$binarySearch");
        AbstractC5252d.Companion.m19655b(i2, i3, C5619u1.m22933c(sArr));
        int i4 = s & C5611t1.f20467c;
        int i5 = i3 - 1;
        while (i2 <= i5) {
            int i6 = (i2 + i5) >>> 1;
            int m18812a = C5215b2.m18812a((int) sArr[i6], i4);
            if (m18812a < 0) {
                i2 = i6 + 1;
            } else {
                if (m18812a <= 0) {
                    return i6;
                }
                i5 = i6 - 1;
            }
        }
        return -(i2 + 1);
    }
}
