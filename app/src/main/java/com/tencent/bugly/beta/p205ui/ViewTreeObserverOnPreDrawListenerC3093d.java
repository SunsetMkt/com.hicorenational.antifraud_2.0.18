package com.tencent.bugly.beta.p205ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.tencent.bugly.beta.global.C3078a;
import com.tencent.bugly.beta.global.C3082e;
import com.tencent.bugly.beta.global.ViewOnTouchListenerC3080c;
import com.tencent.bugly.proguard.C3151an;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.ui.d */
/* loaded from: classes2.dex */
public class ViewTreeObserverOnPreDrawListenerC3093d implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a */
    final int f9961a;

    /* renamed from: b */
    final Object[] f9962b;

    /* renamed from: c */
    long f9963c;

    /* renamed from: d */
    StringBuilder f9964d;

    public ViewTreeObserverOnPreDrawListenerC3093d(int i2, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("loading");
        this.f9964d = sb;
        this.f9961a = i2;
        this.f9962b = objArr;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        int i2;
        int i3;
        try {
            int i4 = this.f9961a;
            if (i4 == 1) {
                C3097h c3097h = (C3097h) this.f9962b[0];
                TextView textView = (TextView) this.f9962b[1];
                Bitmap bitmap = (Bitmap) this.f9962b[2];
                int intValue = ((Integer) this.f9962b[3]).intValue();
                int measuredWidth = textView.getMeasuredWidth();
                int i5 = (int) (measuredWidth * 0.42857142857142855d);
                textView.setHeight(i5);
                if (c3097h.f9983u == null) {
                    if (intValue == 2) {
                        c3097h.f9983u = C3078a.m9325a(bitmap, measuredWidth, i5, C3078a.m9322a(C3082e.f9867G.f9919u, 6.0f));
                    } else {
                        c3097h.f9983u = C3078a.m9325a(bitmap, measuredWidth, i5, C3078a.m9322a(C3082e.f9867G.f9919u, 0.0f));
                    }
                    if (c3097h.f9983u != null) {
                        textView.setText("");
                        textView.setBackgroundDrawable(c3097h.f9983u);
                        textView.getViewTreeObserver().removeOnPreDrawListener(this);
                        return true;
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f9963c <= 300) {
                    return true;
                }
                this.f9963c = currentTimeMillis;
                if (this.f9964d.length() > 9) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("loading");
                    this.f9964d = sb;
                } else {
                    this.f9964d.append(".");
                }
                textView.setText(this.f9964d.toString());
                return true;
            }
            if (i4 != 2) {
                if (i4 != 3) {
                    return false;
                }
                ViewGroup viewGroup = (ViewGroup) this.f9962b[0];
                if (viewGroup.getMeasuredHeight() > C3078a.m9322a((Context) this.f9962b[1], 158.0f)) {
                    ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                    layoutParams.height = C3078a.m9322a((Context) this.f9962b[1], 200.0f);
                    viewGroup.setLayoutParams(layoutParams);
                }
                return true;
            }
            if (((Integer) this.f9962b[2]).intValue() <= 0) {
                return true;
            }
            int intValue2 = ((Integer) this.f9962b[0]).intValue();
            TextView textView2 = (TextView) this.f9962b[1];
            int measuredWidth2 = textView2.getMeasuredWidth();
            int measuredHeight = textView2.getMeasuredHeight();
            int i6 = (int) (C3082e.f9867G.f9872D.widthPixels * C3082e.f9867G.f9872D.heightPixels * 0.4f);
            if (measuredWidth2 == 0 || measuredHeight == 0 || measuredWidth2 * measuredHeight > i6) {
                return true;
            }
            this.f9962b[2] = 0;
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            if (intValue2 == 2) {
                i2 = 8;
                i3 = 7;
            } else {
                i2 = 0;
                i3 = 0;
            }
            paint.setColor(-3355444);
            Bitmap createBitmap = Bitmap.createBitmap(measuredWidth2, measuredHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            float f2 = measuredWidth2;
            float f3 = measuredHeight;
            RectF rectF = new RectF(0.0f, 0.0f, f2, f3);
            float f4 = i2;
            canvas.drawRoundRect(rectF, f4, f4, paint);
            paint.setColor(-1);
            float f5 = i3;
            canvas.drawRoundRect(new RectF(2.0f, 2.0f, f2 - 2.0f, f3 - 2.0f), f5, f5, paint);
            paint.setColor(-3355444);
            Bitmap createBitmap2 = Bitmap.createBitmap(measuredWidth2, measuredHeight, Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap2).drawRoundRect(rectF, f4, f4, paint);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
            BitmapDrawable bitmapDrawable2 = new BitmapDrawable(createBitmap2);
            textView2.setBackgroundDrawable(bitmapDrawable);
            textView2.setOnTouchListener(new ViewOnTouchListenerC3080c(1, bitmapDrawable2, bitmapDrawable));
            return true;
        } catch (Exception e2) {
            if (!C3151an.m9919b(e2)) {
                e2.printStackTrace();
            }
            return false;
        }
    }
}
