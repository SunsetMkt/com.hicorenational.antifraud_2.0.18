package com.google.gson.p147b0.p148q;

import com.google.gson.AbstractC2063k;
import com.google.gson.AbstractC2077y;
import com.google.gson.C2051e;
import com.google.gson.C2066n;
import com.google.gson.InterfaceC2061i;
import com.google.gson.InterfaceC2062j;
import com.google.gson.InterfaceC2069q;
import com.google.gson.InterfaceC2070r;
import com.google.gson.InterfaceC2078z;
import com.google.gson.p147b0.C2008a;
import com.google.gson.p147b0.C2022o;
import com.google.gson.p152d0.C2049a;
import com.google.gson.p153e0.C2052a;
import com.google.gson.p153e0.C2055d;
import java.io.IOException;
import java.lang.reflect.Type;

/* compiled from: TreeTypeAdapter.java */
/* renamed from: com.google.gson.b0.q.m */
/* loaded from: classes.dex */
public final class C2036m<T> extends AbstractC2035l<T> {

    /* renamed from: a */
    private final InterfaceC2070r<T> f5785a;

    /* renamed from: b */
    private final InterfaceC2062j<T> f5786b;

    /* renamed from: c */
    final C2051e f5787c;

    /* renamed from: d */
    private final C2049a<T> f5788d;

    /* renamed from: e */
    private final InterfaceC2078z f5789e;

    /* renamed from: f */
    private final C2036m<T>.b f5790f;

    /* renamed from: g */
    private final boolean f5791g;

    /* renamed from: h */
    private volatile AbstractC2077y<T> f5792h;

    /* compiled from: TreeTypeAdapter.java */
    /* renamed from: com.google.gson.b0.q.m$b */
    private final class b implements InterfaceC2069q, InterfaceC2061i {
        private b() {
        }

        @Override // com.google.gson.InterfaceC2069q
        /* renamed from: a */
        public AbstractC2063k mo5478a(Object obj) {
            return C2036m.this.f5787c.m5580b(obj);
        }

        @Override // com.google.gson.InterfaceC2069q
        /* renamed from: a */
        public AbstractC2063k mo5479a(Object obj, Type type) {
            return C2036m.this.f5787c.m5581b(obj, type);
        }

        @Override // com.google.gson.InterfaceC2061i
        /* renamed from: a */
        public <R> R mo5480a(AbstractC2063k abstractC2063k, Type type) throws C2066n {
            return (R) C2036m.this.f5787c.m5564a(abstractC2063k, type);
        }
    }

    /* compiled from: TreeTypeAdapter.java */
    /* renamed from: com.google.gson.b0.q.m$c */
    private static final class c implements InterfaceC2078z {

        /* renamed from: a */
        private final C2049a<?> f5794a;

        /* renamed from: b */
        private final boolean f5795b;

        /* renamed from: c */
        private final Class<?> f5796c;

        /* renamed from: d */
        private final InterfaceC2070r<?> f5797d;

        /* renamed from: e */
        private final InterfaceC2062j<?> f5798e;

        c(Object obj, C2049a<?> c2049a, boolean z, Class<?> cls) {
            this.f5797d = obj instanceof InterfaceC2070r ? (InterfaceC2070r) obj : null;
            this.f5798e = obj instanceof InterfaceC2062j ? (InterfaceC2062j) obj : null;
            C2008a.m5311a((this.f5797d == null && this.f5798e == null) ? false : true);
            this.f5794a = c2049a;
            this.f5795b = z;
            this.f5796c = cls;
        }

        @Override // com.google.gson.InterfaceC2078z
        public <T> AbstractC2077y<T> create(C2051e c2051e, C2049a<T> c2049a) {
            C2049a<?> c2049a2 = this.f5794a;
            if (c2049a2 != null ? c2049a2.equals(c2049a) || (this.f5795b && this.f5794a.getType() == c2049a.getRawType()) : this.f5796c.isAssignableFrom(c2049a.getRawType())) {
                return new C2036m(this.f5797d, this.f5798e, c2051e, c2049a, this);
            }
            return null;
        }
    }

    public C2036m(InterfaceC2070r<T> interfaceC2070r, InterfaceC2062j<T> interfaceC2062j, C2051e c2051e, C2049a<T> c2049a, InterfaceC2078z interfaceC2078z, boolean z) {
        this.f5790f = new b();
        this.f5785a = interfaceC2070r;
        this.f5786b = interfaceC2062j;
        this.f5787c = c2051e;
        this.f5788d = c2049a;
        this.f5789e = interfaceC2078z;
        this.f5791g = z;
    }

    /* renamed from: b */
    private AbstractC2077y<T> m5476b() {
        AbstractC2077y<T> abstractC2077y = this.f5792h;
        if (abstractC2077y != null) {
            return abstractC2077y;
        }
        AbstractC2077y<T> m5558a = this.f5787c.m5558a(this.f5789e, this.f5788d);
        this.f5792h = m5558a;
        return m5558a;
    }

    @Override // com.google.gson.p147b0.p148q.AbstractC2035l
    /* renamed from: a */
    public AbstractC2077y<T> mo5473a() {
        return this.f5785a != null ? this : m5476b();
    }

    @Override // com.google.gson.AbstractC2077y
    /* renamed from: read */
    public T read2(C2052a c2052a) throws IOException {
        if (this.f5786b == null) {
            return m5476b().read2(c2052a);
        }
        AbstractC2063k m5390a = C2022o.m5390a(c2052a);
        if (this.f5791g && m5390a.isJsonNull()) {
            return null;
        }
        return this.f5786b.m5671a(m5390a, this.f5788d.getType(), this.f5790f);
    }

    @Override // com.google.gson.AbstractC2077y
    public void write(C2055d c2055d, T t) throws IOException {
        if (this.f5785a == null) {
            m5476b().write(c2055d, t);
        } else if (this.f5791g && t == null) {
            c2055d.mo5448j();
        } else {
            C2022o.m5392a(this.f5785a.m5682a(t, this.f5788d.getType(), this.f5790f), c2055d);
        }
    }

    /* renamed from: a */
    public static InterfaceC2078z m5474a(C2049a<?> c2049a, Object obj) {
        return new c(obj, c2049a, false, null);
    }

    /* renamed from: a */
    public static InterfaceC2078z m5475a(Class<?> cls, Object obj) {
        return new c(obj, null, false, cls);
    }

    /* renamed from: b */
    public static InterfaceC2078z m5477b(C2049a<?> c2049a, Object obj) {
        return new c(obj, c2049a, c2049a.getType() == c2049a.getRawType(), null);
    }

    public C2036m(InterfaceC2070r<T> interfaceC2070r, InterfaceC2062j<T> interfaceC2062j, C2051e c2051e, C2049a<T> c2049a, InterfaceC2078z interfaceC2078z) {
        this(interfaceC2070r, interfaceC2062j, c2051e, c2049a, interfaceC2078z, true);
    }
}
