package com.xiaomi.push;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.huawei.hms.framework.common.ContainerUtils;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.analytics.pro.C3397d;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import p245d.C4443d;

/* renamed from: com.xiaomi.push.au */
/* loaded from: classes2.dex */
public class C4092au {

    /* renamed from: a */
    private static final AtomicReference<a<C4093av>> f14572a = new AtomicReference<>(m13783a());

    /* renamed from: a */
    public static final Pattern f14573a = Pattern.compile("([^\\s;]+)(.*)");

    /* renamed from: b */
    public static final Pattern f14574b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    /* renamed from: c */
    public static final Pattern f14575c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    /* renamed from: com.xiaomi.push.au$a */
    private static class a<T> extends FutureTask<T> {

        /* renamed from: a */
        private long f14576a;

        public a(Callable<T> callable) {
            super(callable);
        }

        /* renamed from: a */
        public boolean m13809a() {
            return C4300j.m15681a(C4309r.m15715a()) || (isDone() && Math.abs(SystemClock.elapsedRealtime() - this.f14576a) > 1800000);
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
        public void run() {
            this.f14576a = SystemClock.elapsedRealtime();
            super.run();
        }
    }

    /* renamed from: com.xiaomi.push.au$b */
    public static final class b extends FilterInputStream {

        /* renamed from: a */
        private boolean f14577a;

        public b(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) {
            int read;
            if (!this.f14577a && (read = super.read(bArr, i2, i3)) != -1) {
                return read;
            }
            this.f14577a = true;
            return -1;
        }
    }

    /* renamed from: com.xiaomi.push.au$c */
    public static class c {

        /* renamed from: a */
        public int f14578a;

        /* renamed from: a */
        public Map<String, String> f14579a;

        public String toString() {
            return String.format("resCode = %1$d, headers = %2$s", Integer.valueOf(this.f14578a), this.f14579a.toString());
        }
    }

    /* renamed from: a */
    public static InputStream m13786a(Context context, URL url, boolean z, String str, String str2) {
        return m13787a(context, url, z, str, str2, null, null);
    }

    /* renamed from: b */
    public static void m13800b() {
        f14572a.set(m13783a());
    }

    /* renamed from: c */
    public static boolean m13802c(Context context) {
        C4093av m13784a = m13784a();
        return m13784a != null && m13784a.m13815a();
    }

    /* renamed from: d */
    public static boolean m13803d(Context context) {
        C4093av m13784a = m13784a();
        return m13784a != null && 1 == m13784a.m13811a();
    }

    /* renamed from: e */
    public static boolean m13804e(Context context) {
        C4093av m13785a = m13785a(context);
        return m13785a != null && m13785a.m13811a() == 0 && 20 == m13785a.m13816b();
    }

    /* renamed from: f */
    public static boolean m13805f(Context context) {
        C4093av m13785a = m13785a(context);
        return m13785a != null && m13785a.m13811a() == 0 && 13 == m13785a.m13816b();
    }

    /* renamed from: g */
    public static boolean m13806g(Context context) {
        C4093av m13785a = m13785a(context);
        if (m13785a == null || m13785a.m13811a() != 0) {
            return false;
        }
        String m13817b = m13785a.m13817b();
        if (!"TD-SCDMA".equalsIgnoreCase(m13817b) && !"CDMA2000".equalsIgnoreCase(m13817b) && !"WCDMA".equalsIgnoreCase(m13817b)) {
            switch (m13785a.m13816b()) {
            }
            return false;
        }
        return true;
    }

    /* renamed from: h */
    public static boolean m13807h(Context context) {
        C4093av m13785a = m13785a(context);
        if (m13785a == null || m13785a.m13811a() != 0) {
            return false;
        }
        int m13816b = m13785a.m13816b();
        return m13816b == 1 || m13816b == 2 || m13816b == 4 || m13816b == 7 || m13816b == 11;
    }

    /* renamed from: a */
    public static void m13797a() {
        m13800b();
    }

    /* renamed from: b */
    public static boolean m13801b(Context context) {
        boolean z;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                    if (networkCapabilities != null) {
                        z = networkCapabilities.hasCapability(16);
                    }
                } catch (Exception unused) {
                }
            } else {
                z = m13799a(context);
            }
            return z && m13802c(context);
        }
        z = false;
        if (z) {
            return false;
        }
    }

    /* renamed from: a */
    public static Object m13788a(Context context) {
        ConnectivityManager connectivityManager;
        NetworkRequest build;
        ConnectivityManager.NetworkCallback networkCallback;
        if (context == null) {
            context = C4309r.m15715a();
        }
        ConnectivityManager.NetworkCallback networkCallback2 = null;
        if (context == null || C4300j.m15681a(context) || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            build = new NetworkRequest.Builder().build();
            networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.xiaomi.push.au.1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network2) {
                    super.onAvailable(network2);
                    C4092au.m13800b();
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network2) {
                    super.onLost(network2);
                    C4092au.m13800b();
                }
            };
        } catch (Throwable th) {
            th = th;
        }
        try {
            connectivityManager.registerNetworkCallback(build, networkCallback);
            return networkCallback;
        } catch (Throwable th2) {
            th = th2;
            networkCallback2 = networkCallback;
            AbstractC4022b.m13347a("exception occurred in adding network callback :" + th);
            return networkCallback2;
        }
    }

    /* renamed from: a */
    public static void m13798a(Context context, Object obj) {
        if (Build.VERSION.SDK_INT < 21) {
            AbstractC4022b.m13356b("less than LOLLIPOP(21) not support channel ");
            return;
        }
        if (context == null || obj == null) {
            return;
        }
        try {
            if (obj instanceof ConnectivityManager.NetworkCallback) {
                ((ConnectivityManager) context.getSystemService("connectivity")).unregisterNetworkCallback((ConnectivityManager.NetworkCallback) obj);
            }
        } catch (Throwable th) {
            AbstractC4022b.m13347a("exception occurred in removing network callback :" + th);
        }
    }

    /* renamed from: a */
    private static a<C4093av> m13783a() {
        return new a<>(new Callable<C4093av>() { // from class: com.xiaomi.push.au.2
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C4093av call() {
                NetworkInfo activeNetworkInfo;
                Context m15715a = C4309r.m15715a();
                if (m15715a == null) {
                    return null;
                }
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) m15715a.getSystemService("connectivity");
                    if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                        return null;
                    }
                    return new C4093av(activeNetworkInfo);
                } catch (Exception unused) {
                    return null;
                }
            }
        });
    }

    /* renamed from: a */
    public static C4093av m13784a() {
        a<C4093av> aVar = f14572a.get();
        if (aVar != null) {
            try {
                if (aVar.m13809a()) {
                    AtomicReference<a<C4093av>> atomicReference = f14572a;
                    a<C4093av> m13783a = m13783a();
                    atomicReference.set(m13783a);
                    aVar = m13783a;
                }
                if (!aVar.isDone()) {
                    aVar.run();
                }
                return aVar.get();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: a */
    public static InputStream m13787a(Context context, URL url, boolean z, String str, String str2, Map<String, String> map, c cVar) {
        if (context == null) {
            throw new IllegalArgumentException(C3397d.f11892R);
        }
        if (url != null) {
            URL url2 = !z ? new URL(m13792a(url.toString())) : url;
            try {
                HttpURLConnection.setFollowRedirects(true);
                HttpURLConnection m13795a = m13795a(context, url2);
                m13795a.setConnectTimeout(10000);
                m13795a.setReadTimeout(15000);
                if (!TextUtils.isEmpty(str)) {
                    m13795a.setRequestProperty(HttpHeaders.USER_AGENT, str);
                }
                if (str2 != null) {
                    m13795a.setRequestProperty("Cookie", str2);
                }
                if (map != null) {
                    for (String str3 : map.keySet()) {
                        m13795a.setRequestProperty(str3, map.get(str3));
                    }
                }
                if (cVar != null && (url.getProtocol().equals(HttpConstant.HTTP) || url.getProtocol().equals(HttpConstant.HTTPS))) {
                    cVar.f14578a = m13795a.getResponseCode();
                    if (cVar.f14579a == null) {
                        cVar.f14579a = new HashMap();
                    }
                    int i2 = 0;
                    while (true) {
                        String headerFieldKey = m13795a.getHeaderFieldKey(i2);
                        String headerField = m13795a.getHeaderField(i2);
                        if (headerFieldKey == null && headerField == null) {
                            break;
                        }
                        if (!TextUtils.isEmpty(headerFieldKey) && !TextUtils.isEmpty(headerField)) {
                            cVar.f14579a.put(headerFieldKey, headerField);
                        }
                        i2++;
                    }
                }
                return new b(m13795a.getInputStream());
            } catch (IOException e2) {
                throw new IOException("IOException:" + e2.getClass().getSimpleName());
            } catch (Throwable th) {
                throw new IOException(th.getMessage());
            }
        }
        throw new IllegalArgumentException("url");
    }

    /* renamed from: a */
    public static String m13790a(Context context, URL url) {
        return m13791a(context, url, false, null, "UTF-8", null);
    }

    /* renamed from: a */
    public static String m13791a(Context context, URL url, boolean z, String str, String str2, String str3) {
        InputStream inputStream;
        try {
            inputStream = m13786a(context, url, z, str, str3);
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            StringBuilder sb = new StringBuilder(1024);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str2));
            char[] cArr = new char[4096];
            while (true) {
                int read = bufferedReader.read(cArr);
                if (-1 != read) {
                    sb.append(cArr, 0, read);
                } else {
                    C4408w.m16356a((Closeable) inputStream);
                    return sb.toString();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            C4408w.m16356a((Closeable) inputStream);
            throw th;
        }
    }

    /* renamed from: a */
    public static String m13792a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new String();
        return String.format("%s&key=%s", str, C4099ba.m13875a(String.format("%sbe988a6134bc8254465424e5a70ef037", str)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static String m13793a(String str, Map<String, String> map, File file, String str2) {
        if (!file.exists()) {
            return null;
        }
        String name = file.getName();
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=*****");
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection.setFixedLengthStreamingMode(name.length() + 77 + ((int) file.length()) + str2.length());
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.writeBytes("--*****\r\n");
                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str2 + "\";filename=\"" + file.getName() + "\"\r\n");
                dataOutputStream.writeBytes("\r\n");
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        dataOutputStream.write(bArr, 0, read);
                        dataOutputStream.flush();
                    }
                    dataOutputStream.writeBytes("\r\n");
                    dataOutputStream.writeBytes(C4443d.f16920D);
                    dataOutputStream.writeBytes("*****");
                    dataOutputStream.writeBytes(C4443d.f16920D);
                    dataOutputStream.writeBytes("\r\n");
                    dataOutputStream.flush();
                    StringBuffer stringBuffer = new StringBuffer();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new b(httpURLConnection.getInputStream())));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                stringBuffer.append(readLine);
                            } else {
                                String stringBuffer2 = stringBuffer.toString();
                                C4408w.m16356a((Closeable) fileInputStream);
                                C4408w.m16356a(bufferedReader);
                                return stringBuffer2;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            throw new IOException("IOException:" + e.getClass().getSimpleName());
                        } catch (Throwable th) {
                            th = th;
                            throw new IOException(th.getMessage());
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e4) {
                e = e4;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            C4408w.m16356a((Closeable) null);
            C4408w.m16356a((Closeable) file);
            throw th4;
        }
    }

    /* renamed from: a */
    public static int m13780a(Context context) {
        C4093av m13784a = m13784a();
        if (m13784a == null) {
            return -1;
        }
        return m13784a.m13811a();
    }

    /* renamed from: a */
    public static HttpURLConnection m13795a(Context context, URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    /* renamed from: a */
    public static boolean m13799a(Context context) {
        return m13780a(context) >= 0;
    }

    /* renamed from: a */
    public static C4093av m13785a(Context context) {
        return m13784a();
    }

    /* renamed from: a */
    public static String m13789a(Context context) {
        if (m13803d(context)) {
            return UtilityImpl.NET_TYPE_WIFI;
        }
        C4093av m13784a = m13784a();
        if (m13784a == null) {
            return "";
        }
        return (m13784a.m13814a() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + m13784a.m13817b()).toLowerCase();
    }

    /* renamed from: a */
    public static C4090as m13782a(Context context, String str, Map<String, String> map) {
        return m13781a(context, str, "POST", (Map<String, String>) null, m13794a(map));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C4090as m13781a(Context context, String str, String str2, Map<String, String> map, String str3) {
        boolean z;
        BufferedReader bufferedReader;
        OutputStream outputStream;
        C4090as c4090as = new C4090as();
        try {
            try {
                try {
                    HttpURLConnection m13795a = m13795a(context, m13796a(str));
                    m13795a.setConnectTimeout(10000);
                    m13795a.setReadTimeout(15000);
                    String str4 = str2;
                    if (str2 == 0) {
                        str4 = "GET";
                    }
                    m13795a.setRequestMethod(str4);
                    int i2 = 0;
                    if (map != null) {
                        z = HttpConstant.GZIP.equalsIgnoreCase(map.get("Content-Encoding"));
                        for (String str5 : map.keySet()) {
                            m13795a.setRequestProperty(str5, map.get(str5));
                        }
                    } else {
                        z = false;
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        m13795a.setDoOutput(true);
                        byte[] bytes = str3.getBytes();
                        if (z) {
                            outputStream = new GZIPOutputStream(m13795a.getOutputStream());
                        } else {
                            outputStream = m13795a.getOutputStream();
                        }
                        try {
                            outputStream.write(bytes, 0, bytes.length);
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException e2) {
                            e = e2;
                            throw new IOException("err while request " + str + Constants.COLON_SEPARATOR + e.getClass().getSimpleName());
                        } catch (Throwable th) {
                            th = th;
                            throw new IOException(th.getMessage());
                        }
                    }
                    c4090as.f14569a = m13795a.getResponseCode();
                    AbstractC4022b.m13347a("Http POST Response Code: " + c4090as.f14569a);
                    while (true) {
                        String headerFieldKey = m13795a.getHeaderFieldKey(i2);
                        String headerField = m13795a.getHeaderField(i2);
                        if (headerFieldKey == null && headerField == null) {
                            try {
                                break;
                            } catch (IOException unused) {
                                bufferedReader = new BufferedReader(new InputStreamReader(new b(m13795a.getErrorStream())));
                            }
                        } else {
                            c4090as.f14571a.put(headerFieldKey, headerField);
                            i2 = i2 + 1 + 1;
                        }
                    }
                    bufferedReader = new BufferedReader(new InputStreamReader(new b(m13795a.getInputStream())));
                    try {
                        StringBuffer stringBuffer = new StringBuffer();
                        String property = System.getProperty("line.separator");
                        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                            stringBuffer.append(readLine);
                            stringBuffer.append(property);
                        }
                        c4090as.f14570a = stringBuffer.toString();
                        bufferedReader.close();
                        C4408w.m16356a((Closeable) null);
                        C4408w.m16356a((Closeable) null);
                        return c4090as;
                    } catch (IOException e3) {
                        e = e3;
                        throw new IOException("err while request " + str + Constants.COLON_SEPARATOR + e.getClass().getSimpleName());
                    } catch (Throwable th2) {
                        th = th2;
                        throw new IOException(th.getMessage());
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e4) {
                e = e4;
            }
        } catch (Throwable th4) {
            C4408w.m16356a((Closeable) null);
            C4408w.m16356a((Closeable) str2);
            throw th4;
        }
    }

    /* renamed from: a */
    public static String m13794a(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                try {
                    stringBuffer.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                    stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    stringBuffer.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                    stringBuffer.append("&");
                } catch (UnsupportedEncodingException e2) {
                    AbstractC4022b.m13347a("Failed to convert from params map to string: " + e2);
                    AbstractC4022b.m13347a("map: " + map.toString());
                    return null;
                }
            }
        }
        if (stringBuffer.length() > 0) {
            stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private static URL m13796a(String str) {
        return new URL(str);
    }
}
