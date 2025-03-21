package com.airbnb.lottie.p106y.p109l;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.C1379j;
import com.airbnb.lottie.InterfaceC1384o;
import com.airbnb.lottie.p100b0.C1358h;
import com.airbnb.lottie.p101c0.C1370j;
import com.airbnb.lottie.p102w.C1392a;
import com.airbnb.lottie.p102w.p104c.AbstractC1414a;
import com.airbnb.lottie.p102w.p104c.C1429p;

/* compiled from: ImageLayer.java */
/* renamed from: com.airbnb.lottie.y.l.c */
/* loaded from: classes.dex */
public class C1479c extends AbstractC1477a {

    /* renamed from: D */
    private final Paint f3769D;

    /* renamed from: E */
    private final Rect f3770E;

    /* renamed from: F */
    private final Rect f3771F;

    /* renamed from: G */
    @Nullable
    private AbstractC1414a<ColorFilter, ColorFilter> f3772G;

    /* renamed from: H */
    @Nullable
    private AbstractC1414a<Bitmap, Bitmap> f3773H;

    C1479c(C1379j c1379j, C1480d c1480d) {
        super(c1379j, c1480d);
        this.f3769D = new C1392a(3);
        this.f3770E = new Rect();
        this.f3771F = new Rect();
    }

    @Nullable
    /* renamed from: e */
    private Bitmap m3357e() {
        Bitmap mo3143f;
        AbstractC1414a<Bitmap, Bitmap> abstractC1414a = this.f3773H;
        return (abstractC1414a == null || (mo3143f = abstractC1414a.mo3143f()) == null) ? this.f3746n.m2982a(this.f3747o.m3369k()) : mo3143f;
    }

    @Override // com.airbnb.lottie.p106y.p109l.AbstractC1477a, com.airbnb.lottie.p102w.p103b.InterfaceC1397e
    /* renamed from: a */
    public void mo3095a(RectF rectF, Matrix matrix, boolean z) {
        super.mo3095a(rectF, matrix, z);
        if (m3357e() != null) {
            rectF.set(0.0f, 0.0f, r3.getWidth() * C1358h.m2832a(), r3.getHeight() * C1358h.m2832a());
            this.f3745m.mapRect(rectF);
        }
    }

    @Override // com.airbnb.lottie.p106y.p109l.AbstractC1477a
    /* renamed from: b */
    public void mo3349b(@NonNull Canvas canvas, Matrix matrix, int i2) {
        Bitmap m3357e = m3357e();
        if (m3357e == null || m3357e.isRecycled()) {
            return;
        }
        float m2832a = C1358h.m2832a();
        this.f3769D.setAlpha(i2);
        AbstractC1414a<ColorFilter, ColorFilter> abstractC1414a = this.f3772G;
        if (abstractC1414a != null) {
            this.f3769D.setColorFilter(abstractC1414a.mo3143f());
        }
        canvas.save();
        canvas.concat(matrix);
        this.f3770E.set(0, 0, m3357e.getWidth(), m3357e.getHeight());
        this.f3771F.set(0, 0, (int) (m3357e.getWidth() * m2832a), (int) (m3357e.getHeight() * m2832a));
        canvas.drawBitmap(m3357e, this.f3770E, this.f3771F, this.f3769D);
        canvas.restore();
    }

    @Override // com.airbnb.lottie.p106y.p109l.AbstractC1477a, com.airbnb.lottie.p106y.InterfaceC1440f
    /* renamed from: a */
    public <T> void mo3097a(T t, @Nullable C1370j<T> c1370j) {
        super.mo3097a((C1479c) t, (C1370j<C1479c>) c1370j);
        if (t == InterfaceC1384o.f3326E) {
            if (c1370j == null) {
                this.f3772G = null;
                return;
            } else {
                this.f3772G = new C1429p(c1370j);
                return;
            }
        }
        if (t == InterfaceC1384o.f3329H) {
            if (c1370j == null) {
                this.f3773H = null;
            } else {
                this.f3773H = new C1429p(c1370j);
            }
        }
    }
}
