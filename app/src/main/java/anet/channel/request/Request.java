package anet.channel.request;

import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import i.z2.h0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class Request {
    public static final String DEFAULT_CHARSET = "UTF-8";
    public final RequestStatistic a;

    /* JADX INFO: renamed from: b */
    private HttpUrl f1499b;

    /* JADX INFO: renamed from: c */
    private HttpUrl f1500c;

    /* JADX INFO: renamed from: d */
    private HttpUrl f1501d;

    /* JADX INFO: renamed from: e */
    private URL f1502e;

    /* JADX INFO: renamed from: f */
    private String f1503f;

    /* JADX INFO: renamed from: g */
    private Map<String, String> f1504g;

    /* JADX INFO: renamed from: h */
    private Map<String, String> f1505h;

    /* JADX INFO: renamed from: i */
    private String f1506i;

    /* JADX INFO: renamed from: j */
    private BodyEntry f1507j;

    /* JADX INFO: renamed from: k */
    private boolean f1508k;

    /* JADX INFO: renamed from: l */
    private String f1509l;

    /* JADX INFO: renamed from: m */
    private String f1510m;

    /* JADX INFO: renamed from: n */
    private int f1511n;
    private int o;
    private int p;
    private HostnameVerifier q;
    private SSLSocketFactory r;
    private boolean s;

    /* JADX INFO: compiled from: Taobao */
    public static class Builder {
        private HttpUrl a;

        /* JADX INFO: renamed from: b */
        private HttpUrl f1512b;

        /* JADX INFO: renamed from: e */
        private Map<String, String> f1515e;

        /* JADX INFO: renamed from: f */
        private String f1516f;

        /* JADX INFO: renamed from: g */
        private BodyEntry f1517g;

        /* JADX INFO: renamed from: j */
        private HostnameVerifier f1520j;

        /* JADX INFO: renamed from: k */
        private SSLSocketFactory f1521k;

        /* JADX INFO: renamed from: l */
        private String f1522l;

        /* JADX INFO: renamed from: m */
        private String f1523m;
        private boolean q;

        /* JADX INFO: renamed from: c */
        private String f1513c = "GET";

        /* JADX INFO: renamed from: d */
        private Map<String, String> f1514d = new HashMap();

        /* JADX INFO: renamed from: h */
        private boolean f1518h = true;

        /* JADX INFO: renamed from: i */
        private int f1519i = 0;

        /* JADX INFO: renamed from: n */
        private int f1524n = 10000;
        private int o = 10000;
        private RequestStatistic p = null;

        public Builder addHeader(String str, String str2) {
            this.f1514d.put(str, str2);
            return this;
        }

        public Builder addParam(String str, String str2) {
            if (this.f1515e == null) {
                this.f1515e = new HashMap();
            }
            this.f1515e.put(str, str2);
            this.f1512b = null;
            return this;
        }

        public Request build() {
            if (this.f1517g == null && this.f1515e == null && Method.a(this.f1513c)) {
                ALog.e("awcn.Request", "method " + this.f1513c + " must have a request body", null, new Object[0]);
            }
            if (this.f1517g != null && !Method.b(this.f1513c)) {
                ALog.e("awcn.Request", "method " + this.f1513c + " should not have a request body", null, new Object[0]);
                this.f1517g = null;
            }
            BodyEntry bodyEntry = this.f1517g;
            if (bodyEntry != null && bodyEntry.getContentType() != null) {
                addHeader("Content-Type", this.f1517g.getContentType());
            }
            return new Request(this);
        }

        public Builder setAllowRequestInBg(boolean z) {
            this.q = z;
            return this;
        }

        public Builder setBizId(String str) {
            this.f1522l = str;
            return this;
        }

        public Builder setBody(BodyEntry bodyEntry) {
            this.f1517g = bodyEntry;
            return this;
        }

        public Builder setCharset(String str) {
            this.f1516f = str;
            this.f1512b = null;
            return this;
        }

        public Builder setConnectTimeout(int i2) {
            if (i2 > 0) {
                this.f1524n = i2;
            }
            return this;
        }

        public Builder setHeaders(Map<String, String> map) {
            this.f1514d.clear();
            if (map != null) {
                this.f1514d.putAll(map);
            }
            return this;
        }

        public Builder setHostnameVerifier(HostnameVerifier hostnameVerifier) {
            this.f1520j = hostnameVerifier;
            return this;
        }

        public Builder setMethod(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("method is null or empty");
            }
            if ("GET".equalsIgnoreCase(str)) {
                this.f1513c = "GET";
            } else if ("POST".equalsIgnoreCase(str)) {
                this.f1513c = "POST";
            } else if (Method.OPTION.equalsIgnoreCase(str)) {
                this.f1513c = Method.OPTION;
            } else if (Method.HEAD.equalsIgnoreCase(str)) {
                this.f1513c = Method.HEAD;
            } else if (Method.PUT.equalsIgnoreCase(str)) {
                this.f1513c = Method.PUT;
            } else if (Method.DELETE.equalsIgnoreCase(str)) {
                this.f1513c = Method.DELETE;
            } else {
                this.f1513c = "GET";
            }
            return this;
        }

        public Builder setParams(Map<String, String> map) {
            this.f1515e = map;
            this.f1512b = null;
            return this;
        }

        public Builder setReadTimeout(int i2) {
            if (i2 > 0) {
                this.o = i2;
            }
            return this;
        }

        public Builder setRedirectEnable(boolean z) {
            this.f1518h = z;
            return this;
        }

        public Builder setRedirectTimes(int i2) {
            this.f1519i = i2;
            return this;
        }

        public Builder setRequestStatistic(RequestStatistic requestStatistic) {
            this.p = requestStatistic;
            return this;
        }

        public Builder setSeq(String str) {
            this.f1523m = str;
            return this;
        }

        public Builder setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            this.f1521k = sSLSocketFactory;
            return this;
        }

        public Builder setUrl(HttpUrl httpUrl) {
            this.a = httpUrl;
            this.f1512b = null;
            return this;
        }

        public Builder setUrl(String str) {
            this.a = HttpUrl.parse(str);
            this.f1512b = null;
            if (this.a != null) {
                return this;
            }
            throw new IllegalArgumentException("toURL is invalid! toURL = " + str);
        }
    }

    /* JADX INFO: compiled from: Taobao */
    public static final class Method {
        public static final String DELETE = "DELETE";
        public static final String GET = "GET";
        public static final String HEAD = "HEAD";
        public static final String OPTION = "OPTIONS";
        public static final String POST = "POST";
        public static final String PUT = "PUT";

        static boolean a(String str) {
            return str.equals("POST") || str.equals(PUT);
        }

        static boolean b(String str) {
            return a(str) || str.equals(DELETE) || str.equals(OPTION);
        }
    }

    /* synthetic */ Request(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private Map<String, String> a() {
        return AwcnConfig.isCookieHeaderRedundantFix() ? new HashMap(this.f1504g) : this.f1504g;
    }

    private void b() {
        String strA = anet.channel.strategy.utils.c.a(this.f1505h, getContentEncoding());
        if (!TextUtils.isEmpty(strA)) {
            if (Method.a(this.f1503f) && this.f1507j == null) {
                try {
                    this.f1507j = new ByteArrayEntry(strA.getBytes(getContentEncoding()));
                    this.f1504g.put("Content-Type", "application/x-www-form-urlencoded; charset=" + getContentEncoding());
                } catch (UnsupportedEncodingException unused) {
                }
            } else {
                String strUrlString = this.f1499b.urlString();
                StringBuilder sb = new StringBuilder(strUrlString);
                if (sb.indexOf("?") == -1) {
                    sb.append('?');
                } else if (strUrlString.charAt(strUrlString.length() - 1) != '&') {
                    sb.append(h0.f12423c);
                }
                sb.append(strA);
                HttpUrl httpUrl = HttpUrl.parse(sb.toString());
                if (httpUrl != null) {
                    this.f1500c = httpUrl;
                }
            }
        }
        if (this.f1500c == null) {
            this.f1500c = this.f1499b;
        }
    }

    public boolean containsBody() {
        return this.f1507j != null;
    }

    public String getBizId() {
        return this.f1509l;
    }

    public byte[] getBodyBytes() {
        if (this.f1507j == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(128);
        try {
            postBody(byteArrayOutputStream);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }

    public int getConnectTimeout() {
        return this.o;
    }

    public String getContentEncoding() {
        String str = this.f1506i;
        return str != null ? str : "UTF-8";
    }

    public Map<String, String> getHeaders() {
        return Collections.unmodifiableMap(this.f1504g);
    }

    public String getHost() {
        return this.f1500c.host();
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.q;
    }

    public HttpUrl getHttpUrl() {
        return this.f1500c;
    }

    public String getMethod() {
        return this.f1503f;
    }

    public int getReadTimeout() {
        return this.p;
    }

    public int getRedirectTimes() {
        return this.f1511n;
    }

    public String getSeq() {
        return this.f1510m;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.r;
    }

    public URL getUrl() {
        if (this.f1502e == null) {
            HttpUrl httpUrl = this.f1501d;
            if (httpUrl == null) {
                httpUrl = this.f1500c;
            }
            this.f1502e = httpUrl.toURL();
        }
        return this.f1502e;
    }

    public String getUrlString() {
        return this.f1500c.urlString();
    }

    public boolean isAllowRequestInBg() {
        return this.s;
    }

    public boolean isRedirectEnable() {
        return this.f1508k;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.f1513c = this.f1503f;
        builder.f1514d = a();
        builder.f1515e = this.f1505h;
        builder.f1517g = this.f1507j;
        builder.f1516f = this.f1506i;
        builder.f1518h = this.f1508k;
        builder.f1519i = this.f1511n;
        builder.f1520j = this.q;
        builder.f1521k = this.r;
        builder.a = this.f1499b;
        builder.f1512b = this.f1500c;
        builder.f1522l = this.f1509l;
        builder.f1523m = this.f1510m;
        builder.f1524n = this.o;
        builder.o = this.p;
        builder.p = this.a;
        builder.q = this.s;
        return builder;
    }

    public int postBody(OutputStream outputStream) throws IOException {
        BodyEntry bodyEntry = this.f1507j;
        if (bodyEntry != null) {
            return bodyEntry.writeTo(outputStream);
        }
        return 0;
    }

    public void setDnsOptimize(String str, int i2) {
        if (str != null) {
            if (this.f1501d == null) {
                this.f1501d = new HttpUrl(this.f1500c);
            }
            this.f1501d.replaceIpAndPort(str, i2);
        } else {
            this.f1501d = null;
        }
        this.f1502e = null;
        this.a.setIPAndPort(str, i2);
    }

    public void setUrlScheme(boolean z) {
        if (this.f1501d == null) {
            this.f1501d = new HttpUrl(this.f1500c);
        }
        this.f1501d.setScheme(z ? HttpConstant.HTTPS : HttpConstant.HTTP);
        this.f1502e = null;
    }

    private Request(Builder builder) {
        this.f1503f = "GET";
        this.f1508k = true;
        this.f1511n = 0;
        this.o = 10000;
        this.p = 10000;
        this.f1503f = builder.f1513c;
        this.f1504g = builder.f1514d;
        this.f1505h = builder.f1515e;
        this.f1507j = builder.f1517g;
        this.f1506i = builder.f1516f;
        this.f1508k = builder.f1518h;
        this.f1511n = builder.f1519i;
        this.q = builder.f1520j;
        this.r = builder.f1521k;
        this.f1509l = builder.f1522l;
        this.f1510m = builder.f1523m;
        this.o = builder.f1524n;
        this.p = builder.o;
        this.f1499b = builder.a;
        this.f1500c = builder.f1512b;
        if (this.f1500c == null) {
            b();
        }
        this.a = builder.p != null ? builder.p : new RequestStatistic(getHost(), this.f1509l);
        this.s = builder.q;
    }
}
