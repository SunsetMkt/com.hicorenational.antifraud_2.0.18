package com.umeng.socialize.p215a;

import com.umeng.commonsdk.debug.UMRTLog;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: UMZipUtils.java */
/* renamed from: com.umeng.socialize.a.l */
/* loaded from: classes2.dex */
public class C3626l {
    /* renamed from: a */
    public static void m12556a(byte[] bArr, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(outputStream);
            try {
                gZIPOutputStream2.write(bArr);
                C3617c.m12503a(gZIPOutputStream2);
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream = gZIPOutputStream2;
                try {
                    UMRTLog.m11555e("zip", th.getMessage());
                } finally {
                    C3617c.m12503a(gZIPOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: b */
    public static void m12557b(byte[] bArr, OutputStream outputStream) {
        GZIPInputStream gZIPInputStream = null;
        try {
            GZIPInputStream gZIPInputStream2 = new GZIPInputStream(new ByteArrayInputStream(bArr));
            try {
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int read = gZIPInputStream2.read(bArr2);
                    if (read == -1) {
                        C3617c.m12503a(gZIPInputStream2);
                        return;
                    }
                    outputStream.write(bArr2, 0, read);
                }
            } catch (Throwable th) {
                th = th;
                gZIPInputStream = gZIPInputStream2;
                try {
                    UMRTLog.m11555e("unzip", th.getMessage());
                } finally {
                    C3617c.m12503a(gZIPInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
