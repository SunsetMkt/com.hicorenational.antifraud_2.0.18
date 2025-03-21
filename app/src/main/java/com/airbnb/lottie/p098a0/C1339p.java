package com.airbnb.lottie.p098a0;

import android.graphics.Color;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import com.airbnb.lottie.p098a0.p099l0.AbstractC1330c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: JsonUtils.java */
/* renamed from: com.airbnb.lottie.a0.p */
/* loaded from: classes.dex */
class C1339p {

    /* renamed from: a */
    private static final AbstractC1330c.a f3110a = AbstractC1330c.a.m2710a("x", "y");

    /* compiled from: JsonUtils.java */
    /* renamed from: com.airbnb.lottie.a0.p$a */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f3111a = new int[AbstractC1330c.b.values().length];

        static {
            try {
                f3111a[AbstractC1330c.b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3111a[AbstractC1330c.b.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3111a[AbstractC1330c.b.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private C1339p() {
    }

    @ColorInt
    /* renamed from: a */
    static int m2745a(AbstractC1330c abstractC1330c) throws IOException {
        abstractC1330c.mo2697c();
        int mo2704j = (int) (abstractC1330c.mo2704j() * 255.0d);
        int mo2704j2 = (int) (abstractC1330c.mo2704j() * 255.0d);
        int mo2704j3 = (int) (abstractC1330c.mo2704j() * 255.0d);
        while (abstractC1330c.mo2702h()) {
            abstractC1330c.mo2709o();
        }
        abstractC1330c.mo2699e();
        return Color.argb(255, mo2704j, mo2704j2, mo2704j3);
    }

    /* renamed from: b */
    private static PointF m2748b(AbstractC1330c abstractC1330c, float f2) throws IOException {
        float mo2704j = (float) abstractC1330c.mo2704j();
        float mo2704j2 = (float) abstractC1330c.mo2704j();
        while (abstractC1330c.mo2702h()) {
            abstractC1330c.mo2709o();
        }
        return new PointF(mo2704j * f2, mo2704j2 * f2);
    }

    /* renamed from: c */
    private static PointF m2749c(AbstractC1330c abstractC1330c, float f2) throws IOException {
        abstractC1330c.mo2698d();
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (abstractC1330c.mo2702h()) {
            int mo2694a = abstractC1330c.mo2694a(f3110a);
            if (mo2694a == 0) {
                f3 = m2747b(abstractC1330c);
            } else if (mo2694a != 1) {
                abstractC1330c.mo2708n();
                abstractC1330c.mo2709o();
            } else {
                f4 = m2747b(abstractC1330c);
            }
        }
        abstractC1330c.mo2700f();
        return new PointF(f3 * f2, f4 * f2);
    }

    /* renamed from: d */
    static PointF m2750d(AbstractC1330c abstractC1330c, float f2) throws IOException {
        int i2 = a.f3111a[abstractC1330c.peek().ordinal()];
        if (i2 == 1) {
            return m2748b(abstractC1330c, f2);
        }
        if (i2 == 2) {
            return m2746a(abstractC1330c, f2);
        }
        if (i2 == 3) {
            return m2749c(abstractC1330c, f2);
        }
        throw new IllegalArgumentException("Unknown point starts with " + abstractC1330c.peek());
    }

    /* renamed from: e */
    static List<PointF> m2751e(AbstractC1330c abstractC1330c, float f2) throws IOException {
        ArrayList arrayList = new ArrayList();
        abstractC1330c.mo2697c();
        while (abstractC1330c.peek() == AbstractC1330c.b.BEGIN_ARRAY) {
            abstractC1330c.mo2697c();
            arrayList.add(m2750d(abstractC1330c, f2));
            abstractC1330c.mo2699e();
        }
        abstractC1330c.mo2699e();
        return arrayList;
    }

    /* renamed from: b */
    static float m2747b(AbstractC1330c abstractC1330c) throws IOException {
        AbstractC1330c.b peek = abstractC1330c.peek();
        int i2 = a.f3111a[peek.ordinal()];
        if (i2 == 1) {
            return (float) abstractC1330c.mo2704j();
        }
        if (i2 == 2) {
            abstractC1330c.mo2697c();
            float mo2704j = (float) abstractC1330c.mo2704j();
            while (abstractC1330c.mo2702h()) {
                abstractC1330c.mo2709o();
            }
            abstractC1330c.mo2699e();
            return mo2704j;
        }
        throw new IllegalArgumentException("Unknown value for token of type " + peek);
    }

    /* renamed from: a */
    private static PointF m2746a(AbstractC1330c abstractC1330c, float f2) throws IOException {
        abstractC1330c.mo2697c();
        float mo2704j = (float) abstractC1330c.mo2704j();
        float mo2704j2 = (float) abstractC1330c.mo2704j();
        while (abstractC1330c.peek() != AbstractC1330c.b.END_ARRAY) {
            abstractC1330c.mo2709o();
        }
        abstractC1330c.mo2699e();
        return new PointF(mo2704j * f2, mo2704j2 * f2);
    }
}
