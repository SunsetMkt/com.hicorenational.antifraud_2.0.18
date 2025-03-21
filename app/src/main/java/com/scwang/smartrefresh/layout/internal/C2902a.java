package com.scwang.smartrefresh.layout.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import androidx.annotation.NonNull;

/* compiled from: ArrowDrawable.java */
/* renamed from: com.scwang.smartrefresh.layout.internal.a */
/* loaded from: classes.dex */
public class C2902a extends AbstractC2903b {

    /* renamed from: b */
    private int f9251b = 0;

    /* renamed from: c */
    private int f9252c = 0;

    /* renamed from: d */
    private Path f9253d = new Path();

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        if (this.f9251b != width || this.f9252c != height) {
            int i2 = (width * 30) / 225;
            this.f9253d.reset();
            double d2 = i2;
            float sin = (float) (Math.sin(0.7853981633974483d) * d2);
            float sin2 = (float) (d2 / Math.sin(0.7853981633974483d));
            int i3 = width / 2;
            float f2 = height;
            this.f9253d.moveTo(i3, f2);
            float f3 = height / 2;
            this.f9253d.lineTo(0.0f, f3);
            float f4 = f3 - sin;
            this.f9253d.lineTo(sin, f4);
            int i4 = i2 / 2;
            float f5 = i3 - i4;
            float f6 = (f2 - sin2) - i4;
            this.f9253d.lineTo(f5, f6);
            this.f9253d.lineTo(f5, 0.0f);
            float f7 = i3 + i4;
            this.f9253d.lineTo(f7, 0.0f);
            this.f9253d.lineTo(f7, f6);
            float f8 = width;
            this.f9253d.lineTo(f8 - sin, f4);
            this.f9253d.lineTo(f8, f3);
            this.f9253d.close();
            this.f9251b = width;
            this.f9252c = height;
        }
        canvas.drawPath(this.f9253d, this.f9254a);
    }
}
