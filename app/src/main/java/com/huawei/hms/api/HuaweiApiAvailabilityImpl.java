package com.huawei.hms.api;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.EnableServiceActivity;
import com.huawei.hms.activity.ForegroundIntentBuilder;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.BusResponseResult;
import com.huawei.hms.adapter.AvailableUtil;
import com.huawei.hms.adapter.p171ui.UpdateAdapter;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ErrorDialogFragment;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.api.AvailabilityException;
import com.huawei.hms.common.api.HuaweiApiCallable;
import com.huawei.hms.common.internal.ConnectionErrorMessages;
import com.huawei.hms.common.internal.DialogRedirect;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.note.AppSpoofResolution;
import com.huawei.hms.update.note.DoNothingResolution;
import com.huawei.hms.update.note.NotInstalledHmsResolution;
import com.huawei.hms.update.p183ui.UpdateBean;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.UIUtil;
import com.huawei.hms.utils.Util;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* loaded from: classes.dex */
final class HuaweiApiAvailabilityImpl extends HuaweiApiAvailability {

    /* renamed from: a */
    private static final HuaweiApiAvailabilityImpl f7115a = new HuaweiApiAvailabilityImpl();

    /* renamed from: com.huawei.hms.api.HuaweiApiAvailabilityImpl$a */
    class C2302a implements BusResponseCallback {

        /* renamed from: a */
        final /* synthetic */ TaskCompletionSource[] f7116a;

        C2302a(TaskCompletionSource[] taskCompletionSourceArr) {
            this.f7116a = taskCompletionSourceArr;
        }

        @Override // com.huawei.hms.activity.internal.BusResponseCallback
        public BusResponseResult innerError(Activity activity, int i2, String str) {
            HMSLog.m7715e("HuaweiApiAvailabilityImpl", "Test foreground bus error: resultCode " + i2 + ", errMessage" + str);
            this.f7116a[0].setException(new AvailabilityException());
            return null;
        }

        @Override // com.huawei.hms.activity.internal.BusResponseCallback
        public BusResponseResult succeedReturn(Activity activity, int i2, Intent intent) {
            HMSLog.m7717i("HuaweiApiAvailabilityImpl", "Test foreground bus success: resultCode " + i2 + ", data" + intent);
            return null;
        }
    }

    private HuaweiApiAvailabilityImpl() {
    }

    /* renamed from: a */
    private static Intent m6614a(Activity activity, String str) {
        return BridgeActivity.getIntentStartBridgeActivity(activity, str);
    }

    public static HuaweiApiAvailabilityImpl getInstance() {
        return f7115a;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public Task<Void> checkApiAccessible(HuaweiApi<?> huaweiApi, HuaweiApi<?>... huaweiApiArr) {
        Task<Void> task = new TaskCompletionSource().getTask();
        if (huaweiApi != null) {
            try {
                m6618a(huaweiApi);
            } catch (AvailabilityException e2) {
                HMSLog.m7717i("HuaweiApiAvailabilityImpl", "checkApi has AvailabilityException " + e2.getMessage());
            }
        }
        if (huaweiApiArr != null) {
            for (HuaweiApi<?> huaweiApi2 : huaweiApiArr) {
                m6618a(huaweiApi2);
            }
        }
        return task;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public PendingIntent getErrPendingIntent(Context context, ConnectionResult connectionResult) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(connectionResult);
        return getResolveErrorPendingIntent(context, connectionResult.getErrorCode());
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public Dialog getErrorDialog(Activity activity, int i2, int i3) {
        Checker.checkNonNull(activity, "activity must not be null.");
        HMSLog.m7717i("HuaweiApiAvailabilityImpl", "Enter getErrorDialog, errorCode: " + i2);
        return getErrorDialog(activity, i2, i3, null);
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public String getErrorString(int i2) {
        HMSLog.m7717i("HuaweiApiAvailabilityImpl", "Enter getErrorString, errorCode: " + i2);
        return ConnectionResult.getErrorString(i2);
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public Task<Void> getHuaweiServicesReady(Activity activity) {
        Preconditions.checkNotNull(activity);
        TaskCompletionSource[] taskCompletionSourceArr = {new TaskCompletionSource()};
        Task<Void> task = taskCompletionSourceArr[0].getTask();
        int isHuaweiMobileServicesAvailable = isHuaweiMobileServicesAvailable(activity.getApplicationContext(), 30000000);
        Intent resolveErrorIntent = getResolveErrorIntent(activity, isHuaweiMobileServicesAvailable);
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(activity, ResolutionDelegate.class.getName());
        if (resolveErrorIntent != null) {
            ForegroundIntentBuilder.registerResponseCallback(ResolutionDelegate.CALLBACK_METHOD, new C2302a(taskCompletionSourceArr));
            Bundle bundle = new Bundle();
            bundle.putParcelable("resolution", resolveErrorIntent);
            intentStartBridgeActivity.putExtras(bundle);
            activity.startActivity(intentStartBridgeActivity);
        } else if (isHuaweiMobileServicesAvailable == 3) {
            Intent intent = new Intent();
            intent.setClass(activity, EnableServiceActivity.class);
            activity.startActivity(intent);
        } else if (isHuaweiMobileServicesAvailable == 0) {
            HMSLog.m7717i("HuaweiApiAvailabilityImpl", "The HMS service is available.");
        } else {
            HMSLog.m7715e("HuaweiApiAvailabilityImpl", "Framework can not solve the availability problem.");
            taskCompletionSourceArr[0].setException(new AvailabilityException());
        }
        return task;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public Intent getResolveErrorIntent(Activity activity, int i2) {
        HMSLog.m7717i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorIntent, errorCode: " + i2);
        if (activity == null) {
            return null;
        }
        if (i2 == 1 || i2 == 2) {
            return (Util.isAvailableLibExist(activity) && AvailableUtil.isInstallerLibExist(activity)) ? (Intent) UpdateAdapter.invokeMethod("com.huawei.hms.update.manager.UpdateManager", "getStartUpdateIntent", new Object[]{activity, m6616a(activity.getApplicationContext())}) : m6614a(activity, NotInstalledHmsResolution.class.getName());
        }
        if (i2 == 6) {
            return m6614a(activity, BindingFailedResolution.class.getName());
        }
        if (i2 == 9 && Util.isAvailableLibExist(activity)) {
            return m6614a(activity, AppSpoofResolution.class.getName());
        }
        return null;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public PendingIntent getResolveErrorPendingIntent(Activity activity, int i2) {
        HMSLog.m7717i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorPendingIntent, errorCode: " + i2);
        Intent resolveErrorIntent = getResolveErrorIntent(activity, i2);
        if (resolveErrorIntent != null) {
            return PendingIntent.getActivity(activity, 0, resolveErrorIntent, AbstractC1191a.f2487B1);
        }
        return null;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public int isHuaweiMobileNoticeAvailable(Context context) {
        Checker.checkNonNull(context, "context must not be null.");
        PackageManagerHelper packageManagerHelper = new PackageManagerHelper(context);
        String hMSPackageNameForMultiService = HMSPackageManager.getInstance(context).getHMSPackageNameForMultiService();
        if (TextUtils.isEmpty(hMSPackageNameForMultiService)) {
            HMSLog.m7718w("HuaweiApiAvailabilityImpl", "hmsPackageName is empty, Service is invalid.");
            return 1;
        }
        if (!PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(packageManagerHelper.getPackageStates(hMSPackageNameForMultiService))) {
            return HMSPackageManager.getInstance(context).isApkUpdateNecessary(20600000) ? 2 : 0;
        }
        HMSLog.m7718w("HuaweiApiAvailabilityImpl", "hmsPackageName is not installed, Service is invalid.");
        return 1;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public int isHuaweiMobileServicesAvailable(Context context) {
        Checker.checkNonNull(context, "context must not be null.");
        return HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(context, HuaweiApiAvailability.getServicesVersionCode());
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public boolean isUserResolvableError(int i2) {
        return isUserResolvableError(i2, null);
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public boolean isUserResolvableError(int i2, PendingIntent pendingIntent) {
        if (i2 == 0) {
            return false;
        }
        return pendingIntent != null || i2 == 1 || i2 == 2 || i2 == 6 || i2 == 9;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public void popupErrNotification(Context context, ConnectionResult connectionResult) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(connectionResult);
        showErrorNotification(context, connectionResult.getErrorCode());
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public void resolveError(Activity activity, int i2, int i3) {
        resolveError(activity, i2, i3, null);
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public boolean showErrorDialogFragment(Activity activity, int i2, int i3) {
        return showErrorDialogFragment(activity, i2, i3, null);
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public void showErrorNotification(Context context, int i2) {
        Checker.checkNonNull(context, "context must not be null.");
        HMSLog.m7717i("HuaweiApiAvailabilityImpl", "Enter showErrorNotification, errorCode: " + i2);
        if (!(context instanceof Activity)) {
            HMSLog.m7717i("HuaweiApiAvailabilityImpl", "context not instanceof Activity");
            return;
        }
        Dialog errorDialog = getErrorDialog((Activity) context, i2, 0);
        if (errorDialog == null) {
            HMSLog.m7717i("HuaweiApiAvailabilityImpl", "showErrorNotification errorDialog can not be null");
        } else {
            errorDialog.show();
        }
    }

    /* renamed from: a */
    private static Intent m6615a(Context context, String str) {
        return BridgeActivity.getIntentStartBridgeActivity(context, str);
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public void resolveError(Activity activity, int i2, int i3, PendingIntent pendingIntent) {
        Checker.checkNonNull(activity, "activity must not be null.");
        if (pendingIntent != null) {
            HMSLog.m7717i("HuaweiApiAvailabilityImpl", "Enter resolveError, param pendingIntent is not null. and.errorCode: " + i2);
        } else {
            HMSLog.m7717i("HuaweiApiAvailabilityImpl", "Enter resolveError, param pendingIntent is  null. get pendingIntent from error code.and.errorCode: " + i2);
            pendingIntent = getResolveErrorPendingIntent(activity, i2);
        }
        if (pendingIntent != null) {
            HMSLog.m7717i("HuaweiApiAvailabilityImpl", "In resolveError, start pendingIntent.errorCode: " + i2);
            try {
                activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i3, null, 0, 0, 0);
            } catch (IntentSender.SendIntentException unused) {
                HMSLog.m7715e("HuaweiApiAvailabilityImpl", "Enter resolveError, start pendingIntent failed.errorCode: " + i2);
            }
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public boolean showErrorDialogFragment(Activity activity, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        Dialog errorDialog = getErrorDialog(activity, i2, i3, onCancelListener);
        if (errorDialog == null) {
            return false;
        }
        m6617a(activity, errorDialog, HuaweiMobileServicesUtil.HMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    /* renamed from: a */
    private UpdateBean m6616a(Context context) {
        UpdateBean updateBean = new UpdateBean();
        updateBean.setHmsOrApkUpgrade(true);
        updateBean.setClientPackageName(HMSPackageManager.getInstance(context).getHMSPackageName());
        if (TextUtils.isEmpty(updateBean.getClientPackageName())) {
            updateBean.setClientPackageName("com.huawei.hwid");
        }
        updateBean.setClientVersionCode(HuaweiApiAvailability.getServicesVersionCode());
        updateBean.setClientAppId("C10132067");
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(context);
        }
        try {
            updateBean.setClientAppName(ResourceLoaderUtil.getString("hms_update_title"));
        } catch (Exception e2) {
            HMSLog.m7715e("HuaweiApiAvailabilityImpl", "getString has Exception:" + e2.getMessage());
        }
        return updateBean;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public Dialog getErrorDialog(Activity activity, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        Checker.checkNonNull(activity, "activity must not be null.");
        HMSLog.m7717i("HuaweiApiAvailabilityImpl", "Enter getErrorDialog, errorCode: " + i2);
        return m6612a(activity, i2, DialogRedirect.getInstance(activity, m6613a(activity, i2), i3), onCancelListener);
    }

    public PendingIntent getResolveErrorPendingIntent(Context context, int i2) {
        HMSLog.m7717i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorPendingIntent, errorCode: " + i2);
        Intent resolveErrorIntent = getResolveErrorIntent(context, i2);
        if (resolveErrorIntent != null) {
            return PendingIntent.getActivity(context, 0, resolveErrorIntent, AbstractC1191a.f2487B1);
        }
        return null;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public int isHuaweiMobileServicesAvailable(Context context, int i2) {
        Checker.checkNonNull(context, "context must not be null.");
        return HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(context, i2);
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public boolean showErrorDialogFragment(Activity activity, int i2, Fragment fragment, int i3, DialogInterface.OnCancelListener onCancelListener) {
        return showErrorDialogFragment(activity, i2, i3, onCancelListener);
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public PendingIntent getErrPendingIntent(Context context, int i2, int i3) {
        HMSLog.m7717i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorPendingIntent, errorCode: " + i2 + " requestCode: " + i3);
        Intent resolveErrorIntent = getResolveErrorIntent(context, i2);
        if (resolveErrorIntent != null) {
            return PendingIntent.getActivity(context, i3, resolveErrorIntent, AbstractC1191a.f2487B1);
        }
        return null;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public Task<Void> checkApiAccessible(HuaweiApiCallable huaweiApiCallable, HuaweiApiCallable... huaweiApiCallableArr) {
        Task<Void> task = new TaskCompletionSource().getTask();
        if (huaweiApiCallable != null) {
            try {
                m6618a(huaweiApiCallable);
            } catch (AvailabilityException e2) {
                HMSLog.m7717i("HuaweiApiAvailabilityImpl", "HuaweiApiCallable checkApi has AvailabilityException " + e2.getMessage());
            }
        }
        if (huaweiApiCallableArr != null) {
            for (HuaweiApiCallable huaweiApiCallable2 : huaweiApiCallableArr) {
                m6618a(huaweiApiCallable2);
            }
        }
        return task;
    }

    public Intent getResolveErrorIntent(Context context, int i2) {
        HMSLog.m7717i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorIntent, errorCode: " + i2);
        if (i2 == 1 || i2 == 2) {
            if (Util.isAvailableLibExist(context) && AvailableUtil.isInstallerLibExist(context)) {
                return (Intent) UpdateAdapter.invokeMethod("com.huawei.hms.update.manager.UpdateManager", "getStartUpdateIntent", new Object[]{context, m6616a(context.getApplicationContext())});
            }
            return m6615a(context, NotInstalledHmsResolution.class.getName());
        }
        if (i2 != 6) {
            if (i2 == 9 && Util.isAvailableLibExist(context)) {
                return m6615a(context, AppSpoofResolution.class.getName());
            }
            return null;
        }
        return m6615a(context, BindingFailedResolution.class.getName());
    }

    /* renamed from: a */
    private Intent m6613a(Activity activity, int i2) {
        HMSLog.m7717i("HuaweiApiAvailabilityImpl", "getErrorResolutionIntent, errorCode: " + i2);
        if (i2 == 1 || i2 == 2) {
            if (Util.isAvailableLibExist(activity) && AvailableUtil.isInstallerLibExist(activity)) {
                return (Intent) UpdateAdapter.invokeMethod("com.huawei.hms.update.manager.UpdateManager", "startUpdateIntent", new Object[]{activity});
            }
            return BridgeActivity.getIntentStartBridgeActivity(activity, DoNothingResolution.class.getName());
        }
        if (i2 != 6) {
            if (i2 == 9 && Util.isAvailableLibExist(activity)) {
                return BridgeActivity.getIntentStartBridgeActivity(activity, AppSpoofResolution.class.getName());
            }
            return null;
        }
        return BridgeActivity.getIntentStartBridgeActivity(activity, BindingFailedResolution.class.getName());
    }

    /* renamed from: a */
    private static Dialog m6612a(Activity activity, int i2, DialogRedirect dialogRedirect, DialogInterface.OnCancelListener onCancelListener) {
        if (i2 == 0) {
            return null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, UIUtil.getDialogThemeId(activity));
        builder.setMessage(ConnectionErrorMessages.getErrorMessage(activity, i2));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        builder.setPositiveButton(ConnectionErrorMessages.getErrorDialogButtonMessage(activity, i2), dialogRedirect);
        if (Util.isAvailableLibExist(activity) && AvailableUtil.isInstallerLibExist(activity)) {
            String errorTitle = ConnectionErrorMessages.getErrorTitle(activity, i2);
            if (errorTitle != null) {
                builder.setTitle(errorTitle);
            }
        } else {
            String errorTitle2 = ConnectionErrorMessages.getErrorTitle(activity, i2);
            if (errorTitle2 != null) {
                builder.setTitle(errorTitle2);
            }
        }
        return builder.create();
    }

    /* renamed from: a */
    private static void m6617a(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        Checker.checkNonNull(activity, "activity must not be null.");
        ErrorDialogFragment.newInstance(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    /* renamed from: a */
    private void m6618a(Object obj) throws AvailabilityException {
        ConnectionResult connectionResult;
        AvailabilityException availabilityException = new AvailabilityException();
        if (obj instanceof HuaweiApi) {
            connectionResult = availabilityException.getConnectionResult((HuaweiApi<? extends Api.ApiOptions>) obj);
        } else {
            connectionResult = availabilityException.getConnectionResult((HuaweiApiCallable) obj);
        }
        if (connectionResult.getErrorCode() == 0) {
            return;
        }
        HMSLog.m7717i("HuaweiApiAvailabilityImpl", "The service is unavailable: " + availabilityException.getMessage());
        throw availabilityException;
    }
}
