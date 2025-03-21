package com.scwang.smartrefresh.layout.header;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.scwang.smartrefresh.layout.C2851R;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2870d;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2873g;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2874h;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2875i;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2876j;
import com.scwang.smartrefresh.layout.p190c.EnumC2879b;
import com.scwang.smartrefresh.layout.p190c.EnumC2880c;

/* loaded from: classes.dex */
public class TwoLevelHeader extends InternalAbstract implements InterfaceC2873g {

    /* renamed from: d */
    protected int f9206d;

    /* renamed from: e */
    protected float f9207e;

    /* renamed from: f */
    protected float f9208f;

    /* renamed from: g */
    protected float f9209g;

    /* renamed from: h */
    protected float f9210h;

    /* renamed from: i */
    protected boolean f9211i;

    /* renamed from: j */
    protected boolean f9212j;

    /* renamed from: k */
    protected int f9213k;

    /* renamed from: l */
    protected int f9214l;

    /* renamed from: m */
    protected InterfaceC2874h f9215m;

    /* renamed from: n */
    protected InterfaceC2875i f9216n;

    /* renamed from: o */
    protected InterfaceC2870d f9217o;

    /* renamed from: com.scwang.smartrefresh.layout.header.TwoLevelHeader$a */
    static /* synthetic */ class C2899a {

        /* renamed from: a */
        static final /* synthetic */ int[] f9218a;

        /* renamed from: b */
        static final /* synthetic */ int[] f9219b = new int[EnumC2880c.values().length];

        static {
            try {
                f9219b[EnumC2880c.Translate.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9219b[EnumC2880c.Scale.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f9218a = new int[EnumC2879b.values().length];
            try {
                f9218a[EnumC2879b.TwoLevelReleased.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9218a[EnumC2879b.TwoLevel.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9218a[EnumC2879b.TwoLevelFinish.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9218a[EnumC2879b.PullDownToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public TwoLevelHeader(@NonNull Context context) {
        this(context, null);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.p189b.InterfaceC2874h
    /* renamed from: a */
    public void mo8715a(@NonNull InterfaceC2875i interfaceC2875i, int i2, int i3) {
        InterfaceC2874h interfaceC2874h = this.f9215m;
        if (interfaceC2874h == null) {
            return;
        }
        if (((i3 + i2) * 1.0f) / i2 != this.f9208f && this.f9214l == 0) {
            this.f9214l = i2;
            this.f9215m = null;
            interfaceC2875i.mo8698c().mo8647d(this.f9208f);
            this.f9215m = interfaceC2874h;
        }
        if (this.f9216n == null && interfaceC2874h.getSpinnerStyle() == EnumC2880c.Translate && !isInEditMode()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) interfaceC2874h.getView().getLayoutParams();
            marginLayoutParams.topMargin -= i2;
            interfaceC2874h.getView().setLayoutParams(marginLayoutParams);
        }
        this.f9214l = i2;
        this.f9216n = interfaceC2875i;
        interfaceC2875i.mo8696b(this.f9213k);
        interfaceC2875i.mo8697b(this, !this.f9212j);
        interfaceC2874h.mo8715a(interfaceC2875i, i2, i3);
    }

    /* renamed from: b */
    public TwoLevelHeader m8777b(float f2) {
        if (this.f9208f != f2) {
            this.f9208f = f2;
            InterfaceC2875i interfaceC2875i = this.f9216n;
            if (interfaceC2875i != null) {
                this.f9214l = 0;
                interfaceC2875i.mo8698c().mo8647d(this.f9208f);
            }
        }
        return this;
    }

    /* renamed from: c */
    public TwoLevelHeader m8780c(float f2) {
        this.f9210h = f2;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract
    public boolean equals(Object obj) {
        InterfaceC2874h interfaceC2874h = this.f9215m;
        return (interfaceC2874h != null && interfaceC2874h.equals(obj)) || super.equals(obj);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f9233b = EnumC2880c.MatchLayout;
        if (this.f9215m == null) {
            m8773a(new ClassicsHeader(getContext()));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f9233b = EnumC2880c.FixedBehind;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            if (childAt instanceof InterfaceC2873g) {
                this.f9215m = (InterfaceC2873g) childAt;
                this.f9234c = (InterfaceC2874h) childAt;
                bringChildToFront(childAt);
                break;
            }
            i2++;
        }
        if (this.f9215m == null) {
            m8773a(new ClassicsHeader(getContext()));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        InterfaceC2874h interfaceC2874h = this.f9215m;
        if (interfaceC2874h == null) {
            super.onMeasure(i2, i3);
        } else {
            if (View.MeasureSpec.getMode(i3) != Integer.MIN_VALUE) {
                super.onMeasure(i2, i3);
                return;
            }
            interfaceC2874h.getView().measure(i2, i3);
            super.setMeasuredDimension(View.resolveSize(super.getSuggestedMinimumWidth(), i2), interfaceC2874h.getView().getMeasuredHeight());
        }
    }

    public TwoLevelHeader(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: c */
    public TwoLevelHeader m8781c(boolean z) {
        this.f9211i = z;
        return this;
    }

    public TwoLevelHeader(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f9207e = 0.0f;
        this.f9208f = 2.5f;
        this.f9209g = 1.9f;
        this.f9210h = 1.0f;
        this.f9211i = true;
        this.f9212j = true;
        this.f9213k = 1000;
        this.f9233b = EnumC2880c.FixedBehind;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2851R.styleable.TwoLevelHeader);
        this.f9208f = obtainStyledAttributes.getFloat(C2851R.styleable.TwoLevelHeader_srlMaxRage, this.f9208f);
        this.f9209g = obtainStyledAttributes.getFloat(C2851R.styleable.TwoLevelHeader_srlFloorRage, this.f9209g);
        this.f9210h = obtainStyledAttributes.getFloat(C2851R.styleable.TwoLevelHeader_srlRefreshRage, this.f9210h);
        this.f9213k = obtainStyledAttributes.getInt(C2851R.styleable.TwoLevelHeader_srlFloorDuration, this.f9213k);
        this.f9211i = obtainStyledAttributes.getBoolean(C2851R.styleable.TwoLevelHeader_srlEnableTwoLevel, this.f9211i);
        this.f9212j = obtainStyledAttributes.getBoolean(C2851R.styleable.TwoLevelHeader_srlEnablePullToCloseTwoLevel, this.f9212j);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: b */
    public TwoLevelHeader m8779b(boolean z) {
        InterfaceC2875i interfaceC2875i = this.f9216n;
        this.f9212j = z;
        if (interfaceC2875i != null) {
            interfaceC2875i.mo8697b(this, !z);
        }
        return this;
    }

    /* renamed from: b */
    public TwoLevelHeader m8778b(int i2) {
        this.f9213k = i2;
        return this;
    }

    /* renamed from: b */
    public TwoLevelHeader m8776b() {
        InterfaceC2875i interfaceC2875i = this.f9216n;
        if (interfaceC2875i != null) {
            interfaceC2875i.mo8695b();
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.p191d.InterfaceC2886f
    /* renamed from: a */
    public void mo8733a(@NonNull InterfaceC2876j interfaceC2876j, @NonNull EnumC2879b enumC2879b, @NonNull EnumC2879b enumC2879b2) {
        InterfaceC2874h interfaceC2874h = this.f9215m;
        if (interfaceC2874h != null) {
            interfaceC2874h.mo8733a(interfaceC2876j, enumC2879b, enumC2879b2);
            int i2 = C2899a.f9218a[enumC2879b2.ordinal()];
            boolean z = true;
            if (i2 == 1) {
                if (interfaceC2874h.getView() != this) {
                    interfaceC2874h.getView().animate().alpha(0.0f).setDuration(this.f9213k / 2);
                }
                InterfaceC2875i interfaceC2875i = this.f9216n;
                if (interfaceC2875i != null) {
                    InterfaceC2870d interfaceC2870d = this.f9217o;
                    if (interfaceC2870d != null && !interfaceC2870d.m8702a(interfaceC2876j)) {
                        z = false;
                    }
                    interfaceC2875i.mo8694a(z);
                    return;
                }
                return;
            }
            if (i2 != 2) {
                if (i2 == 3) {
                    if (interfaceC2874h.getView() != this) {
                        interfaceC2874h.getView().animate().alpha(1.0f).setDuration(this.f9213k / 2);
                    }
                } else if (i2 == 4 && interfaceC2874h.getView().getAlpha() == 0.0f && interfaceC2874h.getView() != this) {
                    interfaceC2874h.getView().setAlpha(1.0f);
                }
            }
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.p189b.InterfaceC2874h
    /* renamed from: a */
    public void mo8717a(boolean z, float f2, int i2, int i3, int i4) {
        m8775a(i2);
        InterfaceC2874h interfaceC2874h = this.f9215m;
        InterfaceC2875i interfaceC2875i = this.f9216n;
        if (interfaceC2874h != null) {
            interfaceC2874h.mo8717a(z, f2, i2, i3, i4);
        }
        if (z) {
            float f3 = this.f9207e;
            float f4 = this.f9209g;
            if (f3 < f4 && f2 >= f4 && this.f9211i) {
                interfaceC2875i.mo8693a(EnumC2879b.ReleaseToTwoLevel);
            } else if (this.f9207e >= this.f9209g && f2 < this.f9210h) {
                interfaceC2875i.mo8693a(EnumC2879b.PullDownToRefresh);
            } else {
                float f5 = this.f9207e;
                float f6 = this.f9209g;
                if (f5 >= f6 && f2 < f6) {
                    interfaceC2875i.mo8693a(EnumC2879b.ReleaseToRefresh);
                }
            }
            this.f9207e = f2;
        }
    }

    /* renamed from: a */
    protected void m8775a(int i2) {
        InterfaceC2874h interfaceC2874h = this.f9215m;
        if (this.f9206d == i2 || interfaceC2874h == null) {
            return;
        }
        this.f9206d = i2;
        int i3 = C2899a.f9219b[interfaceC2874h.getSpinnerStyle().ordinal()];
        if (i3 == 1) {
            interfaceC2874h.getView().setTranslationY(i2);
        } else {
            if (i3 != 2) {
                return;
            }
            View view = interfaceC2874h.getView();
            view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getTop() + Math.max(0, i2));
        }
    }

    /* renamed from: a */
    public TwoLevelHeader m8773a(InterfaceC2873g interfaceC2873g) {
        return m8774a(interfaceC2873g, -1, -2);
    }

    /* renamed from: a */
    public TwoLevelHeader m8774a(InterfaceC2873g interfaceC2873g, int i2, int i3) {
        if (interfaceC2873g != null) {
            InterfaceC2874h interfaceC2874h = this.f9215m;
            if (interfaceC2874h != null) {
                removeView(interfaceC2874h.getView());
            }
            if (interfaceC2873g.getSpinnerStyle() == EnumC2880c.FixedBehind) {
                addView(interfaceC2873g.getView(), 0, new RelativeLayout.LayoutParams(i2, i3));
            } else {
                addView(interfaceC2873g.getView(), i2, i3);
            }
            this.f9215m = interfaceC2873g;
            this.f9234c = interfaceC2873g;
        }
        return this;
    }

    /* renamed from: a */
    public TwoLevelHeader m8771a(float f2) {
        this.f9209g = f2;
        return this;
    }

    /* renamed from: a */
    public TwoLevelHeader m8772a(InterfaceC2870d interfaceC2870d) {
        this.f9217o = interfaceC2870d;
        return this;
    }
}
