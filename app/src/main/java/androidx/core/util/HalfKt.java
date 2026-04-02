package androidx.core.util;

import android.util.Half;
import androidx.annotation.RequiresApi;
import i.q2.t.i0;
import i.y;
import j.c.a.d;

/* JADX INFO: compiled from: Half.kt */
/* JADX INFO: loaded from: classes.dex */
@y(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\u000e\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0004H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0005H\u0087\b\u00a8\u0006\u0006"}, d2 = {"toHalf", "Landroid/util/Half;", "", "", "", "", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
public final class HalfKt {
    @RequiresApi(26)
    @d
    public static final Half toHalf(short s) {
        Half halfValueOf = Half.valueOf(s);
        i0.a((Object) halfValueOf, "Half.valueOf(this)");
        return halfValueOf;
    }

    @RequiresApi(26)
    @d
    public static final Half toHalf(float f2) {
        Half halfValueOf = Half.valueOf(f2);
        i0.a((Object) halfValueOf, "Half.valueOf(this)");
        return halfValueOf;
    }

    @RequiresApi(26)
    @d
    public static final Half toHalf(@d String str) {
        i0.f(str, "$receiver");
        Half halfValueOf = Half.valueOf(str);
        i0.a((Object) halfValueOf, "Half.valueOf(this)");
        return halfValueOf;
    }

    @RequiresApi(26)
    @d
    public static final Half toHalf(double d2) {
        Half halfValueOf = Half.valueOf((float) d2);
        i0.a((Object) halfValueOf, "Half.valueOf(this)");
        return halfValueOf;
    }
}
