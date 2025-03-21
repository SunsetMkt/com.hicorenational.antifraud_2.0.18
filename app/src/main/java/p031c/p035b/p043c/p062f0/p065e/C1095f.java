package p031c.p035b.p043c.p062f0.p065e;

import p031c.p035b.p043c.p062f0.p063c.C1083j;
import p031c.p035b.p043c.p062f0.p063c.EnumC1079f;
import p031c.p035b.p043c.p062f0.p063c.EnumC1081h;

/* compiled from: QRCode.java */
/* renamed from: c.b.c.f0.e.f */
/* loaded from: classes.dex */
public final class C1095f {

    /* renamed from: f */
    public static final int f2190f = 8;

    /* renamed from: a */
    private EnumC1081h f2191a;

    /* renamed from: b */
    private EnumC1079f f2192b;

    /* renamed from: c */
    private C1083j f2193c;

    /* renamed from: d */
    private int f2194d = -1;

    /* renamed from: e */
    private C1091b f2195e;

    /* renamed from: b */
    public static boolean m1882b(int i2) {
        return i2 >= 0 && i2 < 8;
    }

    /* renamed from: a */
    public EnumC1079f m1883a() {
        return this.f2192b;
    }

    /* renamed from: b */
    public int m1889b() {
        return this.f2194d;
    }

    /* renamed from: c */
    public C1091b m1890c() {
        return this.f2195e;
    }

    /* renamed from: d */
    public EnumC1081h m1891d() {
        return this.f2191a;
    }

    /* renamed from: e */
    public C1083j m1892e() {
        return this.f2193c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.f2191a);
        sb.append("\n ecLevel: ");
        sb.append(this.f2192b);
        sb.append("\n version: ");
        sb.append(this.f2193c);
        sb.append("\n maskPattern: ");
        sb.append(this.f2194d);
        if (this.f2195e == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.f2195e);
        }
        sb.append(">>\n");
        return sb.toString();
    }

    /* renamed from: a */
    public void m1886a(EnumC1081h enumC1081h) {
        this.f2191a = enumC1081h;
    }

    /* renamed from: a */
    public void m1885a(EnumC1079f enumC1079f) {
        this.f2192b = enumC1079f;
    }

    /* renamed from: a */
    public void m1887a(C1083j c1083j) {
        this.f2193c = c1083j;
    }

    /* renamed from: a */
    public void m1884a(int i2) {
        this.f2194d = i2;
    }

    /* renamed from: a */
    public void m1888a(C1091b c1091b) {
        this.f2195e = c1091b;
    }
}
