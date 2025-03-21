package p286h;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.taobao.accs.common.Constants;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p311t.C5586v;
import p286h.p319v2.C5654w;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: ULong.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 m2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001mB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b \u0010\u000bJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010\t\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\rHÖ\u0001J\u0013\u0010'\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b(\u0010\u0005J\u0013\u0010)\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u0005J\u001b\u0010+\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b,\u0010\u001dJ\u001b\u0010+\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b-\u0010\u001fJ\u001b\u0010+\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b.\u0010\u000bJ\u001b\u0010+\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b/\u0010\"J\u001b\u00100\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b1\u0010\u000bJ\u001b\u00102\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u001dJ\u001b\u00102\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b4\u0010\u001fJ\u001b\u00102\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b5\u0010\u000bJ\u001b\u00102\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b6\u0010\"J\u001b\u00107\u001a\u0002082\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u001b\u0010;\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b<\u0010\u001dJ\u001b\u0010;\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b=\u0010\u001fJ\u001b\u0010;\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b>\u0010\u000bJ\u001b\u0010;\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b?\u0010\"J\u001b\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\rH\u0087\fø\u0001\u0000¢\u0006\u0004\bB\u0010\u001fJ\u001b\u0010C\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\rH\u0087\fø\u0001\u0000¢\u0006\u0004\bD\u0010\u001fJ\u001b\u0010E\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\bF\u0010\u001dJ\u001b\u0010E\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bG\u0010\u001fJ\u001b\u0010E\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bH\u0010\u000bJ\u001b\u0010E\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bI\u0010\"J\u0010\u0010J\u001a\u00020KH\u0087\b¢\u0006\u0004\bL\u0010MJ\u0010\u0010N\u001a\u00020OH\u0087\b¢\u0006\u0004\bP\u0010QJ\u0010\u0010R\u001a\u00020SH\u0087\b¢\u0006\u0004\bT\u0010UJ\u0010\u0010V\u001a\u00020\rH\u0087\b¢\u0006\u0004\bW\u0010XJ\u0010\u0010Y\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bZ\u0010\u0005J\u0010\u0010[\u001a\u00020\\H\u0087\b¢\u0006\u0004\b]\u0010^J\u000f\u0010_\u001a\u00020`H\u0016¢\u0006\u0004\ba\u0010bJ\u0013\u0010c\u001a\u00020\u000eH\u0087\bø\u0001\u0000¢\u0006\u0004\bd\u0010MJ\u0013\u0010e\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\bf\u0010XJ\u0013\u0010g\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\bh\u0010\u0005J\u0013\u0010i\u001a\u00020\u0016H\u0087\bø\u0001\u0000¢\u0006\u0004\bj\u0010^J\u001b\u0010k\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\bl\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006n"}, m23546d2 = {"Lkotlin/ULong;", "", "data", "", "constructor-impl", "(J)J", "data$annotations", "()V", "and", DispatchConstants.OTHER, "and-VKZWuLQ", "(JJ)J", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(JB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "dec", "dec-impl", "div", "div-7apg3OU", "(JB)J", "div-WZ4Q5Ns", "(JI)J", "div-VKZWuLQ", "div-xj2QHRw", "(JS)J", "equals", "", "", "hashCode", "inc", "inc-impl", "inv", "inv-impl", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or", "or-VKZWuLQ", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-impl", "shr", "shr-impl", Constants.KEY_TIMES, "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(J)B", "toDouble", "", "toDouble-impl", "(J)D", "toFloat", "", "toFloat-impl", "(J)F", "toInt", "toInt-impl", "(J)I", "toLong", "toLong-impl", "toShort", "", "toShort-impl", "(J)S", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "toUByte", "toUByte-impl", "toUInt", "toUInt-impl", "toULong", "toULong-impl", "toUShort", "toUShort-impl", "xor", "xor-VKZWuLQ", "Companion", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
@InterfaceC5610t0(version = "1.3")
@InterfaceC5352k
/* renamed from: h.n1 */
/* loaded from: classes2.dex */
public final class C5441n1 implements Comparable<C5441n1> {

    /* renamed from: b */
    public static final long f20301b = 0;

    /* renamed from: c */
    public static final long f20302c = -1;

    /* renamed from: d */
    public static final int f20303d = 8;

    /* renamed from: e */
    public static final int f20304e = 64;

    /* renamed from: f */
    public static final a f20305f = new a(null);

    /* renamed from: a */
    private final long f20306a;

    /* compiled from: ULong.kt */
    /* renamed from: h.n1$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(C5586v c5586v) {
            this();
        }
    }

    @InterfaceC5440n0
    private /* synthetic */ C5441n1(long j2) {
        this.f20306a = j2;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final int m22193a(long j2, byte b2) {
        return C5215b2.m18813a(j2, m22205c(b2 & 255));
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final /* synthetic */ C5441n1 m22197a(long j2) {
        return new C5441n1(j2);
    }

    /* renamed from: a */
    public static boolean m22198a(long j2, @InterfaceC5817e Object obj) {
        return (obj instanceof C5441n1) && j2 == ((C5441n1) obj).m22244a();
    }

    @InterfaceC5426f
    /* renamed from: b */
    private int m22199b(long j2) {
        return m22200b(this.f20306a, j2);
    }

    @InterfaceC5440n0
    /* renamed from: b */
    public static /* synthetic */ void m22204b() {
    }

    @InterfaceC5440n0
    /* renamed from: c */
    public static long m22205c(long j2) {
        return j2;
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final long m22206c(long j2, byte b2) {
        return m22205c(j2 - m22205c(b2 & 255));
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final long m22211d(long j2, byte b2) {
        return m22205c(j2 + m22205c(b2 & 255));
    }

    /* renamed from: d */
    public static final boolean m22214d(long j2, long j3) {
        return j2 == j3;
    }

    /* renamed from: e */
    public static int m22215e(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    @InterfaceC5426f
    /* renamed from: e */
    private static final long m22218e(long j2, long j3) {
        return m22205c(j2 - j3);
    }

    @InterfaceC5426f
    /* renamed from: f */
    private static final long m22221f(long j2, byte b2) {
        return m22205c(j2 * m22205c(b2 & 255));
    }

    @InterfaceC5426f
    /* renamed from: g */
    private static final long m22227g(long j2, long j3) {
        return m22205c(j2 + j3);
    }

    @InterfaceC5426f
    /* renamed from: h */
    private static final byte m22228h(long j2) {
        return (byte) j2;
    }

    @InterfaceC5426f
    /* renamed from: h */
    private static final long m22229h(long j2, int i2) {
        return m22205c(j2 * m22205c(i2 & 4294967295L));
    }

    @InterfaceC5426f
    /* renamed from: i */
    private static final long m22232i(long j2, long j3) {
        return C5215b2.m18820c(j2, j3);
    }

    @InterfaceC5426f
    /* renamed from: j */
    private static final long m22234j(long j2, long j3) {
        return m22205c(j2 * j3);
    }

    @InterfaceC5426f
    /* renamed from: k */
    private static final int m22235k(long j2) {
        return (int) j2;
    }

    @InterfaceC5426f
    /* renamed from: k */
    private static final long m22236k(long j2, long j3) {
        return m22205c(j2 ^ j3);
    }

    @InterfaceC5426f
    /* renamed from: l */
    private static final long m22237l(long j2) {
        return j2;
    }

    @InterfaceC5426f
    /* renamed from: m */
    private static final short m22238m(long j2) {
        return (short) j2;
    }

    @InterfaceC5816d
    /* renamed from: n */
    public static String m22239n(long j2) {
        return C5215b2.m18818b(j2);
    }

    @InterfaceC5426f
    /* renamed from: o */
    private static final byte m22240o(long j2) {
        return C5230f1.m18929c((byte) j2);
    }

    @InterfaceC5426f
    /* renamed from: p */
    private static final int m22241p(long j2) {
        return C5341j1.m21929c((int) j2);
    }

    @InterfaceC5426f
    /* renamed from: q */
    private static final long m22242q(long j2) {
        return j2;
    }

    @InterfaceC5426f
    /* renamed from: r */
    private static final short m22243r(long j2) {
        return C5611t1.m22880c((short) j2);
    }

    /* renamed from: a */
    public final /* synthetic */ long m22244a() {
        return this.f20306a;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(C5441n1 c5441n1) {
        return m22199b(c5441n1.m22244a());
    }

    public boolean equals(Object obj) {
        return m22198a(this.f20306a, obj);
    }

    public int hashCode() {
        return m22215e(this.f20306a);
    }

    @InterfaceC5816d
    public String toString() {
        return m22239n(this.f20306a);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final int m22195a(long j2, short s) {
        return C5215b2.m18813a(j2, m22205c(s & 65535));
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static int m22200b(long j2, long j3) {
        return C5215b2.m18813a(j2, j3);
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final long m22209c(long j2, short s) {
        return m22205c(j2 - m22205c(s & 65535));
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final long m22213d(long j2, short s) {
        return m22205c(j2 + m22205c(s & 65535));
    }

    @InterfaceC5426f
    /* renamed from: e */
    private static final long m22216e(long j2, byte b2) {
        return C5215b2.m18820c(j2, m22205c(b2 & 255));
    }

    @InterfaceC5426f
    /* renamed from: f */
    private static final long m22224f(long j2, short s) {
        return m22205c(j2 * m22205c(s & 65535));
    }

    @InterfaceC5426f
    /* renamed from: g */
    private static final long m22226g(long j2, int i2) {
        return m22205c(j2 >>> i2);
    }

    @InterfaceC5426f
    /* renamed from: h */
    private static final C5654w m22230h(long j2, long j3) {
        return new C5654w(j2, j3, null);
    }

    @InterfaceC5426f
    /* renamed from: i */
    private static final double m22231i(long j2) {
        return C5215b2.m18810a(j2);
    }

    @InterfaceC5426f
    /* renamed from: j */
    private static final float m22233j(long j2) {
        return (float) C5215b2.m18810a(j2);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final int m22194a(long j2, int i2) {
        return C5215b2.m18813a(j2, m22205c(i2 & 4294967295L));
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final long m22201b(long j2, byte b2) {
        return C5215b2.m18817b(j2, m22205c(b2 & 255));
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final long m22207c(long j2, int i2) {
        return m22205c(j2 - m22205c(i2 & 4294967295L));
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final long m22212d(long j2, int i2) {
        return m22205c(j2 + m22205c(i2 & 4294967295L));
    }

    @InterfaceC5426f
    /* renamed from: e */
    private static final long m22219e(long j2, short s) {
        return C5215b2.m18820c(j2, m22205c(s & 65535));
    }

    @InterfaceC5426f
    /* renamed from: f */
    private static final long m22220f(long j2) {
        return m22205c(j2 + 1);
    }

    @InterfaceC5426f
    /* renamed from: g */
    private static final long m22225g(long j2) {
        return m22205c(~j2);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final long m22196a(long j2, long j3) {
        return m22205c(j2 & j3);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final long m22203b(long j2, short s) {
        return C5215b2.m18817b(j2, m22205c(s & 65535));
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final long m22208c(long j2, long j3) {
        return C5215b2.m18817b(j2, j3);
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final long m22210d(long j2) {
        return m22205c(j2 - 1);
    }

    @InterfaceC5426f
    /* renamed from: e */
    private static final long m22217e(long j2, int i2) {
        return C5215b2.m18820c(j2, m22205c(i2 & 4294967295L));
    }

    @InterfaceC5426f
    /* renamed from: f */
    private static final long m22222f(long j2, int i2) {
        return m22205c(j2 << i2);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final long m22202b(long j2, int i2) {
        return C5215b2.m18817b(j2, m22205c(i2 & 4294967295L));
    }

    @InterfaceC5426f
    /* renamed from: f */
    private static final long m22223f(long j2, long j3) {
        return m22205c(j2 | j3);
    }
}
