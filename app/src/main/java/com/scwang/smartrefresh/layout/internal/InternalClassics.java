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
import com.scwang.smartrefresh.layout.b.h;
import com.scwang.smartrefresh.layout.b.i;
import com.scwang.smartrefresh.layout.b.j;
import com.scwang.smartrefresh.layout.e.e;
import com.scwang.smartrefresh.layout.internal.InternalClassics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class InternalClassics<T extends InternalClassics> extends InternalAbstract implements h {
    public static final byte q = 1;
    public static final byte r = 2;
    public static final byte s = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected TextView f5666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected ImageView f5667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected ImageView f5668f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected LinearLayout f5669g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected i f5670h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected b f5671i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected b f5672j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected Integer f5673k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected Integer f5674l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected int f5675m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected int f5676n;
    protected int o;
    protected int p;

    public InternalClassics(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f5676n = 500;
        this.o = 20;
        this.p = 20;
        this.f5664b = com.scwang.smartrefresh.layout.c.c.Translate;
        this.f5667e = new ImageView(context);
        this.f5668f = new ImageView(context);
        this.f5666d = new TextView(context);
        this.f5666d.setTextColor(-10066330);
        this.f5669g = new LinearLayout(context);
        this.f5669g.setGravity(1);
        this.f5669g.setOrientation(1);
        ImageView imageView = this.f5667e;
        TextView textView = this.f5666d;
        ImageView imageView2 = this.f5668f;
        LinearLayout linearLayout = this.f5669g;
        com.scwang.smartrefresh.layout.e.b bVar = new com.scwang.smartrefresh.layout.e.b();
        textView.setId(1);
        imageView.setId(2);
        imageView2.setId(3);
        linearLayout.setId(R.id.widget_frame);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(linearLayout, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(bVar.a(20.0f), bVar.a(20.0f));
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
                int iA = bVar.a(20.0f);
                this.o = iA;
                int paddingRight = getPaddingRight();
                int iA2 = bVar.a(20.0f);
                this.p = iA2;
                setPadding(paddingLeft, iA, paddingRight, iA2);
            } else {
                int paddingLeft2 = getPaddingLeft();
                int iA3 = bVar.a(20.0f);
                this.o = iA3;
                int paddingRight2 = getPaddingRight();
                int paddingBottom = getPaddingBottom();
                this.p = paddingBottom;
                setPadding(paddingLeft2, iA3, paddingRight2, paddingBottom);
            }
        } else if (getPaddingBottom() == 0) {
            int paddingLeft3 = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.o = paddingTop;
            int paddingRight3 = getPaddingRight();
            int iA4 = bVar.a(20.0f);
            this.p = iA4;
            setPadding(paddingLeft3, paddingTop, paddingRight3, iA4);
        } else {
            this.o = getPaddingTop();
            this.p = getPaddingBottom();
        }
        if (isInEditMode()) {
            imageView.setVisibility(8);
        } else {
            imageView2.setVisibility(8);
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.b.h
    public void a(@NonNull i iVar, int i2, int i3) {
        this.f5670h = iVar;
        this.f5670h.a(this, this.f5675m);
    }

    protected T b() {
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.b.h
    public void b(@NonNull j jVar, int i2, int i3) {
        a(jVar, i2, i3);
    }

    public T c(@DrawableRes int i2) {
        this.f5671i = null;
        this.f5667e.setImageResource(i2);
        return (T) b();
    }

    public T d(int i2) {
        this.f5676n = i2;
        return (T) b();
    }

    public T e(@ColorInt int i2) {
        Integer numValueOf = Integer.valueOf(i2);
        this.f5674l = numValueOf;
        this.f5675m = numValueOf.intValue();
        i iVar = this.f5670h;
        if (iVar != null) {
            iVar.a(this, this.f5674l.intValue());
        }
        return (T) b();
    }

    public T f(@ColorRes int i2) {
        e(e.a(getContext(), i2));
        return (T) b();
    }

    public T g(@DrawableRes int i2) {
        this.f5672j = null;
        this.f5668f.setImageResource(i2);
        return (T) b();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (Build.VERSION.SDK_INT >= 14) {
            ImageView imageView = this.f5667e;
            ImageView imageView2 = this.f5668f;
            imageView.animate().cancel();
            imageView2.animate().cancel();
        }
        Object drawable = this.f5668f.getDrawable();
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
            setPadding(getPaddingLeft(), this.o, getPaddingRight(), this.p);
        }
        super.onMeasure(i2, i3);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.b.h
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            if (!(getBackground() instanceof BitmapDrawable) && this.f5674l == null) {
                e(iArr[0]);
                this.f5674l = null;
            }
            if (this.f5673k == null) {
                if (iArr.length > 1) {
                    a(iArr[1]);
                }
                this.f5673k = null;
            }
        }
    }

    public T b(Drawable drawable) {
        this.f5672j = null;
        this.f5668f.setImageDrawable(drawable);
        return (T) b();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.b.h
    public void a(@NonNull j jVar, int i2, int i3) {
        ImageView imageView = this.f5668f;
        if (imageView.getVisibility() != 0) {
            imageView.setVisibility(0);
            Object drawable = this.f5668f.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            } else {
                imageView.animate().rotation(36000.0f).setDuration(100000L);
            }
        }
    }

    public T d(float f2) {
        ImageView imageView = this.f5667e;
        ImageView imageView2 = this.f5668f;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = imageView2.getLayoutParams();
        int iB = com.scwang.smartrefresh.layout.e.b.b(f2);
        layoutParams2.width = iB;
        layoutParams.width = iB;
        int iB2 = com.scwang.smartrefresh.layout.e.b.b(f2);
        layoutParams2.height = iB2;
        layoutParams.height = iB2;
        imageView.setLayoutParams(layoutParams);
        imageView2.setLayoutParams(layoutParams2);
        return (T) b();
    }

    public T c(float f2) {
        ImageView imageView = this.f5668f;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int iB = com.scwang.smartrefresh.layout.e.b.b(f2);
        layoutParams.width = iB;
        layoutParams.height = iB;
        imageView.setLayoutParams(layoutParams);
        return (T) b();
    }

    public T b(@ColorRes int i2) {
        a(e.a(getContext(), i2));
        return (T) b();
    }

    public T e(float f2) {
        this.f5666d.setTextSize(f2);
        i iVar = this.f5670h;
        if (iVar != null) {
            iVar.a(this);
        }
        return (T) b();
    }

    public T b(float f2) {
        ImageView imageView = this.f5667e;
        ImageView imageView2 = this.f5668f;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) imageView2.getLayoutParams();
        int iB = com.scwang.smartrefresh.layout.e.b.b(f2);
        marginLayoutParams2.rightMargin = iB;
        marginLayoutParams.rightMargin = iB;
        imageView.setLayoutParams(marginLayoutParams);
        imageView2.setLayoutParams(marginLayoutParams2);
        return (T) b();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.b.h
    public int a(@NonNull j jVar, boolean z) {
        ImageView imageView = this.f5668f;
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
        return this.f5676n;
    }

    public T a(Drawable drawable) {
        this.f5671i = null;
        this.f5667e.setImageDrawable(drawable);
        return (T) b();
    }

    public T a(com.scwang.smartrefresh.layout.c.c cVar) {
        this.f5664b = cVar;
        return (T) b();
    }

    public T a(@ColorInt int i2) {
        this.f5673k = Integer.valueOf(i2);
        this.f5666d.setTextColor(i2);
        b bVar = this.f5671i;
        if (bVar != null) {
            bVar.a(i2);
            this.f5667e.invalidateDrawable(this.f5671i);
        }
        b bVar2 = this.f5672j;
        if (bVar2 != null) {
            bVar2.a(i2);
            this.f5668f.invalidateDrawable(this.f5672j);
        }
        return (T) b();
    }

    public T a(float f2) {
        ImageView imageView = this.f5667e;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int iB = com.scwang.smartrefresh.layout.e.b.b(f2);
        layoutParams.width = iB;
        layoutParams.height = iB;
        imageView.setLayoutParams(layoutParams);
        return (T) b();
    }
}
