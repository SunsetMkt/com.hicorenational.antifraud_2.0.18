package com.tencent.bugly.crashreport.common.info;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.tencent.bugly.proguard.C3151an;
import com.tencent.bugly.proguard.C3154aq;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class AppInfo {

    /* renamed from: a */
    public static final String[] f10127a = "@buglyAllChannel@".split(Constants.ACCEPT_TIME_SEPARATOR_SP);

    /* renamed from: b */
    public static final String[] f10128b = "@buglyAllChannelPriority@".split(Constants.ACCEPT_TIME_SEPARATOR_SP);

    /* renamed from: c */
    private static ActivityManager f10129c;

    /* renamed from: a */
    public static String m9516a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageName();
        } catch (Throwable th) {
            if (C3151an.m9916a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    /* renamed from: b */
    public static PackageInfo m9521b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(m9516a(context), 0);
        } catch (Throwable th) {
            if (C3151an.m9916a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    public static String m9522c(Context context) {
        CharSequence applicationLabel;
        if (context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (packageManager != null && applicationInfo != null && (applicationLabel = packageManager.getApplicationLabel(applicationInfo)) != null) {
                return applicationLabel.toString();
            }
        } catch (Throwable th) {
            if (!C3151an.m9916a(th)) {
                th.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: d */
    public static Map<String, String> m9523d(Context context) {
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            Object obj = applicationInfo.metaData.get("BUGLY_DISABLE");
            if (obj != null) {
                hashMap.put("BUGLY_DISABLE", obj.toString());
            }
            Object obj2 = applicationInfo.metaData.get("BUGLY_APPID");
            if (obj2 != null) {
                hashMap.put("BUGLY_APPID", obj2.toString());
            }
            Object obj3 = applicationInfo.metaData.get("BUGLY_APP_CHANNEL");
            if (obj3 != null) {
                hashMap.put("BUGLY_APP_CHANNEL", obj3.toString());
            }
            Object obj4 = applicationInfo.metaData.get("BUGLY_APP_VERSION");
            if (obj4 != null) {
                hashMap.put("BUGLY_APP_VERSION", obj4.toString());
            }
            Object obj5 = applicationInfo.metaData.get("BUGLY_ENABLE_DEBUG");
            if (obj5 != null) {
                hashMap.put("BUGLY_ENABLE_DEBUG", obj5.toString());
            }
            Object obj6 = applicationInfo.metaData.get("com.tencent.rdm.uuid");
            if (obj6 != null) {
                hashMap.put("com.tencent.rdm.uuid", obj6.toString());
            }
            Object obj7 = applicationInfo.metaData.get("BUGLY_APP_BUILD_NO");
            if (obj7 != null) {
                hashMap.put("BUGLY_APP_BUILD_NO", obj7.toString());
            }
            Object obj8 = applicationInfo.metaData.get("BUGLY_AREA");
            if (obj8 != null) {
                hashMap.put("BUGLY_AREA", obj8.toString());
            }
            return hashMap;
        } catch (Throwable th) {
            if (!C3151an.m9916a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: e */
    public static String m9524e(Context context) {
        Signature[] signatureArr;
        String m9516a = m9516a(context);
        if (m9516a == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(m9516a, 64);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length != 0) {
                return m9518a(signatureArr[0].toByteArray());
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    /* renamed from: f */
    public static boolean m9525f(Context context) {
        if (context == null) {
            return false;
        }
        if (f10129c == null) {
            f10129c = (ActivityManager) context.getSystemService("activity");
        }
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            f10129c.getMemoryInfo(memoryInfo);
            if (!memoryInfo.lowMemory) {
                return false;
            }
            C3151an.m9921c("Memory is low.", new Object[0]);
            return true;
        } catch (Throwable th) {
            if (!C3151an.m9916a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    /* renamed from: g */
    public static String m9526g(Context context) {
        if (context == null) {
            return "";
        }
        String m9527h = m9527h(context);
        return !C3154aq.m9970a(m9527h) ? m9527h : m9528i(context);
    }

    /* renamed from: h */
    private static String m9527h(Context context) {
        String str = "";
        InputStream inputStream = null;
        try {
            try {
                try {
                    String string = C3154aq.m9947a("DENGTA_META", context).getString("key_channelpath", "");
                    if (C3154aq.m9970a(string)) {
                        string = "channel.ini";
                    }
                    C3151an.m9915a("[AppInfo] Beacon channel file path: " + string, new Object[0]);
                    if (!string.equals("")) {
                        inputStream = context.getAssets().open(string);
                        Properties properties = new Properties();
                        properties.load(inputStream);
                        str = properties.getProperty("CHANNEL", "");
                        C3151an.m9915a("[AppInfo] Beacon channel read from assert: " + str, new Object[0]);
                        if (!C3154aq.m9970a(str)) {
                            return str;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                            C3151an.m9916a(e2);
                        }
                    }
                }
            } catch (Exception unused) {
                C3151an.m9922d("[AppInfo] Failed to get get beacon channel", new Object[0]);
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        } catch (IOException e3) {
            C3151an.m9916a(e3);
        }
        return str;
    }

    /* renamed from: i */
    private static String m9528i(Context context) {
        try {
            Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("CHANNEL_DENGTA");
            return obj != null ? obj.toString() : "";
        } catch (Throwable unused) {
            C3151an.m9922d("[AppInfo] Failed to read beacon channel from manifest.", new Object[0]);
            return "";
        }
    }

    /* renamed from: a */
    public static boolean m9520a(Context context, String str) {
        if (context != null && str != null && str.trim().length() > 0) {
            try {
                String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                if (strArr != null) {
                    for (String str2 : strArr) {
                        if (str.equals(str2)) {
                            return true;
                        }
                    }
                }
            } catch (Throwable th) {
                if (!C3151an.m9916a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static String m9517a(Context context, int i2) {
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader("/proc/" + i2 + "/cmdline");
            try {
                char[] cArr = new char[512];
                fileReader2.read(cArr);
                int i3 = 0;
                while (i3 < cArr.length && cArr[i3] != 0) {
                    i3++;
                }
                String substring = new String(cArr).substring(0, i3);
                try {
                    fileReader2.close();
                } catch (Throwable unused) {
                }
                return substring;
            } catch (Throwable th) {
                th = th;
                fileReader = fileReader2;
                try {
                    if (!C3151an.m9916a(th)) {
                        th.printStackTrace();
                    }
                    String valueOf = String.valueOf(i2);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    return valueOf;
                } catch (Throwable th2) {
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: a */
    public static List<String> m9519a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            String str = map.get("BUGLY_DISABLE");
            if (str != null && str.length() != 0) {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                for (int i2 = 0; i2 < split.length; i2++) {
                    split[i2] = split[i2].trim();
                }
                return Arrays.asList(split);
            }
            return null;
        } catch (Throwable th) {
            if (!C3151an.m9916a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    public static String m9518a(byte[] bArr) {
        X509Certificate x509Certificate;
        StringBuilder sb = new StringBuilder();
        if (bArr != null && bArr.length > 0) {
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                if (certificateFactory == null || (x509Certificate = (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArr))) == null) {
                    return null;
                }
                sb.append("Issuer|");
                Principal issuerDN = x509Certificate.getIssuerDN();
                if (issuerDN != null) {
                    sb.append(issuerDN.toString());
                } else {
                    sb.append("unknown");
                }
                sb.append("\n");
                sb.append("SerialNumber|");
                BigInteger serialNumber = x509Certificate.getSerialNumber();
                if (issuerDN != null) {
                    sb.append(serialNumber.toString(16));
                } else {
                    sb.append("unknown");
                }
                sb.append("\n");
                sb.append("NotBefore|");
                Date notBefore = x509Certificate.getNotBefore();
                if (issuerDN != null) {
                    sb.append(notBefore.toString());
                } else {
                    sb.append("unknown");
                }
                sb.append("\n");
                sb.append("NotAfter|");
                Date notAfter = x509Certificate.getNotAfter();
                if (issuerDN != null) {
                    sb.append(notAfter.toString());
                } else {
                    sb.append("unknown");
                }
                sb.append("\n");
                sb.append("SHA1|");
                String m9959a = C3154aq.m9959a(MessageDigest.getInstance("SHA1").digest(x509Certificate.getEncoded()));
                if (m9959a != null && m9959a.length() > 0) {
                    sb.append(m9959a.toString());
                } else {
                    sb.append("unknown");
                }
                sb.append("\n");
                sb.append("MD5|");
                String m9959a2 = C3154aq.m9959a(MessageDigest.getInstance("MD5").digest(x509Certificate.getEncoded()));
                if (m9959a2 != null && m9959a2.length() > 0) {
                    sb.append(m9959a2.toString());
                } else {
                    sb.append("unknown");
                }
            } catch (CertificateException e2) {
                if (!C3151an.m9916a(e2)) {
                    e2.printStackTrace();
                }
            } catch (Throwable th) {
                if (!C3151an.m9916a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return sb.length() == 0 ? "unknown" : sb.toString();
    }
}
