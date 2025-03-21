package com.bumptech.glide.load.p118p;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.InterfaceC1593g;
import com.bumptech.glide.load.InterfaceC1600n;
import com.bumptech.glide.util.C1876j;
import java.security.MessageDigest;
import java.util.Map;

/* compiled from: EngineKey.java */
/* renamed from: com.bumptech.glide.load.p.n */
/* loaded from: classes.dex */
class C1669n implements InterfaceC1593g {

    /* renamed from: c */
    private final Object f4602c;

    /* renamed from: d */
    private final int f4603d;

    /* renamed from: e */
    private final int f4604e;

    /* renamed from: f */
    private final Class<?> f4605f;

    /* renamed from: g */
    private final Class<?> f4606g;

    /* renamed from: h */
    private final InterfaceC1593g f4607h;

    /* renamed from: i */
    private final Map<Class<?>, InterfaceC1600n<?>> f4608i;

    /* renamed from: j */
    private final C1596j f4609j;

    /* renamed from: k */
    private int f4610k;

    C1669n(Object obj, InterfaceC1593g interfaceC1593g, int i2, int i3, Map<Class<?>, InterfaceC1600n<?>> map, Class<?> cls, Class<?> cls2, C1596j c1596j) {
        this.f4602c = C1876j.m4985a(obj);
        this.f4607h = (InterfaceC1593g) C1876j.m4986a(interfaceC1593g, "Signature must not be null");
        this.f4603d = i2;
        this.f4604e = i3;
        this.f4608i = (Map) C1876j.m4985a(map);
        this.f4605f = (Class) C1876j.m4986a(cls, "Resource class must not be null");
        this.f4606g = (Class) C1876j.m4986a(cls2, "Transcode class must not be null");
        this.f4609j = (C1596j) C1876j.m4985a(c1596j);
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    /* renamed from: a */
    public void mo3827a(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    public boolean equals(Object obj) {
        if (!(obj instanceof C1669n)) {
            return false;
        }
        C1669n c1669n = (C1669n) obj;
        return this.f4602c.equals(c1669n.f4602c) && this.f4607h.equals(c1669n.f4607h) && this.f4604e == c1669n.f4604e && this.f4603d == c1669n.f4603d && this.f4608i.equals(c1669n.f4608i) && this.f4605f.equals(c1669n.f4605f) && this.f4606g.equals(c1669n.f4606g) && this.f4609j.equals(c1669n.f4609j);
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    public int hashCode() {
        if (this.f4610k == 0) {
            this.f4610k = this.f4602c.hashCode();
            this.f4610k = (this.f4610k * 31) + this.f4607h.hashCode();
            this.f4610k = (this.f4610k * 31) + this.f4603d;
            this.f4610k = (this.f4610k * 31) + this.f4604e;
            this.f4610k = (this.f4610k * 31) + this.f4608i.hashCode();
            this.f4610k = (this.f4610k * 31) + this.f4605f.hashCode();
            this.f4610k = (this.f4610k * 31) + this.f4606g.hashCode();
            this.f4610k = (this.f4610k * 31) + this.f4609j.hashCode();
        }
        return this.f4610k;
    }

    public String toString() {
        return "EngineKey{model=" + this.f4602c + ", width=" + this.f4603d + ", height=" + this.f4604e + ", resourceClass=" + this.f4605f + ", transcodeClass=" + this.f4606g + ", signature=" + this.f4607h + ", hashCode=" + this.f4610k + ", transformations=" + this.f4608i + ", options=" + this.f4609j + '}';
    }
}
