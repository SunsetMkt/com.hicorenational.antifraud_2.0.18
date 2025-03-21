package com.google.gson.p147b0;

import com.google.gson.AbstractC2063k;
import com.google.gson.C2064l;
import com.google.gson.C2065m;
import com.google.gson.C2066n;
import com.google.gson.C2072t;
import com.google.gson.p147b0.p148q.C2038o;
import com.google.gson.p153e0.C2052a;
import com.google.gson.p153e0.C2055d;
import com.google.gson.p153e0.C2056e;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

/* compiled from: Streams.java */
/* renamed from: com.google.gson.b0.o */
/* loaded from: classes.dex */
public final class C2022o {
    private C2022o() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public static AbstractC2063k m5390a(C2052a c2052a) throws C2066n {
        boolean z;
        try {
            try {
                c2052a.peek();
                z = false;
                try {
                    return C2038o.f5823V.read2(c2052a);
                } catch (EOFException e2) {
                    e = e2;
                    if (z) {
                        return C2065m.f6026a;
                    }
                    throw new C2072t(e);
                }
            } catch (C2056e e3) {
                throw new C2072t(e3);
            } catch (IOException e4) {
                throw new C2064l(e4);
            } catch (NumberFormatException e5) {
                throw new C2072t(e5);
            }
        } catch (EOFException e6) {
            e = e6;
            z = true;
        }
    }

    /* compiled from: Streams.java */
    /* renamed from: com.google.gson.b0.o$b */
    private static final class b extends Writer {

        /* renamed from: a */
        private final Appendable f5709a;

        /* renamed from: b */
        private final a f5710b = new a();

        /* compiled from: Streams.java */
        /* renamed from: com.google.gson.b0.o$b$a */
        private static class a implements CharSequence {

            /* renamed from: a */
            private char[] f5711a;

            /* renamed from: b */
            private String f5712b;

            private a() {
            }

            /* renamed from: a */
            void m5393a(char[] cArr) {
                this.f5711a = cArr;
                this.f5712b = null;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i2) {
                return this.f5711a[i2];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f5711a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i2, int i3) {
                return new String(this.f5711a, i2, i3 - i2);
            }

            @Override // java.lang.CharSequence
            public String toString() {
                if (this.f5712b == null) {
                    this.f5712b = new String(this.f5711a);
                }
                return this.f5712b;
            }
        }

        b(Appendable appendable) {
            this.f5709a = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i2, int i3) throws IOException {
            this.f5710b.m5393a(cArr);
            this.f5709a.append(this.f5710b, i2, i3 + i2);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence) throws IOException {
            this.f5709a.append(charSequence);
            return this;
        }

        @Override // java.io.Writer
        public void write(int i2) throws IOException {
            this.f5709a.append((char) i2);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence, int i2, int i3) throws IOException {
            this.f5709a.append(charSequence, i2, i3);
            return this;
        }

        @Override // java.io.Writer
        public void write(String str, int i2, int i3) throws IOException {
            Objects.requireNonNull(str);
            this.f5709a.append(str, i2, i3 + i2);
        }
    }

    /* renamed from: a */
    public static void m5392a(AbstractC2063k abstractC2063k, C2055d c2055d) throws IOException {
        C2038o.f5823V.write(c2055d, abstractC2063k);
    }

    /* renamed from: a */
    public static Writer m5391a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new b(appendable);
    }
}
