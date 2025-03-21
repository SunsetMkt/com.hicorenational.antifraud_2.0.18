package anet.channel.request;

import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.statist.RequestStatistic;
import anet.channel.strategy.utils.C0848c;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
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
import p286h.p323z2.C5736h0;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class Request {
    public static final String DEFAULT_CHARSET = "UTF-8";

    /* renamed from: a */
    public final RequestStatistic f916a;

    /* renamed from: b */
    private HttpUrl f917b;

    /* renamed from: c */
    private HttpUrl f918c;

    /* renamed from: d */
    private HttpUrl f919d;

    /* renamed from: e */
    private URL f920e;

    /* renamed from: f */
    private String f921f;

    /* renamed from: g */
    private Map<String, String> f922g;

    /* renamed from: h */
    private Map<String, String> f923h;

    /* renamed from: i */
    private String f924i;

    /* renamed from: j */
    private BodyEntry f925j;

    /* renamed from: k */
    private boolean f926k;

    /* renamed from: l */
    private String f927l;

    /* renamed from: m */
    private String f928m;

    /* renamed from: n */
    private int f929n;

    /* renamed from: o */
    private int f930o;

    /* renamed from: p */
    private int f931p;

    /* renamed from: q */
    private HostnameVerifier f932q;

    /* renamed from: r */
    private SSLSocketFactory f933r;

    /* renamed from: s */
    private boolean f934s;

    /* compiled from: Taobao */
    public static class Builder {

        /* renamed from: a */
        private HttpUrl f935a;

        /* renamed from: b */
        private HttpUrl f936b;

        /* renamed from: e */
        private Map<String, String> f939e;

        /* renamed from: f */
        private String f940f;

        /* renamed from: g */
        private BodyEntry f941g;

        /* renamed from: j */
        private HostnameVerifier f944j;

        /* renamed from: k */
        private SSLSocketFactory f945k;

        /* renamed from: l */
        private String f946l;

        /* renamed from: m */
        private String f947m;

        /* renamed from: q */
        private boolean f951q;

        /* renamed from: c */
        private String f937c = "GET";

        /* renamed from: d */
        private Map<String, String> f938d = new HashMap();

        /* renamed from: h */
        private boolean f942h = true;

        /* renamed from: i */
        private int f943i = 0;

        /* renamed from: n */
        private int f948n = 10000;

        /* renamed from: o */
        private int f949o = 10000;

        /* renamed from: p */
        private RequestStatistic f950p = null;

        public Builder addHeader(String str, String str2) {
            this.f938d.put(str, str2);
            return this;
        }

        public Builder addParam(String str, String str2) {
            if (this.f939e == null) {
                this.f939e = new HashMap();
            }
            this.f939e.put(str, str2);
            this.f936b = null;
            return this;
        }

        public Request build() {
            if (this.f941g == null && this.f939e == null && Method.m577a(this.f937c)) {
                ALog.m715e("awcn.Request", "method " + this.f937c + " must have a request body", null, new Object[0]);
            }
            if (this.f941g != null && !Method.m578b(this.f937c)) {
                ALog.m715e("awcn.Request", "method " + this.f937c + " should not have a request body", null, new Object[0]);
                this.f941g = null;
            }
            BodyEntry bodyEntry = this.f941g;
            if (bodyEntry != null && bodyEntry.getContentType() != null) {
                addHeader("Content-Type", this.f941g.getContentType());
            }
            return new Request(this);
        }

        public Builder setAllowRequestInBg(boolean z) {
            this.f951q = z;
            return this;
        }

        public Builder setBizId(String str) {
            this.f946l = str;
            return this;
        }

        public Builder setBody(BodyEntry bodyEntry) {
            this.f941g = bodyEntry;
            return this;
        }

        public Builder setCharset(String str) {
            this.f940f = str;
            this.f936b = null;
            return this;
        }

        public Builder setConnectTimeout(int i2) {
            if (i2 > 0) {
                this.f948n = i2;
            }
            return this;
        }

        public Builder setHeaders(Map<String, String> map) {
            this.f938d.clear();
            if (map != null) {
                this.f938d.putAll(map);
            }
            return this;
        }

        public Builder setHostnameVerifier(HostnameVerifier hostnameVerifier) {
            this.f944j = hostnameVerifier;
            return this;
        }

        public Builder setMethod(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("method is null or empty");
            }
            if ("GET".equalsIgnoreCase(str)) {
                this.f937c = "GET";
            } else if ("POST".equalsIgnoreCase(str)) {
                this.f937c = "POST";
            } else if (Method.OPTION.equalsIgnoreCase(str)) {
                this.f937c = Method.OPTION;
            } else if (Method.HEAD.equalsIgnoreCase(str)) {
                this.f937c = Method.HEAD;
            } else if (Method.PUT.equalsIgnoreCase(str)) {
                this.f937c = Method.PUT;
            } else if (Method.DELETE.equalsIgnoreCase(str)) {
                this.f937c = Method.DELETE;
            } else {
                this.f937c = "GET";
            }
            return this;
        }

        public Builder setParams(Map<String, String> map) {
            this.f939e = map;
            this.f936b = null;
            return this;
        }

        public Builder setReadTimeout(int i2) {
            if (i2 > 0) {
                this.f949o = i2;
            }
            return this;
        }

        public Builder setRedirectEnable(boolean z) {
            this.f942h = z;
            return this;
        }

        public Builder setRedirectTimes(int i2) {
            this.f943i = i2;
            return this;
        }

        public Builder setRequestStatistic(RequestStatistic requestStatistic) {
            this.f950p = requestStatistic;
            return this;
        }

        public Builder setSeq(String str) {
            this.f947m = str;
            return this;
        }

        public Builder setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            this.f945k = sSLSocketFactory;
            return this;
        }

        public Builder setUrl(HttpUrl httpUrl) {
            this.f935a = httpUrl;
            this.f936b = null;
            return this;
        }

        public Builder setUrl(String str) {
            this.f935a = HttpUrl.parse(str);
            this.f936b = null;
            if (this.f935a != null) {
                return this;
            }
            throw new IllegalArgumentException("toURL is invalid! toURL = " + str);
        }
    }

    /* compiled from: Taobao */
    public static final class Method {
        public static final String DELETE = "DELETE";
        public static final String GET = "GET";
        public static final String HEAD = "HEAD";
        public static final String OPTION = "OPTIONS";
        public static final String POST = "POST";
        public static final String PUT = "PUT";

        /* renamed from: a */
        static boolean m577a(String str) {
            return str.equals("POST") || str.equals(PUT);
        }

        /* renamed from: b */
        static boolean m578b(String str) {
            return m577a(str) || str.equals(DELETE) || str.equals(OPTION);
        }
    }

    /* renamed from: a */
    private Map<String, String> m541a() {
        return AwcnConfig.isCookieHeaderRedundantFix() ? new HashMap(this.f922g) : this.f922g;
    }

    /* renamed from: b */
    private void m542b() {
        String m706a = C0848c.m706a(this.f923h, getContentEncoding());
        if (!TextUtils.isEmpty(m706a)) {
            if (Method.m577a(this.f921f) && this.f925j == null) {
                try {
                    this.f925j = new ByteArrayEntry(m706a.getBytes(getContentEncoding()));
                    this.f922g.put("Content-Type", "application/x-www-form-urlencoded; charset=" + getContentEncoding());
                } catch (UnsupportedEncodingException unused) {
                }
            } else {
                String urlString = this.f917b.urlString();
                StringBuilder sb = new StringBuilder(urlString);
                if (sb.indexOf("?") == -1) {
                    sb.append('?');
                } else if (urlString.charAt(urlString.length() - 1) != '&') {
                    sb.append(C5736h0.f20714c);
                }
                sb.append(m706a);
                HttpUrl parse = HttpUrl.parse(sb.toString());
                if (parse != null) {
                    this.f918c = parse;
                }
            }
        }
        if (this.f918c == null) {
            this.f918c = this.f917b;
        }
    }

    public boolean containsBody() {
        return this.f925j != null;
    }

    public String getBizId() {
        return this.f927l;
    }

    public byte[] getBodyBytes() {
        if (this.f925j == null) {
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
        return this.f930o;
    }

    public String getContentEncoding() {
        String str = this.f924i;
        return str != null ? str : "UTF-8";
    }

    public Map<String, String> getHeaders() {
        return Collections.unmodifiableMap(this.f922g);
    }

    public String getHost() {
        return this.f918c.host();
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.f932q;
    }

    public HttpUrl getHttpUrl() {
        return this.f918c;
    }

    public String getMethod() {
        return this.f921f;
    }

    public int getReadTimeout() {
        return this.f931p;
    }

    public int getRedirectTimes() {
        return this.f929n;
    }

    public String getSeq() {
        return this.f928m;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.f933r;
    }

    public URL getUrl() {
        if (this.f920e == null) {
            HttpUrl httpUrl = this.f919d;
            if (httpUrl == null) {
                httpUrl = this.f918c;
            }
            this.f920e = httpUrl.toURL();
        }
        return this.f920e;
    }

    public String getUrlString() {
        return this.f918c.urlString();
    }

    public boolean isAllowRequestInBg() {
        return this.f934s;
    }

    public boolean isRedirectEnable() {
        return this.f926k;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.f937c = this.f921f;
        builder.f938d = m541a();
        builder.f939e = this.f923h;
        builder.f941g = this.f925j;
        builder.f940f = this.f924i;
        builder.f942h = this.f926k;
        builder.f943i = this.f929n;
        builder.f944j = this.f932q;
        builder.f945k = this.f933r;
        builder.f935a = this.f917b;
        builder.f936b = this.f918c;
        builder.f946l = this.f927l;
        builder.f947m = this.f928m;
        builder.f948n = this.f930o;
        builder.f949o = this.f931p;
        builder.f950p = this.f916a;
        builder.f951q = this.f934s;
        return builder;
    }

    public int postBody(OutputStream outputStream) throws IOException {
        BodyEntry bodyEntry = this.f925j;
        if (bodyEntry != null) {
            return bodyEntry.writeTo(outputStream);
        }
        return 0;
    }

    public void setDnsOptimize(String str, int i2) {
        if (str != null) {
            if (this.f919d == null) {
                this.f919d = new HttpUrl(this.f918c);
            }
            this.f919d.replaceIpAndPort(str, i2);
        } else {
            this.f919d = null;
        }
        this.f920e = null;
        this.f916a.setIPAndPort(str, i2);
    }

    public void setUrlScheme(boolean z) {
        if (this.f919d == null) {
            this.f919d = new HttpUrl(this.f918c);
        }
        this.f919d.setScheme(z ? HttpConstant.HTTPS : HttpConstant.HTTP);
        this.f920e = null;
    }

    private Request(Builder builder) {
        this.f921f = "GET";
        this.f926k = true;
        this.f929n = 0;
        this.f930o = 10000;
        this.f931p = 10000;
        this.f921f = builder.f937c;
        this.f922g = builder.f938d;
        this.f923h = builder.f939e;
        this.f925j = builder.f941g;
        this.f924i = builder.f940f;
        this.f926k = builder.f942h;
        this.f929n = builder.f943i;
        this.f932q = builder.f944j;
        this.f933r = builder.f945k;
        this.f927l = builder.f946l;
        this.f928m = builder.f947m;
        this.f930o = builder.f948n;
        this.f931p = builder.f949o;
        this.f917b = builder.f935a;
        this.f918c = builder.f936b;
        if (this.f918c == null) {
            m542b();
        }
        this.f916a = builder.f950p != null ? builder.f950p : new RequestStatistic(getHost(), this.f927l);
        this.f934s = builder.f951q;
    }
}
