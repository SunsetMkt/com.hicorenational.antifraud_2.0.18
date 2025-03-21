package util;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import p286h.C5230f1;
import p388ui.Hicore;

/* compiled from: AESUtil.java */
/* renamed from: util.u0 */
/* loaded from: classes2.dex */
public class C7324u0 {

    /* renamed from: a */
    private static Cipher f25615a = null;

    /* renamed from: b */
    private static final String f25616b = "UTF-8";

    /* renamed from: c */
    private static final String f25617c = "AES";

    /* renamed from: d */
    private static final String f25618d = "SHA1PRNG";

    /* renamed from: e */
    private static final String f25619e = "AES/CBC/PKCS5Padding";

    /* renamed from: f */
    private static final Integer f25620f = 128;

    /* renamed from: g */
    private static final Integer f25621g = 16;

    /* renamed from: h */
    private static byte[] f25622h;

    /* compiled from: AESUtil.java */
    /* renamed from: util.u0$a */
    public static class a extends Provider {
        public a() {
            super("Crypto", 1.0d, "HARMONY (SHA1 digest; SecureRandom; SHA1withDSA signature)");
            put("SecureRandom.SHA1PRNG", "org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl");
            put("SecureRandom.SHA1PRNG ImplementedIn", ExifInterface.TAG_SOFTWARE);
        }
    }

    /* renamed from: a */
    private static byte[] m26602a(String str) throws Exception {
        byte[] bArr = f25622h;
        if (bArr == null || bArr.length != 32) {
            SharedPreferences sharedPreferences = Hicore.getApp().getSharedPreferences("crypto_info", 0);
            String string = sharedPreferences.getString("salt", "");
            if (!TextUtils.isEmpty(string)) {
                f25622h = m26611e(string);
            }
            byte[] bArr2 = f25622h;
            if (bArr2 == null || bArr2.length != 32) {
                byte[] bArr3 = new byte[32];
                new SecureRandom().nextBytes(bArr3);
                sharedPreferences.edit().putString("salt", m26609c(bArr3)).commit();
                f25622h = bArr3;
            }
        }
        return new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(str.toCharArray(), f25622h, 1000, 256)).getEncoded(), f25617c).getEncoded();
    }

    /* renamed from: b */
    private static byte[] m26607b(byte[] bArr) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(f25617c);
        int i2 = Build.VERSION.SDK_INT;
        SecureRandom secureRandom = i2 > 23 ? SecureRandom.getInstance(f25618d, new a()) : i2 >= 17 ? SecureRandom.getInstance(f25618d, "Crypto") : SecureRandom.getInstance(f25618d);
        secureRandom.setSeed(bArr);
        keyGenerator.init(128, secureRandom);
        return keyGenerator.generateKey().getEncoded();
    }

    /* renamed from: c */
    public static String m26609c(byte[] bArr) {
        return m26600a(bArr, (String) null);
    }

    /* renamed from: d */
    public static String m26610d(String str) {
        return m26608c(str).substring(8, 24);
    }

    /* renamed from: e */
    public static byte[] m26611e(String str) {
        return m26603a(str, (String) null, (byte) 0);
    }

    /* renamed from: c */
    public static String m26608c(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                stringBuffer.append(String.format("%02X", Integer.valueOf(b2 & C5230f1.f20085c)));
            }
            return stringBuffer.toString();
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return "";
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
            return "";
        }
    }

    /* renamed from: b */
    public static String m26605b(String str, String str2, String str3) throws Exception {
        Cipher cipher = Cipher.getInstance(f25619e);
        cipher.init(1, new SecretKeySpec(str2.getBytes("UTF-8"), f25617c), new IvParameterSpec(str3.getBytes("UTF-8")));
        String encodeToString = Base64.encodeToString(cipher.doFinal(str.getBytes("UTF-8")), 0);
        C7301n1.m26457b("encrypt-->", encodeToString);
        C7301n1.m26457b("decrypt-->", m26598a(encodeToString, str2, str3));
        C7301n1.m26457b("encrypt 2-->", encodeToString);
        return encodeToString;
    }

    /* renamed from: a */
    public static String m26600a(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        if (length <= 0) {
            return "";
        }
        if (TextUtils.isEmpty(str)) {
            str = Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(String.valueOf((int) bArr[i2]));
            if (i2 != length - 1) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static String m26604b(String str, String str2) {
        String m26610d = m26610d(str);
        if (m26610d.length() == f25621g.intValue()) {
            try {
                m26601a(m26610d, 1);
                return m26599a(f25615a.doFinal(str2.getBytes("UTF-8")));
            } catch (Exception e2) {
                throw new RuntimeException("AESUtil:encrypt fail!", e2);
            }
        }
        throw new RuntimeException("AESUtil:Invalid AES secretKey length (must be 16 bytes)");
    }

    /* renamed from: a */
    public static byte[] m26603a(String str, String str2, byte b2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        String[] split = str.split(str2);
        int length = split.length;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            try {
                bArr[i2] = Byte.parseByte(split[i2]);
            } catch (Exception unused) {
                bArr[i2] = b2;
            }
        }
        return bArr;
    }

    /* renamed from: b */
    private static byte[] m26606b(String str) {
        byte[] bArr = new byte[str.length() / 2];
        int i2 = 0;
        while (i2 < str.length()) {
            int i3 = i2 + 2;
            bArr[i2 / 2] = (byte) Integer.parseInt(str.substring(i2, i3), 16);
            i2 = i3;
        }
        return bArr;
    }

    /* renamed from: a */
    public static String m26598a(String str, String str2, String str3) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("UTF-8"), f25617c);
        Cipher cipher = Cipher.getInstance(f25619e);
        cipher.init(2, secretKeySpec, new IvParameterSpec(str3.getBytes("UTF-8")));
        return new String(cipher.doFinal(Base64.decode(str, 0)), "UTF-8");
    }

    /* renamed from: a */
    public static String m26597a(String str, String str2) {
        String m26610d = m26610d(str);
        if (m26610d.length() == f25621g.intValue()) {
            try {
                m26601a(m26610d, 2);
                return new String(f25615a.doFinal(m26606b(str2)), "UTF-8");
            } catch (Exception e2) {
                throw new RuntimeException("AESUtil:decrypt fail!", e2);
            }
        }
        throw new RuntimeException("AESUtil:Invalid AES secretKey length (must be 16 bytes)");
    }

    /* renamed from: a */
    public static String m26599a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            sb.append(String.format("%02X", Byte.valueOf(b2)));
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static void m26601a(String str, int i2) {
        try {
            SecureRandom secureRandom = SecureRandom.getInstance(f25618d);
            secureRandom.setSeed(str.getBytes());
            KeyGenerator.getInstance(f25617c).init(f25620f.intValue(), secureRandom);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), f25617c);
            f25615a = Cipher.getInstance(f25619e);
            f25615a.init(i2, secretKeySpec, new IvParameterSpec(m26610d(str).getBytes()));
        } catch (Exception e2) {
            throw new RuntimeException("AESUtil:initParam fail!", e2);
        }
    }
}
