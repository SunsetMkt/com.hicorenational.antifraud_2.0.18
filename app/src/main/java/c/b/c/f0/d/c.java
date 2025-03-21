package c.b.c.f0.d;

import c.b.c.f0.c.j;
import c.b.c.h;
import c.b.c.m;
import c.b.c.t;
import c.b.c.u;
import c.b.c.z.g;
import c.b.c.z.i;
import c.b.c.z.k;
import java.util.Map;

/* compiled from: Detector.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final c.b.c.z.b f2783a;

    /* renamed from: b, reason: collision with root package name */
    private u f2784b;

    public c(c.b.c.z.b bVar) {
        this.f2783a = bVar;
    }

    public g a() throws m, h {
        return a((Map<c.b.c.e, ?>) null);
    }

    protected final c.b.c.z.b b() {
        return this.f2783a;
    }

    protected final u c() {
        return this.f2784b;
    }

    private float b(int i2, int i3, int i4, int i5) {
        int i6;
        float f2;
        float f3;
        float a2 = a(i2, i3, i4, i5);
        int i7 = i2 - (i4 - i2);
        int i8 = 0;
        if (i7 < 0) {
            f2 = i2 / (i2 - i7);
            i6 = 0;
        } else if (i7 >= this.f2783a.g()) {
            f2 = ((this.f2783a.g() - 1) - i2) / (i7 - i2);
            i6 = this.f2783a.g() - 1;
        } else {
            i6 = i7;
            f2 = 1.0f;
        }
        float f4 = i3;
        int i9 = (int) (f4 - ((i5 - i3) * f2));
        if (i9 < 0) {
            f3 = f4 / (i3 - i9);
        } else if (i9 >= this.f2783a.d()) {
            f3 = ((this.f2783a.d() - 1) - i3) / (i9 - i3);
            i8 = this.f2783a.d() - 1;
        } else {
            i8 = i9;
            f3 = 1.0f;
        }
        return (a2 + a(i2, i3, (int) (i2 + ((i6 - i2) * f3)), i8)) - 1.0f;
    }

    public final g a(Map<c.b.c.e, ?> map) throws m, h {
        this.f2784b = map == null ? null : (u) map.get(c.b.c.e.NEED_RESULT_POINT_CALLBACK);
        return a(new e(this.f2783a, this.f2784b).a(map));
    }

    protected final g a(f fVar) throws m, h {
        d b2 = fVar.b();
        d c2 = fVar.c();
        d a2 = fVar.a();
        float a3 = a(b2, c2, a2);
        if (a3 >= 1.0f) {
            int a4 = a(b2, c2, a2, a3);
            j b3 = j.b(a4);
            int c3 = b3.c() - 7;
            a aVar = null;
            if (b3.b().length > 0) {
                float a5 = (c2.a() - b2.a()) + a2.a();
                float b4 = (c2.b() - b2.b()) + a2.b();
                float f2 = 1.0f - (3.0f / c3);
                int a6 = (int) (b2.a() + ((a5 - b2.a()) * f2));
                int b5 = (int) (b2.b() + (f2 * (b4 - b2.b())));
                for (int i2 = 4; i2 <= 16; i2 <<= 1) {
                    try {
                        aVar = a(a3, a6, b5, i2);
                        break;
                    } catch (m unused) {
                    }
                }
            }
            return new g(a(this.f2783a, a(b2, c2, a2, aVar, a4), a4), aVar == null ? new t[]{a2, b2, c2} : new t[]{a2, b2, c2, aVar});
        }
        throw m.getNotFoundInstance();
    }

    private static k a(t tVar, t tVar2, t tVar3, t tVar4, int i2) {
        float a2;
        float b2;
        float f2;
        float f3 = i2 - 3.5f;
        if (tVar4 != null) {
            a2 = tVar4.a();
            b2 = tVar4.b();
            f2 = f3 - 3.0f;
        } else {
            a2 = (tVar2.a() - tVar.a()) + tVar3.a();
            b2 = (tVar2.b() - tVar.b()) + tVar3.b();
            f2 = f3;
        }
        return k.a(3.5f, 3.5f, f3, 3.5f, f2, f2, 3.5f, f3, tVar.a(), tVar.b(), tVar2.a(), tVar2.b(), a2, b2, tVar3.a(), tVar3.b());
    }

    private static c.b.c.z.b a(c.b.c.z.b bVar, k kVar, int i2) throws m {
        return i.a().a(bVar, i2, i2, kVar);
    }

    private static int a(t tVar, t tVar2, t tVar3, float f2) throws m {
        int a2 = ((c.b.c.z.m.a.a(t.a(tVar, tVar2) / f2) + c.b.c.z.m.a.a(t.a(tVar, tVar3) / f2)) / 2) + 7;
        int i2 = a2 & 3;
        if (i2 == 0) {
            return a2 + 1;
        }
        if (i2 == 2) {
            return a2 - 1;
        }
        if (i2 != 3) {
            return a2;
        }
        throw m.getNotFoundInstance();
    }

    protected final float a(t tVar, t tVar2, t tVar3) {
        return (a(tVar, tVar2) + a(tVar, tVar3)) / 2.0f;
    }

    private float a(t tVar, t tVar2) {
        float b2 = b((int) tVar.a(), (int) tVar.b(), (int) tVar2.a(), (int) tVar2.b());
        float b3 = b((int) tVar2.a(), (int) tVar2.b(), (int) tVar.a(), (int) tVar.b());
        return Float.isNaN(b2) ? b3 / 7.0f : Float.isNaN(b3) ? b2 / 7.0f : (b2 + b3) / 14.0f;
    }

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
        int abs = Math.abs(i8 - i6);
        int abs2 = Math.abs(i9 - i7);
        int i12 = (-abs) / 2;
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
            if (z2 == cVar.f2783a.b(i20, i21)) {
                if (i18 == 2) {
                    return c.b.c.z.m.a.a(i19, i16, i6, i7);
                }
                i18++;
            }
            i17 += abs2;
            if (i17 > 0) {
                if (i16 == i9) {
                    break;
                }
                i16 += i14;
                i17 -= abs;
            }
            i19 += i13;
            i15 = i10;
            z3 = z;
            i11 = 1;
        }
        if (i18 == 2) {
            return c.b.c.z.m.a.a(i10, i9, i6, i7);
        }
        return Float.NaN;
    }

    protected final a a(float f2, int i2, int i3, float f3) throws m {
        int i4 = (int) (f3 * f2);
        int max = Math.max(0, i2 - i4);
        int min = Math.min(this.f2783a.g() - 1, i2 + i4) - max;
        float f4 = 3.0f * f2;
        if (min >= f4) {
            int max2 = Math.max(0, i3 - i4);
            int min2 = Math.min(this.f2783a.d() - 1, i3 + i4) - max2;
            if (min2 >= f4) {
                return new b(this.f2783a, max, max2, min, min2, f2, this.f2784b).a();
            }
            throw m.getNotFoundInstance();
        }
        throw m.getNotFoundInstance();
    }
}
