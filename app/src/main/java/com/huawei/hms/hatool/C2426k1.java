package com.huawei.hms.hatool;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.zip.Deflater;

/* renamed from: com.huawei.hms.hatool.k1 */
/* loaded from: classes.dex */
public final class C2426k1 {
    /* renamed from: a */
    public static String m7200a(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    C2415h c2415h = new C2415h(1024);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        c2415h.m7150a(bArr, read);
                    }
                    if (c2415h.m7152b() == 0) {
                        m7202a((Closeable) fileInputStream);
                        return "";
                    }
                    String str = new String(c2415h.m7151a(), "UTF-8");
                    m7202a((Closeable) fileInputStream);
                    return str;
                } catch (FileNotFoundException unused) {
                    fileInputStream2 = fileInputStream;
                    C2452v.m7390f("hmsSdk", "getInfoFromFile(): No files need to be read");
                    m7202a((Closeable) fileInputStream2);
                    return "";
                } catch (IOException unused2) {
                    fileInputStream2 = fileInputStream;
                    C2452v.m7390f("hmsSdk", "getInfoFromFile(): stream.read or new string exception");
                    m7202a((Closeable) fileInputStream2);
                    return "";
                } catch (Throwable th) {
                    th = th;
                    m7202a((Closeable) fileInputStream);
                    throw th;
                }
            } catch (FileNotFoundException unused3) {
            } catch (IOException unused4) {
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    /* renamed from: a */
    public static String m7201a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return byteArrayOutputStream.toString("UTF-8");
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } finally {
            m7202a((Closeable) byteArrayOutputStream);
        }
    }

    /* renamed from: a */
    public static void m7202a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                C2452v.m7390f("hmsSdk", "closeQuietly(): Exception when closing the closeable!");
            }
        }
    }

    /* renamed from: a */
    public static void m7203a(File file, String str) {
        String str2;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (FileNotFoundException unused) {
            } catch (IOException unused2) {
            } catch (Throwable th) {
                th = th;
                m7202a((Closeable) fileOutputStream2);
                throw th;
            }
            try {
                fileOutputStream.write(str.getBytes("UTF-8"));
                fileOutputStream.flush();
            } catch (FileNotFoundException unused3) {
                fileOutputStream2 = fileOutputStream;
                str2 = "saveInfoToFile(): No files need to be read";
                fileOutputStream = fileOutputStream2;
                C2452v.m7390f("hmsSdk", str2);
                m7202a((Closeable) fileOutputStream);
            } catch (IOException unused4) {
                fileOutputStream2 = fileOutputStream;
                str2 = "saveInfoToFile(): io exc from write info to file!";
                fileOutputStream = fileOutputStream2;
                C2452v.m7390f("hmsSdk", str2);
                m7202a((Closeable) fileOutputStream);
            }
            m7202a((Closeable) fileOutputStream);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            m7202a((Closeable) fileOutputStream2);
            throw th;
        }
    }

    /* renamed from: a */
    private static void m7204a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
                C2452v.m7390f("hmsSdk", "closeStream(): Exception: close OutputStream error!");
            }
        }
    }

    /* renamed from: a */
    public static void m7205a(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.getInputStream().close();
        } catch (Exception unused) {
            C2452v.m7390f("hmsSdk", "closeQuietly(): Exception when connHttp.getInputStream()!,There may be no network, or no INTERNET permission");
        }
        httpURLConnection.disconnect();
        C2452v.m7379a("hmsSdk", " connHttp disconnect");
    }

    /* renamed from: a */
    public static byte[] m7206a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[1024];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        deflater.end();
        m7204a((OutputStream) byteArrayOutputStream);
        return byteArray;
    }
}
