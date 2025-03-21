package com.tencent.bugly.proguard;

import com.umeng.analytics.pro.C3393cw;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.l */
/* loaded from: classes2.dex */
public class C3187l {

    /* renamed from: a */
    protected String f10761a;

    /* renamed from: b */
    private ByteBuffer f10762b;

    public C3187l(int i2) {
        this.f10761a = "GBK";
        this.f10762b = ByteBuffer.allocate(i2);
    }

    /* renamed from: a */
    public ByteBuffer m10097a() {
        return this.f10762b;
    }

    /* renamed from: b */
    public byte[] m10119b() {
        byte[] bArr = new byte[this.f10762b.position()];
        System.arraycopy(this.f10762b.array(), 0, bArr, 0, this.f10762b.position());
        return bArr;
    }

    /* renamed from: a */
    public void m10101a(int i2) {
        if (this.f10762b.remaining() < i2) {
            ByteBuffer allocate = ByteBuffer.allocate((this.f10762b.capacity() + i2) * 2);
            allocate.put(this.f10762b.array(), 0, this.f10762b.position());
            this.f10762b = allocate;
        }
    }

    /* renamed from: b */
    public void m10118b(byte b2, int i2) {
        m10101a(3);
        if (b2 == 0) {
            m10098a((byte) 12, i2);
        } else {
            m10098a((byte) 0, i2);
            this.f10762b.put(b2);
        }
    }

    public C3187l() {
        this(128);
    }

    /* renamed from: a */
    public void m10098a(byte b2, int i2) {
        if (i2 < 15) {
            this.f10762b.put((byte) (b2 | (i2 << 4)));
        } else if (i2 < 256) {
            this.f10762b.put((byte) (b2 | 240));
            this.f10762b.put((byte) i2);
        } else {
            throw new C3185j("tag is too large: " + i2);
        }
    }

    /* renamed from: a */
    public void m10110a(boolean z, int i2) {
        m10118b(z ? (byte) 1 : (byte) 0, i2);
    }

    /* renamed from: a */
    public void m10109a(short s, int i2) {
        m10101a(4);
        if (s >= -128 && s <= 127) {
            m10118b((byte) s, i2);
        } else {
            m10098a((byte) 1, i2);
            this.f10762b.putShort(s);
        }
    }

    /* renamed from: a */
    public void m10102a(int i2, int i3) {
        m10101a(6);
        if (i2 >= -32768 && i2 <= 32767) {
            m10109a((short) i2, i3);
        } else {
            m10098a((byte) 2, i3);
            this.f10762b.putInt(i2);
        }
    }

    /* renamed from: a */
    public void m10103a(long j2, int i2) {
        m10101a(10);
        if (j2 >= -2147483648L && j2 <= 2147483647L) {
            m10102a((int) j2, i2);
        } else {
            m10098a((byte) 3, i2);
            this.f10762b.putLong(j2);
        }
    }

    /* renamed from: a */
    public void m10100a(float f2, int i2) {
        m10101a(6);
        m10098a((byte) 4, i2);
        this.f10762b.putFloat(f2);
    }

    /* renamed from: a */
    public void m10099a(double d2, int i2) {
        m10101a(10);
        m10098a((byte) 5, i2);
        this.f10762b.putDouble(d2);
    }

    /* renamed from: a */
    public void m10106a(String str, int i2) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.f10761a);
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        m10101a(bytes.length + 10);
        if (bytes.length > 255) {
            m10098a((byte) 7, i2);
            this.f10762b.putInt(bytes.length);
            this.f10762b.put(bytes);
        } else {
            m10098a((byte) 6, i2);
            this.f10762b.put((byte) bytes.length);
            this.f10762b.put(bytes);
        }
    }

    /* renamed from: a */
    public <K, V> void m10108a(Map<K, V> map, int i2) {
        m10101a(8);
        m10098a((byte) 8, i2);
        m10102a(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                m10105a(entry.getKey(), 0);
                m10105a(entry.getValue(), 1);
            }
        }
    }

    /* renamed from: a */
    public void m10117a(boolean[] zArr, int i2) {
        m10101a(8);
        m10098a((byte) 9, i2);
        m10102a(zArr.length, 0);
        for (boolean z : zArr) {
            m10110a(z, 0);
        }
    }

    /* renamed from: a */
    public void m10111a(byte[] bArr, int i2) {
        m10101a(bArr.length + 8);
        m10098a(C3393cw.f11871k, i2);
        m10098a((byte) 0, 0);
        m10102a(bArr.length, 0);
        this.f10762b.put(bArr);
    }

    /* renamed from: a */
    public void m10116a(short[] sArr, int i2) {
        m10101a(8);
        m10098a((byte) 9, i2);
        m10102a(sArr.length, 0);
        for (short s : sArr) {
            m10109a(s, 0);
        }
    }

    /* renamed from: a */
    public void m10114a(int[] iArr, int i2) {
        m10101a(8);
        m10098a((byte) 9, i2);
        m10102a(iArr.length, 0);
        for (int i3 : iArr) {
            m10102a(i3, 0);
        }
    }

    /* renamed from: a */
    public void m10115a(long[] jArr, int i2) {
        m10101a(8);
        m10098a((byte) 9, i2);
        m10102a(jArr.length, 0);
        for (long j2 : jArr) {
            m10103a(j2, 0);
        }
    }

    /* renamed from: a */
    public void m10113a(float[] fArr, int i2) {
        m10101a(8);
        m10098a((byte) 9, i2);
        m10102a(fArr.length, 0);
        for (float f2 : fArr) {
            m10100a(f2, 0);
        }
    }

    /* renamed from: a */
    public void m10112a(double[] dArr, int i2) {
        m10101a(8);
        m10098a((byte) 9, i2);
        m10102a(dArr.length, 0);
        for (double d2 : dArr) {
            m10099a(d2, 0);
        }
    }

    /* renamed from: a */
    private void m10095a(Object[] objArr, int i2) {
        m10101a(8);
        m10098a((byte) 9, i2);
        m10102a(objArr.length, 0);
        for (Object obj : objArr) {
            m10105a(obj, 0);
        }
    }

    /* renamed from: a */
    public <T> void m10107a(Collection<T> collection, int i2) {
        m10101a(8);
        m10098a((byte) 9, i2);
        m10102a(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                m10105a(it.next(), 0);
            }
        }
    }

    /* renamed from: a */
    public void m10104a(AbstractC3188m abstractC3188m, int i2) {
        m10101a(2);
        m10098a((byte) 10, i2);
        abstractC3188m.mo9794a(this);
        m10101a(2);
        m10098a((byte) 11, 0);
    }

    /* renamed from: a */
    public void m10105a(Object obj, int i2) {
        if (obj instanceof Byte) {
            m10118b(((Byte) obj).byteValue(), i2);
            return;
        }
        if (obj instanceof Boolean) {
            m10110a(((Boolean) obj).booleanValue(), i2);
            return;
        }
        if (obj instanceof Short) {
            m10109a(((Short) obj).shortValue(), i2);
            return;
        }
        if (obj instanceof Integer) {
            m10102a(((Integer) obj).intValue(), i2);
            return;
        }
        if (obj instanceof Long) {
            m10103a(((Long) obj).longValue(), i2);
            return;
        }
        if (obj instanceof Float) {
            m10100a(((Float) obj).floatValue(), i2);
            return;
        }
        if (obj instanceof Double) {
            m10099a(((Double) obj).doubleValue(), i2);
            return;
        }
        if (obj instanceof String) {
            m10106a((String) obj, i2);
            return;
        }
        if (obj instanceof Map) {
            m10108a((Map) obj, i2);
            return;
        }
        if (obj instanceof List) {
            m10107a((Collection) obj, i2);
            return;
        }
        if (obj instanceof AbstractC3188m) {
            m10104a((AbstractC3188m) obj, i2);
            return;
        }
        if (obj instanceof byte[]) {
            m10111a((byte[]) obj, i2);
            return;
        }
        if (obj instanceof boolean[]) {
            m10117a((boolean[]) obj, i2);
            return;
        }
        if (obj instanceof short[]) {
            m10116a((short[]) obj, i2);
            return;
        }
        if (obj instanceof int[]) {
            m10114a((int[]) obj, i2);
            return;
        }
        if (obj instanceof long[]) {
            m10115a((long[]) obj, i2);
            return;
        }
        if (obj instanceof float[]) {
            m10113a((float[]) obj, i2);
            return;
        }
        if (obj instanceof double[]) {
            m10112a((double[]) obj, i2);
            return;
        }
        if (obj.getClass().isArray()) {
            m10095a((Object[]) obj, i2);
        } else {
            if (obj instanceof Collection) {
                m10107a((Collection) obj, i2);
                return;
            }
            throw new C3185j("write object error: unsupport type. " + obj.getClass());
        }
    }

    /* renamed from: a */
    public int m10096a(String str) {
        this.f10761a = str;
        return 0;
    }
}
