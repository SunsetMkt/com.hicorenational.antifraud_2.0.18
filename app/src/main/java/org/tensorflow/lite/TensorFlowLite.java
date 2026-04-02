package org.tensorflow.lite;

/* JADX INFO: loaded from: classes2.dex */
public final class TensorFlowLite {
    private static final String a = "tensorflowlite_jni";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f13010b = "tensorflowlite_flex_jni";

    static {
        a();
    }

    private TensorFlowLite() {
    }

    static boolean a() {
        try {
            System.loadLibrary(a);
            return true;
        } catch (UnsatisfiedLinkError e2) {
            try {
                System.loadLibrary(f13010b);
                return true;
            } catch (UnsatisfiedLinkError unused) {
                System.err.println("TensorFlowLite: failed to load native library: " + e2.getMessage());
                return false;
            }
        }
    }

    @Deprecated
    public static String b() {
        return schemaVersion();
    }

    static native void initTensorFlow();

    public static native String runtimeVersion();

    public static native String schemaVersion();
}
