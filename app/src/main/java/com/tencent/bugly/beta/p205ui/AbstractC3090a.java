package com.tencent.bugly.beta.p205ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.global.C3078a;
import com.tencent.bugly.beta.global.ResBean;
import com.tencent.bugly.beta.global.ViewOnTouchListenerC3080c;
import com.tencent.bugly.beta.utils.C3105e;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.ui.a */
/* loaded from: classes2.dex */
public abstract class AbstractC3090a extends AbstractC3091b {

    /* renamed from: a */
    protected Context f9929a;

    /* renamed from: b */
    protected View f9930b;

    /* renamed from: c */
    protected FrameLayout f9931c;

    /* renamed from: d */
    protected LinearLayout f9932d;

    /* renamed from: e */
    protected ImageView f9933e;

    /* renamed from: f */
    protected TextView f9934f;

    /* renamed from: g */
    protected TextView f9935g;

    /* renamed from: h */
    protected TextView f9936h;

    /* renamed from: i */
    protected LinearLayout f9937i;

    /* renamed from: j */
    protected ResBean f9938j;

    /* renamed from: k */
    protected int f9939k;

    /* renamed from: l */
    protected int f9940l;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f9929a = getActivity();
        this.f9938j = ResBean.f9856a;
        int i2 = this.f9940l;
        if (i2 == 0) {
            this.f9930b = new RelativeLayout(this.f9929a);
            ((RelativeLayout) this.f9930b).setGravity(17);
            this.f9930b.setBackgroundColor(Color.argb(100, 0, 0, 0));
            this.f9931c = new FrameLayout(this.f9929a);
            this.f9931c.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.f9932d = new LinearLayout(this.f9929a);
            this.f9932d.setBackgroundColor(-1);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
            this.f9932d.setGravity(17);
            this.f9932d.setLayoutParams(layoutParams);
            this.f9932d.setMinimumWidth(C3078a.m9322a(this.f9929a, 280.0f));
            this.f9932d.setOrientation(1);
            if (this.f9939k == 2) {
                float m9322a = C3078a.m9322a(this.f9929a, 6.0f);
                ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{m9322a, m9322a, m9322a, m9322a, m9322a, m9322a, m9322a, m9322a}, null, null));
                shapeDrawable.getPaint().setColor(-1);
                shapeDrawable.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
                this.f9932d.setBackgroundDrawable(shapeDrawable);
            }
            this.f9934f = new TextView(this.f9929a);
            this.f9934f.setGravity(16);
            this.f9934f.setSingleLine();
            TextView textView = this.f9934f;
            this.f9938j.getClass();
            textView.setTextColor(Color.parseColor("#273238"));
            this.f9934f.setTextSize(18.0f);
            this.f9934f.setLayoutParams(layoutParams);
            this.f9934f.setOnClickListener(null);
            this.f9934f.setEllipsize(TextUtils.TruncateAt.END);
            int m9322a2 = C3078a.m9322a(this.f9929a, 16.0f);
            this.f9934f.setPadding(m9322a2, 0, m9322a2, 0);
            this.f9934f.setTypeface(null, 1);
            this.f9934f.setHeight(C3078a.m9322a(this.f9929a, 42.0f));
            this.f9934f.setTag(Beta.TAG_TITLE);
            TextView textView2 = new TextView(this.f9929a);
            textView2.setBackgroundColor(-3355444);
            textView2.setHeight(1);
            ScrollView scrollView = new ScrollView(this.f9929a);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(0, 0, 0, C3078a.m9322a(this.f9929a, 52.0f));
            scrollView.setLayoutParams(layoutParams2);
            scrollView.setFillViewport(true);
            scrollView.setVerticalScrollBarEnabled(false);
            scrollView.setHorizontalScrollBarEnabled(false);
            this.f9937i = new LinearLayout(this.f9929a);
            this.f9937i.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.f9937i.setOrientation(1);
            this.f9937i.setPadding(m9322a2, C3078a.m9322a(this.f9929a, 10.0f), m9322a2, 0);
            LinearLayout linearLayout = new LinearLayout(this.f9929a);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setGravity(17);
            linearLayout.setOrientation(0);
            int i3 = m9322a2 / 2;
            linearLayout.setPadding(i3, m9322a2, i3, m9322a2);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams3.gravity = 80;
            linearLayout.setLayoutParams(layoutParams3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2, 1.0f);
            layoutParams4.setMargins(i3, 0, i3, 0);
            this.f9935g = new TextView(this.f9929a);
            this.f9935g.setSingleLine();
            this.f9935g.setGravity(17);
            this.f9935g.setTag(Beta.TAG_CANCEL_BUTTON);
            new RelativeLayout.LayoutParams(-2, -2);
            int m9322a3 = C3078a.m9322a(this.f9929a, 30.0f);
            if (this.f9939k == 2) {
                FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(m9322a3, m9322a3);
                layoutParams5.gravity = 53;
                this.f9935g.setLayoutParams(layoutParams5);
                this.f9935g.setTextSize((float) (m9322a3 * 0.3d));
            } else {
                this.f9935g.setLayoutParams(layoutParams4);
                this.f9935g.setTextSize(16);
                TextView textView3 = this.f9935g;
                this.f9938j.getClass();
                textView3.setTextColor(Color.parseColor("#757575"));
                this.f9935g.setPadding(C3078a.m9322a(this.f9929a, 10.0f), C3078a.m9322a(this.f9929a, 5.0f), C3078a.m9322a(this.f9929a, 10.0f), C3078a.m9322a(this.f9929a, 5.0f));
            }
            this.f9936h = new TextView(this.f9929a);
            this.f9936h.setLayoutParams(layoutParams4);
            this.f9936h.setGravity(17);
            this.f9936h.setTextSize(16);
            TextView textView4 = this.f9936h;
            this.f9938j.getClass();
            textView4.setTextColor(Color.parseColor("#273238"));
            this.f9936h.setSingleLine();
            this.f9936h.setPadding(C3078a.m9322a(this.f9929a, 10.0f), C3078a.m9322a(this.f9929a, 5.0f), C3078a.m9322a(this.f9929a, 10.0f), C3078a.m9322a(this.f9929a, 5.0f));
            this.f9936h.setTypeface(null, 1);
            this.f9936h.setTag(Beta.TAG_CONFIRM_BUTTON);
            int m9322a4 = C3078a.m9322a(this.f9929a, 40.0f);
            scrollView.addView(this.f9937i);
            if (this.f9939k == 2) {
                FrameLayout frameLayout = new FrameLayout(this.f9929a);
                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                int i4 = m9322a3 / 2;
                int i5 = i4 - 5;
                this.f9931c.setPadding(i4, i5, i5, i4);
                frameLayout.addView(this.f9931c);
                frameLayout.addView(this.f9935g);
                ((RelativeLayout) this.f9930b).addView(frameLayout);
            } else {
                this.f9930b.setPadding(m9322a4, m9322a4, m9322a4, m9322a4);
                ((RelativeLayout) this.f9930b).addView(this.f9931c);
                linearLayout.addView(this.f9935g);
            }
            this.f9932d.addView(this.f9934f);
            this.f9932d.addView(textView2);
            this.f9932d.addView(scrollView);
            this.f9931c.addView(this.f9932d);
            linearLayout.addView(this.f9936h);
            this.f9931c.addView(linearLayout);
            if (this.f9939k == 2) {
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                paint.setAntiAlias(true);
                Bitmap createBitmap = Bitmap.createBitmap(m9322a3, m9322a3, Bitmap.Config.ARGB_8888);
                int i6 = m9322a3 / 2;
                Canvas canvas = new Canvas(createBitmap);
                paint.setColor(-3355444);
                float f2 = i6;
                canvas.drawCircle(f2, f2, f2, paint);
                canvas.rotate(45.0f, f2, f2);
                paint.setColor(-7829368);
                int m9322a5 = C3078a.m9322a(this.f9929a, 0.8f);
                float f3 = f2 * 0.4f;
                float f4 = i6 - m9322a5;
                float f5 = f2 * 1.6f;
                float f6 = i6 + m9322a5;
                canvas.drawRect(f3, f4, f5, f6, paint);
                canvas.drawRect(f4, f3, f6, f5, paint);
                canvas.rotate(-45.0f);
                Bitmap createBitmap2 = Bitmap.createBitmap(m9322a3, m9322a3, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap2);
                paint.setColor(-7829368);
                canvas2.drawCircle(f2, f2, f2, paint);
                canvas2.rotate(45.0f, f2, f2);
                paint.setColor(-3355444);
                canvas2.drawRect(f3, f4, f5, f6, paint);
                canvas2.drawRect(f4, f3, f6, f5, paint);
                canvas2.rotate(-45.0f);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
                BitmapDrawable bitmapDrawable2 = new BitmapDrawable(createBitmap2);
                this.f9935g.setBackgroundDrawable(bitmapDrawable);
                this.f9935g.setOnTouchListener(new ViewOnTouchListenerC3080c(1, bitmapDrawable2, bitmapDrawable));
            }
            this.f9930b.setOnClickListener(null);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(300L);
            this.f9930b.startAnimation(alphaAnimation);
        } else {
            this.f9930b = layoutInflater.inflate(i2, (ViewGroup) null);
            this.f9933e = (ImageView) this.f9930b.findViewWithTag(Beta.TAG_IMG_BANNER);
            this.f9934f = (TextView) this.f9930b.findViewWithTag(Beta.TAG_TITLE);
            this.f9935g = (TextView) this.f9930b.findViewWithTag(Beta.TAG_CANCEL_BUTTON);
            this.f9936h = (TextView) this.f9930b.findViewWithTag(Beta.TAG_CONFIRM_BUTTON);
        }
        this.f9935g.setVisibility(8);
        this.f9936h.setVisibility(8);
        this.f9935g.setFocusable(true);
        this.f9936h.setFocusable(true);
        this.f9936h.requestFocus();
        return this.f9930b;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f9929a = null;
        this.f9930b = null;
        this.f9931c = null;
        this.f9932d = null;
        this.f9934f = null;
        this.f9933e = null;
        this.f9935g = null;
        this.f9936h = null;
        this.f9937i = null;
    }

    /* renamed from: a */
    protected void m9352a(final String str, final View.OnClickListener onClickListener, final String str2, final View.OnClickListener onClickListener2) {
        C3105e.m9461a(new Runnable() { // from class: com.tencent.bugly.beta.ui.a.1
            @Override // java.lang.Runnable
            public void run() {
                AbstractC3090a abstractC3090a = AbstractC3090a.this;
                TextView textView = abstractC3090a.f9935g;
                if (textView == null || abstractC3090a.f9936h == null) {
                    return;
                }
                if (str != null) {
                    textView.setVisibility(0);
                    AbstractC3090a abstractC3090a2 = AbstractC3090a.this;
                    if (abstractC3090a2.f9939k != 2) {
                        abstractC3090a2.f9935g.setText(str);
                        AbstractC3090a abstractC3090a3 = AbstractC3090a.this;
                        if (abstractC3090a3.f9940l == 0) {
                            abstractC3090a3.f9935g.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC3093d(2, Integer.valueOf(AbstractC3090a.this.f9939k), AbstractC3090a.this.f9935g, 1));
                        }
                    }
                    AbstractC3090a.this.f9935g.setOnClickListener(onClickListener);
                }
                if (str2 != null) {
                    AbstractC3090a.this.f9936h.setVisibility(0);
                    AbstractC3090a.this.f9936h.setText(str2);
                    AbstractC3090a.this.f9936h.setOnClickListener(onClickListener2);
                    AbstractC3090a abstractC3090a4 = AbstractC3090a.this;
                    if (abstractC3090a4.f9940l == 0) {
                        abstractC3090a4.f9936h.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC3093d(2, Integer.valueOf(AbstractC3090a.this.f9939k), AbstractC3090a.this.f9936h, 1));
                    }
                    AbstractC3090a.this.f9936h.requestFocus();
                }
            }
        });
    }

    @Override // com.tencent.bugly.beta.p205ui.AbstractC3091b
    /* renamed from: a */
    public void mo9351a() {
        if (this.f9930b == null) {
            super.mo9351a();
            return;
        }
        final AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200L);
        C3105e.m9461a(new Runnable() { // from class: com.tencent.bugly.beta.ui.a.2
            @Override // java.lang.Runnable
            public void run() {
                View view = AbstractC3090a.this.f9930b;
                if (view != null) {
                    view.startAnimation(alphaAnimation);
                }
            }
        });
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.bugly.beta.ui.a.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                View view = AbstractC3090a.this.f9930b;
                if (view != null) {
                    view.setVisibility(8);
                }
                AbstractC3090a.super.mo9351a();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
    }
}
