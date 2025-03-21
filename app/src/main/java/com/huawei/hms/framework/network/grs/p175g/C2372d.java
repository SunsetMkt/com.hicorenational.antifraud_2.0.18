package com.huawei.hms.framework.network.grs.p175g;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
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

/* renamed from: com.huawei.hms.framework.network.grs.g.d */
/* loaded from: classes.dex */
public class C2372d {

    /* renamed from: o */
    private static final String f7395o = "d";

    /* renamed from: a */
    private Map<String, List<String>> f7396a;

    /* renamed from: b */
    private byte[] f7397b;

    /* renamed from: c */
    private int f7398c;

    /* renamed from: d */
    private long f7399d;

    /* renamed from: e */
    private long f7400e;

    /* renamed from: f */
    private long f7401f;

    /* renamed from: g */
    private String f7402g;

    /* renamed from: h */
    private int f7403h;

    /* renamed from: i */
    private int f7404i;

    /* renamed from: j */
    private String f7405j;

    /* renamed from: k */
    private long f7406k;

    /* renamed from: l */
    private String f7407l;

    /* renamed from: m */
    private Exception f7408m;

    /* renamed from: n */
    private String f7409n;

    public C2372d(int i2, Map<String, List<String>> map, byte[] bArr, long j2) {
        this.f7398c = 0;
        this.f7403h = 2;
        this.f7404i = ConnectionResult.RESOLUTION_REQUIRED;
        this.f7405j = "";
        this.f7406k = 0L;
        this.f7407l = "";
        this.f7398c = i2;
        this.f7396a = map;
        this.f7397b = ByteBuffer.wrap(bArr).array();
        this.f7399d = j2;
        m6922s();
    }

    public C2372d(Exception exc, long j2) {
        this.f7398c = 0;
        this.f7403h = 2;
        this.f7404i = ConnectionResult.RESOLUTION_REQUIRED;
        this.f7405j = "";
        this.f7406k = 0L;
        this.f7407l = "";
        this.f7408m = exc;
        this.f7399d = j2;
    }

    /* renamed from: a */
    private void m6909a(Map<String, String> map) {
        String str;
        String str2;
        if (map.containsKey(HttpHeaders.ETAG)) {
            String str3 = map.get(HttpHeaders.ETAG);
            if (!TextUtils.isEmpty(str3)) {
                Logger.m6799i(f7395o, "success get Etag from server");
                m6926a(str3);
                return;
            } else {
                str = f7395o;
                str2 = "The Response Heads Etag is Empty";
            }
        } else {
            str = f7395o;
            str2 = "Response Heads has not Etag";
        }
        Logger.m6799i(str, str2);
    }

    /* renamed from: b */
    private void m6910b(int i2) {
        this.f7404i = i2;
    }

    /* renamed from: b */
    private void m6911b(Map<String, String> map) {
        long time;
        if (map.containsKey("Cache-Control")) {
            String str = map.get("Cache-Control");
            if (!TextUtils.isEmpty(str) && str.contains("max-age=")) {
                try {
                    time = Long.parseLong(str.substring(str.indexOf("max-age=") + 8));
                } catch (NumberFormatException e2) {
                    e = e2;
                    time = 0;
                }
                try {
                    Logger.m6802v(f7395o, "Cache-Control value{%s}", Long.valueOf(time));
                } catch (NumberFormatException e3) {
                    e = e3;
                    Logger.m6804w(f7395o, "getExpireTime addHeadersToResult NumberFormatException", e);
                    if (time > 0) {
                    }
                    time = 86400;
                    long j2 = time * 1000;
                    Logger.m6800i(f7395o, "convert expireTime{%s}", Long.valueOf(j2));
                    m6914c(String.valueOf(j2 + System.currentTimeMillis()));
                }
            }
            time = 0;
        } else {
            if (map.containsKey(HttpHeaders.EXPIRES)) {
                String str2 = map.get(HttpHeaders.EXPIRES);
                Logger.m6802v(f7395o, "expires is{%s}", str2);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.ROOT);
                String str3 = map.containsKey(HttpHeaders.DATE) ? map.get(HttpHeaders.DATE) : null;
                try {
                    time = (simpleDateFormat.parse(str2).getTime() - (TextUtils.isEmpty(str3) ? new Date() : simpleDateFormat.parse(str3)).getTime()) / 1000;
                } catch (ParseException e4) {
                    Logger.m6804w(f7395o, "getExpireTime ParseException.", e4);
                }
            } else {
                Logger.m6799i(f7395o, "response headers neither contains Cache-Control nor Expires.");
            }
            time = 0;
        }
        if (time > 0 || time > 2592000) {
            time = 86400;
        }
        long j22 = time * 1000;
        Logger.m6800i(f7395o, "convert expireTime{%s}", Long.valueOf(j22));
        m6914c(String.valueOf(j22 + System.currentTimeMillis()));
    }

    /* renamed from: c */
    private void m6912c(int i2) {
        this.f7403h = i2;
    }

    /* renamed from: c */
    private void m6913c(long j2) {
        this.f7406k = j2;
    }

    /* renamed from: c */
    private void m6914c(String str) {
        this.f7405j = str;
    }

    /* renamed from: c */
    private void m6915c(Map<String, String> map) {
        long j2;
        if (map.containsKey("Retry-After")) {
            String str = map.get("Retry-After");
            if (!TextUtils.isEmpty(str)) {
                try {
                    j2 = Long.parseLong(str);
                } catch (NumberFormatException e2) {
                    Logger.m6804w(f7395o, "getRetryAfter addHeadersToResult NumberFormatException", e2);
                }
                long j3 = j2 * 1000;
                Logger.m6802v(f7395o, "convert retry-afterTime{%s}", Long.valueOf(j3));
                m6913c(j3);
            }
        }
        j2 = 0;
        long j32 = j2 * 1000;
        Logger.m6802v(f7395o, "convert retry-afterTime{%s}", Long.valueOf(j32));
        m6913c(j32);
    }

    /* renamed from: d */
    private void m6916d(String str) {
    }

    /* renamed from: e */
    private void m6917e(String str) {
    }

    /* renamed from: f */
    private void m6918f(String str) {
        this.f7402g = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0052, code lost:
    
        if (r9.getInt(com.taobao.agoo.p201a.p202a.AbstractC3059b.JSON_ERRORCODE) == 0) goto L20;
     */
    /* renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m6919p() {
        /*
            r11 = this;
            java.lang.String r0 = "errorDesc"
            java.lang.String r1 = "errorList"
            java.lang.String r2 = "errorCode"
            java.lang.String r3 = "resultCode"
            java.lang.String r4 = "isSuccess"
            boolean r5 = r11.m6940m()
            r6 = 1
            if (r5 == 0) goto L1c
            java.lang.String r0 = com.huawei.hms.framework.network.grs.p175g.C2372d.f7395o
            java.lang.String r1 = "GRSSDK get httpcode{304} not any changed."
            com.huawei.hms.framework.common.Logger.m6799i(r0, r1)
            r11.m6912c(r6)
            return
        L1c:
            boolean r5 = r11.m6942o()
            r7 = 2
            if (r5 != 0) goto L2e
            java.lang.String r0 = com.huawei.hms.framework.network.grs.p175g.C2372d.f7395o
            java.lang.String r1 = "GRSSDK parse server body all failed."
            com.huawei.hms.framework.common.Logger.m6799i(r0, r1)
            r11.m6912c(r7)
            return
        L2e:
            r5 = 0
            byte[] r8 = r11.f7397b     // Catch: org.json.JSONException -> Lb7
            java.lang.String r8 = com.huawei.hms.framework.common.StringUtils.byte2Str(r8)     // Catch: org.json.JSONException -> Lb7
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch: org.json.JSONException -> Lb7
            r9.<init>(r8)     // Catch: org.json.JSONException -> Lb7
            r8 = -1
            boolean r10 = r9.has(r4)     // Catch: org.json.JSONException -> Lb7
            if (r10 == 0) goto L48
            int r3 = r9.getInt(r4)     // Catch: org.json.JSONException -> Lb7
            if (r3 != r6) goto L56
            goto L54
        L48:
            boolean r4 = r9.has(r3)     // Catch: org.json.JSONException -> Lb7
            if (r4 == 0) goto L58
            int r3 = r9.getInt(r3)     // Catch: org.json.JSONException -> Lb7
            if (r3 != 0) goto L56
        L54:
            r8 = 1
            goto L5f
        L56:
            r8 = 2
            goto L5f
        L58:
            java.lang.String r3 = com.huawei.hms.framework.network.grs.p175g.C2372d.f7395o     // Catch: org.json.JSONException -> Lb7
            java.lang.String r4 = "sth. wrong because server errorcode's key."
            com.huawei.hms.framework.common.Logger.m6796e(r3, r4)     // Catch: org.json.JSONException -> Lb7
        L5f:
            java.lang.String r3 = "services"
            if (r8 == r6) goto L6a
            boolean r4 = r9.has(r3)     // Catch: org.json.JSONException -> Lb7
            if (r4 == 0) goto L6a
            r8 = 0
        L6a:
            r11.m6912c(r8)     // Catch: org.json.JSONException -> Lb7
            java.lang.String r4 = ""
            if (r8 == r6) goto L92
            if (r8 != 0) goto L74
            goto L92
        L74:
            boolean r1 = r9.has(r2)     // Catch: org.json.JSONException -> Lb7
            if (r1 == 0) goto L7f
            int r1 = r9.getInt(r2)     // Catch: org.json.JSONException -> Lb7
            goto L81
        L7f:
            r1 = 9001(0x2329, float:1.2613E-41)
        L81:
            r11.m6910b(r1)     // Catch: org.json.JSONException -> Lb7
            boolean r1 = r9.has(r0)     // Catch: org.json.JSONException -> Lb7
            if (r1 == 0) goto L8e
            java.lang.String r4 = r9.getString(r0)     // Catch: org.json.JSONException -> Lb7
        L8e:
            r11.m6916d(r4)     // Catch: org.json.JSONException -> Lb7
            goto Lce
        L92:
            boolean r0 = r9.has(r3)     // Catch: org.json.JSONException -> Lb7
            if (r0 == 0) goto La1
            org.json.JSONObject r0 = r9.getJSONObject(r3)     // Catch: org.json.JSONException -> Lb7
            java.lang.String r0 = r0.toString()     // Catch: org.json.JSONException -> Lb7
            goto La2
        La1:
            r0 = r4
        La2:
            r11.m6918f(r0)     // Catch: org.json.JSONException -> Lb7
            boolean r0 = r9.has(r1)     // Catch: org.json.JSONException -> Lb7
            if (r0 == 0) goto Lb3
            org.json.JSONObject r0 = r9.getJSONObject(r1)     // Catch: org.json.JSONException -> Lb7
            java.lang.String r4 = r0.toString()     // Catch: org.json.JSONException -> Lb7
        Lb3:
            r11.m6917e(r4)     // Catch: org.json.JSONException -> Lb7
            goto Lce
        Lb7:
            r0 = move-exception
            java.lang.String r1 = com.huawei.hms.framework.network.grs.p175g.C2372d.f7395o
            java.lang.Object[] r2 = new java.lang.Object[r6]
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = com.huawei.hms.framework.common.StringUtils.anonymizeMessage(r0)
            r2[r5] = r0
            java.lang.String r0 = "GrsResponse GrsResponse(String result) JSONException: %s"
            com.huawei.hms.framework.common.Logger.m6805w(r1, r0, r2)
            r11.m6912c(r7)
        Lce:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.p175g.C2372d.m6919p():void");
    }

    /* renamed from: q */
    private void m6920q() {
        if (m6942o() || m6941n() || m6940m()) {
            Map<String, String> m6921r = m6921r();
            if (m6921r.size() <= 0) {
                Logger.m6803w(f7395o, "parseHeader {headers.size() <= 0}");
                return;
            }
            try {
                if (m6942o() || m6940m()) {
                    m6911b(m6921r);
                    m6909a(m6921r);
                }
                if (m6941n()) {
                    m6915c(m6921r);
                }
            } catch (JSONException e2) {
                Logger.m6805w(f7395o, "parseHeader catch JSONException: %s", StringUtils.anonymizeMessage(e2.getMessage()));
            }
        }
    }

    /* renamed from: r */
    private Map<String, String> m6921r() {
        HashMap hashMap = new HashMap(16);
        Map<String, List<String>> map = this.f7396a;
        if (map == null || map.size() <= 0) {
            Logger.m6801v(f7395o, "parseRespHeaders {respHeaders == null} or {respHeaders.size() <= 0}");
            return hashMap;
        }
        for (Map.Entry<String, List<String>> entry : this.f7396a.entrySet()) {
            String key = entry.getKey();
            Iterator<String> it = entry.getValue().iterator();
            while (it.hasNext()) {
                hashMap.put(key, it.next());
            }
        }
        return hashMap;
    }

    /* renamed from: s */
    private void m6922s() {
        m6920q();
        m6919p();
    }

    /* renamed from: a */
    public String m6923a() {
        return this.f7405j;
    }

    /* renamed from: a */
    public void m6924a(int i2) {
    }

    /* renamed from: a */
    public void m6925a(long j2) {
        this.f7401f = j2;
    }

    /* renamed from: a */
    public void m6926a(String str) {
        this.f7407l = str;
    }

    /* renamed from: b */
    public int m6927b() {
        return this.f7398c;
    }

    /* renamed from: b */
    public void m6928b(long j2) {
        this.f7400e = j2;
    }

    /* renamed from: b */
    public void m6929b(String str) {
        this.f7409n = str;
    }

    /* renamed from: c */
    public int m6930c() {
        return this.f7404i;
    }

    /* renamed from: d */
    public Exception m6931d() {
        return this.f7408m;
    }

    /* renamed from: e */
    public String m6932e() {
        return this.f7407l;
    }

    /* renamed from: f */
    public int m6933f() {
        return this.f7403h;
    }

    /* renamed from: g */
    public long m6934g() {
        return this.f7401f;
    }

    /* renamed from: h */
    public long m6935h() {
        return this.f7400e;
    }

    /* renamed from: i */
    public long m6936i() {
        return this.f7399d;
    }

    /* renamed from: j */
    public String m6937j() {
        return this.f7402g;
    }

    /* renamed from: k */
    public long m6938k() {
        return this.f7406k;
    }

    /* renamed from: l */
    public String m6939l() {
        return this.f7409n;
    }

    /* renamed from: m */
    public boolean m6940m() {
        return this.f7398c == 304;
    }

    /* renamed from: n */
    public boolean m6941n() {
        return this.f7398c == 503;
    }

    /* renamed from: o */
    public boolean m6942o() {
        return this.f7398c == 200;
    }
}
