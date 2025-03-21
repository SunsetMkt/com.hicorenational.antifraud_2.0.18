package p286h.p289g2;

import androidx.exifinterface.media.ExifInterface;
import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p286h.InterfaceC5610t0;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.AbstractC5547j0;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5586v;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: AbstractMap.kt */
@InterfaceC5610t0(version = "1.1")
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010&\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\b'\u0018\u0000 )*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003:\u0001)B\u0007\b\u0004¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0013\u001a\u00020\u00142\u0010\u0010\u0015\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0016H\u0000¢\u0006\u0002\b\u0017J\u0015\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\u0018\u0010 \u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0019\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\rH\u0016J#\u0010#\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u0014H\u0016J\b\u0010&\u001a\u00020'H\u0016J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u001fH\u0002J\u001c\u0010&\u001a\u00020'2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0016H\bR\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\bX\u0088\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006*"}, m23546d2 = {"Lkotlin/collections/AbstractMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "()V", "_keys", "", "_values", "", "keys", "getKeys", "()Ljava/util/Set;", "size", "", "getSize", "()I", "values", "getValues", "()Ljava/util/Collection;", "containsEntry", "", "entry", "", "containsEntry$kotlin_stdlib", "containsKey", "key", "(Ljava/lang/Object;)Z", "containsValue", SurveyH5Bean.VALUE, "equals", DispatchConstants.OTHER, "", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "hashCode", "implFindEntry", "(Ljava/lang/Object;)Ljava/util/Map$Entry;", "isEmpty", "toString", "", "o", "Companion", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.g2.e */
/* loaded from: classes2.dex */
public abstract class AbstractC5255e<K, V> implements Map<K, V>, InterfaceC5569a {

    /* renamed from: c */
    public static final a f20110c = new a(null);

    /* renamed from: a */
    private volatile Set<? extends K> f20111a;

    /* renamed from: b */
    private volatile Collection<? extends V> f20112b;

    /* compiled from: AbstractMap.kt */
    /* renamed from: h.g2.e$a */
    public static final class a {
        private a() {
        }

        /* renamed from: a */
        public final int m19723a(@InterfaceC5816d Map.Entry<?, ?> entry) {
            C5544i0.m22546f(entry, "e");
            Object key = entry.getKey();
            int hashCode = key != null ? key.hashCode() : 0;
            Object value = entry.getValue();
            return hashCode ^ (value != null ? value.hashCode() : 0);
        }

        @InterfaceC5816d
        /* renamed from: b */
        public final String m19725b(@InterfaceC5816d Map.Entry<?, ?> entry) {
            C5544i0.m22546f(entry, "e");
            StringBuilder sb = new StringBuilder();
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            return sb.toString();
        }

        public /* synthetic */ a(C5586v c5586v) {
            this();
        }

        /* renamed from: a */
        public final boolean m19724a(@InterfaceC5816d Map.Entry<?, ?> entry, @InterfaceC5817e Object obj) {
            C5544i0.m22546f(entry, "e");
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry2 = (Map.Entry) obj;
            return C5544i0.m22531a(entry.getKey(), entry2.getKey()) && C5544i0.m22531a(entry.getValue(), entry2.getValue());
        }
    }

    /* compiled from: AbstractMap.kt */
    @InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\tJ\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0096\u0002R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\f"}, m23546d2 = {"kotlin/collections/AbstractMap$keys$1", "Lkotlin/collections/AbstractSet;", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "iterator", "", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
    /* renamed from: h.g2.e$b */
    public static final class b extends AbstractC5270j<K> {

        /* compiled from: AbstractMap.kt */
        /* renamed from: h.g2.e$b$a */
        public static final class a implements Iterator<K>, InterfaceC5569a {

            /* renamed from: a */
            final /* synthetic */ Iterator f20114a;

            a(Iterator it) {
                this.f20114a = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f20114a.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                return (K) ((Map.Entry) this.f20114a.next()).getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

        b() {
        }

        @Override // p286h.p289g2.AbstractC5240a, java.util.Collection
        public boolean contains(Object obj) {
            return AbstractC5255e.this.containsKey(obj);
        }

        @Override // p286h.p289g2.AbstractC5240a
        public int getSize() {
            return AbstractC5255e.this.size();
        }

        @Override // p286h.p289g2.AbstractC5270j, p286h.p289g2.AbstractC5240a, java.util.Collection, java.lang.Iterable
        @InterfaceC5816d
        public Iterator<K> iterator() {
            return new a(AbstractC5255e.this.entrySet().iterator());
        }
    }

    /* compiled from: AbstractMap.kt */
    /* renamed from: h.g2.e$c */
    static final class c extends AbstractC5547j0 implements InterfaceC5506l<Map.Entry<? extends K, ? extends V>, String> {
        c() {
            super(1);
        }

        @Override // p286h.p309q2.p310s.InterfaceC5506l
        @InterfaceC5816d
        public final String invoke(@InterfaceC5816d Map.Entry<? extends K, ? extends V> entry) {
            C5544i0.m22546f(entry, "it");
            return AbstractC5255e.this.m19715b((Map.Entry) entry);
        }
    }

    /* compiled from: AbstractMap.kt */
    @InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\tJ\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0096\u0002R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\f"}, m23546d2 = {"kotlin/collections/AbstractMap$values$1", "Lkotlin/collections/AbstractCollection;", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "iterator", "", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
    /* renamed from: h.g2.e$d */
    public static final class d extends AbstractC5240a<V> {

        /* compiled from: AbstractMap.kt */
        /* renamed from: h.g2.e$d$a */
        public static final class a implements Iterator<V>, InterfaceC5569a {

            /* renamed from: a */
            final /* synthetic */ Iterator f20116a;

            a(Iterator it) {
                this.f20116a = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f20116a.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                return (V) ((Map.Entry) this.f20116a.next()).getValue();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

        d() {
        }

        @Override // p286h.p289g2.AbstractC5240a, java.util.Collection
        public boolean contains(Object obj) {
            return AbstractC5255e.this.containsValue(obj);
        }

        @Override // p286h.p289g2.AbstractC5240a
        public int getSize() {
            return AbstractC5255e.this.size();
        }

        @Override // p286h.p289g2.AbstractC5240a, java.util.Collection, java.lang.Iterable
        @InterfaceC5816d
        public Iterator<V> iterator() {
            return new a(AbstractC5255e.this.entrySet().iterator());
        }
    }

    protected AbstractC5255e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public final String m19715b(Map.Entry<? extends K, ? extends V> entry) {
        return m19717c(entry.getKey()) + ContainerUtils.KEY_VALUE_DELIMITER + m19717c(entry.getValue());
    }

    /* renamed from: b */
    public abstract Set m19719b();

    @InterfaceC5816d
    /* renamed from: c */
    public Set<K> m19720c() {
        if (this.f20111a == null) {
            this.f20111a = new b();
        }
        Set<? extends K> set = this.f20111a;
        if (set == null) {
            C5544i0.m22545f();
        }
        return set;
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return m19716b((AbstractC5255e<K, V>) obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        Set<Map.Entry<K, V>> entrySet = entrySet();
        if ((entrySet instanceof Collection) && entrySet.isEmpty()) {
            return false;
        }
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            if (C5544i0.m22531a(((Map.Entry) it.next()).getValue(), obj)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    public int m19721d() {
        return entrySet().size();
    }

    @InterfaceC5816d
    /* renamed from: e */
    public Collection<V> m19722e() {
        if (this.f20112b == null) {
            this.f20112b = new d();
        }
        Collection<? extends V> collection = this.f20112b;
        if (collection == null) {
            C5544i0.m22545f();
        }
        return collection;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return m19719b();
    }

    @Override // java.util.Map
    public boolean equals(@InterfaceC5817e Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        Set<Map.Entry<K, V>> entrySet = map.entrySet();
        if ((entrySet instanceof Collection) && entrySet.isEmpty()) {
            return true;
        }
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            if (!m19718a((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @InterfaceC5817e
    public V get(Object obj) {
        Map.Entry<K, V> m19716b = m19716b((AbstractC5255e<K, V>) obj);
        if (m19716b != null) {
            return m19716b.getValue();
        }
        return null;
    }

    @Override // java.util.Map
    public int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return m19720c();
    }

    @Override // java.util.Map
    public V put(K k2, V v) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return m19721d();
    }

    @InterfaceC5816d
    public String toString() {
        return C5262g0.m19786a(entrySet(), ", ", "{", "}", 0, null, new c(), 24, null);
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return m19722e();
    }

    /* renamed from: b */
    private final Map.Entry<K, V> m19716b(K k2) {
        Object obj;
        Iterator<T> it = entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (C5544i0.m22531a(((Map.Entry) obj).getKey(), k2)) {
                break;
            }
        }
        return (Map.Entry) obj;
    }

    /* renamed from: a */
    public final boolean m19718a(@InterfaceC5817e Map.Entry<?, ?> entry) {
        if (!(entry instanceof Map.Entry)) {
            return false;
        }
        Object key = entry.getKey();
        Object value = entry.getValue();
        V v = get(key);
        if (!C5544i0.m22531a(value, v)) {
            return false;
        }
        return v != null || containsKey(key);
    }

    /* renamed from: c */
    private final String m19717c(Object obj) {
        return obj == this ? "(this Map)" : String.valueOf(obj);
    }
}
