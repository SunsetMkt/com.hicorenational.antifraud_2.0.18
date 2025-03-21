package com.google.gson;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* compiled from: JsonParser.java */
/* loaded from: classes.dex */
public final class o {
    @Deprecated
    public o() {
    }

    public static k b(String str) throws t {
        return b(new StringReader(str));
    }

    @Deprecated
    public k a(String str) throws t {
        return b(str);
    }

    public static k b(Reader reader) throws l, t {
        try {
            com.google.gson.e0.a aVar = new com.google.gson.e0.a(reader);
            k b2 = b(aVar);
            if (!b2.isJsonNull() && aVar.peek() != com.google.gson.e0.c.END_DOCUMENT) {
                throw new t("Did not consume the entire document.");
            }
            return b2;
        } catch (com.google.gson.e0.e e2) {
            throw new t(e2);
        } catch (IOException e3) {
            throw new l(e3);
        } catch (NumberFormatException e4) {
            throw new t(e4);
        }
    }

    @Deprecated
    public k a(Reader reader) throws l, t {
        return b(reader);
    }

    @Deprecated
    public k a(com.google.gson.e0.a aVar) throws l, t {
        return b(aVar);
    }

    public static k b(com.google.gson.e0.a aVar) throws l, t {
        boolean k2 = aVar.k();
        aVar.a(true);
        try {
            try {
                return com.google.gson.b0.o.a(aVar);
            } catch (OutOfMemoryError e2) {
                throw new n("Failed parsing JSON source: " + aVar + " to Json", e2);
            } catch (StackOverflowError e3) {
                throw new n("Failed parsing JSON source: " + aVar + " to Json", e3);
            }
        } finally {
            aVar.a(k2);
        }
    }
}
