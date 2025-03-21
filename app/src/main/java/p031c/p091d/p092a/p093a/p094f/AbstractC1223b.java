package p031c.p091d.p092a.p093a.p094f;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import p031c.p091d.p092a.p093a.C1219c;
import p286h.C5611t1;

/* compiled from: ZipUtils.java */
/* renamed from: c.d.a.a.f.b */
/* loaded from: classes.dex */
public abstract class AbstractC1223b {

    /* renamed from: a */
    public static final int f2696a = 22;

    /* renamed from: b */
    private static final int f2697b = 101010256;

    /* renamed from: c */
    private static final int f2698c = 12;

    /* renamed from: d */
    private static final int f2699d = 16;

    /* renamed from: e */
    private static final int f2700e = 20;

    /* renamed from: f */
    private static final int f2701f = 20;

    /* renamed from: g */
    private static final int f2702g = 1347094023;

    /* renamed from: h */
    private static final int f2703h = 65535;

    private AbstractC1223b() {
    }

    /* renamed from: a */
    static C1219c<ByteBuffer, Long> m2411a(RandomAccessFile randomAccessFile) throws IOException {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        C1219c<ByteBuffer, Long> m2412a = m2412a(randomAccessFile, 0);
        return m2412a != null ? m2412a : m2412a(randomAccessFile, 65535);
    }

    /* renamed from: b */
    private static int m2417b(ByteBuffer byteBuffer) {
        m2413a(byteBuffer);
        int capacity = byteBuffer.capacity();
        if (capacity < 22) {
            return -1;
        }
        int i2 = capacity - 22;
        int min = Math.min(i2, 65535);
        for (int i3 = 0; i3 < min; i3++) {
            int i4 = i2 - i3;
            if (byteBuffer.getInt(i4) == f2697b && m2410a(byteBuffer, i4 + 20) == i3) {
                return i4;
            }
        }
        return -1;
    }

    /* renamed from: c */
    public static long m2419c(ByteBuffer byteBuffer) {
        m2413a(byteBuffer);
        return m2418b(byteBuffer, byteBuffer.position() + 16);
    }

    /* renamed from: d */
    public static long m2420d(ByteBuffer byteBuffer) {
        m2413a(byteBuffer);
        return m2418b(byteBuffer, byteBuffer.position() + 12);
    }

    /* renamed from: a */
    private static C1219c<ByteBuffer, Long> m2412a(RandomAccessFile randomAccessFile, int i2) throws IOException {
        if (i2 >= 0 && i2 <= 65535) {
            long length = randomAccessFile.length();
            if (length < 22) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(((int) Math.min(i2, length - 22)) + 22);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            long capacity = length - allocate.capacity();
            randomAccessFile.seek(capacity);
            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
            int m2417b = m2417b(allocate);
            if (m2417b == -1) {
                return null;
            }
            allocate.position(m2417b);
            ByteBuffer slice = allocate.slice();
            slice.order(ByteOrder.LITTLE_ENDIAN);
            return C1219c.m2368a(slice, Long.valueOf(capacity + m2417b));
        }
        throw new IllegalArgumentException("maxCommentSize: " + i2);
    }

    /* renamed from: b */
    public static long m2418b(ByteBuffer byteBuffer, int i2) {
        return byteBuffer.getInt(i2) & 4294967295L;
    }

    /* renamed from: a */
    public static final boolean m2416a(RandomAccessFile randomAccessFile, long j2) throws IOException {
        long j3 = j2 - 20;
        if (j3 < 0) {
            return false;
        }
        randomAccessFile.seek(j3);
        return randomAccessFile.readInt() == f2702g;
    }

    /* renamed from: a */
    public static void m2415a(ByteBuffer byteBuffer, long j2) {
        m2413a(byteBuffer);
        m2414a(byteBuffer, byteBuffer.position() + 16, j2);
    }

    /* renamed from: a */
    public static void m2413a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    /* renamed from: a */
    public static int m2410a(ByteBuffer byteBuffer, int i2) {
        return byteBuffer.getShort(i2) & C5611t1.f20467c;
    }

    /* renamed from: a */
    private static void m2414a(ByteBuffer byteBuffer, int i2, long j2) {
        if (j2 >= 0 && j2 <= 4294967295L) {
            byteBuffer.putInt(byteBuffer.position() + i2, (int) j2);
            return;
        }
        throw new IllegalArgumentException("uint32 value of out range: " + j2);
    }
}
