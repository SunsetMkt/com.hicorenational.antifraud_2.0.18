package com.airbnb.lottie.a0;

import android.graphics.Color;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import com.airbnb.lottie.a0.l0.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: JsonUtils.java */
/* loaded from: classes.dex */
class p {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f3406a = c.a.a("x", "y");

    /* compiled from: JsonUtils.java */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3407a = new int[c.b.values().length];

        static {
            try {
                f3407a[c.b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3407a[c.b.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3407a[c.b.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private p() {
    }

    @ColorInt
    static int a(com.airbnb.lottie.a0.l0.c cVar) throws IOException {
        cVar.c();
        int j2 = (int) (cVar.j() * 255.0d);
        int j3 = (int) (cVar.j() * 255.0d);
        int j4 = (int) (cVar.j() * 255.0d);
        while (cVar.h()) {
            cVar.o();
        }
        cVar.e();
        return Color.argb(255, j2, j3, j4);
    }

    private static PointF b(com.airbnb.lottie.a0.l0.c cVar, float f2) throws IOException {
        float j2 = (float) cVar.j();
        float j3 = (float) cVar.j();
        while (cVar.h()) {
            cVar.o();
        }
        return new PointF(j2 * f2, j3 * f2);
    }

    private static PointF c(com.airbnb.lottie.a0.l0.c cVar, float f2) throws IOException {
        cVar.d();
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (cVar.h()) {
            int a2 = cVar.a(f3406a);
            if (a2 == 0) {
                f3 = b(cVar);
            } else if (a2 != 1) {
                cVar.n();
                cVar.o();
            } else {
                f4 = b(cVar);
            }
        }
        cVar.f();
        return new PointF(f3 * f2, f4 * f2);
    }

    static PointF d(com.airbnb.lottie.a0.l0.c cVar, float f2) throws IOException {
        int i2 = a.f3407a[cVar.peek().ordinal()];
        if (i2 == 1) {
            return b(cVar, f2);
        }
        if (i2 == 2) {
            return a(cVar, f2);
        }
        if (i2 == 3) {
            return c(cVar, f2);
        }
        throw new IllegalArgumentException("Unknown point starts with " + cVar.peek());
    }

    static List<PointF> e(com.airbnb.lottie.a0.l0.c cVar, float f2) throws IOException {
        ArrayList arrayList = new ArrayList();
        cVar.c();
        while (cVar.peek() == c.b.BEGIN_ARRAY) {
            cVar.c();
            arrayList.add(d(cVar, f2));
            cVar.e();
        }
        cVar.e();
        return arrayList;
    }

    static float b(com.airbnb.lottie.a0.l0.c cVar) throws IOException {
        c.b peek = cVar.peek();
        int i2 = a.f3407a[peek.ordinal()];
        if (i2 == 1) {
            return (float) cVar.j();
        }
        if (i2 == 2) {
            cVar.c();
            float j2 = (float) cVar.j();
            while (cVar.h()) {
                cVar.o();
            }
            cVar.e();
            return j2;
        }
        throw new IllegalArgumentException("Unknown value for token of type " + peek);
    }

    private static PointF a(com.airbnb.lottie.a0.l0.c cVar, float f2) throws IOException {
        cVar.c();
        float j2 = (float) cVar.j();
        float j3 = (float) cVar.j();
        while (cVar.peek() != c.b.END_ARRAY) {
            cVar.o();
        }
        cVar.e();
        return new PointF(j2 * f2, j3 * f2);
    }
}
