package com.alibaba.sdk.android.oss.common.utils;

import android.util.Base64;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import p286h.C5230f1;

/* loaded from: classes.dex */
public class BinaryUtil {
    public static String calculateBase64Md5(byte[] bArr) {
        return toBase64String(calculateMd5(bArr));
    }

    public static byte[] calculateMd5(FileDescriptor fileDescriptor) throws IOException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[10240];
            FileInputStream fileInputStream = new FileInputStream(fileDescriptor);
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    fileInputStream.close();
                    return messageDigest.digest();
                }
                messageDigest.update(bArr, 0, read);
            }
        } catch (NoSuchAlgorithmException unused) {
            throw new RuntimeException("MD5 algorithm not found.");
        }
    }

    public static String calculateMd5Str(byte[] bArr) {
        return getMd5StrFromBytes(calculateMd5(bArr));
    }

    private static String convertHashToString(byte[] bArr) {
        String str = "";
        for (byte b2 : bArr) {
            str = str + Integer.toString((b2 & C5230f1.f20085c) + 256, 16).substring(1);
        }
        return str.toLowerCase();
    }

    public static String fileToSHA1(String str) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Exception unused) {
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            int i2 = 0;
            while (i2 != -1) {
                i2 = fileInputStream.read(bArr);
                if (i2 > 0) {
                    messageDigest.update(bArr, 0, i2);
                }
            }
            String convertHashToString = convertHashToString(messageDigest.digest());
            try {
                fileInputStream.close();
            } catch (Exception unused2) {
            }
            return convertHashToString;
        } catch (Exception unused3) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception unused4) {
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception unused5) {
                }
            }
            throw th;
        }
    }

    public static byte[] fromBase64String(String str) {
        return Base64.decode(str, 0);
    }

    public static String getMd5StrFromBytes(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b2)));
        }
        return sb.toString();
    }

    public static String toBase64String(byte[] bArr) {
        return new String(Base64.encode(bArr, 0)).trim();
    }

    public static String calculateBase64Md5(String str) throws IOException {
        return toBase64String(calculateMd5(str));
    }

    public static String calculateMd5Str(String str) throws IOException {
        return getMd5StrFromBytes(calculateMd5(str));
    }

    public static String calculateBase64Md5(FileDescriptor fileDescriptor) throws IOException {
        return toBase64String(calculateMd5(fileDescriptor));
    }

    public static String calculateMd5Str(FileDescriptor fileDescriptor) throws IOException {
        return getMd5StrFromBytes(calculateMd5(fileDescriptor));
    }

    public static byte[] calculateMd5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException unused) {
            throw new RuntimeException("MD5 algorithm not found.");
        }
    }

    public static String fileToSHA1(FileDescriptor fileDescriptor) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(fileDescriptor);
        } catch (Exception unused) {
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            int i2 = 0;
            while (i2 != -1) {
                i2 = fileInputStream.read(bArr);
                if (i2 > 0) {
                    messageDigest.update(bArr, 0, i2);
                }
            }
            String convertHashToString = convertHashToString(messageDigest.digest());
            try {
                fileInputStream.close();
            } catch (Exception unused2) {
            }
            return convertHashToString;
        } catch (Exception unused3) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception unused4) {
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception unused5) {
                }
            }
            throw th;
        }
    }

    public static byte[] calculateMd5(String str) throws IOException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[10240];
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return messageDigest.digest();
                }
            }
        } catch (NoSuchAlgorithmException unused) {
            throw new RuntimeException("MD5 algorithm not found.");
        }
    }
}
