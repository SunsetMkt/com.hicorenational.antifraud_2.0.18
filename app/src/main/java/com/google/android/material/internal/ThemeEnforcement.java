package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.C1921R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class ThemeEnforcement {
    private static final String APPCOMPAT_THEME_NAME = "Theme.AppCompat";
    private static final String MATERIAL_THEME_NAME = "Theme.MaterialComponents";
    private static final int[] APPCOMPAT_CHECK_ATTRS = {C1921R.attr.colorPrimary};
    private static final int[] MATERIAL_CHECK_ATTRS = {C1921R.attr.colorSecondary};

    private ThemeEnforcement() {
    }

    public static void checkAppCompatTheme(Context context) {
        checkTheme(context, APPCOMPAT_CHECK_ATTRS, APPCOMPAT_THEME_NAME);
    }

    private static void checkCompatibleTheme(Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1921R.styleable.ThemeEnforcement, i2, i3);
        boolean z = obtainStyledAttributes.getBoolean(C1921R.styleable.ThemeEnforcement_enforceMaterialTheme, false);
        obtainStyledAttributes.recycle();
        if (z) {
            checkMaterialTheme(context);
        }
        checkAppCompatTheme(context);
    }

    public static void checkMaterialTheme(Context context) {
        checkTheme(context, MATERIAL_CHECK_ATTRS, MATERIAL_THEME_NAME);
    }

    private static void checkTextAppearance(Context context, AttributeSet attributeSet, @StyleableRes int[] iArr, @AttrRes int i2, @StyleRes int i3, @StyleableRes int... iArr2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1921R.styleable.ThemeEnforcement, i2, i3);
        if (!obtainStyledAttributes.getBoolean(C1921R.styleable.ThemeEnforcement_enforceTextAppearance, false)) {
            obtainStyledAttributes.recycle();
            return;
        }
        boolean isCustomTextAppearanceValid = (iArr2 == null || iArr2.length == 0) ? obtainStyledAttributes.getResourceId(C1921R.styleable.ThemeEnforcement_android_textAppearance, -1) != -1 : isCustomTextAppearanceValid(context, attributeSet, iArr, i2, i3, iArr2);
        obtainStyledAttributes.recycle();
        if (!isCustomTextAppearanceValid) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    private static void checkTheme(Context context, int[] iArr, String str) {
        if (isTheme(context, iArr)) {
            return;
        }
        throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
    }

    public static boolean isAppCompatTheme(Context context) {
        return isTheme(context, APPCOMPAT_CHECK_ATTRS);
    }

    private static boolean isCustomTextAppearanceValid(Context context, AttributeSet attributeSet, @StyleableRes int[] iArr, @AttrRes int i2, @StyleRes int i3, @StyleableRes int... iArr2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        for (int i4 : iArr2) {
            if (obtainStyledAttributes.getResourceId(i4, -1) == -1) {
                obtainStyledAttributes.recycle();
                return false;
            }
        }
        obtainStyledAttributes.recycle();
        return true;
    }

    public static boolean isMaterialTheme(Context context) {
        return isTheme(context, MATERIAL_CHECK_ATTRS);
    }

    private static boolean isTheme(Context context, int[] iArr) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        boolean hasValue = obtainStyledAttributes.hasValue(0);
        obtainStyledAttributes.recycle();
        return hasValue;
    }

    public static TypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, @StyleableRes int[] iArr, @AttrRes int i2, @StyleRes int i3, @StyleableRes int... iArr2) {
        checkCompatibleTheme(context, attributeSet, i2, i3);
        checkTextAppearance(context, attributeSet, iArr, i2, i3, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
    }

    public static TintTypedArray obtainTintedStyledAttributes(Context context, AttributeSet attributeSet, @StyleableRes int[] iArr, @AttrRes int i2, @StyleRes int i3, @StyleableRes int... iArr2) {
        checkCompatibleTheme(context, attributeSet, i2, i3);
        checkTextAppearance(context, attributeSet, iArr, i2, i3, iArr2);
        return TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i2, i3);
    }
}
