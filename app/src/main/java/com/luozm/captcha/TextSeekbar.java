package com.luozm.captcha;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;

/* JADX INFO: loaded from: classes2.dex */
class TextSeekbar extends AppCompatSeekBar {
    private Paint a;

    public TextSeekbar(Context context) {
        super(context);
    }

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint.FontMetrics fontMetrics = this.a.getFontMetrics();
        float f2 = fontMetrics.top;
        float f3 = fontMetrics.bottom;
        int height = getHeight() / 2;
    }

    public TextSeekbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.seekbarSytle);
    }

    public TextSeekbar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new Paint();
        this.a.setTextAlign(Paint.Align.CENTER);
        this.a.setTextSize(c.a(context, 14.0f));
        this.a.setAntiAlias(true);
        this.a.setColor(Color.parseColor("#545454"));
    }
}
