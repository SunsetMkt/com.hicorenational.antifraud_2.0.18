package org.tensorflow.lite;

import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class Tensor {

    /* renamed from: a */
    private long f21679a;

    /* renamed from: b */
    private final EnumC6075a f21680b;

    /* renamed from: c */
    private int[] f21681c;

    static {
        TensorFlowLite.m25136a();
    }

    private Tensor(long j2) {
        this.f21679a = j2;
        this.f21680b = EnumC6075a.fromC(dtype(j2));
        this.f21681c = shape(j2);
    }

    /* renamed from: a */
    static Tensor m25115a(long j2, int i2) {
        return new Tensor(create(j2, i2));
    }

    private static native ByteBuffer buffer(long j2);

    private static native long create(long j2, int i2);

    private static native void delete(long j2);

    private static native int dtype(long j2);

    private static native boolean hasDelegateBufferHandle(long j2);

    /* renamed from: i */
    private void m25123i(Object obj) {
        if (m25120g(obj)) {
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            if (byteBuffer.capacity() != m25131d()) {
                throw new IllegalArgumentException(String.format("Cannot convert between a TensorFlowLite buffer with %d bytes and a ByteBuffer with %d bytes.", Integer.valueOf(m25131d()), Integer.valueOf(byteBuffer.capacity())));
            }
        } else {
            int[] m25118e = m25118e(obj);
            if (!Arrays.equals(m25118e, this.f21681c)) {
                throw new IllegalArgumentException(String.format("Cannot copy between a TensorFlowLite tensor with shape %s and a Java object with shape %s.", Arrays.toString(this.f21681c), Arrays.toString(m25118e)));
            }
        }
    }

    private static native int index(long j2);

    /* renamed from: j */
    private void m25124j(Object obj) {
        EnumC6075a m25119f;
        EnumC6075a enumC6075a;
        if (!m25120g(obj) && (m25119f = m25119f(obj)) != (enumC6075a = this.f21680b)) {
            throw new IllegalArgumentException(String.format("Cannot convert between a TensorFlowLite tensor with type %s and a Java object of type %s (which is compatible with the TensorFlowLite type %s).", enumC6075a, obj.getClass().getName(), m25119f));
        }
    }

    private static native int numBytes(long j2);

    private static native void readMultiDimensionalArray(long j2, Object obj);

    private static native int[] shape(long j2);

    private static native void writeDirectBuffer(long j2, ByteBuffer byteBuffer);

    private static native void writeMultiDimensionalArray(long j2, Object obj);

    /* renamed from: b */
    public EnumC6075a m25127b() {
        return this.f21680b;
    }

    /* renamed from: c */
    public int m25129c() {
        return index(this.f21679a);
    }

    /* renamed from: d */
    public int m25131d() {
        return numBytes(this.f21679a);
    }

    /* renamed from: e */
    public int m25132e() {
        return this.f21681c.length;
    }

    /* renamed from: f */
    public int m25133f() {
        return m25114a(this.f21681c);
    }

    /* renamed from: g */
    void m25134g() {
        this.f21681c = shape(this.f21679a);
    }

    /* renamed from: h */
    public int[] m25135h() {
        return this.f21681c;
    }

    /* renamed from: d */
    static int m25117d(Object obj) {
        if (obj == null || !obj.getClass().isArray()) {
            return 0;
        }
        if (Array.getLength(obj) != 0) {
            return m25117d(Array.get(obj, 0)) + 1;
        }
        throw new IllegalArgumentException("Array lengths cannot be 0.");
    }

    /* renamed from: e */
    static int[] m25118e(Object obj) {
        int[] iArr = new int[m25117d(obj)];
        m25116a(obj, 0, iArr);
        return iArr;
    }

    /* renamed from: f */
    static EnumC6075a m25119f(Object obj) {
        if (obj != null) {
            Class<?> cls = obj.getClass();
            while (cls.isArray()) {
                cls = cls.getComponentType();
            }
            if (Float.TYPE.equals(cls)) {
                return EnumC6075a.FLOAT32;
            }
            if (Integer.TYPE.equals(cls)) {
                return EnumC6075a.INT32;
            }
            if (Byte.TYPE.equals(cls)) {
                return EnumC6075a.UINT8;
            }
            if (Long.TYPE.equals(cls)) {
                return EnumC6075a.INT64;
            }
            if (String.class.equals(cls)) {
                return EnumC6075a.STRING;
            }
        }
        throw new IllegalArgumentException("DataType error: cannot resolve DataType of " + obj.getClass().getName());
    }

    /* renamed from: g */
    private static boolean m25120g(Object obj) {
        return obj instanceof ByteBuffer;
    }

    /* renamed from: h */
    private void m25121h(Object obj) {
        m25124j(obj);
        m25123i(obj);
    }

    /* renamed from: a */
    void m25126a() {
        delete(this.f21679a);
        this.f21679a = 0L;
    }

    /* renamed from: b */
    int[] m25128b(Object obj) {
        if (obj == null || m25120g(obj)) {
            return null;
        }
        m25124j(obj);
        int[] m25118e = m25118e(obj);
        if (Arrays.equals(this.f21681c, m25118e)) {
            return null;
        }
        return m25118e;
    }

    /* renamed from: c */
    void m25130c(Object obj) {
        if (obj == null) {
            if (!hasDelegateBufferHandle(this.f21679a)) {
                throw new IllegalArgumentException("Null inputs are allowed only if the Tensor is bound to a buffer handle.");
            }
            return;
        }
        m25121h(obj);
        if (!m25120g(obj)) {
            writeMultiDimensionalArray(this.f21679a, obj);
            return;
        }
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        if (byteBuffer.isDirect() && byteBuffer.order() == ByteOrder.nativeOrder()) {
            writeDirectBuffer(this.f21679a, byteBuffer);
        } else {
            m25122i().put(byteBuffer);
        }
    }

    /* renamed from: a */
    Object m25125a(Object obj) {
        if (obj == null) {
            if (hasDelegateBufferHandle(this.f21679a)) {
                return obj;
            }
            throw new IllegalArgumentException("Null outputs are allowed only if the Tensor is bound to a buffer handle.");
        }
        m25121h(obj);
        if (obj instanceof ByteBuffer) {
            ((ByteBuffer) obj).put(m25122i());
            return obj;
        }
        readMultiDimensionalArray(this.f21679a, obj);
        return obj;
    }

    /* renamed from: a */
    static int m25114a(int[] iArr) {
        int i2 = 1;
        for (int i3 : iArr) {
            i2 *= i3;
        }
        return i2;
    }

    /* renamed from: i */
    private ByteBuffer m25122i() {
        return buffer(this.f21679a).order(ByteOrder.nativeOrder());
    }

    /* renamed from: a */
    static void m25116a(Object obj, int i2, int[] iArr) {
        if (iArr == null || i2 == iArr.length) {
            return;
        }
        int length = Array.getLength(obj);
        if (iArr[i2] == 0) {
            iArr[i2] = length;
        } else if (iArr[i2] != length) {
            throw new IllegalArgumentException(String.format("Mismatched lengths (%d and %d) in dimension %d", Integer.valueOf(iArr[i2]), Integer.valueOf(length), Integer.valueOf(i2)));
        }
        for (int i3 = 0; i3 < length; i3++) {
            m25116a(Array.get(obj, i3), i2 + 1, iArr);
        }
    }
}
