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
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final n f9902a = new n(101010256);

    /* renamed from: b, reason: collision with root package name */
    private static final o f9903b = new o(38651);

    /* compiled from: ProGuard */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        Properties f9904a;

        /* renamed from: b, reason: collision with root package name */
        byte[] f9905b;

        private a() {
            this.f9904a = new Properties();
        }

        void a(byte[] bArr) throws IOException {
            if (bArr == null) {
                return;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int length = b.f9903b.a().length;
            byte[] bArr2 = new byte[length];
            wrap.get(bArr2);
            if (!b.f9903b.equals(new o(bArr2))) {
                throw new ProtocolException("unknow protocl [" + Arrays.toString(bArr) + "]");
            }
            if (bArr.length - length <= 2) {
                return;
            }
            byte[] bArr3 = new byte[2];
            wrap.get(bArr3);
            int b2 = new o(bArr3).b();
            if ((bArr.length - length) - 2 < b2) {
                return;
            }
            byte[] bArr4 = new byte[b2];
            wrap.get(bArr4);
            this.f9904a.load(new ByteArrayInputStream(bArr4));
            int length2 = ((bArr.length - length) - b2) - 2;
            if (length2 > 0) {
                this.f9905b = new byte[length2];
                wrap.get(this.f9905b);
            }
        }

        public String toString() {
            return "ApkExternalInfo [p=" + this.f9904a + ", otherData=" + Arrays.toString(this.f9905b) + "]";
        }
    }

    public static String a(File file, String str) throws IOException {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            byte[] a2 = a(randomAccessFile);
            if (a2 == null) {
                randomAccessFile.close();
                return null;
            }
            a aVar = new a();
            aVar.a(a2);
            String property = aVar.f9904a.getProperty(str);
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

    public static String a(File file) throws IOException {
        return a(file, "channelNo");
    }

    private static byte[] a(RandomAccessFile randomAccessFile) throws IOException {
        boolean z;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] a2 = f9902a.a();
        int read = randomAccessFile.read();
        while (true) {
            z = true;
            if (read == -1) {
                z = false;
                break;
            }
            if (read == a2[0] && randomAccessFile.read() == a2[1] && randomAccessFile.read() == a2[2] && randomAccessFile.read() == a2[3]) {
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
            int b2 = new o(bArr).b();
            if (b2 == 0) {
                return null;
            }
            byte[] bArr2 = new byte[b2];
            randomAccessFile.read(bArr2);
            return bArr2;
        }
        throw new ZipException("archive is not a ZIP archive");
    }
}
