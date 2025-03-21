package com.lxj.xpopup.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
public class BlankView extends View {

    /* renamed from: a */
    private Paint f8888a;

    /* renamed from: b */
    private RectF f8889b;

    /* renamed from: c */
    public int f8890c;

    /* renamed from: d */
    public int f8891d;

    /* renamed from: e */
    public int f8892e;

    public BlankView(Context context) {
        super(context);
        this.f8888a = new Paint();
        this.f8889b = null;
        this.f8890c = 0;
        this.f8891d = -1;
        this.f8892e = Color.parseColor("#DDDDDD");
    }

    /* renamed from: a */
    private void m8586a() {
        this.f8888a.setAntiAlias(true);
        this.f8888a.setStrokeWidth(1.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f8888a.setColor(this.f8891d);
        RectF rectF = this.f8889b;
        int i2 = this.f8890c;
        canvas.drawRoundRect(rectF, i2, i2, this.f8888a);
        this.f8888a.setStyle(Paint.Style.STROKE);
        this.f8888a.setColor(this.f8892e);
        RectF rectF2 = this.f8889b;
        int i3 = this.f8890c;
        canvas.drawRoundRect(rectF2, i3, i3, this.f8888a);
        this.f8888a.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f8889b = new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }

    public BlankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8888a = new Paint();
        this.f8889b = null;
        this.f8890c = 0;
        this.f8891d = -1;
        this.f8892e = Color.parseColor("#DDDDDD");
        m8586a();
    }

    public BlankView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8888a = new Paint();
        this.f8889b = null;
        this.f8890c = 0;
        this.f8891d = -1;
        this.f8892e = Color.parseColor("#DDDDDD");
        m8586a();
    }
}
