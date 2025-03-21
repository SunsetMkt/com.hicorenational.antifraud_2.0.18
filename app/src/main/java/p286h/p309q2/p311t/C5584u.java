package p286h.p309q2.p311t;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import p286h.C5226e1;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p310s.InterfaceC5510p;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: CollectionToArray.kt */
@InterfaceC5481e(name = "CollectionToArray")
/* renamed from: h.q2.t.u */
/* loaded from: classes2.dex */
public final class C5584u {

    /* renamed from: a */
    private static final Object[] f20433a = new Object[0];

    /* renamed from: b */
    private static final int f20434b = 2147483645;

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object, java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* renamed from: a */
    private static final Object[] m22687a(Collection<?> collection, InterfaceC5495a<Object[]> interfaceC5495a, InterfaceC5506l<? super Integer, Object[]> interfaceC5506l, InterfaceC5510p<? super Object[], ? super Integer, Object[]> interfaceC5510p) {
        int size = collection.size();
        if (size == 0) {
            return interfaceC5495a.invoke();
        }
        Iterator<?> it = collection.iterator();
        if (!it.hasNext()) {
            return interfaceC5495a.invoke();
        }
        Object[] invoke = interfaceC5506l.invoke(Integer.valueOf(size));
        int i2 = 0;
        ?? r3 = invoke;
        while (true) {
            int i3 = i2 + 1;
            r3[i2] = it.next();
            if (i3 >= r3.length) {
                if (!it.hasNext()) {
                    return r3;
                }
                int i4 = ((i3 * 3) + 1) >>> 1;
                if (i4 <= i3) {
                    if (i3 >= f20434b) {
                        throw new OutOfMemoryError();
                    }
                    i4 = f20434b;
                }
                r3 = Arrays.copyOf((Object[]) r3, i4);
                C5544i0.m22521a((Object) r3, "Arrays.copyOf(result, newSize)");
            } else if (!it.hasNext()) {
                return interfaceC5510p.invoke(r3, Integer.valueOf(i3));
            }
            i2 = i3;
            r3 = r3;
        }
    }

    @InterfaceC5481e(name = "toArray")
    @InterfaceC5816d
    /* renamed from: a */
    public static final Object[] m22686a(@InterfaceC5816d Collection<?> collection) {
        C5544i0.m22546f(collection, "collection");
        int size = collection.size();
        if (size != 0) {
            Iterator<?> it = collection.iterator();
            if (it.hasNext()) {
                Object[] objArr = new Object[size];
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    objArr[i2] = it.next();
                    if (i3 >= objArr.length) {
                        if (!it.hasNext()) {
                            return objArr;
                        }
                        int i4 = ((i3 * 3) + 1) >>> 1;
                        if (i4 <= i3) {
                            if (i3 >= f20434b) {
                                throw new OutOfMemoryError();
                            }
                            i4 = f20434b;
                        }
                        objArr = Arrays.copyOf(objArr, i4);
                        C5544i0.m22521a((Object) objArr, "Arrays.copyOf(result, newSize)");
                    } else if (!it.hasNext()) {
                        Object[] copyOf = Arrays.copyOf(objArr, i3);
                        C5544i0.m22521a((Object) copyOf, "Arrays.copyOf(result, size)");
                        return copyOf;
                    }
                    i2 = i3;
                }
            }
        }
        return f20433a;
    }

    @InterfaceC5481e(name = "toArray")
    @InterfaceC5816d
    /* renamed from: a */
    public static final Object[] m22688a(@InterfaceC5816d Collection<?> collection, @InterfaceC5817e Object[] objArr) {
        Object[] objArr2;
        C5544i0.m22546f(collection, "collection");
        if (objArr != null) {
            int size = collection.size();
            int i2 = 0;
            if (size == 0) {
                if (objArr.length <= 0) {
                    return objArr;
                }
                objArr[0] = null;
                return objArr;
            }
            Iterator<?> it = collection.iterator();
            if (!it.hasNext()) {
                if (objArr.length <= 0) {
                    return objArr;
                }
                objArr[0] = null;
                return objArr;
            }
            if (size <= objArr.length) {
                objArr2 = objArr;
            } else {
                Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
                if (newInstance == null) {
                    throw new C5226e1("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                }
                objArr2 = (Object[]) newInstance;
            }
            while (true) {
                int i3 = i2 + 1;
                objArr2[i2] = it.next();
                if (i3 >= objArr2.length) {
                    if (!it.hasNext()) {
                        return objArr2;
                    }
                    int i4 = ((i3 * 3) + 1) >>> 1;
                    if (i4 <= i3) {
                        if (i3 >= f20434b) {
                            throw new OutOfMemoryError();
                        }
                        i4 = f20434b;
                    }
                    objArr2 = Arrays.copyOf(objArr2, i4);
                    C5544i0.m22521a((Object) objArr2, "Arrays.copyOf(result, newSize)");
                } else if (!it.hasNext()) {
                    if (objArr2 == objArr) {
                        objArr[i3] = null;
                        return objArr;
                    }
                    Object[] copyOf = Arrays.copyOf(objArr2, i3);
                    C5544i0.m22521a((Object) copyOf, "Arrays.copyOf(result, size)");
                    return copyOf;
                }
                i2 = i3;
            }
        } else {
            throw new NullPointerException();
        }
    }
}
