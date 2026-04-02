package com.lxj.xpopup.widget;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.lxj.xpopup.f.c;

/* JADX INFO: loaded from: classes2.dex */
public class LoadingView extends View {
    private Paint a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f5518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f5519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f5520d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArgbEvaluator f5521e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f5522f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f5523g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f5524h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float f5525i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f5526j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    float f5527k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    float f5528l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Runnable f5529m;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadingView loadingView = LoadingView.this;
            loadingView.f5526j++;
            loadingView.invalidate();
        }
    }

    public LoadingView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f5529m);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        for (int i2 = this.f5524h - 1; i2 >= 0; i2--) {
            int iAbs = Math.abs(this.f5526j + i2);
            this.a.setColor(((Integer) this.f5521e.evaluate((((iAbs % r2) + 1) * 1.0f) / this.f5524h, Integer.valueOf(this.f5522f), Integer.valueOf(this.f5523g))).intValue());
            float f2 = this.f5527k + this.f5519c;
            float f3 = (this.f5518b / 3.0f) + f2;
            float f4 = this.f5528l;
            canvas.drawLine(f2, f4, f3, f4, this.a);
            canvas.drawCircle(f2, this.f5528l, this.f5520d / 2.0f, this.a);
            canvas.drawCircle(f3, this.f5528l, this.f5520d / 2.0f, this.a);
            canvas.rotate(this.f5525i, this.f5527k, this.f5528l);
        }
        postDelayed(this.f5529m, 80L);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f5518b = getMeasuredWidth() / 2;
        this.f5519c = this.f5518b / 2.5f;
        this.f5527k = getMeasuredWidth() / 2;
        this.f5528l = getMeasuredHeight() / 2;
        this.f5520d *= (getMeasuredWidth() * 1.0f) / c.a(getContext(), 30.0f);
        this.a.setStrokeWidth(this.f5520d);
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f5520d = 2.0f;
        this.f5521e = new ArgbEvaluator();
        this.f5522f = Color.parseColor("#CCCCCC");
        this.f5523g = Color.parseColor("#333333");
        this.f5524h = 12;
        this.f5525i = 360.0f / this.f5524h;
        this.f5526j = 0;
        this.f5529m = new a();
        this.a = new Paint(1);
        this.f5520d = c.a(context, this.f5520d);
        this.a.setStrokeWidth(this.f5520d);
    }
}
