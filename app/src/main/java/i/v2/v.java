package i.v2;

import i.b2;
import i.g2.y1;
import i.n1;
import i.t0;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ULongRange.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.k
@t0(version = "1.3")
final class v extends y1 {
    private final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f12333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f12334c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f12335d;

    private v(long j2, long j3, long j4) {
        this.a = j3;
        boolean z = true;
        int iA = b2.a(j2, j3);
        if (j4 <= 0 ? iA < 0 : iA > 0) {
            z = false;
        }
        this.f12333b = z;
        this.f12334c = n1.c(j4);
        this.f12335d = this.f12333b ? j2 : this.a;
    }

    @Override // i.g2.y1
    public long b() {
        long j2 = this.f12335d;
        if (j2 != this.a) {
            this.f12335d = n1.c(this.f12334c + j2);
        } else {
            if (!this.f12333b) {
                throw new NoSuchElementException();
            }
            this.f12333b = false;
        }
        return j2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f12333b;
    }

    public /* synthetic */ v(long j2, long j3, long j4, i.q2.t.v vVar) {
        this(j2, j3, j4);
    }
}
