package p286h.p289g2;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import p286h.C5226e1;
import p286h.InterfaceC5440n0;
import p286h.InterfaceC5610t0;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: ArraysJVM.kt */
/* renamed from: h.g2.o */
/* loaded from: classes2.dex */
class C5285o {
    @InterfaceC5426f
    /* renamed from: a */
    private static final String m20124a(@InterfaceC5816d byte[] bArr, Charset charset) {
        return new String(bArr, charset);
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final /* synthetic */ <T> T[] m20128b(@InterfaceC5817e T[] tArr) {
        if (tArr != null) {
            return tArr;
        }
        C5544i0.m22518a(0, "T?");
        return (T[]) new Object[0];
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final /* synthetic */ <T> T[] m20126a(@InterfaceC5816d Collection<? extends T> collection) {
        C5544i0.m22546f(collection, "$this$toTypedArray");
        C5544i0.m22518a(0, "T?");
        T[] tArr = (T[]) collection.toArray(new Object[0]);
        if (tArr != null) {
            return tArr;
        }
        throw new C5226e1("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> T[] m20127a(@InterfaceC5816d T[] tArr, int i2) {
        C5544i0.m22546f(tArr, "reference");
        Object newInstance = Array.newInstance(tArr.getClass().getComponentType(), i2);
        if (newInstance != null) {
            return (T[]) ((Object[]) newInstance);
        }
        throw new C5226e1("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    public static final void m20125a(int i2, int i3) {
        if (i2 <= i3) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is greater than size (" + i3 + ").");
    }

    @InterfaceC5481e(name = "contentDeepHashCode")
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5440n0
    /* renamed from: a */
    public static final <T> int m20123a(@InterfaceC5816d T[] tArr) {
        C5544i0.m22546f(tArr, "$this$contentDeepHashCodeImpl");
        return Arrays.deepHashCode(tArr);
    }
}
