package com.huawei.secure.android.common.util;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Character f5250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Character f5251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f5252d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5253e = 0;

    public a(String str) {
        this.a = str;
    }

    public static boolean c(Character ch) {
        char cCharValue;
        return ch != null && (cCharValue = ch.charValue()) >= '0' && cCharValue <= '7';
    }

    public void a(Character ch) {
        this.f5250b = ch;
    }

    public int b() {
        return this.f5252d;
    }

    public Character d() {
        Character ch = this.f5250b;
        if (ch != null) {
            this.f5250b = null;
            return ch;
        }
        String str = this.a;
        if (str == null || str.length() == 0 || this.f5252d >= this.a.length()) {
            return null;
        }
        String str2 = this.a;
        int i2 = this.f5252d;
        this.f5252d = i2 + 1;
        return Character.valueOf(str2.charAt(i2));
    }

    public Character e() {
        Character chD = d();
        if (chD != null && b(chD)) {
            return chD;
        }
        return null;
    }

    public Character f() {
        Character chD = d();
        if (chD != null && c(chD)) {
            return chD;
        }
        return null;
    }

    public Character g() {
        Character ch = this.f5250b;
        if (ch != null) {
            return ch;
        }
        String str = this.a;
        if (str == null || str.length() == 0 || this.f5252d >= this.a.length()) {
            return null;
        }
        return Character.valueOf(this.a.charAt(this.f5252d));
    }

    protected String h() {
        String strSubstring = this.a.substring(this.f5252d);
        if (this.f5250b == null) {
            return strSubstring;
        }
        return this.f5250b + strSubstring;
    }

    public void i() {
        this.f5250b = this.f5251c;
        this.f5252d = this.f5253e;
    }

    public static boolean b(Character ch) {
        if (ch == null) {
            return false;
        }
        char cCharValue = ch.charValue();
        return (cCharValue >= '0' && cCharValue <= '9') || (cCharValue >= 'a' && cCharValue <= 'f') || (cCharValue >= 'A' && cCharValue <= 'F');
    }

    public boolean a() {
        if (this.f5250b != null) {
            return true;
        }
        String str = this.a;
        return (str == null || str.length() == 0 || this.f5252d >= this.a.length()) ? false : true;
    }

    public void c() {
        this.f5251c = this.f5250b;
        this.f5253e = this.f5252d;
    }

    public boolean a(char c2) {
        Character ch = this.f5250b;
        if (ch != null && ch.charValue() == c2) {
            return true;
        }
        String str = this.a;
        return str != null && str.length() != 0 && this.f5252d < this.a.length() && this.a.charAt(this.f5252d) == c2;
    }
}
