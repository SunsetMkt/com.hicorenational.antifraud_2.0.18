package com.airbnb.lottie.p098a0.p099l0;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: LinkedHashTreeMap.java */
/* renamed from: com.airbnb.lottie.a0.l0.f */
/* loaded from: classes.dex */
final class C1333f<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* renamed from: a */
    private static final Comparator<Comparable> f3081a = new a();
    Comparator<? super K> comparator;
    private C1333f<K, V>.d entrySet;
    final g<K, V> header;
    private C1333f<K, V>.e keySet;
    int modCount;
    int size;
    g<K, V>[] table;
    int threshold;

    /* compiled from: LinkedHashTreeMap.java */
    /* renamed from: com.airbnb.lottie.a0.l0.f$a */
    class a implements Comparator<Comparable> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* compiled from: LinkedHashTreeMap.java */
    /* renamed from: com.airbnb.lottie.a0.l0.f$d */
    final class d extends AbstractSet<Map.Entry<K, V>> {

        /* compiled from: LinkedHashTreeMap.java */
        /* renamed from: com.airbnb.lottie.a0.l0.f$d$a */
        class a extends C1333f<K, V>.f<Map.Entry<K, V>> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                return m2740a();
            }
        }

        d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            C1333f.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && C1333f.this.findByEntry((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            g<K, V> findByEntry;
            if (!(obj instanceof Map.Entry) || (findByEntry = C1333f.this.findByEntry((Map.Entry) obj)) == null) {
                return false;
            }
            C1333f.this.removeInternal(findByEntry, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C1333f.this.size;
        }
    }

    /* compiled from: LinkedHashTreeMap.java */
    /* renamed from: com.airbnb.lottie.a0.l0.f$e */
    final class e extends AbstractSet<K> {

        /* compiled from: LinkedHashTreeMap.java */
        /* renamed from: com.airbnb.lottie.a0.l0.f$e$a */
        class a extends C1333f<K, V>.f<K> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return m2740a().f3100f;
            }
        }

        e() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            C1333f.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return C1333f.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return C1333f.this.removeInternalByKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C1333f.this.size;
        }
    }

    /* compiled from: LinkedHashTreeMap.java */
    /* renamed from: com.airbnb.lottie.a0.l0.f$f */
    abstract class f<T> implements Iterator<T> {

        /* renamed from: a */
        g<K, V> f3091a;

        /* renamed from: b */
        g<K, V> f3092b;

        /* renamed from: c */
        int f3093c;

        f() {
            C1333f c1333f = C1333f.this;
            this.f3091a = c1333f.header.f3098d;
            this.f3092b = null;
            this.f3093c = c1333f.modCount;
        }

        /* renamed from: a */
        final g<K, V> m2740a() {
            g<K, V> gVar = this.f3091a;
            C1333f c1333f = C1333f.this;
            if (gVar == c1333f.header) {
                throw new NoSuchElementException();
            }
            if (c1333f.modCount != this.f3093c) {
                throw new ConcurrentModificationException();
            }
            this.f3091a = gVar.f3098d;
            this.f3092b = gVar;
            return gVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f3091a != C1333f.this.header;
        }

        @Override // java.util.Iterator
        public final void remove() {
            g<K, V> gVar = this.f3092b;
            if (gVar == null) {
                throw new IllegalStateException();
            }
            C1333f.this.removeInternal(gVar, true);
            this.f3092b = null;
            this.f3093c = C1333f.this.modCount;
        }
    }

    C1333f() {
        this(null);
    }

    /* renamed from: a */
    private static int m2727a(int i2) {
        int i3 = i2 ^ ((i2 >>> 20) ^ (i2 >>> 12));
        return (i3 >>> 4) ^ ((i3 >>> 7) ^ i3);
    }

    /* renamed from: a */
    private boolean m2731a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: b */
    private void m2733b(g<K, V> gVar) {
        g<K, V> gVar2 = gVar.f3096b;
        g<K, V> gVar3 = gVar.f3097c;
        g<K, V> gVar4 = gVar2.f3096b;
        g<K, V> gVar5 = gVar2.f3097c;
        gVar.f3096b = gVar5;
        if (gVar5 != null) {
            gVar5.f3095a = gVar;
        }
        m2729a((g) gVar, (g) gVar2);
        gVar2.f3097c = gVar;
        gVar.f3095a = gVar2;
        gVar.f3103i = Math.max(gVar3 != null ? gVar3.f3103i : 0, gVar5 != null ? gVar5.f3103i : 0) + 1;
        gVar2.f3103i = Math.max(gVar.f3103i, gVar4 != null ? gVar4.f3103i : 0) + 1;
    }

    static <K, V> g<K, V>[] doubleCapacity(g<K, V>[] gVarArr) {
        int length = gVarArr.length;
        g<K, V>[] gVarArr2 = new g[length * 2];
        c cVar = new c();
        b bVar = new b();
        b bVar2 = new b();
        for (int i2 = 0; i2 < length; i2++) {
            g<K, V> gVar = gVarArr[i2];
            if (gVar != null) {
                cVar.m2739a(gVar);
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    g<K, V> m2738a = cVar.m2738a();
                    if (m2738a == null) {
                        break;
                    }
                    if ((m2738a.f3101g & length) == 0) {
                        i3++;
                    } else {
                        i4++;
                    }
                }
                bVar.m2736a(i3);
                bVar2.m2736a(i4);
                cVar.m2739a(gVar);
                while (true) {
                    g<K, V> m2738a2 = cVar.m2738a();
                    if (m2738a2 == null) {
                        break;
                    }
                    if ((m2738a2.f3101g & length) == 0) {
                        bVar.m2737a(m2738a2);
                    } else {
                        bVar2.m2737a(m2738a2);
                    }
                }
                gVarArr2[i2] = i3 > 0 ? bVar.m2735a() : null;
                gVarArr2[i2 + length] = i4 > 0 ? bVar2.m2735a() : null;
            }
        }
        return gVarArr2;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.table, (Object) null);
        this.size = 0;
        this.modCount++;
        g<K, V> gVar = this.header;
        g<K, V> gVar2 = gVar.f3098d;
        while (gVar2 != gVar) {
            g<K, V> gVar3 = gVar2.f3098d;
            gVar2.f3099e = null;
            gVar2.f3098d = null;
            gVar2 = gVar3;
        }
        gVar.f3099e = gVar;
        gVar.f3098d = gVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        C1333f<K, V>.d dVar = this.entrySet;
        if (dVar != null) {
            return dVar;
        }
        C1333f<K, V>.d dVar2 = new d();
        this.entrySet = dVar2;
        return dVar2;
    }

    g<K, V> find(K k2, boolean z) {
        g<K, V> gVar;
        int i2;
        g<K, V> gVar2;
        Comparator<? super K> comparator = this.comparator;
        g<K, V>[] gVarArr = this.table;
        int m2727a = m2727a(k2.hashCode());
        int length = (gVarArr.length - 1) & m2727a;
        g<K, V> gVar3 = gVarArr[length];
        if (gVar3 != null) {
            Comparable comparable = comparator == f3081a ? (Comparable) k2 : null;
            while (true) {
                int compareTo = comparable != null ? comparable.compareTo(gVar3.f3100f) : comparator.compare(k2, gVar3.f3100f);
                if (compareTo == 0) {
                    return gVar3;
                }
                g<K, V> gVar4 = compareTo < 0 ? gVar3.f3096b : gVar3.f3097c;
                if (gVar4 == null) {
                    gVar = gVar3;
                    i2 = compareTo;
                    break;
                }
                gVar3 = gVar4;
            }
        } else {
            gVar = gVar3;
            i2 = 0;
        }
        if (!z) {
            return null;
        }
        g<K, V> gVar5 = this.header;
        if (gVar != null) {
            gVar2 = new g<>(gVar, k2, m2727a, gVar5, gVar5.f3099e);
            if (i2 < 0) {
                gVar.f3096b = gVar2;
            } else {
                gVar.f3097c = gVar2;
            }
            m2730a((g) gVar, true);
        } else {
            if (comparator == f3081a && !(k2 instanceof Comparable)) {
                throw new ClassCastException(k2.getClass().getName() + " is not Comparable");
            }
            gVar2 = new g<>(gVar, k2, m2727a, gVar5, gVar5.f3099e);
            gVarArr[length] = gVar2;
        }
        int i3 = this.size;
        this.size = i3 + 1;
        if (i3 > this.threshold) {
            m2732b();
        }
        this.modCount++;
        return gVar2;
    }

    g<K, V> findByEntry(Map.Entry<?, ?> entry) {
        g<K, V> findByObject = findByObject(entry.getKey());
        if (findByObject != null && m2731a(findByObject.f3102h, entry.getValue())) {
            return findByObject;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    g<K, V> findByObject(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return find(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        g<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            return findByObject.f3102h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        C1333f<K, V>.e eVar = this.keySet;
        if (eVar != null) {
            return eVar;
        }
        C1333f<K, V>.e eVar2 = new e();
        this.keySet = eVar2;
        return eVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k2, V v) {
        if (k2 == null) {
            throw new NullPointerException("key == null");
        }
        g<K, V> find = find(k2, true);
        V v2 = find.f3102h;
        find.f3102h = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        g<K, V> removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.f3102h;
        }
        return null;
    }

    void removeInternal(g<K, V> gVar, boolean z) {
        int i2;
        if (z) {
            g<K, V> gVar2 = gVar.f3099e;
            gVar2.f3098d = gVar.f3098d;
            gVar.f3098d.f3099e = gVar2;
            gVar.f3099e = null;
            gVar.f3098d = null;
        }
        g<K, V> gVar3 = gVar.f3096b;
        g<K, V> gVar4 = gVar.f3097c;
        g<K, V> gVar5 = gVar.f3095a;
        int i3 = 0;
        if (gVar3 == null || gVar4 == null) {
            if (gVar3 != null) {
                m2729a((g) gVar, (g) gVar3);
                gVar.f3096b = null;
            } else if (gVar4 != null) {
                m2729a((g) gVar, (g) gVar4);
                gVar.f3097c = null;
            } else {
                m2729a((g) gVar, (g) null);
            }
            m2730a((g) gVar5, false);
            this.size--;
            this.modCount++;
            return;
        }
        g<K, V> m2742b = gVar3.f3103i > gVar4.f3103i ? gVar3.m2742b() : gVar4.m2741a();
        removeInternal(m2742b, false);
        g<K, V> gVar6 = gVar.f3096b;
        if (gVar6 != null) {
            i2 = gVar6.f3103i;
            m2742b.f3096b = gVar6;
            gVar6.f3095a = m2742b;
            gVar.f3096b = null;
        } else {
            i2 = 0;
        }
        g<K, V> gVar7 = gVar.f3097c;
        if (gVar7 != null) {
            i3 = gVar7.f3103i;
            m2742b.f3097c = gVar7;
            gVar7.f3095a = m2742b;
            gVar.f3097c = null;
        }
        m2742b.f3103i = Math.max(i2, i3) + 1;
        m2729a((g) gVar, (g) m2742b);
    }

    g<K, V> removeInternalByKey(Object obj) {
        g<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        return findByObject;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    C1333f(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator == null ? f3081a : comparator;
        this.header = new g<>();
        this.table = new g[16];
        g<K, V>[] gVarArr = this.table;
        this.threshold = (gVarArr.length / 2) + (gVarArr.length / 4);
    }

    /* renamed from: a */
    private void m2729a(g<K, V> gVar, g<K, V> gVar2) {
        g<K, V> gVar3 = gVar.f3095a;
        gVar.f3095a = null;
        if (gVar2 != null) {
            gVar2.f3095a = gVar3;
        }
        if (gVar3 == null) {
            int i2 = gVar.f3101g;
            this.table[i2 & (r0.length - 1)] = gVar2;
        } else if (gVar3.f3096b == gVar) {
            gVar3.f3096b = gVar2;
        } else {
            gVar3.f3097c = gVar2;
        }
    }

    /* compiled from: LinkedHashTreeMap.java */
    /* renamed from: com.airbnb.lottie.a0.l0.f$c */
    static class c<K, V> {

        /* renamed from: a */
        private g<K, V> f3086a;

        c() {
        }

        /* renamed from: a */
        void m2739a(g<K, V> gVar) {
            g<K, V> gVar2 = null;
            while (true) {
                g<K, V> gVar3 = gVar2;
                gVar2 = gVar;
                if (gVar2 == null) {
                    this.f3086a = gVar3;
                    return;
                } else {
                    gVar2.f3095a = gVar3;
                    gVar = gVar2.f3096b;
                }
            }
        }

        /* renamed from: a */
        public g<K, V> m2738a() {
            g<K, V> gVar = this.f3086a;
            if (gVar == null) {
                return null;
            }
            g<K, V> gVar2 = gVar.f3095a;
            gVar.f3095a = null;
            g<K, V> gVar3 = gVar.f3097c;
            while (true) {
                g<K, V> gVar4 = gVar2;
                gVar2 = gVar3;
                if (gVar2 != null) {
                    gVar2.f3095a = gVar4;
                    gVar3 = gVar2.f3096b;
                } else {
                    this.f3086a = gVar4;
                    return gVar;
                }
            }
        }
    }

    /* compiled from: LinkedHashTreeMap.java */
    /* renamed from: com.airbnb.lottie.a0.l0.f$g */
    static final class g<K, V> implements Map.Entry<K, V> {

        /* renamed from: a */
        g<K, V> f3095a;

        /* renamed from: b */
        g<K, V> f3096b;

        /* renamed from: c */
        g<K, V> f3097c;

        /* renamed from: d */
        g<K, V> f3098d;

        /* renamed from: e */
        g<K, V> f3099e;

        /* renamed from: f */
        final K f3100f;

        /* renamed from: g */
        final int f3101g;

        /* renamed from: h */
        V f3102h;

        /* renamed from: i */
        int f3103i;

        g() {
            this.f3100f = null;
            this.f3101g = -1;
            this.f3099e = this;
            this.f3098d = this;
        }

        /* renamed from: a */
        public g<K, V> m2741a() {
            g<K, V> gVar = this;
            for (g<K, V> gVar2 = this.f3096b; gVar2 != null; gVar2 = gVar2.f3096b) {
                gVar = gVar2;
            }
            return gVar;
        }

        /* renamed from: b */
        public g<K, V> m2742b() {
            g<K, V> gVar = this;
            for (g<K, V> gVar2 = this.f3097c; gVar2 != null; gVar2 = gVar2.f3097c) {
                gVar = gVar2;
            }
            return gVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k2 = this.f3100f;
            if (k2 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k2.equals(entry.getKey())) {
                return false;
            }
            V v = this.f3102h;
            if (v == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f3100f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f3102h;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k2 = this.f3100f;
            int hashCode = k2 == null ? 0 : k2.hashCode();
            V v = this.f3102h;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.f3102h;
            this.f3102h = v;
            return v2;
        }

        public String toString() {
            return this.f3100f + ContainerUtils.KEY_VALUE_DELIMITER + this.f3102h;
        }

        g(g<K, V> gVar, K k2, int i2, g<K, V> gVar2, g<K, V> gVar3) {
            this.f3095a = gVar;
            this.f3100f = k2;
            this.f3101g = i2;
            this.f3103i = 1;
            this.f3098d = gVar2;
            this.f3099e = gVar3;
            gVar3.f3098d = this;
            gVar2.f3099e = this;
        }
    }

    /* compiled from: LinkedHashTreeMap.java */
    /* renamed from: com.airbnb.lottie.a0.l0.f$b */
    static final class b<K, V> {

        /* renamed from: a */
        private g<K, V> f3082a;

        /* renamed from: b */
        private int f3083b;

        /* renamed from: c */
        private int f3084c;

        /* renamed from: d */
        private int f3085d;

        b() {
        }

        /* renamed from: a */
        void m2736a(int i2) {
            this.f3083b = ((Integer.highestOneBit(i2) * 2) - 1) - i2;
            this.f3085d = 0;
            this.f3084c = 0;
            this.f3082a = null;
        }

        /* renamed from: a */
        void m2737a(g<K, V> gVar) {
            gVar.f3097c = null;
            gVar.f3095a = null;
            gVar.f3096b = null;
            gVar.f3103i = 1;
            int i2 = this.f3083b;
            if (i2 > 0) {
                int i3 = this.f3085d;
                if ((i3 & 1) == 0) {
                    this.f3085d = i3 + 1;
                    this.f3083b = i2 - 1;
                    this.f3084c++;
                }
            }
            gVar.f3095a = this.f3082a;
            this.f3082a = gVar;
            this.f3085d++;
            int i4 = this.f3083b;
            if (i4 > 0) {
                int i5 = this.f3085d;
                if ((i5 & 1) == 0) {
                    this.f3085d = i5 + 1;
                    this.f3083b = i4 - 1;
                    this.f3084c++;
                }
            }
            int i6 = 4;
            while (true) {
                int i7 = i6 - 1;
                if ((this.f3085d & i7) != i7) {
                    return;
                }
                int i8 = this.f3084c;
                if (i8 == 0) {
                    g<K, V> gVar2 = this.f3082a;
                    g<K, V> gVar3 = gVar2.f3095a;
                    g<K, V> gVar4 = gVar3.f3095a;
                    gVar3.f3095a = gVar4.f3095a;
                    this.f3082a = gVar3;
                    gVar3.f3096b = gVar4;
                    gVar3.f3097c = gVar2;
                    gVar3.f3103i = gVar2.f3103i + 1;
                    gVar4.f3095a = gVar3;
                    gVar2.f3095a = gVar3;
                } else if (i8 == 1) {
                    g<K, V> gVar5 = this.f3082a;
                    g<K, V> gVar6 = gVar5.f3095a;
                    this.f3082a = gVar6;
                    gVar6.f3097c = gVar5;
                    gVar6.f3103i = gVar5.f3103i + 1;
                    gVar5.f3095a = gVar6;
                    this.f3084c = 0;
                } else if (i8 == 2) {
                    this.f3084c = 0;
                }
                i6 *= 2;
            }
        }

        /* renamed from: a */
        g<K, V> m2735a() {
            g<K, V> gVar = this.f3082a;
            if (gVar.f3095a == null) {
                return gVar;
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: a */
    private void m2730a(g<K, V> gVar, boolean z) {
        while (gVar != null) {
            g<K, V> gVar2 = gVar.f3096b;
            g<K, V> gVar3 = gVar.f3097c;
            int i2 = gVar2 != null ? gVar2.f3103i : 0;
            int i3 = gVar3 != null ? gVar3.f3103i : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                g<K, V> gVar4 = gVar3.f3096b;
                g<K, V> gVar5 = gVar3.f3097c;
                int i5 = (gVar4 != null ? gVar4.f3103i : 0) - (gVar5 != null ? gVar5.f3103i : 0);
                if (i5 != -1 && (i5 != 0 || z)) {
                    m2733b(gVar3);
                    m2728a(gVar);
                } else {
                    m2728a(gVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 2) {
                g<K, V> gVar6 = gVar2.f3096b;
                g<K, V> gVar7 = gVar2.f3097c;
                int i6 = (gVar6 != null ? gVar6.f3103i : 0) - (gVar7 != null ? gVar7.f3103i : 0);
                if (i6 != 1 && (i6 != 0 || z)) {
                    m2728a(gVar2);
                    m2733b(gVar);
                } else {
                    m2733b(gVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 0) {
                gVar.f3103i = i2 + 1;
                if (z) {
                    return;
                }
            } else {
                gVar.f3103i = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            gVar = gVar.f3095a;
        }
    }

    /* renamed from: b */
    private void m2732b() {
        this.table = doubleCapacity(this.table);
        g<K, V>[] gVarArr = this.table;
        this.threshold = (gVarArr.length / 2) + (gVarArr.length / 4);
    }

    /* renamed from: a */
    private void m2728a(g<K, V> gVar) {
        g<K, V> gVar2 = gVar.f3096b;
        g<K, V> gVar3 = gVar.f3097c;
        g<K, V> gVar4 = gVar3.f3096b;
        g<K, V> gVar5 = gVar3.f3097c;
        gVar.f3097c = gVar4;
        if (gVar4 != null) {
            gVar4.f3095a = gVar;
        }
        m2729a((g) gVar, (g) gVar3);
        gVar3.f3096b = gVar;
        gVar.f3095a = gVar3;
        gVar.f3103i = Math.max(gVar2 != null ? gVar2.f3103i : 0, gVar4 != null ? gVar4.f3103i : 0) + 1;
        gVar3.f3103i = Math.max(gVar.f3103i, gVar5 != null ? gVar5.f3103i : 0) + 1;
    }
}
