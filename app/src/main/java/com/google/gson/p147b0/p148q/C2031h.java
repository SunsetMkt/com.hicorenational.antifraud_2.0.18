package com.google.gson.p147b0.p148q;

import com.google.gson.AbstractC2063k;
import com.google.gson.AbstractC2077y;
import com.google.gson.C2051e;
import com.google.gson.C2068p;
import com.google.gson.C2072t;
import com.google.gson.InterfaceC2078z;
import com.google.gson.p147b0.AbstractC2014g;
import com.google.gson.p147b0.C2009b;
import com.google.gson.p147b0.C2010c;
import com.google.gson.p147b0.C2022o;
import com.google.gson.p147b0.InterfaceC2018k;
import com.google.gson.p152d0.C2049a;
import com.google.gson.p153e0.C2052a;
import com.google.gson.p153e0.C2055d;
import com.google.gson.p153e0.EnumC2054c;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: MapTypeAdapterFactory.java */
/* renamed from: com.google.gson.b0.q.h */
/* loaded from: classes.dex */
public final class C2031h implements InterfaceC2078z {

    /* renamed from: a */
    private final C2010c f5745a;

    /* renamed from: b */
    final boolean f5746b;

    /* compiled from: MapTypeAdapterFactory.java */
    /* renamed from: com.google.gson.b0.q.h$a */
    private final class a<K, V> extends AbstractC2077y<Map<K, V>> {

        /* renamed from: a */
        private final AbstractC2077y<K> f5747a;

        /* renamed from: b */
        private final AbstractC2077y<V> f5748b;

        /* renamed from: c */
        private final InterfaceC2018k<? extends Map<K, V>> f5749c;

        public a(C2051e c2051e, Type type, AbstractC2077y<K> abstractC2077y, Type type2, AbstractC2077y<V> abstractC2077y2, InterfaceC2018k<? extends Map<K, V>> interfaceC2018k) {
            this.f5747a = new C2037n(c2051e, abstractC2077y, type);
            this.f5748b = new C2037n(c2051e, abstractC2077y2, type2);
            this.f5749c = interfaceC2018k;
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(C2055d c2055d, Map<K, V> map) throws IOException {
            if (map == null) {
                c2055d.mo5448j();
                return;
            }
            if (!C2031h.this.f5746b) {
                c2055d.mo5443d();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    c2055d.mo5441b(String.valueOf(entry.getKey()));
                    this.f5748b.write(c2055d, entry.getValue());
                }
                c2055d.mo5447f();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i2 = 0;
            boolean z = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                AbstractC2063k jsonTree = this.f5747a.toJsonTree(entry2.getKey());
                arrayList.add(jsonTree);
                arrayList2.add(entry2.getValue());
                z |= jsonTree.isJsonArray() || jsonTree.isJsonObject();
            }
            if (!z) {
                c2055d.mo5443d();
                int size = arrayList.size();
                while (i2 < size) {
                    c2055d.mo5441b(m5451a((AbstractC2063k) arrayList.get(i2)));
                    this.f5748b.write(c2055d, arrayList2.get(i2));
                    i2++;
                }
                c2055d.mo5447f();
                return;
            }
            c2055d.mo5442c();
            int size2 = arrayList.size();
            while (i2 < size2) {
                c2055d.mo5442c();
                C2022o.m5392a((AbstractC2063k) arrayList.get(i2), c2055d);
                this.f5748b.write(c2055d, arrayList2.get(i2));
                c2055d.mo5446e();
                i2++;
            }
            c2055d.mo5446e();
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: read */
        public Map<K, V> read2(C2052a c2052a) throws IOException {
            EnumC2054c peek = c2052a.peek();
            if (peek == EnumC2054c.NULL) {
                c2052a.mo5429r();
                return null;
            }
            Map<K, V> mo5339a = this.f5749c.mo5339a();
            if (peek == EnumC2054c.BEGIN_ARRAY) {
                c2052a.mo5417c();
                while (c2052a.mo5423j()) {
                    c2052a.mo5417c();
                    K read2 = this.f5747a.read2(c2052a);
                    if (mo5339a.put(read2, this.f5748b.read2(c2052a)) != null) {
                        throw new C2072t("duplicate key: " + read2);
                    }
                    c2052a.mo5419f();
                }
                c2052a.mo5419f();
            } else {
                c2052a.mo5418d();
                while (c2052a.mo5423j()) {
                    AbstractC2014g.f5687a.mo5362a(c2052a);
                    K read22 = this.f5747a.read2(c2052a);
                    if (mo5339a.put(read22, this.f5748b.read2(c2052a)) != null) {
                        throw new C2072t("duplicate key: " + read22);
                    }
                }
                c2052a.mo5420g();
            }
            return mo5339a;
        }

        /* renamed from: a */
        private String m5451a(AbstractC2063k abstractC2063k) {
            if (abstractC2063k.isJsonPrimitive()) {
                C2068p asJsonPrimitive = abstractC2063k.getAsJsonPrimitive();
                if (asJsonPrimitive.m5680b()) {
                    return String.valueOf(asJsonPrimitive.getAsNumber());
                }
                if (asJsonPrimitive.m5679a()) {
                    return Boolean.toString(asJsonPrimitive.getAsBoolean());
                }
                if (asJsonPrimitive.m5681c()) {
                    return asJsonPrimitive.getAsString();
                }
                throw new AssertionError();
            }
            if (abstractC2063k.isJsonNull()) {
                return AbstractC1191a.f2571h;
            }
            throw new AssertionError();
        }
    }

    public C2031h(C2010c c2010c, boolean z) {
        this.f5745a = c2010c;
        this.f5746b = z;
    }

    /* renamed from: a */
    private AbstractC2077y<?> m5450a(C2051e c2051e, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? C2038o.f5831f : c2051e.m5557a((C2049a) C2049a.get(type));
    }

    @Override // com.google.gson.InterfaceC2078z
    public <T> AbstractC2077y<T> create(C2051e c2051e, C2049a<T> c2049a) {
        Type type = c2049a.getType();
        Class<? super T> rawType = c2049a.getRawType();
        if (!Map.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type[] m5325b = C2009b.m5325b(type, rawType);
        return new a(c2051e, m5325b[0], m5450a(c2051e, m5325b[0]), m5325b[1], c2051e.m5557a((C2049a) C2049a.get(m5325b[1])), this.f5745a.m5338a(c2049a));
    }
}
