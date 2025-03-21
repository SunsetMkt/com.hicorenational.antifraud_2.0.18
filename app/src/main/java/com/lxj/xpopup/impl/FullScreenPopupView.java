package com.lxj.xpopup.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.lxj.xpopup.C2768b;
import com.lxj.xpopup.core.CenterPopupView;
import com.lxj.xpopup.p184c.AbstractC2770b;
import com.lxj.xpopup.p184c.C2775g;
import com.lxj.xpopup.p185d.EnumC2803c;
import com.lxj.xpopup.p187f.C2819c;

/* loaded from: classes.dex */
public class FullScreenPopupView extends CenterPopupView {

    /* renamed from: s */
    Paint f8794s;

    /* renamed from: t */
    Rect f8795t;

    public FullScreenPopupView(@NonNull Context context) {
        super(context);
        this.f8794s = new Paint();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f8617a.f8705r.booleanValue()) {
            this.f8794s.setColor(C2768b.f8564c);
            this.f8795t = new Rect(0, 0, C2819c.m8472c(getContext()), C2819c.m8471c());
            canvas.drawRect(this.f8795t, this.f8794s);
        }
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getMaxWidth() {
        return 0;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected AbstractC2770b getPopupAnimator() {
        return new C2775g(getPopupContentView(), EnumC2803c.TranslateFromBottom);
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    /* renamed from: k */
    protected void mo8364k() {
        super.mo8364k();
        int rotation = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation();
        View popupContentView = getPopupContentView();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) popupContentView.getLayoutParams();
        layoutParams.gravity = 48;
        popupContentView.setLayoutParams(layoutParams);
        int m8465b = C2819c.m8474d(getContext()) ? C2819c.m8465b() : 0;
        if (rotation == 0) {
            popupContentView.setPadding(popupContentView.getPaddingLeft(), popupContentView.getPaddingTop(), popupContentView.getPaddingRight(), m8465b);
        } else if (rotation == 1 || rotation == 3) {
            popupContentView.setPadding(popupContentView.getPaddingLeft(), popupContentView.getPaddingTop(), popupContentView.getPaddingRight(), 0);
        }
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f8794s = null;
    }
}
