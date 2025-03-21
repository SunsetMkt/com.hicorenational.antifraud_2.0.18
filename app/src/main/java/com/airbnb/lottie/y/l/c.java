package com.airbnb.lottie.y.l;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.j;
import com.airbnb.lottie.o;
import com.airbnb.lottie.w.c.p;

/* compiled from: ImageLayer.java */
/* loaded from: classes.dex */
public class c extends a {
    private final Paint D;
    private final Rect E;
    private final Rect F;

    @Nullable
    private com.airbnb.lottie.w.c.a<ColorFilter, ColorFilter> G;

    @Nullable
    private com.airbnb.lottie.w.c.a<Bitmap, Bitmap> H;

    c(j jVar, d dVar) {
        super(jVar, dVar);
        this.D = new com.airbnb.lottie.w.a(3);
        this.E = new Rect();
        this.F = new Rect();
    }

    @Nullable
    private Bitmap e() {
        Bitmap f2;
        com.airbnb.lottie.w.c.a<Bitmap, Bitmap> aVar = this.H;
        return (aVar == null || (f2 = aVar.f()) == null) ? this.n.a(this.o.k()) : f2;
    }

    @Override // com.airbnb.lottie.y.l.a, com.airbnb.lottie.w.b.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        if (e() != null) {
            rectF.set(0.0f, 0.0f, r3.getWidth() * com.airbnb.lottie.b0.h.a(), r3.getHeight() * com.airbnb.lottie.b0.h.a());
            this.f3965m.mapRect(rectF);
        }
    }

    @Override // com.airbnb.lottie.y.l.a
    public void b(@NonNull Canvas canvas, Matrix matrix, int i2) {
        Bitmap e2 = e();
        if (e2 == null || e2.isRecycled()) {
            return;
        }
        float a2 = com.airbnb.lottie.b0.h.a();
        this.D.setAlpha(i2);
        com.airbnb.lottie.w.c.a<ColorFilter, ColorFilter> aVar = this.G;
        if (aVar != null) {
            this.D.setColorFilter(aVar.f());
        }
        canvas.save();
        canvas.concat(matrix);
        this.E.set(0, 0, e2.getWidth(), e2.getHeight());
        this.F.set(0, 0, (int) (e2.getWidth() * a2), (int) (e2.getHeight() * a2));
        canvas.drawBitmap(e2, this.E, this.F, this.D);
        canvas.restore();
    }

    @Override // com.airbnb.lottie.y.l.a, com.airbnb.lottie.y.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.c0.j<T> jVar) {
        super.a((c) t, (com.airbnb.lottie.c0.j<c>) jVar);
        if (t == o.E) {
            if (jVar == null) {
                this.G = null;
                return;
            } else {
                this.G = new p(jVar);
                return;
            }
        }
        if (t == o.H) {
            if (jVar == null) {
                this.H = null;
            } else {
                this.H = new p(jVar);
            }
        }
    }
}
