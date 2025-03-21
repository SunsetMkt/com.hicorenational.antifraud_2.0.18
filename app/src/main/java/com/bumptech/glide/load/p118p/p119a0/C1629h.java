package com.bumptech.glide.load.p118p.p119a0;

import androidx.annotation.Nullable;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1634m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: GroupedLinkedMap.java */
/* renamed from: com.bumptech.glide.load.p.a0.h */
/* loaded from: classes.dex */
class C1629h<K extends InterfaceC1634m, V> {

    /* renamed from: a */
    private final a<K, V> f4284a = new a<>();

    /* renamed from: b */
    private final Map<K, a<K, V>> f4285b = new HashMap();

    /* compiled from: GroupedLinkedMap.java */
    /* renamed from: com.bumptech.glide.load.p.a0.h$a */
    private static class a<K, V> {

        /* renamed from: a */
        final K f4286a;

        /* renamed from: b */
        private List<V> f4287b;

        /* renamed from: c */
        a<K, V> f4288c;

        /* renamed from: d */
        a<K, V> f4289d;

        a() {
            this(null);
        }

        @Nullable
        /* renamed from: a */
        public V m3934a() {
            int m3936b = m3936b();
            if (m3936b > 0) {
                return this.f4287b.remove(m3936b - 1);
            }
            return null;
        }

        /* renamed from: b */
        public int m3936b() {
            List<V> list = this.f4287b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        a(K k2) {
            this.f4289d = this;
            this.f4288c = this;
            this.f4286a = k2;
        }

        /* renamed from: a */
        public void m3935a(V v) {
            if (this.f4287b == null) {
                this.f4287b = new ArrayList();
            }
            this.f4287b.add(v);
        }
    }

    C1629h() {
    }

    /* renamed from: b */
    private void m3928b(a<K, V> aVar) {
        m3929c(aVar);
        a<K, V> aVar2 = this.f4284a;
        aVar.f4289d = aVar2.f4289d;
        aVar.f4288c = aVar2;
        m3930d(aVar);
    }

    /* renamed from: c */
    private static <K, V> void m3929c(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f4289d;
        aVar2.f4288c = aVar.f4288c;
        aVar.f4288c.f4289d = aVar2;
    }

    /* renamed from: d */
    private static <K, V> void m3930d(a<K, V> aVar) {
        aVar.f4288c.f4289d = aVar;
        aVar.f4289d.f4288c = aVar;
    }

    /* renamed from: a */
    public void m3933a(K k2, V v) {
        a<K, V> aVar = this.f4285b.get(k2);
        if (aVar == null) {
            aVar = new a<>(k2);
            m3928b(aVar);
            this.f4285b.put(k2, aVar);
        } else {
            k2.offer();
        }
        aVar.m3935a(v);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a aVar = this.f4284a.f4288c; !aVar.equals(this.f4284a); aVar = aVar.f4288c) {
            z = true;
            sb.append('{');
            sb.append(aVar.f4286a);
            sb.append(':');
            sb.append(aVar.m3936b());
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }

    @Nullable
    /* renamed from: a */
    public V m3932a(K k2) {
        a<K, V> aVar = this.f4285b.get(k2);
        if (aVar == null) {
            aVar = new a<>(k2);
            this.f4285b.put(k2, aVar);
        } else {
            k2.offer();
        }
        m3927a(aVar);
        return aVar.m3934a();
    }

    @Nullable
    /* renamed from: a */
    public V m3931a() {
        for (a aVar = this.f4284a.f4289d; !aVar.equals(this.f4284a); aVar = aVar.f4289d) {
            V v = (V) aVar.m3934a();
            if (v != null) {
                return v;
            }
            m3929c(aVar);
            this.f4285b.remove(aVar.f4286a);
            ((InterfaceC1634m) aVar.f4286a).offer();
        }
        return null;
    }

    /* renamed from: a */
    private void m3927a(a<K, V> aVar) {
        m3929c(aVar);
        a<K, V> aVar2 = this.f4284a;
        aVar.f4289d = aVar2;
        aVar.f4288c = aVar2.f4288c;
        m3930d(aVar);
    }
}
