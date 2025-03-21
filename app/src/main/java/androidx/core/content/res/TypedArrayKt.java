package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: TypedArray.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u0016\u0010\u0007\u001a\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\b\u001a\u00020\t*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u0016\u0010\f\u001a\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0016\u0010\r\u001a\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\u0010\u001a\u00020\u000b*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u0016\u0010\u0011\u001a\u00020\u0012*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\u0013\u001a\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\u0014\u001a\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u0016\u0010\u0015\u001a\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u001b\u001a\u0014\u0010\u001c\u001a\u00020\u001a*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a,\u0010\u001d\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u001e*\u00020\u00022\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u001e0 H\u0086\b¢\u0006\u0002\u0010!¨\u0006\""}, m23546d2 = {"checkAttribute", "", "Landroid/content/res/TypedArray;", "index", "", "getBooleanOrThrow", "", "getColorOrThrow", "getColorStateListOrThrow", "Landroid/content/res/ColorStateList;", "getDimensionOrThrow", "", "getDimensionPixelOffsetOrThrow", "getDimensionPixelSizeOrThrow", "getDrawableOrThrow", "Landroid/graphics/drawable/Drawable;", "getFloatOrThrow", "getFontOrThrow", "Landroid/graphics/Typeface;", "getIntOrThrow", "getIntegerOrThrow", "getResourceIdOrThrow", "getStringOrThrow", "", "getTextArrayOrThrow", "", "", "(Landroid/content/res/TypedArray;I)[Ljava/lang/CharSequence;", "getTextOrThrow", "use", "R", "block", "Lkotlin/Function1;", "(Landroid/content/res/TypedArray;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class TypedArrayKt {
    private static final void checkAttribute(@InterfaceC5816d TypedArray typedArray, @StyleableRes int i2) {
        if (!typedArray.hasValue(i2)) {
            throw new IllegalArgumentException("Attribute not defined in set.");
        }
    }

    public static final boolean getBooleanOrThrow(@InterfaceC5816d TypedArray typedArray, @StyleableRes int i2) {
        C5544i0.m22546f(typedArray, "$receiver");
        checkAttribute(typedArray, i2);
        return typedArray.getBoolean(i2, false);
    }

    @ColorInt
    public static final int getColorOrThrow(@InterfaceC5816d TypedArray typedArray, @StyleableRes int i2) {
        C5544i0.m22546f(typedArray, "$receiver");
        checkAttribute(typedArray, i2);
        return typedArray.getColor(i2, 0);
    }

    @InterfaceC5816d
    public static final ColorStateList getColorStateListOrThrow(@InterfaceC5816d TypedArray typedArray, @StyleableRes int i2) {
        C5544i0.m22546f(typedArray, "$receiver");
        checkAttribute(typedArray, i2);
        ColorStateList colorStateList = typedArray.getColorStateList(i2);
        if (colorStateList != null) {
            return colorStateList;
        }
        throw new IllegalStateException("Attribute value was not a color or color state list.".toString());
    }

    public static final float getDimensionOrThrow(@InterfaceC5816d TypedArray typedArray, @StyleableRes int i2) {
        C5544i0.m22546f(typedArray, "$receiver");
        checkAttribute(typedArray, i2);
        return typedArray.getDimension(i2, 0.0f);
    }

    @Dimension
    public static final int getDimensionPixelOffsetOrThrow(@InterfaceC5816d TypedArray typedArray, @StyleableRes int i2) {
        C5544i0.m22546f(typedArray, "$receiver");
        checkAttribute(typedArray, i2);
        return typedArray.getDimensionPixelOffset(i2, 0);
    }

    @Dimension
    public static final int getDimensionPixelSizeOrThrow(@InterfaceC5816d TypedArray typedArray, @StyleableRes int i2) {
        C5544i0.m22546f(typedArray, "$receiver");
        checkAttribute(typedArray, i2);
        return typedArray.getDimensionPixelSize(i2, 0);
    }

    @InterfaceC5816d
    public static final Drawable getDrawableOrThrow(@InterfaceC5816d TypedArray typedArray, @StyleableRes int i2) {
        C5544i0.m22546f(typedArray, "$receiver");
        checkAttribute(typedArray, i2);
        Drawable drawable = typedArray.getDrawable(i2);
        C5544i0.m22521a((Object) drawable, "getDrawable(index)");
        return drawable;
    }

    public static final float getFloatOrThrow(@InterfaceC5816d TypedArray typedArray, @StyleableRes int i2) {
        C5544i0.m22546f(typedArray, "$receiver");
        checkAttribute(typedArray, i2);
        return typedArray.getFloat(i2, 0.0f);
    }

    @RequiresApi(26)
    @InterfaceC5816d
    public static final Typeface getFontOrThrow(@InterfaceC5816d TypedArray typedArray, @StyleableRes int i2) {
        C5544i0.m22546f(typedArray, "$receiver");
        checkAttribute(typedArray, i2);
        Typeface font = typedArray.getFont(i2);
        C5544i0.m22521a((Object) font, "getFont(index)");
        return font;
    }

    public static final int getIntOrThrow(@InterfaceC5816d TypedArray typedArray, @StyleableRes int i2) {
        C5544i0.m22546f(typedArray, "$receiver");
        checkAttribute(typedArray, i2);
        return typedArray.getInt(i2, 0);
    }

    public static final int getIntegerOrThrow(@InterfaceC5816d TypedArray typedArray, @StyleableRes int i2) {
        C5544i0.m22546f(typedArray, "$receiver");
        checkAttribute(typedArray, i2);
        return typedArray.getInteger(i2, 0);
    }

    @AnyRes
    public static final int getResourceIdOrThrow(@InterfaceC5816d TypedArray typedArray, @StyleableRes int i2) {
        C5544i0.m22546f(typedArray, "$receiver");
        checkAttribute(typedArray, i2);
        return typedArray.getResourceId(i2, 0);
    }

    @InterfaceC5816d
    public static final String getStringOrThrow(@InterfaceC5816d TypedArray typedArray, @StyleableRes int i2) {
        C5544i0.m22546f(typedArray, "$receiver");
        checkAttribute(typedArray, i2);
        String string = typedArray.getString(i2);
        if (string != null) {
            return string;
        }
        throw new IllegalStateException("Attribute value could not be coerced to String.".toString());
    }

    @InterfaceC5816d
    public static final CharSequence[] getTextArrayOrThrow(@InterfaceC5816d TypedArray typedArray, @StyleableRes int i2) {
        C5544i0.m22546f(typedArray, "$receiver");
        checkAttribute(typedArray, i2);
        CharSequence[] textArray = typedArray.getTextArray(i2);
        C5544i0.m22521a((Object) textArray, "getTextArray(index)");
        return textArray;
    }

    @InterfaceC5816d
    public static final CharSequence getTextOrThrow(@InterfaceC5816d TypedArray typedArray, @StyleableRes int i2) {
        C5544i0.m22546f(typedArray, "$receiver");
        checkAttribute(typedArray, i2);
        CharSequence text = typedArray.getText(i2);
        if (text != null) {
            return text;
        }
        throw new IllegalStateException("Attribute value could not be coerced to CharSequence.".toString());
    }

    public static final <R> R use(@InterfaceC5816d TypedArray typedArray, @InterfaceC5816d InterfaceC5506l<? super TypedArray, ? extends R> interfaceC5506l) {
        C5544i0.m22546f(typedArray, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "block");
        R invoke = interfaceC5506l.invoke(typedArray);
        typedArray.recycle();
        return invoke;
    }
}
