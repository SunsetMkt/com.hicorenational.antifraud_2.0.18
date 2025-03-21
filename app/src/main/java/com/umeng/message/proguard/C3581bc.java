package com.umeng.message.proguard;

import com.umeng.message.common.UPLog;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* renamed from: com.umeng.message.proguard.bc */
/* loaded from: classes2.dex */
public final class C3581bc {
    /* renamed from: a */
    public static void m12338a(byte[] bArr, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(outputStream);
            try {
                gZIPOutputStream2.write(bArr);
                C3586f.m12386a(gZIPOutputStream2);
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream = gZIPOutputStream2;
                try {
                    UPLog.m12144e("zip", th.getMessage());
                } finally {
                    C3586f.m12386a(gZIPOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: b */
    public static void m12339b(byte[] bArr, OutputStream outputStream) {
        GZIPInputStream gZIPInputStream = null;
        try {
            GZIPInputStream gZIPInputStream2 = new GZIPInputStream(new ByteArrayInputStream(bArr));
            try {
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int read = gZIPInputStream2.read(bArr2);
                    if (read == -1) {
                        C3586f.m12386a(gZIPInputStream2);
                        return;
                    }
                    outputStream.write(bArr2, 0, read);
                }
            } catch (Throwable th) {
                th = th;
                gZIPInputStream = gZIPInputStream2;
                try {
                    UPLog.m12144e("unzip", th.getMessage());
                } finally {
                    C3586f.m12386a(gZIPInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
