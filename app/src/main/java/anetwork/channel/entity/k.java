package anetwork.channel.entity;

import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpUrl;
import anet.channel.util.Utils;
import anetwork.channel.aidl.ParcelableRequest;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class k {
    private ParcelableRequest a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Request f1787b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1789d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RequestStatistic f1791f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f1792g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f1793h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f1794i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f1795j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f1796k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1788c = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1790e = 0;

    public k(ParcelableRequest parcelableRequest, int i2, boolean z) {
        this.f1787b = null;
        this.f1789d = 0;
        if (parcelableRequest == null) {
            throw new IllegalArgumentException("request is null");
        }
        this.a = parcelableRequest;
        this.f1795j = i2;
        this.f1796k = z;
        this.f1794i = b.a.u.b.a(parcelableRequest.f1691m, this.f1795j == 0 ? "HTTP" : "DGRD");
        int i3 = parcelableRequest.f1688j;
        this.f1792g = i3 <= 0 ? (int) (Utils.getNetworkTimeFactor() * 12000.0f) : i3;
        int i4 = parcelableRequest.f1689k;
        this.f1793h = i4 <= 0 ? (int) (Utils.getNetworkTimeFactor() * 12000.0f) : i4;
        int i5 = parcelableRequest.f1681c;
        this.f1789d = (i5 < 0 || i5 > 3) ? 2 : i5;
        HttpUrl httpUrlL = l();
        this.f1791f = new RequestStatistic(httpUrlL.host(), String.valueOf(parcelableRequest.f1690l));
        this.f1791f.url = httpUrlL.simpleUrlString();
        this.f1787b = b(httpUrlL);
    }

    private Request b(HttpUrl httpUrl) {
        Request.Builder requestStatistic = new Request.Builder().setUrl(httpUrl).setMethod(this.a.f1685g).setBody(this.a.f1680b).setReadTimeout(this.f1793h).setConnectTimeout(this.f1792g).setRedirectEnable(this.a.f1684f).setRedirectTimes(this.f1788c).setBizId(this.a.f1690l).setSeq(this.f1794i).setRequestStatistic(this.f1791f);
        requestStatistic.setParams(this.a.f1687i);
        String str = this.a.f1683e;
        if (str != null) {
            requestStatistic.setCharset(str);
        }
        requestStatistic.setHeaders(c(httpUrl));
        return requestStatistic.build();
    }

    private HttpUrl l() {
        HttpUrl httpUrl = HttpUrl.parse(this.a.f1682d);
        if (httpUrl == null) {
            throw new IllegalArgumentException("url is invalid. url=" + this.a.f1682d);
        }
        if (!b.a.k.b.q()) {
            ALog.i("anet.RequestConfig", "request ssl disabled.", this.f1794i, new Object[0]);
            httpUrl.downgradeSchemeAndLock();
        } else if (b.a.u.a.f1909k.equalsIgnoreCase(this.a.a(b.a.u.a.f1904f))) {
            httpUrl.lockScheme();
        }
        return httpUrl;
    }

    public Request a() {
        return this.f1787b;
    }

    public boolean c() {
        return this.f1796k;
    }

    public boolean d() {
        return this.f1790e < this.f1789d;
    }

    public boolean e() {
        return b.a.k.b.m() && !b.a.u.a.f1909k.equalsIgnoreCase(this.a.a(b.a.u.a.f1905g)) && (b.a.k.b.e() || this.f1790e == 0);
    }

    public HttpUrl f() {
        return this.f1787b.getHttpUrl();
    }

    public String g() {
        return this.f1787b.getUrlString();
    }

    public Map<String, String> h() {
        return this.f1787b.getHeaders();
    }

    public boolean i() {
        return !b.a.u.a.f1909k.equalsIgnoreCase(this.a.a(b.a.u.a.f1902d));
    }

    public boolean j() {
        return b.a.u.a.f1908j.equals(this.a.a(b.a.u.a.f1906h));
    }

    public void k() {
        this.f1790e++;
        this.f1791f.retryTimes = this.f1790e;
    }

    private Map<String, String> c(HttpUrl httpUrl) {
        String strHost = httpUrl.host();
        boolean z = !anet.channel.strategy.utils.c.a(strHost);
        if (strHost.length() > 2 && strHost.charAt(0) == '[' && strHost.charAt(strHost.length() - 1) == ']' && anet.channel.strategy.utils.c.b(strHost.substring(1, strHost.length() - 1))) {
            z = false;
        }
        HashMap map = new HashMap();
        Map<String, String> map2 = this.a.f1686h;
        if (map2 != null) {
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                String key = entry.getKey();
                if (!"Host".equalsIgnoreCase(key) && !":host".equalsIgnoreCase(key)) {
                    boolean zEqualsIgnoreCase = b.a.u.a.f1908j.equalsIgnoreCase(this.a.a(b.a.u.a.f1903e));
                    if (!"Cookie".equalsIgnoreCase(key) || zEqualsIgnoreCase) {
                        map.put(key, entry.getValue());
                    }
                } else if (!z) {
                    map.put("Host", entry.getValue());
                }
            }
        }
        return map;
    }

    public void a(Request request) {
        this.f1787b = request;
    }

    public String a(String str) {
        return this.a.a(str);
    }

    public void a(HttpUrl httpUrl) {
        ALog.i("anet.RequestConfig", "redirect", this.f1794i, "to url", httpUrl.toString());
        this.f1788c++;
        this.f1791f.url = httpUrl.simpleUrlString();
        this.f1787b = b(httpUrl);
    }

    public int b() {
        return this.f1793h * (this.f1789d + 1);
    }
}
