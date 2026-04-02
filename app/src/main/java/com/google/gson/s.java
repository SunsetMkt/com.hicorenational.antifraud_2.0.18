package com.google.gson;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: JsonStreamParser.java */
/* JADX INFO: loaded from: classes.dex */
public final class s implements Iterator<k> {
    private final com.google.gson.e0.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f3829b;

    public s(String str) {
        this(new StringReader(str));
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        boolean z;
        synchronized (this.f3829b) {
            try {
                try {
                    z = this.a.peek() != com.google.gson.e0.c.END_DOCUMENT;
                } catch (com.google.gson.e0.e e2) {
                    throw new t(e2);
                } catch (IOException e3) {
                    throw new l(e3);
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

    public s(Reader reader) {
        this.a = new com.google.gson.e0.a(reader);
        this.a.a(true);
        this.f3829b = new Object();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public k next() throws n {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        try {
            return com.google.gson.b0.o.a(this.a);
        } catch (OutOfMemoryError e2) {
            throw new n("Failed parsing JSON source to Json", e2);
        } catch (StackOverflowError e3) {
            throw new n("Failed parsing JSON source to Json", e3);
        }
    }
}
