package c.d.a.a;

import c.d.a.a.f.a;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: V2SchemeUtil.java */
/* loaded from: classes.dex */
public class e {
    public static Map<Integer, ByteBuffer> a(ByteBuffer byteBuffer) throws a.c {
        c.d.a.a.f.a.a(byteBuffer);
        ByteBuffer a2 = c.d.a.a.f.a.a(byteBuffer, 8, byteBuffer.capacity() - 24);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i2 = 0;
        while (a2.hasRemaining()) {
            i2++;
            if (a2.remaining() < 8) {
                throw new a.c("Insufficient data to read size of APK Signing Block entry #" + i2);
            }
            long j2 = a2.getLong();
            if (j2 < 4 || j2 > 2147483647L) {
                throw new a.c("APK Signing Block entry #" + i2 + " size out of range: " + j2);
            }
            int i3 = (int) j2;
            int position = a2.position() + i3;
            if (i3 > a2.remaining()) {
                throw new a.c("APK Signing Block entry #" + i2 + " size out of range: " + i3 + ", available: " + a2.remaining());
            }
            int i4 = a2.getInt();
            linkedHashMap.put(Integer.valueOf(i4), c.d.a.a.f.a.a(a2, i3 - 4));
            if (i4 == 1896449818) {
                System.out.println("find V2 signature block Id : 1896449818");
            }
            a2.position(position);
        }
        if (!linkedHashMap.isEmpty()) {
            return linkedHashMap;
        }
        throw new a.c("not have Id-Value Pair in APK Signing Block entry #" + i2);
    }

    public static ByteBuffer b(File file) throws a.c, IOException {
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
            c<ByteBuffer, Long> b2 = c.d.a.a.f.a.b(randomAccessFile);
            ByteBuffer a2 = b2.a();
            long longValue = b2.b().longValue();
            if (c.d.a.a.f.b.a(randomAccessFile, longValue)) {
                throw new a.c("ZIP64 APK not supported");
            }
            ByteBuffer a3 = c.d.a.a.f.a.a(randomAccessFile, c.d.a.a.f.a.a(a2, longValue)).a();
            randomAccessFile.close();
            return a3;
        } catch (Throwable th2) {
            th = th2;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    private static ByteBuffer b(RandomAccessFile randomAccessFile, long j2, int i2) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(i2);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j2);
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        return allocate;
    }

    public static a a(File file, boolean z) throws IOException, a.c {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            c<ByteBuffer, Long> b2 = c.d.a.a.f.a.b(randomAccessFile);
            ByteBuffer a2 = b2.a();
            long longValue = b2.b().longValue();
            if (!c.d.a.a.f.b.a(randomAccessFile, longValue)) {
                long a3 = c.d.a.a.f.a.a(a2, longValue);
                c<ByteBuffer, Long> a4 = c.d.a.a.f.a.a(randomAccessFile, a3);
                c<ByteBuffer, Long> a5 = a(randomAccessFile, a3, (int) (longValue - a3));
                a aVar = new a();
                aVar.f3142a = z;
                aVar.f3143b = file.length();
                if (!z) {
                    aVar.f3144c = a(randomAccessFile, (int) a4.b().longValue());
                }
                aVar.f3145d = a4;
                aVar.f3146e = a5;
                aVar.f3147f = b2;
                aVar.b();
                System.out.println("baseApk : " + file.getAbsolutePath() + "\nApkSectionInfo = " + aVar);
                randomAccessFile.close();
                return aVar;
            }
            throw new a.c("ZIP64 APK not supported");
        } catch (Throwable th2) {
            th = th2;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    public static c<ByteBuffer, Long> a(RandomAccessFile randomAccessFile, long j2, int i2) throws IOException {
        return c.a(b(randomAccessFile, j2, i2), Long.valueOf(j2));
    }

    public static c<ByteBuffer, Long> a(RandomAccessFile randomAccessFile, int i2) throws IOException {
        return c.a(b(randomAccessFile, 0L, i2), 0L);
    }

    public static ByteBuffer a(Map<Integer, ByteBuffer> map) {
        if (map != null && !map.isEmpty()) {
            long j2 = 24;
            while (map.entrySet().iterator().hasNext()) {
                j2 += r2.next().getValue().remaining() + 12;
            }
            ByteBuffer allocate = ByteBuffer.allocate((int) (8 + j2));
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putLong(j2);
            for (Map.Entry<Integer, ByteBuffer> entry : map.entrySet()) {
                ByteBuffer value = entry.getValue();
                allocate.putLong(value.remaining() + 4);
                allocate.putInt(entry.getKey().intValue());
                allocate.put(value.array(), value.arrayOffset() + value.position(), value.remaining());
            }
            allocate.putLong(j2);
            allocate.putLong(c.d.a.a.f.a.n);
            allocate.putLong(c.d.a.a.f.a.f3166m);
            if (allocate.remaining() <= 0) {
                allocate.flip();
                return allocate;
            }
            throw new RuntimeException("generateNewApkV2SchemeBlock error");
        }
        throw new RuntimeException("getNewApkV2SchemeBlock , id value pair is empty");
    }

    public static boolean a(String str) throws Exception {
        return c.d.a.a.f.a.a(str);
    }

    public static boolean a(File file) {
        try {
            return a(b(file)).containsKey(Integer.valueOf(c.d.a.a.f.a.p));
        } catch (a.c unused) {
            System.out.println("APK : " + file.getAbsolutePath() + " not have apk signature block");
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
