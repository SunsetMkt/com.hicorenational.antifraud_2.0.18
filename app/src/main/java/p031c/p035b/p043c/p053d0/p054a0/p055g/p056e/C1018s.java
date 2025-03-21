package p031c.p035b.p043c.p053d0.p054a0.p055g.p056e;

import com.tencent.bugly.beta.tinker.TinkerReport;
import p031c.p035b.p043c.C1097h;
import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.p072z.C1162a;
import p286h.p323z2.C5736h0;
import util.p395c2.C7265a;

/* compiled from: GeneralAppIdDecoder.java */
/* renamed from: c.b.c.d0.a0.g.e.s */
/* loaded from: classes.dex */
final class C1018s {

    /* renamed from: a */
    private final C1162a f1870a;

    /* renamed from: b */
    private final C1012m f1871b = new C1012m();

    /* renamed from: c */
    private final StringBuilder f1872c = new StringBuilder();

    C1018s(C1162a c1162a) {
        this.f1870a = c1162a;
    }

    /* renamed from: b */
    private C1014o m1467b() throws C1097h {
        C1011l m1470d;
        boolean m1438b;
        do {
            int m1439a = this.f1871b.m1439a();
            if (this.f1871b.m1442b()) {
                m1470d = m1464a();
                m1438b = m1470d.m1438b();
            } else if (this.f1871b.m1443c()) {
                m1470d = m1468c();
                m1438b = m1470d.m1438b();
            } else {
                m1470d = m1470d();
                m1438b = m1470d.m1438b();
            }
            if (!(m1439a != this.f1871b.m1439a()) && !m1438b) {
                break;
            }
        } while (!m1438b);
        return m1470d.m1437a();
    }

    /* renamed from: c */
    private C1015p m1469c(int i2) throws C1097h {
        int i3 = i2 + 7;
        if (i3 > this.f1870a.m2157c()) {
            int m1477a = m1477a(i2, 4);
            return m1477a == 0 ? new C1015p(this.f1870a.m2157c(), 10, 10) : new C1015p(this.f1870a.m2157c(), m1477a - 1, 10);
        }
        int m1477a2 = m1477a(i2, 7) - 8;
        return new C1015p(i3, m1477a2 / 11, m1477a2 % 11);
    }

    /* renamed from: d */
    private C1011l m1470d() throws C1097h {
        while (m1476i(this.f1871b.m1439a())) {
            C1015p m1469c = m1469c(this.f1871b.m1439a());
            this.f1871b.m1441b(m1469c.m1459a());
            if (m1469c.m1457f()) {
                return new C1011l(m1469c.m1458g() ? new C1014o(this.f1871b.m1439a(), this.f1872c.toString()) : new C1014o(this.f1871b.m1439a(), this.f1872c.toString(), m1469c.m1454c()), true);
            }
            this.f1872c.append(m1469c.m1453b());
            if (m1469c.m1458g()) {
                return new C1011l(new C1014o(this.f1871b.m1439a(), this.f1872c.toString()), true);
            }
            this.f1872c.append(m1469c.m1454c());
        }
        if (m1473f(this.f1871b.m1439a())) {
            this.f1871b.m1445e();
            this.f1871b.m1440a(4);
        }
        return new C1011l(false);
    }

    /* renamed from: e */
    private boolean m1472e(int i2) {
        int i3;
        if (i2 + 1 > this.f1870a.m2157c()) {
            return false;
        }
        for (int i4 = 0; i4 < 5 && (i3 = i4 + i2) < this.f1870a.m2157c(); i4++) {
            if (i4 == 2) {
                if (!this.f1870a.m2155b(i2 + 2)) {
                    return false;
                }
            } else if (this.f1870a.m2155b(i3)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    private boolean m1473f(int i2) {
        int i3;
        if (i2 + 1 > this.f1870a.m2157c()) {
            return false;
        }
        for (int i4 = 0; i4 < 4 && (i3 = i4 + i2) < this.f1870a.m2157c(); i4++) {
            if (this.f1870a.m2155b(i3)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: g */
    private boolean m1474g(int i2) {
        int m1477a;
        if (i2 + 5 > this.f1870a.m2157c()) {
            return false;
        }
        int m1477a2 = m1477a(i2, 5);
        if (m1477a2 < 5 || m1477a2 >= 16) {
            return i2 + 6 <= this.f1870a.m2157c() && (m1477a = m1477a(i2, 6)) >= 16 && m1477a < 63;
        }
        return true;
    }

    /* renamed from: h */
    private boolean m1475h(int i2) {
        int m1477a;
        if (i2 + 5 > this.f1870a.m2157c()) {
            return false;
        }
        int m1477a2 = m1477a(i2, 5);
        if (m1477a2 >= 5 && m1477a2 < 16) {
            return true;
        }
        if (i2 + 7 > this.f1870a.m2157c()) {
            return false;
        }
        int m1477a3 = m1477a(i2, 7);
        if (m1477a3 < 64 || m1477a3 >= 116) {
            return i2 + 8 <= this.f1870a.m2157c() && (m1477a = m1477a(i2, 8)) >= 232 && m1477a < 253;
        }
        return true;
    }

    /* renamed from: i */
    private boolean m1476i(int i2) {
        if (i2 + 7 > this.f1870a.m2157c()) {
            return i2 + 4 <= this.f1870a.m2157c();
        }
        int i3 = i2;
        while (true) {
            int i4 = i2 + 3;
            if (i3 >= i4) {
                return this.f1870a.m2155b(i4);
            }
            if (this.f1870a.m2155b(i3)) {
                return true;
            }
            i3++;
        }
    }

    /* renamed from: a */
    String m1479a(StringBuilder sb, int i2) throws C1102m, C1097h {
        String str = null;
        while (true) {
            C1014o m1478a = m1478a(i2, str);
            String m1461a = C1017r.m1461a(m1478a.m1450b());
            if (m1461a != null) {
                sb.append(m1461a);
            }
            String valueOf = m1478a.m1452d() ? String.valueOf(m1478a.m1451c()) : null;
            if (i2 == m1478a.m1459a()) {
                return sb.toString();
            }
            i2 = m1478a.m1459a();
            str = valueOf;
        }
    }

    /* renamed from: c */
    private C1011l m1468c() throws C1097h {
        while (m1475h(this.f1871b.m1439a())) {
            C1013n m1466b = m1466b(this.f1871b.m1439a());
            this.f1871b.m1441b(m1466b.m1459a());
            if (m1466b.m1449c()) {
                return new C1011l(new C1014o(this.f1871b.m1439a(), this.f1872c.toString()), true);
            }
            this.f1872c.append(m1466b.m1448b());
        }
        if (m1471d(this.f1871b.m1439a())) {
            this.f1871b.m1440a(3);
            this.f1871b.m1447g();
        } else if (m1472e(this.f1871b.m1439a())) {
            if (this.f1871b.m1439a() + 5 < this.f1870a.m2157c()) {
                this.f1871b.m1440a(5);
            } else {
                this.f1871b.m1441b(this.f1870a.m2157c());
            }
            this.f1871b.m1445e();
        }
        return new C1011l(false);
    }

    /* renamed from: a */
    int m1477a(int i2, int i3) {
        return m1463a(this.f1870a, i2, i3);
    }

    /* renamed from: a */
    static int m1463a(C1162a c1162a, int i2, int i3) {
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            if (c1162a.m2155b(i2 + i5)) {
                i4 |= 1 << ((i3 - i5) - 1);
            }
        }
        return i4;
    }

    /* renamed from: a */
    C1014o m1478a(int i2, String str) throws C1097h {
        this.f1872c.setLength(0);
        if (str != null) {
            this.f1872c.append(str);
        }
        this.f1871b.m1441b(i2);
        C1014o m1467b = m1467b();
        if (m1467b != null && m1467b.m1452d()) {
            return new C1014o(this.f1871b.m1439a(), this.f1872c.toString(), m1467b.m1451c());
        }
        return new C1014o(this.f1871b.m1439a(), this.f1872c.toString());
    }

    /* renamed from: b */
    private C1013n m1466b(int i2) throws C1097h {
        char c2;
        int m1477a = m1477a(i2, 5);
        if (m1477a == 15) {
            return new C1013n(i2 + 5, C5736h0.f20713b);
        }
        if (m1477a >= 5 && m1477a < 15) {
            return new C1013n(i2 + 5, (char) ((m1477a + 48) - 5));
        }
        int m1477a2 = m1477a(i2, 7);
        if (m1477a2 >= 64 && m1477a2 < 90) {
            return new C1013n(i2 + 7, (char) (m1477a2 + 1));
        }
        if (m1477a2 >= 90 && m1477a2 < 116) {
            return new C1013n(i2 + 7, (char) (m1477a2 + 7));
        }
        switch (m1477a(i2, 8)) {
            case 232:
                c2 = '!';
                break;
            case 233:
                c2 = C5736h0.f20712a;
                break;
            case 234:
                c2 = '%';
                break;
            case C7265a.f25196C0 /* 235 */:
                c2 = C5736h0.f20714c;
                break;
            case 236:
                c2 = '\'';
                break;
            case 237:
                c2 = '(';
                break;
            case 238:
                c2 = ')';
                break;
            case 239:
                c2 = '*';
                break;
            case 240:
                c2 = '+';
                break;
            case 241:
                c2 = ',';
                break;
            case 242:
                c2 = '-';
                break;
            case 243:
                c2 = '.';
                break;
            case 244:
                c2 = '/';
                break;
            case 245:
                c2 = ':';
                break;
            case 246:
                c2 = ';';
                break;
            case 247:
                c2 = C5736h0.f20715d;
                break;
            case 248:
                c2 = '=';
                break;
            case 249:
                c2 = C5736h0.f20716e;
                break;
            case 250:
                c2 = '?';
                break;
            case TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION /* 251 */:
                c2 = '_';
                break;
            case TinkerReport.KEY_LOADED_EXCEPTION_DEX /* 252 */:
                c2 = ' ';
                break;
            default:
                throw C1097h.getFormatInstance();
        }
        return new C1013n(i2 + 8, c2);
    }

    /* renamed from: a */
    private C1011l m1464a() {
        while (m1474g(this.f1871b.m1439a())) {
            C1013n m1465a = m1465a(this.f1871b.m1439a());
            this.f1871b.m1441b(m1465a.m1459a());
            if (m1465a.m1449c()) {
                return new C1011l(new C1014o(this.f1871b.m1439a(), this.f1872c.toString()), true);
            }
            this.f1872c.append(m1465a.m1448b());
        }
        if (m1471d(this.f1871b.m1439a())) {
            this.f1871b.m1440a(3);
            this.f1871b.m1447g();
        } else if (m1472e(this.f1871b.m1439a())) {
            if (this.f1871b.m1439a() + 5 < this.f1870a.m2157c()) {
                this.f1871b.m1440a(5);
            } else {
                this.f1871b.m1441b(this.f1870a.m2157c());
            }
            this.f1871b.m1446f();
        }
        return new C1011l(false);
    }

    /* renamed from: d */
    private boolean m1471d(int i2) {
        int i3 = i2 + 3;
        if (i3 > this.f1870a.m2157c()) {
            return false;
        }
        while (i2 < i3) {
            if (this.f1870a.m2155b(i2)) {
                return false;
            }
            i2++;
        }
        return true;
    }

    /* renamed from: a */
    private C1013n m1465a(int i2) {
        char c2;
        int m1477a = m1477a(i2, 5);
        if (m1477a == 15) {
            return new C1013n(i2 + 5, C5736h0.f20713b);
        }
        if (m1477a >= 5 && m1477a < 15) {
            return new C1013n(i2 + 5, (char) ((m1477a + 48) - 5));
        }
        int m1477a2 = m1477a(i2, 6);
        if (m1477a2 >= 32 && m1477a2 < 58) {
            return new C1013n(i2 + 6, (char) (m1477a2 + 33));
        }
        switch (m1477a2) {
            case 58:
                c2 = '*';
                break;
            case 59:
                c2 = ',';
                break;
            case 60:
                c2 = '-';
                break;
            case 61:
                c2 = '.';
                break;
            case 62:
                c2 = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: " + m1477a2);
        }
        return new C1013n(i2 + 6, c2);
    }
}
