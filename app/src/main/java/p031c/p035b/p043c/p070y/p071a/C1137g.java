package p031c.p035b.p043c.p070y.p071a;

import com.heytap.mcssdk.constant.C2084a;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: CalendarParsedResult.java */
/* renamed from: c.b.c.y.a.g */
/* loaded from: classes.dex */
public final class C1137g extends AbstractC1152q {

    /* renamed from: m */
    private static final Pattern f2311m = Pattern.compile("P(?:(\\d+)W)?(?:(\\d+)D)?(?:T(?:(\\d+)H)?(?:(\\d+)M)?(?:(\\d+)S)?)?");

    /* renamed from: n */
    private static final long[] f2312n = {604800000, 86400000, C2084a.f6123e, C2084a.f6122d, 1000};

    /* renamed from: o */
    private static final Pattern f2313o = Pattern.compile("[0-9]{8}(T[0-9]{6}Z?)?");

    /* renamed from: b */
    private final String f2314b;

    /* renamed from: c */
    private final Date f2315c;

    /* renamed from: d */
    private final boolean f2316d;

    /* renamed from: e */
    private final Date f2317e;

    /* renamed from: f */
    private final boolean f2318f;

    /* renamed from: g */
    private final String f2319g;

    /* renamed from: h */
    private final String f2320h;

    /* renamed from: i */
    private final String[] f2321i;

    /* renamed from: j */
    private final String f2322j;

    /* renamed from: k */
    private final double f2323k;

    /* renamed from: l */
    private final double f2324l;

    public C1137g(String str, String str2, String str3, String str4, String str5, String str6, String[] strArr, String str7, double d2, double d3) {
        super(EnumC1153r.CALENDAR);
        this.f2314b = str;
        try {
            this.f2315c = m2046a(str2);
            if (str3 == null) {
                long m2044a = m2044a((CharSequence) str4);
                this.f2317e = m2044a < 0 ? null : new Date(this.f2315c.getTime() + m2044a);
            } else {
                try {
                    this.f2317e = m2046a(str3);
                } catch (ParseException e2) {
                    throw new IllegalArgumentException(e2.toString());
                }
            }
            boolean z = false;
            this.f2316d = str2.length() == 8;
            if (str3 != null && str3.length() == 8) {
                z = true;
            }
            this.f2318f = z;
            this.f2319g = str5;
            this.f2320h = str6;
            this.f2321i = strArr;
            this.f2322j = str7;
            this.f2323k = d2;
            this.f2324l = d3;
        } catch (ParseException e3) {
            throw new IllegalArgumentException(e3.toString());
        }
    }

    /* renamed from: n */
    private static DateFormat m2047n() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    /* renamed from: o */
    private static DateFormat m2048o() {
        return new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.ENGLISH);
    }

    @Override // p031c.p035b.p043c.p070y.p071a.AbstractC1152q
    /* renamed from: a */
    public String mo2006a() {
        StringBuilder sb = new StringBuilder(100);
        AbstractC1152q.m2115a(this.f2314b, sb);
        AbstractC1152q.m2115a(m2045a(this.f2316d, this.f2315c), sb);
        AbstractC1152q.m2115a(m2045a(this.f2318f, this.f2317e), sb);
        AbstractC1152q.m2115a(this.f2319g, sb);
        AbstractC1152q.m2115a(this.f2320h, sb);
        AbstractC1152q.m2116a(this.f2321i, sb);
        AbstractC1152q.m2115a(this.f2322j, sb);
        return sb.toString();
    }

    /* renamed from: c */
    public String[] m2049c() {
        return this.f2321i;
    }

    /* renamed from: d */
    public String m2050d() {
        return this.f2322j;
    }

    /* renamed from: e */
    public Date m2051e() {
        return this.f2317e;
    }

    /* renamed from: f */
    public double m2052f() {
        return this.f2323k;
    }

    /* renamed from: g */
    public String m2053g() {
        return this.f2319g;
    }

    /* renamed from: h */
    public double m2054h() {
        return this.f2324l;
    }

    /* renamed from: i */
    public String m2055i() {
        return this.f2320h;
    }

    /* renamed from: j */
    public Date m2056j() {
        return this.f2315c;
    }

    /* renamed from: k */
    public String m2057k() {
        return this.f2314b;
    }

    /* renamed from: l */
    public boolean m2058l() {
        return this.f2318f;
    }

    /* renamed from: m */
    public boolean m2059m() {
        return this.f2316d;
    }

    /* renamed from: a */
    private static Date m2046a(String str) throws ParseException {
        if (f2313o.matcher(str).matches()) {
            if (str.length() == 8) {
                return m2047n().parse(str);
            }
            if (str.length() == 16 && str.charAt(15) == 'Z') {
                Date parse = m2048o().parse(str.substring(0, 15));
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                long time = parse.getTime() + gregorianCalendar.get(15);
                gregorianCalendar.setTime(new Date(time));
                return new Date(time + gregorianCalendar.get(16));
            }
            return m2048o().parse(str);
        }
        throw new ParseException(str, 0);
    }

    /* renamed from: a */
    private static String m2045a(boolean z, Date date) {
        DateFormat dateTimeInstance;
        if (date == null) {
            return null;
        }
        if (z) {
            dateTimeInstance = DateFormat.getDateInstance(2);
        } else {
            dateTimeInstance = DateFormat.getDateTimeInstance(2, 2);
        }
        return dateTimeInstance.format(date);
    }

    /* renamed from: a */
    private static long m2044a(CharSequence charSequence) {
        if (charSequence == null) {
            return -1L;
        }
        Matcher matcher = f2311m.matcher(charSequence);
        if (!matcher.matches()) {
            return -1L;
        }
        long j2 = 0;
        int i2 = 0;
        while (i2 < f2312n.length) {
            int i3 = i2 + 1;
            if (matcher.group(i3) != null) {
                j2 += f2312n[i2] * Integer.parseInt(r4);
            }
            i2 = i3;
        }
        return j2;
    }
}
