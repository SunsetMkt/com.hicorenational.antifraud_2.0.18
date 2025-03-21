package androidx.core.util;

import android.util.Half;
import androidx.annotation.RequiresApi;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Half.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\u000e\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0004H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0005H\u0087\b¨\u0006\u0006"}, m23546d2 = {"toHalf", "Landroid/util/Half;", "", "", "", "", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class HalfKt {
    @RequiresApi(26)
    @InterfaceC5816d
    public static final Half toHalf(short s) {
        Half valueOf = Half.valueOf(s);
        C5544i0.m22521a((Object) valueOf, "Half.valueOf(this)");
        return valueOf;
    }

    @RequiresApi(26)
    @InterfaceC5816d
    public static final Half toHalf(float f2) {
        Half valueOf = Half.valueOf(f2);
        C5544i0.m22521a((Object) valueOf, "Half.valueOf(this)");
        return valueOf;
    }

    @RequiresApi(26)
    @InterfaceC5816d
    public static final Half toHalf(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "$receiver");
        Half valueOf = Half.valueOf(str);
        C5544i0.m22521a((Object) valueOf, "Half.valueOf(this)");
        return valueOf;
    }

    @RequiresApi(26)
    @InterfaceC5816d
    public static final Half toHalf(double d2) {
        Half valueOf = Half.valueOf((float) d2);
        C5544i0.m22521a((Object) valueOf, "Half.valueOf(this)");
        return valueOf;
    }
}
