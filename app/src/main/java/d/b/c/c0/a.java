package d.b.c.c0;

import d.b.c.d;
import d.b.c.e;
import d.b.c.h;
import d.b.c.m;
import d.b.c.p;
import d.b.c.r;
import d.b.c.t;
import java.util.Map;

/* JADX INFO: compiled from: ByQuadrantReader.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements p {
    private final p a;

    public a(p pVar) {
        this.a = pVar;
    }

    @Override // d.b.c.p
    public r a(d.b.c.c cVar) throws m, d, h {
        return a(cVar, null);
    }

    @Override // d.b.c.p
    public void reset() {
        this.a.reset();
    }

    @Override // d.b.c.p
    public r a(d.b.c.c cVar, Map<e, ?> map) throws m, d, h {
        int iC = cVar.c() / 2;
        int iB = cVar.b() / 2;
        try {
            try {
                try {
                    try {
                        return this.a.a(cVar.a(0, 0, iC, iB), map);
                    } catch (m unused) {
                        r rVarA = this.a.a(cVar.a(iC, 0, iC, iB), map);
                        a(rVarA.d(), iC, 0);
                        return rVarA;
                    }
                } catch (m unused2) {
                    r rVarA2 = this.a.a(cVar.a(iC, iB, iC, iB), map);
                    a(rVarA2.d(), iC, iB);
                    return rVarA2;
                }
            } catch (m unused3) {
                r rVarA3 = this.a.a(cVar.a(0, iB, iC, iB), map);
                a(rVarA3.d(), 0, iB);
                return rVarA3;
            }
        } catch (m unused4) {
            int i2 = iC / 2;
            int i3 = iB / 2;
            r rVarA4 = this.a.a(cVar.a(i2, i3, iC, iB), map);
            a(rVarA4.d(), i2, i3);
            return rVarA4;
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
