package p031c.p035b.p043c;

import java.util.EnumMap;
import java.util.Map;

/* compiled from: Result.java */
/* renamed from: c.b.c.r */
/* loaded from: classes.dex */
public final class C1107r {

    /* renamed from: a */
    private final String f2216a;

    /* renamed from: b */
    private final byte[] f2217b;

    /* renamed from: c */
    private C1109t[] f2218c;

    /* renamed from: d */
    private final EnumC0953a f2219d;

    /* renamed from: e */
    private Map<EnumC1108s, Object> f2220e;

    /* renamed from: f */
    private final long f2221f;

    public C1107r(String str, byte[] bArr, C1109t[] c1109tArr, EnumC0953a enumC0953a) {
        this(str, bArr, c1109tArr, enumC0953a, System.currentTimeMillis());
    }

    /* renamed from: a */
    public EnumC0953a m1910a() {
        return this.f2219d;
    }

    /* renamed from: b */
    public byte[] m1914b() {
        return this.f2217b;
    }

    /* renamed from: c */
    public Map<EnumC1108s, Object> m1915c() {
        return this.f2220e;
    }

    /* renamed from: d */
    public C1109t[] m1916d() {
        return this.f2218c;
    }

    /* renamed from: e */
    public String m1917e() {
        return this.f2216a;
    }

    /* renamed from: f */
    public long m1918f() {
        return this.f2221f;
    }

    public String toString() {
        return this.f2216a;
    }

    public C1107r(String str, byte[] bArr, C1109t[] c1109tArr, EnumC0953a enumC0953a, long j2) {
        this.f2216a = str;
        this.f2217b = bArr;
        this.f2218c = c1109tArr;
        this.f2219d = enumC0953a;
        this.f2220e = null;
        this.f2221f = j2;
    }

    /* renamed from: a */
    public void m1911a(EnumC1108s enumC1108s, Object obj) {
        if (this.f2220e == null) {
            this.f2220e = new EnumMap(EnumC1108s.class);
        }
        this.f2220e.put(enumC1108s, obj);
    }

    /* renamed from: a */
    public void m1912a(Map<EnumC1108s, Object> map) {
        if (map != null) {
            Map<EnumC1108s, Object> map2 = this.f2220e;
            if (map2 == null) {
                this.f2220e = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    /* renamed from: a */
    public void m1913a(C1109t[] c1109tArr) {
        C1109t[] c1109tArr2 = this.f2218c;
        if (c1109tArr2 == null) {
            this.f2218c = c1109tArr;
            return;
        }
        if (c1109tArr == null || c1109tArr.length <= 0) {
            return;
        }
        C1109t[] c1109tArr3 = new C1109t[c1109tArr2.length + c1109tArr.length];
        System.arraycopy(c1109tArr2, 0, c1109tArr3, 0, c1109tArr2.length);
        System.arraycopy(c1109tArr, 0, c1109tArr3, c1109tArr2.length, c1109tArr.length);
        this.f2218c = c1109tArr3;
    }
}
