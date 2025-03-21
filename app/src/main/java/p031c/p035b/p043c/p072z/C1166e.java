package p031c.p035b.p043c.p072z;

import java.util.List;

/* compiled from: DecoderResult.java */
/* renamed from: c.b.c.z.e */
/* loaded from: classes.dex */
public final class C1166e {

    /* renamed from: a */
    private final byte[] f2398a;

    /* renamed from: b */
    private final String f2399b;

    /* renamed from: c */
    private final List<byte[]> f2400c;

    /* renamed from: d */
    private final String f2401d;

    /* renamed from: e */
    private Integer f2402e;

    /* renamed from: f */
    private Integer f2403f;

    /* renamed from: g */
    private Object f2404g;

    /* renamed from: h */
    private final int f2405h;

    /* renamed from: i */
    private final int f2406i;

    public C1166e(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    /* renamed from: a */
    public List<byte[]> m2187a() {
        return this.f2400c;
    }

    /* renamed from: b */
    public String m2190b() {
        return this.f2401d;
    }

    /* renamed from: c */
    public Integer m2192c() {
        return this.f2403f;
    }

    /* renamed from: d */
    public Integer m2193d() {
        return this.f2402e;
    }

    /* renamed from: e */
    public Object m2194e() {
        return this.f2404g;
    }

    /* renamed from: f */
    public byte[] m2195f() {
        return this.f2398a;
    }

    /* renamed from: g */
    public int m2196g() {
        return this.f2405h;
    }

    /* renamed from: h */
    public int m2197h() {
        return this.f2406i;
    }

    /* renamed from: i */
    public String m2198i() {
        return this.f2399b;
    }

    /* renamed from: j */
    public boolean m2199j() {
        return this.f2405h >= 0 && this.f2406i >= 0;
    }

    public C1166e(byte[] bArr, String str, List<byte[]> list, String str2, int i2, int i3) {
        this.f2398a = bArr;
        this.f2399b = str;
        this.f2400c = list;
        this.f2401d = str2;
        this.f2405h = i3;
        this.f2406i = i2;
    }

    /* renamed from: a */
    public void m2188a(Integer num) {
        this.f2403f = num;
    }

    /* renamed from: b */
    public void m2191b(Integer num) {
        this.f2402e = num;
    }

    /* renamed from: a */
    public void m2189a(Object obj) {
        this.f2404g = obj;
    }
}
