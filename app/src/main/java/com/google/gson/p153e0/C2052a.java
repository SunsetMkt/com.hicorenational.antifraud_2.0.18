package com.google.gson.p153e0;

import com.google.gson.p147b0.AbstractC2014g;
import com.google.gson.p147b0.p148q.C2029f;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import p000a.p001a.p014u.C0052a;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p286h.p323z2.C5736h0;

/* compiled from: JsonReader.java */
/* renamed from: com.google.gson.e0.a */
/* loaded from: classes.dex */
public class C2052a implements Closeable {

    /* renamed from: A */
    private static final int f5941A = 10;

    /* renamed from: B */
    private static final int f5942B = 11;

    /* renamed from: C */
    private static final int f5943C = 12;

    /* renamed from: D */
    private static final int f5944D = 13;

    /* renamed from: E */
    private static final int f5945E = 14;

    /* renamed from: F */
    private static final int f5946F = 15;

    /* renamed from: G */
    private static final int f5947G = 16;

    /* renamed from: H */
    private static final int f5948H = 17;

    /* renamed from: I */
    private static final int f5949I = 0;

    /* renamed from: J */
    private static final int f5950J = 1;

    /* renamed from: K */
    private static final int f5951K = 2;

    /* renamed from: L */
    private static final int f5952L = 3;

    /* renamed from: M */
    private static final int f5953M = 4;

    /* renamed from: N */
    private static final int f5954N = 5;

    /* renamed from: O */
    private static final int f5955O = 6;

    /* renamed from: b0 */
    private static final int f5956b0 = 7;

    /* renamed from: c0 */
    static final int f5957c0 = 1024;

    /* renamed from: p */
    private static final long f5958p = -922337203685477580L;

    /* renamed from: q */
    private static final int f5959q = 0;

    /* renamed from: r */
    private static final int f5960r = 1;

    /* renamed from: s */
    private static final int f5961s = 2;

    /* renamed from: t */
    private static final int f5962t = 3;

    /* renamed from: u */
    private static final int f5963u = 4;

    /* renamed from: v */
    private static final int f5964v = 5;

    /* renamed from: w */
    private static final int f5965w = 6;

    /* renamed from: x */
    private static final int f5966x = 7;

    /* renamed from: y */
    private static final int f5967y = 8;

    /* renamed from: z */
    private static final int f5968z = 9;

    /* renamed from: a */
    private final Reader f5969a;

    /* renamed from: i */
    private long f5977i;

    /* renamed from: j */
    private int f5978j;

    /* renamed from: k */
    private String f5979k;

    /* renamed from: m */
    private int f5981m;

    /* renamed from: n */
    private String[] f5982n;

    /* renamed from: o */
    private int[] f5983o;

    /* renamed from: b */
    private boolean f5970b = false;

    /* renamed from: c */
    private final char[] f5971c = new char[1024];

    /* renamed from: d */
    private int f5972d = 0;

    /* renamed from: e */
    private int f5973e = 0;

    /* renamed from: f */
    private int f5974f = 0;

    /* renamed from: g */
    private int f5975g = 0;

    /* renamed from: h */
    int f5976h = 0;

    /* renamed from: l */
    private int[] f5980l = new int[32];

    /* compiled from: JsonReader.java */
    /* renamed from: com.google.gson.e0.a$a */
    class a extends AbstractC2014g {
        a() {
        }

        @Override // com.google.gson.p147b0.AbstractC2014g
        /* renamed from: a */
        public void mo5362a(C2052a c2052a) throws IOException {
            if (c2052a instanceof C2029f) {
                ((C2029f) c2052a).m5433v();
                return;
            }
            int i2 = c2052a.f5976h;
            if (i2 == 0) {
                i2 = c2052a.m5610e();
            }
            if (i2 == 13) {
                c2052a.f5976h = 9;
                return;
            }
            if (i2 == 12) {
                c2052a.f5976h = 8;
                return;
            }
            if (i2 == 14) {
                c2052a.f5976h = 10;
                return;
            }
            throw new IllegalStateException("Expected a name but was " + c2052a.peek() + c2052a.m5612l());
        }
    }

    static {
        AbstractC2014g.f5687a = new a();
    }

    public C2052a(Reader reader) {
        this.f5981m = 0;
        int[] iArr = this.f5980l;
        int i2 = this.f5981m;
        this.f5981m = i2 + 1;
        iArr[i2] = 6;
        this.f5982n = new String[32];
        this.f5983o = new int[32];
        this.f5969a = (Reader) Objects.requireNonNull(reader, "in == null");
    }

    /* renamed from: A */
    private void m5592A() throws IOException {
        char c2;
        do {
            if (this.f5972d >= this.f5973e && !m5595a(1)) {
                return;
            }
            char[] cArr = this.f5971c;
            int i2 = this.f5972d;
            this.f5972d = i2 + 1;
            c2 = cArr[i2];
            if (c2 == '\n') {
                this.f5974f++;
                this.f5975g = this.f5972d;
                return;
            }
        } while (c2 != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
    
        m5603u();
     */
    /* renamed from: B */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m5593B() throws java.io.IOException {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.f5972d
            int r2 = r1 + r0
            int r3 = r4.f5973e
            if (r2 >= r3) goto L51
            char[] r2 = r4.f5971c
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L4b
            r2 = 10
            if (r1 == r2) goto L4b
            r2 = 12
            if (r1 == r2) goto L4b
            r2 = 13
            if (r1 == r2) goto L4b
            r2 = 32
            if (r1 == r2) goto L4b
            r2 = 35
            if (r1 == r2) goto L48
            r2 = 44
            if (r1 == r2) goto L4b
            r2 = 47
            if (r1 == r2) goto L48
            r2 = 61
            if (r1 == r2) goto L48
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L4b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L4b
            r2 = 58
            if (r1 == r2) goto L4b
            r2 = 59
            if (r1 == r2) goto L48
            switch(r1) {
                case 91: goto L4b;
                case 92: goto L48;
                case 93: goto L4b;
                default: goto L45;
            }
        L45:
            int r0 = r0 + 1
            goto L1
        L48:
            r4.m5603u()
        L4b:
            int r1 = r4.f5972d
            int r1 = r1 + r0
            r4.f5972d = r1
            return
        L51:
            int r1 = r1 + r0
            r4.f5972d = r1
            r0 = 1
            boolean r0 = r4.m5595a(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.p153e0.C2052a.m5593B():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x005b, code lost:
    
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005d, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r4) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006b, code lost:
    
        r1.append(r0, r4, r2 - r4);
        r9.f5972d = r2;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m5598b(char r10) throws java.io.IOException {
        /*
            r9 = this;
            char[] r0 = r9.f5971c
            r1 = 0
        L3:
            int r2 = r9.f5972d
            int r3 = r9.f5973e
        L7:
            r4 = r2
        L8:
            r5 = 16
            r6 = 1
            if (r2 >= r3) goto L5b
            int r7 = r2 + 1
            char r2 = r0[r2]
            if (r2 != r10) goto L27
            r9.f5972d = r7
            int r7 = r7 - r4
            int r7 = r7 - r6
            if (r1 != 0) goto L1f
            java.lang.String r10 = new java.lang.String
            r10.<init>(r0, r4, r7)
            return r10
        L1f:
            r1.append(r0, r4, r7)
            java.lang.String r10 = r1.toString()
            return r10
        L27:
            r8 = 92
            if (r2 != r8) goto L4e
            r9.f5972d = r7
            int r7 = r7 - r4
            int r7 = r7 - r6
            if (r1 != 0) goto L3f
            int r1 = r7 + 1
            int r1 = r1 * 2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r2.<init>(r1)
            r1 = r2
        L3f:
            r1.append(r0, r4, r7)
            char r2 = r9.m5608z()
            r1.append(r2)
            int r2 = r9.f5972d
            int r3 = r9.f5973e
            goto L7
        L4e:
            r5 = 10
            if (r2 != r5) goto L59
            int r2 = r9.f5974f
            int r2 = r2 + r6
            r9.f5974f = r2
            r9.f5975g = r7
        L59:
            r2 = r7
            goto L8
        L5b:
            if (r1 != 0) goto L6b
            int r1 = r2 - r4
            int r1 = r1 * 2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r3.<init>(r1)
            r1 = r3
        L6b:
            int r3 = r2 - r4
            r1.append(r0, r4, r3)
            r9.f5972d = r2
            boolean r2 = r9.m5595a(r6)
            if (r2 == 0) goto L79
            goto L3
        L79:
            java.lang.String r10 = "Unterminated string"
            java.io.IOException r10 = r9.m5597b(r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.p153e0.C2052a.m5598b(char):java.lang.String");
    }

    /* renamed from: u */
    private void m5603u() throws IOException {
        if (!this.f5970b) {
            throw m5597b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    /* renamed from: v */
    private void m5604v() throws IOException {
        m5601c(true);
        this.f5972d--;
        if (this.f5972d + 5 <= this.f5973e || m5595a(5)) {
            int i2 = this.f5972d;
            char[] cArr = this.f5971c;
            if (cArr[i2] == ')' && cArr[i2 + 1] == ']' && cArr[i2 + 2] == '}' && cArr[i2 + 3] == '\'' && cArr[i2 + 4] == '\n') {
                this.f5972d = i2 + 5;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x004b, code lost:
    
        m5603u();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:54:0x0045. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008b  */
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m5605w() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
            r2 = r1
        L3:
            r1 = 0
        L4:
            int r3 = r6.f5972d
            int r4 = r3 + r1
            int r5 = r6.f5973e
            if (r4 >= r5) goto L4f
            char[] r4 = r6.f5971c
            int r3 = r3 + r1
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L5d
            r4 = 10
            if (r3 == r4) goto L5d
            r4 = 12
            if (r3 == r4) goto L5d
            r4 = 13
            if (r3 == r4) goto L5d
            r4 = 32
            if (r3 == r4) goto L5d
            r4 = 35
            if (r3 == r4) goto L4b
            r4 = 44
            if (r3 == r4) goto L5d
            r4 = 47
            if (r3 == r4) goto L4b
            r4 = 61
            if (r3 == r4) goto L4b
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5d
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5d
            r4 = 58
            if (r3 == r4) goto L5d
            r4 = 59
            if (r3 == r4) goto L4b
            switch(r3) {
                case 91: goto L5d;
                case 92: goto L4b;
                case 93: goto L5d;
                default: goto L48;
            }
        L48:
            int r1 = r1 + 1
            goto L4
        L4b:
            r6.m5603u()
            goto L5d
        L4f:
            char[] r3 = r6.f5971c
            int r3 = r3.length
            if (r1 >= r3) goto L5f
            int r3 = r1 + 1
            boolean r3 = r6.m5595a(r3)
            if (r3 == 0) goto L5d
            goto L4
        L5d:
            r0 = r1
            goto L7f
        L5f:
            if (r2 != 0) goto L6c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r1, r3)
            r2.<init>(r3)
        L6c:
            char[] r3 = r6.f5971c
            int r4 = r6.f5972d
            r2.append(r3, r4, r1)
            int r3 = r6.f5972d
            int r3 = r3 + r1
            r6.f5972d = r3
            r1 = 1
            boolean r1 = r6.m5595a(r1)
            if (r1 != 0) goto L3
        L7f:
            if (r2 != 0) goto L8b
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.f5971c
            int r3 = r6.f5972d
            r1.<init>(r2, r3, r0)
            goto L96
        L8b:
            char[] r1 = r6.f5971c
            int r3 = r6.f5972d
            r2.append(r1, r3, r0)
            java.lang.String r1 = r2.toString()
        L96:
            int r2 = r6.f5972d
            int r2 = r2 + r0
            r6.f5972d = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.p153e0.C2052a.m5605w():java.lang.String");
    }

    /* renamed from: x */
    private int m5606x() throws IOException {
        int i2;
        String str;
        String str2;
        char c2 = this.f5971c[this.f5972d];
        if (c2 == 't' || c2 == 'T') {
            i2 = 5;
            str = C0052a.f158j;
            str2 = "TRUE";
        } else if (c2 == 'f' || c2 == 'F') {
            i2 = 6;
            str = C0052a.f159k;
            str2 = "FALSE";
        } else {
            if (c2 != 'n' && c2 != 'N') {
                return 0;
            }
            i2 = 7;
            str = AbstractC1191a.f2571h;
            str2 = "NULL";
        }
        int length = str.length();
        for (int i3 = 1; i3 < length; i3++) {
            if (this.f5972d + i3 >= this.f5973e && !m5595a(i3 + 1)) {
                return 0;
            }
            char c3 = this.f5971c[this.f5972d + i3];
            if (c3 != str.charAt(i3) && c3 != str2.charAt(i3)) {
                return 0;
            }
        }
        if ((this.f5972d + length < this.f5973e || m5595a(length + 1)) && m5594a(this.f5971c[this.f5972d + length])) {
            return 0;
        }
        this.f5972d += length;
        this.f5976h = i2;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x009a, code lost:
    
        if (r9 != 2) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x009c, code lost:
    
        if (r10 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x00a2, code lost:
    
        if (r11 != Long.MIN_VALUE) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00a4, code lost:
    
        if (r13 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00aa, code lost:
    
        if (r11 != 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00ac, code lost:
    
        if (r13 != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00ae, code lost:
    
        if (r13 == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b1, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b2, code lost:
    
        r18.f5977i = r11;
        r18.f5972d += r3;
        r18.f5976h = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00bd, code lost:
    
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00be, code lost:
    
        if (r9 == 2) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c1, code lost:
    
        if (r9 == 4) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00c4, code lost:
    
        if (r9 != 7) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c7, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c9, code lost:
    
        r18.f5978j = r3;
        r18.f5976h = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00cf, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0098, code lost:
    
        if (m5594a(r14) != false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00d0, code lost:
    
        return 0;
     */
    /* renamed from: y */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int m5607y() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.p153e0.C2052a.m5607y():int");
    }

    /* renamed from: z */
    private char m5608z() throws IOException {
        int i2;
        int i3;
        if (this.f5972d == this.f5973e && !m5595a(1)) {
            throw m5597b("Unterminated escape sequence");
        }
        char[] cArr = this.f5971c;
        int i4 = this.f5972d;
        this.f5972d = i4 + 1;
        char c2 = cArr[i4];
        if (c2 == '\n') {
            this.f5974f++;
            this.f5975g = this.f5972d;
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
                throw m5597b("Invalid escape sequence");
            }
            if (this.f5972d + 4 > this.f5973e && !m5595a(4)) {
                throw m5597b("Unterminated escape sequence");
            }
            char c3 = 0;
            int i5 = this.f5972d;
            int i6 = i5 + 4;
            while (i5 < i6) {
                char c4 = this.f5971c[i5];
                char c5 = (char) (c3 << 4);
                if (c4 < '0' || c4 > '9') {
                    if (c4 >= 'a' && c4 <= 'f') {
                        i2 = c4 - 'a';
                    } else {
                        if (c4 < 'A' || c4 > 'F') {
                            throw new NumberFormatException("\\u" + new String(this.f5971c, this.f5972d, 4));
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
            this.f5972d += 4;
            return c3;
        }
        return c2;
    }

    /* renamed from: a */
    public final void m5609a(boolean z) {
        this.f5970b = z;
    }

    /* renamed from: c */
    public void mo5417c() throws IOException {
        int i2 = this.f5976h;
        if (i2 == 0) {
            i2 = m5610e();
        }
        if (i2 == 3) {
            m5600b(1);
            this.f5983o[this.f5981m - 1] = 0;
            this.f5976h = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + peek() + m5612l());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f5976h = 0;
        this.f5980l[0] = 8;
        this.f5981m = 1;
        this.f5969a.close();
    }

    /* renamed from: d */
    public void mo5418d() throws IOException {
        int i2 = this.f5976h;
        if (i2 == 0) {
            i2 = m5610e();
        }
        if (i2 == 1) {
            m5600b(3);
            this.f5976h = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + peek() + m5612l());
        }
    }

    /* renamed from: e */
    int m5610e() throws IOException {
        int m5601c;
        int[] iArr = this.f5980l;
        int i2 = this.f5981m;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int m5601c2 = m5601c(true);
            if (m5601c2 != 44) {
                if (m5601c2 != 59) {
                    if (m5601c2 != 93) {
                        throw m5597b("Unterminated array");
                    }
                    this.f5976h = 4;
                    return 4;
                }
                m5603u();
            }
        } else {
            if (i3 == 3 || i3 == 5) {
                this.f5980l[this.f5981m - 1] = 4;
                if (i3 == 5 && (m5601c = m5601c(true)) != 44) {
                    if (m5601c != 59) {
                        if (m5601c != 125) {
                            throw m5597b("Unterminated object");
                        }
                        this.f5976h = 2;
                        return 2;
                    }
                    m5603u();
                }
                int m5601c3 = m5601c(true);
                if (m5601c3 == 34) {
                    this.f5976h = 13;
                    return 13;
                }
                if (m5601c3 == 39) {
                    m5603u();
                    this.f5976h = 12;
                    return 12;
                }
                if (m5601c3 == 125) {
                    if (i3 == 5) {
                        throw m5597b("Expected name");
                    }
                    this.f5976h = 2;
                    return 2;
                }
                m5603u();
                this.f5972d--;
                if (!m5594a((char) m5601c3)) {
                    throw m5597b("Expected name");
                }
                this.f5976h = 14;
                return 14;
            }
            if (i3 == 4) {
                iArr[i2 - 1] = 5;
                int m5601c4 = m5601c(true);
                if (m5601c4 != 58) {
                    if (m5601c4 != 61) {
                        throw m5597b("Expected ':'");
                    }
                    m5603u();
                    if (this.f5972d < this.f5973e || m5595a(1)) {
                        char[] cArr = this.f5971c;
                        int i4 = this.f5972d;
                        if (cArr[i4] == '>') {
                            this.f5972d = i4 + 1;
                        }
                    }
                }
            } else if (i3 == 6) {
                if (this.f5970b) {
                    m5604v();
                }
                this.f5980l[this.f5981m - 1] = 7;
            } else if (i3 == 7) {
                if (m5601c(false) == -1) {
                    this.f5976h = 17;
                    return 17;
                }
                m5603u();
                this.f5972d--;
            } else if (i3 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int m5601c5 = m5601c(true);
        if (m5601c5 == 34) {
            this.f5976h = 9;
            return 9;
        }
        if (m5601c5 == 39) {
            m5603u();
            this.f5976h = 8;
            return 8;
        }
        if (m5601c5 != 44 && m5601c5 != 59) {
            if (m5601c5 == 91) {
                this.f5976h = 3;
                return 3;
            }
            if (m5601c5 != 93) {
                if (m5601c5 == 123) {
                    this.f5976h = 1;
                    return 1;
                }
                this.f5972d--;
                int m5606x = m5606x();
                if (m5606x != 0) {
                    return m5606x;
                }
                int m5607y = m5607y();
                if (m5607y != 0) {
                    return m5607y;
                }
                if (!m5594a(this.f5971c[this.f5972d])) {
                    throw m5597b("Expected value");
                }
                m5603u();
                this.f5976h = 10;
                return 10;
            }
            if (i3 == 1) {
                this.f5976h = 4;
                return 4;
            }
        }
        if (i3 != 1 && i3 != 2) {
            throw m5597b("Unexpected value");
        }
        m5603u();
        this.f5972d--;
        this.f5976h = 7;
        return 7;
    }

    /* renamed from: f */
    public void mo5419f() throws IOException {
        int i2 = this.f5976h;
        if (i2 == 0) {
            i2 = m5610e();
        }
        if (i2 != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + peek() + m5612l());
        }
        this.f5981m--;
        int[] iArr = this.f5983o;
        int i3 = this.f5981m - 1;
        iArr[i3] = iArr[i3] + 1;
        this.f5976h = 0;
    }

    /* renamed from: g */
    public void mo5420g() throws IOException {
        int i2 = this.f5976h;
        if (i2 == 0) {
            i2 = m5610e();
        }
        if (i2 != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + peek() + m5612l());
        }
        this.f5981m--;
        String[] strArr = this.f5982n;
        int i3 = this.f5981m;
        strArr[i3] = null;
        int[] iArr = this.f5983o;
        int i4 = i3 - 1;
        iArr[i4] = iArr[i4] + 1;
        this.f5976h = 0;
    }

    /* renamed from: h */
    public String mo5421h() {
        return m5599b(false);
    }

    /* renamed from: i */
    public String mo5422i() {
        return m5599b(true);
    }

    /* renamed from: j */
    public boolean mo5423j() throws IOException {
        int i2 = this.f5976h;
        if (i2 == 0) {
            i2 = m5610e();
        }
        return (i2 == 2 || i2 == 4 || i2 == 17) ? false : true;
    }

    /* renamed from: k */
    public final boolean m5611k() {
        return this.f5970b;
    }

    /* renamed from: l */
    String m5612l() {
        return " at line " + (this.f5974f + 1) + " column " + ((this.f5972d - this.f5975g) + 1) + " path " + mo5421h();
    }

    /* renamed from: m */
    public boolean mo5424m() throws IOException {
        int i2 = this.f5976h;
        if (i2 == 0) {
            i2 = m5610e();
        }
        if (i2 == 5) {
            this.f5976h = 0;
            int[] iArr = this.f5983o;
            int i3 = this.f5981m - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        }
        if (i2 == 6) {
            this.f5976h = 0;
            int[] iArr2 = this.f5983o;
            int i4 = this.f5981m - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + peek() + m5612l());
    }

    /* renamed from: n */
    public double mo5425n() throws IOException {
        int i2 = this.f5976h;
        if (i2 == 0) {
            i2 = m5610e();
        }
        if (i2 == 15) {
            this.f5976h = 0;
            int[] iArr = this.f5983o;
            int i3 = this.f5981m - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.f5977i;
        }
        if (i2 == 16) {
            this.f5979k = new String(this.f5971c, this.f5972d, this.f5978j);
            this.f5972d += this.f5978j;
        } else if (i2 == 8 || i2 == 9) {
            this.f5979k = m5598b(i2 == 8 ? '\'' : C5736h0.f20712a);
        } else if (i2 == 10) {
            this.f5979k = m5605w();
        } else if (i2 != 11) {
            throw new IllegalStateException("Expected a double but was " + peek() + m5612l());
        }
        this.f5976h = 11;
        double parseDouble = Double.parseDouble(this.f5979k);
        if (!this.f5970b && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new C2056e("JSON forbids NaN and infinities: " + parseDouble + m5612l());
        }
        this.f5979k = null;
        this.f5976h = 0;
        int[] iArr2 = this.f5983o;
        int i4 = this.f5981m - 1;
        iArr2[i4] = iArr2[i4] + 1;
        return parseDouble;
    }

    /* renamed from: o */
    public int mo5426o() throws IOException {
        int i2 = this.f5976h;
        if (i2 == 0) {
            i2 = m5610e();
        }
        if (i2 == 15) {
            long j2 = this.f5977i;
            int i3 = (int) j2;
            if (j2 == i3) {
                this.f5976h = 0;
                int[] iArr = this.f5983o;
                int i4 = this.f5981m - 1;
                iArr[i4] = iArr[i4] + 1;
                return i3;
            }
            throw new NumberFormatException("Expected an int but was " + this.f5977i + m5612l());
        }
        if (i2 == 16) {
            this.f5979k = new String(this.f5971c, this.f5972d, this.f5978j);
            this.f5972d += this.f5978j;
        } else {
            if (i2 != 8 && i2 != 9 && i2 != 10) {
                throw new IllegalStateException("Expected an int but was " + peek() + m5612l());
            }
            if (i2 == 10) {
                this.f5979k = m5605w();
            } else {
                this.f5979k = m5598b(i2 == 8 ? '\'' : C5736h0.f20712a);
            }
            try {
                int parseInt = Integer.parseInt(this.f5979k);
                this.f5976h = 0;
                int[] iArr2 = this.f5983o;
                int i5 = this.f5981m - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.f5976h = 11;
        double parseDouble = Double.parseDouble(this.f5979k);
        int i6 = (int) parseDouble;
        if (i6 != parseDouble) {
            throw new NumberFormatException("Expected an int but was " + this.f5979k + m5612l());
        }
        this.f5979k = null;
        this.f5976h = 0;
        int[] iArr3 = this.f5983o;
        int i7 = this.f5981m - 1;
        iArr3[i7] = iArr3[i7] + 1;
        return i6;
    }

    /* renamed from: p */
    public long mo5427p() throws IOException {
        int i2 = this.f5976h;
        if (i2 == 0) {
            i2 = m5610e();
        }
        if (i2 == 15) {
            this.f5976h = 0;
            int[] iArr = this.f5983o;
            int i3 = this.f5981m - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.f5977i;
        }
        if (i2 == 16) {
            this.f5979k = new String(this.f5971c, this.f5972d, this.f5978j);
            this.f5972d += this.f5978j;
        } else {
            if (i2 != 8 && i2 != 9 && i2 != 10) {
                throw new IllegalStateException("Expected a long but was " + peek() + m5612l());
            }
            if (i2 == 10) {
                this.f5979k = m5605w();
            } else {
                this.f5979k = m5598b(i2 == 8 ? '\'' : C5736h0.f20712a);
            }
            try {
                long parseLong = Long.parseLong(this.f5979k);
                this.f5976h = 0;
                int[] iArr2 = this.f5983o;
                int i4 = this.f5981m - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.f5976h = 11;
        double parseDouble = Double.parseDouble(this.f5979k);
        long j2 = (long) parseDouble;
        if (j2 != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.f5979k + m5612l());
        }
        this.f5979k = null;
        this.f5976h = 0;
        int[] iArr3 = this.f5983o;
        int i5 = this.f5981m - 1;
        iArr3[i5] = iArr3[i5] + 1;
        return j2;
    }

    public EnumC2054c peek() throws IOException {
        int i2 = this.f5976h;
        if (i2 == 0) {
            i2 = m5610e();
        }
        switch (i2) {
            case 1:
                return EnumC2054c.BEGIN_OBJECT;
            case 2:
                return EnumC2054c.END_OBJECT;
            case 3:
                return EnumC2054c.BEGIN_ARRAY;
            case 4:
                return EnumC2054c.END_ARRAY;
            case 5:
            case 6:
                return EnumC2054c.BOOLEAN;
            case 7:
                return EnumC2054c.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return EnumC2054c.STRING;
            case 12:
            case 13:
            case 14:
                return EnumC2054c.NAME;
            case 15:
            case 16:
                return EnumC2054c.NUMBER;
            case 17:
                return EnumC2054c.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    /* renamed from: q */
    public String mo5428q() throws IOException {
        String m5598b;
        int i2 = this.f5976h;
        if (i2 == 0) {
            i2 = m5610e();
        }
        if (i2 == 14) {
            m5598b = m5605w();
        } else if (i2 == 12) {
            m5598b = m5598b('\'');
        } else {
            if (i2 != 13) {
                throw new IllegalStateException("Expected a name but was " + peek() + m5612l());
            }
            m5598b = m5598b(C5736h0.f20712a);
        }
        this.f5976h = 0;
        this.f5982n[this.f5981m - 1] = m5598b;
        return m5598b;
    }

    /* renamed from: r */
    public void mo5429r() throws IOException {
        int i2 = this.f5976h;
        if (i2 == 0) {
            i2 = m5610e();
        }
        if (i2 == 7) {
            this.f5976h = 0;
            int[] iArr = this.f5983o;
            int i3 = this.f5981m - 1;
            iArr[i3] = iArr[i3] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + peek() + m5612l());
    }

    /* renamed from: s */
    public String mo5430s() throws IOException {
        String str;
        int i2 = this.f5976h;
        if (i2 == 0) {
            i2 = m5610e();
        }
        if (i2 == 10) {
            str = m5605w();
        } else if (i2 == 8) {
            str = m5598b('\'');
        } else if (i2 == 9) {
            str = m5598b(C5736h0.f20712a);
        } else if (i2 == 11) {
            str = this.f5979k;
            this.f5979k = null;
        } else if (i2 == 15) {
            str = Long.toString(this.f5977i);
        } else {
            if (i2 != 16) {
                throw new IllegalStateException("Expected a string but was " + peek() + m5612l());
            }
            str = new String(this.f5971c, this.f5972d, this.f5978j);
            this.f5972d += this.f5978j;
        }
        this.f5976h = 0;
        int[] iArr = this.f5983o;
        int i3 = this.f5981m - 1;
        iArr[i3] = iArr[i3] + 1;
        return str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: t */
    public void mo5431t() throws IOException {
        int i2 = 0;
        do {
            int i3 = this.f5976h;
            if (i3 == 0) {
                i3 = m5610e();
            }
            switch (i3) {
                case 1:
                    m5600b(3);
                    i2++;
                    this.f5976h = 0;
                    break;
                case 2:
                    if (i2 == 0) {
                        this.f5982n[this.f5981m - 1] = null;
                    }
                    this.f5981m--;
                    i2--;
                    this.f5976h = 0;
                    break;
                case 3:
                    m5600b(1);
                    i2++;
                    this.f5976h = 0;
                    break;
                case 4:
                    this.f5981m--;
                    i2--;
                    this.f5976h = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case 15:
                default:
                    this.f5976h = 0;
                    break;
                case 8:
                    m5602c('\'');
                    this.f5976h = 0;
                    break;
                case 9:
                    m5602c(C5736h0.f20712a);
                    this.f5976h = 0;
                    break;
                case 10:
                    m5593B();
                    this.f5976h = 0;
                    break;
                case 12:
                    m5602c('\'');
                    if (i2 == 0) {
                        this.f5982n[this.f5981m - 1] = "<skipped>";
                    }
                    this.f5976h = 0;
                    break;
                case 13:
                    m5602c(C5736h0.f20712a);
                    if (i2 == 0) {
                        this.f5982n[this.f5981m - 1] = "<skipped>";
                    }
                    this.f5976h = 0;
                    break;
                case 14:
                    m5593B();
                    if (i2 == 0) {
                        this.f5982n[this.f5981m - 1] = "<skipped>";
                    }
                    this.f5976h = 0;
                    break;
                case 16:
                    this.f5972d += this.f5978j;
                    this.f5976h = 0;
                    break;
                case 17:
                    break;
            }
            return;
        } while (i2 > 0);
        int[] iArr = this.f5983o;
        int i4 = this.f5981m - 1;
        iArr[i4] = iArr[i4] + 1;
    }

    public String toString() {
        return getClass().getSimpleName() + m5612l();
    }

    /* renamed from: a */
    private boolean m5594a(char c2) throws IOException {
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
        m5603u();
        return false;
    }

    /* renamed from: a */
    private boolean m5595a(int i2) throws IOException {
        int i3;
        char[] cArr = this.f5971c;
        int i4 = this.f5975g;
        int i5 = this.f5972d;
        this.f5975g = i4 - i5;
        int i6 = this.f5973e;
        if (i6 != i5) {
            this.f5973e = i6 - i5;
            System.arraycopy(cArr, i5, cArr, 0, this.f5973e);
        } else {
            this.f5973e = 0;
        }
        this.f5972d = 0;
        do {
            Reader reader = this.f5969a;
            int i7 = this.f5973e;
            int read = reader.read(cArr, i7, cArr.length - i7);
            if (read == -1) {
                return false;
            }
            this.f5973e += read;
            if (this.f5974f == 0 && (i3 = this.f5975g) == 0 && this.f5973e > 0 && cArr[0] == 65279) {
                this.f5972d++;
                this.f5975g = i3 + 1;
                i2++;
            }
        } while (this.f5973e < i2);
        return true;
    }

    /* renamed from: c */
    private void m5602c(char c2) throws IOException {
        char[] cArr = this.f5971c;
        do {
            int i2 = this.f5972d;
            int i3 = this.f5973e;
            while (i2 < i3) {
                int i4 = i2 + 1;
                char c3 = cArr[i2];
                if (c3 == c2) {
                    this.f5972d = i4;
                    return;
                }
                if (c3 == '\\') {
                    this.f5972d = i4;
                    m5608z();
                    i2 = this.f5972d;
                    i3 = this.f5973e;
                } else {
                    if (c3 == '\n') {
                        this.f5974f++;
                        this.f5975g = i4;
                    }
                    i2 = i4;
                }
            }
            this.f5972d = i2;
        } while (m5595a(1));
        throw m5597b("Unterminated string");
    }

    /* renamed from: a */
    private boolean m5596a(String str) throws IOException {
        int length = str.length();
        while (true) {
            if (this.f5972d + length > this.f5973e && !m5595a(length)) {
                return false;
            }
            char[] cArr = this.f5971c;
            int i2 = this.f5972d;
            if (cArr[i2] != '\n') {
                for (int i3 = 0; i3 < length; i3++) {
                    if (this.f5971c[this.f5972d + i3] != str.charAt(i3)) {
                        break;
                    }
                }
                return true;
            }
            this.f5974f++;
            this.f5975g = i2 + 1;
            this.f5972d++;
        }
    }

    /* renamed from: c */
    private int m5601c(boolean z) throws IOException {
        char[] cArr = this.f5971c;
        int i2 = this.f5972d;
        int i3 = this.f5973e;
        while (true) {
            if (i2 == i3) {
                this.f5972d = i2;
                if (!m5595a(1)) {
                    if (!z) {
                        return -1;
                    }
                    throw new EOFException("End of input" + m5612l());
                }
                i2 = this.f5972d;
                i3 = this.f5973e;
            }
            int i4 = i2 + 1;
            char c2 = cArr[i2];
            if (c2 == '\n') {
                this.f5974f++;
                this.f5975g = i4;
            } else if (c2 != ' ' && c2 != '\r' && c2 != '\t') {
                if (c2 == '/') {
                    this.f5972d = i4;
                    if (i4 == i3) {
                        this.f5972d--;
                        boolean m5595a = m5595a(2);
                        this.f5972d++;
                        if (!m5595a) {
                            return c2;
                        }
                    }
                    m5603u();
                    int i5 = this.f5972d;
                    char c3 = cArr[i5];
                    if (c3 == '*') {
                        this.f5972d = i5 + 1;
                        if (m5596a("*/")) {
                            i2 = this.f5972d + 2;
                            i3 = this.f5973e;
                        } else {
                            throw m5597b("Unterminated comment");
                        }
                    } else {
                        if (c3 != '/') {
                            return c2;
                        }
                        this.f5972d = i5 + 1;
                        m5592A();
                        i2 = this.f5972d;
                        i3 = this.f5973e;
                    }
                } else if (c2 == '#') {
                    this.f5972d = i4;
                    m5603u();
                    m5592A();
                    i2 = this.f5972d;
                    i3 = this.f5973e;
                } else {
                    this.f5972d = i4;
                    return c2;
                }
            }
            i2 = i4;
        }
    }

    /* renamed from: b */
    private void m5600b(int i2) {
        int i3 = this.f5981m;
        int[] iArr = this.f5980l;
        if (i3 == iArr.length) {
            int i4 = i3 * 2;
            this.f5980l = Arrays.copyOf(iArr, i4);
            this.f5983o = Arrays.copyOf(this.f5983o, i4);
            this.f5982n = (String[]) Arrays.copyOf(this.f5982n, i4);
        }
        int[] iArr2 = this.f5980l;
        int i5 = this.f5981m;
        this.f5981m = i5 + 1;
        iArr2[i5] = i2;
    }

    /* renamed from: b */
    private String m5599b(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(C5736h0.f20713b);
        for (int i2 = 0; i2 < this.f5981m; i2++) {
            int i3 = this.f5980l[i2];
            if (i3 == 1 || i3 == 2) {
                int i4 = this.f5983o[i2];
                if (z && i4 > 0 && i2 == this.f5981m - 1) {
                    i4--;
                }
                sb.append('[');
                sb.append(i4);
                sb.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append('.');
                String[] strArr = this.f5982n;
                if (strArr[i2] != null) {
                    sb.append(strArr[i2]);
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    private IOException m5597b(String str) throws IOException {
        throw new C2056e(str + m5612l());
    }
}
