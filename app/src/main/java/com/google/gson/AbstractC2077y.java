package com.google.gson;

import com.google.gson.p147b0.p148q.C2029f;
import com.google.gson.p147b0.p148q.C2030g;
import com.google.gson.p153e0.C2052a;
import com.google.gson.p153e0.C2055d;
import com.google.gson.p153e0.EnumC2054c;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/* compiled from: TypeAdapter.java */
/* renamed from: com.google.gson.y */
/* loaded from: classes.dex */
public abstract class AbstractC2077y<T> {

    /* compiled from: TypeAdapter.java */
    /* renamed from: com.google.gson.y$a */
    class a extends AbstractC2077y<T> {
        a() {
        }

        @Override // com.google.gson.AbstractC2077y
        public T read(C2052a c2052a) throws IOException {
            if (c2052a.peek() != EnumC2054c.NULL) {
                return (T) AbstractC2077y.this.read(c2052a);
            }
            c2052a.mo5429r();
            return null;
        }

        @Override // com.google.gson.AbstractC2077y
        public void write(C2055d c2055d, T t) throws IOException {
            if (t == null) {
                c2055d.mo5448j();
            } else {
                AbstractC2077y.this.write(c2055d, t);
            }
        }
    }

    public final T fromJson(Reader reader) throws IOException {
        return read(new C2052a(reader));
    }

    public final T fromJsonTree(AbstractC2063k abstractC2063k) {
        try {
            return read(new C2029f(abstractC2063k));
        } catch (IOException e2) {
            throw new C2064l(e2);
        }
    }

    public final AbstractC2077y<T> nullSafe() {
        return new a();
    }

    public abstract T read(C2052a c2052a) throws IOException;

    public final void toJson(Writer writer, T t) throws IOException {
        write(new C2055d(writer), t);
    }

    public final AbstractC2063k toJsonTree(T t) {
        try {
            C2030g c2030g = new C2030g();
            write(c2030g, t);
            return c2030g.m5449k();
        } catch (IOException e2) {
            throw new C2064l(e2);
        }
    }

    public abstract void write(C2055d c2055d, T t) throws IOException;

    public final T fromJson(String str) throws IOException {
        return fromJson(new StringReader(str));
    }

    public final String toJson(T t) {
        StringWriter stringWriter = new StringWriter();
        try {
            toJson(stringWriter, t);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new C2064l(e2);
        }
    }
}
