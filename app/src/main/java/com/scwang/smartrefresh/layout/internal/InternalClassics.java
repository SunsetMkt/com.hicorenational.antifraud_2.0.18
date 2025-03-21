package com.scwang.smartrefresh.layout.internal;

import android.R;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.scwang.smartrefresh.layout.internal.InternalClassics;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2874h;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2875i;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2876j;
import com.scwang.smartrefresh.layout.p190c.EnumC2880c;
import com.scwang.smartrefresh.layout.p192e.AbstractC2892e;
import com.scwang.smartrefresh.layout.p192e.C2889b;

/* loaded from: classes.dex */
public abstract class InternalClassics<T extends InternalClassics> extends InternalAbstract implements InterfaceC2874h {

    /* renamed from: q */
    public static final byte f9235q = 1;

    /* renamed from: r */
    public static final byte f9236r = 2;

    /* renamed from: s */
    public static final byte f9237s = 3;

    /* renamed from: d */
    protected TextView f9238d;

    /* renamed from: e */
    protected ImageView f9239e;

    /* renamed from: f */
    protected ImageView f9240f;

    /* renamed from: g */
    protected LinearLayout f9241g;

    /* renamed from: h */
    protected InterfaceC2875i f9242h;

    /* renamed from: i */
    protected AbstractC2903b f9243i;

    /* renamed from: j */
    protected AbstractC2903b f9244j;

    /* renamed from: k */
    protected Integer f9245k;

    /* renamed from: l */
    protected Integer f9246l;

    /* renamed from: m */
    protected int f9247m;

    /* renamed from: n */
    protected int f9248n;

    /* renamed from: o */
    protected int f9249o;

    /* renamed from: p */
    protected int f9250p;

    public InternalClassics(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f9248n = 500;
        this.f9249o = 20;
        this.f9250p = 20;
        this.f9233b = EnumC2880c.Translate;
        this.f9239e = new ImageView(context);
        this.f9240f = new ImageView(context);
        this.f9238d = new TextView(context);
        this.f9238d.setTextColor(-10066330);
        this.f9241g = new LinearLayout(context);
        this.f9241g.setGravity(1);
        this.f9241g.setOrientation(1);
        ImageView imageView = this.f9239e;
        TextView textView = this.f9238d;
        ImageView imageView2 = this.f9240f;
        LinearLayout linearLayout = this.f9241g;
        C2889b c2889b = new C2889b();
        textView.setId(1);
        imageView.setId(2);
        imageView2.setId(3);
        linearLayout.setId(R.id.widget_frame);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(linearLayout, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(c2889b.m8737a(20.0f), c2889b.m8737a(20.0f));
        layoutParams2.addRule(15);
        layoutParams2.addRule(0, R.id.widget_frame);
        addView(imageView, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((ViewGroup.LayoutParams) layoutParams2);
        layoutParams3.addRule(15);
        layoutParams3.addRule(0, R.id.widget_frame);
        imageView2.animate().setInterpolator(new LinearInterpolator());
        addView(imageView2, layoutParams3);
        if (getPaddingTop() == 0) {
            if (getPaddingBottom() == 0) {
                int paddingLeft = getPaddingLeft();
                int m8737a = c2889b.m8737a(20.0f);
                this.f9249o = m8737a;
                int paddingRight = getPaddingRight();
                int m8737a2 = c2889b.m8737a(20.0f);
                this.f9250p = m8737a2;
                setPadding(paddingLeft, m8737a, paddingRight, m8737a2);
            } else {
                int paddingLeft2 = getPaddingLeft();
                int m8737a3 = c2889b.m8737a(20.0f);
                this.f9249o = m8737a3;
                int paddingRight2 = getPaddingRight();
                int paddingBottom = getPaddingBottom();
                this.f9250p = paddingBottom;
                setPadding(paddingLeft2, m8737a3, paddingRight2, paddingBottom);
            }
        } else if (getPaddingBottom() == 0) {
            int paddingLeft3 = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.f9249o = paddingTop;
            int paddingRight3 = getPaddingRight();
            int m8737a4 = c2889b.m8737a(20.0f);
            this.f9250p = m8737a4;
            setPadding(paddingLeft3, paddingTop, paddingRight3, m8737a4);
        } else {
            this.f9249o = getPaddingTop();
            this.f9250p = getPaddingBottom();
        }
        if (isInEditMode()) {
            imageView.setVisibility(8);
        } else {
            imageView2.setVisibility(8);
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.p189b.InterfaceC2874h
    /* renamed from: a */
    public void mo8715a(@NonNull InterfaceC2875i interfaceC2875i, int i2, int i3) {
        this.f9242h = interfaceC2875i;
        this.f9242h.mo8691a(this, this.f9247m);
    }

    /* renamed from: b */
    protected T m8788b() {
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.p189b.InterfaceC2874h
    /* renamed from: b */
    public void mo8719b(@NonNull InterfaceC2876j interfaceC2876j, int i2, int i3) {
        mo8716a(interfaceC2876j, i2, i3);
    }

    /* renamed from: c */
    public T m8793c(@DrawableRes int i2) {
        this.f9243i = null;
        this.f9239e.setImageResource(i2);
        return m8788b();
    }

    /* renamed from: d */
    public T m8795d(int i2) {
        this.f9248n = i2;
        return m8788b();
    }

    /* renamed from: e */
    public T m8797e(@ColorInt int i2) {
        Integer valueOf = Integer.valueOf(i2);
        this.f9246l = valueOf;
        this.f9247m = valueOf.intValue();
        InterfaceC2875i interfaceC2875i = this.f9242h;
        if (interfaceC2875i != null) {
            interfaceC2875i.mo8691a(this, this.f9246l.intValue());
        }
        return m8788b();
    }

    /* renamed from: f */
    public T m8798f(@ColorRes int i2) {
        m8797e(AbstractC2892e.m8745a(getContext(), i2));
        return m8788b();
    }

    /* renamed from: g */
    public T m8799g(@DrawableRes int i2) {
        this.f9244j = null;
        this.f9240f.setImageResource(i2);
        return m8788b();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (Build.VERSION.SDK_INT >= 14) {
            ImageView imageView = this.f9239e;
            ImageView imageView2 = this.f9240f;
            imageView.animate().cancel();
            imageView2.animate().cancel();
        }
        Object drawable = this.f9240f.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        if (View.MeasureSpec.getMode(i3) == 1073741824) {
            setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
        } else {
            setPadding(getPaddingLeft(), this.f9249o, getPaddingRight(), this.f9250p);
        }
        super.onMeasure(i2, i3);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.p189b.InterfaceC2874h
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            if (!(getBackground() instanceof BitmapDrawable) && this.f9246l == null) {
                m8797e(iArr[0]);
                this.f9246l = null;
            }
            if (this.f9245k == null) {
                if (iArr.length > 1) {
                    mo8764a(iArr[1]);
                }
                this.f9245k = null;
            }
        }
    }

    /* renamed from: b */
    public T m8791b(Drawable drawable) {
        this.f9244j = null;
        this.f9240f.setImageDrawable(drawable);
        return m8788b();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.p189b.InterfaceC2874h
    /* renamed from: a */
    public void mo8716a(@NonNull InterfaceC2876j interfaceC2876j, int i2, int i3) {
        ImageView imageView = this.f9240f;
        if (imageView.getVisibility() != 0) {
            imageView.setVisibility(0);
            Object drawable = this.f9240f.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            } else {
                imageView.animate().rotation(36000.0f).setDuration(100000L);
            }
        }
    }

    /* renamed from: d */
    public T m8794d(float f2) {
        ImageView imageView = this.f9239e;
        ImageView imageView2 = this.f9240f;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = imageView2.getLayoutParams();
        int m8735b = C2889b.m8735b(f2);
        layoutParams2.width = m8735b;
        layoutParams.width = m8735b;
        int m8735b2 = C2889b.m8735b(f2);
        layoutParams2.height = m8735b2;
        layoutParams.height = m8735b2;
        imageView.setLayoutParams(layoutParams);
        imageView2.setLayoutParams(layoutParams2);
        return m8788b();
    }

    /* renamed from: c */
    public T m8792c(float f2) {
        ImageView imageView = this.f9240f;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int m8735b = C2889b.m8735b(f2);
        layoutParams.width = m8735b;
        layoutParams.height = m8735b;
        imageView.setLayoutParams(layoutParams);
        return m8788b();
    }

    /* renamed from: b */
    public T m8790b(@ColorRes int i2) {
        mo8764a(AbstractC2892e.m8745a(getContext(), i2));
        return m8788b();
    }

    /* renamed from: e */
    public T m8796e(float f2) {
        this.f9238d.setTextSize(f2);
        InterfaceC2875i interfaceC2875i = this.f9242h;
        if (interfaceC2875i != null) {
            interfaceC2875i.mo8690a(this);
        }
        return m8788b();
    }

    /* renamed from: b */
    public T m8789b(float f2) {
        ImageView imageView = this.f9239e;
        ImageView imageView2 = this.f9240f;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) imageView2.getLayoutParams();
        int m8735b = C2889b.m8735b(f2);
        marginLayoutParams2.rightMargin = m8735b;
        marginLayoutParams.rightMargin = m8735b;
        imageView.setLayoutParams(marginLayoutParams);
        imageView2.setLayoutParams(marginLayoutParams2);
        return m8788b();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.p189b.InterfaceC2874h
    /* renamed from: a */
    public int mo8713a(@NonNull InterfaceC2876j interfaceC2876j, boolean z) {
        ImageView imageView = this.f9240f;
        Object drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        } else {
            imageView.animate().rotation(0.0f).setDuration(0L);
        }
        imageView.setVisibility(8);
        return this.f9248n;
    }

    /* renamed from: a */
    public T m8786a(Drawable drawable) {
        this.f9243i = null;
        this.f9239e.setImageDrawable(drawable);
        return m8788b();
    }

    /* renamed from: a */
    public T m8787a(EnumC2880c enumC2880c) {
        this.f9233b = enumC2880c;
        return m8788b();
    }

    /* renamed from: a */
    public T mo8764a(@ColorInt int i2) {
        this.f9245k = Integer.valueOf(i2);
        this.f9238d.setTextColor(i2);
        AbstractC2903b abstractC2903b = this.f9243i;
        if (abstractC2903b != null) {
            abstractC2903b.m8800a(i2);
            this.f9239e.invalidateDrawable(this.f9243i);
        }
        AbstractC2903b abstractC2903b2 = this.f9244j;
        if (abstractC2903b2 != null) {
            abstractC2903b2.m8800a(i2);
            this.f9240f.invalidateDrawable(this.f9244j);
        }
        return m8788b();
    }

    /* renamed from: a */
    public T m8785a(float f2) {
        ImageView imageView = this.f9239e;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int m8735b = C2889b.m8735b(f2);
        layoutParams.width = m8735b;
        layoutParams.height = m8735b;
        imageView.setLayoutParams(layoutParams);
        return m8788b();
    }
}
