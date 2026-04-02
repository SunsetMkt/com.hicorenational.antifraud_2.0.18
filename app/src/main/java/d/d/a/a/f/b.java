package d.d.a.a.f;

import d.d.a.a.c;
import i.t1;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: ZipUtils.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static final int a = 22;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f10129b = 101010256;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f10130c = 12;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f10131d = 16;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f10132e = 20;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f10133f = 20;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f10134g = 1347094023;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f10135h = 65535;

    private b() {
    }

    static c<ByteBuffer, Long> a(RandomAccessFile randomAccessFile) throws IOException {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        c<ByteBuffer, Long> cVarA = a(randomAccessFile, 0);
        return cVarA != null ? cVarA : a(randomAccessFile, 65535);
    }

    private static int b(ByteBuffer byteBuffer) {
        a(byteBuffer);
        int iCapacity = byteBuffer.capacity();
        if (iCapacity < 22) {
            return -1;
        }
        int i2 = iCapacity - 22;
        int iMin = Math.min(i2, 65535);
        for (int i3 = 0; i3 < iMin; i3++) {
            int i4 = i2 - i3;
            if (byteBuffer.getInt(i4) == f10129b && a(byteBuffer, i4 + 20) == i3) {
                return i4;
            }
        }
        return -1;
    }

    public static long c(ByteBuffer byteBuffer) {
        a(byteBuffer);
        return b(byteBuffer, byteBuffer.position() + 16);
    }

    public static long d(ByteBuffer byteBuffer) {
        a(byteBuffer);
        return b(byteBuffer, byteBuffer.position() + 12);
    }

    private static c<ByteBuffer, Long> a(RandomAccessFile randomAccessFile, int i2) throws IOException {
        if (i2 >= 0 && i2 <= 65535) {
            long length = randomAccessFile.length();
            if (length < 22) {
                return null;
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(((int) Math.min(i2, length - 22)) + 22);
            byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
            long jCapacity = length - ((long) byteBufferAllocate.capacity());
            randomAccessFile.seek(jCapacity);
            randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
            int iB = b(byteBufferAllocate);
            if (iB == -1) {
                return null;
            }
            byteBufferAllocate.position(iB);
            ByteBuffer byteBufferSlice = byteBufferAllocate.slice();
            byteBufferSlice.order(ByteOrder.LITTLE_ENDIAN);
            return c.a(byteBufferSlice, Long.valueOf(jCapacity + ((long) iB)));
        }
        throw new IllegalArgumentException("maxCommentSize: " + i2);
    }

    public static long b(ByteBuffer byteBuffer, int i2) {
        return ((long) byteBuffer.getInt(i2)) & 4294967295L;
    }

    public static final boolean a(RandomAccessFile randomAccessFile, long j2) throws IOException {
        long j3 = j2 - 20;
        if (j3 < 0) {
            return false;
        }
        randomAccessFile.seek(j3);
        return randomAccessFile.readInt() == f10134g;
    }

    public static void a(ByteBuffer byteBuffer, long j2) {
        a(byteBuffer);
        a(byteBuffer, byteBuffer.position() + 16, j2);
    }

    public static void a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static int a(ByteBuffer byteBuffer, int i2) {
        return byteBuffer.getShort(i2) & t1.f12275c;
    }

    private static void a(ByteBuffer byteBuffer, int i2, long j2) {
        if (j2 >= 0 && j2 <= 4294967295L) {
            byteBuffer.putInt(byteBuffer.position() + i2, (int) j2);
            return;
        }
        throw new IllegalArgumentException("uint32 value of out range: " + j2);
    }
}
