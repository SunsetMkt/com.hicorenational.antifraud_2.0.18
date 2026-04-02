package com.tencent.bugly.beta.ui;

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
import com.tencent.bugly.beta.global.ResBean;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends b {
    protected Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected View f6034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected FrameLayout f6035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected LinearLayout f6036d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected ImageView f6037e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected TextView f6038f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected TextView f6039g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected TextView f6040h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected LinearLayout f6041i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected ResBean f6042j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected int f6043k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected int f6044l;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = getActivity();
        this.f6042j = ResBean.a;
        int i2 = this.f6044l;
        if (i2 == 0) {
            this.f6034b = new RelativeLayout(this.a);
            ((RelativeLayout) this.f6034b).setGravity(17);
            this.f6034b.setBackgroundColor(Color.argb(100, 0, 0, 0));
            this.f6035c = new FrameLayout(this.a);
            this.f6035c.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.f6036d = new LinearLayout(this.a);
            this.f6036d.setBackgroundColor(-1);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
            this.f6036d.setGravity(17);
            this.f6036d.setLayoutParams(layoutParams);
            this.f6036d.setMinimumWidth(com.tencent.bugly.beta.global.a.a(this.a, 280.0f));
            this.f6036d.setOrientation(1);
            if (this.f6043k == 2) {
                float fA = com.tencent.bugly.beta.global.a.a(this.a, 6.0f);
                ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{fA, fA, fA, fA, fA, fA, fA, fA}, null, null));
                shapeDrawable.getPaint().setColor(-1);
                shapeDrawable.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
                this.f6036d.setBackgroundDrawable(shapeDrawable);
            }
            this.f6038f = new TextView(this.a);
            this.f6038f.setGravity(16);
            this.f6038f.setSingleLine();
            TextView textView = this.f6038f;
            this.f6042j.getClass();
            textView.setTextColor(Color.parseColor("#273238"));
            this.f6038f.setTextSize(18.0f);
            this.f6038f.setLayoutParams(layoutParams);
            this.f6038f.setOnClickListener(null);
            this.f6038f.setEllipsize(TextUtils.TruncateAt.END);
            int iA = com.tencent.bugly.beta.global.a.a(this.a, 16.0f);
            this.f6038f.setPadding(iA, 0, iA, 0);
            this.f6038f.setTypeface(null, 1);
            this.f6038f.setHeight(com.tencent.bugly.beta.global.a.a(this.a, 42.0f));
            this.f6038f.setTag(Beta.TAG_TITLE);
            TextView textView2 = new TextView(this.a);
            textView2.setBackgroundColor(-3355444);
            textView2.setHeight(1);
            ScrollView scrollView = new ScrollView(this.a);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(0, 0, 0, com.tencent.bugly.beta.global.a.a(this.a, 52.0f));
            scrollView.setLayoutParams(layoutParams2);
            scrollView.setFillViewport(true);
            scrollView.setVerticalScrollBarEnabled(false);
            scrollView.setHorizontalScrollBarEnabled(false);
            this.f6041i = new LinearLayout(this.a);
            this.f6041i.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.f6041i.setOrientation(1);
            this.f6041i.setPadding(iA, com.tencent.bugly.beta.global.a.a(this.a, 10.0f), iA, 0);
            LinearLayout linearLayout = new LinearLayout(this.a);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setGravity(17);
            linearLayout.setOrientation(0);
            int i3 = iA / 2;
            linearLayout.setPadding(i3, iA, i3, iA);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams3.gravity = 80;
            linearLayout.setLayoutParams(layoutParams3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2, 1.0f);
            layoutParams4.setMargins(i3, 0, i3, 0);
            this.f6039g = new TextView(this.a);
            this.f6039g.setSingleLine();
            this.f6039g.setGravity(17);
            this.f6039g.setTag(Beta.TAG_CANCEL_BUTTON);
            new RelativeLayout.LayoutParams(-2, -2);
            int iA2 = com.tencent.bugly.beta.global.a.a(this.a, 30.0f);
            if (this.f6043k == 2) {
                FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(iA2, iA2);
                layoutParams5.gravity = 53;
                this.f6039g.setLayoutParams(layoutParams5);
                this.f6039g.setTextSize((float) (((double) iA2) * 0.3d));
            } else {
                this.f6039g.setLayoutParams(layoutParams4);
                this.f6039g.setTextSize(16);
                TextView textView3 = this.f6039g;
                this.f6042j.getClass();
                textView3.setTextColor(Color.parseColor("#757575"));
                this.f6039g.setPadding(com.tencent.bugly.beta.global.a.a(this.a, 10.0f), com.tencent.bugly.beta.global.a.a(this.a, 5.0f), com.tencent.bugly.beta.global.a.a(this.a, 10.0f), com.tencent.bugly.beta.global.a.a(this.a, 5.0f));
            }
            this.f6040h = new TextView(this.a);
            this.f6040h.setLayoutParams(layoutParams4);
            this.f6040h.setGravity(17);
            this.f6040h.setTextSize(16);
            TextView textView4 = this.f6040h;
            this.f6042j.getClass();
            textView4.setTextColor(Color.parseColor("#273238"));
            this.f6040h.setSingleLine();
            this.f6040h.setPadding(com.tencent.bugly.beta.global.a.a(this.a, 10.0f), com.tencent.bugly.beta.global.a.a(this.a, 5.0f), com.tencent.bugly.beta.global.a.a(this.a, 10.0f), com.tencent.bugly.beta.global.a.a(this.a, 5.0f));
            this.f6040h.setTypeface(null, 1);
            this.f6040h.setTag(Beta.TAG_CONFIRM_BUTTON);
            int iA3 = com.tencent.bugly.beta.global.a.a(this.a, 40.0f);
            scrollView.addView(this.f6041i);
            if (this.f6043k == 2) {
                FrameLayout frameLayout = new FrameLayout(this.a);
                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                int i4 = iA2 / 2;
                int i5 = i4 - 5;
                this.f6035c.setPadding(i4, i5, i5, i4);
                frameLayout.addView(this.f6035c);
                frameLayout.addView(this.f6039g);
                ((RelativeLayout) this.f6034b).addView(frameLayout);
            } else {
                this.f6034b.setPadding(iA3, iA3, iA3, iA3);
                ((RelativeLayout) this.f6034b).addView(this.f6035c);
                linearLayout.addView(this.f6039g);
            }
            this.f6036d.addView(this.f6038f);
            this.f6036d.addView(textView2);
            this.f6036d.addView(scrollView);
            this.f6035c.addView(this.f6036d);
            linearLayout.addView(this.f6040h);
            this.f6035c.addView(linearLayout);
            if (this.f6043k == 2) {
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                paint.setAntiAlias(true);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iA2, iA2, Bitmap.Config.ARGB_8888);
                int i6 = iA2 / 2;
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                paint.setColor(-3355444);
                float f2 = i6;
                canvas.drawCircle(f2, f2, f2, paint);
                canvas.rotate(45.0f, f2, f2);
                paint.setColor(-7829368);
                int iA4 = com.tencent.bugly.beta.global.a.a(this.a, 0.8f);
                float f3 = f2 * 0.4f;
                float f4 = i6 - iA4;
                float f5 = f2 * 1.6f;
                float f6 = i6 + iA4;
                canvas.drawRect(f3, f4, f5, f6, paint);
                canvas.drawRect(f4, f3, f6, f5, paint);
                canvas.rotate(-45.0f);
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(iA2, iA2, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                paint.setColor(-7829368);
                canvas2.drawCircle(f2, f2, f2, paint);
                canvas2.rotate(45.0f, f2, f2);
                paint.setColor(-3355444);
                canvas2.drawRect(f3, f4, f5, f6, paint);
                canvas2.drawRect(f4, f3, f6, f5, paint);
                canvas2.rotate(-45.0f);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
                BitmapDrawable bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap2);
                this.f6039g.setBackgroundDrawable(bitmapDrawable);
                this.f6039g.setOnTouchListener(new com.tencent.bugly.beta.global.c(1, bitmapDrawable2, bitmapDrawable));
            }
            this.f6034b.setOnClickListener(null);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(300L);
            this.f6034b.startAnimation(alphaAnimation);
        } else {
            this.f6034b = layoutInflater.inflate(i2, (ViewGroup) null);
            this.f6037e = (ImageView) this.f6034b.findViewWithTag(Beta.TAG_IMG_BANNER);
            this.f6038f = (TextView) this.f6034b.findViewWithTag(Beta.TAG_TITLE);
            this.f6039g = (TextView) this.f6034b.findViewWithTag(Beta.TAG_CANCEL_BUTTON);
            this.f6040h = (TextView) this.f6034b.findViewWithTag(Beta.TAG_CONFIRM_BUTTON);
        }
        this.f6039g.setVisibility(8);
        this.f6040h.setVisibility(8);
        this.f6039g.setFocusable(true);
        this.f6040h.setFocusable(true);
        this.f6040h.requestFocus();
        return this.f6034b;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.a = null;
        this.f6034b = null;
        this.f6035c = null;
        this.f6036d = null;
        this.f6038f = null;
        this.f6037e = null;
        this.f6039g = null;
        this.f6040h = null;
        this.f6041i = null;
    }

    protected void a(final String str, final View.OnClickListener onClickListener, final String str2, final View.OnClickListener onClickListener2) {
        com.tencent.bugly.beta.utils.e.a(new Runnable() { // from class: com.tencent.bugly.beta.ui.a.1
            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                TextView textView = aVar.f6039g;
                if (textView == null || aVar.f6040h == null) {
                    return;
                }
                if (str != null) {
                    textView.setVisibility(0);
                    a aVar2 = a.this;
                    if (aVar2.f6043k != 2) {
                        aVar2.f6039g.setText(str);
                        a aVar3 = a.this;
                        if (aVar3.f6044l == 0) {
                            aVar3.f6039g.getViewTreeObserver().addOnPreDrawListener(new d(2, Integer.valueOf(a.this.f6043k), a.this.f6039g, 1));
                        }
                    }
                    a.this.f6039g.setOnClickListener(onClickListener);
                }
                if (str2 != null) {
                    a.this.f6040h.setVisibility(0);
                    a.this.f6040h.setText(str2);
                    a.this.f6040h.setOnClickListener(onClickListener2);
                    a aVar4 = a.this;
                    if (aVar4.f6044l == 0) {
                        aVar4.f6040h.getViewTreeObserver().addOnPreDrawListener(new d(2, Integer.valueOf(a.this.f6043k), a.this.f6040h, 1));
                    }
                    a.this.f6040h.requestFocus();
                }
            }
        });
    }

    @Override // com.tencent.bugly.beta.ui.b
    public void a() {
        if (this.f6034b == null) {
            super.a();
            return;
        }
        final AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200L);
        com.tencent.bugly.beta.utils.e.a(new Runnable() { // from class: com.tencent.bugly.beta.ui.a.2
            @Override // java.lang.Runnable
            public void run() {
                View view = a.this.f6034b;
                if (view != null) {
                    view.startAnimation(alphaAnimation);
                }
            }
        });
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.bugly.beta.ui.a.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                View view = a.this.f6034b;
                if (view != null) {
                    view.setVisibility(8);
                }
                a.super.a();
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
