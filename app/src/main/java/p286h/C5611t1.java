package p286h;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.taobao.accs.common.Constants;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5586v;
import p286h.p319v2.C5651t;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: UShort.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\n\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001fB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0010J\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0013J\u001b\u0010\u001b\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b \u0010\u0018J\u0013\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\rHÖ\u0001J\u0013\u0010%\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b&\u0010\u0005J\u0013\u0010'\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b(\u0010\u0005J\u001b\u0010)\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b*\u0010\u0010J\u001b\u0010)\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b+\u0010\u0013J\u001b\u0010)\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b,\u0010\u001fJ\u001b\u0010)\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b-\u0010\u0018J\u001b\u0010.\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b/\u0010\u000bJ\u001b\u00100\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b1\u0010\u0010J\u001b\u00100\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b2\u0010\u0013J\u001b\u00100\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u001fJ\u001b\u00100\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b4\u0010\u0018J\u001b\u00105\u001a\u0002062\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b7\u00108J\u001b\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b:\u0010\u0010J\u001b\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b;\u0010\u0013J\u001b\u00109\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b<\u0010\u001fJ\u001b\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b=\u0010\u0018J\u001b\u0010>\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b?\u0010\u0010J\u001b\u0010>\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b@\u0010\u0013J\u001b\u0010>\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\bA\u0010\u001fJ\u001b\u0010>\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bB\u0010\u0018J\u0010\u0010C\u001a\u00020DH\u0087\b¢\u0006\u0004\bE\u0010FJ\u0010\u0010G\u001a\u00020HH\u0087\b¢\u0006\u0004\bI\u0010JJ\u0010\u0010K\u001a\u00020LH\u0087\b¢\u0006\u0004\bM\u0010NJ\u0010\u0010O\u001a\u00020\rH\u0087\b¢\u0006\u0004\bP\u0010QJ\u0010\u0010R\u001a\u00020SH\u0087\b¢\u0006\u0004\bT\u0010UJ\u0010\u0010V\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bW\u0010\u0005J\u000f\u0010X\u001a\u00020YH\u0016¢\u0006\u0004\bZ\u0010[J\u0013\u0010\\\u001a\u00020\u000eH\u0087\bø\u0001\u0000¢\u0006\u0004\b]\u0010FJ\u0013\u0010^\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\b_\u0010QJ\u0013\u0010`\u001a\u00020\u0014H\u0087\bø\u0001\u0000¢\u0006\u0004\ba\u0010UJ\u0013\u0010b\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\bc\u0010\u0005J\u001b\u0010d\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\be\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006g"}, m23546d2 = {"Lkotlin/UShort;", "", "data", "", "constructor-impl", "(S)S", "data$annotations", "()V", "and", DispatchConstants.OTHER, "and-xj2QHRw", "(SS)S", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(SB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "compareTo-xj2QHRw", "(SS)I", "dec", "dec-impl", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(SJ)J", "div-xj2QHRw", "equals", "", "", "hashCode", "inc", "inc-impl", "inv", "inv-impl", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or", "or-xj2QHRw", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", Constants.KEY_TIMES, "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(S)B", "toDouble", "", "toDouble-impl", "(S)D", "toFloat", "", "toFloat-impl", "(S)F", "toInt", "toInt-impl", "(S)I", "toLong", "", "toLong-impl", "(S)J", "toShort", "toShort-impl", "toString", "", "toString-impl", "(S)Ljava/lang/String;", "toUByte", "toUByte-impl", "toUInt", "toUInt-impl", "toULong", "toULong-impl", "toUShort", "toUShort-impl", "xor", "xor-xj2QHRw", "Companion", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
@InterfaceC5610t0(version = "1.3")
@InterfaceC5352k
/* renamed from: h.t1 */
/* loaded from: classes2.dex */
public final class C5611t1 implements Comparable<C5611t1> {

    /* renamed from: b */
    public static final short f20466b = 0;

    /* renamed from: c */
    public static final short f20467c = -1;

    /* renamed from: d */
    public static final int f20468d = 2;

    /* renamed from: e */
    public static final int f20469e = 16;

    /* renamed from: f */
    public static final a f20470f = new a(null);

    /* renamed from: a */
    private final short f20471a;

    /* compiled from: UShort.kt */
    /* renamed from: h.t1$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(C5586v c5586v) {
            this();
        }
    }

    @InterfaceC5440n0
    private /* synthetic */ C5611t1(short s) {
        this.f20471a = s;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final int m22864a(short s, byte b2) {
        return C5544i0.m22512a(s & f20467c, b2 & C5230f1.f20085c);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final /* synthetic */ C5611t1 m22867a(short s) {
        return new C5611t1(s);
    }

    /* renamed from: a */
    public static boolean m22869a(short s, @InterfaceC5817e Object obj) {
        return (obj instanceof C5611t1) && s == ((C5611t1) obj).m22913a();
    }

    @InterfaceC5426f
    /* renamed from: b */
    private int m22870b(short s) {
        return m22873b(this.f20471a, s);
    }

    @InterfaceC5440n0
    /* renamed from: b */
    public static /* synthetic */ void m22875b() {
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final int m22876c(short s, byte b2) {
        return C5341j1.m21929c(C5341j1.m21929c(s & f20467c) - C5341j1.m21929c(b2 & C5230f1.f20085c));
    }

    @InterfaceC5440n0
    /* renamed from: c */
    public static short m22880c(short s) {
        return s;
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final int m22881d(short s, byte b2) {
        return C5341j1.m21929c(C5341j1.m21929c(s & f20467c) + C5341j1.m21929c(b2 & C5230f1.f20085c));
    }

    /* renamed from: d */
    public static final boolean m22885d(short s, short s2) {
        return s == s2;
    }

    /* renamed from: e */
    public static int m22886e(short s) {
        return s;
    }

    @InterfaceC5426f
    /* renamed from: e */
    private static final int m22889e(short s, short s2) {
        return C5341j1.m21929c(C5341j1.m21929c(s & f20467c) - C5341j1.m21929c(s2 & f20467c));
    }

    @InterfaceC5426f
    /* renamed from: f */
    private static final int m22891f(short s, byte b2) {
        return C5341j1.m21929c(C5341j1.m21929c(s & f20467c) * C5341j1.m21929c(b2 & C5230f1.f20085c));
    }

    @InterfaceC5426f
    /* renamed from: g */
    private static final int m22896g(short s, short s2) {
        return C5341j1.m21929c(C5341j1.m21929c(s & f20467c) + C5341j1.m21929c(s2 & f20467c));
    }

    @InterfaceC5426f
    /* renamed from: h */
    private static final byte m22898h(short s) {
        return (byte) s;
    }

    @InterfaceC5426f
    /* renamed from: h */
    private static final C5651t m22899h(short s, short s2) {
        return new C5651t(C5341j1.m21929c(s & f20467c), C5341j1.m21929c(s2 & f20467c), null);
    }

    @InterfaceC5426f
    /* renamed from: i */
    private static final double m22900i(short s) {
        return s & f20467c;
    }

    @InterfaceC5426f
    /* renamed from: i */
    private static final int m22901i(short s, short s2) {
        return C5215b2.m18819c(C5341j1.m21929c(s & f20467c), C5341j1.m21929c(s2 & f20467c));
    }

    @InterfaceC5426f
    /* renamed from: j */
    private static final float m22902j(short s) {
        return s & f20467c;
    }

    @InterfaceC5426f
    /* renamed from: j */
    private static final int m22903j(short s, short s2) {
        return C5341j1.m21929c(C5341j1.m21929c(s & f20467c) * C5341j1.m21929c(s2 & f20467c));
    }

    @InterfaceC5426f
    /* renamed from: k */
    private static final int m22904k(short s) {
        return s & f20467c;
    }

    @InterfaceC5426f
    /* renamed from: k */
    private static final short m22905k(short s, short s2) {
        return m22880c((short) (s ^ s2));
    }

    @InterfaceC5426f
    /* renamed from: l */
    private static final long m22906l(short s) {
        return s & 65535;
    }

    @InterfaceC5426f
    /* renamed from: m */
    private static final short m22907m(short s) {
        return s;
    }

    @InterfaceC5816d
    /* renamed from: n */
    public static String m22908n(short s) {
        return String.valueOf(s & f20467c);
    }

    @InterfaceC5426f
    /* renamed from: o */
    private static final byte m22909o(short s) {
        return C5230f1.m18929c((byte) s);
    }

    @InterfaceC5426f
    /* renamed from: p */
    private static final int m22910p(short s) {
        return C5341j1.m21929c(s & f20467c);
    }

    @InterfaceC5426f
    /* renamed from: q */
    private static final long m22911q(short s) {
        return C5441n1.m22205c(s & 65535);
    }

    @InterfaceC5426f
    /* renamed from: r */
    private static final short m22912r(short s) {
        return s;
    }

    /* renamed from: a */
    public final /* synthetic */ short m22913a() {
        return this.f20471a;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(C5611t1 c5611t1) {
        return m22870b(c5611t1.m22913a());
    }

    public boolean equals(Object obj) {
        return m22869a(this.f20471a, obj);
    }

    public int hashCode() {
        return m22886e(this.f20471a);
    }

    @InterfaceC5816d
    public String toString() {
        return m22908n(this.f20471a);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final int m22865a(short s, int i2) {
        return C5215b2.m18812a(C5341j1.m21929c(s & f20467c), i2);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static int m22873b(short s, short s2) {
        return C5544i0.m22512a(s & f20467c, s2 & f20467c);
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final int m22877c(short s, int i2) {
        return C5341j1.m21929c(C5341j1.m21929c(s & f20467c) - i2);
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final int m22882d(short s, int i2) {
        return C5341j1.m21929c(C5341j1.m21929c(s & f20467c) + i2);
    }

    @InterfaceC5426f
    /* renamed from: e */
    private static final int m22887e(short s, byte b2) {
        return C5215b2.m18819c(C5341j1.m21929c(s & f20467c), C5341j1.m21929c(b2 & C5230f1.f20085c));
    }

    @InterfaceC5426f
    /* renamed from: f */
    private static final int m22892f(short s, int i2) {
        return C5341j1.m21929c(C5341j1.m21929c(s & f20467c) * i2);
    }

    @InterfaceC5426f
    /* renamed from: g */
    private static final short m22897g(short s) {
        return m22880c((short) (~s));
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final int m22866a(short s, long j2) {
        return C5215b2.m18813a(C5441n1.m22205c(s & 65535), j2);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final int m22871b(short s, byte b2) {
        return C5215b2.m18815b(C5341j1.m21929c(s & f20467c), C5341j1.m21929c(b2 & C5230f1.f20085c));
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final long m22879c(short s, long j2) {
        return C5441n1.m22205c(C5441n1.m22205c(s & 65535) - j2);
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final long m22883d(short s, long j2) {
        return C5441n1.m22205c(C5441n1.m22205c(s & 65535) + j2);
    }

    @InterfaceC5426f
    /* renamed from: e */
    private static final int m22888e(short s, int i2) {
        return C5215b2.m18819c(C5341j1.m21929c(s & f20467c), i2);
    }

    @InterfaceC5426f
    /* renamed from: f */
    private static final long m22893f(short s, long j2) {
        return C5441n1.m22205c(C5441n1.m22205c(s & 65535) * j2);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final short m22868a(short s, short s2) {
        return m22880c((short) (s & s2));
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final int m22872b(short s, int i2) {
        return C5215b2.m18815b(C5341j1.m21929c(s & f20467c), i2);
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final int m22878c(short s, short s2) {
        return C5215b2.m18815b(C5341j1.m21929c(s & f20467c), C5341j1.m21929c(s2 & f20467c));
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final short m22884d(short s) {
        return m22880c((short) (s - 1));
    }

    @InterfaceC5426f
    /* renamed from: e */
    private static final long m22890e(short s, long j2) {
        return C5215b2.m18820c(C5441n1.m22205c(s & 65535), j2);
    }

    @InterfaceC5426f
    /* renamed from: f */
    private static final short m22894f(short s) {
        return m22880c((short) (s + 1));
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final long m22874b(short s, long j2) {
        return C5215b2.m18817b(C5441n1.m22205c(s & 65535), j2);
    }

    @InterfaceC5426f
    /* renamed from: f */
    private static final short m22895f(short s, short s2) {
        return m22880c((short) (s | s2));
    }
}
