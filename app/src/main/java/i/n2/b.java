package i.n2;

import i.e1;
import i.o0;
import i.q2.t.i0;
import i.t0;
import i.y;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: IOStreams.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.q2.e(name = "ByteStreamsKt")
@y(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u0000\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u0007\u001a\u00020\b*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0017\u0010\u000b\u001a\u00020\f*\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0017\u0010\r\u001a\u00020\u000e*\u00020\u000f2\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u001c\u0010\u0010\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\r\u0010\u0013\u001a\u00020\u000e*\u00020\u0014H\u0087\b\u001a\u001d\u0010\u0013\u001a\u00020\u000e*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u0018*\u00020\u0001H\u0086\u0002\u001a\f\u0010\u0019\u001a\u00020\u0014*\u00020\u0002H\u0007\u001a\u0016\u0010\u0019\u001a\u00020\u0014*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u0004H\u0007\u001a\u0017\u0010\u001b\u001a\u00020\u001c*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0017\u0010\u001d\u001a\u00020\u001e*\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u00a8\u0006\u001f"}, d2 = {"buffered", "Ljava/io/BufferedInputStream;", "Ljava/io/InputStream;", "bufferSize", "", "Ljava/io/BufferedOutputStream;", "Ljava/io/OutputStream;", "bufferedReader", "Ljava/io/BufferedReader;", "charset", "Ljava/nio/charset/Charset;", "bufferedWriter", "Ljava/io/BufferedWriter;", "byteInputStream", "Ljava/io/ByteArrayInputStream;", "", "copyTo", "", "out", "inputStream", "", "offset", "length", "iterator", "Lkotlin/collections/ByteIterator;", "readBytes", "estimatedSize", "reader", "Ljava/io/InputStreamReader;", "writer", "Ljava/io/OutputStreamWriter;", "kotlin-stdlib"}, k = 2, mv = {1, 1, 16})
public final class b {

    /* JADX INFO: compiled from: IOStreams.kt */
    public static final class a extends i.g2.u {
        private int a = -1;

        /* JADX INFO: renamed from: b */
        private boolean f12164b;

        /* JADX INFO: renamed from: c */
        private boolean f12165c;

        /* JADX INFO: renamed from: d */
        final /* synthetic */ BufferedInputStream f12166d;

        a(BufferedInputStream bufferedInputStream) {
            this.f12166d = bufferedInputStream;
        }

        private final void f() {
            if (this.f12164b || this.f12165c) {
                return;
            }
            this.a = this.f12166d.read();
            this.f12164b = true;
            this.f12165c = this.a == -1;
        }

        public final void a(int i2) {
            this.a = i2;
        }

        public final void b(boolean z) {
            this.f12164b = z;
        }

        public final boolean c() {
            return this.f12165c;
        }

        public final int d() {
            return this.a;
        }

        public final boolean e() {
            return this.f12164b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            f();
            return !this.f12165c;
        }

        public final void a(boolean z) {
            this.f12165c = z;
        }

        @Override // i.g2.u
        public byte b() {
            f();
            if (this.f12165c) {
                throw new NoSuchElementException("Input stream is over.");
            }
            byte b2 = (byte) this.a;
            this.f12164b = false;
            return b2;
        }
    }

    @j.c.a.d
    public static final i.g2.u a(@j.c.a.d BufferedInputStream bufferedInputStream) {
        i0.f(bufferedInputStream, "$this$iterator");
        return new a(bufferedInputStream);
    }

    @i.m2.f
    private static final InputStreamReader b(@j.c.a.d InputStream inputStream, Charset charset) {
        return new InputStreamReader(inputStream, charset);
    }

    @i.m2.f
    private static final ByteArrayInputStream a(@j.c.a.d String str, Charset charset) {
        if (str == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str.getBytes(charset);
        i0.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        return new ByteArrayInputStream(bytes);
    }

    static /* synthetic */ InputStreamReader b(InputStream inputStream, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = i.z2.f.a;
        }
        return new InputStreamReader(inputStream, charset);
    }

    static /* synthetic */ ByteArrayInputStream a(String str, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = i.z2.f.a;
        }
        if (str == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str.getBytes(charset);
        i0.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        return new ByteArrayInputStream(bytes);
    }

    @i.m2.f
    private static final OutputStreamWriter b(@j.c.a.d OutputStream outputStream, Charset charset) {
        return new OutputStreamWriter(outputStream, charset);
    }

    @i.m2.f
    private static final ByteArrayInputStream a(@j.c.a.d byte[] bArr) {
        return new ByteArrayInputStream(bArr);
    }

    static /* synthetic */ OutputStreamWriter b(OutputStream outputStream, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = i.z2.f.a;
        }
        return new OutputStreamWriter(outputStream, charset);
    }

    @i.m2.f
    private static final ByteArrayInputStream a(@j.c.a.d byte[] bArr, int i2, int i3) {
        return new ByteArrayInputStream(bArr, i2, i3);
    }

    @i.m2.f
    private static final BufferedInputStream a(@j.c.a.d InputStream inputStream, int i2) {
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i2);
    }

    public static /* synthetic */ byte[] b(InputStream inputStream, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8192;
        }
        return b(inputStream, i2);
    }

    @i.m2.f
    private static final BufferedReader a(@j.c.a.d InputStream inputStream, Charset charset) {
        Reader inputStreamReader = new InputStreamReader(inputStream, charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
    }

    @i.c(message = "Use readBytes() overload without estimatedSize parameter", replaceWith = @o0(expression = "readBytes()", imports = {}))
    @j.c.a.d
    public static final byte[] b(@j.c.a.d InputStream inputStream, int i2) {
        i0.f(inputStream, "$this$readBytes");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(i2, inputStream.available()));
        a(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        i0.a((Object) byteArray, "buffer.toByteArray()");
        return byteArray;
    }

    static /* synthetic */ BufferedReader a(InputStream inputStream, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = i.z2.f.a;
        }
        Reader inputStreamReader = new InputStreamReader(inputStream, charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
    }

    @i.m2.f
    private static final BufferedOutputStream a(@j.c.a.d OutputStream outputStream, int i2) {
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i2);
    }

    @i.m2.f
    private static final BufferedWriter a(@j.c.a.d OutputStream outputStream, Charset charset) {
        Writer outputStreamWriter = new OutputStreamWriter(outputStream, charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
    }

    static /* synthetic */ BufferedWriter a(OutputStream outputStream, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = i.z2.f.a;
        }
        Writer outputStreamWriter = new OutputStreamWriter(outputStream, charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
    }

    public static /* synthetic */ long a(InputStream inputStream, OutputStream outputStream, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 8192;
        }
        return a(inputStream, outputStream, i2);
    }

    public static final long a(@j.c.a.d InputStream inputStream, @j.c.a.d OutputStream outputStream, int i2) throws IOException {
        i0.f(inputStream, "$this$copyTo");
        i0.f(outputStream, "out");
        byte[] bArr = new byte[i2];
        int i3 = inputStream.read(bArr);
        long j2 = 0;
        while (i3 >= 0) {
            outputStream.write(bArr, 0, i3);
            j2 += (long) i3;
            i3 = inputStream.read(bArr);
        }
        return j2;
    }

    @t0(version = "1.3")
    @j.c.a.d
    public static final byte[] a(@j.c.a.d InputStream inputStream) {
        i0.f(inputStream, "$this$readBytes");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, inputStream.available()));
        a(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        i0.a((Object) byteArray, "buffer.toByteArray()");
        return byteArray;
    }

    static /* synthetic */ BufferedInputStream a(InputStream inputStream, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8192;
        }
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i2);
    }

    static /* synthetic */ BufferedOutputStream a(OutputStream outputStream, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8192;
        }
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i2);
    }
}
