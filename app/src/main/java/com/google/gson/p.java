package com.google.gson;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: compiled from: JsonPrimitive.java */
/* JADX INFO: loaded from: classes.dex */
public final class p extends k {
    private final Object a;

    public p(Boolean bool) {
        this.a = Objects.requireNonNull(bool);
    }

    public boolean a() {
        return this.a instanceof Boolean;
    }

    public boolean b() {
        return this.a instanceof Number;
    }

    public boolean c() {
        return this.a instanceof String;
    }

    @Override // com.google.gson.k
    public p deepCopy() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        if (this.a == null) {
            return pVar.a == null;
        }
        if (a(this) && a(pVar)) {
            return getAsNumber().longValue() == pVar.getAsNumber().longValue();
        }
        if (!(this.a instanceof Number) || !(pVar.a instanceof Number)) {
            return this.a.equals(pVar.a);
        }
        double dDoubleValue = getAsNumber().doubleValue();
        double dDoubleValue2 = pVar.getAsNumber().doubleValue();
        if (dDoubleValue != dDoubleValue2) {
            return Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2);
        }
        return true;
    }

    @Override // com.google.gson.k
    public BigDecimal getAsBigDecimal() {
        Object obj = this.a;
        return obj instanceof BigDecimal ? (BigDecimal) obj : new BigDecimal(getAsString());
    }

    @Override // com.google.gson.k
    public BigInteger getAsBigInteger() {
        Object obj = this.a;
        return obj instanceof BigInteger ? (BigInteger) obj : new BigInteger(getAsString());
    }

    @Override // com.google.gson.k
    public boolean getAsBoolean() {
        return a() ? ((Boolean) this.a).booleanValue() : Boolean.parseBoolean(getAsString());
    }

    @Override // com.google.gson.k
    public byte getAsByte() {
        return b() ? getAsNumber().byteValue() : Byte.parseByte(getAsString());
    }

    @Override // com.google.gson.k
    @Deprecated
    public char getAsCharacter() {
        String asString = getAsString();
        if (asString.isEmpty()) {
            throw new UnsupportedOperationException("String value is empty");
        }
        return asString.charAt(0);
    }

    @Override // com.google.gson.k
    public double getAsDouble() {
        return b() ? getAsNumber().doubleValue() : Double.parseDouble(getAsString());
    }

    @Override // com.google.gson.k
    public float getAsFloat() {
        return b() ? getAsNumber().floatValue() : Float.parseFloat(getAsString());
    }

    @Override // com.google.gson.k
    public int getAsInt() {
        return b() ? getAsNumber().intValue() : Integer.parseInt(getAsString());
    }

    @Override // com.google.gson.k
    public long getAsLong() {
        return b() ? getAsNumber().longValue() : Long.parseLong(getAsString());
    }

    @Override // com.google.gson.k
    public Number getAsNumber() {
        Object obj = this.a;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new com.google.gson.b0.h((String) obj);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    @Override // com.google.gson.k
    public short getAsShort() {
        return b() ? getAsNumber().shortValue() : Short.parseShort(getAsString());
    }

    @Override // com.google.gson.k
    public String getAsString() {
        Object obj = this.a;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (b()) {
            return getAsNumber().toString();
        }
        if (a()) {
            return ((Boolean) this.a).toString();
        }
        throw new AssertionError("Unexpected value type: " + this.a.getClass());
    }

    public int hashCode() {
        long jDoubleToLongBits;
        if (this.a == null) {
            return 31;
        }
        if (a(this)) {
            jDoubleToLongBits = getAsNumber().longValue();
        } else {
            Object obj = this.a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(getAsNumber().doubleValue());
        }
        return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
    }

    private static boolean a(p pVar) {
        Object obj = pVar.a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public p(Number number) {
        this.a = Objects.requireNonNull(number);
    }

    public p(String str) {
        this.a = Objects.requireNonNull(str);
    }

    public p(Character ch) {
        this.a = ((Character) Objects.requireNonNull(ch)).toString();
    }
}
