package com.hihonor.honorid.d.a;

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

/* compiled from: KeyStoreEncryptAndDecrypt.java */
/* loaded from: classes.dex */
public class c {
    public static String a(String str, String str2) {
        byte[] a2 = a.a(str2);
        if (a2.length <= 16) {
            k.a.a.a.j.e.a("KeyStoreEncryptAndDecrypt", "Decrypt source data is invalid.", true);
            return "";
        }
        byte[] bArr = new byte[0];
        try {
            SecretKey a3 = a(str);
            byte[] copyOf = Arrays.copyOf(a2, 16);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(2, a3, new IvParameterSpec(copyOf));
            bArr = cipher.doFinal(a2, 16, a2.length - 16);
        } catch (RuntimeException unused) {
            k.a.a.a.j.e.b("KeyStoreEncryptAndDecrypt", "RuntimeException", true);
        } catch (Exception unused2) {
            k.a.a.a.j.e.a("KeyStoreEncryptAndDecrypt", "Decrypt exception", true);
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused3) {
            k.a.a.a.j.e.b("KeyStoreEncryptAndDecrypt", "unreachable UnsupportedEncodingException", true);
            return "";
        }
    }

    public static String b(String str, String str2) {
        byte[] doFinal;
        byte[] iv;
        byte[] bArr = new byte[0];
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(1, a(str));
            doFinal = cipher.doFinal(str2.getBytes("UTF-8"));
            iv = cipher.getIV();
        } catch (RuntimeException unused) {
            k.a.a.a.j.e.b("KeyStoreEncryptAndDecrypt", "RuntimeException", true);
        } catch (Exception unused2) {
            k.a.a.a.j.e.a("KeyStoreEncryptAndDecrypt", "Encrypt exception", true);
        }
        if (iv != null && iv.length == 16) {
            bArr = Arrays.copyOf(iv, iv.length + doFinal.length);
            System.arraycopy(doFinal, 0, bArr, iv.length, doFinal.length);
            return a.a(bArr);
        }
        k.a.a.a.j.e.a("KeyStoreEncryptAndDecrypt", "IV is invalid.", true);
        return "";
    }

    @TargetApi(23)
    private static SecretKey a(String str) {
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
            k.a.a.a.j.e.b("KeyStoreEncryptAndDecrypt", "RuntimeException", true);
        } catch (Exception unused2) {
            k.a.a.a.j.e.a("KeyStoreEncryptAndDecrypt", "Generate key exception ", true);
        }
        return secretKey;
    }
}
