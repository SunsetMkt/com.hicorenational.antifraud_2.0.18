package p023b.p024a.p025a.p028f;

import android.R;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.view.ViewCompat;
import cn.qqtheme.framework.widget.WheelView;
import p023b.p024a.p025a.p029g.C0929b;

/* compiled from: ConfirmPopup.java */
/* renamed from: b.a.a.f.b */
/* loaded from: classes.dex */
public abstract class AbstractC0927b<V extends View> extends AbstractDialogInterfaceOnKeyListenerC0926a<View> {

    /* renamed from: A */
    protected int f1530A;

    /* renamed from: B */
    protected int f1531B;

    /* renamed from: C */
    protected TextView f1532C;

    /* renamed from: D */
    protected TextView f1533D;

    /* renamed from: E */
    protected View f1534E;

    /* renamed from: F */
    protected View f1535F;

    /* renamed from: G */
    protected View f1536G;

    /* renamed from: H */
    protected View f1537H;

    /* renamed from: i */
    protected boolean f1538i;

    /* renamed from: j */
    protected int f1539j;

    /* renamed from: k */
    protected int f1540k;

    /* renamed from: l */
    protected int f1541l;

    /* renamed from: m */
    protected int f1542m;

    /* renamed from: n */
    protected int f1543n;

    /* renamed from: o */
    protected int f1544o;

    /* renamed from: p */
    protected int f1545p;

    /* renamed from: q */
    protected boolean f1546q;

    /* renamed from: r */
    protected CharSequence f1547r;

    /* renamed from: s */
    protected CharSequence f1548s;

    /* renamed from: t */
    protected CharSequence f1549t;

    /* renamed from: u */
    protected int f1550u;

    /* renamed from: v */
    protected int f1551v;

    /* renamed from: w */
    protected int f1552w;

    /* renamed from: x */
    protected int f1553x;

    /* renamed from: y */
    protected int f1554y;

    /* renamed from: z */
    protected int f1555z;

    /* compiled from: ConfirmPopup.java */
    /* renamed from: b.a.a.f.b$a */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AbstractC0927b.this.m1021a();
            AbstractC0927b.this.m1077u();
        }
    }

    /* compiled from: ConfirmPopup.java */
    /* renamed from: b.a.a.f.b$b */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AbstractC0927b.this.m1021a();
            AbstractC0927b.this.mo847v();
        }
    }

    public AbstractC0927b(Activity activity) {
        super(activity);
        this.f1538i = true;
        this.f1539j = -13388315;
        this.f1540k = 1;
        this.f1541l = -1;
        this.f1542m = 40;
        this.f1543n = 15;
        this.f1544o = 0;
        this.f1545p = 0;
        this.f1546q = true;
        this.f1547r = "";
        this.f1548s = "";
        this.f1549t = "";
        this.f1550u = -13388315;
        this.f1551v = -13388315;
        this.f1552w = ViewCompat.MEASURED_STATE_MASK;
        this.f1553x = WheelView.f2877h0;
        this.f1554y = 0;
        this.f1555z = 0;
        this.f1530A = 0;
        this.f1531B = -1;
        this.f1547r = activity.getString(R.string.cancel);
        this.f1548s = activity.getString(R.string.ok);
    }

    /* renamed from: a */
    public void m1047a(CharSequence charSequence) {
        TextView textView = this.f1532C;
        if (textView != null) {
            textView.setText(charSequence);
        } else {
            this.f1547r = charSequence;
        }
    }

    /* renamed from: b */
    public void m1048b(int i2, int i3) {
        this.f1544o = i2;
        this.f1545p = i3;
    }

    /* renamed from: c */
    public void m1051c(CharSequence charSequence) {
        View view = this.f1534E;
        if (view == null || !(view instanceof TextView)) {
            this.f1549t = charSequence;
        } else {
            ((TextView) view).setText(charSequence);
        }
    }

    /* renamed from: d */
    public void m1052d(View view) {
        this.f1535F = view;
    }

    /* renamed from: e */
    public void m1053e(@ColorInt int i2) {
        this.f1531B = i2;
    }

    /* renamed from: f */
    public void m1055f(@StringRes int i2) {
        m1047a(this.f1520a.getString(i2));
    }

    /* renamed from: g */
    public void m1057g(boolean z) {
        TextView textView = this.f1532C;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        } else {
            this.f1546q = z;
        }
    }

    /* renamed from: h */
    public void m1059h(boolean z) {
        this.f1538i = z;
    }

    /* renamed from: i */
    public void m1060i(int i2) {
        this.f1553x = i2;
    }

    /* renamed from: j */
    public void m1061j(@StringRes int i2) {
        m1049b(this.f1520a.getString(i2));
    }

    /* renamed from: k */
    public void m1062k(@ColorInt int i2) {
        TextView textView = this.f1533D;
        if (textView != null) {
            textView.setTextColor(i2);
        } else {
            this.f1551v = i2;
        }
    }

    /* renamed from: l */
    public void m1063l(@IntRange(from = 10, m294to = 40) int i2) {
        this.f1555z = i2;
    }

    /* renamed from: m */
    public void m1064m(@StringRes int i2) {
        m1051c(this.f1520a.getString(i2));
    }

    /* renamed from: n */
    public void m1065n(@ColorInt int i2) {
        View view = this.f1534E;
        if (view == null || !(view instanceof TextView)) {
            this.f1552w = i2;
        } else {
            ((TextView) view).setTextColor(i2);
        }
    }

    /* renamed from: o */
    public void m1067o(@IntRange(from = 10, m294to = 40) int i2) {
        this.f1530A = i2;
    }

    /* renamed from: p */
    public void m1069p(@ColorInt int i2) {
        this.f1541l = i2;
    }

    /* renamed from: q */
    public void m1071q(@IntRange(from = 10, m294to = 80) int i2) {
        this.f1542m = i2;
    }

    @NonNull
    /* renamed from: r */
    protected abstract V mo846r();

    /* renamed from: r */
    public void m1072r(@ColorInt int i2) {
        this.f1539j = i2;
    }

    /* renamed from: s */
    public void m1074s(int i2) {
        this.f1540k = i2;
    }

    /* renamed from: t */
    public void m1076t(int i2) {
        this.f1543n = i2;
    }

    /* renamed from: u */
    protected void m1077u() {
    }

    /* renamed from: v */
    protected void mo847v() {
    }

    /* renamed from: e */
    public void m1054e(View view) {
        this.f1534E = view;
    }

    /* renamed from: h */
    public void m1058h(@IntRange(from = 10, m294to = 40) int i2) {
        this.f1554y = i2;
    }

    @Override // p023b.p024a.p025a.p028f.AbstractDialogInterfaceOnKeyListenerC0926a
    /* renamed from: j */
    protected final View mo1042j() {
        LinearLayout linearLayout = new LinearLayout(this.f1520a);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setBackgroundColor(this.f1531B);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.setPadding(0, 0, 0, 0);
        linearLayout.setClipToPadding(false);
        View m1075t = m1075t();
        if (m1075t != null) {
            linearLayout.addView(m1075t);
        }
        if (this.f1538i) {
            View view = new View(this.f1520a);
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f1540k));
            view.setBackgroundColor(this.f1539j);
            linearLayout.addView(view);
        }
        if (this.f1536G == null) {
            this.f1536G = mo846r();
        }
        int i2 = this.f1544o;
        int m1103b = i2 > 0 ? C0929b.m1103b(this.f1520a, i2) : 0;
        int i3 = this.f1545p;
        int m1103b2 = i3 > 0 ? C0929b.m1103b(this.f1520a, i3) : 0;
        this.f1536G.setPadding(m1103b, m1103b2, m1103b, m1103b2);
        ViewGroup viewGroup = (ViewGroup) this.f1536G.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.f1536G);
        }
        linearLayout.addView(this.f1536G, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        View m1073s = m1073s();
        if (m1073s != null) {
            linearLayout.addView(m1073s);
        }
        return linearLayout;
    }

    /* renamed from: o */
    public TextView m1066o() {
        TextView textView = this.f1532C;
        if (textView != null) {
            return textView;
        }
        throw new NullPointerException("please call show at first");
    }

    /* renamed from: p */
    public TextView m1068p() {
        TextView textView = this.f1533D;
        if (textView != null) {
            return textView;
        }
        throw new NullPointerException("please call show at first");
    }

    /* renamed from: q */
    public View m1070q() {
        View view = this.f1534E;
        if (view != null) {
            return view;
        }
        throw new NullPointerException("please call show at first");
    }

    @Nullable
    /* renamed from: s */
    protected View m1073s() {
        View view = this.f1537H;
        if (view != null) {
            return view;
        }
        return null;
    }

    @Nullable
    /* renamed from: t */
    protected View m1075t() {
        View view = this.f1535F;
        if (view != null) {
            return view;
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.f1520a);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, C0929b.m1103b(this.f1520a, this.f1542m)));
        relativeLayout.setBackgroundColor(this.f1541l);
        relativeLayout.setGravity(16);
        this.f1532C = new TextView(this.f1520a);
        this.f1532C.setVisibility(this.f1546q ? 0 : 8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(15, -1);
        this.f1532C.setLayoutParams(layoutParams);
        this.f1532C.setBackgroundColor(0);
        this.f1532C.setGravity(17);
        int m1103b = C0929b.m1103b(this.f1520a, this.f1543n);
        this.f1532C.setPadding(m1103b, 0, m1103b, 0);
        if (!TextUtils.isEmpty(this.f1547r)) {
            this.f1532C.setText(this.f1547r);
        }
        this.f1532C.setTextColor(C0929b.m1084a(this.f1550u, this.f1553x));
        int i2 = this.f1554y;
        if (i2 != 0) {
            this.f1532C.setTextSize(i2);
        }
        this.f1532C.setOnClickListener(new a());
        relativeLayout.addView(this.f1532C);
        if (this.f1534E == null) {
            TextView textView = new TextView(this.f1520a);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            int m1103b2 = C0929b.m1103b(this.f1520a, this.f1543n);
            layoutParams2.leftMargin = m1103b2;
            layoutParams2.rightMargin = m1103b2;
            layoutParams2.addRule(14, -1);
            layoutParams2.addRule(15, -1);
            textView.setLayoutParams(layoutParams2);
            textView.setGravity(17);
            if (!TextUtils.isEmpty(this.f1549t)) {
                textView.setText(this.f1549t);
            }
            textView.setTextColor(this.f1552w);
            int i3 = this.f1530A;
            if (i3 != 0) {
                textView.setTextSize(i3);
            }
            this.f1534E = textView;
        }
        relativeLayout.addView(this.f1534E);
        this.f1533D = new TextView(this.f1520a);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams3.addRule(11, -1);
        layoutParams3.addRule(15, -1);
        this.f1533D.setLayoutParams(layoutParams3);
        this.f1533D.setBackgroundColor(0);
        this.f1533D.setGravity(17);
        this.f1533D.setPadding(m1103b, 0, m1103b, 0);
        if (!TextUtils.isEmpty(this.f1548s)) {
            this.f1533D.setText(this.f1548s);
        }
        this.f1533D.setTextColor(C0929b.m1084a(this.f1551v, this.f1553x));
        int i4 = this.f1555z;
        if (i4 != 0) {
            this.f1533D.setTextSize(i4);
        }
        this.f1533D.setOnClickListener(new b());
        relativeLayout.addView(this.f1533D);
        return relativeLayout;
    }

    /* renamed from: b */
    public void m1049b(CharSequence charSequence) {
        TextView textView = this.f1533D;
        if (textView != null) {
            textView.setText(charSequence);
        } else {
            this.f1548s = charSequence;
        }
    }

    /* renamed from: c */
    public void m1050c(View view) {
        this.f1537H = view;
    }

    /* renamed from: g */
    public void m1056g(@ColorInt int i2) {
        TextView textView = this.f1532C;
        if (textView != null) {
            textView.setTextColor(i2);
        } else {
            this.f1550u = i2;
        }
    }
}
