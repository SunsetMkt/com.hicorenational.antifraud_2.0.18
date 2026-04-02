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

/* JADX INFO: compiled from: ObjectTypeAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class j extends y<Object> {

    /* JADX INFO: renamed from: c */
    private static final z f3694c = b(w.DOUBLE);
    private final com.google.gson.e a;

    /* JADX INFO: renamed from: b */
    private final x f3695b;

    /* JADX INFO: compiled from: ObjectTypeAdapter.java */
    class a implements z {
        final /* synthetic */ x a;

        a(x xVar) {
            this.a = xVar;
        }

        @Override // com.google.gson.z
        public <T> y<T> create(com.google.gson.e eVar, com.google.gson.d0.a<T> aVar) {
            if (aVar.getRawType() == Object.class) {
                return new j(eVar, this.a, null);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: ObjectTypeAdapter.java */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a = new int[com.google.gson.e0.c.values().length];

        static {
            try {
                a[com.google.gson.e0.c.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.google.gson.e0.c.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.google.gson.e0.c.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[com.google.gson.e0.c.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[com.google.gson.e0.c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[com.google.gson.e0.c.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* synthetic */ j(com.google.gson.e eVar, x xVar, a aVar) {
        this(eVar, xVar);
    }

    public static z a(x xVar) {
        return xVar == w.DOUBLE ? f3694c : b(xVar);
    }

    private static z b(x xVar) {
        return new a(xVar);
    }

    @Override // com.google.gson.y
    public Object read(com.google.gson.e0.a aVar) throws IOException {
        com.google.gson.e0.c cVarPeek = aVar.peek();
        Object objB = b(aVar, cVarPeek);
        if (objB == null) {
            return a(aVar, cVarPeek);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (aVar.j()) {
                String strQ = objB instanceof Map ? aVar.q() : null;
                com.google.gson.e0.c cVarPeek2 = aVar.peek();
                Object objB2 = b(aVar, cVarPeek2);
                boolean z = objB2 != null;
                if (objB2 == null) {
                    objB2 = a(aVar, cVarPeek2);
                }
                if (objB instanceof List) {
                    ((List) objB).add(objB2);
                } else {
                    ((Map) objB).put(strQ, objB2);
                }
                if (z) {
                    arrayDeque.addLast(objB);
                    objB = objB2;
                }
            } else {
                if (objB instanceof List) {
                    aVar.f();
                } else {
                    aVar.g();
                }
                if (arrayDeque.isEmpty()) {
                    return objB;
                }
                objB = arrayDeque.removeLast();
            }
        }
    }

    @Override // com.google.gson.y
    public void write(com.google.gson.e0.d dVar, Object obj) throws IOException {
        if (obj == null) {
            dVar.j();
            return;
        }
        y yVarA = this.a.a((Class) obj.getClass());
        if (!(yVarA instanceof j)) {
            yVarA.write(dVar, obj);
        } else {
            dVar.d();
            dVar.f();
        }
    }

    private j(com.google.gson.e eVar, x xVar) {
        this.a = eVar;
        this.f3695b = xVar;
    }

    private Object b(com.google.gson.e0.a aVar, com.google.gson.e0.c cVar) throws IOException {
        int i2 = b.a[cVar.ordinal()];
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
        int i2 = b.a[cVar.ordinal()];
        if (i2 == 3) {
            return aVar.s();
        }
        if (i2 == 4) {
            return this.f3695b.readNumber(aVar);
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
