package com.umeng.socialize.tracker.utils;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: HttpClient.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static final String a = "HttpClient";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f8397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, String> f8398d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HttpRequestListener f8399e;

    /* JADX INFO: compiled from: HttpClient.java */
    public enum a {
        POST,
        GET
    }

    public b(String str, a aVar, Map<String, String> map, HttpRequestListener httpRequestListener) {
        this.f8396b = str;
        this.f8397c = aVar;
        this.f8398d = map;
        this.f8399e = httpRequestListener;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x01d9: IF  (r1 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:87:0x01de, block:B:85:0x01d9 */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01e2 A[PHI: r1
  0x01e2: PHI (r1v13 javax.net.ssl.HttpsURLConnection) = 
  (r1v7 javax.net.ssl.HttpsURLConnection)
  (r1v8 javax.net.ssl.HttpsURLConnection)
  (r1v9 javax.net.ssl.HttpsURLConnection)
  (r1v10 javax.net.ssl.HttpsURLConnection)
  (r1v11 javax.net.ssl.HttpsURLConnection)
  (r1v12 javax.net.ssl.HttpsURLConnection)
  (r1v16 javax.net.ssl.HttpsURLConnection)
 binds: [B:55:0x0125, B:62:0x0152, B:69:0x017f, B:76:0x01ab, B:82:0x01d5, B:89:0x01e0, B:36:0x0105] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(int i2, String str) {
        HttpsURLConnection httpsURLConnection;
        HttpsURLConnection httpsURLConnection2;
        try {
            try {
                httpsURLConnection = (HttpsURLConnection) new URL(this.f8396b).openConnection();
            } catch (MalformedURLException unused) {
                httpsURLConnection = null;
            } catch (SocketTimeoutException e2) {
                e = e2;
                httpsURLConnection = null;
            } catch (UnknownHostException e3) {
                e = e3;
                httpsURLConnection = null;
            } catch (SSLHandshakeException e4) {
                e = e4;
                httpsURLConnection = null;
            } catch (IOException e5) {
                e = e5;
                httpsURLConnection = null;
            } catch (Throwable th) {
                th = th;
                httpsURLConnection = null;
            }
            try {
                httpsURLConnection.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, new SecureRandom());
                httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                if (this.f8398d != null && !this.f8398d.isEmpty()) {
                    for (String str2 : this.f8398d.keySet()) {
                        if (!TextUtils.isEmpty(str2)) {
                            httpsURLConnection.setRequestProperty(str2, this.f8398d.get(str2));
                        }
                    }
                }
                httpsURLConnection.setConnectTimeout(i2);
                httpsURLConnection.setReadTimeout(i2);
                if (this.f8397c == a.POST) {
                    httpsURLConnection.setRequestMethod("POST");
                } else {
                    httpsURLConnection.setRequestMethod("GET");
                }
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setDefaultUseCaches(false);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpsURLConnection.getOutputStream());
                outputStreamWriter.write(str);
                outputStreamWriter.flush();
                outputStreamWriter.close();
                if (this.f8399e != null) {
                    this.f8399e.a();
                }
                httpsURLConnection.connect();
            } catch (MalformedURLException unused2) {
                if (httpsURLConnection != null) {
                }
            } catch (SocketTimeoutException e6) {
                e = e6;
                if (this.f8399e != null) {
                    this.f8399e.a(new Throwable(com.umeng.socialize.tracker.utils.a.Timeout.a() + e.getMessage()));
                }
                if (httpsURLConnection != null) {
                }
            } catch (UnknownHostException e7) {
                e = e7;
                if (this.f8399e != null) {
                    this.f8399e.a(new Throwable(com.umeng.socialize.tracker.utils.a.UnKnownHostException.a() + e.getMessage()));
                }
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
            } catch (SSLHandshakeException e8) {
                e = e8;
                if (this.f8399e != null) {
                    this.f8399e.a(new Throwable(com.umeng.socialize.tracker.utils.a.SSLException.a() + e.getMessage()));
                }
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
            } catch (IOException e9) {
                e = e9;
                if (this.f8399e != null) {
                    this.f8399e.a(new Throwable(com.umeng.socialize.tracker.utils.a.IOException.a() + e.getMessage()));
                }
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
            } catch (Throwable th2) {
                th = th2;
                if (this.f8399e != null) {
                    this.f8399e.a(th);
                }
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
            }
            if (httpsURLConnection.getResponseCode() != 200) {
                if (this.f8399e != null) {
                    this.f8399e.a(new Throwable(com.umeng.socialize.tracker.utils.a.HttpError.a() + "Http Response Code:" + httpsURLConnection.getResponseCode()));
                }
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
                return null;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream(), "utf-8"));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                stringBuffer.append(line);
            }
            String string = stringBuffer.toString();
            bufferedReader.close();
            if (this.f8399e != null) {
                this.f8399e.a(string);
            }
            if (httpsURLConnection != null) {
                httpsURLConnection.disconnect();
            }
            return string;
        } catch (Throwable th3) {
            if (httpsURLConnection2 != null) {
                httpsURLConnection2.disconnect();
            }
            throw th3;
        }
    }
}
