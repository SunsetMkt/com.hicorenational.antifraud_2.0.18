package com.google.gson;

import com.google.gson.p147b0.C2015h;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/* compiled from: JsonPrimitive.java */
/* renamed from: com.google.gson.p */
/* loaded from: classes.dex */
public final class C2068p extends AbstractC2063k {

    /* renamed from: a */
    private final Object f6027a;

    public C2068p(Boolean bool) {
        this.f6027a = Objects.requireNonNull(bool);
    }

    /* renamed from: a */
    public boolean m5679a() {
        return this.f6027a instanceof Boolean;
    }

    /* renamed from: b */
    public boolean m5680b() {
        return this.f6027a instanceof Number;
    }

    /* renamed from: c */
    public boolean m5681c() {
        return this.f6027a instanceof String;
    }

    @Override // com.google.gson.AbstractC2063k
    public C2068p deepCopy() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2068p.class != obj.getClass()) {
            return false;
        }
        C2068p c2068p = (C2068p) obj;
        if (this.f6027a == null) {
            return c2068p.f6027a == null;
        }
        if (m5678a(this) && m5678a(c2068p)) {
            return getAsNumber().longValue() == c2068p.getAsNumber().longValue();
        }
        if (!(this.f6027a instanceof Number) || !(c2068p.f6027a instanceof Number)) {
            return this.f6027a.equals(c2068p.f6027a);
        }
        double doubleValue = getAsNumber().doubleValue();
        double doubleValue2 = c2068p.getAsNumber().doubleValue();
        if (doubleValue != doubleValue2) {
            return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
        }
        return true;
    }

    @Override // com.google.gson.AbstractC2063k
    public BigDecimal getAsBigDecimal() {
        Object obj = this.f6027a;
        return obj instanceof BigDecimal ? (BigDecimal) obj : new BigDecimal(getAsString());
    }

    @Override // com.google.gson.AbstractC2063k
    public BigInteger getAsBigInteger() {
        Object obj = this.f6027a;
        return obj instanceof BigInteger ? (BigInteger) obj : new BigInteger(getAsString());
    }

    @Override // com.google.gson.AbstractC2063k
    public boolean getAsBoolean() {
        return m5679a() ? ((Boolean) this.f6027a).booleanValue() : Boolean.parseBoolean(getAsString());
    }

    @Override // com.google.gson.AbstractC2063k
    public byte getAsByte() {
        return m5680b() ? getAsNumber().byteValue() : Byte.parseByte(getAsString());
    }

    @Override // com.google.gson.AbstractC2063k
    @Deprecated
    public char getAsCharacter() {
        String asString = getAsString();
        if (asString.isEmpty()) {
            throw new UnsupportedOperationException("String value is empty");
        }
        return asString.charAt(0);
    }

    @Override // com.google.gson.AbstractC2063k
    public double getAsDouble() {
        return m5680b() ? getAsNumber().doubleValue() : Double.parseDouble(getAsString());
    }

    @Override // com.google.gson.AbstractC2063k
    public float getAsFloat() {
        return m5680b() ? getAsNumber().floatValue() : Float.parseFloat(getAsString());
    }

    @Override // com.google.gson.AbstractC2063k
    public int getAsInt() {
        return m5680b() ? getAsNumber().intValue() : Integer.parseInt(getAsString());
    }

    @Override // com.google.gson.AbstractC2063k
    public long getAsLong() {
        return m5680b() ? getAsNumber().longValue() : Long.parseLong(getAsString());
    }

    @Override // com.google.gson.AbstractC2063k
    public Number getAsNumber() {
        Object obj = this.f6027a;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new C2015h((String) obj);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    @Override // com.google.gson.AbstractC2063k
    public short getAsShort() {
        return m5680b() ? getAsNumber().shortValue() : Short.parseShort(getAsString());
    }

    @Override // com.google.gson.AbstractC2063k
    public String getAsString() {
        Object obj = this.f6027a;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (m5680b()) {
            return getAsNumber().toString();
        }
        if (m5679a()) {
            return ((Boolean) this.f6027a).toString();
        }
        throw new AssertionError("Unexpected value type: " + this.f6027a.getClass());
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.f6027a == null) {
            return 31;
        }
        if (m5678a(this)) {
            doubleToLongBits = getAsNumber().longValue();
        } else {
            Object obj = this.f6027a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(getAsNumber().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    /* renamed from: a */
    private static boolean m5678a(C2068p c2068p) {
        Object obj = c2068p.f6027a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public C2068p(Number number) {
        this.f6027a = Objects.requireNonNull(number);
    }

    public C2068p(String str) {
        this.f6027a = Objects.requireNonNull(str);
    }

    public C2068p(Character ch) {
        this.f6027a = ((Character) Objects.requireNonNull(ch)).toString();
    }
}
