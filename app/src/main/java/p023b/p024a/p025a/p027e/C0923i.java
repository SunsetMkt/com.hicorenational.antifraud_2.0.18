package p023b.p024a.p025a.p027e;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.qqtheme.framework.widget.WheelView;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import p023b.p024a.p025a.p029g.C0929b;

/* compiled from: SinglePicker.java */
/* renamed from: b.a.a.e.i */
/* loaded from: classes.dex */
public class C0923i<T> extends AbstractC0925k {

    /* renamed from: o0 */
    private static final int f1492o0 = -99;

    /* renamed from: g0 */
    private List<T> f1493g0;

    /* renamed from: h0 */
    private List<String> f1494h0;

    /* renamed from: i0 */
    private WheelView f1495i0;

    /* renamed from: j0 */
    private c<T> f1496j0;

    /* renamed from: k0 */
    private b<T> f1497k0;

    /* renamed from: l0 */
    private int f1498l0;

    /* renamed from: m0 */
    private String f1499m0;

    /* renamed from: n0 */
    private int f1500n0;

    /* compiled from: SinglePicker.java */
    /* renamed from: b.a.a.e.i$a */
    class a implements WheelView.InterfaceC1290g {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // cn.qqtheme.framework.widget.WheelView.InterfaceC1290g
        /* renamed from: a */
        public void mo848a(int i2) {
            C0923i.this.f1498l0 = i2;
            if (C0923i.this.f1496j0 != null) {
                C0923i.this.f1496j0.m988a(C0923i.this.f1498l0, C0923i.this.f1493g0.get(i2));
            }
        }
    }

    /* compiled from: SinglePicker.java */
    /* renamed from: b.a.a.e.i$b */
    public interface b<T> {
        /* renamed from: a */
        void mo970a(int i2, T t);
    }

    /* compiled from: SinglePicker.java */
    /* renamed from: b.a.a.e.i$c */
    public interface c<T> {
        /* renamed from: a */
        void m988a(int i2, T t);
    }

    public C0923i(Activity activity, T[] tArr) {
        this(activity, Arrays.asList(tArr));
    }

    /* renamed from: d */
    private String m976d(T t) {
        return ((t instanceof Float) || (t instanceof Double)) ? new DecimalFormat("0.00").format(t) : t.toString();
    }

    /* renamed from: A */
    public WheelView m977A() {
        return this.f1495i0;
    }

    /* renamed from: D */
    public void m978D(int i2) {
        WheelView wheelView = this.f1495i0;
        if (wheelView == null) {
            this.f1500n0 = i2;
            return;
        }
        ViewGroup.LayoutParams layoutParams = wheelView.getLayoutParams();
        layoutParams.width = C0929b.m1103b(this.f1520a, i2);
        this.f1495i0.setLayoutParams(layoutParams);
    }

    /* renamed from: E */
    public void m979E(int i2) {
        if (i2 < 0 || i2 >= this.f1493g0.size()) {
            return;
        }
        this.f1498l0 = i2;
    }

    @Override // p023b.p024a.p025a.p028f.AbstractC0927b
    @NonNull
    /* renamed from: r */
    protected View mo846r() {
        if (this.f1493g0.size() == 0) {
            throw new IllegalArgumentException("Items can't be empty");
        }
        LinearLayout linearLayout = new LinearLayout(this.f1520a);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        this.f1495i0 = m1016x();
        linearLayout.addView(this.f1495i0);
        if (TextUtils.isEmpty(this.f1499m0)) {
            this.f1495i0.setLayoutParams(new LinearLayout.LayoutParams(this.f1521b, -2));
        } else {
            this.f1495i0.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            TextView m1014w = m1014w();
            m1014w.setText(this.f1499m0);
            linearLayout.addView(m1014w);
        }
        this.f1495i0.m2593a(this.f1494h0, this.f1498l0);
        this.f1495i0.setOnItemSelectListener(new a());
        if (this.f1500n0 != f1492o0) {
            ViewGroup.LayoutParams layoutParams = this.f1495i0.getLayoutParams();
            layoutParams.width = C0929b.m1103b(this.f1520a, this.f1500n0);
            this.f1495i0.setLayoutParams(layoutParams);
        }
        return linearLayout;
    }

    public void setOnItemPickListener(b<T> bVar) {
        this.f1497k0 = bVar;
    }

    public void setOnWheelListener(c<T> cVar) {
        this.f1496j0 = cVar;
    }

    @Override // p023b.p024a.p025a.p028f.AbstractC0927b
    /* renamed from: v */
    public void mo847v() {
        b<T> bVar = this.f1497k0;
        if (bVar != null) {
            bVar.mo970a(this.f1498l0, m987z());
        }
    }

    /* renamed from: y */
    public int m986y() {
        return this.f1498l0;
    }

    /* renamed from: z */
    public T m987z() {
        return this.f1493g0.get(this.f1498l0);
    }

    public C0923i(Activity activity, List<T> list) {
        super(activity);
        this.f1493g0 = new ArrayList();
        this.f1494h0 = new ArrayList();
        this.f1498l0 = 0;
        this.f1499m0 = "";
        this.f1500n0 = f1492o0;
        m982a((List) list);
    }

    /* renamed from: b */
    public void m984b(T t) {
        this.f1493g0.remove(t);
        this.f1494h0.remove(m976d((C0923i<T>) t));
    }

    /* renamed from: c */
    public void m985c(@NonNull T t) {
        m979E(this.f1494h0.indexOf(m976d((C0923i<T>) t)));
    }

    /* renamed from: a */
    public void m980a(T t) {
        this.f1493g0.add(t);
        this.f1494h0.add(m976d((C0923i<T>) t));
    }

    /* renamed from: a */
    public void m983a(T[] tArr) {
        m982a((List) Arrays.asList(tArr));
    }

    /* renamed from: a */
    public void m982a(List<T> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.f1493g0 = list;
        this.f1494h0.clear();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            this.f1494h0.add(m976d((C0923i<T>) it.next()));
        }
        WheelView wheelView = this.f1495i0;
        if (wheelView != null) {
            wheelView.m2593a(this.f1494h0, this.f1498l0);
        }
    }

    /* renamed from: a */
    public void m981a(String str) {
        this.f1499m0 = str;
    }
}
