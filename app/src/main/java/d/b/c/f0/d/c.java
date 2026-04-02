package d.b.c.f0.d;

import d.b.c.f0.c.j;
import d.b.c.h;
import d.b.c.m;
import d.b.c.t;
import d.b.c.u;
import d.b.c.z.g;
import d.b.c.z.i;
import d.b.c.z.k;
import java.util.Map;

/* JADX INFO: compiled from: Detector.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private final d.b.c.z.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private u f9806b;

    public c(d.b.c.z.b bVar) {
        this.a = bVar;
    }

    public g a() throws m, h {
        return a((Map<d.b.c.e, ?>) null);
    }

    protected final d.b.c.z.b b() {
        return this.a;
    }

    protected final u c() {
        return this.f9806b;
    }

    private float b(int i2, int i3, int i4, int i5) {
        int iG;
        float fG;
        float fD;
        float fA = a(i2, i3, i4, i5);
        int i6 = i2 - (i4 - i2);
        int iD = 0;
        if (i6 < 0) {
            fG = i2 / (i2 - i6);
            iG = 0;
        } else if (i6 >= this.a.g()) {
            fG = ((this.a.g() - 1) - i2) / (i6 - i2);
            iG = this.a.g() - 1;
        } else {
            iG = i6;
            fG = 1.0f;
        }
        float f2 = i3;
        int i7 = (int) (f2 - ((i5 - i3) * fG));
        if (i7 < 0) {
            fD = f2 / (i3 - i7);
        } else if (i7 >= this.a.d()) {
            fD = ((this.a.d() - 1) - i3) / (i7 - i3);
            iD = this.a.d() - 1;
        } else {
            iD = i7;
            fD = 1.0f;
        }
        return (fA + a(i2, i3, (int) (i2 + ((iG - i2) * fD)), iD)) - 1.0f;
    }

    public final g a(Map<d.b.c.e, ?> map) throws m, h {
        this.f9806b = map == null ? null : (u) map.get(d.b.c.e.NEED_RESULT_POINT_CALLBACK);
        return a(new e(this.a, this.f9806b).a(map));
    }

    protected final g a(f fVar) throws m, h {
        d dVarB = fVar.b();
        d dVarC = fVar.c();
        d dVarA = fVar.a();
        float fA = a(dVarB, dVarC, dVarA);
        if (fA >= 1.0f) {
            int iA = a(dVarB, dVarC, dVarA, fA);
            j jVarB = j.b(iA);
            int iC = jVarB.c() - 7;
            a aVarA = null;
            if (jVarB.b().length > 0) {
                float fA2 = (dVarC.a() - dVarB.a()) + dVarA.a();
                float fB = (dVarC.b() - dVarB.b()) + dVarA.b();
                float f2 = 1.0f - (3.0f / iC);
                int iA2 = (int) (dVarB.a() + ((fA2 - dVarB.a()) * f2));
                int iB = (int) (dVarB.b() + (f2 * (fB - dVarB.b())));
                for (int i2 = 4; i2 <= 16; i2 <<= 1) {
                    try {
                        aVarA = a(fA, iA2, iB, i2);
                        break;
                    } catch (m unused) {
                    }
                }
            }
            return new g(a(this.a, a(dVarB, dVarC, dVarA, aVarA, iA), iA), aVarA == null ? new t[]{dVarA, dVarB, dVarC} : new t[]{dVarA, dVarB, dVarC, aVarA});
        }
        throw m.getNotFoundInstance();
    }

    private static k a(t tVar, t tVar2, t tVar3, t tVar4, int i2) {
        float fA;
        float fB;
        float f2;
        float f3 = i2 - 3.5f;
        if (tVar4 != null) {
            fA = tVar4.a();
            fB = tVar4.b();
            f2 = f3 - 3.0f;
        } else {
            fA = (tVar2.a() - tVar.a()) + tVar3.a();
            fB = (tVar2.b() - tVar.b()) + tVar3.b();
            f2 = f3;
        }
        return k.a(3.5f, 3.5f, f3, 3.5f, f2, f2, 3.5f, f3, tVar.a(), tVar.b(), tVar2.a(), tVar2.b(), fA, fB, tVar3.a(), tVar3.b());
    }

    private static d.b.c.z.b a(d.b.c.z.b bVar, k kVar, int i2) throws m {
        return i.a().a(bVar, i2, i2, kVar);
    }

    private static int a(t tVar, t tVar2, t tVar3, float f2) throws m {
        int iA = ((d.b.c.z.m.a.a(t.a(tVar, tVar2) / f2) + d.b.c.z.m.a.a(t.a(tVar, tVar3) / f2)) / 2) + 7;
        int i2 = iA & 3;
        if (i2 == 0) {
            return iA + 1;
        }
        if (i2 == 2) {
            return iA - 1;
        }
        if (i2 != 3) {
            return iA;
        }
        throw m.getNotFoundInstance();
    }

    protected final float a(t tVar, t tVar2, t tVar3) {
        return (a(tVar, tVar2) + a(tVar, tVar3)) / 2.0f;
    }

    private float a(t tVar, t tVar2) {
        float fB = b((int) tVar.a(), (int) tVar.b(), (int) tVar2.a(), (int) tVar2.b());
        float fB2 = b((int) tVar2.a(), (int) tVar2.b(), (int) tVar.a(), (int) tVar.b());
        return Float.isNaN(fB) ? fB2 / 7.0f : Float.isNaN(fB2) ? fB / 7.0f : (fB + fB2) / 14.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0086, code lost:
    
        if (r14 != 2) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008e, code lost:
    
        return d.b.c.z.m.a.a(r19, r5, r4, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008f, code lost:
    
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float a(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        c cVar;
        boolean z;
        boolean z2;
        int i11 = 1;
        boolean z3 = Math.abs(i5 - i3) > Math.abs(i4 - i2);
        if (z3) {
            i7 = i2;
            i6 = i3;
            i9 = i4;
            i8 = i5;
        } else {
            i6 = i2;
            i7 = i3;
            i8 = i4;
            i9 = i5;
        }
        int iAbs = Math.abs(i8 - i6);
        int iAbs2 = Math.abs(i9 - i7);
        int i12 = (-iAbs) / 2;
        int i13 = i6 < i8 ? 1 : -1;
        int i14 = i7 < i9 ? 1 : -1;
        int i15 = i8 + i13;
        int i16 = i7;
        int i17 = i12;
        int i18 = 0;
        int i19 = i6;
        while (true) {
            if (i19 == i15) {
                i10 = i15;
                break;
            }
            int i20 = z3 ? i16 : i19;
            int i21 = z3 ? i19 : i16;
            if (i18 == i11) {
                cVar = this;
                z = z3;
                i10 = i15;
                z2 = true;
            } else {
                cVar = this;
                z = z3;
                i10 = i15;
                z2 = false;
            }
            if (z2 == cVar.a.b(i20, i21)) {
                if (i18 == 2) {
                    return d.b.c.z.m.a.a(i19, i16, i6, i7);
                }
                i18++;
            }
            i17 += iAbs2;
            if (i17 > 0) {
                if (i16 == i9) {
                    break;
                }
                i16 += i14;
                i17 -= iAbs;
            }
            i19 += i13;
            i15 = i10;
            z3 = z;
            i11 = 1;
        }
    }

    protected final a a(float f2, int i2, int i3, float f3) throws m {
        int i4 = (int) (f3 * f2);
        int iMax = Math.max(0, i2 - i4);
        int iMin = Math.min(this.a.g() - 1, i2 + i4) - iMax;
        float f4 = 3.0f * f2;
        if (iMin >= f4) {
            int iMax2 = Math.max(0, i3 - i4);
            int iMin2 = Math.min(this.a.d() - 1, i3 + i4) - iMax2;
            if (iMin2 >= f4) {
                return new b(this.a, iMax, iMax2, iMin, iMin2, f2, this.f9806b).a();
            }
            throw m.getNotFoundInstance();
        }
        throw m.getNotFoundInstance();
    }
}
