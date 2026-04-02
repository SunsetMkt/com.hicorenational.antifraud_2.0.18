package com.airbnb.lottie.w.b;

import com.airbnb.lottie.w.c.a;
import com.airbnb.lottie.y.k.q;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: TrimPathContent.java */
/* JADX INFO: loaded from: classes.dex */
public class t implements c, a.b {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f2341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<a.b> f2342c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final q.a f2343d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, Float> f2344e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, Float> f2345f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, Float> f2346g;

    public t(com.airbnb.lottie.y.l.a aVar, com.airbnb.lottie.y.k.q qVar) {
        this.a = qVar.b();
        this.f2341b = qVar.f();
        this.f2343d = qVar.e();
        this.f2344e = qVar.d().a();
        this.f2345f = qVar.a().a();
        this.f2346g = qVar.c().a();
        aVar.a(this.f2344e);
        aVar.a(this.f2345f);
        aVar.a(this.f2346g);
        this.f2344e.a(this);
        this.f2345f.a(this);
        this.f2346g.a(this);
    }

    @Override // com.airbnb.lottie.w.c.a.b
    public void a() {
        for (int i2 = 0; i2 < this.f2342c.size(); i2++) {
            this.f2342c.get(i2).a();
        }
    }

    @Override // com.airbnb.lottie.w.b.c
    public void a(List<c> list, List<c> list2) {
    }

    public com.airbnb.lottie.w.c.a<?, Float> b() {
        return this.f2345f;
    }

    public com.airbnb.lottie.w.c.a<?, Float> c() {
        return this.f2346g;
    }

    public com.airbnb.lottie.w.c.a<?, Float> d() {
        return this.f2344e;
    }

    q.a e() {
        return this.f2343d;
    }

    public boolean f() {
        return this.f2341b;
    }

    @Override // com.airbnb.lottie.w.b.c
    public String getName() {
        return this.a;
    }

    void a(a.b bVar) {
        this.f2342c.add(bVar);
    }
}
