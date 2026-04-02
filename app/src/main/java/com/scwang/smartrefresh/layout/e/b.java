package com.scwang.smartrefresh.layout.e;

import android.content.res.Resources;

/* JADX INFO: compiled from: DensityUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    public float a = Resources.getSystem().getDisplayMetrics().density;

    public static int b(float f2) {
        return (int) ((f2 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public int a(float f2) {
        return (int) ((f2 * this.a) + 0.5f);
    }

    public static float b(int i2) {
        return i2 / Resources.getSystem().getDisplayMetrics().density;
    }

    public float a(int i2) {
        return i2 / this.a;
    }
}
