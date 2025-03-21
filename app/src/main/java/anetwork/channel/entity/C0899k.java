package anetwork.channel.entity;

import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.strategy.utils.C0848c;
import anet.channel.util.ALog;
import anet.channel.util.HttpUrl;
import anet.channel.util.Utils;
import anetwork.channel.aidl.ParcelableRequest;
import java.util.HashMap;
import java.util.Map;
import p000a.p001a.p003k.C0014b;
import p000a.p001a.p014u.C0052a;
import p000a.p001a.p014u.C0053b;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.entity.k */
/* loaded from: classes.dex */
public class C0899k {

    /* renamed from: a */
    private ParcelableRequest f1359a;

    /* renamed from: b */
    private Request f1360b;

    /* renamed from: d */
    private int f1362d;

    /* renamed from: f */
    public RequestStatistic f1364f;

    /* renamed from: g */
    public final int f1365g;

    /* renamed from: h */
    public final int f1366h;

    /* renamed from: i */
    public final String f1367i;

    /* renamed from: j */
    public final int f1368j;

    /* renamed from: k */
    private final boolean f1369k;

    /* renamed from: c */
    private int f1361c = 0;

    /* renamed from: e */
    public int f1363e = 0;

    public C0899k(ParcelableRequest parcelableRequest, int i2, boolean z) {
        this.f1360b = null;
        this.f1362d = 0;
        if (parcelableRequest == null) {
            throw new IllegalArgumentException("request is null");
        }
        this.f1359a = parcelableRequest;
        this.f1368j = i2;
        this.f1369k = z;
        this.f1367i = C0053b.m203a(parcelableRequest.f1228m, this.f1368j == 0 ? "HTTP" : "DGRD");
        int i3 = parcelableRequest.f1225j;
        this.f1365g = i3 <= 0 ? (int) (Utils.getNetworkTimeFactor() * 12000.0f) : i3;
        int i4 = parcelableRequest.f1226k;
        this.f1366h = i4 <= 0 ? (int) (Utils.getNetworkTimeFactor() * 12000.0f) : i4;
        int i5 = parcelableRequest.f1218c;
        this.f1362d = (i5 < 0 || i5 > 3) ? 2 : i5;
        HttpUrl m823l = m823l();
        this.f1364f = new RequestStatistic(m823l.host(), String.valueOf(parcelableRequest.f1227l));
        this.f1364f.url = m823l.simpleUrlString();
        this.f1360b = m821b(m823l);
    }

    /* renamed from: b */
    private Request m821b(HttpUrl httpUrl) {
        Request.Builder requestStatistic = new Request.Builder().setUrl(httpUrl).setMethod(this.f1359a.f1222g).setBody(this.f1359a.f1217b).setReadTimeout(this.f1366h).setConnectTimeout(this.f1365g).setRedirectEnable(this.f1359a.f1221f).setRedirectTimes(this.f1361c).setBizId(this.f1359a.f1227l).setSeq(this.f1367i).setRequestStatistic(this.f1364f);
        requestStatistic.setParams(this.f1359a.f1224i);
        String str = this.f1359a.f1220e;
        if (str != null) {
            requestStatistic.setCharset(str);
        }
        requestStatistic.setHeaders(m822c(httpUrl));
        return requestStatistic.build();
    }

    /* renamed from: l */
    private HttpUrl m823l() {
        HttpUrl parse = HttpUrl.parse(this.f1359a.f1219d);
        if (parse == null) {
            throw new IllegalArgumentException("url is invalid. url=" + this.f1359a.f1219d);
        }
        if (!C0014b.m111q()) {
            ALog.m716i("anet.RequestConfig", "request ssl disabled.", this.f1367i, new Object[0]);
            parse.downgradeSchemeAndLock();
        } else if (C0052a.f159k.equalsIgnoreCase(this.f1359a.m760a(C0052a.f154f))) {
            parse.lockScheme();
        }
        return parse;
    }

    /* renamed from: a */
    public Request m824a() {
        return this.f1360b;
    }

    /* renamed from: c */
    public boolean m829c() {
        return this.f1369k;
    }

    /* renamed from: d */
    public boolean m830d() {
        return this.f1363e < this.f1362d;
    }

    /* renamed from: e */
    public boolean m831e() {
        return C0014b.m104m() && !C0052a.f159k.equalsIgnoreCase(this.f1359a.m760a(C0052a.f155g)) && (C0014b.m87e() || this.f1363e == 0);
    }

    /* renamed from: f */
    public HttpUrl m832f() {
        return this.f1360b.getHttpUrl();
    }

    /* renamed from: g */
    public String m833g() {
        return this.f1360b.getUrlString();
    }

    /* renamed from: h */
    public Map<String, String> m834h() {
        return this.f1360b.getHeaders();
    }

    /* renamed from: i */
    public boolean m835i() {
        return !C0052a.f159k.equalsIgnoreCase(this.f1359a.m760a(C0052a.f152d));
    }

    /* renamed from: j */
    public boolean m836j() {
        return C0052a.f158j.equals(this.f1359a.m760a(C0052a.f156h));
    }

    /* renamed from: k */
    public void m837k() {
        this.f1363e++;
        this.f1364f.retryTimes = this.f1363e;
    }

    /* renamed from: c */
    private Map<String, String> m822c(HttpUrl httpUrl) {
        String host = httpUrl.host();
        boolean z = !C0848c.m707a(host);
        if (host.length() > 2 && host.charAt(0) == '[' && host.charAt(host.length() - 1) == ']' && C0848c.m708b(host.substring(1, host.length() - 1))) {
            z = false;
        }
        HashMap hashMap = new HashMap();
        Map<String, String> map = this.f1359a.f1223h;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!"Host".equalsIgnoreCase(key) && !":host".equalsIgnoreCase(key)) {
                    boolean equalsIgnoreCase = C0052a.f158j.equalsIgnoreCase(this.f1359a.m760a(C0052a.f153e));
                    if (!"Cookie".equalsIgnoreCase(key) || equalsIgnoreCase) {
                        hashMap.put(key, entry.getValue());
                    }
                } else if (!z) {
                    hashMap.put("Host", entry.getValue());
                }
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    public void m826a(Request request) {
        this.f1360b = request;
    }

    /* renamed from: a */
    public String m825a(String str) {
        return this.f1359a.m760a(str);
    }

    /* renamed from: a */
    public void m827a(HttpUrl httpUrl) {
        ALog.m716i("anet.RequestConfig", "redirect", this.f1367i, "to url", httpUrl.toString());
        this.f1361c++;
        this.f1364f.url = httpUrl.simpleUrlString();
        this.f1360b = m821b(httpUrl);
    }

    /* renamed from: b */
    public int m828b() {
        return this.f1366h * (this.f1362d + 1);
    }
}
