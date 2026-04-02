package com.scwang.smartrefresh.layout.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: ArrowDrawable.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5677b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5678c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Path f5679d = new Path();

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        if (this.f5677b != iWidth || this.f5678c != iHeight) {
            int i2 = (iWidth * 30) / 225;
            this.f5679d.reset();
            double d2 = i2;
            float fSin = (float) (Math.sin(0.7853981633974483d) * d2);
            float fSin2 = (float) (d2 / Math.sin(0.7853981633974483d));
            int i3 = iWidth / 2;
            float f2 = iHeight;
            this.f5679d.moveTo(i3, f2);
            float f3 = iHeight / 2;
            this.f5679d.lineTo(0.0f, f3);
            float f4 = f3 - fSin;
            this.f5679d.lineTo(fSin, f4);
            int i4 = i2 / 2;
            float f5 = i3 - i4;
            float f6 = (f2 - fSin2) - i4;
            this.f5679d.lineTo(f5, f6);
            this.f5679d.lineTo(f5, 0.0f);
            float f7 = i3 + i4;
            this.f5679d.lineTo(f7, 0.0f);
            this.f5679d.lineTo(f7, f6);
            float f8 = iWidth;
            this.f5679d.lineTo(f8 - fSin, f4);
            this.f5679d.lineTo(f8, f3);
            this.f5679d.close();
            this.f5677b = iWidth;
            this.f5678c = iHeight;
        }
        canvas.drawPath(this.f5679d, this.a);
    }
}
