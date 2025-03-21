package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
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
import p286h.C5230f1;

/* loaded from: classes.dex */
public class BksUtil {

    /* renamed from: a */
    private static final String f8218a = "BksUtil";

    /* renamed from: b */
    private static final String f8219b = "com.huawei.hwid";

    /* renamed from: c */
    private static final String f8220c = "com.huawei.hwid";

    /* renamed from: d */
    private static final String f8221d = "com.huawei.hms";

    /* renamed from: e */
    private static final String f8222e = "com.huawei.hwid.tv";

    /* renamed from: g */
    private static final String f8224g = "files/hmsrootcas.bks";

    /* renamed from: h */
    private static final String f8225h = "4.0.2.300";

    /* renamed from: i */
    private static final String f8226i = "aegis";

    /* renamed from: j */
    private static final String f8227j = "hmsrootcas.bks";

    /* renamed from: k */
    private static final long f8228k = 604800000;

    /* renamed from: l */
    private static final String f8229l = "last_update_time";

    /* renamed from: m */
    private static final String f8230m = "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05";

    /* renamed from: n */
    private static final String f8231n = "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C";

    /* renamed from: o */
    private static final String f8232o = "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539";

    /* renamed from: q */
    private static final String f8234q = "";

    /* renamed from: r */
    private static final String f8235r = "bks_hash";

    /* renamed from: f */
    private static final Uri f8223f = Uri.parse("content://com.huawei.hwid");

    /* renamed from: p */
    private static final String[] f8233p = {"B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05", "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539"};

    private BksUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* renamed from: a */
    private static void m7945a(InputStream inputStream, Context context) {
        ?? r2;
        if (inputStream == null || context == null) {
            return;
        }
        String m7943a = m7943a(context);
        if (!new File(m7943a).exists()) {
            m7942a(m7943a);
        }
        File file = new File(m7943a, "hmsrootcas.bks");
        if (file.exists()) {
            file.delete();
        }
        byte[] bArr = null;
        ?? r6 = 0;
        try {
            try {
                C2563e.m7987c(f8218a, "write output stream ");
                r2 = new FileOutputStream(file);
                try {
                    byte[] bArr2 = new byte[2048];
                    while (true) {
                        int read = inputStream.read(bArr2, 0, bArr2.length);
                        if (read == -1) {
                            break;
                        } else {
                            r2.write(bArr2, 0, read);
                        }
                    }
                    AbstractC2562d.m7978a((OutputStream) r2);
                    bArr = bArr2;
                } catch (IOException unused) {
                    r6 = r2;
                    C2563e.m7986b(f8218a, " IOException");
                    AbstractC2562d.m7978a((OutputStream) r6);
                    bArr = r6;
                } catch (Throwable th) {
                    th = th;
                    AbstractC2562d.m7978a((OutputStream) r2);
                    throw th;
                }
            } catch (IOException unused2) {
            }
        } catch (Throwable th2) {
            th = th2;
            r2 = bArr;
        }
    }

    /* renamed from: a */
    private static boolean m7946a(int i2) {
        return i2 >= 40002300;
    }

    /* renamed from: b */
    private static String m7948b(Context context) {
        return m7943a(context) + File.separator + "hmsrootcas.bks";
    }

    /* renamed from: c */
    private static boolean m7953c(Context context) {
        return new File(m7943a(context) + File.separator + "hmsrootcas.bks").exists();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.OutputStream] */
    public static synchronized InputStream getBksFromTss(Context context) {
        ByteArrayInputStream byteArrayInputStream;
        InputStream inputStream;
        ?? r2;
        String m7994a;
        String m7949b;
        synchronized (BksUtil.class) {
            C2563e.m7987c(f8218a, "get bks from tss begin");
            if (context != null) {
                ContextUtil.setContext(context);
            }
            Context contextUtil = ContextUtil.getInstance();
            ByteArrayInputStream byteArrayInputStream2 = null;
            if (contextUtil == null) {
                C2563e.m7986b(f8218a, "context is null");
                return null;
            }
            if (!m7951b(C2564f.m7990a("com.huawei.hwid")) && !m7951b(C2564f.m7990a("com.huawei.hms"))) {
                C2563e.m7986b(f8218a, "hms version code is too low : " + C2564f.m7990a("com.huawei.hwid"));
                return null;
            }
            boolean m7954c = m7954c(contextUtil, "com.huawei.hwid");
            boolean z = m7954c;
            if (!m7954c) {
                boolean m7950b = m7950b(contextUtil, "com.huawei.hms");
                z = m7950b;
                if (!m7950b) {
                    C2563e.m7986b(f8218a, "hms sign error");
                    return null;
                }
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    inputStream = contextUtil.getContentResolver().openInputStream(Uri.withAppendedPath(f8223f, f8224g));
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read <= -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        byteArrayOutputStream.flush();
                        byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                        try {
                            m7994a = C2565g.m7994a(f8235r, "", contextUtil);
                            m7949b = m7949b(byteArrayOutputStream.toByteArray());
                        } catch (Exception e2) {
                            e = e2;
                            byteArrayInputStream2 = byteArrayInputStream;
                            C2563e.m7986b(f8218a, "Get bks from HMS_VERSION_CODE exception : No content provider" + e.getMessage());
                            AbstractC2562d.m7977a(inputStream);
                            AbstractC2562d.m7978a((OutputStream) byteArrayOutputStream);
                            AbstractC2562d.m7977a((InputStream) byteArrayInputStream2);
                            return getFilesBksIS(contextUtil);
                        } catch (Throwable th) {
                            th = th;
                            r2 = byteArrayOutputStream;
                            AbstractC2562d.m7977a(inputStream);
                            AbstractC2562d.m7978a((OutputStream) r2);
                            AbstractC2562d.m7977a((InputStream) byteArrayInputStream);
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                } catch (Exception e4) {
                    e = e4;
                    inputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = null;
                    byteArrayInputStream = null;
                    r2 = byteArrayOutputStream;
                }
                if (m7953c(contextUtil) && m7994a.equals(m7949b)) {
                    C2563e.m7987c(f8218a, "bks not update");
                    AbstractC2562d.m7977a(inputStream);
                    AbstractC2562d.m7978a((OutputStream) byteArrayOutputStream);
                    AbstractC2562d.m7977a((InputStream) byteArrayInputStream);
                    return getFilesBksIS(contextUtil);
                }
                C2563e.m7987c(f8218a, "update bks and sp");
                m7945a(byteArrayInputStream, contextUtil);
                C2565g.m8000b(f8235r, m7949b, contextUtil);
                AbstractC2562d.m7977a(inputStream);
                AbstractC2562d.m7978a((OutputStream) byteArrayOutputStream);
                AbstractC2562d.m7977a((InputStream) byteArrayInputStream);
                return getFilesBksIS(contextUtil);
            } catch (Throwable th3) {
                th = th3;
                byteArrayInputStream = null;
                r2 = z;
            }
        }
    }

    public static InputStream getFilesBksIS(Context context) {
        if (!m7953c(context)) {
            return null;
        }
        C2563e.m7987c(f8218a, "getFilesBksIS ");
        try {
            return new FileInputStream(m7948b(context));
        } catch (FileNotFoundException unused) {
            C2563e.m7986b(f8218a, "FileNotFoundExceptio: ");
            return null;
        }
    }

    /* renamed from: b */
    private static boolean m7951b(String str) {
        int parseInt;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        C2563e.m7987c(f8218a, "hms version code is : " + str);
        String[] split = str.split("\\.");
        String[] split2 = f8225h.split("\\.");
        int length = split.length;
        int length2 = split2.length;
        int max = Math.max(length, length2);
        int i2 = 0;
        while (i2 < max) {
            if (i2 < length) {
                try {
                    parseInt = Integer.parseInt(split[i2]);
                } catch (Exception e2) {
                    C2563e.m7986b(f8218a, " exception : " + e2.getMessage());
                    return i2 >= length2;
                }
            } else {
                parseInt = 0;
            }
            int parseInt2 = i2 < length2 ? Integer.parseInt(split2[i2]) : 0;
            if (parseInt < parseInt2) {
                return false;
            }
            if (parseInt > parseInt2) {
                return true;
            }
            i2++;
        }
        return true;
    }

    /* renamed from: c */
    private static boolean m7954c(Context context, String str) {
        byte[] m7947a = m7947a(context, str);
        for (String str2 : f8233p) {
            if (str2.equalsIgnoreCase(m7952c(m7947a))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private static String m7952c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return m7944a(MessageDigest.getInstance("SHA-256").digest(bArr));
        } catch (NoSuchAlgorithmException e2) {
            String str = "NoSuchAlgorithmException" + e2.getMessage();
            return "";
        }
    }

    /* renamed from: b */
    private static boolean m7950b(Context context, String str) {
        return "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539".equalsIgnoreCase(m7952c(m7947a(context, str)));
    }

    /* renamed from: b */
    private static String m7949b(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            return m7944a(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            C2563e.m7986b(f8218a, "inputstraem exception");
            return "";
        }
    }

    /* renamed from: a */
    private static int m7942a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        File file = new File(str);
        if (file.exists()) {
            C2563e.m7989e(f8218a, "The directory  has already exists");
            return 1;
        }
        if (file.mkdirs()) {
            C2563e.m7984a(f8218a, "create directory  success");
            return 0;
        }
        C2563e.m7986b(f8218a, "create directory  failed");
        return -1;
    }

    /* renamed from: a */
    private static String m7943a(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.createDeviceProtectedStorageContext().getFilesDir() + File.separator + f8226i;
        }
        return context.getApplicationContext().getFilesDir() + File.separator + f8226i;
    }

    /* renamed from: a */
    private static byte[] m7947a(Context context, String str) {
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

    /* renamed from: a */
    private static String m7944a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & C5230f1.f20085c);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }
}
