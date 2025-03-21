package c.b.c.e0.e;

import c.b.c.t;

/* compiled from: DetectionResultRowIndicatorColumn.java */
/* loaded from: classes.dex */
final class h extends g {

    /* renamed from: d, reason: collision with root package name */
    private final boolean f2673d;

    h(c cVar, boolean z) {
        super(cVar);
        this.f2673d = z;
    }

    int a(a aVar) {
        d[] b2 = b();
        f();
        a(b2, aVar);
        c a2 = a();
        t g2 = this.f2673d ? a2.g() : a2.h();
        t a3 = this.f2673d ? a2.a() : a2.b();
        int c2 = c((int) g2.b());
        int c3 = c((int) a3.b());
        float c4 = (c3 - c2) / aVar.c();
        int i2 = -1;
        int i3 = 0;
        int i4 = 1;
        while (c2 < c3) {
            if (b2[c2] != null) {
                d dVar = b2[c2];
                int c5 = dVar.c() - i2;
                if (c5 == 0) {
                    i3++;
                } else {
                    if (c5 == 1) {
                        i4 = Math.max(i4, i3);
                        i2 = dVar.c();
                    } else if (c5 < 0 || dVar.c() >= aVar.c() || c5 > c2) {
                        b2[c2] = null;
                    } else {
                        if (i4 > 2) {
                            c5 *= i4 - 2;
                        }
                        boolean z = c5 >= c2;
                        for (int i5 = 1; i5 <= c5 && !z; i5++) {
                            z = b2[c2 - i5] != null;
                        }
                        if (z) {
                            b2[c2] = null;
                        } else {
                            i2 = dVar.c();
                        }
                    }
                    i3 = 1;
                }
            }
            c2++;
        }
        return (int) (c4 + 0.5d);
    }

    int b(a aVar) {
        c a2 = a();
        t g2 = this.f2673d ? a2.g() : a2.h();
        t a3 = this.f2673d ? a2.a() : a2.b();
        int c2 = c((int) g2.b());
        int c3 = c((int) a3.b());
        float c4 = (c3 - c2) / aVar.c();
        d[] b2 = b();
        int i2 = -1;
        int i3 = 0;
        int i4 = 1;
        while (c2 < c3) {
            if (b2[c2] != null) {
                d dVar = b2[c2];
                dVar.h();
                int c5 = dVar.c() - i2;
                if (c5 == 0) {
                    i3++;
                } else {
                    if (c5 == 1) {
                        i4 = Math.max(i4, i3);
                        i2 = dVar.c();
                    } else if (dVar.c() >= aVar.c()) {
                        b2[c2] = null;
                    } else {
                        i2 = dVar.c();
                    }
                    i3 = 1;
                }
            }
            c2++;
        }
        return (int) (c4 + 0.5d);
    }

    a c() {
        d[] b2 = b();
        b bVar = new b();
        b bVar2 = new b();
        b bVar3 = new b();
        b bVar4 = new b();
        for (d dVar : b2) {
            if (dVar != null) {
                dVar.h();
                int e2 = dVar.e() % 30;
                int c2 = dVar.c();
                if (!this.f2673d) {
                    c2 += 2;
                }
                int i2 = c2 % 3;
                if (i2 == 0) {
                    bVar2.b((e2 * 3) + 1);
                } else if (i2 == 1) {
                    bVar4.b(e2 / 3);
                    bVar3.b(e2 % 3);
                } else if (i2 == 2) {
                    bVar.b(e2 + 1);
                }
            }
        }
        if (bVar.a().length == 0 || bVar2.a().length == 0 || bVar3.a().length == 0 || bVar4.a().length == 0 || bVar.a()[0] < 1 || bVar2.a()[0] + bVar3.a()[0] < 3 || bVar2.a()[0] + bVar3.a()[0] > 90) {
            return null;
        }
        a aVar = new a(bVar.a()[0], bVar2.a()[0], bVar3.a()[0], bVar4.a()[0]);
        a(b2, aVar);
        return aVar;
    }

    int[] d() throws c.b.c.h {
        a c2 = c();
        if (c2 == null) {
            return null;
        }
        b(c2);
        int[] iArr = new int[c2.c()];
        for (d dVar : b()) {
            if (dVar != null) {
                int c3 = dVar.c();
                if (c3 >= iArr.length) {
                    throw c.b.c.h.getFormatInstance();
                }
                iArr[c3] = iArr[c3] + 1;
            }
        }
        return iArr;
    }

    boolean e() {
        return this.f2673d;
    }

    void f() {
        for (d dVar : b()) {
            if (dVar != null) {
                dVar.h();
            }
        }
    }

    @Override // c.b.c.e0.e.g
    public String toString() {
        return "IsLeft: " + this.f2673d + '\n' + super.toString();
    }

    private void a(d[] dVarArr, a aVar) {
        for (int i2 = 0; i2 < dVarArr.length; i2++) {
            d dVar = dVarArr[i2];
            if (dVarArr[i2] != null) {
                int e2 = dVar.e() % 30;
                int c2 = dVar.c();
                if (c2 > aVar.c()) {
                    dVarArr[i2] = null;
                } else {
                    if (!this.f2673d) {
                        c2 += 2;
                    }
                    int i3 = c2 % 3;
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 == 2 && e2 + 1 != aVar.a()) {
                                dVarArr[i2] = null;
                            }
                        } else if (e2 / 3 != aVar.b() || e2 % 3 != aVar.d()) {
                            dVarArr[i2] = null;
                        }
                    } else if ((e2 * 3) + 1 != aVar.e()) {
                        dVarArr[i2] = null;
                    }
                }
            }
        }
    }
}
