package org.tensorflow.lite;

/* compiled from: DataType.java */
/* renamed from: org.tensorflow.lite.a */
/* loaded from: classes2.dex */
public enum EnumC6075a {
    FLOAT32(1),
    INT32(2),
    UINT8(3),
    INT64(4),
    STRING(5);


    /* renamed from: a */
    private static final EnumC6075a[] f21684a = values();
    private final int value;

    /* compiled from: DataType.java */
    /* renamed from: org.tensorflow.lite.a$a */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f21686a = new int[EnumC6075a.values().length];

        static {
            try {
                f21686a[EnumC6075a.FLOAT32.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21686a[EnumC6075a.INT32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21686a[EnumC6075a.UINT8.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f21686a[EnumC6075a.INT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f21686a[EnumC6075a.STRING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    EnumC6075a(int i2) {
        this.value = i2;
    }

    static EnumC6075a fromC(int i2) {
        for (EnumC6075a enumC6075a : f21684a) {
            if (enumC6075a.value == i2) {
                return enumC6075a;
            }
        }
        throw new IllegalArgumentException("DataType error: DataType " + i2 + " is not recognized in Java (version " + TensorFlowLite.runtimeVersion() + ")");
    }

    public int byteSize() {
        int i2 = a.f21686a[ordinal()];
        if (i2 == 1 || i2 == 2) {
            return 4;
        }
        if (i2 == 3) {
            return 1;
        }
        if (i2 == 4) {
            return 8;
        }
        if (i2 == 5) {
            return -1;
        }
        throw new IllegalArgumentException("DataType error: DataType " + this + " is not supported yet");
    }

    /* renamed from: c */
    int m25138c() {
        return this.value;
    }

    String toStringName() {
        int i2 = a.f21686a[ordinal()];
        if (i2 == 1) {
            return "float";
        }
        if (i2 == 2) {
            return "int";
        }
        if (i2 == 3) {
            return "byte";
        }
        if (i2 == 4) {
            return "long";
        }
        if (i2 == 5) {
            return "string";
        }
        throw new IllegalArgumentException("DataType error: DataType " + this + " is not supported yet");
    }
}
