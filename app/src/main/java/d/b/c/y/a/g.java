package d.b.c.y.a;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: CalendarParsedResult.java */
/* JADX INFO: loaded from: classes.dex */
public final class g extends q {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Pattern f9926m = Pattern.compile("P(?:(\\d+)W)?(?:(\\d+)D)?(?:T(?:(\\d+)H)?(?:(\\d+)M)?(?:(\\d+)S)?)?");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final long[] f9927n = {604800000, 86400000, com.heytap.mcssdk.constant.a.f3869e, com.heytap.mcssdk.constant.a.f3868d, 1000};
    private static final Pattern o = Pattern.compile("[0-9]{8}(T[0-9]{6}Z?)?");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Date f9929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f9930d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Date f9931e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f9932f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f9933g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f9934h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String[] f9935i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f9936j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final double f9937k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final double f9938l;

    public g(String str, String str2, String str3, String str4, String str5, String str6, String[] strArr, String str7, double d2, double d3) {
        super(r.CALENDAR);
        this.f9928b = str;
        try {
            this.f9929c = a(str2);
            if (str3 == null) {
                long jA = a((CharSequence) str4);
                this.f9931e = jA < 0 ? null : new Date(this.f9929c.getTime() + jA);
            } else {
                try {
                    this.f9931e = a(str3);
                } catch (ParseException e2) {
                    throw new IllegalArgumentException(e2.toString());
                }
            }
            boolean z = false;
            this.f9930d = str2.length() == 8;
            if (str3 != null && str3.length() == 8) {
                z = true;
            }
            this.f9932f = z;
            this.f9933g = str5;
            this.f9934h = str6;
            this.f9935i = strArr;
            this.f9936j = str7;
            this.f9937k = d2;
            this.f9938l = d3;
        } catch (ParseException e3) {
            throw new IllegalArgumentException(e3.toString());
        }
    }

    private static DateFormat n() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    private static DateFormat o() {
        return new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.ENGLISH);
    }

    @Override // d.b.c.y.a.q
    public String a() {
        StringBuilder sb = new StringBuilder(100);
        q.a(this.f9928b, sb);
        q.a(a(this.f9930d, this.f9929c), sb);
        q.a(a(this.f9932f, this.f9931e), sb);
        q.a(this.f9933g, sb);
        q.a(this.f9934h, sb);
        q.a(this.f9935i, sb);
        q.a(this.f9936j, sb);
        return sb.toString();
    }

    public String[] c() {
        return this.f9935i;
    }

    public String d() {
        return this.f9936j;
    }

    public Date e() {
        return this.f9931e;
    }

    public double f() {
        return this.f9937k;
    }

    public String g() {
        return this.f9933g;
    }

    public double h() {
        return this.f9938l;
    }

    public String i() {
        return this.f9934h;
    }

    public Date j() {
        return this.f9929c;
    }

    public String k() {
        return this.f9928b;
    }

    public boolean l() {
        return this.f9932f;
    }

    public boolean m() {
        return this.f9930d;
    }

    private static Date a(String str) throws ParseException {
        if (o.matcher(str).matches()) {
            if (str.length() == 8) {
                return n().parse(str);
            }
            if (str.length() == 16 && str.charAt(15) == 'Z') {
                Date date = o().parse(str.substring(0, 15));
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                long time = date.getTime() + ((long) gregorianCalendar.get(15));
                gregorianCalendar.setTime(new Date(time));
                return new Date(time + ((long) gregorianCalendar.get(16)));
            }
            return o().parse(str);
        }
        throw new ParseException(str, 0);
    }

    private static String a(boolean z, Date date) {
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

    private static long a(CharSequence charSequence) {
        if (charSequence == null) {
            return -1L;
        }
        Matcher matcher = f9926m.matcher(charSequence);
        if (!matcher.matches()) {
            return -1L;
        }
        long j2 = 0;
        int i2 = 0;
        while (i2 < f9927n.length) {
            int i3 = i2 + 1;
            String strGroup = matcher.group(i3);
            if (strGroup != null) {
                j2 += f9927n[i2] * ((long) Integer.parseInt(strGroup));
            }
            i2 = i3;
        }
        return j2;
    }
}
