package com.huawei.secure.android.common.ssl.hostname;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f5196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f5198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5199e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f5200f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private char[] f5201g;

    public a(X500Principal x500Principal) {
        this.a = x500Principal.getName("RFC2253");
        this.f5196b = this.a.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:
    
        r1 = r8.f5201g;
        r2 = r8.f5198d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005f, code lost:
    
        return new java.lang.String(r1, r2, r8.f5199e - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a() {
        int i2 = this.f5197c;
        this.f5198d = i2;
        this.f5199e = i2;
        while (true) {
            int i3 = this.f5197c;
            if (i3 < this.f5196b) {
                char[] cArr = this.f5201g;
                char c2 = cArr[i3];
                if (c2 == ' ') {
                    int i4 = this.f5199e;
                    this.f5200f = i4;
                    this.f5197c = i3 + 1;
                    this.f5199e = i4 + 1;
                    cArr[i4] = ' ';
                    while (true) {
                        int i5 = this.f5197c;
                        if (i5 >= this.f5196b) {
                            break;
                        }
                        char[] cArr2 = this.f5201g;
                        if (cArr2[i5] != ' ') {
                            break;
                        }
                        int i6 = this.f5199e;
                        this.f5199e = i6 + 1;
                        cArr2[i6] = ' ';
                        this.f5197c = i5 + 1;
                    }
                    int i7 = this.f5197c;
                    if (i7 == this.f5196b) {
                        break;
                    }
                    char[] cArr3 = this.f5201g;
                    if (cArr3[i7] == ',' || cArr3[i7] == '+' || cArr3[i7] == ';') {
                        break;
                    }
                } else {
                    if (c2 == ';') {
                        break;
                    }
                    if (c2 == '\\') {
                        int i8 = this.f5199e;
                        this.f5199e = i8 + 1;
                        cArr[i8] = b();
                        this.f5197c++;
                    } else {
                        if (c2 == '+' || c2 == ',') {
                            break;
                        }
                        int i9 = this.f5199e;
                        this.f5199e = i9 + 1;
                        cArr[i9] = cArr[i3];
                        this.f5197c = i3 + 1;
                    }
                }
            } else {
                char[] cArr4 = this.f5201g;
                int i10 = this.f5198d;
                return new String(cArr4, i10, this.f5199e - i10);
            }
        }
        char[] cArr5 = this.f5201g;
        int i11 = this.f5198d;
        return new String(cArr5, i11, this.f5200f - i11);
    }

    private char b() {
        this.f5197c++;
        int i2 = this.f5197c;
        if (i2 == this.f5196b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.a);
        }
        char[] cArr = this.f5201g;
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
                            return c();
                    }
                    break;
            }
        }
        return cArr[i2];
    }

    private char c() {
        int i2;
        int i3;
        int iA = a(this.f5197c);
        this.f5197c++;
        if (iA < 128) {
            return (char) iA;
        }
        if (iA < 192 || iA > 247) {
            return '?';
        }
        if (iA <= 223) {
            i3 = iA & 31;
            i2 = 1;
        } else if (iA <= 239) {
            i2 = 2;
            i3 = iA & 15;
        } else {
            i2 = 3;
            i3 = iA & 7;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            this.f5197c++;
            int i5 = this.f5197c;
            if (i5 == this.f5196b || this.f5201g[i5] != '\\') {
                return '?';
            }
            this.f5197c = i5 + 1;
            int iA2 = a(this.f5197c);
            this.f5197c++;
            if ((iA2 & 192) != 128) {
                return '?';
            }
            i3 = (i3 << 6) + (iA2 & 63);
        }
        return (char) i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0061, code lost:
    
        r6.f5199e = r6.f5197c;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String d() {
        int i2 = this.f5197c;
        if (i2 + 4 >= this.f5196b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.a);
        }
        this.f5198d = i2;
        this.f5197c = i2 + 1;
        while (true) {
            int i3 = this.f5197c;
            if (i3 == this.f5196b) {
                break;
            }
            char[] cArr = this.f5201g;
            if (cArr[i3] == '+' || cArr[i3] == ',' || cArr[i3] == ';') {
                break;
            }
            if (cArr[i3] == ' ') {
                this.f5199e = i3;
                this.f5197c = i3 + 1;
                while (true) {
                    int i4 = this.f5197c;
                    if (i4 >= this.f5196b || this.f5201g[i4] != ' ') {
                        break;
                    }
                    this.f5197c = i4 + 1;
                }
            } else {
                if (cArr[i3] >= 'A' && cArr[i3] <= 'F') {
                    cArr[i3] = (char) (cArr[i3] + ' ');
                }
                this.f5197c++;
            }
        }
        int i5 = this.f5199e;
        int i6 = this.f5198d;
        int i7 = i5 - i6;
        if (i7 < 5 || (i7 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.a);
        }
        byte[] bArr = new byte[i7 / 2];
        int i8 = i6 + 1;
        for (int i9 = 0; i9 < bArr.length; i9++) {
            bArr[i9] = (byte) a(i8);
            i8 += 2;
        }
        return new String(this.f5201g, this.f5198d, i7);
    }

    private String e() {
        while (true) {
            int i2 = this.f5197c;
            if (i2 >= this.f5196b || this.f5201g[i2] != ' ') {
                break;
            }
            this.f5197c = i2 + 1;
        }
        int i3 = this.f5197c;
        if (i3 == this.f5196b) {
            return null;
        }
        this.f5198d = i3;
        this.f5197c = i3 + 1;
        while (true) {
            int i4 = this.f5197c;
            if (i4 >= this.f5196b) {
                break;
            }
            char[] cArr = this.f5201g;
            if (cArr[i4] == '=' || cArr[i4] == ' ') {
                break;
            }
            this.f5197c = i4 + 1;
        }
        int i5 = this.f5197c;
        if (i5 >= this.f5196b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.a);
        }
        this.f5199e = i5;
        if (this.f5201g[i5] == ' ') {
            while (true) {
                int i6 = this.f5197c;
                if (i6 >= this.f5196b) {
                    break;
                }
                char[] cArr2 = this.f5201g;
                if (cArr2[i6] == '=' || cArr2[i6] != ' ') {
                    break;
                }
                this.f5197c = i6 + 1;
            }
            char[] cArr3 = this.f5201g;
            int i7 = this.f5197c;
            if (cArr3[i7] != '=' || i7 == this.f5196b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.a);
            }
        }
        this.f5197c++;
        while (true) {
            int i8 = this.f5197c;
            if (i8 >= this.f5196b || this.f5201g[i8] != ' ') {
                break;
            }
            this.f5197c = i8 + 1;
        }
        int i9 = this.f5199e;
        int i10 = this.f5198d;
        if (i9 - i10 > 4) {
            char[] cArr4 = this.f5201g;
            if (cArr4[i10 + 3] == '.' && (cArr4[i10] == 'O' || cArr4[i10] == 'o')) {
                char[] cArr5 = this.f5201g;
                int i11 = this.f5198d + 1;
                if (cArr5[i11] == 'I' || cArr5[i11] == 'i') {
                    char[] cArr6 = this.f5201g;
                    int i12 = this.f5198d + 2;
                    if (cArr6[i12] == 'D' || cArr6[i12] == 'd') {
                        this.f5198d += 4;
                    }
                }
            }
        }
        char[] cArr7 = this.f5201g;
        int i13 = this.f5198d;
        return new String(cArr7, i13, this.f5199e - i13);
    }

    private String f() {
        this.f5197c++;
        this.f5198d = this.f5197c;
        this.f5199e = this.f5198d;
        while (true) {
            int i2 = this.f5197c;
            if (i2 == this.f5196b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.a);
            }
            char[] cArr = this.f5201g;
            if (cArr[i2] == '\"') {
                this.f5197c = i2 + 1;
                while (true) {
                    int i3 = this.f5197c;
                    if (i3 >= this.f5196b || this.f5201g[i3] != ' ') {
                        break;
                    }
                    this.f5197c = i3 + 1;
                }
                char[] cArr2 = this.f5201g;
                int i4 = this.f5198d;
                return new String(cArr2, i4, this.f5199e - i4);
            }
            if (cArr[i2] == '\\') {
                cArr[this.f5199e] = b();
            } else {
                cArr[this.f5199e] = cArr[i2];
            }
            this.f5197c++;
            this.f5199e++;
        }
    }

    public List<String> b(String str) {
        String strF;
        this.f5197c = 0;
        this.f5198d = 0;
        this.f5199e = 0;
        this.f5200f = 0;
        this.f5201g = this.a.toCharArray();
        List<String> listEmptyList = Collections.emptyList();
        String strE = e();
        if (strE == null) {
            return listEmptyList;
        }
        do {
            int i2 = this.f5197c;
            if (i2 < this.f5196b) {
                char c2 = this.f5201g[i2];
                if (c2 == '\"') {
                    strF = f();
                } else if (c2 != '#') {
                    strF = (c2 == '+' || c2 == ',' || c2 == ';') ? "" : a();
                } else {
                    strF = d();
                }
                if (str.equalsIgnoreCase(strE)) {
                    if (listEmptyList.isEmpty()) {
                        listEmptyList = new ArrayList<>();
                    }
                    listEmptyList.add(strF);
                }
                int i3 = this.f5197c;
                if (i3 < this.f5196b) {
                    char[] cArr = this.f5201g;
                    if (cArr[i3] != ',' && cArr[i3] != ';' && cArr[i3] != '+') {
                        throw new IllegalStateException("Malformed DN: " + this.a);
                    }
                    this.f5197c++;
                    strE = e();
                }
            }
            return listEmptyList;
        } while (strE != null);
        throw new IllegalStateException("Malformed DN: " + this.a);
    }

    private int a(int i2) {
        int i3;
        int i4;
        int i5 = i2 + 1;
        if (i5 < this.f5196b) {
            char c2 = this.f5201g[i2];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else {
                if (c2 < 'A' || c2 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.a);
                }
                i3 = c2 - '7';
            }
            char c3 = this.f5201g[i5];
            if (c3 >= '0' && c3 <= '9') {
                i4 = c3 - '0';
            } else if (c3 >= 'a' && c3 <= 'f') {
                i4 = c3 - 'W';
            } else {
                if (c3 < 'A' || c3 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.a);
                }
                i4 = c3 - '7';
            }
            return (i3 << 4) + i4;
        }
        throw new IllegalStateException("Malformed DN: " + this.a);
    }

    public String a(String str) {
        String strF;
        this.f5197c = 0;
        this.f5198d = 0;
        this.f5199e = 0;
        this.f5200f = 0;
        this.f5201g = this.a.toCharArray();
        String strE = e();
        if (strE == null) {
            return null;
        }
        do {
            int i2 = this.f5197c;
            if (i2 == this.f5196b) {
                return null;
            }
            char c2 = this.f5201g[i2];
            if (c2 == '\"') {
                strF = f();
            } else if (c2 != '#') {
                strF = (c2 == '+' || c2 == ',' || c2 == ';') ? "" : a();
            } else {
                strF = d();
            }
            if (str.equalsIgnoreCase(strE)) {
                return strF;
            }
            int i3 = this.f5197c;
            if (i3 >= this.f5196b) {
                return null;
            }
            char[] cArr = this.f5201g;
            if (cArr[i3] != ',' && cArr[i3] != ';' && cArr[i3] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.a);
            }
            this.f5197c++;
            strE = e();
        } while (strE != null);
        throw new IllegalStateException("Malformed DN: " + this.a);
    }
}
