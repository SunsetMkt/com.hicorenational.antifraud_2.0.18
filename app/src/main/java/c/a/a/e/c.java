package c.a.a.e;

import android.app.Activity;
import c.a.a.e.d;

/* JADX INFO: compiled from: DatePicker.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends c.a.a.e.d {

    /* JADX INFO: compiled from: DatePicker.java */
    class a implements d.l {
        final /* synthetic */ g a;

        a(g gVar) {
            this.a = gVar;
        }

        @Override // c.a.a.e.d.l
        public void a(int i2, String str) {
        }

        @Override // c.a.a.e.d.l
        public void b(int i2, String str) {
            this.a.b(i2, str);
        }

        @Override // c.a.a.e.d.l
        public void c(int i2, String str) {
        }

        @Override // c.a.a.e.d.l
        public void d(int i2, String str) {
            this.a.d(i2, str);
        }

        @Override // c.a.a.e.d.l
        public void e(int i2, String str) {
            this.a.e(i2, str);
        }
    }

    /* JADX INFO: compiled from: DatePicker.java */
    class b implements d.m {
        final /* synthetic */ e a;

        b(e eVar) {
            this.a = eVar;
        }

        @Override // c.a.a.e.d.m
        public void a(String str, String str2, String str3, String str4, String str5) {
            ((h) this.a).a(str, str2, str3);
        }
    }

    /* JADX INFO: renamed from: c.a.a.e.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DatePicker.java */
    class C0026c implements d.o {
        final /* synthetic */ e a;

        C0026c(e eVar) {
            this.a = eVar;
        }

        @Override // c.a.a.e.d.o
        public void a(String str, String str2, String str3, String str4) {
            ((i) this.a).a(str, str2);
        }
    }

    /* JADX INFO: compiled from: DatePicker.java */
    class d implements d.j {
        final /* synthetic */ e a;

        d(e eVar) {
            this.a = eVar;
        }

        @Override // c.a.a.e.d.j
        public void a(String str, String str2, String str3, String str4) {
            ((f) this.a).a(str, str2);
        }
    }

    /* JADX INFO: compiled from: DatePicker.java */
    protected interface e {
    }

    /* JADX INFO: compiled from: DatePicker.java */
    public interface f extends e {
        void a(String str, String str2);
    }

    /* JADX INFO: compiled from: DatePicker.java */
    public interface g {
        void b(int i2, String str);

        void d(int i2, String str);

        void e(int i2, String str);
    }

    /* JADX INFO: compiled from: DatePicker.java */
    public interface h extends e {
        void a(String str, String str2, String str3);
    }

    /* JADX INFO: compiled from: DatePicker.java */
    public interface i extends e {
        void a(String str, String str2);
    }

    public c(Activity activity) {
        this(activity, 0);
    }

    @Override // c.a.a.e.d
    @Deprecated
    public final void a(String str, String str2, String str3, String str4, String str5) {
        super.a(str, str2, str3, str4, str5);
    }

    @Override // c.a.a.e.d
    @Deprecated
    public final void b(int i2, int i3, int i4) {
        super.b(i2, i3, i4);
    }

    public void c(int i2, int i3, int i4) {
        super.a(i2, i3, i4);
    }

    public void d(int i2, int i3, int i4) {
        super.b(i2, i3, i4);
    }

    @Override // c.a.a.e.d
    @Deprecated
    public final void e(int i2, int i3) {
        super.e(i2, i3);
    }

    @Override // c.a.a.e.d
    @Deprecated
    public final void f(int i2, int i3) {
        super.f(i2, i3);
    }

    @Override // c.a.a.e.d
    @Deprecated
    public void g(int i2, int i3) {
        super.g(i2, i3);
    }

    @Override // c.a.a.e.d
    @Deprecated
    public void h(int i2, int i3) {
        throw new UnsupportedOperationException("Time range nonsupport");
    }

    @Override // c.a.a.e.d
    @Deprecated
    public void i(int i2, int i3) {
        throw new UnsupportedOperationException("Time range nonsupport");
    }

    public void j(int i2, int i3) {
        super.e(i2, i3);
    }

    public void k(int i2, int i3) {
        super.f(i2, i3);
    }

    public void l(int i2, int i3) {
        super.a(i2, i3, 0, 0);
    }

    public void setOnDatePickListener(e eVar) {
        if (eVar == null) {
            return;
        }
        if (eVar instanceof h) {
            super.setOnDateTimePickListener(new b(eVar));
        } else if (eVar instanceof i) {
            super.setOnDateTimePickListener(new C0026c(eVar));
        } else if (eVar instanceof f) {
            super.setOnDateTimePickListener(new d(eVar));
        }
    }

    @Override // c.a.a.e.d
    @Deprecated
    public final void setOnDateTimePickListener(d.h hVar) {
        super.setOnDateTimePickListener(hVar);
    }

    @Override // c.a.a.e.d
    @Deprecated
    public final void setOnWheelListener(d.l lVar) {
        super.setOnWheelListener(lVar);
    }

    public c(Activity activity, int i2) {
        super(activity, i2, -1);
    }

    public void a(String str, String str2, String str3) {
        super.a(str, str2, str3, "", "");
    }

    public void e(int i2, int i3, int i4) {
        super.a(i2, i3, i4, 0, 0);
    }

    public void setOnWheelListener(g gVar) {
        if (gVar == null) {
            return;
        }
        super.setOnWheelListener(new a(gVar));
    }

    @Override // c.a.a.e.d
    @Deprecated
    public final void a(int i2, int i3, int i4) {
        super.a(i2, i3, i4);
    }

    @Override // c.a.a.e.d
    @Deprecated
    public final void a(int i2, int i3, int i4, int i5, int i6) {
        super.a(i2, i3, i4, i5, i6);
    }

    @Override // c.a.a.e.d
    @Deprecated
    public final void a(int i2, int i3, int i4, int i5) {
        super.a(i2, i3, i4, i5);
    }
}
