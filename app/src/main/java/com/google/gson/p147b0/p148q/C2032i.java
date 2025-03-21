package com.google.gson.p147b0.p148q;

import com.google.gson.AbstractC2077y;
import com.google.gson.C2051e;
import com.google.gson.C2072t;
import com.google.gson.EnumC2075w;
import com.google.gson.InterfaceC2076x;
import com.google.gson.InterfaceC2078z;
import com.google.gson.p152d0.C2049a;
import com.google.gson.p153e0.C2052a;
import com.google.gson.p153e0.C2055d;
import com.google.gson.p153e0.EnumC2054c;
import java.io.IOException;

/* compiled from: NumberTypeAdapter.java */
/* renamed from: com.google.gson.b0.q.i */
/* loaded from: classes.dex */
public final class C2032i extends AbstractC2077y<Number> {

    /* renamed from: b */
    private static final InterfaceC2078z f5751b = m5454b(EnumC2075w.LAZILY_PARSED_NUMBER);

    /* renamed from: a */
    private final InterfaceC2076x f5752a;

    /* compiled from: NumberTypeAdapter.java */
    /* renamed from: com.google.gson.b0.q.i$a */
    class a implements InterfaceC2078z {
        a() {
        }

        @Override // com.google.gson.InterfaceC2078z
        public <T> AbstractC2077y<T> create(C2051e c2051e, C2049a<T> c2049a) {
            if (c2049a.getRawType() == Number.class) {
                return C2032i.this;
            }
            return null;
        }
    }

    /* compiled from: NumberTypeAdapter.java */
    /* renamed from: com.google.gson.b0.q.i$b */
    static /* synthetic */ class b {

        /* renamed from: a */
        static final /* synthetic */ int[] f5754a = new int[EnumC2054c.values().length];

        static {
            try {
                f5754a[EnumC2054c.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5754a[EnumC2054c.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5754a[EnumC2054c.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private C2032i(InterfaceC2076x interfaceC2076x) {
        this.f5752a = interfaceC2076x;
    }

    /* renamed from: a */
    public static InterfaceC2078z m5453a(InterfaceC2076x interfaceC2076x) {
        return interfaceC2076x == EnumC2075w.LAZILY_PARSED_NUMBER ? f5751b : m5454b(interfaceC2076x);
    }

    /* renamed from: b */
    private static InterfaceC2078z m5454b(InterfaceC2076x interfaceC2076x) {
        return new C2032i(interfaceC2076x).new a();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.AbstractC2077y
    /* renamed from: read */
    public Number read2(C2052a c2052a) throws IOException {
        EnumC2054c peek = c2052a.peek();
        int i2 = b.f5754a[peek.ordinal()];
        if (i2 == 1) {
            c2052a.mo5429r();
            return null;
        }
        if (i2 == 2 || i2 == 3) {
            return this.f5752a.readNumber(c2052a);
        }
        throw new C2072t("Expecting number, got: " + peek + "; at path " + c2052a.mo5421h());
    }

    @Override // com.google.gson.AbstractC2077y
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void write(C2055d c2055d, Number number) throws IOException {
        c2055d.mo5439a(number);
    }
}
