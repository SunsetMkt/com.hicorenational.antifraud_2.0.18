package cn.cloudwalk.libproject.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public class HttpUrlConnectionUtil {
    public static String post(String str, String str2) throws Throwable {
        HttpURLConnection httpURLConnection;
        OutputStream outputStream;
        Exception e2;
        BufferedReader bufferedReader;
        String str3 = "";
        BufferedReader bufferedReader2 = null;
        try {
            try {
                byte[] bytes = str2.getBytes();
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(15000);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setRequestProperty("Connection", "keep-alive");
                    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setInstanceFollowRedirects(true);
                    outputStream = httpURLConnection.getOutputStream();
                    try {
                        try {
                            outputStream.write(bytes);
                            outputStream.flush();
                            if (httpURLConnection.getResponseCode() == 200) {
                                bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                                while (true) {
                                    try {
                                        String line = bufferedReader.readLine();
                                        if (line == null) {
                                            break;
                                        }
                                        str3 = str3 + line;
                                    } catch (Exception e3) {
                                        bufferedReader2 = bufferedReader;
                                        e2 = e3;
                                        e2.printStackTrace();
                                        if (bufferedReader2 != null) {
                                            bufferedReader2.close();
                                        }
                                        if (outputStream != null) {
                                            outputStream.close();
                                        }
                                        if (httpURLConnection != null) {
                                        }
                                        return str3;
                                    } catch (Throwable th) {
                                        th = th;
                                        bufferedReader2 = bufferedReader;
                                        if (bufferedReader2 != null) {
                                            try {
                                                bufferedReader2.close();
                                            } catch (Exception unused) {
                                                throw th;
                                            }
                                        }
                                        if (outputStream != null) {
                                            outputStream.close();
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
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
                            if (outputStream != null) {
                                outputStream.close();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Exception e4) {
                        e2 = e4;
                    }
                } catch (Exception e5) {
                    e2 = e5;
                    outputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = null;
                }
            } catch (Exception e6) {
                e2 = e6;
                httpURLConnection = null;
                outputStream = null;
            } catch (Throwable th4) {
                th = th4;
                httpURLConnection = null;
                outputStream = null;
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Exception unused2) {
        }
        return str3;
    }
}
