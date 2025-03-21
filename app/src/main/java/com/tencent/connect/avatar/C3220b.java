package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import cn.cloudwalk.libproject.Contants;

/* compiled from: ProGuard */
/* renamed from: com.tencent.connect.avatar.b */
/* loaded from: classes2.dex */
public class C3220b extends View {

    /* renamed from: a */
    private Rect f10983a;

    /* renamed from: b */
    private Paint f10984b;

    public C3220b(Context context) {
        super(context);
        m10294b();
    }

    /* renamed from: b */
    private void m10294b() {
        this.f10984b = new Paint();
    }

    /* renamed from: a */
    public Rect m10295a() {
        if (this.f10983a == null) {
            this.f10983a = new Rect();
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int min = Math.min(Math.min((measuredHeight - 60) - 80, measuredWidth), Contants.PREVIEW_W);
            int i2 = (measuredWidth - min) / 2;
            int i3 = (measuredHeight - min) / 2;
            this.f10983a.set(i2, i3, i2 + min, min + i3);
        }
        return this.f10983a;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect m10295a = m10295a();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f10984b.setStyle(Paint.Style.FILL);
        this.f10984b.setColor(Color.argb(100, 0, 0, 0));
        float f2 = measuredWidth;
        canvas.drawRect(0.0f, 0.0f, f2, m10295a.top, this.f10984b);
        canvas.drawRect(0.0f, m10295a.bottom, f2, measuredHeight, this.f10984b);
        canvas.drawRect(0.0f, m10295a.top, m10295a.left, m10295a.bottom, this.f10984b);
        canvas.drawRect(m10295a.right, m10295a.top, f2, m10295a.bottom, this.f10984b);
        canvas.drawColor(Color.argb(100, 0, 0, 0));
        this.f10984b.setStyle(Paint.Style.STROKE);
        this.f10984b.setColor(-1);
        canvas.drawRect(m10295a.left, m10295a.top, m10295a.right - 1, m10295a.bottom, this.f10984b);
    }
}
