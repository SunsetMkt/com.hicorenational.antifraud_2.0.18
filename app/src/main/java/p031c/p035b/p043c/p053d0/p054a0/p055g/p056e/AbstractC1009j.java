package p031c.p035b.p043c.p053d0.p054a0.p055g.p056e;

import com.tencent.connect.common.Constants;
import p031c.p035b.p043c.C1097h;
import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.p072z.C1162a;

/* compiled from: AbstractExpandedDecoder.java */
/* renamed from: c.b.c.d0.a0.g.e.j */
/* loaded from: classes.dex */
public abstract class AbstractC1009j {

    /* renamed from: a */
    private final C1162a f1848a;

    /* renamed from: b */
    private final C1018s f1849b;

    AbstractC1009j(C1162a c1162a) {
        this.f1848a = c1162a;
        this.f1849b = new C1018s(c1162a);
    }

    /* renamed from: a */
    protected final C1018s m1435a() {
        return this.f1849b;
    }

    /* renamed from: b */
    protected final C1162a m1436b() {
        return this.f1848a;
    }

    /* renamed from: c */
    public abstract String mo1428c() throws C1102m, C1097h;

    /* renamed from: a */
    public static AbstractC1009j m1434a(C1162a c1162a) {
        if (c1162a.m2155b(1)) {
            return new C1006g(c1162a);
        }
        if (!c1162a.m2155b(2)) {
            return new C1010k(c1162a);
        }
        int m1463a = C1018s.m1463a(c1162a, 1, 4);
        if (m1463a == 4) {
            return new C1000a(c1162a);
        }
        if (m1463a == 5) {
            return new C1001b(c1162a);
        }
        int m1463a2 = C1018s.m1463a(c1162a, 1, 5);
        if (m1463a2 == 12) {
            return new C1002c(c1162a);
        }
        if (m1463a2 == 13) {
            return new C1003d(c1162a);
        }
        switch (C1018s.m1463a(c1162a, 1, 7)) {
            case 56:
                return new C1004e(c1162a, "310", "11");
            case 57:
                return new C1004e(c1162a, "320", "11");
            case 58:
                return new C1004e(c1162a, "310", "13");
            case 59:
                return new C1004e(c1162a, "320", "13");
            case 60:
                return new C1004e(c1162a, "310", "15");
            case 61:
                return new C1004e(c1162a, "320", "15");
            case 62:
                return new C1004e(c1162a, "310", Constants.VIA_REPORT_TYPE_START_GROUP);
            case 63:
                return new C1004e(c1162a, "320", Constants.VIA_REPORT_TYPE_START_GROUP);
            default:
                throw new IllegalStateException("unknown decoder: " + c1162a);
        }
    }
}
