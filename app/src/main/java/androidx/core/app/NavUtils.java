package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.cloudwalk.libproject.Contants;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* loaded from: classes.dex */
public final class NavUtils {
    public static final String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";
    private static final String TAG = "NavUtils";

    private NavUtils() {
    }

    @Nullable
    public static Intent getParentActivityIntent(@NonNull Activity activity) {
        Intent parentActivityIntent;
        if (Build.VERSION.SDK_INT >= 16 && (parentActivityIntent = activity.getParentActivityIntent()) != null) {
            return parentActivityIntent;
        }
        String parentActivityName = getParentActivityName(activity);
        if (parentActivityName == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(activity, parentActivityName);
        try {
            return getParentActivityName(activity, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
        } catch (PackageManager.NameNotFoundException unused) {
            String str = "getParentActivityIntent: bad parentActivityName '" + parentActivityName + "' in manifest";
            return null;
        }
    }

    @Nullable
    public static String getParentActivityName(@NonNull Activity activity) {
        try {
            return getParentActivityName(activity, activity.getComponentName());
        } catch (PackageManager.NameNotFoundException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static void navigateUpFromSameTask(@NonNull Activity activity) {
        Intent parentActivityIntent = getParentActivityIntent(activity);
        if (parentActivityIntent != null) {
            navigateUpTo(activity, parentActivityIntent);
            return;
        }
        throw new IllegalArgumentException("Activity " + activity.getClass().getSimpleName() + " does not have a parent activity name specified. (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data>  element in your manifest?)");
    }

    public static void navigateUpTo(@NonNull Activity activity, @NonNull Intent intent) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.navigateUpTo(intent);
            return;
        }
        intent.addFlags(AbstractC1191a.f2487B1);
        activity.startActivity(intent);
        activity.finish();
    }

    public static boolean shouldUpRecreateTask(@NonNull Activity activity, @NonNull Intent intent) {
        if (Build.VERSION.SDK_INT >= 16) {
            return activity.shouldUpRecreateTask(intent);
        }
        String action = activity.getIntent().getAction();
        return (action == null || action.equals("android.intent.action.MAIN")) ? false : true;
    }

    @Nullable
    public static String getParentActivityName(@NonNull Context context, @NonNull ComponentName componentName) throws PackageManager.NameNotFoundException {
        String string;
        String str;
        PackageManager packageManager = context.getPackageManager();
        int i2 = Build.VERSION.SDK_INT;
        int i3 = Contants.PREVIEW_W;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 29) {
            i3 = 269222528;
        } else if (i4 >= 24) {
            i3 = 787072;
        }
        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, i3);
        if (Build.VERSION.SDK_INT >= 16 && (str = activityInfo.parentActivityName) != null) {
            return str;
        }
        if (activityInfo.metaData == null || (string = activityInfo.metaData.getString(PARENT_ACTIVITY)) == null) {
            return null;
        }
        if (string.charAt(0) != '.') {
            return string;
        }
        return context.getPackageName() + string;
    }

    @Nullable
    public static Intent getParentActivityIntent(@NonNull Context context, @NonNull Class<?> cls) throws PackageManager.NameNotFoundException {
        String parentActivityName = getParentActivityName(context, new ComponentName(context, cls));
        if (parentActivityName == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(context, parentActivityName);
        if (getParentActivityName(context, componentName) == null) {
            return Intent.makeMainActivity(componentName);
        }
        return new Intent().setComponent(componentName);
    }

    @Nullable
    public static Intent getParentActivityIntent(@NonNull Context context, @NonNull ComponentName componentName) throws PackageManager.NameNotFoundException {
        String parentActivityName = getParentActivityName(context, componentName);
        if (parentActivityName == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), parentActivityName);
        if (getParentActivityName(context, componentName2) == null) {
            return Intent.makeMainActivity(componentName2);
        }
        return new Intent().setComponent(componentName2);
    }
}
