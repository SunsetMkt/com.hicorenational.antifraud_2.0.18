package com.luozm.captcha;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;

/* loaded from: classes.dex */
class TextSeekbar extends AppCompatSeekBar {

    /* renamed from: a */
    private Paint f8466a;

    public TextSeekbar(Context context) {
        super(context);
    }

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint.FontMetrics fontMetrics = this.f8466a.getFontMetrics();
        float f2 = fontMetrics.top;
        float f3 = fontMetrics.bottom;
        int height = getHeight() / 2;
    }

    public TextSeekbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C2739R.style.seekbarSytle);
    }

    public TextSeekbar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8466a = new Paint();
        this.f8466a.setTextAlign(Paint.Align.CENTER);
        this.f8466a.setTextSize(C2742c.m8192a(context, 14.0f));
        this.f8466a.setAntiAlias(true);
        this.f8466a.setColor(Color.parseColor("#545454"));
    }
}
