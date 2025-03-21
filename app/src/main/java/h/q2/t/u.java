package h.q2.t;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: CollectionToArray.kt */
@h.q2.e(name = "CollectionToArray")
/* loaded from: classes2.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    private static final Object[] f16446a = new Object[0];

    /* renamed from: b, reason: collision with root package name */
    private static final int f16447b = 2147483645;

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object, java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    private static final Object[] a(Collection<?> collection, h.q2.s.a<Object[]> aVar, h.q2.s.l<? super Integer, Object[]> lVar, h.q2.s.p<? super Object[], ? super Integer, Object[]> pVar) {
        int size = collection.size();
        if (size == 0) {
            return aVar.invoke();
        }
        Iterator<?> it = collection.iterator();
        if (!it.hasNext()) {
            return aVar.invoke();
        }
        Object[] invoke = lVar.invoke(Integer.valueOf(size));
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
                    if (i3 >= f16447b) {
                        throw new OutOfMemoryError();
                    }
                    i4 = f16447b;
                }
                r3 = Arrays.copyOf((Object[]) r3, i4);
                i0.a((Object) r3, "Arrays.copyOf(result, newSize)");
            } else if (!it.hasNext()) {
                return pVar.invoke(r3, Integer.valueOf(i3));
            }
            i2 = i3;
            r3 = r3;
        }
    }

    @h.q2.e(name = "toArray")
    @i.c.a.d
    public static final Object[] a(@i.c.a.d Collection<?> collection) {
        i0.f(collection, "collection");
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
                            if (i3 >= f16447b) {
                                throw new OutOfMemoryError();
                            }
                            i4 = f16447b;
                        }
                        objArr = Arrays.copyOf(objArr, i4);
                        i0.a((Object) objArr, "Arrays.copyOf(result, newSize)");
                    } else if (!it.hasNext()) {
                        Object[] copyOf = Arrays.copyOf(objArr, i3);
                        i0.a((Object) copyOf, "Arrays.copyOf(result, size)");
                        return copyOf;
                    }
                    i2 = i3;
                }
            }
        }
        return f16446a;
    }

    @h.q2.e(name = "toArray")
    @i.c.a.d
    public static final Object[] a(@i.c.a.d Collection<?> collection, @i.c.a.e Object[] objArr) {
        Object[] objArr2;
        i0.f(collection, "collection");
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
                    throw new h.e1("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
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
                        if (i3 >= f16447b) {
                            throw new OutOfMemoryError();
                        }
                        i4 = f16447b;
                    }
                    objArr2 = Arrays.copyOf(objArr2, i4);
                    i0.a((Object) objArr2, "Arrays.copyOf(result, newSize)");
                } else if (!it.hasNext()) {
                    if (objArr2 == objArr) {
                        objArr[i3] = null;
                        return objArr;
                    }
                    Object[] copyOf = Arrays.copyOf(objArr2, i3);
                    i0.a((Object) copyOf, "Arrays.copyOf(result, size)");
                    return copyOf;
                }
                i2 = i3;
            }
        } else {
            throw new NullPointerException();
        }
    }
}
