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
import ui.Hicore;

/* JADX INFO: compiled from: AESUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public class x0 {
    private static Cipher a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f15102b = "UTF-8";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f15103c = "AES";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f15104d = "SHA1PRNG";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f15105e = "AES/CBC/PKCS5Padding";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Integer f15106f = 128;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Integer f15107g = 16;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static byte[] f15108h;

    /* JADX INFO: compiled from: AESUtil.java */
    public static class a extends Provider {
        public a() {
            super("Crypto", 1.0d, "HARMONY (SHA1 digest; SecureRandom; SHA1withDSA signature)");
            put("SecureRandom.SHA1PRNG", "org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl");
            put("SecureRandom.SHA1PRNG ImplementedIn", ExifInterface.TAG_SOFTWARE);
        }
    }

    private static byte[] a(String str) throws Exception {
        byte[] bArr = f15108h;
        if (bArr == null || bArr.length != 32) {
            SharedPreferences sharedPreferences = Hicore.getApp().getSharedPreferences("crypto_info", 0);
            String string = sharedPreferences.getString("salt", "");
            if (!TextUtils.isEmpty(string)) {
                f15108h = e(string);
            }
            byte[] bArr2 = f15108h;
            if (bArr2 == null || bArr2.length != 32) {
                byte[] bArr3 = new byte[32];
                new SecureRandom().nextBytes(bArr3);
                sharedPreferences.edit().putString("salt", c(bArr3)).commit();
                f15108h = bArr3;
            }
        }
        return new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(str.toCharArray(), f15108h, 1000, 256)).getEncoded(), f15103c).getEncoded();
    }

    private static byte[] b(byte[] bArr) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(f15103c);
        int i2 = Build.VERSION.SDK_INT;
        SecureRandom secureRandom = i2 > 23 ? SecureRandom.getInstance(f15104d, new a()) : i2 >= 17 ? SecureRandom.getInstance(f15104d, "Crypto") : SecureRandom.getInstance(f15104d);
        secureRandom.setSeed(bArr);
        keyGenerator.init(128, secureRandom);
        return keyGenerator.generateKey().getEncoded();
    }

    public static String c(byte[] bArr) {
        return a(bArr, (String) null);
    }

    public static String d(String str) {
        return c(str).substring(8, 24);
    }

    public static byte[] e(String str) {
        return a(str, (String) null, (byte) 0);
    }

    public static String c(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : bArrDigest) {
                stringBuffer.append(String.format("%02X", Integer.valueOf(b2 & i.f1.f12066c)));
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

    public static String b(String str, String str2, String str3) throws Exception {
        Cipher cipher = Cipher.getInstance(f15105e);
        cipher.init(1, new SecretKeySpec(str2.getBytes("UTF-8"), f15103c), new IvParameterSpec(str3.getBytes("UTF-8")));
        String strEncodeToString = Base64.encodeToString(cipher.doFinal(str.getBytes("UTF-8")), 0);
        s1.b("encrypt-->", strEncodeToString);
        s1.b("decrypt-->", a(strEncodeToString, str2, str3));
        s1.b("encrypt 2-->", strEncodeToString);
        return strEncodeToString;
    }

    public static String a(byte[] bArr, String str) {
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

    public static String b(String str, String str2) {
        String strD = d(str);
        if (strD.length() == f15107g.intValue()) {
            try {
                a(strD, 1);
                return a(a.doFinal(str2.getBytes("UTF-8")));
            } catch (Exception e2) {
                throw new RuntimeException("AESUtil:encrypt fail!", e2);
            }
        }
        throw new RuntimeException("AESUtil:Invalid AES secretKey length (must be 16 bytes)");
    }

    public static byte[] a(String str, String str2, byte b2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        String[] strArrSplit = str.split(str2);
        int length = strArrSplit.length;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            try {
                bArr[i2] = Byte.parseByte(strArrSplit[i2]);
            } catch (Exception unused) {
                bArr[i2] = b2;
            }
        }
        return bArr;
    }

    private static byte[] b(String str) {
        byte[] bArr = new byte[str.length() / 2];
        int i2 = 0;
        while (i2 < str.length()) {
            int i3 = i2 + 2;
            bArr[i2 / 2] = (byte) Integer.parseInt(str.substring(i2, i3), 16);
            i2 = i3;
        }
        return bArr;
    }

    public static String a(String str, String str2, String str3) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("UTF-8"), f15103c);
        Cipher cipher = Cipher.getInstance(f15105e);
        cipher.init(2, secretKeySpec, new IvParameterSpec(str3.getBytes("UTF-8")));
        return new String(cipher.doFinal(Base64.decode(str, 0)), "UTF-8");
    }

    public static String a(String str, String str2) {
        String strD = d(str);
        if (strD.length() == f15107g.intValue()) {
            try {
                a(strD, 2);
                return new String(a.doFinal(b(str2)), "UTF-8");
            } catch (Exception e2) {
                throw new RuntimeException("AESUtil:decrypt fail!", e2);
            }
        }
        throw new RuntimeException("AESUtil:Invalid AES secretKey length (must be 16 bytes)");
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            sb.append(String.format("%02X", Byte.valueOf(b2)));
        }
        return sb.toString();
    }

    public static void a(String str, int i2) {
        try {
            SecureRandom secureRandom = SecureRandom.getInstance(f15104d);
            secureRandom.setSeed(str.getBytes());
            KeyGenerator.getInstance(f15103c).init(f15106f.intValue(), secureRandom);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), f15103c);
            a = Cipher.getInstance(f15105e);
            a.init(i2, secretKeySpec, new IvParameterSpec(d(str).getBytes()));
        } catch (Exception e2) {
            throw new RuntimeException("AESUtil:initParam fail!", e2);
        }
    }
}
