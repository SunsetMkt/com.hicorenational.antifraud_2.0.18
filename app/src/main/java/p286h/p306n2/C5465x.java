package p286h.p306n2;

import androidx.exifinterface.media.ExifInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p304m2.C5432l;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.AbstractC5547j0;
import p286h.p309q2.p311t.C5535f0;
import p286h.p309q2.p311t.C5544i0;
import p286h.p321x2.C5705s;
import p286h.p321x2.InterfaceC5699m;
import p286h.p323z2.C5731f;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: ReadWrite.kt */
@InterfaceC5481e(name = "TextStreamsKt")
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u0000\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u001c\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u001e\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\r\u001a\u0010\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010*\u00020\u0001\u001a\n\u0010\u0011\u001a\u00020\u0012*\u00020\u0013\u001a\u0010\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015*\u00020\u0002\u001a\n\u0010\u0016\u001a\u00020\u000e*\u00020\u0002\u001a\u0017\u0010\u0016\u001a\u00020\u000e*\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0087\b\u001a\r\u0010\u0019\u001a\u00020\u001a*\u00020\u000eH\u0087\b\u001a5\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001c*\u00020\u00022\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0010\u0012\u0004\u0012\u0002H\u001c0\rH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u001f\u0082\u0002\b\n\u0006\b\u0011(\u001e0\u0001¨\u0006 "}, m23546d2 = {"buffered", "Ljava/io/BufferedReader;", "Ljava/io/Reader;", "bufferSize", "", "Ljava/io/BufferedWriter;", "Ljava/io/Writer;", "copyTo", "", "out", "forEachLine", "", "action", "Lkotlin/Function1;", "", "lineSequence", "Lkotlin/sequences/Sequence;", "readBytes", "", "Ljava/net/URL;", "readLines", "", "readText", "charset", "Ljava/nio/charset/Charset;", "reader", "Ljava/io/StringReader;", "useLines", ExifInterface.GPS_DIRECTION_TRUE, "block", "Requires newer compiler version to be inlined correctly.", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, m23547k = 2, m23548mv = {1, 1, 16})
/* renamed from: h.n2.x */
/* loaded from: classes2.dex */
public final class C5465x {

    /* compiled from: ReadWrite.kt */
    /* renamed from: h.n2.x$a */
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

    @InterfaceC5426f
    /* renamed from: a */
    private static final BufferedReader m22402a(@InterfaceC5816d Reader reader, int i2) {
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i2);
    }

    /* renamed from: b */
    public static final <T> T m22412b(@InterfaceC5816d Reader reader, @InterfaceC5816d InterfaceC5506l<? super InterfaceC5699m<String>, ? extends T> interfaceC5506l) {
        C5544i0.m22546f(reader, "$this$useLines");
        C5544i0.m22546f(interfaceC5506l, "block");
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, 8192);
        try {
            T invoke = interfaceC5506l.invoke(m22401a(bufferedReader));
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

    @InterfaceC5426f
    /* renamed from: a */
    private static final BufferedWriter m22404a(@InterfaceC5816d Writer writer, int i2) {
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i2);
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final String m22413b(@InterfaceC5816d Reader reader) {
        C5544i0.m22546f(reader, "$this$readText");
        StringWriter stringWriter = new StringWriter();
        m22400a(reader, stringWriter, 0, 2, null);
        String stringWriter2 = stringWriter.toString();
        C5544i0.m22521a((Object) stringWriter2, "buffer.toString()");
        return stringWriter2;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final List<String> m22409a(@InterfaceC5816d Reader reader) {
        C5544i0.m22546f(reader, "$this$readLines");
        ArrayList arrayList = new ArrayList();
        m22410a(reader, new a(arrayList));
        return arrayList;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final StringReader m22406a(@InterfaceC5816d String str) {
        return new StringReader(str);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final InterfaceC5699m<String> m22401a(@InterfaceC5816d BufferedReader bufferedReader) {
        InterfaceC5699m<String> m23354a;
        C5544i0.m22546f(bufferedReader, "$this$lineSequence");
        m23354a = C5705s.m23354a(new C5460s(bufferedReader));
        return m23354a;
    }

    /* renamed from: a */
    public static /* synthetic */ long m22400a(Reader reader, Writer writer, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 8192;
        }
        return m22399a(reader, writer, i2);
    }

    /* renamed from: a */
    public static final long m22399a(@InterfaceC5816d Reader reader, @InterfaceC5816d Writer writer, int i2) {
        C5544i0.m22546f(reader, "$this$copyTo");
        C5544i0.m22546f(writer, "out");
        char[] cArr = new char[i2];
        int read = reader.read(cArr);
        long j2 = 0;
        while (read >= 0) {
            writer.write(cArr, 0, read);
            j2 += read;
            read = reader.read(cArr);
        }
        return j2;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final String m22407a(@InterfaceC5816d URL url, Charset charset) {
        return new String(m22411a(url), charset);
    }

    /* renamed from: a */
    static /* synthetic */ String m22408a(URL url, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = C5731f.f20676a;
        }
        return new String(m22411a(url), charset);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final byte[] m22411a(@InterfaceC5816d URL url) {
        C5544i0.m22546f(url, "$this$readBytes");
        InputStream openStream = url.openStream();
        try {
            C5544i0.m22521a((Object) openStream, "it");
            byte[] m22260a = C5443b.m22260a(openStream);
            C5444c.m22275a(openStream, (Throwable) null);
            return m22260a;
        } finally {
        }
    }

    /* renamed from: a */
    static /* synthetic */ BufferedReader m22403a(Reader reader, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8192;
        }
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i2);
    }

    /* renamed from: a */
    static /* synthetic */ BufferedWriter m22405a(Writer writer, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8192;
        }
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i2);
    }

    /* renamed from: a */
    public static final void m22410a(@InterfaceC5816d Reader reader, @InterfaceC5816d InterfaceC5506l<? super String, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(reader, "$this$forEachLine");
        C5544i0.m22546f(interfaceC5506l, "action");
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, 8192);
        try {
            Iterator<String> it = m22401a(bufferedReader).iterator();
            while (it.hasNext()) {
                interfaceC5506l.invoke(it.next());
            }
            C5715y1 c5715y1 = C5715y1.f20665a;
            C5444c.m22275a(bufferedReader, (Throwable) null);
        } finally {
        }
    }
}
