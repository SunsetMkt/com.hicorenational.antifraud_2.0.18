package androidx.core.util;

import android.util.Size;
import android.util.SizeF;
import androidx.annotation.RequiresApi;
import i.q2.t.i0;
import i.y;
import j.c.a.d;

/* JADX INFO: compiled from: Size.kt */
/* JADX INFO: loaded from: classes.dex */
@y(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\n\u001a\r\u0010\u0000\u001a\u00020\u0003*\u00020\u0004H\u0087\n\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0087\n\u001a\r\u0010\u0005\u001a\u00020\u0003*\u00020\u0004H\u0087\n\u00a8\u0006\u0006"}, d2 = {"component1", "", "Landroid/util/Size;", "", "Landroid/util/SizeF;", "component2", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
public final class SizeKt {
    @RequiresApi(21)
    public static final int component1(@d Size size) {
        i0.f(size, "$receiver");
        return size.getWidth();
    }

    @RequiresApi(21)
    public static final int component2(@d Size size) {
        i0.f(size, "$receiver");
        return size.getHeight();
    }

    @RequiresApi(21)
    public static final float component1(@d SizeF sizeF) {
        i0.f(sizeF, "$receiver");
        return sizeF.getWidth();
    }

    @RequiresApi(21)
    public static final float component2(@d SizeF sizeF) {
        i0.f(sizeF, "$receiver");
        return sizeF.getHeight();
    }
}
