package com.huawei.secure.android.common.ssl.hostname;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.security.auth.x500.X500Principal;

/* renamed from: com.huawei.secure.android.common.ssl.hostname.a */
/* loaded from: classes.dex */
public class C2557a {

    /* renamed from: a */
    private final String f8209a;

    /* renamed from: b */
    private final int f8210b;

    /* renamed from: c */
    private int f8211c;

    /* renamed from: d */
    private int f8212d;

    /* renamed from: e */
    private int f8213e;

    /* renamed from: f */
    private int f8214f;

    /* renamed from: g */
    private char[] f8215g;

    public C2557a(X500Principal x500Principal) {
        this.f8209a = x500Principal.getName("RFC2253");
        this.f8210b = this.f8209a.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a7, code lost:
    
        return new java.lang.String(r1, r2, r8.f8214f - r2);
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m7927a() {
        /*
            r8 = this;
            int r0 = r8.f8211c
            r8.f8212d = r0
            r8.f8213e = r0
        L6:
            int r0 = r8.f8211c
            int r1 = r8.f8210b
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f8215g
            int r2 = r8.f8212d
            int r3 = r8.f8213e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.f8215g
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L60
            if (r2 == r5) goto L53
            r5 = 92
            if (r2 == r5) goto L40
            if (r2 == r4) goto L53
            if (r2 == r3) goto L53
            int r2 = r8.f8213e
            int r3 = r2 + 1
            r8.f8213e = r3
            char r3 = r1[r0]
            r1[r2] = r3
            int r0 = r0 + 1
            r8.f8211c = r0
            goto L6
        L40:
            int r0 = r8.f8213e
            int r2 = r0 + 1
            r8.f8213e = r2
            char r2 = r8.m7928b()
            r1[r0] = r2
            int r0 = r8.f8211c
            int r0 = r0 + 1
            r8.f8211c = r0
            goto L6
        L53:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f8215g
            int r2 = r8.f8212d
            int r3 = r8.f8213e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L60:
            int r2 = r8.f8213e
            r8.f8214f = r2
            int r0 = r0 + 1
            r8.f8211c = r0
            int r0 = r2 + 1
            r8.f8213e = r0
            r1[r2] = r6
        L6e:
            int r0 = r8.f8211c
            int r1 = r8.f8210b
            if (r0 >= r1) goto L87
            char[] r1 = r8.f8215g
            char r2 = r1[r0]
            if (r2 != r6) goto L87
            int r2 = r8.f8213e
            int r7 = r2 + 1
            r8.f8213e = r7
            r1[r2] = r6
            int r0 = r0 + 1
            r8.f8211c = r0
            goto L6e
        L87:
            int r0 = r8.f8211c
            int r1 = r8.f8210b
            if (r0 == r1) goto L9b
            char[] r1 = r8.f8215g
            char r2 = r1[r0]
            if (r2 == r3) goto L9b
            char r2 = r1[r0]
            if (r2 == r4) goto L9b
            char r0 = r1[r0]
            if (r0 != r5) goto L6
        L9b:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f8215g
            int r2 = r8.f8212d
            int r3 = r8.f8214f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.ssl.hostname.C2557a.m7927a():java.lang.String");
    }

    /* renamed from: b */
    private char m7928b() {
        this.f8211c++;
        int i2 = this.f8211c;
        if (i2 == this.f8210b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f8209a);
        }
        char[] cArr = this.f8215g;
        char c2 = cArr[i2];
        if (c2 != ' ' && c2 != '%' && c2 != '\\' && c2 != '_' && c2 != '\"' && c2 != '#') {
            switch (c2) {
                case '*':
                case '+':
                case ',':
                    break;
                default:
                    switch (c2) {
                        case ';':
                        case '<':
                        case '=':
                        case '>':
                            break;
                        default:
                            return m7929c();
                    }
            }
        }
        return cArr[i2];
    }

    /* renamed from: c */
    private char m7929c() {
        int i2;
        int i3;
        int m7926a = m7926a(this.f8211c);
        this.f8211c++;
        if (m7926a < 128) {
            return (char) m7926a;
        }
        if (m7926a < 192 || m7926a > 247) {
            return '?';
        }
        if (m7926a <= 223) {
            i3 = m7926a & 31;
            i2 = 1;
        } else if (m7926a <= 239) {
            i2 = 2;
            i3 = m7926a & 15;
        } else {
            i2 = 3;
            i3 = m7926a & 7;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            this.f8211c++;
            int i5 = this.f8211c;
            if (i5 == this.f8210b || this.f8215g[i5] != '\\') {
                return '?';
            }
            this.f8211c = i5 + 1;
            int m7926a2 = m7926a(this.f8211c);
            this.f8211c++;
            if ((m7926a2 & 192) != 128) {
                return '?';
            }
            i3 = (i3 << 6) + (m7926a2 & 63);
        }
        return (char) i3;
    }

    /* renamed from: d */
    private String m7930d() {
        int i2 = this.f8211c;
        if (i2 + 4 >= this.f8210b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f8209a);
        }
        this.f8212d = i2;
        this.f8211c = i2 + 1;
        while (true) {
            int i3 = this.f8211c;
            if (i3 == this.f8210b) {
                break;
            }
            char[] cArr = this.f8215g;
            if (cArr[i3] == '+' || cArr[i3] == ',' || cArr[i3] == ';') {
                break;
            }
            if (cArr[i3] == ' ') {
                this.f8213e = i3;
                this.f8211c = i3 + 1;
                while (true) {
                    int i4 = this.f8211c;
                    if (i4 >= this.f8210b || this.f8215g[i4] != ' ') {
                        break;
                    }
                    this.f8211c = i4 + 1;
                }
            } else {
                if (cArr[i3] >= 'A' && cArr[i3] <= 'F') {
                    cArr[i3] = (char) (cArr[i3] + ' ');
                }
                this.f8211c++;
            }
        }
        this.f8213e = this.f8211c;
        int i5 = this.f8213e;
        int i6 = this.f8212d;
        int i7 = i5 - i6;
        if (i7 < 5 || (i7 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f8209a);
        }
        byte[] bArr = new byte[i7 / 2];
        int i8 = i6 + 1;
        for (int i9 = 0; i9 < bArr.length; i9++) {
            bArr[i9] = (byte) m7926a(i8);
            i8 += 2;
        }
        return new String(this.f8215g, this.f8212d, i7);
    }

    /* renamed from: e */
    private String m7931e() {
        while (true) {
            int i2 = this.f8211c;
            if (i2 >= this.f8210b || this.f8215g[i2] != ' ') {
                break;
            }
            this.f8211c = i2 + 1;
        }
        int i3 = this.f8211c;
        if (i3 == this.f8210b) {
            return null;
        }
        this.f8212d = i3;
        this.f8211c = i3 + 1;
        while (true) {
            int i4 = this.f8211c;
            if (i4 >= this.f8210b) {
                break;
            }
            char[] cArr = this.f8215g;
            if (cArr[i4] == '=' || cArr[i4] == ' ') {
                break;
            }
            this.f8211c = i4 + 1;
        }
        int i5 = this.f8211c;
        if (i5 >= this.f8210b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f8209a);
        }
        this.f8213e = i5;
        if (this.f8215g[i5] == ' ') {
            while (true) {
                int i6 = this.f8211c;
                if (i6 >= this.f8210b) {
                    break;
                }
                char[] cArr2 = this.f8215g;
                if (cArr2[i6] == '=' || cArr2[i6] != ' ') {
                    break;
                }
                this.f8211c = i6 + 1;
            }
            char[] cArr3 = this.f8215g;
            int i7 = this.f8211c;
            if (cArr3[i7] != '=' || i7 == this.f8210b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f8209a);
            }
        }
        this.f8211c++;
        while (true) {
            int i8 = this.f8211c;
            if (i8 >= this.f8210b || this.f8215g[i8] != ' ') {
                break;
            }
            this.f8211c = i8 + 1;
        }
        int i9 = this.f8213e;
        int i10 = this.f8212d;
        if (i9 - i10 > 4) {
            char[] cArr4 = this.f8215g;
            if (cArr4[i10 + 3] == '.' && (cArr4[i10] == 'O' || cArr4[i10] == 'o')) {
                char[] cArr5 = this.f8215g;
                int i11 = this.f8212d + 1;
                if (cArr5[i11] == 'I' || cArr5[i11] == 'i') {
                    char[] cArr6 = this.f8215g;
                    int i12 = this.f8212d + 2;
                    if (cArr6[i12] == 'D' || cArr6[i12] == 'd') {
                        this.f8212d += 4;
                    }
                }
            }
        }
        char[] cArr7 = this.f8215g;
        int i13 = this.f8212d;
        return new String(cArr7, i13, this.f8213e - i13);
    }

    /* renamed from: f */
    private String m7932f() {
        this.f8211c++;
        this.f8212d = this.f8211c;
        this.f8213e = this.f8212d;
        while (true) {
            int i2 = this.f8211c;
            if (i2 == this.f8210b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f8209a);
            }
            char[] cArr = this.f8215g;
            if (cArr[i2] == '\"') {
                this.f8211c = i2 + 1;
                while (true) {
                    int i3 = this.f8211c;
                    if (i3 >= this.f8210b || this.f8215g[i3] != ' ') {
                        break;
                    }
                    this.f8211c = i3 + 1;
                }
                char[] cArr2 = this.f8215g;
                int i4 = this.f8212d;
                return new String(cArr2, i4, this.f8213e - i4);
            }
            if (cArr[i2] == '\\') {
                cArr[this.f8213e] = m7928b();
            } else {
                cArr[this.f8213e] = cArr[i2];
            }
            this.f8211c++;
            this.f8213e++;
        }
    }

    /* renamed from: b */
    public List<String> m7934b(String str) {
        String m7932f;
        this.f8211c = 0;
        this.f8212d = 0;
        this.f8213e = 0;
        this.f8214f = 0;
        this.f8215g = this.f8209a.toCharArray();
        List<String> emptyList = Collections.emptyList();
        String m7931e = m7931e();
        if (m7931e == null) {
            return emptyList;
        }
        do {
            int i2 = this.f8211c;
            if (i2 < this.f8210b) {
                char c2 = this.f8215g[i2];
                if (c2 == '\"') {
                    m7932f = m7932f();
                } else if (c2 != '#') {
                    m7932f = (c2 == '+' || c2 == ',' || c2 == ';') ? "" : m7927a();
                } else {
                    m7932f = m7930d();
                }
                if (str.equalsIgnoreCase(m7931e)) {
                    if (emptyList.isEmpty()) {
                        emptyList = new ArrayList<>();
                    }
                    emptyList.add(m7932f);
                }
                int i3 = this.f8211c;
                if (i3 < this.f8210b) {
                    char[] cArr = this.f8215g;
                    if (cArr[i3] != ',' && cArr[i3] != ';' && cArr[i3] != '+') {
                        throw new IllegalStateException("Malformed DN: " + this.f8209a);
                    }
                    this.f8211c++;
                    m7931e = m7931e();
                }
            }
            return emptyList;
        } while (m7931e != null);
        throw new IllegalStateException("Malformed DN: " + this.f8209a);
    }

    /* renamed from: a */
    private int m7926a(int i2) {
        int i3;
        int i4;
        int i5 = i2 + 1;
        if (i5 < this.f8210b) {
            char c2 = this.f8215g[i2];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else {
                if (c2 < 'A' || c2 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.f8209a);
                }
                i3 = c2 - '7';
            }
            char c3 = this.f8215g[i5];
            if (c3 >= '0' && c3 <= '9') {
                i4 = c3 - '0';
            } else if (c3 >= 'a' && c3 <= 'f') {
                i4 = c3 - 'W';
            } else {
                if (c3 < 'A' || c3 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.f8209a);
                }
                i4 = c3 - '7';
            }
            return (i3 << 4) + i4;
        }
        throw new IllegalStateException("Malformed DN: " + this.f8209a);
    }

    /* renamed from: a */
    public String m7933a(String str) {
        String m7932f;
        this.f8211c = 0;
        this.f8212d = 0;
        this.f8213e = 0;
        this.f8214f = 0;
        this.f8215g = this.f8209a.toCharArray();
        String m7931e = m7931e();
        if (m7931e == null) {
            return null;
        }
        do {
            int i2 = this.f8211c;
            if (i2 == this.f8210b) {
                return null;
            }
            char c2 = this.f8215g[i2];
            if (c2 == '\"') {
                m7932f = m7932f();
            } else if (c2 != '#') {
                m7932f = (c2 == '+' || c2 == ',' || c2 == ';') ? "" : m7927a();
            } else {
                m7932f = m7930d();
            }
            if (str.equalsIgnoreCase(m7931e)) {
                return m7932f;
            }
            int i3 = this.f8211c;
            if (i3 >= this.f8210b) {
                return null;
            }
            char[] cArr = this.f8215g;
            if (cArr[i3] != ',' && cArr[i3] != ';' && cArr[i3] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f8209a);
            }
            this.f8211c++;
            m7931e = m7931e();
        } while (m7931e != null);
        throw new IllegalStateException("Malformed DN: " + this.f8209a);
    }
}
