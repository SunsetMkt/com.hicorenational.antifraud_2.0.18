package com.umeng.message.proguard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.Button;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes2.dex */
public final class bd extends Button {
    private Paint a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f8023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f8024c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f8025d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f8026e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f8027f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f8028g;

    public bd(Context context) {
        super(context);
        setBackgroundColor(0);
        this.a = new Paint();
        this.f8028g = bb.a(1.0f);
        this.f8027f = bb.a(2.0f);
    }

    @Override // android.widget.TextView, android.view.View
    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f8023b = getWidth() / 2;
        this.f8024c = getHeight() / 2;
        this.f8025d = (Math.min(getHeight(), getWidth()) / 2) - this.f8028g;
        this.f8026e = this.f8025d / 1.4142f;
        this.a.setAntiAlias(true);
        this.a.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.a.setStyle(Paint.Style.FILL);
        canvas.drawCircle(this.f8023b, this.f8024c, this.f8025d, this.a);
        this.a.setColor(-1);
        this.a.setStrokeWidth(this.f8027f);
        this.a.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(this.f8023b, this.f8024c, this.f8025d, this.a);
        float f2 = this.f8023b;
        float f3 = this.f8026e;
        float f4 = this.f8024c;
        canvas.drawLine(f2 - f3, f4 - f3, f2 + f3, f4 + f3, this.a);
        float f5 = this.f8023b;
        float f6 = this.f8026e;
        float f7 = this.f8024c;
        canvas.drawLine(f5 + f6, f7 - f6, f5 - f6, f7 + f6, this.a);
    }
}
