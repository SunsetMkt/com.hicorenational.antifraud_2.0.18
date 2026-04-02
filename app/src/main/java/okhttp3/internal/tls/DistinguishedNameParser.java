package okhttp3.internal.tls;

import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes2.dex */
final class DistinguishedNameParser {
    private int beg;
    private char[] chars;
    private int cur;
    private final String dn;
    private int end;
    private final int length;
    private int pos;

    DistinguishedNameParser(X500Principal x500Principal) {
        this.dn = x500Principal.getName("RFC2253");
        this.length = this.dn.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:
    
        r1 = r8.chars;
        r2 = r8.beg;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005f, code lost:
    
        return new java.lang.String(r1, r2, r8.end - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String escapedAV() {
        int i2 = this.pos;
        this.beg = i2;
        this.end = i2;
        while (true) {
            int i3 = this.pos;
            if (i3 < this.length) {
                char[] cArr = this.chars;
                char c2 = cArr[i3];
                if (c2 == ' ') {
                    int i4 = this.end;
                    this.cur = i4;
                    this.pos = i3 + 1;
                    this.end = i4 + 1;
                    cArr[i4] = ' ';
                    while (true) {
                        int i5 = this.pos;
                        if (i5 >= this.length) {
                            break;
                        }
                        char[] cArr2 = this.chars;
                        if (cArr2[i5] != ' ') {
                            break;
                        }
                        int i6 = this.end;
                        this.end = i6 + 1;
                        cArr2[i6] = ' ';
                        this.pos = i5 + 1;
                    }
                    int i7 = this.pos;
                    if (i7 == this.length) {
                        break;
                    }
                    char[] cArr3 = this.chars;
                    if (cArr3[i7] == ',' || cArr3[i7] == '+' || cArr3[i7] == ';') {
                        break;
                    }
                } else {
                    if (c2 == ';') {
                        break;
                    }
                    if (c2 == '\\') {
                        int i8 = this.end;
                        this.end = i8 + 1;
                        cArr[i8] = getEscaped();
                        this.pos++;
                    } else {
                        if (c2 == '+' || c2 == ',') {
                            break;
                        }
                        int i9 = this.end;
                        this.end = i9 + 1;
                        cArr[i9] = cArr[i3];
                        this.pos = i3 + 1;
                    }
                }
            } else {
                char[] cArr4 = this.chars;
                int i10 = this.beg;
                return new String(cArr4, i10, this.end - i10);
            }
        }
        char[] cArr5 = this.chars;
        int i11 = this.beg;
        return new String(cArr5, i11, this.cur - i11);
    }

    private int getByte(int i2) {
        int i3;
        int i4;
        int i5 = i2 + 1;
        if (i5 >= this.length) {
            throw new IllegalStateException("Malformed DN: " + this.dn);
        }
        char c2 = this.chars[i2];
        if (c2 >= '0' && c2 <= '9') {
            i3 = c2 - '0';
        } else if (c2 >= 'a' && c2 <= 'f') {
            i3 = c2 - 'W';
        } else {
            if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.dn);
            }
            i3 = c2 - '7';
        }
        char c3 = this.chars[i5];
        if (c3 >= '0' && c3 <= '9') {
            i4 = c3 - '0';
        } else if (c3 >= 'a' && c3 <= 'f') {
            i4 = c3 - 'W';
        } else {
            if (c3 < 'A' || c3 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.dn);
            }
            i4 = c3 - '7';
        }
        return (i3 << 4) + i4;
    }

    private char getEscaped() {
        this.pos++;
        int i2 = this.pos;
        if (i2 == this.length) {
            throw new IllegalStateException("Unexpected end of DN: " + this.dn);
        }
        char c2 = this.chars[i2];
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
                            return getUTF8();
                    }
                    break;
            }
        }
        return this.chars[this.pos];
    }

    private char getUTF8() {
        int i2;
        int i3;
        int i4 = getByte(this.pos);
        this.pos++;
        if (i4 < 128) {
            return (char) i4;
        }
        if (i4 < 192 || i4 > 247) {
            return '?';
        }
        if (i4 <= 223) {
            i3 = i4 & 31;
            i2 = 1;
        } else if (i4 <= 239) {
            i2 = 2;
            i3 = i4 & 15;
        } else {
            i2 = 3;
            i3 = i4 & 7;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            this.pos++;
            int i6 = this.pos;
            if (i6 == this.length || this.chars[i6] != '\\') {
                return '?';
            }
            this.pos = i6 + 1;
            int i7 = getByte(this.pos);
            this.pos++;
            if ((i7 & 192) != 128) {
                return '?';
            }
            i3 = (i3 << 6) + (i7 & 63);
        }
        return (char) i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0061, code lost:
    
        r6.end = r6.pos;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String hexAV() {
        int i2 = this.pos;
        if (i2 + 4 >= this.length) {
            throw new IllegalStateException("Unexpected end of DN: " + this.dn);
        }
        this.beg = i2;
        this.pos = i2 + 1;
        while (true) {
            int i3 = this.pos;
            if (i3 == this.length) {
                break;
            }
            char[] cArr = this.chars;
            if (cArr[i3] == '+' || cArr[i3] == ',' || cArr[i3] == ';') {
                break;
            }
            if (cArr[i3] == ' ') {
                this.end = i3;
                this.pos = i3 + 1;
                while (true) {
                    int i4 = this.pos;
                    if (i4 >= this.length || this.chars[i4] != ' ') {
                        break;
                    }
                    this.pos = i4 + 1;
                }
            } else {
                if (cArr[i3] >= 'A' && cArr[i3] <= 'F') {
                    cArr[i3] = (char) (cArr[i3] + ' ');
                }
                this.pos++;
            }
        }
        int i5 = this.end;
        int i6 = this.beg;
        int i7 = i5 - i6;
        if (i7 < 5 || (i7 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.dn);
        }
        byte[] bArr = new byte[i7 / 2];
        int i8 = i6 + 1;
        for (int i9 = 0; i9 < bArr.length; i9++) {
            bArr[i9] = (byte) getByte(i8);
            i8 += 2;
        }
        return new String(this.chars, this.beg, i7);
    }

    private String nextAT() {
        while (true) {
            int i2 = this.pos;
            if (i2 >= this.length || this.chars[i2] != ' ') {
                break;
            }
            this.pos = i2 + 1;
        }
        int i3 = this.pos;
        if (i3 == this.length) {
            return null;
        }
        this.beg = i3;
        this.pos = i3 + 1;
        while (true) {
            int i4 = this.pos;
            if (i4 >= this.length) {
                break;
            }
            char[] cArr = this.chars;
            if (cArr[i4] == '=' || cArr[i4] == ' ') {
                break;
            }
            this.pos = i4 + 1;
        }
        int i5 = this.pos;
        if (i5 >= this.length) {
            throw new IllegalStateException("Unexpected end of DN: " + this.dn);
        }
        this.end = i5;
        if (this.chars[i5] == ' ') {
            while (true) {
                int i6 = this.pos;
                if (i6 >= this.length) {
                    break;
                }
                char[] cArr2 = this.chars;
                if (cArr2[i6] == '=' || cArr2[i6] != ' ') {
                    break;
                }
                this.pos = i6 + 1;
            }
            char[] cArr3 = this.chars;
            int i7 = this.pos;
            if (cArr3[i7] != '=' || i7 == this.length) {
                throw new IllegalStateException("Unexpected end of DN: " + this.dn);
            }
        }
        this.pos++;
        while (true) {
            int i8 = this.pos;
            if (i8 >= this.length || this.chars[i8] != ' ') {
                break;
            }
            this.pos = i8 + 1;
        }
        int i9 = this.end;
        int i10 = this.beg;
        if (i9 - i10 > 4) {
            char[] cArr4 = this.chars;
            if (cArr4[i10 + 3] == '.' && (cArr4[i10] == 'O' || cArr4[i10] == 'o')) {
                char[] cArr5 = this.chars;
                int i11 = this.beg;
                if (cArr5[i11 + 1] == 'I' || cArr5[i11 + 1] == 'i') {
                    char[] cArr6 = this.chars;
                    int i12 = this.beg;
                    if (cArr6[i12 + 2] == 'D' || cArr6[i12 + 2] == 'd') {
                        this.beg += 4;
                    }
                }
            }
        }
        char[] cArr7 = this.chars;
        int i13 = this.beg;
        return new String(cArr7, i13, this.end - i13);
    }

    private String quotedAV() {
        this.pos++;
        this.beg = this.pos;
        this.end = this.beg;
        while (true) {
            int i2 = this.pos;
            if (i2 == this.length) {
                throw new IllegalStateException("Unexpected end of DN: " + this.dn);
            }
            char[] cArr = this.chars;
            if (cArr[i2] == '\"') {
                this.pos = i2 + 1;
                while (true) {
                    int i3 = this.pos;
                    if (i3 >= this.length || this.chars[i3] != ' ') {
                        break;
                    }
                    this.pos = i3 + 1;
                }
                char[] cArr2 = this.chars;
                int i4 = this.beg;
                return new String(cArr2, i4, this.end - i4);
            }
            if (cArr[i2] == '\\') {
                cArr[this.end] = getEscaped();
            } else {
                cArr[this.end] = cArr[i2];
            }
            this.pos++;
            this.end++;
        }
    }

    public String findMostSpecific(String str) {
        this.pos = 0;
        this.beg = 0;
        this.end = 0;
        this.cur = 0;
        this.chars = this.dn.toCharArray();
        String strNextAT = nextAT();
        if (strNextAT == null) {
            return null;
        }
        do {
            int i2 = this.pos;
            if (i2 == this.length) {
                return null;
            }
            char c2 = this.chars[i2];
            String strEscapedAV = c2 != '\"' ? c2 != '#' ? (c2 == '+' || c2 == ',' || c2 == ';') ? "" : escapedAV() : hexAV() : quotedAV();
            if (str.equalsIgnoreCase(strNextAT)) {
                return strEscapedAV;
            }
            int i3 = this.pos;
            if (i3 >= this.length) {
                return null;
            }
            char[] cArr = this.chars;
            if (cArr[i3] != ',' && cArr[i3] != ';' && cArr[i3] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.dn);
            }
            this.pos++;
            strNextAT = nextAT();
        } while (strNextAT != null);
        throw new IllegalStateException("Malformed DN: " + this.dn);
    }
}
