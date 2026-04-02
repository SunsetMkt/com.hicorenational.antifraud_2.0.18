package com.huawei.hms.framework.network.grs.g;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.taobao.accs.common.Constants;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private static final String o = "d";
    private Map<String, List<String>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f4648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f4650d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f4651e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f4652f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f4653g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f4654h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f4655i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f4656j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f4657k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f4658l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Exception f4659m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f4660n;

    public d(int i2, Map<String, List<String>> map, byte[] bArr, long j2) {
        this.f4649c = 0;
        this.f4654h = 2;
        this.f4655i = ConnectionResult.RESOLUTION_REQUIRED;
        this.f4656j = "";
        this.f4657k = 0L;
        this.f4658l = "";
        this.f4649c = i2;
        this.a = map;
        this.f4648b = ByteBuffer.wrap(bArr).array();
        this.f4650d = j2;
        s();
    }

    public d(Exception exc, long j2) {
        this.f4649c = 0;
        this.f4654h = 2;
        this.f4655i = ConnectionResult.RESOLUTION_REQUIRED;
        this.f4656j = "";
        this.f4657k = 0L;
        this.f4658l = "";
        this.f4659m = exc;
        this.f4650d = j2;
    }

    private void a(Map<String, String> map) {
        String str;
        String str2;
        if (map.containsKey(HttpHeaders.ETAG)) {
            String str3 = map.get(HttpHeaders.ETAG);
            if (!TextUtils.isEmpty(str3)) {
                Logger.i(o, "success get Etag from server");
                a(str3);
                return;
            } else {
                str = o;
                str2 = "The Response Heads Etag is Empty";
            }
        } else {
            str = o;
            str2 = "Response Heads has not Etag";
        }
        Logger.i(str, str2);
    }

    private void b(int i2) {
        this.f4655i = i2;
    }

    private void b(Map<String, String> map) {
        long time;
        if (map.containsKey("Cache-Control")) {
            String str = map.get("Cache-Control");
            if (TextUtils.isEmpty(str) || !str.contains("max-age=")) {
                time = 0;
            } else {
                try {
                    time = Long.parseLong(str.substring(str.indexOf("max-age=") + 8));
                } catch (NumberFormatException e2) {
                    e = e2;
                    time = 0;
                }
                try {
                    Logger.v(o, "Cache-Control value{%s}", Long.valueOf(time));
                } catch (NumberFormatException e3) {
                    e = e3;
                    Logger.w(o, "getExpireTime addHeadersToResult NumberFormatException", e);
                }
            }
        } else {
            if (map.containsKey(HttpHeaders.EXPIRES)) {
                String str2 = map.get(HttpHeaders.EXPIRES);
                Logger.v(o, "expires is{%s}", str2);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.ROOT);
                String str3 = map.containsKey(HttpHeaders.DATE) ? map.get(HttpHeaders.DATE) : null;
                try {
                    time = (simpleDateFormat.parse(str2).getTime() - (TextUtils.isEmpty(str3) ? new Date() : simpleDateFormat.parse(str3)).getTime()) / 1000;
                } catch (ParseException e4) {
                    Logger.w(o, "getExpireTime ParseException.", e4);
                    time = 0;
                }
            } else {
                Logger.i(o, "response headers neither contains Cache-Control nor Expires.");
            }
            time = 0;
        }
        if (time <= 0 || time > 2592000) {
            time = 86400;
        }
        long j2 = time * 1000;
        Logger.i(o, "convert expireTime{%s}", Long.valueOf(j2));
        c(String.valueOf(j2 + System.currentTimeMillis()));
    }

    private void c(int i2) {
        this.f4654h = i2;
    }

    private void c(long j2) {
        this.f4657k = j2;
    }

    private void c(String str) {
        this.f4656j = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(Map<String, String> map) {
        long j2;
        if (map.containsKey("Retry-After")) {
            String str = map.get("Retry-After");
            if (TextUtils.isEmpty(str)) {
                j2 = 0;
            } else {
                try {
                    j2 = Long.parseLong(str);
                } catch (NumberFormatException e2) {
                    Logger.w(o, "getRetryAfter addHeadersToResult NumberFormatException", e2);
                    j2 = 0;
                }
            }
        }
        long j3 = j2 * 1000;
        Logger.v(o, "convert retry-afterTime{%s}", Long.valueOf(j3));
        c(j3);
    }

    private void d(String str) {
    }

    private void e(String str) {
    }

    private void f(String str) {
        this.f4653g = str;
    }

    private void p() {
        if (m()) {
            Logger.i(o, "GRSSDK get httpcode{304} not any changed.");
            c(1);
            return;
        }
        if (!o()) {
            Logger.i(o, "GRSSDK parse server body all failed.");
            c(2);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(StringUtils.byte2Str(this.f4648b));
            int i2 = -1;
            if (jSONObject.has(d.c.a.b.a.a.k0)) {
                if (jSONObject.getInt(d.c.a.b.a.a.k0) == 1) {
                }
            } else if (jSONObject.has(com.taobao.agoo.a.a.b.JSON_ERRORCODE)) {
                i2 = jSONObject.getInt(com.taobao.agoo.a.a.b.JSON_ERRORCODE) == 0 ? 1 : 2;
            } else {
                Logger.e(o, "sth. wrong because server errorcode's key.");
            }
            if (i2 != 1 && jSONObject.has("services")) {
                i2 = 0;
            }
            c(i2);
            if (i2 == 1 || i2 == 0) {
                f(jSONObject.has("services") ? jSONObject.getJSONObject("services").toString() : "");
                e(jSONObject.has("errorList") ? jSONObject.getJSONObject("errorList").toString() : "");
            } else {
                b(jSONObject.has(Constants.KEY_ERROR_CODE) ? jSONObject.getInt(Constants.KEY_ERROR_CODE) : ConnectionResult.RESOLUTION_REQUIRED);
                d(jSONObject.has("errorDesc") ? jSONObject.getString("errorDesc") : "");
            }
        } catch (JSONException e2) {
            Logger.w(o, "GrsResponse GrsResponse(String result) JSONException: %s", StringUtils.anonymizeMessage(e2.getMessage()));
            c(2);
        }
    }

    private void q() {
        if (o() || n() || m()) {
            Map<String, String> mapR = r();
            if (mapR.size() <= 0) {
                Logger.w(o, "parseHeader {headers.size() <= 0}");
                return;
            }
            try {
                if (o() || m()) {
                    b(mapR);
                    a(mapR);
                }
                if (n()) {
                    c(mapR);
                }
            } catch (JSONException e2) {
                Logger.w(o, "parseHeader catch JSONException: %s", StringUtils.anonymizeMessage(e2.getMessage()));
            }
        }
    }

    private Map<String, String> r() {
        HashMap map = new HashMap(16);
        Map<String, List<String>> map2 = this.a;
        if (map2 == null || map2.size() <= 0) {
            Logger.v(o, "parseRespHeaders {respHeaders == null} or {respHeaders.size() <= 0}");
            return map;
        }
        for (Map.Entry<String, List<String>> entry : this.a.entrySet()) {
            String key = entry.getKey();
            Iterator<String> it = entry.getValue().iterator();
            while (it.hasNext()) {
                map.put(key, it.next());
            }
        }
        return map;
    }

    private void s() {
        q();
        p();
    }

    public String a() {
        return this.f4656j;
    }

    public void a(int i2) {
    }

    public void a(long j2) {
        this.f4652f = j2;
    }

    public void a(String str) {
        this.f4658l = str;
    }

    public int b() {
        return this.f4649c;
    }

    public void b(long j2) {
        this.f4651e = j2;
    }

    public void b(String str) {
        this.f4660n = str;
    }

    public int c() {
        return this.f4655i;
    }

    public Exception d() {
        return this.f4659m;
    }

    public String e() {
        return this.f4658l;
    }

    public int f() {
        return this.f4654h;
    }

    public long g() {
        return this.f4652f;
    }

    public long h() {
        return this.f4651e;
    }

    public long i() {
        return this.f4650d;
    }

    public String j() {
        return this.f4653g;
    }

    public long k() {
        return this.f4657k;
    }

    public String l() {
        return this.f4660n;
    }

    public boolean m() {
        return this.f4649c == 304;
    }

    public boolean n() {
        return this.f4649c == 503;
    }

    public boolean o() {
        return this.f4649c == 200;
    }
}
