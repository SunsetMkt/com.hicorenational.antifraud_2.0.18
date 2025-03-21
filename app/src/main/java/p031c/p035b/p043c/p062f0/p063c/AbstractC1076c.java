package p031c.p035b.p043c.p062f0.p063c;

import p031c.p035b.p043c.p072z.C1163b;

/* compiled from: DataMask.java */
/* renamed from: c.b.c.f0.c.c */
/* loaded from: classes.dex */
abstract class AbstractC1076c {

    /* renamed from: a */
    private static final AbstractC1076c[] f2119a;

    /* compiled from: DataMask.java */
    /* renamed from: c.b.c.f0.c.c$b */
    private static final class b extends AbstractC1076c {
        private b() {
            super();
        }

        @Override // p031c.p035b.p043c.p062f0.p063c.AbstractC1076c
        /* renamed from: a */
        boolean mo1746a(int i2, int i3) {
            return ((i2 + i3) & 1) == 0;
        }
    }

    /* compiled from: DataMask.java */
    /* renamed from: c.b.c.f0.c.c$c */
    private static final class c extends AbstractC1076c {
        private c() {
            super();
        }

        @Override // p031c.p035b.p043c.p062f0.p063c.AbstractC1076c
        /* renamed from: a */
        boolean mo1746a(int i2, int i3) {
            return (i2 & 1) == 0;
        }
    }

    /* compiled from: DataMask.java */
    /* renamed from: c.b.c.f0.c.c$d */
    private static final class d extends AbstractC1076c {
        private d() {
            super();
        }

        @Override // p031c.p035b.p043c.p062f0.p063c.AbstractC1076c
        /* renamed from: a */
        boolean mo1746a(int i2, int i3) {
            return i3 % 3 == 0;
        }
    }

    /* compiled from: DataMask.java */
    /* renamed from: c.b.c.f0.c.c$e */
    private static final class e extends AbstractC1076c {
        private e() {
            super();
        }

        @Override // p031c.p035b.p043c.p062f0.p063c.AbstractC1076c
        /* renamed from: a */
        boolean mo1746a(int i2, int i3) {
            return (i2 + i3) % 3 == 0;
        }
    }

    /* compiled from: DataMask.java */
    /* renamed from: c.b.c.f0.c.c$f */
    private static final class f extends AbstractC1076c {
        private f() {
            super();
        }

        @Override // p031c.p035b.p043c.p062f0.p063c.AbstractC1076c
        /* renamed from: a */
        boolean mo1746a(int i2, int i3) {
            return (((i2 / 2) + (i3 / 3)) & 1) == 0;
        }
    }

    /* compiled from: DataMask.java */
    /* renamed from: c.b.c.f0.c.c$g */
    private static final class g extends AbstractC1076c {
        private g() {
            super();
        }

        @Override // p031c.p035b.p043c.p062f0.p063c.AbstractC1076c
        /* renamed from: a */
        boolean mo1746a(int i2, int i3) {
            int i4 = i2 * i3;
            return (i4 & 1) + (i4 % 3) == 0;
        }
    }

    /* compiled from: DataMask.java */
    /* renamed from: c.b.c.f0.c.c$h */
    private static final class h extends AbstractC1076c {
        private h() {
            super();
        }

        @Override // p031c.p035b.p043c.p062f0.p063c.AbstractC1076c
        /* renamed from: a */
        boolean mo1746a(int i2, int i3) {
            int i4 = i2 * i3;
            return (((i4 & 1) + (i4 % 3)) & 1) == 0;
        }
    }

    /* compiled from: DataMask.java */
    /* renamed from: c.b.c.f0.c.c$i */
    private static final class i extends AbstractC1076c {
        private i() {
            super();
        }

        @Override // p031c.p035b.p043c.p062f0.p063c.AbstractC1076c
        /* renamed from: a */
        boolean mo1746a(int i2, int i3) {
            return ((((i2 + i3) & 1) + ((i2 * i3) % 3)) & 1) == 0;
        }
    }

    static {
        f2119a = new AbstractC1076c[]{new b(), new c(), new d(), new e(), new f(), new g(), new h(), new i()};
    }

    /* renamed from: a */
    final void m1745a(C1163b c1163b, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                if (mo1746a(i3, i4)) {
                    c1163b.m2169a(i4, i3);
                }
            }
        }
    }

    /* renamed from: a */
    abstract boolean mo1746a(int i2, int i3);

    private AbstractC1076c() {
    }

    /* renamed from: a */
    static AbstractC1076c m1744a(int i2) {
        if (i2 >= 0 && i2 <= 7) {
            return f2119a[i2];
        }
        throw new IllegalArgumentException();
    }
}
