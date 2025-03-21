package p286h.p289g2;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import p286h.InterfaceC5610t0;
import p286h.p309q2.p311t.p312q1.InterfaceC5575g;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: AbstractMutableMap.kt */
@InterfaceC5610t0(version = "1.1")
/* renamed from: h.g2.h */
/* loaded from: classes2.dex */
public abstract class AbstractC5264h<K, V> extends AbstractMap<K, V> implements Map<K, V>, InterfaceC5575g {
    protected AbstractC5264h() {
    }

    /* renamed from: b */
    public abstract Set m19956b();

    /* renamed from: c */
    public /* bridge */ Set m19957c() {
        return super.keySet();
    }

    /* renamed from: d */
    public /* bridge */ int m19958d() {
        return super.size();
    }

    /* renamed from: e */
    public /* bridge */ Collection m19959e() {
        return super.values();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return m19956b();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return m19957c();
    }

    @Override // java.util.AbstractMap, java.util.Map
    @InterfaceC5817e
    public abstract V put(K k2, V v);

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return m19958d();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<V> values() {
        return m19959e();
    }
}
