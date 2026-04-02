package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import i.f1;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
public class BksUtil {
    private static final String a = "BksUtil";

    /* JADX INFO: renamed from: b */
    private static final String f5203b = "com.huawei.hwid";

    /* JADX INFO: renamed from: c */
    private static final String f5204c = "com.huawei.hwid";

    /* JADX INFO: renamed from: d */
    private static final String f5205d = "com.huawei.hms";

    /* JADX INFO: renamed from: e */
    private static final String f5206e = "com.huawei.hwid.tv";

    /* JADX INFO: renamed from: g */
    private static final String f5208g = "files/hmsrootcas.bks";

    /* JADX INFO: renamed from: h */
    private static final String f5209h = "4.0.2.300";

    /* JADX INFO: renamed from: i */
    private static final String f5210i = "aegis";

    /* JADX INFO: renamed from: j */
    private static final String f5211j = "hmsrootcas.bks";

    /* JADX INFO: renamed from: k */
    private static final long f5212k = 604800000;

    /* JADX INFO: renamed from: l */
    private static final String f5213l = "last_update_time";

    /* JADX INFO: renamed from: m */
    private static final String f5214m = "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05";

    /* JADX INFO: renamed from: n */
    private static final String f5215n = "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C";
    private static final String o = "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539";
    private static final String q = "";
    private static final String r = "bks_hash";

    /* JADX INFO: renamed from: f */
    private static final Uri f5207f = Uri.parse("content://com.huawei.hwid");
    private static final String[] p = {"B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05", "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539"};

    private BksUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v8 */
    private static void a(InputStream inputStream, Context context) throws Throwable {
        ?? fileOutputStream;
        if (inputStream == null || context == null) {
            return;
        }
        String strA = a(context);
        if (!new File(strA).exists()) {
            a(strA);
        }
        File file = new File(strA, "hmsrootcas.bks");
        if (file.exists()) {
            file.delete();
        }
        ?? r6 = 0;
        ?? r62 = 0;
        try {
            try {
                e.c(a, "write output stream ");
                fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int i2 = inputStream.read(bArr, 0, bArr.length);
                        if (i2 == -1) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, i2);
                        }
                    }
                    d.a((OutputStream) fileOutputStream);
                    r6 = bArr;
                } catch (IOException unused) {
                    r62 = fileOutputStream;
                    e.b(a, " IOException");
                    d.a((OutputStream) r62);
                    r6 = r62;
                } catch (Throwable th) {
                    th = th;
                    d.a((OutputStream) fileOutputStream);
                    throw th;
                }
            } catch (IOException unused2) {
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = r6;
        }
    }

    private static boolean a(int i2) {
        return i2 >= 40002300;
    }

    private static String b(Context context) {
        return a(context) + File.separator + "hmsrootcas.bks";
    }

    private static boolean c(Context context) {
        return new File(a(context) + File.separator + "hmsrootcas.bks").exists();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:139|99|143|100|101|(2:140|102)|(8:103|(1:105)(1:145)|125|126|127|128|129|130)|106|142|107|(1:113)(1:112)|114|128|129|130) */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x00de, code lost:
    
        r9 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x00df, code lost:
    
        r2 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x00e0, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x00e1, code lost:
    
        r4 = r1;
        r1 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0118, code lost:
    
        com.huawei.secure.android.common.ssl.util.d.a(r3);
        com.huawei.secure.android.common.ssl.util.d.a((java.io.OutputStream) r2);
        com.huawei.secure.android.common.ssl.util.d.a((java.io.InputStream) r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0121, code lost:
    
        throw r9;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.OutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized InputStream getBksFromTss(Context context) {
        ByteArrayInputStream byteArrayInputStream;
        InputStream inputStreamOpenInputStream;
        ?? r2;
        byte[] bArr;
        e.c(a, "get bks from tss begin");
        if (context != null) {
            ContextUtil.setContext(context);
        }
        Context contextUtil = ContextUtil.getInstance();
        ByteArrayInputStream byteArrayInputStream2 = null;
        if (contextUtil == null) {
            e.b(a, "context is null");
            return null;
        }
        if (!b(f.a("com.huawei.hwid")) && !b(f.a("com.huawei.hms"))) {
            e.b(a, "hms version code is too low : " + f.a("com.huawei.hwid"));
            return null;
        }
        boolean zC = c(contextUtil, "com.huawei.hwid");
        boolean z = zC;
        if (!zC) {
            boolean zB = b(contextUtil, "com.huawei.hms");
            z = zB;
            if (!zB) {
                e.b(a, "hms sign error");
                return null;
            }
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                inputStreamOpenInputStream = contextUtil.getContentResolver().openInputStream(Uri.withAppendedPath(f5207f, f5208g));
                try {
                    bArr = new byte[1024];
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                inputStreamOpenInputStream = null;
            } catch (Throwable th) {
                th = th;
                inputStreamOpenInputStream = null;
                byteArrayInputStream = null;
                r2 = byteArrayOutputStream;
            }
            while (true) {
                int i2 = inputStreamOpenInputStream.read(bArr);
                if (i2 <= -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
                e.b(a, "Get bks from HMS_VERSION_CODE exception : No content provider" + e.getMessage());
                d.a(inputStreamOpenInputStream);
                d.a((OutputStream) byteArrayOutputStream);
                d.a((InputStream) byteArrayInputStream2);
                return getFilesBksIS(contextUtil);
            }
            byteArrayOutputStream.flush();
            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            String strA = g.a(r, "", contextUtil);
            String strB = b(byteArrayOutputStream.toByteArray());
            if (c(contextUtil) && strA.equals(strB)) {
                e.c(a, "bks not update");
            } else {
                e.c(a, "update bks and sp");
                a(byteArrayInputStream, contextUtil);
                g.b(r, strB, contextUtil);
            }
            d.a(inputStreamOpenInputStream);
            d.a((OutputStream) byteArrayOutputStream);
            d.a((InputStream) byteArrayInputStream);
            return getFilesBksIS(contextUtil);
        } catch (Throwable th2) {
            th = th2;
            byteArrayInputStream = null;
            r2 = z;
        }
    }

    public static InputStream getFilesBksIS(Context context) {
        if (!c(context)) {
            return null;
        }
        e.c(a, "getFilesBksIS ");
        try {
            return new FileInputStream(b(context));
        } catch (FileNotFoundException unused) {
            e.b(a, "FileNotFoundExceptio: ");
            return null;
        }
    }

    private static boolean b(String str) {
        int i2;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        e.c(a, "hms version code is : " + str);
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = f5209h.split("\\.");
        int length = strArrSplit.length;
        int length2 = strArrSplit2.length;
        int iMax = Math.max(length, length2);
        int i3 = 0;
        while (i3 < iMax) {
            if (i3 < length) {
                try {
                    i2 = Integer.parseInt(strArrSplit[i3]);
                } catch (Exception e2) {
                    e.b(a, " exception : " + e2.getMessage());
                    return i3 >= length2;
                }
            } else {
                i2 = 0;
            }
            int i4 = i3 < length2 ? Integer.parseInt(strArrSplit2[i3]) : 0;
            if (i2 < i4) {
                return false;
            }
            if (i2 > i4) {
                return true;
            }
            i3++;
        }
        return true;
    }

    private static boolean c(Context context, String str) {
        byte[] bArrA = a(context, str);
        for (String str2 : p) {
            if (str2.equalsIgnoreCase(c(bArrA))) {
                return true;
            }
        }
        return false;
    }

    private static String c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return a(MessageDigest.getInstance("SHA-256").digest(bArr));
        } catch (NoSuchAlgorithmException e2) {
            String str = "NoSuchAlgorithmException" + e2.getMessage();
            return "";
        }
    }

    private static boolean b(Context context, String str) {
        return "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539".equalsIgnoreCase(c(a(context, str)));
    }

    private static String b(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            e.b(a, "inputstraem exception");
            return "";
        }
    }

    private static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        File file = new File(str);
        if (file.exists()) {
            e.e(a, "The directory  has already exists");
            return 1;
        }
        if (file.mkdirs()) {
            e.a(a, "create directory  success");
            return 0;
        }
        e.b(a, "create directory  failed");
        return -1;
    }

    private static String a(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.createDeviceProtectedStorageContext().getFilesDir() + File.separator + f5210i;
        }
        return context.getApplicationContext().getFilesDir() + File.separator + f5210i;
    }

    private static byte[] a(Context context, String str) {
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(str, 64)) != null) {
                return packageInfo.signatures[0].toByteArray();
            }
        } catch (PackageManager.NameNotFoundException e2) {
            String str2 = "PackageManager.NameNotFoundException : " + e2.getMessage();
        } catch (Exception e3) {
            String str3 = "get pm exception : " + e3.getMessage();
        }
        return new byte[0];
    }

    private static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & f1.f12066c);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }
}
