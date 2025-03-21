package org.android.agoo.common;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: Taobao */
/* renamed from: org.android.agoo.common.a */
/* loaded from: classes2.dex */
public final class C6011a {

    /* renamed from: a */
    private static byte[] f21470a = {82, 22, 50, 44, -16, 124, -40, -114, -87, -40, 37, 23, -56, 23, -33, 75};

    /* renamed from: b */
    private static ThreadLocal<Cipher> f21471b = new ThreadLocal<>();

    /* renamed from: c */
    private static final AlgorithmParameterSpec f21472c = new IvParameterSpec(f21470a);

    /* renamed from: a */
    public static final byte[] m24951a(byte[] bArr, SecretKeySpec secretKeySpec, byte[] bArr2) throws IllegalArgumentException {
        try {
            return m24949a(secretKeySpec, bArr2, 2).doFinal(bArr);
        } catch (BadPaddingException e2) {
            throw new IllegalArgumentException("AES decrypt error:" + e2.getMessage(), e2);
        } catch (IllegalBlockSizeException e3) {
            throw new IllegalArgumentException("AES decrypt error:" + e3.getMessage(), e3);
        }
    }

    /* renamed from: a */
    private static final Cipher m24949a(SecretKeySpec secretKeySpec, byte[] bArr, int i2) {
        Cipher m24948a = m24948a();
        try {
            m24948a.init(i2, secretKeySpec, new IvParameterSpec(bArr));
            return m24948a;
        } catch (IllegalArgumentException e2) {
            throw new RuntimeException("init Chipher error:" + e2.getMessage(), e2);
        } catch (InvalidAlgorithmParameterException e3) {
            throw new RuntimeException("init Chipher error:" + e3.getMessage(), e3);
        } catch (InvalidKeyException e4) {
            throw new RuntimeException("init Chipher error:" + e4.getMessage(), e4);
        }
    }

    /* renamed from: a */
    private static final Cipher m24948a() {
        Cipher cipher = f21471b.get();
        if (cipher == null) {
            try {
                cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                f21471b.set(cipher);
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException("get Chipher error:" + e2.getMessage(), e2);
            } catch (NoSuchPaddingException e3) {
                throw new RuntimeException("get Chipher error:" + e3.getMessage(), e3);
            }
        }
        return cipher;
    }

    /* renamed from: a */
    public static final byte[] m24950a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Throwable th) {
            throw new RuntimeException("md5 value Throwable", th);
        }
    }

    /* renamed from: a */
    public static byte[] m24952a(byte[] bArr, byte[] bArr2) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "HmacSHA1");
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(secretKeySpec);
            return mac.doFinal(bArr2);
        } catch (Throwable th) {
            throw new RuntimeException("HmacSHA1 Throwable", th);
        }
    }
}
