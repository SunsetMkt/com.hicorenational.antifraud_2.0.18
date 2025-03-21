package com.google.gson;

import com.google.gson.p147b0.C2022o;
import com.google.gson.p153e0.C2052a;
import com.google.gson.p153e0.C2056e;
import com.google.gson.p153e0.EnumC2054c;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* compiled from: JsonParser.java */
/* renamed from: com.google.gson.o */
/* loaded from: classes.dex */
public final class C2067o {
    @Deprecated
    public C2067o() {
    }

    /* renamed from: b */
    public static AbstractC2063k m5674b(String str) throws C2072t {
        return m5673b(new StringReader(str));
    }

    @Deprecated
    /* renamed from: a */
    public AbstractC2063k m5677a(String str) throws C2072t {
        return m5674b(str);
    }

    /* renamed from: b */
    public static AbstractC2063k m5673b(Reader reader) throws C2064l, C2072t {
        try {
            C2052a c2052a = new C2052a(reader);
            AbstractC2063k m5672b = m5672b(c2052a);
            if (!m5672b.isJsonNull() && c2052a.peek() != EnumC2054c.END_DOCUMENT) {
                throw new C2072t("Did not consume the entire document.");
            }
            return m5672b;
        } catch (C2056e e2) {
            throw new C2072t(e2);
        } catch (IOException e3) {
            throw new C2064l(e3);
        } catch (NumberFormatException e4) {
            throw new C2072t(e4);
        }
    }

    @Deprecated
    /* renamed from: a */
    public AbstractC2063k m5676a(Reader reader) throws C2064l, C2072t {
        return m5673b(reader);
    }

    @Deprecated
    /* renamed from: a */
    public AbstractC2063k m5675a(C2052a c2052a) throws C2064l, C2072t {
        return m5672b(c2052a);
    }

    /* renamed from: b */
    public static AbstractC2063k m5672b(C2052a c2052a) throws C2064l, C2072t {
        boolean m5611k = c2052a.m5611k();
        c2052a.m5609a(true);
        try {
            try {
                return C2022o.m5390a(c2052a);
            } catch (OutOfMemoryError e2) {
                throw new C2066n("Failed parsing JSON source: " + c2052a + " to Json", e2);
            } catch (StackOverflowError e3) {
                throw new C2066n("Failed parsing JSON source: " + c2052a + " to Json", e3);
            }
        } finally {
            c2052a.m5609a(m5611k);
        }
    }
}
