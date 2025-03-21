package androidx.core.content;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import androidx.exifinterface.media.ExifInterface;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Context.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u00006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\u0086\b¢\u0006\u0002\u0010\u0003\u001aN\u0010\u0004\u001a\u00020\u0005*\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\f\u001a\u00020\u000b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\u000e¢\u0006\u0002\b\u0010H\u0086\b\u001a8\u0010\u0004\u001a\u00020\u0005*\u00020\u00022\b\b\u0001\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\u000e¢\u0006\u0002\b\u0010H\u0086\b¨\u0006\u0012"}, m23546d2 = {"getSystemService", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/content/Context;", "(Landroid/content/Context;)Ljava/lang/Object;", "withStyledAttributes", "", "set", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "", "defStyleRes", "block", "Lkotlin/Function1;", "Landroid/content/res/TypedArray;", "Lkotlin/ExtensionFunctionType;", "resourceId", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class ContextKt {
    private static final <T> T getSystemService(@InterfaceC5816d Context context) {
        C5544i0.m22518a(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) ContextCompat.getSystemService(context, Object.class);
    }

    public static final void withStyledAttributes(@InterfaceC5816d Context context, @InterfaceC5817e AttributeSet attributeSet, @InterfaceC5816d int[] iArr, @AttrRes int i2, @StyleRes int i3, @InterfaceC5816d InterfaceC5506l<? super TypedArray, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(context, "$receiver");
        C5544i0.m22546f(iArr, "attrs");
        C5544i0.m22546f(interfaceC5506l, "block");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        interfaceC5506l.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static /* bridge */ /* synthetic */ void withStyledAttributes$default(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3, InterfaceC5506l interfaceC5506l, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            attributeSet = null;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        C5544i0.m22546f(context, "$receiver");
        C5544i0.m22546f(iArr, "attrs");
        C5544i0.m22546f(interfaceC5506l, "block");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        interfaceC5506l.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static final void withStyledAttributes(@InterfaceC5816d Context context, @StyleRes int i2, @InterfaceC5816d int[] iArr, @InterfaceC5816d InterfaceC5506l<? super TypedArray, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(context, "$receiver");
        C5544i0.m22546f(iArr, "attrs");
        C5544i0.m22546f(interfaceC5506l, "block");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, iArr);
        interfaceC5506l.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }
}
