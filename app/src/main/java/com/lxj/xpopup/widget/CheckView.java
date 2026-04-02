package com.lxj.xpopup.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.lxj.xpopup.f.c;

/* JADX INFO: loaded from: classes2.dex */
public class CheckView extends View {
    Paint a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f5516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Path f5517c;

    public CheckView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f5516b == 0) {
            return;
        }
        this.f5517c.moveTo(getMeasuredWidth() / 4, getMeasuredHeight() / 2);
        this.f5517c.lineTo(getMeasuredWidth() / 2, (getMeasuredHeight() * 3) / 4);
        this.f5517c.lineTo(getMeasuredWidth(), getMeasuredHeight() / 4);
        canvas.drawPath(this.f5517c, this.a);
    }

    public void setColor(int i2) {
        this.f5516b = i2;
        this.a.setColor(i2);
        postInvalidate();
    }

    public CheckView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f5516b = 0;
        this.f5517c = new Path();
        this.a = new Paint(1);
        this.a.setStrokeWidth(c.a(context, 2.0f));
        this.a.setStyle(Paint.Style.STROKE);
    }
}
