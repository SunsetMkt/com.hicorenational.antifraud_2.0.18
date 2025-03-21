package com.google.gson.p153e0;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;
import p000a.p001a.p014u.C0052a;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: JsonWriter.java */
/* renamed from: com.google.gson.e0.d */
/* loaded from: classes.dex */
public class C2055d implements Closeable, Flushable {

    /* renamed from: j */
    private static final Pattern f5993j = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* renamed from: k */
    private static final String[] f5994k = new String[128];

    /* renamed from: l */
    private static final String[] f5995l;

    /* renamed from: a */
    private final Writer f5996a;

    /* renamed from: b */
    private int[] f5997b = new int[32];

    /* renamed from: c */
    private int f5998c = 0;

    /* renamed from: d */
    private String f5999d;

    /* renamed from: e */
    private String f6000e;

    /* renamed from: f */
    private boolean f6001f;

    /* renamed from: g */
    private boolean f6002g;

    /* renamed from: h */
    private String f6003h;

    /* renamed from: i */
    private boolean f6004i;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f5994k[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = f5994k;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        f5995l = (String[]) strArr.clone();
        String[] strArr2 = f5995l;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public C2055d(Writer writer) {
        m5615a(6);
        this.f6000e = Constants.COLON_SEPARATOR;
        this.f6004i = true;
        this.f5996a = (Writer) Objects.requireNonNull(writer, "out == null");
    }

    /* renamed from: k */
    private void m5619k() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.f5996a.write(44);
        } else if (peek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        m5621m();
        m5617b(4);
    }

    /* renamed from: l */
    private void m5620l() throws IOException {
        int peek = peek();
        if (peek == 1) {
            m5617b(2);
            m5621m();
            return;
        }
        if (peek == 2) {
            this.f5996a.append(',');
            m5621m();
        } else {
            if (peek == 4) {
                this.f5996a.append((CharSequence) this.f6000e);
                m5617b(5);
                return;
            }
            if (peek != 6) {
                if (peek != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.f6001f) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            m5617b(7);
        }
    }

    /* renamed from: m */
    private void m5621m() throws IOException {
        if (this.f5999d == null) {
            return;
        }
        this.f5996a.write(10);
        int i2 = this.f5998c;
        for (int i3 = 1; i3 < i2; i3++) {
            this.f5996a.write(this.f5999d);
        }
    }

    /* renamed from: n */
    private void m5622n() throws IOException {
        if (this.f6003h != null) {
            m5619k();
            m5618e(this.f6003h);
            this.f6003h = null;
        }
    }

    private int peek() {
        int i2 = this.f5998c;
        if (i2 != 0) {
            return this.f5997b[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    /* renamed from: a */
    public final void m5623a(boolean z) {
        this.f6002g = z;
    }

    /* renamed from: b */
    public final void m5624b(boolean z) {
        this.f6001f = z;
    }

    /* renamed from: c */
    public final void m5625c(String str) {
        if (str.length() == 0) {
            this.f5999d = null;
            this.f6000e = Constants.COLON_SEPARATOR;
        } else {
            this.f5999d = str;
            this.f6000e = ": ";
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f5996a.close();
        int i2 = this.f5998c;
        if (i2 > 1 || (i2 == 1 && this.f5997b[i2 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f5998c = 0;
    }

    /* renamed from: d */
    public C2055d mo5443d() throws IOException {
        m5622n();
        return m5613a(3, '{');
    }

    /* renamed from: e */
    public C2055d mo5446e() throws IOException {
        return m5614a(1, 2, ']');
    }

    /* renamed from: f */
    public C2055d mo5447f() throws IOException {
        return m5614a(3, 5, '}');
    }

    public void flush() throws IOException {
        if (this.f5998c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f5996a.flush();
    }

    /* renamed from: g */
    public final boolean m5627g() {
        return this.f6004i;
    }

    /* renamed from: h */
    public final boolean m5628h() {
        return this.f6002g;
    }

    /* renamed from: i */
    public boolean m5629i() {
        return this.f6001f;
    }

    /* renamed from: j */
    public C2055d mo5448j() throws IOException {
        if (this.f6003h != null) {
            if (!this.f6004i) {
                this.f6003h = null;
                return this;
            }
            m5622n();
        }
        m5620l();
        this.f5996a.write(AbstractC1191a.f2571h);
        return this;
    }

    /* renamed from: a */
    private C2055d m5613a(int i2, char c2) throws IOException {
        m5620l();
        m5615a(i2);
        this.f5996a.write(c2);
        return this;
    }

    /* renamed from: b */
    private void m5617b(int i2) {
        this.f5997b[this.f5998c - 1] = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m5618e(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.f6002g
            if (r0 == 0) goto L7
            java.lang.String[] r0 = com.google.gson.p153e0.C2055d.f5995l
            goto L9
        L7:
            java.lang.String[] r0 = com.google.gson.p153e0.C2055d.f5994k
        L9:
            java.io.Writer r1 = r8.f5996a
            r2 = 34
            r1.write(r2)
            int r1 = r9.length()
            r3 = 0
            r4 = 0
        L16:
            if (r3 >= r1) goto L45
            char r5 = r9.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L25
            r5 = r0[r5]
            if (r5 != 0) goto L32
            goto L42
        L25:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L2c
            java.lang.String r5 = "\\u2028"
            goto L32
        L2c:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L42
            java.lang.String r5 = "\\u2029"
        L32:
            if (r4 >= r3) goto L3b
            java.io.Writer r6 = r8.f5996a
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.f5996a
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.f5996a
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r9 = r8.f5996a
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.p153e0.C2055d.m5618e(java.lang.String):void");
    }

    /* renamed from: b */
    public C2055d mo5441b(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.f6003h == null) {
            if (this.f5998c != 0) {
                this.f6003h = str;
                return this;
            }
            throw new IllegalStateException("JsonWriter is closed.");
        }
        throw new IllegalStateException();
    }

    /* renamed from: d */
    public C2055d mo5444d(String str) throws IOException {
        if (str == null) {
            return mo5448j();
        }
        m5622n();
        m5620l();
        m5618e(str);
        return this;
    }

    /* renamed from: a */
    private C2055d m5614a(int i2, int i3, char c2) throws IOException {
        int peek = peek();
        if (peek != i3 && peek != i2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f6003h == null) {
            this.f5998c--;
            if (peek == i3) {
                m5621m();
            }
            this.f5996a.write(c2);
            return this;
        }
        throw new IllegalStateException("Dangling name: " + this.f6003h);
    }

    /* renamed from: c */
    public final void m5626c(boolean z) {
        this.f6004i = z;
    }

    /* renamed from: c */
    public C2055d mo5442c() throws IOException {
        m5622n();
        return m5613a(1, '[');
    }

    /* renamed from: d */
    public C2055d mo5445d(boolean z) throws IOException {
        m5622n();
        m5620l();
        this.f5996a.write(z ? C0052a.f158j : C0052a.f159k);
        return this;
    }

    /* renamed from: a */
    private void m5615a(int i2) {
        int i3 = this.f5998c;
        int[] iArr = this.f5997b;
        if (i3 == iArr.length) {
            this.f5997b = Arrays.copyOf(iArr, i3 * 2);
        }
        int[] iArr2 = this.f5997b;
        int i4 = this.f5998c;
        this.f5998c = i4 + 1;
        iArr2[i4] = i2;
    }

    /* renamed from: a */
    public C2055d mo5440a(String str) throws IOException {
        if (str == null) {
            return mo5448j();
        }
        m5622n();
        m5620l();
        this.f5996a.append((CharSequence) str);
        return this;
    }

    /* renamed from: a */
    public C2055d mo5438a(Boolean bool) throws IOException {
        if (bool == null) {
            return mo5448j();
        }
        m5622n();
        m5620l();
        this.f5996a.write(bool.booleanValue() ? C0052a.f158j : C0052a.f159k);
        return this;
    }

    /* renamed from: a */
    public C2055d mo5436a(float f2) throws IOException {
        m5622n();
        if (!this.f6001f && (Float.isNaN(f2) || Float.isInfinite(f2))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + f2);
        }
        m5620l();
        this.f5996a.append((CharSequence) Float.toString(f2));
        return this;
    }

    /* renamed from: a */
    public C2055d mo5435a(double d2) throws IOException {
        m5622n();
        if (!this.f6001f && (Double.isNaN(d2) || Double.isInfinite(d2))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d2);
        }
        m5620l();
        this.f5996a.append((CharSequence) Double.toString(d2));
        return this;
    }

    /* renamed from: a */
    public C2055d mo5437a(long j2) throws IOException {
        m5622n();
        m5620l();
        this.f5996a.write(Long.toString(j2));
        return this;
    }

    /* renamed from: a */
    private static boolean m5616a(Class<? extends Number> cls) {
        return cls == Integer.class || cls == Long.class || cls == Double.class || cls == Float.class || cls == Byte.class || cls == Short.class || cls == BigDecimal.class || cls == BigInteger.class || cls == AtomicInteger.class || cls == AtomicLong.class;
    }

    /* renamed from: a */
    public C2055d mo5439a(Number number) throws IOException {
        if (number == null) {
            return mo5448j();
        }
        m5622n();
        String obj = number.toString();
        if (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN")) {
            Class<?> cls = number.getClass();
            if (!m5616a((Class<? extends Number>) cls) && !f5993j.matcher(obj).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + obj);
            }
        } else if (!this.f6001f) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + obj);
        }
        m5620l();
        this.f5996a.append((CharSequence) obj);
        return this;
    }
}
