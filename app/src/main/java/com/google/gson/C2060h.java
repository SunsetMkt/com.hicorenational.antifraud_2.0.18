package com.google.gson;

import com.google.gson.p147b0.C2017j;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: JsonArray.java */
/* renamed from: com.google.gson.h */
/* loaded from: classes.dex */
public final class C2060h extends AbstractC2063k implements Iterable<AbstractC2063k> {

    /* renamed from: a */
    private final ArrayList<AbstractC2063k> f6025a;

    public C2060h() {
        this.f6025a = new ArrayList<>();
    }

    /* renamed from: a */
    public void m5665a(Boolean bool) {
        this.f6025a.add(bool == null ? C2065m.f6026a : new C2068p(bool));
    }

    /* renamed from: b */
    public boolean m5669b(AbstractC2063k abstractC2063k) {
        return this.f6025a.contains(abstractC2063k);
    }

    /* renamed from: c */
    public boolean m5670c(AbstractC2063k abstractC2063k) {
        return this.f6025a.remove(abstractC2063k);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof C2060h) && ((C2060h) obj).f6025a.equals(this.f6025a));
    }

    public AbstractC2063k get(int i2) {
        return this.f6025a.get(i2);
    }

    @Override // com.google.gson.AbstractC2063k
    public BigDecimal getAsBigDecimal() {
        return m5660b().getAsBigDecimal();
    }

    @Override // com.google.gson.AbstractC2063k
    public BigInteger getAsBigInteger() {
        return m5660b().getAsBigInteger();
    }

    @Override // com.google.gson.AbstractC2063k
    public boolean getAsBoolean() {
        return m5660b().getAsBoolean();
    }

    @Override // com.google.gson.AbstractC2063k
    public byte getAsByte() {
        return m5660b().getAsByte();
    }

    @Override // com.google.gson.AbstractC2063k
    @Deprecated
    public char getAsCharacter() {
        return m5660b().getAsCharacter();
    }

    @Override // com.google.gson.AbstractC2063k
    public double getAsDouble() {
        return m5660b().getAsDouble();
    }

    @Override // com.google.gson.AbstractC2063k
    public float getAsFloat() {
        return m5660b().getAsFloat();
    }

    @Override // com.google.gson.AbstractC2063k
    public int getAsInt() {
        return m5660b().getAsInt();
    }

    @Override // com.google.gson.AbstractC2063k
    public long getAsLong() {
        return m5660b().getAsLong();
    }

    @Override // com.google.gson.AbstractC2063k
    public Number getAsNumber() {
        return m5660b().getAsNumber();
    }

    @Override // com.google.gson.AbstractC2063k
    public short getAsShort() {
        return m5660b().getAsShort();
    }

    @Override // com.google.gson.AbstractC2063k
    public String getAsString() {
        return m5660b().getAsString();
    }

    public int hashCode() {
        return this.f6025a.hashCode();
    }

    public boolean isEmpty() {
        return this.f6025a.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<AbstractC2063k> iterator() {
        return this.f6025a.iterator();
    }

    public AbstractC2063k remove(int i2) {
        return this.f6025a.remove(i2);
    }

    public int size() {
        return this.f6025a.size();
    }

    /* renamed from: b */
    private AbstractC2063k m5660b() {
        int size = this.f6025a.size();
        if (size == 1) {
            return this.f6025a.get(0);
        }
        throw new IllegalStateException("Array must have size 1, but has size " + size);
    }

    /* renamed from: a */
    public void m5666a(Character ch) {
        this.f6025a.add(ch == null ? C2065m.f6026a : new C2068p(ch));
    }

    @Override // com.google.gson.AbstractC2063k
    public C2060h deepCopy() {
        if (this.f6025a.isEmpty()) {
            return new C2060h();
        }
        C2060h c2060h = new C2060h(this.f6025a.size());
        Iterator<AbstractC2063k> it = this.f6025a.iterator();
        while (it.hasNext()) {
            c2060h.m5664a(it.next().deepCopy());
        }
        return c2060h;
    }

    public C2060h(int i2) {
        this.f6025a = new ArrayList<>(i2);
    }

    /* renamed from: a */
    public void m5667a(Number number) {
        this.f6025a.add(number == null ? C2065m.f6026a : new C2068p(number));
    }

    /* renamed from: a */
    public void m5668a(String str) {
        this.f6025a.add(str == null ? C2065m.f6026a : new C2068p(str));
    }

    /* renamed from: a */
    public void m5664a(AbstractC2063k abstractC2063k) {
        if (abstractC2063k == null) {
            abstractC2063k = C2065m.f6026a;
        }
        this.f6025a.add(abstractC2063k);
    }

    /* renamed from: a */
    public void m5663a(C2060h c2060h) {
        this.f6025a.addAll(c2060h.f6025a);
    }

    /* renamed from: a */
    public AbstractC2063k m5661a(int i2, AbstractC2063k abstractC2063k) {
        ArrayList<AbstractC2063k> arrayList = this.f6025a;
        if (abstractC2063k == null) {
            abstractC2063k = C2065m.f6026a;
        }
        return arrayList.set(i2, abstractC2063k);
    }

    /* renamed from: a */
    public List<AbstractC2063k> m5662a() {
        return new C2017j(this.f6025a);
    }
}
