package p286h.p289g2;

import com.taobao.accs.AccsClientConfig;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: MapWithDefault.kt */
/* renamed from: h.g2.g1 */
/* loaded from: classes2.dex */
final class C5263g1<K, V> implements InterfaceC5260f1<K, V> {

    /* renamed from: a */
    @InterfaceC5816d
    private final Map<K, V> f20123a;

    /* renamed from: b */
    private final InterfaceC5506l<K, V> f20124b;

    /* JADX WARN: Multi-variable type inference failed */
    public C5263g1(@InterfaceC5816d Map<K, V> map, @InterfaceC5816d InterfaceC5506l<? super K, ? extends V> interfaceC5506l) {
        C5544i0.m22546f(map, "map");
        C5544i0.m22546f(interfaceC5506l, AccsClientConfig.DEFAULT_CONFIGTAG);
        this.f20123a = map;
        this.f20124b = interfaceC5506l;
    }

    @Override // p286h.p289g2.InterfaceC5260f1, p286h.p289g2.InterfaceC5313x0
    @InterfaceC5816d
    /* renamed from: a */
    public Map<K, V> mo19739a() {
        return this.f20123a;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public Set<Map.Entry<K, V>> m19952b() {
        return mo19739a().entrySet();
    }

    @InterfaceC5816d
    /* renamed from: c */
    public Set<K> m19953c() {
        return mo19739a().keySet();
    }

    @Override // java.util.Map
    public void clear() {
        mo19739a().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return mo19739a().containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return mo19739a().containsValue(obj);
    }

    /* renamed from: d */
    public int m19954d() {
        return mo19739a().size();
    }

    @InterfaceC5816d
    /* renamed from: e */
    public Collection<V> m19955e() {
        return mo19739a().values();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return m19952b();
    }

    @Override // java.util.Map
    public boolean equals(@InterfaceC5817e Object obj) {
        return mo19739a().equals(obj);
    }

    @Override // java.util.Map
    @InterfaceC5817e
    public V get(Object obj) {
        return mo19739a().get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return mo19739a().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return mo19739a().isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return m19953c();
    }

    @Override // java.util.Map
    @InterfaceC5817e
    public V put(K k2, V v) {
        return mo19739a().put(k2, v);
    }

    @Override // java.util.Map
    public void putAll(@InterfaceC5816d Map<? extends K, ? extends V> map) {
        C5544i0.m22546f(map, "from");
        mo19739a().putAll(map);
    }

    @Override // java.util.Map
    @InterfaceC5817e
    public V remove(Object obj) {
        return mo19739a().remove(obj);
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return m19954d();
    }

    @InterfaceC5816d
    public String toString() {
        return mo19739a().toString();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return m19955e();
    }

    @Override // p286h.p289g2.InterfaceC5313x0
    /* renamed from: a */
    public V mo19951a(K k2) {
        Map<K, V> mo19739a = mo19739a();
        V v = mo19739a.get(k2);
        return (v != null || mo19739a.containsKey(k2)) ? v : this.f20124b.invoke(k2);
    }
}
