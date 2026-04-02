package i.a3;

import i.t0;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: MonoTimeSource.kt */
/* JADX INFO: loaded from: classes2.dex */
@j
@t0(version = "1.3")
public final class m extends b implements p {

    /* JADX INFO: renamed from: c */
    public static final m f12059c = new m();

    private m() {
        super(TimeUnit.NANOSECONDS);
    }

    @Override // i.a3.b
    protected long c() {
        return System.nanoTime();
    }

    @j.c.a.d
    public String toString() {
        return "TimeSource(System.nanoTime())";
    }
}
