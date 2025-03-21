package com.airbnb.lottie.p098a0.p099l0;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;

/* compiled from: JsonReader.java */
/* renamed from: com.airbnb.lottie.a0.l0.c */
/* loaded from: classes.dex */
public abstract class AbstractC1330c implements Closeable {

    /* renamed from: g */
    private static final String[] f3024g = new String[128];

    /* renamed from: a */
    int f3025a;

    /* renamed from: b */
    int[] f3026b = new int[32];

    /* renamed from: c */
    String[] f3027c = new String[32];

    /* renamed from: d */
    int[] f3028d = new int[32];

    /* renamed from: e */
    boolean f3029e;

    /* renamed from: f */
    boolean f3030f;

    /* compiled from: JsonReader.java */
    /* renamed from: com.airbnb.lottie.a0.l0.c$a */
    public static final class a {

        /* renamed from: a */
        final String[] f3031a;

        /* renamed from: b */
        final Options f3032b;

        private a(String[] strArr, Options options) {
            this.f3031a = strArr;
            this.f3032b = options;
        }

        /* renamed from: a */
        public static a m2710a(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    AbstractC1330c.m2693b(buffer, strArr[i2]);
                    buffer.readByte();
                    byteStringArr[i2] = buffer.readByteString();
                }
                return new a((String[]) strArr.clone(), Options.m24931of(byteStringArr));
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    /* compiled from: JsonReader.java */
    /* renamed from: com.airbnb.lottie.a0.l0.c$b */
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
            f3024g[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = f3024g;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    AbstractC1330c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m2693b(okio.BufferedSink r7, java.lang.String r8) throws java.io.IOException {
        /*
            java.lang.String[] r0 = com.airbnb.lottie.p098a0.p099l0.AbstractC1330c.f3024g
            r1 = 34
            r7.writeByte(r1)
            int r2 = r8.length()
            r3 = 0
            r4 = 0
        Ld:
            if (r3 >= r2) goto L36
            char r5 = r8.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L1c
            r5 = r0[r5]
            if (r5 != 0) goto L29
            goto L33
        L1c:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L23
            java.lang.String r5 = "\\u2028"
            goto L29
        L23:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L33
            java.lang.String r5 = "\\u2029"
        L29:
            if (r4 >= r3) goto L2e
            r7.writeUtf8(r8, r4, r3)
        L2e:
            r7.writeUtf8(r5)
            int r4 = r3 + 1
        L33:
            int r3 = r3 + 1
            goto Ld
        L36:
            if (r4 >= r2) goto L3b
            r7.writeUtf8(r8, r4, r2)
        L3b:
            r7.writeByte(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.p098a0.p099l0.AbstractC1330c.m2693b(okio.BufferedSink, java.lang.String):void");
    }

    /* renamed from: a */
    public abstract int mo2694a(a aVar) throws IOException;

    /* renamed from: c */
    public abstract void mo2697c() throws IOException;

    /* renamed from: d */
    public abstract void mo2698d() throws IOException;

    /* renamed from: e */
    public abstract void mo2699e() throws IOException;

    /* renamed from: f */
    public abstract void mo2700f() throws IOException;

    /* renamed from: g */
    public final String m2701g() {
        return C1331d.m2711a(this.f3025a, this.f3026b, this.f3027c, this.f3028d);
    }

    /* renamed from: h */
    public abstract boolean mo2702h() throws IOException;

    /* renamed from: i */
    public abstract boolean mo2703i() throws IOException;

    /* renamed from: j */
    public abstract double mo2704j() throws IOException;

    /* renamed from: k */
    public abstract int mo2705k() throws IOException;

    /* renamed from: l */
    public abstract String mo2706l() throws IOException;

    /* renamed from: m */
    public abstract String mo2707m() throws IOException;

    /* renamed from: n */
    public abstract void mo2708n() throws IOException;

    /* renamed from: o */
    public abstract void mo2709o() throws IOException;

    public abstract b peek() throws IOException;

    /* renamed from: a */
    public static AbstractC1330c m2691a(BufferedSource bufferedSource) {
        return new C1332e(bufferedSource);
    }

    /* renamed from: a */
    final void m2696a(int i2) {
        int i3 = this.f3025a;
        int[] iArr = this.f3026b;
        if (i3 == iArr.length) {
            if (i3 != 256) {
                this.f3026b = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.f3027c;
                this.f3027c = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.f3028d;
                this.f3028d = Arrays.copyOf(iArr2, iArr2.length * 2);
            } else {
                throw new C1328a("Nesting too deep at " + m2701g());
            }
        }
        int[] iArr3 = this.f3026b;
        int i4 = this.f3025a;
        this.f3025a = i4 + 1;
        iArr3[i4] = i2;
    }

    /* renamed from: a */
    final C1329b m2695a(String str) throws C1329b {
        throw new C1329b(str + " at path " + m2701g());
    }
}
