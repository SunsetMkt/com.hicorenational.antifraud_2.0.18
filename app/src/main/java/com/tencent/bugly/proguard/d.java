package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class d extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected HashMap<String, byte[]> f6519e = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private HashMap<String, Object> f6521g = new HashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    k f6520f = new k();

    private void c(String str, Object obj) {
        this.f6521g.put(str, obj);
    }

    @Override // com.tencent.bugly.proguard.c
    public /* bridge */ /* synthetic */ void a(String str) {
        super.a(str);
    }

    public void b() {
        this.f6519e = new HashMap<>();
    }

    @Override // com.tencent.bugly.proguard.c
    public <T> void a(String str, T t) {
        if (this.f6519e == null) {
            super.a(str, t);
            return;
        }
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        }
        if (t instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        }
        l lVar = new l();
        lVar.a(this.f6516c);
        lVar.a(t, 0);
        this.f6519e.put(str, n.a(lVar.a()));
    }

    public <T> T b(String str, T t) throws b {
        HashMap<String, byte[]> map = this.f6519e;
        if (map != null) {
            if (!map.containsKey(str)) {
                return null;
            }
            if (this.f6521g.containsKey(str)) {
                return (T) this.f6521g.get(str);
            }
            try {
                T t2 = (T) a(this.f6519e.get(str), t);
                if (t2 != null) {
                    c(str, t2);
                }
                return t2;
            } catch (Exception e2) {
                throw new b(e2);
            }
        }
        if (!this.a.containsKey(str)) {
            return null;
        }
        if (this.f6521g.containsKey(str)) {
            return (T) this.f6521g.get(str);
        }
        byte[] value = new byte[0];
        Iterator<Map.Entry<String, byte[]>> it = this.a.get(str).entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<String, byte[]> next = it.next();
            next.getKey();
            value = next.getValue();
        }
        try {
            this.f6520f.a(value);
            this.f6520f.a(this.f6516c);
            T t3 = (T) this.f6520f.a((Object) t, 0, true);
            c(str, t3);
            return t3;
        } catch (Exception e3) {
            throw new b(e3);
        }
    }

    private Object a(byte[] bArr, Object obj) {
        this.f6520f.a(bArr);
        this.f6520f.a(this.f6516c);
        return this.f6520f.a(obj, 0, true);
    }

    @Override // com.tencent.bugly.proguard.c
    public byte[] a() {
        if (this.f6519e != null) {
            l lVar = new l(0);
            lVar.a(this.f6516c);
            lVar.a((Map) this.f6519e, 0);
            return n.a(lVar.a());
        }
        return super.a();
    }

    @Override // com.tencent.bugly.proguard.c
    public void a(byte[] bArr) {
        try {
            super.a(bArr);
        } catch (Exception unused) {
            this.f6520f.a(bArr);
            this.f6520f.a(this.f6516c);
            HashMap map = new HashMap(1);
            map.put("", new byte[0]);
            this.f6519e = this.f6520f.a((Map) map, 0, false);
        }
    }
}
