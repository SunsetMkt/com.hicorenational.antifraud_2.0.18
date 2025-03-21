package p286h.p319v2;

import java.util.NoSuchElementException;
import p286h.C5215b2;
import p286h.C5441n1;
import p286h.InterfaceC5352k;
import p286h.InterfaceC5610t0;
import p286h.p289g2.AbstractC5317y1;
import p286h.p309q2.p311t.C5586v;

/* compiled from: ULongRange.kt */
@InterfaceC5610t0(version = "1.3")
@InterfaceC5352k
/* renamed from: h.v2.v */
/* loaded from: classes2.dex */
final class C5653v extends AbstractC5317y1 {

    /* renamed from: a */
    private final long f20544a;

    /* renamed from: b */
    private boolean f20545b;

    /* renamed from: c */
    private final long f20546c;

    /* renamed from: d */
    private long f20547d;

    private C5653v(long j2, long j3, long j4) {
        this.f20544a = j3;
        boolean z = true;
        int m18813a = C5215b2.m18813a(j2, j3);
        if (j4 <= 0 ? m18813a < 0 : m18813a > 0) {
            z = false;
        }
        this.f20545b = z;
        this.f20546c = C5441n1.m22205c(j4);
        this.f20547d = this.f20545b ? j2 : this.f20544a;
    }

    @Override // p286h.p289g2.AbstractC5317y1
    /* renamed from: b */
    public long mo21795b() {
        long j2 = this.f20547d;
        if (j2 != this.f20544a) {
            this.f20547d = C5441n1.m22205c(this.f20546c + j2);
        } else {
            if (!this.f20545b) {
                throw new NoSuchElementException();
            }
            this.f20545b = false;
        }
        return j2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f20545b;
    }

    public /* synthetic */ C5653v(long j2, long j3, long j4, C5586v c5586v) {
        this(j2, j3, j4);
    }
}
