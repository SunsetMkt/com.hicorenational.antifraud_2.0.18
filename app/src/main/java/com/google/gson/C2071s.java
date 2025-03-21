package com.google.gson;

import com.google.gson.p147b0.C2022o;
import com.google.gson.p153e0.C2052a;
import com.google.gson.p153e0.C2056e;
import com.google.gson.p153e0.EnumC2054c;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: JsonStreamParser.java */
/* renamed from: com.google.gson.s */
/* loaded from: classes.dex */
public final class C2071s implements Iterator<AbstractC2063k> {

    /* renamed from: a */
    private final C2052a f6028a;

    /* renamed from: b */
    private final Object f6029b;

    public C2071s(String str) {
        this(new StringReader(str));
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        boolean z;
        synchronized (this.f6029b) {
            try {
                try {
                    z = this.f6028a.peek() != EnumC2054c.END_DOCUMENT;
                } catch (C2056e e2) {
                    throw new C2072t(e2);
                } catch (IOException e3) {
                    throw new C2064l(e3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public C2071s(Reader reader) {
        this.f6028a = new C2052a(reader);
        this.f6028a.m5609a(true);
        this.f6029b = new Object();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public AbstractC2063k next() throws C2066n {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        try {
            return C2022o.m5390a(this.f6028a);
        } catch (OutOfMemoryError e2) {
            throw new C2066n("Failed parsing JSON source to Json", e2);
        } catch (StackOverflowError e3) {
            throw new C2066n("Failed parsing JSON source to Json", e3);
        }
    }
}
