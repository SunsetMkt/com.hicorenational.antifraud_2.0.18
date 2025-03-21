package com.xiaomi.push;

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

/* renamed from: com.xiaomi.push.hr */
/* loaded from: classes2.dex */
public final class C4278hr {

    /* renamed from: a */
    private static final Comparator f16309a = new a();

    /* renamed from: com.xiaomi.push.hr$a */
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
            return obj instanceof List ? C4278hr.m15574a((List) obj, (List) obj2) : obj instanceof Set ? C4278hr.m15576a((Set) obj, (Set) obj2) : obj instanceof Map ? C4278hr.m15575a((Map) obj, (Map) obj2) : obj instanceof byte[] ? C4278hr.m15579a((byte[]) obj, (byte[]) obj2) : C4278hr.m15571a((Comparable) obj, (Comparable) obj2);
        }
    }

    /* renamed from: a */
    public static int m15568a(byte b2, byte b3) {
        if (b2 < b3) {
            return -1;
        }
        return b3 < b2 ? 1 : 0;
    }

    /* renamed from: a */
    public static int m15569a(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i3 < i2 ? 1 : 0;
    }

    /* renamed from: a */
    public static int m15570a(long j2, long j3) {
        if (j2 < j3) {
            return -1;
        }
        return j3 < j2 ? 1 : 0;
    }

    /* renamed from: a */
    public static int m15577a(short s, short s2) {
        if (s < s2) {
            return -1;
        }
        return s2 < s ? 1 : 0;
    }

    /* renamed from: a */
    public static int m15578a(boolean z, boolean z2) {
        return Boolean.valueOf(z).compareTo(Boolean.valueOf(z2));
    }

    /* renamed from: a */
    public static int m15572a(String str, String str2) {
        return str.compareTo(str2);
    }

    /* renamed from: a */
    public static int m15579a(byte[] bArr, byte[] bArr2) {
        int m15569a = m15569a(bArr.length, bArr2.length);
        if (m15569a != 0) {
            return m15569a;
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int m15568a = m15568a(bArr[i2], bArr2[i2]);
            if (m15568a != 0) {
                return m15568a;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static int m15571a(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    /* renamed from: a */
    public static int m15574a(List list, List list2) {
        int m15569a = m15569a(list.size(), list2.size());
        if (m15569a != 0) {
            return m15569a;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            int compare = f16309a.compare(list.get(i2), list2.get(i2));
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static int m15576a(Set set, Set set2) {
        int m15569a = m15569a(set.size(), set2.size());
        if (m15569a != 0) {
            return m15569a;
        }
        TreeSet treeSet = new TreeSet(f16309a);
        treeSet.addAll(set);
        TreeSet treeSet2 = new TreeSet(f16309a);
        treeSet2.addAll(set2);
        Iterator it = treeSet.iterator();
        Iterator it2 = treeSet2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            int compare = f16309a.compare(it.next(), it2.next());
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static int m15575a(Map map, Map map2) {
        int m15569a = m15569a(map.size(), map2.size());
        if (m15569a != 0) {
            return m15569a;
        }
        TreeMap treeMap = new TreeMap(f16309a);
        treeMap.putAll(map);
        Iterator it = treeMap.entrySet().iterator();
        TreeMap treeMap2 = new TreeMap(f16309a);
        treeMap2.putAll(map2);
        Iterator it2 = treeMap2.entrySet().iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Map.Entry entry2 = (Map.Entry) it2.next();
            int compare = f16309a.compare(entry.getKey(), entry2.getKey());
            if (compare != 0) {
                return compare;
            }
            int compare2 = f16309a.compare(entry.getValue(), entry2.getValue());
            if (compare2 != 0) {
                return compare2;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static void m15582a(ByteBuffer byteBuffer, StringBuilder sb) {
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset();
        int limit = byteBuffer.limit();
        int i2 = limit - arrayOffset > 128 ? arrayOffset + 128 : limit;
        for (int i3 = arrayOffset; i3 < i2; i3++) {
            if (i3 > arrayOffset) {
                sb.append(AbstractC1191a.f2568g);
            }
            sb.append(m15580a(array[i3]));
        }
        if (limit != i2) {
            sb.append("...");
        }
    }

    /* renamed from: a */
    public static String m15580a(byte b2) {
        return Integer.toHexString((b2 | 256) & FrameMetricsAggregator.EVERY_DURATION).toUpperCase().substring(1);
    }

    /* renamed from: a */
    public static byte[] m15584a(ByteBuffer byteBuffer) {
        if (m15583a(byteBuffer)) {
            return byteBuffer.array();
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        m15573a(byteBuffer, bArr, 0);
        return bArr;
    }

    /* renamed from: a */
    public static boolean m15583a(ByteBuffer byteBuffer) {
        return byteBuffer.hasArray() && byteBuffer.position() == 0 && byteBuffer.arrayOffset() == 0 && byteBuffer.remaining() == byteBuffer.capacity();
    }

    /* renamed from: a */
    public static int m15573a(ByteBuffer byteBuffer, byte[] bArr, int i2) {
        int remaining = byteBuffer.remaining();
        System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), bArr, i2, remaining);
        return remaining;
    }

    /* renamed from: a */
    public static ByteBuffer m15581a(ByteBuffer byteBuffer) {
        return m15583a(byteBuffer) ? byteBuffer : ByteBuffer.wrap(m15584a(byteBuffer));
    }
}
