package com.google.gson.p147b0;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* compiled from: LinkedTreeMap.java */
/* renamed from: com.google.gson.b0.i */
/* loaded from: classes.dex */
public final class C2016i<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* renamed from: a */
    private static final Comparator<Comparable> f5688a = new a();
    private final boolean allowNullValues;
    private final Comparator<? super K> comparator;
    private C2016i<K, V>.b entrySet;
    final e<K, V> header;
    private C2016i<K, V>.c keySet;
    int modCount;
    e<K, V> root;
    int size;

    /* compiled from: LinkedTreeMap.java */
    /* renamed from: com.google.gson.b0.i$a */
    class a implements Comparator<Comparable> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* compiled from: LinkedTreeMap.java */
    /* renamed from: com.google.gson.b0.i$b */
    class b extends AbstractSet<Map.Entry<K, V>> {

        /* compiled from: LinkedTreeMap.java */
        /* renamed from: com.google.gson.b0.i$b$a */
        class a extends C2016i<K, V>.d<Map.Entry<K, V>> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                return m5369a();
            }
        }

        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            C2016i.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && C2016i.this.findByEntry((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> findByEntry;
            if (!(obj instanceof Map.Entry) || (findByEntry = C2016i.this.findByEntry((Map.Entry) obj)) == null) {
                return false;
            }
            C2016i.this.removeInternal(findByEntry, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C2016i.this.size;
        }
    }

    /* compiled from: LinkedTreeMap.java */
    /* renamed from: com.google.gson.b0.i$c */
    final class c extends AbstractSet<K> {

        /* compiled from: LinkedTreeMap.java */
        /* renamed from: com.google.gson.b0.i$c$a */
        class a extends C2016i<K, V>.d<K> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return m5369a().f5702f;
            }
        }

        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            C2016i.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return C2016i.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return C2016i.this.removeInternalByKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C2016i.this.size;
        }
    }

    /* compiled from: LinkedTreeMap.java */
    /* renamed from: com.google.gson.b0.i$d */
    private abstract class d<T> implements Iterator<T> {

        /* renamed from: a */
        e<K, V> f5693a;

        /* renamed from: b */
        e<K, V> f5694b;

        /* renamed from: c */
        int f5695c;

        d() {
            C2016i c2016i = C2016i.this;
            this.f5693a = c2016i.header.f5700d;
            this.f5694b = null;
            this.f5695c = c2016i.modCount;
        }

        /* renamed from: a */
        final e<K, V> m5369a() {
            e<K, V> eVar = this.f5693a;
            C2016i c2016i = C2016i.this;
            if (eVar == c2016i.header) {
                throw new NoSuchElementException();
            }
            if (c2016i.modCount != this.f5695c) {
                throw new ConcurrentModificationException();
            }
            this.f5693a = eVar.f5700d;
            this.f5694b = eVar;
            return eVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f5693a != C2016i.this.header;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.f5694b;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            C2016i.this.removeInternal(eVar, true);
            this.f5694b = null;
            this.f5695c = C2016i.this.modCount;
        }
    }

    public C2016i() {
        this(f5688a, true);
    }

    /* renamed from: a */
    private boolean m5366a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    /* renamed from: b */
    private void m5367b(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f5698b;
        e<K, V> eVar3 = eVar.f5699c;
        e<K, V> eVar4 = eVar2.f5698b;
        e<K, V> eVar5 = eVar2.f5699c;
        eVar.f5698b = eVar5;
        if (eVar5 != null) {
            eVar5.f5697a = eVar;
        }
        m5364a((e) eVar, (e) eVar2);
        eVar2.f5699c = eVar;
        eVar.f5697a = eVar2;
        eVar.f5705i = Math.max(eVar3 != null ? eVar3.f5705i : 0, eVar5 != null ? eVar5.f5705i : 0) + 1;
        eVar2.f5705i = Math.max(eVar.f5705i, eVar4 != null ? eVar4.f5705i : 0) + 1;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        e<K, V> eVar = this.header;
        eVar.f5701e = eVar;
        eVar.f5700d = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        C2016i<K, V>.b bVar = this.entrySet;
        if (bVar != null) {
            return bVar;
        }
        C2016i<K, V>.b bVar2 = new b();
        this.entrySet = bVar2;
        return bVar2;
    }

    e<K, V> find(K k2, boolean z) {
        int i2;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.comparator;
        e<K, V> eVar2 = this.root;
        if (eVar2 != null) {
            Comparable comparable = comparator == f5688a ? (Comparable) k2 : null;
            while (true) {
                i2 = comparable != null ? comparable.compareTo(eVar2.f5702f) : comparator.compare(k2, eVar2.f5702f);
                if (i2 == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = i2 < 0 ? eVar2.f5698b : eVar2.f5699c;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            i2 = 0;
        }
        if (!z) {
            return null;
        }
        e<K, V> eVar4 = this.header;
        if (eVar2 != null) {
            eVar = new e<>(this.allowNullValues, eVar2, k2, eVar4, eVar4.f5701e);
            if (i2 < 0) {
                eVar2.f5698b = eVar;
            } else {
                eVar2.f5699c = eVar;
            }
            m5365a((e) eVar2, true);
        } else {
            if (comparator == f5688a && !(k2 instanceof Comparable)) {
                throw new ClassCastException(k2.getClass().getName() + " is not Comparable");
            }
            eVar = new e<>(this.allowNullValues, eVar2, k2, eVar4, eVar4.f5701e);
            this.root = eVar;
        }
        this.size++;
        this.modCount++;
        return eVar;
    }

    e<K, V> findByEntry(Map.Entry<?, ?> entry) {
        e<K, V> findByObject = findByObject(entry.getKey());
        if (findByObject != null && m5366a(findByObject.f5704h, entry.getValue())) {
            return findByObject;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    e<K, V> findByObject(Object obj) {
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
        e<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            return findByObject.f5704h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        C2016i<K, V>.c cVar = this.keySet;
        if (cVar != null) {
            return cVar;
        }
        C2016i<K, V>.c cVar2 = new c();
        this.keySet = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k2, V v) {
        if (k2 == null) {
            throw new NullPointerException("key == null");
        }
        if (v == null && !this.allowNullValues) {
            throw new NullPointerException("value == null");
        }
        e<K, V> find = find(k2, true);
        V v2 = find.f5704h;
        find.f5704h = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.f5704h;
        }
        return null;
    }

    void removeInternal(e<K, V> eVar, boolean z) {
        int i2;
        if (z) {
            e<K, V> eVar2 = eVar.f5701e;
            eVar2.f5700d = eVar.f5700d;
            eVar.f5700d.f5701e = eVar2;
        }
        e<K, V> eVar3 = eVar.f5698b;
        e<K, V> eVar4 = eVar.f5699c;
        e<K, V> eVar5 = eVar.f5697a;
        int i3 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                m5364a((e) eVar, (e) eVar3);
                eVar.f5698b = null;
            } else if (eVar4 != null) {
                m5364a((e) eVar, (e) eVar4);
                eVar.f5699c = null;
            } else {
                m5364a((e) eVar, (e) null);
            }
            m5365a((e) eVar5, false);
            this.size--;
            this.modCount++;
            return;
        }
        e<K, V> m5371b = eVar3.f5705i > eVar4.f5705i ? eVar3.m5371b() : eVar4.m5370a();
        removeInternal(m5371b, false);
        e<K, V> eVar6 = eVar.f5698b;
        if (eVar6 != null) {
            i2 = eVar6.f5705i;
            m5371b.f5698b = eVar6;
            eVar6.f5697a = m5371b;
            eVar.f5698b = null;
        } else {
            i2 = 0;
        }
        e<K, V> eVar7 = eVar.f5699c;
        if (eVar7 != null) {
            i3 = eVar7.f5705i;
            m5371b.f5699c = eVar7;
            eVar7.f5697a = m5371b;
            eVar.f5699c = null;
        }
        m5371b.f5705i = Math.max(i2, i3) + 1;
        m5364a((e) eVar, (e) m5371b);
    }

    e<K, V> removeInternalByKey(Object obj) {
        e<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        return findByObject;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public C2016i(boolean z) {
        this(f5688a, z);
    }

    /* renamed from: a */
    private void m5364a(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.f5697a;
        eVar.f5697a = null;
        if (eVar2 != null) {
            eVar2.f5697a = eVar3;
        }
        if (eVar3 == null) {
            this.root = eVar2;
        } else if (eVar3.f5698b == eVar) {
            eVar3.f5698b = eVar2;
        } else {
            eVar3.f5699c = eVar2;
        }
    }

    public C2016i(Comparator<? super K> comparator, boolean z) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator == null ? f5688a : comparator;
        this.allowNullValues = z;
        this.header = new e<>(z);
    }

    /* compiled from: LinkedTreeMap.java */
    /* renamed from: com.google.gson.b0.i$e */
    static final class e<K, V> implements Map.Entry<K, V> {

        /* renamed from: a */
        e<K, V> f5697a;

        /* renamed from: b */
        e<K, V> f5698b;

        /* renamed from: c */
        e<K, V> f5699c;

        /* renamed from: d */
        e<K, V> f5700d;

        /* renamed from: e */
        e<K, V> f5701e;

        /* renamed from: f */
        final K f5702f;

        /* renamed from: g */
        final boolean f5703g;

        /* renamed from: h */
        V f5704h;

        /* renamed from: i */
        int f5705i;

        e(boolean z) {
            this.f5702f = null;
            this.f5703g = z;
            this.f5701e = this;
            this.f5700d = this;
        }

        /* renamed from: a */
        public e<K, V> m5370a() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f5698b; eVar2 != null; eVar2 = eVar2.f5698b) {
                eVar = eVar2;
            }
            return eVar;
        }

        /* renamed from: b */
        public e<K, V> m5371b() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f5699c; eVar2 != null; eVar2 = eVar2.f5699c) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k2 = this.f5702f;
            if (k2 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k2.equals(entry.getKey())) {
                return false;
            }
            V v = this.f5704h;
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
            return this.f5702f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f5704h;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k2 = this.f5702f;
            int hashCode = k2 == null ? 0 : k2.hashCode();
            V v = this.f5704h;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (v == null && !this.f5703g) {
                throw new NullPointerException("value == null");
            }
            V v2 = this.f5704h;
            this.f5704h = v;
            return v2;
        }

        public String toString() {
            return this.f5702f + ContainerUtils.KEY_VALUE_DELIMITER + this.f5704h;
        }

        e(boolean z, e<K, V> eVar, K k2, e<K, V> eVar2, e<K, V> eVar3) {
            this.f5697a = eVar;
            this.f5702f = k2;
            this.f5703g = z;
            this.f5705i = 1;
            this.f5700d = eVar2;
            this.f5701e = eVar3;
            eVar3.f5700d = this;
            eVar2.f5701e = this;
        }
    }

    /* renamed from: a */
    private void m5365a(e<K, V> eVar, boolean z) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.f5698b;
            e<K, V> eVar3 = eVar.f5699c;
            int i2 = eVar2 != null ? eVar2.f5705i : 0;
            int i3 = eVar3 != null ? eVar3.f5705i : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                e<K, V> eVar4 = eVar3.f5698b;
                e<K, V> eVar5 = eVar3.f5699c;
                int i5 = (eVar4 != null ? eVar4.f5705i : 0) - (eVar5 != null ? eVar5.f5705i : 0);
                if (i5 != -1 && (i5 != 0 || z)) {
                    m5367b(eVar3);
                    m5363a(eVar);
                } else {
                    m5363a(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 2) {
                e<K, V> eVar6 = eVar2.f5698b;
                e<K, V> eVar7 = eVar2.f5699c;
                int i6 = (eVar6 != null ? eVar6.f5705i : 0) - (eVar7 != null ? eVar7.f5705i : 0);
                if (i6 != 1 && (i6 != 0 || z)) {
                    m5363a(eVar2);
                    m5367b(eVar);
                } else {
                    m5367b(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 0) {
                eVar.f5705i = i2 + 1;
                if (z) {
                    return;
                }
            } else {
                eVar.f5705i = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            eVar = eVar.f5697a;
        }
    }

    /* renamed from: a */
    private void m5363a(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f5698b;
        e<K, V> eVar3 = eVar.f5699c;
        e<K, V> eVar4 = eVar3.f5698b;
        e<K, V> eVar5 = eVar3.f5699c;
        eVar.f5699c = eVar4;
        if (eVar4 != null) {
            eVar4.f5697a = eVar;
        }
        m5364a((e) eVar, (e) eVar3);
        eVar3.f5698b = eVar;
        eVar.f5697a = eVar3;
        eVar.f5705i = Math.max(eVar2 != null ? eVar2.f5705i : 0, eVar4 != null ? eVar4.f5705i : 0) + 1;
        eVar3.f5705i = Math.max(eVar.f5705i, eVar5 != null ? eVar5.f5705i : 0) + 1;
    }
}
