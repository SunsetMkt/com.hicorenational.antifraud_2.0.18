package androidx.transition;

import android.animation.TypeEvaluator;

/* loaded from: classes.dex */
class FloatArrayEvaluator implements TypeEvaluator<float[]> {
    private float[] mArray;

    FloatArrayEvaluator(float[] fArr) {
        this.mArray = fArr;
    }

    @Override // android.animation.TypeEvaluator
    public float[] evaluate(float f2, float[] fArr, float[] fArr2) {
        float[] fArr3 = this.mArray;
        if (fArr3 == null) {
            fArr3 = new float[fArr.length];
        }
        for (int i2 = 0; i2 < fArr3.length; i2++) {
            float f3 = fArr[i2];
            fArr3[i2] = f3 + ((fArr2[i2] - f3) * f2);
        }
        return fArr3;
    }
}
