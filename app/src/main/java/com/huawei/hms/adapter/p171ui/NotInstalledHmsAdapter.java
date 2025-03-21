package com.huawei.hms.adapter.p171ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.p183ui.NotInstalledHmsDialogHelper;

/* loaded from: classes.dex */
public class NotInstalledHmsAdapter implements IBridgeActivityDelegate {

    /* renamed from: c */
    private static final Object f7098c = new Object();

    /* renamed from: d */
    private static boolean f7099d;

    /* renamed from: a */
    private Activity f7100a;

    /* renamed from: b */
    private Dialog f7101b;

    /* renamed from: com.huawei.hms.adapter.ui.NotInstalledHmsAdapter$a */
    private static class DialogInterfaceOnCancelListenerC2295a implements DialogInterface.OnCancelListener {

        /* renamed from: a */
        private final Activity f7102a;

        public DialogInterfaceOnCancelListenerC2295a(Activity activity) {
            this.f7102a = activity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            HMSLog.m7717i("NotInstalledHmsAdapter", "<Dialog onCancel>");
            SystemManager.getInstance().notifyUpdateResult(13);
            this.f7102a.finish();
        }
    }

    /* renamed from: com.huawei.hms.adapter.ui.NotInstalledHmsAdapter$b */
    private static class DialogInterfaceOnClickListenerC2296b implements DialogInterface.OnClickListener {

        /* renamed from: a */
        private final Activity f7103a;

        public DialogInterfaceOnClickListenerC2296b(Activity activity) {
            this.f7103a = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            HMSLog.m7717i("NotInstalledHmsAdapter", "<Dialog onClick>");
            SystemManager.getInstance().notifyUpdateResult(30);
            this.f7103a.finish();
        }
    }

    /* renamed from: a */
    private void m6598a(Activity activity) {
        Dialog dialog = this.f7101b;
        if (dialog != null && dialog.isShowing()) {
            this.f7101b.setOnCancelListener(null);
            this.f7101b.cancel();
        }
        this.f7101b = NotInstalledHmsDialogHelper.getDialogBuilder(activity).setPositiveButton(NotInstalledHmsDialogHelper.getConfirmResId(activity), new DialogInterfaceOnClickListenerC2296b(activity)).setOnCancelListener(new DialogInterfaceOnCancelListenerC2295a(activity)).show();
    }

    public static boolean getShowLock() {
        synchronized (f7098c) {
            HMSLog.m7717i("NotInstalledHmsAdapter", "<canShowDialog> sIsShowingDialog: " + f7099d);
            if (f7099d) {
                return false;
            }
            f7099d = true;
            return true;
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        HMSLog.m7717i("NotInstalledHmsAdapter", "<getRequestCode>");
        return 0;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        HMSLog.m7717i("NotInstalledHmsAdapter", "<onBridgeActivityCreate>");
        if (activity == null || activity.isFinishing()) {
            HMSLog.m7715e("NotInstalledHmsAdapter", "<onBridgeActivityCreate> activity is null or finishing");
        } else {
            this.f7100a = activity;
            m6598a(activity);
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.m7717i("NotInstalledHmsAdapter", "<onBridgeActivityDestroy>");
        synchronized (f7098c) {
            f7099d = false;
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i2, int i3, Intent intent) {
        HMSLog.m7717i("NotInstalledHmsAdapter", "<onBridgeActivityResult>");
        return false;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        HMSLog.m7717i("NotInstalledHmsAdapter", "<onBridgeConfigurationChanged>");
        Activity activity = this.f7100a;
        if (activity == null || activity.isFinishing()) {
            HMSLog.m7715e("NotInstalledHmsAdapter", "<onBridgeConfigurationChanged> mActivity is null or finishing");
        } else {
            m6598a(this.f7100a);
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i2, KeyEvent keyEvent) {
        HMSLog.m7717i("NotInstalledHmsAdapter", "<onKeyUp>");
    }
}
