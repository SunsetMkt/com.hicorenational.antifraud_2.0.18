package i.v2;

import i.g2.v0;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ProgressionIterators.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class m extends v0 {
    private final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f12317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f12318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f12319d;

    public m(long j2, long j3, long j4) {
        this.f12319d = j4;
        this.a = j3;
        boolean z = true;
        if (this.f12319d <= 0 ? j2 < j3 : j2 > j3) {
            z = false;
        }
        this.f12317b = z;
        this.f12318c = this.f12317b ? j2 : this.a;
    }

    public final long b() {
        return this.f12319d;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f12317b;
    }

    @Override // i.g2.v0
    public long nextLong() {
        long j2 = this.f12318c;
        if (j2 != this.a) {
            this.f12318c = this.f12319d + j2;
        } else {
            if (!this.f12317b) {
                throw new NoSuchElementException();
            }
            this.f12317b = false;
        }
        return j2;
    }
}
