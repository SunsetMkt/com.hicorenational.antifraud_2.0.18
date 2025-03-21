package com.tencent.bugly.proguard;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.i */
/* loaded from: classes2.dex */
public final class C3184i {

    /* renamed from: a */
    private StringBuilder f10755a;

    /* renamed from: b */
    private int f10756b;

    public C3184i(StringBuilder sb, int i2) {
        this.f10756b = 0;
        this.f10755a = sb;
        this.f10756b = i2;
    }

    /* renamed from: a */
    private void m10042a(String str) {
        for (int i2 = 0; i2 < this.f10756b; i2++) {
            this.f10755a.append('\t');
        }
        if (str != null) {
            StringBuilder sb = this.f10755a;
            sb.append(str);
            sb.append(": ");
        }
    }

    /* renamed from: a */
    public C3184i m10055a(boolean z, String str) {
        m10042a(str);
        StringBuilder sb = this.f10755a;
        sb.append(z ? 'T' : 'F');
        sb.append('\n');
        return this;
    }

    /* renamed from: a */
    public C3184i m10043a(byte b2, String str) {
        m10042a(str);
        StringBuilder sb = this.f10755a;
        sb.append((int) b2);
        sb.append('\n');
        return this;
    }

    /* renamed from: a */
    public C3184i m10044a(char c2, String str) {
        m10042a(str);
        StringBuilder sb = this.f10755a;
        sb.append(c2);
        sb.append('\n');
        return this;
    }

    /* renamed from: a */
    public C3184i m10054a(short s, String str) {
        m10042a(str);
        StringBuilder sb = this.f10755a;
        sb.append((int) s);
        sb.append('\n');
        return this;
    }

    /* renamed from: a */
    public C3184i m10047a(int i2, String str) {
        m10042a(str);
        StringBuilder sb = this.f10755a;
        sb.append(i2);
        sb.append('\n');
        return this;
    }

    /* renamed from: a */
    public C3184i m10048a(long j2, String str) {
        m10042a(str);
        StringBuilder sb = this.f10755a;
        sb.append(j2);
        sb.append('\n');
        return this;
    }

    /* renamed from: a */
    public C3184i m10046a(float f2, String str) {
        m10042a(str);
        StringBuilder sb = this.f10755a;
        sb.append(f2);
        sb.append('\n');
        return this;
    }

    /* renamed from: a */
    public C3184i m10045a(double d2, String str) {
        m10042a(str);
        StringBuilder sb = this.f10755a;
        sb.append(d2);
        sb.append('\n');
        return this;
    }

    /* renamed from: a */
    public C3184i m10051a(String str, String str2) {
        m10042a(str2);
        if (str == null) {
            StringBuilder sb = this.f10755a;
            sb.append(AbstractC1191a.f2571h);
            sb.append('\n');
        } else {
            StringBuilder sb2 = this.f10755a;
            sb2.append(str);
            sb2.append('\n');
        }
        return this;
    }

    /* renamed from: a */
    public C3184i m10056a(byte[] bArr, String str) {
        m10042a(str);
        if (bArr == null) {
            StringBuilder sb = this.f10755a;
            sb.append(AbstractC1191a.f2571h);
            sb.append('\n');
            return this;
        }
        if (bArr.length == 0) {
            StringBuilder sb2 = this.f10755a;
            sb2.append(bArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        StringBuilder sb3 = this.f10755a;
        sb3.append(bArr.length);
        sb3.append(", [");
        sb3.append('\n');
        C3184i c3184i = new C3184i(this.f10755a, this.f10756b + 1);
        for (byte b2 : bArr) {
            c3184i.m10043a(b2, (String) null);
        }
        m10044a(']', (String) null);
        return this;
    }

    /* renamed from: a */
    public C3184i m10062a(short[] sArr, String str) {
        m10042a(str);
        if (sArr == null) {
            StringBuilder sb = this.f10755a;
            sb.append(AbstractC1191a.f2571h);
            sb.append('\n');
            return this;
        }
        if (sArr.length == 0) {
            StringBuilder sb2 = this.f10755a;
            sb2.append(sArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        StringBuilder sb3 = this.f10755a;
        sb3.append(sArr.length);
        sb3.append(", [");
        sb3.append('\n');
        C3184i c3184i = new C3184i(this.f10755a, this.f10756b + 1);
        for (short s : sArr) {
            c3184i.m10054a(s, (String) null);
        }
        m10044a(']', (String) null);
        return this;
    }

    /* renamed from: a */
    public C3184i m10059a(int[] iArr, String str) {
        m10042a(str);
        if (iArr == null) {
            StringBuilder sb = this.f10755a;
            sb.append(AbstractC1191a.f2571h);
            sb.append('\n');
            return this;
        }
        if (iArr.length == 0) {
            StringBuilder sb2 = this.f10755a;
            sb2.append(iArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        StringBuilder sb3 = this.f10755a;
        sb3.append(iArr.length);
        sb3.append(", [");
        sb3.append('\n');
        C3184i c3184i = new C3184i(this.f10755a, this.f10756b + 1);
        for (int i2 : iArr) {
            c3184i.m10047a(i2, (String) null);
        }
        m10044a(']', (String) null);
        return this;
    }

    /* renamed from: a */
    public C3184i m10060a(long[] jArr, String str) {
        m10042a(str);
        if (jArr == null) {
            StringBuilder sb = this.f10755a;
            sb.append(AbstractC1191a.f2571h);
            sb.append('\n');
            return this;
        }
        if (jArr.length == 0) {
            StringBuilder sb2 = this.f10755a;
            sb2.append(jArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        StringBuilder sb3 = this.f10755a;
        sb3.append(jArr.length);
        sb3.append(", [");
        sb3.append('\n');
        C3184i c3184i = new C3184i(this.f10755a, this.f10756b + 1);
        for (long j2 : jArr) {
            c3184i.m10048a(j2, (String) null);
        }
        m10044a(']', (String) null);
        return this;
    }

    /* renamed from: a */
    public C3184i m10058a(float[] fArr, String str) {
        m10042a(str);
        if (fArr == null) {
            StringBuilder sb = this.f10755a;
            sb.append(AbstractC1191a.f2571h);
            sb.append('\n');
            return this;
        }
        if (fArr.length == 0) {
            StringBuilder sb2 = this.f10755a;
            sb2.append(fArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        StringBuilder sb3 = this.f10755a;
        sb3.append(fArr.length);
        sb3.append(", [");
        sb3.append('\n');
        C3184i c3184i = new C3184i(this.f10755a, this.f10756b + 1);
        for (float f2 : fArr) {
            c3184i.m10046a(f2, (String) null);
        }
        m10044a(']', (String) null);
        return this;
    }

    /* renamed from: a */
    public C3184i m10057a(double[] dArr, String str) {
        m10042a(str);
        if (dArr == null) {
            StringBuilder sb = this.f10755a;
            sb.append(AbstractC1191a.f2571h);
            sb.append('\n');
            return this;
        }
        if (dArr.length == 0) {
            StringBuilder sb2 = this.f10755a;
            sb2.append(dArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        StringBuilder sb3 = this.f10755a;
        sb3.append(dArr.length);
        sb3.append(", [");
        sb3.append('\n');
        C3184i c3184i = new C3184i(this.f10755a, this.f10756b + 1);
        for (double d2 : dArr) {
            c3184i.m10045a(d2, (String) null);
        }
        m10044a(']', (String) null);
        return this;
    }

    /* renamed from: a */
    public <K, V> C3184i m10053a(Map<K, V> map, String str) {
        m10042a(str);
        if (map == null) {
            StringBuilder sb = this.f10755a;
            sb.append(AbstractC1191a.f2571h);
            sb.append('\n');
            return this;
        }
        if (map.isEmpty()) {
            StringBuilder sb2 = this.f10755a;
            sb2.append(map.size());
            sb2.append(", {}");
            sb2.append('\n');
            return this;
        }
        StringBuilder sb3 = this.f10755a;
        sb3.append(map.size());
        sb3.append(", {");
        sb3.append('\n');
        C3184i c3184i = new C3184i(this.f10755a, this.f10756b + 1);
        C3184i c3184i2 = new C3184i(this.f10755a, this.f10756b + 2);
        for (Map.Entry<K, V> entry : map.entrySet()) {
            c3184i.m10044a('(', (String) null);
            c3184i2.m10050a((C3184i) entry.getKey(), (String) null);
            c3184i2.m10050a((C3184i) entry.getValue(), (String) null);
            c3184i.m10044a(')', (String) null);
        }
        m10044a('}', (String) null);
        return this;
    }

    /* renamed from: a */
    public <T> C3184i m10061a(T[] tArr, String str) {
        m10042a(str);
        if (tArr == null) {
            StringBuilder sb = this.f10755a;
            sb.append(AbstractC1191a.f2571h);
            sb.append('\n');
            return this;
        }
        if (tArr.length == 0) {
            StringBuilder sb2 = this.f10755a;
            sb2.append(tArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        StringBuilder sb3 = this.f10755a;
        sb3.append(tArr.length);
        sb3.append(", [");
        sb3.append('\n');
        C3184i c3184i = new C3184i(this.f10755a, this.f10756b + 1);
        for (T t : tArr) {
            c3184i.m10050a((C3184i) t, (String) null);
        }
        m10044a(']', (String) null);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public <T> C3184i m10052a(Collection<T> collection, String str) {
        if (collection == null) {
            m10042a(str);
            StringBuilder sb = this.f10755a;
            sb.append(AbstractC1191a.f2571h);
            sb.append('\t');
            return this;
        }
        return m10061a(collection.toArray(), str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public <T> C3184i m10050a(T t, String str) {
        if (t == 0) {
            StringBuilder sb = this.f10755a;
            sb.append(AbstractC1191a.f2571h);
            sb.append('\n');
        } else if (t instanceof Byte) {
            m10043a(((Byte) t).byteValue(), str);
        } else if (t instanceof Boolean) {
            m10055a(((Boolean) t).booleanValue(), str);
        } else if (t instanceof Short) {
            m10054a(((Short) t).shortValue(), str);
        } else if (t instanceof Integer) {
            m10047a(((Integer) t).intValue(), str);
        } else if (t instanceof Long) {
            m10048a(((Long) t).longValue(), str);
        } else if (t instanceof Float) {
            m10046a(((Float) t).floatValue(), str);
        } else if (t instanceof Double) {
            m10045a(((Double) t).doubleValue(), str);
        } else if (t instanceof String) {
            m10051a((String) t, str);
        } else if (t instanceof Map) {
            m10053a((Map) t, str);
        } else if (t instanceof List) {
            m10052a((Collection) t, str);
        } else if (t instanceof AbstractC3188m) {
            m10049a((AbstractC3188m) t, str);
        } else if (t instanceof byte[]) {
            m10056a((byte[]) t, str);
        } else if (t instanceof boolean[]) {
            m10050a((C3184i) t, str);
        } else if (t instanceof short[]) {
            m10062a((short[]) t, str);
        } else if (t instanceof int[]) {
            m10059a((int[]) t, str);
        } else if (t instanceof long[]) {
            m10060a((long[]) t, str);
        } else if (t instanceof float[]) {
            m10058a((float[]) t, str);
        } else if (t instanceof double[]) {
            m10057a((double[]) t, str);
        } else if (t.getClass().isArray()) {
            m10061a((Object[]) t, str);
        } else {
            throw new C3185j("write object error: unsupport type.");
        }
        return this;
    }

    /* renamed from: a */
    public C3184i m10049a(AbstractC3188m abstractC3188m, String str) {
        m10044a('{', str);
        if (abstractC3188m == null) {
            StringBuilder sb = this.f10755a;
            sb.append('\t');
            sb.append(AbstractC1191a.f2571h);
        } else {
            abstractC3188m.mo9795a(this.f10755a, this.f10756b + 1);
        }
        m10044a('}', (String) null);
        return this;
    }
}
