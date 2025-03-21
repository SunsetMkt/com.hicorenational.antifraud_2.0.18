package androidx.core.graphics;

import android.graphics.Matrix;
import com.taobao.accs.common.Constants;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Matrix.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0014\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u001a\u001a\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003\u001a\u001a\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u001a\u0015\u0010\f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0086\n\u001a\r\u0010\u000e\u001a\u00020\u000f*\u00020\u0001H\u0086\b¨\u0006\u0010"}, m23546d2 = {"rotationMatrix", "Landroid/graphics/Matrix;", "degrees", "", "px", "py", "scaleMatrix", "sx", "sy", "translationMatrix", "tx", "ty", Constants.KEY_TIMES, "m", "values", "", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class MatrixKt {
    @InterfaceC5816d
    public static final Matrix rotationMatrix(float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        matrix.setRotate(f2, f3, f4);
        return matrix;
    }

    @InterfaceC5816d
    public static /* bridge */ /* synthetic */ Matrix rotationMatrix$default(float f2, float f3, float f4, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f3 = 0.0f;
        }
        if ((i2 & 4) != 0) {
            f4 = 0.0f;
        }
        return rotationMatrix(f2, f3, f4);
    }

    @InterfaceC5816d
    public static final Matrix scaleMatrix(float f2, float f3) {
        Matrix matrix = new Matrix();
        matrix.setScale(f2, f3);
        return matrix;
    }

    @InterfaceC5816d
    public static /* bridge */ /* synthetic */ Matrix scaleMatrix$default(float f2, float f3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 1.0f;
        }
        if ((i2 & 2) != 0) {
            f3 = 1.0f;
        }
        return scaleMatrix(f2, f3);
    }

    @InterfaceC5816d
    public static final Matrix times(@InterfaceC5816d Matrix matrix, @InterfaceC5816d Matrix matrix2) {
        C5544i0.m22546f(matrix, "$receiver");
        C5544i0.m22546f(matrix2, "m");
        Matrix matrix3 = new Matrix(matrix);
        matrix3.preConcat(matrix2);
        return matrix3;
    }

    @InterfaceC5816d
    public static final Matrix translationMatrix(float f2, float f3) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(f2, f3);
        return matrix;
    }

    @InterfaceC5816d
    public static /* bridge */ /* synthetic */ Matrix translationMatrix$default(float f2, float f3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 2) != 0) {
            f3 = 0.0f;
        }
        return translationMatrix(f2, f3);
    }

    @InterfaceC5816d
    public static final float[] values(@InterfaceC5816d Matrix matrix) {
        C5544i0.m22546f(matrix, "$receiver");
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return fArr;
    }
}
