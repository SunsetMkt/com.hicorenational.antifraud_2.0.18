package p388ui.view;

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
import p023b.p024a.p025a.p027e.AbstractC0925k;
import p023b.p024a.p025a.p029g.C0930c;
import p023b.p024a.p025a.p029g.C0931d;

/* compiled from: TimeSecondPicker.java */
/* renamed from: ui.view.w */
/* loaded from: classes2.dex */
public class C7247w extends AbstractC0925k {

    /* renamed from: Q0 */
    public static final int f25034Q0 = -1;

    /* renamed from: R0 */
    public static final int f25035R0 = 0;

    /* renamed from: S0 */
    public static final int f25036S0 = 1;

    /* renamed from: T0 */
    public static final int f25037T0 = 2;

    /* renamed from: U0 */
    public static final int f25038U0 = 3;

    /* renamed from: V0 */
    @Deprecated
    public static final int f25039V0 = 3;

    /* renamed from: W0 */
    public static final int f25040W0 = 4;

    /* renamed from: X0 */
    @Deprecated
    public static final int f25041X0 = 4;

    /* renamed from: A0 */
    private int f25042A0;

    /* renamed from: B0 */
    private int f25043B0;

    /* renamed from: C0 */
    private int f25044C0;

    /* renamed from: D0 */
    private int f25045D0;

    /* renamed from: E0 */
    private int f25046E0;

    /* renamed from: F0 */
    private int f25047F0;

    /* renamed from: G0 */
    private int f25048G0;

    /* renamed from: H0 */
    private int f25049H0;

    /* renamed from: I0 */
    private int f25050I0;

    /* renamed from: J0 */
    private int f25051J0;

    /* renamed from: K0 */
    private int f25052K0;

    /* renamed from: L0 */
    private int f25053L0;

    /* renamed from: M0 */
    private int f25054M0;

    /* renamed from: N0 */
    private int f25055N0;

    /* renamed from: O0 */
    private int f25056O0;

    /* renamed from: P0 */
    private boolean f25057P0;

    /* renamed from: g0 */
    private ArrayList<String> f25058g0;

    /* renamed from: h0 */
    private ArrayList<String> f25059h0;

    /* renamed from: i0 */
    private ArrayList<String> f25060i0;

    /* renamed from: j0 */
    private ArrayList<String> f25061j0;

    /* renamed from: k0 */
    private ArrayList<String> f25062k0;

    /* renamed from: l0 */
    private ArrayList<String> f25063l0;

    /* renamed from: m0 */
    private String f25064m0;

    /* renamed from: n0 */
    private String f25065n0;

    /* renamed from: o0 */
    private String f25066o0;

    /* renamed from: p0 */
    private String f25067p0;

    /* renamed from: q0 */
    private String f25068q0;

    /* renamed from: r0 */
    private String f25069r0;

    /* renamed from: s0 */
    private int f25070s0;

    /* renamed from: t0 */
    private int f25071t0;

    /* renamed from: u0 */
    private int f25072u0;

    /* renamed from: v0 */
    private String f25073v0;

    /* renamed from: w0 */
    private String f25074w0;

    /* renamed from: x0 */
    private String f25075x0;

    /* renamed from: y0 */
    private m f25076y0;

    /* renamed from: z0 */
    private i f25077z0;

    /* compiled from: TimeSecondPicker.java */
    /* renamed from: ui.view.w$a */
    class a implements WheelView.InterfaceC1290g {

        /* renamed from: a */
        final /* synthetic */ WheelView f25078a;

        /* renamed from: b */
        final /* synthetic */ WheelView f25079b;

        a(WheelView wheelView, WheelView wheelView2) {
            this.f25078a = wheelView;
            this.f25079b = wheelView2;
        }

        @Override // cn.qqtheme.framework.widget.WheelView.InterfaceC1290g
        /* renamed from: a */
        public void mo848a(int i2) {
            C7247w.this.f25070s0 = i2;
            String str = (String) C7247w.this.f25058g0.get(C7247w.this.f25070s0);
            if (C7247w.this.f25076y0 != null) {
                C7247w.this.f25076y0.m26125e(C7247w.this.f25070s0, str);
            }
            C0931d.m1156c(this, "change months after year wheeled");
            if (C7247w.this.f25057P0) {
                C7247w.this.f25071t0 = 0;
                C7247w.this.f25072u0 = 0;
            }
            int m1136c = C0930c.m1136c(str);
            C7247w.this.m26074E(m1136c);
            this.f25078a.m2593a(C7247w.this.f25059h0, C7247w.this.f25071t0);
            if (C7247w.this.f25076y0 != null) {
                C7247w.this.f25076y0.m26124d(C7247w.this.f25071t0, (String) C7247w.this.f25059h0.get(C7247w.this.f25071t0));
            }
            C7247w c7247w = C7247w.this;
            c7247w.m26095h(m1136c, C0930c.m1136c((String) c7247w.f25059h0.get(C7247w.this.f25071t0)));
            this.f25079b.m2593a(C7247w.this.f25060i0, C7247w.this.f25072u0);
            if (C7247w.this.f25076y0 != null) {
                C7247w.this.f25076y0.m26122b(C7247w.this.f25072u0, (String) C7247w.this.f25060i0.get(C7247w.this.f25072u0));
            }
        }
    }

    /* compiled from: TimeSecondPicker.java */
    /* renamed from: ui.view.w$b */
    class b implements WheelView.InterfaceC1290g {

        /* renamed from: a */
        final /* synthetic */ WheelView f25081a;

        b(WheelView wheelView) {
            this.f25081a = wheelView;
        }

        @Override // cn.qqtheme.framework.widget.WheelView.InterfaceC1290g
        /* renamed from: a */
        public void mo848a(int i2) {
            C7247w.this.f25071t0 = i2;
            String str = (String) C7247w.this.f25059h0.get(C7247w.this.f25071t0);
            if (C7247w.this.f25076y0 != null) {
                C7247w.this.f25076y0.m26124d(C7247w.this.f25071t0, str);
            }
            if (C7247w.this.f25042A0 == 0 || C7247w.this.f25042A0 == 2) {
                C0931d.m1156c(this, "change days after month wheeled");
                if (C7247w.this.f25057P0) {
                    C7247w.this.f25072u0 = 0;
                }
                C7247w.this.m26095h(C7247w.this.f25042A0 == 0 ? C0930c.m1136c(C7247w.this.m26106D()) : Calendar.getInstance(Locale.CHINA).get(1), C0930c.m1136c(str));
                this.f25081a.m2593a(C7247w.this.f25060i0, C7247w.this.f25072u0);
                if (C7247w.this.f25076y0 != null) {
                    C7247w.this.f25076y0.m26122b(C7247w.this.f25072u0, (String) C7247w.this.f25060i0.get(C7247w.this.f25072u0));
                }
            }
        }
    }

    /* compiled from: TimeSecondPicker.java */
    /* renamed from: ui.view.w$c */
    class c implements WheelView.InterfaceC1290g {
        c() {
        }

        @Override // cn.qqtheme.framework.widget.WheelView.InterfaceC1290g
        /* renamed from: a */
        public void mo848a(int i2) {
            C7247w.this.f25072u0 = i2;
            if (C7247w.this.f25076y0 != null) {
                C7247w.this.f25076y0.m26122b(C7247w.this.f25072u0, (String) C7247w.this.f25060i0.get(C7247w.this.f25072u0));
            }
        }
    }

    /* compiled from: TimeSecondPicker.java */
    /* renamed from: ui.view.w$d */
    class d implements WheelView.InterfaceC1290g {

        /* renamed from: a */
        final /* synthetic */ WheelView f25084a;

        d(WheelView wheelView) {
            this.f25084a = wheelView;
        }

        @Override // cn.qqtheme.framework.widget.WheelView.InterfaceC1290g
        /* renamed from: a */
        public void mo848a(int i2) {
            C7247w c7247w = C7247w.this;
            c7247w.f25073v0 = (String) c7247w.f25061j0.get(i2);
            if (C7247w.this.f25076y0 != null) {
                C7247w.this.f25076y0.m26121a(i2, C7247w.this.f25073v0);
            }
            C0931d.m1156c(this, "change minutes after hour wheeled");
            C7247w c7247w2 = C7247w.this;
            c7247w2.m26072D(C0930c.m1136c(c7247w2.f25073v0));
            this.f25084a.m2594a(C7247w.this.f25062k0, C7247w.this.f25074w0);
        }
    }

    /* compiled from: TimeSecondPicker.java */
    /* renamed from: ui.view.w$e */
    class e implements WheelView.InterfaceC1290g {
        e() {
        }

        @Override // cn.qqtheme.framework.widget.WheelView.InterfaceC1290g
        /* renamed from: a */
        public void mo848a(int i2) {
            C7247w c7247w = C7247w.this;
            c7247w.f25074w0 = (String) c7247w.f25062k0.get(i2);
            if (C7247w.this.f25076y0 != null) {
                C7247w.this.f25076y0.m26123c(i2, C7247w.this.f25074w0);
            }
        }
    }

    /* compiled from: TimeSecondPicker.java */
    /* renamed from: ui.view.w$f */
    class f implements WheelView.InterfaceC1290g {
        f() {
        }

        @Override // cn.qqtheme.framework.widget.WheelView.InterfaceC1290g
        /* renamed from: a */
        public void mo848a(int i2) {
            C7247w c7247w = C7247w.this;
            c7247w.f25075x0 = (String) c7247w.f25063l0.get(i2);
            if (C7247w.this.f25076y0 != null) {
                C7247w.this.f25076y0.m26126f(i2, C7247w.this.f25075x0);
            }
        }
    }

    /* compiled from: TimeSecondPicker.java */
    /* renamed from: ui.view.w$g */
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
    /* renamed from: ui.view.w$h */
    public @interface h {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: TimeSecondPicker.java */
    /* renamed from: ui.view.w$i */
    public interface i {
    }

    /* compiled from: TimeSecondPicker.java */
    @Deprecated
    /* renamed from: ui.view.w$j */
    public interface j extends k {
    }

    /* compiled from: TimeSecondPicker.java */
    /* renamed from: ui.view.w$k */
    public interface k extends i {
        /* renamed from: a */
        void m26120a(String str, String str2, String str3, String str4, String str5);
    }

    /* compiled from: TimeSecondPicker.java */
    /* renamed from: ui.view.w$l */
    public interface l extends i {
        /* renamed from: a */
        void mo25212a(String str, String str2, String str3);
    }

    /* compiled from: TimeSecondPicker.java */
    /* renamed from: ui.view.w$m */
    public interface m {
        /* renamed from: a */
        void m26121a(int i2, String str);

        /* renamed from: b */
        void m26122b(int i2, String str);

        /* renamed from: c */
        void m26123c(int i2, String str);

        /* renamed from: d */
        void m26124d(int i2, String str);

        /* renamed from: e */
        void m26125e(int i2, String str);

        /* renamed from: f */
        void m26126f(int i2, String str);
    }

    /* compiled from: TimeSecondPicker.java */
    /* renamed from: ui.view.w$n */
    public interface n extends i {
        /* renamed from: a */
        void m26127a(String str, String str2, String str3, String str4, String str5, String str6);
    }

    /* compiled from: TimeSecondPicker.java */
    @Deprecated
    /* renamed from: ui.view.w$o */
    public interface o extends p {
    }

    /* compiled from: TimeSecondPicker.java */
    /* renamed from: ui.view.w$p */
    public interface p extends i {
        /* renamed from: a */
        void m26128a(String str, String str2, String str3, String str4, String str5);
    }

    /* compiled from: TimeSecondPicker.java */
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: ui.view.w$q */
    public @interface q {
    }

    public C7247w(Activity activity, int i2) {
        this(activity, 0, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public void m26074E(int i2) {
        String str;
        int i3;
        int i4 = 1;
        if (this.f25057P0) {
            str = "";
        } else {
            int size = this.f25059h0.size();
            int i5 = this.f25071t0;
            str = size > i5 ? this.f25059h0.get(i5) : C0930c.m1134b(Calendar.getInstance().get(2) + 1);
            C0931d.m1156c(this, "preSelectMonth=" + str);
        }
        this.f25059h0.clear();
        int i6 = this.f25045D0;
        if (i6 < 1 || (i3 = this.f25048G0) < 1 || i6 > 12 || i3 > 12) {
            throw new IllegalArgumentException("Month out of range [1-12]");
        }
        int i7 = this.f25044C0;
        int i8 = this.f25047F0;
        if (i7 == i8) {
            if (i6 > i3) {
                while (i3 >= this.f25045D0) {
                    this.f25059h0.add(C0930c.m1134b(i3));
                    i3--;
                }
            } else {
                while (i6 <= this.f25048G0) {
                    this.f25059h0.add(C0930c.m1134b(i6));
                    i6++;
                }
            }
        } else if (i2 == i7) {
            while (i6 <= 12) {
                this.f25059h0.add(C0930c.m1134b(i6));
                i6++;
            }
        } else if (i2 == i8) {
            while (i4 <= this.f25048G0) {
                this.f25059h0.add(C0930c.m1134b(i4));
                i4++;
            }
        } else {
            while (i4 <= 12) {
                this.f25059h0.add(C0930c.m1134b(i4));
                i4++;
            }
        }
        if (this.f25057P0) {
            return;
        }
        int indexOf = this.f25059h0.indexOf(str);
        if (indexOf == -1) {
            indexOf = 0;
        }
        this.f25071t0 = indexOf;
    }

    /* renamed from: F */
    private void m26075F() {
        this.f25058g0.clear();
        int i2 = this.f25044C0;
        int i3 = this.f25047F0;
        if (i2 == i3) {
            this.f25058g0.add(String.valueOf(i2));
        } else if (i2 < i3) {
            while (i2 <= this.f25047F0) {
                this.f25058g0.add(String.valueOf(i2));
                i2++;
            }
        } else {
            while (i2 >= this.f25047F0) {
                this.f25058g0.add(String.valueOf(i2));
                i2--;
            }
        }
        if (this.f25057P0) {
            return;
        }
        int i4 = this.f25042A0;
        if (i4 == 0 || i4 == 1) {
            int indexOf = this.f25058g0.indexOf(C0930c.m1134b(Calendar.getInstance().get(1)));
            if (indexOf == -1) {
                this.f25070s0 = 0;
            } else {
                this.f25070s0 = indexOf;
            }
        }
    }

    /* renamed from: A */
    public String m26103A() {
        return this.f25043B0 != -1 ? this.f25074w0 : "";
    }

    /* renamed from: B */
    public String m26104B() {
        if (this.f25042A0 == -1) {
            return "";
        }
        if (this.f25059h0.size() <= this.f25071t0) {
            this.f25071t0 = this.f25059h0.size() - 1;
        }
        return this.f25059h0.get(this.f25071t0);
    }

    /* renamed from: C */
    public String m26105C() {
        return this.f25043B0 != -1 ? this.f25075x0 : "";
    }

    /* renamed from: D */
    public String m26106D() {
        int i2 = this.f25042A0;
        if (i2 != 0 && i2 != 1) {
            return "";
        }
        if (this.f25058g0.size() <= this.f25070s0) {
            this.f25070s0 = this.f25058g0.size() - 1;
        }
        return this.f25058g0.get(this.f25070s0);
    }

    @Override // p023b.p024a.p025a.p028f.AbstractC0927b
    /* renamed from: r */
    protected View mo846r() {
        int i2 = this.f25042A0;
        if ((i2 == 0 || i2 == 1) && this.f25058g0.size() == 0) {
            C0931d.m1156c(this, "init years before make view");
            m26075F();
        }
        if (this.f25042A0 != -1 && this.f25059h0.size() == 0) {
            C0931d.m1156c(this, "init months before make view");
            m26074E(C0930c.m1136c(m26106D()));
        }
        int i3 = this.f25042A0;
        if ((i3 == 0 || i3 == 2) && this.f25060i0.size() == 0) {
            C0931d.m1156c(this, "init days before make view");
            m26095h(this.f25042A0 == 0 ? C0930c.m1136c(m26106D()) : Calendar.getInstance(Locale.CHINA).get(1), C0930c.m1136c(m26104B()));
        }
        if (this.f25043B0 != -1 && this.f25061j0.size() == 0) {
            C0931d.m1156c(this, "init hours before make view");
            m26073E();
        }
        if (this.f25043B0 != -1 && this.f25062k0.size() == 0) {
            C0931d.m1156c(this, "init minutes before make view");
            m26072D(C0930c.m1136c(this.f25073v0));
            m26076F(C0930c.m1136c(this.f25074w0));
        }
        LinearLayout linearLayout = new LinearLayout(this.f1520a);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        WheelView m1016x = m1016x();
        WheelView m1016x2 = m1016x();
        WheelView m1016x3 = m1016x();
        WheelView m1016x4 = m1016x();
        WheelView m1016x5 = m1016x();
        WheelView m1016x6 = m1016x();
        int i4 = this.f25042A0;
        if (i4 == 0 || i4 == 1) {
            m1016x.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            m1016x.m2593a(this.f25058g0, this.f25070s0);
            m1016x.setOnItemSelectListener(new a(m1016x2, m1016x3));
            linearLayout.addView(m1016x);
            if (!TextUtils.isEmpty(this.f25064m0)) {
                TextView m1014w = m1014w();
                m1014w.setTextSize(this.f25056O0);
                m1014w.setText(this.f25064m0);
                linearLayout.addView(m1014w);
            }
        }
        if (this.f25042A0 != -1) {
            m1016x2.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            m1016x2.m2593a(this.f25059h0, this.f25071t0);
            m1016x2.setOnItemSelectListener(new b(m1016x3));
            linearLayout.addView(m1016x2);
            if (!TextUtils.isEmpty(this.f25065n0)) {
                TextView m1014w2 = m1014w();
                m1014w2.setTextSize(this.f25056O0);
                m1014w2.setText(this.f25065n0);
                linearLayout.addView(m1014w2);
            }
        }
        int i5 = this.f25042A0;
        if (i5 == 0 || i5 == 2) {
            m1016x3.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            m1016x3.m2593a(this.f25060i0, this.f25072u0);
            m1016x3.setOnItemSelectListener(new c());
            linearLayout.addView(m1016x3);
            if (!TextUtils.isEmpty(this.f25066o0)) {
                TextView m1014w3 = m1014w();
                m1014w3.setTextSize(this.f25056O0);
                m1014w3.setText(this.f25066o0);
                linearLayout.addView(m1014w3);
            }
        }
        if (this.f25043B0 != -1) {
            m1016x4.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            m1016x4.m2594a(this.f25061j0, this.f25073v0);
            m1016x4.setOnItemSelectListener(new d(m1016x5));
            linearLayout.addView(m1016x4);
            if (!TextUtils.isEmpty(this.f25067p0)) {
                TextView m1014w4 = m1014w();
                m1014w4.setTextSize(this.f25056O0);
                m1014w4.setText(this.f25067p0);
                linearLayout.addView(m1014w4);
            }
            m1016x5.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            m1016x5.m2594a(this.f25062k0, this.f25074w0);
            m1016x5.setOnItemSelectListener(new e());
            linearLayout.addView(m1016x5);
            if (!TextUtils.isEmpty(this.f25068q0)) {
                TextView m1014w5 = m1014w();
                m1014w5.setTextSize(this.f25056O0);
                m1014w5.setText(this.f25068q0);
                linearLayout.addView(m1014w5);
            }
            m1016x6.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            m1016x6.m2594a(this.f25063l0, this.f25075x0);
            m1016x6.setOnItemSelectListener(new f());
            linearLayout.addView(m1016x6);
            if (!TextUtils.isEmpty(this.f25069r0)) {
                TextView m1014w6 = m1014w();
                m1014w6.setTextSize(this.f25056O0);
                m1014w6.setText(this.f25069r0);
                linearLayout.addView(m1014w6);
            }
        }
        return linearLayout;
    }

    public void setOnDateTimePickListener(i iVar) {
        this.f25077z0 = iVar;
    }

    public void setOnWheelListener(m mVar) {
        this.f25076y0 = mVar;
    }

    @Override // p023b.p024a.p025a.p028f.AbstractC0927b
    /* renamed from: v */
    protected void mo847v() {
        if (this.f25077z0 == null) {
            return;
        }
        String m26106D = m26106D();
        String m26104B = m26104B();
        String m26118y = m26118y();
        String m26119z = m26119z();
        String m26103A = m26103A();
        String m26105C = m26105C();
        int i2 = this.f25042A0;
        if (i2 == -1) {
            ((l) this.f25077z0).mo25212a(m26119z, m26103A, m26105C);
            return;
        }
        if (i2 == 0) {
            ((n) this.f25077z0).m26127a(m26106D, m26104B, m26118y, m26119z, m26103A, m26105C);
        } else if (i2 == 1) {
            ((p) this.f25077z0).m26128a(m26106D, m26104B, m26119z, m26103A, m26105C);
        } else {
            if (i2 != 2) {
                return;
            }
            ((k) this.f25077z0).m26120a(m26104B, m26118y, m26119z, m26103A, m26105C);
        }
    }

    /* renamed from: y */
    public String m26118y() {
        int i2 = this.f25042A0;
        if (i2 != 0 && i2 != 2) {
            return "";
        }
        if (this.f25060i0.size() <= this.f25072u0) {
            this.f25072u0 = this.f25060i0.size() - 1;
        }
        return this.f25060i0.get(this.f25072u0);
    }

    /* renamed from: z */
    public String m26119z() {
        return this.f25043B0 != -1 ? this.f25073v0 : "";
    }

    public C7247w(Activity activity, int i2, int i3) {
        super(activity);
        this.f25058g0 = new ArrayList<>();
        this.f25059h0 = new ArrayList<>();
        this.f25060i0 = new ArrayList<>();
        this.f25061j0 = new ArrayList<>();
        this.f25062k0 = new ArrayList<>();
        this.f25063l0 = new ArrayList<>();
        this.f25064m0 = "年";
        this.f25065n0 = "月";
        this.f25066o0 = "日";
        this.f25067p0 = "时";
        this.f25068q0 = "分";
        this.f25069r0 = "秒";
        this.f25070s0 = 0;
        this.f25071t0 = 0;
        this.f25072u0 = 0;
        this.f25073v0 = "";
        this.f25074w0 = "";
        this.f25075x0 = "";
        this.f25042A0 = 0;
        this.f25043B0 = 3;
        this.f25044C0 = 2010;
        this.f25045D0 = 1;
        this.f25046E0 = 1;
        this.f25047F0 = 2020;
        this.f25048G0 = 12;
        this.f25049H0 = 31;
        this.f25052K0 = 0;
        this.f25055N0 = 59;
        this.f25056O0 = 16;
        this.f25057P0 = true;
        if (i2 == -1 && i3 == -1) {
            throw new IllegalArgumentException("The modes are NONE at the same time");
        }
        if (i2 == 0 && i3 != -1) {
            int i4 = this.f1521b;
            if (i4 < 720) {
                this.f25056O0 = 14;
            } else if (i4 < 480) {
                this.f25056O0 = 12;
            }
        }
        this.f25042A0 = i2;
        if (i3 == 4) {
            this.f25050I0 = 1;
            this.f25053L0 = 12;
        } else {
            this.f25050I0 = 0;
            this.f25053L0 = 23;
        }
        this.f25043B0 = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m26095h(int i2, int i3) {
        String str;
        int m1122a = C0930c.m1122a(i2, i3);
        if (this.f25057P0) {
            str = "";
        } else {
            if (this.f25072u0 >= m1122a) {
                this.f25072u0 = m1122a - 1;
            }
            int size = this.f25060i0.size();
            int i4 = this.f25072u0;
            str = size > i4 ? this.f25060i0.get(i4) : C0930c.m1134b(Calendar.getInstance().get(5));
            C0931d.m1156c(this, "maxDays=" + m1122a + ", preSelectDay=" + str);
        }
        this.f25060i0.clear();
        if (i2 == this.f25044C0 && i3 == this.f25045D0 && i2 == this.f25047F0 && i3 == this.f25048G0) {
            for (int i5 = this.f25046E0; i5 <= this.f25049H0; i5++) {
                this.f25060i0.add(C0930c.m1134b(i5));
            }
        } else if (i2 == this.f25044C0 && i3 == this.f25045D0) {
            for (int i6 = this.f25046E0; i6 <= m1122a; i6++) {
                this.f25060i0.add(C0930c.m1134b(i6));
            }
        } else {
            int i7 = 1;
            if (i2 == this.f25047F0 && i3 == this.f25048G0) {
                while (i7 <= this.f25049H0) {
                    this.f25060i0.add(C0930c.m1134b(i7));
                    i7++;
                }
            } else {
                while (i7 <= m1122a) {
                    this.f25060i0.add(C0930c.m1134b(i7));
                    i7++;
                }
            }
        }
        if (this.f25057P0) {
            return;
        }
        int indexOf = this.f25060i0.indexOf(str);
        if (indexOf == -1) {
            indexOf = 0;
        }
        this.f25072u0 = indexOf;
    }

    /* renamed from: f */
    public void m26115f(int i2, int i3) {
        int i4 = this.f25042A0;
        if (i4 == -1) {
            throw new IllegalArgumentException("Date mode invalid");
        }
        if (i4 == 0) {
            throw new IllegalArgumentException("Not support year/month/day mode");
        }
        if (i4 == 1) {
            this.f25044C0 = i2;
            this.f25045D0 = i3;
        } else if (i4 == 2) {
            int i5 = Calendar.getInstance(Locale.CHINA).get(1);
            this.f25047F0 = i5;
            this.f25044C0 = i5;
            this.f25045D0 = i2;
            this.f25046E0 = i3;
        }
        m26075F();
    }

    @Deprecated
    /* renamed from: g */
    public void m26116g(int i2, int i3) {
        if (this.f25042A0 == -1) {
            throw new IllegalArgumentException("Date mode invalid");
        }
        this.f25044C0 = i2;
        this.f25047F0 = i3;
        m26075F();
    }

    /* renamed from: o */
    public void m26117o(boolean z) {
        this.f25057P0 = z;
    }

    /* renamed from: d */
    public void m26113d(int i2, int i3, int i4) {
        if (this.f25043B0 != -1) {
            boolean z = i2 < 0 || i3 < 0 || i3 > 59 || i4 < 0 || i4 > 59;
            if (this.f25043B0 == 4 && (i2 == 0 || i2 > 12)) {
                z = true;
            }
            if (this.f25043B0 == 3 && i2 >= 24) {
                z = true;
            }
            if (!z) {
                this.f25050I0 = i2;
                this.f25051J0 = i3;
                this.f25052K0 = i4;
                m26073E();
                return;
            }
            throw new IllegalArgumentException("Time out of range");
        }
        throw new IllegalArgumentException("Time mode invalid");
    }

    /* renamed from: e */
    public void m26114e(int i2, int i3) {
        int i4 = this.f25042A0;
        if (i4 == -1) {
            throw new IllegalArgumentException("Date mode invalid");
        }
        if (i4 != 0) {
            if (i4 == 1) {
                this.f25047F0 = i2;
                this.f25048G0 = i3;
            } else if (i4 == 2) {
                this.f25048G0 = i2;
                this.f25049H0 = i3;
            }
            m26075F();
            return;
        }
        throw new IllegalArgumentException("Not support year/month/day mode");
    }

    /* renamed from: b */
    public void m26111b(int i2, int i3, int i4) {
        if (this.f25042A0 != -1) {
            this.f25044C0 = i2;
            this.f25045D0 = i3;
            this.f25046E0 = i4;
            m26075F();
            return;
        }
        throw new IllegalArgumentException("Date mode invalid");
    }

    /* renamed from: c */
    public void m26112c(int i2, int i3, int i4) {
        if (this.f25043B0 != -1) {
            boolean z = i2 < 0 || i3 < 0 || i3 > 59 || i4 < 0 || i4 > 59;
            if (this.f25043B0 == 4 && (i2 == 0 || i2 > 12)) {
                z = true;
            }
            if (this.f25043B0 == 3 && i2 >= 24) {
                z = true;
            }
            if (!z) {
                this.f25053L0 = i2;
                this.f25054M0 = i3;
                this.f25055N0 = i4;
                m26073E();
                return;
            }
            throw new IllegalArgumentException("Time out of range");
        }
        throw new IllegalArgumentException("Time mode invalid");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public void m26072D(int i2) {
        this.f25062k0.clear();
        int i3 = this.f25050I0;
        int i4 = this.f25053L0;
        if (i3 == i4) {
            int i5 = this.f25051J0;
            int i6 = this.f25054M0;
            if (i5 > i6) {
                this.f25051J0 = i6;
                this.f25054M0 = i5;
            }
            for (int i7 = this.f25051J0; i7 <= this.f25054M0; i7++) {
                this.f25062k0.add(C0930c.m1134b(i7));
            }
        } else if (i2 == i3) {
            for (int i8 = this.f25051J0; i8 <= 59; i8++) {
                this.f25062k0.add(C0930c.m1134b(i8));
            }
        } else if (i2 == i4) {
            for (int i9 = 0; i9 <= this.f25054M0; i9++) {
                this.f25062k0.add(C0930c.m1134b(i9));
            }
        } else {
            for (int i10 = 0; i10 <= 59; i10++) {
                this.f25062k0.add(C0930c.m1134b(i10));
            }
        }
        if (this.f25062k0.indexOf(this.f25074w0) == -1) {
            this.f25074w0 = this.f25062k0.get(0);
        }
    }

    /* renamed from: a */
    public void m26107a(int i2, int i3, int i4) {
        if (this.f25042A0 != -1) {
            this.f25047F0 = i2;
            this.f25048G0 = i3;
            this.f25049H0 = i4;
            m26075F();
            return;
        }
        throw new IllegalArgumentException("Date mode invalid");
    }

    /* renamed from: a */
    public void m26110a(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f25064m0 = str;
        this.f25065n0 = str2;
        this.f25066o0 = str3;
        this.f25067p0 = str4;
        this.f25068q0 = str5;
        this.f25069r0 = str6;
    }

    /* renamed from: F */
    private void m26076F(int i2) {
        this.f25063l0.clear();
        int i3 = this.f25051J0;
        int i4 = this.f25054M0;
        if (i3 == i4) {
            int i5 = this.f25052K0;
            int i6 = this.f25055N0;
            if (i5 > i6) {
                this.f25052K0 = i6;
                this.f25055N0 = i5;
            }
            for (int i7 = this.f25052K0; i7 <= this.f25055N0; i7++) {
                this.f25063l0.add(C0930c.m1134b(i7));
            }
        } else if (i2 == i3) {
            for (int i8 = this.f25052K0; i8 <= 59; i8++) {
                this.f25063l0.add(C0930c.m1134b(i8));
            }
        } else if (i2 == i4) {
            for (int i9 = 0; i9 <= this.f25055N0; i9++) {
                this.f25063l0.add(C0930c.m1134b(i9));
            }
        } else {
            for (int i10 = 0; i10 <= 59; i10++) {
                this.f25063l0.add(C0930c.m1134b(i10));
            }
        }
        if (this.f25063l0.indexOf(this.f25075x0) == -1) {
            this.f25075x0 = this.f25063l0.get(0);
        }
    }

    /* renamed from: a */
    public void m26109a(int i2, int i3, int i4, int i5, int i6, int i7) {
        if (this.f25042A0 == 0) {
            C0931d.m1156c(this, "change months and days while set selected");
            m26074E(i2);
            m26095h(i2, i3);
            this.f25070s0 = m26077a(this.f25058g0, i2);
            this.f25071t0 = m26077a(this.f25059h0, i3);
            this.f25072u0 = m26077a(this.f25060i0, i4);
            if (this.f25043B0 != -1) {
                this.f25073v0 = C0930c.m1134b(i5);
                this.f25074w0 = C0930c.m1134b(i6);
                this.f25075x0 = C0930c.m1134b(i7);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Date mode invalid");
    }

    /* renamed from: E */
    private void m26073E() {
        int i2;
        this.f25061j0.clear();
        if (this.f25057P0) {
            i2 = 0;
        } else if (this.f25043B0 == 3) {
            i2 = Calendar.getInstance().get(11);
        } else {
            i2 = Calendar.getInstance().get(10);
        }
        for (int i3 = this.f25050I0; i3 <= this.f25053L0; i3++) {
            String m1134b = C0930c.m1134b(i3);
            if (!this.f25057P0 && i3 == i2) {
                this.f25073v0 = m1134b;
            }
            this.f25061j0.add(m1134b);
        }
        if (this.f25061j0.indexOf(this.f25073v0) == -1) {
            this.f25073v0 = this.f25061j0.get(0);
        }
        if (this.f25057P0) {
            return;
        }
        this.f25074w0 = C0930c.m1134b(Calendar.getInstance().get(12));
        this.f25075x0 = C0930c.m1134b(Calendar.getInstance().get(13));
    }

    /* renamed from: a */
    public void m26108a(int i2, int i3, int i4, int i5, int i6) {
        int i7 = this.f25042A0;
        if (i7 != 0) {
            if (i7 == 2) {
                C0931d.m1156c(this, "change months and days while set selected");
                int i8 = Calendar.getInstance(Locale.CHINA).get(1);
                this.f25047F0 = i8;
                this.f25044C0 = i8;
                m26074E(i8);
                m26095h(i8, i2);
                this.f25071t0 = m26077a(this.f25059h0, i2);
                this.f25072u0 = m26077a(this.f25060i0, i3);
            } else if (i7 == 1) {
                C0931d.m1156c(this, "change months while set selected");
                m26074E(i2);
                this.f25070s0 = m26077a(this.f25058g0, i2);
                this.f25071t0 = m26077a(this.f25059h0, i3);
            }
            if (this.f25043B0 != -1) {
                this.f25073v0 = C0930c.m1134b(i4);
                this.f25074w0 = C0930c.m1134b(i5);
                this.f25075x0 = C0930c.m1134b(i6);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Date mode invalid");
    }

    /* renamed from: a */
    private int m26077a(ArrayList<String> arrayList, int i2) {
        int binarySearch = Collections.binarySearch(arrayList, Integer.valueOf(i2), new g());
        if (binarySearch >= 0) {
            return binarySearch;
        }
        throw new IllegalArgumentException("Item[" + i2 + "] out of range");
    }
}
