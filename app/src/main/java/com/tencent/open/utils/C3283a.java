package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import cn.cloudwalk.util.LogUtils;
import com.tencent.open.log.SLog;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.utils.a */
/* loaded from: classes2.dex */
public class C3283a {

    /* renamed from: a */
    private KeyStore f11285a;

    /* renamed from: b */
    private SharedPreferences f11286b;

    public C3283a(Context context) {
        try {
            this.f11286b = context.getSharedPreferences("KEYSTORE_SETTING", 0);
            this.f11285a = KeyStore.getInstance("AndroidKeyStore");
            this.f11285a.load(null);
            if (this.f11285a.containsAlias("KEYSTORE_AES")) {
                return;
            }
            m10576c("");
            m10573a(context);
            m10572a();
        } catch (Exception e2) {
            SLog.m10499d("KEYSTORE", LogUtils.LOG_EXCEPTION, e2);
        }
    }

    /* renamed from: a */
    private void m10573a(Context context) throws Exception {
        SLog.m10498d("KEYSTORE", "Build.VERSION.SDK_INT=" + Build.VERSION.SDK_INT);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            keyPairGenerator.initialize(new KeyGenParameterSpec.Builder("KEYSTORE_AES", 3).setDigests("SHA-256", "SHA-512").setEncryptionPaddings("PKCS1Padding").build());
            keyPairGenerator.generateKeyPair();
        } else if (i2 >= 18) {
            KeyPairGenerator keyPairGenerator2 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(1, 30);
            keyPairGenerator2.initialize(new KeyPairGeneratorSpec.Builder(context).setAlias("KEYSTORE_AES").setSubject(new X500Principal("CN=KEYSTORE_AES")).setSerialNumber(BigInteger.TEN).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build());
            keyPairGenerator2.generateKeyPair();
        }
    }

    /* renamed from: c */
    private void m10576c(String str) {
        this.f11286b.edit().putString("PREF_KEY_IV", str).apply();
    }

    /* renamed from: d */
    private void m10577d(String str) {
        this.f11286b.edit().putString("PREF_KEY_AES", str).apply();
    }

    /* renamed from: b */
    public String m10579b(String str) {
        try {
            byte[] decode = Base64.decode(str.getBytes(), 0);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, m10575c(), new IvParameterSpec(m10574b()));
            return new String(cipher.doFinal(decode));
        } catch (Exception e2) {
            SLog.m10501e("KEYSTORE", LogUtils.LOG_EXCEPTION, e2);
            return "";
        }
    }

    /* renamed from: c */
    private SecretKeySpec m10575c() throws Exception {
        String string = this.f11286b.getString("PREF_KEY_AES", "");
        if (Build.VERSION.SDK_INT < 18) {
            return new SecretKeySpec(Base64.decode(string, 0), "AES/GCM/NoPadding");
        }
        PrivateKey privateKey = (PrivateKey) this.f11285a.getKey("KEYSTORE_AES", null);
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, privateKey);
        return new SecretKeySpec(cipher.doFinal(Base64.decode(string, 0)), "AES/GCM/NoPadding");
    }

    /* renamed from: b */
    private byte[] m10574b() {
        return Base64.decode(this.f11286b.getString("PREF_KEY_IV", ""), 0);
    }

    /* renamed from: a */
    public String m10578a(String str) {
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, m10575c(), new IvParameterSpec(m10574b()));
            return Base64.encodeToString(cipher.doFinal(str.getBytes()), 0);
        } catch (Exception e2) {
            SLog.m10501e("KEYSTORE", LogUtils.LOG_EXCEPTION, e2);
            return "";
        }
    }

    /* renamed from: a */
    private void m10572a() throws Exception {
        byte[] bArr = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(bArr);
        m10576c(Base64.encodeToString(secureRandom.generateSeed(12), 0));
        if (Build.VERSION.SDK_INT >= 18) {
            PublicKey publicKey = this.f11285a.getCertificate("KEYSTORE_AES").getPublicKey();
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, publicKey);
            m10577d(Base64.encodeToString(cipher.doFinal(bArr), 0));
            return;
        }
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(bArr);
        m10577d(Base64.encodeToString(messageDigest.digest(), 0));
    }
}
