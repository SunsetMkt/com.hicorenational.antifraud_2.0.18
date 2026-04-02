package com.huawei.hms.framework.common;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.libcore.io.ExternalStorageFile;
import com.huawei.libcore.io.ExternalStorageFileInputStream;
import com.huawei.libcore.io.ExternalStorageFileOutputStream;
import com.huawei.libcore.io.ExternalStorageRandomAccessFile;
import com.umeng.analytics.pro.cw;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
public class CreateFileUtil {
    private static final String EXTERNAL_FILE_NAME = "com.huawei.libcore.io.ExternalStorageFile";
    private static final String EXTERNAL_INPUTSTREAM_NAME = "com.huawei.libcore.io.ExternalStorageFileInputStream";
    private static final String EXTERNAL_OUTPUTSTREAM_NAME = "com.huawei.libcore.io.ExternalStorageFileOutputStream";
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final String RANDOM_ACCESS_FILE_NAME = "com.huawei.libcore.io.ExternalStorageRandomAccessFile";
    private static final String TAG = "CreateFileUtil";

    public static String byteArrayToHex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        int i2 = 0;
        for (byte b2 : bArr) {
            int i3 = i2 + 1;
            char[] cArr2 = HEX_DIGITS;
            cArr[i2] = cArr2[(b2 >>> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = cArr2[b2 & cw.f7205m];
        }
        return new String(cArr);
    }

    public static void deleteSecure(File file) {
        if (file == null || !file.exists() || file.delete()) {
            return;
        }
        Logger.w(TAG, "deleteSecure exception");
    }

    public static String getCacheDirPath(Context context) {
        return context == null ? "" : ContextCompat.getProtectedStorageContext(context).getCacheDir().getPath();
    }

    public static String getCanonicalPath(String str) {
        try {
            return newFile(str).getCanonicalPath();
        } catch (IOException e2) {
            Logger.w(TAG, "the canonicalPath has IOException", e2);
            return str;
        } catch (SecurityException e3) {
            Logger.w(TAG, "the canonicalPath has securityException", e3);
            return str;
        } catch (Exception e4) {
            Logger.w(TAG, "the canonicalPath has other Exception", e4);
            return str;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0030 A[EXC_TOP_SPLITTER, PHI: r2 r10
  0x0030: PHI (r2v6 java.lang.String) = 
  (r2v0 java.lang.String)
  (r2v0 java.lang.String)
  (r2v0 java.lang.String)
  (r2v0 java.lang.String)
  (r2v0 java.lang.String)
  (r2v13 java.lang.String)
 binds: [B:53:0x0076, B:34:0x0050, B:39:0x005a, B:44:0x0064, B:49:0x006e, B:12:0x002e] A[DONT_GENERATE, DONT_INLINE]
  0x0030: PHI (r10v13 java.io.FileInputStream) = 
  (r10v8 java.io.FileInputStream)
  (r10v9 java.io.FileInputStream)
  (r10v10 java.io.FileInputStream)
  (r10v11 java.io.FileInputStream)
  (r10v12 java.io.FileInputStream)
  (r10v14 java.io.FileInputStream)
 binds: [B:53:0x0076, B:34:0x0050, B:39:0x005a, B:44:0x0064, B:49:0x006e, B:12:0x002e] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.io.FileInputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getFileHashData(String str, String str2) throws Throwable {
        FileInputStream fileInputStreamNewSafeFileInputStream;
        MessageDigest messageDigest;
        byte[] bArr;
        long j2;
        try {
            try {
                messageDigest = MessageDigest.getInstance(str2);
                fileInputStreamNewSafeFileInputStream = newSafeFileInputStream(str);
            } catch (FileNotFoundException e2) {
                e = e2;
                fileInputStreamNewSafeFileInputStream = null;
            } catch (IOException e3) {
                e = e3;
                fileInputStreamNewSafeFileInputStream = null;
            } catch (IllegalArgumentException e4) {
                e = e4;
                fileInputStreamNewSafeFileInputStream = null;
            } catch (IndexOutOfBoundsException e5) {
                e = e5;
                fileInputStreamNewSafeFileInputStream = null;
            } catch (NoSuchAlgorithmException e6) {
                e = e6;
                fileInputStreamNewSafeFileInputStream = null;
            } catch (Throwable th) {
                th = th;
                str = 0;
                if (str != 0) {
                }
                throw th;
            }
            try {
                bArr = new byte[1024];
                j2 = 0;
            } catch (FileNotFoundException e7) {
                e = e7;
                Logger.e(TAG, "getFileHashData FileNotFoundException", e);
                if (fileInputStreamNewSafeFileInputStream != null) {
                    try {
                        fileInputStreamNewSafeFileInputStream.close();
                    } catch (IOException unused) {
                        Logger.e(TAG, "Close FileInputStream failed!");
                    }
                }
            } catch (IOException e8) {
                e = e8;
                Logger.e(TAG, "getFileHashData IOException", e);
                if (fileInputStreamNewSafeFileInputStream != null) {
                    fileInputStreamNewSafeFileInputStream.close();
                }
            } catch (IllegalArgumentException e9) {
                e = e9;
                Logger.e(TAG, "getFileHashData IllegalArgumentException", e);
                if (fileInputStreamNewSafeFileInputStream != null) {
                    fileInputStreamNewSafeFileInputStream.close();
                }
            } catch (IndexOutOfBoundsException e10) {
                e = e10;
                Logger.e(TAG, "getFileHashData IndexOutOfBoundsException", e);
                if (fileInputStreamNewSafeFileInputStream != null) {
                    fileInputStreamNewSafeFileInputStream.close();
                }
            } catch (NoSuchAlgorithmException e11) {
                e = e11;
                Logger.e(TAG, "getFileHashData NoSuchAlgorithmException", e);
                if (fileInputStreamNewSafeFileInputStream != null) {
                }
            }
            while (true) {
                int i2 = fileInputStreamNewSafeFileInputStream.read(bArr);
                if (i2 == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, i2);
                j2 += (long) i2;
                return strByteArrayToHex;
            }
            strByteArrayToHex = j2 > 0 ? byteArrayToHex(messageDigest.digest()) : null;
            if (fileInputStreamNewSafeFileInputStream != null) {
                fileInputStreamNewSafeFileInputStream.close();
            }
            return strByteArrayToHex;
        } catch (Throwable th2) {
            th = th2;
            if (str != 0) {
                try {
                    str.close();
                } catch (IOException unused2) {
                    Logger.e(TAG, "Close FileInputStream failed!");
                }
            }
            throw th;
        }
    }

    @Deprecated
    public static boolean isPVersion() {
        return EmuiUtil.isUpPVersion();
    }

    public static File newFile(String str) {
        if (str == null) {
            return null;
        }
        return (EmuiUtil.isUpPVersion() && ReflectionUtils.checkCompatible(EXTERNAL_FILE_NAME)) ? new ExternalStorageFile(str) : new File(str);
    }

    public static FileInputStream newFileInputStream(String str) throws FileNotFoundException {
        if (str != null) {
            return (EmuiUtil.isUpPVersion() && ReflectionUtils.checkCompatible(EXTERNAL_INPUTSTREAM_NAME)) ? new ExternalStorageFileInputStream(str) : new FileInputStream(str);
        }
        Logger.w(TAG, "newFileInputStream  file is null");
        throw new FileNotFoundException("file is null");
    }

    public static FileOutputStream newFileOutputStream(File file) throws FileNotFoundException {
        if (file != null) {
            return (EmuiUtil.isUpPVersion() && ReflectionUtils.checkCompatible(EXTERNAL_OUTPUTSTREAM_NAME)) ? new ExternalStorageFileOutputStream(file) : new FileOutputStream(file);
        }
        Logger.e(TAG, "newFileOutputStream  file is null");
        throw new FileNotFoundException("file is null");
    }

    public static RandomAccessFile newRandomAccessFile(String str, String str2) throws FileNotFoundException {
        if (str != null) {
            return (EmuiUtil.isUpPVersion() && ReflectionUtils.checkCompatible(RANDOM_ACCESS_FILE_NAME)) ? new ExternalStorageRandomAccessFile(str, str2) : new RandomAccessFile(str, str2);
        }
        Logger.w(TAG, "newFileOutputStream  file is null");
        throw new FileNotFoundException("file is null");
    }

    public static File newSafeFile(String str) {
        if (str == null) {
            return null;
        }
        try {
            File fileNewFile = newFile(str);
            return !fileNewFile.exists() ? new File(str) : fileNewFile;
        } catch (RuntimeException unused) {
            Logger.w(TAG, "newFile is runtimeException");
            return new File(str);
        } catch (Throwable unused2) {
            Logger.w(TAG, "newFile is Throwable");
            return new File(str);
        }
    }

    public static FileInputStream newSafeFileInputStream(String str) throws FileNotFoundException {
        try {
            return newFileInputStream(str);
        } catch (FileNotFoundException unused) {
            Logger.w(TAG, "newFileInputStream is fileNotFoundException");
            return new FileInputStream(str);
        } catch (RuntimeException unused2) {
            Logger.w(TAG, "newFileInputStream is runtimeException");
            return new FileInputStream(str);
        } catch (Throwable unused3) {
            Logger.w(TAG, "newFileInputStream is Throwable");
            return new FileInputStream(str);
        }
    }

    public static FileOutputStream newSafeFileOutputStream(File file) throws FileNotFoundException {
        try {
            return newFileOutputStream(file);
        } catch (FileNotFoundException unused) {
            Logger.w(TAG, "newFileOutputStream is fileNotFoundException");
            return new FileOutputStream(file);
        } catch (RuntimeException unused2) {
            Logger.w(TAG, "newFileOutputStream is runtimeException");
            return new FileOutputStream(file);
        } catch (Throwable unused3) {
            Logger.w(TAG, "newFileOutputStream is Throwable");
            return new FileOutputStream(file);
        }
    }

    public static RandomAccessFile newSafeRandomAccessFile(String str, String str2) throws FileNotFoundException {
        if (str == null) {
            Logger.w(TAG, "newRandomAccessFile  file is null");
            throw new FileNotFoundException("file is null");
        }
        try {
            return newRandomAccessFile(str, str2);
        } catch (FileNotFoundException unused) {
            Logger.w(TAG, "newRandomAccessFile is fileNotFoundException");
            return new RandomAccessFile(str, str2);
        } catch (RuntimeException unused2) {
            Logger.w(TAG, "newRandomAccessFile is runtimeException");
            return new RandomAccessFile(str, str2);
        } catch (Throwable unused3) {
            Logger.w(TAG, "newRandomAccessFile is Throwable");
            return new RandomAccessFile(str, str2);
        }
    }

    public static void deleteSecure(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        deleteSecure(newFile(str));
    }
}
