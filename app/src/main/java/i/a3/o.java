package i.a3;

import i.t0;

/* JADX INFO: compiled from: TimeSource.kt */
/* JADX INFO: loaded from: classes2.dex */
@j
@t0(version = "1.3")
public abstract class o {
    public abstract double a();

    @j.c.a.d
    public o a(double d2) {
        return b(d.y(d2));
    }

    @j.c.a.d
    public o b(double d2) {
        return new c(this, d2, null);
    }

    public final boolean c() {
        return !d.s(a());
    }

    public final boolean b() {
        return d.s(a());
    }
}
