package okio.internal;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.analytics.pro.C3393cw;
import java.util.Arrays;
import okio.Base64;
import okio.Buffer;
import okio.ByteString;
import okio.Platform;
import okio.Util;
import p286h.C5226e1;
import p286h.C5230f1;
import p286h.InterfaceC5713y;
import p286h.p289g2.C5291q;
import p286h.p309q2.p311t.C5544i0;
import p286h.p323z2.C5724b0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: ByteString.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0002\u001a\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0080\b\u001a\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\r\u0010\u000f\u001a\u00020\u0010*\u00020\nH\u0080\b\u001a\r\u0010\u0011\u001a\u00020\u0010*\u00020\nH\u0080\b\u001a\u0015\u0010\u0012\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0080\b\u001a\u000f\u0010\u0014\u001a\u0004\u0018\u00010\n*\u00020\u0010H\u0080\b\u001a\r\u0010\u0015\u001a\u00020\n*\u00020\u0010H\u0080\b\u001a\r\u0010\u0016\u001a\u00020\n*\u00020\u0010H\u0080\b\u001a\u0015\u0010\u0017\u001a\u00020\u0018*\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010\u0017\u001a\u00020\u0018*\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\u0080\b\u001a\u0017\u0010\u001a\u001a\u00020\u0018*\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u001bH\u0080\b\u001a\u0015\u0010\u001c\u001a\u00020\u001d*\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0005H\u0080\b\u001a\r\u0010\u001f\u001a\u00020\u0005*\u00020\nH\u0080\b\u001a\r\u0010 \u001a\u00020\u0005*\u00020\nH\u0080\b\u001a\r\u0010!\u001a\u00020\u0010*\u00020\nH\u0080\b\u001a\u001d\u0010\"\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0005H\u0080\b\u001a\r\u0010$\u001a\u00020\u0007*\u00020\nH\u0080\b\u001a\u001d\u0010%\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0005H\u0080\b\u001a\u001d\u0010%\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0005H\u0080\b\u001a-\u0010&\u001a\u00020\u0018*\u00020\n2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0080\b\u001a-\u0010&\u001a\u00020\u0018*\u00020\n2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010*\u001a\u00020\u0018*\u00020\n2\u0006\u0010+\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010*\u001a\u00020\u0018*\u00020\n2\u0006\u0010+\u001a\u00020\nH\u0080\b\u001a\u001d\u0010,\u001a\u00020\n*\u00020\n2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0005H\u0080\b\u001a\r\u0010/\u001a\u00020\n*\u00020\nH\u0080\b\u001a\r\u00100\u001a\u00020\n*\u00020\nH\u0080\b\u001a\r\u00101\u001a\u00020\u0007*\u00020\nH\u0080\b\u001a\u001d\u00102\u001a\u00020\n*\u00020\u00072\u0006\u0010'\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0080\b\u001a\r\u00103\u001a\u00020\u0010*\u00020\nH\u0080\b\u001a\r\u00104\u001a\u00020\u0010*\u00020\nH\u0080\b\u001a$\u00105\u001a\u000206*\u00020\n2\u0006\u00107\u001a\u0002082\u0006\u0010'\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u00069"}, m23546d2 = {"HEX_DIGIT_CHARS", "", "getHEX_DIGIT_CHARS", "()[C", "codePointIndexToCharIndex", "", C3351bh.f11580aE, "", "codePointCount", "commonOf", "Lokio/ByteString;", "data", "decodeHexDigit", C3351bh.f11584aI, "", "commonBase64", "", "commonBase64Url", "commonCompareTo", DispatchConstants.OTHER, "commonDecodeBase64", "commonDecodeHex", "commonEncodeUtf8", "commonEndsWith", "", "suffix", "commonEquals", "", "commonGetByte", "", "pos", "commonGetSize", "commonHashCode", "commonHex", "commonIndexOf", "fromIndex", "commonInternalArray", "commonLastIndexOf", "commonRangeEquals", "offset", "otherOffset", "byteCount", "commonStartsWith", RequestParameters.PREFIX, "commonSubstring", "beginIndex", "endIndex", "commonToAsciiLowercase", "commonToAsciiUppercase", "commonToByteArray", "commonToByteString", "commonToString", "commonUtf8", "commonWrite", "", "buffer", "Lokio/Buffer;", "okio"}, m23547k = 2, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class ByteStringKt {

    @InterfaceC5816d
    private static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x0069, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x0072, code lost:
    
        r19 = r6;
        r6 = r5;
        r5 = r19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int codePointIndexToCharIndex(byte[] r20, int r21) {
        /*
            Method dump skipped, instructions count: 480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ByteStringKt.codePointIndexToCharIndex(byte[], int):int");
    }

    @InterfaceC5816d
    public static final String commonBase64(@InterfaceC5816d ByteString byteString) {
        C5544i0.m22546f(byteString, "$this$commonBase64");
        return Base64.encodeBase64$default(byteString.getData$okio(), null, 1, null);
    }

    @InterfaceC5816d
    public static final String commonBase64Url(@InterfaceC5816d ByteString byteString) {
        C5544i0.m22546f(byteString, "$this$commonBase64Url");
        return Base64.encodeBase64(byteString.getData$okio(), Base64.getBASE64_URL_SAFE());
    }

    public static final int commonCompareTo(@InterfaceC5816d ByteString byteString, @InterfaceC5816d ByteString byteString2) {
        C5544i0.m22546f(byteString, "$this$commonCompareTo");
        C5544i0.m22546f(byteString2, DispatchConstants.OTHER);
        int size = byteString.size();
        int size2 = byteString2.size();
        int min = Math.min(size, size2);
        for (int i2 = 0; i2 < min; i2++) {
            int i3 = byteString.getByte(i2) & C5230f1.f20085c;
            int i4 = byteString2.getByte(i2) & C5230f1.f20085c;
            if (i3 != i4) {
                return i3 < i4 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    @InterfaceC5817e
    public static final ByteString commonDecodeBase64(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "$this$commonDecodeBase64");
        byte[] decodeBase64ToArray = Base64.decodeBase64ToArray(str);
        if (decodeBase64ToArray != null) {
            return new ByteString(decodeBase64ToArray);
        }
        return null;
    }

    @InterfaceC5816d
    public static final ByteString commonDecodeHex(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "$this$commonDecodeHex");
        if (!(str.length() % 2 == 0)) {
            throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
        }
        byte[] bArr = new byte[str.length() / 2];
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) ((decodeHexDigit(str.charAt(i3)) << 4) + decodeHexDigit(str.charAt(i3 + 1)));
        }
        return new ByteString(bArr);
    }

    @InterfaceC5816d
    public static final ByteString commonEncodeUtf8(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "$this$commonEncodeUtf8");
        ByteString byteString = new ByteString(Platform.asUtf8ToByteArray(str));
        byteString.setUtf8$okio(str);
        return byteString;
    }

    public static final boolean commonEndsWith(@InterfaceC5816d ByteString byteString, @InterfaceC5816d ByteString byteString2) {
        C5544i0.m22546f(byteString, "$this$commonEndsWith");
        C5544i0.m22546f(byteString2, "suffix");
        return byteString.rangeEquals(byteString.size() - byteString2.size(), byteString2, 0, byteString2.size());
    }

    public static final boolean commonEquals(@InterfaceC5816d ByteString byteString, @InterfaceC5817e Object obj) {
        C5544i0.m22546f(byteString, "$this$commonEquals");
        if (obj == byteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString2 = (ByteString) obj;
            if (byteString2.size() == byteString.getData$okio().length && byteString2.rangeEquals(0, byteString.getData$okio(), 0, byteString.getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    public static final byte commonGetByte(@InterfaceC5816d ByteString byteString, int i2) {
        C5544i0.m22546f(byteString, "$this$commonGetByte");
        return byteString.getData$okio()[i2];
    }

    public static final int commonGetSize(@InterfaceC5816d ByteString byteString) {
        C5544i0.m22546f(byteString, "$this$commonGetSize");
        return byteString.getData$okio().length;
    }

    public static final int commonHashCode(@InterfaceC5816d ByteString byteString) {
        C5544i0.m22546f(byteString, "$this$commonHashCode");
        int hashCode$okio = byteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode = Arrays.hashCode(byteString.getData$okio());
        byteString.setHashCode$okio(hashCode);
        return hashCode;
    }

    @InterfaceC5816d
    public static final String commonHex(@InterfaceC5816d ByteString byteString) {
        C5544i0.m22546f(byteString, "$this$commonHex");
        char[] cArr = new char[byteString.getData$okio().length * 2];
        int i2 = 0;
        for (byte b2 : byteString.getData$okio()) {
            int i3 = i2 + 1;
            cArr[i2] = getHEX_DIGIT_CHARS()[(b2 >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = getHEX_DIGIT_CHARS()[b2 & C3393cw.f11873m];
        }
        return new String(cArr);
    }

    public static final int commonIndexOf(@InterfaceC5816d ByteString byteString, @InterfaceC5816d byte[] bArr, int i2) {
        C5544i0.m22546f(byteString, "$this$commonIndexOf");
        C5544i0.m22546f(bArr, DispatchConstants.OTHER);
        int length = byteString.getData$okio().length - bArr.length;
        int max = Math.max(i2, 0);
        if (max > length) {
            return -1;
        }
        while (!Util.arrayRangeEquals(byteString.getData$okio(), max, bArr, 0, bArr.length)) {
            if (max == length) {
                return -1;
            }
            max++;
        }
        return max;
    }

    @InterfaceC5816d
    public static final byte[] commonInternalArray(@InterfaceC5816d ByteString byteString) {
        C5544i0.m22546f(byteString, "$this$commonInternalArray");
        return byteString.getData$okio();
    }

    public static final int commonLastIndexOf(@InterfaceC5816d ByteString byteString, @InterfaceC5816d ByteString byteString2, int i2) {
        C5544i0.m22546f(byteString, "$this$commonLastIndexOf");
        C5544i0.m22546f(byteString2, DispatchConstants.OTHER);
        return byteString.lastIndexOf(byteString2.internalArray$okio(), i2);
    }

    @InterfaceC5816d
    public static final ByteString commonOf(@InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(bArr, "data");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        C5544i0.m22521a((Object) copyOf, "java.util.Arrays.copyOf(this, size)");
        return new ByteString(copyOf);
    }

    public static final boolean commonRangeEquals(@InterfaceC5816d ByteString byteString, int i2, @InterfaceC5816d ByteString byteString2, int i3, int i4) {
        C5544i0.m22546f(byteString, "$this$commonRangeEquals");
        C5544i0.m22546f(byteString2, DispatchConstants.OTHER);
        return byteString2.rangeEquals(i3, byteString.getData$okio(), i2, i4);
    }

    public static final boolean commonStartsWith(@InterfaceC5816d ByteString byteString, @InterfaceC5816d ByteString byteString2) {
        C5544i0.m22546f(byteString, "$this$commonStartsWith");
        C5544i0.m22546f(byteString2, RequestParameters.PREFIX);
        return byteString.rangeEquals(0, byteString2, 0, byteString2.size());
    }

    @InterfaceC5816d
    public static final ByteString commonSubstring(@InterfaceC5816d ByteString byteString, int i2, int i3) {
        C5544i0.m22546f(byteString, "$this$commonSubstring");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
        if (i3 <= byteString.getData$okio().length) {
            if (i3 - i2 >= 0) {
                return (i2 == 0 && i3 == byteString.getData$okio().length) ? byteString : new ByteString(C5291q.m20194a(byteString.getData$okio(), i2, i3));
            }
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
        throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + ')').toString());
    }

    @InterfaceC5816d
    public static final ByteString commonToAsciiLowercase(@InterfaceC5816d ByteString byteString) {
        byte b2;
        C5544i0.m22546f(byteString, "$this$commonToAsciiLowercase");
        for (int i2 = 0; i2 < byteString.getData$okio().length; i2++) {
            byte b3 = byteString.getData$okio()[i2];
            byte b4 = (byte) 65;
            if (b3 >= b4 && b3 <= (b2 = (byte) 90)) {
                byte[] data$okio = byteString.getData$okio();
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
        return byteString;
    }

    @InterfaceC5816d
    public static final ByteString commonToAsciiUppercase(@InterfaceC5816d ByteString byteString) {
        byte b2;
        C5544i0.m22546f(byteString, "$this$commonToAsciiUppercase");
        for (int i2 = 0; i2 < byteString.getData$okio().length; i2++) {
            byte b3 = byteString.getData$okio()[i2];
            byte b4 = (byte) 97;
            if (b3 >= b4 && b3 <= (b2 = (byte) 122)) {
                byte[] data$okio = byteString.getData$okio();
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
        return byteString;
    }

    @InterfaceC5816d
    public static final byte[] commonToByteArray(@InterfaceC5816d ByteString byteString) {
        C5544i0.m22546f(byteString, "$this$commonToByteArray");
        byte[] data$okio = byteString.getData$okio();
        byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
        C5544i0.m22521a((Object) copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @InterfaceC5816d
    public static final ByteString commonToByteString(@InterfaceC5816d byte[] bArr, int i2, int i3) {
        C5544i0.m22546f(bArr, "$this$commonToByteString");
        Util.checkOffsetAndCount(bArr.length, i2, i3);
        return new ByteString(C5291q.m20194a(bArr, i2, i3 + i2));
    }

    @InterfaceC5816d
    public static final String commonToString(@InterfaceC5816d ByteString byteString) {
        String m23580a;
        String m23580a2;
        String m23580a3;
        ByteString byteString2 = byteString;
        C5544i0.m22546f(byteString2, "$this$commonToString");
        if (byteString.getData$okio().length == 0) {
            return "[size=0]";
        }
        int codePointIndexToCharIndex = codePointIndexToCharIndex(byteString.getData$okio(), 64);
        if (codePointIndexToCharIndex == -1) {
            if (byteString.getData$okio().length <= 64) {
                return "[hex=" + byteString.hex() + ']';
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[size=");
            sb.append(byteString.getData$okio().length);
            sb.append(" hex=");
            if (64 <= byteString.getData$okio().length) {
                if (64 != byteString.getData$okio().length) {
                    byteString2 = new ByteString(C5291q.m20194a(byteString.getData$okio(), 0, 64));
                }
                sb.append(byteString2.hex());
                sb.append("…]");
                return sb.toString();
            }
            throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + ')').toString());
        }
        String utf8 = byteString.utf8();
        if (utf8 == null) {
            throw new C5226e1("null cannot be cast to non-null type java.lang.String");
        }
        String substring = utf8.substring(0, codePointIndexToCharIndex);
        C5544i0.m22521a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        m23580a = C5724b0.m23580a(substring, "\\", "\\\\", false, 4, (Object) null);
        m23580a2 = C5724b0.m23580a(m23580a, "\n", "\\n", false, 4, (Object) null);
        m23580a3 = C5724b0.m23580a(m23580a2, "\r", "\\r", false, 4, (Object) null);
        if (codePointIndexToCharIndex >= utf8.length()) {
            return "[text=" + m23580a3 + ']';
        }
        return "[size=" + byteString.getData$okio().length + " text=" + m23580a3 + "…]";
    }

    @InterfaceC5816d
    public static final String commonUtf8(@InterfaceC5816d ByteString byteString) {
        C5544i0.m22546f(byteString, "$this$commonUtf8");
        String utf8$okio = byteString.getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        String utf8String = Platform.toUtf8String(byteString.internalArray$okio());
        byteString.setUtf8$okio(utf8String);
        return utf8String;
    }

    public static final void commonWrite(@InterfaceC5816d ByteString byteString, @InterfaceC5816d Buffer buffer, int i2, int i3) {
        C5544i0.m22546f(byteString, "$this$commonWrite");
        C5544i0.m22546f(buffer, "buffer");
        buffer.write(byteString.getData$okio(), i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int decodeHexDigit(char c2) {
        if ('0' <= c2 && '9' >= c2) {
            return c2 - '0';
        }
        char c3 = 'a';
        if ('a' > c2 || 'f' < c2) {
            c3 = 'A';
            if ('A' > c2 || 'F' < c2) {
                throw new IllegalArgumentException("Unexpected hex digit: " + c2);
            }
        }
        return (c2 - c3) + 10;
    }

    @InterfaceC5816d
    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }

    public static final boolean commonEndsWith(@InterfaceC5816d ByteString byteString, @InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(byteString, "$this$commonEndsWith");
        C5544i0.m22546f(bArr, "suffix");
        return byteString.rangeEquals(byteString.size() - bArr.length, bArr, 0, bArr.length);
    }

    public static final int commonLastIndexOf(@InterfaceC5816d ByteString byteString, @InterfaceC5816d byte[] bArr, int i2) {
        C5544i0.m22546f(byteString, "$this$commonLastIndexOf");
        C5544i0.m22546f(bArr, DispatchConstants.OTHER);
        for (int min = Math.min(i2, byteString.getData$okio().length - bArr.length); min >= 0; min--) {
            if (Util.arrayRangeEquals(byteString.getData$okio(), min, bArr, 0, bArr.length)) {
                return min;
            }
        }
        return -1;
    }

    public static final boolean commonRangeEquals(@InterfaceC5816d ByteString byteString, int i2, @InterfaceC5816d byte[] bArr, int i3, int i4) {
        C5544i0.m22546f(byteString, "$this$commonRangeEquals");
        C5544i0.m22546f(bArr, DispatchConstants.OTHER);
        return i2 >= 0 && i2 <= byteString.getData$okio().length - i4 && i3 >= 0 && i3 <= bArr.length - i4 && Util.arrayRangeEquals(byteString.getData$okio(), i2, bArr, i3, i4);
    }

    public static final boolean commonStartsWith(@InterfaceC5816d ByteString byteString, @InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(byteString, "$this$commonStartsWith");
        C5544i0.m22546f(bArr, RequestParameters.PREFIX);
        return byteString.rangeEquals(0, bArr, 0, bArr.length);
    }
}
