package com.luck.picture.lib.tools;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

/* loaded from: classes.dex */
public class AttrsUtils {
    public static boolean getTypeValueBoolean(Context context, int i2) {
        try {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().resourceId, new int[]{i2});
            boolean z = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
            return z;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static int getTypeValueColor(Context context, int i2) {
        try {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().resourceId, new int[]{i2});
            int color = obtainStyledAttributes.getColor(0, 0);
            obtainStyledAttributes.recycle();
            return color;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static Drawable getTypeValueDrawable(Context context, int i2) {
        try {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().resourceId, new int[]{i2});
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
