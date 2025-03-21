package com.google.gson;

import com.google.gson.p147b0.C2022o;
import com.google.gson.p153e0.C2055d;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: JsonElement.java */
/* renamed from: com.google.gson.k */
/* loaded from: classes.dex */
public abstract class AbstractC2063k {
    @Deprecated
    public AbstractC2063k() {
    }

    public abstract AbstractC2063k deepCopy();

    public BigDecimal getAsBigDecimal() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public BigInteger getAsBigInteger() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean getAsBoolean() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public byte getAsByte() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    @Deprecated
    public char getAsCharacter() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double getAsDouble() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public float getAsFloat() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int getAsInt() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public C2060h getAsJsonArray() {
        if (isJsonArray()) {
            return (C2060h) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public C2065m getAsJsonNull() {
        if (isJsonNull()) {
            return (C2065m) this;
        }
        throw new IllegalStateException("Not a JSON Null: " + this);
    }

    public JsonObject getAsJsonObject() {
        if (isJsonObject()) {
            return (JsonObject) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public C2068p getAsJsonPrimitive() {
        if (isJsonPrimitive()) {
            return (C2068p) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public long getAsLong() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number getAsNumber() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public short getAsShort() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String getAsString() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean isJsonArray() {
        return this instanceof C2060h;
    }

    public boolean isJsonNull() {
        return this instanceof C2065m;
    }

    public boolean isJsonObject() {
        return this instanceof JsonObject;
    }

    public boolean isJsonPrimitive() {
        return this instanceof C2068p;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            C2055d c2055d = new C2055d(stringWriter);
            c2055d.m5624b(true);
            C2022o.m5392a(this, c2055d);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
