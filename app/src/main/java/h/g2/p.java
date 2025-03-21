package h.g2;

import anet.channel.strategy.dispatch.DispatchConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* compiled from: Arrays.kt */
/* loaded from: classes2.dex */
class p extends o {
    @i.c.a.d
    public static final <T, R> h.i0<List<T>, List<R>> a(@i.c.a.d h.i0<? extends T, ? extends R>[] i0VarArr) {
        h.q2.t.i0.f(i0VarArr, "$this$unzip");
        ArrayList arrayList = new ArrayList(i0VarArr.length);
        ArrayList arrayList2 = new ArrayList(i0VarArr.length);
        for (h.i0<? extends T, ? extends R> i0Var : i0VarArr) {
            arrayList.add(i0Var.getFirst());
            arrayList2.add(i0Var.getSecond());
        }
        return h.c1.a(arrayList, arrayList2);
    }

    @h.q2.e(name = "contentDeepToString")
    @h.t0(version = "1.3")
    @h.n0
    @i.c.a.d
    public static final <T> String c(@i.c.a.d T[] tArr) {
        int b2;
        h.q2.t.i0.f(tArr, "$this$contentDeepToStringImpl");
        b2 = h.v2.q.b(tArr.length, 429496729);
        StringBuilder sb = new StringBuilder((b2 * 5) + 2);
        a(tArr, sb, new ArrayList());
        String sb2 = sb.toString();
        h.q2.t.i0.a((Object) sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @h.m2.f
    @h.t0(version = "1.3")
    private static final boolean d(@i.c.a.e Object[] objArr) {
        if (objArr != null) {
            if (!(objArr.length == 0)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Incorrect types in method signature: <C:[Ljava/lang/Object;:TR;R:Ljava/lang/Object;>(TC;Lh/q2/s/a<+TR;>;)TR; */
    @h.m2.f
    @h.t0(version = "1.3")
    private static final Object a(Object[] objArr, h.q2.s.a aVar) {
        return objArr.length == 0 ? aVar.invoke() : objArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.q2.e(name = "contentDeepEquals")
    @h.t0(version = "1.3")
    @h.n0
    public static final <T> boolean a(@i.c.a.d T[] tArr, @i.c.a.d T[] tArr2) {
        boolean a2;
        boolean a3;
        boolean a4;
        boolean a5;
        h.q2.t.i0.f(tArr, "$this$contentDeepEqualsImpl");
        h.q2.t.i0.f(tArr2, DispatchConstants.OTHER);
        if (tArr == tArr2) {
            return true;
        }
        if (tArr.length != tArr2.length) {
            return false;
        }
        int length = tArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            Object[] objArr = tArr[i2];
            Object[] objArr2 = tArr2[i2];
            if (objArr != objArr2) {
                if (objArr == 0 || objArr2 == 0) {
                    return false;
                }
                if ((objArr instanceof Object[]) && (objArr2 instanceof Object[])) {
                    if (!a(objArr, objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof byte[]) && (objArr2 instanceof byte[])) {
                    if (!Arrays.equals((byte[]) objArr, (byte[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof short[]) && (objArr2 instanceof short[])) {
                    if (!Arrays.equals((short[]) objArr, (short[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof int[]) && (objArr2 instanceof int[])) {
                    if (!Arrays.equals((int[]) objArr, (int[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof long[]) && (objArr2 instanceof long[])) {
                    if (!Arrays.equals((long[]) objArr, (long[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof float[]) && (objArr2 instanceof float[])) {
                    if (!Arrays.equals((float[]) objArr, (float[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof double[]) && (objArr2 instanceof double[])) {
                    if (!Arrays.equals((double[]) objArr, (double[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof char[]) && (objArr2 instanceof char[])) {
                    if (!Arrays.equals((char[]) objArr, (char[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof boolean[]) && (objArr2 instanceof boolean[])) {
                    if (!Arrays.equals((boolean[]) objArr, (boolean[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof h.g1) && (objArr2 instanceof h.g1)) {
                    a5 = h.g2.a2.c.a(((h.g1) objArr).c(), ((h.g1) objArr2).c());
                    if (!a5) {
                        return false;
                    }
                } else if ((objArr instanceof h.u1) && (objArr2 instanceof h.u1)) {
                    a4 = h.g2.a2.c.a(((h.u1) objArr).c(), ((h.u1) objArr2).c());
                    if (!a4) {
                        return false;
                    }
                } else if ((objArr instanceof h.k1) && (objArr2 instanceof h.k1)) {
                    a3 = h.g2.a2.c.a(((h.k1) objArr).c(), ((h.k1) objArr2).c());
                    if (!a3) {
                        return false;
                    }
                } else if ((objArr instanceof h.o1) && (objArr2 instanceof h.o1)) {
                    a2 = h.g2.a2.c.a(((h.o1) objArr).c(), ((h.o1) objArr2).c());
                    if (!a2) {
                        return false;
                    }
                } else if (!h.q2.t.i0.a(objArr, objArr2)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> void a(@i.c.a.d T[] tArr, StringBuilder sb, List<Object[]> list) {
        String k2;
        String k3;
        String k4;
        String k5;
        if (list.contains(tArr)) {
            sb.append("[...]");
            return;
        }
        list.add(tArr);
        sb.append('[');
        int length = tArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(", ");
            }
            Object[] objArr = tArr[i2];
            if (objArr == 0) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else if (objArr instanceof Object[]) {
                a(objArr, sb, list);
            } else if (objArr instanceof byte[]) {
                String arrays = Arrays.toString((byte[]) objArr);
                h.q2.t.i0.a((Object) arrays, "java.util.Arrays.toString(this)");
                sb.append(arrays);
            } else if (objArr instanceof short[]) {
                String arrays2 = Arrays.toString((short[]) objArr);
                h.q2.t.i0.a((Object) arrays2, "java.util.Arrays.toString(this)");
                sb.append(arrays2);
            } else if (objArr instanceof int[]) {
                String arrays3 = Arrays.toString((int[]) objArr);
                h.q2.t.i0.a((Object) arrays3, "java.util.Arrays.toString(this)");
                sb.append(arrays3);
            } else if (objArr instanceof long[]) {
                String arrays4 = Arrays.toString((long[]) objArr);
                h.q2.t.i0.a((Object) arrays4, "java.util.Arrays.toString(this)");
                sb.append(arrays4);
            } else if (objArr instanceof float[]) {
                String arrays5 = Arrays.toString((float[]) objArr);
                h.q2.t.i0.a((Object) arrays5, "java.util.Arrays.toString(this)");
                sb.append(arrays5);
            } else if (objArr instanceof double[]) {
                String arrays6 = Arrays.toString((double[]) objArr);
                h.q2.t.i0.a((Object) arrays6, "java.util.Arrays.toString(this)");
                sb.append(arrays6);
            } else if (objArr instanceof char[]) {
                String arrays7 = Arrays.toString((char[]) objArr);
                h.q2.t.i0.a((Object) arrays7, "java.util.Arrays.toString(this)");
                sb.append(arrays7);
            } else if (objArr instanceof boolean[]) {
                String arrays8 = Arrays.toString((boolean[]) objArr);
                h.q2.t.i0.a((Object) arrays8, "java.util.Arrays.toString(this)");
                sb.append(arrays8);
            } else if (objArr instanceof h.g1) {
                k5 = h.g2.a2.c.k(((h.g1) objArr).c());
                sb.append(k5);
            } else if (objArr instanceof h.u1) {
                k4 = h.g2.a2.c.k(((h.u1) objArr).c());
                sb.append(k4);
            } else if (objArr instanceof h.k1) {
                k3 = h.g2.a2.c.k(((h.k1) objArr).c());
                sb.append(k3);
            } else if (objArr instanceof h.o1) {
                k2 = h.g2.a2.c.k(((h.o1) objArr).c());
                sb.append(k2);
            } else {
                sb.append(objArr.toString());
            }
        }
        sb.append(']');
        list.remove(y.a((List) list));
    }

    @i.c.a.d
    public static final <T> List<T> a(@i.c.a.d T[][] tArr) {
        h.q2.t.i0.f(tArr, "$this$flatten");
        int i2 = 0;
        for (T[] tArr2 : tArr) {
            i2 += tArr2.length;
        }
        ArrayList arrayList = new ArrayList(i2);
        for (T[] tArr3 : tArr) {
            d0.a((Collection) arrayList, (Object[]) tArr3);
        }
        return arrayList;
    }
}
