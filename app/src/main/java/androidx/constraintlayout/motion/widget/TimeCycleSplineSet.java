package androidx.constraintlayout.motion.widget;

import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.core.app.NotificationCompat;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;

/* loaded from: classes.dex */
public abstract class TimeCycleSplineSet {
    private static final int CURVE_OFFSET = 2;
    private static final int CURVE_PERIOD = 1;
    private static final int CURVE_VALUE = 0;
    private static final String TAG = "SplineSet";
    private static float VAL_2PI = 6.2831855f;
    private int count;
    long last_time;
    protected CurveFit mCurveFit;
    private String mType;
    protected int mWaveShape = 0;
    protected int[] mTimePoints = new int[10];
    protected float[][] mValues = (float[][]) Array.newInstance((Class<?>) float.class, 10, 3);
    private float[] mCache = new float[3];
    protected boolean mContinue = false;
    float last_cycle = Float.NaN;

    static class AlphaSet extends TimeCycleSplineSet {
        AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f2, long j2, KeyCache keyCache) {
            view.setAlpha(get(f2, j2, view, keyCache));
            return this.mContinue;
        }
    }

    static class CustomSet extends TimeCycleSplineSet {
        String mAttributeName;
        float[] mCache;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;
        SparseArray<float[]> mWaveProperties = new SparseArray<>();

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.mAttributeName = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[1];
            this.mConstraintAttributeList = sparseArray;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public void setPoint(int i2, float f2, float f3, int i3, float f4) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f2, long j2, KeyCache keyCache) {
            this.mCurveFit.getPos(f2, this.mTempValues);
            float[] fArr = this.mTempValues;
            float f3 = fArr[fArr.length - 2];
            float f4 = fArr[fArr.length - 1];
            long j3 = j2 - this.last_time;
            if (Float.isNaN(this.last_cycle)) {
                this.last_cycle = keyCache.getFloatValue(view, this.mAttributeName, 0);
                if (Float.isNaN(this.last_cycle)) {
                    this.last_cycle = 0.0f;
                }
            }
            this.last_cycle = (float) ((this.last_cycle + ((j3 * 1.0E-9d) * f3)) % 1.0d);
            this.last_time = j2;
            float calcWave = calcWave(this.last_cycle);
            this.mContinue = false;
            for (int i2 = 0; i2 < this.mCache.length; i2++) {
                this.mContinue |= ((double) this.mTempValues[i2]) != 0.0d;
                this.mCache[i2] = (this.mTempValues[i2] * calcWave) + f4;
            }
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(view, this.mCache);
            if (f3 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public void setup(int i2) {
            int size = this.mConstraintAttributeList.size();
            int noOfInterpValues = this.mConstraintAttributeList.valueAt(0).noOfInterpValues();
            double[] dArr = new double[size];
            int i3 = noOfInterpValues + 2;
            this.mTempValues = new float[i3];
            this.mCache = new float[noOfInterpValues];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) double.class, size, i3);
            for (int i4 = 0; i4 < size; i4++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i4);
                ConstraintAttribute valueAt = this.mConstraintAttributeList.valueAt(i4);
                float[] valueAt2 = this.mWaveProperties.valueAt(i4);
                dArr[i4] = keyAt * 0.01d;
                valueAt.getValuesToInterpolate(this.mTempValues);
                int i5 = 0;
                while (true) {
                    if (i5 < this.mTempValues.length) {
                        dArr2[i4][i5] = r7[i5];
                        i5++;
                    }
                }
                dArr2[i4][noOfInterpValues] = valueAt2[0];
                dArr2[i4][noOfInterpValues + 1] = valueAt2[1];
            }
            this.mCurveFit = CurveFit.get(i2, dArr, dArr2);
        }

        public void setPoint(int i2, ConstraintAttribute constraintAttribute, float f2, int i3, float f3) {
            this.mConstraintAttributeList.append(i2, constraintAttribute);
            this.mWaveProperties.append(i2, new float[]{f2, f3});
            this.mWaveShape = Math.max(this.mWaveShape, i3);
        }
    }

    static class ElevationSet extends TimeCycleSplineSet {
        ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f2, long j2, KeyCache keyCache) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(get(f2, j2, view, keyCache));
            }
            return this.mContinue;
        }
    }

    static class PathRotate extends TimeCycleSplineSet {
        PathRotate() {
        }

        public boolean setPathRotate(View view, KeyCache keyCache, float f2, long j2, double d2, double d3) {
            view.setRotation(get(f2, j2, view, keyCache) + ((float) Math.toDegrees(Math.atan2(d3, d2))));
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f2, long j2, KeyCache keyCache) {
            return this.mContinue;
        }
    }

    static class ProgressSet extends TimeCycleSplineSet {
        boolean mNoMethod = false;

        ProgressSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f2, long j2, KeyCache keyCache) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(f2, j2, view, keyCache));
            } else {
                if (this.mNoMethod) {
                    return false;
                }
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.mNoMethod = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, Float.valueOf(get(f2, j2, view, keyCache)));
                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                    }
                }
            }
            return this.mContinue;
        }
    }

    static class RotationSet extends TimeCycleSplineSet {
        RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f2, long j2, KeyCache keyCache) {
            view.setRotation(get(f2, j2, view, keyCache));
            return this.mContinue;
        }
    }

    static class RotationXset extends TimeCycleSplineSet {
        RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f2, long j2, KeyCache keyCache) {
            view.setRotationX(get(f2, j2, view, keyCache));
            return this.mContinue;
        }
    }

    static class RotationYset extends TimeCycleSplineSet {
        RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f2, long j2, KeyCache keyCache) {
            view.setRotationY(get(f2, j2, view, keyCache));
            return this.mContinue;
        }
    }

    static class ScaleXset extends TimeCycleSplineSet {
        ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f2, long j2, KeyCache keyCache) {
            view.setScaleX(get(f2, j2, view, keyCache));
            return this.mContinue;
        }
    }

    static class ScaleYset extends TimeCycleSplineSet {
        ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f2, long j2, KeyCache keyCache) {
            view.setScaleY(get(f2, j2, view, keyCache));
            return this.mContinue;
        }
    }

    private static class Sort {
        private Sort() {
        }

        static void doubleQuickSort(int[] iArr, float[][] fArr, int i2, int i3) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i3;
            iArr2[1] = i2;
            int i4 = 2;
            while (i4 > 0) {
                int i5 = i4 - 1;
                int i6 = iArr2[i5];
                i4 = i5 - 1;
                int i7 = iArr2[i4];
                if (i6 < i7) {
                    int partition = partition(iArr, fArr, i6, i7);
                    int i8 = i4 + 1;
                    iArr2[i4] = partition - 1;
                    int i9 = i8 + 1;
                    iArr2[i8] = i6;
                    int i10 = i9 + 1;
                    iArr2[i9] = i7;
                    i4 = i10 + 1;
                    iArr2[i10] = partition + 1;
                }
            }
        }

        private static int partition(int[] iArr, float[][] fArr, int i2, int i3) {
            int i4 = iArr[i3];
            int i5 = i2;
            while (i2 < i3) {
                if (iArr[i2] <= i4) {
                    swap(iArr, fArr, i5, i2);
                    i5++;
                }
                i2++;
            }
            swap(iArr, fArr, i5, i3);
            return i5;
        }

        private static void swap(int[] iArr, float[][] fArr, int i2, int i3) {
            int i4 = iArr[i2];
            iArr[i2] = iArr[i3];
            iArr[i3] = i4;
            float[] fArr2 = fArr[i2];
            fArr[i2] = fArr[i3];
            fArr[i3] = fArr2;
        }
    }

    static class TranslationXset extends TimeCycleSplineSet {
        TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f2, long j2, KeyCache keyCache) {
            view.setTranslationX(get(f2, j2, view, keyCache));
            return this.mContinue;
        }
    }

    static class TranslationYset extends TimeCycleSplineSet {
        TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f2, long j2, KeyCache keyCache) {
            view.setTranslationY(get(f2, j2, view, keyCache));
            return this.mContinue;
        }
    }

    static class TranslationZset extends TimeCycleSplineSet {
        TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f2, long j2, KeyCache keyCache) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(get(f2, j2, view, keyCache));
            }
            return this.mContinue;
        }
    }

    static TimeCycleSplineSet makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static TimeCycleSplineSet makeSpline(String str, long j2) {
        char c2;
        TimeCycleSplineSet alphaSet;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case -1001078227:
                if (str.equals(NotificationCompat.CATEGORY_PROGRESS)) {
                    c2 = 11;
                    break;
                }
                c2 = 65535;
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                alphaSet = new AlphaSet();
                break;
            case 1:
                alphaSet = new ElevationSet();
                break;
            case 2:
                alphaSet = new RotationSet();
                break;
            case 3:
                alphaSet = new RotationXset();
                break;
            case 4:
                alphaSet = new RotationYset();
                break;
            case 5:
                alphaSet = new PathRotate();
                break;
            case 6:
                alphaSet = new ScaleXset();
                break;
            case 7:
                alphaSet = new ScaleYset();
                break;
            case '\b':
                alphaSet = new TranslationXset();
                break;
            case '\t':
                alphaSet = new TranslationYset();
                break;
            case '\n':
                alphaSet = new TranslationZset();
                break;
            case 11:
                alphaSet = new ProgressSet();
                break;
            default:
                return null;
        }
        alphaSet.setStartTime(j2);
        return alphaSet;
    }

    protected float calcWave(float f2) {
        float abs;
        switch (this.mWaveShape) {
            case 1:
                return Math.signum(f2 * VAL_2PI);
            case 2:
                abs = Math.abs(f2);
                break;
            case 3:
                return (((f2 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                abs = ((f2 * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos(f2 * VAL_2PI);
            case 6:
                float abs2 = 1.0f - Math.abs(((f2 * 4.0f) % 4.0f) - 2.0f);
                abs = abs2 * abs2;
                break;
            default:
                return (float) Math.sin(f2 * VAL_2PI);
        }
        return 1.0f - abs;
    }

    public float get(float f2, long j2, View view, KeyCache keyCache) {
        this.mCurveFit.getPos(f2, this.mCache);
        float[] fArr = this.mCache;
        float f3 = fArr[1];
        if (f3 == 0.0f) {
            this.mContinue = false;
            return fArr[2];
        }
        if (Float.isNaN(this.last_cycle)) {
            this.last_cycle = keyCache.getFloatValue(view, this.mType, 0);
            if (Float.isNaN(this.last_cycle)) {
                this.last_cycle = 0.0f;
            }
        }
        this.last_cycle = (float) ((this.last_cycle + (((j2 - this.last_time) * 1.0E-9d) * f3)) % 1.0d);
        keyCache.setFloatValue(view, this.mType, 0, this.last_cycle);
        this.last_time = j2;
        float f4 = this.mCache[0];
        float calcWave = (calcWave(this.last_cycle) * f4) + this.mCache[2];
        this.mContinue = (f4 == 0.0f && f3 == 0.0f) ? false : true;
        return calcWave;
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public void setPoint(int i2, float f2, float f3, int i3, float f4) {
        int[] iArr = this.mTimePoints;
        int i4 = this.count;
        iArr[i4] = i2;
        float[][] fArr = this.mValues;
        fArr[i4][0] = f2;
        fArr[i4][1] = f3;
        fArr[i4][2] = f4;
        this.mWaveShape = Math.max(this.mWaveShape, i3);
        this.count++;
    }

    public abstract boolean setProperty(View view, float f2, long j2, KeyCache keyCache);

    protected void setStartTime(long j2) {
        this.last_time = j2;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(int i2) {
        int i3;
        int i4 = this.count;
        if (i4 == 0) {
            String str = "Error no points added to " + this.mType;
            return;
        }
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, i4 - 1);
        int i5 = 1;
        int i6 = 0;
        while (true) {
            int[] iArr = this.mTimePoints;
            if (i5 >= iArr.length) {
                break;
            }
            if (iArr[i5] != iArr[i5 - 1]) {
                i6++;
            }
            i5++;
        }
        if (i6 == 0) {
            i6 = 1;
        }
        double[] dArr = new double[i6];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) double.class, i6, 3);
        int i7 = 0;
        while (i3 < this.count) {
            if (i3 > 0) {
                int[] iArr2 = this.mTimePoints;
                i3 = iArr2[i3] == iArr2[i3 + (-1)] ? i3 + 1 : 0;
            }
            dArr[i7] = this.mTimePoints[i3] * 0.01d;
            double[] dArr3 = dArr2[i7];
            float[][] fArr = this.mValues;
            dArr3[0] = fArr[i3][0];
            dArr2[i7][1] = fArr[i3][1];
            dArr2[i7][2] = fArr[i3][2];
            i7++;
        }
        this.mCurveFit = CurveFit.get(i2, dArr, dArr2);
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i2 = 0; i2 < this.count; i2++) {
            str = str + "[" + this.mTimePoints[i2] + " , " + decimalFormat.format(this.mValues[i2]) + "] ";
        }
        return str;
    }
}
