package org.tensorflow.lite;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.tensorflow.lite.C6077c;

/* loaded from: classes2.dex */
final class NativeInterpreterWrapper implements AutoCloseable {

    /* renamed from: l */
    private static final int f21667l = 512;

    /* renamed from: a */
    private long f21668a;

    /* renamed from: b */
    private long f21669b;

    /* renamed from: c */
    private long f21670c;

    /* renamed from: d */
    private long f21671d;

    /* renamed from: e */
    private ByteBuffer f21672e;

    /* renamed from: f */
    private Map<String, Integer> f21673f;

    /* renamed from: g */
    private Map<String, Integer> f21674g;

    /* renamed from: h */
    private Tensor[] f21675h;

    /* renamed from: i */
    private Tensor[] f21676i;

    /* renamed from: j */
    private boolean f21677j;

    /* renamed from: k */
    private final List<InterfaceC6076b> f21678k;

    static {
        TensorFlowLite.m25136a();
    }

    NativeInterpreterWrapper(String str) {
        this(str, (C6077c.a) null);
    }

    /* renamed from: a */
    private void m25099a(long j2, long j3, C6077c.a aVar) {
        if (aVar == null) {
            aVar = new C6077c.a();
        }
        this.f21668a = j2;
        this.f21670c = j3;
        this.f21669b = createInterpreter(j3, j2, aVar.f21688a);
        this.f21675h = new Tensor[getInputCount(this.f21669b)];
        this.f21676i = new Tensor[getOutputCount(this.f21669b)];
        Boolean bool = aVar.f21689b;
        if (bool != null) {
            m25104a(bool.booleanValue());
        }
        Boolean bool2 = aVar.f21690c;
        if (bool2 != null) {
            allowFp16PrecisionForFp32(this.f21669b, bool2.booleanValue());
        }
        Boolean bool3 = aVar.f21691d;
        if (bool3 != null) {
            allowBufferHandleOutput(this.f21669b, bool3.booleanValue());
        }
        for (InterfaceC6076b interfaceC6076b : aVar.f21692e) {
            applyDelegate(this.f21669b, j2, interfaceC6076b.mo25139c());
            this.f21678k.add(interfaceC6076b);
        }
        allocateTensors(this.f21669b, j2);
        this.f21677j = true;
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

    /* renamed from: b */
    int m25107b(String str) {
        if (this.f21674g == null) {
            String[] outputNames = getOutputNames(this.f21669b);
            this.f21674g = new HashMap();
            if (outputNames != null) {
                for (int i2 = 0; i2 < outputNames.length; i2++) {
                    this.f21674g.put(outputNames[i2], Integer.valueOf(i2));
                }
            }
        }
        if (this.f21674g.containsKey(str)) {
            return this.f21674g.get(str).intValue();
        }
        throw new IllegalArgumentException(String.format("Input error: '%s' is not a valid name for any output. Names of outputs and their indexes are %s", str, this.f21674g.toString()));
    }

    /* renamed from: c */
    int m25109c(int i2) {
        return getOutputQuantizationZeroPoint(this.f21669b, i2);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        int i2 = 0;
        while (true) {
            Tensor[] tensorArr = this.f21675h;
            if (i2 >= tensorArr.length) {
                break;
            }
            if (tensorArr[i2] != null) {
                tensorArr[i2].m25126a();
                this.f21675h[i2] = null;
            }
            i2++;
        }
        int i3 = 0;
        while (true) {
            Tensor[] tensorArr2 = this.f21676i;
            if (i3 >= tensorArr2.length) {
                delete(this.f21668a, this.f21670c, this.f21669b);
                this.f21668a = 0L;
                this.f21670c = 0L;
                this.f21669b = 0L;
                this.f21672e = null;
                this.f21673f = null;
                this.f21674g = null;
                this.f21677j = false;
                this.f21678k.clear();
                return;
            }
            if (tensorArr2[i3] != null) {
                tensorArr2[i3].m25126a();
                this.f21676i[i3] = null;
            }
            i3++;
        }
    }

    /* renamed from: d */
    Long m25110d() {
        long j2 = this.f21671d;
        if (j2 < 0) {
            return null;
        }
        return Long.valueOf(j2);
    }

    /* renamed from: e */
    void m25113e(int i2) {
        numThreads(this.f21669b, i2);
    }

    NativeInterpreterWrapper(String str, C6077c.a aVar) {
        this.f21671d = -1L;
        this.f21677j = false;
        this.f21678k = new ArrayList();
        long createErrorReporter = createErrorReporter(512);
        m25099a(createErrorReporter, createModel(str, createErrorReporter), aVar);
    }

    /* renamed from: c */
    int m25108c() {
        return this.f21675h.length;
    }

    /* renamed from: d */
    Tensor m25111d(int i2) {
        if (i2 >= 0) {
            Tensor[] tensorArr = this.f21676i;
            if (i2 < tensorArr.length) {
                Tensor tensor = tensorArr[i2];
                if (tensor != null) {
                    return tensor;
                }
                long j2 = this.f21669b;
                Tensor m25115a = Tensor.m25115a(j2, getOutputTensorIndex(j2, i2));
                tensorArr[i2] = m25115a;
                return m25115a;
            }
        }
        throw new IllegalArgumentException("Invalid output Tensor index: " + i2);
    }

    /* renamed from: e */
    int m25112e() {
        return this.f21676i.length;
    }

    NativeInterpreterWrapper(ByteBuffer byteBuffer) {
        this(byteBuffer, (C6077c.a) null);
    }

    NativeInterpreterWrapper(ByteBuffer byteBuffer, C6077c.a aVar) {
        this.f21671d = -1L;
        this.f21677j = false;
        this.f21678k = new ArrayList();
        if (byteBuffer != null && ((byteBuffer instanceof MappedByteBuffer) || (byteBuffer.isDirect() && byteBuffer.order() == ByteOrder.nativeOrder()))) {
            this.f21672e = byteBuffer;
            long createErrorReporter = createErrorReporter(512);
            m25099a(createErrorReporter, createModelWithBuffer(this.f21672e, createErrorReporter), aVar);
            return;
        }
        throw new IllegalArgumentException("Model ByteBuffer should be either a MappedByteBuffer of the model file, or a direct ByteBuffer using ByteOrder.nativeOrder() which contains bytes of model content.");
    }

    /* renamed from: b */
    float m25106b(int i2) {
        return getOutputQuantizationScale(this.f21669b, i2);
    }

    /* renamed from: a */
    void m25105a(Object[] objArr, Map<Integer, Object> map) {
        this.f21671d = -1L;
        if (objArr != null && objArr.length != 0) {
            if (map != null && !map.isEmpty()) {
                int i2 = 0;
                for (int i3 = 0; i3 < objArr.length; i3++) {
                    int[] m25128b = m25101a(i3).m25128b(objArr[i3]);
                    if (m25128b != null) {
                        m25102a(i3, m25128b);
                    }
                }
                boolean z = !this.f21677j;
                if (z) {
                    allocateTensors(this.f21669b, this.f21668a);
                    this.f21677j = true;
                }
                for (int i4 = 0; i4 < objArr.length; i4++) {
                    m25101a(i4).m25130c(objArr[i4]);
                }
                long nanoTime = System.nanoTime();
                run(this.f21669b, this.f21668a);
                long nanoTime2 = System.nanoTime() - nanoTime;
                if (z) {
                    while (true) {
                        Tensor[] tensorArr = this.f21676i;
                        if (i2 >= tensorArr.length) {
                            break;
                        }
                        if (tensorArr[i2] != null) {
                            tensorArr[i2].m25134g();
                        }
                        i2++;
                    }
                }
                for (Map.Entry<Integer, Object> entry : map.entrySet()) {
                    m25111d(entry.getKey().intValue()).m25125a(entry.getValue());
                }
                this.f21671d = nanoTime2;
                return;
            }
            throw new IllegalArgumentException("Input error: Outputs should not be null or empty.");
        }
        throw new IllegalArgumentException("Input error: Inputs should not be null or empty.");
    }

    /* renamed from: a */
    void m25102a(int i2, int[] iArr) {
        if (resizeInput(this.f21669b, this.f21668a, i2, iArr)) {
            this.f21677j = false;
            Tensor[] tensorArr = this.f21675h;
            if (tensorArr[i2] != null) {
                tensorArr[i2].m25134g();
            }
        }
    }

    /* renamed from: a */
    void m25104a(boolean z) {
        useNNAPI(this.f21669b, z);
    }

    /* renamed from: a */
    void m25103a(InterfaceC6076b interfaceC6076b) {
        applyDelegate(this.f21669b, this.f21668a, interfaceC6076b.mo25139c());
        this.f21678k.add(interfaceC6076b);
    }

    /* renamed from: a */
    int m25100a(String str) {
        if (this.f21673f == null) {
            String[] inputNames = getInputNames(this.f21669b);
            this.f21673f = new HashMap();
            if (inputNames != null) {
                for (int i2 = 0; i2 < inputNames.length; i2++) {
                    this.f21673f.put(inputNames[i2], Integer.valueOf(i2));
                }
            }
        }
        if (this.f21673f.containsKey(str)) {
            return this.f21673f.get(str).intValue();
        }
        throw new IllegalArgumentException(String.format("Input error: '%s' is not a valid name for any input. Names of inputs and their indexes are %s", str, this.f21673f.toString()));
    }

    /* renamed from: a */
    Tensor m25101a(int i2) {
        if (i2 >= 0) {
            Tensor[] tensorArr = this.f21675h;
            if (i2 < tensorArr.length) {
                Tensor tensor = tensorArr[i2];
                if (tensor != null) {
                    return tensor;
                }
                long j2 = this.f21669b;
                Tensor m25115a = Tensor.m25115a(j2, getInputTensorIndex(j2, i2));
                tensorArr[i2] = m25115a;
                return m25115a;
            }
        }
        throw new IllegalArgumentException("Invalid input Tensor index: " + i2);
    }
}
