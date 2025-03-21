package p286h.p319v2;

import java.util.NoSuchElementException;
import p286h.p289g2.AbstractC5307v0;

/* compiled from: ProgressionIterators.kt */
/* renamed from: h.v2.m */
/* loaded from: classes2.dex */
public final class C5644m extends AbstractC5307v0 {

    /* renamed from: a */
    private final long f20524a;

    /* renamed from: b */
    private boolean f20525b;

    /* renamed from: c */
    private long f20526c;

    /* renamed from: d */
    private final long f20527d;

    public C5644m(long j2, long j3, long j4) {
        this.f20527d = j4;
        this.f20524a = j3;
        boolean z = true;
        if (this.f20527d <= 0 ? j2 < j3 : j2 > j3) {
            z = false;
        }
        this.f20525b = z;
        this.f20526c = this.f20525b ? j2 : this.f20524a;
    }

    /* renamed from: b */
    public final long m23029b() {
        return this.f20527d;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f20525b;
    }

    @Override // p286h.p289g2.AbstractC5307v0
    public long nextLong() {
        long j2 = this.f20526c;
        if (j2 != this.f20524a) {
            this.f20526c = this.f20527d + j2;
        } else {
            if (!this.f20525b) {
                throw new NoSuchElementException();
            }
            this.f20525b = false;
        }
        return j2;
    }
}
