package com.google.gson.b0.q;

import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.y;
import com.google.gson.z;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: TreeTypeAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class m<T> extends l<T> {
    private final r<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.gson.j<T> f3718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final com.google.gson.e f3719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.gson.d0.a<T> f3720d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final z f3721e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final m<T>.b f3722f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f3723g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile y<T> f3724h;

    /* JADX INFO: compiled from: TreeTypeAdapter.java */
    private final class b implements q, com.google.gson.i {
        private b() {
        }

        @Override // com.google.gson.q
        public com.google.gson.k a(Object obj) {
            return m.this.f3719c.b(obj);
        }

        @Override // com.google.gson.q
        public com.google.gson.k a(Object obj, Type type) {
            return m.this.f3719c.b(obj, type);
        }

        @Override // com.google.gson.i
        public <R> R a(com.google.gson.k kVar, Type type) throws com.google.gson.n {
            return (R) m.this.f3719c.a(kVar, type);
        }
    }

    /* JADX INFO: compiled from: TreeTypeAdapter.java */
    private static final class c implements z {
        private final com.google.gson.d0.a<?> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f3725b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Class<?> f3726c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final r<?> f3727d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final com.google.gson.j<?> f3728e;

        c(Object obj, com.google.gson.d0.a<?> aVar, boolean z, Class<?> cls) {
            this.f3727d = obj instanceof r ? (r) obj : null;
            this.f3728e = obj instanceof com.google.gson.j ? (com.google.gson.j) obj : null;
            com.google.gson.b0.a.a((this.f3727d == null && this.f3728e == null) ? false : true);
            this.a = aVar;
            this.f3725b = z;
            this.f3726c = cls;
        }

        @Override // com.google.gson.z
        public <T> y<T> create(com.google.gson.e eVar, com.google.gson.d0.a<T> aVar) {
            com.google.gson.d0.a<?> aVar2 = this.a;
            if (aVar2 != null ? aVar2.equals(aVar) || (this.f3725b && this.a.getType() == aVar.getRawType()) : this.f3726c.isAssignableFrom(aVar.getRawType())) {
                return new m(this.f3727d, this.f3728e, eVar, aVar, this);
            }
            return null;
        }
    }

    public m(r<T> rVar, com.google.gson.j<T> jVar, com.google.gson.e eVar, com.google.gson.d0.a<T> aVar, z zVar, boolean z) {
        this.f3722f = new b();
        this.a = rVar;
        this.f3718b = jVar;
        this.f3719c = eVar;
        this.f3720d = aVar;
        this.f3721e = zVar;
        this.f3723g = z;
    }

    private y<T> b() {
        y<T> yVar = this.f3724h;
        if (yVar != null) {
            return yVar;
        }
        y<T> yVarA = this.f3719c.a(this.f3721e, this.f3720d);
        this.f3724h = yVarA;
        return yVarA;
    }

    @Override // com.google.gson.b0.q.l
    public y<T> a() {
        return this.a != null ? this : b();
    }

    @Override // com.google.gson.y
    public T read(com.google.gson.e0.a aVar) throws IOException {
        if (this.f3718b == null) {
            return b().read(aVar);
        }
        com.google.gson.k kVarA = com.google.gson.b0.o.a(aVar);
        if (this.f3723g && kVarA.isJsonNull()) {
            return null;
        }
        return this.f3718b.a(kVarA, this.f3720d.getType(), this.f3722f);
    }

    @Override // com.google.gson.y
    public void write(com.google.gson.e0.d dVar, T t) throws IOException {
        if (this.a == null) {
            b().write(dVar, t);
        } else if (this.f3723g && t == null) {
            dVar.j();
        } else {
            com.google.gson.b0.o.a(this.a.a(t, this.f3720d.getType(), this.f3722f), dVar);
        }
    }

    public static z a(com.google.gson.d0.a<?> aVar, Object obj) {
        return new c(obj, aVar, false, null);
    }

    public static z a(Class<?> cls, Object obj) {
        return new c(obj, null, false, cls);
    }

    public static z b(com.google.gson.d0.a<?> aVar, Object obj) {
        return new c(obj, aVar, aVar.getType() == aVar.getRawType(), null);
    }

    public m(r<T> rVar, com.google.gson.j<T> jVar, com.google.gson.e eVar, com.google.gson.d0.a<T> aVar, z zVar) {
        this(rVar, jVar, eVar, aVar, zVar, true);
    }
}
