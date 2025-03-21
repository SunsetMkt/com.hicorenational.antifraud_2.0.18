package org.tensorflow.lite;

/* loaded from: classes2.dex */
public final class TensorFlowLite {

    /* renamed from: a */
    private static final String f21682a = "tensorflowlite_jni";

    /* renamed from: b */
    private static final String f21683b = "tensorflowlite_flex_jni";

    static {
        m25136a();
    }

    private TensorFlowLite() {
    }

    /* renamed from: a */
    static boolean m25136a() {
        try {
            System.loadLibrary(f21682a);
            return true;
        } catch (UnsatisfiedLinkError e2) {
            try {
                System.loadLibrary(f21683b);
                return true;
            } catch (UnsatisfiedLinkError unused) {
                System.err.println("TensorFlowLite: failed to load native library: " + e2.getMessage());
                return false;
            }
        }
    }

    @Deprecated
    /* renamed from: b */
    public static String m25137b() {
        return schemaVersion();
    }

    static native void initTensorFlow();

    public static native String runtimeVersion();

    public static native String schemaVersion();
}
