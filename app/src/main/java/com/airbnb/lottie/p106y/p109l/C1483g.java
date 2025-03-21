package com.airbnb.lottie.p106y.p109l;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.C1379j;
import com.airbnb.lottie.InterfaceC1384o;
import com.airbnb.lottie.p101c0.C1370j;
import com.airbnb.lottie.p102w.C1392a;
import com.airbnb.lottie.p102w.p104c.AbstractC1414a;
import com.airbnb.lottie.p102w.p104c.C1429p;

/* compiled from: SolidLayer.java */
/* renamed from: com.airbnb.lottie.y.l.g */
/* loaded from: classes.dex */
public class C1483g extends AbstractC1477a {

    /* renamed from: D */
    private final RectF f3799D;

    /* renamed from: E */
    private final Paint f3800E;

    /* renamed from: F */
    private final float[] f3801F;

    /* renamed from: G */
    private final Path f3802G;

    /* renamed from: H */
    private final C1480d f3803H;

    /* renamed from: I */
    @Nullable
    private AbstractC1414a<ColorFilter, ColorFilter> f3804I;

    C1483g(C1379j c1379j, C1480d c1480d) {
        super(c1379j, c1480d);
        this.f3799D = new RectF();
        this.f3800E = new C1392a();
        this.f3801F = new float[8];
        this.f3802G = new Path();
        this.f3803H = c1480d;
        this.f3800E.setAlpha(0);
        this.f3800E.setStyle(Paint.Style.FILL);
        this.f3800E.setColor(c1480d.m3371m());
    }

    @Override // com.airbnb.lottie.p106y.p109l.AbstractC1477a, com.airbnb.lottie.p102w.p103b.InterfaceC1397e
    /* renamed from: a */
    public void mo3095a(RectF rectF, Matrix matrix, boolean z) {
        super.mo3095a(rectF, matrix, z);
        this.f3799D.set(0.0f, 0.0f, this.f3803H.m3373o(), this.f3803H.m3372n());
        this.f3745m.mapRect(this.f3799D);
        rectF.set(this.f3799D);
    }

    @Override // com.airbnb.lottie.p106y.p109l.AbstractC1477a
    /* renamed from: b */
    public void mo3349b(Canvas canvas, Matrix matrix, int i2) {
        int alpha = Color.alpha(this.f3803H.m3371m());
        if (alpha == 0) {
            return;
        }
        int intValue = (int) ((i2 / 255.0f) * (((alpha / 255.0f) * (this.f3754v.m3173c() == null ? 100 : this.f3754v.m3173c().mo3143f().intValue())) / 100.0f) * 255.0f);
        this.f3800E.setAlpha(intValue);
        AbstractC1414a<ColorFilter, ColorFilter> abstractC1414a = this.f3804I;
        if (abstractC1414a != null) {
            this.f3800E.setColorFilter(abstractC1414a.mo3143f());
        }
        if (intValue > 0) {
            float[] fArr = this.f3801F;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.f3803H.m3373o();
            float[] fArr2 = this.f3801F;
            fArr2[3] = 0.0f;
            fArr2[4] = this.f3803H.m3373o();
            this.f3801F[5] = this.f3803H.m3372n();
            float[] fArr3 = this.f3801F;
            fArr3[6] = 0.0f;
            fArr3[7] = this.f3803H.m3372n();
            matrix.mapPoints(this.f3801F);
            this.f3802G.reset();
            Path path = this.f3802G;
            float[] fArr4 = this.f3801F;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.f3802G;
            float[] fArr5 = this.f3801F;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.f3802G;
            float[] fArr6 = this.f3801F;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.f3802G;
            float[] fArr7 = this.f3801F;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.f3802G;
            float[] fArr8 = this.f3801F;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.f3802G.close();
            canvas.drawPath(this.f3802G, this.f3800E);
        }
    }

    @Override // com.airbnb.lottie.p106y.p109l.AbstractC1477a, com.airbnb.lottie.p106y.InterfaceC1440f
    /* renamed from: a */
    public <T> void mo3097a(T t, @Nullable C1370j<T> c1370j) {
        super.mo3097a((C1483g) t, (C1370j<C1483g>) c1370j);
        if (t == InterfaceC1384o.f3326E) {
            if (c1370j == null) {
                this.f3804I = null;
            } else {
                this.f3804I = new C1429p(c1370j);
            }
        }
    }
}
