package d.b.c;

import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: Result.java */
/* JADX INFO: loaded from: classes.dex */
public final class r {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f9850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private t[] f9851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f9852d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<s, Object> f9853e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f9854f;

    public r(String str, byte[] bArr, t[] tVarArr, a aVar) {
        this(str, bArr, tVarArr, aVar, System.currentTimeMillis());
    }

    public a a() {
        return this.f9852d;
    }

    public byte[] b() {
        return this.f9850b;
    }

    public Map<s, Object> c() {
        return this.f9853e;
    }

    public t[] d() {
        return this.f9851c;
    }

    public String e() {
        return this.a;
    }

    public long f() {
        return this.f9854f;
    }

    public String toString() {
        return this.a;
    }

    public r(String str, byte[] bArr, t[] tVarArr, a aVar, long j2) {
        this.a = str;
        this.f9850b = bArr;
        this.f9851c = tVarArr;
        this.f9852d = aVar;
        this.f9853e = null;
        this.f9854f = j2;
    }

    public void a(s sVar, Object obj) {
        if (this.f9853e == null) {
            this.f9853e = new EnumMap(s.class);
        }
        this.f9853e.put(sVar, obj);
    }

    public void a(Map<s, Object> map) {
        if (map != null) {
            Map<s, Object> map2 = this.f9853e;
            if (map2 == null) {
                this.f9853e = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void a(t[] tVarArr) {
        t[] tVarArr2 = this.f9851c;
        if (tVarArr2 == null) {
            this.f9851c = tVarArr;
            return;
        }
        if (tVarArr == null || tVarArr.length <= 0) {
            return;
        }
        t[] tVarArr3 = new t[tVarArr2.length + tVarArr.length];
        System.arraycopy(tVarArr2, 0, tVarArr3, 0, tVarArr2.length);
        System.arraycopy(tVarArr, 0, tVarArr3, tVarArr2.length, tVarArr.length);
        this.f9851c = tVarArr3;
    }
}
