package p286h;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.taobao.accs.common.Constants;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5586v;
import p286h.p319v2.C5651t;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: UByte.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001fB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u000fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0012J\u001b\u0010\u001b\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b \u0010\u0018J\u0013\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\rHÖ\u0001J\u0013\u0010%\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b&\u0010\u0005J\u0013\u0010'\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b(\u0010\u0005J\u001b\u0010)\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b*\u0010\u000fJ\u001b\u0010)\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b+\u0010\u0012J\u001b\u0010)\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\b,\u0010\u001fJ\u001b\u0010)\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b-\u0010\u0018J\u001b\u0010.\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b/\u0010\u000bJ\u001b\u00100\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b1\u0010\u000fJ\u001b\u00100\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b2\u0010\u0012J\u001b\u00100\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u001fJ\u001b\u00100\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b4\u0010\u0018J\u001b\u00105\u001a\u0002062\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b7\u00108J\u001b\u00109\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b:\u0010\u000fJ\u001b\u00109\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b;\u0010\u0012J\u001b\u00109\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\b<\u0010\u001fJ\u001b\u00109\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b=\u0010\u0018J\u001b\u0010>\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b?\u0010\u000fJ\u001b\u0010>\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b@\u0010\u0012J\u001b\u0010>\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\bA\u0010\u001fJ\u001b\u0010>\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bB\u0010\u0018J\u0010\u0010C\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bD\u0010\u0005J\u0010\u0010E\u001a\u00020FH\u0087\b¢\u0006\u0004\bG\u0010HJ\u0010\u0010I\u001a\u00020JH\u0087\b¢\u0006\u0004\bK\u0010LJ\u0010\u0010M\u001a\u00020\rH\u0087\b¢\u0006\u0004\bN\u0010OJ\u0010\u0010P\u001a\u00020QH\u0087\b¢\u0006\u0004\bR\u0010SJ\u0010\u0010T\u001a\u00020UH\u0087\b¢\u0006\u0004\bV\u0010WJ\u000f\u0010X\u001a\u00020YH\u0016¢\u0006\u0004\bZ\u0010[J\u0013\u0010\\\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b]\u0010\u0005J\u0013\u0010^\u001a\u00020\u0010H\u0087\bø\u0001\u0000¢\u0006\u0004\b_\u0010OJ\u0013\u0010`\u001a\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\ba\u0010SJ\u0013\u0010b\u001a\u00020\u0016H\u0087\bø\u0001\u0000¢\u0006\u0004\bc\u0010WJ\u001b\u0010d\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\be\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006g"}, m23546d2 = {"Lkotlin/UByte;", "", "data", "", "constructor-impl", "(B)B", "data$annotations", "()V", "and", DispatchConstants.OTHER, "and-7apg3OU", "(BB)B", "compareTo", "", "compareTo-7apg3OU", "(BB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(BI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(BJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(BS)I", "dec", "dec-impl", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(BJ)J", "div-xj2QHRw", "equals", "", "", "hashCode", "inc", "inc-impl", "inv", "inv-impl", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or", "or-7apg3OU", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-7apg3OU", "(BB)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", Constants.KEY_TIMES, "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "toByte-impl", "toDouble", "", "toDouble-impl", "(B)D", "toFloat", "", "toFloat-impl", "(B)F", "toInt", "toInt-impl", "(B)I", "toLong", "", "toLong-impl", "(B)J", "toShort", "", "toShort-impl", "(B)S", "toString", "", "toString-impl", "(B)Ljava/lang/String;", "toUByte", "toUByte-impl", "toUInt", "toUInt-impl", "toULong", "toULong-impl", "toUShort", "toUShort-impl", "xor", "xor-7apg3OU", "Companion", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
@InterfaceC5610t0(version = "1.3")
@InterfaceC5352k
/* renamed from: h.f1 */
/* loaded from: classes2.dex */
public final class C5230f1 implements Comparable<C5230f1> {

    /* renamed from: b */
    public static final byte f20084b = 0;

    /* renamed from: c */
    public static final byte f20085c = -1;

    /* renamed from: d */
    public static final int f20086d = 1;

    /* renamed from: e */
    public static final int f20087e = 8;

    /* renamed from: f */
    public static final a f20088f = new a(null);

    /* renamed from: a */
    private final byte f20089a;

    /* compiled from: UByte.kt */
    /* renamed from: h.f1$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(C5586v c5586v) {
            this();
        }
    }

    @InterfaceC5440n0
    private /* synthetic */ C5230f1(byte b2) {
        this.f20089a = b2;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final int m18920a(byte b2, short s) {
        return C5544i0.m22512a(b2 & f20085c, s & C5611t1.f20467c);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final /* synthetic */ C5230f1 m18921a(byte b2) {
        return new C5230f1(b2);
    }

    /* renamed from: a */
    public static boolean m18922a(byte b2, @InterfaceC5817e Object obj) {
        return (obj instanceof C5230f1) && b2 == ((C5230f1) obj).m18966a();
    }

    @InterfaceC5426f
    /* renamed from: b */
    private int m18923b(byte b2) {
        return m18924b(this.f20089a, b2);
    }

    @InterfaceC5440n0
    /* renamed from: b */
    public static /* synthetic */ void m18928b() {
    }

    @InterfaceC5440n0
    /* renamed from: c */
    public static byte m18929c(byte b2) {
        return b2;
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final int m18932c(byte b2, short s) {
        return C5341j1.m21929c(C5341j1.m21929c(b2 & f20085c) - C5341j1.m21929c(s & C5611t1.f20467c));
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final int m18936d(byte b2, short s) {
        return C5341j1.m21929c(C5341j1.m21929c(b2 & f20085c) + C5341j1.m21929c(s & C5611t1.f20467c));
    }

    /* renamed from: d */
    public static final boolean m18938d(byte b2, byte b3) {
        return b2 == b3;
    }

    /* renamed from: e */
    public static int m18939e(byte b2) {
        return b2;
    }

    @InterfaceC5426f
    /* renamed from: e */
    private static final int m18940e(byte b2, byte b3) {
        return C5341j1.m21929c(C5341j1.m21929c(b2 & f20085c) - C5341j1.m21929c(b3 & f20085c));
    }

    @InterfaceC5426f
    /* renamed from: f */
    private static final int m18947f(byte b2, short s) {
        return C5341j1.m21929c(C5341j1.m21929c(b2 & f20085c) * C5341j1.m21929c(s & C5611t1.f20467c));
    }

    @InterfaceC5426f
    /* renamed from: g */
    private static final int m18950g(byte b2, byte b3) {
        return C5341j1.m21929c(C5341j1.m21929c(b2 & f20085c) + C5341j1.m21929c(b3 & f20085c));
    }

    @InterfaceC5426f
    /* renamed from: h */
    private static final byte m18951h(byte b2) {
        return b2;
    }

    @InterfaceC5426f
    /* renamed from: h */
    private static final C5651t m18952h(byte b2, byte b3) {
        return new C5651t(C5341j1.m21929c(b2 & f20085c), C5341j1.m21929c(b3 & f20085c), null);
    }

    @InterfaceC5426f
    /* renamed from: i */
    private static final double m18953i(byte b2) {
        return b2 & f20085c;
    }

    @InterfaceC5426f
    /* renamed from: i */
    private static final int m18954i(byte b2, byte b3) {
        return C5215b2.m18819c(C5341j1.m21929c(b2 & f20085c), C5341j1.m21929c(b3 & f20085c));
    }

    @InterfaceC5426f
    /* renamed from: j */
    private static final float m18955j(byte b2) {
        return b2 & f20085c;
    }

    @InterfaceC5426f
    /* renamed from: j */
    private static final int m18956j(byte b2, byte b3) {
        return C5341j1.m21929c(C5341j1.m21929c(b2 & f20085c) * C5341j1.m21929c(b3 & f20085c));
    }

    @InterfaceC5426f
    /* renamed from: k */
    private static final byte m18957k(byte b2, byte b3) {
        return m18929c((byte) (b2 ^ b3));
    }

    @InterfaceC5426f
    /* renamed from: k */
    private static final int m18958k(byte b2) {
        return b2 & f20085c;
    }

    @InterfaceC5426f
    /* renamed from: l */
    private static final long m18959l(byte b2) {
        return b2 & 255;
    }

    @InterfaceC5426f
    /* renamed from: m */
    private static final short m18960m(byte b2) {
        return (short) (b2 & 255);
    }

    @InterfaceC5816d
    /* renamed from: n */
    public static String m18961n(byte b2) {
        return String.valueOf(b2 & f20085c);
    }

    @InterfaceC5426f
    /* renamed from: o */
    private static final byte m18962o(byte b2) {
        return b2;
    }

    @InterfaceC5426f
    /* renamed from: p */
    private static final int m18963p(byte b2) {
        return C5341j1.m21929c(b2 & f20085c);
    }

    @InterfaceC5426f
    /* renamed from: q */
    private static final long m18964q(byte b2) {
        return C5441n1.m22205c(b2 & 255);
    }

    @InterfaceC5426f
    /* renamed from: r */
    private static final short m18965r(byte b2) {
        return C5611t1.m22880c((short) (b2 & 255));
    }

    /* renamed from: a */
    public final /* synthetic */ byte m18966a() {
        return this.f20089a;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(C5230f1 c5230f1) {
        return m18923b(c5230f1.m18966a());
    }

    public boolean equals(Object obj) {
        return m18922a(this.f20089a, obj);
    }

    public int hashCode() {
        return m18939e(this.f20089a);
    }

    @InterfaceC5816d
    public String toString() {
        return m18961n(this.f20089a);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final int m18918a(byte b2, int i2) {
        return C5215b2.m18812a(C5341j1.m21929c(b2 & f20085c), i2);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static int m18924b(byte b2, byte b3) {
        return C5544i0.m22512a(b2 & f20085c, b3 & f20085c);
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final int m18931c(byte b2, int i2) {
        return C5341j1.m21929c(C5341j1.m21929c(b2 & f20085c) - i2);
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final int m18935d(byte b2, int i2) {
        return C5341j1.m21929c(C5341j1.m21929c(b2 & f20085c) + i2);
    }

    @InterfaceC5426f
    /* renamed from: e */
    private static final int m18942e(byte b2, short s) {
        return C5215b2.m18819c(C5341j1.m21929c(b2 & f20085c), C5341j1.m21929c(s & C5611t1.f20467c));
    }

    @InterfaceC5426f
    /* renamed from: f */
    private static final int m18946f(byte b2, int i2) {
        return C5341j1.m21929c(C5341j1.m21929c(b2 & f20085c) * i2);
    }

    @InterfaceC5426f
    /* renamed from: g */
    private static final byte m18949g(byte b2) {
        return m18929c((byte) (~b2));
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final int m18919a(byte b2, long j2) {
        return C5215b2.m18813a(C5441n1.m22205c(b2 & 255), j2);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final int m18926b(byte b2, short s) {
        return C5215b2.m18815b(C5341j1.m21929c(b2 & f20085c), C5341j1.m21929c(s & C5611t1.f20467c));
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final long m18933c(byte b2, long j2) {
        return C5441n1.m22205c(C5441n1.m22205c(b2 & 255) - j2);
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final long m18937d(byte b2, long j2) {
        return C5441n1.m22205c(C5441n1.m22205c(b2 & 255) + j2);
    }

    @InterfaceC5426f
    /* renamed from: e */
    private static final int m18941e(byte b2, int i2) {
        return C5215b2.m18819c(C5341j1.m21929c(b2 & f20085c), i2);
    }

    @InterfaceC5426f
    /* renamed from: f */
    private static final long m18948f(byte b2, long j2) {
        return C5441n1.m22205c(C5441n1.m22205c(b2 & 255) * j2);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final byte m18917a(byte b2, byte b3) {
        return m18929c((byte) (b2 & b3));
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final int m18925b(byte b2, int i2) {
        return C5215b2.m18815b(C5341j1.m21929c(b2 & f20085c), i2);
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final int m18930c(byte b2, byte b3) {
        return C5215b2.m18815b(C5341j1.m21929c(b2 & f20085c), C5341j1.m21929c(b3 & f20085c));
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final byte m18934d(byte b2) {
        return m18929c((byte) (b2 - 1));
    }

    @InterfaceC5426f
    /* renamed from: e */
    private static final long m18943e(byte b2, long j2) {
        return C5215b2.m18820c(C5441n1.m22205c(b2 & 255), j2);
    }

    @InterfaceC5426f
    /* renamed from: f */
    private static final byte m18944f(byte b2) {
        return m18929c((byte) (b2 + 1));
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final long m18927b(byte b2, long j2) {
        return C5215b2.m18817b(C5441n1.m22205c(b2 & 255), j2);
    }

    @InterfaceC5426f
    /* renamed from: f */
    private static final byte m18945f(byte b2, byte b3) {
        return m18929c((byte) (b2 | b3));
    }
}
