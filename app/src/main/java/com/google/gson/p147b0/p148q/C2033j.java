package com.google.gson.p147b0.p148q;

import com.google.gson.AbstractC2077y;
import com.google.gson.C2051e;
import com.google.gson.EnumC2075w;
import com.google.gson.InterfaceC2076x;
import com.google.gson.InterfaceC2078z;
import com.google.gson.p147b0.C2016i;
import com.google.gson.p152d0.C2049a;
import com.google.gson.p153e0.C2052a;
import com.google.gson.p153e0.C2055d;
import com.google.gson.p153e0.EnumC2054c;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: ObjectTypeAdapter.java */
/* renamed from: com.google.gson.b0.q.j */
/* loaded from: classes.dex */
public final class C2033j extends AbstractC2077y<Object> {

    /* renamed from: c */
    private static final InterfaceC2078z f5755c = m5458b(EnumC2075w.DOUBLE);

    /* renamed from: a */
    private final C2051e f5756a;

    /* renamed from: b */
    private final InterfaceC2076x f5757b;

    /* compiled from: ObjectTypeAdapter.java */
    /* renamed from: com.google.gson.b0.q.j$a */
    class a implements InterfaceC2078z {

        /* renamed from: a */
        final /* synthetic */ InterfaceC2076x f5758a;

        a(InterfaceC2076x interfaceC2076x) {
            this.f5758a = interfaceC2076x;
        }

        @Override // com.google.gson.InterfaceC2078z
        public <T> AbstractC2077y<T> create(C2051e c2051e, C2049a<T> c2049a) {
            a aVar = null;
            if (c2049a.getRawType() == Object.class) {
                return new C2033j(c2051e, this.f5758a, aVar);
            }
            return null;
        }
    }

    /* compiled from: ObjectTypeAdapter.java */
    /* renamed from: com.google.gson.b0.q.j$b */
    static /* synthetic */ class b {

        /* renamed from: a */
        static final /* synthetic */ int[] f5759a = new int[EnumC2054c.values().length];

        static {
            try {
                f5759a[EnumC2054c.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5759a[EnumC2054c.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5759a[EnumC2054c.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5759a[EnumC2054c.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5759a[EnumC2054c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5759a[EnumC2054c.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* synthetic */ C2033j(C2051e c2051e, InterfaceC2076x interfaceC2076x, a aVar) {
        this(c2051e, interfaceC2076x);
    }

    /* renamed from: a */
    public static InterfaceC2078z m5456a(InterfaceC2076x interfaceC2076x) {
        return interfaceC2076x == EnumC2075w.DOUBLE ? f5755c : m5458b(interfaceC2076x);
    }

    /* renamed from: b */
    private static InterfaceC2078z m5458b(InterfaceC2076x interfaceC2076x) {
        return new a(interfaceC2076x);
    }

    @Override // com.google.gson.AbstractC2077y
    /* renamed from: read */
    public Object read2(C2052a c2052a) throws IOException {
        EnumC2054c peek = c2052a.peek();
        Object m5459b = m5459b(c2052a, peek);
        if (m5459b == null) {
            return m5457a(c2052a, peek);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (c2052a.mo5423j()) {
                String mo5428q = m5459b instanceof Map ? c2052a.mo5428q() : null;
                EnumC2054c peek2 = c2052a.peek();
                Object m5459b2 = m5459b(c2052a, peek2);
                boolean z = m5459b2 != null;
                if (m5459b2 == null) {
                    m5459b2 = m5457a(c2052a, peek2);
                }
                if (m5459b instanceof List) {
                    ((List) m5459b).add(m5459b2);
                } else {
                    ((Map) m5459b).put(mo5428q, m5459b2);
                }
                if (z) {
                    arrayDeque.addLast(m5459b);
                    m5459b = m5459b2;
                }
            } else {
                if (m5459b instanceof List) {
                    c2052a.mo5419f();
                } else {
                    c2052a.mo5420g();
                }
                if (arrayDeque.isEmpty()) {
                    return m5459b;
                }
                m5459b = arrayDeque.removeLast();
            }
        }
    }

    @Override // com.google.gson.AbstractC2077y
    public void write(C2055d c2055d, Object obj) throws IOException {
        if (obj == null) {
            c2055d.mo5448j();
            return;
        }
        AbstractC2077y m5559a = this.f5756a.m5559a((Class) obj.getClass());
        if (!(m5559a instanceof C2033j)) {
            m5559a.write(c2055d, obj);
        } else {
            c2055d.mo5443d();
            c2055d.mo5447f();
        }
    }

    private C2033j(C2051e c2051e, InterfaceC2076x interfaceC2076x) {
        this.f5756a = c2051e;
        this.f5757b = interfaceC2076x;
    }

    /* renamed from: b */
    private Object m5459b(C2052a c2052a, EnumC2054c enumC2054c) throws IOException {
        int i2 = b.f5759a[enumC2054c.ordinal()];
        if (i2 == 1) {
            c2052a.mo5417c();
            return new ArrayList();
        }
        if (i2 != 2) {
            return null;
        }
        c2052a.mo5418d();
        return new C2016i();
    }

    /* renamed from: a */
    private Object m5457a(C2052a c2052a, EnumC2054c enumC2054c) throws IOException {
        int i2 = b.f5759a[enumC2054c.ordinal()];
        if (i2 == 3) {
            return c2052a.mo5430s();
        }
        if (i2 == 4) {
            return this.f5757b.readNumber(c2052a);
        }
        if (i2 == 5) {
            return Boolean.valueOf(c2052a.mo5424m());
        }
        if (i2 == 6) {
            c2052a.mo5429r();
            return null;
        }
        throw new IllegalStateException("Unexpected token: " + enumC2054c);
    }
}
