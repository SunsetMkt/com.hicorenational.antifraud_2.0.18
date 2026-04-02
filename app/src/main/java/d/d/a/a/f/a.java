package d.d.a.a.f;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;

/* JADX INFO: compiled from: ApkSignatureSchemeV2Verifier.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static final String a = "X-Android-APK-Signed";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f10112b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f10113c = 1048576;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f10114d = 257;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f10115e = 258;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f10116f = 259;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f10117g = 260;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f10118h = 513;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f10119i = 514;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f10120j = 769;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f10121k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f10122l = 2;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f10123m = 3617552046287187010L;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f10124n = 2334950737559900225L;
    private static final int o = 32;
    public static final int p = 1896449818;

    /* JADX INFO: compiled from: ApkSignatureSchemeV2Verifier.java */
    private static class b {
        private final ByteBuffer a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f10125b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f10126c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f10127d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final ByteBuffer f10128e;

        private b(ByteBuffer byteBuffer, long j2, long j3, long j4, ByteBuffer byteBuffer2) {
            this.a = byteBuffer;
            this.f10125b = j2;
            this.f10126c = j3;
            this.f10127d = j4;
            this.f10128e = byteBuffer2;
        }
    }

    /* JADX INFO: compiled from: ApkSignatureSchemeV2Verifier.java */
    public static class c extends Exception {
        private static final long serialVersionUID = 1;

        public c(String str) {
            super(str);
        }

        public c(String str, Throwable th) {
            super(str, th);
        }
    }

    public static boolean a(String str) throws Throwable {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
        } catch (c unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            a(randomAccessFile);
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

    public static d.d.a.a.c<ByteBuffer, Long> b(RandomAccessFile randomAccessFile) throws IOException, c {
        d.d.a.a.c<ByteBuffer, Long> cVarA = d.d.a.a.f.b.a(randomAccessFile);
        if (cVarA != null) {
            return cVarA;
        }
        throw new c("Not an APK file: ZIP End of Central Directory record not found");
    }

    private static int c(int i2) {
        if (i2 == 513) {
            return 1;
        }
        if (i2 == f10119i) {
            return 2;
        }
        if (i2 == f10120j) {
            return 1;
        }
        switch (i2) {
            case 257:
            case 259:
                return 1;
            case 258:
            case f10117g /* 260 */:
                return 2;
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i2 & (-1)));
        }
    }

    private static String d(int i2) {
        if (i2 == 513 || i2 == f10119i) {
            return "EC";
        }
        if (i2 == f10120j) {
            return "DSA";
        }
        switch (i2) {
            case 257:
            case 258:
            case 259:
            case f10117g /* 260 */:
                return "RSA";
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i2 & (-1)));
        }
    }

    private static d.d.a.a.c<String, ? extends AlgorithmParameterSpec> e(int i2) {
        if (i2 == 513) {
            return d.d.a.a.c.a("SHA256withECDSA", null);
        }
        if (i2 == f10119i) {
            return d.d.a.a.c.a("SHA512withECDSA", null);
        }
        if (i2 == f10120j) {
            return d.d.a.a.c.a("SHA256withDSA", null);
        }
        switch (i2) {
            case 257:
                return d.d.a.a.c.a("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
            case 258:
                return d.d.a.a.c.a("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
            case 259:
                return d.d.a.a.c.a("SHA256withRSA", null);
            case f10117g /* 260 */:
                return d.d.a.a.c.a("SHA512withRSA", null);
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i2 & (-1)));
        }
    }

    private static boolean f(int i2) {
        if (i2 == 513 || i2 == f10119i || i2 == f10120j) {
            return true;
        }
        switch (i2) {
            case 257:
            case 258:
            case 259:
            case f10117g /* 260 */:
                return true;
            default:
                return false;
        }
    }

    private static int b(int i2, int i3) {
        return a(c(i2), c(i3));
    }

    private static ByteBuffer c(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() >= 4) {
            int i2 = byteBuffer.getInt();
            if (i2 >= 0) {
                if (i2 <= byteBuffer.remaining()) {
                    return a(byteBuffer, i2);
                }
                throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i2 + ", remaining: " + byteBuffer.remaining());
            }
            throw new IllegalArgumentException("Negative length");
        }
        throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
    }

    private static byte[] d(ByteBuffer byteBuffer) throws IOException {
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

    private static b a(RandomAccessFile randomAccessFile) throws IOException, c {
        d.d.a.a.c<ByteBuffer, Long> cVarB = b(randomAccessFile);
        ByteBuffer byteBufferA = cVarB.a();
        long jLongValue = cVarB.b().longValue();
        if (!d.d.a.a.f.b.a(randomAccessFile, jLongValue)) {
            long jA = a(byteBufferA, jLongValue);
            d.d.a.a.c<ByteBuffer, Long> cVarA = a(randomAccessFile, jA);
            ByteBuffer byteBufferA2 = cVarA.a();
            return new b(b(byteBufferA2), cVarA.b().longValue(), jA, jLongValue, byteBufferA);
        }
        throw new c("ZIP64 APK not supported");
    }

    private static int b(int i2) {
        if (i2 == 1) {
            return 32;
        }
        if (i2 == 2) {
            return 64;
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: " + i2);
    }

    private static ByteBuffer b(ByteBuffer byteBuffer) throws c {
        a(byteBuffer);
        ByteBuffer byteBufferA = a(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i2 = 0;
        while (byteBufferA.hasRemaining()) {
            i2++;
            if (byteBufferA.remaining() >= 8) {
                long j2 = byteBufferA.getLong();
                if (j2 >= 4 && j2 <= 2147483647L) {
                    int i3 = (int) j2;
                    int iPosition = byteBufferA.position() + i3;
                    if (i3 <= byteBufferA.remaining()) {
                        if (byteBufferA.getInt() == 1896449818) {
                            return a(byteBufferA, i3 - 4);
                        }
                        byteBufferA.position(iPosition);
                    } else {
                        throw new c("APK Signing Block entry #" + i2 + " size out of range: " + i3 + ", available: " + byteBufferA.remaining());
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

    public static long a(ByteBuffer byteBuffer, long j2) throws c {
        long jC = d.d.a.a.f.b.c(byteBuffer);
        if (jC < j2) {
            if (d.d.a.a.f.b.d(byteBuffer) + jC == j2) {
                return jC;
            }
            throw new c("ZIP Central Directory is not immediately followed by End of Central Directory");
        }
        throw new c("ZIP Central Directory offset out of range: " + jC + ". ZIP End of Central Directory offset: " + j2);
    }

    private static final long a(long j2) {
        return ((j2 + 1048576) - 1) / 1048576;
    }

    private static int a(int i2, int i3) {
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

    private static String a(int i2) {
        if (i2 == 1) {
            return "SHA-256";
        }
        if (i2 == 2) {
            return "SHA-512";
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: " + i2);
    }

    public static ByteBuffer a(ByteBuffer byteBuffer, int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException("start: " + i2);
        }
        if (i3 >= i2) {
            int iCapacity = byteBuffer.capacity();
            if (i3 <= byteBuffer.capacity()) {
                int iLimit = byteBuffer.limit();
                int iPosition = byteBuffer.position();
                try {
                    byteBuffer.position(0);
                    byteBuffer.limit(i3);
                    byteBuffer.position(i2);
                    ByteBuffer byteBufferSlice = byteBuffer.slice();
                    byteBufferSlice.order(byteBuffer.order());
                    return byteBufferSlice;
                } finally {
                    byteBuffer.position(0);
                    byteBuffer.limit(iLimit);
                    byteBuffer.position(iPosition);
                }
            }
            throw new IllegalArgumentException("end > capacity: " + i3 + " > " + iCapacity);
        }
        throw new IllegalArgumentException("end < start: " + i3 + " < " + i2);
    }

    public static ByteBuffer a(ByteBuffer byteBuffer, int i2) throws BufferUnderflowException {
        if (i2 >= 0) {
            int iLimit = byteBuffer.limit();
            int iPosition = byteBuffer.position();
            int i3 = i2 + iPosition;
            if (i3 >= iPosition && i3 <= iLimit) {
                byteBuffer.limit(i3);
                try {
                    ByteBuffer byteBufferSlice = byteBuffer.slice();
                    byteBufferSlice.order(byteBuffer.order());
                    byteBuffer.position(i3);
                    return byteBufferSlice;
                } finally {
                    byteBuffer.limit(iLimit);
                }
            }
            throw new BufferUnderflowException();
        }
        throw new IllegalArgumentException("size: " + i2);
    }

    private static void a(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) (i2 & 255);
        bArr[i3 + 1] = (byte) ((i2 >>> 8) & 255);
        bArr[i3 + 2] = (byte) ((i2 >>> 16) & 255);
        bArr[i3 + 3] = (byte) ((i2 >>> 24) & 255);
    }

    public static d.d.a.a.c<ByteBuffer, Long> a(RandomAccessFile randomAccessFile, long j2) throws IOException, c {
        if (j2 >= 32) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(24);
            byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
            randomAccessFile.seek(j2 - ((long) byteBufferAllocate.capacity()));
            randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
            if (byteBufferAllocate.getLong(8) == f10124n && byteBufferAllocate.getLong(16) == f10123m) {
                long j3 = byteBufferAllocate.getLong(0);
                if (j3 < byteBufferAllocate.capacity() || j3 > 2147483639) {
                    throw new c("APK Signing Block size out of range: " + j3);
                }
                int i2 = (int) (8 + j3);
                long j4 = j2 - ((long) i2);
                if (j4 >= 0) {
                    ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i2);
                    byteBufferAllocate2.order(ByteOrder.LITTLE_ENDIAN);
                    randomAccessFile.seek(j4);
                    randomAccessFile.readFully(byteBufferAllocate2.array(), byteBufferAllocate2.arrayOffset(), byteBufferAllocate2.capacity());
                    long j5 = byteBufferAllocate2.getLong(0);
                    if (j5 == j3) {
                        return d.d.a.a.c.a(byteBufferAllocate2, Long.valueOf(j4));
                    }
                    throw new c("APK Signing Block sizes in header and footer do not match: " + j5 + " vs " + j3);
                }
                throw new c("APK Signing Block offset out of range: " + j4);
            }
            throw new c("No APK Signing Block before ZIP Central Directory");
        }
        throw new c("APK too small for APK Signing Block. ZIP Central Directory offset: " + j2);
    }

    public static void a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }
}
