package com.google.gson.b0.q;

import com.google.gson.t;
import com.google.gson.w;
import com.google.gson.x;
import com.google.gson.y;
import com.google.gson.z;
import java.io.IOException;

/* JADX INFO: compiled from: NumberTypeAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class i extends y<Number> {

    /* JADX INFO: renamed from: b */
    private static final z f3693b = b(w.LAZILY_PARSED_NUMBER);
    private final x a;

    /* JADX INFO: compiled from: NumberTypeAdapter.java */
    class a implements z {
        a() {
        }

        @Override // com.google.gson.z
        public <T> y<T> create(com.google.gson.e eVar, com.google.gson.d0.a<T> aVar) {
            if (aVar.getRawType() == Number.class) {
                return i.this;
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: NumberTypeAdapter.java */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a = new int[com.google.gson.e0.c.values().length];

        static {
            try {
                a[com.google.gson.e0.c.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.google.gson.e0.c.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.google.gson.e0.c.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private i(x xVar) {
        this.a = xVar;
    }

    public static z a(x xVar) {
        return xVar == w.LAZILY_PARSED_NUMBER ? f3693b : b(xVar);
    }

    private static z b(x xVar) {
        return new i(xVar).new a();
    }

    @Override // com.google.gson.y
    public Number read(com.google.gson.e0.a aVar) throws IOException {
        com.google.gson.e0.c cVarPeek = aVar.peek();
        int i2 = b.a[cVarPeek.ordinal()];
        if (i2 == 1) {
            aVar.r();
            return null;
        }
        if (i2 == 2 || i2 == 3) {
            return this.a.readNumber(aVar);
        }
        throw new t("Expecting number, got: " + cVarPeek + "; at path " + aVar.h());
    }

    @Override // com.google.gson.y
    /* JADX INFO: renamed from: a */
    public void write(com.google.gson.e0.d dVar, Number number) throws IOException {
        dVar.a(number);
    }
}
