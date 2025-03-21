package com.lxj.xpopup.core;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.NonNull;
import com.lxj.xpopup.p184c.AbstractC2770b;
import com.lxj.xpopup.p184c.C2772d;
import com.lxj.xpopup.p185d.EnumC2803c;
import com.lxj.xpopup.p185d.EnumC2804d;
import com.lxj.xpopup.p187f.C2819c;

/* loaded from: classes.dex */
public class HorizontalAttachPopupView extends AttachPopupView {
    public HorizontalAttachPopupView(@NonNull Context context) {
        super(context);
    }

    /* renamed from: w */
    private boolean m8402w() {
        return (this.f8606t || this.f8617a.f8704q == EnumC2804d.Left) && this.f8617a.f8704q != EnumC2804d.Right;
    }

    @Override // com.lxj.xpopup.core.AttachPopupView, com.lxj.xpopup.core.BasePopupView
    protected AbstractC2770b getPopupAnimator() {
        C2772d c2772d = m8402w() ? new C2772d(getPopupContentView(), EnumC2803c.ScrollAlphaFromRight) : new C2772d(getPopupContentView(), EnumC2803c.ScrollAlphaFromLeft);
        c2772d.f8579i = true;
        return c2772d;
    }

    @Override // com.lxj.xpopup.core.AttachPopupView, com.lxj.xpopup.core.BasePopupView
    /* renamed from: k */
    protected void mo8364k() {
        super.mo8364k();
        int i2 = this.f8617a.f8707t;
        if (i2 == 0) {
            i2 = C2819c.m8449a(getContext(), 0.0f);
        }
        this.f8602p = i2;
        int i3 = this.f8617a.f8706s;
        if (i3 == 0) {
            i3 = C2819c.m8449a(getContext(), 4.0f);
        }
        this.f8603q = i3;
        if (this.f8617a.f8692e.booleanValue() || Build.VERSION.SDK_INT >= 21 || getPopupBackground() != null) {
            return;
        }
        int i4 = this.f8603q;
        int i5 = this.f8607u;
        this.f8603q = i4 - i5;
        this.f8602p -= i5;
    }

    @Override // com.lxj.xpopup.core.AttachPopupView
    /* renamed from: u */
    protected void mo8365u() {
        float f2;
        float height;
        int measuredWidth = getPopupContentView().getMeasuredWidth();
        int measuredHeight = getPopupContentView().getMeasuredHeight();
        C2800a c2800a = this.f8617a;
        PointF pointF = c2800a.f8697j;
        if (pointF != null) {
            this.f8606t = pointF.x > ((float) (C2819c.m8472c(getContext()) / 2));
            float f3 = m8402w() ? (this.f8617a.f8697j.x - measuredWidth) - this.f8603q : this.f8603q + this.f8617a.f8697j.x;
            height = (this.f8617a.f8697j.y - (measuredHeight * 0.5f)) + this.f8602p;
            f2 = f3;
        } else {
            int[] iArr = new int[2];
            c2800a.m8427a().getLocationOnScreen(iArr);
            Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + this.f8617a.m8427a().getMeasuredWidth(), iArr[1] + this.f8617a.m8427a().getMeasuredHeight());
            this.f8606t = (rect.left + rect.right) / 2 > C2819c.m8472c(getContext()) / 2;
            f2 = m8402w() ? (rect.left - measuredWidth) - this.f8603q : rect.right + this.f8603q;
            height = rect.top + ((rect.height() - measuredHeight) / 2) + this.f8602p;
        }
        getPopupContentView().setTranslationX(f2);
        getPopupContentView().setTranslationY(height);
    }
}
