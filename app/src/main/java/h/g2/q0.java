package h.g2;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Grouping.kt */
/* loaded from: classes2.dex */
class q0 extends p0 {
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @h.t0(version = "1.1")
    @i.c.a.d
    public static final <T, K, R> Map<K, R> a(@i.c.a.d n0<T, ? extends K> n0Var, @i.c.a.d h.q2.s.r<? super K, ? super R, ? super T, ? super Boolean, ? extends R> rVar) {
        h.q2.t.i0.f(n0Var, "$this$aggregate");
        h.q2.t.i0.f(rVar, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> a2 = n0Var.a();
        while (a2.hasNext()) {
            ?? next = a2.next();
            Object a3 = n0Var.a(next);
            a.a.a aVar = (Object) linkedHashMap.get(a3);
            linkedHashMap.put(a3, rVar.invoke(a3, aVar, next, Boolean.valueOf(aVar == null && !linkedHashMap.containsKey(a3))));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @h.t0(version = "1.1")
    @i.c.a.d
    public static final <T, K, R, M extends Map<? super K, R>> M a(@i.c.a.d n0<T, ? extends K> n0Var, @i.c.a.d M m2, @i.c.a.d h.q2.s.r<? super K, ? super R, ? super T, ? super Boolean, ? extends R> rVar) {
        h.q2.t.i0.f(n0Var, "$this$aggregateTo");
        h.q2.t.i0.f(m2, "destination");
        h.q2.t.i0.f(rVar, "operation");
        Iterator<T> a2 = n0Var.a();
        while (a2.hasNext()) {
            ?? next = a2.next();
            Object a3 = n0Var.a(next);
            a.a.a aVar = (Object) m2.get(a3);
            m2.put(a3, rVar.invoke(a3, aVar, next, Boolean.valueOf(aVar == null && !m2.containsKey(a3))));
        }
        return m2;
    }

    @h.t0(version = "1.1")
    @i.c.a.d
    public static final <T, K, M extends Map<? super K, Integer>> M a(@i.c.a.d n0<T, ? extends K> n0Var, @i.c.a.d M m2) {
        h.q2.t.i0.f(n0Var, "$this$eachCountTo");
        h.q2.t.i0.f(m2, "destination");
        Iterator<T> a2 = n0Var.a();
        while (a2.hasNext()) {
            K a3 = n0Var.a(a2.next());
            Object obj = m2.get(a3);
            if (obj == null && !m2.containsKey(a3)) {
                obj = 0;
            }
            m2.put(a3, Integer.valueOf(((Number) obj).intValue() + 1));
        }
        return m2;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @h.t0(version = "1.1")
    @i.c.a.d
    public static final <T, K, R> Map<K, R> a(@i.c.a.d n0<T, ? extends K> n0Var, @i.c.a.d h.q2.s.p<? super K, ? super T, ? extends R> pVar, @i.c.a.d h.q2.s.q<? super K, ? super R, ? super T, ? extends R> qVar) {
        h.q2.t.i0.f(n0Var, "$this$fold");
        h.q2.t.i0.f(pVar, "initialValueSelector");
        h.q2.t.i0.f(qVar, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> a2 = n0Var.a();
        while (a2.hasNext()) {
            ?? next = a2.next();
            Object a3 = n0Var.a(next);
            R r = (Object) linkedHashMap.get(a3);
            if (r == null && !linkedHashMap.containsKey(a3)) {
                r = pVar.invoke(a3, next);
            }
            linkedHashMap.put(a3, qVar.invoke(a3, r, next));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @h.t0(version = "1.1")
    @i.c.a.d
    public static final <T, K, R, M extends Map<? super K, R>> M a(@i.c.a.d n0<T, ? extends K> n0Var, @i.c.a.d M m2, @i.c.a.d h.q2.s.p<? super K, ? super T, ? extends R> pVar, @i.c.a.d h.q2.s.q<? super K, ? super R, ? super T, ? extends R> qVar) {
        h.q2.t.i0.f(n0Var, "$this$foldTo");
        h.q2.t.i0.f(m2, "destination");
        h.q2.t.i0.f(pVar, "initialValueSelector");
        h.q2.t.i0.f(qVar, "operation");
        Iterator<T> a2 = n0Var.a();
        while (a2.hasNext()) {
            ?? next = a2.next();
            Object a3 = n0Var.a(next);
            R r = (Object) m2.get(a3);
            if (r == null && !m2.containsKey(a3)) {
                r = pVar.invoke(a3, next);
            }
            m2.put(a3, qVar.invoke(a3, r, next));
        }
        return m2;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @h.t0(version = "1.1")
    @i.c.a.d
    public static final <T, K, R> Map<K, R> a(@i.c.a.d n0<T, ? extends K> n0Var, R r, @i.c.a.d h.q2.s.p<? super R, ? super T, ? extends R> pVar) {
        h.q2.t.i0.f(n0Var, "$this$fold");
        h.q2.t.i0.f(pVar, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> a2 = n0Var.a();
        while (a2.hasNext()) {
            ?? next = a2.next();
            K a3 = n0Var.a(next);
            a.a.a aVar = (Object) linkedHashMap.get(a3);
            if (aVar == null && !linkedHashMap.containsKey(a3)) {
                aVar = (Object) r;
            }
            linkedHashMap.put(a3, pVar.invoke(aVar, next));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @h.t0(version = "1.1")
    @i.c.a.d
    public static final <T, K, R, M extends Map<? super K, R>> M a(@i.c.a.d n0<T, ? extends K> n0Var, @i.c.a.d M m2, R r, @i.c.a.d h.q2.s.p<? super R, ? super T, ? extends R> pVar) {
        h.q2.t.i0.f(n0Var, "$this$foldTo");
        h.q2.t.i0.f(m2, "destination");
        h.q2.t.i0.f(pVar, "operation");
        Iterator<T> a2 = n0Var.a();
        while (a2.hasNext()) {
            ?? next = a2.next();
            K a3 = n0Var.a(next);
            a.a.a aVar = (Object) m2.get(a3);
            if (aVar == null && !m2.containsKey(a3)) {
                aVar = (Object) r;
            }
            m2.put(a3, pVar.invoke(aVar, next));
        }
        return m2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.t0(version = "1.1")
    @i.c.a.d
    public static final <S, T extends S, K> Map<K, S> a(@i.c.a.d n0<T, ? extends K> n0Var, @i.c.a.d h.q2.s.q<? super K, ? super S, ? super T, ? extends S> qVar) {
        h.q2.t.i0.f(n0Var, "$this$reduce");
        h.q2.t.i0.f(qVar, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator a2 = n0Var.a();
        while (a2.hasNext()) {
            S s = (Object) a2.next();
            Object a3 = n0Var.a(s);
            a.a.a aVar = (Object) linkedHashMap.get(a3);
            if (!(aVar == null && !linkedHashMap.containsKey(a3))) {
                s = qVar.invoke(a3, aVar, s);
            }
            linkedHashMap.put(a3, s);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.t0(version = "1.1")
    @i.c.a.d
    public static final <S, T extends S, K, M extends Map<? super K, S>> M a(@i.c.a.d n0<T, ? extends K> n0Var, @i.c.a.d M m2, @i.c.a.d h.q2.s.q<? super K, ? super S, ? super T, ? extends S> qVar) {
        h.q2.t.i0.f(n0Var, "$this$reduceTo");
        h.q2.t.i0.f(m2, "destination");
        h.q2.t.i0.f(qVar, "operation");
        Iterator a2 = n0Var.a();
        while (a2.hasNext()) {
            S s = (Object) a2.next();
            Object a3 = n0Var.a(s);
            a.a.a aVar = (Object) m2.get(a3);
            if (!(aVar == null && !m2.containsKey(a3))) {
                s = qVar.invoke(a3, aVar, s);
            }
            m2.put(a3, s);
        }
        return m2;
    }
}
