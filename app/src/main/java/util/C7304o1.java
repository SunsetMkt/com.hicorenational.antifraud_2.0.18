package util;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import p286h.C5230f1;

/* compiled from: MD5Utils.java */
/* renamed from: util.o1 */
/* loaded from: classes2.dex */
public class C7304o1 {
    /* renamed from: a */
    public static String m26467a(String str) {
        return m26470b(str).toLowerCase();
    }

    /* renamed from: b */
    public static String m26470b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i2 = 0; i2 < charArray.length; i2++) {
                bArr[i2] = (byte) charArray[i2];
            }
            byte[] digest = messageDigest.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                int i3 = b2 & C5230f1.f20085c;
                if (i3 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i3));
            }
            return stringBuffer.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static String m26466a(File file) {
        int i2;
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr, 0, 1024);
                if (read == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
            }
            fileInputStream.close();
            String bigInteger = new BigInteger(1, messageDigest.digest()).toString(16);
            int length = bigInteger.length();
            if (length >= 32) {
                return bigInteger;
            }
            int i3 = 32 - length;
            String str = "";
            for (i2 = 0; i2 < i3; i2++) {
                str = "0" + str;
            }
            return str + bigInteger;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public static String m26469b(File file) {
        FileInputStream fileInputStream;
        int i2;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                    byte[] bArr = new byte[10485760];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                    String bigInteger = new BigInteger(1, messageDigest.digest()).toString(16);
                    int length = 40 - bigInteger.length();
                    if (length > 0) {
                        for (i2 = 0; i2 < length; i2++) {
                            bigInteger = "0" + bigInteger;
                        }
                    }
                    try {
                        fileInputStream.close();
                    } catch (Exception unused) {
                    }
                    return bigInteger;
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                    System.out.println(e);
                    if (fileInputStream2 == null) {
                        return "";
                    }
                    try {
                        fileInputStream2.close();
                        return "";
                    } catch (Exception unused2) {
                        return "";
                    }
                } catch (Throwable th) {
                    th = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    /* renamed from: a */
    public static Map<String, String> m26468a(File file, boolean z) {
        if (!file.isDirectory()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory() && z) {
                hashMap.putAll(m26468a(file2, z));
            } else {
                String m26466a = m26466a(file2);
                if (m26466a != null) {
                    hashMap.put(file2.getPath(), m26466a);
                }
            }
        }
        return hashMap;
    }
}
