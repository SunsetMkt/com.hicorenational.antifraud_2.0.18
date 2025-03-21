package p286h.p289g2;

import anet.channel.strategy.dispatch.DispatchConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p286h.C5218c1;
import p286h.C5239g1;
import p286h.C5334i0;
import p286h.C5354k1;
import p286h.C5468o1;
import p286h.C5619u1;
import p286h.InterfaceC5440n0;
import p286h.InterfaceC5610t0;
import p286h.p289g2.p290a2.C5245c;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p311t.C5544i0;
import p286h.p319v2.C5648q;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Arrays.kt */
/* renamed from: h.g2.p */
/* loaded from: classes2.dex */
class C5288p extends C5285o {
    @InterfaceC5816d
    /* renamed from: a */
    public static final <T, R> C5334i0<List<T>, List<R>> m20130a(@InterfaceC5816d C5334i0<? extends T, ? extends R>[] c5334i0Arr) {
        C5544i0.m22546f(c5334i0Arr, "$this$unzip");
        ArrayList arrayList = new ArrayList(c5334i0Arr.length);
        ArrayList arrayList2 = new ArrayList(c5334i0Arr.length);
        for (C5334i0<? extends T, ? extends R> c5334i0 : c5334i0Arr) {
            arrayList.add(c5334i0.getFirst());
            arrayList2.add(c5334i0.getSecond());
        }
        return C5218c1.m18838a(arrayList, arrayList2);
    }

    @InterfaceC5481e(name = "contentDeepToString")
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5440n0
    @InterfaceC5816d
    /* renamed from: c */
    public static final <T> String m20135c(@InterfaceC5816d T[] tArr) {
        int m23101b;
        C5544i0.m22546f(tArr, "$this$contentDeepToStringImpl");
        m23101b = C5648q.m23101b(tArr.length, 429496729);
        StringBuilder sb = new StringBuilder((m23101b * 5) + 2);
        m20133a(tArr, sb, new ArrayList());
        String sb2 = sb.toString();
        C5544i0.m22521a((Object) sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: d */
    private static final boolean m20136d(@InterfaceC5817e Object[] objArr) {
        if (objArr != null) {
            if (!(objArr.length == 0)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Incorrect types in method signature: <C:[Ljava/lang/Object;:TR;R:Ljava/lang/Object;>(TC;Lh/q2/s/a<+TR;>;)TR; */
    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    private static final Object m20131a(Object[] objArr, InterfaceC5495a interfaceC5495a) {
        return objArr.length == 0 ? interfaceC5495a.invoke() : objArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5481e(name = "contentDeepEquals")
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5440n0
    /* renamed from: a */
    public static final <T> boolean m20134a(@InterfaceC5816d T[] tArr, @InterfaceC5816d T[] tArr2) {
        boolean m19185a;
        boolean m19183a;
        boolean m19187a;
        boolean m19181a;
        C5544i0.m22546f(tArr, "$this$contentDeepEqualsImpl");
        C5544i0.m22546f(tArr2, DispatchConstants.OTHER);
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
                    if (!m20134a(objArr, objArr2)) {
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
                } else if ((objArr instanceof C5239g1) && (objArr2 instanceof C5239g1)) {
                    m19181a = C5245c.m19181a(((C5239g1) objArr).m18991c(), ((C5239g1) objArr2).m18991c());
                    if (!m19181a) {
                        return false;
                    }
                } else if ((objArr instanceof C5619u1) && (objArr2 instanceof C5619u1)) {
                    m19187a = C5245c.m19187a(((C5619u1) objArr).m22942c(), ((C5619u1) objArr2).m22942c());
                    if (!m19187a) {
                        return false;
                    }
                } else if ((objArr instanceof C5354k1) && (objArr2 instanceof C5354k1)) {
                    m19183a = C5245c.m19183a(((C5354k1) objArr).m21994c(), ((C5354k1) objArr2).m21994c());
                    if (!m19183a) {
                        return false;
                    }
                } else if ((objArr instanceof C5468o1) && (objArr2 instanceof C5468o1)) {
                    m19185a = C5245c.m19185a(((C5468o1) objArr).m22432c(), ((C5468o1) objArr2).m22432c());
                    if (!m19185a) {
                        return false;
                    }
                } else if (!C5544i0.m22531a(objArr, objArr2)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private static final <T> void m20133a(@InterfaceC5816d T[] tArr, StringBuilder sb, List<Object[]> list) {
        String m19431k;
        String m19430k;
        String m19432k;
        String m19429k;
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
                sb.append(AbstractC1191a.f2571h);
            } else if (objArr instanceof Object[]) {
                m20133a(objArr, sb, list);
            } else if (objArr instanceof byte[]) {
                String arrays = Arrays.toString((byte[]) objArr);
                C5544i0.m22521a((Object) arrays, "java.util.Arrays.toString(this)");
                sb.append(arrays);
            } else if (objArr instanceof short[]) {
                String arrays2 = Arrays.toString((short[]) objArr);
                C5544i0.m22521a((Object) arrays2, "java.util.Arrays.toString(this)");
                sb.append(arrays2);
            } else if (objArr instanceof int[]) {
                String arrays3 = Arrays.toString((int[]) objArr);
                C5544i0.m22521a((Object) arrays3, "java.util.Arrays.toString(this)");
                sb.append(arrays3);
            } else if (objArr instanceof long[]) {
                String arrays4 = Arrays.toString((long[]) objArr);
                C5544i0.m22521a((Object) arrays4, "java.util.Arrays.toString(this)");
                sb.append(arrays4);
            } else if (objArr instanceof float[]) {
                String arrays5 = Arrays.toString((float[]) objArr);
                C5544i0.m22521a((Object) arrays5, "java.util.Arrays.toString(this)");
                sb.append(arrays5);
            } else if (objArr instanceof double[]) {
                String arrays6 = Arrays.toString((double[]) objArr);
                C5544i0.m22521a((Object) arrays6, "java.util.Arrays.toString(this)");
                sb.append(arrays6);
            } else if (objArr instanceof char[]) {
                String arrays7 = Arrays.toString((char[]) objArr);
                C5544i0.m22521a((Object) arrays7, "java.util.Arrays.toString(this)");
                sb.append(arrays7);
            } else if (objArr instanceof boolean[]) {
                String arrays8 = Arrays.toString((boolean[]) objArr);
                C5544i0.m22521a((Object) arrays8, "java.util.Arrays.toString(this)");
                sb.append(arrays8);
            } else if (objArr instanceof C5239g1) {
                m19429k = C5245c.m19429k(((C5239g1) objArr).m18991c());
                sb.append(m19429k);
            } else if (objArr instanceof C5619u1) {
                m19432k = C5245c.m19432k(((C5619u1) objArr).m22942c());
                sb.append(m19432k);
            } else if (objArr instanceof C5354k1) {
                m19430k = C5245c.m19430k(((C5354k1) objArr).m21994c());
                sb.append(m19430k);
            } else if (objArr instanceof C5468o1) {
                m19431k = C5245c.m19431k(((C5468o1) objArr).m22432c());
                sb.append(m19431k);
            } else {
                sb.append(objArr.toString());
            }
        }
        sb.append(']');
        list.remove(C5315y.m21757a((List) list));
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> List<T> m20132a(@InterfaceC5816d T[][] tArr) {
        C5544i0.m22546f(tArr, "$this$flatten");
        int i2 = 0;
        for (T[] tArr2 : tArr) {
            i2 += tArr2.length;
        }
        ArrayList arrayList = new ArrayList(i2);
        for (T[] tArr3 : tArr) {
            C5253d0.m19667a((Collection) arrayList, (Object[]) tArr3);
        }
        return arrayList;
    }
}
