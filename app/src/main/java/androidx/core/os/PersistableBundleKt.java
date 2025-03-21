package androidx.core.os;

import android.os.Build;
import android.os.PersistableBundle;
import androidx.annotation.RequiresApi;
import p286h.C5226e1;
import p286h.C5334i0;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p286h.p323z2.C5736h0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: PersistableBundle.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, m23546d2 = {"persistableBundleOf", "Landroid/os/PersistableBundle;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/os/PersistableBundle;", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class PersistableBundleKt {
    @RequiresApi(21)
    @InterfaceC5816d
    public static final PersistableBundle persistableBundleOf(@InterfaceC5816d C5334i0<String, ? extends Object>... c5334i0Arr) {
        C5544i0.m22546f(c5334i0Arr, "pairs");
        PersistableBundle persistableBundle = new PersistableBundle(c5334i0Arr.length);
        for (C5334i0<String, ? extends Object> c5334i0 : c5334i0Arr) {
            String component1 = c5334i0.component1();
            Object component2 = c5334i0.component2();
            if (component2 == null) {
                persistableBundle.putString(component1, null);
            } else if (component2 instanceof Boolean) {
                if (Build.VERSION.SDK_INT < 22) {
                    throw new IllegalArgumentException("Illegal value type boolean for key \"" + component1 + C5736h0.f20712a);
                }
                persistableBundle.putBoolean(component1, ((Boolean) component2).booleanValue());
            } else if (component2 instanceof Double) {
                persistableBundle.putDouble(component1, ((Number) component2).doubleValue());
            } else if (component2 instanceof Integer) {
                persistableBundle.putInt(component1, ((Number) component2).intValue());
            } else if (component2 instanceof Long) {
                persistableBundle.putLong(component1, ((Number) component2).longValue());
            } else if (component2 instanceof String) {
                persistableBundle.putString(component1, (String) component2);
            } else if (component2 instanceof boolean[]) {
                if (Build.VERSION.SDK_INT < 22) {
                    throw new IllegalArgumentException("Illegal value type boolean[] for key \"" + component1 + C5736h0.f20712a);
                }
                persistableBundle.putBooleanArray(component1, (boolean[]) component2);
            } else if (component2 instanceof double[]) {
                persistableBundle.putDoubleArray(component1, (double[]) component2);
            } else if (component2 instanceof int[]) {
                persistableBundle.putIntArray(component1, (int[]) component2);
            } else if (component2 instanceof long[]) {
                persistableBundle.putLongArray(component1, (long[]) component2);
            } else {
                if (!(component2 instanceof Object[])) {
                    throw new IllegalArgumentException("Illegal value type " + component2.getClass().getCanonicalName() + " for key \"" + component1 + C5736h0.f20712a);
                }
                Class<?> componentType = component2.getClass().getComponentType();
                if (!String.class.isAssignableFrom(componentType)) {
                    C5544i0.m22521a((Object) componentType, "componentType");
                    throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + component1 + C5736h0.f20712a);
                }
                if (component2 == null) {
                    throw new C5226e1("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                }
                persistableBundle.putStringArray(component1, (String[]) component2);
            }
        }
        return persistableBundle;
    }
}
