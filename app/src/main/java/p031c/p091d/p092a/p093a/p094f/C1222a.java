package p031c.p091d.p092a.p093a.p094f;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import p031c.p091d.p092a.p093a.C1219c;

/* compiled from: ApkSignatureSchemeV2Verifier.java */
/* renamed from: c.d.a.a.f.a */
/* loaded from: classes.dex */
public class C1222a {

    /* renamed from: a */
    public static final String f2675a = "X-Android-APK-Signed";

    /* renamed from: b */
    public static final int f2676b = 2;

    /* renamed from: c */
    private static final int f2677c = 1048576;

    /* renamed from: d */
    private static final int f2678d = 257;

    /* renamed from: e */
    private static final int f2679e = 258;

    /* renamed from: f */
    private static final int f2680f = 259;

    /* renamed from: g */
    private static final int f2681g = 260;

    /* renamed from: h */
    private static final int f2682h = 513;

    /* renamed from: i */
    private static final int f2683i = 514;

    /* renamed from: j */
    private static final int f2684j = 769;

    /* renamed from: k */
    private static final int f2685k = 1;

    /* renamed from: l */
    private static final int f2686l = 2;

    /* renamed from: m */
    public static final long f2687m = 3617552046287187010L;

    /* renamed from: n */
    public static final long f2688n = 2334950737559900225L;

    /* renamed from: o */
    private static final int f2689o = 32;

    /* renamed from: p */
    public static final int f2690p = 1896449818;

    /* compiled from: ApkSignatureSchemeV2Verifier.java */
    /* renamed from: c.d.a.a.f.a$b */
    private static class b {

        /* renamed from: a */
        private final ByteBuffer f2691a;

        /* renamed from: b */
        private final long f2692b;

        /* renamed from: c */
        private final long f2693c;

        /* renamed from: d */
        private final long f2694d;

        /* renamed from: e */
        private final ByteBuffer f2695e;

        private b(ByteBuffer byteBuffer, long j2, long j3, long j4, ByteBuffer byteBuffer2) {
            this.f2691a = byteBuffer;
            this.f2692b = j2;
            this.f2693c = j3;
            this.f2694d = j4;
            this.f2695e = byteBuffer2;
        }
    }

    /* compiled from: ApkSignatureSchemeV2Verifier.java */
    /* renamed from: c.d.a.a.f.a$c */
    public static class c extends Exception {
        private static final long serialVersionUID = 1;

        public c(String str) {
            super(str);
        }

        public c(String str, Throwable th) {
            super(str, th);
        }
    }

    /* renamed from: a */
    public static boolean m2399a(String str) throws IOException {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
        } catch (c unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            m2393a(randomAccessFile);
            randomAccessFile.close();
            return true;
        } catch (c unused2) {
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th;
        }
    }

    /* renamed from: b */
    public static C1219c<ByteBuffer, Long> m2402b(RandomAccessFile randomAccessFile) throws IOException, c {
        C1219c<ByteBuffer, Long> m2411a = AbstractC1223b.m2411a(randomAccessFile);
        if (m2411a != null) {
            return m2411a;
        }
        throw new c("Not an APK file: ZIP End of Central Directory record not found");
    }

    /* renamed from: c */
    private static int m2404c(int i2) {
        if (i2 == 513) {
            return 1;
        }
        if (i2 == f2683i) {
            return 2;
        }
        if (i2 == f2684j) {
            return 1;
        }
        switch (i2) {
            case 257:
            case 259:
                return 1;
            case 258:
            case f2681g /* 260 */:
                return 2;
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i2 & (-1)));
        }
    }

    /* renamed from: d */
    private static String m2406d(int i2) {
        if (i2 == 513 || i2 == f2683i) {
            return "EC";
        }
        if (i2 == f2684j) {
            return "DSA";
        }
        switch (i2) {
            case 257:
            case 258:
            case 259:
            case f2681g /* 260 */:
                return "RSA";
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i2 & (-1)));
        }
    }

    /* renamed from: e */
    private static C1219c<String, ? extends AlgorithmParameterSpec> m2408e(int i2) {
        if (i2 == 513) {
            return C1219c.m2368a("SHA256withECDSA", null);
        }
        if (i2 == f2683i) {
            return C1219c.m2368a("SHA512withECDSA", null);
        }
        if (i2 == f2684j) {
            return C1219c.m2368a("SHA256withDSA", null);
        }
        switch (i2) {
            case 257:
                return C1219c.m2368a("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
            case 258:
                return C1219c.m2368a("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
            case 259:
                return C1219c.m2368a("SHA256withRSA", null);
            case f2681g /* 260 */:
                return C1219c.m2368a("SHA512withRSA", null);
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i2 & (-1)));
        }
    }

    /* renamed from: f */
    private static boolean m2409f(int i2) {
        if (i2 == 513 || i2 == f2683i || i2 == f2684j) {
            return true;
        }
        switch (i2) {
            case 257:
            case 258:
            case 259:
            case f2681g /* 260 */:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: b */
    private static int m2401b(int i2, int i3) {
        return m2389a(m2404c(i2), m2404c(i3));
    }

    /* renamed from: c */
    private static ByteBuffer m2405c(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() >= 4) {
            int i2 = byteBuffer.getInt();
            if (i2 >= 0) {
                if (i2 <= byteBuffer.remaining()) {
                    return m2395a(byteBuffer, i2);
                }
                throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i2 + ", remaining: " + byteBuffer.remaining());
            }
            throw new IllegalArgumentException("Negative length");
        }
        throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
    }

    /* renamed from: d */
    private static byte[] m2407d(ByteBuffer byteBuffer) throws IOException {
        int i2 = byteBuffer.getInt();
        if (i2 >= 0) {
            if (i2 <= byteBuffer.remaining()) {
                byte[] bArr = new byte[i2];
                byteBuffer.get(bArr);
                return bArr;
            }
            throw new IOException("Underflow while reading length-prefixed value. Length: " + i2 + ", available: " + byteBuffer.remaining());
        }
        throw new IOException("Negative length");
    }

    /* renamed from: a */
    private static b m2393a(RandomAccessFile randomAccessFile) throws IOException, c {
        C1219c<ByteBuffer, Long> m2402b = m2402b(randomAccessFile);
        ByteBuffer m2369a = m2402b.m2369a();
        long longValue = m2402b.m2370b().longValue();
        if (!AbstractC1223b.m2416a(randomAccessFile, longValue)) {
            long m2391a = m2391a(m2369a, longValue);
            C1219c<ByteBuffer, Long> m2392a = m2392a(randomAccessFile, m2391a);
            ByteBuffer m2369a2 = m2392a.m2369a();
            return new b(m2403b(m2369a2), m2392a.m2370b().longValue(), m2391a, longValue, m2369a);
        }
        throw new c("ZIP64 APK not supported");
    }

    /* renamed from: b */
    private static int m2400b(int i2) {
        if (i2 == 1) {
            return 32;
        }
        if (i2 == 2) {
            return 64;
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: " + i2);
    }

    /* renamed from: b */
    private static ByteBuffer m2403b(ByteBuffer byteBuffer) throws c {
        m2398a(byteBuffer);
        ByteBuffer m2396a = m2396a(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i2 = 0;
        while (m2396a.hasRemaining()) {
            i2++;
            if (m2396a.remaining() >= 8) {
                long j2 = m2396a.getLong();
                if (j2 >= 4 && j2 <= 2147483647L) {
                    int i3 = (int) j2;
                    int position = m2396a.position() + i3;
                    if (i3 <= m2396a.remaining()) {
                        if (m2396a.getInt() == 1896449818) {
                            return m2395a(m2396a, i3 - 4);
                        }
                        m2396a.position(position);
                    } else {
                        throw new c("APK Signing Block entry #" + i2 + " size out of range: " + i3 + ", available: " + m2396a.remaining());
                    }
                } else {
                    throw new c("APK Signing Block entry #" + i2 + " size out of range: " + j2);
                }
            } else {
                throw new c("Insufficient data to read size of APK Signing Block entry #" + i2);
            }
        }
        throw new c("No APK Signature Scheme v2 block in APK Signing Block");
    }

    /* renamed from: a */
    public static long m2391a(ByteBuffer byteBuffer, long j2) throws c {
        long m2419c = AbstractC1223b.m2419c(byteBuffer);
        if (m2419c < j2) {
            if (AbstractC1223b.m2420d(byteBuffer) + m2419c == j2) {
                return m2419c;
            }
            throw new c("ZIP Central Directory is not immediately followed by End of Central Directory");
        }
        throw new c("ZIP Central Directory offset out of range: " + m2419c + ". ZIP End of Central Directory offset: " + j2);
    }

    /* renamed from: a */
    private static final long m2390a(long j2) {
        return ((j2 + 1048576) - 1) / 1048576;
    }

    /* renamed from: a */
    private static int m2389a(int i2, int i3) {
        if (i2 == 1) {
            if (i3 == 1) {
                return 0;
            }
            if (i3 == 2) {
                return -1;
            }
            throw new IllegalArgumentException("Unknown digestAlgorithm2: " + i3);
        }
        if (i2 != 2) {
            throw new IllegalArgumentException("Unknown digestAlgorithm1: " + i2);
        }
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            return 0;
        }
        throw new IllegalArgumentException("Unknown digestAlgorithm2: " + i3);
    }

    /* renamed from: a */
    private static String m2394a(int i2) {
        if (i2 == 1) {
            return "SHA-256";
        }
        if (i2 == 2) {
            return "SHA-512";
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: " + i2);
    }

    /* renamed from: a */
    public static ByteBuffer m2396a(ByteBuffer byteBuffer, int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException("start: " + i2);
        }
        if (i3 >= i2) {
            int capacity = byteBuffer.capacity();
            if (i3 <= byteBuffer.capacity()) {
                int limit = byteBuffer.limit();
                int position = byteBuffer.position();
                try {
                    byteBuffer.position(0);
                    byteBuffer.limit(i3);
                    byteBuffer.position(i2);
                    ByteBuffer slice = byteBuffer.slice();
                    slice.order(byteBuffer.order());
                    return slice;
                } finally {
                    byteBuffer.position(0);
                    byteBuffer.limit(limit);
                    byteBuffer.position(position);
                }
            }
            throw new IllegalArgumentException("end > capacity: " + i3 + " > " + capacity);
        }
        throw new IllegalArgumentException("end < start: " + i3 + " < " + i2);
    }

    /* renamed from: a */
    public static ByteBuffer m2395a(ByteBuffer byteBuffer, int i2) throws BufferUnderflowException {
        if (i2 >= 0) {
            int limit = byteBuffer.limit();
            int position = byteBuffer.position();
            int i3 = i2 + position;
            if (i3 >= position && i3 <= limit) {
                byteBuffer.limit(i3);
                try {
                    ByteBuffer slice = byteBuffer.slice();
                    slice.order(byteBuffer.order());
                    byteBuffer.position(i3);
                    return slice;
                } finally {
                    byteBuffer.limit(limit);
                }
            }
            throw new BufferUnderflowException();
        }
        throw new IllegalArgumentException("size: " + i2);
    }

    /* renamed from: a */
    private static void m2397a(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) (i2 & 255);
        bArr[i3 + 1] = (byte) ((i2 >>> 8) & 255);
        bArr[i3 + 2] = (byte) ((i2 >>> 16) & 255);
        bArr[i3 + 3] = (byte) ((i2 >>> 24) & 255);
    }

    /* renamed from: a */
    public static C1219c<ByteBuffer, Long> m2392a(RandomAccessFile randomAccessFile, long j2) throws IOException, c {
        if (j2 >= 32) {
            ByteBuffer allocate = ByteBuffer.allocate(24);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            randomAccessFile.seek(j2 - allocate.capacity());
            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
            if (allocate.getLong(8) == f2688n && allocate.getLong(16) == f2687m) {
                long j3 = allocate.getLong(0);
                if (j3 < allocate.capacity() || j3 > 2147483639) {
                    throw new c("APK Signing Block size out of range: " + j3);
                }
                int i2 = (int) (8 + j3);
                long j4 = j2 - i2;
                if (j4 >= 0) {
                    ByteBuffer allocate2 = ByteBuffer.allocate(i2);
                    allocate2.order(ByteOrder.LITTLE_ENDIAN);
                    randomAccessFile.seek(j4);
                    randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                    long j5 = allocate2.getLong(0);
                    if (j5 == j3) {
                        return C1219c.m2368a(allocate2, Long.valueOf(j4));
                    }
                    throw new c("APK Signing Block sizes in header and footer do not match: " + j5 + " vs " + j3);
                }
                throw new c("APK Signing Block offset out of range: " + j4);
            }
            throw new c("No APK Signing Block before ZIP Central Directory");
        }
        throw new c("APK too small for APK Signing Block. ZIP Central Directory offset: " + j2);
    }

    /* renamed from: a */
    public static void m2398a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }
}
