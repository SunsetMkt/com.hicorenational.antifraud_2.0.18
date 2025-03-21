package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5535f0;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Canvas.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001aD\u0010\b\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a&\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001aN\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a:\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\n2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a:\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\n2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b¨\u0006\u0013"}, m23546d2 = {"withMatrix", "", "Landroid/graphics/Canvas;", "matrix", "Landroid/graphics/Matrix;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "withRotation", "degrees", "", "pivotX", "pivotY", "withSave", "withScale", "x", "y", "withSkew", "withTranslation", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class CanvasKt {
    public static final void withMatrix(@InterfaceC5816d Canvas canvas, @InterfaceC5816d Matrix matrix, @InterfaceC5816d InterfaceC5506l<? super Canvas, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(canvas, "$receiver");
        C5544i0.m22546f(matrix, "matrix");
        C5544i0.m22546f(interfaceC5506l, "block");
        int save = canvas.save();
        canvas.concat(matrix);
        try {
            interfaceC5506l.invoke(canvas);
        } finally {
            C5535f0.m22474b(1);
            canvas.restoreToCount(save);
            C5535f0.m22471a(1);
        }
    }

    public static /* bridge */ /* synthetic */ void withMatrix$default(Canvas canvas, Matrix matrix, InterfaceC5506l interfaceC5506l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            matrix = new Matrix();
        }
        C5544i0.m22546f(canvas, "$receiver");
        C5544i0.m22546f(matrix, "matrix");
        C5544i0.m22546f(interfaceC5506l, "block");
        int save = canvas.save();
        canvas.concat(matrix);
        try {
            interfaceC5506l.invoke(canvas);
        } finally {
            C5535f0.m22474b(1);
            canvas.restoreToCount(save);
            C5535f0.m22471a(1);
        }
    }

    public static final void withRotation(@InterfaceC5816d Canvas canvas, float f2, float f3, float f4, @InterfaceC5816d InterfaceC5506l<? super Canvas, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(canvas, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "block");
        int save = canvas.save();
        canvas.rotate(f2, f3, f4);
        try {
            interfaceC5506l.invoke(canvas);
        } finally {
            C5535f0.m22474b(1);
            canvas.restoreToCount(save);
            C5535f0.m22471a(1);
        }
    }

    public static /* bridge */ /* synthetic */ void withRotation$default(Canvas canvas, float f2, float f3, float f4, InterfaceC5506l interfaceC5506l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 2) != 0) {
            f3 = 0.0f;
        }
        if ((i2 & 4) != 0) {
            f4 = 0.0f;
        }
        C5544i0.m22546f(canvas, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "block");
        int save = canvas.save();
        canvas.rotate(f2, f3, f4);
        try {
            interfaceC5506l.invoke(canvas);
        } finally {
            C5535f0.m22474b(1);
            canvas.restoreToCount(save);
            C5535f0.m22471a(1);
        }
    }

    public static final void withSave(@InterfaceC5816d Canvas canvas, @InterfaceC5816d InterfaceC5506l<? super Canvas, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(canvas, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "block");
        int save = canvas.save();
        try {
            interfaceC5506l.invoke(canvas);
        } finally {
            C5535f0.m22474b(1);
            canvas.restoreToCount(save);
            C5535f0.m22471a(1);
        }
    }

    public static final void withScale(@InterfaceC5816d Canvas canvas, float f2, float f3, float f4, float f5, @InterfaceC5816d InterfaceC5506l<? super Canvas, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(canvas, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "block");
        int save = canvas.save();
        canvas.scale(f2, f3, f4, f5);
        try {
            interfaceC5506l.invoke(canvas);
        } finally {
            C5535f0.m22474b(1);
            canvas.restoreToCount(save);
            C5535f0.m22471a(1);
        }
    }

    public static /* bridge */ /* synthetic */ void withScale$default(Canvas canvas, float f2, float f3, float f4, float f5, InterfaceC5506l interfaceC5506l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 1.0f;
        }
        if ((i2 & 2) != 0) {
            f3 = 1.0f;
        }
        if ((i2 & 4) != 0) {
            f4 = 0.0f;
        }
        if ((i2 & 8) != 0) {
            f5 = 0.0f;
        }
        C5544i0.m22546f(canvas, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "block");
        int save = canvas.save();
        canvas.scale(f2, f3, f4, f5);
        try {
            interfaceC5506l.invoke(canvas);
        } finally {
            C5535f0.m22474b(1);
            canvas.restoreToCount(save);
            C5535f0.m22471a(1);
        }
    }

    public static final void withSkew(@InterfaceC5816d Canvas canvas, float f2, float f3, @InterfaceC5816d InterfaceC5506l<? super Canvas, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(canvas, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "block");
        int save = canvas.save();
        canvas.skew(f2, f3);
        try {
            interfaceC5506l.invoke(canvas);
        } finally {
            C5535f0.m22474b(1);
            canvas.restoreToCount(save);
            C5535f0.m22471a(1);
        }
    }

    public static /* bridge */ /* synthetic */ void withSkew$default(Canvas canvas, float f2, float f3, InterfaceC5506l interfaceC5506l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 2) != 0) {
            f3 = 0.0f;
        }
        C5544i0.m22546f(canvas, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "block");
        int save = canvas.save();
        canvas.skew(f2, f3);
        try {
            interfaceC5506l.invoke(canvas);
        } finally {
            C5535f0.m22474b(1);
            canvas.restoreToCount(save);
            C5535f0.m22471a(1);
        }
    }

    public static final void withTranslation(@InterfaceC5816d Canvas canvas, float f2, float f3, @InterfaceC5816d InterfaceC5506l<? super Canvas, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(canvas, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "block");
        int save = canvas.save();
        canvas.translate(f2, f3);
        try {
            interfaceC5506l.invoke(canvas);
        } finally {
            C5535f0.m22474b(1);
            canvas.restoreToCount(save);
            C5535f0.m22471a(1);
        }
    }

    public static /* bridge */ /* synthetic */ void withTranslation$default(Canvas canvas, float f2, float f3, InterfaceC5506l interfaceC5506l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 2) != 0) {
            f3 = 0.0f;
        }
        C5544i0.m22546f(canvas, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "block");
        int save = canvas.save();
        canvas.translate(f2, f3);
        try {
            interfaceC5506l.invoke(canvas);
        } finally {
            C5535f0.m22474b(1);
            canvas.restoreToCount(save);
            C5535f0.m22471a(1);
        }
    }
}
