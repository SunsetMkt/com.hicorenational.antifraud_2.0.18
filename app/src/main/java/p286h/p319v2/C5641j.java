package p286h.p319v2;

import java.util.NoSuchElementException;
import p286h.p289g2.AbstractC5304u0;

/* compiled from: ProgressionIterators.kt */
/* renamed from: h.v2.j */
/* loaded from: classes2.dex */
public final class C5641j extends AbstractC5304u0 {

    /* renamed from: a */
    private final int f20514a;

    /* renamed from: b */
    private boolean f20515b;

    /* renamed from: c */
    private int f20516c;

    /* renamed from: d */
    private final int f20517d;

    public C5641j(int i2, int i3, int i4) {
        this.f20517d = i4;
        this.f20514a = i3;
        boolean z = true;
        if (this.f20517d <= 0 ? i2 < i3 : i2 > i3) {
            z = false;
        }
        this.f20515b = z;
        this.f20516c = this.f20515b ? i2 : this.f20514a;
    }

    /* renamed from: b */
    public final int m23023b() {
        return this.f20517d;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f20515b;
    }

    @Override // p286h.p289g2.AbstractC5304u0
    public int nextInt() {
        int i2 = this.f20516c;
        if (i2 != this.f20514a) {
            this.f20516c = this.f20517d + i2;
        } else {
            if (!this.f20515b) {
                throw new NoSuchElementException();
            }
            this.f20515b = false;
        }
        return i2;
    }
}
