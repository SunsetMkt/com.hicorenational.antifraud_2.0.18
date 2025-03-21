package h.z2;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import h.e1;
import h.g2.u0;
import h.q2.t.m1;
import h.t0;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StringsJVM.kt */
/* loaded from: classes2.dex */
public class b0 extends a0 {
    @h.m2.f
    private static final int a(@i.c.a.d String str, char c2, int i2) {
        if (str != null) {
            return str.indexOf(c2, i2);
        }
        throw new e1("null cannot be cast to non-null type java.lang.String");
    }

    @h.m2.f
    private static final int b(@i.c.a.d String str, char c2, int i2) {
        if (str != null) {
            return str.lastIndexOf(c2, i2);
        }
        throw new e1("null cannot be cast to non-null type java.lang.String");
    }

    public static /* synthetic */ boolean c(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return c(str, str2, z);
    }

    @t0(version = "1.3")
    @h.j
    @i.c.a.d
    public static final char[] d(@i.c.a.d String str, int i2, int i3) {
        h.q2.t.i0.f(str, "$this$toCharArray");
        h.g2.d.Companion.a(i2, i3, str.length());
        char[] cArr = new char[i3 - i2];
        str.getChars(i2, i3, cArr, 0);
        return cArr;
    }

    @h.m2.f
    private static final int f(@i.c.a.d String str, int i2) {
        if (str != null) {
            return str.codePointAt(i2);
        }
        throw new e1("null cannot be cast to non-null type java.lang.String");
    }

    @h.m2.f
    private static final int g(@i.c.a.d String str, int i2) {
        if (str != null) {
            return str.codePointBefore(i2);
        }
        throw new e1("null cannot be cast to non-null type java.lang.String");
    }

    @h.m2.f
    private static final String h(@i.c.a.d String str, int i2) {
        if (str == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        String substring = str.substring(i2);
        h.q2.t.i0.a((Object) substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }

    @h.m2.f
    private static final Pattern i(@i.c.a.d String str, int i2) {
        Pattern compile = Pattern.compile(str, i2);
        h.q2.t.i0.a((Object) compile, "java.util.regex.Pattern.compile(this, flags)");
        return compile;
    }

    @i.c.a.d
    public static final String j(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "$this$capitalize");
        if (!(str.length() > 0) || !Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(0, 1);
        h.q2.t.i0.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (substring == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        String upperCase = substring.toUpperCase();
        h.q2.t.i0.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
        sb.append(upperCase);
        String substring2 = str.substring(1);
        h.q2.t.i0.a((Object) substring2, "(this as java.lang.String).substring(startIndex)");
        sb.append(substring2);
        return sb.toString();
    }

    @i.c.a.d
    public static final String l(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "$this$decapitalize");
        if (!(str.length() > 0) || !Character.isUpperCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(0, 1);
        h.q2.t.i0.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (substring == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = substring.toLowerCase();
        h.q2.t.i0.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
        sb.append(lowerCase);
        String substring2 = str.substring(1);
        h.q2.t.i0.a((Object) substring2, "(this as java.lang.String).substring(startIndex)");
        sb.append(substring2);
        return sb.toString();
    }

    @t0(version = "1.3")
    @h.j
    @i.c.a.d
    public static final byte[] m(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "$this$encodeToByteArray");
        byte[] bytes = str.getBytes(f.f16682a);
        h.q2.t.i0.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    @h.m2.f
    private static final String n(@i.c.a.d String str) {
        if (str == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        String intern = str.intern();
        h.q2.t.i0.a((Object) intern, "(this as java.lang.String).intern()");
        return intern;
    }

    @h.m2.f
    private static final char[] o(@i.c.a.d String str) {
        if (str == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        char[] charArray = str.toCharArray();
        h.q2.t.i0.a((Object) charArray, "(this as java.lang.String).toCharArray()");
        return charArray;
    }

    @h.m2.f
    private static final String p(@i.c.a.d String str) {
        if (str == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase();
        h.q2.t.i0.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
        return lowerCase;
    }

    @h.m2.f
    private static final String q(@i.c.a.d String str) {
        if (str == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        String upperCase = str.toUpperCase();
        h.q2.t.i0.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
        return upperCase;
    }

    @h.m2.f
    private static final int a(@i.c.a.d String str, String str2, int i2) {
        if (str != null) {
            return str.indexOf(str2, i2);
        }
        throw new e1("null cannot be cast to non-null type java.lang.String");
    }

    @h.m2.f
    private static final int b(@i.c.a.d String str, String str2, int i2) {
        if (str != null) {
            return str.lastIndexOf(str2, i2);
        }
        throw new e1("null cannot be cast to non-null type java.lang.String");
    }

    public static boolean c(@i.c.a.e String str, @i.c.a.e String str2, boolean z) {
        return str == null ? str2 == null : !z ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static /* synthetic */ String a(String str, char c2, char c3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return a(str, c2, c3, z);
    }

    public static /* synthetic */ String b(String str, char c2, char c3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return b(str, c2, c3, z);
    }

    public static /* synthetic */ boolean d(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return d(str, str2, z);
    }

    @i.c.a.d
    public static final String a(@i.c.a.d String str, char c2, char c3, boolean z) {
        h.q2.t.i0.f(str, "$this$replace");
        if (!z) {
            String replace = str.replace(c2, c3);
            h.q2.t.i0.a((Object) replace, "(this as java.lang.Strin…replace(oldChar, newChar)");
            return replace;
        }
        return h.x2.u.a(c0.b(str, new char[]{c2}, z, 0, 4, (Object) null), String.valueOf(c3), null, null, 0, null, null, 62, null);
    }

    @i.c.a.d
    public static final String b(@i.c.a.d String str, char c2, char c3, boolean z) {
        h.q2.t.i0.f(str, "$this$replaceFirst");
        int a2 = c0.a((CharSequence) str, c2, 0, z, 2, (Object) null);
        return a2 < 0 ? str : c0.a((CharSequence) str, a2, a2 + 1, (CharSequence) String.valueOf(c3)).toString();
    }

    @h.m2.f
    private static final String c(@i.c.a.d String str, int i2, int i3) {
        if (str == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        String substring = str.substring(i2, i3);
        h.q2.t.i0.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean d(@i.c.a.d String str, @i.c.a.d String str2, boolean z) {
        h.q2.t.i0.f(str, "$this$startsWith");
        h.q2.t.i0.f(str2, RequestParameters.PREFIX);
        if (!z) {
            return str.startsWith(str2);
        }
        return a(str, 0, str2, 0, str2.length(), z);
    }

    @h.m2.f
    private static final String c(StringBuilder sb) {
        return new String(sb);
    }

    public static /* synthetic */ String a(String str, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return a(str, str2, str3, z);
    }

    public static /* synthetic */ String b(String str, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return b(str, str2, str3, z);
    }

    @h.m2.f
    private static final String c(@i.c.a.d String str, Locale locale) {
        if (str == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase(locale);
        h.q2.t.i0.a((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    @h.m2.f
    private static final String d(@i.c.a.d String str, Locale locale) {
        if (str == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        String upperCase = str.toUpperCase(locale);
        h.q2.t.i0.a((Object) upperCase, "(this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }

    @i.c.a.d
    public static final String a(@i.c.a.d String str, @i.c.a.d String str2, @i.c.a.d String str3, boolean z) {
        h.q2.t.i0.f(str, "$this$replace");
        h.q2.t.i0.f(str2, "oldValue");
        h.q2.t.i0.f(str3, "newValue");
        return h.x2.u.a(c0.b(str, new String[]{str2}, z, 0, 4, (Object) null), str3, null, null, 0, null, null, 62, null);
    }

    @i.c.a.d
    public static final String b(@i.c.a.d String str, @i.c.a.d String str2, @i.c.a.d String str3, boolean z) {
        h.q2.t.i0.f(str, "$this$replaceFirst");
        h.q2.t.i0.f(str2, "oldValue");
        h.q2.t.i0.f(str3, "newValue");
        int a2 = c0.a((CharSequence) str, str2, 0, z, 2, (Object) null);
        return a2 < 0 ? str : c0.a((CharSequence) str, a2, str2.length() + a2, (CharSequence) str3).toString();
    }

    public static /* synthetic */ String a(char[] cArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = cArr.length;
        }
        return b(cArr, i2, i3);
    }

    public static /* synthetic */ char[] a(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return d(str, i2, i3);
    }

    @t0(version = "1.3")
    @h.j
    @i.c.a.d
    public static final String b(@i.c.a.d char[] cArr) {
        h.q2.t.i0.f(cArr, "$this$concatToString");
        return new String(cArr);
    }

    public static /* synthetic */ String a(byte[] bArr, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = bArr.length;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return a(bArr, i2, i3, z);
    }

    @t0(version = "1.3")
    @h.j
    @i.c.a.d
    public static final String b(@i.c.a.d char[] cArr, int i2, int i3) {
        h.q2.t.i0.f(cArr, "$this$concatToString");
        h.g2.d.Companion.a(i2, i3, cArr.length);
        return new String(cArr, i2, i3 - i2);
    }

    @t0(version = "1.3")
    @h.j
    @i.c.a.d
    public static final String a(@i.c.a.d byte[] bArr, int i2, int i3, boolean z) {
        h.q2.t.i0.f(bArr, "$this$decodeToString");
        h.g2.d.Companion.a(i2, i3, bArr.length);
        if (!z) {
            return new String(bArr, i2, i3 - i2, f.f16682a);
        }
        String charBuffer = f.f16682a.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(bArr, i2, i3 - i2)).toString();
        h.q2.t.i0.a((Object) charBuffer, "decoder.decode(ByteBuffe…- startIndex)).toString()");
        return charBuffer;
    }

    @t0(version = "1.3")
    @h.j
    @i.c.a.d
    public static final String b(@i.c.a.d byte[] bArr) {
        h.q2.t.i0.f(bArr, "$this$decodeToString");
        return new String(bArr, f.f16682a);
    }

    public static /* synthetic */ boolean b(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return b(str, str2, z);
    }

    public static final boolean b(@i.c.a.d String str, @i.c.a.d String str2, boolean z) {
        h.q2.t.i0.f(str, "$this$endsWith");
        h.q2.t.i0.f(str2, "suffix");
        if (!z) {
            return str.endsWith(str2);
        }
        return a(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    @h.m2.f
    private static final int b(@i.c.a.d String str, int i2, int i3) {
        if (str != null) {
            return str.offsetByCodePoints(i2, i3);
        }
        throw new e1("null cannot be cast to non-null type java.lang.String");
    }

    @h.j
    @t0(version = "1.3")
    @h.m2.g
    @i.c.a.d
    public static final String b(@i.c.a.d String str, @i.c.a.d Locale locale) {
        h.q2.t.i0.f(str, "$this$decapitalize");
        h.q2.t.i0.f(locale, "locale");
        if (!(str.length() > 0) || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(0, 1);
        h.q2.t.i0.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (substring == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = substring.toLowerCase(locale);
        h.q2.t.i0.a((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        sb.append(lowerCase);
        String substring2 = str.substring(1);
        h.q2.t.i0.a((Object) substring2, "(this as java.lang.String).substring(startIndex)");
        sb.append(substring2);
        return sb.toString();
    }

    public static /* synthetic */ byte[] a(String str, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return a(str, i2, i3, z);
    }

    @t0(version = "1.3")
    @h.j
    @i.c.a.d
    public static final byte[] a(@i.c.a.d String str, int i2, int i3, boolean z) {
        h.q2.t.i0.f(str, "$this$encodeToByteArray");
        h.g2.d.Companion.a(i2, i3, str.length());
        if (!z) {
            String substring = str.substring(i2, i3);
            h.q2.t.i0.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            Charset charset = f.f16682a;
            if (substring == null) {
                throw new e1("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = substring.getBytes(charset);
            h.q2.t.i0.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            return bytes;
        }
        ByteBuffer encode = f.f16682a.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).encode(CharBuffer.wrap(str, i2, i3));
        if (encode.hasArray() && encode.arrayOffset() == 0) {
            int remaining = encode.remaining();
            byte[] array = encode.array();
            if (array == null) {
                h.q2.t.i0.f();
            }
            if (remaining == array.length) {
                byte[] array2 = encode.array();
                h.q2.t.i0.a((Object) array2, "byteBuffer.array()");
                return array2;
            }
        }
        byte[] bArr = new byte[encode.remaining()];
        encode.get(bArr);
        return bArr;
    }

    static /* synthetic */ char[] a(String str, char[] cArr, int i2, int i3, int i4, int i5, Object obj) {
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
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        str.getChars(i3, i4, cArr, i2);
        return cArr;
    }

    @h.m2.f
    private static final char[] a(@i.c.a.d String str, char[] cArr, int i2, int i3, int i4) {
        if (str == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        str.getChars(i3, i4, cArr, i2);
        return cArr;
    }

    @h.m2.f
    private static final String a(@i.c.a.d String str, Object... objArr) {
        String format = String.format(str, Arrays.copyOf(objArr, objArr.length));
        h.q2.t.i0.a((Object) format, "java.lang.String.format(this, *args)");
        return format;
    }

    @h.m2.f
    private static final String a(@i.c.a.d m1 m1Var, String str, Object... objArr) {
        String format = String.format(str, Arrays.copyOf(objArr, objArr.length));
        h.q2.t.i0.a((Object) format, "java.lang.String.format(format, *args)");
        return format;
    }

    @h.m2.f
    private static final String a(@i.c.a.d String str, Locale locale, Object... objArr) {
        String format = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        h.q2.t.i0.a((Object) format, "java.lang.String.format(locale, this, *args)");
        return format;
    }

    @h.m2.f
    private static final String a(@i.c.a.d m1 m1Var, Locale locale, String str, Object... objArr) {
        String format = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        h.q2.t.i0.a((Object) format, "java.lang.String.format(locale, format, *args)");
        return format;
    }

    public static /* synthetic */ List a(CharSequence charSequence, Pattern pattern, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return a(charSequence, pattern, i2);
    }

    @i.c.a.d
    public static final List<String> a(@i.c.a.d CharSequence charSequence, @i.c.a.d Pattern pattern, int i2) {
        List<String> d2;
        h.q2.t.i0.f(charSequence, "$this$split");
        h.q2.t.i0.f(pattern, "regex");
        if (i2 >= 0) {
            if (i2 == 0) {
                i2 = -1;
            }
            String[] split = pattern.split(charSequence, i2);
            h.q2.t.i0.a((Object) split, "regex.split(this, if (limit == 0) -1 else limit)");
            d2 = h.g2.q.d((Object[]) split);
            return d2;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    public static /* synthetic */ boolean a(String str, String str2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = false;
        }
        return a(str, str2, i2, z);
    }

    public static final boolean a(@i.c.a.d String str, @i.c.a.d String str2, int i2, boolean z) {
        h.q2.t.i0.f(str, "$this$startsWith");
        h.q2.t.i0.f(str2, RequestParameters.PREFIX);
        if (!z) {
            return str.startsWith(str2, i2);
        }
        return a(str, i2, str2, 0, str2.length(), z);
    }

    @h.m2.f
    private static final String a(byte[] bArr, int i2, int i3, Charset charset) {
        return new String(bArr, i2, i3, charset);
    }

    @h.m2.f
    private static final String a(byte[] bArr, Charset charset) {
        return new String(bArr, charset);
    }

    @h.m2.f
    private static final String a(byte[] bArr, int i2, int i3) {
        return new String(bArr, i2, i3, f.f16682a);
    }

    @h.m2.f
    private static final String a(byte[] bArr) {
        return new String(bArr, f.f16682a);
    }

    @h.m2.f
    private static final String a(char[] cArr) {
        return new String(cArr);
    }

    @h.m2.f
    private static final String a(char[] cArr, int i2, int i3) {
        return new String(cArr, i2, i3);
    }

    @h.m2.f
    private static final String a(int[] iArr, int i2, int i3) {
        return new String(iArr, i2, i3);
    }

    @h.m2.f
    private static final String a(StringBuffer stringBuffer) {
        return new String(stringBuffer);
    }

    @h.m2.f
    private static final int a(@i.c.a.d String str, int i2, int i3) {
        if (str != null) {
            return str.codePointCount(i2, i3);
        }
        throw new e1("null cannot be cast to non-null type java.lang.String");
    }

    public static /* synthetic */ int a(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return a(str, str2, z);
    }

    public static final int a(@i.c.a.d String str, @i.c.a.d String str2, boolean z) {
        h.q2.t.i0.f(str, "$this$compareTo");
        h.q2.t.i0.f(str2, DispatchConstants.OTHER);
        if (z) {
            return str.compareToIgnoreCase(str2);
        }
        return str.compareTo(str2);
    }

    @h.m2.f
    private static final boolean a(@i.c.a.d String str, CharSequence charSequence) {
        if (str != null) {
            return str.contentEquals(charSequence);
        }
        throw new e1("null cannot be cast to non-null type java.lang.String");
    }

    @h.m2.f
    private static final boolean a(@i.c.a.d String str, StringBuffer stringBuffer) {
        if (str != null) {
            return str.contentEquals(stringBuffer);
        }
        throw new e1("null cannot be cast to non-null type java.lang.String");
    }

    public static final boolean a(@i.c.a.d CharSequence charSequence) {
        boolean z;
        h.q2.t.i0.f(charSequence, "$this$isBlank");
        if (charSequence.length() != 0) {
            Iterable b2 = c0.b(charSequence);
            if (!(b2 instanceof Collection) || !((Collection) b2).isEmpty()) {
                Iterator it = b2.iterator();
                while (it.hasNext()) {
                    if (!d.p(charSequence.charAt(((u0) it).nextInt()))) {
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

    public static final boolean a(@i.c.a.d CharSequence charSequence, int i2, @i.c.a.d CharSequence charSequence2, int i3, int i4, boolean z) {
        h.q2.t.i0.f(charSequence, "$this$regionMatches");
        h.q2.t.i0.f(charSequence2, DispatchConstants.OTHER);
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return a((String) charSequence, i2, (String) charSequence2, i3, i4, z);
        }
        return c0.b(charSequence, i2, charSequence2, i3, i4, z);
    }

    public static final boolean a(@i.c.a.d String str, int i2, @i.c.a.d String str2, int i3, int i4, boolean z) {
        h.q2.t.i0.f(str, "$this$regionMatches");
        h.q2.t.i0.f(str2, DispatchConstants.OTHER);
        if (!z) {
            return str.regionMatches(i2, str2, i3, i4);
        }
        return str.regionMatches(z, i2, str2, i3, i4);
    }

    @h.m2.f
    private static final byte[] a(@i.c.a.d String str, Charset charset) {
        if (str == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str.getBytes(charset);
        h.q2.t.i0.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    static /* synthetic */ byte[] a(String str, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = f.f16682a;
        }
        if (str == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str.getBytes(charset);
        h.q2.t.i0.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    @h.j
    @t0(version = "1.3")
    @h.m2.g
    @i.c.a.d
    public static final String a(@i.c.a.d String str, @i.c.a.d Locale locale) {
        h.q2.t.i0.f(str, "$this$capitalize");
        h.q2.t.i0.f(locale, "locale");
        if (str.length() > 0) {
            char charAt = str.charAt(0);
            if (Character.isLowerCase(charAt)) {
                StringBuilder sb = new StringBuilder();
                char titleCase = Character.toTitleCase(charAt);
                if (titleCase != Character.toUpperCase(charAt)) {
                    sb.append(titleCase);
                } else {
                    String substring = str.substring(0, 1);
                    h.q2.t.i0.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (substring == null) {
                        throw new e1("null cannot be cast to non-null type java.lang.String");
                    }
                    String upperCase = substring.toUpperCase(locale);
                    h.q2.t.i0.a((Object) upperCase, "(this as java.lang.String).toUpperCase(locale)");
                    sb.append(upperCase);
                }
                String substring2 = str.substring(1);
                h.q2.t.i0.a((Object) substring2, "(this as java.lang.String).substring(startIndex)");
                sb.append(substring2);
                String sb2 = sb.toString();
                h.q2.t.i0.a((Object) sb2, "StringBuilder().apply(builderAction).toString()");
                return sb2;
            }
        }
        return str;
    }

    @i.c.a.d
    public static final String a(@i.c.a.d CharSequence charSequence, int i2) {
        h.q2.t.i0.f(charSequence, "$this$repeat");
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
                h.q2.t.i0.a((Object) sb2, "sb.toString()");
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

    @i.c.a.d
    public static final Comparator<String> a(@i.c.a.d m1 m1Var) {
        h.q2.t.i0.f(m1Var, "$this$CASE_INSENSITIVE_ORDER");
        Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;
        h.q2.t.i0.a((Object) comparator, "java.lang.String.CASE_INSENSITIVE_ORDER");
        return comparator;
    }

    static /* synthetic */ Pattern a(String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        Pattern compile = Pattern.compile(str, i2);
        h.q2.t.i0.a((Object) compile, "java.util.regex.Pattern.compile(this, flags)");
        return compile;
    }
}
