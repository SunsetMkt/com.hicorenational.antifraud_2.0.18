package com.umeng.analytics.pro;

import androidx.core.app.FrameMetricsAggregator;
import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: TBaseHelper.java */
/* renamed from: com.umeng.analytics.pro.br */
/* loaded from: classes2.dex */
public final class C3361br {

    /* renamed from: a */
    private static final Comparator f11757a = new a();

    /* compiled from: TBaseHelper.java */
    /* renamed from: com.umeng.analytics.pro.br$a */
    private static class a implements Comparator {
        private a() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (obj == null && obj2 == null) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            return obj instanceof List ? C3361br.m11041a((List) obj, (List) obj2) : obj instanceof Set ? C3361br.m11043a((Set) obj, (Set) obj2) : obj instanceof Map ? C3361br.m11042a((Map) obj, (Map) obj2) : obj instanceof byte[] ? C3361br.m11046a((byte[]) obj, (byte[]) obj2) : C3361br.m11037a((Comparable) obj, (Comparable) obj2);
        }
    }

    private C3361br() {
    }

    /* renamed from: a */
    public static int m11033a(byte b2, byte b3) {
        if (b2 < b3) {
            return -1;
        }
        return b3 < b2 ? 1 : 0;
    }

    /* renamed from: a */
    public static int m11034a(double d2, double d3) {
        if (d2 < d3) {
            return -1;
        }
        return d3 < d2 ? 1 : 0;
    }

    /* renamed from: a */
    public static int m11035a(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i3 < i2 ? 1 : 0;
    }

    /* renamed from: a */
    public static int m11036a(long j2, long j3) {
        if (j2 < j3) {
            return -1;
        }
        return j3 < j2 ? 1 : 0;
    }

    /* renamed from: a */
    public static int m11038a(Object obj, Object obj2) {
        if (obj instanceof Comparable) {
            return m11037a((Comparable) obj, (Comparable) obj2);
        }
        if (obj instanceof List) {
            return m11041a((List) obj, (List) obj2);
        }
        if (obj instanceof Set) {
            return m11043a((Set) obj, (Set) obj2);
        }
        if (obj instanceof Map) {
            return m11042a((Map) obj, (Map) obj2);
        }
        if (obj instanceof byte[]) {
            return m11046a((byte[]) obj, (byte[]) obj2);
        }
        throw new IllegalArgumentException("Cannot compare objects of type " + obj.getClass());
    }

    /* renamed from: a */
    public static int m11044a(short s, short s2) {
        if (s < s2) {
            return -1;
        }
        return s2 < s ? 1 : 0;
    }

    /* renamed from: b */
    public static boolean m11051b(ByteBuffer byteBuffer) {
        return byteBuffer.hasArray() && byteBuffer.position() == 0 && byteBuffer.arrayOffset() == 0 && byteBuffer.remaining() == byteBuffer.capacity();
    }

    /* renamed from: c */
    public static ByteBuffer m11052c(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        return m11051b(byteBuffer) ? byteBuffer : ByteBuffer.wrap(m11049a(byteBuffer));
    }

    /* renamed from: d */
    public static ByteBuffer m11053d(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        ByteBuffer wrap = ByteBuffer.wrap(new byte[byteBuffer.remaining()]);
        if (byteBuffer.hasArray()) {
            System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), wrap.array(), 0, byteBuffer.remaining());
        } else {
            byteBuffer.slice().get(wrap.array());
        }
        return wrap;
    }

    /* renamed from: a */
    public static int m11045a(boolean z, boolean z2) {
        return Boolean.valueOf(z).compareTo(Boolean.valueOf(z2));
    }

    /* renamed from: a */
    public static int m11039a(String str, String str2) {
        return str.compareTo(str2);
    }

    /* renamed from: a */
    public static int m11046a(byte[] bArr, byte[] bArr2) {
        int m11035a = m11035a(bArr.length, bArr2.length);
        if (m11035a != 0) {
            return m11035a;
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int m11033a = m11033a(bArr[i2], bArr2[i2]);
            if (m11033a != 0) {
                return m11033a;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static int m11037a(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    /* renamed from: a */
    public static int m11041a(List list, List list2) {
        int m11035a = m11035a(list.size(), list2.size());
        if (m11035a != 0) {
            return m11035a;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            int compare = f11757a.compare(list.get(i2), list2.get(i2));
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static int m11043a(Set set, Set set2) {
        int m11035a = m11035a(set.size(), set2.size());
        if (m11035a != 0) {
            return m11035a;
        }
        TreeSet treeSet = new TreeSet(f11757a);
        treeSet.addAll(set);
        TreeSet treeSet2 = new TreeSet(f11757a);
        treeSet2.addAll(set2);
        Iterator it = treeSet.iterator();
        Iterator it2 = treeSet2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            int compare = f11757a.compare(it.next(), it2.next());
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static int m11042a(Map map, Map map2) {
        int m11035a = m11035a(map.size(), map2.size());
        if (m11035a != 0) {
            return m11035a;
        }
        TreeMap treeMap = new TreeMap(f11757a);
        treeMap.putAll(map);
        Iterator it = treeMap.entrySet().iterator();
        TreeMap treeMap2 = new TreeMap(f11757a);
        treeMap2.putAll(map2);
        Iterator it2 = treeMap2.entrySet().iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Map.Entry entry2 = (Map.Entry) it2.next();
            int compare = f11757a.compare(entry.getKey(), entry2.getKey());
            if (compare != 0) {
                return compare;
            }
            int compare2 = f11757a.compare(entry.getValue(), entry2.getValue());
            if (compare2 != 0) {
                return compare2;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static void m11048a(ByteBuffer byteBuffer, StringBuilder sb) {
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset();
        int position = byteBuffer.position() + arrayOffset;
        int limit = arrayOffset + byteBuffer.limit();
        int i2 = limit - position > 128 ? position + 128 : limit;
        for (int i3 = position; i3 < i2; i3++) {
            if (i3 > position) {
                sb.append(AbstractC1191a.f2568g);
            }
            sb.append(m11047a(array[i3]));
        }
        if (limit != i2) {
            sb.append("...");
        }
    }

    /* renamed from: a */
    public static String m11047a(byte b2) {
        return Integer.toHexString((b2 | 256) & FrameMetricsAggregator.EVERY_DURATION).toUpperCase().substring(1);
    }

    /* renamed from: a */
    public static byte[] m11049a(ByteBuffer byteBuffer) {
        if (m11051b(byteBuffer)) {
            return byteBuffer.array();
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        m11040a(byteBuffer, bArr, 0);
        return bArr;
    }

    /* renamed from: a */
    public static int m11040a(ByteBuffer byteBuffer, byte[] bArr, int i2) {
        int remaining = byteBuffer.remaining();
        System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), bArr, i2, remaining);
        return remaining;
    }

    /* renamed from: a */
    public static byte[] m11050a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }
}
