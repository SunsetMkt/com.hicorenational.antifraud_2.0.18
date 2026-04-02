package i.g2.a2;

import i.b2;
import i.f1;
import i.g1;
import i.g2.r;
import i.j1;
import i.k;
import i.k1;
import i.m2.f;
import i.n1;
import i.o1;
import i.q2.t.i0;
import i.t0;
import i.t1;
import i.u1;
import i.y;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: _UArraysJvm.kt */
/* JADX INFO: loaded from: classes2.dex */
@y(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0007H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\n0\u0001*\u00020\u000bH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\r\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001*\u00020\u000fH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001a\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001c\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001e\u001a\u001f\u0010\u001f\u001a\u00020\u0002*\u00020\u00032\u0006\u0010 \u001a\u00020\u0013H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\"\u001a\u001f\u0010\u001f\u001a\u00020\u0006*\u00020\u00072\u0006\u0010 \u001a\u00020\u0013H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010$\u001a\u001f\u0010\u001f\u001a\u00020\n*\u00020\u000b2\u0006\u0010 \u001a\u00020\u0013H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010&\u001a\u001f\u0010\u001f\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010 \u001a\u00020\u0013H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010(\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006)"}, d2 = {"asList", "", "Lkotlin/UByte;", "Lkotlin/UByteArray;", "asList-GBYM_sE", "([B)Ljava/util/List;", "Lkotlin/UInt;", "Lkotlin/UIntArray;", "asList--ajY-9A", "([I)Ljava/util/List;", "Lkotlin/ULong;", "Lkotlin/ULongArray;", "asList-QwZRm1k", "([J)Ljava/util/List;", "Lkotlin/UShort;", "Lkotlin/UShortArray;", "asList-rL5Bavg", "([S)Ljava/util/List;", "binarySearch", "", "element", "fromIndex", "toIndex", "binarySearch-WpHrYlw", "([BBII)I", "binarySearch-2fe2U9s", "([IIII)I", "binarySearch-K6DWlUc", "([JJII)I", "binarySearch-EtDCXyQ", "([SSII)I", "elementAt", "index", "elementAt-PpDY95g", "([BI)B", "elementAt-qFRl0hI", "([II)I", "elementAt-r7IrZao", "([JI)J", "elementAt-nggk6HY", "([SI)S", "kotlin-stdlib"}, k = 5, mv = {1, 1, 16}, pn = "kotlin.collections", xi = 1, xs = "kotlin/collections/unsigned/UArraysKt")
class b {

    /* JADX INFO: compiled from: _UArraysJvm.kt */
    public static final class a extends i.g2.d<j1> implements RandomAccess {
        final /* synthetic */ int[] a;

        a(int[] iArr) {
            this.a = iArr;
        }

        public boolean a(int i2) {
            return k1.a(this.a, i2);
        }

        public int b(int i2) {
            return r.g(this.a, i2);
        }

        public int c(int i2) {
            return r.h(this.a, i2);
        }

        @Override // i.g2.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof j1) {
                return a(((j1) obj).a());
            }
            return false;
        }

        @Override // i.g2.d, i.g2.a
        public int getSize() {
            return k1.c(this.a);
        }

        @Override // i.g2.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof j1) {
                return b(((j1) obj).a());
            }
            return -1;
        }

        @Override // i.g2.a, java.util.Collection
        public boolean isEmpty() {
            return k1.e(this.a);
        }

        @Override // i.g2.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof j1) {
                return c(((j1) obj).a());
            }
            return -1;
        }

        @Override // i.g2.d, java.util.List
        @j.c.a.d
        public j1 get(int i2) {
            return j1.a(k1.b(this.a, i2));
        }
    }

    /* JADX INFO: renamed from: i.g2.a2.b$b */
    /* JADX INFO: compiled from: _UArraysJvm.kt */
    public static final class C0236b extends i.g2.d<n1> implements RandomAccess {
        final /* synthetic */ long[] a;

        C0236b(long[] jArr) {
            this.a = jArr;
        }

        public boolean a(long j2) {
            return o1.a(this.a, j2);
        }

        public int b(long j2) {
            return r.c(this.a, j2);
        }

        public int c(long j2) {
            return r.d(this.a, j2);
        }

        @Override // i.g2.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof n1) {
                return a(((n1) obj).a());
            }
            return false;
        }

        @Override // i.g2.d, i.g2.a
        public int getSize() {
            return o1.c(this.a);
        }

        @Override // i.g2.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof n1) {
                return b(((n1) obj).a());
            }
            return -1;
        }

        @Override // i.g2.a, java.util.Collection
        public boolean isEmpty() {
            return o1.e(this.a);
        }

        @Override // i.g2.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof n1) {
                return c(((n1) obj).a());
            }
            return -1;
        }

        @Override // i.g2.d, java.util.List
        @j.c.a.d
        public n1 get(int i2) {
            return n1.a(o1.a(this.a, i2));
        }
    }

    /* JADX INFO: compiled from: _UArraysJvm.kt */
    public static final class c extends i.g2.d<f1> implements RandomAccess {
        final /* synthetic */ byte[] a;

        c(byte[] bArr) {
            this.a = bArr;
        }

        public boolean a(byte b2) {
            return g1.a(this.a, b2);
        }

        public int b(byte b2) {
            return r.c(this.a, b2);
        }

        public int c(byte b2) {
            return r.d(this.a, b2);
        }

        @Override // i.g2.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof f1) {
                return a(((f1) obj).a());
            }
            return false;
        }

        @Override // i.g2.d, i.g2.a
        public int getSize() {
            return g1.c(this.a);
        }

        @Override // i.g2.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof f1) {
                return b(((f1) obj).a());
            }
            return -1;
        }

        @Override // i.g2.a, java.util.Collection
        public boolean isEmpty() {
            return g1.e(this.a);
        }

        @Override // i.g2.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof f1) {
                return c(((f1) obj).a());
            }
            return -1;
        }

        @Override // i.g2.d, java.util.List
        @j.c.a.d
        public f1 get(int i2) {
            return f1.a(g1.a(this.a, i2));
        }
    }

    /* JADX INFO: compiled from: _UArraysJvm.kt */
    public static final class d extends i.g2.d<t1> implements RandomAccess {
        final /* synthetic */ short[] a;

        d(short[] sArr) {
            this.a = sArr;
        }

        public boolean a(short s) {
            return u1.a(this.a, s);
        }

        public int b(short s) {
            return r.c(this.a, s);
        }

        public int c(short s) {
            return r.d(this.a, s);
        }

        @Override // i.g2.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof t1) {
                return a(((t1) obj).a());
            }
            return false;
        }

        @Override // i.g2.d, i.g2.a
        public int getSize() {
            return u1.c(this.a);
        }

        @Override // i.g2.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof t1) {
                return b(((t1) obj).a());
            }
            return -1;
        }

        @Override // i.g2.a, java.util.Collection
        public boolean isEmpty() {
            return u1.e(this.a);
        }

        @Override // i.g2.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof t1) {
                return c(((t1) obj).a());
            }
            return -1;
        }

        @Override // i.g2.d, java.util.List
        @j.c.a.d
        public t1 get(int i2) {
            return t1.a(u1.a(this.a, i2));
        }
    }

    @k
    @t0(version = "1.3")
    @f
    private static final int a(@j.c.a.d int[] iArr, int i2) {
        return k1.b(iArr, i2);
    }

    @k
    @t0(version = "1.3")
    @f
    private static final long a(@j.c.a.d long[] jArr, int i2) {
        return o1.a(jArr, i2);
    }

    @k
    @t0(version = "1.3")
    @f
    private static final byte a(@j.c.a.d byte[] bArr, int i2) {
        return g1.a(bArr, i2);
    }

    @k
    @t0(version = "1.3")
    @f
    private static final short a(@j.c.a.d short[] sArr, int i2) {
        return u1.a(sArr, i2);
    }

    @k
    @t0(version = "1.3")
    @j.c.a.d
    public static final List<j1> a(@j.c.a.d int[] iArr) {
        i0.f(iArr, "$this$asList");
        return new a(iArr);
    }

    @k
    @t0(version = "1.3")
    @j.c.a.d
    public static final List<n1> a(@j.c.a.d long[] jArr) {
        i0.f(jArr, "$this$asList");
        return new C0236b(jArr);
    }

    @k
    @t0(version = "1.3")
    @j.c.a.d
    public static final List<f1> a(@j.c.a.d byte[] bArr) {
        i0.f(bArr, "$this$asList");
        return new c(bArr);
    }

    @k
    @t0(version = "1.3")
    @j.c.a.d
    public static final List<t1> a(@j.c.a.d short[] sArr) {
        i0.f(sArr, "$this$asList");
        return new d(sArr);
    }

    public static /* synthetic */ int a(int[] iArr, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = k1.c(iArr);
        }
        return a(iArr, i2, i3, i4);
    }

    @k
    @t0(version = "1.3")
    public static final int a(@j.c.a.d int[] iArr, int i2, int i3, int i4) {
        i0.f(iArr, "$this$binarySearch");
        i.g2.d.Companion.b(i3, i4, k1.c(iArr));
        int i5 = i4 - 1;
        while (i3 <= i5) {
            int i6 = (i3 + i5) >>> 1;
            int iA = b2.a(iArr[i6], i2);
            if (iA < 0) {
                i3 = i6 + 1;
            } else {
                if (iA <= 0) {
                    return i6;
                }
                i5 = i6 - 1;
            }
        }
        return -(i3 + 1);
    }

    public static /* synthetic */ int a(long[] jArr, long j2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = o1.c(jArr);
        }
        return a(jArr, j2, i2, i3);
    }

    @k
    @t0(version = "1.3")
    public static final int a(@j.c.a.d long[] jArr, long j2, int i2, int i3) {
        i0.f(jArr, "$this$binarySearch");
        i.g2.d.Companion.b(i2, i3, o1.c(jArr));
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int iA = b2.a(jArr[i5], j2);
            if (iA < 0) {
                i2 = i5 + 1;
            } else {
                if (iA <= 0) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static /* synthetic */ int a(byte[] bArr, byte b2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = g1.c(bArr);
        }
        return a(bArr, b2, i2, i3);
    }

    @k
    @t0(version = "1.3")
    public static final int a(@j.c.a.d byte[] bArr, byte b2, int i2, int i3) {
        i0.f(bArr, "$this$binarySearch");
        i.g2.d.Companion.b(i2, i3, g1.c(bArr));
        int i4 = b2 & f1.f12066c;
        int i5 = i3 - 1;
        while (i2 <= i5) {
            int i6 = (i2 + i5) >>> 1;
            int iA = b2.a((int) bArr[i6], i4);
            if (iA < 0) {
                i2 = i6 + 1;
            } else {
                if (iA <= 0) {
                    return i6;
                }
                i5 = i6 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static /* synthetic */ int a(short[] sArr, short s, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = u1.c(sArr);
        }
        return a(sArr, s, i2, i3);
    }

    @k
    @t0(version = "1.3")
    public static final int a(@j.c.a.d short[] sArr, short s, int i2, int i3) {
        i0.f(sArr, "$this$binarySearch");
        i.g2.d.Companion.b(i2, i3, u1.c(sArr));
        int i4 = s & t1.f12275c;
        int i5 = i3 - 1;
        while (i2 <= i5) {
            int i6 = (i2 + i5) >>> 1;
            int iA = b2.a((int) sArr[i6], i4);
            if (iA < 0) {
                i2 = i6 + 1;
            } else {
                if (iA <= 0) {
                    return i6;
                }
                i5 = i6 - 1;
            }
        }
        return -(i2 + 1);
    }
}
