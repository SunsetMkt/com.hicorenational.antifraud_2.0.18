package com.tencent.bugly.proguard;

import com.umeng.analytics.pro.cw;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public final class k {
    protected String a = "GBK";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ByteBuffer f6540b;

    /* JADX INFO: compiled from: BUGLY */
    public static class a {
        public byte a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6541b;
    }

    public k() {
    }

    private int b(a aVar) {
        return a(aVar, this.f6540b.duplicate());
    }

    public void a(byte[] bArr) {
        ByteBuffer byteBuffer = this.f6540b;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.f6540b = ByteBuffer.wrap(bArr);
    }

    private void b(int i2) {
        ByteBuffer byteBuffer = this.f6540b;
        byteBuffer.position(byteBuffer.position() + i2);
    }

    public k(byte[] bArr) {
        this.f6540b = ByteBuffer.wrap(bArr);
    }

    private void b() {
        a aVar = new a();
        a(aVar);
        a(aVar.a);
    }

    public static int a(a aVar, ByteBuffer byteBuffer) {
        byte b2 = byteBuffer.get();
        aVar.a = (byte) (b2 & cw.f7205m);
        aVar.f6541b = (b2 & 240) >> 4;
        if (aVar.f6541b != 15) {
            return 1;
        }
        aVar.f6541b = byteBuffer.get();
        return 2;
    }

    public k(byte[] bArr, int i2) {
        this.f6540b = ByteBuffer.wrap(bArr);
        this.f6540b.position(i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T[] b(T t, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.a == 9) {
            int iA = a(0, 0, true);
            if (iA >= 0) {
                T[] tArr = (T[]) ((Object[]) Array.newInstance(t.getClass(), iA));
                for (int i3 = 0; i3 < iA; i3++) {
                    tArr[i3] = a((Object) t, 0, true);
                }
                return tArr;
            }
            throw new h("size invalid: " + iA);
        }
        throw new h("type mismatch.");
    }

    public void a(a aVar) {
        a(aVar, this.f6540b);
    }

    public boolean a(int i2) {
        try {
            a aVar = new a();
            while (true) {
                int iB = b(aVar);
                if (i2 <= aVar.f6541b || aVar.a == 11) {
                    break;
                }
                b(iB);
                a(aVar.a);
            }
            return i2 == aVar.f6541b;
        } catch (h | BufferUnderflowException unused) {
            return false;
        }
    }

    public void a() {
        a aVar = new a();
        do {
            a(aVar);
            a(aVar.a);
        } while (aVar.a != 11);
    }

    private void a(byte b2) {
        int i2 = 0;
        switch (b2) {
            case 0:
                b(1);
                return;
            case 1:
                b(2);
                return;
            case 2:
                b(4);
                return;
            case 3:
                b(8);
                return;
            case 4:
                b(4);
                return;
            case 5:
                b(8);
                return;
            case 6:
                int i3 = this.f6540b.get();
                if (i3 < 0) {
                    i3 += 256;
                }
                b(i3);
                return;
            case 7:
                b(this.f6540b.getInt());
                return;
            case 8:
                int iA = a(0, 0, true);
                while (i2 < iA * 2) {
                    b();
                    i2++;
                }
                return;
            case 9:
                int iA2 = a(0, 0, true);
                while (i2 < iA2) {
                    b();
                    i2++;
                }
                return;
            case 10:
                a();
                return;
            case 11:
            case 12:
                return;
            case 13:
                a aVar = new a();
                a(aVar);
                if (aVar.a == 0) {
                    b(a(0, 0, true));
                    return;
                }
                throw new h("skipField with invalid type, type value: " + ((int) b2) + ", " + ((int) aVar.a));
            default:
                throw new h("invalid type.");
        }
    }

    public boolean a(boolean z, int i2, boolean z2) {
        return a((byte) 0, i2, z2) != 0;
    }

    public byte a(byte b2, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return b2;
        }
        a aVar = new a();
        a(aVar);
        byte b3 = aVar.a;
        if (b3 == 0) {
            return this.f6540b.get();
        }
        if (b3 == 12) {
            return (byte) 0;
        }
        throw new h("type mismatch.");
    }

    public short a(short s, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return s;
        }
        a aVar = new a();
        a(aVar);
        byte b2 = aVar.a;
        if (b2 == 0) {
            return this.f6540b.get();
        }
        if (b2 == 1) {
            return this.f6540b.getShort();
        }
        if (b2 == 12) {
            return (short) 0;
        }
        throw new h("type mismatch.");
    }

    public int a(int i2, int i3, boolean z) {
        if (!a(i3)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return i2;
        }
        a aVar = new a();
        a(aVar);
        byte b2 = aVar.a;
        if (b2 == 0) {
            return this.f6540b.get();
        }
        if (b2 == 1) {
            return this.f6540b.getShort();
        }
        if (b2 == 2) {
            return this.f6540b.getInt();
        }
        if (b2 == 12) {
            return 0;
        }
        throw new h("type mismatch.");
    }

    public long a(long j2, int i2, boolean z) {
        int i3;
        if (!a(i2)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return j2;
        }
        a aVar = new a();
        a(aVar);
        byte b2 = aVar.a;
        if (b2 == 0) {
            i3 = this.f6540b.get();
        } else if (b2 == 1) {
            i3 = this.f6540b.getShort();
        } else {
            if (b2 != 2) {
                if (b2 == 3) {
                    return this.f6540b.getLong();
                }
                if (b2 == 12) {
                    return 0L;
                }
                throw new h("type mismatch.");
            }
            i3 = this.f6540b.getInt();
        }
        return i3;
    }

    public float a(float f2, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return f2;
        }
        a aVar = new a();
        a(aVar);
        byte b2 = aVar.a;
        if (b2 == 4) {
            return this.f6540b.getFloat();
        }
        if (b2 == 12) {
            return 0.0f;
        }
        throw new h("type mismatch.");
    }

    public double a(double d2, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return d2;
        }
        a aVar = new a();
        a(aVar);
        byte b2 = aVar.a;
        if (b2 == 4) {
            return this.f6540b.getFloat();
        }
        if (b2 == 5) {
            return this.f6540b.getDouble();
        }
        if (b2 == 12) {
            return 0.0d;
        }
        throw new h("type mismatch.");
    }

    public String a(int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        byte b2 = aVar.a;
        if (b2 == 6) {
            int i3 = this.f6540b.get();
            if (i3 < 0) {
                i3 += 256;
            }
            byte[] bArr = new byte[i3];
            this.f6540b.get(bArr);
            try {
                return new String(bArr, this.a);
            } catch (UnsupportedEncodingException unused) {
                return new String(bArr);
            }
        }
        if (b2 == 7) {
            int i4 = this.f6540b.getInt();
            if (i4 <= 104857600 && i4 >= 0) {
                byte[] bArr2 = new byte[i4];
                this.f6540b.get(bArr2);
                try {
                    return new String(bArr2, this.a);
                } catch (UnsupportedEncodingException unused2) {
                    return new String(bArr2);
                }
            }
            throw new h("String too long: " + i4);
        }
        throw new h("type mismatch.");
    }

    public <K, V> HashMap<K, V> a(Map<K, V> map, int i2, boolean z) {
        return (HashMap) a(new HashMap(), map, i2, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> Map<K, V> a(Map<K, V> map, Map<K, V> map2, int i2, boolean z) {
        if (map2 != null && !map2.isEmpty()) {
            Map.Entry<K, V> next = map2.entrySet().iterator().next();
            K key = next.getKey();
            V value = next.getValue();
            if (a(i2)) {
                a aVar = new a();
                a(aVar);
                if (aVar.a == 8) {
                    int iA = a(0, 0, true);
                    if (iA < 0) {
                        throw new h("size invalid: " + iA);
                    }
                    for (int i3 = 0; i3 < iA; i3++) {
                        map.put(a(key, 0, true), a(value, 1, true));
                    }
                } else {
                    throw new h("type mismatch.");
                }
            } else if (z) {
                throw new h("require field not exist.");
            }
            return map;
        }
        return new HashMap();
    }

    public boolean[] a(boolean[] zArr, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.a == 9) {
            int iA = a(0, 0, true);
            if (iA >= 0) {
                boolean[] zArr2 = new boolean[iA];
                for (int i3 = 0; i3 < iA; i3++) {
                    zArr2[i3] = a(zArr2[0], 0, true);
                }
                return zArr2;
            }
            throw new h("size invalid: " + iA);
        }
        throw new h("type mismatch.");
    }

    public byte[] a(byte[] bArr, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        byte b2 = aVar.a;
        if (b2 == 9) {
            int iA = a(0, 0, true);
            if (iA >= 0) {
                byte[] bArr2 = new byte[iA];
                for (int i3 = 0; i3 < iA; i3++) {
                    bArr2[i3] = a(bArr2[0], 0, true);
                }
                return bArr2;
            }
            throw new h("size invalid: " + iA);
        }
        if (b2 == 13) {
            a aVar2 = new a();
            a(aVar2);
            if (aVar2.a == 0) {
                int iA2 = a(0, 0, true);
                if (iA2 >= 0) {
                    byte[] bArr3 = new byte[iA2];
                    this.f6540b.get(bArr3);
                    return bArr3;
                }
                throw new h("invalid size, tag: " + i2 + ", type: " + ((int) aVar.a) + ", " + ((int) aVar2.a) + ", size: " + iA2);
            }
            throw new h("type mismatch, tag: " + i2 + ", type: " + ((int) aVar.a) + ", " + ((int) aVar2.a));
        }
        throw new h("type mismatch.");
    }

    public short[] a(short[] sArr, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.a == 9) {
            int iA = a(0, 0, true);
            if (iA >= 0) {
                short[] sArr2 = new short[iA];
                for (int i3 = 0; i3 < iA; i3++) {
                    sArr2[i3] = a(sArr2[0], 0, true);
                }
                return sArr2;
            }
            throw new h("size invalid: " + iA);
        }
        throw new h("type mismatch.");
    }

    public int[] a(int[] iArr, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.a == 9) {
            int iA = a(0, 0, true);
            if (iA >= 0) {
                int[] iArr2 = new int[iA];
                for (int i3 = 0; i3 < iA; i3++) {
                    iArr2[i3] = a(iArr2[0], 0, true);
                }
                return iArr2;
            }
            throw new h("size invalid: " + iA);
        }
        throw new h("type mismatch.");
    }

    public long[] a(long[] jArr, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.a == 9) {
            int iA = a(0, 0, true);
            if (iA >= 0) {
                long[] jArr2 = new long[iA];
                for (int i3 = 0; i3 < iA; i3++) {
                    jArr2[i3] = a(jArr2[0], 0, true);
                }
                return jArr2;
            }
            throw new h("size invalid: " + iA);
        }
        throw new h("type mismatch.");
    }

    public float[] a(float[] fArr, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.a == 9) {
            int iA = a(0, 0, true);
            if (iA >= 0) {
                float[] fArr2 = new float[iA];
                for (int i3 = 0; i3 < iA; i3++) {
                    fArr2[i3] = a(fArr2[0], 0, true);
                }
                return fArr2;
            }
            throw new h("size invalid: " + iA);
        }
        throw new h("type mismatch.");
    }

    public double[] a(double[] dArr, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.a == 9) {
            int iA = a(0, 0, true);
            if (iA >= 0) {
                double[] dArr2 = new double[iA];
                for (int i3 = 0; i3 < iA; i3++) {
                    dArr2[i3] = a(dArr2[0], 0, true);
                }
                return dArr2;
            }
            throw new h("size invalid: " + iA);
        }
        throw new h("type mismatch.");
    }

    public <T> T[] a(T[] tArr, int i2, boolean z) {
        if (tArr != null && tArr.length != 0) {
            return (T[]) b(tArr[0], i2, z);
        }
        throw new h("unable to get type of key and value.");
    }

    public <T> List<T> a(List<T> list, int i2, boolean z) {
        if (list != null && !list.isEmpty()) {
            Object[] objArrB = b(list.get(0), i2, z);
            if (objArrB == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : objArrB) {
                arrayList.add(obj);
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public m a(m mVar, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return null;
        }
        try {
            m mVar2 = (m) mVar.getClass().newInstance();
            a aVar = new a();
            a(aVar);
            if (aVar.a == 10) {
                mVar2.a(this);
                a();
                return mVar2;
            }
            throw new h("type mismatch.");
        } catch (Exception e2) {
            throw new h(e2.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> Object a(T t, int i2, boolean z) {
        if (t instanceof Byte) {
            return Byte.valueOf(a((byte) 0, i2, z));
        }
        if (t instanceof Boolean) {
            return Boolean.valueOf(a(false, i2, z));
        }
        if (t instanceof Short) {
            return Short.valueOf(a((short) 0, i2, z));
        }
        if (t instanceof Integer) {
            return Integer.valueOf(a(0, i2, z));
        }
        if (t instanceof Long) {
            return Long.valueOf(a(0L, i2, z));
        }
        if (t instanceof Float) {
            return Float.valueOf(a(0.0f, i2, z));
        }
        if (t instanceof Double) {
            return Double.valueOf(a(0.0d, i2, z));
        }
        if (t instanceof String) {
            return String.valueOf(a(i2, z));
        }
        if (t instanceof Map) {
            return a((Map) t, i2, z);
        }
        if (t instanceof List) {
            return a((List) t, i2, z);
        }
        if (t instanceof m) {
            return a((m) t, i2, z);
        }
        if (t.getClass().isArray()) {
            if (!(t instanceof byte[]) && !(t instanceof Byte[])) {
                if (t instanceof boolean[]) {
                    return a((boolean[]) null, i2, z);
                }
                if (t instanceof short[]) {
                    return a((short[]) null, i2, z);
                }
                if (t instanceof int[]) {
                    return a((int[]) null, i2, z);
                }
                if (t instanceof long[]) {
                    return a((long[]) null, i2, z);
                }
                if (t instanceof float[]) {
                    return a((float[]) null, i2, z);
                }
                if (t instanceof double[]) {
                    return a((double[]) null, i2, z);
                }
                return a((Object[]) t, i2, z);
            }
            return a((byte[]) null, i2, z);
        }
        throw new h("read object error: unsupport type.");
    }

    public int a(String str) {
        this.a = str;
        return 0;
    }
}
