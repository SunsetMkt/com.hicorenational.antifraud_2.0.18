package com.huawei.hms.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import android.util.AndroidException;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.support.log.HMSLog;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* loaded from: classes.dex */
public class PackageManagerHelper {

    /* renamed from: a */
    private final PackageManager f7973a;

    public enum PackageStates {
        ENABLED,
        DISABLED,
        NOT_INSTALLED,
        SPOOF
    }

    public PackageManagerHelper(Context context) {
        this.f7973a = context.getPackageManager();
    }

    /* renamed from: a */
    private byte[] m7793a(String str) {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = this.f7973a.getPackageInfo(str, 64);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0) {
                return signatureArr[0].toByteArray();
            }
        } catch (AndroidException e2) {
            HMSLog.m7715e("PackageManagerHelper", "Failed to get application signature certificate fingerprint." + e2.getMessage());
        } catch (RuntimeException e3) {
            HMSLog.m7716e("PackageManagerHelper", "Failed to get application signature certificate fingerprint.", e3);
        }
        HMSLog.m7715e("PackageManagerHelper", "Failed to get application signature certificate fingerprint.");
        return new byte[0];
    }

    public String getApplicationName(String str) {
        try {
            return this.f7973a.getApplicationLabel(this.f7973a.getApplicationInfo(str, 128)).toString();
        } catch (AndroidException | RuntimeException unused) {
            HMSLog.m7715e("PackageManagerHelper", "Failed to get application name for " + str);
            return null;
        }
    }

    public long getPackageFirstInstallTime(String str) {
        try {
            PackageInfo packageInfo = this.f7973a.getPackageInfo(str, 128);
            if (packageInfo != null) {
                return packageInfo.firstInstallTime;
            }
            return 0L;
        } catch (AndroidException | RuntimeException unused) {
            return 0L;
        }
    }

    public String getPackageSignature(String str) {
        byte[] m7793a = m7793a(str);
        if (m7793a == null || m7793a.length == 0) {
            return null;
        }
        return HEX.encodeHexString(SHA256.digest(m7793a), true);
    }

    public String getPackageSigningCertificate(String str) {
        if (Build.VERSION.SDK_INT < 28) {
            return getPackageSignature(str);
        }
        try {
            PackageInfo packageInfo = this.f7973a.getPackageInfo(str, AbstractC1191a.f2490C1);
            if (Objects.isNull(packageInfo, packageInfo.signingInfo)) {
                HMSLog.m7715e("PackageManagerHelper", "packageInfo or packageInfo.signingInfo is null");
                return null;
            }
            Signature[] apkContentsSigners = packageInfo.signingInfo.getApkContentsSigners();
            if (!Objects.isNull(apkContentsSigners, apkContentsSigners[0])) {
                return HEX.encodeHexString(SHA256.digest(apkContentsSigners[0].toByteArray()), true);
            }
            HMSLog.m7715e("PackageManagerHelper", "get V3 signature is null");
            return null;
        } catch (AndroidException | RuntimeException unused) {
            HMSLog.m7715e("PackageManagerHelper", "getPackageSignatureV3 has exception");
            return null;
        }
    }

    public PackageStates getPackageStates(String str) {
        if (TextUtils.isEmpty(str)) {
            HMSLog.m7715e("PackageManagerHelper", "servicePackageName is empty.");
            return PackageStates.NOT_INSTALLED;
        }
        try {
            return this.f7973a.getApplicationInfo(str, 128).enabled ? PackageStates.ENABLED : PackageStates.DISABLED;
        } catch (AndroidException | RuntimeException unused) {
            HMSLog.m7715e("PackageManagerHelper", "in getPackageStates, getApplicationInfo threw an exception");
            return PackageStates.NOT_INSTALLED;
        }
    }

    public int getPackageVersionCode(String str) {
        try {
            PackageInfo packageInfo = this.f7973a.getPackageInfo(str, 16);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (AndroidException e2) {
            HMSLog.m7715e("PackageManagerHelper", "get PackageVersionCode failed " + e2);
            return 0;
        } catch (RuntimeException e3) {
            HMSLog.m7716e("PackageManagerHelper", "get PackageVersionCode failed", e3);
            return 0;
        }
    }

    public String getPackageVersionName(String str) {
        try {
            PackageInfo packageInfo = this.f7973a.getPackageInfo(str, 16);
            if (packageInfo != null) {
                String str2 = packageInfo.versionName;
                if (str2 != null) {
                    return str2;
                }
            }
            return "";
        } catch (AndroidException unused) {
            return "";
        } catch (RuntimeException e2) {
            HMSLog.m7716e("PackageManagerHelper", "get getPackageVersionName failed", e2);
            return "";
        }
    }

    public boolean hasProvider(String str, String str2) {
        ProviderInfo[] providerInfoArr;
        try {
            PackageInfo packageInfo = this.f7973a.getPackageInfo(str, 8);
            if (packageInfo != null && (providerInfoArr = packageInfo.providers) != null) {
                for (ProviderInfo providerInfo : providerInfoArr) {
                    if (str2.equals(providerInfo.authority)) {
                        return true;
                    }
                }
            }
        } catch (AndroidException | RuntimeException unused) {
        }
        return false;
    }

    public boolean isPackageFreshInstall(String str) {
        try {
            PackageInfo packageInfo = this.f7973a.getPackageInfo(str, 128);
            if (packageInfo != null) {
                return packageInfo.firstInstallTime == packageInfo.lastUpdateTime;
            }
            return false;
        } catch (AndroidException | RuntimeException unused) {
            return false;
        }
    }

    public boolean verifyPackageArchive(String str, String str2, String str3) {
        PackageInfo packageInfo;
        InputStream inputStream = null;
        try {
            packageInfo = this.f7973a.getPackageArchiveInfo(str, 64);
        } catch (Exception e2) {
            HMSLog.m7715e("PackageManagerHelper", "getPackageArchiveInfo Exception. " + e2.getMessage());
            packageInfo = null;
        }
        if (packageInfo != null && packageInfo.signatures.length > 0) {
            try {
                if (!str2.equals(packageInfo.packageName)) {
                    return false;
                }
                try {
                    inputStream = IOUtils.toInputStream(packageInfo.signatures[0].toByteArray());
                    return str3.equalsIgnoreCase(HEX.encodeHexString(SHA256.digest(CertificateFactory.getInstance("X.509").generateCertificate(inputStream).getEncoded()), true));
                } catch (IOException | CertificateException e3) {
                    HMSLog.m7715e("PackageManagerHelper", "Failed to get application signature certificate fingerprint." + e3.getMessage());
                }
            } finally {
                IOUtils.closeQuietly((InputStream) null);
            }
        }
        return false;
    }
}
