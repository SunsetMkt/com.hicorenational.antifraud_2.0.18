package com.huawei.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.C2550a;
import com.huawei.secure.android.common.encrypt.utils.C2551b;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public abstract class FileSHA256 {

    /* renamed from: a */
    private static final int f8036a = 8192;

    /* renamed from: c */
    private static final String f8038c = "FileSHA256";

    /* renamed from: d */
    private static final String f8039d = "";

    /* renamed from: b */
    private static final String f8037b = "SHA-256";

    /* renamed from: e */
    private static final String[] f8040e = {f8037b, "SHA-384", "SHA-512"};

    /* renamed from: a */
    private static boolean m7848a(File file) {
        return file != null && file.exists() && file.length() > 0;
    }

    public static String fileSHA256Encrypt(File file) {
        return fileSHAEncrypt(file, f8037b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.InputStream] */
    public static String fileSHAEncrypt(File file, String str) {
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        ?? r1 = "";
        if (TextUtils.isEmpty(str) || !m7849a(str)) {
            C2551b.m7898b(f8038c, "algorithm is empty or not safe");
            return "";
        }
        if (!m7848a(file)) {
            C2551b.m7898b(f8038c, "file is not valid");
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
                C2550a.m7889a((InputStream) r1);
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
                C2550a.m7889a((InputStream) fileInputStream);
            } catch (IOException e4) {
                e = e4;
                C2551b.m7898b(f8038c, "IOException" + e.getMessage());
                C2550a.m7889a((InputStream) fileInputStream);
                return r0;
            } catch (NoSuchAlgorithmException e5) {
                e = e5;
                C2551b.m7898b(f8038c, "NoSuchAlgorithmException" + e.getMessage());
                C2550a.m7889a((InputStream) fileInputStream);
                return r0;
            }
            return r0;
        } catch (Throwable th2) {
            th = th2;
            C2550a.m7889a((InputStream) r1);
            throw th;
        }
    }

    public static String inputStreamSHA256Encrypt(InputStream inputStream) {
        return inputStream == null ? "" : inputStreamSHAEncrypt(inputStream, f8037b);
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
            C2551b.m7898b(f8038c, "inputstraem exception");
            return "";
        } finally {
            C2550a.m7889a(inputStream);
        }
    }

    public static boolean validateFileSHA(File file, String str, String str2) {
        if (!TextUtils.isEmpty(str) && m7849a(str2)) {
            return str.equals(fileSHAEncrypt(file, str2));
        }
        C2551b.m7898b(f8038c, "hash value is null || algorithm is illegal");
        return false;
    }

    public static boolean validateFileSHA256(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equalsIgnoreCase(fileSHA256Encrypt(file));
    }

    public static boolean validateInputStreamSHA(InputStream inputStream, String str, String str2) {
        if (!TextUtils.isEmpty(str) && m7849a(str2)) {
            return str.equals(inputStreamSHAEncrypt(inputStream, str2));
        }
        C2551b.m7898b(f8038c, "hash value is null || algorithm is illegal");
        return false;
    }

    public static boolean validateInputStreamSHA256(InputStream inputStream, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(inputStreamSHA256Encrypt(inputStream));
    }

    /* renamed from: a */
    private static boolean m7849a(String str) {
        for (String str2 : f8040e) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
