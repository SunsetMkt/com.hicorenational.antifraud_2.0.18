package com.huawei.hms.update.note;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.availableupdate.C2310a;
import com.huawei.hms.p182ui.AbstractDialog;
import com.huawei.hms.p182ui.AbstractPromptDialog;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;

/* loaded from: classes.dex */
public class AppSpoofResolution implements IBridgeActivityDelegate {

    /* renamed from: a */
    private Activity f7904a;

    /* renamed from: b */
    private C2535b f7905b;

    /* renamed from: com.huawei.hms.update.note.AppSpoofResolution$a */
    class C2534a implements AbstractDialog.Callback {
        C2534a() {
        }

        @Override // com.huawei.hms.ui.AbstractDialog.Callback
        public void onCancel(AbstractDialog abstractDialog) {
            C2310a.f7165c.m6654a(true);
            AppSpoofResolution.this.f7905b = null;
            AppSpoofResolution.this.m7721a();
        }

        @Override // com.huawei.hms.ui.AbstractDialog.Callback
        public void onDoWork(AbstractDialog abstractDialog) {
            C2310a.f7165c.m6654a(true);
            AppSpoofResolution.this.f7905b = null;
            AppSpoofResolution.this.m7721a();
        }
    }

    /* renamed from: com.huawei.hms.update.note.AppSpoofResolution$b */
    private static class C2535b extends AbstractPromptDialog {
        private C2535b() {
        }

        @Override // com.huawei.hms.p182ui.AbstractDialog
        public String onGetMessageString(Context context) {
            String applicationName = new PackageManagerHelper(context).getApplicationName("com.huawei.hwid");
            if (TextUtils.isEmpty(applicationName)) {
                applicationName = "com.huawei.hwid";
            }
            if (ResourceLoaderUtil.getmContext() == null) {
                ResourceLoaderUtil.setmContext(context);
            }
            return ResourceLoaderUtil.getString("hms_is_spoof", applicationName);
        }

        @Override // com.huawei.hms.p182ui.AbstractDialog
        public String onGetPositiveButtonString(Context context) {
            if (ResourceLoaderUtil.getmContext() == null) {
                ResourceLoaderUtil.setmContext(context);
            }
            return ResourceLoaderUtil.getString("hms_confirm");
        }

        @Override // com.huawei.hms.p182ui.AbstractPromptDialog, com.huawei.hms.p182ui.AbstractDialog
        public String onGetTitleString(Context context) {
            if (ResourceLoaderUtil.getmContext() == null) {
                ResourceLoaderUtil.setmContext(context);
            }
            return ResourceLoaderUtil.getString("hms_spoof_hints");
        }

        /* synthetic */ C2535b(C2534a c2534a) {
            this();
        }
    }

    /* renamed from: b */
    private void m7723b() {
        Activity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        C2535b c2535b = this.f7905b;
        if (c2535b == null) {
            this.f7905b = new C2535b(null);
        } else {
            c2535b.dismiss();
        }
        HMSLog.m7717i("AppSpoofResolution", "enter AppSpoofResolution showPromptdlg to resolve conn error");
        this.f7905b.show(activity, new C2534a());
    }

    protected Activity getActivity() {
        return this.f7904a;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 0;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        HMSLog.m7717i("AppSpoofResolution", "enter AppSpoofResolution onBridgeActivityCreate");
        if (activity == null || activity.isFinishing()) {
            HMSLog.m7715e("AppSpoofResolution", "activity is null or finishing");
            return;
        }
        this.f7904a = activity;
        C2310a c2310a = C2310a.f7165c;
        c2310a.m6653a(activity);
        c2310a.m6654a(false);
        m7723b();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.m7717i("AppSpoofResolution", "enter AppSpoofResolution onBridgeActivityDestroy");
        C2310a c2310a = C2310a.f7165c;
        if (c2310a.m6652a().compareAndSet(true, false)) {
            SystemManager.getInstance().notifyNoticeResult(29);
        }
        c2310a.m6655b(this.f7904a);
        this.f7904a = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i2, int i3, Intent intent) {
        if (i2 != getRequestCode()) {
            return false;
        }
        HMSLog.m7717i("AppSpoofResolution", "enter AppSpoofResolution onBridgeActivityResult");
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        if (this.f7905b == null) {
            return;
        }
        HMSLog.m7717i("AppSpoofResolution", "enter AppSpoofResolution re show prompt dialog");
        m7723b();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i2, KeyEvent keyEvent) {
        HMSLog.m7717i("AppSpoofResolution", "enter AppSpoofResolution On key up when resolve spoof error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7721a() {
        Activity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        HMSLog.m7717i("AppSpoofResolution", "enter AppSpoofResolution finishBridgeActivity：");
        if (C2310a.f7165c.m6652a().compareAndSet(true, false)) {
            SystemManager.getInstance().notifyNoticeResult(29);
        }
        activity.finish();
    }
}
