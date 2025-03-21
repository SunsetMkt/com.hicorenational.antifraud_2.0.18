package com.scwang.smartrefresh.layout.footer;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.scwang.smartrefresh.layout.C2851R;
import com.scwang.smartrefresh.layout.internal.C2902a;
import com.scwang.smartrefresh.layout.internal.C2904c;
import com.scwang.smartrefresh.layout.internal.InternalClassics;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2872f;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2876j;
import com.scwang.smartrefresh.layout.p190c.EnumC2879b;
import com.scwang.smartrefresh.layout.p190c.EnumC2880c;
import com.scwang.smartrefresh.layout.p192e.C2889b;

/* loaded from: classes.dex */
public class ClassicsFooter extends InternalClassics<ClassicsFooter> implements InterfaceC2872f {

    /* renamed from: B */
    public static String f9135B;

    /* renamed from: C */
    public static String f9136C;

    /* renamed from: D */
    public static String f9137D;

    /* renamed from: E */
    public static String f9138E;

    /* renamed from: F */
    public static String f9139F;

    /* renamed from: G */
    public static String f9140G;

    /* renamed from: H */
    public static String f9141H;

    /* renamed from: A */
    protected boolean f9142A;

    /* renamed from: t */
    protected String f9143t;

    /* renamed from: u */
    protected String f9144u;

    /* renamed from: v */
    protected String f9145v;

    /* renamed from: w */
    protected String f9146w;

    /* renamed from: x */
    protected String f9147x;

    /* renamed from: y */
    protected String f9148y;

    /* renamed from: z */
    protected String f9149z;

    /* renamed from: com.scwang.smartrefresh.layout.footer.ClassicsFooter$a */
    static /* synthetic */ class C2895a {

        /* renamed from: a */
        static final /* synthetic */ int[] f9150a = new int[EnumC2879b.values().length];

        static {
            try {
                f9150a[EnumC2879b.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9150a[EnumC2879b.PullUpToLoad.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9150a[EnumC2879b.Loading.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9150a[EnumC2879b.LoadReleased.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9150a[EnumC2879b.ReleaseToLoad.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9150a[EnumC2879b.Refreshing.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ClassicsFooter(Context context) {
        this(context, null);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.p189b.InterfaceC2874h
    /* renamed from: a */
    public void mo8716a(@NonNull InterfaceC2876j interfaceC2876j, int i2, int i3) {
        if (this.f9142A) {
            return;
        }
        super.mo8716a(interfaceC2876j, i2, i3);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.p189b.InterfaceC2874h
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (this.f9233b == EnumC2880c.FixedBehind) {
            super.setPrimaryColors(iArr);
        }
    }

    public ClassicsFooter(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClassicsFooter(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f9143t = null;
        this.f9144u = null;
        this.f9145v = null;
        this.f9146w = null;
        this.f9147x = null;
        this.f9148y = null;
        this.f9149z = null;
        this.f9142A = false;
        if (f9135B == null) {
            f9135B = context.getString(C2851R.string.srl_footer_pulling);
        }
        if (f9136C == null) {
            f9136C = context.getString(C2851R.string.srl_footer_release);
        }
        if (f9137D == null) {
            f9137D = context.getString(C2851R.string.srl_footer_loading);
        }
        if (f9138E == null) {
            f9138E = context.getString(C2851R.string.srl_footer_refreshing);
        }
        if (f9139F == null) {
            f9139F = context.getString(C2851R.string.srl_footer_finish);
        }
        if (f9140G == null) {
            f9140G = context.getString(C2851R.string.srl_footer_failed);
        }
        if (f9141H == null) {
            f9141H = context.getString(C2851R.string.srl_footer_nothing);
        }
        ImageView imageView = this.f9239e;
        ImageView imageView2 = this.f9240f;
        C2889b c2889b = new C2889b();
        this.f9238d.setTextColor(-10066330);
        this.f9238d.setText(isInEditMode() ? f9137D : f9135B);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2851R.styleable.ClassicsFooter);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
        layoutParams2.rightMargin = obtainStyledAttributes.getDimensionPixelSize(C2851R.styleable.ClassicsFooter_srlDrawableMarginRight, c2889b.m8737a(20.0f));
        layoutParams.rightMargin = layoutParams2.rightMargin;
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(C2851R.styleable.ClassicsFooter_srlDrawableArrowSize, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(C2851R.styleable.ClassicsFooter_srlDrawableArrowSize, layoutParams.height);
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(C2851R.styleable.ClassicsFooter_srlDrawableProgressSize, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(C2851R.styleable.ClassicsFooter_srlDrawableProgressSize, layoutParams2.height);
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(C2851R.styleable.ClassicsFooter_srlDrawableSize, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(C2851R.styleable.ClassicsFooter_srlDrawableSize, layoutParams.height);
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(C2851R.styleable.ClassicsFooter_srlDrawableSize, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(C2851R.styleable.ClassicsFooter_srlDrawableSize, layoutParams2.height);
        this.f9248n = obtainStyledAttributes.getInt(C2851R.styleable.ClassicsFooter_srlFinishDuration, this.f9248n);
        this.f9233b = EnumC2880c.values()[obtainStyledAttributes.getInt(C2851R.styleable.ClassicsFooter_srlClassicsSpinnerStyle, this.f9233b.ordinal())];
        if (obtainStyledAttributes.hasValue(C2851R.styleable.ClassicsFooter_srlDrawableArrow)) {
            this.f9239e.setImageDrawable(obtainStyledAttributes.getDrawable(C2851R.styleable.ClassicsFooter_srlDrawableArrow));
        } else {
            this.f9243i = new C2902a();
            this.f9243i.m8800a(-10066330);
            this.f9239e.setImageDrawable(this.f9243i);
        }
        if (obtainStyledAttributes.hasValue(C2851R.styleable.ClassicsFooter_srlDrawableProgress)) {
            this.f9240f.setImageDrawable(obtainStyledAttributes.getDrawable(C2851R.styleable.ClassicsFooter_srlDrawableProgress));
        } else {
            this.f9244j = new C2904c();
            this.f9244j.m8800a(-10066330);
            this.f9240f.setImageDrawable(this.f9244j);
        }
        if (obtainStyledAttributes.hasValue(C2851R.styleable.ClassicsFooter_srlTextSizeTitle)) {
            this.f9238d.setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(C2851R.styleable.ClassicsFooter_srlTextSizeTitle, C2889b.m8735b(16.0f)));
        } else {
            this.f9238d.setTextSize(16.0f);
        }
        if (obtainStyledAttributes.hasValue(C2851R.styleable.ClassicsFooter_srlPrimaryColor)) {
            super.m8797e(obtainStyledAttributes.getColor(C2851R.styleable.ClassicsFooter_srlPrimaryColor, 0));
        }
        if (obtainStyledAttributes.hasValue(C2851R.styleable.ClassicsFooter_srlAccentColor)) {
            super.mo8764a(obtainStyledAttributes.getColor(C2851R.styleable.ClassicsFooter_srlAccentColor, 0));
        }
        this.f9143t = f9135B;
        this.f9144u = f9136C;
        this.f9145v = f9137D;
        this.f9146w = f9138E;
        this.f9147x = f9139F;
        this.f9148y = f9140G;
        this.f9149z = f9141H;
        if (obtainStyledAttributes.hasValue(C2851R.styleable.ClassicsFooter_srlTextPulling)) {
            this.f9143t = obtainStyledAttributes.getString(C2851R.styleable.ClassicsFooter_srlTextPulling);
        }
        if (obtainStyledAttributes.hasValue(C2851R.styleable.ClassicsFooter_srlTextRelease)) {
            this.f9144u = obtainStyledAttributes.getString(C2851R.styleable.ClassicsFooter_srlTextRelease);
        }
        if (obtainStyledAttributes.hasValue(C2851R.styleable.ClassicsFooter_srlTextLoading)) {
            this.f9145v = obtainStyledAttributes.getString(C2851R.styleable.ClassicsFooter_srlTextLoading);
        }
        if (obtainStyledAttributes.hasValue(C2851R.styleable.ClassicsFooter_srlTextRefreshing)) {
            this.f9146w = obtainStyledAttributes.getString(C2851R.styleable.ClassicsFooter_srlTextRefreshing);
        }
        if (obtainStyledAttributes.hasValue(C2851R.styleable.ClassicsFooter_srlTextFinish)) {
            this.f9147x = obtainStyledAttributes.getString(C2851R.styleable.ClassicsFooter_srlTextFinish);
        }
        if (obtainStyledAttributes.hasValue(C2851R.styleable.ClassicsFooter_srlTextFailed)) {
            this.f9148y = obtainStyledAttributes.getString(C2851R.styleable.ClassicsFooter_srlTextFailed);
        }
        if (obtainStyledAttributes.hasValue(C2851R.styleable.ClassicsFooter_srlTextNothing)) {
            this.f9149z = obtainStyledAttributes.getString(C2851R.styleable.ClassicsFooter_srlTextNothing);
        }
        obtainStyledAttributes.recycle();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.p189b.InterfaceC2874h
    /* renamed from: a */
    public int mo8713a(@NonNull InterfaceC2876j interfaceC2876j, boolean z) {
        if (this.f9142A) {
            return 0;
        }
        this.f9238d.setText(z ? this.f9147x : this.f9148y);
        return super.mo8713a(interfaceC2876j, z);
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2872f
    /* renamed from: a */
    public boolean mo8712a(boolean z) {
        if (this.f9142A == z) {
            return true;
        }
        this.f9142A = z;
        ImageView imageView = this.f9239e;
        if (z) {
            this.f9238d.setText(this.f9149z);
            imageView.setVisibility(8);
            return true;
        }
        this.f9238d.setText(this.f9143t);
        imageView.setVisibility(0);
        return true;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.p191d.InterfaceC2886f
    /* renamed from: a */
    public void mo8733a(@NonNull InterfaceC2876j interfaceC2876j, @NonNull EnumC2879b enumC2879b, @NonNull EnumC2879b enumC2879b2) {
        ImageView imageView = this.f9239e;
        if (this.f9142A) {
            return;
        }
        switch (C2895a.f9150a[enumC2879b2.ordinal()]) {
            case 1:
                imageView.setVisibility(0);
                break;
            case 2:
                break;
            case 3:
            case 4:
                imageView.setVisibility(8);
                this.f9238d.setText(this.f9145v);
                return;
            case 5:
                this.f9238d.setText(this.f9144u);
                imageView.animate().rotation(0.0f);
                return;
            case 6:
                this.f9238d.setText(this.f9146w);
                imageView.setVisibility(8);
                return;
            default:
                return;
        }
        this.f9238d.setText(this.f9143t);
        imageView.animate().rotation(180.0f);
    }
}
