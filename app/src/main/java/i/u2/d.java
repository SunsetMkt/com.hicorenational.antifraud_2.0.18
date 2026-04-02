package i.u2;

import i.q2.t.i0;
import java.util.Random;

/* JADX INFO: compiled from: PlatformRandom.kt */
/* JADX INFO: loaded from: classes2.dex */
final class d extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @j.c.a.d
    private final Random f12285d;

    public d(@j.c.a.d Random random) {
        i0.f(random, "impl");
        this.f12285d = random;
    }

    @Override // i.u2.a
    @j.c.a.d
    public Random g() {
        return this.f12285d;
    }
}
