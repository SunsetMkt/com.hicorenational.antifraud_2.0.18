package i.a.a.a.n;

import i.a.a.a.g;
import i.a.a.a.k.l;
import java.io.UnsupportedEncodingException;

/* compiled from: RFC1522Codec.java */
/* loaded from: classes2.dex */
abstract class d {

    /* renamed from: a, reason: collision with root package name */
    protected static final char f16876a = '?';

    /* renamed from: b, reason: collision with root package name */
    protected static final String f16877b = "?=";

    /* renamed from: c, reason: collision with root package name */
    protected static final String f16878c = "=?";

    d() {
    }

    protected abstract String a();

    protected String a(String str, String str2) throws g, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(f16878c);
        stringBuffer.append(str2);
        stringBuffer.append(f16876a);
        stringBuffer.append(a());
        stringBuffer.append(f16876a);
        stringBuffer.append(l.b(b(str.getBytes(str2))));
        stringBuffer.append(f16877b);
        return stringBuffer.toString();
    }

    protected abstract byte[] a(byte[] bArr) throws i.a.a.a.e;

    protected String b(String str) throws i.a.a.a.e, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        if (!str.startsWith(f16878c) || !str.endsWith(f16877b)) {
            throw new i.a.a.a.e("RFC 1522 violation: malformed encoded content");
        }
        int length = str.length() - 2;
        int indexOf = str.indexOf(63, 2);
        if (indexOf == length) {
            throw new i.a.a.a.e("RFC 1522 violation: charset token not found");
        }
        String substring = str.substring(2, indexOf);
        if (substring.equals("")) {
            throw new i.a.a.a.e("RFC 1522 violation: charset not specified");
        }
        int i2 = indexOf + 1;
        int indexOf2 = str.indexOf(63, i2);
        if (indexOf2 == length) {
            throw new i.a.a.a.e("RFC 1522 violation: encoding token not found");
        }
        String substring2 = str.substring(i2, indexOf2);
        if (a().equalsIgnoreCase(substring2)) {
            int i3 = indexOf2 + 1;
            return new String(a(l.b(str.substring(i3, str.indexOf(63, i3)))), substring);
        }
        throw new i.a.a.a.e("This codec cannot decode " + substring2 + " encoded content");
    }

    protected abstract byte[] b(byte[] bArr) throws g;
}
