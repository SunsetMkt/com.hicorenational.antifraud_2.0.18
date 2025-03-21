package p286h.p289g2;

import bean.SurveyH5Bean;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Maps.kt */
/* renamed from: h.g2.k0 */
/* loaded from: classes2.dex */
final class C5274k0 implements Map, Serializable, InterfaceC5569a {
    public static final C5274k0 INSTANCE = new C5274k0();
    private static final long serialVersionUID = 8246714829545688274L;

    private C5274k0() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean containsKey(@InterfaceC5817e Object obj) {
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof Void) {
            return containsValue((Void) obj);
        }
        return false;
    }

    public boolean containsValue(@InterfaceC5816d Void r2) {
        C5544i0.m22546f(r2, SurveyH5Bean.VALUE);
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(@InterfaceC5817e Object obj) {
        return (obj instanceof Map) && ((Map) obj).isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Object get(Object obj) {
        return get(obj);
    }

    @Override // java.util.Map
    @InterfaceC5817e
    public Void get(@InterfaceC5817e Object obj) {
        return null;
    }

    @InterfaceC5816d
    public Set<Map.Entry> getEntries() {
        return C5277l0.INSTANCE;
    }

    @InterfaceC5816d
    public Set<Object> getKeys() {
        return C5277l0.INSTANCE;
    }

    public int getSize() {
        return 0;
    }

    @InterfaceC5816d
    public Collection getValues() {
        return C5271j0.INSTANCE;
    }

    @Override // java.util.Map
    public int hashCode() {
        return 0;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Object> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Void put(Object obj, Void r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @InterfaceC5816d
    public String toString() {
        return "{}";
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return getValues();
    }
}
