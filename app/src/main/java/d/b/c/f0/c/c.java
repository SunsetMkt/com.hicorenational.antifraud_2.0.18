package d.b.c.f0.c;

/* JADX INFO: compiled from: DataMask.java */
/* JADX INFO: loaded from: classes.dex */
abstract class c {
    private static final c[] a;

    /* JADX INFO: compiled from: DataMask.java */
    private static final class b extends c {
        private b() {
            super();
        }

        @Override // d.b.c.f0.c.c
        boolean a(int i2, int i3) {
            return ((i2 + i3) & 1) == 0;
        }
    }

    /* JADX INFO: renamed from: d.b.c.f0.c.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DataMask.java */
    private static final class C0159c extends c {
        private C0159c() {
            super();
        }

        @Override // d.b.c.f0.c.c
        boolean a(int i2, int i3) {
            return (i2 & 1) == 0;
        }
    }

    /* JADX INFO: compiled from: DataMask.java */
    private static final class d extends c {
        private d() {
            super();
        }

        @Override // d.b.c.f0.c.c
        boolean a(int i2, int i3) {
            return i3 % 3 == 0;
        }
    }

    /* JADX INFO: compiled from: DataMask.java */
    private static final class e extends c {
        private e() {
            super();
        }

        @Override // d.b.c.f0.c.c
        boolean a(int i2, int i3) {
            return (i2 + i3) % 3 == 0;
        }
    }

    /* JADX INFO: compiled from: DataMask.java */
    private static final class f extends c {
        private f() {
            super();
        }

        @Override // d.b.c.f0.c.c
        boolean a(int i2, int i3) {
            return (((i2 / 2) + (i3 / 3)) & 1) == 0;
        }
    }

    /* JADX INFO: compiled from: DataMask.java */
    private static final class g extends c {
        private g() {
            super();
        }

        @Override // d.b.c.f0.c.c
        boolean a(int i2, int i3) {
            int i4 = i2 * i3;
            return (i4 & 1) + (i4 % 3) == 0;
        }
    }

    /* JADX INFO: compiled from: DataMask.java */
    private static final class h extends c {
        private h() {
            super();
        }

        @Override // d.b.c.f0.c.c
        boolean a(int i2, int i3) {
            int i4 = i2 * i3;
            return (((i4 & 1) + (i4 % 3)) & 1) == 0;
        }
    }

    /* JADX INFO: compiled from: DataMask.java */
    private static final class i extends c {
        private i() {
            super();
        }

        @Override // d.b.c.f0.c.c
        boolean a(int i2, int i3) {
            return ((((i2 + i3) & 1) + ((i2 * i3) % 3)) & 1) == 0;
        }
    }

    static {
        a = new c[]{new b(), new C0159c(), new d(), new e(), new f(), new g(), new h(), new i()};
    }

    final void a(d.b.c.z.b bVar, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                if (a(i3, i4)) {
                    bVar.a(i4, i3);
                }
            }
        }
    }

    abstract boolean a(int i2, int i3);

    private c() {
    }

    static c a(int i2) {
        if (i2 >= 0 && i2 <= 7) {
            return a[i2];
        }
        throw new IllegalArgumentException();
    }
}
