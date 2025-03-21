package com.airbnb.lottie.p106y.p109l;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.airbnb.lottie.C1379j;
import com.airbnb.lottie.p102w.p103b.C1396d;
import com.airbnb.lottie.p106y.C1439e;
import com.airbnb.lottie.p106y.p108k.C1472n;
import java.util.Collections;
import java.util.List;

/* compiled from: ShapeLayer.java */
/* renamed from: com.airbnb.lottie.y.l.f */
/* loaded from: classes.dex */
public class C1482f extends AbstractC1477a {

    /* renamed from: D */
    private final C1396d f3798D;

    C1482f(C1379j c1379j, C1480d c1480d) {
        super(c1379j, c1480d);
        this.f3798D = new C1396d(c1379j, this, new C1472n("__container", c1480d.m3370l(), false));
        this.f3798D.mo3098a(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.p106y.p109l.AbstractC1477a, com.airbnb.lottie.p102w.p103b.InterfaceC1397e
    /* renamed from: a */
    public void mo3095a(RectF rectF, Matrix matrix, boolean z) {
        super.mo3095a(rectF, matrix, z);
        this.f3798D.mo3095a(rectF, this.f3745m, z);
    }

    @Override // com.airbnb.lottie.p106y.p109l.AbstractC1477a
    /* renamed from: b */
    void mo3349b(@NonNull Canvas canvas, Matrix matrix, int i2) {
        this.f3798D.mo3094a(canvas, matrix, i2);
    }

    @Override // com.airbnb.lottie.p106y.p109l.AbstractC1477a
    /* renamed from: b */
    protected void mo3351b(C1439e c1439e, int i2, List<C1439e> list, C1439e c1439e2) {
        this.f3798D.mo3096a(c1439e, i2, list, c1439e2);
    }
}
