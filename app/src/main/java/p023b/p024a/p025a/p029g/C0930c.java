package p023b.p024a.p025a.p029g;

import android.text.format.DateUtils;
import androidx.annotation.NonNull;
import com.heytap.mcssdk.constant.C2084a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* compiled from: DateUtils.java */
/* renamed from: b.a.a.g.c */
/* loaded from: classes.dex */
public class C0930c extends DateUtils {

    /* renamed from: a */
    public static final int f1561a = 0;

    /* renamed from: b */
    public static final int f1562b = 1;

    /* renamed from: c */
    public static final int f1563c = 2;

    /* renamed from: d */
    public static final int f1564d = 3;

    /* compiled from: DateUtils.java */
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: b.a.a.g.c$a */
    public @interface a {
    }

    /* renamed from: a */
    public static long m1123a(long j2, long j3) {
        return m1124a(j2, j3, 3);
    }

    /* renamed from: b */
    public static long m1133b(Date date, Date date2) {
        return m1125a(date, date2, 3);
    }

    /* renamed from: c */
    public static long m1138c(Date date, Date date2) {
        return m1125a(date, date2, 2);
    }

    /* renamed from: d */
    public static long m1140d(Date date, Date date2) {
        return m1125a(date, date2, 1);
    }

    /* renamed from: e */
    public static long m1141e(Date date, Date date2) {
        return m1125a(date, date2, 0);
    }

    /* renamed from: a */
    public static long m1124a(long j2, long j3, int i2) {
        return m1125a(new Date(j2), new Date(j3), i2);
    }

    /* renamed from: b */
    public static long m1132b(long j2, long j3) {
        return m1124a(j2, j3, 2);
    }

    /* renamed from: c */
    public static long m1137c(long j2, long j3) {
        return m1124a(j2, j3, 1);
    }

    /* renamed from: d */
    public static long m1139d(long j2, long j3) {
        return m1124a(j2, j3, 0);
    }

    /* renamed from: a */
    public static long m1125a(Date date, Date date2, int i2) {
        long[] m1131a = m1131a(date, date2);
        if (i2 == 1) {
            return m1131a[2];
        }
        if (i2 == 2) {
            return m1131a[1];
        }
        if (i2 == 3) {
            return m1131a[0];
        }
        return m1131a[3];
    }

    @NonNull
    /* renamed from: b */
    public static String m1134b(int i2) {
        StringBuilder sb;
        String str;
        if (i2 < 10) {
            sb = new StringBuilder();
            str = "0";
        } else {
            sb = new StringBuilder();
            str = "";
        }
        sb.append(str);
        sb.append(i2);
        return sb.toString();
    }

    /* renamed from: c */
    public static int m1136c(@NonNull String str) {
        try {
            if (str.startsWith("0")) {
                str = str.substring(1);
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            C0931d.m1159c(e2);
            return 0;
        }
    }

    /* renamed from: b */
    public static Date m1135b(String str) {
        return m1128a(str, "yyyy-MM-dd HH:mm:ss");
    }

    /* renamed from: a */
    private static long[] m1131a(Date date, Date date2) {
        return m1130a(date2.getTime() - date.getTime());
    }

    /* renamed from: a */
    private static long[] m1130a(long j2) {
        long j3 = j2 / 86400000;
        long j4 = j2 % 86400000;
        long j5 = j4 / C2084a.f6123e;
        long j6 = j4 % C2084a.f6123e;
        long j7 = j6 / C2084a.f6122d;
        long j8 = j6 % C2084a.f6122d;
        long j9 = j8 / 1000;
        C0931d.m1166e(String.format(Locale.CHINA, "different: %d ms, %d days, %d hours, %d minutes, %d seconds", Long.valueOf(j8), Long.valueOf(j3), Long.valueOf(j5), Long.valueOf(j7), Long.valueOf(j9)));
        return new long[]{j3, j5, j7, j9};
    }

    /* renamed from: a */
    public static int m1121a(int i2) {
        return m1122a(0, i2);
    }

    /* renamed from: a */
    public static int m1122a(int i2, int i3) {
        List asList = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
        List asList2 = Arrays.asList("4", "6", "9", "11");
        if (asList.contains(String.valueOf(i3))) {
            return 31;
        }
        if (asList2.contains(String.valueOf(i3))) {
            return 30;
        }
        if (i2 <= 0) {
            return 29;
        }
        return ((i2 % 4 != 0 || i2 % 100 == 0) && i2 % 400 != 0) ? 28 : 29;
    }

    /* renamed from: a */
    public static boolean m1129a(Date date) {
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(date);
            return calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
        }
        throw new IllegalArgumentException("date is null");
    }

    /* renamed from: a */
    public static Date m1128a(String str, String str2) {
        try {
            return new Date(new SimpleDateFormat(str2, Locale.PRC).parse(str).getTime());
        } catch (ParseException e2) {
            C0931d.m1159c(e2);
            return null;
        }
    }

    /* renamed from: a */
    public static String m1127a(Date date, String str) {
        return new SimpleDateFormat(str, Locale.PRC).format(date);
    }

    /* renamed from: a */
    public static String m1126a(String str) {
        return m1127a(Calendar.getInstance(Locale.CHINA).getTime(), str);
    }
}
