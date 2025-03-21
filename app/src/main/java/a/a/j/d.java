package a.a.j;

import a.a.j.a;
import anet.channel.util.HttpHelper;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.xiaomi.mipush.sdk.Constants;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final TimeZone f1117a = TimeZone.getTimeZone("GMT");

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<SimpleDateFormat> f1118b = new ThreadLocal<>();

    public static String a(long j2) {
        return a().format(new Date(j2));
    }

    private static long a(String str) {
        if (str.length() == 0) {
            return 0L;
        }
        try {
            ParsePosition parsePosition = new ParsePosition(0);
            Date parse = a().parse(str, parsePosition);
            if (parsePosition.getIndex() == str.length()) {
                return parse.getTime();
            }
        } catch (Exception unused) {
        }
        return 0L;
    }

    public static a.C0001a a(Map<String, List<String>> map) {
        long j2;
        long j3;
        long currentTimeMillis = System.currentTimeMillis();
        String singleHeaderFieldByKey = HttpHelper.getSingleHeaderFieldByKey(map, "Cache-Control");
        boolean z = true;
        int i2 = 0;
        if (singleHeaderFieldByKey != null) {
            String[] split = singleHeaderFieldByKey.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            j2 = 0;
            while (true) {
                if (i2 >= split.length) {
                    break;
                }
                String trim = split[i2].trim();
                if (trim.equals("no-store")) {
                    return null;
                }
                if (trim.equals("no-cache")) {
                    j2 = 0;
                    break;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j2 = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                }
                i2++;
            }
        } else {
            j2 = 0;
            z = false;
        }
        String singleHeaderFieldByKey2 = HttpHelper.getSingleHeaderFieldByKey(map, HttpHeaders.DATE);
        long a2 = singleHeaderFieldByKey2 != null ? a(singleHeaderFieldByKey2) : 0L;
        String singleHeaderFieldByKey3 = HttpHelper.getSingleHeaderFieldByKey(map, HttpHeaders.EXPIRES);
        long a3 = singleHeaderFieldByKey3 != null ? a(singleHeaderFieldByKey3) : 0L;
        String singleHeaderFieldByKey4 = HttpHelper.getSingleHeaderFieldByKey(map, HttpHeaders.LAST_MODIFIED);
        long a4 = singleHeaderFieldByKey4 != null ? a(singleHeaderFieldByKey4) : 0L;
        String singleHeaderFieldByKey5 = HttpHelper.getSingleHeaderFieldByKey(map, HttpHeaders.ETAG);
        if (z) {
            currentTimeMillis += j2 * 1000;
        } else {
            if (a2 <= 0 || a3 < a2) {
                j3 = a4;
                if (j3 <= 0) {
                    currentTimeMillis = 0;
                }
                if (currentTimeMillis != 0 && singleHeaderFieldByKey5 == null) {
                    return null;
                }
                a.C0001a c0001a = new a.C0001a();
                c0001a.etag = singleHeaderFieldByKey5;
                c0001a.ttl = currentTimeMillis;
                c0001a.serverDate = a2;
                c0001a.lastModified = j3;
                c0001a.responseHeaders = map;
                return c0001a;
            }
            currentTimeMillis += a3 - a2;
        }
        j3 = a4;
        if (currentTimeMillis != 0) {
        }
        a.C0001a c0001a2 = new a.C0001a();
        c0001a2.etag = singleHeaderFieldByKey5;
        c0001a2.ttl = currentTimeMillis;
        c0001a2.serverDate = a2;
        c0001a2.lastModified = j3;
        c0001a2.responseHeaders = map;
        return c0001a2;
    }

    private static SimpleDateFormat a() {
        SimpleDateFormat simpleDateFormat = f1118b.get();
        if (simpleDateFormat != null) {
            return simpleDateFormat;
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat2.setTimeZone(f1117a);
        f1118b.set(simpleDateFormat2);
        return simpleDateFormat2;
    }
}
