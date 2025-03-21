package p324i.p325a.p326a.p327a.p328k;

import java.io.UnsupportedEncodingException;
import p324i.p325a.p326a.p327a.C5758c;

/* compiled from: StringUtils.java */
/* renamed from: i.a.a.a.k.l */
/* loaded from: classes2.dex */
public class C5777l {
    /* renamed from: a */
    public static byte[] m24207a(String str) {
        return m24208a(str, C5758c.f20750a);
    }

    /* renamed from: b */
    public static byte[] m24210b(String str) {
        return m24208a(str, C5758c.f20751b);
    }

    /* renamed from: c */
    public static byte[] m24212c(String str) {
        return m24208a(str, C5758c.f20752c);
    }

    /* renamed from: d */
    public static byte[] m24214d(String str) {
        return m24208a(str, C5758c.f20753d);
    }

    /* renamed from: e */
    public static byte[] m24216e(String str) {
        return m24208a(str, C5758c.f20754e);
    }

    /* renamed from: f */
    public static byte[] m24218f(String str) {
        return m24208a(str, "UTF-8");
    }

    /* renamed from: a */
    public static byte[] m24208a(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(str2);
        } catch (UnsupportedEncodingException e2) {
            throw m24204a(str2, e2);
        }
    }

    /* renamed from: b */
    public static String m24209b(byte[] bArr) {
        return m24206a(bArr, C5758c.f20751b);
    }

    /* renamed from: c */
    public static String m24211c(byte[] bArr) {
        return m24206a(bArr, C5758c.f20752c);
    }

    /* renamed from: d */
    public static String m24213d(byte[] bArr) {
        return m24206a(bArr, C5758c.f20753d);
    }

    /* renamed from: e */
    public static String m24215e(byte[] bArr) {
        return m24206a(bArr, C5758c.f20754e);
    }

    /* renamed from: f */
    public static String m24217f(byte[] bArr) {
        return m24206a(bArr, "UTF-8");
    }

    /* renamed from: a */
    private static IllegalStateException m24204a(String str, UnsupportedEncodingException unsupportedEncodingException) {
        return new IllegalStateException(str + ": " + unsupportedEncodingException);
    }

    /* renamed from: a */
    public static String m24206a(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e2) {
            throw m24204a(str, e2);
        }
    }

    /* renamed from: a */
    public static String m24205a(byte[] bArr) {
        return m24206a(bArr, C5758c.f20750a);
    }
}
