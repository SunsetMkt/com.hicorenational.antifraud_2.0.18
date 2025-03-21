package p388ui.view;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes2.dex */
public class ZoomOutPageTransformer implements ViewPager.PageTransformer {

    /* renamed from: a */
    private static float f24770a = 0.85f;

    /* renamed from: b */
    private static float f24771b = 0.5f;

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view, float f2) {
        view.getWidth();
        view.getHeight();
        if (f2 < -1.0f) {
            view.setAlpha(0.0f);
            view.setTranslationX(0.0f);
        } else if (f2 > 1.0f) {
            view.setAlpha(0.0f);
            view.setTranslationX(0.0f);
        } else {
            float max = Math.max(f24770a, 1.0f - Math.abs(f2));
            float f3 = f24771b;
            float f4 = f24770a;
            view.setAlpha(f3 + (((max - f4) / (1.0f - f4)) * (1.0f - f3)));
        }
    }
}
