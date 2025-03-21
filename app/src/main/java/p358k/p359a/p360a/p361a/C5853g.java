package p358k.p359a.p360a.p361a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.hihonor.honorid.p165f.C2171a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import p286h.C5230f1;
import p358k.p359a.p360a.p361a.p363j.C5863e;

/* compiled from: SDKUtil.java */
/* renamed from: k.a.a.a.g */
/* loaded from: classes2.dex */
public class C5853g {
    /* renamed from: a */
    public static boolean m24640a(Context context) {
        if (context != null) {
            return C2171a.m6319a(context);
        }
        C5863e.m24691a("SDKUtil", "context is null", true);
        return false;
    }

    /* renamed from: b */
    public static boolean m24646b(Context context, int i2) {
        if (context != null) {
            return m24643b(context) >= i2;
        }
        C5863e.m24692b("SDKUtil", "context is null", true);
        return false;
    }

    /* renamed from: c */
    public static boolean m24648c(Context context, int i2) {
        if (context != null) {
            return m24643b(context) <= i2;
        }
        C5863e.m24692b("SDKUtil", "context is null", true);
        return false;
    }

    /* renamed from: a */
    public static boolean m24641a(Context context, int i2) {
        if (context != null) {
            return m24643b(context) < i2;
        }
        C5863e.m24692b("SDKUtil", "context is null", true);
        return false;
    }

    /* renamed from: b */
    public static int m24643b(Context context) {
        try {
            int i2 = context.getPackageManager().getPackageInfo(C5851e.m24637a(context).m24638a(), 0).versionCode;
            C5863e.m24692b("SDKUtil", "versionCode " + i2, true);
            return i2;
        } catch (PackageManager.NameNotFoundException unused) {
            C5863e.m24691a("SDKUtil", "NameNotFoundException error", true);
            return 0;
        } catch (Exception unused2) {
            C5863e.m24691a("SDKUtil", "Exception error", true);
            return 0;
        }
    }

    /* renamed from: c */
    public static boolean m24647c(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            String m24638a = C5851e.m24637a(context).m24638a();
            PackageInfo packageInfo = packageManager.getPackageInfo(m24638a, 0);
            C5863e.m24692b("SDKUtil", "packageName " + m24638a, true);
            return packageInfo.versionName.contains("oversea");
        } catch (PackageManager.NameNotFoundException unused) {
            C5863e.m24691a("SDKUtil", "NameNotFoundException error", true);
            return false;
        } catch (Exception unused2) {
            C5863e.m24691a("SDKUtil", "Exception error", true);
            return false;
        }
    }

    /* renamed from: a */
    private static byte[] m24642a(Context context, String str) {
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
            C5863e.m24691a("HiPkgSignManager", "PackageManager.NameNotFoundException : " + e2.getMessage(), true);
        } catch (Exception e3) {
            C5863e.m24691a("HiPkgSignManager", "Exception : " + e3.getMessage(), true);
        }
        return new byte[0];
    }

    /* renamed from: b */
    public static String m24644b(Context context, String str) {
        byte[] m24642a = m24642a(context, str);
        String m24645b = (m24642a == null || m24642a.length <= 0) ? "" : m24645b(m24642a);
        return m24645b == null ? "" : m24645b;
    }

    /* renamed from: a */
    private static String m24639a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < length; i2++) {
            if ((bArr[i2] & C5230f1.f20085c) < 16) {
                stringBuffer.append("0" + Integer.toHexString(bArr[i2] & C5230f1.f20085c));
            } else {
                stringBuffer.append(Integer.toHexString(bArr[i2] & C5230f1.f20085c));
            }
        }
        return stringBuffer.toString().toUpperCase(Locale.ENGLISH);
    }

    /* renamed from: b */
    private static String m24645b(byte[] bArr) {
        try {
            return m24639a(MessageDigest.getInstance("SHA-256").digest(bArr));
        } catch (NoSuchAlgorithmException e2) {
            String str = "NoSuchAlgorithmException" + e2.getMessage();
            return "";
        }
    }
}
