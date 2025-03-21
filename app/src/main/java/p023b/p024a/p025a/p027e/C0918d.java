package p023b.p024a.p025a.p027e;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.qqtheme.framework.widget.WheelView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import p023b.p024a.p025a.p029g.C0930c;
import p023b.p024a.p025a.p029g.C0931d;

/* compiled from: DateTimePicker.java */
/* renamed from: b.a.a.e.d */
/* loaded from: classes.dex */
public class C0918d extends AbstractC0925k {

    /* renamed from: L0 */
    public static final int f1402L0 = -1;

    /* renamed from: M0 */
    public static final int f1403M0 = 0;

    /* renamed from: N0 */
    public static final int f1404N0 = 1;

    /* renamed from: O0 */
    public static final int f1405O0 = 2;

    /* renamed from: P0 */
    public static final int f1406P0 = 3;

    /* renamed from: Q0 */
    @Deprecated
    public static final int f1407Q0 = 3;

    /* renamed from: R0 */
    public static final int f1408R0 = 4;

    /* renamed from: S0 */
    @Deprecated
    public static final int f1409S0 = 4;

    /* renamed from: A0 */
    private int f1410A0;

    /* renamed from: B0 */
    private int f1411B0;

    /* renamed from: C0 */
    private int f1412C0;

    /* renamed from: D0 */
    private int f1413D0;

    /* renamed from: E0 */
    private int f1414E0;

    /* renamed from: F0 */
    private int f1415F0;

    /* renamed from: G0 */
    private int f1416G0;

    /* renamed from: H0 */
    private int f1417H0;

    /* renamed from: I0 */
    private int f1418I0;

    /* renamed from: J0 */
    private int f1419J0;

    /* renamed from: K0 */
    private boolean f1420K0;

    /* renamed from: g0 */
    private ArrayList<String> f1421g0;

    /* renamed from: h0 */
    private ArrayList<String> f1422h0;

    /* renamed from: i0 */
    private ArrayList<String> f1423i0;

    /* renamed from: j0 */
    private ArrayList<String> f1424j0;

    /* renamed from: k0 */
    private ArrayList<String> f1425k0;

    /* renamed from: l0 */
    private String f1426l0;

    /* renamed from: m0 */
    private String f1427m0;

    /* renamed from: n0 */
    private String f1428n0;

    /* renamed from: o0 */
    private String f1429o0;

    /* renamed from: p0 */
    private String f1430p0;

    /* renamed from: q0 */
    private int f1431q0;

    /* renamed from: r0 */
    private int f1432r0;

    /* renamed from: s0 */
    private int f1433s0;

    /* renamed from: t0 */
    private String f1434t0;

    /* renamed from: u0 */
    private String f1435u0;

    /* renamed from: v0 */
    private l f1436v0;

    /* renamed from: w0 */
    private h f1437w0;

    /* renamed from: x0 */
    private int f1438x0;

    /* renamed from: y0 */
    private int f1439y0;

    /* renamed from: z0 */
    private int f1440z0;

    /* compiled from: DateTimePicker.java */
    /* renamed from: b.a.a.e.d$a */
    class a implements WheelView.InterfaceC1290g {

        /* renamed from: a */
        final /* synthetic */ WheelView f1441a;

        /* renamed from: b */
        final /* synthetic */ WheelView f1442b;

        a(WheelView wheelView, WheelView wheelView2) {
            this.f1441a = wheelView;
            this.f1442b = wheelView2;
        }

        @Override // cn.qqtheme.framework.widget.WheelView.InterfaceC1290g
        /* renamed from: a */
        public void mo848a(int i2) {
            C0918d.this.f1431q0 = i2;
            String str = (String) C0918d.this.f1421g0.get(C0918d.this.f1431q0);
            if (C0918d.this.f1436v0 != null) {
                C0918d.this.f1436v0.mo879e(C0918d.this.f1431q0, str);
            }
            C0931d.m1156c(this, "change months after year wheeled");
            if (C0918d.this.f1420K0) {
                C0918d.this.f1432r0 = 0;
                C0918d.this.f1433s0 = 0;
            }
            int m1136c = C0930c.m1136c(str);
            C0918d.this.m892E(m1136c);
            this.f1441a.m2593a(C0918d.this.f1422h0, C0918d.this.f1432r0);
            if (C0918d.this.f1436v0 != null) {
                C0918d.this.f1436v0.mo878d(C0918d.this.f1432r0, (String) C0918d.this.f1422h0.get(C0918d.this.f1432r0));
            }
            C0918d c0918d = C0918d.this;
            c0918d.m912j(m1136c, C0930c.m1136c((String) c0918d.f1422h0.get(C0918d.this.f1432r0)));
            this.f1442b.m2593a(C0918d.this.f1423i0, C0918d.this.f1433s0);
            if (C0918d.this.f1436v0 != null) {
                C0918d.this.f1436v0.mo876b(C0918d.this.f1433s0, (String) C0918d.this.f1423i0.get(C0918d.this.f1433s0));
            }
        }
    }

    /* compiled from: DateTimePicker.java */
    /* renamed from: b.a.a.e.d$b */
    class b implements WheelView.InterfaceC1290g {

        /* renamed from: a */
        final /* synthetic */ WheelView f1444a;

        b(WheelView wheelView) {
            this.f1444a = wheelView;
        }

        @Override // cn.qqtheme.framework.widget.WheelView.InterfaceC1290g
        /* renamed from: a */
        public void mo848a(int i2) {
            C0918d.this.f1432r0 = i2;
            String str = (String) C0918d.this.f1422h0.get(C0918d.this.f1432r0);
            if (C0918d.this.f1436v0 != null) {
                C0918d.this.f1436v0.mo878d(C0918d.this.f1432r0, str);
            }
            if (C0918d.this.f1438x0 == 0 || C0918d.this.f1438x0 == 2) {
                C0931d.m1156c(this, "change days after month wheeled");
                if (C0918d.this.f1420K0) {
                    C0918d.this.f1433s0 = 0;
                }
                C0918d.this.m912j(C0918d.this.f1438x0 == 0 ? C0930c.m1136c(C0918d.this.m918C()) : Calendar.getInstance(Locale.CHINA).get(1), C0930c.m1136c(str));
                this.f1444a.m2593a(C0918d.this.f1423i0, C0918d.this.f1433s0);
                if (C0918d.this.f1436v0 != null) {
                    C0918d.this.f1436v0.mo876b(C0918d.this.f1433s0, (String) C0918d.this.f1423i0.get(C0918d.this.f1433s0));
                }
            }
        }
    }

    /* compiled from: DateTimePicker.java */
    /* renamed from: b.a.a.e.d$c */
    class c implements WheelView.InterfaceC1290g {
        c() {
        }

        @Override // cn.qqtheme.framework.widget.WheelView.InterfaceC1290g
        /* renamed from: a */
        public void mo848a(int i2) {
            C0918d.this.f1433s0 = i2;
            if (C0918d.this.f1436v0 != null) {
                C0918d.this.f1436v0.mo876b(C0918d.this.f1433s0, (String) C0918d.this.f1423i0.get(C0918d.this.f1433s0));
            }
        }
    }

    /* compiled from: DateTimePicker.java */
    /* renamed from: b.a.a.e.d$d */
    class d implements WheelView.InterfaceC1290g {

        /* renamed from: a */
        final /* synthetic */ WheelView f1447a;

        d(WheelView wheelView) {
            this.f1447a = wheelView;
        }

        @Override // cn.qqtheme.framework.widget.WheelView.InterfaceC1290g
        /* renamed from: a */
        public void mo848a(int i2) {
            C0918d c0918d = C0918d.this;
            c0918d.f1434t0 = (String) c0918d.f1424j0.get(i2);
            if (C0918d.this.f1436v0 != null) {
                C0918d.this.f1436v0.mo875a(i2, C0918d.this.f1434t0);
            }
            C0931d.m1156c(this, "change minutes after hour wheeled");
            C0918d c0918d2 = C0918d.this;
            c0918d2.m890D(C0930c.m1136c(c0918d2.f1434t0));
            this.f1447a.m2594a(C0918d.this.f1425k0, C0918d.this.f1435u0);
        }
    }

    /* compiled from: DateTimePicker.java */
    /* renamed from: b.a.a.e.d$e */
    class e implements WheelView.InterfaceC1290g {
        e() {
        }

        @Override // cn.qqtheme.framework.widget.WheelView.InterfaceC1290g
        /* renamed from: a */
        public void mo848a(int i2) {
            C0918d c0918d = C0918d.this;
            c0918d.f1435u0 = (String) c0918d.f1425k0.get(i2);
            if (C0918d.this.f1436v0 != null) {
                C0918d.this.f1436v0.mo877c(i2, C0918d.this.f1435u0);
            }
        }
    }

    /* compiled from: DateTimePicker.java */
    /* renamed from: b.a.a.e.d$f */
    class f implements Comparator<Object> {
        f() {
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

    /* compiled from: DateTimePicker.java */
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: b.a.a.e.d$g */
    public @interface g {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: DateTimePicker.java */
    /* renamed from: b.a.a.e.d$h */
    public interface h {
    }

    /* compiled from: DateTimePicker.java */
    @Deprecated
    /* renamed from: b.a.a.e.d$i */
    public interface i extends j {
    }

    /* compiled from: DateTimePicker.java */
    /* renamed from: b.a.a.e.d$j */
    public interface j extends h {
        /* renamed from: a */
        void mo882a(String str, String str2, String str3, String str4);
    }

    /* compiled from: DateTimePicker.java */
    /* renamed from: b.a.a.e.d$k */
    public interface k extends h {
        /* renamed from: a */
        void mo922a(String str, String str2);
    }

    /* compiled from: DateTimePicker.java */
    /* renamed from: b.a.a.e.d$l */
    public interface l {
        /* renamed from: a */
        void mo875a(int i2, String str);

        /* renamed from: b */
        void mo876b(int i2, String str);

        /* renamed from: c */
        void mo877c(int i2, String str);

        /* renamed from: d */
        void mo878d(int i2, String str);

        /* renamed from: e */
        void mo879e(int i2, String str);
    }

    /* compiled from: DateTimePicker.java */
    /* renamed from: b.a.a.e.d$m */
    public interface m extends h {
        /* renamed from: a */
        void mo880a(String str, String str2, String str3, String str4, String str5);
    }

    /* compiled from: DateTimePicker.java */
    @Deprecated
    /* renamed from: b.a.a.e.d$n */
    public interface n extends o {
    }

    /* compiled from: DateTimePicker.java */
    /* renamed from: b.a.a.e.d$o */
    public interface o extends h {
        /* renamed from: a */
        void mo881a(String str, String str2, String str3, String str4);
    }

    /* compiled from: DateTimePicker.java */
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: b.a.a.e.d$p */
    public @interface p {
    }

    public C0918d(Activity activity, int i2) {
        this(activity, 0, i2);
    }

    /* renamed from: D */
    private void m889D() {
        this.f1424j0.clear();
        int i2 = !this.f1420K0 ? this.f1439y0 == 3 ? Calendar.getInstance().get(11) : Calendar.getInstance().get(10) : 0;
        for (int i3 = this.f1415F0; i3 <= this.f1417H0; i3++) {
            String m1134b = C0930c.m1134b(i3);
            if (!this.f1420K0 && i3 == i2) {
                this.f1434t0 = m1134b;
            }
            this.f1424j0.add(m1134b);
        }
        if (this.f1424j0.indexOf(this.f1434t0) == -1) {
            this.f1434t0 = this.f1424j0.get(0);
        }
        if (this.f1420K0) {
            return;
        }
        this.f1435u0 = C0930c.m1134b(Calendar.getInstance().get(12));
    }

    /* renamed from: E */
    private void m891E() {
        this.f1421g0.clear();
        int i2 = this.f1440z0;
        int i3 = this.f1412C0;
        if (i2 == i3) {
            this.f1421g0.add(String.valueOf(i2));
        } else if (i2 < i3) {
            while (i2 <= this.f1412C0) {
                this.f1421g0.add(String.valueOf(i2));
                i2++;
            }
        } else {
            while (i2 >= this.f1412C0) {
                this.f1421g0.add(String.valueOf(i2));
                i2--;
            }
        }
        if (this.f1420K0) {
            return;
        }
        int i4 = this.f1438x0;
        if (i4 == 0 || i4 == 1) {
            int indexOf = this.f1421g0.indexOf(C0930c.m1134b(Calendar.getInstance().get(1)));
            if (indexOf == -1) {
                this.f1431q0 = 0;
            } else {
                this.f1431q0 = indexOf;
            }
        }
    }

    /* renamed from: A */
    public String m916A() {
        return this.f1439y0 != -1 ? this.f1435u0 : "";
    }

    /* renamed from: B */
    public String m917B() {
        if (this.f1438x0 == -1) {
            return "";
        }
        if (this.f1422h0.size() <= this.f1432r0) {
            this.f1432r0 = this.f1422h0.size() - 1;
        }
        return this.f1422h0.get(this.f1432r0);
    }

    /* renamed from: C */
    public String m918C() {
        int i2 = this.f1438x0;
        if (i2 != 0 && i2 != 1) {
            return "";
        }
        if (this.f1421g0.size() <= this.f1431q0) {
            this.f1431q0 = this.f1421g0.size() - 1;
        }
        return this.f1421g0.get(this.f1431q0);
    }

    /* renamed from: o */
    public void m919o(boolean z) {
        this.f1420K0 = z;
    }

    @Override // p023b.p024a.p025a.p028f.AbstractC0927b
    @NonNull
    /* renamed from: r */
    protected View mo846r() {
        int i2 = this.f1438x0;
        if ((i2 == 0 || i2 == 1) && this.f1421g0.size() == 0) {
            C0931d.m1156c(this, "init years before make view");
            m891E();
        }
        if (this.f1438x0 != -1 && this.f1422h0.size() == 0) {
            C0931d.m1156c(this, "init months before make view");
            m892E(C0930c.m1136c(m918C()));
        }
        int i3 = this.f1438x0;
        if ((i3 == 0 || i3 == 2) && this.f1423i0.size() == 0) {
            C0931d.m1156c(this, "init days before make view");
            m912j(this.f1438x0 == 0 ? C0930c.m1136c(m918C()) : Calendar.getInstance(Locale.CHINA).get(1), C0930c.m1136c(m917B()));
        }
        if (this.f1439y0 != -1 && this.f1424j0.size() == 0) {
            C0931d.m1156c(this, "init hours before make view");
            m889D();
        }
        if (this.f1439y0 != -1 && this.f1425k0.size() == 0) {
            C0931d.m1156c(this, "init minutes before make view");
            m890D(C0930c.m1136c(this.f1434t0));
        }
        LinearLayout linearLayout = new LinearLayout(this.f1520a);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        WheelView m1016x = m1016x();
        WheelView m1016x2 = m1016x();
        WheelView m1016x3 = m1016x();
        WheelView m1016x4 = m1016x();
        WheelView m1016x5 = m1016x();
        int i4 = this.f1438x0;
        if (i4 == 0 || i4 == 1) {
            m1016x.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            m1016x.m2593a(this.f1421g0, this.f1431q0);
            m1016x.setOnItemSelectListener(new a(m1016x2, m1016x3));
            linearLayout.addView(m1016x);
            if (!TextUtils.isEmpty(this.f1426l0)) {
                TextView m1014w = m1014w();
                m1014w.setTextSize(this.f1419J0);
                m1014w.setText(this.f1426l0);
                linearLayout.addView(m1014w);
            }
        }
        if (this.f1438x0 != -1) {
            m1016x2.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            m1016x2.m2593a(this.f1422h0, this.f1432r0);
            m1016x2.setOnItemSelectListener(new b(m1016x3));
            linearLayout.addView(m1016x2);
            if (!TextUtils.isEmpty(this.f1427m0)) {
                TextView m1014w2 = m1014w();
                m1014w2.setTextSize(this.f1419J0);
                m1014w2.setText(this.f1427m0);
                linearLayout.addView(m1014w2);
            }
        }
        int i5 = this.f1438x0;
        if (i5 == 0 || i5 == 2) {
            m1016x3.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            m1016x3.m2593a(this.f1423i0, this.f1433s0);
            m1016x3.setOnItemSelectListener(new c());
            linearLayout.addView(m1016x3);
            if (!TextUtils.isEmpty(this.f1428n0)) {
                TextView m1014w3 = m1014w();
                m1014w3.setTextSize(this.f1419J0);
                m1014w3.setText(this.f1428n0);
                linearLayout.addView(m1014w3);
            }
        }
        if (this.f1439y0 != -1) {
            m1016x4.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            m1016x4.m2594a(this.f1424j0, this.f1434t0);
            m1016x4.setOnItemSelectListener(new d(m1016x5));
            linearLayout.addView(m1016x4);
            if (!TextUtils.isEmpty(this.f1429o0)) {
                TextView m1014w4 = m1014w();
                m1014w4.setTextSize(this.f1419J0);
                m1014w4.setText(this.f1429o0);
                linearLayout.addView(m1014w4);
            }
            m1016x5.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            m1016x5.m2594a(this.f1425k0, this.f1435u0);
            m1016x5.setOnItemSelectListener(new e());
            linearLayout.addView(m1016x5);
            if (!TextUtils.isEmpty(this.f1430p0)) {
                TextView m1014w5 = m1014w();
                m1014w5.setTextSize(this.f1419J0);
                m1014w5.setText(this.f1430p0);
                linearLayout.addView(m1014w5);
            }
        }
        return linearLayout;
    }

    public void setOnDateTimePickListener(h hVar) {
        this.f1437w0 = hVar;
    }

    public void setOnWheelListener(l lVar) {
        this.f1436v0 = lVar;
    }

    @Override // p023b.p024a.p025a.p028f.AbstractC0927b
    /* renamed from: v */
    protected void mo847v() {
        if (this.f1437w0 == null) {
            return;
        }
        String m918C = m918C();
        String m917B = m917B();
        String m920y = m920y();
        String m921z = m921z();
        String m916A = m916A();
        int i2 = this.f1438x0;
        if (i2 == -1) {
            ((k) this.f1437w0).mo922a(m921z, m916A);
            return;
        }
        if (i2 == 0) {
            ((m) this.f1437w0).mo880a(m918C, m917B, m920y, m921z, m916A);
        } else if (i2 == 1) {
            ((o) this.f1437w0).mo881a(m918C, m917B, m921z, m916A);
        } else {
            if (i2 != 2) {
                return;
            }
            ((j) this.f1437w0).mo882a(m917B, m920y, m921z, m916A);
        }
    }

    /* renamed from: y */
    public String m920y() {
        int i2 = this.f1438x0;
        if (i2 != 0 && i2 != 2) {
            return "";
        }
        if (this.f1423i0.size() <= this.f1433s0) {
            this.f1433s0 = this.f1423i0.size() - 1;
        }
        return this.f1423i0.get(this.f1433s0);
    }

    /* renamed from: z */
    public String m921z() {
        return this.f1439y0 != -1 ? this.f1434t0 : "";
    }

    public C0918d(Activity activity, int i2, int i3) {
        super(activity);
        this.f1421g0 = new ArrayList<>();
        this.f1422h0 = new ArrayList<>();
        this.f1423i0 = new ArrayList<>();
        this.f1424j0 = new ArrayList<>();
        this.f1425k0 = new ArrayList<>();
        this.f1426l0 = "年";
        this.f1427m0 = "月";
        this.f1428n0 = "日";
        this.f1429o0 = "时";
        this.f1430p0 = "分";
        this.f1431q0 = 0;
        this.f1432r0 = 0;
        this.f1433s0 = 0;
        this.f1434t0 = "";
        this.f1435u0 = "";
        this.f1438x0 = 0;
        this.f1439y0 = 3;
        this.f1440z0 = 2010;
        this.f1410A0 = 1;
        this.f1411B0 = 1;
        this.f1412C0 = 2020;
        this.f1413D0 = 12;
        this.f1414E0 = 31;
        this.f1416G0 = 0;
        this.f1418I0 = 59;
        this.f1419J0 = 16;
        this.f1420K0 = true;
        if (i2 == -1 && i3 == -1) {
            throw new IllegalArgumentException("The modes are NONE at the same time");
        }
        if (i2 == 0 && i3 != -1) {
            int i4 = this.f1521b;
            if (i4 < 720) {
                this.f1419J0 = 14;
            } else if (i4 < 480) {
                this.f1419J0 = 12;
            }
        }
        this.f1438x0 = i2;
        if (i3 == 4) {
            this.f1415F0 = 1;
            this.f1417H0 = 12;
        } else {
            this.f1415F0 = 0;
            this.f1417H0 = 23;
        }
        this.f1439y0 = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m912j(int i2, int i3) {
        String str;
        int m1122a = C0930c.m1122a(i2, i3);
        if (this.f1420K0) {
            str = "";
        } else {
            if (this.f1433s0 >= m1122a) {
                this.f1433s0 = m1122a - 1;
            }
            int size = this.f1423i0.size();
            int i4 = this.f1433s0;
            str = size > i4 ? this.f1423i0.get(i4) : C0930c.m1134b(Calendar.getInstance().get(5));
            C0931d.m1156c(this, "maxDays=" + m1122a + ", preSelectDay=" + str);
        }
        this.f1423i0.clear();
        if (i2 == this.f1440z0 && i3 == this.f1410A0 && i2 == this.f1412C0 && i3 == this.f1413D0) {
            for (int i5 = this.f1411B0; i5 <= this.f1414E0; i5++) {
                this.f1423i0.add(C0930c.m1134b(i5));
            }
        } else if (i2 == this.f1440z0 && i3 == this.f1410A0) {
            for (int i6 = this.f1411B0; i6 <= m1122a; i6++) {
                this.f1423i0.add(C0930c.m1134b(i6));
            }
        } else {
            int i7 = 1;
            if (i2 == this.f1412C0 && i3 == this.f1413D0) {
                while (i7 <= this.f1414E0) {
                    this.f1423i0.add(C0930c.m1134b(i7));
                    i7++;
                }
            } else {
                while (i7 <= m1122a) {
                    this.f1423i0.add(C0930c.m1134b(i7));
                    i7++;
                }
            }
        }
        if (this.f1420K0) {
            return;
        }
        int indexOf = this.f1423i0.indexOf(str);
        if (indexOf == -1) {
            indexOf = 0;
        }
        this.f1433s0 = indexOf;
    }

    /* renamed from: f */
    public void mo868f(int i2, int i3) {
        int i4 = this.f1438x0;
        if (i4 == -1) {
            throw new IllegalArgumentException("Date mode invalid");
        }
        if (i4 == 0) {
            throw new IllegalArgumentException("Not support year/month/day mode");
        }
        if (i4 == 1) {
            this.f1440z0 = i2;
            this.f1410A0 = i3;
        } else if (i4 == 2) {
            int i5 = Calendar.getInstance(Locale.CHINA).get(1);
            this.f1412C0 = i5;
            this.f1440z0 = i5;
            this.f1410A0 = i2;
            this.f1411B0 = i3;
        }
        m891E();
    }

    @Deprecated
    /* renamed from: g */
    public void mo869g(int i2, int i3) {
        if (this.f1438x0 == -1) {
            throw new IllegalArgumentException("Date mode invalid");
        }
        this.f1440z0 = i2;
        this.f1412C0 = i3;
        m891E();
    }

    /* renamed from: h */
    public void mo870h(int i2, int i3) {
        if (this.f1439y0 == -1) {
            throw new IllegalArgumentException("Time mode invalid");
        }
        boolean z = i2 < 0 || i3 < 0 || i3 > 59;
        if (this.f1439y0 == 4 && (i2 == 0 || i2 > 12)) {
            z = true;
        }
        if (this.f1439y0 == 3 && i2 >= 24) {
            z = true;
        }
        if (z) {
            throw new IllegalArgumentException("Time out of range");
        }
        this.f1417H0 = i2;
        this.f1418I0 = i3;
        m889D();
    }

    /* renamed from: i */
    public void mo871i(int i2, int i3) {
        if (this.f1439y0 == -1) {
            throw new IllegalArgumentException("Time mode invalid");
        }
        boolean z = i2 < 0 || i3 < 0 || i3 > 59;
        if (this.f1439y0 == 4 && (i2 == 0 || i2 > 12)) {
            z = true;
        }
        if (this.f1439y0 == 3 && i2 >= 24) {
            z = true;
        }
        if (z) {
            throw new IllegalArgumentException("Time out of range");
        }
        this.f1415F0 = i2;
        this.f1416G0 = i3;
        m889D();
    }

    /* renamed from: e */
    public void mo866e(int i2, int i3) {
        int i4 = this.f1438x0;
        if (i4 == -1) {
            throw new IllegalArgumentException("Date mode invalid");
        }
        if (i4 != 0) {
            if (i4 == 1) {
                this.f1412C0 = i2;
                this.f1413D0 = i3;
            } else if (i4 == 2) {
                this.f1413D0 = i2;
                this.f1414E0 = i3;
            }
            m891E();
            return;
        }
        throw new IllegalArgumentException("Not support year/month/day mode");
    }

    /* renamed from: b */
    public void mo863b(int i2, int i3, int i4) {
        if (this.f1438x0 != -1) {
            this.f1440z0 = i2;
            this.f1410A0 = i3;
            this.f1411B0 = i4;
            m891E();
            return;
        }
        throw new IllegalArgumentException("Date mode invalid");
    }

    /* renamed from: a */
    public void mo858a(int i2, int i3, int i4) {
        if (this.f1438x0 != -1) {
            this.f1412C0 = i2;
            this.f1413D0 = i3;
            this.f1414E0 = i4;
            m891E();
            return;
        }
        throw new IllegalArgumentException("Date mode invalid");
    }

    /* renamed from: a */
    public void mo862a(String str, String str2, String str3, String str4, String str5) {
        this.f1426l0 = str;
        this.f1427m0 = str2;
        this.f1428n0 = str3;
        this.f1429o0 = str4;
        this.f1430p0 = str5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public void m892E(int i2) {
        String str;
        int i3;
        int i4 = 1;
        if (this.f1420K0) {
            str = "";
        } else {
            int size = this.f1422h0.size();
            int i5 = this.f1432r0;
            if (size > i5) {
                str = this.f1422h0.get(i5);
            } else {
                str = C0930c.m1134b(Calendar.getInstance().get(2) + 1);
            }
            C0931d.m1156c(this, "preSelectMonth=" + str);
        }
        this.f1422h0.clear();
        int i6 = this.f1410A0;
        if (i6 >= 1 && (i3 = this.f1413D0) >= 1 && i6 <= 12 && i3 <= 12) {
            int i7 = this.f1440z0;
            int i8 = this.f1412C0;
            if (i7 == i8) {
                if (i6 > i3) {
                    while (i3 >= this.f1410A0) {
                        this.f1422h0.add(C0930c.m1134b(i3));
                        i3--;
                    }
                } else {
                    while (i6 <= this.f1413D0) {
                        this.f1422h0.add(C0930c.m1134b(i6));
                        i6++;
                    }
                }
            } else if (i2 == i7) {
                while (i6 <= 12) {
                    this.f1422h0.add(C0930c.m1134b(i6));
                    i6++;
                }
            } else if (i2 == i8) {
                while (i4 <= this.f1413D0) {
                    this.f1422h0.add(C0930c.m1134b(i4));
                    i4++;
                }
            } else {
                while (i4 <= 12) {
                    this.f1422h0.add(C0930c.m1134b(i4));
                    i4++;
                }
            }
            if (this.f1420K0) {
                return;
            }
            int indexOf = this.f1422h0.indexOf(str);
            if (indexOf == -1) {
                indexOf = 0;
            }
            this.f1432r0 = indexOf;
            return;
        }
        throw new IllegalArgumentException("Month out of range [1-12]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public void m890D(int i2) {
        this.f1425k0.clear();
        int i3 = this.f1415F0;
        int i4 = this.f1417H0;
        if (i3 == i4) {
            int i5 = this.f1416G0;
            int i6 = this.f1418I0;
            if (i5 > i6) {
                this.f1416G0 = i6;
                this.f1418I0 = i5;
            }
            for (int i7 = this.f1416G0; i7 <= this.f1418I0; i7++) {
                this.f1425k0.add(C0930c.m1134b(i7));
            }
        } else if (i2 == i3) {
            for (int i8 = this.f1416G0; i8 <= 59; i8++) {
                this.f1425k0.add(C0930c.m1134b(i8));
            }
        } else if (i2 == i4) {
            for (int i9 = 0; i9 <= this.f1418I0; i9++) {
                this.f1425k0.add(C0930c.m1134b(i9));
            }
        } else {
            for (int i10 = 0; i10 <= 59; i10++) {
                this.f1425k0.add(C0930c.m1134b(i10));
            }
        }
        if (this.f1425k0.indexOf(this.f1435u0) == -1) {
            this.f1435u0 = this.f1425k0.get(0);
        }
    }

    /* renamed from: a */
    public void mo860a(int i2, int i3, int i4, int i5, int i6) {
        if (this.f1438x0 == 0) {
            C0931d.m1156c(this, "change months and days while set selected");
            m892E(i2);
            m912j(i2, i3);
            this.f1431q0 = m895a(this.f1421g0, i2);
            this.f1432r0 = m895a(this.f1422h0, i3);
            this.f1433s0 = m895a(this.f1423i0, i4);
            if (this.f1439y0 != -1) {
                this.f1434t0 = C0930c.m1134b(i5);
                this.f1435u0 = C0930c.m1134b(i6);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Date mode invalid");
    }

    /* renamed from: a */
    public void mo859a(int i2, int i3, int i4, int i5) {
        int i6 = this.f1438x0;
        if (i6 != 0) {
            if (i6 == 2) {
                C0931d.m1156c(this, "change months and days while set selected");
                int i7 = Calendar.getInstance(Locale.CHINA).get(1);
                this.f1412C0 = i7;
                this.f1440z0 = i7;
                m892E(i7);
                m912j(i7, i2);
                this.f1432r0 = m895a(this.f1422h0, i2);
                this.f1433s0 = m895a(this.f1423i0, i3);
            } else if (i6 == 1) {
                C0931d.m1156c(this, "change months while set selected");
                m892E(i2);
                this.f1431q0 = m895a(this.f1421g0, i2);
                this.f1432r0 = m895a(this.f1422h0, i3);
            }
            if (this.f1439y0 != -1) {
                this.f1434t0 = C0930c.m1134b(i4);
                this.f1435u0 = C0930c.m1134b(i5);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Date mode invalid");
    }

    /* renamed from: a */
    private int m895a(ArrayList<String> arrayList, int i2) {
        int binarySearch = Collections.binarySearch(arrayList, Integer.valueOf(i2), new f());
        if (binarySearch >= 0) {
            return binarySearch;
        }
        throw new IllegalArgumentException("Item[" + i2 + "] out of range");
    }
}
