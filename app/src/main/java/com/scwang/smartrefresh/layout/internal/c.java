package com.scwang.smartrefresh.layout.internal;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: ProgressDrawable.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends b implements Animatable, ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f5680b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f5681c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected int f5682d = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected Path f5684f = new Path();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected ValueAnimator f5683e = ValueAnimator.ofInt(30, 3600);

    public c() {
        this.f5683e.setDuration(com.heytap.mcssdk.constant.a.q);
        this.f5683e.setInterpolator(new LinearInterpolator());
        this.f5683e.setRepeatCount(-1);
        this.f5683e.setRepeatMode(1);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        int iMax = Math.max(1, iWidth / 20);
        if (this.f5680b != iWidth || this.f5681c != iHeight) {
            this.f5684f.reset();
            float f2 = iWidth - iMax;
            float f3 = iHeight / 2;
            float f4 = iMax;
            this.f5684f.addCircle(f2, f3, f4, Path.Direction.CW);
            float f5 = iWidth - (iMax * 5);
            this.f5684f.addRect(f5, r4 - iMax, f2, r4 + iMax, Path.Direction.CW);
            this.f5684f.addCircle(f5, f3, f4, Path.Direction.CW);
            this.f5680b = iWidth;
            this.f5681c = iHeight;
        }
        canvas.save();
        float f6 = iWidth / 2;
        float f7 = iHeight / 2;
        canvas.rotate(this.f5682d, f6, f7);
        for (int i2 = 0; i2 < 12; i2++) {
            this.a.setAlpha((i2 + 5) * 17);
            canvas.rotate(30.0f, f6, f7);
            canvas.drawPath(this.f5684f, this.a);
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f5683e.isRunning();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f5682d = (((Integer) valueAnimator.getAnimatedValue()).intValue() / 30) * 30;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.f5683e.isRunning()) {
            return;
        }
        this.f5683e.addUpdateListener(this);
        this.f5683e.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.f5683e.isRunning()) {
            this.f5683e.removeAllListeners();
            this.f5683e.removeAllUpdateListeners();
            this.f5683e.cancel();
        }
    }
}
