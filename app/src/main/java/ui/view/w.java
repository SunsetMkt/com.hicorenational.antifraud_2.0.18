package ui.view;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.qqtheme.framework.widget.WheelView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

/* compiled from: TimeSecondPicker.java */
/* loaded from: classes2.dex */
public class w extends b.a.a.e.k {
    public static final int Q0 = -1;
    public static final int R0 = 0;
    public static final int S0 = 1;
    public static final int T0 = 2;
    public static final int U0 = 3;

    @Deprecated
    public static final int V0 = 3;
    public static final int W0 = 4;

    @Deprecated
    public static final int X0 = 4;
    private int A0;
    private int B0;
    private int C0;
    private int D0;
    private int E0;
    private int F0;
    private int G0;
    private int H0;
    private int I0;
    private int J0;
    private int K0;
    private int L0;
    private int M0;
    private int N0;
    private int O0;
    private boolean P0;
    private ArrayList<String> g0;
    private ArrayList<String> h0;
    private ArrayList<String> i0;
    private ArrayList<String> j0;
    private ArrayList<String> k0;
    private ArrayList<String> l0;
    private String m0;
    private String n0;
    private String o0;
    private String p0;
    private String q0;
    private String r0;
    private int s0;
    private int t0;
    private int u0;
    private String v0;
    private String w0;
    private String x0;
    private m y0;
    private i z0;

    /* compiled from: TimeSecondPicker.java */
    class a implements WheelView.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WheelView f20689a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WheelView f20690b;

        a(WheelView wheelView, WheelView wheelView2) {
            this.f20689a = wheelView;
            this.f20690b = wheelView2;
        }

        @Override // cn.qqtheme.framework.widget.WheelView.g
        public void a(int i2) {
            w.this.s0 = i2;
            String str = (String) w.this.g0.get(w.this.s0);
            if (w.this.y0 != null) {
                w.this.y0.e(w.this.s0, str);
            }
            b.a.a.g.d.c(this, "change months after year wheeled");
            if (w.this.P0) {
                w.this.t0 = 0;
                w.this.u0 = 0;
            }
            int c2 = b.a.a.g.c.c(str);
            w.this.E(c2);
            this.f20689a.a(w.this.h0, w.this.t0);
            if (w.this.y0 != null) {
                w.this.y0.d(w.this.t0, (String) w.this.h0.get(w.this.t0));
            }
            w wVar = w.this;
            wVar.h(c2, b.a.a.g.c.c((String) wVar.h0.get(w.this.t0)));
            this.f20690b.a(w.this.i0, w.this.u0);
            if (w.this.y0 != null) {
                w.this.y0.b(w.this.u0, (String) w.this.i0.get(w.this.u0));
            }
        }
    }

    /* compiled from: TimeSecondPicker.java */
    class b implements WheelView.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WheelView f20692a;

        b(WheelView wheelView) {
            this.f20692a = wheelView;
        }

        @Override // cn.qqtheme.framework.widget.WheelView.g
        public void a(int i2) {
            w.this.t0 = i2;
            String str = (String) w.this.h0.get(w.this.t0);
            if (w.this.y0 != null) {
                w.this.y0.d(w.this.t0, str);
            }
            if (w.this.A0 == 0 || w.this.A0 == 2) {
                b.a.a.g.d.c(this, "change days after month wheeled");
                if (w.this.P0) {
                    w.this.u0 = 0;
                }
                w.this.h(w.this.A0 == 0 ? b.a.a.g.c.c(w.this.D()) : Calendar.getInstance(Locale.CHINA).get(1), b.a.a.g.c.c(str));
                this.f20692a.a(w.this.i0, w.this.u0);
                if (w.this.y0 != null) {
                    w.this.y0.b(w.this.u0, (String) w.this.i0.get(w.this.u0));
                }
            }
        }
    }

    /* compiled from: TimeSecondPicker.java */
    class c implements WheelView.g {
        c() {
        }

        @Override // cn.qqtheme.framework.widget.WheelView.g
        public void a(int i2) {
            w.this.u0 = i2;
            if (w.this.y0 != null) {
                w.this.y0.b(w.this.u0, (String) w.this.i0.get(w.this.u0));
            }
        }
    }

    /* compiled from: TimeSecondPicker.java */
    class d implements WheelView.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WheelView f20695a;

        d(WheelView wheelView) {
            this.f20695a = wheelView;
        }

        @Override // cn.qqtheme.framework.widget.WheelView.g
        public void a(int i2) {
            w wVar = w.this;
            wVar.v0 = (String) wVar.j0.get(i2);
            if (w.this.y0 != null) {
                w.this.y0.a(i2, w.this.v0);
            }
            b.a.a.g.d.c(this, "change minutes after hour wheeled");
            w wVar2 = w.this;
            wVar2.D(b.a.a.g.c.c(wVar2.v0));
            this.f20695a.a(w.this.k0, w.this.w0);
        }
    }

    /* compiled from: TimeSecondPicker.java */
    class e implements WheelView.g {
        e() {
        }

        @Override // cn.qqtheme.framework.widget.WheelView.g
        public void a(int i2) {
            w wVar = w.this;
            wVar.w0 = (String) wVar.k0.get(i2);
            if (w.this.y0 != null) {
                w.this.y0.c(i2, w.this.w0);
            }
        }
    }

    /* compiled from: TimeSecondPicker.java */
    class f implements WheelView.g {
        f() {
        }

        @Override // cn.qqtheme.framework.widget.WheelView.g
        public void a(int i2) {
            w wVar = w.this;
            wVar.x0 = (String) wVar.l0.get(i2);
            if (w.this.y0 != null) {
                w.this.y0.f(i2, w.this.x0);
            }
        }
    }

    /* compiled from: TimeSecondPicker.java */
    class g implements Comparator<Object> {
        g() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            String obj3 = obj.toString();
            String obj4 = obj2.toString();
            if (obj3.startsWith("0")) {
                obj3 = obj3.substring(1);
            }
            if (obj4.startsWith("0")) {
                obj4 = obj4.substring(1);
            }
            try {
                return Integer.parseInt(obj3) - Integer.parseInt(obj4);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                return 0;
            }
        }
    }

    /* compiled from: TimeSecondPicker.java */
    @Retention(RetentionPolicy.SOURCE)
    public @interface h {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: TimeSecondPicker.java */
    public interface i {
    }

    /* compiled from: TimeSecondPicker.java */
    @Deprecated
    public interface j extends k {
    }

    /* compiled from: TimeSecondPicker.java */
    public interface k extends i {
        void a(String str, String str2, String str3, String str4, String str5);
    }

    /* compiled from: TimeSecondPicker.java */
    public interface l extends i {
        void a(String str, String str2, String str3);
    }

    /* compiled from: TimeSecondPicker.java */
    public interface m {
        void a(int i2, String str);

        void b(int i2, String str);

        void c(int i2, String str);

        void d(int i2, String str);

        void e(int i2, String str);

        void f(int i2, String str);
    }

    /* compiled from: TimeSecondPicker.java */
    public interface n extends i {
        void a(String str, String str2, String str3, String str4, String str5, String str6);
    }

    /* compiled from: TimeSecondPicker.java */
    @Deprecated
    public interface o extends p {
    }

    /* compiled from: TimeSecondPicker.java */
    public interface p extends i {
        void a(String str, String str2, String str3, String str4, String str5);
    }

    /* compiled from: TimeSecondPicker.java */
    @Retention(RetentionPolicy.SOURCE)
    public @interface q {
    }

    public w(Activity activity, int i2) {
        this(activity, 0, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(int i2) {
        String str;
        int i3;
        int i4 = 1;
        if (this.P0) {
            str = "";
        } else {
            int size = this.h0.size();
            int i5 = this.t0;
            str = size > i5 ? this.h0.get(i5) : b.a.a.g.c.b(Calendar.getInstance().get(2) + 1);
            b.a.a.g.d.c(this, "preSelectMonth=" + str);
        }
        this.h0.clear();
        int i6 = this.D0;
        if (i6 < 1 || (i3 = this.G0) < 1 || i6 > 12 || i3 > 12) {
            throw new IllegalArgumentException("Month out of range [1-12]");
        }
        int i7 = this.C0;
        int i8 = this.F0;
        if (i7 == i8) {
            if (i6 > i3) {
                while (i3 >= this.D0) {
                    this.h0.add(b.a.a.g.c.b(i3));
                    i3--;
                }
            } else {
                while (i6 <= this.G0) {
                    this.h0.add(b.a.a.g.c.b(i6));
                    i6++;
                }
            }
        } else if (i2 == i7) {
            while (i6 <= 12) {
                this.h0.add(b.a.a.g.c.b(i6));
                i6++;
            }
        } else if (i2 == i8) {
            while (i4 <= this.G0) {
                this.h0.add(b.a.a.g.c.b(i4));
                i4++;
            }
        } else {
            while (i4 <= 12) {
                this.h0.add(b.a.a.g.c.b(i4));
                i4++;
            }
        }
        if (this.P0) {
            return;
        }
        int indexOf = this.h0.indexOf(str);
        if (indexOf == -1) {
            indexOf = 0;
        }
        this.t0 = indexOf;
    }

    private void F() {
        this.g0.clear();
        int i2 = this.C0;
        int i3 = this.F0;
        if (i2 == i3) {
            this.g0.add(String.valueOf(i2));
        } else if (i2 < i3) {
            while (i2 <= this.F0) {
                this.g0.add(String.valueOf(i2));
                i2++;
            }
        } else {
            while (i2 >= this.F0) {
                this.g0.add(String.valueOf(i2));
                i2--;
            }
        }
        if (this.P0) {
            return;
        }
        int i4 = this.A0;
        if (i4 == 0 || i4 == 1) {
            int indexOf = this.g0.indexOf(b.a.a.g.c.b(Calendar.getInstance().get(1)));
            if (indexOf == -1) {
                this.s0 = 0;
            } else {
                this.s0 = indexOf;
            }
        }
    }

    public String A() {
        return this.B0 != -1 ? this.w0 : "";
    }

    public String B() {
        if (this.A0 == -1) {
            return "";
        }
        if (this.h0.size() <= this.t0) {
            this.t0 = this.h0.size() - 1;
        }
        return this.h0.get(this.t0);
    }

    public String C() {
        return this.B0 != -1 ? this.x0 : "";
    }

    public String D() {
        int i2 = this.A0;
        if (i2 != 0 && i2 != 1) {
            return "";
        }
        if (this.g0.size() <= this.s0) {
            this.s0 = this.g0.size() - 1;
        }
        return this.g0.get(this.s0);
    }

    @Override // b.a.a.f.b
    protected View r() {
        int i2 = this.A0;
        if ((i2 == 0 || i2 == 1) && this.g0.size() == 0) {
            b.a.a.g.d.c(this, "init years before make view");
            F();
        }
        if (this.A0 != -1 && this.h0.size() == 0) {
            b.a.a.g.d.c(this, "init months before make view");
            E(b.a.a.g.c.c(D()));
        }
        int i3 = this.A0;
        if ((i3 == 0 || i3 == 2) && this.i0.size() == 0) {
            b.a.a.g.d.c(this, "init days before make view");
            h(this.A0 == 0 ? b.a.a.g.c.c(D()) : Calendar.getInstance(Locale.CHINA).get(1), b.a.a.g.c.c(B()));
        }
        if (this.B0 != -1 && this.j0.size() == 0) {
            b.a.a.g.d.c(this, "init hours before make view");
            E();
        }
        if (this.B0 != -1 && this.k0.size() == 0) {
            b.a.a.g.d.c(this, "init minutes before make view");
            D(b.a.a.g.c.c(this.v0));
            F(b.a.a.g.c.c(this.w0));
        }
        LinearLayout linearLayout = new LinearLayout(this.f2289a);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        WheelView x = x();
        WheelView x2 = x();
        WheelView x3 = x();
        WheelView x4 = x();
        WheelView x5 = x();
        WheelView x6 = x();
        int i4 = this.A0;
        if (i4 == 0 || i4 == 1) {
            x.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            x.a(this.g0, this.s0);
            x.setOnItemSelectListener(new a(x2, x3));
            linearLayout.addView(x);
            if (!TextUtils.isEmpty(this.m0)) {
                TextView w = w();
                w.setTextSize(this.O0);
                w.setText(this.m0);
                linearLayout.addView(w);
            }
        }
        if (this.A0 != -1) {
            x2.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            x2.a(this.h0, this.t0);
            x2.setOnItemSelectListener(new b(x3));
            linearLayout.addView(x2);
            if (!TextUtils.isEmpty(this.n0)) {
                TextView w2 = w();
                w2.setTextSize(this.O0);
                w2.setText(this.n0);
                linearLayout.addView(w2);
            }
        }
        int i5 = this.A0;
        if (i5 == 0 || i5 == 2) {
            x3.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            x3.a(this.i0, this.u0);
            x3.setOnItemSelectListener(new c());
            linearLayout.addView(x3);
            if (!TextUtils.isEmpty(this.o0)) {
                TextView w3 = w();
                w3.setTextSize(this.O0);
                w3.setText(this.o0);
                linearLayout.addView(w3);
            }
        }
        if (this.B0 != -1) {
            x4.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            x4.a(this.j0, this.v0);
            x4.setOnItemSelectListener(new d(x5));
            linearLayout.addView(x4);
            if (!TextUtils.isEmpty(this.p0)) {
                TextView w4 = w();
                w4.setTextSize(this.O0);
                w4.setText(this.p0);
                linearLayout.addView(w4);
            }
            x5.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            x5.a(this.k0, this.w0);
            x5.setOnItemSelectListener(new e());
            linearLayout.addView(x5);
            if (!TextUtils.isEmpty(this.q0)) {
                TextView w5 = w();
                w5.setTextSize(this.O0);
                w5.setText(this.q0);
                linearLayout.addView(w5);
            }
            x6.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            x6.a(this.l0, this.x0);
            x6.setOnItemSelectListener(new f());
            linearLayout.addView(x6);
            if (!TextUtils.isEmpty(this.r0)) {
                TextView w6 = w();
                w6.setTextSize(this.O0);
                w6.setText(this.r0);
                linearLayout.addView(w6);
            }
        }
        return linearLayout;
    }

    public void setOnDateTimePickListener(i iVar) {
        this.z0 = iVar;
    }

    public void setOnWheelListener(m mVar) {
        this.y0 = mVar;
    }

    @Override // b.a.a.f.b
    protected void v() {
        if (this.z0 == null) {
            return;
        }
        String D = D();
        String B = B();
        String y = y();
        String z = z();
        String A = A();
        String C = C();
        int i2 = this.A0;
        if (i2 == -1) {
            ((l) this.z0).a(z, A, C);
            return;
        }
        if (i2 == 0) {
            ((n) this.z0).a(D, B, y, z, A, C);
        } else if (i2 == 1) {
            ((p) this.z0).a(D, B, z, A, C);
        } else {
            if (i2 != 2) {
                return;
            }
            ((k) this.z0).a(B, y, z, A, C);
        }
    }

    public String y() {
        int i2 = this.A0;
        if (i2 != 0 && i2 != 2) {
            return "";
        }
        if (this.i0.size() <= this.u0) {
            this.u0 = this.i0.size() - 1;
        }
        return this.i0.get(this.u0);
    }

    public String z() {
        return this.B0 != -1 ? this.v0 : "";
    }

    public w(Activity activity, int i2, int i3) {
        super(activity);
        this.g0 = new ArrayList<>();
        this.h0 = new ArrayList<>();
        this.i0 = new ArrayList<>();
        this.j0 = new ArrayList<>();
        this.k0 = new ArrayList<>();
        this.l0 = new ArrayList<>();
        this.m0 = "年";
        this.n0 = "月";
        this.o0 = "日";
        this.p0 = "时";
        this.q0 = "分";
        this.r0 = "秒";
        this.s0 = 0;
        this.t0 = 0;
        this.u0 = 0;
        this.v0 = "";
        this.w0 = "";
        this.x0 = "";
        this.A0 = 0;
        this.B0 = 3;
        this.C0 = 2010;
        this.D0 = 1;
        this.E0 = 1;
        this.F0 = 2020;
        this.G0 = 12;
        this.H0 = 31;
        this.K0 = 0;
        this.N0 = 59;
        this.O0 = 16;
        this.P0 = true;
        if (i2 == -1 && i3 == -1) {
            throw new IllegalArgumentException("The modes are NONE at the same time");
        }
        if (i2 == 0 && i3 != -1) {
            int i4 = this.f2290b;
            if (i4 < 720) {
                this.O0 = 14;
            } else if (i4 < 480) {
                this.O0 = 12;
            }
        }
        this.A0 = i2;
        if (i3 == 4) {
            this.I0 = 1;
            this.L0 = 12;
        } else {
            this.I0 = 0;
            this.L0 = 23;
        }
        this.B0 = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, int i3) {
        String str;
        int a2 = b.a.a.g.c.a(i2, i3);
        if (this.P0) {
            str = "";
        } else {
            if (this.u0 >= a2) {
                this.u0 = a2 - 1;
            }
            int size = this.i0.size();
            int i4 = this.u0;
            str = size > i4 ? this.i0.get(i4) : b.a.a.g.c.b(Calendar.getInstance().get(5));
            b.a.a.g.d.c(this, "maxDays=" + a2 + ", preSelectDay=" + str);
        }
        this.i0.clear();
        if (i2 == this.C0 && i3 == this.D0 && i2 == this.F0 && i3 == this.G0) {
            for (int i5 = this.E0; i5 <= this.H0; i5++) {
                this.i0.add(b.a.a.g.c.b(i5));
            }
        } else if (i2 == this.C0 && i3 == this.D0) {
            for (int i6 = this.E0; i6 <= a2; i6++) {
                this.i0.add(b.a.a.g.c.b(i6));
            }
        } else {
            int i7 = 1;
            if (i2 == this.F0 && i3 == this.G0) {
                while (i7 <= this.H0) {
                    this.i0.add(b.a.a.g.c.b(i7));
                    i7++;
                }
            } else {
                while (i7 <= a2) {
                    this.i0.add(b.a.a.g.c.b(i7));
                    i7++;
                }
            }
        }
        if (this.P0) {
            return;
        }
        int indexOf = this.i0.indexOf(str);
        if (indexOf == -1) {
            indexOf = 0;
        }
        this.u0 = indexOf;
    }

    public void f(int i2, int i3) {
        int i4 = this.A0;
        if (i4 == -1) {
            throw new IllegalArgumentException("Date mode invalid");
        }
        if (i4 == 0) {
            throw new IllegalArgumentException("Not support year/month/day mode");
        }
        if (i4 == 1) {
            this.C0 = i2;
            this.D0 = i3;
        } else if (i4 == 2) {
            int i5 = Calendar.getInstance(Locale.CHINA).get(1);
            this.F0 = i5;
            this.C0 = i5;
            this.D0 = i2;
            this.E0 = i3;
        }
        F();
    }

    @Deprecated
    public void g(int i2, int i3) {
        if (this.A0 == -1) {
            throw new IllegalArgumentException("Date mode invalid");
        }
        this.C0 = i2;
        this.F0 = i3;
        F();
    }

    public void o(boolean z) {
        this.P0 = z;
    }

    public void d(int i2, int i3, int i4) {
        if (this.B0 != -1) {
            boolean z = i2 < 0 || i3 < 0 || i3 > 59 || i4 < 0 || i4 > 59;
            if (this.B0 == 4 && (i2 == 0 || i2 > 12)) {
                z = true;
            }
            if (this.B0 == 3 && i2 >= 24) {
                z = true;
            }
            if (!z) {
                this.I0 = i2;
                this.J0 = i3;
                this.K0 = i4;
                E();
                return;
            }
            throw new IllegalArgumentException("Time out of range");
        }
        throw new IllegalArgumentException("Time mode invalid");
    }

    public void e(int i2, int i3) {
        int i4 = this.A0;
        if (i4 == -1) {
            throw new IllegalArgumentException("Date mode invalid");
        }
        if (i4 != 0) {
            if (i4 == 1) {
                this.F0 = i2;
                this.G0 = i3;
            } else if (i4 == 2) {
                this.G0 = i2;
                this.H0 = i3;
            }
            F();
            return;
        }
        throw new IllegalArgumentException("Not support year/month/day mode");
    }

    public void b(int i2, int i3, int i4) {
        if (this.A0 != -1) {
            this.C0 = i2;
            this.D0 = i3;
            this.E0 = i4;
            F();
            return;
        }
        throw new IllegalArgumentException("Date mode invalid");
    }

    public void c(int i2, int i3, int i4) {
        if (this.B0 != -1) {
            boolean z = i2 < 0 || i3 < 0 || i3 > 59 || i4 < 0 || i4 > 59;
            if (this.B0 == 4 && (i2 == 0 || i2 > 12)) {
                z = true;
            }
            if (this.B0 == 3 && i2 >= 24) {
                z = true;
            }
            if (!z) {
                this.L0 = i2;
                this.M0 = i3;
                this.N0 = i4;
                E();
                return;
            }
            throw new IllegalArgumentException("Time out of range");
        }
        throw new IllegalArgumentException("Time mode invalid");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(int i2) {
        this.k0.clear();
        int i3 = this.I0;
        int i4 = this.L0;
        if (i3 == i4) {
            int i5 = this.J0;
            int i6 = this.M0;
            if (i5 > i6) {
                this.J0 = i6;
                this.M0 = i5;
            }
            for (int i7 = this.J0; i7 <= this.M0; i7++) {
                this.k0.add(b.a.a.g.c.b(i7));
            }
        } else if (i2 == i3) {
            for (int i8 = this.J0; i8 <= 59; i8++) {
                this.k0.add(b.a.a.g.c.b(i8));
            }
        } else if (i2 == i4) {
            for (int i9 = 0; i9 <= this.M0; i9++) {
                this.k0.add(b.a.a.g.c.b(i9));
            }
        } else {
            for (int i10 = 0; i10 <= 59; i10++) {
                this.k0.add(b.a.a.g.c.b(i10));
            }
        }
        if (this.k0.indexOf(this.w0) == -1) {
            this.w0 = this.k0.get(0);
        }
    }

    public void a(int i2, int i3, int i4) {
        if (this.A0 != -1) {
            this.F0 = i2;
            this.G0 = i3;
            this.H0 = i4;
            F();
            return;
        }
        throw new IllegalArgumentException("Date mode invalid");
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6) {
        this.m0 = str;
        this.n0 = str2;
        this.o0 = str3;
        this.p0 = str4;
        this.q0 = str5;
        this.r0 = str6;
    }

    private void F(int i2) {
        this.l0.clear();
        int i3 = this.J0;
        int i4 = this.M0;
        if (i3 == i4) {
            int i5 = this.K0;
            int i6 = this.N0;
            if (i5 > i6) {
                this.K0 = i6;
                this.N0 = i5;
            }
            for (int i7 = this.K0; i7 <= this.N0; i7++) {
                this.l0.add(b.a.a.g.c.b(i7));
            }
        } else if (i2 == i3) {
            for (int i8 = this.K0; i8 <= 59; i8++) {
                this.l0.add(b.a.a.g.c.b(i8));
            }
        } else if (i2 == i4) {
            for (int i9 = 0; i9 <= this.N0; i9++) {
                this.l0.add(b.a.a.g.c.b(i9));
            }
        } else {
            for (int i10 = 0; i10 <= 59; i10++) {
                this.l0.add(b.a.a.g.c.b(i10));
            }
        }
        if (this.l0.indexOf(this.x0) == -1) {
            this.x0 = this.l0.get(0);
        }
    }

    public void a(int i2, int i3, int i4, int i5, int i6, int i7) {
        if (this.A0 == 0) {
            b.a.a.g.d.c(this, "change months and days while set selected");
            E(i2);
            h(i2, i3);
            this.s0 = a(this.g0, i2);
            this.t0 = a(this.h0, i3);
            this.u0 = a(this.i0, i4);
            if (this.B0 != -1) {
                this.v0 = b.a.a.g.c.b(i5);
                this.w0 = b.a.a.g.c.b(i6);
                this.x0 = b.a.a.g.c.b(i7);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Date mode invalid");
    }

    private void E() {
        int i2;
        this.j0.clear();
        if (this.P0) {
            i2 = 0;
        } else if (this.B0 == 3) {
            i2 = Calendar.getInstance().get(11);
        } else {
            i2 = Calendar.getInstance().get(10);
        }
        for (int i3 = this.I0; i3 <= this.L0; i3++) {
            String b2 = b.a.a.g.c.b(i3);
            if (!this.P0 && i3 == i2) {
                this.v0 = b2;
            }
            this.j0.add(b2);
        }
        if (this.j0.indexOf(this.v0) == -1) {
            this.v0 = this.j0.get(0);
        }
        if (this.P0) {
            return;
        }
        this.w0 = b.a.a.g.c.b(Calendar.getInstance().get(12));
        this.x0 = b.a.a.g.c.b(Calendar.getInstance().get(13));
    }

    public void a(int i2, int i3, int i4, int i5, int i6) {
        int i7 = this.A0;
        if (i7 != 0) {
            if (i7 == 2) {
                b.a.a.g.d.c(this, "change months and days while set selected");
                int i8 = Calendar.getInstance(Locale.CHINA).get(1);
                this.F0 = i8;
                this.C0 = i8;
                E(i8);
                h(i8, i2);
                this.t0 = a(this.h0, i2);
                this.u0 = a(this.i0, i3);
            } else if (i7 == 1) {
                b.a.a.g.d.c(this, "change months while set selected");
                E(i2);
                this.s0 = a(this.g0, i2);
                this.t0 = a(this.h0, i3);
            }
            if (this.B0 != -1) {
                this.v0 = b.a.a.g.c.b(i4);
                this.w0 = b.a.a.g.c.b(i5);
                this.x0 = b.a.a.g.c.b(i6);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Date mode invalid");
    }

    private int a(ArrayList<String> arrayList, int i2) {
        int binarySearch = Collections.binarySearch(arrayList, Integer.valueOf(i2), new g());
        if (binarySearch >= 0) {
            return binarySearch;
        }
        throw new IllegalArgumentException("Item[" + i2 + "] out of range");
    }
}
