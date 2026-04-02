package com.airbnb.lottie.a0;

import android.graphics.Color;
import androidx.annotation.IntRange;
import com.airbnb.lottie.a0.l0.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: GradientColorParser.java */
/* JADX INFO: loaded from: classes.dex */
public class l implements k0<com.airbnb.lottie.y.k.c> {
    private int a;

    public l(int i2) {
        this.a = i2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008f  */
    @Override // com.airbnb.lottie.a0.k0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.airbnb.lottie.y.k.c a(com.airbnb.lottie.a0.l0.c cVar, float f2) throws IOException {
        ArrayList arrayList = new ArrayList();
        boolean z = cVar.peek() == c.b.BEGIN_ARRAY;
        if (z) {
            cVar.c();
        }
        while (cVar.h()) {
            arrayList.add(Float.valueOf((float) cVar.j()));
        }
        if (z) {
            cVar.e();
        }
        if (this.a == -1) {
            this.a = arrayList.size() / 4;
        }
        int i2 = this.a;
        float[] fArr = new float[i2];
        int[] iArr = new int[i2];
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < this.a * 4; i5++) {
            int i6 = i5 / 4;
            double dFloatValue = arrayList.get(i5).floatValue();
            int i7 = i5 % 4;
            if (i7 != 0) {
                if (i7 == 1) {
                    i3 = (int) (dFloatValue * 255.0d);
                } else if (i7 == 2) {
                    i4 = (int) (dFloatValue * 255.0d);
                } else if (i7 == 3) {
                    iArr[i6] = Color.argb(255, i3, i4, (int) (dFloatValue * 255.0d));
                }
            } else if (i6 > 0) {
                float f3 = (float) dFloatValue;
                if (fArr[i6 - 1] >= f3) {
                    fArr[i6] = f3 + 0.01f;
                } else {
                    fArr[i6] = (float) dFloatValue;
                }
            }
        }
        com.airbnb.lottie.y.k.c cVar2 = new com.airbnb.lottie.y.k.c(fArr, iArr);
        a(cVar2, arrayList);
        return cVar2;
    }

    private void a(com.airbnb.lottie.y.k.c cVar, List<Float> list) {
        int i2 = this.a * 4;
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
        for (int i4 = 0; i4 < cVar.c(); i4++) {
            int i5 = cVar.a()[i4];
            cVar.a()[i4] = Color.argb(a(cVar.b()[i4], dArr, dArr2), Color.red(i5), Color.green(i5), Color.blue(i5));
        }
    }

    @IntRange(from = 0, to = 255)
    private int a(double d2, double[] dArr, double[] dArr2) {
        double dB;
        int i2 = 1;
        while (true) {
            if (i2 < dArr.length) {
                int i3 = i2 - 1;
                double d3 = dArr[i3];
                double d4 = dArr[i2];
                if (dArr[i2] >= d2) {
                    dB = com.airbnb.lottie.b0.g.b(dArr2[i3], dArr2[i2], com.airbnb.lottie.b0.g.a((d2 - d3) / (d4 - d3), 0.0d, 1.0d));
                    break;
                }
                i2++;
            } else {
                dB = dArr2[dArr2.length - 1];
                break;
            }
        }
        return (int) (dB * 255.0d);
    }
}
