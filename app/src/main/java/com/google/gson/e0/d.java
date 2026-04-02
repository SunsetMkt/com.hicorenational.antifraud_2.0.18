package com.google.gson.e0;

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

/* JADX INFO: compiled from: JsonWriter.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements Closeable, Flushable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Pattern f3805j = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String[] f3806k = new String[128];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String[] f3807l;
    private final Writer a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f3808b = new int[32];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3809c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f3810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f3811e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f3812f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f3813g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f3814h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f3815i;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f3806k[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = f3806k;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        f3807l = (String[]) strArr.clone();
        String[] strArr2 = f3807l;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public d(Writer writer) {
        a(6);
        this.f3811e = Constants.COLON_SEPARATOR;
        this.f3815i = true;
        this.a = (Writer) Objects.requireNonNull(writer, "out == null");
    }

    private void k() throws IOException {
        int iPeek = peek();
        if (iPeek == 5) {
            this.a.write(44);
        } else if (iPeek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        m();
        b(4);
    }

    private void l() throws IOException {
        int iPeek = peek();
        if (iPeek == 1) {
            b(2);
            m();
            return;
        }
        if (iPeek == 2) {
            this.a.append(',');
            m();
        } else {
            if (iPeek == 4) {
                this.a.append((CharSequence) this.f3811e);
                b(5);
                return;
            }
            if (iPeek != 6) {
                if (iPeek != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.f3812f) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            b(7);
        }
    }

    private void m() throws IOException {
        if (this.f3810d == null) {
            return;
        }
        this.a.write(10);
        int i2 = this.f3809c;
        for (int i3 = 1; i3 < i2; i3++) {
            this.a.write(this.f3810d);
        }
    }

    private void n() throws IOException {
        if (this.f3814h != null) {
            k();
            e(this.f3814h);
            this.f3814h = null;
        }
    }

    private int peek() {
        int i2 = this.f3809c;
        if (i2 != 0) {
            return this.f3808b[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void a(boolean z) {
        this.f3813g = z;
    }

    public final void b(boolean z) {
        this.f3812f = z;
    }

    public final void c(String str) {
        if (str.length() == 0) {
            this.f3810d = null;
            this.f3811e = Constants.COLON_SEPARATOR;
        } else {
            this.f3810d = str;
            this.f3811e = ": ";
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
        int i2 = this.f3809c;
        if (i2 > 1 || (i2 == 1 && this.f3808b[i2 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f3809c = 0;
    }

    public d d() throws IOException {
        n();
        return a(3, '{');
    }

    public d e() throws IOException {
        return a(1, 2, ']');
    }

    public d f() throws IOException {
        return a(3, 5, '}');
    }

    public void flush() throws IOException {
        if (this.f3809c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.a.flush();
    }

    public final boolean g() {
        return this.f3815i;
    }

    public final boolean h() {
        return this.f3813g;
    }

    public boolean i() {
        return this.f3812f;
    }

    public d j() throws IOException {
        if (this.f3814h != null) {
            if (!this.f3815i) {
                this.f3814h = null;
                return this;
            }
            n();
        }
        l();
        this.a.write(d.c.a.b.a.a.f10075h);
        return this;
    }

    private d a(int i2, char c2) throws IOException {
        l();
        a(i2);
        this.a.write(c2);
        return this;
    }

    private void b(int i2) {
        this.f3808b[this.f3809c - 1] = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void e(String str) throws IOException {
        String str2;
        String[] strArr = this.f3813g ? f3807l : f3806k;
        this.a.write(34);
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt < '\u0080') {
                str2 = strArr[cCharAt];
                if (str2 != null) {
                    if (i2 < i3) {
                        this.a.write(str, i2, i3 - i2);
                    }
                    this.a.write(str2);
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
                this.a.write(str2);
                i2 = i3 + 1;
            }
        }
        if (i2 < length) {
            this.a.write(str, i2, length - i2);
        }
        this.a.write(34);
    }

    public d b(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.f3814h == null) {
            if (this.f3809c != 0) {
                this.f3814h = str;
                return this;
            }
            throw new IllegalStateException("JsonWriter is closed.");
        }
        throw new IllegalStateException();
    }

    public d d(String str) throws IOException {
        if (str == null) {
            return j();
        }
        n();
        l();
        e(str);
        return this;
    }

    private d a(int i2, int i3, char c2) throws IOException {
        int iPeek = peek();
        if (iPeek != i3 && iPeek != i2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f3814h == null) {
            this.f3809c--;
            if (iPeek == i3) {
                m();
            }
            this.a.write(c2);
            return this;
        }
        throw new IllegalStateException("Dangling name: " + this.f3814h);
    }

    public final void c(boolean z) {
        this.f3815i = z;
    }

    public d c() throws IOException {
        n();
        return a(1, '[');
    }

    public d d(boolean z) throws IOException {
        n();
        l();
        this.a.write(z ? b.a.u.a.f1908j : b.a.u.a.f1909k);
        return this;
    }

    private void a(int i2) {
        int i3 = this.f3809c;
        int[] iArr = this.f3808b;
        if (i3 == iArr.length) {
            this.f3808b = Arrays.copyOf(iArr, i3 * 2);
        }
        int[] iArr2 = this.f3808b;
        int i4 = this.f3809c;
        this.f3809c = i4 + 1;
        iArr2[i4] = i2;
    }

    public d a(String str) throws IOException {
        if (str == null) {
            return j();
        }
        n();
        l();
        this.a.append((CharSequence) str);
        return this;
    }

    public d a(Boolean bool) throws IOException {
        if (bool == null) {
            return j();
        }
        n();
        l();
        this.a.write(bool.booleanValue() ? b.a.u.a.f1908j : b.a.u.a.f1909k);
        return this;
    }

    public d a(float f2) throws IOException {
        n();
        if (!this.f3812f && (Float.isNaN(f2) || Float.isInfinite(f2))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + f2);
        }
        l();
        this.a.append((CharSequence) Float.toString(f2));
        return this;
    }

    public d a(double d2) throws IOException {
        n();
        if (!this.f3812f && (Double.isNaN(d2) || Double.isInfinite(d2))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d2);
        }
        l();
        this.a.append((CharSequence) Double.toString(d2));
        return this;
    }

    public d a(long j2) throws IOException {
        n();
        l();
        this.a.write(Long.toString(j2));
        return this;
    }

    private static boolean a(Class<? extends Number> cls) {
        return cls == Integer.class || cls == Long.class || cls == Double.class || cls == Float.class || cls == Byte.class || cls == Short.class || cls == BigDecimal.class || cls == BigInteger.class || cls == AtomicInteger.class || cls == AtomicLong.class;
    }

    public d a(Number number) throws IOException {
        if (number == null) {
            return j();
        }
        n();
        String string = number.toString();
        if (!string.equals("-Infinity") && !string.equals("Infinity") && !string.equals("NaN")) {
            Class<?> cls = number.getClass();
            if (!a((Class<? extends Number>) cls) && !f3805j.matcher(string).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + string);
            }
        } else if (!this.f3812f) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + string);
        }
        l();
        this.a.append((CharSequence) string);
        return this;
    }
}
