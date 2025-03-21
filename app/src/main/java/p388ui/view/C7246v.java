package p388ui.view;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;
import java.util.List;
import p023b.p024a.p025a.p027e.AbstractC0925k;

/* compiled from: ThreePicker.java */
/* renamed from: ui.view.v */
/* loaded from: classes2.dex */
public class C7246v extends AbstractC0925k {

    /* renamed from: g0 */
    private List<String> f25017g0;

    /* renamed from: h0 */
    private List<String> f25018h0;

    /* renamed from: i0 */
    private List<String> f25019i0;

    /* renamed from: j0 */
    private int f25020j0;

    /* renamed from: k0 */
    private int f25021k0;

    /* renamed from: l0 */
    private int f25022l0;

    /* renamed from: m0 */
    private e f25023m0;

    /* renamed from: n0 */
    private d f25024n0;

    /* renamed from: o0 */
    private CharSequence f25025o0;

    /* renamed from: p0 */
    private CharSequence f25026p0;

    /* renamed from: q0 */
    private CharSequence f25027q0;

    /* renamed from: r0 */
    private CharSequence f25028r0;

    /* renamed from: s0 */
    private CharSequence f25029s0;

    /* renamed from: t0 */
    private CharSequence f25030t0;

    /* compiled from: ThreePicker.java */
    /* renamed from: ui.view.v$a */
    class a implements WheelView.InterfaceC1290g {
        a() {
        }

        @Override // cn.qqtheme.framework.widget.WheelView.InterfaceC1290g
        /* renamed from: a */
        public void mo848a(int i2) {
            C7246v.this.f25020j0 = i2;
            if (C7246v.this.f25023m0 != null) {
                C7246v.this.f25023m0.m26071g(C7246v.this.f25020j0, (String) C7246v.this.f25017g0.get(C7246v.this.f25020j0));
            }
        }
    }

    /* compiled from: ThreePicker.java */
    /* renamed from: ui.view.v$b */
    class b implements WheelView.InterfaceC1290g {
        b() {
        }

        @Override // cn.qqtheme.framework.widget.WheelView.InterfaceC1290g
        /* renamed from: a */
        public void mo848a(int i2) {
            C7246v.this.f25021k0 = i2;
            if (C7246v.this.f25023m0 != null) {
                C7246v.this.f25023m0.m26070f(C7246v.this.f25021k0, (String) C7246v.this.f25018h0.get(C7246v.this.f25021k0));
            }
        }
    }

    /* compiled from: ThreePicker.java */
    /* renamed from: ui.view.v$c */
    class c implements WheelView.InterfaceC1290g {
        c() {
        }

        @Override // cn.qqtheme.framework.widget.WheelView.InterfaceC1290g
        /* renamed from: a */
        public void mo848a(int i2) {
            C7246v.this.f25022l0 = i2;
            if (C7246v.this.f25023m0 != null) {
                C7246v.this.f25023m0.m26070f(C7246v.this.f25022l0, (String) C7246v.this.f25019i0.get(C7246v.this.f25022l0));
            }
        }
    }

    /* compiled from: ThreePicker.java */
    /* renamed from: ui.view.v$d */
    public interface d {
        /* renamed from: a */
        void m26068a(int i2, int i3, int i4);
    }

    /* compiled from: ThreePicker.java */
    /* renamed from: ui.view.v$e */
    public interface e {
        /* renamed from: a */
        void m26069a(int i2, String str);

        /* renamed from: f */
        void m26070f(int i2, String str);

        /* renamed from: g */
        void m26071g(int i2, String str);
    }

    public C7246v(Activity activity, List<String> list, List<String> list2, List<String> list3) {
        super(activity);
        this.f25017g0 = new ArrayList();
        this.f25018h0 = new ArrayList();
        this.f25019i0 = new ArrayList();
        this.f25020j0 = 0;
        this.f25021k0 = 0;
        this.f25022l0 = 0;
        this.f25017g0 = list;
        this.f25018h0 = list2;
        this.f25019i0 = list3;
    }

    /* renamed from: A */
    public String m26061A() {
        int size = this.f25019i0.size();
        int i2 = this.f25022l0;
        return size > i2 ? this.f25019i0.get(i2) : "";
    }

    @Override // p023b.p024a.p025a.p028f.AbstractC0927b
    @NonNull
    /* renamed from: r */
    protected View mo846r() {
        LinearLayout linearLayout = new LinearLayout(this.f1520a);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        if (!TextUtils.isEmpty(this.f25025o0)) {
            TextView m1014w = m1014w();
            m1014w.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            m1014w.setText(this.f25025o0);
            linearLayout.addView(m1014w);
        }
        WheelView m1016x = m1016x();
        m1016x.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(m1016x);
        if (!TextUtils.isEmpty(this.f25026p0)) {
            TextView m1014w2 = m1014w();
            m1014w2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            m1014w2.setText(this.f25026p0);
            linearLayout.addView(m1014w2);
        }
        if (!TextUtils.isEmpty(this.f25027q0)) {
            TextView m1014w3 = m1014w();
            m1014w3.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            m1014w3.setText(this.f25027q0);
            linearLayout.addView(m1014w3);
        }
        WheelView m1016x2 = m1016x();
        m1016x2.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(m1016x2);
        if (!TextUtils.isEmpty(this.f25028r0)) {
            TextView m1014w4 = m1014w();
            m1014w4.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            m1014w4.setText(this.f25028r0);
            linearLayout.addView(m1014w4);
        }
        if (!TextUtils.isEmpty(this.f25029s0)) {
            TextView m1014w5 = m1014w();
            m1014w5.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            m1014w5.setText(this.f25029s0);
            linearLayout.addView(m1014w5);
        }
        WheelView m1016x3 = m1016x();
        m1016x3.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(m1016x3);
        if (!TextUtils.isEmpty(this.f25030t0)) {
            TextView m1014w6 = m1014w();
            m1014w6.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            m1014w6.setText(this.f25030t0);
            linearLayout.addView(m1014w6);
        }
        m1016x.m2593a(this.f25017g0, this.f25020j0);
        m1016x.setOnItemSelectListener(new a());
        m1016x2.m2593a(this.f25018h0, this.f25021k0);
        m1016x2.setOnItemSelectListener(new b());
        m1016x3.m2593a(this.f25019i0, this.f25022l0);
        m1016x3.setOnItemSelectListener(new c());
        return linearLayout;
    }

    public void setOnPickListener(d dVar) {
        this.f25024n0 = dVar;
    }

    public void setOnWheelListener(e eVar) {
        this.f25023m0 = eVar;
    }

    @Override // p023b.p024a.p025a.p028f.AbstractC0927b
    /* renamed from: v */
    public void mo847v() {
        d dVar = this.f25024n0;
        if (dVar != null) {
            dVar.m26068a(this.f25020j0, this.f25021k0, this.f25022l0);
        }
    }

    /* renamed from: y */
    public String m26066y() {
        int size = this.f25017g0.size();
        int i2 = this.f25020j0;
        return size > i2 ? this.f25017g0.get(i2) : "";
    }

    /* renamed from: z */
    public String m26067z() {
        int size = this.f25018h0.size();
        int i2 = this.f25021k0;
        return size > i2 ? this.f25018h0.get(i2) : "";
    }

    /* renamed from: a */
    public void m26062a(int i2, int i3, int i4) {
        if (i2 >= 0 && i2 < this.f25017g0.size()) {
            this.f25020j0 = i2;
        }
        if (i3 >= 0 && i3 < this.f25018h0.size()) {
            this.f25021k0 = i3;
        }
        if (i4 < 0 || i4 >= this.f25019i0.size()) {
            return;
        }
        this.f25022l0 = i4;
    }

    /* renamed from: b */
    public void m26064b(CharSequence charSequence, CharSequence charSequence2) {
        this.f25027q0 = charSequence;
        this.f25028r0 = charSequence2;
    }

    /* renamed from: c */
    public void m26065c(CharSequence charSequence, CharSequence charSequence2) {
        this.f25029s0 = charSequence;
        this.f25030t0 = charSequence2;
    }

    /* renamed from: a */
    public void m26063a(CharSequence charSequence, CharSequence charSequence2) {
        this.f25025o0 = charSequence;
        this.f25026p0 = charSequence2;
    }
}
