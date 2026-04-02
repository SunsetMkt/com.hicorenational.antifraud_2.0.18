package com.airbnb.lottie.a0.l0;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;

/* JADX INFO: compiled from: JsonReader.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c implements Closeable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String[] f2045g = new String[128];
    int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int[] f2046b = new int[32];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String[] f2047c = new String[32];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int[] f2048d = new int[32];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f2049e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f2050f;

    /* JADX INFO: compiled from: JsonReader.java */
    public static final class a {
        final String[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Options f2051b;

        private a(String[] strArr, Options options) {
            this.a = strArr;
            this.f2051b = options;
        }

        public static a a(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    c.b(buffer, strArr[i2]);
                    buffer.readByte();
                    byteStringArr[i2] = buffer.readByteString();
                }
                return new a((String[]) strArr.clone(), Options.of(byteStringArr));
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    /* JADX INFO: compiled from: JsonReader.java */
    public enum b {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f2045g[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = f2045g;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(BufferedSink bufferedSink, String str) throws IOException {
        String str2;
        String[] strArr = f2045g;
        bufferedSink.writeByte(34);
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt < '\u0080') {
                str2 = strArr[cCharAt];
                if (str2 != null) {
                    if (i2 < i3) {
                        bufferedSink.writeUtf8(str, i2, i3);
                    }
                    bufferedSink.writeUtf8(str2);
                    i2 = i3 + 1;
                }
            } else {
                if (cCharAt == '\u2028') {
                    str2 = "\\u2028";
                } else if (cCharAt == '\u2029') {
                    str2 = "\\u2029";
                }
                if (i2 < i3) {
                }
                bufferedSink.writeUtf8(str2);
                i2 = i3 + 1;
            }
        }
        if (i2 < length) {
            bufferedSink.writeUtf8(str, i2, length);
        }
        bufferedSink.writeByte(34);
    }

    public abstract int a(a aVar) throws IOException;

    public abstract void c() throws IOException;

    public abstract void d() throws IOException;

    public abstract void e() throws IOException;

    public abstract void f() throws IOException;

    public final String g() {
        return d.a(this.a, this.f2046b, this.f2047c, this.f2048d);
    }

    public abstract boolean h() throws IOException;

    public abstract boolean i() throws IOException;

    public abstract double j() throws IOException;

    public abstract int k() throws IOException;

    public abstract String l() throws IOException;

    public abstract String m() throws IOException;

    public abstract void n() throws IOException;

    public abstract void o() throws IOException;

    public abstract b peek() throws IOException;

    public static c a(BufferedSource bufferedSource) {
        return new e(bufferedSource);
    }

    final void a(int i2) {
        int i3 = this.a;
        int[] iArr = this.f2046b;
        if (i3 == iArr.length) {
            if (i3 != 256) {
                this.f2046b = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.f2047c;
                this.f2047c = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.f2048d;
                this.f2048d = Arrays.copyOf(iArr2, iArr2.length * 2);
            } else {
                throw new com.airbnb.lottie.a0.l0.a("Nesting too deep at " + g());
            }
        }
        int[] iArr3 = this.f2046b;
        int i4 = this.a;
        this.a = i4 + 1;
        iArr3[i4] = i2;
    }

    final com.airbnb.lottie.a0.l0.b a(String str) throws com.airbnb.lottie.a0.l0.b {
        throw new com.airbnb.lottie.a0.l0.b(str + " at path " + g());
    }
}
