package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import com.xiaomi.mipush.sdk.Constants;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class PathInterpolatorCompat implements Interpolator {
    public static final double EPSILON = 1.0E-5d;
    public static final int MAX_NUM_POINTS = 3000;
    private static final float PRECISION = 0.002f;

    /* renamed from: mX */
    private float[] f630mX;

    /* renamed from: mY */
    private float[] f631mY;

    public PathInterpolatorCompat(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    private void initCubic(float f2, float f3, float f4, float f5) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f2, f3, f4, f5, 1.0f, 1.0f);
        initPath(path);
    }

    private void initPath(Path path) {
        int i2 = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = Math.min(MAX_NUM_POINTS, ((int) (length / PRECISION)) + 1);
        if (min <= 0) {
            throw new IllegalArgumentException("The Path has a invalid length " + length);
        }
        this.f630mX = new float[min];
        this.f631mY = new float[min];
        float[] fArr = new float[2];
        for (int i3 = 0; i3 < min; i3++) {
            pathMeasure.getPosTan((i3 * length) / (min - 1), fArr, null);
            this.f630mX[i3] = fArr[0];
            this.f631mY[i3] = fArr[1];
        }
        if (Math.abs(this.f630mX[0]) <= 1.0E-5d && Math.abs(this.f631mY[0]) <= 1.0E-5d) {
            int i4 = min - 1;
            if (Math.abs(this.f630mX[i4] - 1.0f) <= 1.0E-5d && Math.abs(this.f631mY[i4] - 1.0f) <= 1.0E-5d) {
                int i5 = 0;
                float f2 = 0.0f;
                while (i2 < min) {
                    float[] fArr2 = this.f630mX;
                    int i6 = i5 + 1;
                    float f3 = fArr2[i5];
                    if (f3 < f2) {
                        throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f3);
                    }
                    fArr2[i2] = f3;
                    i2++;
                    f2 = f3;
                    i5 = i6;
                }
                if (pathMeasure.nextContour()) {
                    throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                }
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("The Path must start at (0,0) and end at (1,1) start: ");
        sb.append(this.f630mX[0]);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(this.f631mY[0]);
        sb.append(" end:");
        int i7 = min - 1;
        sb.append(this.f630mX[i7]);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(this.f631mY[i7]);
        throw new IllegalArgumentException(sb.toString());
    }

    private void initQuad(float f2, float f3) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f2, f3, 1.0f, 1.0f);
        initPath(path);
    }

    private void parseInterpolatorFromTypeArray(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
            String namedString = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "pathData", 4);
            Path createPathFromPathData = PathParser.createPathFromPathData(namedString);
            if (createPathFromPathData != null) {
                initPath(createPathFromPathData);
                return;
            }
            throw new InflateException("The path is null, which is created from " + namedString);
        }
        if (!TypedArrayUtils.hasAttribute(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        }
        if (!TypedArrayUtils.hasAttribute(xmlPullParser, "controlY1")) {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
        float namedFloat = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlX1", 0, 0.0f);
        float namedFloat2 = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlY1", 1, 0.0f);
        boolean hasAttribute = TypedArrayUtils.hasAttribute(xmlPullParser, "controlX2");
        if (hasAttribute != TypedArrayUtils.hasAttribute(xmlPullParser, "controlY2")) {
            throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
        }
        if (hasAttribute) {
            initCubic(namedFloat, namedFloat2, TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlX2", 2, 0.0f), TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlY2", 3, 0.0f));
        } else {
            initQuad(namedFloat, namedFloat2);
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        int i2 = 0;
        int length = this.f630mX.length - 1;
        while (length - i2 > 1) {
            int i3 = (i2 + length) / 2;
            if (f2 < this.f630mX[i3]) {
                length = i3;
            } else {
                i2 = i3;
            }
        }
        float[] fArr = this.f630mX;
        float f3 = fArr[length] - fArr[i2];
        if (f3 == 0.0f) {
            return this.f631mY[i2];
        }
        float f4 = (f2 - fArr[i2]) / f3;
        float[] fArr2 = this.f631mY;
        float f5 = fArr2[i2];
        return f5 + (f4 * (fArr2[length] - f5));
    }

    public PathInterpolatorCompat(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_PATH_INTERPOLATOR);
        parseInterpolatorFromTypeArray(obtainAttributes, xmlPullParser);
        obtainAttributes.recycle();
    }
}
