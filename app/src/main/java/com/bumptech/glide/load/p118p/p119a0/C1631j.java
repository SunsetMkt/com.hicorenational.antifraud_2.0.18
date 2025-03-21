package com.bumptech.glide.load.p118p.p119a0;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.C1876j;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* compiled from: LruArrayPool.java */
/* renamed from: com.bumptech.glide.load.p.a0.j */
/* loaded from: classes.dex */
public final class C1631j implements InterfaceC1623b {

    /* renamed from: h */
    private static final int f4291h = 4194304;

    /* renamed from: i */
    @VisibleForTesting
    static final int f4292i = 8;

    /* renamed from: j */
    private static final int f4293j = 2;

    /* renamed from: b */
    private final C1629h<a, Object> f4294b;

    /* renamed from: c */
    private final b f4295c;

    /* renamed from: d */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f4296d;

    /* renamed from: e */
    private final Map<Class<?>, InterfaceC1622a<?>> f4297e;

    /* renamed from: f */
    private final int f4298f;

    /* renamed from: g */
    private int f4299g;

    /* compiled from: LruArrayPool.java */
    /* renamed from: com.bumptech.glide.load.p.a0.j$a */
    private static final class a implements InterfaceC1634m {

        /* renamed from: a */
        private final b f4300a;

        /* renamed from: b */
        int f4301b;

        /* renamed from: c */
        private Class<?> f4302c;

        a(b bVar) {
            this.f4300a = bVar;
        }

        /* renamed from: a */
        void m3949a(int i2, Class<?> cls) {
            this.f4301b = i2;
            this.f4302c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f4301b == aVar.f4301b && this.f4302c == aVar.f4302c;
        }

        public int hashCode() {
            int i2 = this.f4301b * 31;
            Class<?> cls = this.f4302c;
            return i2 + (cls != null ? cls.hashCode() : 0);
        }

        @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1634m
        public void offer() {
            this.f4300a.m3918a(this);
        }

        public String toString() {
            return "Key{size=" + this.f4301b + "array=" + this.f4302c + '}';
        }
    }

    /* compiled from: LruArrayPool.java */
    /* renamed from: com.bumptech.glide.load.p.a0.j$b */
    private static final class b extends AbstractC1625d<a> {
        b() {
        }

        /* renamed from: a */
        a m3950a(int i2, Class<?> cls) {
            a m3919b = m3919b();
            m3919b.m3949a(i2, cls);
            return m3919b;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.load.p118p.p119a0.AbstractC1625d
        /* renamed from: a */
        public a mo3916a() {
            return new a(this);
        }
    }

    @VisibleForTesting
    public C1631j() {
        this.f4294b = new C1629h<>();
        this.f4295c = new b();
        this.f4296d = new HashMap();
        this.f4297e = new HashMap();
        this.f4298f = 4194304;
    }

    /* renamed from: c */
    private boolean m3946c(int i2) {
        return i2 <= this.f4298f / 2;
    }

    /* renamed from: d */
    private boolean m3947d() {
        int i2 = this.f4299g;
        return i2 == 0 || this.f4298f / i2 >= 2;
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1623b
    @Deprecated
    /* renamed from: a */
    public <T> void mo3906a(T t, Class<T> cls) {
        put(t);
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1623b
    /* renamed from: b */
    public synchronized <T> T mo3907b(int i2, Class<T> cls) {
        Integer ceilingKey;
        ceilingKey = m3942b((Class<?>) cls).ceilingKey(Integer.valueOf(i2));
        return (T) m3940a(m3941a(i2, ceilingKey) ? this.f4295c.m3950a(ceilingKey.intValue(), cls) : this.f4295c.m3950a(i2, cls), (Class) cls);
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1623b
    public synchronized <T> void put(T t) {
        Class<?> cls = t.getClass();
        InterfaceC1622a<T> m3937a = m3937a((Class) cls);
        int mo3902a = m3937a.mo3902a(t);
        int mo3901a = m3937a.mo3901a() * mo3902a;
        if (m3946c(mo3901a)) {
            a m3950a = this.f4295c.m3950a(mo3902a, cls);
            this.f4294b.m3933a(m3950a, t);
            NavigableMap<Integer, Integer> m3942b = m3942b(cls);
            Integer num = (Integer) m3942b.get(Integer.valueOf(m3950a.f4301b));
            Integer valueOf = Integer.valueOf(m3950a.f4301b);
            int i2 = 1;
            if (num != null) {
                i2 = 1 + num.intValue();
            }
            m3942b.put(valueOf, Integer.valueOf(i2));
            this.f4299g += mo3901a;
            m3944c();
        }
    }

    /* renamed from: c */
    private void m3944c() {
        m3943b(this.f4298f);
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1623b
    /* renamed from: a */
    public synchronized <T> T mo3903a(int i2, Class<T> cls) {
        return (T) m3940a(this.f4295c.m3950a(i2, cls), (Class) cls);
    }

    /* renamed from: c */
    private void m3945c(int i2, Class<?> cls) {
        NavigableMap<Integer, Integer> m3942b = m3942b(cls);
        Integer num = (Integer) m3942b.get(Integer.valueOf(i2));
        if (num != null) {
            if (num.intValue() == 1) {
                m3942b.remove(Integer.valueOf(i2));
                return;
            } else {
                m3942b.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i2 + ", this: " + this);
    }

    /* renamed from: a */
    private <T> T m3940a(a aVar, Class<T> cls) {
        InterfaceC1622a<T> m3937a = m3937a((Class) cls);
        T t = (T) m3939a(aVar);
        if (t != null) {
            this.f4299g -= m3937a.mo3902a(t) * m3937a.mo3901a();
            m3945c(m3937a.mo3902a(t), cls);
        }
        if (t != null) {
            return t;
        }
        if (Log.isLoggable(m3937a.getTag(), 2)) {
            m3937a.getTag();
            String str = "Allocated " + aVar.f4301b + " bytes";
        }
        return m3937a.newArray(aVar.f4301b);
    }

    /* renamed from: b */
    private void m3943b(int i2) {
        while (this.f4299g > i2) {
            Object m3931a = this.f4294b.m3931a();
            C1876j.m4985a(m3931a);
            InterfaceC1622a m3938a = m3938a((C1631j) m3931a);
            this.f4299g -= m3938a.mo3902a(m3931a) * m3938a.mo3901a();
            m3945c(m3938a.mo3902a(m3931a), m3931a.getClass());
            if (Log.isLoggable(m3938a.getTag(), 2)) {
                m3938a.getTag();
                String str = "evicted: " + m3938a.mo3902a(m3931a);
            }
        }
    }

    public C1631j(int i2) {
        this.f4294b = new C1629h<>();
        this.f4295c = new b();
        this.f4296d = new HashMap();
        this.f4297e = new HashMap();
        this.f4298f = i2;
    }

    @Nullable
    /* renamed from: a */
    private <T> T m3939a(a aVar) {
        return (T) this.f4294b.m3932a((C1629h<a, Object>) aVar);
    }

    /* renamed from: a */
    private boolean m3941a(int i2, Integer num) {
        return num != null && (m3947d() || num.intValue() <= i2 * 8);
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1623b
    /* renamed from: a */
    public synchronized void mo3904a() {
        m3943b(0);
    }

    /* renamed from: b */
    private NavigableMap<Integer, Integer> m3942b(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f4296d.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f4296d.put(cls, treeMap);
        return treeMap;
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1623b
    /* renamed from: a */
    public synchronized void mo3905a(int i2) {
        try {
            if (i2 >= 40) {
                mo3904a();
            } else if (i2 >= 20 || i2 == 15) {
                m3943b(this.f4298f / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* renamed from: b */
    int m3948b() {
        int i2 = 0;
        for (Class<?> cls : this.f4296d.keySet()) {
            for (Integer num : this.f4296d.get(cls).keySet()) {
                i2 += num.intValue() * ((Integer) this.f4296d.get(cls).get(num)).intValue() * m3937a((Class) cls).mo3901a();
            }
        }
        return i2;
    }

    /* renamed from: a */
    private <T> InterfaceC1622a<T> m3938a(T t) {
        return m3937a((Class) t.getClass());
    }

    /* renamed from: a */
    private <T> InterfaceC1622a<T> m3937a(Class<T> cls) {
        InterfaceC1622a<T> interfaceC1622a = (InterfaceC1622a) this.f4297e.get(cls);
        if (interfaceC1622a == null) {
            if (cls.equals(int[].class)) {
                interfaceC1622a = new C1630i();
            } else if (cls.equals(byte[].class)) {
                interfaceC1622a = new C1628g();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.f4297e.put(cls, interfaceC1622a);
        }
        return interfaceC1622a;
    }
}
