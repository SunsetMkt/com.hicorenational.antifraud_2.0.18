package com.lxj.xpopup.photoview;

import android.widget.ImageView;
import androidx.core.view.MotionEventCompat;

/* JADX INFO: compiled from: Util.java */
/* JADX INFO: loaded from: classes2.dex */
class l {

    /* JADX INFO: compiled from: Util.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a = new int[ImageView.ScaleType.values().length];

        static {
            try {
                a[ImageView.ScaleType.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    l() {
    }

    static int a(int i2) {
        return (i2 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
    }

    static void a(float f2, float f3, float f4) {
        if (f2 >= f3) {
            throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
        }
        if (f3 >= f4) {
            throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
        }
    }

    static boolean a(ImageView imageView) {
        return imageView.getDrawable() != null;
    }

    static boolean a(ImageView.ScaleType scaleType) {
        return (scaleType == null || a.a[scaleType.ordinal()] == 1) ? false : true;
    }
}
