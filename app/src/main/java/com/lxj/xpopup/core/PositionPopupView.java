package com.lxj.xpopup.core;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.lxj.xpopup.C2766R;
import com.lxj.xpopup.p184c.AbstractC2770b;
import com.lxj.xpopup.p184c.C2772d;
import com.lxj.xpopup.p185d.EnumC2803c;
import com.lxj.xpopup.p187f.C2819c;
import com.lxj.xpopup.widget.PartShadowContainer;

/* loaded from: classes.dex */
public class PositionPopupView extends BasePopupView {

    /* renamed from: p */
    PartShadowContainer f8686p;

    /* renamed from: com.lxj.xpopup.core.PositionPopupView$a */
    class RunnableC2799a implements Runnable {
        RunnableC2799a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PositionPopupView positionPopupView = PositionPopupView.this;
            if (positionPopupView.f8617a.f8709v) {
                PositionPopupView.this.f8686p.setTranslationX((C2819c.m8472c(positionPopupView.getContext()) - PositionPopupView.this.f8686p.getMeasuredWidth()) / 2.0f);
            } else {
                positionPopupView.f8686p.setTranslationX(r1.f8706s);
            }
            PositionPopupView.this.f8686p.setTranslationY(r0.f8617a.f8707t);
        }
    }

    public PositionPopupView(@NonNull Context context) {
        super(context);
        this.f8686p = (PartShadowContainer) findViewById(C2766R.id.attachPopupContainer);
        this.f8686p.addView(LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.f8686p, false));
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected AbstractC2770b getPopupAnimator() {
        return new C2772d(getPopupContentView(), EnumC2803c.ScaleAlphaFromCenter);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getPopupLayoutId() {
        return C2766R.layout._xpopup_attach_popup_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    /* renamed from: k */
    protected void mo8364k() {
        super.mo8364k();
        C2819c.m8459a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight(), new RunnableC2799a());
    }
}
