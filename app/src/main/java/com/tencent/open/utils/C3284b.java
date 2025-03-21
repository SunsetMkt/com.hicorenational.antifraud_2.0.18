package com.tencent.open.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;
import java.util.zip.ZipException;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.utils.b */
/* loaded from: classes2.dex */
public final class C3284b {

    /* renamed from: a */
    private static final C3296n f11287a = new C3296n(101010256);

    /* renamed from: b */
    private static final C3297o f11288b = new C3297o(38651);

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.utils.b$a */
    private static class a {

        /* renamed from: a */
        Properties f11289a;

        /* renamed from: b */
        byte[] f11290b;

        private a() {
            this.f11289a = new Properties();
        }

        /* renamed from: a */
        void m10584a(byte[] bArr) throws IOException {
            if (bArr == null) {
                return;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int length = C3284b.f11288b.m10717a().length;
            byte[] bArr2 = new byte[length];
            wrap.get(bArr2);
            if (!C3284b.f11288b.equals(new C3297o(bArr2))) {
                throw new ProtocolException("unknow protocl [" + Arrays.toString(bArr) + "]");
            }
            if (bArr.length - length <= 2) {
                return;
            }
            byte[] bArr3 = new byte[2];
            wrap.get(bArr3);
            int m10718b = new C3297o(bArr3).m10718b();
            if ((bArr.length - length) - 2 < m10718b) {
                return;
            }
            byte[] bArr4 = new byte[m10718b];
            wrap.get(bArr4);
            this.f11289a.load(new ByteArrayInputStream(bArr4));
            int length2 = ((bArr.length - length) - m10718b) - 2;
            if (length2 > 0) {
                this.f11290b = new byte[length2];
                wrap.get(this.f11290b);
            }
        }

        public String toString() {
            return "ApkExternalInfo [p=" + this.f11289a + ", otherData=" + Arrays.toString(this.f11290b) + "]";
        }
    }

    /* renamed from: a */
    public static String m10582a(File file, String str) throws IOException {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            byte[] m10583a = m10583a(randomAccessFile);
            if (m10583a == null) {
                randomAccessFile.close();
                return null;
            }
            a aVar = new a();
            aVar.m10584a(m10583a);
            String property = aVar.f11289a.getProperty(str);
            randomAccessFile.close();
            return property;
        } catch (Throwable th2) {
            th = th2;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static String m10581a(File file) throws IOException {
        return m10582a(file, "channelNo");
    }

    /* renamed from: a */
    private static byte[] m10583a(RandomAccessFile randomAccessFile) throws IOException {
        boolean z;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] m10715a = f11287a.m10715a();
        int read = randomAccessFile.read();
        while (true) {
            z = true;
            if (read == -1) {
                z = false;
                break;
            }
            if (read == m10715a[0] && randomAccessFile.read() == m10715a[1] && randomAccessFile.read() == m10715a[2] && randomAccessFile.read() == m10715a[3]) {
                break;
            }
            length--;
            randomAccessFile.seek(length);
            read = randomAccessFile.read();
        }
        if (z) {
            randomAccessFile.seek(length + 16 + 4);
            byte[] bArr = new byte[2];
            randomAccessFile.readFully(bArr);
            int m10718b = new C3297o(bArr).m10718b();
            if (m10718b == 0) {
                return null;
            }
            byte[] bArr2 = new byte[m10718b];
            randomAccessFile.read(bArr2);
            return bArr2;
        }
        throw new ZipException("archive is not a ZIP archive");
    }
}
