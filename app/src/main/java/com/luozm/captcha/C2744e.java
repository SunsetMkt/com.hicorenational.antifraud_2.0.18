package com.luozm.captcha;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import androidx.annotation.NonNull;
import java.util.Random;

/* compiled from: DefaultCaptchaStrategy.java */
/* renamed from: com.luozm.captcha.e */
/* loaded from: classes.dex */
public class C2744e extends AbstractC2743d {
    public C2744e(Context context) {
        super(context);
    }

    @Override // com.luozm.captcha.AbstractC2743d
    /* renamed from: a */
    public Path mo8194a(int i2) {
        int i3 = (int) (i2 / 4.0f);
        Path path = new Path();
        float f2 = i3;
        path.moveTo(0.0f, f2);
        path.rLineTo(f2, 0.0f);
        int i4 = -i3;
        float f3 = i4 / 2;
        path.rLineTo(0.0f, f3);
        path.rLineTo(f2, 0.0f);
        float f4 = i3 / 2;
        path.rLineTo(0.0f, f4);
        path.rLineTo(f2, 0.0f);
        path.rLineTo(0.0f, f2);
        path.rLineTo(f4, 0.0f);
        path.rLineTo(0.0f, f2);
        path.rLineTo(f3, 0.0f);
        path.rLineTo(0.0f, f2);
        float f5 = i4;
        path.rLineTo(f5, 0.0f);
        path.rLineTo(0.0f, f3);
        path.rLineTo(f5, 0.0f);
        path.rLineTo(0.0f, f4);
        path.rLineTo(f5, 0.0f);
        path.rLineTo(0.0f, f5);
        path.rLineTo(f4, 0.0f);
        path.rLineTo(0.0f, f5);
        path.rLineTo(f3, 0.0f);
        path.rLineTo(0.0f, f5);
        path.close();
        return path;
    }

    @Override // com.luozm.captcha.AbstractC2743d
    @NonNull
    /* renamed from: b */
    public C2745f mo8198b(int i2, int i3, int i4) {
        Random random = new Random();
        int nextInt = random.nextInt((i2 - i4) + 1);
        int nextInt2 = random.nextInt((i3 - i4) + 1);
        if (nextInt2 < 0) {
            nextInt2 = 0;
        }
        return new C2745f(nextInt, nextInt2);
    }

    @Override // com.luozm.captcha.AbstractC2743d
    /* renamed from: b */
    public Paint mo8197b() {
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#000000"));
        paint.setAlpha(165);
        return paint;
    }

    @Override // com.luozm.captcha.AbstractC2743d
    @NonNull
    /* renamed from: a */
    public C2745f mo8195a(int i2, int i3, int i4) {
        if (C2742c.m8192a(m8199c(), 25.0f) + i2 >= m8199c().getResources().getDisplayMetrics().widthPixels) {
            i2 -= i4;
        }
        Random random = new Random();
        int nextInt = random.nextInt((i2 - i4) + 1);
        if (nextInt < i4) {
            nextInt = i4;
        }
        int nextInt2 = random.nextInt((i3 - i4) + 1);
        if (nextInt2 < 0) {
            nextInt2 = 0;
        }
        return new C2745f(nextInt, nextInt2);
    }

    @Override // com.luozm.captcha.AbstractC2743d
    /* renamed from: a */
    public Paint mo8193a() {
        return new Paint();
    }

    @Override // com.luozm.captcha.AbstractC2743d
    /* renamed from: a */
    public void mo8196a(Canvas canvas, Path path) {
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#ffffff"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10.0f);
        paint.setMaskFilter(new EmbossMaskFilter(new float[]{1.0f, 1.0f, 1.0f}, 0.4f, 2.0f, 1.5f));
        canvas.drawPath(new Path(path), paint);
    }
}
