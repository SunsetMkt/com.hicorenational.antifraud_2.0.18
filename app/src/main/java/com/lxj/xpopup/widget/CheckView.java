package com.lxj.xpopup.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.lxj.xpopup.p187f.C2819c;

/* loaded from: classes.dex */
public class CheckView extends View {

    /* renamed from: a */
    Paint f8893a;

    /* renamed from: b */
    int f8894b;

    /* renamed from: c */
    Path f8895c;

    public CheckView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f8894b == 0) {
            return;
        }
        this.f8895c.moveTo(getMeasuredWidth() / 4, getMeasuredHeight() / 2);
        this.f8895c.lineTo(getMeasuredWidth() / 2, (getMeasuredHeight() * 3) / 4);
        this.f8895c.lineTo(getMeasuredWidth(), getMeasuredHeight() / 4);
        canvas.drawPath(this.f8895c, this.f8893a);
    }

    public void setColor(int i2) {
        this.f8894b = i2;
        this.f8893a.setColor(i2);
        postInvalidate();
    }

    public CheckView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8894b = 0;
        this.f8895c = new Path();
        this.f8893a = new Paint(1);
        this.f8893a.setStrokeWidth(C2819c.m8449a(context, 2.0f));
        this.f8893a.setStyle(Paint.Style.STROKE);
    }
}
