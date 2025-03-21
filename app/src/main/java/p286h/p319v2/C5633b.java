package p286h.p319v2;

import java.util.NoSuchElementException;
import p286h.p289g2.AbstractC5306v;

/* compiled from: ProgressionIterators.kt */
/* renamed from: h.v2.b */
/* loaded from: classes2.dex */
public final class C5633b extends AbstractC5306v {

    /* renamed from: a */
    private final int f20498a;

    /* renamed from: b */
    private boolean f20499b;

    /* renamed from: c */
    private int f20500c;

    /* renamed from: d */
    private final int f20501d;

    public C5633b(char c2, char c3, int i2) {
        this.f20501d = i2;
        this.f20498a = c3;
        boolean z = true;
        if (this.f20501d <= 0 ? c2 < c3 : c2 > c3) {
            z = false;
        }
        this.f20499b = z;
        this.f20500c = this.f20499b ? c2 : this.f20498a;
    }

    @Override // p286h.p289g2.AbstractC5306v
    /* renamed from: b */
    public char mo21708b() {
        int i2 = this.f20500c;
        if (i2 != this.f20498a) {
            this.f20500c = this.f20501d + i2;
        } else {
            if (!this.f20499b) {
                throw new NoSuchElementException();
            }
            this.f20499b = false;
        }
        return (char) i2;
    }

    /* renamed from: c */
    public final int m23008c() {
        return this.f20501d;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f20499b;
    }
}
