package p031c.p091d.p092a.p093a;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import p031c.p091d.p092a.p093a.p094f.AbstractC1223b;
import p031c.p091d.p092a.p093a.p094f.C1222a;

/* compiled from: V1SchemeUtil.java */
/* renamed from: c.d.a.a.d */
/* loaded from: classes.dex */
public class C1220d {

    /* compiled from: V1SchemeUtil.java */
    /* renamed from: c.d.a.a.d$a */
    public static class a extends Exception {
        static final long serialVersionUID = -3387516993124229949L;

        public a() {
        }

        public a(String str) {
            super(str);
        }
    }

    /* renamed from: a */
    public static void m2374a(File file, String str) throws Exception {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        if (file == null || !file.exists() || !file.isFile() || str == null || str.isEmpty()) {
            throw new Exception("param error , file : " + file + " , channel : " + str);
        }
        byte[] bytes = str.getBytes("UTF-8");
        C1219c<ByteBuffer, Long> m2378c = m2378c(file);
        if (m2378c.m2369a().remaining() == 22) {
            System.out.println("file : " + file.getAbsolutePath() + " , has no comment");
            try {
                randomAccessFile2 = new RandomAccessFile(file, "rw");
            } catch (Throwable th) {
                th = th;
                randomAccessFile2 = null;
            }
            try {
                randomAccessFile2.seek(file.length() - 2);
                m2372a(bytes.length + 2 + C1218b.f2672d.length, randomAccessFile2);
                randomAccessFile2.write(bytes);
                m2372a(bytes.length, randomAccessFile2);
                randomAccessFile2.write(C1218b.f2672d);
                randomAccessFile2.close();
                return;
            } catch (Throwable th2) {
                th = th2;
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                }
                throw th;
            }
        }
        System.out.println("file : " + file.getAbsolutePath() + " , has comment");
        if (m2375a(file)) {
            try {
                String m2379d = m2379d(file);
                if (m2379d != null) {
                    file.delete();
                    throw new a("file : " + file.getAbsolutePath() + " has a channel : " + m2379d + ", only ignore");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        int m2410a = AbstractC1223b.m2410a(m2378c.m2369a(), 20);
        int length = bytes.length + m2410a + 2 + C1218b.f2672d.length;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
        }
        try {
            randomAccessFile.seek((m2378c.m2370b().longValue() + 22) - 2);
            m2372a(length, randomAccessFile);
            randomAccessFile.seek(m2378c.m2370b().longValue() + 22 + m2410a);
            randomAccessFile.write(bytes);
            m2372a(bytes.length, randomAccessFile);
            randomAccessFile.write(C1218b.f2672d);
            randomAccessFile.close();
        } catch (Throwable th4) {
            th = th4;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
    
        r1 = r0.getJarEntry(r3.getName());
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m2377b(java.io.File r6) {
        /*
            java.util.jar.JarFile r0 = new java.util.jar.JarFile     // Catch: java.io.IOException -> L36
            r0.<init>(r6)     // Catch: java.io.IOException -> L36
            java.lang.String r6 = "META-INF/MANIFEST.MF"
            java.util.jar.JarEntry r6 = r0.getJarEntry(r6)     // Catch: java.io.IOException -> L36
            r1 = 0
            java.util.Enumeration r2 = r0.entries()     // Catch: java.io.IOException -> L36
        L10:
            boolean r3 = r2.hasMoreElements()     // Catch: java.io.IOException -> L36
            if (r3 == 0) goto L30
            java.lang.Object r3 = r2.nextElement()     // Catch: java.io.IOException -> L36
            java.util.jar.JarEntry r3 = (java.util.jar.JarEntry) r3     // Catch: java.io.IOException -> L36
            java.lang.String r4 = r3.getName()     // Catch: java.io.IOException -> L36
            java.lang.String r5 = "META-INF/\\w+\\.SF"
            boolean r4 = r4.matches(r5)     // Catch: java.io.IOException -> L36
            if (r4 == 0) goto L10
            java.lang.String r1 = r3.getName()     // Catch: java.io.IOException -> L36
            java.util.jar.JarEntry r1 = r0.getJarEntry(r1)     // Catch: java.io.IOException -> L36
        L30:
            if (r6 == 0) goto L3a
            if (r1 == 0) goto L3a
            r6 = 1
            return r6
        L36:
            r6 = move-exception
            r6.printStackTrace()
        L3a:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p031c.p091d.p092a.p093a.C1220d.m2377b(java.io.File):boolean");
    }

    /* renamed from: c */
    public static C1219c<ByteBuffer, Long> m2378c(File file) throws IOException, C1222a.c {
        RandomAccessFile randomAccessFile;
        if (file == null || !file.exists() || !file.isFile()) {
            return null;
        }
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            C1219c<ByteBuffer, Long> m2402b = C1222a.m2402b(randomAccessFile);
            if (AbstractC1223b.m2416a(randomAccessFile, m2402b.m2370b().longValue())) {
                throw new C1222a.c("ZIP64 APK not supported");
            }
            randomAccessFile.close();
            return m2402b;
        } catch (Throwable th2) {
            th = th2;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    /* renamed from: d */
    public static String m2379d(File file) throws Exception {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            long length = randomAccessFile.length();
            byte[] bArr = new byte[C1218b.f2672d.length];
            long length2 = length - C1218b.f2672d.length;
            randomAccessFile.seek(length2);
            randomAccessFile.readFully(bArr);
            if (!m2376a(bArr)) {
                throw new Exception("zip v1 magic not found");
            }
            long j2 = length2 - 2;
            randomAccessFile.seek(j2);
            int m2371a = m2371a(randomAccessFile);
            if (m2371a <= 0) {
                throw new Exception("zip channel info not found");
            }
            randomAccessFile.seek(j2 - m2371a);
            byte[] bArr2 = new byte[m2371a];
            randomAccessFile.readFully(bArr2);
            String str = new String(bArr2, "UTF-8");
            randomAccessFile.close();
            return str;
        } catch (Throwable th2) {
            th = th2;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    private static void m2372a(int i2, DataOutput dataOutput) throws IOException {
        ByteBuffer order = ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN);
        order.putShort((short) i2);
        dataOutput.write(order.array());
    }

    /* renamed from: a */
    private static short m2371a(DataInput dataInput) throws IOException {
        byte[] bArr = new byte[2];
        dataInput.readFully(bArr);
        return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getShort(0);
    }

    /* renamed from: a */
    public static boolean m2375a(File file) throws IOException {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            long length = randomAccessFile.length();
            byte[] bArr = new byte[C1218b.f2672d.length];
            randomAccessFile.seek(length - C1218b.f2672d.length);
            randomAccessFile.readFully(bArr);
            boolean m2376a = m2376a(bArr);
            randomAccessFile.close();
            return m2376a;
        } catch (Throwable th2) {
            th = th2;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    private static boolean m2376a(byte[] bArr) {
        if (bArr.length != C1218b.f2672d.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr2 = C1218b.f2672d;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    /* renamed from: a */
    public static void m2373a(File file, File file2) throws IOException {
        FileChannel fileChannel;
        FileChannel channel;
        if (!file2.exists()) {
            file2.createNewFile();
        }
        FileChannel fileChannel2 = null;
        try {
            channel = new FileInputStream(file).getChannel();
            try {
                fileChannel = new FileOutputStream(file2).getChannel();
            } catch (Throwable th) {
                fileChannel2 = channel;
                th = th;
                fileChannel = null;
            }
        } catch (Throwable th2) {
            th = th2;
            fileChannel = null;
        }
        try {
            fileChannel.transferFrom(channel, 0L, channel.size());
            if (channel != null) {
                channel.close();
            }
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (Throwable th3) {
            fileChannel2 = channel;
            th = th3;
            if (fileChannel2 != null) {
                fileChannel2.close();
            }
            if (fileChannel != null) {
                fileChannel.close();
            }
            throw th;
        }
    }
}
