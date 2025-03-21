package com.google.gson;

import com.google.gson.p147b0.C2015h;
import com.google.gson.p153e0.C2052a;
import com.google.gson.p153e0.C2056e;
import java.io.IOException;
import java.math.BigDecimal;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ToNumberPolicy.java */
/* renamed from: com.google.gson.w */
/* loaded from: classes.dex */
public abstract class EnumC2075w implements InterfaceC2076x {
    public static final EnumC2075w DOUBLE = new a("DOUBLE", 0);
    public static final EnumC2075w LAZILY_PARSED_NUMBER = new EnumC2075w("LAZILY_PARSED_NUMBER", 1) { // from class: com.google.gson.w.b
        {
            a aVar = null;
        }

        @Override // com.google.gson.InterfaceC2076x
        public Number readNumber(C2052a c2052a) throws IOException {
            return new C2015h(c2052a.mo5430s());
        }
    };
    public static final EnumC2075w LONG_OR_DOUBLE = new EnumC2075w("LONG_OR_DOUBLE", 2) { // from class: com.google.gson.w.c
        {
            a aVar = null;
        }

        @Override // com.google.gson.InterfaceC2076x
        public Number readNumber(C2052a c2052a) throws IOException, C2066n {
            String mo5430s = c2052a.mo5430s();
            try {
                try {
                    return Long.valueOf(Long.parseLong(mo5430s));
                } catch (NumberFormatException unused) {
                    Double valueOf = Double.valueOf(mo5430s);
                    if ((!valueOf.isInfinite() && !valueOf.isNaN()) || c2052a.m5611k()) {
                        return valueOf;
                    }
                    throw new C2056e("JSON forbids NaN and infinities: " + valueOf + "; at path " + c2052a.mo5422i());
                }
            } catch (NumberFormatException e2) {
                throw new C2066n("Cannot parse " + mo5430s + "; at path " + c2052a.mo5422i(), e2);
            }
        }
    };
    public static final EnumC2075w BIG_DECIMAL = new EnumC2075w("BIG_DECIMAL", 3) { // from class: com.google.gson.w.d
        {
            a aVar = null;
        }

        @Override // com.google.gson.InterfaceC2076x
        public BigDecimal readNumber(C2052a c2052a) throws IOException {
            String mo5430s = c2052a.mo5430s();
            try {
                return new BigDecimal(mo5430s);
            } catch (NumberFormatException e2) {
                throw new C2066n("Cannot parse " + mo5430s + "; at path " + c2052a.mo5422i(), e2);
            }
        }
    };

    /* renamed from: a */
    private static final /* synthetic */ EnumC2075w[] f6036a = {DOUBLE, LAZILY_PARSED_NUMBER, LONG_OR_DOUBLE, BIG_DECIMAL};

    /* compiled from: ToNumberPolicy.java */
    /* renamed from: com.google.gson.w$a */
    enum a extends EnumC2075w {
        a(String str, int i2) {
            super(str, i2, null);
        }

        @Override // com.google.gson.InterfaceC2076x
        public Double readNumber(C2052a c2052a) throws IOException {
            return Double.valueOf(c2052a.mo5425n());
        }
    }

    private EnumC2075w(String str, int i2) {
    }

    public static EnumC2075w valueOf(String str) {
        return (EnumC2075w) Enum.valueOf(EnumC2075w.class, str);
    }

    public static EnumC2075w[] values() {
        return (EnumC2075w[]) f6036a.clone();
    }

    /* synthetic */ EnumC2075w(String str, int i2, a aVar) {
        this(str, i2);
    }
}
