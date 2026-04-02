package com.bumptech.glide.load.p.a0;

import androidx.annotation.Nullable;
import com.bumptech.glide.load.p.a0.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: GroupedLinkedMap.java */
/* JADX INFO: loaded from: classes.dex */
class h<K extends m, V> {
    private final a<K, V> a = new a<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<K, a<K, V>> f2781b = new HashMap();

    /* JADX INFO: compiled from: GroupedLinkedMap.java */
    private static class a<K, V> {
        final K a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<V> f2782b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        a<K, V> f2783c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        a<K, V> f2784d;

        a() {
            this(null);
        }

        @Nullable
        public V a() {
            int iB = b();
            if (iB > 0) {
                return this.f2782b.remove(iB - 1);
            }
            return null;
        }

        public int b() {
            List<V> list = this.f2782b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        a(K k2) {
            this.f2784d = this;
            this.f2783c = this;
            this.a = k2;
        }

        public void a(V v) {
            if (this.f2782b == null) {
                this.f2782b = new ArrayList();
            }
            this.f2782b.add(v);
        }
    }

    h() {
    }

    private void b(a<K, V> aVar) {
        c(aVar);
        a<K, V> aVar2 = this.a;
        aVar.f2784d = aVar2.f2784d;
        aVar.f2783c = aVar2;
        d(aVar);
    }

    private static <K, V> void c(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f2784d;
        aVar2.f2783c = aVar.f2783c;
        aVar.f2783c.f2784d = aVar2;
    }

    private static <K, V> void d(a<K, V> aVar) {
        aVar.f2783c.f2784d = aVar;
        aVar.f2784d.f2783c = aVar;
    }

    public void a(K k2, V v) {
        a<K, V> aVar = this.f2781b.get(k2);
        if (aVar == null) {
            aVar = new a<>(k2);
            b(aVar);
            this.f2781b.put(k2, aVar);
        } else {
            k2.offer();
        }
        aVar.a(v);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a aVar = this.a.f2783c; !aVar.equals(this.a); aVar = aVar.f2783c) {
            z = true;
            sb.append('{');
            sb.append(aVar.a);
            sb.append(':');
            sb.append(aVar.b());
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }

    @Nullable
    public V a(K k2) {
        a<K, V> aVar = this.f2781b.get(k2);
        if (aVar == null) {
            aVar = new a<>(k2);
            this.f2781b.put(k2, aVar);
        } else {
            k2.offer();
        }
        a(aVar);
        return aVar.a();
    }

    @Nullable
    public V a() {
        for (a aVar = this.a.f2784d; !aVar.equals(this.a); aVar = aVar.f2784d) {
            V v = (V) aVar.a();
            if (v != null) {
                return v;
            }
            c(aVar);
            this.f2781b.remove(aVar.a);
            ((m) aVar.a).offer();
        }
        return null;
    }

    private void a(a<K, V> aVar) {
        c(aVar);
        a<K, V> aVar2 = this.a;
        aVar.f2784d = aVar2;
        aVar.f2783c = aVar2.f2783c;
        d(aVar);
    }
}
