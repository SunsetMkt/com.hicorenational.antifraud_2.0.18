package p031c.p035b.p043c.p044a0.p046d;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.C1109t;
import p031c.p035b.p043c.p072z.AbstractC1170i;
import p031c.p035b.p043c.p072z.C1163b;
import p031c.p035b.p043c.p072z.C1168g;
import p031c.p035b.p043c.p072z.p073m.C1174a;
import p031c.p035b.p043c.p072z.p073m.C1176c;

/* compiled from: Detector.java */
/* renamed from: c.b.c.a0.d.a */
/* loaded from: classes.dex */
public final class C0961a {

    /* renamed from: a */
    private final C1163b f1675a;

    /* renamed from: b */
    private final C1176c f1676b;

    /* compiled from: Detector.java */
    /* renamed from: c.b.c.a0.d.a$b */
    private static final class b {

        /* renamed from: a */
        private final C1109t f1677a;

        /* renamed from: b */
        private final C1109t f1678b;

        /* renamed from: c */
        private final int f1679c;

        /* renamed from: a */
        C1109t m1237a() {
            return this.f1677a;
        }

        /* renamed from: b */
        C1109t m1238b() {
            return this.f1678b;
        }

        /* renamed from: c */
        public int m1239c() {
            return this.f1679c;
        }

        public String toString() {
            return this.f1677a + "/" + this.f1678b + '/' + this.f1679c;
        }

        private b(C1109t c1109t, C1109t c1109t2, int i2) {
            this.f1677a = c1109t;
            this.f1678b = c1109t2;
            this.f1679c = i2;
        }
    }

    /* compiled from: Detector.java */
    /* renamed from: c.b.c.a0.d.a$c */
    private static final class c implements Comparator<b>, Serializable {
        private c() {
        }

        @Override // java.util.Comparator
        public int compare(b bVar, b bVar2) {
            return bVar.m1239c() - bVar2.m1239c();
        }
    }

    public C0961a(C1163b c1163b) throws C1102m {
        this.f1675a = c1163b;
        this.f1676b = new C1176c(c1163b);
    }

    /* renamed from: b */
    private b m1235b(C1109t c1109t, C1109t c1109t2) {
        int m1922a = (int) c1109t.m1922a();
        int m1923b = (int) c1109t.m1923b();
        int m1922a2 = (int) c1109t2.m1922a();
        int m1923b2 = (int) c1109t2.m1923b();
        int i2 = 0;
        boolean z = Math.abs(m1923b2 - m1923b) > Math.abs(m1922a2 - m1922a);
        if (z) {
            m1923b = m1922a;
            m1922a = m1923b;
            m1923b2 = m1922a2;
            m1922a2 = m1923b2;
        }
        int abs = Math.abs(m1922a2 - m1922a);
        int abs2 = Math.abs(m1923b2 - m1923b);
        int i3 = (-abs) / 2;
        int i4 = m1923b < m1923b2 ? 1 : -1;
        int i5 = m1922a >= m1922a2 ? -1 : 1;
        boolean m2173b = this.f1675a.m2173b(z ? m1923b : m1922a, z ? m1922a : m1923b);
        while (m1922a != m1922a2) {
            boolean m2173b2 = this.f1675a.m2173b(z ? m1923b : m1922a, z ? m1922a : m1923b);
            if (m2173b2 != m2173b) {
                i2++;
                m2173b = m2173b2;
            }
            i3 += abs2;
            if (i3 > 0) {
                if (m1923b == m1923b2) {
                    break;
                }
                m1923b += i4;
                i3 -= abs;
            }
            m1922a += i5;
        }
        return new b(c1109t, c1109t2, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v3, types: [c.b.c.t] */
    /* JADX WARN: Type inference failed for: r16v3, types: [c.b.c.t] */
    /* JADX WARN: Type inference failed for: r22v0, types: [c.b.c.t] */
    /* JADX WARN: Type inference failed for: r23v0, types: [c.b.c.a0.d.a] */
    /* JADX WARN: Type inference failed for: r3v3, types: [c.b.c.t[]] */
    /* JADX WARN: Type inference failed for: r4v6, types: [c.b.c.t[]] */
    /* JADX WARN: Type inference failed for: r6v2, types: [c.b.c.t] */
    /* renamed from: a */
    public C1168g m1236a() throws C1102m {
        C1109t c1109t;
        C1109t m1231a;
        C1163b m1232a;
        C1109t[] m2230a = this.f1676b.m2230a();
        C1109t c1109t2 = m2230a[0];
        C1109t c1109t3 = m2230a[1];
        C1109t c1109t4 = m2230a[2];
        C1109t c1109t5 = m2230a[3];
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(m1235b(c1109t2, c1109t3));
        arrayList.add(m1235b(c1109t2, c1109t4));
        arrayList.add(m1235b(c1109t3, c1109t5));
        arrayList.add(m1235b(c1109t4, c1109t5));
        a aVar = null;
        Collections.sort(arrayList, new c());
        b bVar = (b) arrayList.get(0);
        b bVar2 = (b) arrayList.get(1);
        HashMap hashMap = new HashMap();
        m1233a(hashMap, bVar.m1237a());
        m1233a(hashMap, bVar.m1238b());
        m1233a(hashMap, bVar2.m1237a());
        m1233a(hashMap, bVar2.m1238b());
        Object obj = null;
        Object obj2 = null;
        for (Map.Entry entry : hashMap.entrySet()) {
            ?? r16 = (C1109t) entry.getKey();
            if (((Integer) entry.getValue()).intValue() == 2) {
                obj = r16;
            } else if (aVar == null) {
                aVar = r16;
            } else {
                obj2 = r16;
            }
        }
        if (aVar == null || obj == null || obj2 == null) {
            throw C1102m.getNotFoundInstance();
        }
        ?? r4 = {aVar, obj, obj2};
        C1109t.m1921a(r4);
        ?? r14 = r4[0];
        ?? r22 = r4[1];
        ?? r6 = r4[2];
        C1109t c1109t6 = !hashMap.containsKey(c1109t2) ? c1109t2 : !hashMap.containsKey(c1109t3) ? c1109t3 : !hashMap.containsKey(c1109t4) ? c1109t4 : c1109t5;
        int m1239c = m1235b(r6, c1109t6).m1239c();
        int m1239c2 = m1235b(r14, c1109t6).m1239c();
        if ((m1239c & 1) == 1) {
            m1239c++;
        }
        int i2 = m1239c + 2;
        if ((m1239c2 & 1) == 1) {
            m1239c2++;
        }
        int i3 = m1239c2 + 2;
        if (i2 * 4 >= i3 * 7 || i3 * 4 >= i2 * 7) {
            c1109t = r6;
            m1231a = m1231a(r22, r14, r6, c1109t6, i2, i3);
            if (m1231a == null) {
                m1231a = c1109t6;
            }
            int m1239c3 = m1235b(c1109t, m1231a).m1239c();
            int m1239c4 = m1235b(r14, m1231a).m1239c();
            if ((m1239c3 & 1) == 1) {
                m1239c3++;
            }
            int i4 = m1239c3;
            if ((m1239c4 & 1) == 1) {
                m1239c4++;
            }
            m1232a = m1232a(this.f1675a, c1109t, r22, r14, m1231a, i4, m1239c4);
        } else {
            m1231a = m1230a(r22, r14, r6, c1109t6, Math.min(i3, i2));
            if (m1231a == null) {
                m1231a = c1109t6;
            }
            int max = Math.max(m1235b(r6, m1231a).m1239c(), m1235b(r14, m1231a).m1239c()) + 1;
            if ((max & 1) == 1) {
                max++;
            }
            int i5 = max;
            m1232a = m1232a(this.f1675a, r6, r22, r14, m1231a, i5, i5);
            c1109t = r6;
        }
        return new C1168g(m1232a, new C1109t[]{c1109t, r22, r14, m1231a});
    }

    /* renamed from: a */
    private C1109t m1231a(C1109t c1109t, C1109t c1109t2, C1109t c1109t3, C1109t c1109t4, int i2, int i3) {
        float m1229a = m1229a(c1109t, c1109t2) / i2;
        float m1229a2 = m1229a(c1109t3, c1109t4);
        C1109t c1109t5 = new C1109t(c1109t4.m1922a() + (((c1109t4.m1922a() - c1109t3.m1922a()) / m1229a2) * m1229a), c1109t4.m1923b() + (m1229a * ((c1109t4.m1923b() - c1109t3.m1923b()) / m1229a2)));
        float m1229a3 = m1229a(c1109t, c1109t3) / i3;
        float m1229a4 = m1229a(c1109t2, c1109t4);
        C1109t c1109t6 = new C1109t(c1109t4.m1922a() + (((c1109t4.m1922a() - c1109t2.m1922a()) / m1229a4) * m1229a3), c1109t4.m1923b() + (m1229a3 * ((c1109t4.m1923b() - c1109t2.m1923b()) / m1229a4)));
        if (m1234a(c1109t5)) {
            return (m1234a(c1109t6) && Math.abs(i2 - m1235b(c1109t3, c1109t5).m1239c()) + Math.abs(i3 - m1235b(c1109t2, c1109t5).m1239c()) > Math.abs(i2 - m1235b(c1109t3, c1109t6).m1239c()) + Math.abs(i3 - m1235b(c1109t2, c1109t6).m1239c())) ? c1109t6 : c1109t5;
        }
        if (m1234a(c1109t6)) {
            return c1109t6;
        }
        return null;
    }

    /* renamed from: a */
    private C1109t m1230a(C1109t c1109t, C1109t c1109t2, C1109t c1109t3, C1109t c1109t4, int i2) {
        float f2 = i2;
        float m1229a = m1229a(c1109t, c1109t2) / f2;
        float m1229a2 = m1229a(c1109t3, c1109t4);
        C1109t c1109t5 = new C1109t(c1109t4.m1922a() + (((c1109t4.m1922a() - c1109t3.m1922a()) / m1229a2) * m1229a), c1109t4.m1923b() + (m1229a * ((c1109t4.m1923b() - c1109t3.m1923b()) / m1229a2)));
        float m1229a3 = m1229a(c1109t, c1109t3) / f2;
        float m1229a4 = m1229a(c1109t2, c1109t4);
        C1109t c1109t6 = new C1109t(c1109t4.m1922a() + (((c1109t4.m1922a() - c1109t2.m1922a()) / m1229a4) * m1229a3), c1109t4.m1923b() + (m1229a3 * ((c1109t4.m1923b() - c1109t2.m1923b()) / m1229a4)));
        if (m1234a(c1109t5)) {
            return (m1234a(c1109t6) && Math.abs(m1235b(c1109t3, c1109t5).m1239c() - m1235b(c1109t2, c1109t5).m1239c()) > Math.abs(m1235b(c1109t3, c1109t6).m1239c() - m1235b(c1109t2, c1109t6).m1239c())) ? c1109t6 : c1109t5;
        }
        if (m1234a(c1109t6)) {
            return c1109t6;
        }
        return null;
    }

    /* renamed from: a */
    private boolean m1234a(C1109t c1109t) {
        return c1109t.m1922a() >= 0.0f && c1109t.m1922a() < ((float) this.f1675a.m2181g()) && c1109t.m1923b() > 0.0f && c1109t.m1923b() < ((float) this.f1675a.m2177d());
    }

    /* renamed from: a */
    private static int m1229a(C1109t c1109t, C1109t c1109t2) {
        return C1174a.m2223a(C1109t.m1919a(c1109t, c1109t2));
    }

    /* renamed from: a */
    private static void m1233a(Map<C1109t, Integer> map, C1109t c1109t) {
        Integer num = map.get(c1109t);
        map.put(c1109t, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    /* renamed from: a */
    private static C1163b m1232a(C1163b c1163b, C1109t c1109t, C1109t c1109t2, C1109t c1109t3, C1109t c1109t4, int i2, int i3) throws C1102m {
        float f2 = i2 - 0.5f;
        float f3 = i3 - 0.5f;
        return AbstractC1170i.m2206a().mo2200a(c1163b, i2, i3, 0.5f, 0.5f, f2, 0.5f, f2, f3, 0.5f, f3, c1109t.m1922a(), c1109t.m1923b(), c1109t4.m1922a(), c1109t4.m1923b(), c1109t3.m1922a(), c1109t3.m1923b(), c1109t2.m1922a(), c1109t2.m1923b());
    }
}
