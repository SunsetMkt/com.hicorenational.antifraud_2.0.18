package com.airbnb.lottie.w.b;

import android.graphics.Path;
import com.airbnb.lottie.w.c.a;
import com.airbnb.lottie.y.k.q;
import java.util.List;

/* JADX INFO: compiled from: ShapeContent.java */
/* JADX INFO: loaded from: classes.dex */
public class r implements n, a.b {

    /* JADX INFO: renamed from: b */
    private final String f2335b;

    /* JADX INFO: renamed from: c */
    private final boolean f2336c;

    /* JADX INFO: renamed from: d */
    private final com.airbnb.lottie.j f2337d;

    /* JADX INFO: renamed from: e */
    private final com.airbnb.lottie.w.c.a<?, Path> f2338e;

    /* JADX INFO: renamed from: f */
    private boolean f2339f;
    private final Path a = new Path();

    /* JADX INFO: renamed from: g */
    private b f2340g = new b();

    public r(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar, com.airbnb.lottie.y.k.o oVar) {
        this.f2335b = oVar.a();
        this.f2336c = oVar.c();
        this.f2337d = jVar;
        this.f2338e = oVar.b().a();
        aVar.a(this.f2338e);
        this.f2338e.a(this);
    }

    private void b() {
        this.f2339f = false;
        this.f2337d.invalidateSelf();
    }

    @Override // com.airbnb.lottie.w.c.a.b
    public void a() {
        b();
    }

    @Override // com.airbnb.lottie.w.b.c
    public String getName() {
        return this.f2335b;
    }

    @Override // com.airbnb.lottie.w.b.n
    public Path getPath() {
        if (this.f2339f) {
            return this.a;
        }
        this.a.reset();
        if (this.f2336c) {
            this.f2339f = true;
            return this.a;
        }
        this.a.set(this.f2338e.f());
        this.a.setFillType(Path.FillType.EVEN_ODD);
        this.f2340g.a(this.a);
        this.f2339f = true;
        return this.a;
    }

    @Override // com.airbnb.lottie.w.b.c
    public void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (cVar instanceof t) {
                t tVar = (t) cVar;
                if (tVar.e() == q.a.SIMULTANEOUSLY) {
                    this.f2340g.a(tVar);
                    tVar.a(this);
                }
            }
        }
    }
}
