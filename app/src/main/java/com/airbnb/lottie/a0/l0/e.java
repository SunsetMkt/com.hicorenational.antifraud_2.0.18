package com.airbnb.lottie.a0.l0;

import androidx.annotation.Nullable;
import com.airbnb.lottie.a0.l0.c;
import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: compiled from: JsonUtf8Reader.java */
/* JADX INFO: loaded from: classes.dex */
final class e extends c {
    private static final int A = 7;
    private static final int B = 8;
    private static final int C = 9;
    private static final int D = 10;
    private static final int E = 11;
    private static final int F = 12;
    private static final int G = 13;
    private static final int H = 14;
    private static final int I = 15;
    private static final int J = 16;
    private static final int K = 17;
    private static final int L = 18;
    private static final int M = 0;
    private static final int N = 1;
    private static final int O = 2;
    private static final int b0 = 3;
    private static final int c0 = 4;
    private static final int d0 = 5;
    private static final int e0 = 6;
    private static final int f0 = 7;

    /* JADX INFO: renamed from: n */
    private static final long f2059n = -922337203685477580L;
    private static final ByteString o = ByteString.encodeUtf8("'\\");
    private static final ByteString p = ByteString.encodeUtf8("\"\\");
    private static final ByteString q = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");
    private static final ByteString r = ByteString.encodeUtf8("\n\r");
    private static final ByteString s = ByteString.encodeUtf8("*/");
    private static final int t = 0;
    private static final int u = 1;
    private static final int v = 2;
    private static final int w = 3;
    private static final int x = 4;
    private static final int y = 5;
    private static final int z = 6;

    /* JADX INFO: renamed from: h */
    private final BufferedSource f2060h;

    /* JADX INFO: renamed from: i */
    private final Buffer f2061i;

    /* JADX INFO: renamed from: j */
    private int f2062j = 0;

    /* JADX INFO: renamed from: k */
    private long f2063k;

    /* JADX INFO: renamed from: l */
    private int f2064l;

    /* JADX INFO: renamed from: m */
    @Nullable
    private String f2065m;

    e(BufferedSource bufferedSource) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        }
        this.f2060h = bufferedSource;
        this.f2061i = bufferedSource.buffer();
        a(6);
    }

    private boolean b(int i2) throws IOException {
        if (i2 == 9 || i2 == 10 || i2 == 12 || i2 == 13 || i2 == 32) {
            return false;
        }
        if (i2 != 35) {
            if (i2 == 44) {
                return false;
            }
            if (i2 != 47 && i2 != 61) {
                if (i2 == 123 || i2 == 125 || i2 == 58) {
                    return false;
                }
                if (i2 != 59) {
                    switch (i2) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        p();
        return false;
    }

    private void p() throws IOException {
        if (!this.f2049e) {
            throw a("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private int q() throws IOException {
        int[] iArr = this.f2046b;
        int i2 = this.a;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int iA = a(true);
            this.f2061i.readByte();
            if (iA != 44) {
                if (iA != 59) {
                    if (iA != 93) {
                        throw a("Unterminated array");
                    }
                    this.f2062j = 4;
                    return 4;
                }
                p();
            }
        } else {
            if (i3 == 3 || i3 == 5) {
                this.f2046b[this.a - 1] = 4;
                if (i3 == 5) {
                    int iA2 = a(true);
                    this.f2061i.readByte();
                    if (iA2 != 44) {
                        if (iA2 != 59) {
                            if (iA2 != 125) {
                                throw a("Unterminated object");
                            }
                            this.f2062j = 2;
                            return 2;
                        }
                        p();
                    }
                }
                int iA3 = a(true);
                if (iA3 == 34) {
                    this.f2061i.readByte();
                    this.f2062j = 13;
                    return 13;
                }
                if (iA3 == 39) {
                    this.f2061i.readByte();
                    p();
                    this.f2062j = 12;
                    return 12;
                }
                if (iA3 != 125) {
                    p();
                    if (!b((char) iA3)) {
                        throw a("Expected name");
                    }
                    this.f2062j = 14;
                    return 14;
                }
                if (i3 == 5) {
                    throw a("Expected name");
                }
                this.f2061i.readByte();
                this.f2062j = 2;
                return 2;
            }
            if (i3 == 4) {
                iArr[i2 - 1] = 5;
                int iA4 = a(true);
                this.f2061i.readByte();
                if (iA4 != 58) {
                    if (iA4 != 61) {
                        throw a("Expected ':'");
                    }
                    p();
                    if (this.f2060h.request(1L) && this.f2061i.getByte(0L) == 62) {
                        this.f2061i.readByte();
                    }
                }
            } else if (i3 == 6) {
                iArr[i2 - 1] = 7;
            } else if (i3 == 7) {
                if (a(false) == -1) {
                    this.f2062j = 18;
                    return 18;
                }
                p();
            } else if (i3 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iA5 = a(true);
        if (iA5 == 34) {
            this.f2061i.readByte();
            this.f2062j = 9;
            return 9;
        }
        if (iA5 == 39) {
            p();
            this.f2061i.readByte();
            this.f2062j = 8;
            return 8;
        }
        if (iA5 != 44 && iA5 != 59) {
            if (iA5 == 91) {
                this.f2061i.readByte();
                this.f2062j = 3;
                return 3;
            }
            if (iA5 != 93) {
                if (iA5 == 123) {
                    this.f2061i.readByte();
                    this.f2062j = 1;
                    return 1;
                }
                int iS = s();
                if (iS != 0) {
                    return iS;
                }
                int iT = t();
                if (iT != 0) {
                    return iT;
                }
                if (!b(this.f2061i.getByte(0L))) {
                    throw a("Expected value");
                }
                p();
                this.f2062j = 10;
                return 10;
            }
            if (i3 == 1) {
                this.f2061i.readByte();
                this.f2062j = 4;
                return 4;
            }
        }
        if (i3 != 1 && i3 != 2) {
            throw a("Unexpected value");
        }
        p();
        this.f2062j = 7;
        return 7;
    }

    private String r() throws IOException {
        long jIndexOfElement = this.f2060h.indexOfElement(q);
        return jIndexOfElement != -1 ? this.f2061i.readUtf8(jIndexOfElement) : this.f2061i.readUtf8();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private int s() throws IOException {
        int i2;
        String str;
        String str2;
        byte b2 = this.f2061i.getByte(0L);
        if (b2 == 116 || b2 == 84) {
            i2 = 5;
            str = b.a.u.a.f1908j;
            str2 = "TRUE";
        } else if (b2 == 102 || b2 == 70) {
            i2 = 6;
            str = b.a.u.a.f1909k;
            str2 = "FALSE";
        } else {
            if (b2 != 110 && b2 != 78) {
                return 0;
            }
            i2 = 7;
            str = d.c.a.b.a.a.f10075h;
            str2 = "NULL";
        }
        int length = str.length();
        int i3 = 1;
        while (i3 < length) {
            int i4 = i3 + 1;
            if (!this.f2060h.request(i4)) {
                return 0;
            }
            byte b3 = this.f2061i.getByte(i3);
            if (b3 != str.charAt(i3) && b3 != str2.charAt(i3)) {
                return 0;
            }
            i3 = i4;
        }
        if (this.f2060h.request(length + 1) && b(this.f2061i.getByte(length))) {
            return 0;
        }
        this.f2061i.skip(length);
        this.f2062j = i2;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:159:0x0089, code lost:
    
        if (b(r11) != false) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x00c0, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int t() throws IOException {
        boolean z2 = true;
        int i2 = 0;
        long j2 = 0;
        int i3 = 0;
        char c2 = 0;
        boolean z3 = true;
        boolean z4 = false;
        while (true) {
            int i4 = i3 + 1;
            if (!this.f2060h.request(i4)) {
                break;
            }
            byte b2 = this.f2061i.getByte(i3);
            if (b2 != 43) {
                if (b2 == 69 || b2 == 101) {
                    if (c2 != 2 && c2 != 4) {
                        return i2;
                    }
                    c2 = 5;
                } else if (b2 != 45) {
                    if (b2 != 46) {
                        if (b2 < 48 || b2 > 57) {
                            break;
                        }
                        if (c2 == z2 || c2 == 0) {
                            j2 = -(b2 - 48);
                            i2 = 0;
                            c2 = 2;
                        } else {
                            if (c2 == 2) {
                                if (j2 == 0) {
                                    return i2;
                                }
                                long j3 = (10 * j2) - ((long) (b2 - 48));
                                z3 = (j2 > -922337203685477580L || (j2 == -922337203685477580L && j3 < j2)) & z3;
                                j2 = j3;
                            } else if (c2 == 3) {
                                i2 = 0;
                                c2 = 4;
                            } else if (c2 == 5 || c2 == 6) {
                                i2 = 0;
                                c2 = 7;
                            }
                            i2 = 0;
                        }
                    } else {
                        if (c2 != 2) {
                            return i2;
                        }
                        c2 = 3;
                    }
                } else if (c2 == 0) {
                    c2 = 1;
                    z4 = true;
                } else if (c2 != 5) {
                    return i2;
                }
                i3 = i4;
                z2 = true;
            } else if (c2 != 5) {
                return i2;
            }
            c2 = 6;
            i3 = i4;
            z2 = true;
        }
        if (c2 == 2 && z3 && ((j2 != Long.MIN_VALUE || z4) && (j2 != 0 || !z4))) {
            if (!z4) {
                j2 = -j2;
            }
            this.f2063k = j2;
            this.f2061i.skip(i3);
            this.f2062j = 16;
            return 16;
        }
        if (c2 != 2 && c2 != 4 && c2 != 7) {
            return 0;
        }
        this.f2064l = i3;
        this.f2062j = 17;
        return 17;
    }

    private char u() throws IOException {
        int i2;
        int i3;
        if (!this.f2060h.request(1L)) {
            throw a("Unterminated escape sequence");
        }
        byte b2 = this.f2061i.readByte();
        if (b2 == 10 || b2 == 34 || b2 == 39 || b2 == 47 || b2 == 92) {
            return (char) b2;
        }
        if (b2 == 98) {
            return '\b';
        }
        if (b2 == 102) {
            return '\f';
        }
        if (b2 == 110) {
            return '\n';
        }
        if (b2 == 114) {
            return '\r';
        }
        if (b2 == 116) {
            return '\t';
        }
        if (b2 != 117) {
            if (this.f2049e) {
                return (char) b2;
            }
            throw a("Invalid escape sequence: \\" + ((char) b2));
        }
        if (!this.f2060h.request(4L)) {
            throw new EOFException("Unterminated escape sequence at path " + g());
        }
        char c2 = 0;
        for (int i4 = 0; i4 < 4; i4++) {
            byte b3 = this.f2061i.getByte(i4);
            char c3 = (char) (c2 << 4);
            if (b3 < 48 || b3 > 57) {
                if (b3 >= 97 && b3 <= 102) {
                    i2 = b3 - 97;
                } else {
                    if (b3 < 65 || b3 > 70) {
                        throw a("\\u" + this.f2061i.readUtf8(4L));
                    }
                    i2 = b3 - 65;
                }
                i3 = i2 + 10;
            } else {
                i3 = b3 - 48;
            }
            c2 = (char) (c3 + i3);
        }
        this.f2061i.skip(4L);
        return c2;
    }

    private boolean v() throws IOException {
        long jIndexOf = this.f2060h.indexOf(s);
        boolean z2 = jIndexOf != -1;
        Buffer buffer = this.f2061i;
        buffer.skip(z2 ? jIndexOf + ((long) s.size()) : buffer.size());
        return z2;
    }

    private void w() throws IOException {
        long jIndexOfElement = this.f2060h.indexOfElement(r);
        Buffer buffer = this.f2061i;
        buffer.skip(jIndexOfElement != -1 ? jIndexOfElement + 1 : buffer.size());
    }

    private void x() throws IOException {
        long jIndexOfElement = this.f2060h.indexOfElement(q);
        Buffer buffer = this.f2061i;
        if (jIndexOfElement == -1) {
            jIndexOfElement = buffer.size();
        }
        buffer.skip(jIndexOfElement);
    }

    @Override // com.airbnb.lottie.a0.l0.c
    public int a(c.a aVar) throws IOException {
        int iQ = this.f2062j;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ < 12 || iQ > 15) {
            return -1;
        }
        if (iQ == 15) {
            return a(this.f2065m, aVar);
        }
        int iSelect = this.f2060h.select(aVar.f2051b);
        if (iSelect != -1) {
            this.f2062j = 0;
            this.f2047c[this.a - 1] = aVar.a[iSelect];
            return iSelect;
        }
        String str = this.f2047c[this.a - 1];
        String strL = l();
        int iA = a(strL, aVar);
        if (iA == -1) {
            this.f2062j = 15;
            this.f2065m = strL;
            this.f2047c[this.a - 1] = str;
        }
        return iA;
    }

    @Override // com.airbnb.lottie.a0.l0.c
    public void c() throws IOException {
        int iQ = this.f2062j;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ == 3) {
            a(1);
            this.f2048d[this.a - 1] = 0;
            this.f2062j = 0;
        } else {
            throw new a("Expected BEGIN_ARRAY but was " + peek() + " at path " + g());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f2062j = 0;
        this.f2046b[0] = 8;
        this.a = 1;
        this.f2061i.clear();
        this.f2060h.close();
    }

    @Override // com.airbnb.lottie.a0.l0.c
    public void d() throws IOException {
        int iQ = this.f2062j;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ == 1) {
            a(3);
            this.f2062j = 0;
            return;
        }
        throw new a("Expected BEGIN_OBJECT but was " + peek() + " at path " + g());
    }

    @Override // com.airbnb.lottie.a0.l0.c
    public void e() throws IOException {
        int iQ = this.f2062j;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ == 4) {
            this.a--;
            int[] iArr = this.f2048d;
            int i2 = this.a - 1;
            iArr[i2] = iArr[i2] + 1;
            this.f2062j = 0;
            return;
        }
        throw new a("Expected END_ARRAY but was " + peek() + " at path " + g());
    }

    @Override // com.airbnb.lottie.a0.l0.c
    public void f() throws IOException {
        int iQ = this.f2062j;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ != 2) {
            throw new a("Expected END_OBJECT but was " + peek() + " at path " + g());
        }
        this.a--;
        String[] strArr = this.f2047c;
        int i2 = this.a;
        strArr[i2] = null;
        int[] iArr = this.f2048d;
        int i3 = i2 - 1;
        iArr[i3] = iArr[i3] + 1;
        this.f2062j = 0;
    }

    @Override // com.airbnb.lottie.a0.l0.c
    public boolean h() throws IOException {
        int iQ = this.f2062j;
        if (iQ == 0) {
            iQ = q();
        }
        return (iQ == 2 || iQ == 4 || iQ == 18) ? false : true;
    }

    @Override // com.airbnb.lottie.a0.l0.c
    public boolean i() throws IOException {
        int iQ = this.f2062j;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ == 5) {
            this.f2062j = 0;
            int[] iArr = this.f2048d;
            int i2 = this.a - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        }
        if (iQ == 6) {
            this.f2062j = 0;
            int[] iArr2 = this.f2048d;
            int i3 = this.a - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        }
        throw new a("Expected a boolean but was " + peek() + " at path " + g());
    }

    @Override // com.airbnb.lottie.a0.l0.c
    public double j() throws IOException {
        int iQ = this.f2062j;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ == 16) {
            this.f2062j = 0;
            int[] iArr = this.f2048d;
            int i2 = this.a - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f2063k;
        }
        if (iQ == 17) {
            this.f2065m = this.f2061i.readUtf8(this.f2064l);
        } else if (iQ == 9) {
            this.f2065m = a(p);
        } else if (iQ == 8) {
            this.f2065m = a(o);
        } else if (iQ == 10) {
            this.f2065m = r();
        } else if (iQ != 11) {
            throw new a("Expected a double but was " + peek() + " at path " + g());
        }
        this.f2062j = 11;
        try {
            double d2 = Double.parseDouble(this.f2065m);
            if (this.f2049e || !(Double.isNaN(d2) || Double.isInfinite(d2))) {
                this.f2065m = null;
                this.f2062j = 0;
                int[] iArr2 = this.f2048d;
                int i3 = this.a - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return d2;
            }
            throw new b("JSON forbids NaN and infinities: " + d2 + " at path " + g());
        } catch (NumberFormatException unused) {
            throw new a("Expected a double but was " + this.f2065m + " at path " + g());
        }
    }

    @Override // com.airbnb.lottie.a0.l0.c
    public int k() throws IOException {
        int iQ = this.f2062j;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ == 16) {
            long j2 = this.f2063k;
            int i2 = (int) j2;
            if (j2 == i2) {
                this.f2062j = 0;
                int[] iArr = this.f2048d;
                int i3 = this.a - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            throw new a("Expected an int but was " + this.f2063k + " at path " + g());
        }
        if (iQ == 17) {
            this.f2065m = this.f2061i.readUtf8(this.f2064l);
        } else if (iQ == 9 || iQ == 8) {
            this.f2065m = iQ == 9 ? a(p) : a(o);
            try {
                int i4 = Integer.parseInt(this.f2065m);
                this.f2062j = 0;
                int[] iArr2 = this.f2048d;
                int i5 = this.a - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return i4;
            } catch (NumberFormatException unused) {
            }
        } else if (iQ != 11) {
            throw new a("Expected an int but was " + peek() + " at path " + g());
        }
        this.f2062j = 11;
        try {
            double d2 = Double.parseDouble(this.f2065m);
            int i6 = (int) d2;
            if (i6 == d2) {
                this.f2065m = null;
                this.f2062j = 0;
                int[] iArr3 = this.f2048d;
                int i7 = this.a - 1;
                iArr3[i7] = iArr3[i7] + 1;
                return i6;
            }
            throw new a("Expected an int but was " + this.f2065m + " at path " + g());
        } catch (NumberFormatException unused2) {
            throw new a("Expected an int but was " + this.f2065m + " at path " + g());
        }
    }

    @Override // com.airbnb.lottie.a0.l0.c
    public String l() throws IOException {
        String strA;
        int iQ = this.f2062j;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ == 14) {
            strA = r();
        } else if (iQ == 13) {
            strA = a(p);
        } else if (iQ == 12) {
            strA = a(o);
        } else {
            if (iQ != 15) {
                throw new a("Expected a name but was " + peek() + " at path " + g());
            }
            strA = this.f2065m;
        }
        this.f2062j = 0;
        this.f2047c[this.a - 1] = strA;
        return strA;
    }

    @Override // com.airbnb.lottie.a0.l0.c
    public String m() throws IOException {
        String utf8;
        int iQ = this.f2062j;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ == 10) {
            utf8 = r();
        } else if (iQ == 9) {
            utf8 = a(p);
        } else if (iQ == 8) {
            utf8 = a(o);
        } else if (iQ == 11) {
            utf8 = this.f2065m;
            this.f2065m = null;
        } else if (iQ == 16) {
            utf8 = Long.toString(this.f2063k);
        } else {
            if (iQ != 17) {
                throw new a("Expected a string but was " + peek() + " at path " + g());
            }
            utf8 = this.f2061i.readUtf8(this.f2064l);
        }
        this.f2062j = 0;
        int[] iArr = this.f2048d;
        int i2 = this.a - 1;
        iArr[i2] = iArr[i2] + 1;
        return utf8;
    }

    @Override // com.airbnb.lottie.a0.l0.c
    public void n() throws IOException {
        if (this.f2050f) {
            throw new a("Cannot skip unexpected " + peek() + " at " + g());
        }
        int iQ = this.f2062j;
        if (iQ == 0) {
            iQ = q();
        }
        if (iQ == 14) {
            x();
        } else if (iQ == 13) {
            b(p);
        } else if (iQ == 12) {
            b(o);
        } else if (iQ != 15) {
            throw new a("Expected a name but was " + peek() + " at path " + g());
        }
        this.f2062j = 0;
        this.f2047c[this.a - 1] = d.c.a.b.a.a.f10075h;
    }

    @Override // com.airbnb.lottie.a0.l0.c
    public void o() throws IOException {
        if (this.f2050f) {
            throw new a("Cannot skip unexpected " + peek() + " at " + g());
        }
        int i2 = 0;
        do {
            int iQ = this.f2062j;
            if (iQ == 0) {
                iQ = q();
            }
            if (iQ == 3) {
                a(1);
            } else if (iQ == 1) {
                a(3);
            } else {
                if (iQ == 4) {
                    i2--;
                    if (i2 < 0) {
                        throw new a("Expected a value but was " + peek() + " at path " + g());
                    }
                    this.a--;
                } else if (iQ == 2) {
                    i2--;
                    if (i2 < 0) {
                        throw new a("Expected a value but was " + peek() + " at path " + g());
                    }
                    this.a--;
                } else if (iQ == 14 || iQ == 10) {
                    x();
                } else if (iQ == 9 || iQ == 13) {
                    b(p);
                } else if (iQ == 8 || iQ == 12) {
                    b(o);
                } else if (iQ == 17) {
                    this.f2061i.skip(this.f2064l);
                } else if (iQ == 18) {
                    throw new a("Expected a value but was " + peek() + " at path " + g());
                }
                this.f2062j = 0;
            }
            i2++;
            this.f2062j = 0;
        } while (i2 != 0);
        int[] iArr = this.f2048d;
        int i3 = this.a;
        int i4 = i3 - 1;
        iArr[i4] = iArr[i4] + 1;
        this.f2047c[i3 - 1] = d.c.a.b.a.a.f10075h;
    }

    @Override // com.airbnb.lottie.a0.l0.c
    public c.b peek() throws IOException {
        int iQ = this.f2062j;
        if (iQ == 0) {
            iQ = q();
        }
        switch (iQ) {
            case 1:
                return c.b.BEGIN_OBJECT;
            case 2:
                return c.b.END_OBJECT;
            case 3:
                return c.b.BEGIN_ARRAY;
            case 4:
                return c.b.END_ARRAY;
            case 5:
            case 6:
                return c.b.BOOLEAN;
            case 7:
                return c.b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return c.b.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return c.b.NAME;
            case 16:
            case 17:
                return c.b.NUMBER;
            case 18:
                return c.b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public String toString() {
        return "JsonReader(" + this.f2060h + ")";
    }

    private int b(String str, c.a aVar) {
        int length = aVar.a.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(aVar.a[i2])) {
                this.f2062j = 0;
                int[] iArr = this.f2048d;
                int i3 = this.a - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
        }
        return -1;
    }

    private void b(ByteString byteString) throws IOException {
        while (true) {
            long jIndexOfElement = this.f2060h.indexOfElement(byteString);
            if (jIndexOfElement != -1) {
                if (this.f2061i.getByte(jIndexOfElement) == 92) {
                    this.f2061i.skip(jIndexOfElement + 1);
                    u();
                } else {
                    this.f2061i.skip(jIndexOfElement + 1);
                    return;
                }
            } else {
                throw a("Unterminated string");
            }
        }
    }

    private int a(String str, c.a aVar) {
        int length = aVar.a.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(aVar.a[i2])) {
                this.f2062j = 0;
                this.f2047c[this.a - 1] = str;
                return i2;
            }
        }
        return -1;
    }

    private String a(ByteString byteString) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long jIndexOfElement = this.f2060h.indexOfElement(byteString);
            if (jIndexOfElement != -1) {
                if (this.f2061i.getByte(jIndexOfElement) != 92) {
                    if (sb == null) {
                        String utf8 = this.f2061i.readUtf8(jIndexOfElement);
                        this.f2061i.readByte();
                        return utf8;
                    }
                    sb.append(this.f2061i.readUtf8(jIndexOfElement));
                    this.f2061i.readByte();
                    return sb.toString();
                }
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(this.f2061i.readUtf8(jIndexOfElement));
                this.f2061i.readByte();
                sb.append(u());
            } else {
                throw a("Unterminated string");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x0025, code lost:
    
        r6.f2061i.skip(r3 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x002f, code lost:
    
        if (r1 != 47) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0039, code lost:
    
        if (r6.f2060h.request(2) != false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x003b, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x003c, code lost:
    
        p();
        r3 = r6.f2061i.getByte(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0049, code lost:
    
        if (r3 == 42) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x004b, code lost:
    
        if (r3 == 47) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x004d, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x004e, code lost:
    
        r6.f2061i.readByte();
        r6.f2061i.readByte();
        w();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x005c, code lost:
    
        r6.f2061i.readByte();
        r6.f2061i.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x006a, code lost:
    
        if (v() == false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0073, code lost:
    
        throw a("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0076, code lost:
    
        if (r1 != 35) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0078, code lost:
    
        p();
        w();
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x007f, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int a(boolean z2) throws IOException {
        while (true) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (!this.f2060h.request(i3)) {
                    if (z2) {
                        throw new EOFException("End of input");
                    }
                    return -1;
                }
                byte b2 = this.f2061i.getByte(i2);
                if (b2 != 10 && b2 != 32 && b2 != 13 && b2 != 9) {
                    break;
                }
                i2 = i3;
            }
        }
    }
}
