package androidx.core.content;

import android.content.ContentValues;
import p286h.C5334i0;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p286h.p323z2.C5736h0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: ContentValues.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\u0007¨\u0006\b"}, m23546d2 = {"contentValuesOf", "Landroid/content/ContentValues;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/content/ContentValues;", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class ContentValuesKt {
    @InterfaceC5816d
    public static final ContentValues contentValuesOf(@InterfaceC5816d C5334i0<String, ? extends Object>... c5334i0Arr) {
        C5544i0.m22546f(c5334i0Arr, "pairs");
        ContentValues contentValues = new ContentValues(c5334i0Arr.length);
        for (C5334i0<String, ? extends Object> c5334i0 : c5334i0Arr) {
            String component1 = c5334i0.component1();
            Object component2 = c5334i0.component2();
            if (component2 == null) {
                contentValues.putNull(component1);
            } else if (component2 instanceof String) {
                contentValues.put(component1, (String) component2);
            } else if (component2 instanceof Integer) {
                contentValues.put(component1, (Integer) component2);
            } else if (component2 instanceof Long) {
                contentValues.put(component1, (Long) component2);
            } else if (component2 instanceof Boolean) {
                contentValues.put(component1, (Boolean) component2);
            } else if (component2 instanceof Float) {
                contentValues.put(component1, (Float) component2);
            } else if (component2 instanceof Double) {
                contentValues.put(component1, (Double) component2);
            } else if (component2 instanceof byte[]) {
                contentValues.put(component1, (byte[]) component2);
            } else if (component2 instanceof Byte) {
                contentValues.put(component1, (Byte) component2);
            } else {
                if (!(component2 instanceof Short)) {
                    throw new IllegalArgumentException("Illegal value type " + component2.getClass().getCanonicalName() + " for key \"" + component1 + C5736h0.f20712a);
                }
                contentValues.put(component1, (Short) component2);
            }
        }
        return contentValues;
    }
}
