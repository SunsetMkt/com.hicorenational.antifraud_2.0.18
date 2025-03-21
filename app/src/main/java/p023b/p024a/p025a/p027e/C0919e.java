package p023b.p024a.p025a.p027e;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DoublePicker.java */
/* renamed from: b.a.a.e.e */
/* loaded from: classes.dex */
public class C0919e extends AbstractC0925k {

    /* renamed from: g0 */
    private List<String> f1451g0;

    /* renamed from: h0 */
    private List<String> f1452h0;

    /* renamed from: i0 */
    private int f1453i0;

    /* renamed from: j0 */
    private int f1454j0;

    /* renamed from: k0 */
    private d f1455k0;

    /* renamed from: l0 */
    private c f1456l0;

    /* renamed from: m0 */
    private CharSequence f1457m0;

    /* renamed from: n0 */
    private CharSequence f1458n0;

    /* renamed from: o0 */
    private CharSequence f1459o0;

    /* renamed from: p0 */
    private CharSequence f1460p0;

    /* compiled from: DoublePicker.java */
    /* renamed from: b.a.a.e.e$a */
    class a implements WheelView.InterfaceC1290g {
        a() {
        }

        @Override // cn.qqtheme.framework.widget.WheelView.InterfaceC1290g
        /* renamed from: a */
        public void mo848a(int i2) {
            C0919e.this.f1453i0 = i2;
            if (C0919e.this.f1455k0 != null) {
                C0919e.this.f1455k0.m937g(C0919e.this.f1453i0, (String) C0919e.this.f1451g0.get(C0919e.this.f1453i0));
            }
        }
    }

    /* compiled from: DoublePicker.java */
    /* renamed from: b.a.a.e.e$b */
    class b implements WheelView.InterfaceC1290g {
        b() {
        }

        @Override // cn.qqtheme.framework.widget.WheelView.InterfaceC1290g
        /* renamed from: a */
        public void mo848a(int i2) {
            C0919e.this.f1454j0 = i2;
            if (C0919e.this.f1455k0 != null) {
                C0919e.this.f1455k0.m936f(C0919e.this.f1454j0, (String) C0919e.this.f1452h0.get(C0919e.this.f1454j0));
            }
        }
    }

    /* compiled from: DoublePicker.java */
    /* renamed from: b.a.a.e.e$c */
    public interface c {
        /* renamed from: a */
        void m935a(int i2, int i3);
    }

    /* compiled from: DoublePicker.java */
    /* renamed from: b.a.a.e.e$d */
    public interface d {
        /* renamed from: f */
        void m936f(int i2, String str);

        /* renamed from: g */
        void m937g(int i2, String str);
    }

    public C0919e(Activity activity, List<String> list, List<String> list2) {
        super(activity);
        this.f1451g0 = new ArrayList();
        this.f1452h0 = new ArrayList();
        this.f1453i0 = 0;
        this.f1454j0 = 0;
        this.f1451g0 = list;
        this.f1452h0 = list2;
    }

    @Override // p023b.p024a.p025a.p028f.AbstractC0927b
    @NonNull
    /* renamed from: r */
    protected View mo846r() {
        LinearLayout linearLayout = new LinearLayout(this.f1520a);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        if (!TextUtils.isEmpty(this.f1457m0)) {
            TextView m1014w = m1014w();
            m1014w.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            m1014w.setText(this.f1457m0);
            linearLayout.addView(m1014w);
        }
        WheelView m1016x = m1016x();
        m1016x.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(m1016x);
        if (!TextUtils.isEmpty(this.f1458n0)) {
            TextView m1014w2 = m1014w();
            m1014w2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            m1014w2.setText(this.f1458n0);
            linearLayout.addView(m1014w2);
        }
        if (!TextUtils.isEmpty(this.f1459o0)) {
            TextView m1014w3 = m1014w();
            m1014w3.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            m1014w3.setText(this.f1459o0);
            linearLayout.addView(m1014w3);
        }
        WheelView m1016x2 = m1016x();
        m1016x2.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(m1016x2);
        if (!TextUtils.isEmpty(this.f1460p0)) {
            TextView m1014w4 = m1014w();
            m1014w4.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            m1014w4.setText(this.f1460p0);
            linearLayout.addView(m1014w4);
        }
        m1016x.m2593a(this.f1451g0, this.f1453i0);
        m1016x.setOnItemSelectListener(new a());
        m1016x2.m2593a(this.f1452h0, this.f1454j0);
        m1016x2.setOnItemSelectListener(new b());
        return linearLayout;
    }

    public void setOnPickListener(c cVar) {
        this.f1456l0 = cVar;
    }

    public void setOnWheelListener(d dVar) {
        this.f1455k0 = dVar;
    }

    @Override // p023b.p024a.p025a.p028f.AbstractC0927b
    /* renamed from: v */
    public void mo847v() {
        c cVar = this.f1456l0;
        if (cVar != null) {
            cVar.m935a(this.f1453i0, this.f1454j0);
        }
    }

    /* renamed from: y */
    public String m933y() {
        int size = this.f1451g0.size();
        int i2 = this.f1453i0;
        return size > i2 ? this.f1451g0.get(i2) : "";
    }

    /* renamed from: z */
    public String m934z() {
        int size = this.f1452h0.size();
        int i2 = this.f1454j0;
        return size > i2 ? this.f1452h0.get(i2) : "";
    }

    /* renamed from: e */
    public void m932e(int i2, int i3) {
        if (i2 >= 0 && i2 < this.f1451g0.size()) {
            this.f1453i0 = i2;
        }
        if (i3 < 0 || i3 >= this.f1452h0.size()) {
            return;
        }
        this.f1454j0 = i3;
    }

    /* renamed from: a */
    public void m930a(CharSequence charSequence, CharSequence charSequence2) {
        this.f1457m0 = charSequence;
        this.f1458n0 = charSequence2;
    }

    /* renamed from: b */
    public void m931b(CharSequence charSequence, CharSequence charSequence2) {
        this.f1459o0 = charSequence;
        this.f1460p0 = charSequence2;
    }
}
