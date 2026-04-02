package cn.cloudwalk.libproject.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
public class HttpsUrlConnectionUtil {

    private static class HttpsTrustManager implements X509TrustManager {
        private HttpsTrustManager() {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [cn.cloudwalk.libproject.net.HttpsUrlConnectionUtil$1] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v1, types: [javax.net.ssl.HttpsURLConnection] */
    /* JADX WARN: Type inference failed for: r8v12, types: [javax.net.ssl.HttpsURLConnection] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [javax.net.ssl.HttpsURLConnection] */
    public static String post(String str, String str2) throws Throwable {
        BufferedReader bufferedReader;
        String str3 = "";
        ?? r2 = 0;
        bufferedReader = null;
        bufferedReader = null;
        bufferedReader = null;
        BufferedReader bufferedReader2 = null;
        BufferedReader bufferedReader3 = null;
        BufferedReader bufferedReader4 = null;
        r2 = 0;
        try {
            try {
                try {
                    SSLContext sSLContext = SSLContext.getInstance("TLS");
                    sSLContext.init(null, new TrustManager[]{new HttpsTrustManager()}, new SecureRandom());
                    SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
                    URL url = new URL(str);
                    HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() { // from class: cn.cloudwalk.libproject.net.HttpsUrlConnectionUtil.1
                        @Override // javax.net.ssl.HostnameVerifier
                        public boolean verify(String str4, SSLSession sSLSession) {
                            return true;
                        }
                    });
                    str = (HttpsURLConnection) url.openConnection();
                    try {
                        str.setSSLSocketFactory(socketFactory);
                        str.setDoOutput(true);
                        str.setDoInput(true);
                        str.setRequestMethod("POST");
                        str.setRequestProperty("Charset", "UTF-8");
                        str.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        str.setConnectTimeout(15000);
                        str.setReadTimeout(15000);
                        OutputStream outputStream = str.getOutputStream();
                        outputStream.write(str2.getBytes());
                        outputStream.close();
                        if (str.getResponseCode() == 200) {
                            bufferedReader = new BufferedReader(new InputStreamReader(str.getInputStream(), "UTF-8"));
                            while (true) {
                                try {
                                    String line = bufferedReader.readLine();
                                    if (line == null) {
                                        break;
                                    }
                                    str3 = str3 + line;
                                } catch (MalformedURLException e2) {
                                    e = e2;
                                    bufferedReader2 = bufferedReader;
                                    e.printStackTrace();
                                    if (bufferedReader2 != null) {
                                        bufferedReader2.close();
                                    }
                                    if (str != 0) {
                                    }
                                    return str3;
                                } catch (IOException e3) {
                                    e = e3;
                                    bufferedReader3 = bufferedReader;
                                    e.printStackTrace();
                                    if (bufferedReader3 != null) {
                                        bufferedReader3.close();
                                    }
                                    if (str != 0) {
                                    }
                                    return str3;
                                } catch (Exception e4) {
                                    e = e4;
                                    bufferedReader4 = bufferedReader;
                                    e.printStackTrace();
                                    if (bufferedReader4 != null) {
                                        bufferedReader4.close();
                                    }
                                    if (str != 0) {
                                    }
                                    return str3;
                                } catch (Throwable th) {
                                    th = th;
                                    r2 = bufferedReader;
                                    if (r2 != 0) {
                                        try {
                                            r2.close();
                                        } catch (Exception unused) {
                                            throw th;
                                        }
                                    }
                                    if (str != 0) {
                                        str.disconnect();
                                    }
                                    throw th;
                                }
                            }
                        } else {
                            bufferedReader = null;
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                    } catch (MalformedURLException e5) {
                        e = e5;
                    } catch (IOException e6) {
                        e = e6;
                    } catch (Exception e7) {
                        e = e7;
                    }
                } catch (MalformedURLException e8) {
                    e = e8;
                    str = 0;
                } catch (IOException e9) {
                    e = e9;
                    str = 0;
                } catch (Exception e10) {
                    e = e10;
                    str = 0;
                } catch (Throwable th2) {
                    th = th2;
                    str = 0;
                }
                if (str != 0) {
                    str.disconnect();
                }
            } catch (Exception unused2) {
            }
            return str3;
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
