package org.tensorflow.lite;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.tensorflow.lite.c;

/* JADX INFO: loaded from: classes2.dex */
final class NativeInterpreterWrapper implements AutoCloseable {

    /* JADX INFO: renamed from: l */
    private static final int f12997l = 512;
    private long a;

    /* JADX INFO: renamed from: b */
    private long f12998b;

    /* JADX INFO: renamed from: c */
    private long f12999c;

    /* JADX INFO: renamed from: d */
    private long f13000d;

    /* JADX INFO: renamed from: e */
    private ByteBuffer f13001e;

    /* JADX INFO: renamed from: f */
    private Map<String, Integer> f13002f;

    /* JADX INFO: renamed from: g */
    private Map<String, Integer> f13003g;

    /* JADX INFO: renamed from: h */
    private Tensor[] f13004h;

    /* JADX INFO: renamed from: i */
    private Tensor[] f13005i;

    /* JADX INFO: renamed from: j */
    private boolean f13006j;

    /* JADX INFO: renamed from: k */
    private final List<b> f13007k;

    static {
        TensorFlowLite.a();
    }

    NativeInterpreterWrapper(String str) {
        this(str, (c.a) null);
    }

    private void a(long j2, long j3, c.a aVar) {
        if (aVar == null) {
            aVar = new c.a();
        }
        this.a = j2;
        this.f12999c = j3;
        this.f12998b = createInterpreter(j3, j2, aVar.a);
        this.f13004h = new Tensor[getInputCount(this.f12998b)];
        this.f13005i = new Tensor[getOutputCount(this.f12998b)];
        Boolean bool = aVar.f13012b;
        if (bool != null) {
            a(bool.booleanValue());
        }
        Boolean bool2 = aVar.f13013c;
        if (bool2 != null) {
            allowFp16PrecisionForFp32(this.f12998b, bool2.booleanValue());
        }
        Boolean bool3 = aVar.f13014d;
        if (bool3 != null) {
            allowBufferHandleOutput(this.f12998b, bool3.booleanValue());
        }
        for (b bVar : aVar.f13015e) {
            applyDelegate(this.f12998b, j2, bVar.c());
            this.f13007k.add(bVar);
        }
        allocateTensors(this.f12998b, j2);
        this.f13006j = true;
    }

    private static native long allocateTensors(long j2, long j3);

    private static native void allowBufferHandleOutput(long j2, boolean z);

    private static native void allowFp16PrecisionForFp32(long j2, boolean z);

    private static native void applyDelegate(long j2, long j3, long j4);

    private static native long createErrorReporter(int i2);

    private static native long createInterpreter(long j2, long j3, int i2);

    private static native long createModel(String str, long j2);

    private static native long createModelWithBuffer(ByteBuffer byteBuffer, long j2);

    private static native void delete(long j2, long j3, long j4);

    private static native int getInputCount(long j2);

    private static native String[] getInputNames(long j2);

    private static native int getInputTensorIndex(long j2, int i2);

    private static native int getOutputCount(long j2);

    private static native int getOutputDataType(long j2, int i2);

    private static native String[] getOutputNames(long j2);

    private static native float getOutputQuantizationScale(long j2, int i2);

    private static native int getOutputQuantizationZeroPoint(long j2, int i2);

    private static native int getOutputTensorIndex(long j2, int i2);

    private static native void numThreads(long j2, int i2);

    private static native boolean resizeInput(long j2, long j3, int i2, int[] iArr);

    private static native void run(long j2, long j3);

    private static native void useNNAPI(long j2, boolean z);

    int b(String str) {
        if (this.f13003g == null) {
            String[] outputNames = getOutputNames(this.f12998b);
            this.f13003g = new HashMap();
            if (outputNames != null) {
                for (int i2 = 0; i2 < outputNames.length; i2++) {
                    this.f13003g.put(outputNames[i2], Integer.valueOf(i2));
                }
            }
        }
        if (this.f13003g.containsKey(str)) {
            return this.f13003g.get(str).intValue();
        }
        throw new IllegalArgumentException(String.format("Input error: '%s' is not a valid name for any output. Names of outputs and their indexes are %s", str, this.f13003g.toString()));
    }

    int c(int i2) {
        return getOutputQuantizationZeroPoint(this.f12998b, i2);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        int i2 = 0;
        while (true) {
            Tensor[] tensorArr = this.f13004h;
            if (i2 >= tensorArr.length) {
                break;
            }
            if (tensorArr[i2] != null) {
                tensorArr[i2].a();
                this.f13004h[i2] = null;
            }
            i2++;
        }
        int i3 = 0;
        while (true) {
            Tensor[] tensorArr2 = this.f13005i;
            if (i3 >= tensorArr2.length) {
                delete(this.a, this.f12999c, this.f12998b);
                this.a = 0L;
                this.f12999c = 0L;
                this.f12998b = 0L;
                this.f13001e = null;
                this.f13002f = null;
                this.f13003g = null;
                this.f13006j = false;
                this.f13007k.clear();
                return;
            }
            if (tensorArr2[i3] != null) {
                tensorArr2[i3].a();
                this.f13005i[i3] = null;
            }
            i3++;
        }
    }

    Long d() {
        long j2 = this.f13000d;
        if (j2 < 0) {
            return null;
        }
        return Long.valueOf(j2);
    }

    void e(int i2) {
        numThreads(this.f12998b, i2);
    }

    NativeInterpreterWrapper(String str, c.a aVar) {
        this.f13000d = -1L;
        this.f13006j = false;
        this.f13007k = new ArrayList();
        long jCreateErrorReporter = createErrorReporter(512);
        a(jCreateErrorReporter, createModel(str, jCreateErrorReporter), aVar);
    }

    int c() {
        return this.f13004h.length;
    }

    Tensor d(int i2) {
        if (i2 >= 0) {
            Tensor[] tensorArr = this.f13005i;
            if (i2 < tensorArr.length) {
                Tensor tensor = tensorArr[i2];
                if (tensor != null) {
                    return tensor;
                }
                long j2 = this.f12998b;
                Tensor tensorA = Tensor.a(j2, getOutputTensorIndex(j2, i2));
                tensorArr[i2] = tensorA;
                return tensorA;
            }
        }
        throw new IllegalArgumentException("Invalid output Tensor index: " + i2);
    }

    int e() {
        return this.f13005i.length;
    }

    NativeInterpreterWrapper(ByteBuffer byteBuffer) {
        this(byteBuffer, (c.a) null);
    }

    NativeInterpreterWrapper(ByteBuffer byteBuffer, c.a aVar) {
        this.f13000d = -1L;
        this.f13006j = false;
        this.f13007k = new ArrayList();
        if (byteBuffer != null && ((byteBuffer instanceof MappedByteBuffer) || (byteBuffer.isDirect() && byteBuffer.order() == ByteOrder.nativeOrder()))) {
            this.f13001e = byteBuffer;
            long jCreateErrorReporter = createErrorReporter(512);
            a(jCreateErrorReporter, createModelWithBuffer(this.f13001e, jCreateErrorReporter), aVar);
            return;
        }
        throw new IllegalArgumentException("Model ByteBuffer should be either a MappedByteBuffer of the model file, or a direct ByteBuffer using ByteOrder.nativeOrder() which contains bytes of model content.");
    }

    float b(int i2) {
        return getOutputQuantizationScale(this.f12998b, i2);
    }

    void a(Object[] objArr, Map<Integer, Object> map) {
        this.f13000d = -1L;
        if (objArr != null && objArr.length != 0) {
            if (map != null && !map.isEmpty()) {
                int i2 = 0;
                for (int i3 = 0; i3 < objArr.length; i3++) {
                    int[] iArrB = a(i3).b(objArr[i3]);
                    if (iArrB != null) {
                        a(i3, iArrB);
                    }
                }
                boolean z = !this.f13006j;
                if (z) {
                    allocateTensors(this.f12998b, this.a);
                    this.f13006j = true;
                }
                for (int i4 = 0; i4 < objArr.length; i4++) {
                    a(i4).c(objArr[i4]);
                }
                long jNanoTime = System.nanoTime();
                run(this.f12998b, this.a);
                long jNanoTime2 = System.nanoTime() - jNanoTime;
                if (z) {
                    while (true) {
                        Tensor[] tensorArr = this.f13005i;
                        if (i2 >= tensorArr.length) {
                            break;
                        }
                        if (tensorArr[i2] != null) {
                            tensorArr[i2].g();
                        }
                        i2++;
                    }
                }
                for (Map.Entry<Integer, Object> entry : map.entrySet()) {
                    d(entry.getKey().intValue()).a(entry.getValue());
                }
                this.f13000d = jNanoTime2;
                return;
            }
            throw new IllegalArgumentException("Input error: Outputs should not be null or empty.");
        }
        throw new IllegalArgumentException("Input error: Inputs should not be null or empty.");
    }

    void a(int i2, int[] iArr) {
        if (resizeInput(this.f12998b, this.a, i2, iArr)) {
            this.f13006j = false;
            Tensor[] tensorArr = this.f13004h;
            if (tensorArr[i2] != null) {
                tensorArr[i2].g();
            }
        }
    }

    void a(boolean z) {
        useNNAPI(this.f12998b, z);
    }

    void a(b bVar) {
        applyDelegate(this.f12998b, this.a, bVar.c());
        this.f13007k.add(bVar);
    }

    int a(String str) {
        if (this.f13002f == null) {
            String[] inputNames = getInputNames(this.f12998b);
            this.f13002f = new HashMap();
            if (inputNames != null) {
                for (int i2 = 0; i2 < inputNames.length; i2++) {
                    this.f13002f.put(inputNames[i2], Integer.valueOf(i2));
                }
            }
        }
        if (this.f13002f.containsKey(str)) {
            return this.f13002f.get(str).intValue();
        }
        throw new IllegalArgumentException(String.format("Input error: '%s' is not a valid name for any input. Names of inputs and their indexes are %s", str, this.f13002f.toString()));
    }

    Tensor a(int i2) {
        if (i2 >= 0) {
            Tensor[] tensorArr = this.f13004h;
            if (i2 < tensorArr.length) {
                Tensor tensor = tensorArr[i2];
                if (tensor != null) {
                    return tensor;
                }
                long j2 = this.f12998b;
                Tensor tensorA = Tensor.a(j2, getInputTensorIndex(j2, i2));
                tensorArr[i2] = tensorA;
                return tensorA;
            }
        }
        throw new IllegalArgumentException("Invalid input Tensor index: " + i2);
    }
}
