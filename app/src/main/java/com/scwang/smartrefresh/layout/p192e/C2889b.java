package com.scwang.smartrefresh.layout.p192e;

import android.content.res.Resources;

/* compiled from: DensityUtil.java */
/* renamed from: com.scwang.smartrefresh.layout.e.b */
/* loaded from: classes.dex */
public class C2889b {

    /* renamed from: a */
    public float f9116a = Resources.getSystem().getDisplayMetrics().density;

    /* renamed from: b */
    public static int m8735b(float f2) {
        return (int) ((f2 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: a */
    public int m8737a(float f2) {
        return (int) ((f2 * this.f9116a) + 0.5f);
    }

    /* renamed from: b */
    public static float m8734b(int i2) {
        return i2 / Resources.getSystem().getDisplayMetrics().density;
    }

    /* renamed from: a */
    public float m8736a(int i2) {
        return i2 / this.f9116a;
    }
}
