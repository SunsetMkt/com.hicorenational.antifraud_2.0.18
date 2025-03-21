package com.scwang.smartrefresh.layout.internal;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import com.heytap.mcssdk.constant.C2084a;

/* compiled from: ProgressDrawable.java */
/* renamed from: com.scwang.smartrefresh.layout.internal.c */
/* loaded from: classes.dex */
public class C2904c extends AbstractC2903b implements Animatable, ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b */
    protected int f9255b = 0;

    /* renamed from: c */
    protected int f9256c = 0;

    /* renamed from: d */
    protected int f9257d = 0;

    /* renamed from: f */
    protected Path f9259f = new Path();

    /* renamed from: e */
    protected ValueAnimator f9258e = ValueAnimator.ofInt(30, 3600);

    public C2904c() {
        this.f9258e.setDuration(C2084a.f6135q);
        this.f9258e.setInterpolator(new LinearInterpolator());
        this.f9258e.setRepeatCount(-1);
        this.f9258e.setRepeatMode(1);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int max = Math.max(1, width / 20);
        if (this.f9255b != width || this.f9256c != height) {
            this.f9259f.reset();
            float f2 = width - max;
            float f3 = height / 2;
            float f4 = max;
            this.f9259f.addCircle(f2, f3, f4, Path.Direction.CW);
            float f5 = width - (max * 5);
            this.f9259f.addRect(f5, r4 - max, f2, r4 + max, Path.Direction.CW);
            this.f9259f.addCircle(f5, f3, f4, Path.Direction.CW);
            this.f9255b = width;
            this.f9256c = height;
        }
        canvas.save();
        float f6 = width / 2;
        float f7 = height / 2;
        canvas.rotate(this.f9257d, f6, f7);
        for (int i2 = 0; i2 < 12; i2++) {
            this.f9254a.setAlpha((i2 + 5) * 17);
            canvas.rotate(30.0f, f6, f7);
            canvas.drawPath(this.f9259f, this.f9254a);
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f9258e.isRunning();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f9257d = (((Integer) valueAnimator.getAnimatedValue()).intValue() / 30) * 30;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.f9258e.isRunning()) {
            return;
        }
        this.f9258e.addUpdateListener(this);
        this.f9258e.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.f9258e.isRunning()) {
            this.f9258e.removeAllListeners();
            this.f9258e.removeAllUpdateListeners();
            this.f9258e.cancel();
        }
    }
}
