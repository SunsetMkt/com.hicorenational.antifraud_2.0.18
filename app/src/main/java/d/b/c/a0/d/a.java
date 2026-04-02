package d.b.c.a0.d;

import d.b.c.m;
import d.b.c.t;
import d.b.c.z.g;
import d.b.c.z.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: Detector.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    private final d.b.c.z.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.b.c.z.m.c f9466b;

    /* JADX INFO: compiled from: Detector.java */
    private static final class b {
        private final t a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final t f9467b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f9468c;

        t a() {
            return this.a;
        }

        t b() {
            return this.f9467b;
        }

        public int c() {
            return this.f9468c;
        }

        public String toString() {
            return this.a + "/" + this.f9467b + '/' + this.f9468c;
        }

        private b(t tVar, t tVar2, int i2) {
            this.a = tVar;
            this.f9467b = tVar2;
            this.f9468c = i2;
        }
    }

    /* JADX INFO: compiled from: Detector.java */
    private static final class c implements Comparator<b>, Serializable {
        private c() {
        }

        @Override // java.util.Comparator
        public int compare(b bVar, b bVar2) {
            return bVar.c() - bVar2.c();
        }
    }

    public a(d.b.c.z.b bVar) throws m {
        this.a = bVar;
        this.f9466b = new d.b.c.z.m.c(bVar);
    }

    private b b(t tVar, t tVar2) {
        int iA = (int) tVar.a();
        int iB = (int) tVar.b();
        int iA2 = (int) tVar2.a();
        int iB2 = (int) tVar2.b();
        int i2 = 0;
        boolean z = Math.abs(iB2 - iB) > Math.abs(iA2 - iA);
        if (z) {
            iB = iA;
            iA = iB;
            iB2 = iA2;
            iA2 = iB2;
        }
        int iAbs = Math.abs(iA2 - iA);
        int iAbs2 = Math.abs(iB2 - iB);
        int i3 = (-iAbs) / 2;
        int i4 = iB < iB2 ? 1 : -1;
        int i5 = iA >= iA2 ? -1 : 1;
        boolean zB = this.a.b(z ? iB : iA, z ? iA : iB);
        while (iA != iA2) {
            boolean zB2 = this.a.b(z ? iB : iA, z ? iA : iB);
            if (zB2 != zB) {
                i2++;
                zB = zB2;
            }
            i3 += iAbs2;
            if (i3 > 0) {
                if (iB == iB2) {
                    break;
                }
                iB += i4;
                i3 -= iAbs;
            }
            iA += i5;
        }
        return new b(tVar, tVar2, i2);
    }

    public g a() throws m {
        t tVar;
        t tVarA;
        d.b.c.z.b bVarA;
        t[] tVarArrA = this.f9466b.a();
        t tVar2 = tVarArrA[0];
        t tVar3 = tVarArrA[1];
        t tVar4 = tVarArrA[2];
        t tVar5 = tVarArrA[3];
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(b(tVar2, tVar3));
        arrayList.add(b(tVar2, tVar4));
        arrayList.add(b(tVar3, tVar5));
        arrayList.add(b(tVar4, tVar5));
        t tVar6 = null;
        Collections.sort(arrayList, new c());
        b bVar = (b) arrayList.get(0);
        b bVar2 = (b) arrayList.get(1);
        HashMap map = new HashMap();
        a(map, bVar.a());
        a(map, bVar.b());
        a(map, bVar2.a());
        a(map, bVar2.b());
        t tVar7 = null;
        t tVar8 = null;
        for (Map.Entry entry : map.entrySet()) {
            t tVar9 = (t) entry.getKey();
            if (((Integer) entry.getValue()).intValue() == 2) {
                tVar7 = tVar9;
            } else if (tVar6 == null) {
                tVar6 = tVar9;
            } else {
                tVar8 = tVar9;
            }
        }
        if (tVar6 == null || tVar7 == null || tVar8 == null) {
            throw m.getNotFoundInstance();
        }
        t[] tVarArr = {tVar6, tVar7, tVar8};
        t.a(tVarArr);
        t tVar10 = tVarArr[0];
        t tVar11 = tVarArr[1];
        t tVar12 = tVarArr[2];
        t tVar13 = !map.containsKey(tVar2) ? tVar2 : !map.containsKey(tVar3) ? tVar3 : !map.containsKey(tVar4) ? tVar4 : tVar5;
        int iC = b(tVar12, tVar13).c();
        int iC2 = b(tVar10, tVar13).c();
        if ((iC & 1) == 1) {
            iC++;
        }
        int i2 = iC + 2;
        if ((iC2 & 1) == 1) {
            iC2++;
        }
        int i3 = iC2 + 2;
        if (i2 * 4 >= i3 * 7 || i3 * 4 >= i2 * 7) {
            tVar = tVar12;
            tVarA = a(tVar11, tVar10, tVar12, tVar13, i2, i3);
            if (tVarA == null) {
                tVarA = tVar13;
            }
            int iC3 = b(tVar, tVarA).c();
            int iC4 = b(tVar10, tVarA).c();
            if ((iC3 & 1) == 1) {
                iC3++;
            }
            int i4 = iC3;
            if ((iC4 & 1) == 1) {
                iC4++;
            }
            bVarA = a(this.a, tVar, tVar11, tVar10, tVarA, i4, iC4);
        } else {
            tVarA = a(tVar11, tVar10, tVar12, tVar13, Math.min(i3, i2));
            if (tVarA == null) {
                tVarA = tVar13;
            }
            int iMax = Math.max(b(tVar12, tVarA).c(), b(tVar10, tVarA).c()) + 1;
            if ((iMax & 1) == 1) {
                iMax++;
            }
            int i5 = iMax;
            bVarA = a(this.a, tVar12, tVar11, tVar10, tVarA, i5, i5);
            tVar = tVar12;
        }
        return new g(bVarA, new t[]{tVar, tVar11, tVar10, tVarA});
    }

    private t a(t tVar, t tVar2, t tVar3, t tVar4, int i2, int i3) {
        float fA = a(tVar, tVar2) / i2;
        float fA2 = a(tVar3, tVar4);
        t tVar5 = new t(tVar4.a() + (((tVar4.a() - tVar3.a()) / fA2) * fA), tVar4.b() + (fA * ((tVar4.b() - tVar3.b()) / fA2)));
        float fA3 = a(tVar, tVar3) / i3;
        float fA4 = a(tVar2, tVar4);
        t tVar6 = new t(tVar4.a() + (((tVar4.a() - tVar2.a()) / fA4) * fA3), tVar4.b() + (fA3 * ((tVar4.b() - tVar2.b()) / fA4)));
        if (a(tVar5)) {
            return (a(tVar6) && Math.abs(i2 - b(tVar3, tVar5).c()) + Math.abs(i3 - b(tVar2, tVar5).c()) > Math.abs(i2 - b(tVar3, tVar6).c()) + Math.abs(i3 - b(tVar2, tVar6).c())) ? tVar6 : tVar5;
        }
        if (a(tVar6)) {
            return tVar6;
        }
        return null;
    }

    private t a(t tVar, t tVar2, t tVar3, t tVar4, int i2) {
        float f2 = i2;
        float fA = a(tVar, tVar2) / f2;
        float fA2 = a(tVar3, tVar4);
        t tVar5 = new t(tVar4.a() + (((tVar4.a() - tVar3.a()) / fA2) * fA), tVar4.b() + (fA * ((tVar4.b() - tVar3.b()) / fA2)));
        float fA3 = a(tVar, tVar3) / f2;
        float fA4 = a(tVar2, tVar4);
        t tVar6 = new t(tVar4.a() + (((tVar4.a() - tVar2.a()) / fA4) * fA3), tVar4.b() + (fA3 * ((tVar4.b() - tVar2.b()) / fA4)));
        if (a(tVar5)) {
            return (a(tVar6) && Math.abs(b(tVar3, tVar5).c() - b(tVar2, tVar5).c()) > Math.abs(b(tVar3, tVar6).c() - b(tVar2, tVar6).c())) ? tVar6 : tVar5;
        }
        if (a(tVar6)) {
            return tVar6;
        }
        return null;
    }

    private boolean a(t tVar) {
        return tVar.a() >= 0.0f && tVar.a() < ((float) this.a.g()) && tVar.b() > 0.0f && tVar.b() < ((float) this.a.d());
    }

    private static int a(t tVar, t tVar2) {
        return d.b.c.z.m.a.a(t.a(tVar, tVar2));
    }

    private static void a(Map<t, Integer> map, t tVar) {
        Integer num = map.get(tVar);
        map.put(tVar, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    private static d.b.c.z.b a(d.b.c.z.b bVar, t tVar, t tVar2, t tVar3, t tVar4, int i2, int i3) throws m {
        float f2 = i2 - 0.5f;
        float f3 = i3 - 0.5f;
        return i.a().a(bVar, i2, i3, 0.5f, 0.5f, f2, 0.5f, f2, f3, 0.5f, f3, tVar.a(), tVar.b(), tVar4.a(), tVar4.b(), tVar3.a(), tVar3.b(), tVar2.a(), tVar2.b());
    }
}
