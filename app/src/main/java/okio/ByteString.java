package okio;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.umeng.analytics.pro.C3393cw;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okio.internal.ByteStringKt;
import p286h.C5226e1;
import p286h.EnumC5220d;
import p286h.InterfaceC5216c;
import p286h.InterfaceC5467o0;
import p286h.InterfaceC5713y;
import p286h.p289g2.C5291q;
import p286h.p309q2.InterfaceC5479c;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.InterfaceC5482f;
import p286h.p309q2.InterfaceC5484h;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5586v;
import p286h.p323z2.C5724b0;
import p286h.p323z2.C5731f;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: ByteString.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 Z2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001ZB\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0011\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0000H\u0096\u0002J\u0015\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u001dJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0004J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0000J\u0013\u0010!\u001a\u00020\u001f2\b\u0010\u001a\u001a\u0004\u0018\u00010\"H\u0096\u0002J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b&J\u0015\u0010&\u001a\u00020$2\u0006\u0010%\u001a\u00020\tH\u0007¢\u0006\u0002\b'J\r\u0010(\u001a\u00020\tH\u0010¢\u0006\u0002\b)J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010*\u001a\u00020\u0010H\u0016J\u001d\u0010+\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u0000H\u0010¢\u0006\u0002\b-J\u0010\u0010.\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0000H\u0016J\u0010\u0010/\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0000H\u0016J\u0010\u00100\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0000H\u0016J\u001a\u00101\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\tH\u0017J\u001a\u00101\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u00102\u001a\u00020\tH\u0007J\r\u00103\u001a\u00020\u0004H\u0010¢\u0006\u0002\b4J\u0015\u00105\u001a\u00020$2\u0006\u00106\u001a\u00020\tH\u0010¢\u0006\u0002\b7J\u001a\u00108\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\tH\u0017J\u001a\u00108\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u00102\u001a\u00020\tH\u0007J\b\u00109\u001a\u00020\u0000H\u0016J(\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\tH\u0016J(\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\tH\u0016J\u0010\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0002J\b\u0010B\u001a\u00020\u0000H\u0016J\b\u0010C\u001a\u00020\u0000H\u0016J\b\u0010D\u001a\u00020\u0000H\u0016J\r\u0010\u000e\u001a\u00020\tH\u0007¢\u0006\u0002\bEJ\u000e\u0010F\u001a\u00020\u001f2\u0006\u0010G\u001a\u00020\u0004J\u000e\u0010F\u001a\u00020\u001f2\u0006\u0010G\u001a\u00020\u0000J\u0010\u0010H\u001a\u00020\u00102\u0006\u0010I\u001a\u00020JH\u0016J\u001c\u0010K\u001a\u00020\u00002\b\b\u0002\u0010L\u001a\u00020\t2\b\b\u0002\u0010M\u001a\u00020\tH\u0017J\b\u0010N\u001a\u00020\u0000H\u0016J\b\u0010O\u001a\u00020\u0000H\u0016J\b\u0010P\u001a\u00020\u0004H\u0016J\b\u0010Q\u001a\u00020\u0010H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010R\u001a\u00020?2\u0006\u0010S\u001a\u00020TH\u0016J%\u0010R\u001a\u00020?2\u0006\u0010U\u001a\u00020V2\u0006\u0010;\u001a\u00020\t2\u0006\u0010=\u001a\u00020\tH\u0010¢\u0006\u0002\bWJ\u0010\u0010X\u001a\u00020?2\u0006\u0010S\u001a\u00020YH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006["}, m23546d2 = {"Lokio/ByteString;", "Ljava/io/Serializable;", "", "data", "", "([B)V", "getData$okio", "()[B", "hashCode", "", "getHashCode$okio", "()I", "setHashCode$okio", "(I)V", "size", "utf8", "", "getUtf8$okio", "()Ljava/lang/String;", "setUtf8$okio", "(Ljava/lang/String;)V", "asByteBuffer", "Ljava/nio/ByteBuffer;", "base64", "base64Url", "compareTo", DispatchConstants.OTHER, "digest", "algorithm", "digest$okio", "endsWith", "", "suffix", "equals", "", "get", "", "index", "getByte", "-deprecated_getByte", "getSize", "getSize$okio", "hex", "hmac", "key", "hmac$okio", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "fromIndex", "internalArray", "internalArray$okio", "internalGet", "pos", "internalGet$okio", "lastIndexOf", "md5", "rangeEquals", "offset", "otherOffset", "byteCount", "readObject", "", "in", "Ljava/io/ObjectInputStream;", "sha1", "sha256", "sha512", "-deprecated_size", "startsWith", RequestParameters.PREFIX, "string", "charset", "Ljava/nio/charset/Charset;", "substring", "beginIndex", "endIndex", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", "toString", "write", "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "write$okio", "writeObject", "Ljava/io/ObjectOutputStream;", "Companion", "okio"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public class ByteString implements Serializable, Comparable<ByteString> {
    public static final Companion Companion = new Companion(null);

    @InterfaceC5479c
    @InterfaceC5816d
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;

    @InterfaceC5816d
    private final byte[] data;
    private transient int hashCode;

    @InterfaceC5817e
    private transient String utf8;

    /* compiled from: ByteString.kt */
    @InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\fJ\u001d\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\b\u0010J\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\u0012J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\b\u0016J\u0014\u0010\u0013\u001a\u00020\u00042\n\u0010\u0017\u001a\u00020\u0018\"\u00020\u0019H\u0007J%\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b\u0016J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b!J\u000e\u0010\u0007\u001a\u0004\u0018\u00010\u0004*\u00020\tH\u0007J\f\u0010\u000b\u001a\u00020\u0004*\u00020\tH\u0007J\u001b\u0010\"\u001a\u00020\u0004*\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\b\rJ\f\u0010\u0011\u001a\u00020\u0004*\u00020\tH\u0007J\u0019\u0010#\u001a\u00020\u0004*\u00020 2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b\u001eJ\u0011\u0010$\u001a\u00020\u0004*\u00020\u0015H\u0007¢\u0006\u0002\b\u0013J%\u0010$\u001a\u00020\u0004*\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b\u0013R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006%"}, m23546d2 = {"Lokio/ByteString$Companion;", "", "()V", "EMPTY", "Lokio/ByteString;", "serialVersionUID", "", "decodeBase64", "string", "", "-deprecated_decodeBase64", "decodeHex", "-deprecated_decodeHex", "encodeString", "charset", "Ljava/nio/charset/Charset;", "-deprecated_encodeString", "encodeUtf8", "-deprecated_encodeUtf8", "of", "buffer", "Ljava/nio/ByteBuffer;", "-deprecated_of", "data", "", "", "array", "offset", "", "byteCount", "read", "inputstream", "Ljava/io/InputStream;", "-deprecated_read", "encode", "readByteString", "toByteString", "okio"}, m23547k = 1, m23548mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ ByteString encodeString$default(Companion companion, String str, Charset charset, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                charset = C5731f.f20676a;
            }
            return companion.encodeString(str, charset);
        }

        public static /* synthetic */ ByteString of$default(Companion companion, byte[] bArr, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i2 = 0;
            }
            if ((i4 & 2) != 0) {
                i3 = bArr.length;
            }
            return companion.m24930of(bArr, i2, i3);
        }

        @InterfaceC5481e(name = "-deprecated_decodeBase64")
        @InterfaceC5216c(level = EnumC5220d.ERROR, message = "moved to extension function", replaceWith = @InterfaceC5467o0(expression = "string.decodeBase64()", imports = {"okio.ByteString.Companion.decodeBase64"}))
        @InterfaceC5817e
        /* renamed from: -deprecated_decodeBase64 */
        public final ByteString m26871deprecated_decodeBase64(@InterfaceC5816d String str) {
            C5544i0.m22546f(str, "string");
            return decodeBase64(str);
        }

        @InterfaceC5481e(name = "-deprecated_decodeHex")
        @InterfaceC5216c(level = EnumC5220d.ERROR, message = "moved to extension function", replaceWith = @InterfaceC5467o0(expression = "string.decodeHex()", imports = {"okio.ByteString.Companion.decodeHex"}))
        @InterfaceC5816d
        /* renamed from: -deprecated_decodeHex */
        public final ByteString m26872deprecated_decodeHex(@InterfaceC5816d String str) {
            C5544i0.m22546f(str, "string");
            return decodeHex(str);
        }

        @InterfaceC5481e(name = "-deprecated_encodeString")
        @InterfaceC5216c(level = EnumC5220d.ERROR, message = "moved to extension function", replaceWith = @InterfaceC5467o0(expression = "string.encode(charset)", imports = {"okio.ByteString.Companion.encode"}))
        @InterfaceC5816d
        /* renamed from: -deprecated_encodeString */
        public final ByteString m26873deprecated_encodeString(@InterfaceC5816d String str, @InterfaceC5816d Charset charset) {
            C5544i0.m22546f(str, "string");
            C5544i0.m22546f(charset, "charset");
            return encodeString(str, charset);
        }

        @InterfaceC5481e(name = "-deprecated_encodeUtf8")
        @InterfaceC5216c(level = EnumC5220d.ERROR, message = "moved to extension function", replaceWith = @InterfaceC5467o0(expression = "string.encodeUtf8()", imports = {"okio.ByteString.Companion.encodeUtf8"}))
        @InterfaceC5816d
        /* renamed from: -deprecated_encodeUtf8 */
        public final ByteString m26874deprecated_encodeUtf8(@InterfaceC5816d String str) {
            C5544i0.m22546f(str, "string");
            return encodeUtf8(str);
        }

        @InterfaceC5481e(name = "-deprecated_of")
        @InterfaceC5216c(level = EnumC5220d.ERROR, message = "moved to extension function", replaceWith = @InterfaceC5467o0(expression = "buffer.toByteString()", imports = {"okio.ByteString.Companion.toByteString"}))
        @InterfaceC5816d
        /* renamed from: -deprecated_of */
        public final ByteString m26875deprecated_of(@InterfaceC5816d ByteBuffer byteBuffer) {
            C5544i0.m22546f(byteBuffer, "buffer");
            return m24928of(byteBuffer);
        }

        @InterfaceC5481e(name = "-deprecated_read")
        @InterfaceC5216c(level = EnumC5220d.ERROR, message = "moved to extension function", replaceWith = @InterfaceC5467o0(expression = "inputstream.readByteString(byteCount)", imports = {"okio.ByteString.Companion.readByteString"}))
        @InterfaceC5816d
        /* renamed from: -deprecated_read */
        public final ByteString m26877deprecated_read(@InterfaceC5816d InputStream inputStream, int i2) {
            C5544i0.m22546f(inputStream, "inputstream");
            return read(inputStream, i2);
        }

        @InterfaceC5817e
        @InterfaceC5484h
        public final ByteString decodeBase64(@InterfaceC5816d String str) {
            C5544i0.m22546f(str, "$this$decodeBase64");
            byte[] decodeBase64ToArray = Base64.decodeBase64ToArray(str);
            if (decodeBase64ToArray != null) {
                return new ByteString(decodeBase64ToArray);
            }
            return null;
        }

        @InterfaceC5484h
        @InterfaceC5816d
        public final ByteString decodeHex(@InterfaceC5816d String str) {
            C5544i0.m22546f(str, "$this$decodeHex");
            if (!(str.length() % 2 == 0)) {
                throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
            }
            byte[] bArr = new byte[str.length() / 2];
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ((ByteStringKt.decodeHexDigit(str.charAt(i3)) << 4) + ByteStringKt.decodeHexDigit(str.charAt(i3 + 1)));
            }
            return new ByteString(bArr);
        }

        @InterfaceC5481e(name = "encodeString")
        @InterfaceC5484h
        @InterfaceC5816d
        public final ByteString encodeString(@InterfaceC5816d String str, @InterfaceC5816d Charset charset) {
            C5544i0.m22546f(str, "$this$encode");
            C5544i0.m22546f(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            C5544i0.m22521a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            return new ByteString(bytes);
        }

        @InterfaceC5484h
        @InterfaceC5816d
        public final ByteString encodeUtf8(@InterfaceC5816d String str) {
            C5544i0.m22546f(str, "$this$encodeUtf8");
            ByteString byteString = new ByteString(Platform.asUtf8ToByteArray(str));
            byteString.setUtf8$okio(str);
            return byteString;
        }

        @InterfaceC5481e(name = "of")
        @InterfaceC5484h
        @InterfaceC5816d
        /* renamed from: of */
        public final ByteString m24928of(@InterfaceC5816d ByteBuffer byteBuffer) {
            C5544i0.m22546f(byteBuffer, "$this$toByteString");
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return new ByteString(bArr);
        }

        @InterfaceC5481e(name = "read")
        @InterfaceC5484h
        @InterfaceC5816d
        public final ByteString read(@InterfaceC5816d InputStream inputStream, int i2) throws IOException {
            C5544i0.m22546f(inputStream, "$this$readByteString");
            int i3 = 0;
            if (!(i2 >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + i2).toString());
            }
            byte[] bArr = new byte[i2];
            while (i3 < i2) {
                int read = inputStream.read(bArr, i3, i2 - i3);
                if (read == -1) {
                    throw new EOFException();
                }
                i3 += read;
            }
            return new ByteString(bArr);
        }

        public /* synthetic */ Companion(C5586v c5586v) {
            this();
        }

        @InterfaceC5481e(name = "-deprecated_of")
        @InterfaceC5216c(level = EnumC5220d.ERROR, message = "moved to extension function", replaceWith = @InterfaceC5467o0(expression = "array.toByteString(offset, byteCount)", imports = {"okio.ByteString.Companion.toByteString"}))
        @InterfaceC5816d
        /* renamed from: -deprecated_of */
        public final ByteString m26876deprecated_of(@InterfaceC5816d byte[] bArr, int i2, int i3) {
            C5544i0.m22546f(bArr, "array");
            return m24930of(bArr, i2, i3);
        }

        @InterfaceC5484h
        @InterfaceC5816d
        /* renamed from: of */
        public final ByteString m24929of(@InterfaceC5816d byte... bArr) {
            C5544i0.m22546f(bArr, "data");
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            C5544i0.m22521a((Object) copyOf, "java.util.Arrays.copyOf(this, size)");
            return new ByteString(copyOf);
        }

        @InterfaceC5481e(name = "of")
        @InterfaceC5484h
        @InterfaceC5816d
        /* renamed from: of */
        public final ByteString m24930of(@InterfaceC5816d byte[] bArr, int i2, int i3) {
            C5544i0.m22546f(bArr, "$this$toByteString");
            Util.checkOffsetAndCount(bArr.length, i2, i3);
            return new ByteString(C5291q.m20194a(bArr, i2, i3 + i2));
        }
    }

    public ByteString(@InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(bArr, "data");
        this.data = bArr;
    }

    @InterfaceC5817e
    @InterfaceC5484h
    public static final ByteString decodeBase64(@InterfaceC5816d String str) {
        return Companion.decodeBase64(str);
    }

    @InterfaceC5484h
    @InterfaceC5816d
    public static final ByteString decodeHex(@InterfaceC5816d String str) {
        return Companion.decodeHex(str);
    }

    @InterfaceC5481e(name = "encodeString")
    @InterfaceC5484h
    @InterfaceC5816d
    public static final ByteString encodeString(@InterfaceC5816d String str, @InterfaceC5816d Charset charset) {
        return Companion.encodeString(str, charset);
    }

    @InterfaceC5484h
    @InterfaceC5816d
    public static final ByteString encodeUtf8(@InterfaceC5816d String str) {
        return Companion.encodeUtf8(str);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, ByteString byteString2, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return byteString.indexOf(byteString2, i2);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, byte[] bArr, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return byteString.indexOf(bArr, i2);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, ByteString byteString2, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i3 & 2) != 0) {
            i2 = byteString.size();
        }
        return byteString.lastIndexOf(byteString2, i2);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, byte[] bArr, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i3 & 2) != 0) {
            i2 = byteString.size();
        }
        return byteString.lastIndexOf(bArr, i2);
    }

    @InterfaceC5481e(name = "of")
    @InterfaceC5484h
    @InterfaceC5816d
    /* renamed from: of */
    public static final ByteString m24925of(@InterfaceC5816d ByteBuffer byteBuffer) {
        return Companion.m24928of(byteBuffer);
    }

    @InterfaceC5484h
    @InterfaceC5816d
    /* renamed from: of */
    public static final ByteString m24926of(@InterfaceC5816d byte... bArr) {
        return Companion.m24929of(bArr);
    }

    @InterfaceC5481e(name = "of")
    @InterfaceC5484h
    @InterfaceC5816d
    /* renamed from: of */
    public static final ByteString m24927of(@InterfaceC5816d byte[] bArr, int i2, int i3) {
        return Companion.m24930of(bArr, i2, i3);
    }

    @InterfaceC5481e(name = "read")
    @InterfaceC5484h
    @InterfaceC5816d
    public static final ByteString read(@InterfaceC5816d InputStream inputStream, int i2) throws IOException {
        return Companion.read(inputStream, i2);
    }

    private final void readObject(ObjectInputStream objectInputStream) throws IOException {
        ByteString read = Companion.read(objectInputStream, objectInputStream.readInt());
        Field declaredField = ByteString.class.getDeclaredField("data");
        C5544i0.m22521a((Object) declaredField, "field");
        declaredField.setAccessible(true);
        declaredField.set(this, read.data);
    }

    public static /* synthetic */ ByteString substring$default(ByteString byteString, int i2, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
        }
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = byteString.size();
        }
        return byteString.substring(i2, i3);
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    @InterfaceC5481e(name = "-deprecated_getByte")
    @InterfaceC5216c(level = EnumC5220d.ERROR, message = "moved to operator function", replaceWith = @InterfaceC5467o0(expression = "this[index]", imports = {}))
    /* renamed from: -deprecated_getByte */
    public final byte m26869deprecated_getByte(int i2) {
        return getByte(i2);
    }

    @InterfaceC5481e(name = "-deprecated_size")
    @InterfaceC5216c(level = EnumC5220d.ERROR, message = "moved to val", replaceWith = @InterfaceC5467o0(expression = "size", imports = {}))
    /* renamed from: -deprecated_size */
    public final int m26870deprecated_size() {
        return size();
    }

    @InterfaceC5816d
    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        C5544i0.m22521a((Object) asReadOnlyBuffer, "ByteBuffer.wrap(data).asReadOnlyBuffer()");
        return asReadOnlyBuffer;
    }

    @InterfaceC5816d
    public String base64() {
        return Base64.encodeBase64$default(getData$okio(), null, 1, null);
    }

    @InterfaceC5816d
    public String base64Url() {
        return Base64.encodeBase64(getData$okio(), Base64.getBASE64_URL_SAFE());
    }

    @InterfaceC5816d
    public ByteString digest$okio(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "algorithm");
        byte[] digest = MessageDigest.getInstance(str).digest(this.data);
        C5544i0.m22521a((Object) digest, "MessageDigest.getInstance(algorithm).digest(data)");
        return new ByteString(digest);
    }

    public final boolean endsWith(@InterfaceC5816d ByteString byteString) {
        C5544i0.m22546f(byteString, "suffix");
        return rangeEquals(size() - byteString.size(), byteString, 0, byteString.size());
    }

    public boolean equals(@InterfaceC5817e Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == getData$okio().length && byteString.rangeEquals(0, getData$okio(), 0, getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    @InterfaceC5481e(name = "getByte")
    public final byte getByte(int i2) {
        return internalGet$okio(i2);
    }

    @InterfaceC5816d
    public final byte[] getData$okio() {
        return this.data;
    }

    public final int getHashCode$okio() {
        return this.hashCode;
    }

    public int getSize$okio() {
        return getData$okio().length;
    }

    @InterfaceC5817e
    public final String getUtf8$okio() {
        return this.utf8;
    }

    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode = Arrays.hashCode(getData$okio());
        setHashCode$okio(hashCode);
        return hashCode;
    }

    @InterfaceC5816d
    public String hex() {
        char[] cArr = new char[getData$okio().length * 2];
        int i2 = 0;
        for (byte b2 : getData$okio()) {
            int i3 = i2 + 1;
            cArr[i2] = ByteStringKt.getHEX_DIGIT_CHARS()[(b2 >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = ByteStringKt.getHEX_DIGIT_CHARS()[b2 & C3393cw.f11873m];
        }
        return new String(cArr);
    }

    @InterfaceC5816d
    public ByteString hmac$okio(@InterfaceC5816d String str, @InterfaceC5816d ByteString byteString) {
        C5544i0.m22546f(str, "algorithm");
        C5544i0.m22546f(byteString, "key");
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            byte[] doFinal = mac.doFinal(this.data);
            C5544i0.m22521a((Object) doFinal, "mac.doFinal(data)");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    @InterfaceC5816d
    public ByteString hmacSha1(@InterfaceC5816d ByteString byteString) {
        C5544i0.m22546f(byteString, "key");
        return hmac$okio("HmacSHA1", byteString);
    }

    @InterfaceC5816d
    public ByteString hmacSha256(@InterfaceC5816d ByteString byteString) {
        C5544i0.m22546f(byteString, "key");
        return hmac$okio("HmacSHA256", byteString);
    }

    @InterfaceC5816d
    public ByteString hmacSha512(@InterfaceC5816d ByteString byteString) {
        C5544i0.m22546f(byteString, "key");
        return hmac$okio("HmacSHA512", byteString);
    }

    @InterfaceC5482f
    public final int indexOf(@InterfaceC5816d ByteString byteString) {
        return indexOf$default(this, byteString, 0, 2, (Object) null);
    }

    @InterfaceC5482f
    public final int indexOf(@InterfaceC5816d ByteString byteString, int i2) {
        C5544i0.m22546f(byteString, DispatchConstants.OTHER);
        return indexOf(byteString.internalArray$okio(), i2);
    }

    @InterfaceC5482f
    public int indexOf(@InterfaceC5816d byte[] bArr) {
        return indexOf$default(this, bArr, 0, 2, (Object) null);
    }

    @InterfaceC5816d
    public byte[] internalArray$okio() {
        return getData$okio();
    }

    public byte internalGet$okio(int i2) {
        return getData$okio()[i2];
    }

    @InterfaceC5482f
    public final int lastIndexOf(@InterfaceC5816d ByteString byteString) {
        return lastIndexOf$default(this, byteString, 0, 2, (Object) null);
    }

    @InterfaceC5482f
    public final int lastIndexOf(@InterfaceC5816d ByteString byteString, int i2) {
        C5544i0.m22546f(byteString, DispatchConstants.OTHER);
        return lastIndexOf(byteString.internalArray$okio(), i2);
    }

    @InterfaceC5482f
    public int lastIndexOf(@InterfaceC5816d byte[] bArr) {
        return lastIndexOf$default(this, bArr, 0, 2, (Object) null);
    }

    @InterfaceC5816d
    public ByteString md5() {
        return digest$okio("MD5");
    }

    public boolean rangeEquals(int i2, @InterfaceC5816d ByteString byteString, int i3, int i4) {
        C5544i0.m22546f(byteString, DispatchConstants.OTHER);
        return byteString.rangeEquals(i3, getData$okio(), i2, i4);
    }

    public final void setHashCode$okio(int i2) {
        this.hashCode = i2;
    }

    public final void setUtf8$okio(@InterfaceC5817e String str) {
        this.utf8 = str;
    }

    @InterfaceC5816d
    public ByteString sha1() {
        return digest$okio("SHA-1");
    }

    @InterfaceC5816d
    public ByteString sha256() {
        return digest$okio("SHA-256");
    }

    @InterfaceC5816d
    public ByteString sha512() {
        return digest$okio("SHA-512");
    }

    @InterfaceC5481e(name = "size")
    public final int size() {
        return getSize$okio();
    }

    public final boolean startsWith(@InterfaceC5816d ByteString byteString) {
        C5544i0.m22546f(byteString, RequestParameters.PREFIX);
        return rangeEquals(0, byteString, 0, byteString.size());
    }

    @InterfaceC5816d
    public String string(@InterfaceC5816d Charset charset) {
        C5544i0.m22546f(charset, "charset");
        return new String(this.data, charset);
    }

    @InterfaceC5482f
    @InterfaceC5816d
    public ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    @InterfaceC5482f
    @InterfaceC5816d
    public ByteString substring(int i2) {
        return substring$default(this, i2, 0, 2, null);
    }

    @InterfaceC5482f
    @InterfaceC5816d
    public ByteString substring(int i2, int i3) {
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
        if (i3 <= getData$okio().length) {
            if (i3 - i2 >= 0) {
                return (i2 == 0 && i3 == getData$okio().length) ? this : new ByteString(C5291q.m20194a(getData$okio(), i2, i3));
            }
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
        throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
    }

    @InterfaceC5816d
    public ByteString toAsciiLowercase() {
        byte b2;
        for (int i2 = 0; i2 < getData$okio().length; i2++) {
            byte b3 = getData$okio()[i2];
            byte b4 = (byte) 65;
            if (b3 >= b4 && b3 <= (b2 = (byte) 90)) {
                byte[] data$okio = getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                C5544i0.m22521a((Object) copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i2] = (byte) (b3 + 32);
                for (int i3 = i2 + 1; i3 < copyOf.length; i3++) {
                    byte b5 = copyOf[i3];
                    if (b5 >= b4 && b5 <= b2) {
                        copyOf[i3] = (byte) (b5 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    @InterfaceC5816d
    public ByteString toAsciiUppercase() {
        byte b2;
        for (int i2 = 0; i2 < getData$okio().length; i2++) {
            byte b3 = getData$okio()[i2];
            byte b4 = (byte) 97;
            if (b3 >= b4 && b3 <= (b2 = (byte) 122)) {
                byte[] data$okio = getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                C5544i0.m22521a((Object) copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i2] = (byte) (b3 - 32);
                for (int i3 = i2 + 1; i3 < copyOf.length; i3++) {
                    byte b5 = copyOf[i3];
                    if (b5 >= b4 && b5 <= b2) {
                        copyOf[i3] = (byte) (b5 - 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    @InterfaceC5816d
    public byte[] toByteArray() {
        byte[] data$okio = getData$okio();
        byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
        C5544i0.m22521a((Object) copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @InterfaceC5816d
    public String toString() {
        if (getData$okio().length == 0) {
            return "[size=0]";
        }
        int codePointIndexToCharIndex = ByteStringKt.codePointIndexToCharIndex(getData$okio(), 64);
        if (codePointIndexToCharIndex == -1) {
            if (getData$okio().length <= 64) {
                return "[hex=" + hex() + ']';
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[size=");
            sb.append(getData$okio().length);
            sb.append(" hex=");
            if (64 <= getData$okio().length) {
                sb.append((64 == getData$okio().length ? this : new ByteString(C5291q.m20194a(getData$okio(), 0, 64))).hex());
                sb.append("…]");
                return sb.toString();
            }
            throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
        }
        String utf8 = utf8();
        if (utf8 == null) {
            throw new C5226e1("null cannot be cast to non-null type java.lang.String");
        }
        String substring = utf8.substring(0, codePointIndexToCharIndex);
        C5544i0.m22521a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String m23580a = C5724b0.m23580a(C5724b0.m23580a(C5724b0.m23580a(substring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
        if (codePointIndexToCharIndex >= utf8.length()) {
            return "[text=" + m23580a + ']';
        }
        return "[size=" + getData$okio().length + " text=" + m23580a + "…]";
    }

    @InterfaceC5816d
    public String utf8() {
        String utf8$okio = getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        String utf8String = Platform.toUtf8String(internalArray$okio());
        setUtf8$okio(utf8String);
        return utf8String;
    }

    public void write(@InterfaceC5816d OutputStream outputStream) throws IOException {
        C5544i0.m22546f(outputStream, "out");
        outputStream.write(this.data);
    }

    public void write$okio(@InterfaceC5816d Buffer buffer, int i2, int i3) {
        C5544i0.m22546f(buffer, "buffer");
        ByteStringKt.commonWrite(this, buffer, i2, i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0032, code lost:
    
        return 1;
     */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(@p324i.p336c.p337a.InterfaceC5816d okio.ByteString r10) {
        /*
            r9 = this;
            java.lang.String r0 = "other"
            p286h.p309q2.p311t.C5544i0.m22546f(r10, r0)
            int r0 = r9.size()
            int r1 = r10.size()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = 0
        L13:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L2b
            byte r7 = r9.getByte(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.getByte(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L28
            int r4 = r4 + 1
            goto L13
        L28:
            if (r7 >= r8) goto L32
            goto L33
        L2b:
            if (r0 != r1) goto L2f
            r5 = 0
            goto L33
        L2f:
            if (r0 >= r1) goto L32
            goto L33
        L32:
            r5 = 1
        L33:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ByteString.compareTo(okio.ByteString):int");
    }

    public final boolean endsWith(@InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(bArr, "suffix");
        return rangeEquals(size() - bArr.length, bArr, 0, bArr.length);
    }

    @InterfaceC5482f
    public int indexOf(@InterfaceC5816d byte[] bArr, int i2) {
        C5544i0.m22546f(bArr, DispatchConstants.OTHER);
        int length = getData$okio().length - bArr.length;
        int max = Math.max(i2, 0);
        if (max <= length) {
            while (!Util.arrayRangeEquals(getData$okio(), max, bArr, 0, bArr.length)) {
                if (max != length) {
                    max++;
                }
            }
            return max;
        }
        return -1;
    }

    @InterfaceC5482f
    public int lastIndexOf(@InterfaceC5816d byte[] bArr, int i2) {
        C5544i0.m22546f(bArr, DispatchConstants.OTHER);
        for (int min = Math.min(i2, getData$okio().length - bArr.length); min >= 0; min--) {
            if (Util.arrayRangeEquals(getData$okio(), min, bArr, 0, bArr.length)) {
                return min;
            }
        }
        return -1;
    }

    public boolean rangeEquals(int i2, @InterfaceC5816d byte[] bArr, int i3, int i4) {
        C5544i0.m22546f(bArr, DispatchConstants.OTHER);
        return i2 >= 0 && i2 <= getData$okio().length - i4 && i3 >= 0 && i3 <= bArr.length - i4 && Util.arrayRangeEquals(getData$okio(), i2, bArr, i3, i4);
    }

    public final boolean startsWith(@InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(bArr, RequestParameters.PREFIX);
        return rangeEquals(0, bArr, 0, bArr.length);
    }
}
