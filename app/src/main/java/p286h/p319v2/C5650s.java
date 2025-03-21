package p286h.p319v2;

import java.util.NoSuchElementException;
import p286h.C5215b2;
import p286h.C5341j1;
import p286h.InterfaceC5352k;
import p286h.InterfaceC5610t0;
import p286h.p289g2.AbstractC5314x1;
import p286h.p309q2.p311t.C5586v;

/* compiled from: UIntRange.kt */
@InterfaceC5610t0(version = "1.3")
@InterfaceC5352k
/* renamed from: h.v2.s */
/* loaded from: classes2.dex */
final class C5650s extends AbstractC5314x1 {

    /* renamed from: a */
    private final int f20534a;

    /* renamed from: b */
    private boolean f20535b;

    /* renamed from: c */
    private final int f20536c;

    /* renamed from: d */
    private int f20537d;

    private C5650s(int i2, int i3, int i4) {
        this.f20534a = i3;
        boolean z = true;
        int m18812a = C5215b2.m18812a(i2, i3);
        if (i4 <= 0 ? m18812a < 0 : m18812a > 0) {
            z = false;
        }
        this.f20535b = z;
        this.f20536c = C5341j1.m21929c(i4);
        this.f20537d = this.f20535b ? i2 : this.f20534a;
    }

    @Override // p286h.p289g2.AbstractC5314x1
    /* renamed from: b */
    public int mo21756b() {
        int i2 = this.f20537d;
        if (i2 != this.f20534a) {
            this.f20537d = C5341j1.m21929c(this.f20536c + i2);
        } else {
            if (!this.f20535b) {
                throw new NoSuchElementException();
            }
            this.f20535b = false;
        }
        return i2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f20535b;
    }

    public /* synthetic */ C5650s(int i2, int i3, int i4, C5586v c5586v) {
        this(i2, i3, i4);
    }
}
