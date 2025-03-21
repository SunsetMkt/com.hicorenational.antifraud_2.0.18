package c.b.c.a0.d;

import c.b.c.m;
import c.b.c.t;
import c.b.c.z.g;
import c.b.c.z.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Detector.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final c.b.c.z.b f2361a;

    /* renamed from: b, reason: collision with root package name */
    private final c.b.c.z.m.c f2362b;

    /* compiled from: Detector.java */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final t f2363a;

        /* renamed from: b, reason: collision with root package name */
        private final t f2364b;

        /* renamed from: c, reason: collision with root package name */
        private final int f2365c;

        t a() {
            return this.f2363a;
        }

        t b() {
            return this.f2364b;
        }

        public int c() {
            return this.f2365c;
        }

        public String toString() {
            return this.f2363a + "/" + this.f2364b + '/' + this.f2365c;
        }

        private b(t tVar, t tVar2, int i2) {
            this.f2363a = tVar;
            this.f2364b = tVar2;
            this.f2365c = i2;
        }
    }

    /* compiled from: Detector.java */
    private static final class c implements Comparator<b>, Serializable {
        private c() {
        }

        @Override // java.util.Comparator
        public int compare(b bVar, b bVar2) {
            return bVar.c() - bVar2.c();
        }
    }

    public a(c.b.c.z.b bVar) throws m {
        this.f2361a = bVar;
        this.f2362b = new c.b.c.z.m.c(bVar);
    }

    private b b(t tVar, t tVar2) {
        int a2 = (int) tVar.a();
        int b2 = (int) tVar.b();
        int a3 = (int) tVar2.a();
        int b3 = (int) tVar2.b();
        int i2 = 0;
        boolean z = Math.abs(b3 - b2) > Math.abs(a3 - a2);
        if (z) {
            b2 = a2;
            a2 = b2;
            b3 = a3;
            a3 = b3;
        }
        int abs = Math.abs(a3 - a2);
        int abs2 = Math.abs(b3 - b2);
        int i3 = (-abs) / 2;
        int i4 = b2 < b3 ? 1 : -1;
        int i5 = a2 >= a3 ? -1 : 1;
        boolean b4 = this.f2361a.b(z ? b2 : a2, z ? a2 : b2);
        while (a2 != a3) {
            boolean b5 = this.f2361a.b(z ? b2 : a2, z ? a2 : b2);
            if (b5 != b4) {
                i2++;
                b4 = b5;
            }
            i3 += abs2;
            if (i3 > 0) {
                if (b2 == b3) {
                    break;
                }
                b2 += i4;
                i3 -= abs;
            }
            a2 += i5;
        }
        return new b(tVar, tVar2, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v3, types: [c.b.c.t] */
    /* JADX WARN: Type inference failed for: r16v3, types: [c.b.c.t] */
    /* JADX WARN: Type inference failed for: r22v0, types: [c.b.c.t] */
    /* JADX WARN: Type inference failed for: r23v0, types: [c.b.c.a0.d.a] */
    /* JADX WARN: Type inference failed for: r3v3, types: [c.b.c.t[]] */
    /* JADX WARN: Type inference failed for: r4v6, types: [c.b.c.t[]] */
    /* JADX WARN: Type inference failed for: r6v2, types: [c.b.c.t] */
    public g a() throws m {
        t tVar;
        t a2;
        c.b.c.z.b a3;
        t[] a4 = this.f2362b.a();
        t tVar2 = a4[0];
        t tVar3 = a4[1];
        t tVar4 = a4[2];
        t tVar5 = a4[3];
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(b(tVar2, tVar3));
        arrayList.add(b(tVar2, tVar4));
        arrayList.add(b(tVar3, tVar5));
        arrayList.add(b(tVar4, tVar5));
        C0033a c0033a = null;
        Collections.sort(arrayList, new c());
        b bVar = (b) arrayList.get(0);
        b bVar2 = (b) arrayList.get(1);
        HashMap hashMap = new HashMap();
        a(hashMap, bVar.a());
        a(hashMap, bVar.b());
        a(hashMap, bVar2.a());
        a(hashMap, bVar2.b());
        Object obj = null;
        Object obj2 = null;
        for (Map.Entry entry : hashMap.entrySet()) {
            ?? r16 = (t) entry.getKey();
            if (((Integer) entry.getValue()).intValue() == 2) {
                obj = r16;
            } else if (c0033a == null) {
                c0033a = r16;
            } else {
                obj2 = r16;
            }
        }
        if (c0033a == null || obj == null || obj2 == null) {
            throw m.getNotFoundInstance();
        }
        ?? r4 = {c0033a, obj, obj2};
        t.a(r4);
        ?? r14 = r4[0];
        ?? r22 = r4[1];
        ?? r6 = r4[2];
        t tVar6 = !hashMap.containsKey(tVar2) ? tVar2 : !hashMap.containsKey(tVar3) ? tVar3 : !hashMap.containsKey(tVar4) ? tVar4 : tVar5;
        int c2 = b(r6, tVar6).c();
        int c3 = b(r14, tVar6).c();
        if ((c2 & 1) == 1) {
            c2++;
        }
        int i2 = c2 + 2;
        if ((c3 & 1) == 1) {
            c3++;
        }
        int i3 = c3 + 2;
        if (i2 * 4 >= i3 * 7 || i3 * 4 >= i2 * 7) {
            tVar = r6;
            a2 = a(r22, r14, r6, tVar6, i2, i3);
            if (a2 == null) {
                a2 = tVar6;
            }
            int c4 = b(tVar, a2).c();
            int c5 = b(r14, a2).c();
            if ((c4 & 1) == 1) {
                c4++;
            }
            int i4 = c4;
            if ((c5 & 1) == 1) {
                c5++;
            }
            a3 = a(this.f2361a, tVar, r22, r14, a2, i4, c5);
        } else {
            a2 = a(r22, r14, r6, tVar6, Math.min(i3, i2));
            if (a2 == null) {
                a2 = tVar6;
            }
            int max = Math.max(b(r6, a2).c(), b(r14, a2).c()) + 1;
            if ((max & 1) == 1) {
                max++;
            }
            int i5 = max;
            a3 = a(this.f2361a, r6, r22, r14, a2, i5, i5);
            tVar = r6;
        }
        return new g(a3, new t[]{tVar, r22, r14, a2});
    }

    private t a(t tVar, t tVar2, t tVar3, t tVar4, int i2, int i3) {
        float a2 = a(tVar, tVar2) / i2;
        float a3 = a(tVar3, tVar4);
        t tVar5 = new t(tVar4.a() + (((tVar4.a() - tVar3.a()) / a3) * a2), tVar4.b() + (a2 * ((tVar4.b() - tVar3.b()) / a3)));
        float a4 = a(tVar, tVar3) / i3;
        float a5 = a(tVar2, tVar4);
        t tVar6 = new t(tVar4.a() + (((tVar4.a() - tVar2.a()) / a5) * a4), tVar4.b() + (a4 * ((tVar4.b() - tVar2.b()) / a5)));
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
        float a2 = a(tVar, tVar2) / f2;
        float a3 = a(tVar3, tVar4);
        t tVar5 = new t(tVar4.a() + (((tVar4.a() - tVar3.a()) / a3) * a2), tVar4.b() + (a2 * ((tVar4.b() - tVar3.b()) / a3)));
        float a4 = a(tVar, tVar3) / f2;
        float a5 = a(tVar2, tVar4);
        t tVar6 = new t(tVar4.a() + (((tVar4.a() - tVar2.a()) / a5) * a4), tVar4.b() + (a4 * ((tVar4.b() - tVar2.b()) / a5)));
        if (a(tVar5)) {
            return (a(tVar6) && Math.abs(b(tVar3, tVar5).c() - b(tVar2, tVar5).c()) > Math.abs(b(tVar3, tVar6).c() - b(tVar2, tVar6).c())) ? tVar6 : tVar5;
        }
        if (a(tVar6)) {
            return tVar6;
        }
        return null;
    }

    private boolean a(t tVar) {
        return tVar.a() >= 0.0f && tVar.a() < ((float) this.f2361a.g()) && tVar.b() > 0.0f && tVar.b() < ((float) this.f2361a.d());
    }

    private static int a(t tVar, t tVar2) {
        return c.b.c.z.m.a.a(t.a(tVar, tVar2));
    }

    private static void a(Map<t, Integer> map, t tVar) {
        Integer num = map.get(tVar);
        map.put(tVar, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    private static c.b.c.z.b a(c.b.c.z.b bVar, t tVar, t tVar2, t tVar3, t tVar4, int i2, int i3) throws m {
        float f2 = i2 - 0.5f;
        float f3 = i3 - 0.5f;
        return i.a().a(bVar, i2, i3, 0.5f, 0.5f, f2, 0.5f, f2, f3, 0.5f, f3, tVar.a(), tVar.b(), tVar4.a(), tVar4.b(), tVar3.a(), tVar3.b(), tVar2.a(), tVar2.b());
    }
}
