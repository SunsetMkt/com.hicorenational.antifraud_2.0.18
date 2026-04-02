package i.g2;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;

/* JADX INFO: compiled from: ArraysJVM.kt */
/* JADX INFO: loaded from: classes2.dex */
class o {
    @i.m2.f
    private static final String a(@j.c.a.d byte[] bArr, Charset charset) {
        return new String(bArr, charset);
    }

    @j.c.a.d
    public static final /* synthetic */ <T> T[] b(@j.c.a.e T[] tArr) {
        if (tArr != null) {
            return tArr;
        }
        i.q2.t.i0.a(0, "T?");
        return (T[]) new Object[0];
    }

    @j.c.a.d
    public static final /* synthetic */ <T> T[] a(@j.c.a.d Collection<? extends T> collection) {
        i.q2.t.i0.f(collection, "$this$toTypedArray");
        i.q2.t.i0.a(0, "T?");
        T[] tArr = (T[]) collection.toArray(new Object[0]);
        if (tArr != null) {
            return tArr;
        }
        throw new i.e1("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @j.c.a.d
    public static final <T> T[] a(@j.c.a.d T[] tArr, int i2) {
        i.q2.t.i0.f(tArr, "reference");
        Object objNewInstance = Array.newInstance(tArr.getClass().getComponentType(), i2);
        if (objNewInstance != null) {
            return (T[]) ((Object[]) objNewInstance);
        }
        throw new i.e1("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @i.t0(version = "1.3")
    public static final void a(int i2, int i3) {
        if (i2 <= i3) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is greater than size (" + i3 + ").");
    }

    @i.n0
    @i.q2.e(name = "contentDeepHashCode")
    @i.t0(version = "1.3")
    public static final <T> int a(@j.c.a.d T[] tArr) {
        i.q2.t.i0.f(tArr, "$this$contentDeepHashCodeImpl");
        return Arrays.deepHashCode(tArr);
    }
}
