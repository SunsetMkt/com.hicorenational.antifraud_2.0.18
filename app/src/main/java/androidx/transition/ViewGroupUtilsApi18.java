package androidx.transition;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(18)
/* loaded from: classes.dex */
class ViewGroupUtilsApi18 {
    private static final String TAG = "ViewUtilsApi18";
    private static Method sSuppressLayoutMethod;
    private static boolean sSuppressLayoutMethodFetched;

    private ViewGroupUtilsApi18() {
    }

    private static void fetchSuppressLayoutMethod() {
        if (sSuppressLayoutMethodFetched) {
            return;
        }
        try {
            sSuppressLayoutMethod = ViewGroup.class.getDeclaredMethod("suppressLayout", Boolean.TYPE);
            sSuppressLayoutMethod.setAccessible(true);
        } catch (NoSuchMethodException unused) {
        }
        sSuppressLayoutMethodFetched = true;
    }

    static void suppressLayout(@NonNull ViewGroup viewGroup, boolean z) {
        fetchSuppressLayoutMethod();
        Method method = sSuppressLayoutMethod;
        if (method != null) {
            try {
                method.invoke(viewGroup, Boolean.valueOf(z));
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }
}
