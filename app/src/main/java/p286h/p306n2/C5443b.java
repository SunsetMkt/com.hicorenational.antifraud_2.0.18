package p286h.p306n2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.NoSuchElementException;
import p286h.C5226e1;
import p286h.InterfaceC5216c;
import p286h.InterfaceC5467o0;
import p286h.InterfaceC5610t0;
import p286h.InterfaceC5713y;
import p286h.p289g2.AbstractC5303u;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p311t.C5544i0;
import p286h.p323z2.C5731f;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: IOStreams.kt */
@InterfaceC5481e(name = "ByteStreamsKt")
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u0000\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u0007\u001a\u00020\b*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0017\u0010\u000b\u001a\u00020\f*\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0017\u0010\r\u001a\u00020\u000e*\u00020\u000f2\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u001c\u0010\u0010\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\r\u0010\u0013\u001a\u00020\u000e*\u00020\u0014H\u0087\b\u001a\u001d\u0010\u0013\u001a\u00020\u000e*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u0018*\u00020\u0001H\u0086\u0002\u001a\f\u0010\u0019\u001a\u00020\u0014*\u00020\u0002H\u0007\u001a\u0016\u0010\u0019\u001a\u00020\u0014*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u0004H\u0007\u001a\u0017\u0010\u001b\u001a\u00020\u001c*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0017\u0010\u001d\u001a\u00020\u001e*\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b¨\u0006\u001f"}, m23546d2 = {"buffered", "Ljava/io/BufferedInputStream;", "Ljava/io/InputStream;", "bufferSize", "", "Ljava/io/BufferedOutputStream;", "Ljava/io/OutputStream;", "bufferedReader", "Ljava/io/BufferedReader;", "charset", "Ljava/nio/charset/Charset;", "bufferedWriter", "Ljava/io/BufferedWriter;", "byteInputStream", "Ljava/io/ByteArrayInputStream;", "", "copyTo", "", "out", "inputStream", "", "offset", "length", "iterator", "Lkotlin/collections/ByteIterator;", "readBytes", "estimatedSize", "reader", "Ljava/io/InputStreamReader;", "writer", "Ljava/io/OutputStreamWriter;", "kotlin-stdlib"}, m23547k = 2, m23548mv = {1, 1, 16})
/* renamed from: h.n2.b */
/* loaded from: classes2.dex */
public final class C5443b {

    /* compiled from: IOStreams.kt */
    /* renamed from: h.n2.b$a */
    public static final class a extends AbstractC5303u {

        /* renamed from: a */
        private int f20307a = -1;

        /* renamed from: b */
        private boolean f20308b;

        /* renamed from: c */
        private boolean f20309c;

        /* renamed from: d */
        final /* synthetic */ BufferedInputStream f20310d;

        a(BufferedInputStream bufferedInputStream) {
            this.f20310d = bufferedInputStream;
        }

        /* renamed from: f */
        private final void m22267f() {
            if (this.f20308b || this.f20309c) {
                return;
            }
            this.f20307a = this.f20310d.read();
            this.f20308b = true;
            this.f20309c = this.f20307a == -1;
        }

        /* renamed from: a */
        public final void m22268a(int i2) {
            this.f20307a = i2;
        }

        /* renamed from: b */
        public final void m22270b(boolean z) {
            this.f20308b = z;
        }

        /* renamed from: c */
        public final boolean m22271c() {
            return this.f20309c;
        }

        /* renamed from: d */
        public final int m22272d() {
            return this.f20307a;
        }

        /* renamed from: e */
        public final boolean m22273e() {
            return this.f20308b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            m22267f();
            return !this.f20309c;
        }

        /* renamed from: a */
        public final void m22269a(boolean z) {
            this.f20309c = z;
        }

        @Override // p286h.p289g2.AbstractC5303u
        /* renamed from: b */
        public byte mo21707b() {
            m22267f();
            if (this.f20309c) {
                throw new NoSuchElementException("Input stream is over.");
            }
            byte b2 = (byte) this.f20307a;
            this.f20308b = false;
            return b2;
        }
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final AbstractC5303u m22247a(@InterfaceC5816d BufferedInputStream bufferedInputStream) {
        C5544i0.m22546f(bufferedInputStream, "$this$iterator");
        return new a(bufferedInputStream);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final InputStreamReader m22261b(@InterfaceC5816d InputStream inputStream, Charset charset) {
        return new InputStreamReader(inputStream, charset);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final ByteArrayInputStream m22256a(@InterfaceC5816d String str, Charset charset) {
        if (str == null) {
            throw new C5226e1("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str.getBytes(charset);
        C5544i0.m22521a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        return new ByteArrayInputStream(bytes);
    }

    /* renamed from: b */
    static /* synthetic */ InputStreamReader m22262b(InputStream inputStream, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = C5731f.f20676a;
        }
        return new InputStreamReader(inputStream, charset);
    }

    /* renamed from: a */
    static /* synthetic */ ByteArrayInputStream m22257a(String str, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = C5731f.f20676a;
        }
        if (str == null) {
            throw new C5226e1("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str.getBytes(charset);
        C5544i0.m22521a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        return new ByteArrayInputStream(bytes);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final OutputStreamWriter m22263b(@InterfaceC5816d OutputStream outputStream, Charset charset) {
        return new OutputStreamWriter(outputStream, charset);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final ByteArrayInputStream m22258a(@InterfaceC5816d byte[] bArr) {
        return new ByteArrayInputStream(bArr);
    }

    /* renamed from: b */
    static /* synthetic */ OutputStreamWriter m22264b(OutputStream outputStream, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = C5731f.f20676a;
        }
        return new OutputStreamWriter(outputStream, charset);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final ByteArrayInputStream m22259a(@InterfaceC5816d byte[] bArr, int i2, int i3) {
        return new ByteArrayInputStream(bArr, i2, i3);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final BufferedInputStream m22248a(@InterfaceC5816d InputStream inputStream, int i2) {
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i2);
    }

    /* renamed from: b */
    public static /* synthetic */ byte[] m22266b(InputStream inputStream, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8192;
        }
        return m22265b(inputStream, i2);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final BufferedReader m22252a(@InterfaceC5816d InputStream inputStream, Charset charset) {
        Reader inputStreamReader = new InputStreamReader(inputStream, charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
    }

    @InterfaceC5216c(message = "Use readBytes() overload without estimatedSize parameter", replaceWith = @InterfaceC5467o0(expression = "readBytes()", imports = {}))
    @InterfaceC5816d
    /* renamed from: b */
    public static final byte[] m22265b(@InterfaceC5816d InputStream inputStream, int i2) {
        C5544i0.m22546f(inputStream, "$this$readBytes");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(i2, inputStream.available()));
        m22246a(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        C5544i0.m22521a((Object) byteArray, "buffer.toByteArray()");
        return byteArray;
    }

    /* renamed from: a */
    static /* synthetic */ BufferedReader m22253a(InputStream inputStream, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = C5731f.f20676a;
        }
        Reader inputStreamReader = new InputStreamReader(inputStream, charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final BufferedOutputStream m22250a(@InterfaceC5816d OutputStream outputStream, int i2) {
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i2);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final BufferedWriter m22254a(@InterfaceC5816d OutputStream outputStream, Charset charset) {
        Writer outputStreamWriter = new OutputStreamWriter(outputStream, charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
    }

    /* renamed from: a */
    static /* synthetic */ BufferedWriter m22255a(OutputStream outputStream, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = C5731f.f20676a;
        }
        Writer outputStreamWriter = new OutputStreamWriter(outputStream, charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
    }

    /* renamed from: a */
    public static /* synthetic */ long m22246a(InputStream inputStream, OutputStream outputStream, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 8192;
        }
        return m22245a(inputStream, outputStream, i2);
    }

    /* renamed from: a */
    public static final long m22245a(@InterfaceC5816d InputStream inputStream, @InterfaceC5816d OutputStream outputStream, int i2) {
        C5544i0.m22546f(inputStream, "$this$copyTo");
        C5544i0.m22546f(outputStream, "out");
        byte[] bArr = new byte[i2];
        int read = inputStream.read(bArr);
        long j2 = 0;
        while (read >= 0) {
            outputStream.write(bArr, 0, read);
            j2 += read;
            read = inputStream.read(bArr);
        }
        return j2;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: a */
    public static final byte[] m22260a(@InterfaceC5816d InputStream inputStream) {
        C5544i0.m22546f(inputStream, "$this$readBytes");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, inputStream.available()));
        m22246a(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        C5544i0.m22521a((Object) byteArray, "buffer.toByteArray()");
        return byteArray;
    }

    /* renamed from: a */
    static /* synthetic */ BufferedInputStream m22249a(InputStream inputStream, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8192;
        }
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i2);
    }

    /* renamed from: a */
    static /* synthetic */ BufferedOutputStream m22251a(OutputStream outputStream, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8192;
        }
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i2);
    }
}
