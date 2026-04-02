package i.u2;

import i.q2.t.i0;
import java.util.Random;

/* JADX INFO: compiled from: PlatformRandom.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends f {
    @Override // i.u2.f
    public int a(int i2) {
        return g.b(g().nextInt(), i2);
    }

    @Override // i.u2.f
    public double b() {
        return g().nextDouble();
    }

    @Override // i.u2.f
    public int c(int i2) {
        return g().nextInt(i2);
    }

    @Override // i.u2.f
    public int d() {
        return g().nextInt();
    }

    @Override // i.u2.f
    public long e() {
        return g().nextLong();
    }

    @j.c.a.d
    public abstract Random g();

    @Override // i.u2.f
    public boolean a() {
        return g().nextBoolean();
    }

    @Override // i.u2.f
    public float c() {
        return g().nextFloat();
    }

    @Override // i.u2.f
    @j.c.a.d
    public byte[] a(@j.c.a.d byte[] bArr) {
        i0.f(bArr, "array");
        g().nextBytes(bArr);
        return bArr;
    }
}
