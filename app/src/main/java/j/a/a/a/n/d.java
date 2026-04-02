package j.a.a.a.n;

import j.a.a.a.g;
import j.a.a.a.k.l;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: RFC1522Codec.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class d {
    protected static final char a = '?';

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final String f12546b = "?=";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected static final String f12547c = "=?";

    d() {
    }

    protected abstract String a();

    protected String a(String str, String str2) throws g, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(f12547c);
        stringBuffer.append(str2);
        stringBuffer.append(a);
        stringBuffer.append(a());
        stringBuffer.append(a);
        stringBuffer.append(l.b(b(str.getBytes(str2))));
        stringBuffer.append(f12546b);
        return stringBuffer.toString();
    }

    protected abstract byte[] a(byte[] bArr) throws j.a.a.a.e;

    protected String b(String str) throws UnsupportedEncodingException, j.a.a.a.e {
        if (str == null) {
            return null;
        }
        if (!str.startsWith(f12547c) || !str.endsWith(f12546b)) {
            throw new j.a.a.a.e("RFC 1522 violation: malformed encoded content");
        }
        int length = str.length() - 2;
        int iIndexOf = str.indexOf(63, 2);
        if (iIndexOf == length) {
            throw new j.a.a.a.e("RFC 1522 violation: charset token not found");
        }
        String strSubstring = str.substring(2, iIndexOf);
        if (strSubstring.equals("")) {
            throw new j.a.a.a.e("RFC 1522 violation: charset not specified");
        }
        int i2 = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(63, i2);
        if (iIndexOf2 == length) {
            throw new j.a.a.a.e("RFC 1522 violation: encoding token not found");
        }
        String strSubstring2 = str.substring(i2, iIndexOf2);
        if (a().equalsIgnoreCase(strSubstring2)) {
            int i3 = iIndexOf2 + 1;
            return new String(a(l.b(str.substring(i3, str.indexOf(63, i3)))), strSubstring);
        }
        throw new j.a.a.a.e("This codec cannot decode " + strSubstring2 + " encoded content");
    }

    protected abstract byte[] b(byte[] bArr) throws g;
}
