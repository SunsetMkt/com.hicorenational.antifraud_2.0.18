package p031c.p091d.p092a.p093a;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedHashMap;
import java.util.Map;
import p031c.p091d.p092a.p093a.p094f.AbstractC1223b;
import p031c.p091d.p092a.p093a.p094f.C1222a;

/* compiled from: V2SchemeUtil.java */
/* renamed from: c.d.a.a.e */
/* loaded from: classes.dex */
public class C1221e {
    /* renamed from: a */
    public static Map<Integer, ByteBuffer> m2384a(ByteBuffer byteBuffer) throws C1222a.c {
        C1222a.m2398a(byteBuffer);
        ByteBuffer m2396a = C1222a.m2396a(byteBuffer, 8, byteBuffer.capacity() - 24);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i2 = 0;
        while (m2396a.hasRemaining()) {
            i2++;
            if (m2396a.remaining() < 8) {
                throw new C1222a.c("Insufficient data to read size of APK Signing Block entry #" + i2);
            }
            long j2 = m2396a.getLong();
            if (j2 < 4 || j2 > 2147483647L) {
                throw new C1222a.c("APK Signing Block entry #" + i2 + " size out of range: " + j2);
            }
            int i3 = (int) j2;
            int position = m2396a.position() + i3;
            if (i3 > m2396a.remaining()) {
                throw new C1222a.c("APK Signing Block entry #" + i2 + " size out of range: " + i3 + ", available: " + m2396a.remaining());
            }
            int i4 = m2396a.getInt();
            linkedHashMap.put(Integer.valueOf(i4), C1222a.m2395a(m2396a, i3 - 4));
            if (i4 == 1896449818) {
                System.out.println("find V2 signature block Id : 1896449818");
            }
            m2396a.position(position);
        }
        if (!linkedHashMap.isEmpty()) {
            return linkedHashMap;
        }
        throw new C1222a.c("not have Id-Value Pair in APK Signing Block entry #" + i2);
    }

    /* renamed from: b */
    public static ByteBuffer m2387b(File file) throws C1222a.c, IOException {
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
            ByteBuffer m2369a = m2402b.m2369a();
            long longValue = m2402b.m2370b().longValue();
            if (AbstractC1223b.m2416a(randomAccessFile, longValue)) {
                throw new C1222a.c("ZIP64 APK not supported");
            }
            ByteBuffer m2369a2 = C1222a.m2392a(randomAccessFile, C1222a.m2391a(m2369a, longValue)).m2369a();
            randomAccessFile.close();
            return m2369a2;
        } catch (Throwable th2) {
            th = th2;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    /* renamed from: b */
    private static ByteBuffer m2388b(RandomAccessFile randomAccessFile, long j2, int i2) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(i2);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j2);
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        return allocate;
    }

    /* renamed from: a */
    public static C1217a m2380a(File file, boolean z) throws IOException, C1222a.c {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            C1219c<ByteBuffer, Long> m2402b = C1222a.m2402b(randomAccessFile);
            ByteBuffer m2369a = m2402b.m2369a();
            long longValue = m2402b.m2370b().longValue();
            if (!AbstractC1223b.m2416a(randomAccessFile, longValue)) {
                long m2391a = C1222a.m2391a(m2369a, longValue);
                C1219c<ByteBuffer, Long> m2392a = C1222a.m2392a(randomAccessFile, m2391a);
                C1219c<ByteBuffer, Long> m2382a = m2382a(randomAccessFile, m2391a, (int) (longValue - m2391a));
                C1217a c1217a = new C1217a();
                c1217a.f2663a = z;
                c1217a.f2664b = file.length();
                if (!z) {
                    c1217a.f2665c = m2381a(randomAccessFile, (int) m2392a.m2370b().longValue());
                }
                c1217a.f2666d = m2392a;
                c1217a.f2667e = m2382a;
                c1217a.f2668f = m2402b;
                c1217a.m2366b();
                System.out.println("baseApk : " + file.getAbsolutePath() + "\nApkSectionInfo = " + c1217a);
                randomAccessFile.close();
                return c1217a;
            }
            throw new C1222a.c("ZIP64 APK not supported");
        } catch (Throwable th2) {
            th = th2;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static C1219c<ByteBuffer, Long> m2382a(RandomAccessFile randomAccessFile, long j2, int i2) throws IOException {
        return C1219c.m2368a(m2388b(randomAccessFile, j2, i2), Long.valueOf(j2));
    }

    /* renamed from: a */
    public static C1219c<ByteBuffer, Long> m2381a(RandomAccessFile randomAccessFile, int i2) throws IOException {
        return C1219c.m2368a(m2388b(randomAccessFile, 0L, i2), 0L);
    }

    /* renamed from: a */
    public static ByteBuffer m2383a(Map<Integer, ByteBuffer> map) {
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
            allocate.putLong(C1222a.f2688n);
            allocate.putLong(C1222a.f2687m);
            if (allocate.remaining() <= 0) {
                allocate.flip();
                return allocate;
            }
            throw new RuntimeException("generateNewApkV2SchemeBlock error");
        }
        throw new RuntimeException("getNewApkV2SchemeBlock , id value pair is empty");
    }

    /* renamed from: a */
    public static boolean m2386a(String str) throws Exception {
        return C1222a.m2399a(str);
    }

    /* renamed from: a */
    public static boolean m2385a(File file) {
        try {
            return m2384a(m2387b(file)).containsKey(Integer.valueOf(C1222a.f2690p));
        } catch (C1222a.c unused) {
            System.out.println("APK : " + file.getAbsolutePath() + " not have apk signature block");
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
