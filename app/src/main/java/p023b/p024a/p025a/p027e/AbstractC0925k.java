package p023b.p024a.p025a.p027e;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import cn.qqtheme.framework.widget.WheelView;
import p023b.p024a.p025a.p028f.AbstractC0927b;

/* compiled from: WheelPicker.java */
/* renamed from: b.a.a.e.k */
/* loaded from: classes.dex */
public abstract class AbstractC0925k extends AbstractC0927b<View> {

    /* renamed from: I */
    protected float f1506I;

    /* renamed from: J */
    protected int f1507J;

    /* renamed from: K */
    protected int f1508K;

    /* renamed from: L */
    protected Typeface f1509L;

    /* renamed from: M */
    protected int f1510M;

    /* renamed from: N */
    protected int f1511N;

    /* renamed from: O */
    protected int f1512O;

    /* renamed from: b0 */
    protected int f1513b0;

    /* renamed from: c0 */
    protected boolean f1514c0;

    /* renamed from: d0 */
    protected boolean f1515d0;

    /* renamed from: e0 */
    protected boolean f1516e0;

    /* renamed from: f0 */
    protected WheelView.C1286c f1517f0;

    public AbstractC0925k(Activity activity) {
        super(activity);
        this.f1506I = 2.0f;
        this.f1507J = -1;
        this.f1508K = 16;
        this.f1509L = Typeface.DEFAULT;
        this.f1510M = WheelView.f2878i0;
        this.f1511N = WheelView.f2877h0;
        this.f1512O = WheelView.f2877h0;
        this.f1513b0 = 3;
        this.f1514c0 = true;
        this.f1515d0 = true;
        this.f1516e0 = true;
        this.f1517f0 = new WheelView.C1286c();
    }

    /* renamed from: A */
    public void m996A(@ColorInt int i2) {
        this.f1511N = i2;
    }

    /* renamed from: B */
    public void m997B(int i2) {
        this.f1507J = i2;
    }

    /* renamed from: C */
    public void m998C(int i2) {
        this.f1508K = i2;
    }

    /* renamed from: a */
    public void m999a(float f2) {
        if (this.f1517f0 == null) {
            this.f1517f0 = new WheelView.C1286c();
        }
        this.f1517f0.m2597a(f2);
    }

    /* renamed from: b */
    public final void m1001b(@FloatRange(from = 2.0d, m293to = 4.0d) float f2) {
        this.f1506I = f2;
    }

    /* renamed from: c */
    public void m1004c(@ColorInt int i2, @IntRange(from = 1, m294to = 255) int i3) {
        if (this.f1517f0 == null) {
            this.f1517f0 = new WheelView.C1286c();
        }
        this.f1517f0.m2604d(i2);
        this.f1517f0.m2603c(i3);
    }

    /* renamed from: d */
    public void m1005d(@ColorInt int i2, @ColorInt int i3) {
        this.f1511N = i2;
        this.f1510M = i3;
    }

    /* renamed from: i */
    public void m1006i(boolean z) {
        this.f1514c0 = z;
    }

    /* renamed from: j */
    public void m1007j(boolean z) {
        if (this.f1517f0 == null) {
            this.f1517f0 = new WheelView.C1286c();
        }
        this.f1517f0.m2602b(z);
    }

    @Deprecated
    /* renamed from: k */
    public void m1008k(boolean z) {
        m1007j(z);
    }

    /* renamed from: l */
    public void m1009l(boolean z) {
        if (this.f1517f0 == null) {
            this.f1517f0 = new WheelView.C1286c();
        }
        this.f1517f0.m2599a(z);
    }

    /* renamed from: m */
    public void m1010m(boolean z) {
        this.f1516e0 = z;
    }

    /* renamed from: n */
    public void m1011n(boolean z) {
        this.f1515d0 = z;
    }

    /* renamed from: u */
    public void m1012u(@ColorInt int i2) {
        if (this.f1517f0 == null) {
            this.f1517f0 = new WheelView.C1286c();
        }
        this.f1517f0.m2602b(true);
        this.f1517f0.m2601b(i2);
    }

    /* renamed from: v */
    public void m1013v(int i2) {
        this.f1512O = i2;
    }

    @Deprecated
    /* renamed from: w */
    public void m1015w(@ColorInt int i2) {
        m1012u(i2);
    }

    /* renamed from: x */
    public void m1017x(@IntRange(from = 1, m294to = 5) int i2) {
        this.f1513b0 = i2;
    }

    @Deprecated
    /* renamed from: y */
    public void m1018y(int i2) {
        this.f1507J = i2;
    }

    /* renamed from: z */
    public void m1019z(@ColorInt int i2) {
        m1004c(i2, 100);
    }

    @Deprecated
    /* renamed from: b */
    public void m1002b(WheelView.C1286c c1286c) {
        m1000a(c1286c);
    }

    /* renamed from: w */
    protected TextView m1014w() {
        TextView textView = new TextView(this.f1520a);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        textView.setTextColor(this.f1512O);
        textView.setTextSize(this.f1508K);
        return textView;
    }

    /* renamed from: x */
    protected WheelView m1016x() {
        WheelView wheelView = new WheelView(this.f1520a);
        wheelView.setLineSpaceMultiplier(this.f1506I);
        wheelView.setTextPadding(this.f1507J);
        wheelView.setTextSize(this.f1508K);
        wheelView.setTypeface(this.f1509L);
        wheelView.m2591a(this.f1510M, this.f1511N);
        wheelView.setDividerConfig(this.f1517f0);
        wheelView.setOffset(this.f1513b0);
        wheelView.setCycleDisable(this.f1514c0);
        wheelView.setUseWeight(this.f1515d0);
        wheelView.setTextSizeAutoFit(this.f1516e0);
        return wheelView;
    }

    /* renamed from: a */
    public void m1000a(@Nullable WheelView.C1286c c1286c) {
        if (c1286c == null) {
            this.f1517f0 = new WheelView.C1286c();
            this.f1517f0.m2602b(false);
            this.f1517f0.m2599a(false);
            return;
        }
        this.f1517f0 = c1286c;
    }

    @Override // p023b.p024a.p025a.p028f.AbstractDialogInterfaceOnKeyListenerC0926a
    /* renamed from: c */
    public View mo1003c() {
        if (this.f1536G == null) {
            this.f1536G = mo846r();
        }
        return this.f1536G;
    }
}
