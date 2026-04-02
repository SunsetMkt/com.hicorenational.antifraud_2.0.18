package d.b.c.e0.e;

import d.b.c.m;
import d.b.c.t;

/* JADX INFO: compiled from: BoundingBox.java */
/* JADX INFO: loaded from: classes.dex */
final class c {
    private d.b.c.z.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private t f9692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private t f9693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private t f9694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private t f9695e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f9696f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f9697g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f9698h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f9699i;

    c(d.b.c.z.b bVar, t tVar, t tVar2, t tVar3, t tVar4) throws m {
        if ((tVar == null && tVar3 == null) || ((tVar2 == null && tVar4 == null) || ((tVar != null && tVar2 == null) || (tVar3 != null && tVar4 == null)))) {
            throw m.getNotFoundInstance();
        }
        a(bVar, tVar, tVar2, tVar3, tVar4);
    }

    private void a(d.b.c.z.b bVar, t tVar, t tVar2, t tVar3, t tVar4) {
        this.a = bVar;
        this.f9692b = tVar;
        this.f9693c = tVar2;
        this.f9694d = tVar3;
        this.f9695e = tVar4;
        i();
    }

    private void i() {
        if (this.f9692b == null) {
            this.f9692b = new t(0.0f, this.f9694d.b());
            this.f9693c = new t(0.0f, this.f9695e.b());
        } else if (this.f9694d == null) {
            this.f9694d = new t(this.a.g() - 1, this.f9692b.b());
            this.f9695e = new t(this.a.g() - 1, this.f9693c.b());
        }
        this.f9696f = (int) Math.min(this.f9692b.a(), this.f9693c.a());
        this.f9697g = (int) Math.max(this.f9694d.a(), this.f9695e.a());
        this.f9698h = (int) Math.min(this.f9692b.b(), this.f9694d.b());
        this.f9699i = (int) Math.max(this.f9693c.b(), this.f9695e.b());
    }

    t b() {
        return this.f9695e;
    }

    int c() {
        return this.f9697g;
    }

    int d() {
        return this.f9699i;
    }

    int e() {
        return this.f9696f;
    }

    int f() {
        return this.f9698h;
    }

    t g() {
        return this.f9692b;
    }

    t h() {
        return this.f9694d;
    }

    c(c cVar) {
        a(cVar.a, cVar.f9692b, cVar.f9693c, cVar.f9694d, cVar.f9695e);
    }

    static c a(c cVar, c cVar2) throws m {
        return cVar == null ? cVar2 : cVar2 == null ? cVar : new c(cVar.a, cVar.f9692b, cVar.f9693c, cVar2.f9694d, cVar2.f9695e);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    c a(int i2, int i3, boolean z) throws m {
        t tVar;
        t tVar2;
        t tVar3;
        t tVar4;
        t tVar5 = this.f9692b;
        t tVar6 = this.f9693c;
        t tVar7 = this.f9694d;
        t tVar8 = this.f9695e;
        if (i2 > 0) {
            t tVar9 = z ? tVar5 : tVar7;
            int iB = ((int) tVar9.b()) - i2;
            if (iB < 0) {
                iB = 0;
            }
            t tVar10 = new t(tVar9.a(), iB);
            if (!z) {
                tVar2 = tVar10;
                tVar = tVar5;
                if (i3 <= 0) {
                    t tVar11 = z ? this.f9693c : this.f9695e;
                    int iB2 = ((int) tVar11.b()) + i3;
                    if (iB2 >= this.a.d()) {
                        iB2 = this.a.d() - 1;
                    }
                    t tVar12 = new t(tVar11.a(), iB2);
                    if (!z) {
                        tVar4 = tVar12;
                        tVar3 = tVar6;
                        i();
                        return new c(this.a, tVar, tVar3, tVar2, tVar4);
                    }
                    tVar3 = tVar12;
                } else {
                    tVar3 = tVar6;
                }
                tVar4 = tVar8;
                i();
                return new c(this.a, tVar, tVar3, tVar2, tVar4);
            }
            tVar = tVar10;
        } else {
            tVar = tVar5;
        }
        tVar2 = tVar7;
        if (i3 <= 0) {
        }
        tVar4 = tVar8;
        i();
        return new c(this.a, tVar, tVar3, tVar2, tVar4);
    }

    t a() {
        return this.f9693c;
    }
}
