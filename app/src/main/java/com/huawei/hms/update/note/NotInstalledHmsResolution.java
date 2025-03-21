package com.huawei.hms.update.note;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.availableupdate.C2311b;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.p183ui.NotInstalledHmsDialogHelper;

/* loaded from: classes.dex */
public class NotInstalledHmsResolution implements IBridgeActivityDelegate {

    /* renamed from: a */
    private Dialog f7907a;

    /* renamed from: b */
    private Activity f7908b;

    /* renamed from: com.huawei.hms.update.note.NotInstalledHmsResolution$a */
    private static class DialogInterfaceOnClickListenerC2536a implements DialogInterface.OnClickListener {

        /* renamed from: a */
        private final Activity f7909a;

        public DialogInterfaceOnClickListenerC2536a(Activity activity) {
            this.f7909a = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            HMSLog.m7717i("NotInstalledHmsResolution", "<Dialog onClick>");
            this.f7909a.finish();
        }
    }

    /* renamed from: a */
    private void m7725a(Activity activity) {
        m7724a();
        this.f7907a = NotInstalledHmsDialogHelper.getDialogBuilder(activity).setPositiveButton(NotInstalledHmsDialogHelper.getConfirmResId(activity), new DialogInterfaceOnClickListenerC2536a(activity)).show();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        HMSLog.m7717i("NotInstalledHmsResolution", "<Resolution getRequestCode>");
        return 0;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        HMSLog.m7717i("NotInstalledHmsResolution", "<Resolution onBridgeActivityCreate>");
        if (activity == null || activity.isFinishing()) {
            HMSLog.m7715e("NotInstalledHmsResolution", "<Resolution onBridgeActivityCreate> activity is null or finishing");
            return;
        }
        this.f7908b = activity;
        C2311b.f7169b.m6656a(activity);
        m7725a(activity);
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.m7717i("NotInstalledHmsResolution", "<Resolution onBridgeActivityDestroy>");
        m7724a();
        C2311b.f7169b.m6657b(this.f7908b);
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i2, int i3, Intent intent) {
        HMSLog.m7717i("NotInstalledHmsResolution", "<Resolution onBridgeActivityResult>");
        return false;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        HMSLog.m7717i("NotInstalledHmsResolution", "<Resolution onBridgeConfigurationChanged>");
        Activity activity = this.f7908b;
        if (activity == null || activity.isFinishing()) {
            HMSLog.m7715e("NotInstalledHmsResolution", "<Resolution onBridgeActivityCreate> mActivity is null or finishing");
        } else {
            m7725a(this.f7908b);
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i2, KeyEvent keyEvent) {
        HMSLog.m7717i("NotInstalledHmsResolution", "<Resolution onKeyUp>");
    }

    /* renamed from: a */
    private void m7724a() {
        Dialog dialog = this.f7907a;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.f7907a.cancel();
    }
}
