package p286h.p323z2;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import p286h.C5226e1;
import p286h.InterfaceC5339j;
import p286h.InterfaceC5610t0;
import p286h.p289g2.AbstractC5252d;
import p286h.p289g2.AbstractC5304u0;
import p286h.p289g2.C5291q;
import p286h.p304m2.InterfaceC5426f;
import p286h.p304m2.InterfaceC5427g;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5557m1;
import p286h.p321x2.C5707u;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: StringsJVM.kt */
/* renamed from: h.z2.b0 */
/* loaded from: classes2.dex */
public class C5724b0 extends C5722a0 {
    @InterfaceC5426f
    /* renamed from: a */
    private static final int m23569a(@InterfaceC5816d String str, char c2, int i2) {
        if (str != null) {
            return str.indexOf(c2, i2);
        }
        throw new C5226e1("null cannot be cast to non-null type java.lang.String");
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final int m23615b(@InterfaceC5816d String str, char c2, int i2) {
        if (str != null) {
            return str.lastIndexOf(c2, i2);
        }
        throw new C5226e1("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: c */
    public static /* synthetic */ boolean m23632c(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return m23631c(str, str2, z);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    @InterfaceC5816d
    /* renamed from: d */
    public static final char[] m23636d(@InterfaceC5816d String str, int i2, int i3) {
        C5544i0.m22546f(str, "$this$toCharArray");
        AbstractC5252d.Companion.m19652a(i2, i3, str.length());
        char[] cArr = new char[i3 - i2];
        str.getChars(i2, i3, cArr, 0);
        return cArr;
    }

    @InterfaceC5426f
    /* renamed from: f */
    private static final int m23637f(@InterfaceC5816d String str, int i2) {
        if (str != null) {
            return str.codePointAt(i2);
        }
        throw new C5226e1("null cannot be cast to non-null type java.lang.String");
    }

    @InterfaceC5426f
    /* renamed from: g */
    private static final int m23638g(@InterfaceC5816d String str, int i2) {
        if (str != null) {
            return str.codePointBefore(i2);
        }
        throw new C5226e1("null cannot be cast to non-null type java.lang.String");
    }

    @InterfaceC5426f
    /* renamed from: h */
    private static final String m23639h(@InterfaceC5816d String str, int i2) {
        if (str == null) {
            throw new C5226e1("null cannot be cast to non-null type java.lang.String");
        }
        String substring = str.substring(i2);
        C5544i0.m22521a((Object) substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }

    @InterfaceC5426f
    /* renamed from: i */
    private static final Pattern m23640i(@InterfaceC5816d String str, int i2) {
        Pattern compile = Pattern.compile(str, i2);
        C5544i0.m22521a((Object) compile, "java.util.regex.Pattern.compile(this, flags)");
        return compile;
    }

    @InterfaceC5816d
    /* renamed from: j */
    public static final String m23641j(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "$this$capitalize");
        if (!(str.length() > 0) || !Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(0, 1);
        C5544i0.m22521a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (substring == null) {
            throw new C5226e1("null cannot be cast to non-null type java.lang.String");
        }
        String upperCase = substring.toUpperCase();
        C5544i0.m22521a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
        sb.append(upperCase);
        String substring2 = str.substring(1);
        C5544i0.m22521a((Object) substring2, "(this as java.lang.String).substring(startIndex)");
        sb.append(substring2);
        return sb.toString();
    }

    @InterfaceC5816d
    /* renamed from: l */
    public static final String m23642l(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "$this$decapitalize");
        if (!(str.length() > 0) || !Character.isUpperCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(0, 1);
        C5544i0.m22521a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (substring == null) {
            throw new C5226e1("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = substring.toLowerCase();
        C5544i0.m22521a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
        sb.append(lowerCase);
        String substring2 = str.substring(1);
        C5544i0.m22521a((Object) substring2, "(this as java.lang.String).substring(startIndex)");
        sb.append(substring2);
        return sb.toString();
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    @InterfaceC5816d
    /* renamed from: m */
    public static final byte[] m23643m(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "$this$encodeToByteArray");
        byte[] bytes = str.getBytes(C5731f.f20676a);
        C5544i0.m22521a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    @InterfaceC5426f
    /* renamed from: n */
    private static final String m23644n(@InterfaceC5816d String str) {
        if (str == null) {
            throw new C5226e1("null cannot be cast to non-null type java.lang.String");
        }
        String intern = str.intern();
        C5544i0.m22521a((Object) intern, "(this as java.lang.String).intern()");
        return intern;
    }

    @InterfaceC5426f
    /* renamed from: o */
    private static final char[] m23645o(@InterfaceC5816d String str) {
        if (str == null) {
            throw new C5226e1("null cannot be cast to non-null type java.lang.String");
        }
        char[] charArray = str.toCharArray();
        C5544i0.m22521a((Object) charArray, "(this as java.lang.String).toCharArray()");
        return charArray;
    }

    @InterfaceC5426f
    /* renamed from: p */
    private static final String m23646p(@InterfaceC5816d String str) {
        if (str == null) {
            throw new C5226e1("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase();
        C5544i0.m22521a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
        return lowerCase;
    }

    @InterfaceC5426f
    /* renamed from: q */
    private static final String m23647q(@InterfaceC5816d String str) {
        if (str == null) {
            throw new C5226e1("null cannot be cast to non-null type java.lang.String");
        }
        String upperCase = str.toUpperCase();
        C5544i0.m22521a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
        return upperCase;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final int m23571a(@InterfaceC5816d String str, String str2, int i2) {
        if (str != null) {
            return str.indexOf(str2, i2);
        }
        throw new C5226e1("null cannot be cast to non-null type java.lang.String");
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final int m23617b(@InterfaceC5816d String str, String str2, int i2) {
        if (str != null) {
            return str.lastIndexOf(str2, i2);
        }
        throw new C5226e1("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: c */
    public static boolean m23631c(@InterfaceC5817e String str, @InterfaceC5817e String str2, boolean z) {
        return str == null ? str2 == null : !z ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    /* renamed from: a */
    public static /* synthetic */ String m23578a(String str, char c2, char c3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m23577a(str, c2, c3, z);
    }

    /* renamed from: b */
    public static /* synthetic */ String m23619b(String str, char c2, char c3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m23618b(str, c2, c3, z);
    }

    /* renamed from: d */
    public static /* synthetic */ boolean m23635d(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return m23634d(str, str2, z);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final String m23577a(@InterfaceC5816d String str, char c2, char c3, boolean z) {
        String m23414a;
        C5544i0.m22546f(str, "$this$replace");
        if (!z) {
            String replace = str.replace(c2, c3);
            C5544i0.m22521a((Object) replace, "(this as java.lang.Strin…replace(oldChar, newChar)");
            return replace;
        }
        m23414a = C5707u.m23414a(C5726c0.m23719b(str, new char[]{c2}, z, 0, 4, (Object) null), String.valueOf(c3), null, null, 0, null, null, 62, null);
        return m23414a;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final String m23618b(@InterfaceC5816d String str, char c2, char c3, boolean z) {
        C5544i0.m22546f(str, "$this$replaceFirst");
        int m23650a = C5726c0.m23650a((CharSequence) str, c2, 0, z, 2, (Object) null);
        return m23650a < 0 ? str : C5726c0.m23667a((CharSequence) str, m23650a, m23650a + 1, (CharSequence) String.valueOf(c3)).toString();
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final String m23628c(@InterfaceC5816d String str, int i2, int i3) {
        if (str == null) {
            throw new C5226e1("null cannot be cast to non-null type java.lang.String");
        }
        String substring = str.substring(i2, i3);
        C5544i0.m22521a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: d */
    public static final boolean m23634d(@InterfaceC5816d String str, @InterfaceC5816d String str2, boolean z) {
        C5544i0.m22546f(str, "$this$startsWith");
        C5544i0.m22546f(str2, RequestParameters.PREFIX);
        if (!z) {
            return str.startsWith(str2);
        }
        return m23602a(str, 0, str2, 0, str2.length(), z);
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final String m23630c(StringBuilder sb) {
        return new String(sb);
    }

    /* renamed from: a */
    public static /* synthetic */ String m23580a(String str, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m23579a(str, str2, str3, z);
    }

    /* renamed from: b */
    public static /* synthetic */ String m23621b(String str, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m23620b(str, str2, str3, z);
    }

    @InterfaceC5426f
    /* renamed from: c */
    private static final String m23629c(@InterfaceC5816d String str, Locale locale) {
        if (str == null) {
            throw new C5226e1("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase(locale);
        C5544i0.m22521a((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    @InterfaceC5426f
    /* renamed from: d */
    private static final String m23633d(@InterfaceC5816d String str, Locale locale) {
        if (str == null) {
            throw new C5226e1("null cannot be cast to non-null type java.lang.String");
        }
        String upperCase = str.toUpperCase(locale);
        C5544i0.m22521a((Object) upperCase, "(this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final String m23579a(@InterfaceC5816d String str, @InterfaceC5816d String str2, @InterfaceC5816d String str3, boolean z) {
        String m23414a;
        C5544i0.m22546f(str, "$this$replace");
        C5544i0.m22546f(str2, "oldValue");
        C5544i0.m22546f(str3, "newValue");
        m23414a = C5707u.m23414a(C5726c0.m23721b(str, new String[]{str2}, z, 0, 4, (Object) null), str3, null, null, 0, null, null, 62, null);
        return m23414a;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final String m23620b(@InterfaceC5816d String str, @InterfaceC5816d String str2, @InterfaceC5816d String str3, boolean z) {
        C5544i0.m22546f(str, "$this$replaceFirst");
        C5544i0.m22546f(str2, "oldValue");
        C5544i0.m22546f(str3, "newValue");
        int m23654a = C5726c0.m23654a((CharSequence) str, str2, 0, z, 2, (Object) null);
        return m23654a < 0 ? str : C5726c0.m23667a((CharSequence) str, m23654a, str2.length() + m23654a, (CharSequence) str3).toString();
    }

    /* renamed from: a */
    public static /* synthetic */ String m23593a(char[] cArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = cArr.length;
        }
        return m23625b(cArr, i2, i3);
    }

    /* renamed from: a */
    public static /* synthetic */ char[] m23612a(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return m23636d(str, i2, i3);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    @InterfaceC5816d
    /* renamed from: b */
    public static final String m23624b(@InterfaceC5816d char[] cArr) {
        C5544i0.m22546f(cArr, "$this$concatToString");
        return new String(cArr);
    }

    /* renamed from: a */
    public static /* synthetic */ String m23589a(byte[] bArr, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = bArr.length;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return m23588a(bArr, i2, i3, z);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    @InterfaceC5816d
    /* renamed from: b */
    public static final String m23625b(@InterfaceC5816d char[] cArr, int i2, int i3) {
        C5544i0.m22546f(cArr, "$this$concatToString");
        AbstractC5252d.Companion.m19652a(i2, i3, cArr.length);
        return new String(cArr, i2, i3 - i2);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    @InterfaceC5816d
    /* renamed from: a */
    public static final String m23588a(@InterfaceC5816d byte[] bArr, int i2, int i3, boolean z) {
        C5544i0.m22546f(bArr, "$this$decodeToString");
        AbstractC5252d.Companion.m19652a(i2, i3, bArr.length);
        if (!z) {
            return new String(bArr, i2, i3 - i2, C5731f.f20676a);
        }
        String charBuffer = C5731f.f20676a.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(bArr, i2, i3 - i2)).toString();
        C5544i0.m22521a((Object) charBuffer, "decoder.decode(ByteBuffe…- startIndex)).toString()");
        return charBuffer;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    @InterfaceC5816d
    /* renamed from: b */
    public static final String m23623b(@InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(bArr, "$this$decodeToString");
        return new String(bArr, C5731f.f20676a);
    }

    /* renamed from: b */
    public static /* synthetic */ boolean m23627b(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return m23626b(str, str2, z);
    }

    /* renamed from: b */
    public static final boolean m23626b(@InterfaceC5816d String str, @InterfaceC5816d String str2, boolean z) {
        C5544i0.m22546f(str, "$this$endsWith");
        C5544i0.m22546f(str2, "suffix");
        if (!z) {
            return str.endsWith(str2);
        }
        return m23602a(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    @InterfaceC5426f
    /* renamed from: b */
    private static final int m23616b(@InterfaceC5816d String str, int i2, int i3) {
        if (str != null) {
            return str.offsetByCodePoints(i2, i3);
        }
        throw new C5226e1("null cannot be cast to non-null type java.lang.String");
    }

    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5427g
    @InterfaceC5816d
    /* renamed from: b */
    public static final String m23622b(@InterfaceC5816d String str, @InterfaceC5816d Locale locale) {
        C5544i0.m22546f(str, "$this$decapitalize");
        C5544i0.m22546f(locale, "locale");
        if (!(str.length() > 0) || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(0, 1);
        C5544i0.m22521a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (substring == null) {
            throw new C5226e1("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = substring.toLowerCase(locale);
        C5544i0.m22521a((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        sb.append(lowerCase);
        String substring2 = str.substring(1);
        C5544i0.m22521a((Object) substring2, "(this as java.lang.String).substring(startIndex)");
        sb.append(substring2);
        return sb.toString();
    }

    /* renamed from: a */
    public static /* synthetic */ byte[] m23609a(String str, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return m23608a(str, i2, i3, z);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    @InterfaceC5816d
    /* renamed from: a */
    public static final byte[] m23608a(@InterfaceC5816d String str, int i2, int i3, boolean z) {
        C5544i0.m22546f(str, "$this$encodeToByteArray");
        AbstractC5252d.Companion.m19652a(i2, i3, str.length());
        if (!z) {
            String substring = str.substring(i2, i3);
            C5544i0.m22521a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            Charset charset = C5731f.f20676a;
            if (substring == null) {
                throw new C5226e1("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = substring.getBytes(charset);
            C5544i0.m22521a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            return bytes;
        }
        ByteBuffer encode = C5731f.f20676a.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).encode(CharBuffer.wrap(str, i2, i3));
        if (encode.hasArray() && encode.arrayOffset() == 0) {
            int remaining = encode.remaining();
            byte[] array = encode.array();
            if (array == null) {
                C5544i0.m22545f();
            }
            if (remaining == array.length) {
                byte[] array2 = encode.array();
                C5544i0.m22521a((Object) array2, "byteBuffer.array()");
                return array2;
            }
        }
        byte[] bArr = new byte[encode.remaining()];
        encode.get(bArr);
        return bArr;
    }

    /* renamed from: a */
    static /* synthetic */ char[] m23614a(String str, char[] cArr, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = str.length();
        }
        if (str == null) {
            throw new C5226e1("null cannot be cast to non-null type java.lang.String");
        }
        str.getChars(i3, i4, cArr, i2);
        return cArr;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final char[] m23613a(@InterfaceC5816d String str, char[] cArr, int i2, int i3, int i4) {
        if (str == null) {
            throw new C5226e1("null cannot be cast to non-null type java.lang.String");
        }
        str.getChars(i3, i4, cArr, i2);
        return cArr;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final String m23583a(@InterfaceC5816d String str, Object... objArr) {
        String format = String.format(str, Arrays.copyOf(objArr, objArr.length));
        C5544i0.m22521a((Object) format, "java.lang.String.format(this, *args)");
        return format;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final String m23574a(@InterfaceC5816d C5557m1 c5557m1, String str, Object... objArr) {
        String format = String.format(str, Arrays.copyOf(objArr, objArr.length));
        C5544i0.m22521a((Object) format, "java.lang.String.format(format, *args)");
        return format;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final String m23582a(@InterfaceC5816d String str, Locale locale, Object... objArr) {
        String format = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        C5544i0.m22521a((Object) format, "java.lang.String.format(locale, this, *args)");
        return format;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final String m23575a(@InterfaceC5816d C5557m1 c5557m1, Locale locale, String str, Object... objArr) {
        String format = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        C5544i0.m22521a((Object) format, "java.lang.String.format(locale, format, *args)");
        return format;
    }

    /* renamed from: a */
    public static /* synthetic */ List m23597a(CharSequence charSequence, Pattern pattern, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return m23596a(charSequence, pattern, i2);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final List<String> m23596a(@InterfaceC5816d CharSequence charSequence, @InterfaceC5816d Pattern pattern, int i2) {
        C5544i0.m22546f(charSequence, "$this$split");
        C5544i0.m22546f(pattern, "regex");
        if (i2 >= 0) {
            if (i2 == 0) {
                i2 = -1;
            }
            String[] split = pattern.split(charSequence, i2);
            C5544i0.m22521a((Object) split, "regex.split(this, if (limit == 0) -1 else limit)");
            return C5291q.m20317d((Object[]) split);
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    /* renamed from: a */
    public static /* synthetic */ boolean m23606a(String str, String str2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = false;
        }
        return m23605a(str, str2, i2, z);
    }

    /* renamed from: a */
    public static final boolean m23605a(@InterfaceC5816d String str, @InterfaceC5816d String str2, int i2, boolean z) {
        C5544i0.m22546f(str, "$this$startsWith");
        C5544i0.m22546f(str2, RequestParameters.PREFIX);
        if (!z) {
            return str.startsWith(str2, i2);
        }
        return m23602a(str, i2, str2, 0, str2.length(), z);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final String m23587a(byte[] bArr, int i2, int i3, Charset charset) {
        return new String(bArr, i2, i3, charset);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final String m23590a(byte[] bArr, Charset charset) {
        return new String(bArr, charset);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final String m23586a(byte[] bArr, int i2, int i3) {
        return new String(bArr, i2, i3, C5731f.f20676a);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final String m23585a(byte[] bArr) {
        return new String(bArr, C5731f.f20676a);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final String m23591a(char[] cArr) {
        return new String(cArr);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final String m23592a(char[] cArr, int i2, int i3) {
        return new String(cArr, i2, i3);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final String m23594a(int[] iArr, int i2, int i3) {
        return new String(iArr, i2, i3);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final String m23584a(StringBuffer stringBuffer) {
        return new String(stringBuffer);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final int m23570a(@InterfaceC5816d String str, int i2, int i3) {
        if (str != null) {
            return str.codePointCount(i2, i3);
        }
        throw new C5226e1("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: a */
    public static /* synthetic */ int m23573a(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return m23572a(str, str2, z);
    }

    /* renamed from: a */
    public static final int m23572a(@InterfaceC5816d String str, @InterfaceC5816d String str2, boolean z) {
        C5544i0.m22546f(str, "$this$compareTo");
        C5544i0.m22546f(str2, DispatchConstants.OTHER);
        if (z) {
            return str.compareToIgnoreCase(str2);
        }
        return str.compareTo(str2);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final boolean m23604a(@InterfaceC5816d String str, CharSequence charSequence) {
        if (str != null) {
            return str.contentEquals(charSequence);
        }
        throw new C5226e1("null cannot be cast to non-null type java.lang.String");
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final boolean m23607a(@InterfaceC5816d String str, StringBuffer stringBuffer) {
        if (str != null) {
            return str.contentEquals(stringBuffer);
        }
        throw new C5226e1("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: a */
    public static final boolean m23599a(@InterfaceC5816d CharSequence charSequence) {
        boolean z;
        C5544i0.m22546f(charSequence, "$this$isBlank");
        if (charSequence.length() != 0) {
            Iterable m23717b = C5726c0.m23717b(charSequence);
            if (!(m23717b instanceof Collection) || !((Collection) m23717b).isEmpty()) {
                Iterator it = m23717b.iterator();
                while (it.hasNext()) {
                    if (!C5727d.m23823p(charSequence.charAt(((AbstractC5304u0) it).nextInt()))) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static final boolean m23600a(@InterfaceC5816d CharSequence charSequence, int i2, @InterfaceC5816d CharSequence charSequence2, int i3, int i4, boolean z) {
        C5544i0.m22546f(charSequence, "$this$regionMatches");
        C5544i0.m22546f(charSequence2, DispatchConstants.OTHER);
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return m23602a((String) charSequence, i2, (String) charSequence2, i3, i4, z);
        }
        return C5726c0.m23751b(charSequence, i2, charSequence2, i3, i4, z);
    }

    /* renamed from: a */
    public static final boolean m23602a(@InterfaceC5816d String str, int i2, @InterfaceC5816d String str2, int i3, int i4, boolean z) {
        C5544i0.m22546f(str, "$this$regionMatches");
        C5544i0.m22546f(str2, DispatchConstants.OTHER);
        if (!z) {
            return str.regionMatches(i2, str2, i3, i4);
        }
        return str.regionMatches(z, i2, str2, i3, i4);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final byte[] m23610a(@InterfaceC5816d String str, Charset charset) {
        if (str == null) {
            throw new C5226e1("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str.getBytes(charset);
        C5544i0.m22521a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    /* renamed from: a */
    static /* synthetic */ byte[] m23611a(String str, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = C5731f.f20676a;
        }
        if (str == null) {
            throw new C5226e1("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str.getBytes(charset);
        C5544i0.m22521a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    @InterfaceC5339j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5427g
    @InterfaceC5816d
    /* renamed from: a */
    public static final String m23581a(@InterfaceC5816d String str, @InterfaceC5816d Locale locale) {
        C5544i0.m22546f(str, "$this$capitalize");
        C5544i0.m22546f(locale, "locale");
        if (str.length() > 0) {
            char charAt = str.charAt(0);
            if (Character.isLowerCase(charAt)) {
                StringBuilder sb = new StringBuilder();
                char titleCase = Character.toTitleCase(charAt);
                if (titleCase != Character.toUpperCase(charAt)) {
                    sb.append(titleCase);
                } else {
                    String substring = str.substring(0, 1);
                    C5544i0.m22521a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (substring == null) {
                        throw new C5226e1("null cannot be cast to non-null type java.lang.String");
                    }
                    String upperCase = substring.toUpperCase(locale);
                    C5544i0.m22521a((Object) upperCase, "(this as java.lang.String).toUpperCase(locale)");
                    sb.append(upperCase);
                }
                String substring2 = str.substring(1);
                C5544i0.m22521a((Object) substring2, "(this as java.lang.String).substring(startIndex)");
                sb.append(substring2);
                String sb2 = sb.toString();
                C5544i0.m22521a((Object) sb2, "StringBuilder().apply(builderAction).toString()");
                return sb2;
            }
        }
        return str;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final String m23576a(@InterfaceC5816d CharSequence charSequence, int i2) {
        C5544i0.m22546f(charSequence, "$this$repeat");
        int i3 = 1;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i2 + '.').toString());
        }
        if (i2 == 0) {
            return "";
        }
        if (i2 != 1) {
            int length = charSequence.length();
            if (length == 0) {
                return "";
            }
            if (length != 1) {
                StringBuilder sb = new StringBuilder(charSequence.length() * i2);
                if (1 <= i2) {
                    while (true) {
                        sb.append(charSequence);
                        if (i3 == i2) {
                            break;
                        }
                        i3++;
                    }
                }
                String sb2 = sb.toString();
                C5544i0.m22521a((Object) sb2, "sb.toString()");
                return sb2;
            }
            char charAt = charSequence.charAt(0);
            char[] cArr = new char[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                cArr[i4] = charAt;
            }
            return new String(cArr);
        }
        return charSequence.toString();
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final Comparator<String> m23595a(@InterfaceC5816d C5557m1 c5557m1) {
        C5544i0.m22546f(c5557m1, "$this$CASE_INSENSITIVE_ORDER");
        Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;
        C5544i0.m22521a((Object) comparator, "java.lang.String.CASE_INSENSITIVE_ORDER");
        return comparator;
    }

    /* renamed from: a */
    static /* synthetic */ Pattern m23598a(String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        Pattern compile = Pattern.compile(str, i2);
        C5544i0.m22521a((Object) compile, "java.util.regex.Pattern.compile(this, flags)");
        return compile;
    }
}
