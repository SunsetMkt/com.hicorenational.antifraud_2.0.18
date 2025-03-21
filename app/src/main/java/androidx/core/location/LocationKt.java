package androidx.core.location;

import android.location.Location;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Location.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\n\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0086\n¨\u0006\u0004"}, m23546d2 = {"component1", "", "Landroid/location/Location;", "component2", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class LocationKt {
    public static final double component1(@InterfaceC5816d Location location) {
        C5544i0.m22546f(location, "$receiver");
        return location.getLatitude();
    }

    public static final double component2(@InterfaceC5816d Location location) {
        C5544i0.m22546f(location, "$receiver");
        return location.getLongitude();
    }
}
