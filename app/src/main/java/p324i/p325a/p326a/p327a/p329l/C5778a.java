package p324i.p325a.p326a.p327a.p329l;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import p324i.p325a.p326a.p327a.p328k.C5776k;
import p324i.p325a.p326a.p327a.p328k.C5777l;

/* compiled from: DigestUtils.java */
/* renamed from: i.a.a.a.l.a */
/* loaded from: classes2.dex */
public class C5778a {

    /* renamed from: a */
    private static final int f20824a = 1024;

    /* renamed from: a */
    private static byte[] m24222a(MessageDigest messageDigest, InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1024];
        int read = inputStream.read(bArr, 0, 1024);
        while (read > -1) {
            messageDigest.update(bArr, 0, read);
            read = inputStream.read(bArr, 0, 1024);
        }
        return messageDigest.digest();
    }

    /* renamed from: b */
    static MessageDigest m24227b(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2.getMessage());
        }
    }

    /* renamed from: c */
    private static MessageDigest m24228c() {
        return m24227b("SHA-384");
    }

    /* renamed from: d */
    private static MessageDigest m24233d() {
        return m24227b("SHA-512");
    }

    /* renamed from: e */
    private static MessageDigest m24238e() {
        return m24227b("SHA");
    }

    /* renamed from: f */
    public static byte[] m24241f(String str) {
        return m24235d(m24221a(str));
    }

    /* renamed from: g */
    public static String m24244g(String str) {
        return C5776k.m24202b(m24241f(str));
    }

    /* renamed from: h */
    public static byte[] m24247h(String str) {
        return m24242f(m24221a(str));
    }

    /* renamed from: i */
    public static String m24250i(String str) {
        return C5776k.m24202b(m24247h(str));
    }

    /* renamed from: j */
    public static byte[] m24254j(String str) {
        return m24248h(m24221a(str));
    }

    /* renamed from: k */
    public static String m24255k(String str) {
        return C5776k.m24202b(m24254j(str));
    }

    /* renamed from: l */
    public static String m24256l(String str) {
        return C5776k.m24202b(m24239e(str));
    }

    /* renamed from: c */
    public static byte[] m24230c(String str) {
        return m24223a(m24221a(str));
    }

    /* renamed from: d */
    public static String m24232d(String str) {
        return C5776k.m24202b(m24230c(str));
    }

    /* renamed from: e */
    public static byte[] m24239e(String str) {
        return m24231c(m24221a(str));
    }

    /* renamed from: f */
    public static byte[] m24242f(byte[] bArr) {
        return m24228c().digest(bArr);
    }

    /* renamed from: g */
    public static String m24245g(byte[] bArr) {
        return C5776k.m24202b(m24242f(bArr));
    }

    /* renamed from: h */
    public static byte[] m24248h(byte[] bArr) {
        return m24233d().digest(bArr);
    }

    /* renamed from: i */
    public static String m24251i(byte[] bArr) {
        return C5776k.m24202b(m24248h(bArr));
    }

    /* renamed from: j */
    public static String m24253j(byte[] bArr) {
        return C5776k.m24202b(m24231c(bArr));
    }

    /* renamed from: b */
    private static MessageDigest m24226b() {
        return m24227b("SHA-256");
    }

    /* renamed from: c */
    public static byte[] m24231c(byte[] bArr) {
        return m24238e().digest(bArr);
    }

    /* renamed from: d */
    public static byte[] m24235d(byte[] bArr) {
        return m24226b().digest(bArr);
    }

    /* renamed from: e */
    public static String m24237e(byte[] bArr) {
        return C5776k.m24202b(m24235d(bArr));
    }

    /* renamed from: f */
    public static byte[] m24240f(InputStream inputStream) throws IOException {
        return m24222a(m24228c(), inputStream);
    }

    /* renamed from: g */
    public static String m24243g(InputStream inputStream) throws IOException {
        return C5776k.m24202b(m24240f(inputStream));
    }

    /* renamed from: h */
    public static byte[] m24246h(InputStream inputStream) throws IOException {
        return m24222a(m24233d(), inputStream);
    }

    /* renamed from: i */
    public static String m24249i(InputStream inputStream) throws IOException {
        return C5776k.m24202b(m24246h(inputStream));
    }

    /* renamed from: j */
    public static String m24252j(InputStream inputStream) throws IOException {
        return C5776k.m24202b(m24229c(inputStream));
    }

    /* renamed from: b */
    public static String m24225b(byte[] bArr) {
        return C5776k.m24202b(m24223a(bArr));
    }

    /* renamed from: c */
    public static byte[] m24229c(InputStream inputStream) throws IOException {
        return m24222a(m24238e(), inputStream);
    }

    /* renamed from: d */
    public static byte[] m24234d(InputStream inputStream) throws IOException {
        return m24222a(m24226b(), inputStream);
    }

    /* renamed from: e */
    public static String m24236e(InputStream inputStream) throws IOException {
        return C5776k.m24202b(m24234d(inputStream));
    }

    /* renamed from: a */
    private static byte[] m24221a(String str) {
        return C5777l.m24218f(str);
    }

    /* renamed from: b */
    public static String m24224b(InputStream inputStream) throws IOException {
        return C5776k.m24202b(m24220a(inputStream));
    }

    /* renamed from: a */
    private static MessageDigest m24219a() {
        return m24227b("MD5");
    }

    /* renamed from: a */
    public static byte[] m24223a(byte[] bArr) {
        return m24219a().digest(bArr);
    }

    /* renamed from: a */
    public static byte[] m24220a(InputStream inputStream) throws IOException {
        return m24222a(m24219a(), inputStream);
    }
}
