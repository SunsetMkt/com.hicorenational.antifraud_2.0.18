package com.huawei.secure.android.common.util;

/* renamed from: com.huawei.secure.android.common.util.a */
/* loaded from: classes.dex */
public class C2569a {

    /* renamed from: a */
    private String f8295a;

    /* renamed from: b */
    private Character f8296b;

    /* renamed from: c */
    private Character f8297c;

    /* renamed from: d */
    private int f8298d = 0;

    /* renamed from: e */
    private int f8299e = 0;

    public C2569a(String str) {
        this.f8295a = str;
    }

    /* renamed from: c */
    public static boolean m8060c(Character ch) {
        char charValue;
        return ch != null && (charValue = ch.charValue()) >= '0' && charValue <= '7';
    }

    /* renamed from: a */
    public void m8061a(Character ch) {
        this.f8296b = ch;
    }

    /* renamed from: b */
    public int m8064b() {
        return this.f8298d;
    }

    /* renamed from: d */
    public Character m8066d() {
        Character ch = this.f8296b;
        if (ch != null) {
            this.f8296b = null;
            return ch;
        }
        String str = this.f8295a;
        if (str == null || str.length() == 0 || this.f8298d >= this.f8295a.length()) {
            return null;
        }
        String str2 = this.f8295a;
        int i2 = this.f8298d;
        this.f8298d = i2 + 1;
        return Character.valueOf(str2.charAt(i2));
    }

    /* renamed from: e */
    public Character m8067e() {
        Character m8066d = m8066d();
        if (m8066d != null && m8059b(m8066d)) {
            return m8066d;
        }
        return null;
    }

    /* renamed from: f */
    public Character m8068f() {
        Character m8066d = m8066d();
        if (m8066d != null && m8060c(m8066d)) {
            return m8066d;
        }
        return null;
    }

    /* renamed from: g */
    public Character m8069g() {
        Character ch = this.f8296b;
        if (ch != null) {
            return ch;
        }
        String str = this.f8295a;
        if (str == null || str.length() == 0 || this.f8298d >= this.f8295a.length()) {
            return null;
        }
        return Character.valueOf(this.f8295a.charAt(this.f8298d));
    }

    /* renamed from: h */
    protected String m8070h() {
        String substring = this.f8295a.substring(this.f8298d);
        if (this.f8296b == null) {
            return substring;
        }
        return this.f8296b + substring;
    }

    /* renamed from: i */
    public void m8071i() {
        this.f8296b = this.f8297c;
        this.f8298d = this.f8299e;
    }

    /* renamed from: b */
    public static boolean m8059b(Character ch) {
        if (ch == null) {
            return false;
        }
        char charValue = ch.charValue();
        return (charValue >= '0' && charValue <= '9') || (charValue >= 'a' && charValue <= 'f') || (charValue >= 'A' && charValue <= 'F');
    }

    /* renamed from: a */
    public boolean m8062a() {
        if (this.f8296b != null) {
            return true;
        }
        String str = this.f8295a;
        return (str == null || str.length() == 0 || this.f8298d >= this.f8295a.length()) ? false : true;
    }

    /* renamed from: c */
    public void m8065c() {
        this.f8297c = this.f8296b;
        this.f8299e = this.f8298d;
    }

    /* renamed from: a */
    public boolean m8063a(char c2) {
        Character ch = this.f8296b;
        if (ch != null && ch.charValue() == c2) {
            return true;
        }
        String str = this.f8295a;
        return str != null && str.length() != 0 && this.f8298d < this.f8295a.length() && this.f8295a.charAt(this.f8298d) == c2;
    }
}
