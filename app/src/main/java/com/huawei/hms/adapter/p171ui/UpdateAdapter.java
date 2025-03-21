package com.huawei.hms.adapter.p171ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.AvailableUtil;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.availableupdate.C2312c;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.update.p183ui.UpdateBean;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class UpdateAdapter implements IBridgeActivityDelegate {

    /* renamed from: a */
    private WeakReference<Activity> f7104a;

    /* renamed from: b */
    private Context f7105b;

    /* renamed from: c */
    private int f7106c;

    /* renamed from: d */
    private UpdateBean f7107d;

    /* renamed from: e */
    private boolean f7108e = false;

    /* renamed from: a */
    private static Object m6599a(String str, String str2, Object[] objArr) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            HMSLog.m7715e("UpdateAdapter", "className is empty.");
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            HMSLog.m7715e("UpdateAdapter", "methodName is empty.");
            return null;
        }
        if (objArr == null) {
            HMSLog.m7715e("UpdateAdapter", "args is null.");
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (objArr[i2] instanceof Activity) {
                clsArr[i2] = Activity.class;
            } else if (objArr[i2] instanceof Context) {
                clsArr[i2] = Context.class;
            } else if (objArr[i2] instanceof UpdateBean) {
                clsArr[i2] = UpdateBean.class;
            } else if (objArr[i2] instanceof Integer) {
                clsArr[i2] = Integer.TYPE;
            } else if (objArr[i2] instanceof Boolean) {
                clsArr[i2] = Boolean.TYPE;
            } else {
                HMSLog.m7715e("UpdateAdapter", "not set args[" + i2 + "] type");
            }
        }
        Class<?> cls = Class.forName(str);
        return cls.getMethod(str2, clsArr).invoke(cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), objArr);
    }

    /* renamed from: b */
    private Activity m6604b() {
        WeakReference<Activity> weakReference = this.f7104a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* renamed from: c */
    private void m6605c() {
        SystemManager.getInstance().notifyUpdateResult(8);
        m6600a();
    }

    public static Object invokeMethod(String str, String str2, Object[] objArr) {
        try {
            return m6599a(str, str2, objArr);
        } catch (Throwable th) {
            HMSLog.m7715e("UpdateAdapter", "invoke " + str + "." + str2 + " fail. " + th.getMessage());
            return null;
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 1001;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        if (activity == null) {
            HMSLog.m7717i("UpdateAdapter", "activity == null");
            m6605c();
            return;
        }
        if (activity.isFinishing()) {
            HMSLog.m7717i("UpdateAdapter", "activity is finishing");
            m6605c();
            return;
        }
        this.f7105b = activity.getApplicationContext();
        this.f7104a = new WeakReference<>(activity);
        if (C2312c.f7172b.m6659a(m6604b())) {
            Intent intent = activity.getIntent();
            if (intent == null) {
                m6605c();
                return;
            }
            try {
                this.f7106c = intent.getIntExtra(CommonCode.MapKey.UPDATE_VERSION, 0);
            } catch (Throwable th) {
                HMSLog.m7715e("UpdateAdapter", "get update_version:" + th.getMessage());
            }
            if (this.f7106c == 0) {
                m6605c();
                return;
            }
            if (intent.hasExtra("installHMS")) {
                this.f7108e = true;
            }
            if (m6603a(intent, activity)) {
                return;
            }
            try {
                if (AvailableUtil.isInstallerLibExist(this.f7105b)) {
                    UpdateBean updateBean = (UpdateBean) m6599a("com.huawei.hms.adapter.ui.InstallerAdapter", "setUpdateBean", new Object[]{activity, Integer.valueOf(this.f7106c), Boolean.valueOf(this.f7108e)});
                    this.f7107d = updateBean;
                    m6599a("com.huawei.hms.adapter.ui.InstallerAdapter", "startUpdateHms", new Object[]{activity, updateBean, 1001});
                    this.f7107d = null;
                }
            } catch (Throwable th2) {
                HMSLog.m7715e("UpdateAdapter", "InstallerAdapter.startUpdateHms is failed. message：" + th2.getMessage());
                m6605c();
            }
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.m7717i("UpdateAdapter", "onBridgeActivityDestroy");
        C2312c.f7172b.m6660b(m6604b());
        this.f7104a = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i2, int i3, Intent intent) {
        int i4;
        if (i2 != getRequestCode()) {
            this.f7107d = null;
            return false;
        }
        HMSLog.m7717i("UpdateAdapter", "onBridgeActivityResult " + i3);
        if (AvailableUtil.isInstallerLibExist(this.f7105b) && i3 == 1214) {
            HMSLog.m7717i("UpdateAdapter", "Enter update escape route");
            Activity m6604b = m6604b();
            if (m6604b == null) {
                HMSLog.m7715e("UpdateAdapter", "bridgeActivity is null, update escape failed ");
                this.f7107d = null;
                return true;
            }
            invokeMethod("com.huawei.hms.update.manager.UpdateManager", "startUpdate", new Object[]{m6604b, 1001, this.f7107d});
            this.f7107d = null;
        }
        if (i3 == -1) {
            if (intent != null) {
                try {
                    i4 = intent.getIntExtra(KpmsConstant.KIT_UPDATE_RESULT, 0);
                } catch (Throwable unused) {
                    HMSLog.m7718w("UpdateAdapter", "get kit_update_result failed, throwable occur.");
                    i4 = 0;
                }
                if (i4 == 1) {
                    HMSLog.m7717i("UpdateAdapter", "new framework update process,Error resolved successfully!");
                    SystemManager.getInstance().notifyUpdateResult(0);
                    this.f7107d = null;
                    m6600a();
                    return true;
                }
                m6601a(intent);
            }
        } else if (i3 == 0) {
            HMSLog.m7717i("UpdateAdapter", "Activity.RESULT_CANCELED");
            this.f7107d = null;
            Activity m6604b2 = m6604b();
            if (m6604b2 == null) {
                return true;
            }
            String hMSPackageName = HMSPackageManager.getInstance(m6604b2.getApplicationContext()).getHMSPackageName();
            if (TextUtils.isEmpty(hMSPackageName)) {
                hMSPackageName = "com.huawei.hwid";
            }
            if (this.f7108e || m6602a(m6604b2, hMSPackageName, this.f7106c)) {
                HMSLog.m7717i("UpdateAdapter", "Resolve error, process canceled by user clicking back button!");
                SystemManager.getInstance().notifyUpdateResult(13);
            } else {
                SystemManager.getInstance().notifyUpdateResult(0);
            }
        } else if (i3 == 1) {
            SystemManager.getInstance().notifyUpdateResult(28);
        }
        m6600a();
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        HMSLog.m7717i("UpdateAdapter", "onBridgeConfigurationChanged");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i2, KeyEvent keyEvent) {
        HMSLog.m7717i("UpdateAdapter", "On key up when resolve conn error");
    }

    /* renamed from: a */
    private boolean m6603a(Intent intent, Activity activity) {
        if (!intent.getBooleanExtra(CommonCode.MapKey.NEW_UPDATE, false)) {
            return false;
        }
        HMSLog.m7717i("UpdateAdapter", "4.0 framework HMSCore upgrade process");
        String hMSPackageName = HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageName();
        if (TextUtils.isEmpty(hMSPackageName)) {
            HMSLog.m7718w("UpdateAdapter", "hmsPackageName is empty, update invalid.");
            m6605c();
            return true;
        }
        ComponentName componentName = new ComponentName(hMSPackageName, "com.huawei.hms.fwksdk.stub.UpdateStubActivity");
        Intent intent2 = new Intent();
        intent2.putExtra(KpmsConstant.CALLER_PACKAGE_NAME, activity.getApplicationContext().getPackageName());
        intent2.putExtra(KpmsConstant.UPDATE_PACKAGE_NAME, hMSPackageName);
        intent2.setComponent(componentName);
        activity.startActivityForResult(intent2, 1001);
        return true;
    }

    /* renamed from: a */
    private void m6601a(Intent intent) {
        int i2 = -1;
        try {
            i2 = intent.getIntExtra(BridgeActivity.EXTRA_RESULT, -1);
        } catch (Throwable unused) {
            HMSLog.m7718w("UpdateAdapter", "get extra_result failed, throwable occur.");
        }
        if (i2 == 0) {
            HMSLog.m7717i("UpdateAdapter", "Error resolved successfully!");
            SystemManager.getInstance().notifyUpdateResult(0);
        } else if (i2 == 13) {
            HMSLog.m7717i("UpdateAdapter", "Resolve error process canceled by user!");
            SystemManager.getInstance().notifyUpdateResult(13);
        } else if (i2 == 8) {
            HMSLog.m7717i("UpdateAdapter", "Internal error occurred, recommended retry.");
            SystemManager.getInstance().notifyUpdateResult(8);
        } else {
            HMSLog.m7717i("UpdateAdapter", "Other error codes.");
            SystemManager.getInstance().notifyUpdateResult(i2);
        }
    }

    /* renamed from: a */
    private void m6600a() {
        Activity m6604b = m6604b();
        if (m6604b == null || m6604b.isFinishing()) {
            return;
        }
        m6604b.finish();
    }

    /* renamed from: a */
    private boolean m6602a(Context context, String str, int i2) {
        if (context != null && !TextUtils.isEmpty(str) && i2 != 0) {
            PackageManagerHelper packageManagerHelper = new PackageManagerHelper(context);
            return PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(packageManagerHelper.getPackageStates(str)) || packageManagerHelper.getPackageVersionCode(str) < i2;
        }
        HMSLog.m7718w("UpdateAdapter", "Please check your params, one of params is invalid.");
        return false;
    }
}
