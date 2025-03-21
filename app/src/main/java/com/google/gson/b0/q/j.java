package com.google.gson.b0.q;

import com.google.gson.w;
import com.google.gson.x;
import com.google.gson.y;
import com.google.gson.z;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: ObjectTypeAdapter.java */
/* loaded from: classes.dex */
public final class j extends y<Object> {

    /* renamed from: c, reason: collision with root package name */
    private static final z f5578c = b(w.DOUBLE);

    /* renamed from: a, reason: collision with root package name */
    private final com.google.gson.e f5579a;

    /* renamed from: b, reason: collision with root package name */
    private final x f5580b;

    /* compiled from: ObjectTypeAdapter.java */
    class a implements z {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ x f5581a;

        a(x xVar) {
            this.f5581a = xVar;
        }

        @Override // com.google.gson.z
        public <T> y<T> create(com.google.gson.e eVar, com.google.gson.d0.a<T> aVar) {
            a aVar2 = null;
            if (aVar.getRawType() == Object.class) {
                return new j(eVar, this.f5581a, aVar2);
            }
            return null;
        }
    }

    /* compiled from: ObjectTypeAdapter.java */
    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5582a = new int[com.google.gson.e0.c.values().length];

        static {
            try {
                f5582a[com.google.gson.e0.c.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5582a[com.google.gson.e0.c.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5582a[com.google.gson.e0.c.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5582a[com.google.gson.e0.c.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5582a[com.google.gson.e0.c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5582a[com.google.gson.e0.c.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* synthetic */ j(com.google.gson.e eVar, x xVar, a aVar) {
        this(eVar, xVar);
    }

    public static z a(x xVar) {
        return xVar == w.DOUBLE ? f5578c : b(xVar);
    }

    private static z b(x xVar) {
        return new a(xVar);
    }

    @Override // com.google.gson.y
    /* renamed from: read */
    public Object read2(com.google.gson.e0.a aVar) throws IOException {
        com.google.gson.e0.c peek = aVar.peek();
        Object b2 = b(aVar, peek);
        if (b2 == null) {
            return a(aVar, peek);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (aVar.j()) {
                String q = b2 instanceof Map ? aVar.q() : null;
                com.google.gson.e0.c peek2 = aVar.peek();
                Object b3 = b(aVar, peek2);
                boolean z = b3 != null;
                if (b3 == null) {
                    b3 = a(aVar, peek2);
                }
                if (b2 instanceof List) {
                    ((List) b2).add(b3);
                } else {
                    ((Map) b2).put(q, b3);
                }
                if (z) {
                    arrayDeque.addLast(b2);
                    b2 = b3;
                }
            } else {
                if (b2 instanceof List) {
                    aVar.f();
                } else {
                    aVar.g();
                }
                if (arrayDeque.isEmpty()) {
                    return b2;
                }
                b2 = arrayDeque.removeLast();
            }
        }
    }

    @Override // com.google.gson.y
    public void write(com.google.gson.e0.d dVar, Object obj) throws IOException {
        if (obj == null) {
            dVar.j();
            return;
        }
        y a2 = this.f5579a.a((Class) obj.getClass());
        if (!(a2 instanceof j)) {
            a2.write(dVar, obj);
        } else {
            dVar.d();
            dVar.f();
        }
    }

    private j(com.google.gson.e eVar, x xVar) {
        this.f5579a = eVar;
        this.f5580b = xVar;
    }

    private Object b(com.google.gson.e0.a aVar, com.google.gson.e0.c cVar) throws IOException {
        int i2 = b.f5582a[cVar.ordinal()];
        if (i2 == 1) {
            aVar.c();
            return new ArrayList();
        }
        if (i2 != 2) {
            return null;
        }
        aVar.d();
        return new com.google.gson.b0.i();
    }

    private Object a(com.google.gson.e0.a aVar, com.google.gson.e0.c cVar) throws IOException {
        int i2 = b.f5582a[cVar.ordinal()];
        if (i2 == 3) {
            return aVar.s();
        }
        if (i2 == 4) {
            return this.f5580b.readNumber(aVar);
        }
        if (i2 == 5) {
            return Boolean.valueOf(aVar.m());
        }
        if (i2 == 6) {
            aVar.r();
            return null;
        }
        throw new IllegalStateException("Unexpected token: " + cVar);
    }
}
