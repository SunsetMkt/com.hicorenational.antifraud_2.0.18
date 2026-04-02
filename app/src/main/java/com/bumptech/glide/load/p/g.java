package com.bumptech.glide.load.p;

import com.bumptech.glide.i;
import com.bumptech.glide.load.p.h;
import com.bumptech.glide.load.q.n;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: DecodeHelper.java */
/* JADX INFO: loaded from: classes.dex */
final class g<Transcode> {
    private final List<n.a<?>> a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<com.bumptech.glide.load.g> f2923b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.d f2924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f2925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2926e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2927f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Class<?> f2928g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private h.e f2929h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.bumptech.glide.load.j f2930i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Map<Class<?>, com.bumptech.glide.load.n<?>> f2931j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Class<Transcode> f2932k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f2933l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f2934m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.bumptech.glide.load.g f2935n;
    private com.bumptech.glide.h o;
    private j p;
    private boolean q;
    private boolean r;

    g() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    <R> void a(com.bumptech.glide.d dVar, Object obj, com.bumptech.glide.load.g gVar, int i2, int i3, j jVar, Class<?> cls, Class<R> cls2, com.bumptech.glide.h hVar, com.bumptech.glide.load.j jVar2, Map<Class<?>, com.bumptech.glide.load.n<?>> map, boolean z, boolean z2, h.e eVar) {
        this.f2924c = dVar;
        this.f2925d = obj;
        this.f2935n = gVar;
        this.f2926e = i2;
        this.f2927f = i3;
        this.p = jVar;
        this.f2928g = cls;
        this.f2929h = eVar;
        this.f2932k = cls2;
        this.o = hVar;
        this.f2930i = jVar2;
        this.f2931j = map;
        this.q = z;
        this.r = z2;
    }

    com.bumptech.glide.load.p.a0.b b() {
        return this.f2924c.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean c(Class<?> cls) {
        return a((Class) cls) != null;
    }

    com.bumptech.glide.load.p.b0.a d() {
        return this.f2929h.a();
    }

    j e() {
        return this.p;
    }

    int f() {
        return this.f2927f;
    }

    List<n.a<?>> g() {
        if (!this.f2933l) {
            this.f2933l = true;
            this.a.clear();
            List listA = this.f2924c.f().a(this.f2925d);
            int size = listA.size();
            for (int i2 = 0; i2 < size; i2++) {
                n.a<?> aVarA = ((com.bumptech.glide.load.q.n) listA.get(i2)).a(this.f2925d, this.f2926e, this.f2927f, this.f2930i);
                if (aVarA != null) {
                    this.a.add(aVarA);
                }
            }
        }
        return this.a;
    }

    Class<?> h() {
        return this.f2925d.getClass();
    }

    com.bumptech.glide.load.j i() {
        return this.f2930i;
    }

    com.bumptech.glide.h j() {
        return this.o;
    }

    List<Class<?>> k() {
        return this.f2924c.f().b(this.f2925d.getClass(), this.f2928g, this.f2932k);
    }

    com.bumptech.glide.load.g l() {
        return this.f2935n;
    }

    Class<?> m() {
        return this.f2932k;
    }

    int n() {
        return this.f2926e;
    }

    boolean o() {
        return this.r;
    }

    <Z> com.bumptech.glide.load.n<Z> b(Class<Z> cls) {
        com.bumptech.glide.load.n<Z> nVar = (com.bumptech.glide.load.n) this.f2931j.get(cls);
        if (nVar == null) {
            Iterator<Map.Entry<Class<?>, com.bumptech.glide.load.n<?>>> it = this.f2931j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, com.bumptech.glide.load.n<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    nVar = (com.bumptech.glide.load.n) next.getValue();
                    break;
                }
            }
        }
        if (nVar != null) {
            return nVar;
        }
        if (!this.f2931j.isEmpty() || !this.q) {
            return com.bumptech.glide.load.r.c.a();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    List<com.bumptech.glide.load.g> c() {
        if (!this.f2934m) {
            this.f2934m = true;
            this.f2923b.clear();
            List<n.a<?>> listG = g();
            int size = listG.size();
            for (int i2 = 0; i2 < size; i2++) {
                n.a<?> aVar = listG.get(i2);
                if (!this.f2923b.contains(aVar.a)) {
                    this.f2923b.add(aVar.a);
                }
                for (int i3 = 0; i3 < aVar.f3090b.size(); i3++) {
                    if (!this.f2923b.contains(aVar.f3090b.get(i3))) {
                        this.f2923b.add(aVar.f3090b.get(i3));
                    }
                }
            }
        }
        return this.f2923b;
    }

    boolean b(v<?> vVar) {
        return this.f2924c.f().b(vVar);
    }

    void a() {
        this.f2924c = null;
        this.f2925d = null;
        this.f2935n = null;
        this.f2928g = null;
        this.f2932k = null;
        this.f2930i = null;
        this.o = null;
        this.f2931j = null;
        this.p = null;
        this.a.clear();
        this.f2933l = false;
        this.f2923b.clear();
        this.f2934m = false;
    }

    <Data> t<Data, ?, Transcode> a(Class<Data> cls) {
        return this.f2924c.f().a(cls, this.f2928g, this.f2932k);
    }

    <Z> com.bumptech.glide.load.m<Z> a(v<Z> vVar) {
        return this.f2924c.f().a((v) vVar);
    }

    List<com.bumptech.glide.load.q.n<File, ?>> a(File file) throws i.c {
        return this.f2924c.f().a(file);
    }

    boolean a(com.bumptech.glide.load.g gVar) {
        List<n.a<?>> listG = g();
        int size = listG.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (listG.get(i2).a.equals(gVar)) {
                return true;
            }
        }
        return false;
    }

    <X> com.bumptech.glide.load.d<X> a(X x) throws i.e {
        return this.f2924c.f().c(x);
    }
}
