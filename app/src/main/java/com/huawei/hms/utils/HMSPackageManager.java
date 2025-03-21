package com.huawei.hms.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidException;
import android.util.Pair;
import anet.channel.util.HttpConstant;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.common.HmsCheckedState;
import com.huawei.hms.common.PackageConstants;
import com.huawei.hms.device.C2343a;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.PackageManagerHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* loaded from: classes.dex */
public class HMSPackageManager {

    /* renamed from: o */
    private static HMSPackageManager f7944o;

    /* renamed from: p */
    private static final Object f7945p = new Object();

    /* renamed from: q */
    private static final Object f7946q = new Object();

    /* renamed from: r */
    private static final Object f7947r = new Object();

    /* renamed from: s */
    private static final Map<String, String> f7948s;

    /* renamed from: a */
    private final Context f7949a;

    /* renamed from: b */
    private final PackageManagerHelper f7950b;

    /* renamed from: c */
    private String f7951c;

    /* renamed from: d */
    private String f7952d;

    /* renamed from: e */
    private int f7953e;

    /* renamed from: f */
    private String f7954f;

    /* renamed from: g */
    private String f7955g;

    /* renamed from: h */
    private String f7956h;

    /* renamed from: i */
    private String f7957i;

    /* renamed from: j */
    private int f7958j;

    /* renamed from: k */
    private int f7959k;

    /* renamed from: l */
    private long f7960l;

    /* renamed from: m */
    private boolean f7961m;

    /* renamed from: n */
    private int f7962n;

    public static class PackagePriorityInfo implements Comparable<PackagePriorityInfo> {

        /* renamed from: a */
        private String f7963a;

        /* renamed from: b */
        private String f7964b;

        /* renamed from: c */
        private String f7965c;

        /* renamed from: d */
        private String f7966d;

        /* renamed from: e */
        private String f7967e;

        /* renamed from: f */
        private Long f7968f;

        public PackagePriorityInfo(String str, String str2, String str3, String str4, String str5, long j2) {
            this.f7963a = str;
            this.f7964b = str2;
            this.f7965c = str3;
            this.f7966d = str4;
            this.f7967e = str5;
            this.f7968f = Long.valueOf(j2);
        }

        @Override // java.lang.Comparable
        public int compareTo(PackagePriorityInfo packagePriorityInfo) {
            return TextUtils.equals(this.f7967e, packagePriorityInfo.f7967e) ? this.f7968f.compareTo(packagePriorityInfo.f7968f) : this.f7967e.compareTo(packagePriorityInfo.f7967e);
        }
    }

    /* renamed from: com.huawei.hms.utils.HMSPackageManager$a */
    class C2542a implements Comparator<ResolveInfo> {
        C2542a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ResolveInfo resolveInfo, ResolveInfo resolveInfo2) {
            String str = resolveInfo.serviceInfo.applicationInfo.packageName;
            String str2 = resolveInfo2.serviceInfo.applicationInfo.packageName;
            if (HMSPackageManager.f7948s.containsKey(str) && HMSPackageManager.f7948s.containsKey(str2)) {
                return str.compareTo(str2);
            }
            if (HMSPackageManager.f7948s.containsKey(str)) {
                return -1;
            }
            return HMSPackageManager.f7948s.containsKey(str2) ? 1 : 0;
        }
    }

    /* renamed from: com.huawei.hms.utils.HMSPackageManager$b */
    class RunnableC2543b implements Runnable {
        RunnableC2543b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HMSLog.m7717i("HMSPackageManager", "enter asyncOnceCheckMDMState");
            try {
                List<ResolveInfo> queryIntentServices = HMSPackageManager.this.f7949a.getPackageManager().queryIntentServices(new Intent("com.huawei.hms.core.aidlservice"), 128);
                if (queryIntentServices == null || queryIntentServices.size() == 0) {
                    return;
                }
                Iterator<ResolveInfo> it = queryIntentServices.iterator();
                while (it.hasNext()) {
                    if ("com.huawei.hwid".equals(it.next().serviceInfo.applicationInfo.packageName)) {
                        HMSPackageManager.this.m7761d();
                    }
                }
                HMSLog.m7717i("HMSPackageManager", "quit asyncOnceCheckMDMState");
            } catch (Exception e2) {
                HMSLog.m7715e("HMSPackageManager", "asyncOnceCheckMDMState query hms action failed. " + e2.getMessage());
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f7948s = hashMap;
        hashMap.put("com.huawei.hwid", "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05");
        hashMap.put("com.huawei.hwid.tv", "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C");
    }

    private HMSPackageManager(Context context) {
        this.f7949a = context;
        this.f7950b = new PackageManagerHelper(context);
    }

    /* renamed from: c */
    private boolean m7760c(String str, String str2) {
        return Objects.equals(str2, this.f7950b.getPackageSigningCertificate(str)) || Objects.equals(str2, this.f7950b.getPackageSignature(str));
    }

    /* renamed from: d */
    private Pair<String, String> m7762d(String str, String str2) {
        if (!f7948s.containsKey(str) || !PackageConstants.SERVICES_SIGNATURE_V3.equalsIgnoreCase(str2)) {
            return null;
        }
        this.f7962n = 3;
        return new Pair<>(str, str2);
    }

    /* renamed from: e */
    private void m7765e(String str) {
        if (SystemUtils.isHuawei() || SystemUtils.isSystemApp(this.f7949a, str) || Build.VERSION.SDK_INT < 28 || m7756b(str)) {
            AgHmsUpdateState.getInstance().setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);
        }
    }

    /* renamed from: f */
    private void m7766f() {
        synchronized (f7946q) {
            this.f7951c = null;
            this.f7952d = null;
            this.f7953e = 0;
        }
    }

    /* renamed from: g */
    private Pair<String, String> m7767g() {
        try {
            List<ResolveInfo> queryIntentServices = this.f7949a.getPackageManager().queryIntentServices(new Intent("com.huawei.hms.core.aidlservice"), 128);
            if (queryIntentServices == null || queryIntentServices.size() == 0) {
                HMSLog.m7715e("HMSPackageManager", "query hms action, resolveInfoList is null or empty.");
                return null;
            }
            m7751a(queryIntentServices);
            for (ResolveInfo resolveInfo : queryIntentServices) {
                String str = resolveInfo.serviceInfo.applicationInfo.packageName;
                String packageSigningCertificate = this.f7950b.getPackageSigningCertificate(str);
                String packageSignature = this.f7950b.getPackageSignature(str);
                Pair<String, String> m7762d = m7762d(str, packageSigningCertificate);
                if (m7762d != null) {
                    HMSLog.m7717i("HMSPackageManager", "signature V3 check success");
                    return m7762d;
                }
                Pair<String, String> m7745a = m7745a(resolveInfo.serviceInfo.metaData, str, packageSigningCertificate, packageSignature);
                if (m7745a != null) {
                    HMSLog.m7717i("HMSPackageManager", "DSS signature check success");
                    return m7745a;
                }
                Pair<String, String> m7746a = m7746a(str, packageSignature);
                if (m7746a != null) {
                    HMSLog.m7717i("HMSPackageManager", "signature V2 check success");
                    return m7746a;
                }
            }
            return null;
        } catch (Exception e2) {
            HMSLog.m7715e("HMSPackageManager", "getHmsPackageName query hms action failed. " + e2.getMessage());
            return null;
        }
    }

    public static HMSPackageManager getInstance(Context context) {
        synchronized (f7945p) {
            if (f7944o == null && context != null) {
                if (context.getApplicationContext() != null) {
                    f7944o = new HMSPackageManager(context.getApplicationContext());
                } else {
                    f7944o = new HMSPackageManager(context);
                }
                f7944o.m7771k();
                f7944o.m7755b();
            }
        }
        return f7944o;
    }

    /* renamed from: h */
    private Pair<String, String> m7768h() {
        Pair<String, String> m7767g = m7767g();
        if (m7767g != null) {
            HMSLog.m7717i("HMSPackageManager", "aidlService pkgName: " + ((String) m7767g.first));
            this.f7956h = "com.huawei.hms.core.aidlservice";
            this.f7957i = null;
            return m7767g;
        }
        ArrayList<PackagePriorityInfo> m7769i = m7769i();
        if (m7769i == null) {
            HMSLog.m7715e("HMSPackageManager", "PackagePriorityInfo list is null");
            return null;
        }
        Iterator<PackagePriorityInfo> it = m7769i.iterator();
        while (it.hasNext()) {
            PackagePriorityInfo next = it.next();
            String str = next.f7963a;
            String str2 = next.f7964b;
            String str3 = next.f7965c;
            String str4 = next.f7966d;
            String packageSignature = this.f7950b.getPackageSignature(str);
            if (m7753a(str + "&" + packageSignature + "&" + str2, str3, str4)) {
                HMSLog.m7717i("HMSPackageManager", "result: " + str + ", " + str2 + ", " + next.f7968f);
                this.f7956h = PackageConstants.GENERAL_SERVICES_ACTION;
                m7763d(str2);
                return new Pair<>(str, packageSignature);
            }
        }
        return null;
    }

    /* renamed from: i */
    private ArrayList<PackagePriorityInfo> m7769i() {
        try {
            List<ResolveInfo> queryIntentServices = this.f7949a.getPackageManager().queryIntentServices(new Intent(PackageConstants.GENERAL_SERVICES_ACTION), 128);
            if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                HMSLog.m7715e("HMSPackageManager", "query aglite action, resolveInfoList is null or empty");
                return null;
            }
            ArrayList<PackagePriorityInfo> arrayList = new ArrayList<>();
            for (ResolveInfo resolveInfo : queryIntentServices) {
                String str = resolveInfo.serviceInfo.applicationInfo.packageName;
                long packageFirstInstallTime = this.f7950b.getPackageFirstInstallTime(str);
                Bundle bundle = resolveInfo.serviceInfo.metaData;
                if (bundle == null) {
                    HMSLog.m7715e("HMSPackageManager", "package " + str + " get metaData is null");
                } else {
                    String m7748a = m7748a(bundle, "hms_app_checker_config");
                    String m7749a = m7749a(m7748a);
                    if (TextUtils.isEmpty(m7749a)) {
                        HMSLog.m7717i("HMSPackageManager", "get priority fail. hmsCheckerCfg: " + m7748a);
                    } else {
                        String m7748a2 = m7748a(bundle, "hms_app_signer_v2");
                        if (TextUtils.isEmpty(m7748a2)) {
                            HMSLog.m7717i("HMSPackageManager", "get signerV2 fail.");
                        } else {
                            String m7748a3 = m7748a(bundle, "hms_app_cert_chain");
                            if (TextUtils.isEmpty(m7748a3)) {
                                HMSLog.m7717i("HMSPackageManager", "get certChain fail.");
                            } else {
                                HMSLog.m7717i("HMSPackageManager", "add: " + str + ", " + m7748a + ", " + packageFirstInstallTime);
                                arrayList.add(new PackagePriorityInfo(str, m7748a, m7748a2, m7748a3, m7749a, packageFirstInstallTime));
                            }
                        }
                    }
                }
            }
            Collections.sort(arrayList);
            return arrayList;
        } catch (Exception e2) {
            HMSLog.m7715e("HMSPackageManager", "query aglite action failed. " + e2.getMessage());
            return null;
        }
    }

    /* renamed from: j */
    private void m7770j() {
        synchronized (f7946q) {
            Pair<String, String> m7767g = m7767g();
            if (m7767g == null) {
                HMSLog.m7715e("HMSPackageManager", "<initHmsPackageInfo> Failed to find HMS apk");
                m7766f();
                return;
            }
            String str = (String) m7767g.first;
            this.f7951c = str;
            this.f7952d = (String) m7767g.second;
            this.f7953e = this.f7950b.getPackageVersionCode(str);
            HMSLog.m7717i("HMSPackageManager", "<initHmsPackageInfo> Succeed to find HMS apk: " + this.f7951c + " version: " + this.f7953e);
        }
    }

    /* renamed from: k */
    private void m7771k() {
        synchronized (f7946q) {
            Pair<String, String> m7768h = m7768h();
            if (m7768h == null) {
                HMSLog.m7715e("HMSPackageManager", "<initHmsPackageInfoForMultiService> Failed to find HMS apk");
                m7764e();
                AgHmsUpdateState.getInstance().setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);
                return;
            }
            this.f7954f = (String) m7768h.first;
            this.f7955g = (String) m7768h.second;
            this.f7958j = this.f7950b.getPackageVersionCode(getHMSPackageNameForMultiService());
            m7765e(this.f7954f);
            HMSLog.m7717i("HMSPackageManager", "<initHmsPackageInfoForMultiService> Succeed to find HMS apk: " + this.f7954f + " version: " + this.f7958j);
        }
    }

    /* renamed from: l */
    private boolean m7772l() {
        Bundle bundle;
        PackageManager packageManager = this.f7949a.getPackageManager();
        if (packageManager == null) {
            HMSLog.m7715e("HMSPackageManager", "In isMinApkVersionEffective, Failed to get 'PackageManager' instance.");
            return true;
        }
        try {
        } catch (AndroidException unused) {
            HMSLog.m7715e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.");
        } catch (RuntimeException e2) {
            HMSLog.m7716e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.", e2);
        }
        if (!TextUtils.isEmpty(this.f7956h) && (this.f7956h.equals(PackageConstants.GENERAL_SERVICES_ACTION) || this.f7956h.equals(PackageConstants.INTERNAL_SERVICES_ACTION))) {
            HMSLog.m7717i("HMSPackageManager", "action = " + this.f7956h + " exist");
            return false;
        }
        ApplicationInfo applicationInfo = packageManager.getPackageInfo(getHMSPackageName(), 128).applicationInfo;
        if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("com.huawei.hms.kit.api_level:hmscore") && (getHmsVersionCode() >= 50000000 || getHmsVersionCode() <= 19999999)) {
            HMSLog.m7717i("HMSPackageManager", "MinApkVersion is disabled.");
            return false;
        }
        return true;
    }

    public String getHMSFingerprint() {
        String str = this.f7952d;
        return str == null ? "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05" : str;
    }

    public String getHMSPackageName() {
        HMSLog.m7717i("HMSPackageManager", "Enter getHMSPackageName");
        refresh();
        String str = this.f7951c;
        if (str != null) {
            if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.f7950b.getPackageStates(str))) {
                HMSLog.m7717i("HMSPackageManager", "The package name is not installed and needs to be refreshed again");
                m7770j();
            }
            String str2 = this.f7951c;
            if (str2 != null) {
                return str2;
            }
        }
        HMSLog.m7717i("HMSPackageManager", "return default packageName: com.huawei.hwid");
        return "com.huawei.hwid";
    }

    public String getHMSPackageNameForMultiService() {
        HMSLog.m7717i("HMSPackageManager", "Enter getHMSPackageNameForMultiService");
        refreshForMultiService();
        String str = this.f7954f;
        if (str != null) {
            if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.f7950b.getPackageStates(str))) {
                HMSLog.m7717i("HMSPackageManager", "The package name is not installed and needs to be refreshed again");
                m7771k();
            }
            String str2 = this.f7954f;
            if (str2 != null) {
                return str2;
            }
        }
        HMSLog.m7717i("HMSPackageManager", "return default packageName: com.huawei.hwid");
        return "com.huawei.hwid";
    }

    public PackageManagerHelper.PackageStates getHMSPackageStates() {
        synchronized (f7945p) {
            refresh();
            PackageManagerHelper.PackageStates packageStates = this.f7950b.getPackageStates(this.f7951c);
            PackageManagerHelper.PackageStates packageStates2 = PackageManagerHelper.PackageStates.NOT_INSTALLED;
            if (packageStates == packageStates2) {
                m7766f();
                return packageStates2;
            }
            boolean z = false;
            if ("com.huawei.hwid".equals(this.f7951c) && m7761d() == 1) {
                return PackageManagerHelper.PackageStates.SPOOF;
            }
            if (packageStates == PackageManagerHelper.PackageStates.ENABLED && !m7760c(this.f7951c, this.f7952d)) {
                z = true;
            }
            return z ? packageStates2 : packageStates;
        }
    }

    public PackageManagerHelper.PackageStates getHMSPackageStatesForMultiService() {
        synchronized (f7945p) {
            refreshForMultiService();
            PackageManagerHelper.PackageStates packageStates = this.f7950b.getPackageStates(this.f7954f);
            PackageManagerHelper.PackageStates packageStates2 = PackageManagerHelper.PackageStates.NOT_INSTALLED;
            if (packageStates == packageStates2) {
                m7764e();
                return packageStates2;
            }
            boolean z = false;
            if ("com.huawei.hwid".equals(this.f7954f) && m7761d() == 1) {
                return PackageManagerHelper.PackageStates.SPOOF;
            }
            if (packageStates == PackageManagerHelper.PackageStates.ENABLED && !m7760c(this.f7954f, this.f7955g)) {
                z = true;
            }
            return z ? packageStates2 : packageStates;
        }
    }

    public int getHmsMultiServiceVersion() {
        return this.f7950b.getPackageVersionCode(getHMSPackageNameForMultiService());
    }

    public int getHmsVersionCode() {
        return this.f7950b.getPackageVersionCode(getHMSPackageName());
    }

    public String getInnerServiceAction() {
        return PackageConstants.INTERNAL_SERVICES_ACTION;
    }

    public String getServiceAction() {
        return !TextUtils.isEmpty(this.f7956h) ? this.f7956h : "com.huawei.hms.core.aidlservice";
    }

    public boolean hmsVerHigherThan(int i2) {
        if (this.f7953e >= i2 || !m7772l()) {
            return true;
        }
        int packageVersionCode = this.f7950b.getPackageVersionCode(getHMSPackageName());
        this.f7953e = packageVersionCode;
        return packageVersionCode >= i2;
    }

    public boolean isApkNeedUpdate(int i2) {
        int hmsVersionCode = getHmsVersionCode();
        HMSLog.m7717i("HMSPackageManager", "current versionCode:" + hmsVersionCode + ", target version requirements: " + i2);
        return hmsVersionCode < i2;
    }

    public boolean isApkUpdateNecessary(int i2) {
        if (isUpdateHmsForThirdPartyDevice()) {
            return true;
        }
        int hmsVersionCode = getHmsVersionCode();
        HMSLog.m7717i("HMSPackageManager", "current versionCode:" + hmsVersionCode + ", minimum version requirements: " + i2);
        return m7772l() && hmsVersionCode < i2;
    }

    public boolean isUpdateHmsForThirdPartyDevice() {
        return "com.huawei.hwid".equals(this.f7954f) && AgHmsUpdateState.getInstance().isUpdateHms();
    }

    public boolean isUseOldCertificate() {
        return this.f7961m;
    }

    public void refresh() {
        if (TextUtils.isEmpty(this.f7951c) || TextUtils.isEmpty(this.f7952d)) {
            m7770j();
        }
        m7758c(this.f7951c);
    }

    public void refreshForMultiService() {
        if (TextUtils.isEmpty(this.f7954f) || TextUtils.isEmpty(this.f7955g)) {
            m7771k();
        }
        m7758c(this.f7954f);
    }

    public void resetMultiServiceState() {
        m7764e();
    }

    public void setUseOldCertificate(boolean z) {
        this.f7961m = z;
    }

    /* renamed from: b */
    private boolean m7756b(String str) {
        return !"com.huawei.hwid".equals(str) || this.f7962n == 3;
    }

    /* renamed from: a */
    private void m7751a(List<ResolveInfo> list) {
        if (list.size() <= 1) {
            return;
        }
        Collections.sort(list, new C2542a());
    }

    /* renamed from: b */
    private boolean m7757b(String str, String str2) {
        Map<String, String> map = f7948s;
        return map.containsKey(str) && map.get(str).equalsIgnoreCase(str2);
    }

    /* renamed from: c */
    private void m7758c(String str) {
        if ("com.huawei.hwid".equals(str) && AgHmsUpdateState.getInstance().isUpdateHms() && this.f7950b.getPackageVersionCode(str) >= AgHmsUpdateState.getInstance().getTargetVersionCode()) {
            AgHmsUpdateState.getInstance().resetUpdateState();
            HMSLog.m7717i("HMSPackageManager", "refresh update state for HMS V3");
        }
    }

    /* renamed from: a */
    private Pair<String, String> m7745a(Bundle bundle, String str, String str2, String str3) {
        String str4;
        if (bundle == null) {
            HMSLog.m7715e("HMSPackageManager", "DSS check: " + str + " for metadata is null");
            return null;
        }
        this.f7962n = 2;
        if (m7752a(bundle, str, str2)) {
            HMSLog.m7717i("HMSPackageManager", "support DSS V3 check");
            str3 = str2;
            str4 = "hms_app_signer_v3";
        } else {
            str4 = "hms_app_signer";
        }
        if (!bundle.containsKey(str4)) {
            HMSLog.m7715e("HMSPackageManager", "skip package " + str + " for no " + str4);
            return null;
        }
        if (!bundle.containsKey("hms_app_cert_chain")) {
            HMSLog.m7715e("HMSPackageManager", "skip package " + str + " for no cert chain");
            return null;
        }
        if (!m7753a(str + "&" + str3, bundle.getString(str4), bundle.getString("hms_app_cert_chain"))) {
            HMSLog.m7715e("HMSPackageManager", "checkSigner failed");
            return null;
        }
        if (str4.equals("hms_app_signer_v3")) {
            this.f7962n = 3;
        }
        return new Pair<>(str, str3);
    }

    /* renamed from: b */
    private void m7755b() {
        new Thread(new RunnableC2543b(), "Thread-asyncOnceCheckMDMState").start();
    }

    /* renamed from: d */
    private void m7763d(String str) {
        String m7749a = m7749a(str);
        if (TextUtils.isEmpty(m7749a)) {
            return;
        }
        this.f7957i = m7749a.substring(9);
    }

    /* renamed from: e */
    private void m7764e() {
        synchronized (f7946q) {
            this.f7954f = null;
            this.f7955g = null;
            this.f7956h = null;
            this.f7957i = null;
            this.f7958j = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0024 A[Catch: all -> 0x0077, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0018, B:11:0x0024, B:12:0x0042, B:15:0x0044, B:18:0x004b, B:19:0x0073), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0044 A[Catch: all -> 0x0077, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0018, B:11:0x0024, B:12:0x0042, B:15:0x0044, B:18:0x004b, B:19:0x0073), top: B:3:0x0003 }] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int m7761d() {
        /*
            r7 = this;
            java.lang.Object r0 = com.huawei.hms.utils.HMSPackageManager.f7947r
            monitor-enter(r0)
            java.lang.String r1 = "HMSPackageManager"
            java.lang.String r2 = "enter checkHmsIsSpoof"
            com.huawei.hms.support.log.HMSLog.m7717i(r1, r2)     // Catch: java.lang.Throwable -> L77
            com.huawei.hms.utils.PackageManagerHelper r1 = r7.f7950b     // Catch: java.lang.Throwable -> L77
            java.lang.String r2 = "com.huawei.hwid"
            long r1 = r1.getPackageFirstInstallTime(r2)     // Catch: java.lang.Throwable -> L77
            int r3 = r7.f7959k     // Catch: java.lang.Throwable -> L77
            r4 = 3
            r5 = 1
            if (r3 == r4) goto L21
            long r3 = r7.f7960l     // Catch: java.lang.Throwable -> L77
            int r6 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r6 == 0) goto L1f
            goto L21
        L1f:
            r1 = 0
            goto L22
        L21:
            r1 = 1
        L22:
            if (r1 != 0) goto L44
            java.lang.String r1 = "HMSPackageManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77
            r2.<init>()     // Catch: java.lang.Throwable -> L77
            java.lang.String r3 = "quit checkHmsIsSpoof cached state: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L77
            int r3 = r7.f7959k     // Catch: java.lang.Throwable -> L77
            java.lang.String r3 = m7747a(r3)     // Catch: java.lang.Throwable -> L77
            r2.append(r3)     // Catch: java.lang.Throwable -> L77
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L77
            com.huawei.hms.support.log.HMSLog.m7717i(r1, r2)     // Catch: java.lang.Throwable -> L77
            int r1 = r7.f7959k     // Catch: java.lang.Throwable -> L77
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L77
            return r1
        L44:
            boolean r1 = r7.m7759c()     // Catch: java.lang.Throwable -> L77
            if (r1 == 0) goto L4b
            r5 = 2
        L4b:
            r7.f7959k = r5     // Catch: java.lang.Throwable -> L77
            com.huawei.hms.utils.PackageManagerHelper r1 = r7.f7950b     // Catch: java.lang.Throwable -> L77
            java.lang.String r2 = "com.huawei.hwid"
            long r1 = r1.getPackageFirstInstallTime(r2)     // Catch: java.lang.Throwable -> L77
            r7.f7960l = r1     // Catch: java.lang.Throwable -> L77
            java.lang.String r1 = "HMSPackageManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77
            r2.<init>()     // Catch: java.lang.Throwable -> L77
            java.lang.String r3 = "quit checkHmsIsSpoof state: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L77
            int r3 = r7.f7959k     // Catch: java.lang.Throwable -> L77
            java.lang.String r3 = m7747a(r3)     // Catch: java.lang.Throwable -> L77
            r2.append(r3)     // Catch: java.lang.Throwable -> L77
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L77
            com.huawei.hms.support.log.HMSLog.m7717i(r1, r2)     // Catch: java.lang.Throwable -> L77
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L77
            int r0 = r7.f7959k
            return r0
        L77:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L77
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.utils.HMSPackageManager.m7761d():int");
    }

    /* renamed from: c */
    private boolean m7759c() {
        String hmsPath = ReadApkFileUtil.getHmsPath(this.f7949a);
        if (hmsPath == null) {
            HMSLog.m7717i("HMSPackageManager", "hmsPath is null!");
            return false;
        }
        if (!ReadApkFileUtil.isCertFound(hmsPath)) {
            HMSLog.m7717i("HMSPackageManager", "NO huawer.cer in HMS!");
            return false;
        }
        if (!ReadApkFileUtil.checkSignature()) {
            HMSLog.m7717i("HMSPackageManager", "checkSignature fail!");
            return false;
        }
        if (ReadApkFileUtil.verifyApkHash(hmsPath)) {
            return true;
        }
        HMSLog.m7717i("HMSPackageManager", "verifyApkHash fail!");
        return false;
    }

    /* renamed from: a */
    private Pair<String, String> m7746a(String str, String str2) {
        if (m7757b(str, str2)) {
            return new Pair<>(str, str2);
        }
        HMSLog.m7718w("HMSPackageManager", "check sign fail: " + str + AbstractC1191a.f2606s1 + str2);
        return null;
    }

    /* renamed from: a */
    private boolean m7752a(Bundle bundle, String str, String str2) {
        return bundle.containsKey("hms_app_signer_v3") && !m7757b(str, str2) && Build.VERSION.SDK_INT >= 28;
    }

    /* renamed from: a */
    private String m7748a(Bundle bundle, String str) {
        if (!bundle.containsKey(str)) {
            HMSLog.m7715e("HMSPackageManager", "no " + str + " in metaData");
            return null;
        }
        return bundle.getString(str);
    }

    /* renamed from: a */
    private String m7749a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("priority=");
        if (indexOf == -1) {
            HMSLog.m7715e("HMSPackageManager", "get indexOfIdentifier -1");
            return null;
        }
        int indexOf2 = str.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        return str.substring(indexOf, indexOf2);
    }

    /* renamed from: a */
    private boolean m7753a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            List<X509Certificate> m6782b = C2343a.m6782b(str3);
            if (m6782b.size() == 0) {
                HMSLog.m7715e("HMSPackageManager", "certChain is empty");
                return false;
            }
            if (!C2343a.m6779a(C2343a.m6772a(this.f7949a), m6782b)) {
                HMSLog.m7715e("HMSPackageManager", "failed to verify cert chain");
                return false;
            }
            X509Certificate x509Certificate = m6782b.get(m6782b.size() - 1);
            if (!C2343a.m6777a(x509Certificate, "Huawei CBG HMS")) {
                HMSLog.m7715e("HMSPackageManager", "CN is invalid");
                return false;
            }
            if (!C2343a.m6784b(x509Certificate, "Huawei CBG Cloud Security Signer")) {
                HMSLog.m7715e("HMSPackageManager", "OU is invalid");
                return false;
            }
            if (C2343a.m6778a(x509Certificate, str, str2)) {
                return true;
            }
            HMSLog.m7715e("HMSPackageManager", "signature is invalid: " + str);
            return false;
        }
        HMSLog.m7715e("HMSPackageManager", "args is invalid");
        return false;
    }

    /* renamed from: a */
    private static String m7747a(int i2) {
        if (i2 == 1) {
            return "SPOOFED";
        }
        if (i2 == 2) {
            return HttpConstant.SUCCESS;
        }
        if (i2 == 3) {
            return "UNCHECKED";
        }
        HMSLog.m7715e("HMSPackageManager", "invalid checkMDM state: " + i2);
        return "";
    }
}
