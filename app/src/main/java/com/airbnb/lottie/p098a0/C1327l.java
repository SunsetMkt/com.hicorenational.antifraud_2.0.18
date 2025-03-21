package com.airbnb.lottie.p098a0;

import android.graphics.Color;
import androidx.annotation.IntRange;
import com.airbnb.lottie.p098a0.p099l0.AbstractC1330c;
import com.airbnb.lottie.p100b0.C1357g;
import com.airbnb.lottie.p106y.p108k.C1461c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GradientColorParser.java */
/* renamed from: com.airbnb.lottie.a0.l */
/* loaded from: classes.dex */
public class C1327l implements InterfaceC1326k0<C1461c> {

    /* renamed from: a */
    private int f3023a;

    public C1327l(int i2) {
        this.f3023a = i2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.p098a0.InterfaceC1326k0
    /* renamed from: a */
    public C1461c mo2679a(AbstractC1330c abstractC1330c, float f2) throws IOException {
        ArrayList arrayList = new ArrayList();
        boolean z = abstractC1330c.peek() == AbstractC1330c.b.BEGIN_ARRAY;
        if (z) {
            abstractC1330c.mo2697c();
        }
        while (abstractC1330c.mo2702h()) {
            arrayList.add(Float.valueOf((float) abstractC1330c.mo2704j()));
        }
        if (z) {
            abstractC1330c.mo2699e();
        }
        if (this.f3023a == -1) {
            this.f3023a = arrayList.size() / 4;
        }
        int i2 = this.f3023a;
        float[] fArr = new float[i2];
        int[] iArr = new int[i2];
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < this.f3023a * 4; i5++) {
            int i6 = i5 / 4;
            double floatValue = arrayList.get(i5).floatValue();
            int i7 = i5 % 4;
            if (i7 == 0) {
                if (i6 > 0) {
                    float f3 = (float) floatValue;
                    if (fArr[i6 - 1] >= f3) {
                        fArr[i6] = f3 + 0.01f;
                    }
                }
                fArr[i6] = (float) floatValue;
            } else if (i7 == 1) {
                i3 = (int) (floatValue * 255.0d);
            } else if (i7 == 2) {
                i4 = (int) (floatValue * 255.0d);
            } else if (i7 == 3) {
                iArr[i6] = Color.argb(255, i3, i4, (int) (floatValue * 255.0d));
            }
        }
        C1461c c1461c = new C1461c(fArr, iArr);
        m2690a(c1461c, arrayList);
        return c1461c;
    }

    /* renamed from: a */
    private void m2690a(C1461c c1461c, List<Float> list) {
        int i2 = this.f3023a * 4;
        if (list.size() <= i2) {
            return;
        }
        int size = (list.size() - i2) / 2;
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        int i3 = 0;
        while (i2 < list.size()) {
            if (i2 % 2 == 0) {
                dArr[i3] = list.get(i2).floatValue();
            } else {
                dArr2[i3] = list.get(i2).floatValue();
                i3++;
            }
            i2++;
        }
        for (int i4 = 0; i4 < c1461c.m3242c(); i4++) {
            int i5 = c1461c.m3240a()[i4];
            c1461c.m3240a()[i4] = Color.argb(m2689a(c1461c.m3241b()[i4], dArr, dArr2), Color.red(i5), Color.green(i5), Color.blue(i5));
        }
    }

    @IntRange(from = 0, m294to = 255)
    /* renamed from: a */
    private int m2689a(double d2, double[] dArr, double[] dArr2) {
        double d3;
        int i2 = 1;
        while (true) {
            if (i2 < dArr.length) {
                int i3 = i2 - 1;
                double d4 = dArr[i3];
                double d5 = dArr[i2];
                if (dArr[i2] >= d2) {
                    d3 = C1357g.m2828b(dArr2[i3], dArr2[i2], C1357g.m2819a((d2 - d4) / (d5 - d4), 0.0d, 1.0d));
                    break;
                }
                i2++;
            } else {
                d3 = dArr2[dArr2.length - 1];
                break;
            }
        }
        return (int) (d3 * 255.0d);
    }
}
