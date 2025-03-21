package p000a.p001a.p002j;

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
import p000a.p001a.p002j.InterfaceC0009a;

/* compiled from: Taobao */
/* renamed from: a.a.j.d */
/* loaded from: classes.dex */
public class C0012d {

    /* renamed from: a */
    private static final TimeZone f7a = TimeZone.getTimeZone("GMT");

    /* renamed from: b */
    private static final ThreadLocal<SimpleDateFormat> f8b = new ThreadLocal<>();

    /* renamed from: a */
    public static String m63a(long j2) {
        return m64a().format(new Date(j2));
    }

    /* renamed from: a */
    private static long m61a(String str) {
        if (str.length() == 0) {
            return 0L;
        }
        try {
            ParsePosition parsePosition = new ParsePosition(0);
            Date parse = m64a().parse(str, parsePosition);
            if (parsePosition.getIndex() == str.length()) {
                return parse.getTime();
            }
        } catch (Exception unused) {
        }
        return 0L;
    }

    /* renamed from: a */
    public static InterfaceC0009a.a m62a(Map<String, List<String>> map) {
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
        long m61a = singleHeaderFieldByKey2 != null ? m61a(singleHeaderFieldByKey2) : 0L;
        String singleHeaderFieldByKey3 = HttpHelper.getSingleHeaderFieldByKey(map, HttpHeaders.EXPIRES);
        long m61a2 = singleHeaderFieldByKey3 != null ? m61a(singleHeaderFieldByKey3) : 0L;
        String singleHeaderFieldByKey4 = HttpHelper.getSingleHeaderFieldByKey(map, HttpHeaders.LAST_MODIFIED);
        long m61a3 = singleHeaderFieldByKey4 != null ? m61a(singleHeaderFieldByKey4) : 0L;
        String singleHeaderFieldByKey5 = HttpHelper.getSingleHeaderFieldByKey(map, HttpHeaders.ETAG);
        if (z) {
            currentTimeMillis += j2 * 1000;
        } else {
            if (m61a <= 0 || m61a2 < m61a) {
                j3 = m61a3;
                if (j3 <= 0) {
                    currentTimeMillis = 0;
                }
                if (currentTimeMillis != 0 && singleHeaderFieldByKey5 == null) {
                    return null;
                }
                InterfaceC0009a.a aVar = new InterfaceC0009a.a();
                aVar.etag = singleHeaderFieldByKey5;
                aVar.ttl = currentTimeMillis;
                aVar.serverDate = m61a;
                aVar.lastModified = j3;
                aVar.responseHeaders = map;
                return aVar;
            }
            currentTimeMillis += m61a2 - m61a;
        }
        j3 = m61a3;
        if (currentTimeMillis != 0) {
        }
        InterfaceC0009a.a aVar2 = new InterfaceC0009a.a();
        aVar2.etag = singleHeaderFieldByKey5;
        aVar2.ttl = currentTimeMillis;
        aVar2.serverDate = m61a;
        aVar2.lastModified = j3;
        aVar2.responseHeaders = map;
        return aVar2;
    }

    /* renamed from: a */
    private static SimpleDateFormat m64a() {
        SimpleDateFormat simpleDateFormat = f8b.get();
        if (simpleDateFormat != null) {
            return simpleDateFormat;
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat2.setTimeZone(f7a);
        f8b.set(simpleDateFormat2);
        return simpleDateFormat2;
    }
}
