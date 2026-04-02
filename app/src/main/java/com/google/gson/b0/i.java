package com.google.gson.b0;

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

/* JADX INFO: compiled from: LinkedTreeMap.java */
/* JADX INFO: loaded from: classes.dex */
public final class i<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> a = new a();
    private final boolean allowNullValues;
    private final Comparator<? super K> comparator;
    private i<K, V>.b entrySet;
    final e<K, V> header;
    private i<K, V>.c keySet;
    int modCount;
    e<K, V> root;
    int size;

    /* JADX INFO: compiled from: LinkedTreeMap.java */
    class a implements Comparator<Comparable> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* JADX INFO: compiled from: LinkedTreeMap.java */
    class b extends AbstractSet<Map.Entry<K, V>> {

        /* JADX INFO: compiled from: LinkedTreeMap.java */
        class a extends i<K, V>.d<Map.Entry<K, V>> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            i.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && i.this.findByEntry((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> eVarFindByEntry;
            if (!(obj instanceof Map.Entry) || (eVarFindByEntry = i.this.findByEntry((Map.Entry) obj)) == null) {
                return false;
            }
            i.this.removeInternal(eVarFindByEntry, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return i.this.size;
        }
    }

    /* JADX INFO: compiled from: LinkedTreeMap.java */
    final class c extends AbstractSet<K> {

        /* JADX INFO: compiled from: LinkedTreeMap.java */
        class a extends i<K, V>.d<K> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().f3668f;
            }
        }

        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            i.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return i.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return i.this.removeInternalByKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return i.this.size;
        }
    }

    /* JADX INFO: compiled from: LinkedTreeMap.java */
    private abstract class d<T> implements Iterator<T> {
        e<K, V> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        e<K, V> f3661b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f3662c;

        d() {
            i iVar = i.this;
            this.a = iVar.header.f3666d;
            this.f3661b = null;
            this.f3662c = iVar.modCount;
        }

        final e<K, V> a() {
            e<K, V> eVar = this.a;
            i iVar = i.this;
            if (eVar == iVar.header) {
                throw new NoSuchElementException();
            }
            if (iVar.modCount != this.f3662c) {
                throw new ConcurrentModificationException();
            }
            this.a = eVar.f3666d;
            this.f3661b = eVar;
            return eVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.a != i.this.header;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.f3661b;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            i.this.removeInternal(eVar, true);
            this.f3661b = null;
            this.f3662c = i.this.modCount;
        }
    }

    public i() {
        this(a, true);
    }

    private boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    private void b(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f3664b;
        e<K, V> eVar3 = eVar.f3665c;
        e<K, V> eVar4 = eVar2.f3664b;
        e<K, V> eVar5 = eVar2.f3665c;
        eVar.f3664b = eVar5;
        if (eVar5 != null) {
            eVar5.a = eVar;
        }
        a((e) eVar, (e) eVar2);
        eVar2.f3665c = eVar;
        eVar.a = eVar2;
        eVar.f3671i = Math.max(eVar3 != null ? eVar3.f3671i : 0, eVar5 != null ? eVar5.f3671i : 0) + 1;
        eVar2.f3671i = Math.max(eVar.f3671i, eVar4 != null ? eVar4.f3671i : 0) + 1;
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
        eVar.f3667e = eVar;
        eVar.f3666d = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        i<K, V>.b bVar = this.entrySet;
        if (bVar != null) {
            return bVar;
        }
        i<K, V>.b bVar2 = new b();
        this.entrySet = bVar2;
        return bVar2;
    }

    e<K, V> find(K k2, boolean z) {
        int iCompareTo;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.comparator;
        e<K, V> eVar2 = this.root;
        if (eVar2 != null) {
            Comparable comparable = comparator == a ? (Comparable) k2 : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(eVar2.f3668f) : comparator.compare(k2, eVar2.f3668f);
                if (iCompareTo == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = iCompareTo < 0 ? eVar2.f3664b : eVar2.f3665c;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            iCompareTo = 0;
        }
        if (!z) {
            return null;
        }
        e<K, V> eVar4 = this.header;
        if (eVar2 != null) {
            eVar = new e<>(this.allowNullValues, eVar2, k2, eVar4, eVar4.f3667e);
            if (iCompareTo < 0) {
                eVar2.f3664b = eVar;
            } else {
                eVar2.f3665c = eVar;
            }
            a((e) eVar2, true);
        } else {
            if (comparator == a && !(k2 instanceof Comparable)) {
                throw new ClassCastException(k2.getClass().getName() + " is not Comparable");
            }
            eVar = new e<>(this.allowNullValues, eVar2, k2, eVar4, eVar4.f3667e);
            this.root = eVar;
        }
        this.size++;
        this.modCount++;
        return eVar;
    }

    e<K, V> findByEntry(Map.Entry<?, ?> entry) {
        e<K, V> eVarFindByObject = findByObject(entry.getKey());
        if (eVarFindByObject != null && a(eVarFindByObject.f3670h, entry.getValue())) {
            return eVarFindByObject;
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
        e<K, V> eVarFindByObject = findByObject(obj);
        if (eVarFindByObject != null) {
            return eVarFindByObject.f3670h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        i<K, V>.c cVar = this.keySet;
        if (cVar != null) {
            return cVar;
        }
        i<K, V>.c cVar2 = new c();
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
        e<K, V> eVarFind = find(k2, true);
        V v2 = eVarFind.f3670h;
        eVarFind.f3670h = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> eVarRemoveInternalByKey = removeInternalByKey(obj);
        if (eVarRemoveInternalByKey != null) {
            return eVarRemoveInternalByKey.f3670h;
        }
        return null;
    }

    void removeInternal(e<K, V> eVar, boolean z) {
        int i2;
        if (z) {
            e<K, V> eVar2 = eVar.f3667e;
            eVar2.f3666d = eVar.f3666d;
            eVar.f3666d.f3667e = eVar2;
        }
        e<K, V> eVar3 = eVar.f3664b;
        e<K, V> eVar4 = eVar.f3665c;
        e<K, V> eVar5 = eVar.a;
        int i3 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                a((e) eVar, (e) eVar3);
                eVar.f3664b = null;
            } else if (eVar4 != null) {
                a((e) eVar, (e) eVar4);
                eVar.f3665c = null;
            } else {
                a((e) eVar, (e) null);
            }
            a((e) eVar5, false);
            this.size--;
            this.modCount++;
            return;
        }
        e<K, V> eVarB = eVar3.f3671i > eVar4.f3671i ? eVar3.b() : eVar4.a();
        removeInternal(eVarB, false);
        e<K, V> eVar6 = eVar.f3664b;
        if (eVar6 != null) {
            i2 = eVar6.f3671i;
            eVarB.f3664b = eVar6;
            eVar6.a = eVarB;
            eVar.f3664b = null;
        } else {
            i2 = 0;
        }
        e<K, V> eVar7 = eVar.f3665c;
        if (eVar7 != null) {
            i3 = eVar7.f3671i;
            eVarB.f3665c = eVar7;
            eVar7.a = eVarB;
            eVar.f3665c = null;
        }
        eVarB.f3671i = Math.max(i2, i3) + 1;
        a((e) eVar, (e) eVarB);
    }

    e<K, V> removeInternalByKey(Object obj) {
        e<K, V> eVarFindByObject = findByObject(obj);
        if (eVarFindByObject != null) {
            removeInternal(eVarFindByObject, true);
        }
        return eVarFindByObject;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public i(boolean z) {
        this(a, z);
    }

    private void a(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.a;
        eVar.a = null;
        if (eVar2 != null) {
            eVar2.a = eVar3;
        }
        if (eVar3 == null) {
            this.root = eVar2;
        } else if (eVar3.f3664b == eVar) {
            eVar3.f3664b = eVar2;
        } else {
            eVar3.f3665c = eVar2;
        }
    }

    public i(Comparator<? super K> comparator, boolean z) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator == null ? a : comparator;
        this.allowNullValues = z;
        this.header = new e<>(z);
    }

    /* JADX INFO: compiled from: LinkedTreeMap.java */
    static final class e<K, V> implements Map.Entry<K, V> {
        e<K, V> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        e<K, V> f3664b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        e<K, V> f3665c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        e<K, V> f3666d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        e<K, V> f3667e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final K f3668f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final boolean f3669g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        V f3670h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f3671i;

        e(boolean z) {
            this.f3668f = null;
            this.f3669g = z;
            this.f3667e = this;
            this.f3666d = this;
        }

        public e<K, V> a() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f3664b; eVar2 != null; eVar2 = eVar2.f3664b) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e<K, V> b() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f3665c; eVar2 != null; eVar2 = eVar2.f3665c) {
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
            K k2 = this.f3668f;
            if (k2 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k2.equals(entry.getKey())) {
                return false;
            }
            V v = this.f3670h;
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
            return this.f3668f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f3670h;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k2 = this.f3668f;
            int iHashCode = k2 == null ? 0 : k2.hashCode();
            V v = this.f3670h;
            return iHashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (v == null && !this.f3669g) {
                throw new NullPointerException("value == null");
            }
            V v2 = this.f3670h;
            this.f3670h = v;
            return v2;
        }

        public String toString() {
            return this.f3668f + ContainerUtils.KEY_VALUE_DELIMITER + this.f3670h;
        }

        e(boolean z, e<K, V> eVar, K k2, e<K, V> eVar2, e<K, V> eVar3) {
            this.a = eVar;
            this.f3668f = k2;
            this.f3669g = z;
            this.f3671i = 1;
            this.f3666d = eVar2;
            this.f3667e = eVar3;
            eVar3.f3666d = this;
            eVar2.f3667e = this;
        }
    }

    private void a(e<K, V> eVar, boolean z) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.f3664b;
            e<K, V> eVar3 = eVar.f3665c;
            int i2 = eVar2 != null ? eVar2.f3671i : 0;
            int i3 = eVar3 != null ? eVar3.f3671i : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                e<K, V> eVar4 = eVar3.f3664b;
                e<K, V> eVar5 = eVar3.f3665c;
                int i5 = (eVar4 != null ? eVar4.f3671i : 0) - (eVar5 != null ? eVar5.f3671i : 0);
                if (i5 != -1 && (i5 != 0 || z)) {
                    b(eVar3);
                    a(eVar);
                } else {
                    a(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 2) {
                e<K, V> eVar6 = eVar2.f3664b;
                e<K, V> eVar7 = eVar2.f3665c;
                int i6 = (eVar6 != null ? eVar6.f3671i : 0) - (eVar7 != null ? eVar7.f3671i : 0);
                if (i6 != 1 && (i6 != 0 || z)) {
                    a(eVar2);
                    b(eVar);
                } else {
                    b(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 0) {
                eVar.f3671i = i2 + 1;
                if (z) {
                    return;
                }
            } else {
                eVar.f3671i = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            eVar = eVar.a;
        }
    }

    private void a(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f3664b;
        e<K, V> eVar3 = eVar.f3665c;
        e<K, V> eVar4 = eVar3.f3664b;
        e<K, V> eVar5 = eVar3.f3665c;
        eVar.f3665c = eVar4;
        if (eVar4 != null) {
            eVar4.a = eVar;
        }
        a((e) eVar, (e) eVar3);
        eVar3.f3664b = eVar;
        eVar.a = eVar3;
        eVar.f3671i = Math.max(eVar2 != null ? eVar2.f3671i : 0, eVar4 != null ? eVar4.f3671i : 0) + 1;
        eVar3.f3671i = Math.max(eVar.f3671i, eVar5 != null ? eVar5.f3671i : 0) + 1;
    }
}
