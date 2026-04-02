package com.google.gson.b0;

import com.google.gson.t;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

/* JADX INFO: compiled from: Streams.java */
/* JADX INFO: loaded from: classes.dex */
public final class o {
    private o() {
        throw new UnsupportedOperationException();
    }

    public static com.google.gson.k a(com.google.gson.e0.a aVar) throws com.google.gson.n {
        boolean z;
        try {
            try {
                aVar.peek();
                z = false;
                try {
                    return com.google.gson.b0.q.o.V.read(aVar);
                } catch (EOFException e2) {
                    e = e2;
                    if (z) {
                        return com.google.gson.m.a;
                    }
                    throw new t(e);
                }
            } catch (com.google.gson.e0.e e3) {
                throw new t(e3);
            } catch (IOException e4) {
                throw new com.google.gson.l(e4);
            } catch (NumberFormatException e5) {
                throw new t(e5);
            }
        } catch (EOFException e6) {
            e = e6;
            z = true;
        }
    }

    /* JADX INFO: compiled from: Streams.java */
    private static final class b extends Writer {
        private final Appendable a;

        /* JADX INFO: renamed from: b */
        private final a f3673b = new a();

        /* JADX INFO: compiled from: Streams.java */
        private static class a implements CharSequence {
            private char[] a;

            /* JADX INFO: renamed from: b */
            private String f3674b;

            private a() {
            }

            void a(char[] cArr) {
                this.a = cArr;
                this.f3674b = null;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i2) {
                return this.a[i2];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i2, int i3) {
                return new String(this.a, i2, i3 - i2);
            }

            @Override // java.lang.CharSequence
            public String toString() {
                if (this.f3674b == null) {
                    this.f3674b = new String(this.a);
                }
                return this.f3674b;
            }

            /* synthetic */ a(a aVar) {
                this();
            }
        }

        b(Appendable appendable) {
            this.a = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i2, int i3) throws IOException {
            this.f3673b.a(cArr);
            this.a.append(this.f3673b, i2, i3 + i2);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence) throws IOException {
            this.a.append(charSequence);
            return this;
        }

        @Override // java.io.Writer
        public void write(int i2) throws IOException {
            this.a.append((char) i2);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence, int i2, int i3) throws IOException {
            this.a.append(charSequence, i2, i3);
            return this;
        }

        @Override // java.io.Writer
        public void write(String str, int i2, int i3) throws IOException {
            Objects.requireNonNull(str);
            this.a.append(str, i2, i3 + i2);
        }
    }

    public static void a(com.google.gson.k kVar, com.google.gson.e0.d dVar) throws IOException {
        com.google.gson.b0.q.o.V.write(dVar, kVar);
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new b(appendable);
    }
}
