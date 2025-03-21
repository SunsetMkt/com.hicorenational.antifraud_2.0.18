package com.tencent.open.p211a;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.open.log.SLog;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import p245d.C4443d;
import p286h.p323z2.C5736h0;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.a.b */
/* loaded from: classes2.dex */
class C3251b implements InterfaceC3250a {

    /* renamed from: a */
    private int f11138a = 15000;

    /* renamed from: b */
    private int f11139b = BuglyStrategy.C3070a.MAX_USERDATA_VALUE_LENGTH;

    /* renamed from: c */
    private final String f11140c;

    public C3251b(String str) {
        this.f11140c = str;
    }

    /* renamed from: b */
    private static void m10408b(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        try {
            httpURLConnection.disconnect();
        } catch (Exception unused) {
        }
    }

    @Override // com.tencent.open.p211a.InterfaceC3250a
    /* renamed from: a */
    public void mo10403a(long j2, long j3) {
        if (j2 <= 0 || j3 <= 0) {
            return;
        }
        this.f11138a = (int) j2;
        this.f11139b = (int) j3;
    }

    @Override // com.tencent.open.p211a.InterfaceC3250a
    /* renamed from: a */
    public InterfaceC3256g mo10400a(String str, String str2) throws IOException {
        SLog.m10502i("DefaultHttpServiceImpl", "get. ");
        if (!TextUtils.isEmpty(str2)) {
            int indexOf = str2.indexOf("?");
            if (indexOf == -1) {
                str = str + "?";
            } else if (indexOf != str.length() - 1) {
                str = str + "&";
            }
            str = str + str2;
        }
        return m10404a(str, str2.length());
    }

    @Override // com.tencent.open.p211a.InterfaceC3250a
    /* renamed from: a */
    public InterfaceC3256g mo10401a(String str, Map<String, String> map) throws IOException {
        SLog.m10502i("DefaultHttpServiceImpl", "post. ");
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (z) {
                z = false;
            } else {
                sb.append(C5736h0.f20714c);
            }
            sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            sb.append('=');
            sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }
        String sb2 = sb.toString();
        return m10405a(str, sb2.length(), sb2);
    }

    @Override // com.tencent.open.p211a.InterfaceC3250a
    /* renamed from: a */
    public InterfaceC3256g mo10402a(String str, Map<String, String> map, Map<String, byte[]> map2) throws IOException {
        if (map2 != null && map2.size() > 0) {
            Iterator<Map.Entry<String, byte[]>> it = map2.entrySet().iterator();
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry<String, byte[]> next = it.next();
            return m10409a(str, map, next.getKey(), next.getValue());
        }
        return mo10401a(str, map);
    }

    /* renamed from: a */
    private void m10407a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        httpURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, this.f11140c);
        httpURLConnection.setConnectTimeout(this.f11138a);
        httpURLConnection.setReadTimeout(this.f11139b);
        httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
        httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
        httpURLConnection.setRequestProperty("Charset", "UTF-8");
    }

    /* renamed from: a */
    private InterfaceC3256g m10404a(String str, int i2) throws IOException {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setRequestMethod("GET");
                m10407a(httpURLConnection);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(false);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() == 200) {
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read != -1) {
                                byteArrayOutputStream.write(bArr, 0, read);
                            } else {
                                C3252c c3252c = new C3252c(httpURLConnection, byteArrayOutputStream.toString(), httpURLConnection.getContentLength(), i2, httpURLConnection.getResponseCode(), "");
                                m10406a(byteArrayOutputStream);
                                m10406a(inputStream);
                                m10408b(httpURLConnection);
                                return c3252c;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        m10406a(byteArrayOutputStream2);
                        m10406a(inputStream);
                        m10408b(httpURLConnection);
                        throw th;
                    }
                } else {
                    String responseMessage = httpURLConnection.getResponseMessage();
                    if (responseMessage == null) {
                        responseMessage = "请求失败 code:" + httpURLConnection.getResponseCode();
                    }
                    C3252c c3252c2 = new C3252c(httpURLConnection, "", httpURLConnection.getContentLength(), i2, httpURLConnection.getResponseCode(), responseMessage);
                    m10406a((Closeable) null);
                    m10406a((Closeable) null);
                    m10408b(httpURLConnection);
                    return c3252c2;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            inputStream = null;
        }
    }

    /* renamed from: a */
    private InterfaceC3256g m10405a(String str, int i2, String str2) throws IOException {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setRequestMethod("POST");
                m10407a(httpURLConnection);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8");
                outputStreamWriter.write(str2);
                outputStreamWriter.flush();
                httpURLConnection.connect();
                int contentLength = httpURLConnection.getContentLength();
                if (httpURLConnection.getResponseCode() == 200) {
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read != -1) {
                                byteArrayOutputStream.write(bArr, 0, read);
                            } else {
                                C3252c c3252c = new C3252c(httpURLConnection, byteArrayOutputStream.toString(), contentLength, i2, httpURLConnection.getResponseCode(), "");
                                m10406a(byteArrayOutputStream);
                                m10406a(inputStream);
                                m10408b(httpURLConnection);
                                return c3252c;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        m10406a(byteArrayOutputStream2);
                        m10406a(inputStream);
                        m10408b(httpURLConnection);
                        throw th;
                    }
                } else {
                    String responseMessage = httpURLConnection.getResponseMessage();
                    if (responseMessage == null) {
                        responseMessage = "Unknown fail: " + httpURLConnection.getResponseCode();
                    }
                    C3252c c3252c2 = new C3252c(httpURLConnection, "", 0, i2, httpURLConnection.getResponseCode(), responseMessage);
                    m10406a((Closeable) null);
                    m10406a((Closeable) null);
                    m10408b(httpURLConnection);
                    return c3252c2;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            inputStream = null;
        }
    }

    /* renamed from: a */
    public InterfaceC3256g m10409a(String str, Map<String, String> map, String str2, byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream;
        InputStream inputStream;
        int i2;
        String str3;
        InputStream inputStream2;
        ByteArrayOutputStream byteArrayOutputStream2;
        Map<String, String> map2 = map;
        SLog.m10502i("DefaultHttpServiceImpl", "文件上传");
        String uuid = UUID.randomUUID().toString();
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + uuid);
            } catch (Throwable th) {
                th = th;
            }
            try {
                m10407a(httpURLConnection);
                httpURLConnection.connect();
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                if (map2 != null) {
                    try {
                        if (map.size() > 0) {
                            Iterator<String> it = map.keySet().iterator();
                            while (it.hasNext()) {
                                StringBuffer stringBuffer = new StringBuffer();
                                String encode = URLEncoder.encode(it.next(), "UTF-8");
                                String encode2 = URLEncoder.encode(map2.get(encode), "UTF-8");
                                stringBuffer.append(C4443d.f16920D);
                                stringBuffer.append(uuid);
                                stringBuffer.append("\r\n");
                                stringBuffer.append("Content-Disposition: form-data; name=\"");
                                stringBuffer.append(encode);
                                stringBuffer.append("\"");
                                stringBuffer.append("\r\n");
                                stringBuffer.append("\r\n");
                                stringBuffer.append(encode2);
                                stringBuffer.append("\r\n");
                                String stringBuffer2 = stringBuffer.toString();
                                SLog.m10502i("DefaultHttpServiceImpl", encode + ContainerUtils.KEY_VALUE_DELIMITER + stringBuffer2 + "##");
                                dataOutputStream.write(stringBuffer2.getBytes());
                                map2 = map;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream = null;
                        inputStream = null;
                        m10406a(dataOutputStream);
                        m10406a(inputStream);
                        m10406a(byteArrayOutputStream);
                        m10408b(httpURLConnection);
                        throw th;
                    }
                }
                if (bArr == null || bArr.length <= 0) {
                    i2 = 0;
                } else {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append(C4443d.f16920D);
                    stringBuffer3.append(uuid);
                    stringBuffer3.append("\r\n");
                    stringBuffer3.append("Content-Disposition: form-data; name=\"" + str2 + "\"; filename=\"" + str2 + "\"\r\n");
                    StringBuilder sb = new StringBuilder();
                    sb.append("Content-Type: application/octet-stream; charset=UTF-8");
                    sb.append("\r\n");
                    stringBuffer3.append(sb.toString());
                    stringBuffer3.append("\r\n");
                    dataOutputStream.write(stringBuffer3.toString().getBytes());
                    dataOutputStream.write(bArr, 0, bArr.length);
                    dataOutputStream.write("\r\n".getBytes());
                    byte[] bytes = (C4443d.f16920D + uuid + C4443d.f16920D + "\r\n").getBytes();
                    dataOutputStream.write(bytes);
                    int length = bytes.length + 0;
                    dataOutputStream.flush();
                    i2 = length;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
                dataOutputStream = null;
                inputStream = null;
                m10406a(dataOutputStream);
                m10406a(inputStream);
                m10406a(byteArrayOutputStream);
                m10408b(httpURLConnection);
                throw th;
            }
            try {
                int responseCode = httpURLConnection.getResponseCode();
                SLog.m10502i("DefaultHttpServiceImpl", responseCode + "");
                if (responseCode == 200) {
                    inputStream2 = httpURLConnection.getInputStream();
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byte[] bArr2 = new byte[1024];
                            while (true) {
                                int read = inputStream2.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, read);
                            }
                            str3 = byteArrayOutputStream.toString();
                            byteArrayOutputStream2 = byteArrayOutputStream;
                        } catch (Throwable th4) {
                            th = th4;
                            inputStream = inputStream2;
                            m10406a(dataOutputStream);
                            m10406a(inputStream);
                            m10406a(byteArrayOutputStream);
                            m10408b(httpURLConnection);
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream = inputStream2;
                        byteArrayOutputStream = null;
                        m10406a(dataOutputStream);
                        m10406a(inputStream);
                        m10406a(byteArrayOutputStream);
                        m10408b(httpURLConnection);
                        throw th;
                    }
                } else {
                    str3 = httpURLConnection.getResponseCode() + "";
                    inputStream2 = null;
                    byteArrayOutputStream2 = null;
                }
                try {
                    try {
                        C3252c c3252c = new C3252c(httpURLConnection, str3, httpURLConnection.getContentLength(), i2, httpURLConnection.getResponseCode(), "");
                        m10406a(dataOutputStream);
                        m10406a(inputStream2);
                        m10406a(byteArrayOutputStream2);
                        m10408b(httpURLConnection);
                        return c3252c;
                    } catch (Throwable th6) {
                        th = th6;
                        dataOutputStream = dataOutputStream;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        inputStream = inputStream2;
                        m10406a(dataOutputStream);
                        m10406a(inputStream);
                        m10406a(byteArrayOutputStream);
                        m10408b(httpURLConnection);
                        throw th;
                    }
                } catch (Throwable th7) {
                    th = th7;
                }
            } catch (Throwable th8) {
                th = th8;
                byteArrayOutputStream = null;
                inputStream = null;
                m10406a(dataOutputStream);
                m10406a(inputStream);
                m10406a(byteArrayOutputStream);
                m10408b(httpURLConnection);
                throw th;
            }
        } catch (Throwable th9) {
            th = th9;
            byteArrayOutputStream = null;
            httpURLConnection = null;
        }
    }

    /* renamed from: a */
    private static void m10406a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
