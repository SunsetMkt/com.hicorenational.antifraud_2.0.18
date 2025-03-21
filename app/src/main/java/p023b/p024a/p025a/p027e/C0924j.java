package p023b.p024a.p025a.p027e;

import android.app.Activity;
import p023b.p024a.p025a.p027e.C0918d;

/* compiled from: TimePicker.java */
/* renamed from: b.a.a.e.j */
/* loaded from: classes.dex */
public class C0924j extends C0918d {

    /* compiled from: TimePicker.java */
    /* renamed from: b.a.a.e.j$a */
    class a implements C0918d.l {

        /* renamed from: a */
        final /* synthetic */ d f1502a;

        a(d dVar) {
            this.f1502a = dVar;
        }

        @Override // p023b.p024a.p025a.p027e.C0918d.l
        /* renamed from: a */
        public void mo875a(int i2, String str) {
            this.f1502a.m994a(i2, str);
        }

        @Override // p023b.p024a.p025a.p027e.C0918d.l
        /* renamed from: b */
        public void mo876b(int i2, String str) {
        }

        @Override // p023b.p024a.p025a.p027e.C0918d.l
        /* renamed from: c */
        public void mo877c(int i2, String str) {
            this.f1502a.m995c(i2, str);
        }

        @Override // p023b.p024a.p025a.p027e.C0918d.l
        /* renamed from: d */
        public void mo878d(int i2, String str) {
        }

        @Override // p023b.p024a.p025a.p027e.C0918d.l
        /* renamed from: e */
        public void mo879e(int i2, String str) {
        }
    }

    /* compiled from: TimePicker.java */
    /* renamed from: b.a.a.e.j$b */
    class b implements C0918d.k {

        /* renamed from: a */
        final /* synthetic */ c f1504a;

        b(c cVar) {
            this.f1504a = cVar;
        }

        @Override // p023b.p024a.p025a.p027e.C0918d.k
        /* renamed from: a */
        public void mo922a(String str, String str2) {
            this.f1504a.m993a(str, str2);
        }
    }

    /* compiled from: TimePicker.java */
    /* renamed from: b.a.a.e.j$c */
    public interface c {
        /* renamed from: a */
        void m993a(String str, String str2);
    }

    /* compiled from: TimePicker.java */
    /* renamed from: b.a.a.e.j$d */
    public interface d {
        /* renamed from: a */
        void m994a(int i2, String str);

        /* renamed from: c */
        void m995c(int i2, String str);
    }

    public C0924j(Activity activity) {
        this(activity, 3);
    }

    @Override // p023b.p024a.p025a.p027e.C0918d
    @Deprecated
    /* renamed from: a */
    public final void mo862a(String str, String str2, String str3, String str4, String str5) {
        super.mo862a(str, str2, str3, str4, str5);
    }

    @Override // p023b.p024a.p025a.p027e.C0918d
    @Deprecated
    /* renamed from: b */
    public final void mo863b(int i2, int i3, int i4) {
        throw new UnsupportedOperationException("Date range nonsupport");
    }

    @Override // p023b.p024a.p025a.p027e.C0918d
    @Deprecated
    /* renamed from: e */
    public final void mo866e(int i2, int i3) {
        throw new UnsupportedOperationException("Data range nonsupport");
    }

    @Override // p023b.p024a.p025a.p027e.C0918d
    @Deprecated
    /* renamed from: f */
    public final void mo868f(int i2, int i3) {
        throw new UnsupportedOperationException("Date range nonsupport");
    }

    @Override // p023b.p024a.p025a.p027e.C0918d
    @Deprecated
    /* renamed from: g */
    public void mo869g(int i2, int i3) {
        super.mo871i(i2, 0);
        super.mo870h(i3, 59);
    }

    @Override // p023b.p024a.p025a.p027e.C0918d
    @Deprecated
    /* renamed from: h */
    public void mo870h(int i2, int i3) {
        super.mo870h(i2, i3);
    }

    @Override // p023b.p024a.p025a.p027e.C0918d
    @Deprecated
    /* renamed from: i */
    public void mo871i(int i2, int i3) {
        super.mo871i(i2, i3);
    }

    /* renamed from: j */
    public void m990j(int i2, int i3) {
        super.mo870h(i2, i3);
    }

    /* renamed from: k */
    public void m991k(int i2, int i3) {
        super.mo871i(i2, i3);
    }

    /* renamed from: l */
    public void m992l(int i2, int i3) {
        super.mo859a(0, 0, i2, i3);
    }

    @Override // p023b.p024a.p025a.p027e.C0918d
    @Deprecated
    public final void setOnDateTimePickListener(C0918d.h hVar) {
        super.setOnDateTimePickListener(hVar);
    }

    public void setOnTimePickListener(c cVar) {
        if (cVar == null) {
            return;
        }
        super.setOnDateTimePickListener(new b(cVar));
    }

    @Override // p023b.p024a.p025a.p027e.C0918d
    @Deprecated
    public final void setOnWheelListener(C0918d.l lVar) {
        super.setOnWheelListener(lVar);
    }

    public C0924j(Activity activity, int i2) {
        super(activity, -1, i2);
    }

    /* renamed from: a */
    public void m989a(String str, String str2) {
        super.mo862a("", "", "", str, str2);
    }

    public void setOnWheelListener(d dVar) {
        if (dVar == null) {
            return;
        }
        super.setOnWheelListener(new a(dVar));
    }

    @Override // p023b.p024a.p025a.p027e.C0918d
    @Deprecated
    /* renamed from: a */
    public final void mo858a(int i2, int i3, int i4) {
        throw new UnsupportedOperationException("Date range nonsupport");
    }

    @Override // p023b.p024a.p025a.p027e.C0918d
    @Deprecated
    /* renamed from: a */
    public final void mo860a(int i2, int i3, int i4, int i5, int i6) {
        super.mo860a(i2, i3, i4, i5, i6);
    }

    @Override // p023b.p024a.p025a.p027e.C0918d
    @Deprecated
    /* renamed from: a */
    public final void mo859a(int i2, int i3, int i4, int i5) {
        super.mo859a(i2, i3, i4, i5);
    }
}
