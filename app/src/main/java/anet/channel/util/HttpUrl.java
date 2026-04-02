package anet.channel.util;

import android.text.TextUtils;
import anet.channel.strategy.StrategyCenter;
import com.xiaomi.mipush.sdk.Constants;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class HttpUrl {
    private String host;
    private volatile boolean isSchemeLocked;
    private String path;
    private int port;
    private String scheme;
    private String simpleUrl;
    private String url;

    private HttpUrl() {
        this.isSchemeLocked = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b3, code lost:
    
        if (r0.port > 65535) goto L53;
     */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0134  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HttpUrl parse(String str) {
        int i2;
        int i3;
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strTrim = str.trim();
        HttpUrl httpUrl = new HttpUrl();
        httpUrl.url = strTrim;
        int i4 = 0;
        if (strTrim.startsWith("//")) {
            httpUrl.scheme = null;
            i2 = 0;
        } else {
            if (!strTrim.regionMatches(true, 0, "https:", 0, 6)) {
                if (strTrim.regionMatches(true, 0, "http:", 0, 5)) {
                    httpUrl.scheme = HttpConstant.HTTP;
                    i2 = 5;
                }
                return null;
            }
            httpUrl.scheme = HttpConstant.HTTPS;
            i2 = 6;
        }
        int length = strTrim.length();
        int i5 = i2 + 2;
        int i6 = i5;
        boolean z = false;
        while (i6 < length) {
            char cCharAt = strTrim.charAt(i6);
            if (cCharAt == '[') {
                z = true;
            } else if (cCharAt == ']') {
                z = false;
            } else if (cCharAt == '/' || cCharAt == '?' || cCharAt == '#' || (cCharAt == ':' && !z)) {
                httpUrl.host = strTrim.substring(i5, i6);
                break;
            }
            i6++;
        }
        if (i6 == length) {
            httpUrl.host = strTrim.substring(i5);
        }
        int i7 = 0;
        while (i6 < length) {
            char cCharAt2 = strTrim.charAt(i6);
            if (cCharAt2 == ':' && i7 == 0) {
                i7 = i6 + 1;
            } else if (cCharAt2 == '/' || cCharAt2 == '#' || cCharAt2 == '?') {
                i3 = i6;
                break;
            }
            i6++;
        }
        i3 = length;
        if (i7 != 0) {
            try {
                httpUrl.port = Integer.parseInt(strTrim.substring(i7, i3));
                if (httpUrl.port > 0) {
                }
            } catch (NumberFormatException unused) {
            }
            return null;
        }
        while (i6 < length) {
            char cCharAt3 = strTrim.charAt(i6);
            if (cCharAt3 == '/' && i4 == 0) {
                i4 = i6;
            } else if (cCharAt3 == '?' || cCharAt3 == '#') {
                int i8 = i4 != 0 ? i6 : length;
                if (i4 == 0) {
                    httpUrl.path = strTrim.substring(i4, i8);
                } else {
                    httpUrl.path = null;
                }
                if (httpUrl.scheme == null) {
                    int i9 = httpUrl.port;
                    if (i9 == 80) {
                        httpUrl.scheme = HttpConstant.HTTP;
                    } else if (i9 == 443) {
                        httpUrl.scheme = HttpConstant.HTTPS;
                    } else {
                        httpUrl.scheme = StrategyCenter.getInstance().getSchemeByHost(httpUrl.host, null);
                    }
                }
                if (!TextUtils.isEmpty(httpUrl.scheme) && !TextUtils.isEmpty(httpUrl.host)) {
                    StringBuilder sb = new StringBuilder(httpUrl.scheme);
                    sb.append(HttpConstant.SCHEME_SPLIT);
                    sb.append(httpUrl.host);
                    if (httpUrl.containsNonDefaultPort()) {
                        sb.append(Constants.COLON_SEPARATOR);
                        sb.append(httpUrl.port);
                    }
                    str2 = httpUrl.path;
                    if (str2 == null) {
                        sb.append(str2);
                    } else if (i6 != length) {
                        sb.append("/");
                    }
                    httpUrl.simpleUrl = sb.toString();
                    sb.append(strTrim.substring(i6));
                    httpUrl.url = sb.toString();
                    return httpUrl;
                }
                return null;
            }
            i6++;
        }
        if (i4 == 0) {
        }
        if (httpUrl.scheme == null) {
        }
        if (!TextUtils.isEmpty(httpUrl.scheme)) {
            StringBuilder sb2 = new StringBuilder(httpUrl.scheme);
            sb2.append(HttpConstant.SCHEME_SPLIT);
            sb2.append(httpUrl.host);
            if (httpUrl.containsNonDefaultPort()) {
            }
            str2 = httpUrl.path;
            if (str2 == null) {
            }
            httpUrl.simpleUrl = sb2.toString();
            sb2.append(strTrim.substring(i6));
            httpUrl.url = sb2.toString();
            return httpUrl;
        }
        return null;
    }

    public boolean containsNonDefaultPort() {
        return this.port != 0 && ((HttpConstant.HTTP.equals(this.scheme) && this.port != 80) || (HttpConstant.HTTPS.equals(this.scheme) && this.port != 443));
    }

    public void downgradeSchemeAndLock() {
        this.isSchemeLocked = true;
        if (HttpConstant.HTTP.equals(this.scheme)) {
            return;
        }
        this.scheme = HttpConstant.HTTP;
        String str = this.scheme;
        String str2 = this.url;
        this.url = StringUtils.concatString(str, Constants.COLON_SEPARATOR, str2.substring(str2.indexOf("//")));
    }

    public int getPort() {
        return this.port;
    }

    public String host() {
        return this.host;
    }

    public boolean isSchemeLocked() {
        return this.isSchemeLocked;
    }

    public void lockScheme() {
        this.isSchemeLocked = true;
    }

    public String path() {
        return this.path;
    }

    public void replaceIpAndPort(String str, int i2) {
        if (str != null) {
            int iIndexOf = this.url.indexOf("//") + 2;
            while (iIndexOf < this.url.length() && this.url.charAt(iIndexOf) != '/') {
                iIndexOf++;
            }
            boolean zB = anet.channel.strategy.utils.c.b(str);
            StringBuilder sb = new StringBuilder(this.url.length() + str.length());
            sb.append(this.scheme);
            sb.append(HttpConstant.SCHEME_SPLIT);
            if (zB) {
                sb.append('[');
            }
            sb.append(str);
            if (zB) {
                sb.append(']');
            }
            if (i2 != 0) {
                sb.append(':');
                sb.append(i2);
            } else if (this.port != 0) {
                sb.append(':');
                sb.append(this.port);
            }
            sb.append(this.url.substring(iIndexOf));
            this.url = sb.toString();
        }
    }

    public String scheme() {
        return this.scheme;
    }

    public void setScheme(String str) {
        if (this.isSchemeLocked || str.equalsIgnoreCase(this.scheme)) {
            return;
        }
        this.scheme = str;
        String str2 = this.url;
        this.url = StringUtils.concatString(str, Constants.COLON_SEPARATOR, str2.substring(str2.indexOf("//")));
        this.simpleUrl = StringUtils.concatString(str, Constants.COLON_SEPARATOR, this.simpleUrl.substring(this.url.indexOf("//")));
    }

    public String simpleUrlString() {
        return this.simpleUrl;
    }

    public String toString() {
        return this.url;
    }

    public URL toURL() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    public String urlString() {
        return this.url;
    }

    public HttpUrl(HttpUrl httpUrl) {
        this.isSchemeLocked = false;
        this.scheme = httpUrl.scheme;
        this.host = httpUrl.host;
        this.path = httpUrl.path;
        this.url = httpUrl.url;
        this.simpleUrl = httpUrl.simpleUrl;
        this.isSchemeLocked = httpUrl.isSchemeLocked;
    }
}
