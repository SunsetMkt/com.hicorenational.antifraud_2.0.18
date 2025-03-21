package com.airbnb.lottie.p098a0.p099l0;

import androidx.annotation.Nullable;
import com.airbnb.lottie.p098a0.p099l0.AbstractC1330c;
import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import p000a.p001a.p014u.C0052a;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: JsonUtf8Reader.java */
/* renamed from: com.airbnb.lottie.a0.l0.e */
/* loaded from: classes.dex */
final class C1332e extends AbstractC1330c {

    /* renamed from: A */
    private static final int f3042A = 7;

    /* renamed from: B */
    private static final int f3043B = 8;

    /* renamed from: C */
    private static final int f3044C = 9;

    /* renamed from: D */
    private static final int f3045D = 10;

    /* renamed from: E */
    private static final int f3046E = 11;

    /* renamed from: F */
    private static final int f3047F = 12;

    /* renamed from: G */
    private static final int f3048G = 13;

    /* renamed from: H */
    private static final int f3049H = 14;

    /* renamed from: I */
    private static final int f3050I = 15;

    /* renamed from: J */
    private static final int f3051J = 16;

    /* renamed from: K */
    private static final int f3052K = 17;

    /* renamed from: L */
    private static final int f3053L = 18;

    /* renamed from: M */
    private static final int f3054M = 0;

    /* renamed from: N */
    private static final int f3055N = 1;

    /* renamed from: O */
    private static final int f3056O = 2;

    /* renamed from: b0 */
    private static final int f3057b0 = 3;

    /* renamed from: c0 */
    private static final int f3058c0 = 4;

    /* renamed from: d0 */
    private static final int f3059d0 = 5;

    /* renamed from: e0 */
    private static final int f3060e0 = 6;

    /* renamed from: f0 */
    private static final int f3061f0 = 7;

    /* renamed from: n */
    private static final long f3062n = -922337203685477580L;

    /* renamed from: o */
    private static final ByteString f3063o = ByteString.encodeUtf8("'\\");

    /* renamed from: p */
    private static final ByteString f3064p = ByteString.encodeUtf8("\"\\");

    /* renamed from: q */
    private static final ByteString f3065q = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");

    /* renamed from: r */
    private static final ByteString f3066r = ByteString.encodeUtf8("\n\r");

    /* renamed from: s */
    private static final ByteString f3067s = ByteString.encodeUtf8("*/");

    /* renamed from: t */
    private static final int f3068t = 0;

    /* renamed from: u */
    private static final int f3069u = 1;

    /* renamed from: v */
    private static final int f3070v = 2;

    /* renamed from: w */
    private static final int f3071w = 3;

    /* renamed from: x */
    private static final int f3072x = 4;

    /* renamed from: y */
    private static final int f3073y = 5;

    /* renamed from: z */
    private static final int f3074z = 6;

    /* renamed from: h */
    private final BufferedSource f3075h;

    /* renamed from: i */
    private final Buffer f3076i;

    /* renamed from: j */
    private int f3077j = 0;

    /* renamed from: k */
    private long f3078k;

    /* renamed from: l */
    private int f3079l;

    /* renamed from: m */
    @Nullable
    private String f3080m;

    C1332e(BufferedSource bufferedSource) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        }
        this.f3075h = bufferedSource;
        this.f3076i = bufferedSource.buffer();
        m2696a(6);
    }

    /* renamed from: b */
    private boolean m2717b(int i2) throws IOException {
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
        m2718p();
        return false;
    }

    /* renamed from: p */
    private void m2718p() throws IOException {
        if (!this.f3029e) {
            throw m2695a("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    /* renamed from: q */
    private int m2719q() throws IOException {
        int[] iArr = this.f3026b;
        int i2 = this.f3025a;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int m2713a = m2713a(true);
            this.f3076i.readByte();
            if (m2713a != 44) {
                if (m2713a != 59) {
                    if (m2713a != 93) {
                        throw m2695a("Unterminated array");
                    }
                    this.f3077j = 4;
                    return 4;
                }
                m2718p();
            }
        } else {
            if (i3 == 3 || i3 == 5) {
                this.f3026b[this.f3025a - 1] = 4;
                if (i3 == 5) {
                    int m2713a2 = m2713a(true);
                    this.f3076i.readByte();
                    if (m2713a2 != 44) {
                        if (m2713a2 != 59) {
                            if (m2713a2 != 125) {
                                throw m2695a("Unterminated object");
                            }
                            this.f3077j = 2;
                            return 2;
                        }
                        m2718p();
                    }
                }
                int m2713a3 = m2713a(true);
                if (m2713a3 == 34) {
                    this.f3076i.readByte();
                    this.f3077j = 13;
                    return 13;
                }
                if (m2713a3 == 39) {
                    this.f3076i.readByte();
                    m2718p();
                    this.f3077j = 12;
                    return 12;
                }
                if (m2713a3 != 125) {
                    m2718p();
                    if (!m2717b((char) m2713a3)) {
                        throw m2695a("Expected name");
                    }
                    this.f3077j = 14;
                    return 14;
                }
                if (i3 == 5) {
                    throw m2695a("Expected name");
                }
                this.f3076i.readByte();
                this.f3077j = 2;
                return 2;
            }
            if (i3 == 4) {
                iArr[i2 - 1] = 5;
                int m2713a4 = m2713a(true);
                this.f3076i.readByte();
                if (m2713a4 != 58) {
                    if (m2713a4 != 61) {
                        throw m2695a("Expected ':'");
                    }
                    m2718p();
                    if (this.f3075h.request(1L) && this.f3076i.getByte(0L) == 62) {
                        this.f3076i.readByte();
                    }
                }
            } else if (i3 == 6) {
                iArr[i2 - 1] = 7;
            } else if (i3 == 7) {
                if (m2713a(false) == -1) {
                    this.f3077j = 18;
                    return 18;
                }
                m2718p();
            } else if (i3 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int m2713a5 = m2713a(true);
        if (m2713a5 == 34) {
            this.f3076i.readByte();
            this.f3077j = 9;
            return 9;
        }
        if (m2713a5 == 39) {
            m2718p();
            this.f3076i.readByte();
            this.f3077j = 8;
            return 8;
        }
        if (m2713a5 != 44 && m2713a5 != 59) {
            if (m2713a5 == 91) {
                this.f3076i.readByte();
                this.f3077j = 3;
                return 3;
            }
            if (m2713a5 != 93) {
                if (m2713a5 == 123) {
                    this.f3076i.readByte();
                    this.f3077j = 1;
                    return 1;
                }
                int m2721s = m2721s();
                if (m2721s != 0) {
                    return m2721s;
                }
                int m2722t = m2722t();
                if (m2722t != 0) {
                    return m2722t;
                }
                if (!m2717b(this.f3076i.getByte(0L))) {
                    throw m2695a("Expected value");
                }
                m2718p();
                this.f3077j = 10;
                return 10;
            }
            if (i3 == 1) {
                this.f3076i.readByte();
                this.f3077j = 4;
                return 4;
            }
        }
        if (i3 != 1 && i3 != 2) {
            throw m2695a("Unexpected value");
        }
        m2718p();
        this.f3077j = 7;
        return 7;
    }

    /* renamed from: r */
    private String m2720r() throws IOException {
        long indexOfElement = this.f3075h.indexOfElement(f3065q);
        return indexOfElement != -1 ? this.f3076i.readUtf8(indexOfElement) : this.f3076i.readUtf8();
    }

    /* renamed from: s */
    private int m2721s() throws IOException {
        int i2;
        String str;
        String str2;
        byte b2 = this.f3076i.getByte(0L);
        if (b2 == 116 || b2 == 84) {
            i2 = 5;
            str = C0052a.f158j;
            str2 = "TRUE";
        } else if (b2 == 102 || b2 == 70) {
            i2 = 6;
            str = C0052a.f159k;
            str2 = "FALSE";
        } else {
            if (b2 != 110 && b2 != 78) {
                return 0;
            }
            i2 = 7;
            str = AbstractC1191a.f2571h;
            str2 = "NULL";
        }
        int length = str.length();
        int i3 = 1;
        while (i3 < length) {
            int i4 = i3 + 1;
            if (!this.f3075h.request(i4)) {
                return 0;
            }
            byte b3 = this.f3076i.getByte(i3);
            if (b3 != str.charAt(i3) && b3 != str2.charAt(i3)) {
                return 0;
            }
            i3 = i4;
        }
        if (this.f3075h.request(length + 1) && m2717b(this.f3076i.getByte(length))) {
            return 0;
        }
        this.f3076i.skip(length);
        this.f3077j = i2;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0089, code lost:
    
        if (m2717b(r11) != false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x008b, code lost:
    
        if (r6 != 2) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x008d, code lost:
    
        if (r7 == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0093, code lost:
    
        if (r8 != Long.MIN_VALUE) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0095, code lost:
    
        if (r10 == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0099, code lost:
    
        if (r8 != 0) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x009b, code lost:
    
        if (r10 != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009d, code lost:
    
        if (r10 == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a0, code lost:
    
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a1, code lost:
    
        r16.f3078k = r8;
        r16.f3076i.skip(r5);
        r16.f3077j = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ad, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ae, code lost:
    
        if (r6 == 2) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b1, code lost:
    
        if (r6 == 4) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b4, code lost:
    
        if (r6 != 7) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b7, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00b9, code lost:
    
        r16.f3079l = r5;
        r16.f3077j = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00bf, code lost:
    
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00c0, code lost:
    
        return 0;
     */
    /* renamed from: t */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int m2722t() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.p098a0.p099l0.C1332e.m2722t():int");
    }

    /* renamed from: u */
    private char m2723u() throws IOException {
        int i2;
        int i3;
        if (!this.f3075h.request(1L)) {
            throw m2695a("Unterminated escape sequence");
        }
        byte readByte = this.f3076i.readByte();
        if (readByte == 10 || readByte == 34 || readByte == 39 || readByte == 47 || readByte == 92) {
            return (char) readByte;
        }
        if (readByte == 98) {
            return '\b';
        }
        if (readByte == 102) {
            return '\f';
        }
        if (readByte == 110) {
            return '\n';
        }
        if (readByte == 114) {
            return '\r';
        }
        if (readByte == 116) {
            return '\t';
        }
        if (readByte != 117) {
            if (this.f3029e) {
                return (char) readByte;
            }
            throw m2695a("Invalid escape sequence: \\" + ((char) readByte));
        }
        if (!this.f3075h.request(4L)) {
            throw new EOFException("Unterminated escape sequence at path " + m2701g());
        }
        char c2 = 0;
        for (int i4 = 0; i4 < 4; i4++) {
            byte b2 = this.f3076i.getByte(i4);
            char c3 = (char) (c2 << 4);
            if (b2 < 48 || b2 > 57) {
                if (b2 >= 97 && b2 <= 102) {
                    i2 = b2 - 97;
                } else {
                    if (b2 < 65 || b2 > 70) {
                        throw m2695a("\\u" + this.f3076i.readUtf8(4L));
                    }
                    i2 = b2 - 65;
                }
                i3 = i2 + 10;
            } else {
                i3 = b2 - 48;
            }
            c2 = (char) (c3 + i3);
        }
        this.f3076i.skip(4L);
        return c2;
    }

    /* renamed from: v */
    private boolean m2724v() throws IOException {
        long indexOf = this.f3075h.indexOf(f3067s);
        boolean z = indexOf != -1;
        Buffer buffer = this.f3076i;
        buffer.skip(z ? indexOf + f3067s.size() : buffer.size());
        return z;
    }

    /* renamed from: w */
    private void m2725w() throws IOException {
        long indexOfElement = this.f3075h.indexOfElement(f3066r);
        Buffer buffer = this.f3076i;
        buffer.skip(indexOfElement != -1 ? indexOfElement + 1 : buffer.size());
    }

    /* renamed from: x */
    private void m2726x() throws IOException {
        long indexOfElement = this.f3075h.indexOfElement(f3065q);
        Buffer buffer = this.f3076i;
        if (indexOfElement == -1) {
            indexOfElement = buffer.size();
        }
        buffer.skip(indexOfElement);
    }

    @Override // com.airbnb.lottie.p098a0.p099l0.AbstractC1330c
    /* renamed from: a */
    public int mo2694a(AbstractC1330c.a aVar) throws IOException {
        int i2 = this.f3077j;
        if (i2 == 0) {
            i2 = m2719q();
        }
        if (i2 < 12 || i2 > 15) {
            return -1;
        }
        if (i2 == 15) {
            return m2712a(this.f3080m, aVar);
        }
        int select = this.f3075h.select(aVar.f3032b);
        if (select != -1) {
            this.f3077j = 0;
            this.f3027c[this.f3025a - 1] = aVar.f3031a[select];
            return select;
        }
        String str = this.f3027c[this.f3025a - 1];
        String mo2706l = mo2706l();
        int m2712a = m2712a(mo2706l, aVar);
        if (m2712a == -1) {
            this.f3077j = 15;
            this.f3080m = mo2706l;
            this.f3027c[this.f3025a - 1] = str;
        }
        return m2712a;
    }

    @Override // com.airbnb.lottie.p098a0.p099l0.AbstractC1330c
    /* renamed from: c */
    public void mo2697c() throws IOException {
        int i2 = this.f3077j;
        if (i2 == 0) {
            i2 = m2719q();
        }
        if (i2 == 3) {
            m2696a(1);
            this.f3028d[this.f3025a - 1] = 0;
            this.f3077j = 0;
        } else {
            throw new C1328a("Expected BEGIN_ARRAY but was " + peek() + " at path " + m2701g());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f3077j = 0;
        this.f3026b[0] = 8;
        this.f3025a = 1;
        this.f3076i.clear();
        this.f3075h.close();
    }

    @Override // com.airbnb.lottie.p098a0.p099l0.AbstractC1330c
    /* renamed from: d */
    public void mo2698d() throws IOException {
        int i2 = this.f3077j;
        if (i2 == 0) {
            i2 = m2719q();
        }
        if (i2 == 1) {
            m2696a(3);
            this.f3077j = 0;
            return;
        }
        throw new C1328a("Expected BEGIN_OBJECT but was " + peek() + " at path " + m2701g());
    }

    @Override // com.airbnb.lottie.p098a0.p099l0.AbstractC1330c
    /* renamed from: e */
    public void mo2699e() throws IOException {
        int i2 = this.f3077j;
        if (i2 == 0) {
            i2 = m2719q();
        }
        if (i2 == 4) {
            this.f3025a--;
            int[] iArr = this.f3028d;
            int i3 = this.f3025a - 1;
            iArr[i3] = iArr[i3] + 1;
            this.f3077j = 0;
            return;
        }
        throw new C1328a("Expected END_ARRAY but was " + peek() + " at path " + m2701g());
    }

    @Override // com.airbnb.lottie.p098a0.p099l0.AbstractC1330c
    /* renamed from: f */
    public void mo2700f() throws IOException {
        int i2 = this.f3077j;
        if (i2 == 0) {
            i2 = m2719q();
        }
        if (i2 != 2) {
            throw new C1328a("Expected END_OBJECT but was " + peek() + " at path " + m2701g());
        }
        this.f3025a--;
        String[] strArr = this.f3027c;
        int i3 = this.f3025a;
        strArr[i3] = null;
        int[] iArr = this.f3028d;
        int i4 = i3 - 1;
        iArr[i4] = iArr[i4] + 1;
        this.f3077j = 0;
    }

    @Override // com.airbnb.lottie.p098a0.p099l0.AbstractC1330c
    /* renamed from: h */
    public boolean mo2702h() throws IOException {
        int i2 = this.f3077j;
        if (i2 == 0) {
            i2 = m2719q();
        }
        return (i2 == 2 || i2 == 4 || i2 == 18) ? false : true;
    }

    @Override // com.airbnb.lottie.p098a0.p099l0.AbstractC1330c
    /* renamed from: i */
    public boolean mo2703i() throws IOException {
        int i2 = this.f3077j;
        if (i2 == 0) {
            i2 = m2719q();
        }
        if (i2 == 5) {
            this.f3077j = 0;
            int[] iArr = this.f3028d;
            int i3 = this.f3025a - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        }
        if (i2 == 6) {
            this.f3077j = 0;
            int[] iArr2 = this.f3028d;
            int i4 = this.f3025a - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return false;
        }
        throw new C1328a("Expected a boolean but was " + peek() + " at path " + m2701g());
    }

    @Override // com.airbnb.lottie.p098a0.p099l0.AbstractC1330c
    /* renamed from: j */
    public double mo2704j() throws IOException {
        int i2 = this.f3077j;
        if (i2 == 0) {
            i2 = m2719q();
        }
        if (i2 == 16) {
            this.f3077j = 0;
            int[] iArr = this.f3028d;
            int i3 = this.f3025a - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.f3078k;
        }
        if (i2 == 17) {
            this.f3080m = this.f3076i.readUtf8(this.f3079l);
        } else if (i2 == 9) {
            this.f3080m = m2714a(f3064p);
        } else if (i2 == 8) {
            this.f3080m = m2714a(f3063o);
        } else if (i2 == 10) {
            this.f3080m = m2720r();
        } else if (i2 != 11) {
            throw new C1328a("Expected a double but was " + peek() + " at path " + m2701g());
        }
        this.f3077j = 11;
        try {
            double parseDouble = Double.parseDouble(this.f3080m);
            if (this.f3029e || !(Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
                this.f3080m = null;
                this.f3077j = 0;
                int[] iArr2 = this.f3028d;
                int i4 = this.f3025a - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseDouble;
            }
            throw new C1329b("JSON forbids NaN and infinities: " + parseDouble + " at path " + m2701g());
        } catch (NumberFormatException unused) {
            throw new C1328a("Expected a double but was " + this.f3080m + " at path " + m2701g());
        }
    }

    @Override // com.airbnb.lottie.p098a0.p099l0.AbstractC1330c
    /* renamed from: k */
    public int mo2705k() throws IOException {
        int i2 = this.f3077j;
        if (i2 == 0) {
            i2 = m2719q();
        }
        if (i2 == 16) {
            long j2 = this.f3078k;
            int i3 = (int) j2;
            if (j2 == i3) {
                this.f3077j = 0;
                int[] iArr = this.f3028d;
                int i4 = this.f3025a - 1;
                iArr[i4] = iArr[i4] + 1;
                return i3;
            }
            throw new C1328a("Expected an int but was " + this.f3078k + " at path " + m2701g());
        }
        if (i2 == 17) {
            this.f3080m = this.f3076i.readUtf8(this.f3079l);
        } else if (i2 == 9 || i2 == 8) {
            this.f3080m = i2 == 9 ? m2714a(f3064p) : m2714a(f3063o);
            try {
                int parseInt = Integer.parseInt(this.f3080m);
                this.f3077j = 0;
                int[] iArr2 = this.f3028d;
                int i5 = this.f3025a - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else if (i2 != 11) {
            throw new C1328a("Expected an int but was " + peek() + " at path " + m2701g());
        }
        this.f3077j = 11;
        try {
            double parseDouble = Double.parseDouble(this.f3080m);
            int i6 = (int) parseDouble;
            if (i6 == parseDouble) {
                this.f3080m = null;
                this.f3077j = 0;
                int[] iArr3 = this.f3028d;
                int i7 = this.f3025a - 1;
                iArr3[i7] = iArr3[i7] + 1;
                return i6;
            }
            throw new C1328a("Expected an int but was " + this.f3080m + " at path " + m2701g());
        } catch (NumberFormatException unused2) {
            throw new C1328a("Expected an int but was " + this.f3080m + " at path " + m2701g());
        }
    }

    @Override // com.airbnb.lottie.p098a0.p099l0.AbstractC1330c
    /* renamed from: l */
    public String mo2706l() throws IOException {
        String str;
        int i2 = this.f3077j;
        if (i2 == 0) {
            i2 = m2719q();
        }
        if (i2 == 14) {
            str = m2720r();
        } else if (i2 == 13) {
            str = m2714a(f3064p);
        } else if (i2 == 12) {
            str = m2714a(f3063o);
        } else {
            if (i2 != 15) {
                throw new C1328a("Expected a name but was " + peek() + " at path " + m2701g());
            }
            str = this.f3080m;
        }
        this.f3077j = 0;
        this.f3027c[this.f3025a - 1] = str;
        return str;
    }

    @Override // com.airbnb.lottie.p098a0.p099l0.AbstractC1330c
    /* renamed from: m */
    public String mo2707m() throws IOException {
        String readUtf8;
        int i2 = this.f3077j;
        if (i2 == 0) {
            i2 = m2719q();
        }
        if (i2 == 10) {
            readUtf8 = m2720r();
        } else if (i2 == 9) {
            readUtf8 = m2714a(f3064p);
        } else if (i2 == 8) {
            readUtf8 = m2714a(f3063o);
        } else if (i2 == 11) {
            readUtf8 = this.f3080m;
            this.f3080m = null;
        } else if (i2 == 16) {
            readUtf8 = Long.toString(this.f3078k);
        } else {
            if (i2 != 17) {
                throw new C1328a("Expected a string but was " + peek() + " at path " + m2701g());
            }
            readUtf8 = this.f3076i.readUtf8(this.f3079l);
        }
        this.f3077j = 0;
        int[] iArr = this.f3028d;
        int i3 = this.f3025a - 1;
        iArr[i3] = iArr[i3] + 1;
        return readUtf8;
    }

    @Override // com.airbnb.lottie.p098a0.p099l0.AbstractC1330c
    /* renamed from: n */
    public void mo2708n() throws IOException {
        if (this.f3030f) {
            throw new C1328a("Cannot skip unexpected " + peek() + " at " + m2701g());
        }
        int i2 = this.f3077j;
        if (i2 == 0) {
            i2 = m2719q();
        }
        if (i2 == 14) {
            m2726x();
        } else if (i2 == 13) {
            m2716b(f3064p);
        } else if (i2 == 12) {
            m2716b(f3063o);
        } else if (i2 != 15) {
            throw new C1328a("Expected a name but was " + peek() + " at path " + m2701g());
        }
        this.f3077j = 0;
        this.f3027c[this.f3025a - 1] = AbstractC1191a.f2571h;
    }

    @Override // com.airbnb.lottie.p098a0.p099l0.AbstractC1330c
    /* renamed from: o */
    public void mo2709o() throws IOException {
        if (this.f3030f) {
            throw new C1328a("Cannot skip unexpected " + peek() + " at " + m2701g());
        }
        int i2 = 0;
        do {
            int i3 = this.f3077j;
            if (i3 == 0) {
                i3 = m2719q();
            }
            if (i3 == 3) {
                m2696a(1);
            } else if (i3 == 1) {
                m2696a(3);
            } else {
                if (i3 == 4) {
                    i2--;
                    if (i2 < 0) {
                        throw new C1328a("Expected a value but was " + peek() + " at path " + m2701g());
                    }
                    this.f3025a--;
                } else if (i3 == 2) {
                    i2--;
                    if (i2 < 0) {
                        throw new C1328a("Expected a value but was " + peek() + " at path " + m2701g());
                    }
                    this.f3025a--;
                } else if (i3 == 14 || i3 == 10) {
                    m2726x();
                } else if (i3 == 9 || i3 == 13) {
                    m2716b(f3064p);
                } else if (i3 == 8 || i3 == 12) {
                    m2716b(f3063o);
                } else if (i3 == 17) {
                    this.f3076i.skip(this.f3079l);
                } else if (i3 == 18) {
                    throw new C1328a("Expected a value but was " + peek() + " at path " + m2701g());
                }
                this.f3077j = 0;
            }
            i2++;
            this.f3077j = 0;
        } while (i2 != 0);
        int[] iArr = this.f3028d;
        int i4 = this.f3025a;
        int i5 = i4 - 1;
        iArr[i5] = iArr[i5] + 1;
        this.f3027c[i4 - 1] = AbstractC1191a.f2571h;
    }

    @Override // com.airbnb.lottie.p098a0.p099l0.AbstractC1330c
    public AbstractC1330c.b peek() throws IOException {
        int i2 = this.f3077j;
        if (i2 == 0) {
            i2 = m2719q();
        }
        switch (i2) {
            case 1:
                return AbstractC1330c.b.BEGIN_OBJECT;
            case 2:
                return AbstractC1330c.b.END_OBJECT;
            case 3:
                return AbstractC1330c.b.BEGIN_ARRAY;
            case 4:
                return AbstractC1330c.b.END_ARRAY;
            case 5:
            case 6:
                return AbstractC1330c.b.BOOLEAN;
            case 7:
                return AbstractC1330c.b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return AbstractC1330c.b.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return AbstractC1330c.b.NAME;
            case 16:
            case 17:
                return AbstractC1330c.b.NUMBER;
            case 18:
                return AbstractC1330c.b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public String toString() {
        return "JsonReader(" + this.f3075h + ")";
    }

    /* renamed from: b */
    private int m2715b(String str, AbstractC1330c.a aVar) {
        int length = aVar.f3031a.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(aVar.f3031a[i2])) {
                this.f3077j = 0;
                int[] iArr = this.f3028d;
                int i3 = this.f3025a - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: b */
    private void m2716b(ByteString byteString) throws IOException {
        while (true) {
            long indexOfElement = this.f3075h.indexOfElement(byteString);
            if (indexOfElement != -1) {
                if (this.f3076i.getByte(indexOfElement) == 92) {
                    this.f3076i.skip(indexOfElement + 1);
                    m2723u();
                } else {
                    this.f3076i.skip(indexOfElement + 1);
                    return;
                }
            } else {
                throw m2695a("Unterminated string");
            }
        }
    }

    /* renamed from: a */
    private int m2712a(String str, AbstractC1330c.a aVar) {
        int length = aVar.f3031a.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(aVar.f3031a[i2])) {
                this.f3077j = 0;
                this.f3027c[this.f3025a - 1] = str;
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: a */
    private String m2714a(ByteString byteString) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long indexOfElement = this.f3075h.indexOfElement(byteString);
            if (indexOfElement != -1) {
                if (this.f3076i.getByte(indexOfElement) != 92) {
                    if (sb == null) {
                        String readUtf8 = this.f3076i.readUtf8(indexOfElement);
                        this.f3076i.readByte();
                        return readUtf8;
                    }
                    sb.append(this.f3076i.readUtf8(indexOfElement));
                    this.f3076i.readByte();
                    return sb.toString();
                }
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(this.f3076i.readUtf8(indexOfElement));
                this.f3076i.readByte();
                sb.append(m2723u());
            } else {
                throw m2695a("Unterminated string");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
    
        r6.f3076i.skip(r3 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
    
        if (r1 != 47) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0076, code lost:
    
        if (r1 != 35) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0078, code lost:
    
        m2718p();
        m2725w();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007f, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0039, code lost:
    
        if (r6.f3075h.request(2) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003c, code lost:
    
        m2718p();
        r3 = r6.f3076i.getByte(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0049, code lost:
    
        if (r3 == 42) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005c, code lost:
    
        r6.f3076i.readByte();
        r6.f3076i.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006a, code lost:
    
        if (m2724v() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0073, code lost:
    
        throw m2695a("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x004b, code lost:
    
        if (r3 == 47) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x004e, code lost:
    
        r6.f3076i.readByte();
        r6.f3076i.readByte();
        m2725w();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x004d, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x003b, code lost:
    
        return r1;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int m2713a(boolean r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
        L1:
            r1 = 0
        L2:
            okio.BufferedSource r2 = r6.f3075h
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.request(r4)
            if (r2 == 0) goto L82
            okio.Buffer r2 = r6.f3076i
            long r4 = (long) r1
            byte r1 = r2.getByte(r4)
            r2 = 10
            if (r1 == r2) goto L80
            r2 = 32
            if (r1 == r2) goto L80
            r2 = 13
            if (r1 == r2) goto L80
            r2 = 9
            if (r1 != r2) goto L25
            goto L80
        L25:
            okio.Buffer r2 = r6.f3076i
            int r3 = r3 + (-1)
            long r3 = (long) r3
            r2.skip(r3)
            r2 = 47
            if (r1 != r2) goto L74
            okio.BufferedSource r3 = r6.f3075h
            r4 = 2
            boolean r3 = r3.request(r4)
            if (r3 != 0) goto L3c
            return r1
        L3c:
            r6.m2718p()
            okio.Buffer r3 = r6.f3076i
            r4 = 1
            byte r3 = r3.getByte(r4)
            r4 = 42
            if (r3 == r4) goto L5c
            if (r3 == r2) goto L4e
            return r1
        L4e:
            okio.Buffer r1 = r6.f3076i
            r1.readByte()
            okio.Buffer r1 = r6.f3076i
            r1.readByte()
            r6.m2725w()
            goto L1
        L5c:
            okio.Buffer r1 = r6.f3076i
            r1.readByte()
            okio.Buffer r1 = r6.f3076i
            r1.readByte()
            boolean r1 = r6.m2724v()
            if (r1 == 0) goto L6d
            goto L1
        L6d:
            java.lang.String r7 = "Unterminated comment"
            com.airbnb.lottie.a0.l0.b r7 = r6.m2695a(r7)
            throw r7
        L74:
            r2 = 35
            if (r1 != r2) goto L7f
            r6.m2718p()
            r6.m2725w()
            goto L1
        L7f:
            return r1
        L80:
            r1 = r3
            goto L2
        L82:
            if (r7 != 0) goto L86
            r7 = -1
            return r7
        L86:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.String r0 = "End of input"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.p098a0.p099l0.C1332e.m2713a(boolean):int");
    }
}
