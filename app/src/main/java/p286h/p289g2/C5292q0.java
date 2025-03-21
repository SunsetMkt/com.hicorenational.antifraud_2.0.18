package p286h.p289g2;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import p000a.p001a.InterfaceC0000a;
import p286h.InterfaceC5610t0;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p310s.InterfaceC5511q;
import p286h.p309q2.p310s.InterfaceC5512r;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Grouping.kt */
/* renamed from: h.g2.q0 */
/* loaded from: classes2.dex */
class C5292q0 extends C5289p0 {
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5816d
    /* renamed from: a */
    public static final <T, K, R> Map<K, R> m20382a(@InterfaceC5816d InterfaceC5283n0<T, ? extends K> interfaceC5283n0, @InterfaceC5816d InterfaceC5512r<? super K, ? super R, ? super T, ? super Boolean, ? extends R> interfaceC5512r) {
        C5544i0.m22546f(interfaceC5283n0, "$this$aggregate");
        C5544i0.m22546f(interfaceC5512r, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> mo19950a = interfaceC5283n0.mo19950a();
        while (mo19950a.hasNext()) {
            ?? next = mo19950a.next();
            Object mo19949a = interfaceC5283n0.mo19949a(next);
            InterfaceC0000a interfaceC0000a = (Object) linkedHashMap.get(mo19949a);
            linkedHashMap.put(mo19949a, interfaceC5512r.invoke(mo19949a, interfaceC0000a, next, Boolean.valueOf(interfaceC0000a == null && !linkedHashMap.containsKey(mo19949a))));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5816d
    /* renamed from: a */
    public static final <T, K, R, M extends Map<? super K, R>> M m20387a(@InterfaceC5816d InterfaceC5283n0<T, ? extends K> interfaceC5283n0, @InterfaceC5816d M m2, @InterfaceC5816d InterfaceC5512r<? super K, ? super R, ? super T, ? super Boolean, ? extends R> interfaceC5512r) {
        C5544i0.m22546f(interfaceC5283n0, "$this$aggregateTo");
        C5544i0.m22546f(m2, "destination");
        C5544i0.m22546f(interfaceC5512r, "operation");
        Iterator<T> mo19950a = interfaceC5283n0.mo19950a();
        while (mo19950a.hasNext()) {
            ?? next = mo19950a.next();
            Object mo19949a = interfaceC5283n0.mo19949a(next);
            InterfaceC0000a interfaceC0000a = (Object) m2.get(mo19949a);
            m2.put(mo19949a, interfaceC5512r.invoke(mo19949a, interfaceC0000a, next, Boolean.valueOf(interfaceC0000a == null && !m2.containsKey(mo19949a))));
        }
        return m2;
    }

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5816d
    /* renamed from: a */
    public static final <T, K, M extends Map<? super K, Integer>> M m20384a(@InterfaceC5816d InterfaceC5283n0<T, ? extends K> interfaceC5283n0, @InterfaceC5816d M m2) {
        C5544i0.m22546f(interfaceC5283n0, "$this$eachCountTo");
        C5544i0.m22546f(m2, "destination");
        Iterator<T> mo19950a = interfaceC5283n0.mo19950a();
        while (mo19950a.hasNext()) {
            K mo19949a = interfaceC5283n0.mo19949a(mo19950a.next());
            Object obj = m2.get(mo19949a);
            if (obj == null && !m2.containsKey(mo19949a)) {
                obj = 0;
            }
            m2.put(mo19949a, Integer.valueOf(((Number) obj).intValue() + 1));
        }
        return m2;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5816d
    /* renamed from: a */
    public static final <T, K, R> Map<K, R> m20380a(@InterfaceC5816d InterfaceC5283n0<T, ? extends K> interfaceC5283n0, @InterfaceC5816d InterfaceC5510p<? super K, ? super T, ? extends R> interfaceC5510p, @InterfaceC5816d InterfaceC5511q<? super K, ? super R, ? super T, ? extends R> interfaceC5511q) {
        C5544i0.m22546f(interfaceC5283n0, "$this$fold");
        C5544i0.m22546f(interfaceC5510p, "initialValueSelector");
        C5544i0.m22546f(interfaceC5511q, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> mo19950a = interfaceC5283n0.mo19950a();
        while (mo19950a.hasNext()) {
            ?? next = mo19950a.next();
            Object mo19949a = interfaceC5283n0.mo19949a(next);
            R r = (Object) linkedHashMap.get(mo19949a);
            if (r == null && !linkedHashMap.containsKey(mo19949a)) {
                r = interfaceC5510p.invoke(mo19949a, next);
            }
            linkedHashMap.put(mo19949a, interfaceC5511q.invoke(mo19949a, r, next));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5816d
    /* renamed from: a */
    public static final <T, K, R, M extends Map<? super K, R>> M m20385a(@InterfaceC5816d InterfaceC5283n0<T, ? extends K> interfaceC5283n0, @InterfaceC5816d M m2, @InterfaceC5816d InterfaceC5510p<? super K, ? super T, ? extends R> interfaceC5510p, @InterfaceC5816d InterfaceC5511q<? super K, ? super R, ? super T, ? extends R> interfaceC5511q) {
        C5544i0.m22546f(interfaceC5283n0, "$this$foldTo");
        C5544i0.m22546f(m2, "destination");
        C5544i0.m22546f(interfaceC5510p, "initialValueSelector");
        C5544i0.m22546f(interfaceC5511q, "operation");
        Iterator<T> mo19950a = interfaceC5283n0.mo19950a();
        while (mo19950a.hasNext()) {
            ?? next = mo19950a.next();
            Object mo19949a = interfaceC5283n0.mo19949a(next);
            R r = (Object) m2.get(mo19949a);
            if (r == null && !m2.containsKey(mo19949a)) {
                r = interfaceC5510p.invoke(mo19949a, next);
            }
            m2.put(mo19949a, interfaceC5511q.invoke(mo19949a, r, next));
        }
        return m2;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5816d
    /* renamed from: a */
    public static final <T, K, R> Map<K, R> m20383a(@InterfaceC5816d InterfaceC5283n0<T, ? extends K> interfaceC5283n0, R r, @InterfaceC5816d InterfaceC5510p<? super R, ? super T, ? extends R> interfaceC5510p) {
        C5544i0.m22546f(interfaceC5283n0, "$this$fold");
        C5544i0.m22546f(interfaceC5510p, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> mo19950a = interfaceC5283n0.mo19950a();
        while (mo19950a.hasNext()) {
            ?? next = mo19950a.next();
            K mo19949a = interfaceC5283n0.mo19949a(next);
            InterfaceC0000a interfaceC0000a = (Object) linkedHashMap.get(mo19949a);
            if (interfaceC0000a == null && !linkedHashMap.containsKey(mo19949a)) {
                interfaceC0000a = (Object) r;
            }
            linkedHashMap.put(mo19949a, interfaceC5510p.invoke(interfaceC0000a, next));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5816d
    /* renamed from: a */
    public static final <T, K, R, M extends Map<? super K, R>> M m20388a(@InterfaceC5816d InterfaceC5283n0<T, ? extends K> interfaceC5283n0, @InterfaceC5816d M m2, R r, @InterfaceC5816d InterfaceC5510p<? super R, ? super T, ? extends R> interfaceC5510p) {
        C5544i0.m22546f(interfaceC5283n0, "$this$foldTo");
        C5544i0.m22546f(m2, "destination");
        C5544i0.m22546f(interfaceC5510p, "operation");
        Iterator<T> mo19950a = interfaceC5283n0.mo19950a();
        while (mo19950a.hasNext()) {
            ?? next = mo19950a.next();
            K mo19949a = interfaceC5283n0.mo19949a(next);
            InterfaceC0000a interfaceC0000a = (Object) m2.get(mo19949a);
            if (interfaceC0000a == null && !m2.containsKey(mo19949a)) {
                interfaceC0000a = (Object) r;
            }
            m2.put(mo19949a, interfaceC5510p.invoke(interfaceC0000a, next));
        }
        return m2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5816d
    /* renamed from: a */
    public static final <S, T extends S, K> Map<K, S> m20381a(@InterfaceC5816d InterfaceC5283n0<T, ? extends K> interfaceC5283n0, @InterfaceC5816d InterfaceC5511q<? super K, ? super S, ? super T, ? extends S> interfaceC5511q) {
        C5544i0.m22546f(interfaceC5283n0, "$this$reduce");
        C5544i0.m22546f(interfaceC5511q, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator mo19950a = interfaceC5283n0.mo19950a();
        while (mo19950a.hasNext()) {
            S s = (Object) mo19950a.next();
            Object mo19949a = interfaceC5283n0.mo19949a(s);
            InterfaceC0000a interfaceC0000a = (Object) linkedHashMap.get(mo19949a);
            if (!(interfaceC0000a == null && !linkedHashMap.containsKey(mo19949a))) {
                s = interfaceC5511q.invoke(mo19949a, interfaceC0000a, s);
            }
            linkedHashMap.put(mo19949a, s);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5816d
    /* renamed from: a */
    public static final <S, T extends S, K, M extends Map<? super K, S>> M m20386a(@InterfaceC5816d InterfaceC5283n0<T, ? extends K> interfaceC5283n0, @InterfaceC5816d M m2, @InterfaceC5816d InterfaceC5511q<? super K, ? super S, ? super T, ? extends S> interfaceC5511q) {
        C5544i0.m22546f(interfaceC5283n0, "$this$reduceTo");
        C5544i0.m22546f(m2, "destination");
        C5544i0.m22546f(interfaceC5511q, "operation");
        Iterator mo19950a = interfaceC5283n0.mo19950a();
        while (mo19950a.hasNext()) {
            S s = (Object) mo19950a.next();
            Object mo19949a = interfaceC5283n0.mo19949a(s);
            InterfaceC0000a interfaceC0000a = (Object) m2.get(mo19949a);
            if (!(interfaceC0000a == null && !m2.containsKey(mo19949a))) {
                s = interfaceC5511q.invoke(mo19949a, interfaceC0000a, s);
            }
            m2.put(mo19949a, s);
        }
        return m2;
    }
}
