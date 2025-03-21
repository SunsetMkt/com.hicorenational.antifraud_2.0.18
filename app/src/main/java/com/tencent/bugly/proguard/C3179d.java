package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.d */
/* loaded from: classes2.dex */
public class C3179d extends C3178c {

    /* renamed from: e */
    protected HashMap<String, byte[]> f10733e = null;

    /* renamed from: g */
    private HashMap<String, Object> f10735g = new HashMap<>();

    /* renamed from: f */
    C3186k f10734f = new C3186k();

    /* renamed from: c */
    private void m10033c(String str, Object obj) {
        this.f10735g.put(str, obj);
    }

    @Override // com.tencent.bugly.proguard.C3178c
    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo10028a(String str) {
        super.mo10028a(str);
    }

    /* renamed from: b */
    public void mo10035b() {
        this.f10733e = new HashMap<>();
    }

    @Override // com.tencent.bugly.proguard.C3178c
    /* renamed from: a */
    public <T> void mo10029a(String str, T t) {
        if (this.f10733e == null) {
            super.mo10029a(str, (String) t);
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
        C3187l c3187l = new C3187l();
        c3187l.m10096a(this.f10730c);
        c3187l.m10105a(t, 0);
        this.f10733e.put(str, C3189n.m10125a(c3187l.m10097a()));
    }

    /* renamed from: b */
    public <T> T m10034b(String str, T t) throws C3164b {
        HashMap<String, byte[]> hashMap = this.f10733e;
        if (hashMap != null) {
            if (!hashMap.containsKey(str)) {
                return null;
            }
            if (this.f10735g.containsKey(str)) {
                return (T) this.f10735g.get(str);
            }
            try {
                T t2 = (T) m10032a(this.f10733e.get(str), t);
                if (t2 != null) {
                    m10033c(str, t2);
                }
                return t2;
            } catch (Exception e2) {
                throw new C3164b(e2);
            }
        }
        if (!this.f10728a.containsKey(str)) {
            return null;
        }
        if (this.f10735g.containsKey(str)) {
            return (T) this.f10735g.get(str);
        }
        byte[] bArr = new byte[0];
        Iterator<Map.Entry<String, byte[]>> it = this.f10728a.get(str).entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<String, byte[]> next = it.next();
            next.getKey();
            bArr = next.getValue();
        }
        try {
            this.f10734f.m10084a(bArr);
            this.f10734f.m10074a(this.f10730c);
            T t3 = (T) this.f10734f.m10077a((C3186k) t, 0, true);
            m10033c(str, t3);
            return t3;
        } catch (Exception e3) {
            throw new C3164b(e3);
        }
    }

    /* renamed from: a */
    private Object m10032a(byte[] bArr, Object obj) {
        this.f10734f.m10084a(bArr);
        this.f10734f.m10074a(this.f10730c);
        return this.f10734f.m10077a((C3186k) obj, 0, true);
    }

    @Override // com.tencent.bugly.proguard.C3178c
    /* renamed from: a */
    public byte[] mo10031a() {
        if (this.f10733e != null) {
            C3187l c3187l = new C3187l(0);
            c3187l.m10096a(this.f10730c);
            c3187l.m10108a((Map) this.f10733e, 0);
            return C3189n.m10125a(c3187l.m10097a());
        }
        return super.mo10031a();
    }

    @Override // com.tencent.bugly.proguard.C3178c
    /* renamed from: a */
    public void mo10030a(byte[] bArr) {
        try {
            super.mo10030a(bArr);
        } catch (Exception unused) {
            this.f10734f.m10084a(bArr);
            this.f10734f.m10074a(this.f10730c);
            HashMap hashMap = new HashMap(1);
            hashMap.put("", new byte[0]);
            this.f10733e = this.f10734f.m10079a((Map) hashMap, 0, false);
        }
    }
}
