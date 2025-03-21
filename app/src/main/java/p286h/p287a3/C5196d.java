package p286h.p287a3;

import androidx.exifinterface.media.ExifInterface;
import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import com.taobao.accs.common.Constants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.concurrent.TimeUnit;
import p286h.InterfaceC5440n0;
import p286h.InterfaceC5610t0;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p310s.InterfaceC5511q;
import p286h.p309q2.p310s.InterfaceC5512r;
import p286h.p309q2.p310s.InterfaceC5513s;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5586v;
import p286h.p309q2.p311t.C5588w;
import p286h.p319v2.C5648q;
import p286h.p323z2.C5726c0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Duration.kt */
@InterfaceC5202j
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0087@\u0018\u0000 s2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001sB\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u0000H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u001b\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0003H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u001b\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\tH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010-J\u001b\u0010)\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b.\u0010,J\u0013\u0010/\u001a\u0002002\b\u0010&\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\tHÖ\u0001J\r\u00103\u001a\u000200¢\u0006\u0004\b4\u00105J\r\u00106\u001a\u000200¢\u0006\u0004\b7\u00105J\r\u00108\u001a\u000200¢\u0006\u0004\b9\u00105J\r\u0010:\u001a\u000200¢\u0006\u0004\b;\u00105J\u001b\u0010<\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b=\u0010,J\u001b\u0010>\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b?\u0010,J\u0017\u0010@\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0004\bA\u0010(J\u001b\u0010B\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0003H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bC\u0010,J\u001b\u0010B\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\tH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bC\u0010-J\u008d\u0001\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E2u\u0010F\u001aq\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(J\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(K\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HE0GH\u0086\b¢\u0006\u0004\bO\u0010PJx\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E2`\u0010F\u001a\\\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(K\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HE0QH\u0086\b¢\u0006\u0004\bO\u0010RJc\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E2K\u0010F\u001aG\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HE0SH\u0086\b¢\u0006\u0004\bO\u0010TJN\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E26\u0010F\u001a2\u0012\u0013\u0012\u00110V¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HE0UH\u0086\b¢\u0006\u0004\bO\u0010WJ\u0019\u0010X\u001a\u00020\u00032\n\u0010Y\u001a\u00060Zj\u0002`[¢\u0006\u0004\b\\\u0010]J\u0019\u0010^\u001a\u00020\t2\n\u0010Y\u001a\u00060Zj\u0002`[¢\u0006\u0004\b_\u0010`J\r\u0010a\u001a\u00020b¢\u0006\u0004\bc\u0010dJ\u0019\u0010e\u001a\u00020V2\n\u0010Y\u001a\u00060Zj\u0002`[¢\u0006\u0004\bf\u0010gJ\r\u0010h\u001a\u00020V¢\u0006\u0004\bi\u0010jJ\r\u0010k\u001a\u00020V¢\u0006\u0004\bl\u0010jJ\u000f\u0010m\u001a\u00020bH\u0016¢\u0006\u0004\bn\u0010dJ#\u0010m\u001a\u00020b2\n\u0010Y\u001a\u00060Zj\u0002`[2\b\b\u0002\u0010o\u001a\u00020\t¢\u0006\u0004\bn\u0010pJ\u0013\u0010q\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\br\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00008Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u001a\u0010\b\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u0011\u0010\u0012\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005R\u0011\u0010\u0014\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0005R\u0011\u0010\u0016\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0005R\u0011\u0010\u0018\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0005R\u0011\u0010\u001a\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0005R\u001a\u0010\u001c\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\rR\u001a\u0010\u001f\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\rR\u001a\u0010\"\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006t"}, m23546d2 = {"Lkotlin/time/Duration;", "", SurveyH5Bean.VALUE, "", "constructor-impl", "(D)D", "absoluteValue", "getAbsoluteValue-impl", "hoursComponent", "", "hoursComponent$annotations", "()V", "getHoursComponent-impl", "(D)I", "inDays", "getInDays-impl", "inHours", "getInHours-impl", "inMicroseconds", "getInMicroseconds-impl", "inMilliseconds", "getInMilliseconds-impl", "inMinutes", "getInMinutes-impl", "inNanoseconds", "getInNanoseconds-impl", "inSeconds", "getInSeconds-impl", "minutesComponent", "minutesComponent$annotations", "getMinutesComponent-impl", "nanosecondsComponent", "nanosecondsComponent$annotations", "getNanosecondsComponent-impl", "secondsComponent", "secondsComponent$annotations", "getSecondsComponent-impl", "compareTo", DispatchConstants.OTHER, "compareTo-LRDsOJo", "(DD)I", "div", "scale", "div-impl", "(DD)D", "(DI)D", "div-LRDsOJo", "equals", "", "", "hashCode", "isFinite", "isFinite-impl", "(D)Z", "isInfinite", "isInfinite-impl", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "minus", "minus-LRDsOJo", "plus", "plus-LRDsOJo", "precision", "precision-impl", Constants.KEY_TIMES, "times-impl", "toComponents", ExifInterface.GPS_DIRECTION_TRUE, "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "days", "hours", "minutes", "seconds", "nanoseconds", "toComponents-impl", "(DLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "(DLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(DLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "", "(DLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toDouble", "unit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "toDouble-impl", "(DLjava/util/concurrent/TimeUnit;)D", "toInt", "toInt-impl", "(DLjava/util/concurrent/TimeUnit;)I", "toIsoString", "", "toIsoString-impl", "(D)Ljava/lang/String;", "toLong", "toLong-impl", "(DLjava/util/concurrent/TimeUnit;)J", "toLongMilliseconds", "toLongMilliseconds-impl", "(D)J", "toLongNanoseconds", "toLongNanoseconds-impl", "toString", "toString-impl", "decimals", "(DLjava/util/concurrent/TimeUnit;I)Ljava/lang/String;", "unaryMinus", "unaryMinus-impl", "Companion", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
@InterfaceC5610t0(version = "1.3")
/* renamed from: h.a3.d */
/* loaded from: classes2.dex */
public final class C5196d implements Comparable<C5196d> {

    /* renamed from: a */
    private final double f20067a;

    /* renamed from: d */
    public static final a f20066d = new a(null);

    /* renamed from: b */
    private static final double f20064b = m18690c(0.0d);

    /* renamed from: c */
    private static final double f20065c = m18690c(C5588w.f20440f.m22693e());

    /* compiled from: Duration.kt */
    /* renamed from: h.a3.d$a */
    public static final class a {
        private a() {
        }

        /* renamed from: a */
        public final double m18726a() {
            return C5196d.f20065c;
        }

        /* renamed from: b */
        public final double m18728b() {
            return C5196d.f20064b;
        }

        public /* synthetic */ a(C5586v c5586v) {
            this();
        }

        /* renamed from: a */
        public final double m18727a(double d2, @InterfaceC5816d TimeUnit timeUnit, @InterfaceC5816d TimeUnit timeUnit2) {
            C5544i0.m22546f(timeUnit, "sourceUnit");
            C5544i0.m22546f(timeUnit2, "targetUnit");
            return C5200h.m18779a(d2, timeUnit, timeUnit2);
        }
    }

    private /* synthetic */ C5196d(double d2) {
        this.f20067a = d2;
    }

    /* renamed from: a */
    public static boolean m18683a(double d2, @InterfaceC5817e Object obj) {
        return (obj instanceof C5196d) && Double.compare(d2, ((C5196d) obj).m18724a()) == 0;
    }

    /* renamed from: b */
    public static final double m18685b(double d2, double d3) {
        return d2 / d3;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final /* synthetic */ C5196d m18688b(double d2) {
        return new C5196d(d2);
    }

    /* renamed from: c */
    public static double m18690c(double d2) {
        return d2;
    }

    /* renamed from: d */
    public static final double m18693d(double d2) {
        return m18717s(d2) ? m18723y(d2) : d2;
    }

    @InterfaceC5440n0
    /* renamed from: d */
    public static /* synthetic */ void m18694d() {
    }

    /* renamed from: d */
    public static final boolean m18695d(double d2, double d3) {
        return Double.compare(d2, d3) == 0;
    }

    /* renamed from: e */
    public static final double m18696e(double d2, double d3) {
        return m18690c(d2 - d3);
    }

    @InterfaceC5440n0
    /* renamed from: e */
    public static /* synthetic */ void m18698e() {
    }

    /* renamed from: f */
    public static final double m18700f(double d2, double d3) {
        return m18690c(d2 + d3);
    }

    @InterfaceC5440n0
    /* renamed from: f */
    public static /* synthetic */ void m18701f() {
    }

    /* renamed from: g */
    public static final double m18702g(double d2) {
        return m18675a(d2, TimeUnit.HOURS);
    }

    /* renamed from: g */
    private static final int m18703g(double d2, double d3) {
        if (d3 < 1) {
            return 3;
        }
        if (d3 < 10) {
            return 2;
        }
        return d3 < ((double) 100) ? 1 : 0;
    }

    @InterfaceC5440n0
    /* renamed from: g */
    public static /* synthetic */ void m18704g() {
    }

    /* renamed from: h */
    public static final double m18706h(double d2, double d3) {
        return m18690c(d2 * d3);
    }

    /* renamed from: i */
    public static final double m18707i(double d2) {
        return m18675a(d2, TimeUnit.MILLISECONDS);
    }

    /* renamed from: j */
    public static final double m18708j(double d2) {
        return m18675a(d2, TimeUnit.MINUTES);
    }

    /* renamed from: k */
    public static final double m18709k(double d2) {
        return m18675a(d2, TimeUnit.NANOSECONDS);
    }

    /* renamed from: l */
    public static final double m18710l(double d2) {
        return m18675a(d2, TimeUnit.SECONDS);
    }

    /* renamed from: m */
    public static final int m18711m(double d2) {
        return (int) (m18708j(d2) % 60);
    }

    /* renamed from: n */
    public static final int m18712n(double d2) {
        return (int) (m18709k(d2) % 1.0E9d);
    }

    /* renamed from: o */
    public static final int m18713o(double d2) {
        return (int) (m18710l(d2) % 60);
    }

    /* renamed from: p */
    public static int m18714p(double d2) {
        long doubleToLongBits = Double.doubleToLongBits(d2);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    /* renamed from: q */
    public static final boolean m18715q(double d2) {
        return (Double.isInfinite(d2) || Double.isNaN(d2)) ? false : true;
    }

    /* renamed from: r */
    public static final boolean m18716r(double d2) {
        return Double.isInfinite(d2);
    }

    /* renamed from: s */
    public static final boolean m18717s(double d2) {
        return d2 < ((double) 0);
    }

    /* renamed from: t */
    public static final boolean m18718t(double d2) {
        return d2 > ((double) 0);
    }

    @InterfaceC5816d
    /* renamed from: u */
    public static final String m18719u(double d2) {
        StringBuilder sb = new StringBuilder();
        if (m18717s(d2)) {
            sb.append('-');
        }
        sb.append("PT");
        double m18693d = m18693d(d2);
        int m18702g = (int) m18702g(m18693d);
        int m18711m = m18711m(m18693d);
        int m18713o = m18713o(m18693d);
        int m18712n = m18712n(m18693d);
        boolean z = true;
        boolean z2 = m18702g != 0;
        boolean z3 = (m18713o == 0 && m18712n == 0) ? false : true;
        if (m18711m == 0 && (!z3 || !z2)) {
            z = false;
        }
        if (z2) {
            sb.append(m18702g);
            sb.append('H');
        }
        if (z) {
            sb.append(m18711m);
            sb.append('M');
        }
        if (z3 || (!z2 && !z)) {
            sb.append(m18713o);
            if (m18712n != 0) {
                sb.append('.');
                String m23738b = C5726c0.m23738b(String.valueOf(m18712n), 9, '0');
                if (m18712n % 1000000 == 0) {
                    sb.append((CharSequence) m23738b, 0, 3);
                    C5544i0.m22521a((Object) sb, "this.append(value, startIndex, endIndex)");
                } else if (m18712n % 1000 == 0) {
                    sb.append((CharSequence) m23738b, 0, 6);
                    C5544i0.m22521a((Object) sb, "this.append(value, startIndex, endIndex)");
                } else {
                    sb.append(m23738b);
                }
            }
            sb.append('S');
        }
        String sb2 = sb.toString();
        C5544i0.m22521a((Object) sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* renamed from: v */
    public static final long m18720v(double d2) {
        return m18692c(d2, TimeUnit.MILLISECONDS);
    }

    /* renamed from: w */
    public static final long m18721w(double d2) {
        return m18692c(d2, TimeUnit.NANOSECONDS);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009f  */
    @p324i.p336c.p337a.InterfaceC5816d
    /* renamed from: x */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m18722x(double r8) {
        /*
            boolean r0 = m18716r(r8)
            if (r0 == 0) goto Lc
            java.lang.String r8 = java.lang.String.valueOf(r8)
            goto Lc0
        Lc:
            r0 = 0
            int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r2 != 0) goto L16
            java.lang.String r8 = "0s"
            goto Lc0
        L16:
            double r0 = m18693d(r8)
            double r0 = m18709k(r0)
            r2 = 4517329193108106637(0x3eb0c6f7a0b5ed8d, double:1.0E-6)
            r4 = 0
            r5 = 1
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L2e
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS
        L2b:
            r1 = 0
            r4 = 1
            goto L8f
        L2e:
            double r2 = (double) r5
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L37
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.NANOSECONDS
            r1 = 7
            goto L8f
        L37:
            r2 = 4652007308841189376(0x408f400000000000, double:1000.0)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L44
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.NANOSECONDS
        L42:
            r1 = 0
            goto L8f
        L44:
            r2 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L50
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MICROSECONDS
            goto L42
        L50:
            r2 = 4741671816366391296(0x41cdcd6500000000, double:1.0E9)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L5c
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS
            goto L42
        L5c:
            r2 = 4786511204640096256(0x426d1a94a2000000, double:1.0E12)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L68
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS
            goto L42
        L68:
            r2 = 4813020802404319232(0x42cb48eb57e00000, double:6.0E13)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L74
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MINUTES
            goto L42
        L74:
            r2 = 4839562400168542208(0x4329945ca2620000, double:3.6E15)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L80
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.HOURS
            goto L42
        L80:
            r2 = 4920018990336211136(0x44476b344f2a78c0, double:8.64E20)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L8c
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.DAYS
            goto L42
        L8c:
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.DAYS
            goto L2b
        L8f:
            double r2 = m18675a(r8, r0)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            if (r4 == 0) goto L9f
            java.lang.String r8 = p286h.p287a3.C5203k.m18782a(r2)
            goto Lb2
        L9f:
            if (r1 <= 0) goto La6
            java.lang.String r8 = p286h.p287a3.C5203k.m18785b(r2, r1)
            goto Lb2
        La6:
            double r6 = java.lang.Math.abs(r2)
            int r8 = m18703g(r8, r6)
            java.lang.String r8 = p286h.p287a3.C5203k.m18783a(r2, r8)
        Lb2:
            r5.append(r8)
            java.lang.String r8 = p286h.p287a3.C5201i.m18781a(r0)
            r5.append(r8)
            java.lang.String r8 = r5.toString()
        Lc0:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p286h.p287a3.C5196d.m18722x(double):java.lang.String");
    }

    /* renamed from: y */
    public static final double m18723y(double d2) {
        return m18690c(-d2);
    }

    /* renamed from: a */
    public final /* synthetic */ double m18724a() {
        return this.f20067a;
    }

    /* renamed from: a */
    public int m18725a(double d2) {
        return m18676a(this.f20067a, d2);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(C5196d c5196d) {
        return m18725a(c5196d.m18724a());
    }

    public boolean equals(Object obj) {
        return m18683a(this.f20067a, obj);
    }

    public int hashCode() {
        return m18714p(this.f20067a);
    }

    @InterfaceC5816d
    public String toString() {
        return m18722x(this.f20067a);
    }

    /* renamed from: a */
    public static final double m18674a(double d2, int i2) {
        return m18690c(d2 / i2);
    }

    /* renamed from: b */
    public static final double m18686b(double d2, int i2) {
        return m18690c(d2 * i2);
    }

    /* renamed from: c */
    public static final double m18691c(double d2, double d3) {
        return m18690c(d2 / d3);
    }

    /* renamed from: e */
    public static final int m18697e(double d2) {
        return (int) (m18702g(d2) % 24);
    }

    /* renamed from: f */
    public static final double m18699f(double d2) {
        return m18675a(d2, TimeUnit.DAYS);
    }

    /* renamed from: h */
    public static final double m18705h(double d2) {
        return m18675a(d2, TimeUnit.MICROSECONDS);
    }

    /* renamed from: a */
    public static int m18676a(double d2, double d3) {
        return Double.compare(d2, d3);
    }

    /* renamed from: b */
    public static final int m18687b(double d2, @InterfaceC5816d TimeUnit timeUnit) {
        C5544i0.m22546f(timeUnit, "unit");
        return (int) m18675a(d2, timeUnit);
    }

    /* renamed from: c */
    public static final long m18692c(double d2, @InterfaceC5816d TimeUnit timeUnit) {
        C5544i0.m22546f(timeUnit, "unit");
        return (long) m18675a(d2, timeUnit);
    }

    /* renamed from: a */
    public static final <T> T m18680a(double d2, @InterfaceC5816d InterfaceC5513s<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> interfaceC5513s) {
        C5544i0.m22546f(interfaceC5513s, "action");
        return interfaceC5513s.invoke(Integer.valueOf((int) m18699f(d2)), Integer.valueOf(m18697e(d2)), Integer.valueOf(m18711m(d2)), Integer.valueOf(m18713o(d2)), Integer.valueOf(m18712n(d2)));
    }

    /* renamed from: a */
    public static final <T> T m18679a(double d2, @InterfaceC5816d InterfaceC5512r<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> interfaceC5512r) {
        C5544i0.m22546f(interfaceC5512r, "action");
        return interfaceC5512r.invoke(Integer.valueOf((int) m18702g(d2)), Integer.valueOf(m18711m(d2)), Integer.valueOf(m18713o(d2)), Integer.valueOf(m18712n(d2)));
    }

    /* renamed from: a */
    public static final <T> T m18678a(double d2, @InterfaceC5816d InterfaceC5511q<? super Integer, ? super Integer, ? super Integer, ? extends T> interfaceC5511q) {
        C5544i0.m22546f(interfaceC5511q, "action");
        return interfaceC5511q.invoke(Integer.valueOf((int) m18708j(d2)), Integer.valueOf(m18713o(d2)), Integer.valueOf(m18712n(d2)));
    }

    /* renamed from: a */
    public static final <T> T m18677a(double d2, @InterfaceC5816d InterfaceC5510p<? super Long, ? super Integer, ? extends T> interfaceC5510p) {
        C5544i0.m22546f(interfaceC5510p, "action");
        return interfaceC5510p.invoke(Long.valueOf((long) m18710l(d2)), Integer.valueOf(m18712n(d2)));
    }

    /* renamed from: a */
    public static final double m18675a(double d2, @InterfaceC5816d TimeUnit timeUnit) {
        TimeUnit m18741b;
        C5544i0.m22546f(timeUnit, "unit");
        m18741b = C5197e.m18741b();
        return C5200h.m18779a(d2, m18741b, timeUnit);
    }

    /* renamed from: a */
    public static /* synthetic */ String m18682a(double d2, TimeUnit timeUnit, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return m18681a(d2, timeUnit, i2);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final String m18681a(double d2, @InterfaceC5816d TimeUnit timeUnit, int i2) {
        String m18782a;
        int m23101b;
        C5544i0.m22546f(timeUnit, "unit");
        if (i2 >= 0) {
            if (m18716r(d2)) {
                return String.valueOf(d2);
            }
            double m18675a = m18675a(d2, timeUnit);
            StringBuilder sb = new StringBuilder();
            if (Math.abs(m18675a) < 1.0E14d) {
                m23101b = C5648q.m23101b(i2, 12);
                m18782a = C5203k.m18783a(m18675a, m23101b);
            } else {
                m18782a = C5203k.m18782a(m18675a);
            }
            sb.append(m18782a);
            sb.append(C5201i.m18781a(timeUnit));
            return sb.toString();
        }
        throw new IllegalArgumentException(("decimals must be not negative, but was " + i2).toString());
    }
}
