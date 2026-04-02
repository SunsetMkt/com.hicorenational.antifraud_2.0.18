package i.v2;

import i.b2;
import i.g2.x1;
import i.j1;
import i.t0;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: UIntRange.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.k
@t0(version = "1.3")
final class s extends x1 {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f12325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f12326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f12327d;

    private s(int i2, int i3, int i4) {
        this.a = i3;
        boolean z = true;
        int iA = b2.a(i2, i3);
        if (i4 <= 0 ? iA < 0 : iA > 0) {
            z = false;
        }
        this.f12325b = z;
        this.f12326c = j1.c(i4);
        this.f12327d = this.f12325b ? i2 : this.a;
    }

    @Override // i.g2.x1
    public int b() {
        int i2 = this.f12327d;
        if (i2 != this.a) {
            this.f12327d = j1.c(this.f12326c + i2);
        } else {
            if (!this.f12325b) {
                throw new NoSuchElementException();
            }
            this.f12325b = false;
        }
        return i2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f12325b;
    }

    public /* synthetic */ s(int i2, int i3, int i4, i.q2.t.v vVar) {
        this(i2, i3, i4);
    }
}
