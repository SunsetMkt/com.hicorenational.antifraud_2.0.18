package p031c.p035b.p043c;

import p031c.p035b.p043c.p072z.C1162a;
import p031c.p035b.p043c.p072z.C1163b;

/* compiled from: BinaryBitmap.java */
/* renamed from: c.b.c.c */
/* loaded from: classes.dex */
public final class C0981c {

    /* renamed from: a */
    private final AbstractC0976b f1759a;

    /* renamed from: b */
    private C1163b f1760b;

    public C0981c(AbstractC0976b abstractC0976b) {
        if (abstractC0976b == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.f1759a = abstractC0976b;
    }

    /* renamed from: a */
    public C1162a m1343a(int i2, C1162a c1162a) throws C1102m {
        return this.f1759a.mo1323a(i2, c1162a);
    }

    /* renamed from: b */
    public int m1345b() {
        return this.f1759a.m1325b();
    }

    /* renamed from: c */
    public int m1346c() {
        return this.f1759a.m1327d();
    }

    /* renamed from: d */
    public boolean m1347d() {
        return this.f1759a.m1326c().mo1897e();
    }

    /* renamed from: e */
    public boolean m1348e() {
        return this.f1759a.m1326c().mo1898f();
    }

    /* renamed from: f */
    public C0981c m1349f() {
        return new C0981c(this.f1759a.mo1322a(this.f1759a.m1326c().mo1899g()));
    }

    /* renamed from: g */
    public C0981c m1350g() {
        return new C0981c(this.f1759a.mo1322a(this.f1759a.m1326c().mo1900h()));
    }

    public String toString() {
        try {
            return m1344a().toString();
        } catch (C1102m unused) {
            return "";
        }
    }

    /* renamed from: a */
    public C1163b m1344a() throws C1102m {
        if (this.f1760b == null) {
            this.f1760b = this.f1759a.mo1324a();
        }
        return this.f1760b;
    }

    /* renamed from: a */
    public C0981c m1342a(int i2, int i3, int i4, int i5) {
        return new C0981c(this.f1759a.mo1322a(this.f1759a.m1326c().mo1893a(i2, i3, i4, i5)));
    }
}
