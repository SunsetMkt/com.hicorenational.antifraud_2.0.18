package com.bumptech.glide.load.p118p;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.InterfaceC1593g;
import com.bumptech.glide.load.InterfaceC1600n;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1623b;
import com.bumptech.glide.util.C1873g;
import com.bumptech.glide.util.C1878l;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: ResourceCacheKey.java */
/* renamed from: com.bumptech.glide.load.p.x */
/* loaded from: classes.dex */
final class C1679x implements InterfaceC1593g {

    /* renamed from: k */
    private static final C1873g<Class<?>, byte[]> f4644k = new C1873g<>(50);

    /* renamed from: c */
    private final InterfaceC1623b f4645c;

    /* renamed from: d */
    private final InterfaceC1593g f4646d;

    /* renamed from: e */
    private final InterfaceC1593g f4647e;

    /* renamed from: f */
    private final int f4648f;

    /* renamed from: g */
    private final int f4649g;

    /* renamed from: h */
    private final Class<?> f4650h;

    /* renamed from: i */
    private final C1596j f4651i;

    /* renamed from: j */
    private final InterfaceC1600n<?> f4652j;

    C1679x(InterfaceC1623b interfaceC1623b, InterfaceC1593g interfaceC1593g, InterfaceC1593g interfaceC1593g2, int i2, int i3, InterfaceC1600n<?> interfaceC1600n, Class<?> cls, C1596j c1596j) {
        this.f4645c = interfaceC1623b;
        this.f4646d = interfaceC1593g;
        this.f4647e = interfaceC1593g2;
        this.f4648f = i2;
        this.f4649g = i3;
        this.f4652j = interfaceC1600n;
        this.f4650h = cls;
        this.f4651i = c1596j;
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    /* renamed from: a */
    public void mo3827a(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f4645c.mo3903a(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f4648f).putInt(this.f4649g).array();
        this.f4647e.mo3827a(messageDigest);
        this.f4646d.mo3827a(messageDigest);
        messageDigest.update(bArr);
        InterfaceC1600n<?> interfaceC1600n = this.f4652j;
        if (interfaceC1600n != null) {
            interfaceC1600n.mo3827a(messageDigest);
        }
        this.f4651i.mo3827a(messageDigest);
        messageDigest.update(m4209a());
        this.f4645c.put(bArr);
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    public boolean equals(Object obj) {
        if (!(obj instanceof C1679x)) {
            return false;
        }
        C1679x c1679x = (C1679x) obj;
        return this.f4649g == c1679x.f4649g && this.f4648f == c1679x.f4648f && C1878l.m5009b(this.f4652j, c1679x.f4652j) && this.f4650h.equals(c1679x.f4650h) && this.f4646d.equals(c1679x.f4646d) && this.f4647e.equals(c1679x.f4647e) && this.f4651i.equals(c1679x.f4651i);
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    public int hashCode() {
        int hashCode = (((((this.f4646d.hashCode() * 31) + this.f4647e.hashCode()) * 31) + this.f4648f) * 31) + this.f4649g;
        InterfaceC1600n<?> interfaceC1600n = this.f4652j;
        if (interfaceC1600n != null) {
            hashCode = (hashCode * 31) + interfaceC1600n.hashCode();
        }
        return (((hashCode * 31) + this.f4650h.hashCode()) * 31) + this.f4651i.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f4646d + ", signature=" + this.f4647e + ", width=" + this.f4648f + ", height=" + this.f4649g + ", decodedResourceClass=" + this.f4650h + ", transformation='" + this.f4652j + "', options=" + this.f4651i + '}';
    }

    /* renamed from: a */
    private byte[] m4209a() {
        byte[] m4977b = f4644k.m4977b(this.f4650h);
        if (m4977b != null) {
            return m4977b;
        }
        byte[] bytes = this.f4650h.getName().getBytes(InterfaceC1593g.f4191b);
        f4644k.m4978b(this.f4650h, bytes);
        return bytes;
    }
}
