package com.umeng.analytics.pro;

import com.umeng.commonsdk.debug.UMRTLog;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: ZipUtils.java */
/* renamed from: com.umeng.analytics.pro.as */
/* loaded from: classes2.dex */
public class C3335as {
    /* renamed from: a */
    public static byte[] m10863a(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                bArr[i2] = (byte) ((bArr[i2] ^ bArr2[i2 % bArr2.length]) ^ (i2 & 255));
            }
        }
        return bArr;
    }

    /* renamed from: b */
    public static void m10864b(byte[] bArr, OutputStream outputStream) {
        GZIPInputStream gZIPInputStream = null;
        try {
            GZIPInputStream gZIPInputStream2 = new GZIPInputStream(new ByteArrayInputStream(bArr));
            try {
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int read = gZIPInputStream2.read(bArr2);
                    if (read == -1) {
                        C3332ap.m10858a(gZIPInputStream2);
                        return;
                    }
                    outputStream.write(bArr2, 0, read);
                }
            } catch (Throwable th) {
                th = th;
                gZIPInputStream = gZIPInputStream2;
                try {
                    UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "unGzip error: " + th.getMessage());
                } finally {
                    C3332ap.m10858a(gZIPInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public static void m10862a(byte[] bArr, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(outputStream);
            try {
                gZIPOutputStream2.write(bArr);
                C3332ap.m10858a(gZIPOutputStream2);
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream = gZIPOutputStream2;
                try {
                    UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "gzip error: " + th.getMessage());
                } finally {
                    C3332ap.m10858a(gZIPOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
