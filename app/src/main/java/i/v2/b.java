package i.v2;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ProgressionIterators.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends i.g2.v {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f12298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f12299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f12300d;

    public b(char c2, char c3, int i2) {
        this.f12300d = i2;
        this.a = c3;
        boolean z = true;
        if (this.f12300d <= 0 ? c2 < c3 : c2 > c3) {
            z = false;
        }
        this.f12298b = z;
        this.f12299c = this.f12298b ? c2 : this.a;
    }

    @Override // i.g2.v
    public char b() {
        int i2 = this.f12299c;
        if (i2 != this.a) {
            this.f12299c = this.f12300d + i2;
        } else {
            if (!this.f12298b) {
                throw new NoSuchElementException();
            }
            this.f12298b = false;
        }
        return (char) i2;
    }

    public final int c() {
        return this.f12300d;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f12298b;
    }
}
