package com.scwang.smartrefresh.layout.header;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.scwang.smartrefresh.layout.C2851R;
import com.scwang.smartrefresh.layout.internal.C2902a;
import com.scwang.smartrefresh.layout.internal.C2904c;
import com.scwang.smartrefresh.layout.internal.InternalClassics;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2873g;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2875i;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2876j;
import com.scwang.smartrefresh.layout.p190c.EnumC2879b;
import com.scwang.smartrefresh.layout.p190c.EnumC2880c;
import com.scwang.smartrefresh.layout.p192e.C2889b;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class ClassicsHeader extends InternalClassics<ClassicsHeader> implements InterfaceC2873g {

    /* renamed from: H */
    public static final byte f9181H = 4;

    /* renamed from: I */
    public static String f9182I;

    /* renamed from: J */
    public static String f9183J;

    /* renamed from: K */
    public static String f9184K;

    /* renamed from: L */
    public static String f9185L;

    /* renamed from: M */
    public static String f9186M;

    /* renamed from: N */
    public static String f9187N;

    /* renamed from: O */
    public static String f9188O;

    /* renamed from: b0 */
    public static String f9189b0;

    /* renamed from: A */
    protected String f9190A;

    /* renamed from: B */
    protected String f9191B;

    /* renamed from: C */
    protected String f9192C;

    /* renamed from: D */
    protected String f9193D;

    /* renamed from: E */
    protected String f9194E;

    /* renamed from: F */
    protected String f9195F;

    /* renamed from: G */
    protected String f9196G;

    /* renamed from: t */
    protected String f9197t;

    /* renamed from: u */
    protected Date f9198u;

    /* renamed from: v */
    protected TextView f9199v;

    /* renamed from: w */
    protected SharedPreferences f9200w;

    /* renamed from: x */
    protected DateFormat f9201x;

    /* renamed from: y */
    protected boolean f9202y;

    /* renamed from: z */
    protected String f9203z;

    /* renamed from: com.scwang.smartrefresh.layout.header.ClassicsHeader$a */
    static /* synthetic */ class C2898a {

        /* renamed from: a */
        static final /* synthetic */ int[] f9204a = new int[EnumC2879b.values().length];

        static {
            try {
                f9204a[EnumC2879b.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9204a[EnumC2879b.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9204a[EnumC2879b.Refreshing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9204a[EnumC2879b.RefreshReleased.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9204a[EnumC2879b.ReleaseToRefresh.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9204a[EnumC2879b.ReleaseToTwoLevel.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9204a[EnumC2879b.Loading.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public ClassicsHeader(Context context) {
        this(context, null);
    }

    /* renamed from: b */
    public ClassicsHeader m8768b(boolean z) {
        TextView textView = this.f9199v;
        this.f9202y = z;
        textView.setVisibility(z ? 0 : 8);
        InterfaceC2875i interfaceC2875i = this.f9242h;
        if (interfaceC2875i != null) {
            interfaceC2875i.mo8690a(this);
        }
        return this;
    }

    /* renamed from: f */
    public ClassicsHeader m8769f(float f2) {
        this.f9199v.setTextSize(f2);
        InterfaceC2875i interfaceC2875i = this.f9242h;
        if (interfaceC2875i != null) {
            interfaceC2875i.mo8690a(this);
        }
        return this;
    }

    /* renamed from: g */
    public ClassicsHeader m8770g(float f2) {
        TextView textView = this.f9199v;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        marginLayoutParams.topMargin = C2889b.m8735b(f2);
        textView.setLayoutParams(marginLayoutParams);
        return this;
    }

    public ClassicsHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.p189b.InterfaceC2874h
    /* renamed from: a */
    public int mo8713a(@NonNull InterfaceC2876j interfaceC2876j, boolean z) {
        if (z) {
            this.f9238d.setText(this.f9193D);
            if (this.f9198u != null) {
                m8767a(new Date());
            }
        } else {
            this.f9238d.setText(this.f9194E);
        }
        return super.mo8713a(interfaceC2876j, z);
    }

    public ClassicsHeader(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        FragmentManager supportFragmentManager;
        List<Fragment> fragments;
        this.f9197t = "LAST_UPDATE_TIME";
        this.f9202y = true;
        this.f9203z = null;
        this.f9190A = null;
        this.f9191B = null;
        this.f9192C = null;
        this.f9193D = null;
        this.f9194E = null;
        this.f9195F = null;
        this.f9196G = null;
        if (f9182I == null) {
            f9182I = context.getString(C2851R.string.srl_header_pulling);
        }
        if (f9183J == null) {
            f9183J = context.getString(C2851R.string.srl_header_refreshing);
        }
        if (f9184K == null) {
            f9184K = context.getString(C2851R.string.srl_header_loading);
        }
        if (f9185L == null) {
            f9185L = context.getString(C2851R.string.srl_header_release);
        }
        if (f9186M == null) {
            f9186M = context.getString(C2851R.string.srl_header_finish);
        }
        if (f9187N == null) {
            f9187N = context.getString(C2851R.string.srl_header_failed);
        }
        if (f9188O == null) {
            f9188O = context.getString(C2851R.string.srl_header_update);
        }
        if (f9189b0 == null) {
            f9189b0 = context.getString(C2851R.string.srl_header_secondary);
        }
        this.f9199v = new TextView(context);
        this.f9199v.setTextColor(-8618884);
        this.f9201x = new SimpleDateFormat(f9188O, Locale.getDefault());
        ImageView imageView = this.f9239e;
        TextView textView = this.f9199v;
        ImageView imageView2 = this.f9240f;
        LinearLayout linearLayout = this.f9241g;
        C2889b c2889b = new C2889b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2851R.styleable.ClassicsHeader);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = obtainStyledAttributes.getDimensionPixelSize(C2851R.styleable.ClassicsHeader_srlTextTimeMarginTop, c2889b.m8737a(0.0f));
        layoutParams2.rightMargin = obtainStyledAttributes.getDimensionPixelSize(C2851R.styleable.ClassicsFooter_srlDrawableMarginRight, c2889b.m8737a(20.0f));
        layoutParams.rightMargin = layoutParams2.rightMargin;
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(C2851R.styleable.ClassicsHeader_srlDrawableArrowSize, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(C2851R.styleable.ClassicsHeader_srlDrawableArrowSize, layoutParams.height);
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(C2851R.styleable.ClassicsHeader_srlDrawableProgressSize, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(C2851R.styleable.ClassicsHeader_srlDrawableProgressSize, layoutParams2.height);
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(C2851R.styleable.ClassicsHeader_srlDrawableSize, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(C2851R.styleable.ClassicsHeader_srlDrawableSize, layoutParams.height);
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(C2851R.styleable.ClassicsHeader_srlDrawableSize, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(C2851R.styleable.ClassicsHeader_srlDrawableSize, layoutParams2.height);
        this.f9248n = obtainStyledAttributes.getInt(C2851R.styleable.ClassicsHeader_srlFinishDuration, this.f9248n);
        this.f9202y = obtainStyledAttributes.getBoolean(C2851R.styleable.ClassicsHeader_srlEnableLastTime, this.f9202y);
        this.f9233b = EnumC2880c.values()[obtainStyledAttributes.getInt(C2851R.styleable.ClassicsHeader_srlClassicsSpinnerStyle, this.f9233b.ordinal())];
        if (obtainStyledAttributes.hasValue(C2851R.styleable.ClassicsHeader_srlDrawableArrow)) {
            this.f9239e.setImageDrawable(obtainStyledAttributes.getDrawable(C2851R.styleable.ClassicsHeader_srlDrawableArrow));
        } else {
            this.f9243i = new C2902a();
            this.f9243i.m8800a(-10066330);
            this.f9239e.setImageDrawable(this.f9243i);
        }
        if (obtainStyledAttributes.hasValue(C2851R.styleable.ClassicsHeader_srlDrawableProgress)) {
            this.f9240f.setImageDrawable(obtainStyledAttributes.getDrawable(C2851R.styleable.ClassicsHeader_srlDrawableProgress));
        } else {
            this.f9244j = new C2904c();
            this.f9244j.m8800a(-10066330);
            this.f9240f.setImageDrawable(this.f9244j);
        }
        if (obtainStyledAttributes.hasValue(C2851R.styleable.ClassicsHeader_srlTextSizeTitle)) {
            this.f9238d.setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(C2851R.styleable.ClassicsHeader_srlTextSizeTitle, C2889b.m8735b(16.0f)));
        } else {
            this.f9238d.setTextSize(16.0f);
        }
        if (obtainStyledAttributes.hasValue(C2851R.styleable.ClassicsHeader_srlTextSizeTime)) {
            this.f9199v.setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(C2851R.styleable.ClassicsHeader_srlTextSizeTime, C2889b.m8735b(12.0f)));
        } else {
            this.f9199v.setTextSize(12.0f);
        }
        if (obtainStyledAttributes.hasValue(C2851R.styleable.ClassicsHeader_srlPrimaryColor)) {
            super.m8797e(obtainStyledAttributes.getColor(C2851R.styleable.ClassicsHeader_srlPrimaryColor, 0));
        }
        if (obtainStyledAttributes.hasValue(C2851R.styleable.ClassicsHeader_srlAccentColor)) {
            mo8764a(obtainStyledAttributes.getColor(C2851R.styleable.ClassicsHeader_srlAccentColor, 0));
        }
        this.f9203z = f9182I;
        this.f9191B = f9184K;
        this.f9192C = f9185L;
        this.f9193D = f9186M;
        this.f9194E = f9187N;
        this.f9195F = f9188O;
        this.f9196G = f9189b0;
        this.f9190A = f9183J;
        if (obtainStyledAttributes.hasValue(C2851R.styleable.ClassicsHeader_srlTextPulling)) {
            this.f9203z = obtainStyledAttributes.getString(C2851R.styleable.ClassicsHeader_srlTextPulling);
        }
        if (obtainStyledAttributes.hasValue(C2851R.styleable.ClassicsHeader_srlTextLoading)) {
            this.f9191B = obtainStyledAttributes.getString(C2851R.styleable.ClassicsHeader_srlTextLoading);
        }
        if (obtainStyledAttributes.hasValue(C2851R.styleable.ClassicsHeader_srlTextRelease)) {
            this.f9192C = obtainStyledAttributes.getString(C2851R.styleable.ClassicsHeader_srlTextRelease);
        }
        if (obtainStyledAttributes.hasValue(C2851R.styleable.ClassicsHeader_srlTextFinish)) {
            this.f9193D = obtainStyledAttributes.getString(C2851R.styleable.ClassicsHeader_srlTextFinish);
        }
        if (obtainStyledAttributes.hasValue(C2851R.styleable.ClassicsHeader_srlTextFailed)) {
            this.f9194E = obtainStyledAttributes.getString(C2851R.styleable.ClassicsHeader_srlTextFailed);
        }
        if (obtainStyledAttributes.hasValue(C2851R.styleable.ClassicsHeader_srlTextUpdate)) {
            this.f9195F = obtainStyledAttributes.getString(C2851R.styleable.ClassicsHeader_srlTextUpdate);
        }
        if (obtainStyledAttributes.hasValue(C2851R.styleable.ClassicsHeader_srlTextSecondary)) {
            this.f9196G = obtainStyledAttributes.getString(C2851R.styleable.ClassicsHeader_srlTextSecondary);
        }
        if (obtainStyledAttributes.hasValue(C2851R.styleable.ClassicsHeader_srlTextRefreshing)) {
            this.f9190A = obtainStyledAttributes.getString(C2851R.styleable.ClassicsHeader_srlTextRefreshing);
        }
        obtainStyledAttributes.recycle();
        textView.setId(4);
        textView.setVisibility(this.f9202y ? 0 : 8);
        linearLayout.addView(textView, layoutParams3);
        this.f9238d.setText(isInEditMode() ? this.f9190A : this.f9203z);
        try {
            if ((context instanceof FragmentActivity) && (supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager()) != null && (fragments = supportFragmentManager.getFragments()) != null && fragments.size() > 0) {
                m8767a(new Date());
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f9197t += context.getClass().getName();
        this.f9200w = context.getSharedPreferences("ClassicsHeader", 0);
        m8767a(new Date(this.f9200w.getLong(this.f9197t, System.currentTimeMillis())));
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.p191d.InterfaceC2886f
    /* renamed from: a */
    public void mo8733a(@NonNull InterfaceC2876j interfaceC2876j, @NonNull EnumC2879b enumC2879b, @NonNull EnumC2879b enumC2879b2) {
        ImageView imageView = this.f9239e;
        TextView textView = this.f9199v;
        switch (C2898a.f9204a[enumC2879b2.ordinal()]) {
            case 1:
                textView.setVisibility(this.f9202y ? 0 : 8);
                break;
            case 2:
                break;
            case 3:
            case 4:
                this.f9238d.setText(this.f9190A);
                imageView.setVisibility(8);
                return;
            case 5:
                this.f9238d.setText(this.f9192C);
                imageView.animate().rotation(180.0f);
                return;
            case 6:
                this.f9238d.setText(this.f9196G);
                imageView.animate().rotation(0.0f);
                return;
            case 7:
                imageView.setVisibility(8);
                textView.setVisibility(this.f9202y ? 4 : 8);
                this.f9238d.setText(this.f9191B);
                return;
            default:
                return;
        }
        this.f9238d.setText(this.f9203z);
        imageView.setVisibility(0);
        imageView.animate().rotation(0.0f);
    }

    /* renamed from: a */
    public ClassicsHeader m8767a(Date date) {
        this.f9198u = date;
        this.f9199v.setText(this.f9201x.format(date));
        if (this.f9200w != null && !isInEditMode()) {
            this.f9200w.edit().putLong(this.f9197t, date.getTime()).apply();
        }
        return this;
    }

    /* renamed from: a */
    public ClassicsHeader m8766a(DateFormat dateFormat) {
        this.f9201x = dateFormat;
        Date date = this.f9198u;
        if (date != null) {
            this.f9199v.setText(this.f9201x.format(date));
        }
        return this;
    }

    /* renamed from: a */
    public ClassicsHeader m8765a(CharSequence charSequence) {
        this.f9198u = null;
        this.f9199v.setText(charSequence);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics
    /* renamed from: a */
    public ClassicsHeader mo8764a(@ColorInt int i2) {
        this.f9199v.setTextColor((16777215 & i2) | (-872415232));
        return (ClassicsHeader) super.mo8764a(i2);
    }
}
