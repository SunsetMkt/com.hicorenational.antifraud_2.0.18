package i.v2;

import i.g2.u0;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ProgressionIterators.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j extends u0 {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f12309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f12310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f12311d;

    public j(int i2, int i3, int i4) {
        this.f12311d = i4;
        this.a = i3;
        boolean z = true;
        if (this.f12311d <= 0 ? i2 < i3 : i2 > i3) {
            z = false;
        }
        this.f12309b = z;
        this.f12310c = this.f12309b ? i2 : this.a;
    }

    public final int b() {
        return this.f12311d;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f12309b;
    }

    @Override // i.g2.u0
    public int nextInt() {
        int i2 = this.f12310c;
        if (i2 != this.a) {
            this.f12310c = this.f12311d + i2;
        } else {
            if (!this.f12309b) {
                throw new NoSuchElementException();
            }
            this.f12309b = false;
        }
        return i2;
    }
}
