package d.b.c.e0.e;

import java.util.Formatter;

/* JADX INFO: compiled from: DetectionResultColumn.java */
/* JADX INFO: loaded from: classes.dex */
class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f9722c = 5;
    private final c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d[] f9723b;

    g(c cVar) {
        this.a = new c(cVar);
        this.f9723b = new d[(cVar.d() - cVar.f()) + 1];
    }

    final void a(int i2, d dVar) {
        this.f9723b[c(i2)] = dVar;
    }

    final d b(int i2) {
        d dVar;
        d dVar2;
        d dVarA = a(i2);
        if (dVarA != null) {
            return dVarA;
        }
        for (int i3 = 1; i3 < 5; i3++) {
            int iC = c(i2) - i3;
            if (iC >= 0 && (dVar2 = this.f9723b[iC]) != null) {
                return dVar2;
            }
            int iC2 = c(i2) + i3;
            d[] dVarArr = this.f9723b;
            if (iC2 < dVarArr.length && (dVar = dVarArr[iC2]) != null) {
                return dVar;
            }
        }
        return null;
    }

    final int c(int i2) {
        return i2 - this.a.f();
    }

    public String toString() {
        Formatter formatter = new Formatter();
        int i2 = 0;
        for (d dVar : this.f9723b) {
            if (dVar == null) {
                formatter.format("%3d:    |   %n", Integer.valueOf(i2));
                i2++;
            } else {
                formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i2), Integer.valueOf(dVar.c()), Integer.valueOf(dVar.e()));
                i2++;
            }
        }
        String string = formatter.toString();
        formatter.close();
        return string;
    }

    final d a(int i2) {
        return this.f9723b[c(i2)];
    }

    final c a() {
        return this.a;
    }

    final d[] b() {
        return this.f9723b;
    }
}
