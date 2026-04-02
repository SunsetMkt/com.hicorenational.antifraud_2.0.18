package com.airbnb.lottie.w.b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.w.c.a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ContentGroup.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements e, n, a.b, com.airbnb.lottie.y.f {
    private Paint a;

    /* JADX INFO: renamed from: b */
    private RectF f2259b;

    /* JADX INFO: renamed from: c */
    private final Matrix f2260c;

    /* JADX INFO: renamed from: d */
    private final Path f2261d;

    /* JADX INFO: renamed from: e */
    private final RectF f2262e;

    /* JADX INFO: renamed from: f */
    private final String f2263f;

    /* JADX INFO: renamed from: g */
    private final boolean f2264g;

    /* JADX INFO: renamed from: h */
    private final List<c> f2265h;

    /* JADX INFO: renamed from: i */
    private final com.airbnb.lottie.j f2266i;

    /* JADX INFO: renamed from: j */
    @Nullable
    private List<n> f2267j;

    /* JADX INFO: renamed from: k */
    @Nullable
    private com.airbnb.lottie.w.c.o f2268k;

    public d(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar, com.airbnb.lottie.y.k.n nVar) {
        this(jVar, aVar, nVar.b(), nVar.c(), a(jVar, aVar, nVar.a()), a(nVar.a()));
    }

    private static List<c> a(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar, List<com.airbnb.lottie.y.k.b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVarA = list.get(i2).a(jVar, aVar);
            if (cVarA != null) {
                arrayList.add(cVarA);
            }
        }
        return arrayList;
    }

    private boolean d() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f2265h.size(); i3++) {
            if ((this.f2265h.get(i3) instanceof e) && (i2 = i2 + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    List<n> b() {
        if (this.f2267j == null) {
            this.f2267j = new ArrayList();
            for (int i2 = 0; i2 < this.f2265h.size(); i2++) {
                c cVar = this.f2265h.get(i2);
                if (cVar instanceof n) {
                    this.f2267j.add((n) cVar);
                }
            }
        }
        return this.f2267j;
    }

    Matrix c() {
        com.airbnb.lottie.w.c.o oVar = this.f2268k;
        if (oVar != null) {
            return oVar.b();
        }
        this.f2260c.reset();
        return this.f2260c;
    }

    @Override // com.airbnb.lottie.w.b.c
    public String getName() {
        return this.f2263f;
    }

    @Override // com.airbnb.lottie.w.b.n
    public Path getPath() {
        this.f2260c.reset();
        com.airbnb.lottie.w.c.o oVar = this.f2268k;
        if (oVar != null) {
            this.f2260c.set(oVar.b());
        }
        this.f2261d.reset();
        if (this.f2264g) {
            return this.f2261d;
        }
        for (int size = this.f2265h.size() - 1; size >= 0; size--) {
            c cVar = this.f2265h.get(size);
            if (cVar instanceof n) {
                this.f2261d.addPath(((n) cVar).getPath(), this.f2260c);
            }
        }
        return this.f2261d;
    }

    d(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar, String str, boolean z, List<c> list, @Nullable com.airbnb.lottie.y.j.l lVar) {
        this.a = new com.airbnb.lottie.w.a();
        this.f2259b = new RectF();
        this.f2260c = new Matrix();
        this.f2261d = new Path();
        this.f2262e = new RectF();
        this.f2263f = str;
        this.f2266i = jVar;
        this.f2264g = z;
        this.f2265h = list;
        if (lVar != null) {
            this.f2268k = lVar.a();
            this.f2268k.a(aVar);
            this.f2268k.a(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof j) {
                arrayList.add((j) cVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((j) arrayList.get(size2)).a(list.listIterator(list.size()));
        }
    }

    @Nullable
    static com.airbnb.lottie.y.j.l a(List<com.airbnb.lottie.y.k.b> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            com.airbnb.lottie.y.k.b bVar = list.get(i2);
            if (bVar instanceof com.airbnb.lottie.y.j.l) {
                return (com.airbnb.lottie.y.j.l) bVar;
            }
        }
        return null;
    }

    @Override // com.airbnb.lottie.w.c.a.b
    public void a() {
        this.f2266i.invalidateSelf();
    }

    @Override // com.airbnb.lottie.w.b.c
    public void a(List<c> list, List<c> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f2265h.size());
        arrayList.addAll(list);
        for (int size = this.f2265h.size() - 1; size >= 0; size--) {
            c cVar = this.f2265h.get(size);
            cVar.a(arrayList, this.f2265h.subList(0, size));
            arrayList.add(cVar);
        }
    }

    @Override // com.airbnb.lottie.w.b.e
    public void a(Canvas canvas, Matrix matrix, int i2) {
        if (this.f2264g) {
            return;
        }
        this.f2260c.set(matrix);
        com.airbnb.lottie.w.c.o oVar = this.f2268k;
        if (oVar != null) {
            this.f2260c.preConcat(oVar.b());
            i2 = (int) (((((this.f2268k.c() == null ? 100 : this.f2268k.c().f().intValue()) / 100.0f) * i2) / 255.0f) * 255.0f);
        }
        boolean z = this.f2266i.u() && d() && i2 != 255;
        if (z) {
            this.f2259b.set(0.0f, 0.0f, 0.0f, 0.0f);
            a(this.f2259b, this.f2260c, true);
            this.a.setAlpha(i2);
            com.airbnb.lottie.b0.h.a(canvas, this.f2259b, this.a);
        }
        if (z) {
            i2 = 255;
        }
        for (int size = this.f2265h.size() - 1; size >= 0; size--) {
            c cVar = this.f2265h.get(size);
            if (cVar instanceof e) {
                ((e) cVar).a(canvas, this.f2260c, i2);
            }
        }
        if (z) {
            canvas.restore();
        }
    }

    @Override // com.airbnb.lottie.w.b.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.f2260c.set(matrix);
        com.airbnb.lottie.w.c.o oVar = this.f2268k;
        if (oVar != null) {
            this.f2260c.preConcat(oVar.b());
        }
        this.f2262e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f2265h.size() - 1; size >= 0; size--) {
            c cVar = this.f2265h.get(size);
            if (cVar instanceof e) {
                ((e) cVar).a(this.f2262e, this.f2260c, z);
                rectF.union(this.f2262e);
            }
        }
    }

    @Override // com.airbnb.lottie.y.f
    public void a(com.airbnb.lottie.y.e eVar, int i2, List<com.airbnb.lottie.y.e> list, com.airbnb.lottie.y.e eVar2) {
        if (eVar.c(getName(), i2) || "__container".equals(getName())) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.a(getName());
                if (eVar.a(getName(), i2)) {
                    list.add(eVar2.a(this));
                }
            }
            if (eVar.d(getName(), i2)) {
                int iB = i2 + eVar.b(getName(), i2);
                for (int i3 = 0; i3 < this.f2265h.size(); i3++) {
                    c cVar = this.f2265h.get(i3);
                    if (cVar instanceof com.airbnb.lottie.y.f) {
                        ((com.airbnb.lottie.y.f) cVar).a(eVar, iB, list, eVar2);
                    }
                }
            }
        }
    }

    @Override // com.airbnb.lottie.y.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.c0.j<T> jVar) {
        com.airbnb.lottie.w.c.o oVar = this.f2268k;
        if (oVar != null) {
            oVar.a(t, jVar);
        }
    }
}
