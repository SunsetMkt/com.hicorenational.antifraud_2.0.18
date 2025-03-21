package com.lxj.xpopup.photoview;

import android.widget.ImageView;
import androidx.core.view.MotionEventCompat;

/* compiled from: Util.java */
/* renamed from: com.lxj.xpopup.photoview.l */
/* loaded from: classes.dex */
class C2840l {

    /* compiled from: Util.java */
    /* renamed from: com.lxj.xpopup.photoview.l$a */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f8887a = new int[ImageView.ScaleType.values().length];

        static {
            try {
                f8887a[ImageView.ScaleType.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    C2840l() {
    }

    /* renamed from: a */
    static int m8582a(int i2) {
        return (i2 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
    }

    /* renamed from: a */
    static void m8583a(float f2, float f3, float f4) {
        if (f2 >= f3) {
            throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
        }
        if (f3 >= f4) {
            throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
        }
    }

    /* renamed from: a */
    static boolean m8585a(ImageView imageView) {
        return imageView.getDrawable() != null;
    }

    /* renamed from: a */
    static boolean m8584a(ImageView.ScaleType scaleType) {
        return (scaleType == null || a.f8887a[scaleType.ordinal()] == 1) ? false : true;
    }
}
