package com.huawei.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.a;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public abstract class FileSHA256 {

    /* renamed from: a, reason: collision with root package name */
    private static final int f7459a = 8192;

    /* renamed from: c, reason: collision with root package name */
    private static final String f7461c = "FileSHA256";

    /* renamed from: d, reason: collision with root package name */
    private static final String f7462d = "";

    /* renamed from: b, reason: collision with root package name */
    private static final String f7460b = "SHA-256";

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f7463e = {f7460b, "SHA-384", "SHA-512"};

    private static boolean a(File file) {
        return file != null && file.exists() && file.length() > 0;
    }

    public static String fileSHA256Encrypt(File file) {
        return fileSHAEncrypt(file, f7460b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.InputStream] */
    public static String fileSHAEncrypt(File file, String str) {
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        ?? r1 = "";
        if (TextUtils.isEmpty(str) || !a(str)) {
            b.b(f7461c, "algorithm is empty or not safe");
            return "";
        }
        if (!a(file)) {
            b.b(f7461c, "file is not valid");
            return "";
        }
        try {
            try {
                messageDigest = MessageDigest.getInstance(str);
                fileInputStream = new FileInputStream(file);
            } catch (IOException e2) {
                e = e2;
                fileInputStream = null;
            } catch (NoSuchAlgorithmException e3) {
                e = e3;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                r1 = 0;
                a.a((InputStream) r1);
                throw th;
            }
            try {
                byte[] bArr = new byte[8192];
                boolean z = false;
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                    z = true;
                }
                r0 = z ? HexUtil.byteArray2HexStr(messageDigest.digest()) : null;
                a.a((InputStream) fileInputStream);
            } catch (IOException e4) {
                e = e4;
                b.b(f7461c, "IOException" + e.getMessage());
                a.a((InputStream) fileInputStream);
                return r0;
            } catch (NoSuchAlgorithmException e5) {
                e = e5;
                b.b(f7461c, "NoSuchAlgorithmException" + e.getMessage());
                a.a((InputStream) fileInputStream);
                return r0;
            }
            return r0;
        } catch (Throwable th2) {
            th = th2;
            a.a((InputStream) r1);
            throw th;
        }
    }

    public static String inputStreamSHA256Encrypt(InputStream inputStream) {
        return inputStream == null ? "" : inputStreamSHAEncrypt(inputStream, f7460b);
    }

    public static String inputStreamSHAEncrypt(InputStream inputStream, String str) {
        if (inputStream == null) {
            return "";
        }
        byte[] bArr = new byte[8192];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            while (true) {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    return HexUtil.byteArray2HexStr(messageDigest.digest());
                }
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                }
            }
        } catch (IOException | NoSuchAlgorithmException unused) {
            b.b(f7461c, "inputstraem exception");
            return "";
        } finally {
            a.a(inputStream);
        }
    }

    public static boolean validateFileSHA(File file, String str, String str2) {
        if (!TextUtils.isEmpty(str) && a(str2)) {
            return str.equals(fileSHAEncrypt(file, str2));
        }
        b.b(f7461c, "hash value is null || algorithm is illegal");
        return false;
    }

    public static boolean validateFileSHA256(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equalsIgnoreCase(fileSHA256Encrypt(file));
    }

    public static boolean validateInputStreamSHA(InputStream inputStream, String str, String str2) {
        if (!TextUtils.isEmpty(str) && a(str2)) {
            return str.equals(inputStreamSHAEncrypt(inputStream, str2));
        }
        b.b(f7461c, "hash value is null || algorithm is illegal");
        return false;
    }

    public static boolean validateInputStreamSHA256(InputStream inputStream, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(inputStreamSHA256Encrypt(inputStream));
    }

    private static boolean a(String str) {
        for (String str2 : f7463e) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
