package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class ActionBarDrawerToggleHoneycomb {
    private static final String TAG = "ActionBarDrawerToggleHC";
    private static final int[] THEME_ATTRS = {R.attr.homeAsUpIndicator};

    static class SetIndicatorInfo {
        public Method setHomeActionContentDescription;
        public Method setHomeAsUpIndicator;
        public ImageView upIndicatorView;

        SetIndicatorInfo(Activity activity) {
            try {
                this.setHomeAsUpIndicator = android.app.ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", Drawable.class);
                this.setHomeActionContentDescription = android.app.ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", Integer.TYPE);
            } catch (NoSuchMethodException unused) {
                View findViewById = activity.findViewById(R.id.home);
                if (findViewById == null) {
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
                if (viewGroup.getChildCount() != 2) {
                    return;
                }
                View childAt = viewGroup.getChildAt(0);
                View childAt2 = childAt.getId() != 16908332 ? childAt : viewGroup.getChildAt(1);
                if (childAt2 instanceof ImageView) {
                    this.upIndicatorView = (ImageView) childAt2;
                }
            }
        }
    }

    private ActionBarDrawerToggleHoneycomb() {
    }

    public static Drawable getThemeUpIndicator(Activity activity) {
        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(THEME_ATTRS);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }

    public static SetIndicatorInfo setActionBarDescription(SetIndicatorInfo setIndicatorInfo, Activity activity, int i2) {
        if (setIndicatorInfo == null) {
            setIndicatorInfo = new SetIndicatorInfo(activity);
        }
        if (setIndicatorInfo.setHomeAsUpIndicator != null) {
            try {
                android.app.ActionBar actionBar = activity.getActionBar();
                setIndicatorInfo.setHomeActionContentDescription.invoke(actionBar, Integer.valueOf(i2));
                if (Build.VERSION.SDK_INT <= 19) {
                    actionBar.setSubtitle(actionBar.getSubtitle());
                }
            } catch (Exception unused) {
            }
        }
        return setIndicatorInfo;
    }

    public static SetIndicatorInfo setActionBarUpIndicator(Activity activity, Drawable drawable, int i2) {
        SetIndicatorInfo setIndicatorInfo = new SetIndicatorInfo(activity);
        if (setIndicatorInfo.setHomeAsUpIndicator != null) {
            try {
                android.app.ActionBar actionBar = activity.getActionBar();
                setIndicatorInfo.setHomeAsUpIndicator.invoke(actionBar, drawable);
                setIndicatorInfo.setHomeActionContentDescription.invoke(actionBar, Integer.valueOf(i2));
            } catch (Exception unused) {
            }
        } else {
            ImageView imageView = setIndicatorInfo.upIndicatorView;
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
            }
        }
        return setIndicatorInfo;
    }
}
