package com.youth.banner.transformer;

import android.view.View;

/* loaded from: classes2.dex */
public class ZoomOutSlideTransformer extends ABaseTransformer {
    private static final float MIN_ALPHA = 0.5f;
    private static final float MIN_SCALE = 0.85f;

    @Override // com.youth.banner.transformer.ABaseTransformer
    protected void onTransform(View view, float f2) {
        if (f2 >= -1.0f || f2 <= 1.0f) {
            float height = view.getHeight();
            float width = view.getWidth();
            float max = Math.max(MIN_SCALE, 1.0f - Math.abs(f2));
            float f3 = 1.0f - max;
            float f4 = (height * f3) / 2.0f;
            float f5 = (f3 * width) / 2.0f;
            view.setPivotY(height * MIN_ALPHA);
            view.setPivotX(width * MIN_ALPHA);
            if (f2 < 0.0f) {
                view.setTranslationX(f5 - (f4 / 2.0f));
            } else {
                view.setTranslationX((-f5) + (f4 / 2.0f));
            }
            view.setScaleX(max);
            view.setScaleY(max);
            view.setAlpha((((max - MIN_SCALE) / 0.14999998f) * MIN_ALPHA) + MIN_ALPHA);
        }
    }
}
