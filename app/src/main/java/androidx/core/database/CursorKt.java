package androidx.core.database;

import android.database.Cursor;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Cursor.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u00008\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b\u001a\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\u0007\u001a\u001c\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\n\u001a\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\f\u001a\u001c\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\u000f\u001a\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\u0012\u001a\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b¨\u0006\u0015"}, m23546d2 = {"getBlobOrNull", "", "Landroid/database/Cursor;", "index", "", "getDoubleOrNull", "", "(Landroid/database/Cursor;I)Ljava/lang/Double;", "getFloatOrNull", "", "(Landroid/database/Cursor;I)Ljava/lang/Float;", "getIntOrNull", "(Landroid/database/Cursor;I)Ljava/lang/Integer;", "getLongOrNull", "", "(Landroid/database/Cursor;I)Ljava/lang/Long;", "getShortOrNull", "", "(Landroid/database/Cursor;I)Ljava/lang/Short;", "getStringOrNull", "", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class CursorKt {
    @InterfaceC5817e
    public static final byte[] getBlobOrNull(@InterfaceC5816d Cursor cursor, int i2) {
        C5544i0.m22546f(cursor, "$receiver");
        if (cursor.isNull(i2)) {
            return null;
        }
        return cursor.getBlob(i2);
    }

    @InterfaceC5817e
    public static final Double getDoubleOrNull(@InterfaceC5816d Cursor cursor, int i2) {
        C5544i0.m22546f(cursor, "$receiver");
        if (cursor.isNull(i2)) {
            return null;
        }
        return Double.valueOf(cursor.getDouble(i2));
    }

    @InterfaceC5817e
    public static final Float getFloatOrNull(@InterfaceC5816d Cursor cursor, int i2) {
        C5544i0.m22546f(cursor, "$receiver");
        if (cursor.isNull(i2)) {
            return null;
        }
        return Float.valueOf(cursor.getFloat(i2));
    }

    @InterfaceC5817e
    public static final Integer getIntOrNull(@InterfaceC5816d Cursor cursor, int i2) {
        C5544i0.m22546f(cursor, "$receiver");
        if (cursor.isNull(i2)) {
            return null;
        }
        return Integer.valueOf(cursor.getInt(i2));
    }

    @InterfaceC5817e
    public static final Long getLongOrNull(@InterfaceC5816d Cursor cursor, int i2) {
        C5544i0.m22546f(cursor, "$receiver");
        if (cursor.isNull(i2)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i2));
    }

    @InterfaceC5817e
    public static final Short getShortOrNull(@InterfaceC5816d Cursor cursor, int i2) {
        C5544i0.m22546f(cursor, "$receiver");
        if (cursor.isNull(i2)) {
            return null;
        }
        return Short.valueOf(cursor.getShort(i2));
    }

    @InterfaceC5817e
    public static final String getStringOrNull(@InterfaceC5816d Cursor cursor, int i2) {
        C5544i0.m22546f(cursor, "$receiver");
        if (cursor.isNull(i2)) {
            return null;
        }
        return cursor.getString(i2);
    }
}
