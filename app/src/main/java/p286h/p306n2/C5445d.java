package p286h.p306n2;

import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import p286h.C5629v;
import p286h.InterfaceC5604s;
import p286h.InterfaceC5713y;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p311t.AbstractC5547j0;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Console.kt */
@InterfaceC5481e(name = "ConsoleKt")
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0005\n\u0002\u0010\f\n\u0002\u0010\u0019\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0087\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\rH\u0087\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eH\u0087\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000fH\u0087\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0010H\u0087\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0011H\u0087\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0012H\u0087\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0013H\u0087\b\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0014H\u0087\b\u001a\t\u0010\u0015\u001a\u00020\nH\u0087\b\u001a\u0013\u0010\u0015\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0087\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\rH\u0087\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eH\u0087\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000fH\u0087\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0010H\u0087\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0011H\u0087\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0012H\u0087\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0013H\u0087\b\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0014H\u0087\b\u001a\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u001a\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\f\u0010\u001a\u001a\u00020\r*\u00020\u001bH\u0002\u001a\f\u0010\u001c\u001a\u00020\n*\u00020\u001dH\u0002\u001a\u0018\u0010\u001e\u001a\u00020\n*\u00020\u001b2\n\u0010\u001f\u001a\u00060 j\u0002`!H\u0002\u001a$\u0010\"\u001a\u00020\r*\u00020\u00042\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\rH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006'"}, m23546d2 = {"BUFFER_SIZE", "", "LINE_SEPARATOR_MAX_LENGTH", "decoder", "Ljava/nio/charset/CharsetDecoder;", "getDecoder", "()Ljava/nio/charset/CharsetDecoder;", "decoder$delegate", "Lkotlin/Lazy;", "print", "", "message", "", "", "", "", "", "", "", "", "", "println", "readLine", "", "inputStream", "Ljava/io/InputStream;", "endsWithLineSeparator", "Ljava/nio/CharBuffer;", "flipBack", "Ljava/nio/Buffer;", "offloadPrefixTo", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "tryDecode", "byteBuffer", "Ljava/nio/ByteBuffer;", "charBuffer", "isEndOfStream", "kotlin-stdlib"}, m23547k = 2, m23548mv = {1, 1, 16})
/* renamed from: h.n2.d */
/* loaded from: classes2.dex */
public final class C5445d {

    /* renamed from: a */
    private static final int f20311a = 32;

    /* renamed from: b */
    private static final int f20312b = 2;

    /* renamed from: c */
    private static final InterfaceC5604s f20313c;

    /* compiled from: Console.kt */
    /* renamed from: h.n2.d$a */
    static final class a extends AbstractC5547j0 implements InterfaceC5495a<CharsetDecoder> {
        public static final a INSTANCE = new a();

        a() {
            super(0);
        }

        @Override // p286h.p309q2.p310s.InterfaceC5495a
        public final CharsetDecoder invoke() {
            return Charset.defaultCharset().newDecoder();
        }
    }

    static {
        InterfaceC5604s m22990a;
        m22990a = C5629v.m22990a(a.INSTANCE);
        f20313c = m22990a;
    }

    /* renamed from: a */
    private static final CharsetDecoder m22277a() {
        return (CharsetDecoder) f20313c.getValue();
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final void m22284a(Object obj) {
        System.out.print(obj);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final void m22299b(Object obj) {
        System.out.println(obj);
    }

    @InterfaceC5817e
    /* renamed from: c */
    public static final String m22303c() {
        InputStream inputStream = System.in;
        C5544i0.m22521a((Object) inputStream, "System.`in`");
        return m22276a(inputStream, m22277a());
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final void m22282a(int i2) {
        System.out.print(i2);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final void m22297b(int i2) {
        System.out.println(i2);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final void m22283a(long j2) {
        System.out.print(j2);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final void m22298b(long j2) {
        System.out.println(j2);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final void m22278a(byte b2) {
        System.out.print(Byte.valueOf(b2));
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final void m22293b(byte b2) {
        System.out.println(Byte.valueOf(b2));
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final void m22287a(short s) {
        System.out.print(Short.valueOf(s));
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final void m22300b(short s) {
        System.out.println(Short.valueOf(s));
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final void m22279a(char c2) {
        System.out.print(c2);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final void m22294b(char c2) {
        System.out.println(c2);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final void m22288a(boolean z) {
        System.out.print(z);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final void m22301b(boolean z) {
        System.out.println(z);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final void m22281a(float f2) {
        System.out.print(f2);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final void m22296b(float f2) {
        System.out.println(f2);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final void m22280a(double d2) {
        System.out.print(d2);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final void m22295b(double d2) {
        System.out.println(d2);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final void m22289a(char[] cArr) {
        System.out.print(cArr);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final void m22302b(char[] cArr) {
        System.out.println(cArr);
    }

    @InterfaceC5817e
    /* renamed from: a */
    public static final String m22276a(@InterfaceC5816d InputStream inputStream, @InterfaceC5816d CharsetDecoder charsetDecoder) {
        C5544i0.m22546f(inputStream, "inputStream");
        C5544i0.m22546f(charsetDecoder, "decoder");
        if (charsetDecoder.maxCharsPerByte() <= ((float) 1)) {
            ByteBuffer allocate = ByteBuffer.allocate(32);
            CharBuffer allocate2 = CharBuffer.allocate(4);
            StringBuilder sb = new StringBuilder();
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            do {
                allocate.put((byte) read);
                C5544i0.m22521a((Object) allocate, "byteBuffer");
                C5544i0.m22521a((Object) allocate2, "charBuffer");
                if (m22291a(charsetDecoder, allocate, allocate2, false)) {
                    if (m22290a(allocate2)) {
                        break;
                    }
                    if (allocate2.remaining() < 2) {
                        m22286a(allocate2, sb);
                    }
                }
                read = inputStream.read();
            } while (read != -1);
            m22291a(charsetDecoder, allocate, allocate2, true);
            charsetDecoder.reset();
            int position = allocate2.position();
            if (position > 0 && allocate2.get(position - 1) == '\n' && position - 1 > 0 && allocate2.get(position - 1) == '\r') {
                position--;
            }
            allocate2.flip();
            for (int i2 = 0; i2 < position; i2++) {
                sb.append(allocate2.get());
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("Encodings with multiple chars per byte are not supported".toString());
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final void m22292b() {
        System.out.println();
    }

    /* renamed from: a */
    private static final boolean m22291a(@InterfaceC5816d CharsetDecoder charsetDecoder, ByteBuffer byteBuffer, CharBuffer charBuffer, boolean z) {
        int position = charBuffer.position();
        byteBuffer.flip();
        CoderResult decode = charsetDecoder.decode(byteBuffer, charBuffer, z);
        if (decode.isError()) {
            decode.throwException();
        }
        boolean z2 = charBuffer.position() > position;
        if (z2) {
            byteBuffer.clear();
        } else {
            m22285a((Buffer) byteBuffer);
        }
        return z2;
    }

    /* renamed from: a */
    private static final boolean m22290a(@InterfaceC5816d CharBuffer charBuffer) {
        int position = charBuffer.position();
        return position > 0 && charBuffer.get(position - 1) == '\n';
    }

    /* renamed from: a */
    private static final void m22285a(@InterfaceC5816d Buffer buffer) {
        buffer.position(buffer.limit());
        buffer.limit(buffer.capacity());
    }

    /* renamed from: a */
    private static final void m22286a(@InterfaceC5816d CharBuffer charBuffer, StringBuilder sb) {
        charBuffer.flip();
        int limit = charBuffer.limit() - 1;
        for (int i2 = 0; i2 < limit; i2++) {
            sb.append(charBuffer.get());
        }
        charBuffer.compact();
    }
}
