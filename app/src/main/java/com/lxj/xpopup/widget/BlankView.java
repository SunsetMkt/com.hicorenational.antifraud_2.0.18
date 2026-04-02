package com.lxj.xpopup.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class BlankView extends View {
    private Paint a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RectF f5512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5514d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5515e;

    public BlankView(Context context) {
        super(context);
        this.a = new Paint();
        this.f5512b = null;
        this.f5513c = 0;
        this.f5514d = -1;
        this.f5515e = Color.parseColor("#DDDDDD");
    }

    private void a() {
        this.a.setAntiAlias(true);
        this.a.setStrokeWidth(1.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.a.setColor(this.f5514d);
        RectF rectF = this.f5512b;
        int i2 = this.f5513c;
        canvas.drawRoundRect(rectF, i2, i2, this.a);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setColor(this.f5515e);
        RectF rectF2 = this.f5512b;
        int i3 = this.f5513c;
        canvas.drawRoundRect(rectF2, i3, i3, this.a);
        this.a.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f5512b = new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }

    public BlankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Paint();
        this.f5512b = null;
        this.f5513c = 0;
        this.f5514d = -1;
        this.f5515e = Color.parseColor("#DDDDDD");
        a();
    }

    public BlankView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new Paint();
        this.f5512b = null;
        this.f5513c = 0;
        this.f5514d = -1;
        this.f5515e = Color.parseColor("#DDDDDD");
        a();
    }
}
