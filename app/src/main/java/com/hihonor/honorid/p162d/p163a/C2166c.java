package com.hihonor.honorid.p162d.p163a;

import android.annotation.TargetApi;
import android.security.keystore.KeyGenParameterSpec;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.KeyStore;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import p358k.p359a.p360a.p361a.p363j.C5863e;

/* compiled from: KeyStoreEncryptAndDecrypt.java */
/* renamed from: com.hihonor.honorid.d.a.c */
/* loaded from: classes.dex */
public class C2166c {
    /* renamed from: a */
    public static String m6305a(String str, String str2) {
        byte[] m6301a = AbstractC2164a.m6301a(str2);
        if (m6301a.length <= 16) {
            C5863e.m24691a("KeyStoreEncryptAndDecrypt", "Decrypt source data is invalid.", true);
            return "";
        }
        byte[] bArr = new byte[0];
        try {
            SecretKey m6306a = m6306a(str);
            byte[] copyOf = Arrays.copyOf(m6301a, 16);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(2, m6306a, new IvParameterSpec(copyOf));
            bArr = cipher.doFinal(m6301a, 16, m6301a.length - 16);
        } catch (RuntimeException unused) {
            C5863e.m24692b("KeyStoreEncryptAndDecrypt", "RuntimeException", true);
        } catch (Exception unused2) {
            C5863e.m24691a("KeyStoreEncryptAndDecrypt", "Decrypt exception", true);
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused3) {
            C5863e.m24692b("KeyStoreEncryptAndDecrypt", "unreachable UnsupportedEncodingException", true);
            return "";
        }
    }

    /* renamed from: b */
    public static String m6307b(String str, String str2) {
        byte[] doFinal;
        byte[] iv;
        byte[] bArr = new byte[0];
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(1, m6306a(str));
            doFinal = cipher.doFinal(str2.getBytes("UTF-8"));
            iv = cipher.getIV();
        } catch (RuntimeException unused) {
            C5863e.m24692b("KeyStoreEncryptAndDecrypt", "RuntimeException", true);
        } catch (Exception unused2) {
            C5863e.m24691a("KeyStoreEncryptAndDecrypt", "Encrypt exception", true);
        }
        if (iv != null && iv.length == 16) {
            bArr = Arrays.copyOf(iv, iv.length + doFinal.length);
            System.arraycopy(doFinal, 0, bArr, iv.length, doFinal.length);
            return AbstractC2164a.m6299a(bArr);
        }
        C5863e.m24691a("KeyStoreEncryptAndDecrypt", "IV is invalid.", true);
        return "";
    }

    @TargetApi(23)
    /* renamed from: a */
    private static SecretKey m6306a(String str) {
        SecretKey secretKey = null;
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            Key key = keyStore.getKey(str, null);
            if (key != null && (key instanceof SecretKey)) {
                secretKey = (SecretKey) key;
            } else {
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                keyGenerator.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes("CBC").setEncryptionPaddings("PKCS7Padding").setKeySize(256).build());
                secretKey = keyGenerator.generateKey();
            }
        } catch (RuntimeException unused) {
            C5863e.m24692b("KeyStoreEncryptAndDecrypt", "RuntimeException", true);
        } catch (Exception unused2) {
            C5863e.m24691a("KeyStoreEncryptAndDecrypt", "Generate key exception ", true);
        }
        return secretKey;
    }
}
