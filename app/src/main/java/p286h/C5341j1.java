package p286h;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.taobao.accs.common.Constants;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p311t.C5586v;
import p286h.p319v2.C5651t;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: UInt.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 j2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001jB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0005J\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u000fJ\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u000bJ\u001b\u0010\u0019\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0016J\u0013\u0010\u001f\u001a\u00020 2\b\u0010\t\u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0013\u0010#\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b$\u0010\u0005J\u0013\u0010%\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b&\u0010\u0005J\u001b\u0010'\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b(\u0010\u000fJ\u001b\u0010'\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b)\u0010\u000bJ\u001b\u0010'\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b*\u0010\u001dJ\u001b\u0010'\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b+\u0010\u0016J\u001b\u0010,\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b-\u0010\u000bJ\u001b\u0010.\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b/\u0010\u000fJ\u001b\u0010.\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b0\u0010\u000bJ\u001b\u0010.\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b1\u0010\u001dJ\u001b\u0010.\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b2\u0010\u0016J\u001b\u00103\u001a\u0002042\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b5\u00106J\u001b\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b8\u0010\u000fJ\u001b\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b9\u0010\u000bJ\u001b\u00107\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b:\u0010\u001dJ\u001b\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b;\u0010\u0016J\u001b\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u0003H\u0087\fø\u0001\u0000¢\u0006\u0004\b>\u0010\u000bJ\u001b\u0010?\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u0003H\u0087\fø\u0001\u0000¢\u0006\u0004\b@\u0010\u000bJ\u001b\u0010A\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\bB\u0010\u000fJ\u001b\u0010A\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bC\u0010\u000bJ\u001b\u0010A\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bD\u0010\u001dJ\u001b\u0010A\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\bE\u0010\u0016J\u0010\u0010F\u001a\u00020GH\u0087\b¢\u0006\u0004\bH\u0010IJ\u0010\u0010J\u001a\u00020KH\u0087\b¢\u0006\u0004\bL\u0010MJ\u0010\u0010N\u001a\u00020OH\u0087\b¢\u0006\u0004\bP\u0010QJ\u0010\u0010R\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bS\u0010\u0005J\u0010\u0010T\u001a\u00020UH\u0087\b¢\u0006\u0004\bV\u0010WJ\u0010\u0010X\u001a\u00020YH\u0087\b¢\u0006\u0004\bZ\u0010[J\u000f\u0010\\\u001a\u00020]H\u0016¢\u0006\u0004\b^\u0010_J\u0013\u0010`\u001a\u00020\rH\u0087\bø\u0001\u0000¢\u0006\u0004\ba\u0010IJ\u0013\u0010b\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\bc\u0010\u0005J\u0013\u0010d\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\be\u0010WJ\u0013\u0010f\u001a\u00020\u0014H\u0087\bø\u0001\u0000¢\u0006\u0004\bg\u0010[J\u001b\u0010h\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\bi\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006k"}, m23546d2 = {"Lkotlin/UInt;", "", "data", "", "constructor-impl", "(I)I", "data$annotations", "()V", "and", DispatchConstants.OTHER, "and-WZ4Q5Ns", "(II)I", "compareTo", "Lkotlin/UByte;", "compareTo-7apg3OU", "(IB)I", "compareTo-WZ4Q5Ns", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(IJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(IS)I", "dec", "dec-impl", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(IJ)J", "div-xj2QHRw", "equals", "", "", "hashCode", "inc", "inc-impl", "inv", "inv-impl", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or", "or-WZ4Q5Ns", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-WZ4Q5Ns", "(II)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-impl", "shr", "shr-impl", Constants.KEY_TIMES, "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(I)B", "toDouble", "", "toDouble-impl", "(I)D", "toFloat", "", "toFloat-impl", "(I)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(I)J", "toShort", "", "toShort-impl", "(I)S", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "toUByte", "toUByte-impl", "toUInt", "toUInt-impl", "toULong", "toULong-impl", "toUShort", "toUShort-impl", "xor", "xor-WZ4Q5Ns", "Companion", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
@InterfaceC5610t0(version = "1.3")
@InterfaceC5352k
/* renamed from: h.j1 */
/* loaded from: classes2.dex */
public final class C5341j1 implements Comparable<C5341j1> {

    /* renamed from: b */
    public static final int f20219b = 0;

    /* renamed from: c */
    public static final int f20220c = -1;

    /* renamed from: d */
    public static final int f20221d = 4;

    /* renamed from: e */
    public static final int f20222e = 32;

    /* renamed from: f */
    public static final a f20223f = new a(null);

    /* renamed from: a */
    private final int f20224a;

    /* compiled from: UInt.kt */
    /* renamed from: h.j1$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(C5586v c5586v) {
            this();
        }
    }

    @InterfaceC5440n0
    private /* synthetic */ C5341j1(int i2) {
        this.f20224a = i2;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final int m21917a(int i2, byte b2) {
        return C5215b2.m18812a(i2, m21929c(b2 & C5230f1.f20085c));
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final /* synthetic */ C5341j1 m21921a(int i2) {
        return new C5341j1(i2);
    }

    /* renamed from: a */
    public static boolean m21922a(int i2, @InterfaceC5817e Object obj) {
        return (obj instanceof C5341j1) && i2 == ((C5341j1) obj).m21968a();
    }

    @InterfaceC5426f
    /* renamed from: b */
    private int m21923b(int i2) {
        return m21925b(this.f20224a, i2);
    }

    @InterfaceC5440n0
    /* renamed from: b */
    public static /* synthetic */ void m21928b() {
    }

    @InterfaceC5440n0
    /* renamed from: c */
    public static int m21929c(int i2) {
        return i2;
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final int m21930c(int i2, byte b2) {
        return m21929c(i2 - m21929c(b2 & C5230f1.f20085c));
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final int m21935d(int i2, byte b2) {
        return m21929c(i2 + m21929c(b2 & C5230f1.f20085c));
    }

    /* renamed from: d */
    public static final boolean m21938d(int i2, int i3) {
        return i2 == i3;
    }

    /* renamed from: e */
    public static int m21939e(int i2) {
        return i2;
    }

    @InterfaceC5426f
    /* renamed from: e */
    private static final int m21941e(int i2, int i3) {
        return m21929c(i2 - i3);
    }

    @InterfaceC5426f
    /* renamed from: f */
    private static final int m21945f(int i2, byte b2) {
        return m21929c(i2 * m21929c(b2 & C5230f1.f20085c));
    }

    @InterfaceC5426f
    /* renamed from: g */
    private static final int m21950g(int i2, int i3) {
        return m21929c(i2 + i3);
    }

    @InterfaceC5426f
    /* renamed from: h */
    private static final byte m21951h(int i2) {
        return (byte) i2;
    }

    @InterfaceC5426f
    /* renamed from: h */
    private static final C5651t m21952h(int i2, int i3) {
        return new C5651t(i2, i3, null);
    }

    @InterfaceC5426f
    /* renamed from: i */
    private static final int m21954i(int i2, int i3) {
        return C5215b2.m18819c(i2, i3);
    }

    @InterfaceC5426f
    /* renamed from: j */
    private static final int m21956j(int i2, int i3) {
        return m21929c(i2 << i3);
    }

    @InterfaceC5426f
    /* renamed from: k */
    private static final int m21957k(int i2) {
        return i2;
    }

    @InterfaceC5426f
    /* renamed from: k */
    private static final int m21958k(int i2, int i3) {
        return m21929c(i2 >>> i3);
    }

    @InterfaceC5426f
    /* renamed from: l */
    private static final int m21959l(int i2, int i3) {
        return m21929c(i2 * i3);
    }

    @InterfaceC5426f
    /* renamed from: l */
    private static final long m21960l(int i2) {
        return i2 & 4294967295L;
    }

    @InterfaceC5426f
    /* renamed from: m */
    private static final int m21961m(int i2, int i3) {
        return m21929c(i2 ^ i3);
    }

    @InterfaceC5426f
    /* renamed from: m */
    private static final short m21962m(int i2) {
        return (short) i2;
    }

    @InterfaceC5816d
    /* renamed from: n */
    public static String m21963n(int i2) {
        return String.valueOf(i2 & 4294967295L);
    }

    @InterfaceC5426f
    /* renamed from: o */
    private static final byte m21964o(int i2) {
        return C5230f1.m18929c((byte) i2);
    }

    @InterfaceC5426f
    /* renamed from: p */
    private static final int m21965p(int i2) {
        return i2;
    }

    @InterfaceC5426f
    /* renamed from: q */
    private static final long m21966q(int i2) {
        return C5441n1.m22205c(i2 & 4294967295L);
    }

    @InterfaceC5426f
    /* renamed from: r */
    private static final short m21967r(int i2) {
        return C5611t1.m22880c((short) i2);
    }

    /* renamed from: a */
    public final /* synthetic */ int m21968a() {
        return this.f20224a;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(C5341j1 c5341j1) {
        return m21923b(c5341j1.m21968a());
    }

    public boolean equals(Object obj) {
        return m21922a(this.f20224a, obj);
    }

    public int hashCode() {
        return m21939e(this.f20224a);
    }

    @InterfaceC5816d
    public String toString() {
        return m21963n(this.f20224a);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final int m21920a(int i2, short s) {
        return C5215b2.m18812a(i2, m21929c(s & C5611t1.f20467c));
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static int m21925b(int i2, int i3) {
        return C5215b2.m18812a(i2, i3);
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final int m21932c(int i2, short s) {
        return m21929c(i2 - m21929c(s & C5611t1.f20467c));
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final int m21936d(int i2, short s) {
        return m21929c(i2 + m21929c(s & C5611t1.f20467c));
    }

    @InterfaceC5426f
    /* renamed from: e */
    private static final int m21940e(int i2, byte b2) {
        return C5215b2.m18819c(i2, m21929c(b2 & C5230f1.f20085c));
    }

    @InterfaceC5426f
    /* renamed from: f */
    private static final int m21947f(int i2, short s) {
        return m21929c(i2 * m21929c(s & C5611t1.f20467c));
    }

    @InterfaceC5426f
    /* renamed from: g */
    private static final int m21949g(int i2) {
        return m21929c(~i2);
    }

    @InterfaceC5426f
    /* renamed from: i */
    private static final double m21953i(int i2) {
        return C5215b2.m18809a(i2);
    }

    @InterfaceC5426f
    /* renamed from: j */
    private static final float m21955j(int i2) {
        return (float) C5215b2.m18809a(i2);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final int m21919a(int i2, long j2) {
        return C5215b2.m18813a(C5441n1.m22205c(i2 & 4294967295L), j2);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final int m21924b(int i2, byte b2) {
        return C5215b2.m18815b(i2, m21929c(b2 & C5230f1.f20085c));
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final long m21933c(int i2, long j2) {
        return C5441n1.m22205c(C5441n1.m22205c(i2 & 4294967295L) - j2);
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final long m21937d(int i2, long j2) {
        return C5441n1.m22205c(C5441n1.m22205c(i2 & 4294967295L) + j2);
    }

    @InterfaceC5426f
    /* renamed from: e */
    private static final int m21942e(int i2, short s) {
        return C5215b2.m18819c(i2, m21929c(s & C5611t1.f20467c));
    }

    @InterfaceC5426f
    /* renamed from: f */
    private static final long m21948f(int i2, long j2) {
        return C5441n1.m22205c(C5441n1.m22205c(i2 & 4294967295L) * j2);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final int m21918a(int i2, int i3) {
        return m21929c(i2 & i3);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final int m21926b(int i2, short s) {
        return C5215b2.m18815b(i2, m21929c(s & C5611t1.f20467c));
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final int m21931c(int i2, int i3) {
        return C5215b2.m18815b(i2, i3);
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final int m21934d(int i2) {
        return m21929c(i2 - 1);
    }

    @InterfaceC5426f
    /* renamed from: e */
    private static final long m21943e(int i2, long j2) {
        return C5215b2.m18820c(C5441n1.m22205c(i2 & 4294967295L), j2);
    }

    @InterfaceC5426f
    /* renamed from: f */
    private static final int m21944f(int i2) {
        return m21929c(i2 + 1);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final long m21927b(int i2, long j2) {
        return C5215b2.m18817b(C5441n1.m22205c(i2 & 4294967295L), j2);
    }

    @InterfaceC5426f
    /* renamed from: f */
    private static final int m21946f(int i2, int i3) {
        return m21929c(i2 | i3);
    }
}
