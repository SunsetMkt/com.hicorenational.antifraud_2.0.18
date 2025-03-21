package com.umeng.message.proguard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.Button;
import androidx.core.view.ViewCompat;

/* renamed from: com.umeng.message.proguard.bd */
/* loaded from: classes2.dex */
public final class C3582bd extends Button {

    /* renamed from: a */
    private Paint f13260a;

    /* renamed from: b */
    private float f13261b;

    /* renamed from: c */
    private float f13262c;

    /* renamed from: d */
    private float f13263d;

    /* renamed from: e */
    private float f13264e;

    /* renamed from: f */
    private float f13265f;

    /* renamed from: g */
    private int f13266g;

    public C3582bd(Context context) {
        super(context);
        setBackgroundColor(0);
        this.f13260a = new Paint();
        this.f13266g = C3580bb.m12337a(1.0f);
        this.f13265f = C3580bb.m12337a(2.0f);
    }

    @Override // android.widget.TextView, android.view.View
    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f13261b = getWidth() / 2;
        this.f13262c = getHeight() / 2;
        this.f13263d = (Math.min(getHeight(), getWidth()) / 2) - this.f13266g;
        this.f13264e = this.f13263d / 1.4142f;
        this.f13260a.setAntiAlias(true);
        this.f13260a.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f13260a.setStyle(Paint.Style.FILL);
        canvas.drawCircle(this.f13261b, this.f13262c, this.f13263d, this.f13260a);
        this.f13260a.setColor(-1);
        this.f13260a.setStrokeWidth(this.f13265f);
        this.f13260a.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(this.f13261b, this.f13262c, this.f13263d, this.f13260a);
        float f2 = this.f13261b;
        float f3 = this.f13264e;
        float f4 = this.f13262c;
        canvas.drawLine(f2 - f3, f4 - f3, f2 + f3, f4 + f3, this.f13260a);
        float f5 = this.f13261b;
        float f6 = this.f13264e;
        float f7 = this.f13262c;
        canvas.drawLine(f5 + f6, f7 - f6, f5 - f6, f7 + f6, this.f13260a);
    }
}
