package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.e */
/* loaded from: classes2.dex */
public class C3180e extends C3179d {

    /* renamed from: h */
    static HashMap<String, byte[]> f10736h;

    /* renamed from: i */
    static HashMap<String, HashMap<String, byte[]>> f10737i;

    /* renamed from: g */
    protected C3182g f10738g = new C3182g();

    /* renamed from: j */
    private int f10739j = 0;

    public C3180e() {
        this.f10738g.f10745a = (short) 2;
    }

    @Override // com.tencent.bugly.proguard.C3179d, com.tencent.bugly.proguard.C3178c
    /* renamed from: a */
    public <T> void mo10029a(String str, T t) {
        if (!str.startsWith(".")) {
            super.mo10029a(str, (String) t);
            return;
        }
        throw new IllegalArgumentException("put name can not startwith . , now is " + str);
    }

    @Override // com.tencent.bugly.proguard.C3179d
    /* renamed from: b */
    public void mo10035b() {
        super.mo10035b();
        this.f10738g.f10745a = (short) 3;
    }

    /* renamed from: c */
    public void m10040c(String str) {
        this.f10738g.f10750f = str;
    }

    /* renamed from: b */
    public void m10039b(String str) {
        this.f10738g.f10749e = str;
    }

    @Override // com.tencent.bugly.proguard.C3179d, com.tencent.bugly.proguard.C3178c
    /* renamed from: a */
    public byte[] mo10031a() {
        C3182g c3182g = this.f10738g;
        if (c3182g.f10745a == 2) {
            if (!c3182g.f10749e.equals("")) {
                if (this.f10738g.f10750f.equals("")) {
                    throw new IllegalArgumentException("funcName can not is null");
                }
            } else {
                throw new IllegalArgumentException("servantName can not is null");
            }
        } else {
            if (c3182g.f10749e == null) {
                c3182g.f10749e = "";
            }
            C3182g c3182g2 = this.f10738g;
            if (c3182g2.f10750f == null) {
                c3182g2.f10750f = "";
            }
        }
        C3187l c3187l = new C3187l(0);
        c3187l.m10096a(this.f10730c);
        if (this.f10738g.f10745a == 2) {
            c3187l.m10108a((Map) this.f10728a, 0);
        } else {
            c3187l.m10108a((Map) ((C3179d) this).f10733e, 0);
        }
        this.f10738g.f10751g = C3189n.m10125a(c3187l.m10097a());
        C3187l c3187l2 = new C3187l(0);
        c3187l2.m10096a(this.f10730c);
        m10038a(c3187l2);
        byte[] m10125a = C3189n.m10125a(c3187l2.m10097a());
        int length = m10125a.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(m10125a).flip();
        return allocate.array();
    }

    @Override // com.tencent.bugly.proguard.C3179d, com.tencent.bugly.proguard.C3178c
    /* renamed from: a */
    public void mo10030a(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                C3186k c3186k = new C3186k(bArr, 4);
                c3186k.m10074a(this.f10730c);
                m10037a(c3186k);
                if (this.f10738g.f10745a == 3) {
                    C3186k c3186k2 = new C3186k(this.f10738g.f10751g);
                    c3186k2.m10074a(this.f10730c);
                    if (f10736h == null) {
                        f10736h = new HashMap<>();
                        f10736h.put("", new byte[0]);
                    }
                    ((C3179d) this).f10733e = c3186k2.m10079a((Map) f10736h, 0, false);
                    return;
                }
                C3186k c3186k3 = new C3186k(this.f10738g.f10751g);
                c3186k3.m10074a(this.f10730c);
                if (f10737i == null) {
                    f10737i = new HashMap<>();
                    HashMap<String, byte[]> hashMap = new HashMap<>();
                    hashMap.put("", new byte[0]);
                    f10737i.put("", hashMap);
                }
                this.f10728a = c3186k3.m10079a((Map) f10737i, 0, false);
                this.f10729b = new HashMap<>();
                return;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        throw new IllegalArgumentException("decode package must include size head");
    }

    /* renamed from: a */
    public void m10036a(int i2) {
        this.f10738g.f10748d = i2;
    }

    /* renamed from: a */
    public void m10038a(C3187l c3187l) {
        this.f10738g.mo9794a(c3187l);
    }

    /* renamed from: a */
    public void m10037a(C3186k c3186k) {
        this.f10738g.mo9793a(c3186k);
    }
}
