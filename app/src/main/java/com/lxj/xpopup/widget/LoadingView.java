package com.lxj.xpopup.widget;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.lxj.xpopup.p187f.C2819c;

/* loaded from: classes.dex */
public class LoadingView extends View {

    /* renamed from: a */
    private Paint f8896a;

    /* renamed from: b */
    private float f8897b;

    /* renamed from: c */
    private float f8898c;

    /* renamed from: d */
    private float f8899d;

    /* renamed from: e */
    private ArgbEvaluator f8900e;

    /* renamed from: f */
    private int f8901f;

    /* renamed from: g */
    private int f8902g;

    /* renamed from: h */
    int f8903h;

    /* renamed from: i */
    float f8904i;

    /* renamed from: j */
    int f8905j;

    /* renamed from: k */
    float f8906k;

    /* renamed from: l */
    float f8907l;

    /* renamed from: m */
    private Runnable f8908m;

    /* renamed from: com.lxj.xpopup.widget.LoadingView$a */
    class RunnableC2841a implements Runnable {
        RunnableC2841a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadingView loadingView = LoadingView.this;
            loadingView.f8905j++;
            loadingView.invalidate();
        }
    }

    public LoadingView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f8908m);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        for (int i2 = this.f8903h - 1; i2 >= 0; i2--) {
            int abs = Math.abs(this.f8905j + i2);
            this.f8896a.setColor(((Integer) this.f8900e.evaluate((((abs % r2) + 1) * 1.0f) / this.f8903h, Integer.valueOf(this.f8901f), Integer.valueOf(this.f8902g))).intValue());
            float f2 = this.f8906k + this.f8898c;
            float f3 = (this.f8897b / 3.0f) + f2;
            float f4 = this.f8907l;
            canvas.drawLine(f2, f4, f3, f4, this.f8896a);
            canvas.drawCircle(f2, this.f8907l, this.f8899d / 2.0f, this.f8896a);
            canvas.drawCircle(f3, this.f8907l, this.f8899d / 2.0f, this.f8896a);
            canvas.rotate(this.f8904i, this.f8906k, this.f8907l);
        }
        postDelayed(this.f8908m, 80L);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f8897b = getMeasuredWidth() / 2;
        this.f8898c = this.f8897b / 2.5f;
        this.f8906k = getMeasuredWidth() / 2;
        this.f8907l = getMeasuredHeight() / 2;
        this.f8899d *= (getMeasuredWidth() * 1.0f) / C2819c.m8449a(getContext(), 30.0f);
        this.f8896a.setStrokeWidth(this.f8899d);
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8899d = 2.0f;
        this.f8900e = new ArgbEvaluator();
        this.f8901f = Color.parseColor("#CCCCCC");
        this.f8902g = Color.parseColor("#333333");
        this.f8903h = 12;
        this.f8904i = 360.0f / this.f8903h;
        this.f8905j = 0;
        this.f8908m = new RunnableC2841a();
        this.f8896a = new Paint(1);
        this.f8899d = C2819c.m8449a(context, this.f8899d);
        this.f8896a.setStrokeWidth(this.f8899d);
    }
}
