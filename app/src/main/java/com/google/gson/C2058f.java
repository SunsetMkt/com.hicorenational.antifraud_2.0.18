package com.google.gson;

import com.google.gson.p147b0.C2008a;
import com.google.gson.p147b0.C2011d;
import com.google.gson.p147b0.p148q.C2027d;
import com.google.gson.p147b0.p148q.C2036m;
import com.google.gson.p147b0.p148q.C2038o;
import com.google.gson.p147b0.p151t.C2045d;
import com.google.gson.p152d0.C2049a;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: GsonBuilder.java */
/* renamed from: com.google.gson.f */
/* loaded from: classes.dex */
public final class C2058f {

    /* renamed from: a */
    private C2011d f6005a;

    /* renamed from: b */
    private EnumC2073u f6006b;

    /* renamed from: c */
    private InterfaceC2048d f6007c;

    /* renamed from: d */
    private final Map<Type, InterfaceC2059g<?>> f6008d;

    /* renamed from: e */
    private final List<InterfaceC2078z> f6009e;

    /* renamed from: f */
    private final List<InterfaceC2078z> f6010f;

    /* renamed from: g */
    private boolean f6011g;

    /* renamed from: h */
    private String f6012h;

    /* renamed from: i */
    private int f6013i;

    /* renamed from: j */
    private int f6014j;

    /* renamed from: k */
    private boolean f6015k;

    /* renamed from: l */
    private boolean f6016l;

    /* renamed from: m */
    private boolean f6017m;

    /* renamed from: n */
    private boolean f6018n;

    /* renamed from: o */
    private boolean f6019o;

    /* renamed from: p */
    private boolean f6020p;

    /* renamed from: q */
    private boolean f6021q;

    /* renamed from: r */
    private InterfaceC2076x f6022r;

    /* renamed from: s */
    private InterfaceC2076x f6023s;

    /* renamed from: t */
    private final LinkedList<InterfaceC2074v> f6024t;

    public C2058f() {
        this.f6005a = C2011d.f5672h;
        this.f6006b = EnumC2073u.DEFAULT;
        this.f6007c = EnumC2046c.IDENTITY;
        this.f6008d = new HashMap();
        this.f6009e = new ArrayList();
        this.f6010f = new ArrayList();
        this.f6011g = false;
        this.f6012h = C2051e.f5905H;
        this.f6013i = 2;
        this.f6014j = 2;
        this.f6015k = false;
        this.f6016l = false;
        this.f6017m = true;
        this.f6018n = false;
        this.f6019o = false;
        this.f6020p = false;
        this.f6021q = true;
        this.f6022r = C2051e.f5907J;
        this.f6023s = C2051e.f5908K;
        this.f6024t = new LinkedList<>();
    }

    /* renamed from: a */
    public C2058f m5632a(double d2) {
        if (!Double.isNaN(d2) && d2 >= 0.0d) {
            this.f6005a = this.f6005a.m5349a(d2);
            return this;
        }
        throw new IllegalArgumentException("Invalid version: " + d2);
    }

    /* renamed from: b */
    public C2058f m5649b(InterfaceC2076x interfaceC2076x) {
        this.f6022r = (InterfaceC2076x) Objects.requireNonNull(interfaceC2076x);
        return this;
    }

    /* renamed from: c */
    public C2058f m5650c() {
        this.f6005a = this.f6005a.m5348a();
        return this;
    }

    /* renamed from: d */
    public C2058f m5651d() {
        this.f6021q = false;
        return this;
    }

    /* renamed from: e */
    public C2058f m5652e() {
        this.f6015k = true;
        return this;
    }

    /* renamed from: f */
    public C2058f m5653f() {
        this.f6005a = this.f6005a.m5354b();
        return this;
    }

    /* renamed from: g */
    public C2058f m5654g() {
        this.f6019o = true;
        return this;
    }

    /* renamed from: h */
    public C2058f m5655h() {
        this.f6011g = true;
        return this;
    }

    /* renamed from: i */
    public C2058f m5656i() {
        this.f6016l = true;
        return this;
    }

    /* renamed from: j */
    public C2058f m5657j() {
        this.f6020p = true;
        return this;
    }

    /* renamed from: k */
    public C2058f m5658k() {
        this.f6018n = true;
        return this;
    }

    /* renamed from: b */
    public C2058f m5648b(InterfaceC2000a interfaceC2000a) {
        Objects.requireNonNull(interfaceC2000a);
        this.f6005a = this.f6005a.m5350a(interfaceC2000a, true, false);
        return this;
    }

    /* renamed from: a */
    public C2058f m5645a(int... iArr) {
        Objects.requireNonNull(iArr);
        this.f6005a = this.f6005a.m5351a(iArr);
        return this;
    }

    /* renamed from: b */
    public C2058f m5647b() {
        this.f6017m = false;
        return this;
    }

    /* renamed from: a */
    public C2058f m5638a(EnumC2073u enumC2073u) {
        this.f6006b = (EnumC2073u) Objects.requireNonNull(enumC2073u);
        return this;
    }

    /* renamed from: a */
    public C2058f m5636a(EnumC2046c enumC2046c) {
        return m5637a((InterfaceC2048d) enumC2046c);
    }

    /* renamed from: a */
    public C2058f m5637a(InterfaceC2048d interfaceC2048d) {
        this.f6007c = (InterfaceC2048d) Objects.requireNonNull(interfaceC2048d);
        return this;
    }

    /* renamed from: a */
    public C2058f m5640a(InterfaceC2076x interfaceC2076x) {
        this.f6023s = (InterfaceC2076x) Objects.requireNonNull(interfaceC2076x);
        return this;
    }

    /* renamed from: a */
    public C2058f m5646a(InterfaceC2000a... interfaceC2000aArr) {
        Objects.requireNonNull(interfaceC2000aArr);
        for (InterfaceC2000a interfaceC2000a : interfaceC2000aArr) {
            this.f6005a = this.f6005a.m5350a(interfaceC2000a, true, true);
        }
        return this;
    }

    /* renamed from: a */
    public C2058f m5635a(InterfaceC2000a interfaceC2000a) {
        Objects.requireNonNull(interfaceC2000a);
        this.f6005a = this.f6005a.m5350a(interfaceC2000a, false, true);
        return this;
    }

    /* renamed from: a */
    public C2058f m5643a(String str) {
        this.f6012h = str;
        return this;
    }

    /* renamed from: a */
    public C2058f m5633a(int i2) {
        this.f6013i = i2;
        this.f6012h = null;
        return this;
    }

    /* renamed from: a */
    public C2058f m5634a(int i2, int i3) {
        this.f6013i = i2;
        this.f6014j = i3;
        this.f6012h = null;
        return this;
    }

    /* renamed from: a */
    public C2058f m5644a(Type type, Object obj) {
        Objects.requireNonNull(type);
        boolean z = obj instanceof InterfaceC2070r;
        C2008a.m5311a(z || (obj instanceof InterfaceC2062j) || (obj instanceof InterfaceC2059g) || (obj instanceof AbstractC2077y));
        if (obj instanceof InterfaceC2059g) {
            this.f6008d.put(type, (InterfaceC2059g) obj);
        }
        if (z || (obj instanceof InterfaceC2062j)) {
            this.f6009e.add(C2036m.m5477b(C2049a.get(type), obj));
        }
        if (obj instanceof AbstractC2077y) {
            this.f6009e.add(C2038o.m5483a(C2049a.get(type), (AbstractC2077y) obj));
        }
        return this;
    }

    C2058f(C2051e c2051e) {
        this.f6005a = C2011d.f5672h;
        this.f6006b = EnumC2073u.DEFAULT;
        this.f6007c = EnumC2046c.IDENTITY;
        this.f6008d = new HashMap();
        this.f6009e = new ArrayList();
        this.f6010f = new ArrayList();
        this.f6011g = false;
        this.f6012h = C2051e.f5905H;
        this.f6013i = 2;
        this.f6014j = 2;
        this.f6015k = false;
        this.f6016l = false;
        this.f6017m = true;
        this.f6018n = false;
        this.f6019o = false;
        this.f6020p = false;
        this.f6021q = true;
        this.f6022r = C2051e.f5907J;
        this.f6023s = C2051e.f5908K;
        this.f6024t = new LinkedList<>();
        this.f6005a = c2051e.f5916f;
        this.f6007c = c2051e.f5917g;
        this.f6008d.putAll(c2051e.f5918h);
        this.f6011g = c2051e.f5919i;
        this.f6015k = c2051e.f5920j;
        this.f6019o = c2051e.f5921k;
        this.f6017m = c2051e.f5922l;
        this.f6018n = c2051e.f5923m;
        this.f6020p = c2051e.f5924n;
        this.f6016l = c2051e.f5925o;
        this.f6006b = c2051e.f5930t;
        this.f6012h = c2051e.f5927q;
        this.f6013i = c2051e.f5928r;
        this.f6014j = c2051e.f5929s;
        this.f6009e.addAll(c2051e.f5931u);
        this.f6010f.addAll(c2051e.f5932v);
        this.f6021q = c2051e.f5926p;
        this.f6022r = c2051e.f5933w;
        this.f6023s = c2051e.f5934x;
        this.f6024t.addAll(c2051e.f5935y);
    }

    /* renamed from: a */
    public C2058f m5641a(InterfaceC2078z interfaceC2078z) {
        Objects.requireNonNull(interfaceC2078z);
        this.f6009e.add(interfaceC2078z);
        return this;
    }

    /* renamed from: a */
    public C2058f m5642a(Class<?> cls, Object obj) {
        Objects.requireNonNull(cls);
        boolean z = obj instanceof InterfaceC2070r;
        C2008a.m5311a(z || (obj instanceof InterfaceC2062j) || (obj instanceof AbstractC2077y));
        if ((obj instanceof InterfaceC2062j) || z) {
            this.f6010f.add(C2036m.m5475a(cls, obj));
        }
        if (obj instanceof AbstractC2077y) {
            this.f6009e.add(C2038o.m5486b(cls, (AbstractC2077y) obj));
        }
        return this;
    }

    /* renamed from: a */
    public C2058f m5639a(InterfaceC2074v interfaceC2074v) {
        Objects.requireNonNull(interfaceC2074v);
        this.f6024t.addFirst(interfaceC2074v);
        return this;
    }

    /* renamed from: a */
    public C2051e m5631a() {
        List<InterfaceC2078z> arrayList = new ArrayList<>(this.f6009e.size() + this.f6010f.size() + 3);
        arrayList.addAll(this.f6009e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f6010f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        m5630a(this.f6012h, this.f6013i, this.f6014j, arrayList);
        return new C2051e(this.f6005a, this.f6007c, new HashMap(this.f6008d), this.f6011g, this.f6015k, this.f6019o, this.f6017m, this.f6018n, this.f6020p, this.f6016l, this.f6021q, this.f6006b, this.f6012h, this.f6013i, this.f6014j, new ArrayList(this.f6009e), new ArrayList(this.f6010f), arrayList, this.f6022r, this.f6023s, new ArrayList(this.f6024t));
    }

    /* renamed from: a */
    private void m5630a(String str, int i2, int i3, List<InterfaceC2078z> list) {
        InterfaceC2078z m5406a;
        InterfaceC2078z m5406a2;
        boolean z = C2045d.f5891a;
        InterfaceC2078z interfaceC2078z = null;
        if (str != null && !str.trim().isEmpty()) {
            InterfaceC2078z m5407a = C2027d.b.f5730b.m5407a(str);
            if (z) {
                interfaceC2078z = C2045d.f5893c.m5407a(str);
                m5406a2 = C2045d.f5892b.m5407a(str);
                m5406a = m5407a;
            } else {
                m5406a = m5407a;
                m5406a2 = null;
            }
        } else {
            if (i2 == 2 || i3 == 2) {
                return;
            }
            m5406a = C2027d.b.f5730b.m5406a(i2, i3);
            if (z) {
                interfaceC2078z = C2045d.f5893c.m5406a(i2, i3);
                m5406a2 = C2045d.f5892b.m5406a(i2, i3);
            }
            m5406a2 = null;
        }
        list.add(m5406a);
        if (z) {
            list.add(interfaceC2078z);
            list.add(m5406a2);
        }
    }
}
