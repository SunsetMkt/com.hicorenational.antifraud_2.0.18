package com.google.gson;

import com.google.gson.b0.q.d;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: GsonBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    private com.google.gson.b0.d a;

    /* JADX INFO: renamed from: b */
    private u f3816b;

    /* JADX INFO: renamed from: c */
    private d f3817c;

    /* JADX INFO: renamed from: d */
    private final Map<Type, g<?>> f3818d;

    /* JADX INFO: renamed from: e */
    private final List<z> f3819e;

    /* JADX INFO: renamed from: f */
    private final List<z> f3820f;

    /* JADX INFO: renamed from: g */
    private boolean f3821g;

    /* JADX INFO: renamed from: h */
    private String f3822h;

    /* JADX INFO: renamed from: i */
    private int f3823i;

    /* JADX INFO: renamed from: j */
    private int f3824j;

    /* JADX INFO: renamed from: k */
    private boolean f3825k;

    /* JADX INFO: renamed from: l */
    private boolean f3826l;

    /* JADX INFO: renamed from: m */
    private boolean f3827m;

    /* JADX INFO: renamed from: n */
    private boolean f3828n;
    private boolean o;
    private boolean p;
    private boolean q;
    private x r;
    private x s;
    private final LinkedList<v> t;

    public f() {
        this.a = com.google.gson.b0.d.f3648h;
        this.f3816b = u.DEFAULT;
        this.f3817c = c.IDENTITY;
        this.f3818d = new HashMap();
        this.f3819e = new ArrayList();
        this.f3820f = new ArrayList();
        this.f3821g = false;
        this.f3822h = e.H;
        this.f3823i = 2;
        this.f3824j = 2;
        this.f3825k = false;
        this.f3826l = false;
        this.f3827m = true;
        this.f3828n = false;
        this.o = false;
        this.p = false;
        this.q = true;
        this.r = e.J;
        this.s = e.K;
        this.t = new LinkedList<>();
    }

    public f a(double d2) {
        if (!Double.isNaN(d2) && d2 >= 0.0d) {
            this.a = this.a.a(d2);
            return this;
        }
        throw new IllegalArgumentException("Invalid version: " + d2);
    }

    public f b(x xVar) {
        this.r = (x) Objects.requireNonNull(xVar);
        return this;
    }

    public f c() {
        this.a = this.a.a();
        return this;
    }

    public f d() {
        this.q = false;
        return this;
    }

    public f e() {
        this.f3825k = true;
        return this;
    }

    public f f() {
        this.a = this.a.b();
        return this;
    }

    public f g() {
        this.o = true;
        return this;
    }

    public f h() {
        this.f3821g = true;
        return this;
    }

    public f i() {
        this.f3826l = true;
        return this;
    }

    public f j() {
        this.p = true;
        return this;
    }

    public f k() {
        this.f3828n = true;
        return this;
    }

    public f b(a aVar) {
        Objects.requireNonNull(aVar);
        this.a = this.a.a(aVar, true, false);
        return this;
    }

    public f a(int... iArr) {
        Objects.requireNonNull(iArr);
        this.a = this.a.a(iArr);
        return this;
    }

    public f b() {
        this.f3827m = false;
        return this;
    }

    public f a(u uVar) {
        this.f3816b = (u) Objects.requireNonNull(uVar);
        return this;
    }

    public f a(c cVar) {
        return a((d) cVar);
    }

    public f a(d dVar) {
        this.f3817c = (d) Objects.requireNonNull(dVar);
        return this;
    }

    public f a(x xVar) {
        this.s = (x) Objects.requireNonNull(xVar);
        return this;
    }

    public f a(a... aVarArr) {
        Objects.requireNonNull(aVarArr);
        for (a aVar : aVarArr) {
            this.a = this.a.a(aVar, true, true);
        }
        return this;
    }

    public f a(a aVar) {
        Objects.requireNonNull(aVar);
        this.a = this.a.a(aVar, false, true);
        return this;
    }

    public f a(String str) {
        this.f3822h = str;
        return this;
    }

    public f a(int i2) {
        this.f3823i = i2;
        this.f3822h = null;
        return this;
    }

    public f a(int i2, int i3) {
        this.f3823i = i2;
        this.f3824j = i3;
        this.f3822h = null;
        return this;
    }

    public f a(Type type, Object obj) {
        Objects.requireNonNull(type);
        boolean z = obj instanceof r;
        com.google.gson.b0.a.a(z || (obj instanceof j) || (obj instanceof g) || (obj instanceof y));
        if (obj instanceof g) {
            this.f3818d.put(type, (g) obj);
        }
        if (z || (obj instanceof j)) {
            this.f3819e.add(com.google.gson.b0.q.m.b(com.google.gson.d0.a.get(type), obj));
        }
        if (obj instanceof y) {
            this.f3819e.add(com.google.gson.b0.q.o.a(com.google.gson.d0.a.get(type), (y) obj));
        }
        return this;
    }

    f(e eVar) {
        this.a = com.google.gson.b0.d.f3648h;
        this.f3816b = u.DEFAULT;
        this.f3817c = c.IDENTITY;
        this.f3818d = new HashMap();
        this.f3819e = new ArrayList();
        this.f3820f = new ArrayList();
        this.f3821g = false;
        this.f3822h = e.H;
        this.f3823i = 2;
        this.f3824j = 2;
        this.f3825k = false;
        this.f3826l = false;
        this.f3827m = true;
        this.f3828n = false;
        this.o = false;
        this.p = false;
        this.q = true;
        this.r = e.J;
        this.s = e.K;
        this.t = new LinkedList<>();
        this.a = eVar.f3776f;
        this.f3817c = eVar.f3777g;
        this.f3818d.putAll(eVar.f3778h);
        this.f3821g = eVar.f3779i;
        this.f3825k = eVar.f3780j;
        this.o = eVar.f3781k;
        this.f3827m = eVar.f3782l;
        this.f3828n = eVar.f3783m;
        this.p = eVar.f3784n;
        this.f3826l = eVar.o;
        this.f3816b = eVar.t;
        this.f3822h = eVar.q;
        this.f3823i = eVar.r;
        this.f3824j = eVar.s;
        this.f3819e.addAll(eVar.u);
        this.f3820f.addAll(eVar.v);
        this.q = eVar.p;
        this.r = eVar.w;
        this.s = eVar.x;
        this.t.addAll(eVar.y);
    }

    public f a(z zVar) {
        Objects.requireNonNull(zVar);
        this.f3819e.add(zVar);
        return this;
    }

    public f a(Class<?> cls, Object obj) {
        Objects.requireNonNull(cls);
        boolean z = obj instanceof r;
        com.google.gson.b0.a.a(z || (obj instanceof j) || (obj instanceof y));
        if ((obj instanceof j) || z) {
            this.f3820f.add(com.google.gson.b0.q.m.a(cls, obj));
        }
        if (obj instanceof y) {
            this.f3819e.add(com.google.gson.b0.q.o.b(cls, (y) obj));
        }
        return this;
    }

    public f a(v vVar) {
        Objects.requireNonNull(vVar);
        this.t.addFirst(vVar);
        return this;
    }

    public e a() {
        List<z> arrayList = new ArrayList<>(this.f3819e.size() + this.f3820f.size() + 3);
        arrayList.addAll(this.f3819e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f3820f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        a(this.f3822h, this.f3823i, this.f3824j, arrayList);
        return new e(this.a, this.f3817c, new HashMap(this.f3818d), this.f3821g, this.f3825k, this.o, this.f3827m, this.f3828n, this.p, this.f3826l, this.q, this.f3816b, this.f3822h, this.f3823i, this.f3824j, new ArrayList(this.f3819e), new ArrayList(this.f3820f), arrayList, this.r, this.s, new ArrayList(this.t));
    }

    private void a(String str, int i2, int i3, List<z> list) {
        z zVarA;
        z zVarA2;
        boolean z = com.google.gson.b0.t.d.a;
        z zVarA3 = null;
        if (str != null && !str.trim().isEmpty()) {
            z zVarA4 = d.b.f3686b.a(str);
            if (z) {
                zVarA3 = com.google.gson.b0.t.d.f3768c.a(str);
                zVarA2 = com.google.gson.b0.t.d.f3767b.a(str);
                zVarA = zVarA4;
            } else {
                zVarA = zVarA4;
                zVarA2 = null;
            }
        } else {
            if (i2 == 2 || i3 == 2) {
                return;
            }
            zVarA = d.b.f3686b.a(i2, i3);
            if (z) {
                zVarA3 = com.google.gson.b0.t.d.f3768c.a(i2, i3);
                zVarA2 = com.google.gson.b0.t.d.f3767b.a(i2, i3);
            } else {
                zVarA2 = null;
            }
        }
        list.add(zVarA);
        if (z) {
            list.add(zVarA3);
            list.add(zVarA2);
        }
    }
}
