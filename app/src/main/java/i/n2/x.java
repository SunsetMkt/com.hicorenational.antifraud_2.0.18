package i.n2;

import androidx.exifinterface.media.ExifInterface;
import i.q2.t.f0;
import i.q2.t.i0;
import i.q2.t.j0;
import i.y;
import i.y1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ReadWrite.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.q2.e(name = "TextStreamsKt")
@y(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u0000\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u001c\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u001e\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\r\u001a\u0010\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010*\u00020\u0001\u001a\n\u0010\u0011\u001a\u00020\u0012*\u00020\u0013\u001a\u0010\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015*\u00020\u0002\u001a\n\u0010\u0016\u001a\u00020\u000e*\u00020\u0002\u001a\u0017\u0010\u0016\u001a\u00020\u000e*\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0087\b\u001a\r\u0010\u0019\u001a\u00020\u001a*\u00020\u000eH\u0087\b\u001a5\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001c*\u00020\u00022\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0010\u0012\u0004\u0012\u0002H\u001c0\rH\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001f\u0082\u0002\b\n\u0006\b\u0011(\u001e0\u0001\u00a8\u0006 "}, d2 = {"buffered", "Ljava/io/BufferedReader;", "Ljava/io/Reader;", "bufferSize", "", "Ljava/io/BufferedWriter;", "Ljava/io/Writer;", "copyTo", "", "out", "forEachLine", "", "action", "Lkotlin/Function1;", "", "lineSequence", "Lkotlin/sequences/Sequence;", "readBytes", "", "Ljava/net/URL;", "readLines", "", "readText", "charset", "Ljava/nio/charset/Charset;", "reader", "Ljava/io/StringReader;", "useLines", ExifInterface.GPS_DIRECTION_TRUE, "block", "Requires newer compiler version to be inlined correctly.", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 1, 16})
public final class x {

    /* JADX INFO: compiled from: ReadWrite.kt */
    static final class a extends j0 implements i.q2.s.l<String, y1> {
        final /* synthetic */ ArrayList $result;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ArrayList arrayList) {
            super(1);
            this.$result = arrayList;
        }

        @Override // i.q2.s.l
        public /* bridge */ /* synthetic */ y1 invoke(String str) {
            invoke2(str);
            return y1.a;
        }

        /* JADX INFO: renamed from: invoke */
        public final void invoke2(@j.c.a.d String str) {
            i0.f(str, "it");
            this.$result.add(str);
        }
    }

    @i.m2.f
    private static final BufferedReader a(@j.c.a.d Reader reader, int i2) {
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i2);
    }

    public static final <T> T b(@j.c.a.d Reader reader, @j.c.a.d i.q2.s.l<? super i.x2.m<String>, ? extends T> lVar) throws IllegalAccessException, IOException, InvocationTargetException {
        i0.f(reader, "$this$useLines");
        i0.f(lVar, "block");
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, 8192);
        try {
            T tInvoke = lVar.invoke(a(bufferedReader));
            f0.b(1);
            if (i.m2.l.a(1, 1, 0)) {
                c.a(bufferedReader, (Throwable) null);
            } else {
                bufferedReader.close();
            }
            f0.a(1);
            return tInvoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                f0.b(1);
                if (i.m2.l.a(1, 1, 0)) {
                    c.a(bufferedReader, th);
                } else {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused) {
                    }
                }
                f0.a(1);
                throw th2;
            }
        }
    }

    @i.m2.f
    private static final BufferedWriter a(@j.c.a.d Writer writer, int i2) {
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i2);
    }

    @j.c.a.d
    public static final String b(@j.c.a.d Reader reader) {
        i0.f(reader, "$this$readText");
        StringWriter stringWriter = new StringWriter();
        a(reader, stringWriter, 0, 2, null);
        String string = stringWriter.toString();
        i0.a((Object) string, "buffer.toString()");
        return string;
    }

    @j.c.a.d
    public static final List<String> a(@j.c.a.d Reader reader) throws IllegalAccessException, IOException, InvocationTargetException {
        i0.f(reader, "$this$readLines");
        ArrayList arrayList = new ArrayList();
        a(reader, new a(arrayList));
        return arrayList;
    }

    @i.m2.f
    private static final StringReader a(@j.c.a.d String str) {
        return new StringReader(str);
    }

    @j.c.a.d
    public static final i.x2.m<String> a(@j.c.a.d BufferedReader bufferedReader) {
        i0.f(bufferedReader, "$this$lineSequence");
        return i.x2.s.a(new s(bufferedReader));
    }

    public static /* synthetic */ long a(Reader reader, Writer writer, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 8192;
        }
        return a(reader, writer, i2);
    }

    public static final long a(@j.c.a.d Reader reader, @j.c.a.d Writer writer, int i2) throws IOException {
        i0.f(reader, "$this$copyTo");
        i0.f(writer, "out");
        char[] cArr = new char[i2];
        int i3 = reader.read(cArr);
        long j2 = 0;
        while (i3 >= 0) {
            writer.write(cArr, 0, i3);
            j2 += (long) i3;
            i3 = reader.read(cArr);
        }
        return j2;
    }

    @i.m2.f
    private static final String a(@j.c.a.d URL url, Charset charset) {
        return new String(a(url), charset);
    }

    static /* synthetic */ String a(URL url, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = i.z2.f.a;
        }
        return new String(a(url), charset);
    }

    @j.c.a.d
    public static final byte[] a(@j.c.a.d URL url) throws IllegalAccessException, IOException, InvocationTargetException {
        i0.f(url, "$this$readBytes");
        InputStream inputStreamOpenStream = url.openStream();
        try {
            i0.a((Object) inputStreamOpenStream, "it");
            byte[] bArrA = b.a(inputStreamOpenStream);
            c.a(inputStreamOpenStream, (Throwable) null);
            return bArrA;
        } finally {
        }
    }

    static /* synthetic */ BufferedReader a(Reader reader, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8192;
        }
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i2);
    }

    static /* synthetic */ BufferedWriter a(Writer writer, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8192;
        }
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i2);
    }

    public static final void a(@j.c.a.d Reader reader, @j.c.a.d i.q2.s.l<? super String, y1> lVar) throws IllegalAccessException, IOException, InvocationTargetException {
        i0.f(reader, "$this$forEachLine");
        i0.f(lVar, "action");
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, 8192);
        try {
            Iterator<String> it = a(bufferedReader).iterator();
            while (it.hasNext()) {
                lVar.invoke(it.next());
            }
            y1 y1Var = y1.a;
            c.a(bufferedReader, (Throwable) null);
        } finally {
        }
    }
}
