package com.google.gson.p147b0.p148q;

import com.google.gson.AbstractC2063k;
import com.google.gson.C2060h;
import com.google.gson.C2065m;
import com.google.gson.C2068p;
import com.google.gson.JsonObject;
import com.google.gson.p153e0.C2055d;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* compiled from: JsonTreeWriter.java */
/* renamed from: com.google.gson.b0.q.g */
/* loaded from: classes.dex */
public final class C2030g extends C2055d {

    /* renamed from: p */
    private static final Writer f5740p = new a();

    /* renamed from: q */
    private static final C2068p f5741q = new C2068p("closed");

    /* renamed from: m */
    private final List<AbstractC2063k> f5742m;

    /* renamed from: n */
    private String f5743n;

    /* renamed from: o */
    private AbstractC2063k f5744o;

    /* compiled from: JsonTreeWriter.java */
    /* renamed from: com.google.gson.b0.q.g$a */
    class a extends Writer {
        a() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i2, int i3) {
            throw new AssertionError();
        }
    }

    public C2030g() {
        super(f5740p);
        this.f5742m = new ArrayList();
        this.f5744o = C2065m.f6026a;
    }

    /* renamed from: a */
    private void m5434a(AbstractC2063k abstractC2063k) {
        if (this.f5743n != null) {
            if (!abstractC2063k.isJsonNull() || m5627g()) {
                ((JsonObject) peek()).add(this.f5743n, abstractC2063k);
            }
            this.f5743n = null;
            return;
        }
        if (this.f5742m.isEmpty()) {
            this.f5744o = abstractC2063k;
            return;
        }
        AbstractC2063k peek = peek();
        if (!(peek instanceof C2060h)) {
            throw new IllegalStateException();
        }
        ((C2060h) peek).m5664a(abstractC2063k);
    }

    private AbstractC2063k peek() {
        return this.f5742m.get(r0.size() - 1);
    }

    @Override // com.google.gson.p153e0.C2055d
    /* renamed from: b */
    public C2055d mo5441b(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.f5742m.isEmpty() || this.f5743n != null) {
            throw new IllegalStateException();
        }
        if (!(peek() instanceof JsonObject)) {
            throw new IllegalStateException();
        }
        this.f5743n = str;
        return this;
    }

    @Override // com.google.gson.p153e0.C2055d
    /* renamed from: c */
    public C2055d mo5442c() throws IOException {
        C2060h c2060h = new C2060h();
        m5434a(c2060h);
        this.f5742m.add(c2060h);
        return this;
    }

    @Override // com.google.gson.p153e0.C2055d, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f5742m.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.f5742m.add(f5741q);
    }

    @Override // com.google.gson.p153e0.C2055d
    /* renamed from: d */
    public C2055d mo5443d() throws IOException {
        JsonObject jsonObject = new JsonObject();
        m5434a(jsonObject);
        this.f5742m.add(jsonObject);
        return this;
    }

    @Override // com.google.gson.p153e0.C2055d
    /* renamed from: e */
    public C2055d mo5446e() throws IOException {
        if (this.f5742m.isEmpty() || this.f5743n != null) {
            throw new IllegalStateException();
        }
        if (!(peek() instanceof C2060h)) {
            throw new IllegalStateException();
        }
        this.f5742m.remove(r0.size() - 1);
        return this;
    }

    @Override // com.google.gson.p153e0.C2055d
    /* renamed from: f */
    public C2055d mo5447f() throws IOException {
        if (this.f5742m.isEmpty() || this.f5743n != null) {
            throw new IllegalStateException();
        }
        if (!(peek() instanceof JsonObject)) {
            throw new IllegalStateException();
        }
        this.f5742m.remove(r0.size() - 1);
        return this;
    }

    @Override // com.google.gson.p153e0.C2055d, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // com.google.gson.p153e0.C2055d
    /* renamed from: j */
    public C2055d mo5448j() throws IOException {
        m5434a(C2065m.f6026a);
        return this;
    }

    /* renamed from: k */
    public AbstractC2063k m5449k() {
        if (this.f5742m.isEmpty()) {
            return this.f5744o;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f5742m);
    }

    @Override // com.google.gson.p153e0.C2055d
    /* renamed from: d */
    public C2055d mo5444d(String str) throws IOException {
        if (str == null) {
            return mo5448j();
        }
        m5434a(new C2068p(str));
        return this;
    }

    @Override // com.google.gson.p153e0.C2055d
    /* renamed from: d */
    public C2055d mo5445d(boolean z) throws IOException {
        m5434a(new C2068p(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.gson.p153e0.C2055d
    /* renamed from: a */
    public C2055d mo5440a(String str) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.gson.p153e0.C2055d
    /* renamed from: a */
    public C2055d mo5438a(Boolean bool) throws IOException {
        if (bool == null) {
            return mo5448j();
        }
        m5434a(new C2068p(bool));
        return this;
    }

    @Override // com.google.gson.p153e0.C2055d
    /* renamed from: a */
    public C2055d mo5436a(float f2) throws IOException {
        if (!m5629i() && (Float.isNaN(f2) || Float.isInfinite(f2))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + f2);
        }
        m5434a(new C2068p(Float.valueOf(f2)));
        return this;
    }

    @Override // com.google.gson.p153e0.C2055d
    /* renamed from: a */
    public C2055d mo5435a(double d2) throws IOException {
        if (!m5629i() && (Double.isNaN(d2) || Double.isInfinite(d2))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d2);
        }
        m5434a(new C2068p(Double.valueOf(d2)));
        return this;
    }

    @Override // com.google.gson.p153e0.C2055d
    /* renamed from: a */
    public C2055d mo5437a(long j2) throws IOException {
        m5434a(new C2068p(Long.valueOf(j2)));
        return this;
    }

    @Override // com.google.gson.p153e0.C2055d
    /* renamed from: a */
    public C2055d mo5439a(Number number) throws IOException {
        if (number == null) {
            return mo5448j();
        }
        if (!m5629i()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        m5434a(new C2068p(number));
        return this;
    }
}
