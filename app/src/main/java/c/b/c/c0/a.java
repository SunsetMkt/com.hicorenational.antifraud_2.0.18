package c.b.c.c0;

import c.b.c.d;
import c.b.c.e;
import c.b.c.h;
import c.b.c.m;
import c.b.c.p;
import c.b.c.r;
import c.b.c.t;
import java.util.Map;

/* compiled from: ByQuadrantReader.java */
/* loaded from: classes.dex */
public final class a implements p {

    /* renamed from: a, reason: collision with root package name */
    private final p f2434a;

    public a(p pVar) {
        this.f2434a = pVar;
    }

    @Override // c.b.c.p
    public r a(c.b.c.c cVar) throws m, d, h {
        return a(cVar, null);
    }

    @Override // c.b.c.p
    public void reset() {
        this.f2434a.reset();
    }

    @Override // c.b.c.p
    public r a(c.b.c.c cVar, Map<e, ?> map) throws m, d, h {
        int c2 = cVar.c() / 2;
        int b2 = cVar.b() / 2;
        try {
            try {
                try {
                    try {
                        return this.f2434a.a(cVar.a(0, 0, c2, b2), map);
                    } catch (m unused) {
                        r a2 = this.f2434a.a(cVar.a(c2, 0, c2, b2), map);
                        a(a2.d(), c2, 0);
                        return a2;
                    }
                } catch (m unused2) {
                    int i2 = c2 / 2;
                    int i3 = b2 / 2;
                    r a3 = this.f2434a.a(cVar.a(i2, i3, c2, b2), map);
                    a(a3.d(), i2, i3);
                    return a3;
                }
            } catch (m unused3) {
                r a4 = this.f2434a.a(cVar.a(0, b2, c2, b2), map);
                a(a4.d(), 0, b2);
                return a4;
            }
        } catch (m unused4) {
            r a5 = this.f2434a.a(cVar.a(c2, b2, c2, b2), map);
            a(a5.d(), c2, b2);
            return a5;
        }
    }

    private static void a(t[] tVarArr, int i2, int i3) {
        if (tVarArr != null) {
            for (int i4 = 0; i4 < tVarArr.length; i4++) {
                t tVar = tVarArr[i4];
                tVarArr[i4] = new t(tVar.a() + i2, tVar.b() + i3);
            }
        }
    }
}
