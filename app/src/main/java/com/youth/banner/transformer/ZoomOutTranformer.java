package com.youth.banner.transformer;

import android.view.View;

/* loaded from: classes2.dex */
public class ZoomOutTranformer extends ABaseTransformer {
    @Override // com.youth.banner.transformer.ABaseTransformer
    protected void onTransform(View view, float f2) {
        float abs = Math.abs(f2) + 1.0f;
        view.setScaleX(abs);
        view.setScaleY(abs);
        view.setPivotX(view.getWidth() * 0.5f);
        view.setPivotY(view.getHeight() * 0.5f);
        view.setAlpha((f2 < -1.0f || f2 > 1.0f) ? 0.0f : 1.0f - (abs - 1.0f));
        if (f2 == -1.0f) {
            view.setTranslationX(view.getWidth() * (-1));
        }
    }
}
