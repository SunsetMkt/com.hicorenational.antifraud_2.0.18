package com.lxj.xpopup.core;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.NonNull;
import com.lxj.xpopup.c.b;
import com.lxj.xpopup.d.c;
import com.lxj.xpopup.d.d;

/* JADX INFO: loaded from: classes2.dex */
public class HorizontalAttachPopupView extends AttachPopupView {
    public HorizontalAttachPopupView(@NonNull Context context) {
        super(context);
    }

    private boolean w() {
        return (this.t || this.a.q == d.Left) && this.a.q != d.Right;
    }

    @Override // com.lxj.xpopup.core.AttachPopupView, com.lxj.xpopup.core.BasePopupView
    protected b getPopupAnimator() {
        com.lxj.xpopup.c.d dVar = w() ? new com.lxj.xpopup.c.d(getPopupContentView(), c.ScrollAlphaFromRight) : new com.lxj.xpopup.c.d(getPopupContentView(), c.ScrollAlphaFromLeft);
        dVar.f5408i = true;
        return dVar;
    }

    @Override // com.lxj.xpopup.core.AttachPopupView, com.lxj.xpopup.core.BasePopupView
    protected void k() {
        super.k();
        int iA = this.a.t;
        if (iA == 0) {
            iA = com.lxj.xpopup.f.c.a(getContext(), 0.0f);
        }
        this.p = iA;
        int iA2 = this.a.s;
        if (iA2 == 0) {
            iA2 = com.lxj.xpopup.f.c.a(getContext(), 4.0f);
        }
        this.q = iA2;
        if (this.a.f5444e.booleanValue() || Build.VERSION.SDK_INT >= 21 || getPopupBackground() != null) {
            return;
        }
        int i2 = this.q;
        int i3 = this.u;
        this.q = i2 - i3;
        this.p -= i3;
    }

    @Override // com.lxj.xpopup.core.AttachPopupView
    protected void u() {
        float f2;
        float fHeight;
        int measuredWidth = getPopupContentView().getMeasuredWidth();
        int measuredHeight = getPopupContentView().getMeasuredHeight();
        a aVar = this.a;
        PointF pointF = aVar.f5449j;
        if (pointF != null) {
            this.t = pointF.x > ((float) (com.lxj.xpopup.f.c.c(getContext()) / 2));
            float f3 = w() ? (this.a.f5449j.x - measuredWidth) - this.q : this.q + this.a.f5449j.x;
            fHeight = (this.a.f5449j.y - (measuredHeight * 0.5f)) + this.p;
            f2 = f3;
        } else {
            int[] iArr = new int[2];
            aVar.a().getLocationOnScreen(iArr);
            Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + this.a.a().getMeasuredWidth(), iArr[1] + this.a.a().getMeasuredHeight());
            this.t = (rect.left + rect.right) / 2 > com.lxj.xpopup.f.c.c(getContext()) / 2;
            f2 = w() ? (rect.left - measuredWidth) - this.q : rect.right + this.q;
            fHeight = rect.top + ((rect.height() - measuredHeight) / 2) + this.p;
        }
        getPopupContentView().setTranslationX(f2);
        getPopupContentView().setTranslationY(fHeight);
    }
}
