package com.tencent.open.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.p207a.C3203a;
import com.tencent.open.log.C3277d;
import com.tencent.open.log.SLog;
import com.tencent.open.p211a.C3255f;
import com.tencent.open.p211a.InterfaceC3256g;
import com.tencent.tauth.IRequestListener;
import com.xiaomi.mipush.sdk.Constants;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Map;
import java.util.zip.ZipException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class HttpUtils {

    /* compiled from: ProGuard */
    public static class NetworkUnavailableException extends Exception {
        public static final String ERROR_INFO = "network unavailable";

        public NetworkUnavailableException(String str) {
            super(str);
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.utils.HttpUtils$a */
    public static class C3282a {

        /* renamed from: a */
        public final String f11283a;

        /* renamed from: b */
        public final int f11284b;

        private C3282a(String str, int i2) {
            this.f11283a = str;
            this.f11284b = i2;
        }
    }

    private HttpUtils() {
    }

    /* renamed from: a */
    private static void m10569a(Context context, QQToken qQToken, String str) {
        if (str.indexOf("add_share") > -1 || str.indexOf("upload_pic") > -1 || str.indexOf("add_topic") > -1 || str.indexOf("set_user_face") > -1 || str.indexOf("add_t") > -1 || str.indexOf("add_pic_t") > -1 || str.indexOf("add_pic_url") > -1 || str.indexOf("add_video") > -1) {
            C3203a.m10154a(context, qQToken, "requireApi", str);
        }
    }

    /* renamed from: b */
    private static Map<String, byte[]> m10571b(Bundle bundle) {
        HashMap hashMap = new HashMap(0);
        if (bundle != null && bundle.size() != 0) {
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof byte[]) {
                    hashMap.put(str, (byte[]) obj);
                }
            }
        }
        return hashMap;
    }

    public static String encodeUrl(Bundle bundle) {
        return encodeUrl(m10568a(bundle));
    }

    public static int getErrorCodeFromException(IOException iOException) {
        if (iOException instanceof CharConversionException) {
            return -20;
        }
        if (iOException instanceof MalformedInputException) {
            return -21;
        }
        if (iOException instanceof UnmappableCharacterException) {
            return -22;
        }
        if (iOException instanceof ClosedChannelException) {
            return -24;
        }
        if (iOException instanceof EOFException) {
            return -26;
        }
        if (iOException instanceof FileLockInterruptionException) {
            return -27;
        }
        if (iOException instanceof FileNotFoundException) {
            return -28;
        }
        if (iOException instanceof HttpRetryException) {
            return -29;
        }
        if (iOException instanceof SocketTimeoutException) {
            return -8;
        }
        if (iOException instanceof InvalidPropertiesFormatException) {
            return -30;
        }
        if (iOException instanceof MalformedURLException) {
            return -3;
        }
        if (iOException instanceof InvalidClassException) {
            return -33;
        }
        if (iOException instanceof InvalidObjectException) {
            return -34;
        }
        if (iOException instanceof NotActiveException) {
            return -35;
        }
        if (iOException instanceof NotSerializableException) {
            return -36;
        }
        if (iOException instanceof OptionalDataException) {
            return -37;
        }
        if (iOException instanceof StreamCorruptedException) {
            return -38;
        }
        if (iOException instanceof WriteAbortedException) {
            return -39;
        }
        if (iOException instanceof ProtocolException) {
            return -40;
        }
        if (iOException instanceof SSLHandshakeException) {
            return -41;
        }
        if (iOException instanceof SSLKeyException) {
            return -42;
        }
        if (iOException instanceof SSLPeerUnverifiedException) {
            return -43;
        }
        if (iOException instanceof SSLProtocolException) {
            return -44;
        }
        if (iOException instanceof BindException) {
            return -45;
        }
        if (iOException instanceof ConnectException) {
            return -46;
        }
        if (iOException instanceof NoRouteToHostException) {
            return -47;
        }
        if (iOException instanceof PortUnreachableException) {
            return -48;
        }
        if (iOException instanceof SyncFailedException) {
            return -49;
        }
        if (iOException instanceof UTFDataFormatException) {
            return -50;
        }
        if (iOException instanceof UnknownHostException) {
            return -51;
        }
        if (iOException instanceof UnknownServiceException) {
            return -52;
        }
        if (iOException instanceof UnsupportedEncodingException) {
            return -53;
        }
        return iOException instanceof ZipException ? -54 : -2;
    }

    public static C3282a getProxy(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return null;
        }
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception unused) {
            networkInfo = null;
        }
        if (networkInfo != null && networkInfo.getType() == 0) {
            String m10570b = m10570b(context);
            int m10566a = m10566a(context);
            if (!TextUtils.isEmpty(m10570b) && m10566a >= 0) {
                return new C3282a(m10570b, m10566a);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x018b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject request(com.tencent.connect.auth.QQToken r21, android.content.Context r22, java.lang.String r23, android.os.Bundle r24, java.lang.String r25) throws java.io.IOException, org.json.JSONException, com.tencent.open.utils.HttpUtils.NetworkUnavailableException, com.tencent.open.utils.HttpUtils.HttpStatusException {
        /*
            Method dump skipped, instructions count: 413
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.HttpUtils.request(com.tencent.connect.auth.QQToken, android.content.Context, java.lang.String, android.os.Bundle, java.lang.String):org.json.JSONObject");
    }

    public static void requestAsync(final QQToken qQToken, final Context context, final String str, final Bundle bundle, final String str2, final IRequestListener iRequestListener) {
        SLog.m10502i("openSDK_LOG.HttpUtils", "OpenApi requestAsync");
        C3294l.m10654a(new Runnable() { // from class: com.tencent.open.utils.HttpUtils.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject request = HttpUtils.request(QQToken.this, context, str, bundle, str2);
                    if (iRequestListener != null) {
                        iRequestListener.onComplete(request);
                        SLog.m10502i("openSDK_LOG.HttpUtils", "OpenApi onComplete");
                    }
                } catch (HttpStatusException e2) {
                    IRequestListener iRequestListener2 = iRequestListener;
                    if (iRequestListener2 != null) {
                        iRequestListener2.onHttpStatusException(e2);
                        SLog.m10500e("openSDK_LOG.HttpUtils", "OpenApi requestAsync onHttpStatusException" + e2.toString());
                    }
                } catch (NetworkUnavailableException e3) {
                    IRequestListener iRequestListener3 = iRequestListener;
                    if (iRequestListener3 != null) {
                        iRequestListener3.onNetworkUnavailableException(e3);
                        SLog.m10500e("openSDK_LOG.HttpUtils", "OpenApi requestAsync onNetworkUnavailableException" + e3.toString());
                    }
                } catch (MalformedURLException e4) {
                    IRequestListener iRequestListener4 = iRequestListener;
                    if (iRequestListener4 != null) {
                        iRequestListener4.onMalformedURLException(e4);
                        SLog.m10500e("openSDK_LOG.HttpUtils", "OpenApi requestAsync MalformedURLException" + e4.toString());
                    }
                } catch (SocketTimeoutException e5) {
                    IRequestListener iRequestListener5 = iRequestListener;
                    if (iRequestListener5 != null) {
                        iRequestListener5.onSocketTimeoutException(e5);
                        SLog.m10500e("openSDK_LOG.HttpUtils", "OpenApi requestAsync onSocketTimeoutException" + e5.toString());
                    }
                } catch (IOException e6) {
                    IRequestListener iRequestListener6 = iRequestListener;
                    if (iRequestListener6 != null) {
                        iRequestListener6.onIOException(e6);
                        SLog.m10500e("openSDK_LOG.HttpUtils", "OpenApi requestAsync IOException" + e6.toString());
                    }
                } catch (JSONException e7) {
                    IRequestListener iRequestListener7 = iRequestListener;
                    if (iRequestListener7 != null) {
                        iRequestListener7.onJSONException(e7);
                        SLog.m10500e("openSDK_LOG.HttpUtils", "OpenApi requestAsync JSONException" + e7.toString());
                    }
                } catch (Exception e8) {
                    IRequestListener iRequestListener8 = iRequestListener;
                    if (iRequestListener8 != null) {
                        iRequestListener8.onUnknowException(e8);
                        SLog.m10500e("openSDK_LOG.HttpUtils", "OpenApi requestAsync onUnknowException" + e8.toString());
                    }
                }
            }
        });
    }

    /* compiled from: ProGuard */
    public static class HttpStatusException extends Exception {
        public static final String ERROR_INFO = "http status code error:";
        public final int statusCode;

        public HttpStatusException(String str) {
            super(str);
            this.statusCode = -1;
        }

        public HttpStatusException(int i2) {
            super(ERROR_INFO + i2);
            this.statusCode = i2;
        }
    }

    public static String encodeUrl(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : map.keySet()) {
            if (z) {
                z = false;
            } else {
                sb.append("&");
            }
            sb.append(URLEncoder.encode(str));
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(URLEncoder.encode(map.get(str)));
        }
        return sb.toString();
    }

    /* renamed from: b */
    private static String m10570b(Context context) {
        if (Build.VERSION.SDK_INT >= 11) {
            return System.getProperty("http.proxyHost");
        }
        if (context != null) {
            String host = Proxy.getHost(context);
            return TextUtils.isEmpty(host) ? Proxy.getDefaultHost() : host;
        }
        return Proxy.getDefaultHost();
    }

    /* renamed from: a */
    private static InterfaceC3256g m10567a(String str, String str2, Bundle bundle) throws IOException {
        Bundle bundle2;
        if (bundle != null) {
            bundle2 = new Bundle(bundle);
        } else {
            bundle2 = new Bundle();
        }
        if (str2.equalsIgnoreCase("GET")) {
            Map<String, String> m10568a = m10568a(bundle2);
            Bundle m10548b = C3277d.m10548b(bundle2);
            if (m10548b != bundle2) {
                SLog.m10502i("openSDK_LOG.HttpUtils", "-->openUrl encodedParam =" + m10548b.toString() + " -- url = " + str);
            } else {
                SLog.m10502i("openSDK_LOG.HttpUtils", "-->openUrl encodedParam =" + m10568a.toString() + " -- url = " + str);
            }
            return C3255f.m10416a().m10420a(str, m10568a);
        }
        if (str2.equalsIgnoreCase("POST")) {
            Map<String, String> m10568a2 = m10568a(bundle2);
            Map<String, byte[]> m10571b = m10571b(bundle2);
            if (m10571b != null && m10571b.size() != 0) {
                SLog.m10508w("openSDK_LOG.HttpUtils", "openUrl: has binary " + m10571b.size());
                return C3255f.m10416a().m10421a(str, m10568a2, m10571b);
            }
            return C3255f.m10416a().m10424b(str, m10568a2);
        }
        SLog.m10500e("openSDK_LOG.HttpUtils", "openUrl: http method " + str2 + " is not supported.");
        throw new IOException("http method is not supported.");
    }

    /* renamed from: a */
    private static Map<String, String> m10568a(Bundle bundle) {
        HashMap hashMap = new HashMap();
        if (bundle != null && bundle.size() != 0) {
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (!(obj instanceof String) && !(obj instanceof String[])) {
                    SLog.m10508w("openSDK_LOG.HttpUtils", "parseBundleToMap: the type " + obj.getClass() + " is unsupported");
                } else if (obj instanceof String[]) {
                    String[] strArr = (String[]) obj;
                    StringBuilder sb = new StringBuilder();
                    for (int i2 = 0; i2 < strArr.length; i2++) {
                        if (i2 != 0) {
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        sb.append(strArr[i2]);
                    }
                    hashMap.put(str, sb.toString());
                } else {
                    hashMap.put(str, (String) obj);
                }
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    private static int m10566a(Context context) {
        if (Build.VERSION.SDK_INT < 11) {
            if (context != null) {
                int port = Proxy.getPort(context);
                return port < 0 ? Proxy.getDefaultPort() : port;
            }
            return Proxy.getDefaultPort();
        }
        String property = System.getProperty("http.proxyPort");
        if (!TextUtils.isEmpty(property)) {
            try {
                return Integer.parseInt(property);
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }
}
