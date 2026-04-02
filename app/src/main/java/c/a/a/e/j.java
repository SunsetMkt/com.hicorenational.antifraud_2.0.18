package c.a.a.e;

import android.app.Activity;
import c.a.a.e.d;

/* JADX INFO: compiled from: TimePicker.java */
/* JADX INFO: loaded from: classes.dex */
public class j extends c.a.a.e.d {

    /* JADX INFO: compiled from: TimePicker.java */
    class a implements d.l {
        final /* synthetic */ d a;

        a(d dVar) {
            this.a = dVar;
        }

        @Override // c.a.a.e.d.l
        public void a(int i2, String str) {
            this.a.a(i2, str);
        }

        @Override // c.a.a.e.d.l
        public void b(int i2, String str) {
        }

        @Override // c.a.a.e.d.l
        public void c(int i2, String str) {
            this.a.c(i2, str);
        }

        @Override // c.a.a.e.d.l
        public void d(int i2, String str) {
        }

        @Override // c.a.a.e.d.l
        public void e(int i2, String str) {
        }
    }

    /* JADX INFO: compiled from: TimePicker.java */
    class b implements d.k {
        final /* synthetic */ c a;

        b(c cVar) {
            this.a = cVar;
        }

        @Override // c.a.a.e.d.k
        public void a(String str, String str2) {
            this.a.a(str, str2);
        }
    }

    /* JADX INFO: compiled from: TimePicker.java */
    public interface c {
        void a(String str, String str2);
    }

    /* JADX INFO: compiled from: TimePicker.java */
    public interface d {
        void a(int i2, String str);

        void c(int i2, String str);
    }

    public j(Activity activity) {
        this(activity, 3);
    }

    @Override // c.a.a.e.d
    @Deprecated
    public final void a(String str, String str2, String str3, String str4, String str5) {
        super.a(str, str2, str3, str4, str5);
    }

    @Override // c.a.a.e.d
    @Deprecated
    public final void b(int i2, int i3, int i4) {
        throw new UnsupportedOperationException("Date range nonsupport");
    }

    @Override // c.a.a.e.d
    @Deprecated
    public final void e(int i2, int i3) {
        throw new UnsupportedOperationException("Data range nonsupport");
    }

    @Override // c.a.a.e.d
    @Deprecated
    public final void f(int i2, int i3) {
        throw new UnsupportedOperationException("Date range nonsupport");
    }

    @Override // c.a.a.e.d
    @Deprecated
    public void g(int i2, int i3) {
        super.i(i2, 0);
        super.h(i3, 59);
    }

    @Override // c.a.a.e.d
    @Deprecated
    public void h(int i2, int i3) {
        super.h(i2, i3);
    }

    @Override // c.a.a.e.d
    @Deprecated
    public void i(int i2, int i3) {
        super.i(i2, i3);
    }

    public void j(int i2, int i3) {
        super.h(i2, i3);
    }

    public void k(int i2, int i3) {
        super.i(i2, i3);
    }

    public void l(int i2, int i3) {
        super.a(0, 0, i2, i3);
    }

    @Override // c.a.a.e.d
    @Deprecated
    public final void setOnDateTimePickListener(d.h hVar) {
        super.setOnDateTimePickListener(hVar);
    }

    public void setOnTimePickListener(c cVar) {
        if (cVar == null) {
            return;
        }
        super.setOnDateTimePickListener(new b(cVar));
    }

    @Override // c.a.a.e.d
    @Deprecated
    public final void setOnWheelListener(d.l lVar) {
        super.setOnWheelListener(lVar);
    }

    public j(Activity activity, int i2) {
        super(activity, -1, i2);
    }

    public void a(String str, String str2) {
        super.a("", "", "", str, str2);
    }

    public void setOnWheelListener(d dVar) {
        if (dVar == null) {
            return;
        }
        super.setOnWheelListener(new a(dVar));
    }

    @Override // c.a.a.e.d
    @Deprecated
    public final void a(int i2, int i3, int i4) {
        throw new UnsupportedOperationException("Date range nonsupport");
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
