package com.google.gson.e0;

import com.google.gson.b0.g;
import i.z2.h0;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: JsonReader.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements Closeable {
    private static final int A = 10;
    private static final int B = 11;
    private static final int C = 12;
    private static final int D = 13;
    private static final int E = 14;
    private static final int F = 15;
    private static final int G = 16;
    private static final int H = 17;
    private static final int I = 0;
    private static final int J = 1;
    private static final int K = 2;
    private static final int L = 3;
    private static final int M = 4;
    private static final int N = 5;
    private static final int O = 6;
    private static final int b0 = 7;
    static final int c0 = 1024;
    private static final long p = -922337203685477580L;
    private static final int q = 0;
    private static final int r = 1;
    private static final int s = 2;
    private static final int t = 3;
    private static final int u = 4;
    private static final int v = 5;
    private static final int w = 6;
    private static final int x = 7;
    private static final int y = 8;
    private static final int z = 9;
    private final Reader a;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f3792i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f3793j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f3794k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f3796m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String[] f3797n;
    private int[] o;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3785b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final char[] f3786c = new char[1024];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3787d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3788e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f3789f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3790g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f3791h = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int[] f3795l = new int[32];

    /* JADX INFO: renamed from: com.google.gson.e0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: JsonReader.java */
    class C0080a extends g {
        C0080a() {
        }

        @Override // com.google.gson.b0.g
        public void a(a aVar) throws IOException {
            if (aVar instanceof com.google.gson.b0.q.f) {
                ((com.google.gson.b0.q.f) aVar).v();
                return;
            }
            int iE = aVar.f3791h;
            if (iE == 0) {
                iE = aVar.e();
            }
            if (iE == 13) {
                aVar.f3791h = 9;
                return;
            }
            if (iE == 12) {
                aVar.f3791h = 8;
                return;
            }
            if (iE == 14) {
                aVar.f3791h = 10;
                return;
            }
            throw new IllegalStateException("Expected a name but was " + aVar.peek() + aVar.l());
        }
    }

    static {
        g.a = new C0080a();
    }

    public a(Reader reader) {
        this.f3796m = 0;
        int[] iArr = this.f3795l;
        int i2 = this.f3796m;
        this.f3796m = i2 + 1;
        iArr[i2] = 6;
        this.f3797n = new String[32];
        this.o = new int[32];
        this.a = (Reader) Objects.requireNonNull(reader, "in == null");
    }

    private void A() throws IOException {
        char c2;
        do {
            if (this.f3787d >= this.f3788e && !a(1)) {
                return;
            }
            char[] cArr = this.f3786c;
            int i2 = this.f3787d;
            this.f3787d = i2 + 1;
            c2 = cArr[i2];
            if (c2 == '\n') {
                this.f3789f++;
                this.f3790g = this.f3787d;
                return;
            }
        } while (c2 != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
    
        u();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void B() throws IOException {
        do {
            int i2 = 0;
            while (true) {
                int i3 = this.f3787d;
                if (i3 + i2 < this.f3788e) {
                    char c2 = this.f3786c[i3 + i2];
                    if (c2 != '\t' && c2 != '\n' && c2 != '\f' && c2 != '\r' && c2 != ' ') {
                        if (c2 != '#') {
                            if (c2 != ',') {
                                if (c2 != '/' && c2 != '=') {
                                    if (c2 != '{' && c2 != '}' && c2 != ':') {
                                        if (c2 != ';') {
                                            switch (c2) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i2++;
                                                    break;
                                            }
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    this.f3787d = i3 + i2;
                }
            }
            this.f3787d += i2;
            return;
        } while (a(1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005b, code lost:
    
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005d, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r4) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006b, code lost:
    
        r1.append(r0, r4, r2 - r4);
        r9.f3787d = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String b(char c2) throws IOException {
        char[] cArr = this.f3786c;
        StringBuilder sb = null;
        do {
            int i2 = this.f3787d;
            int i3 = this.f3788e;
            while (true) {
                int i4 = i2;
                while (i2 < i3) {
                    int i5 = i2 + 1;
                    char c3 = cArr[i2];
                    if (c3 == c2) {
                        this.f3787d = i5;
                        int i6 = (i5 - i4) - 1;
                        if (sb == null) {
                            return new String(cArr, i4, i6);
                        }
                        sb.append(cArr, i4, i6);
                        return sb.toString();
                    }
                    if (c3 == '\\') {
                        this.f3787d = i5;
                        int i7 = (i5 - i4) - 1;
                        if (sb == null) {
                            sb = new StringBuilder(Math.max((i7 + 1) * 2, 16));
                        }
                        sb.append(cArr, i4, i7);
                        sb.append(z());
                        i2 = this.f3787d;
                        i3 = this.f3788e;
                    } else {
                        if (c3 == '\n') {
                            this.f3789f++;
                            this.f3790g = i5;
                        }
                        i2 = i5;
                    }
                }
                break;
            }
        } while (a(1));
        throw b("Unterminated string");
    }

    private void u() throws IOException {
        if (!this.f3785b) {
            throw b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void v() throws IOException {
        c(true);
        this.f3787d--;
        if (this.f3787d + 5 <= this.f3788e || a(5)) {
            int i2 = this.f3787d;
            char[] cArr = this.f3786c;
            if (cArr[i2] == ')' && cArr[i2 + 1] == ']' && cArr[i2 + 2] == '}' && cArr[i2 + 3] == '\'' && cArr[i2 + 4] == '\n') {
                this.f3787d = i2 + 5;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004b, code lost:
    
        u();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0045. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String w() throws IOException {
        String string;
        int i2 = 0;
        StringBuilder sb = null;
        do {
            int i3 = 0;
            while (true) {
                int i4 = this.f3787d;
                if (i4 + i3 < this.f3788e) {
                    char c2 = this.f3786c[i4 + i3];
                    if (c2 != '\t' && c2 != '\n' && c2 != '\f' && c2 != '\r' && c2 != ' ') {
                        if (c2 != '#') {
                            if (c2 != ',') {
                                if (c2 != '/' && c2 != '=') {
                                    if (c2 != '{' && c2 != '}' && c2 != ':') {
                                        if (c2 != ';') {
                                            switch (c2) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i3++;
                                                    break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (i3 >= this.f3786c.length) {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i3, 16));
                    }
                    sb.append(this.f3786c, this.f3787d, i3);
                    this.f3787d += i3;
                } else if (a(i3 + 1)) {
                }
            }
            i2 = i3;
            if (sb != null) {
                string = new String(this.f3786c, this.f3787d, i2);
            } else {
                sb.append(this.f3786c, this.f3787d, i2);
                string = sb.toString();
            }
            this.f3787d += i2;
            return string;
        } while (a(1));
        if (sb != null) {
        }
        this.f3787d += i2;
        return string;
    }

    private int x() throws IOException {
        int i2;
        String str;
        String str2;
        char c2 = this.f3786c[this.f3787d];
        if (c2 == 't' || c2 == 'T') {
            i2 = 5;
            str = b.a.u.a.f1908j;
            str2 = "TRUE";
        } else if (c2 == 'f' || c2 == 'F') {
            i2 = 6;
            str = b.a.u.a.f1909k;
            str2 = "FALSE";
        } else {
            if (c2 != 'n' && c2 != 'N') {
                return 0;
            }
            i2 = 7;
            str = d.c.a.b.a.a.f10075h;
            str2 = "NULL";
        }
        int length = str.length();
        for (int i3 = 1; i3 < length; i3++) {
            if (this.f3787d + i3 >= this.f3788e && !a(i3 + 1)) {
                return 0;
            }
            char c3 = this.f3786c[this.f3787d + i3];
            if (c3 != str.charAt(i3) && c3 != str2.charAt(i3)) {
                return 0;
            }
        }
        if ((this.f3787d + length < this.f3788e || a(length + 1)) && a(this.f3786c[this.f3787d + length])) {
            return 0;
        }
        this.f3787d += length;
        this.f3791h = i2;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0098, code lost:
    
        if (a(r14) != false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x009a, code lost:
    
        if (r9 != 2) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x009c, code lost:
    
        if (r10 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a2, code lost:
    
        if (r11 != Long.MIN_VALUE) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a4, code lost:
    
        if (r13 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00aa, code lost:
    
        if (r11 != 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ac, code lost:
    
        if (r13 != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ae, code lost:
    
        if (r13 == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00b1, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b2, code lost:
    
        r18.f3792i = r11;
        r18.f3787d += r3;
        r18.f3791h = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00bd, code lost:
    
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00be, code lost:
    
        if (r9 == 2) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00c1, code lost:
    
        if (r9 == 4) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00c4, code lost:
    
        if (r9 != 7) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00c7, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00c9, code lost:
    
        r18.f3793j = r3;
        r18.f3791h = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00cf, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00d0, code lost:
    
        return 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int y() throws IOException {
        char c2;
        char[] cArr = this.f3786c;
        int i2 = this.f3787d;
        int i3 = 0;
        int i4 = this.f3788e;
        int i5 = 0;
        char c3 = 0;
        boolean z2 = true;
        long j2 = 0;
        boolean z3 = false;
        while (true) {
            if (i2 + i5 != i4) {
                c2 = cArr[i2 + i5];
                if (c2 == '+') {
                    if (c2 == 'E' || c2 == 'e') {
                        i3 = 0;
                        if (c3 != 2 && c3 != 4) {
                            return 0;
                        }
                        c3 = 5;
                    } else if (c2 == '-') {
                        i3 = 0;
                        if (c3 == 0) {
                            c3 = 1;
                            z3 = true;
                        } else if (c3 != 5) {
                            return 0;
                        }
                    } else if (c2 == '.') {
                        i3 = 0;
                        if (c3 != 2) {
                            return 0;
                        }
                        c3 = 3;
                    } else {
                        if (c2 < '0' || c2 > '9') {
                            break;
                        }
                        if (c3 == 1 || c3 == 0) {
                            j2 = -(c2 - '0');
                            i3 = 0;
                            c3 = 2;
                        } else {
                            if (c3 == 2) {
                                if (j2 == 0) {
                                    return 0;
                                }
                                long j3 = (10 * j2) - ((long) (c2 - '0'));
                                boolean z4 = j2 > -922337203685477580L || (j2 == -922337203685477580L && j3 < j2);
                                j2 = j3;
                                z2 = z4 & z2;
                            } else if (c3 == 3) {
                                i3 = 0;
                                c3 = 4;
                            } else if (c3 == 5 || c3 == 6) {
                                i3 = 0;
                                c3 = 7;
                            }
                            i3 = 0;
                        }
                    }
                    i5++;
                } else {
                    i3 = 0;
                    if (c3 != 5) {
                        return 0;
                    }
                }
                c3 = 6;
                i5++;
            } else {
                if (i5 == cArr.length) {
                    return i3;
                }
                if (!a(i5 + 1)) {
                    break;
                }
                i2 = this.f3787d;
                i4 = this.f3788e;
                c2 = cArr[i2 + i5];
                if (c2 == '+') {
                }
                c3 = 6;
                i5++;
            }
        }
    }

    private char z() throws IOException {
        int i2;
        int i3;
        if (this.f3787d == this.f3788e && !a(1)) {
            throw b("Unterminated escape sequence");
        }
        char[] cArr = this.f3786c;
        int i4 = this.f3787d;
        this.f3787d = i4 + 1;
        char c2 = cArr[i4];
        if (c2 == '\n') {
            this.f3789f++;
            this.f3790g = this.f3787d;
        } else if (c2 != '\"' && c2 != '\'' && c2 != '/' && c2 != '\\') {
            if (c2 == 'b') {
                return '\b';
            }
            if (c2 == 'f') {
                return '\f';
            }
            if (c2 == 'n') {
                return '\n';
            }
            if (c2 == 'r') {
                return '\r';
            }
            if (c2 == 't') {
                return '\t';
            }
            if (c2 != 'u') {
                throw b("Invalid escape sequence");
            }
            if (this.f3787d + 4 > this.f3788e && !a(4)) {
                throw b("Unterminated escape sequence");
            }
            char c3 = 0;
            int i5 = this.f3787d;
            int i6 = i5 + 4;
            while (i5 < i6) {
                char c4 = this.f3786c[i5];
                char c5 = (char) (c3 << 4);
                if (c4 < '0' || c4 > '9') {
                    if (c4 >= 'a' && c4 <= 'f') {
                        i2 = c4 - 'a';
                    } else {
                        if (c4 < 'A' || c4 > 'F') {
                            throw new NumberFormatException("\\u" + new String(this.f3786c, this.f3787d, 4));
                        }
                        i2 = c4 - 'A';
                    }
                    i3 = i2 + 10;
                } else {
                    i3 = c4 - '0';
                }
                c3 = (char) (c5 + i3);
                i5++;
            }
            this.f3787d += 4;
            return c3;
        }
        return c2;
    }

    public final void a(boolean z2) {
        this.f3785b = z2;
    }

    public void c() throws IOException {
        int iE = this.f3791h;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 3) {
            b(1);
            this.o[this.f3796m - 1] = 0;
            this.f3791h = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + peek() + l());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f3791h = 0;
        this.f3795l[0] = 8;
        this.f3796m = 1;
        this.a.close();
    }

    public void d() throws IOException {
        int iE = this.f3791h;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 1) {
            b(3);
            this.f3791h = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + peek() + l());
        }
    }

    int e() throws IOException {
        int iC;
        int[] iArr = this.f3795l;
        int i2 = this.f3796m;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int iC2 = c(true);
            if (iC2 != 44) {
                if (iC2 != 59) {
                    if (iC2 != 93) {
                        throw b("Unterminated array");
                    }
                    this.f3791h = 4;
                    return 4;
                }
                u();
            }
        } else {
            if (i3 == 3 || i3 == 5) {
                this.f3795l[this.f3796m - 1] = 4;
                if (i3 == 5 && (iC = c(true)) != 44) {
                    if (iC != 59) {
                        if (iC != 125) {
                            throw b("Unterminated object");
                        }
                        this.f3791h = 2;
                        return 2;
                    }
                    u();
                }
                int iC3 = c(true);
                if (iC3 == 34) {
                    this.f3791h = 13;
                    return 13;
                }
                if (iC3 == 39) {
                    u();
                    this.f3791h = 12;
                    return 12;
                }
                if (iC3 == 125) {
                    if (i3 == 5) {
                        throw b("Expected name");
                    }
                    this.f3791h = 2;
                    return 2;
                }
                u();
                this.f3787d--;
                if (!a((char) iC3)) {
                    throw b("Expected name");
                }
                this.f3791h = 14;
                return 14;
            }
            if (i3 == 4) {
                iArr[i2 - 1] = 5;
                int iC4 = c(true);
                if (iC4 != 58) {
                    if (iC4 != 61) {
                        throw b("Expected ':'");
                    }
                    u();
                    if (this.f3787d < this.f3788e || a(1)) {
                        char[] cArr = this.f3786c;
                        int i4 = this.f3787d;
                        if (cArr[i4] == '>') {
                            this.f3787d = i4 + 1;
                        }
                    }
                }
            } else if (i3 == 6) {
                if (this.f3785b) {
                    v();
                }
                this.f3795l[this.f3796m - 1] = 7;
            } else if (i3 == 7) {
                if (c(false) == -1) {
                    this.f3791h = 17;
                    return 17;
                }
                u();
                this.f3787d--;
            } else if (i3 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iC5 = c(true);
        if (iC5 == 34) {
            this.f3791h = 9;
            return 9;
        }
        if (iC5 == 39) {
            u();
            this.f3791h = 8;
            return 8;
        }
        if (iC5 != 44 && iC5 != 59) {
            if (iC5 == 91) {
                this.f3791h = 3;
                return 3;
            }
            if (iC5 != 93) {
                if (iC5 == 123) {
                    this.f3791h = 1;
                    return 1;
                }
                this.f3787d--;
                int iX = x();
                if (iX != 0) {
                    return iX;
                }
                int iY = y();
                if (iY != 0) {
                    return iY;
                }
                if (!a(this.f3786c[this.f3787d])) {
                    throw b("Expected value");
                }
                u();
                this.f3791h = 10;
                return 10;
            }
            if (i3 == 1) {
                this.f3791h = 4;
                return 4;
            }
        }
        if (i3 != 1 && i3 != 2) {
            throw b("Unexpected value");
        }
        u();
        this.f3787d--;
        this.f3791h = 7;
        return 7;
    }

    public void f() throws IOException {
        int iE = this.f3791h;
        if (iE == 0) {
            iE = e();
        }
        if (iE != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + peek() + l());
        }
        this.f3796m--;
        int[] iArr = this.o;
        int i2 = this.f3796m - 1;
        iArr[i2] = iArr[i2] + 1;
        this.f3791h = 0;
    }

    public void g() throws IOException {
        int iE = this.f3791h;
        if (iE == 0) {
            iE = e();
        }
        if (iE != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + peek() + l());
        }
        this.f3796m--;
        String[] strArr = this.f3797n;
        int i2 = this.f3796m;
        strArr[i2] = null;
        int[] iArr = this.o;
        int i3 = i2 - 1;
        iArr[i3] = iArr[i3] + 1;
        this.f3791h = 0;
    }

    public String h() {
        return b(false);
    }

    public String i() {
        return b(true);
    }

    public boolean j() throws IOException {
        int iE = this.f3791h;
        if (iE == 0) {
            iE = e();
        }
        return (iE == 2 || iE == 4 || iE == 17) ? false : true;
    }

    public final boolean k() {
        return this.f3785b;
    }

    String l() {
        return " at line " + (this.f3789f + 1) + " column " + ((this.f3787d - this.f3790g) + 1) + " path " + h();
    }

    public boolean m() throws IOException {
        int iE = this.f3791h;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 5) {
            this.f3791h = 0;
            int[] iArr = this.o;
            int i2 = this.f3796m - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        }
        if (iE == 6) {
            this.f3791h = 0;
            int[] iArr2 = this.o;
            int i3 = this.f3796m - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + peek() + l());
    }

    public double n() throws IOException {
        int iE = this.f3791h;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 15) {
            this.f3791h = 0;
            int[] iArr = this.o;
            int i2 = this.f3796m - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f3792i;
        }
        if (iE == 16) {
            this.f3794k = new String(this.f3786c, this.f3787d, this.f3793j);
            this.f3787d += this.f3793j;
        } else if (iE == 8 || iE == 9) {
            this.f3794k = b(iE == 8 ? '\'' : h0.a);
        } else if (iE == 10) {
            this.f3794k = w();
        } else if (iE != 11) {
            throw new IllegalStateException("Expected a double but was " + peek() + l());
        }
        this.f3791h = 11;
        double d2 = Double.parseDouble(this.f3794k);
        if (!this.f3785b && (Double.isNaN(d2) || Double.isInfinite(d2))) {
            throw new e("JSON forbids NaN and infinities: " + d2 + l());
        }
        this.f3794k = null;
        this.f3791h = 0;
        int[] iArr2 = this.o;
        int i3 = this.f3796m - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return d2;
    }

    public int o() throws IOException {
        int iE = this.f3791h;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 15) {
            long j2 = this.f3792i;
            int i2 = (int) j2;
            if (j2 == i2) {
                this.f3791h = 0;
                int[] iArr = this.o;
                int i3 = this.f3796m - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            throw new NumberFormatException("Expected an int but was " + this.f3792i + l());
        }
        if (iE == 16) {
            this.f3794k = new String(this.f3786c, this.f3787d, this.f3793j);
            this.f3787d += this.f3793j;
        } else {
            if (iE != 8 && iE != 9 && iE != 10) {
                throw new IllegalStateException("Expected an int but was " + peek() + l());
            }
            if (iE == 10) {
                this.f3794k = w();
            } else {
                this.f3794k = b(iE == 8 ? '\'' : h0.a);
            }
            try {
                int i4 = Integer.parseInt(this.f3794k);
                this.f3791h = 0;
                int[] iArr2 = this.o;
                int i5 = this.f3796m - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return i4;
            } catch (NumberFormatException unused) {
            }
        }
        this.f3791h = 11;
        double d2 = Double.parseDouble(this.f3794k);
        int i6 = (int) d2;
        if (i6 != d2) {
            throw new NumberFormatException("Expected an int but was " + this.f3794k + l());
        }
        this.f3794k = null;
        this.f3791h = 0;
        int[] iArr3 = this.o;
        int i7 = this.f3796m - 1;
        iArr3[i7] = iArr3[i7] + 1;
        return i6;
    }

    public long p() throws IOException {
        int iE = this.f3791h;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 15) {
            this.f3791h = 0;
            int[] iArr = this.o;
            int i2 = this.f3796m - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f3792i;
        }
        if (iE == 16) {
            this.f3794k = new String(this.f3786c, this.f3787d, this.f3793j);
            this.f3787d += this.f3793j;
        } else {
            if (iE != 8 && iE != 9 && iE != 10) {
                throw new IllegalStateException("Expected a long but was " + peek() + l());
            }
            if (iE == 10) {
                this.f3794k = w();
            } else {
                this.f3794k = b(iE == 8 ? '\'' : h0.a);
            }
            try {
                long j2 = Long.parseLong(this.f3794k);
                this.f3791h = 0;
                int[] iArr2 = this.o;
                int i3 = this.f3796m - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return j2;
            } catch (NumberFormatException unused) {
            }
        }
        this.f3791h = 11;
        double d2 = Double.parseDouble(this.f3794k);
        long j3 = (long) d2;
        if (j3 != d2) {
            throw new NumberFormatException("Expected a long but was " + this.f3794k + l());
        }
        this.f3794k = null;
        this.f3791h = 0;
        int[] iArr3 = this.o;
        int i4 = this.f3796m - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j3;
    }

    public c peek() throws IOException {
        int iE = this.f3791h;
        if (iE == 0) {
            iE = e();
        }
        switch (iE) {
            case 1:
                return c.BEGIN_OBJECT;
            case 2:
                return c.END_OBJECT;
            case 3:
                return c.BEGIN_ARRAY;
            case 4:
                return c.END_ARRAY;
            case 5:
            case 6:
                return c.BOOLEAN;
            case 7:
                return c.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return c.STRING;
            case 12:
            case 13:
            case 14:
                return c.NAME;
            case 15:
            case 16:
                return c.NUMBER;
            case 17:
                return c.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public String q() throws IOException {
        String strB;
        int iE = this.f3791h;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 14) {
            strB = w();
        } else if (iE == 12) {
            strB = b('\'');
        } else {
            if (iE != 13) {
                throw new IllegalStateException("Expected a name but was " + peek() + l());
            }
            strB = b(h0.a);
        }
        this.f3791h = 0;
        this.f3797n[this.f3796m - 1] = strB;
        return strB;
    }

    public void r() throws IOException {
        int iE = this.f3791h;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 7) {
            this.f3791h = 0;
            int[] iArr = this.o;
            int i2 = this.f3796m - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + peek() + l());
    }

    public String s() throws IOException {
        String str;
        int iE = this.f3791h;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 10) {
            str = w();
        } else if (iE == 8) {
            str = b('\'');
        } else if (iE == 9) {
            str = b(h0.a);
        } else if (iE == 11) {
            str = this.f3794k;
            this.f3794k = null;
        } else if (iE == 15) {
            str = Long.toString(this.f3792i);
        } else {
            if (iE != 16) {
                throw new IllegalStateException("Expected a string but was " + peek() + l());
            }
            str = new String(this.f3786c, this.f3787d, this.f3793j);
            this.f3787d += this.f3793j;
        }
        this.f3791h = 0;
        int[] iArr = this.o;
        int i2 = this.f3796m - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void t() throws IOException {
        int i2 = 0;
        do {
            int iE = this.f3791h;
            if (iE == 0) {
                iE = e();
            }
            switch (iE) {
                case 1:
                    b(3);
                    i2++;
                    this.f3791h = 0;
                    break;
                case 2:
                    if (i2 == 0) {
                        this.f3797n[this.f3796m - 1] = null;
                    }
                    this.f3796m--;
                    i2--;
                    this.f3791h = 0;
                    break;
                case 3:
                    b(1);
                    i2++;
                    this.f3791h = 0;
                    break;
                case 4:
                    this.f3796m--;
                    i2--;
                    this.f3791h = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case 15:
                default:
                    this.f3791h = 0;
                    break;
                case 8:
                    c('\'');
                    this.f3791h = 0;
                    break;
                case 9:
                    c(h0.a);
                    this.f3791h = 0;
                    break;
                case 10:
                    B();
                    this.f3791h = 0;
                    break;
                case 12:
                    c('\'');
                    if (i2 == 0) {
                        this.f3797n[this.f3796m - 1] = "<skipped>";
                    }
                    this.f3791h = 0;
                    break;
                case 13:
                    c(h0.a);
                    if (i2 == 0) {
                        this.f3797n[this.f3796m - 1] = "<skipped>";
                    }
                    this.f3791h = 0;
                    break;
                case 14:
                    B();
                    if (i2 == 0) {
                        this.f3797n[this.f3796m - 1] = "<skipped>";
                    }
                    this.f3791h = 0;
                    break;
                case 16:
                    this.f3787d += this.f3793j;
                    this.f3791h = 0;
                    break;
                case 17:
                    break;
            }
            return;
        } while (i2 > 0);
        int[] iArr = this.o;
        int i3 = this.f3796m - 1;
        iArr[i3] = iArr[i3] + 1;
    }

    public String toString() {
        return getClass().getSimpleName() + l();
    }

    private boolean a(char c2) throws IOException {
        if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
            return false;
        }
        if (c2 != '#') {
            if (c2 == ',') {
                return false;
            }
            if (c2 != '/' && c2 != '=') {
                if (c2 == '{' || c2 == '}' || c2 == ':') {
                    return false;
                }
                if (c2 != ';') {
                    switch (c2) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        u();
        return false;
    }

    private boolean a(int i2) throws IOException {
        int i3;
        char[] cArr = this.f3786c;
        int i4 = this.f3790g;
        int i5 = this.f3787d;
        this.f3790g = i4 - i5;
        int i6 = this.f3788e;
        if (i6 != i5) {
            this.f3788e = i6 - i5;
            System.arraycopy(cArr, i5, cArr, 0, this.f3788e);
        } else {
            this.f3788e = 0;
        }
        this.f3787d = 0;
        do {
            Reader reader = this.a;
            int i7 = this.f3788e;
            int i8 = reader.read(cArr, i7, cArr.length - i7);
            if (i8 == -1) {
                return false;
            }
            this.f3788e += i8;
            if (this.f3789f == 0 && (i3 = this.f3790g) == 0 && this.f3788e > 0 && cArr[0] == '\ufeff') {
                this.f3787d++;
                this.f3790g = i3 + 1;
                i2++;
            }
        } while (this.f3788e < i2);
        return true;
    }

    private void c(char c2) throws IOException {
        char[] cArr = this.f3786c;
        do {
            int i2 = this.f3787d;
            int i3 = this.f3788e;
            while (i2 < i3) {
                int i4 = i2 + 1;
                char c3 = cArr[i2];
                if (c3 == c2) {
                    this.f3787d = i4;
                    return;
                }
                if (c3 == '\\') {
                    this.f3787d = i4;
                    z();
                    i2 = this.f3787d;
                    i3 = this.f3788e;
                } else {
                    if (c3 == '\n') {
                        this.f3789f++;
                        this.f3790g = i4;
                    }
                    i2 = i4;
                }
            }
            this.f3787d = i2;
        } while (a(1));
        throw b("Unterminated string");
    }

    private boolean a(String str) throws IOException {
        int length = str.length();
        while (true) {
            if (this.f3787d + length > this.f3788e && !a(length)) {
                return false;
            }
            char[] cArr = this.f3786c;
            int i2 = this.f3787d;
            if (cArr[i2] != '\n') {
                for (int i3 = 0; i3 < length; i3++) {
                    if (this.f3786c[this.f3787d + i3] != str.charAt(i3)) {
                        break;
                    }
                }
                return true;
            }
            this.f3789f++;
            this.f3790g = i2 + 1;
            this.f3787d++;
        }
    }

    private int c(boolean z2) throws IOException {
        char[] cArr = this.f3786c;
        int i2 = this.f3787d;
        int i3 = this.f3788e;
        while (true) {
            if (i2 == i3) {
                this.f3787d = i2;
                if (!a(1)) {
                    if (!z2) {
                        return -1;
                    }
                    throw new EOFException("End of input" + l());
                }
                i2 = this.f3787d;
                i3 = this.f3788e;
            }
            int i4 = i2 + 1;
            char c2 = cArr[i2];
            if (c2 == '\n') {
                this.f3789f++;
                this.f3790g = i4;
            } else if (c2 != ' ' && c2 != '\r' && c2 != '\t') {
                if (c2 == '/') {
                    this.f3787d = i4;
                    if (i4 == i3) {
                        this.f3787d--;
                        boolean zA = a(2);
                        this.f3787d++;
                        if (!zA) {
                            return c2;
                        }
                    }
                    u();
                    int i5 = this.f3787d;
                    char c3 = cArr[i5];
                    if (c3 == '*') {
                        this.f3787d = i5 + 1;
                        if (a("*/")) {
                            i2 = this.f3787d + 2;
                            i3 = this.f3788e;
                        } else {
                            throw b("Unterminated comment");
                        }
                    } else {
                        if (c3 != '/') {
                            return c2;
                        }
                        this.f3787d = i5 + 1;
                        A();
                        i2 = this.f3787d;
                        i3 = this.f3788e;
                    }
                } else if (c2 == '#') {
                    this.f3787d = i4;
                    u();
                    A();
                    i2 = this.f3787d;
                    i3 = this.f3788e;
                } else {
                    this.f3787d = i4;
                    return c2;
                }
            }
            i2 = i4;
        }
    }

    private void b(int i2) {
        int i3 = this.f3796m;
        int[] iArr = this.f3795l;
        if (i3 == iArr.length) {
            int i4 = i3 * 2;
            this.f3795l = Arrays.copyOf(iArr, i4);
            this.o = Arrays.copyOf(this.o, i4);
            this.f3797n = (String[]) Arrays.copyOf(this.f3797n, i4);
        }
        int[] iArr2 = this.f3795l;
        int i5 = this.f3796m;
        this.f3796m = i5 + 1;
        iArr2[i5] = i2;
    }

    private String b(boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append(h0.f12422b);
        for (int i2 = 0; i2 < this.f3796m; i2++) {
            int i3 = this.f3795l[i2];
            if (i3 == 1 || i3 == 2) {
                int i4 = this.o[i2];
                if (z2 && i4 > 0 && i2 == this.f3796m - 1) {
                    i4--;
                }
                sb.append('[');
                sb.append(i4);
                sb.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append('.');
                String[] strArr = this.f3797n;
                if (strArr[i2] != null) {
                    sb.append(strArr[i2]);
                }
            }
        }
        return sb.toString();
    }

    private IOException b(String str) throws IOException {
        throw new e(str + l());
    }
}
