package p286h.p306n2;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.C3414o;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p289g2.C5291q;
import p286h.p304m2.C5432l;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p311t.AbstractC5547j0;
import p286h.p309q2.p311t.C5535f0;
import p286h.p309q2.p311t.C5544i0;
import p286h.p319v2.C5648q;
import p286h.p321x2.InterfaceC5699m;
import p286h.p323z2.C5731f;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: FileReadWrite.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000z\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001c\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t\u001a!\u0010\n\u001a\u00020\u000b*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\rH\u0087\b\u001a!\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\rH\u0087\b\u001aB\u0010\u0010\u001a\u00020\u0001*\u00020\u000226\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00010\u0012\u001aJ\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\r26\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00010\u0012\u001a7\u0010\u0018\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t2!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00010\u0019\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0002H\u0087\b\u001a\r\u0010\u001d\u001a\u00020\u001e*\u00020\u0002H\u0087\b\u001a\u0017\u0010\u001f\u001a\u00020 *\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\tH\u0087\b\u001a\n\u0010!\u001a\u00020\u0004*\u00020\u0002\u001a\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070#*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t\u001a\u0014\u0010$\u001a\u00020\u0007*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t\u001a\u0017\u0010%\u001a\u00020&*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\tH\u0087\b\u001a?\u0010'\u001a\u0002H(\"\u0004\b\u0000\u0010(*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t2\u0018\u0010)\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070*\u0012\u0004\u0012\u0002H(0\u0019H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010,\u001a\u0012\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001c\u0010.\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t\u001a\u0017\u0010/\u001a\u000200*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\tH\u0087\b\u0082\u0002\b\n\u0006\b\u0011(+0\u0001¨\u00061"}, m23546d2 = {"appendBytes", "", "Ljava/io/File;", "array", "", "appendText", "text", "", "charset", "Ljava/nio/charset/Charset;", "bufferedReader", "Ljava/io/BufferedReader;", "bufferSize", "", "bufferedWriter", "Ljava/io/BufferedWriter;", "forEachBlock", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "buffer", "bytesRead", "blockSize", "forEachLine", "Lkotlin/Function1;", "line", "inputStream", "Ljava/io/FileInputStream;", "outputStream", "Ljava/io/FileOutputStream;", "printWriter", "Ljava/io/PrintWriter;", "readBytes", "readLines", "", "readText", "reader", "Ljava/io/InputStreamReader;", "useLines", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/sequences/Sequence;", "Requires newer compiler version to be inlined correctly.", "(Ljava/io/File;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeBytes", "writeText", "writer", "Ljava/io/OutputStreamWriter;", "kotlin-stdlib"}, m23547k = 5, m23548mv = {1, 1, 16}, m23550xi = 1, m23551xs = "kotlin/io/FilesKt")
/* renamed from: h.n2.p */
/* loaded from: classes2.dex */
class C5457p extends C5456o {

    /* compiled from: FileReadWrite.kt */
    /* renamed from: h.n2.p$a */
    static final class a extends AbstractC5547j0 implements InterfaceC5506l<String, C5715y1> {
        final /* synthetic */ ArrayList $result;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ArrayList arrayList) {
            super(1);
            this.$result = arrayList;
        }

        @Override // p286h.p309q2.p310s.InterfaceC5506l
        public /* bridge */ /* synthetic */ C5715y1 invoke(String str) {
            invoke2(str);
            return C5715y1.f20665a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@InterfaceC5816d String str) {
            C5544i0.m22546f(str, "it");
            this.$result.add(str);
        }
    }

    /* renamed from: a */
    static /* synthetic */ BufferedReader m22337a(File file, Charset charset, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charset = C5731f.f20676a;
        }
        if ((i3 & 2) != 0) {
            i2 = 8192;
        }
        Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, i2);
    }

    /* renamed from: b */
    static /* synthetic */ BufferedWriter m22348b(File file, Charset charset, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charset = C5731f.f20676a;
        }
        if ((i3 & 2) != 0) {
            i2 = 8192;
        }
        Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, i2);
    }

    @InterfaceC5816d
    /* renamed from: c */
    public static final String m22356c(@InterfaceC5816d File file, @InterfaceC5816d Charset charset) {
        C5544i0.m22546f(file, "$this$readText");
        C5544i0.m22546f(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String m22413b = C5465x.m22413b(inputStreamReader);
            C5444c.m22275a(inputStreamReader, (Throwable) null);
            return m22413b;
        } finally {
        }
    }

    /* renamed from: d */
    static /* synthetic */ InputStreamReader m22359d(File file, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = C5731f.f20676a;
        }
        return new InputStreamReader(new FileInputStream(file), charset);
    }

    /* renamed from: e */
    static /* synthetic */ OutputStreamWriter m22362e(File file, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = C5731f.f20676a;
        }
        return new OutputStreamWriter(new FileOutputStream(file), charset);
    }

    @InterfaceC5426f
    /* renamed from: f */
    private static final FileOutputStream m22363f(@InterfaceC5816d File file) {
        return new FileOutputStream(file);
    }

    @InterfaceC5816d
    /* renamed from: g */
    public static final byte[] m22364g(@InterfaceC5816d File file) {
        C5544i0.m22546f(file, "$this$readBytes");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length > Integer.MAX_VALUE) {
                throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
            }
            int i2 = (int) length;
            byte[] bArr = new byte[i2];
            int i3 = 0;
            while (i2 > 0) {
                int read = fileInputStream.read(bArr, i3, i2);
                if (read < 0) {
                    break;
                }
                i2 -= read;
                i3 += read;
            }
            if (i2 > 0) {
                bArr = Arrays.copyOf(bArr, i3);
                C5544i0.m22521a((Object) bArr, "java.util.Arrays.copyOf(this, newSize)");
            } else {
                int read2 = fileInputStream.read();
                if (read2 != -1) {
                    C5448g c5448g = new C5448g(C3414o.a.f12213q);
                    c5448g.write(read2);
                    C5443b.m22246a(fileInputStream, c5448g, 0, 2, null);
                    int length2 = bArr.length + c5448g.size();
                    if (length2 < 0) {
                        throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                    }
                    byte[] buffer = c5448g.getBuffer();
                    byte[] copyOf = Arrays.copyOf(bArr, length2);
                    C5544i0.m22521a((Object) copyOf, "java.util.Arrays.copyOf(this, newSize)");
                    bArr = C5291q.m20196a(buffer, copyOf, bArr.length, 0, c5448g.size());
                }
            }
            C5444c.m22275a(fileInputStream, (Throwable) null);
            return bArr;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                C5444c.m22275a(fileInputStream, th);
                throw th2;
            }
        }
    }

    /* renamed from: c */
    public static /* synthetic */ String m22357c(File file, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = C5731f.f20676a;
        }
        return m22356c(file, charset);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final BufferedReader m22336a(@InterfaceC5816d File file, Charset charset, int i2) {
        Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, i2);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final BufferedWriter m22347b(@InterfaceC5816d File file, Charset charset, int i2) {
        Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, i2);
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final InputStreamReader m22358d(@InterfaceC5816d File file, Charset charset) {
        return new InputStreamReader(new FileInputStream(file), charset);
    }

    @InterfaceC5426f
    /* renamed from: e */
    private static final OutputStreamWriter m22361e(@InterfaceC5816d File file, Charset charset) {
        return new OutputStreamWriter(new FileOutputStream(file), charset);
    }

    /* renamed from: a */
    static /* synthetic */ PrintWriter m22339a(File file, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = C5731f.f20676a;
        }
        Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return new PrintWriter(outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192));
    }

    /* renamed from: b */
    public static final void m22355b(@InterfaceC5816d File file, @InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(file, "$this$writeBytes");
        C5544i0.m22546f(bArr, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            C5715y1 c5715y1 = C5715y1.f20665a;
            C5444c.m22275a(fileOutputStream, (Throwable) null);
        } finally {
        }
    }

    @InterfaceC5426f
    /* renamed from: e */
    private static final FileInputStream m22360e(@InterfaceC5816d File file) {
        return new FileInputStream(file);
    }

    /* renamed from: b */
    public static final void m22353b(@InterfaceC5816d File file, @InterfaceC5816d String str, @InterfaceC5816d Charset charset) {
        C5544i0.m22546f(file, "$this$writeText");
        C5544i0.m22546f(str, "text");
        C5544i0.m22546f(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        C5544i0.m22521a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        m22355b(file, bytes);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final PrintWriter m22338a(@InterfaceC5816d File file, Charset charset) {
        Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return new PrintWriter(outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192));
    }

    /* renamed from: b */
    public static /* synthetic */ void m22354b(File file, String str, Charset charset, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            charset = C5731f.f20676a;
        }
        m22353b(file, str, charset);
    }

    /* renamed from: a */
    public static final void m22346a(@InterfaceC5816d File file, @InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(file, "$this$appendBytes");
        C5544i0.m22546f(bArr, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        try {
            fileOutputStream.write(bArr);
            C5715y1 c5715y1 = C5715y1.f20665a;
            C5444c.m22275a(fileOutputStream, (Throwable) null);
        } finally {
        }
    }

    /* renamed from: b */
    public static /* synthetic */ List m22352b(File file, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = C5731f.f20676a;
        }
        return m22351b(file, charset);
    }

    /* renamed from: a */
    public static final void m22342a(@InterfaceC5816d File file, @InterfaceC5816d String str, @InterfaceC5816d Charset charset) {
        C5544i0.m22546f(file, "$this$appendText");
        C5544i0.m22546f(str, "text");
        C5544i0.m22546f(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        C5544i0.m22521a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        m22346a(file, bytes);
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final List<String> m22351b(@InterfaceC5816d File file, @InterfaceC5816d Charset charset) {
        C5544i0.m22546f(file, "$this$readLines");
        C5544i0.m22546f(charset, "charset");
        ArrayList arrayList = new ArrayList();
        m22344a(file, charset, new a(arrayList));
        return arrayList;
    }

    /* renamed from: a */
    public static /* synthetic */ void m22343a(File file, String str, Charset charset, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            charset = C5731f.f20676a;
        }
        m22342a(file, str, charset);
    }

    /* renamed from: a */
    public static final void m22341a(@InterfaceC5816d File file, @InterfaceC5816d InterfaceC5510p<? super byte[], ? super Integer, C5715y1> interfaceC5510p) {
        C5544i0.m22546f(file, "$this$forEachBlock");
        C5544i0.m22546f(interfaceC5510p, "action");
        m22340a(file, 4096, interfaceC5510p);
    }

    /* renamed from: b */
    public static /* synthetic */ Object m22350b(File file, Charset charset, InterfaceC5506l interfaceC5506l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = C5731f.f20676a;
        }
        C5544i0.m22546f(file, "$this$useLines");
        C5544i0.m22546f(charset, "charset");
        C5544i0.m22546f(interfaceC5506l, "block");
        Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            Object invoke = interfaceC5506l.invoke(C5465x.m22401a(bufferedReader));
            C5535f0.m22474b(1);
            if (C5432l.m22181a(1, 1, 0)) {
                C5444c.m22275a(bufferedReader, (Throwable) null);
            } else {
                bufferedReader.close();
            }
            C5535f0.m22471a(1);
            return invoke;
        } finally {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [byte[], java.lang.Object] */
    /* renamed from: a */
    public static final void m22340a(@InterfaceC5816d File file, int i2, @InterfaceC5816d InterfaceC5510p<? super byte[], ? super Integer, C5715y1> interfaceC5510p) {
        int m23050a;
        C5544i0.m22546f(file, "$this$forEachBlock");
        C5544i0.m22546f(interfaceC5510p, "action");
        m23050a = C5648q.m23050a(i2, 512);
        ?? r2 = new byte[m23050a];
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int read = fileInputStream.read(r2);
                if (read <= 0) {
                    C5715y1 c5715y1 = C5715y1.f20665a;
                    C5444c.m22275a(fileInputStream, (Throwable) null);
                    return;
                }
                interfaceC5510p.invoke(r2, Integer.valueOf(read));
            } finally {
            }
        }
    }

    /* renamed from: b */
    public static final <T> T m22349b(@InterfaceC5816d File file, @InterfaceC5816d Charset charset, @InterfaceC5816d InterfaceC5506l<? super InterfaceC5699m<String>, ? extends T> interfaceC5506l) {
        C5544i0.m22546f(file, "$this$useLines");
        C5544i0.m22546f(charset, "charset");
        C5544i0.m22546f(interfaceC5506l, "block");
        Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            T invoke = interfaceC5506l.invoke(C5465x.m22401a(bufferedReader));
            C5535f0.m22474b(1);
            if (C5432l.m22181a(1, 1, 0)) {
                C5444c.m22275a(bufferedReader, (Throwable) null);
            } else {
                bufferedReader.close();
            }
            C5535f0.m22471a(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                C5535f0.m22474b(1);
                if (C5432l.m22181a(1, 1, 0)) {
                    C5444c.m22275a(bufferedReader, th);
                } else {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused) {
                    }
                }
                C5535f0.m22471a(1);
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public static /* synthetic */ void m22345a(File file, Charset charset, InterfaceC5506l interfaceC5506l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = C5731f.f20676a;
        }
        m22344a(file, charset, (InterfaceC5506l<? super String, C5715y1>) interfaceC5506l);
    }

    /* renamed from: a */
    public static final void m22344a(@InterfaceC5816d File file, @InterfaceC5816d Charset charset, @InterfaceC5816d InterfaceC5506l<? super String, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(file, "$this$forEachLine");
        C5544i0.m22546f(charset, "charset");
        C5544i0.m22546f(interfaceC5506l, "action");
        C5465x.m22410a(new BufferedReader(new InputStreamReader(new FileInputStream(file), charset)), interfaceC5506l);
    }
}
