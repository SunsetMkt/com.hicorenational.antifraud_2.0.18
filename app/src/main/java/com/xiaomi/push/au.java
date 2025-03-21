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

/* loaded from: classes2.dex */
public class au {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicReference<a<av>> f12461a = new AtomicReference<>(a());

    /* renamed from: a, reason: collision with other field name */
    public static final Pattern f197a = Pattern.compile("([^\\s;]+)(.*)");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f12462b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f12463c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    private static class a<T> extends FutureTask<T> {

        /* renamed from: a, reason: collision with root package name */
        private long f12464a;

        public a(Callable<T> callable) {
            super(callable);
        }

        public boolean a() {
            return j.m627a(C0334r.m636a()) || (isDone() && Math.abs(SystemClock.elapsedRealtime() - this.f12464a) > 1800000);
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
        public void run() {
            this.f12464a = SystemClock.elapsedRealtime();
            super.run();
        }
    }

    public static final class b extends FilterInputStream {

        /* renamed from: a, reason: collision with root package name */
        private boolean f12465a;

        public b(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) {
            int read;
            if (!this.f12465a && (read = super.read(bArr, i2, i3)) != -1) {
                return read;
            }
            this.f12465a = true;
            return -1;
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f12466a;

        /* renamed from: a, reason: collision with other field name */
        public Map<String, String> f198a;

        public String toString() {
            return String.format("resCode = %1$d, headers = %2$s", Integer.valueOf(this.f12466a), this.f198a.toString());
        }
    }

    public static InputStream a(Context context, URL url, boolean z, String str, String str2) {
        return a(context, url, z, str, str2, null, null);
    }

    public static void b() {
        f12461a.set(a());
    }

    public static boolean c(Context context) {
        av m144a = m144a();
        return m144a != null && m144a.m155a();
    }

    public static boolean d(Context context) {
        av m144a = m144a();
        return m144a != null && 1 == m144a.a();
    }

    public static boolean e(Context context) {
        av m145a = m145a(context);
        return m145a != null && m145a.a() == 0 && 20 == m145a.b();
    }

    public static boolean f(Context context) {
        av m145a = m145a(context);
        return m145a != null && m145a.a() == 0 && 13 == m145a.b();
    }

    public static boolean g(Context context) {
        av m145a = m145a(context);
        if (m145a == null || m145a.a() != 0) {
            return false;
        }
        String m156b = m145a.m156b();
        if (!"TD-SCDMA".equalsIgnoreCase(m156b) && !"CDMA2000".equalsIgnoreCase(m156b) && !"WCDMA".equalsIgnoreCase(m156b)) {
            switch (m145a.b()) {
            }
            return false;
        }
        return true;
    }

    public static boolean h(Context context) {
        av m145a = m145a(context);
        if (m145a == null || m145a.a() != 0) {
            return false;
        }
        int b2 = m145a.b();
        return b2 == 1 || b2 == 2 || b2 == 4 || b2 == 7 || b2 == 11;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m150a() {
        b();
    }

    public static boolean b(Context context) {
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
                z = m151a(context);
            }
            return z && c(context);
        }
        z = false;
        if (z) {
            return false;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static Object m146a(Context context) {
        ConnectivityManager connectivityManager;
        NetworkRequest build;
        ConnectivityManager.NetworkCallback networkCallback;
        if (context == null) {
            context = C0334r.m636a();
        }
        ConnectivityManager.NetworkCallback networkCallback2 = null;
        if (context == null || j.m627a(context) || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            build = new NetworkRequest.Builder().build();
            networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.xiaomi.push.au.1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network2) {
                    super.onAvailable(network2);
                    au.b();
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network2) {
                    super.onLost(network2);
                    au.b();
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
            com.xiaomi.channel.commonutils.logger.b.m50a("exception occurred in adding network callback :" + th);
            return networkCallback2;
        }
    }

    public static void a(Context context, Object obj) {
        if (Build.VERSION.SDK_INT < 21) {
            com.xiaomi.channel.commonutils.logger.b.b("less than LOLLIPOP(21) not support channel ");
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
            com.xiaomi.channel.commonutils.logger.b.m50a("exception occurred in removing network callback :" + th);
        }
    }

    private static a<av> a() {
        return new a<>(new Callable<av>() { // from class: com.xiaomi.push.au.2
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public av call() {
                NetworkInfo activeNetworkInfo;
                Context m636a = C0334r.m636a();
                if (m636a == null) {
                    return null;
                }
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) m636a.getSystemService("connectivity");
                    if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                        return null;
                    }
                    return new av(activeNetworkInfo);
                } catch (Exception unused) {
                    return null;
                }
            }
        });
    }

    /* renamed from: a, reason: collision with other method in class */
    public static av m144a() {
        a<av> aVar = f12461a.get();
        if (aVar != null) {
            try {
                if (aVar.a()) {
                    AtomicReference<a<av>> atomicReference = f12461a;
                    a<av> a2 = a();
                    atomicReference.set(a2);
                    aVar = a2;
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

    public static InputStream a(Context context, URL url, boolean z, String str, String str2, Map<String, String> map, c cVar) {
        if (context == null) {
            throw new IllegalArgumentException(com.umeng.analytics.pro.d.R);
        }
        if (url != null) {
            URL url2 = !z ? new URL(a(url.toString())) : url;
            try {
                HttpURLConnection.setFollowRedirects(true);
                HttpURLConnection m148a = m148a(context, url2);
                m148a.setConnectTimeout(10000);
                m148a.setReadTimeout(15000);
                if (!TextUtils.isEmpty(str)) {
                    m148a.setRequestProperty(HttpHeaders.USER_AGENT, str);
                }
                if (str2 != null) {
                    m148a.setRequestProperty("Cookie", str2);
                }
                if (map != null) {
                    for (String str3 : map.keySet()) {
                        m148a.setRequestProperty(str3, map.get(str3));
                    }
                }
                if (cVar != null && (url.getProtocol().equals(HttpConstant.HTTP) || url.getProtocol().equals(HttpConstant.HTTPS))) {
                    cVar.f12466a = m148a.getResponseCode();
                    if (cVar.f198a == null) {
                        cVar.f198a = new HashMap();
                    }
                    int i2 = 0;
                    while (true) {
                        String headerFieldKey = m148a.getHeaderFieldKey(i2);
                        String headerField = m148a.getHeaderField(i2);
                        if (headerFieldKey == null && headerField == null) {
                            break;
                        }
                        if (!TextUtils.isEmpty(headerFieldKey) && !TextUtils.isEmpty(headerField)) {
                            cVar.f198a.put(headerFieldKey, headerField);
                        }
                        i2++;
                    }
                }
                return new b(m148a.getInputStream());
            } catch (IOException e2) {
                throw new IOException("IOException:" + e2.getClass().getSimpleName());
            } catch (Throwable th) {
                throw new IOException(th.getMessage());
            }
        }
        throw new IllegalArgumentException("url");
    }

    public static String a(Context context, URL url) {
        return a(context, url, false, null, "UTF-8", null);
    }

    public static String a(Context context, URL url, boolean z, String str, String str2, String str3) {
        InputStream inputStream;
        try {
            inputStream = a(context, url, z, str, str3);
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
                    w.a((Closeable) inputStream);
                    return sb.toString();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            w.a((Closeable) inputStream);
            throw th;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new String();
        return String.format("%s&key=%s", str, ba.a(String.format("%sbe988a6134bc8254465424e5a70ef037", str)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String a(String str, Map<String, String> map, File file, String str2) {
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
                    dataOutputStream.writeBytes(d.d.D);
                    dataOutputStream.writeBytes("*****");
                    dataOutputStream.writeBytes(d.d.D);
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
                                w.a((Closeable) fileInputStream);
                                w.a(bufferedReader);
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
            w.a((Closeable) null);
            w.a((Closeable) file);
            throw th4;
        }
    }

    public static int a(Context context) {
        av m144a = m144a();
        if (m144a == null) {
            return -1;
        }
        return m144a.a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static HttpURLConnection m148a(Context context, URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m151a(Context context) {
        return a(context) >= 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static av m145a(Context context) {
        return m144a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m147a(Context context) {
        if (d(context)) {
            return UtilityImpl.NET_TYPE_WIFI;
        }
        av m144a = m144a();
        if (m144a == null) {
            return "";
        }
        return (m144a.m154a() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + m144a.m156b()).toLowerCase();
    }

    public static as a(Context context, String str, Map<String, String> map) {
        return a(context, str, "POST", (Map<String, String>) null, a(map));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static as a(Context context, String str, String str2, Map<String, String> map, String str3) {
        boolean z;
        BufferedReader bufferedReader;
        OutputStream outputStream;
        as asVar = new as();
        try {
            try {
                try {
                    HttpURLConnection m148a = m148a(context, m149a(str));
                    m148a.setConnectTimeout(10000);
                    m148a.setReadTimeout(15000);
                    String str4 = str2;
                    if (str2 == 0) {
                        str4 = "GET";
                    }
                    m148a.setRequestMethod(str4);
                    int i2 = 0;
                    if (map != null) {
                        z = HttpConstant.GZIP.equalsIgnoreCase(map.get("Content-Encoding"));
                        for (String str5 : map.keySet()) {
                            m148a.setRequestProperty(str5, map.get(str5));
                        }
                    } else {
                        z = false;
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        m148a.setDoOutput(true);
                        byte[] bytes = str3.getBytes();
                        if (z) {
                            outputStream = new GZIPOutputStream(m148a.getOutputStream());
                        } else {
                            outputStream = m148a.getOutputStream();
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
                    asVar.f12460a = m148a.getResponseCode();
                    com.xiaomi.channel.commonutils.logger.b.m50a("Http POST Response Code: " + asVar.f12460a);
                    while (true) {
                        String headerFieldKey = m148a.getHeaderFieldKey(i2);
                        String headerField = m148a.getHeaderField(i2);
                        if (headerFieldKey == null && headerField == null) {
                            try {
                                break;
                            } catch (IOException unused) {
                                bufferedReader = new BufferedReader(new InputStreamReader(new b(m148a.getErrorStream())));
                            }
                        } else {
                            asVar.f196a.put(headerFieldKey, headerField);
                            i2 = i2 + 1 + 1;
                        }
                    }
                    bufferedReader = new BufferedReader(new InputStreamReader(new b(m148a.getInputStream())));
                    try {
                        StringBuffer stringBuffer = new StringBuffer();
                        String property = System.getProperty("line.separator");
                        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                            stringBuffer.append(readLine);
                            stringBuffer.append(property);
                        }
                        asVar.f195a = stringBuffer.toString();
                        bufferedReader.close();
                        w.a((Closeable) null);
                        w.a((Closeable) null);
                        return asVar;
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
            w.a((Closeable) null);
            w.a((Closeable) str2);
            throw th4;
        }
    }

    public static String a(Map<String, String> map) {
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
                    com.xiaomi.channel.commonutils.logger.b.m50a("Failed to convert from params map to string: " + e2);
                    com.xiaomi.channel.commonutils.logger.b.m50a("map: " + map.toString());
                    return null;
                }
            }
        }
        if (stringBuffer.length() > 0) {
            stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    private static URL m149a(String str) {
        return new URL(str);
    }
}
