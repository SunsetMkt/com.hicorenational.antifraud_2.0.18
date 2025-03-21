package p324i.p325a.p326a.p327a.p332n;

import java.io.UnsupportedEncodingException;
import p324i.p325a.p326a.p327a.C5760e;
import p324i.p325a.p326a.p327a.C5762g;
import p324i.p325a.p326a.p327a.p328k.C5777l;

/* compiled from: RFC1522Codec.java */
/* renamed from: i.a.a.a.n.d */
/* loaded from: classes2.dex */
abstract class AbstractC5800d {

    /* renamed from: a */
    protected static final char f20930a = '?';

    /* renamed from: b */
    protected static final String f20931b = "?=";

    /* renamed from: c */
    protected static final String f20932c = "=?";

    AbstractC5800d() {
    }

    /* renamed from: a */
    protected abstract String mo24416a();

    /* renamed from: a */
    protected String m24431a(String str, String str2) throws C5762g, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(f20932c);
        stringBuffer.append(str2);
        stringBuffer.append(f20930a);
        stringBuffer.append(mo24416a());
        stringBuffer.append(f20930a);
        stringBuffer.append(C5777l.m24209b(mo24420b(str.getBytes(str2))));
        stringBuffer.append(f20931b);
        return stringBuffer.toString();
    }

    /* renamed from: a */
    protected abstract byte[] mo24417a(byte[] bArr) throws C5760e;

    /* renamed from: b */
    protected String m24432b(String str) throws C5760e, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        if (!str.startsWith(f20932c) || !str.endsWith(f20931b)) {
            throw new C5760e("RFC 1522 violation: malformed encoded content");
        }
        int length = str.length() - 2;
        int indexOf = str.indexOf(63, 2);
        if (indexOf == length) {
            throw new C5760e("RFC 1522 violation: charset token not found");
        }
        String substring = str.substring(2, indexOf);
        if (substring.equals("")) {
            throw new C5760e("RFC 1522 violation: charset not specified");
        }
        int i2 = indexOf + 1;
        int indexOf2 = str.indexOf(63, i2);
        if (indexOf2 == length) {
            throw new C5760e("RFC 1522 violation: encoding token not found");
        }
        String substring2 = str.substring(i2, indexOf2);
        if (mo24416a().equalsIgnoreCase(substring2)) {
            int i3 = indexOf2 + 1;
            return new String(mo24417a(C5777l.m24210b(str.substring(i3, str.indexOf(63, i3)))), substring);
        }
        throw new C5760e("This codec cannot decode " + substring2 + " encoded content");
    }

    /* renamed from: b */
    protected abstract byte[] mo24420b(byte[] bArr) throws C5762g;
}
