package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class e extends d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static HashMap<String, byte[]> f6522h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static HashMap<String, HashMap<String, byte[]>> f6523i;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected g f6524g = new g();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f6525j = 0;

    public e() {
        this.f6524g.a = (short) 2;
    }

    @Override // com.tencent.bugly.proguard.d, com.tencent.bugly.proguard.c
    public <T> void a(String str, T t) {
        if (!str.startsWith(".")) {
            super.a(str, t);
            return;
        }
        throw new IllegalArgumentException("put name can not startwith . , now is " + str);
    }

    @Override // com.tencent.bugly.proguard.d
    public void b() {
        super.b();
        this.f6524g.a = (short) 3;
    }

    public void c(String str) {
        this.f6524g.f6534f = str;
    }

    public void b(String str) {
        this.f6524g.f6533e = str;
    }

    @Override // com.tencent.bugly.proguard.d, com.tencent.bugly.proguard.c
    public byte[] a() {
        g gVar = this.f6524g;
        if (gVar.a == 2) {
            if (!gVar.f6533e.equals("")) {
                if (this.f6524g.f6534f.equals("")) {
                    throw new IllegalArgumentException("funcName can not is null");
                }
            } else {
                throw new IllegalArgumentException("servantName can not is null");
            }
        } else {
            if (gVar.f6533e == null) {
                gVar.f6533e = "";
            }
            g gVar2 = this.f6524g;
            if (gVar2.f6534f == null) {
                gVar2.f6534f = "";
            }
        }
        l lVar = new l(0);
        lVar.a(this.f6516c);
        if (this.f6524g.a == 2) {
            lVar.a((Map) this.a, 0);
        } else {
            lVar.a((Map) ((d) this).f6519e, 0);
        }
        this.f6524g.f6535g = n.a(lVar.a());
        l lVar2 = new l(0);
        lVar2.a(this.f6516c);
        a(lVar2);
        byte[] bArrA = n.a(lVar2.a());
        int length = bArrA.length + 4;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        byteBufferAllocate.putInt(length).put(bArrA).flip();
        return byteBufferAllocate.array();
    }

    @Override // com.tencent.bugly.proguard.d, com.tencent.bugly.proguard.c
    public void a(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                k kVar = new k(bArr, 4);
                kVar.a(this.f6516c);
                a(kVar);
                if (this.f6524g.a == 3) {
                    k kVar2 = new k(this.f6524g.f6535g);
                    kVar2.a(this.f6516c);
                    if (f6522h == null) {
                        f6522h = new HashMap<>();
                        f6522h.put("", new byte[0]);
                    }
                    ((d) this).f6519e = kVar2.a((Map) f6522h, 0, false);
                    return;
                }
                k kVar3 = new k(this.f6524g.f6535g);
                kVar3.a(this.f6516c);
                if (f6523i == null) {
                    f6523i = new HashMap<>();
                    HashMap<String, byte[]> map = new HashMap<>();
                    map.put("", new byte[0]);
                    f6523i.put("", map);
                }
                this.a = kVar3.a((Map) f6523i, 0, false);
                this.f6515b = new HashMap<>();
                return;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        throw new IllegalArgumentException("decode package must include size head");
    }

    public void a(int i2) {
        this.f6524g.f6532d = i2;
    }

    public void a(l lVar) {
        this.f6524g.a(lVar);
    }

    public void a(k kVar) {
        this.f6524g.a(kVar);
    }
}
