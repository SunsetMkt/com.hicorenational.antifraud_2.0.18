package p031c.p035b.p043c.p062f0.p064d;

import p031c.p035b.p043c.C1109t;

/* compiled from: AlignmentPattern.java */
/* renamed from: c.b.c.f0.d.a */
/* loaded from: classes.dex */
public final class C1084a extends C1109t {

    /* renamed from: c */
    private final float f2146c;

    C1084a(float f2, float f3, float f4) {
        super(f2, f3);
        this.f2146c = f4;
    }

    /* renamed from: a */
    boolean m1784a(float f2, float f3, float f4) {
        if (Math.abs(f3 - m1923b()) > f2 || Math.abs(f4 - m1922a()) > f2) {
            return false;
        }
        float abs = Math.abs(f2 - this.f2146c);
        return abs <= 1.0f || abs <= this.f2146c;
    }

    /* renamed from: b */
    C1084a m1785b(float f2, float f3, float f4) {
        return new C1084a((m1922a() + f3) / 2.0f, (m1923b() + f2) / 2.0f, (this.f2146c + f4) / 2.0f);
    }
}
