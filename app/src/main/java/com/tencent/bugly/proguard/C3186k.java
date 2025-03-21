package com.tencent.bugly.proguard;

import com.umeng.analytics.pro.C3393cw;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.k */
/* loaded from: classes2.dex */
public final class C3186k {

    /* renamed from: a */
    protected String f10757a = "GBK";

    /* renamed from: b */
    private ByteBuffer f10758b;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.k$a */
    public static class a {

        /* renamed from: a */
        public byte f10759a;

        /* renamed from: b */
        public int f10760b;
    }

    public C3186k() {
    }

    /* renamed from: b */
    private int m10066b(a aVar) {
        return m10063a(aVar, this.f10758b.duplicate());
    }

    /* renamed from: a */
    public void m10084a(byte[] bArr) {
        ByteBuffer byteBuffer = this.f10758b;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.f10758b = ByteBuffer.wrap(bArr);
    }

    /* renamed from: b */
    private void m10068b(int i2) {
        ByteBuffer byteBuffer = this.f10758b;
        byteBuffer.position(byteBuffer.position() + i2);
    }

    public C3186k(byte[] bArr) {
        this.f10758b = ByteBuffer.wrap(bArr);
    }

    /* renamed from: b */
    private void m10067b() {
        a aVar = new a();
        m10083a(aVar);
        m10065a(aVar.f10759a);
    }

    /* renamed from: a */
    public static int m10063a(a aVar, ByteBuffer byteBuffer) {
        byte b2 = byteBuffer.get();
        aVar.f10759a = (byte) (b2 & C3393cw.f11873m);
        aVar.f10760b = (b2 & 240) >> 4;
        if (aVar.f10760b != 15) {
            return 1;
        }
        aVar.f10760b = byteBuffer.get();
        return 2;
    }

    public C3186k(byte[] bArr, int i2) {
        this.f10758b = ByteBuffer.wrap(bArr);
        this.f10758b.position(i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    private <T> T[] m10069b(T t, int i2, boolean z) {
        if (!m10085a(i2)) {
            if (z) {
                throw new C3183h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        m10083a(aVar);
        if (aVar.f10759a == 9) {
            int m10073a = m10073a(0, 0, true);
            if (m10073a >= 0) {
                T[] tArr = (T[]) ((Object[]) Array.newInstance(t.getClass(), m10073a));
                for (int i3 = 0; i3 < m10073a; i3++) {
                    tArr[i3] = m10077a((C3186k) t, 0, true);
                }
                return tArr;
            }
            throw new C3183h("size invalid: " + m10073a);
        }
        throw new C3183h("type mismatch.");
    }

    /* renamed from: a */
    public void m10083a(a aVar) {
        m10063a(aVar, this.f10758b);
    }

    /* renamed from: a */
    public boolean m10085a(int i2) {
        try {
            a aVar = new a();
            while (true) {
                int m10066b = m10066b(aVar);
                if (i2 <= aVar.f10760b || aVar.f10759a == 11) {
                    break;
                }
                m10068b(m10066b);
                m10065a(aVar.f10759a);
            }
            return i2 == aVar.f10760b;
        } catch (C3183h | BufferUnderflowException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public void m10082a() {
        a aVar = new a();
        do {
            m10083a(aVar);
            m10065a(aVar.f10759a);
        } while (aVar.f10759a != 11);
    }

    /* renamed from: a */
    private void m10065a(byte b2) {
        int i2 = 0;
        switch (b2) {
            case 0:
                m10068b(1);
                return;
            case 1:
                m10068b(2);
                return;
            case 2:
                m10068b(4);
                return;
            case 3:
                m10068b(8);
                return;
            case 4:
                m10068b(4);
                return;
            case 5:
                m10068b(8);
                return;
            case 6:
                int i3 = this.f10758b.get();
                if (i3 < 0) {
                    i3 += 256;
                }
                m10068b(i3);
                return;
            case 7:
                m10068b(this.f10758b.getInt());
                return;
            case 8:
                int m10073a = m10073a(0, 0, true);
                while (i2 < m10073a * 2) {
                    m10067b();
                    i2++;
                }
                return;
            case 9:
                int m10073a2 = m10073a(0, 0, true);
                while (i2 < m10073a2) {
                    m10067b();
                    i2++;
                }
                return;
            case 10:
                m10082a();
                return;
            case 11:
            case 12:
                return;
            case 13:
                a aVar = new a();
                m10083a(aVar);
                if (aVar.f10759a == 0) {
                    m10068b(m10073a(0, 0, true));
                    return;
                }
                throw new C3183h("skipField with invalid type, type value: " + ((int) b2) + ", " + ((int) aVar.f10759a));
            default:
                throw new C3183h("invalid type.");
        }
    }

    /* renamed from: a */
    public boolean m10086a(boolean z, int i2, boolean z2) {
        return m10070a((byte) 0, i2, z2) != 0;
    }

    /* renamed from: a */
    public byte m10070a(byte b2, int i2, boolean z) {
        if (!m10085a(i2)) {
            if (z) {
                throw new C3183h("require field not exist.");
            }
            return b2;
        }
        a aVar = new a();
        m10083a(aVar);
        byte b3 = aVar.f10759a;
        if (b3 == 0) {
            return this.f10758b.get();
        }
        if (b3 == 12) {
            return (byte) 0;
        }
        throw new C3183h("type mismatch.");
    }

    /* renamed from: a */
    public short m10081a(short s, int i2, boolean z) {
        if (!m10085a(i2)) {
            if (z) {
                throw new C3183h("require field not exist.");
            }
            return s;
        }
        a aVar = new a();
        m10083a(aVar);
        byte b2 = aVar.f10759a;
        if (b2 == 0) {
            return this.f10758b.get();
        }
        if (b2 == 1) {
            return this.f10758b.getShort();
        }
        if (b2 == 12) {
            return (short) 0;
        }
        throw new C3183h("type mismatch.");
    }

    /* renamed from: a */
    public int m10073a(int i2, int i3, boolean z) {
        if (!m10085a(i3)) {
            if (z) {
                throw new C3183h("require field not exist.");
            }
            return i2;
        }
        a aVar = new a();
        m10083a(aVar);
        byte b2 = aVar.f10759a;
        if (b2 == 0) {
            return this.f10758b.get();
        }
        if (b2 == 1) {
            return this.f10758b.getShort();
        }
        if (b2 == 2) {
            return this.f10758b.getInt();
        }
        if (b2 == 12) {
            return 0;
        }
        throw new C3183h("type mismatch.");
    }

    /* renamed from: a */
    public long m10075a(long j2, int i2, boolean z) {
        int i3;
        if (!m10085a(i2)) {
            if (z) {
                throw new C3183h("require field not exist.");
            }
            return j2;
        }
        a aVar = new a();
        m10083a(aVar);
        byte b2 = aVar.f10759a;
        if (b2 == 0) {
            i3 = this.f10758b.get();
        } else if (b2 == 1) {
            i3 = this.f10758b.getShort();
        } else {
            if (b2 != 2) {
                if (b2 == 3) {
                    return this.f10758b.getLong();
                }
                if (b2 == 12) {
                    return 0L;
                }
                throw new C3183h("type mismatch.");
            }
            i3 = this.f10758b.getInt();
        }
        return i3;
    }

    /* renamed from: a */
    public float m10072a(float f2, int i2, boolean z) {
        if (!m10085a(i2)) {
            if (z) {
                throw new C3183h("require field not exist.");
            }
            return f2;
        }
        a aVar = new a();
        m10083a(aVar);
        byte b2 = aVar.f10759a;
        if (b2 == 4) {
            return this.f10758b.getFloat();
        }
        if (b2 == 12) {
            return 0.0f;
        }
        throw new C3183h("type mismatch.");
    }

    /* renamed from: a */
    public double m10071a(double d2, int i2, boolean z) {
        if (!m10085a(i2)) {
            if (z) {
                throw new C3183h("require field not exist.");
            }
            return d2;
        }
        a aVar = new a();
        m10083a(aVar);
        byte b2 = aVar.f10759a;
        if (b2 == 4) {
            return this.f10758b.getFloat();
        }
        if (b2 == 5) {
            return this.f10758b.getDouble();
        }
        if (b2 == 12) {
            return 0.0d;
        }
        throw new C3183h("type mismatch.");
    }

    /* renamed from: a */
    public String m10078a(int i2, boolean z) {
        if (!m10085a(i2)) {
            if (z) {
                throw new C3183h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        m10083a(aVar);
        byte b2 = aVar.f10759a;
        if (b2 == 6) {
            int i3 = this.f10758b.get();
            if (i3 < 0) {
                i3 += 256;
            }
            byte[] bArr = new byte[i3];
            this.f10758b.get(bArr);
            try {
                return new String(bArr, this.f10757a);
            } catch (UnsupportedEncodingException unused) {
                return new String(bArr);
            }
        }
        if (b2 == 7) {
            int i4 = this.f10758b.getInt();
            if (i4 <= 104857600 && i4 >= 0) {
                byte[] bArr2 = new byte[i4];
                this.f10758b.get(bArr2);
                try {
                    return new String(bArr2, this.f10757a);
                } catch (UnsupportedEncodingException unused2) {
                    return new String(bArr2);
                }
            }
            throw new C3183h("String too long: " + i4);
        }
        throw new C3183h("type mismatch.");
    }

    /* renamed from: a */
    public <K, V> HashMap<K, V> m10079a(Map<K, V> map, int i2, boolean z) {
        return (HashMap) m10064a(new HashMap(), map, i2, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private <K, V> Map<K, V> m10064a(Map<K, V> map, Map<K, V> map2, int i2, boolean z) {
        if (map2 != null && !map2.isEmpty()) {
            Map.Entry<K, V> next = map2.entrySet().iterator().next();
            K key = next.getKey();
            V value = next.getValue();
            if (m10085a(i2)) {
                a aVar = new a();
                m10083a(aVar);
                if (aVar.f10759a == 8) {
                    int m10073a = m10073a(0, 0, true);
                    if (m10073a < 0) {
                        throw new C3183h("size invalid: " + m10073a);
                    }
                    for (int i3 = 0; i3 < m10073a; i3++) {
                        map.put(m10077a((C3186k) key, 0, true), m10077a((C3186k) value, 1, true));
                    }
                } else {
                    throw new C3183h("type mismatch.");
                }
            } else if (z) {
                throw new C3183h("require field not exist.");
            }
            return map;
        }
        return new HashMap();
    }

    /* renamed from: a */
    public boolean[] m10094a(boolean[] zArr, int i2, boolean z) {
        if (!m10085a(i2)) {
            if (z) {
                throw new C3183h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        m10083a(aVar);
        if (aVar.f10759a == 9) {
            int m10073a = m10073a(0, 0, true);
            if (m10073a >= 0) {
                boolean[] zArr2 = new boolean[m10073a];
                for (int i3 = 0; i3 < m10073a; i3++) {
                    zArr2[i3] = m10086a(zArr2[0], 0, true);
                }
                return zArr2;
            }
            throw new C3183h("size invalid: " + m10073a);
        }
        throw new C3183h("type mismatch.");
    }

    /* renamed from: a */
    public byte[] m10087a(byte[] bArr, int i2, boolean z) {
        if (!m10085a(i2)) {
            if (z) {
                throw new C3183h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        m10083a(aVar);
        byte b2 = aVar.f10759a;
        if (b2 == 9) {
            int m10073a = m10073a(0, 0, true);
            if (m10073a >= 0) {
                byte[] bArr2 = new byte[m10073a];
                for (int i3 = 0; i3 < m10073a; i3++) {
                    bArr2[i3] = m10070a(bArr2[0], 0, true);
                }
                return bArr2;
            }
            throw new C3183h("size invalid: " + m10073a);
        }
        if (b2 == 13) {
            a aVar2 = new a();
            m10083a(aVar2);
            if (aVar2.f10759a == 0) {
                int m10073a2 = m10073a(0, 0, true);
                if (m10073a2 >= 0) {
                    byte[] bArr3 = new byte[m10073a2];
                    this.f10758b.get(bArr3);
                    return bArr3;
                }
                throw new C3183h("invalid size, tag: " + i2 + ", type: " + ((int) aVar.f10759a) + ", " + ((int) aVar2.f10759a) + ", size: " + m10073a2);
            }
            throw new C3183h("type mismatch, tag: " + i2 + ", type: " + ((int) aVar.f10759a) + ", " + ((int) aVar2.f10759a));
        }
        throw new C3183h("type mismatch.");
    }

    /* renamed from: a */
    public short[] m10093a(short[] sArr, int i2, boolean z) {
        if (!m10085a(i2)) {
            if (z) {
                throw new C3183h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        m10083a(aVar);
        if (aVar.f10759a == 9) {
            int m10073a = m10073a(0, 0, true);
            if (m10073a >= 0) {
                short[] sArr2 = new short[m10073a];
                for (int i3 = 0; i3 < m10073a; i3++) {
                    sArr2[i3] = m10081a(sArr2[0], 0, true);
                }
                return sArr2;
            }
            throw new C3183h("size invalid: " + m10073a);
        }
        throw new C3183h("type mismatch.");
    }

    /* renamed from: a */
    public int[] m10090a(int[] iArr, int i2, boolean z) {
        if (!m10085a(i2)) {
            if (z) {
                throw new C3183h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        m10083a(aVar);
        if (aVar.f10759a == 9) {
            int m10073a = m10073a(0, 0, true);
            if (m10073a >= 0) {
                int[] iArr2 = new int[m10073a];
                for (int i3 = 0; i3 < m10073a; i3++) {
                    iArr2[i3] = m10073a(iArr2[0], 0, true);
                }
                return iArr2;
            }
            throw new C3183h("size invalid: " + m10073a);
        }
        throw new C3183h("type mismatch.");
    }

    /* renamed from: a */
    public long[] m10091a(long[] jArr, int i2, boolean z) {
        if (!m10085a(i2)) {
            if (z) {
                throw new C3183h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        m10083a(aVar);
        if (aVar.f10759a == 9) {
            int m10073a = m10073a(0, 0, true);
            if (m10073a >= 0) {
                long[] jArr2 = new long[m10073a];
                for (int i3 = 0; i3 < m10073a; i3++) {
                    jArr2[i3] = m10075a(jArr2[0], 0, true);
                }
                return jArr2;
            }
            throw new C3183h("size invalid: " + m10073a);
        }
        throw new C3183h("type mismatch.");
    }

    /* renamed from: a */
    public float[] m10089a(float[] fArr, int i2, boolean z) {
        if (!m10085a(i2)) {
            if (z) {
                throw new C3183h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        m10083a(aVar);
        if (aVar.f10759a == 9) {
            int m10073a = m10073a(0, 0, true);
            if (m10073a >= 0) {
                float[] fArr2 = new float[m10073a];
                for (int i3 = 0; i3 < m10073a; i3++) {
                    fArr2[i3] = m10072a(fArr2[0], 0, true);
                }
                return fArr2;
            }
            throw new C3183h("size invalid: " + m10073a);
        }
        throw new C3183h("type mismatch.");
    }

    /* renamed from: a */
    public double[] m10088a(double[] dArr, int i2, boolean z) {
        if (!m10085a(i2)) {
            if (z) {
                throw new C3183h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        m10083a(aVar);
        if (aVar.f10759a == 9) {
            int m10073a = m10073a(0, 0, true);
            if (m10073a >= 0) {
                double[] dArr2 = new double[m10073a];
                for (int i3 = 0; i3 < m10073a; i3++) {
                    dArr2[i3] = m10071a(dArr2[0], 0, true);
                }
                return dArr2;
            }
            throw new C3183h("size invalid: " + m10073a);
        }
        throw new C3183h("type mismatch.");
    }

    /* renamed from: a */
    public <T> T[] m10092a(T[] tArr, int i2, boolean z) {
        if (tArr != null && tArr.length != 0) {
            return (T[]) m10069b(tArr[0], i2, z);
        }
        throw new C3183h("unable to get type of key and value.");
    }

    /* renamed from: a */
    public <T> List<T> m10080a(List<T> list, int i2, boolean z) {
        if (list != null && !list.isEmpty()) {
            Object[] m10069b = m10069b(list.get(0), i2, z);
            if (m10069b == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : m10069b) {
                arrayList.add(obj);
            }
            return arrayList;
        }
        return new ArrayList();
    }

    /* renamed from: a */
    public AbstractC3188m m10076a(AbstractC3188m abstractC3188m, int i2, boolean z) {
        if (!m10085a(i2)) {
            if (z) {
                throw new C3183h("require field not exist.");
            }
            return null;
        }
        try {
            AbstractC3188m abstractC3188m2 = (AbstractC3188m) abstractC3188m.getClass().newInstance();
            a aVar = new a();
            m10083a(aVar);
            if (aVar.f10759a == 10) {
                abstractC3188m2.mo9793a(this);
                m10082a();
                return abstractC3188m2;
            }
            throw new C3183h("type mismatch.");
        } catch (Exception e2) {
            throw new C3183h(e2.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public <T> Object m10077a(T t, int i2, boolean z) {
        if (t instanceof Byte) {
            return Byte.valueOf(m10070a((byte) 0, i2, z));
        }
        if (t instanceof Boolean) {
            return Boolean.valueOf(m10086a(false, i2, z));
        }
        if (t instanceof Short) {
            return Short.valueOf(m10081a((short) 0, i2, z));
        }
        if (t instanceof Integer) {
            return Integer.valueOf(m10073a(0, i2, z));
        }
        if (t instanceof Long) {
            return Long.valueOf(m10075a(0L, i2, z));
        }
        if (t instanceof Float) {
            return Float.valueOf(m10072a(0.0f, i2, z));
        }
        if (t instanceof Double) {
            return Double.valueOf(m10071a(0.0d, i2, z));
        }
        if (t instanceof String) {
            return String.valueOf(m10078a(i2, z));
        }
        if (t instanceof Map) {
            return m10079a((Map) t, i2, z);
        }
        if (t instanceof List) {
            return m10080a((List) t, i2, z);
        }
        if (t instanceof AbstractC3188m) {
            return m10076a((AbstractC3188m) t, i2, z);
        }
        if (t.getClass().isArray()) {
            if (!(t instanceof byte[]) && !(t instanceof Byte[])) {
                if (t instanceof boolean[]) {
                    return m10094a((boolean[]) null, i2, z);
                }
                if (t instanceof short[]) {
                    return m10093a((short[]) null, i2, z);
                }
                if (t instanceof int[]) {
                    return m10090a((int[]) null, i2, z);
                }
                if (t instanceof long[]) {
                    return m10091a((long[]) null, i2, z);
                }
                if (t instanceof float[]) {
                    return m10089a((float[]) null, i2, z);
                }
                if (t instanceof double[]) {
                    return m10088a((double[]) null, i2, z);
                }
                return m10092a((Object[]) t, i2, z);
            }
            return m10087a((byte[]) null, i2, z);
        }
        throw new C3183h("read object error: unsupport type.");
    }

    /* renamed from: a */
    public int m10074a(String str) {
        this.f10757a = str;
        return 0;
    }
}
