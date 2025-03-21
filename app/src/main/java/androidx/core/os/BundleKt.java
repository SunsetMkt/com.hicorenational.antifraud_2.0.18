package androidx.core.os;

import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import java.io.Serializable;
import p286h.C5226e1;
import p286h.C5334i0;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p286h.p323z2.C5736h0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Bundle.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\u0007¨\u0006\b"}, m23546d2 = {"bundleOf", "Landroid/os/Bundle;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/os/Bundle;", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class BundleKt {
    @InterfaceC5816d
    public static final Bundle bundleOf(@InterfaceC5816d C5334i0<String, ? extends Object>... c5334i0Arr) {
        C5544i0.m22546f(c5334i0Arr, "pairs");
        Bundle bundle = new Bundle(c5334i0Arr.length);
        for (C5334i0<String, ? extends Object> c5334i0 : c5334i0Arr) {
            String component1 = c5334i0.component1();
            Object component2 = c5334i0.component2();
            if (component2 == null) {
                bundle.putString(component1, null);
            } else if (component2 instanceof Boolean) {
                bundle.putBoolean(component1, ((Boolean) component2).booleanValue());
            } else if (component2 instanceof Byte) {
                bundle.putByte(component1, ((Number) component2).byteValue());
            } else if (component2 instanceof Character) {
                bundle.putChar(component1, ((Character) component2).charValue());
            } else if (component2 instanceof Double) {
                bundle.putDouble(component1, ((Number) component2).doubleValue());
            } else if (component2 instanceof Float) {
                bundle.putFloat(component1, ((Number) component2).floatValue());
            } else if (component2 instanceof Integer) {
                bundle.putInt(component1, ((Number) component2).intValue());
            } else if (component2 instanceof Long) {
                bundle.putLong(component1, ((Number) component2).longValue());
            } else if (component2 instanceof Short) {
                bundle.putShort(component1, ((Number) component2).shortValue());
            } else if (component2 instanceof Bundle) {
                bundle.putBundle(component1, (Bundle) component2);
            } else if (component2 instanceof CharSequence) {
                bundle.putCharSequence(component1, (CharSequence) component2);
            } else if (component2 instanceof Parcelable) {
                bundle.putParcelable(component1, (Parcelable) component2);
            } else if (component2 instanceof boolean[]) {
                bundle.putBooleanArray(component1, (boolean[]) component2);
            } else if (component2 instanceof byte[]) {
                bundle.putByteArray(component1, (byte[]) component2);
            } else if (component2 instanceof char[]) {
                bundle.putCharArray(component1, (char[]) component2);
            } else if (component2 instanceof double[]) {
                bundle.putDoubleArray(component1, (double[]) component2);
            } else if (component2 instanceof float[]) {
                bundle.putFloatArray(component1, (float[]) component2);
            } else if (component2 instanceof int[]) {
                bundle.putIntArray(component1, (int[]) component2);
            } else if (component2 instanceof long[]) {
                bundle.putLongArray(component1, (long[]) component2);
            } else if (component2 instanceof short[]) {
                bundle.putShortArray(component1, (short[]) component2);
            } else if (component2 instanceof Object[]) {
                Class<?> componentType = component2.getClass().getComponentType();
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    if (component2 == null) {
                        throw new C5226e1("null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
                    }
                    bundle.putParcelableArray(component1, (Parcelable[]) component2);
                } else if (String.class.isAssignableFrom(componentType)) {
                    if (component2 == null) {
                        throw new C5226e1("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                    }
                    bundle.putStringArray(component1, (String[]) component2);
                } else if (CharSequence.class.isAssignableFrom(componentType)) {
                    if (component2 == null) {
                        throw new C5226e1("null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
                    }
                    bundle.putCharSequenceArray(component1, (CharSequence[]) component2);
                } else {
                    if (!Serializable.class.isAssignableFrom(componentType)) {
                        C5544i0.m22521a((Object) componentType, "componentType");
                        throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + component1 + C5736h0.f20712a);
                    }
                    bundle.putSerializable(component1, (Serializable) component2);
                }
            } else if (component2 instanceof Serializable) {
                bundle.putSerializable(component1, (Serializable) component2);
            } else if (Build.VERSION.SDK_INT >= 18 && (component2 instanceof Binder)) {
                bundle.putBinder(component1, (IBinder) component2);
            } else if (Build.VERSION.SDK_INT >= 21 && (component2 instanceof Size)) {
                bundle.putSize(component1, (Size) component2);
            } else {
                if (Build.VERSION.SDK_INT < 21 || !(component2 instanceof SizeF)) {
                    throw new IllegalArgumentException("Illegal value type " + component2.getClass().getCanonicalName() + " for key \"" + component1 + C5736h0.f20712a);
                }
                bundle.putSizeF(component1, (SizeF) component2);
            }
        }
        return bundle;
    }
}
