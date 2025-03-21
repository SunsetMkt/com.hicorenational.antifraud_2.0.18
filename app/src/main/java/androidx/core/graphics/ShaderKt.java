package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Shader;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Shader.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H\u0086\b¨\u0006\u0007"}, m23546d2 = {"transform", "", "Landroid/graphics/Shader;", "block", "Lkotlin/Function1;", "Landroid/graphics/Matrix;", "Lkotlin/ExtensionFunctionType;", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class ShaderKt {
    public static final void transform(@InterfaceC5816d Shader shader, @InterfaceC5816d InterfaceC5506l<? super Matrix, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(shader, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "block");
        Matrix matrix = new Matrix();
        shader.getLocalMatrix(matrix);
        interfaceC5506l.invoke(matrix);
        shader.setLocalMatrix(matrix);
    }
}
