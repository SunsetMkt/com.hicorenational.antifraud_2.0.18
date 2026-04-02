package org.tensorflow.lite;

import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class Tensor {
    private long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f13008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int[] f13009c;

    static {
        TensorFlowLite.a();
    }

    private Tensor(long j2) {
        this.a = j2;
        this.f13008b = a.fromC(dtype(j2));
        this.f13009c = shape(j2);
    }

    static Tensor a(long j2, int i2) {
        return new Tensor(create(j2, i2));
    }

    private static native ByteBuffer buffer(long j2);

    private static native long create(long j2, int i2);

    private static native void delete(long j2);

    private static native int dtype(long j2);

    private static native boolean hasDelegateBufferHandle(long j2);

    private void i(Object obj) {
        if (g(obj)) {
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            if (byteBuffer.capacity() != d()) {
                throw new IllegalArgumentException(String.format("Cannot convert between a TensorFlowLite buffer with %d bytes and a ByteBuffer with %d bytes.", Integer.valueOf(d()), Integer.valueOf(byteBuffer.capacity())));
            }
        } else {
            int[] iArrE = e(obj);
            if (!Arrays.equals(iArrE, this.f13009c)) {
                throw new IllegalArgumentException(String.format("Cannot copy between a TensorFlowLite tensor with shape %s and a Java object with shape %s.", Arrays.toString(this.f13009c), Arrays.toString(iArrE)));
            }
        }
    }

    private static native int index(long j2);

    private void j(Object obj) {
        a aVarF;
        a aVar;
        if (!g(obj) && (aVarF = f(obj)) != (aVar = this.f13008b)) {
            throw new IllegalArgumentException(String.format("Cannot convert between a TensorFlowLite tensor with type %s and a Java object of type %s (which is compatible with the TensorFlowLite type %s).", aVar, obj.getClass().getName(), aVarF));
        }
    }

    private static native int numBytes(long j2);

    private static native void readMultiDimensionalArray(long j2, Object obj);

    private static native int[] shape(long j2);

    private static native void writeDirectBuffer(long j2, ByteBuffer byteBuffer);

    private static native void writeMultiDimensionalArray(long j2, Object obj);

    public a b() {
        return this.f13008b;
    }

    public int c() {
        return index(this.a);
    }

    public int d() {
        return numBytes(this.a);
    }

    public int e() {
        return this.f13009c.length;
    }

    public int f() {
        return a(this.f13009c);
    }

    void g() {
        this.f13009c = shape(this.a);
    }

    public int[] h() {
        return this.f13009c;
    }

    static int d(Object obj) {
        if (obj == null || !obj.getClass().isArray()) {
            return 0;
        }
        if (Array.getLength(obj) != 0) {
            return d(Array.get(obj, 0)) + 1;
        }
        throw new IllegalArgumentException("Array lengths cannot be 0.");
    }

    static int[] e(Object obj) {
        int[] iArr = new int[d(obj)];
        a(obj, 0, iArr);
        return iArr;
    }

    static a f(Object obj) {
        if (obj != null) {
            Class<?> componentType = obj.getClass();
            while (componentType.isArray()) {
                componentType = componentType.getComponentType();
            }
            if (Float.TYPE.equals(componentType)) {
                return a.FLOAT32;
            }
            if (Integer.TYPE.equals(componentType)) {
                return a.INT32;
            }
            if (Byte.TYPE.equals(componentType)) {
                return a.UINT8;
            }
            if (Long.TYPE.equals(componentType)) {
                return a.INT64;
            }
            if (String.class.equals(componentType)) {
                return a.STRING;
            }
        }
        throw new IllegalArgumentException("DataType error: cannot resolve DataType of " + obj.getClass().getName());
    }

    private static boolean g(Object obj) {
        return obj instanceof ByteBuffer;
    }

    private void h(Object obj) {
        j(obj);
        i(obj);
    }

    void a() {
        delete(this.a);
        this.a = 0L;
    }

    int[] b(Object obj) {
        if (obj == null || g(obj)) {
            return null;
        }
        j(obj);
        int[] iArrE = e(obj);
        if (Arrays.equals(this.f13009c, iArrE)) {
            return null;
        }
        return iArrE;
    }

    void c(Object obj) {
        if (obj == null) {
            if (!hasDelegateBufferHandle(this.a)) {
                throw new IllegalArgumentException("Null inputs are allowed only if the Tensor is bound to a buffer handle.");
            }
            return;
        }
        h(obj);
        if (!g(obj)) {
            writeMultiDimensionalArray(this.a, obj);
            return;
        }
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        if (byteBuffer.isDirect() && byteBuffer.order() == ByteOrder.nativeOrder()) {
            writeDirectBuffer(this.a, byteBuffer);
        } else {
            i().put(byteBuffer);
        }
    }

    Object a(Object obj) {
        if (obj == null) {
            if (hasDelegateBufferHandle(this.a)) {
                return obj;
            }
            throw new IllegalArgumentException("Null outputs are allowed only if the Tensor is bound to a buffer handle.");
        }
        h(obj);
        if (obj instanceof ByteBuffer) {
            ((ByteBuffer) obj).put(i());
            return obj;
        }
        readMultiDimensionalArray(this.a, obj);
        return obj;
    }

    static int a(int[] iArr) {
        int i2 = 1;
        for (int i3 : iArr) {
            i2 *= i3;
        }
        return i2;
    }

    private ByteBuffer i() {
        return buffer(this.a).order(ByteOrder.nativeOrder());
    }

    static void a(Object obj, int i2, int[] iArr) {
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
            a(Array.get(obj, i3), i2 + 1, iArr);
        }
    }
}
