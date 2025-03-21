package com.huawei.hms.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.p171ui.NotInstalledHmsAdapter;
import com.huawei.hms.adapter.p171ui.UpdateAdapter;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.adapter.sysobs.SystemObserver;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.note.AppSpoofResolution;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSBIInitializer;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.UIUtil;

/* loaded from: classes.dex */
public class AvailableAdapter {

    /* renamed from: a */
    private final int f7039a;

    /* renamed from: b */
    private AvailableCallBack f7040b;

    /* renamed from: d */
    private SystemObserver f7042d = new C2286a();

    /* renamed from: c */
    private boolean f7041c = false;

    public interface AvailableCallBack {
        void onComplete(int i2);
    }

    /* renamed from: com.huawei.hms.adapter.AvailableAdapter$a */
    class C2286a implements SystemObserver {
        C2286a() {
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemObserver
        public boolean onNoticeResult(int i2) {
            AvailableCallBack m6528a = AvailableAdapter.this.m6528a();
            if (m6528a == null) {
                HMSLog.m7715e("AvailableAdapter", "onNoticeResult baseCallBack null");
                return true;
            }
            m6528a.onComplete(i2);
            return true;
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemObserver
        public boolean onSolutionResult(Intent intent, String str) {
            return false;
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemObserver
        public boolean onUpdateResult(int i2) {
            AvailableCallBack m6528a = AvailableAdapter.this.m6528a();
            if (m6528a == null) {
                HMSLog.m7715e("AvailableAdapter", "onUpdateResult baseCallBack null");
                return true;
            }
            m6528a.onComplete(i2);
            return true;
        }
    }

    public AvailableAdapter(int i2) {
        this.f7039a = i2;
    }

    /* renamed from: b */
    private void m6532b(Context context) {
        HMSBIInitializer.getInstance(context).initBI();
    }

    public int checkHuaweiMobileServicesForUpdate(Context context) {
        Checker.checkNonNull(context, "context must not be null.");
        int m6527a = m6527a(context);
        if (m6527a != 0 || !HMSPackageManager.getInstance(context).isApkNeedUpdate(this.f7039a)) {
            return m6527a;
        }
        HMSLog.m7717i("AvailableAdapter", "The current version does not meet the target version requirements");
        return 2;
    }

    public int isHuaweiMobileServicesAvailable(Context context) {
        Checker.checkNonNull(context, "context must not be null.");
        int m6527a = m6527a(context);
        if (m6527a != 0 || !HMSPackageManager.getInstance(context).isApkUpdateNecessary(this.f7039a)) {
            return m6527a;
        }
        HMSLog.m7717i("AvailableAdapter", "The current version does not meet the minimum version requirements");
        return 2;
    }

    public boolean isUserNoticeError(int i2) {
        return i2 == 29;
    }

    public boolean isUserResolvableError(int i2) {
        return i2 == 1 || i2 == 2;
    }

    public void setCalledBySolutionInstallHms(boolean z) {
        this.f7041c = z;
    }

    public void startNotice(Activity activity, AvailableCallBack availableCallBack) {
        if (activity == null || availableCallBack == null) {
            return;
        }
        if (UIUtil.isBackground(activity)) {
            HMSLog.m7717i("AvailableAdapter", "current app is in Background");
            availableCallBack.onComplete(28);
        } else {
            HMSLog.m7717i("AvailableAdapter", "startNotice");
            this.f7040b = availableCallBack;
            SystemManager.getSystemNotifier().registerObserver(this.f7042d);
            activity.startActivity(BridgeActivity.getIntentStartBridgeActivity(activity, AppSpoofResolution.class.getName()));
        }
    }

    public void startResolution(Activity activity, AvailableCallBack availableCallBack) {
        if (activity == null || availableCallBack == null) {
            return;
        }
        m6532b(activity);
        if (UIUtil.isBackground(activity)) {
            HMSLog.m7717i("AvailableAdapter", "current app is in Background");
            availableCallBack.onComplete(28);
            return;
        }
        boolean m6531a = m6531a(activity);
        if (!AvailableUtil.isInstallerLibExist(activity) && !m6531a) {
            m6530a(activity, availableCallBack);
            return;
        }
        HMSLog.m7717i("AvailableAdapter", "startResolution");
        this.f7040b = availableCallBack;
        SystemManager.getSystemNotifier().registerObserver(this.f7042d);
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(activity, UpdateAdapter.class.getName());
        intentStartBridgeActivity.putExtra(CommonCode.MapKey.UPDATE_VERSION, this.f7039a);
        if (this.f7041c) {
            intentStartBridgeActivity.putExtra("installHMS", "installHMS");
        }
        intentStartBridgeActivity.putExtra(CommonCode.MapKey.NEW_UPDATE, m6531a);
        activity.startActivity(intentStartBridgeActivity);
    }

    /* renamed from: a */
    private int m6527a(Context context) {
        if (Build.VERSION.SDK_INT < 16) {
            HMSLog.m7717i("AvailableAdapter", "HMS can not be supported under android 4.1");
            return 21;
        }
        if (HMSPackageManager.getInstance(context).isUseOldCertificate()) {
            HMSLog.m7715e("AvailableAdapter", "The CP uses the old certificate to terminate the connection.");
            return 13;
        }
        PackageManagerHelper.PackageStates hMSPackageStatesForMultiService = HMSPackageManager.getInstance(context).getHMSPackageStatesForMultiService();
        if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(hMSPackageStatesForMultiService)) {
            HMSLog.m7717i("AvailableAdapter", "HMS is not installed");
            return 1;
        }
        if (PackageManagerHelper.PackageStates.SPOOF.equals(hMSPackageStatesForMultiService)) {
            HMSLog.m7717i("AvailableAdapter", "HMS is spoofed");
            return 29;
        }
        if (!PackageManagerHelper.PackageStates.DISABLED.equals(hMSPackageStatesForMultiService)) {
            return 0;
        }
        HMSLog.m7717i("AvailableAdapter", "HMS is disabled");
        return 3;
    }

    /* renamed from: a */
    private void m6530a(Activity activity, AvailableCallBack availableCallBack) {
        HMSLog.m7717i("AvailableAdapter", "<showHmsApkNotInstalledDialog> startResolution");
        if (NotInstalledHmsAdapter.getShowLock()) {
            this.f7040b = availableCallBack;
            SystemManager.getSystemNotifier().registerObserver(this.f7042d);
            activity.startActivity(BridgeActivity.getIntentStartBridgeActivity(activity, NotInstalledHmsAdapter.class.getName()));
            return;
        }
        availableCallBack.onComplete(31);
    }

    /* renamed from: a */
    private boolean m6531a(Activity activity) {
        if (HMSPackageManager.getInstance(activity).isUpdateHmsForThirdPartyDevice() || HMSPackageManager.getInstance(activity).getHmsVersionCode() < 40000000) {
            return false;
        }
        HMSLog.m7717i("AvailableAdapter", "enter 4.0 HmsCore upgrade process");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public AvailableCallBack m6528a() {
        return this.f7040b;
    }
}
