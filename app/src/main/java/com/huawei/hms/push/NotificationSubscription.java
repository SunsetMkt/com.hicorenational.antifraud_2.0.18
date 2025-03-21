package com.huawei.hms.push;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.notification.SubscribedItem;
import com.huawei.hms.push.task.SubscribeNotificationTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.api.entity.push.SubscribeNotificationReq;
import com.huawei.hms.support.log.HMSLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* loaded from: classes.dex */
public class NotificationSubscription {
    public static final int NOTIFICATION_SUBSCRIBE_REQUEST_CODE = 1001;

    /* renamed from: d */
    private static final String f7695d = "NotificationSubscription";

    /* renamed from: a */
    private Activity f7696a;

    /* renamed from: b */
    private Context f7697b;

    /* renamed from: c */
    private HuaweiApi<Api.ApiOptions.NoOptions> f7698c;

    private NotificationSubscription(Activity activity) {
        Preconditions.checkNotNull(activity);
        this.f7697b = activity.getApplicationContext();
        this.f7696a = activity;
        HuaweiApi<Api.ApiOptions.NoOptions> huaweiApi = new HuaweiApi<>(activity, (Api<Api.ApiOptions>) new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH), (Api.ApiOptions) null, (AbstractClientBuilder) new PushClientBuilder());
        this.f7698c = huaweiApi;
        huaweiApi.setKitSdkVersion(61200300);
    }

    /* renamed from: a */
    private Task<SubscribeResult> m7526a(List<String> list) {
        String reportEntry = PushBiUtil.reportEntry(this.f7697b, PushNaming.SUBSCRIBE_NOTIFICATION);
        if (list == null || list.isEmpty() || list.size() > 3) {
            PushBiUtil.reportExit(this.f7697b, PushNaming.SUBSCRIBE_NOTIFICATION, reportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
            HMSLog.m7715e(f7695d, "Invalid entityIds: entityId list should not be empty or more than max size");
            return m7525a(ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException());
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            PushBiUtil.reportExit(this.f7697b, PushNaming.SUBSCRIBE_NOTIFICATION, reportEntry, ErrorEnum.ERROR_MAIN_THREAD);
            return m7525a(ErrorEnum.ERROR_MAIN_THREAD.toApiException());
        }
        if (!((NotificationManager) this.f7697b.getSystemService("notification")).areNotificationsEnabled()) {
            HMSLog.m7717i(f7695d, "App disabled notification");
            PushBiUtil.reportExit(this.f7697b, PushNaming.SUBSCRIBE_NOTIFICATION, reportEntry, ErrorEnum.ERROR_NOTIFICATION_DISABLED);
            return m7525a(ErrorEnum.ERROR_NOTIFICATION_DISABLED.toApiException());
        }
        try {
            if (C2505v.m7654a(this.f7697b) != ErrorEnum.SUCCESS) {
                return m7525a(ErrorEnum.ERROR_NO_TOKEN.toApiException());
            }
            if (-1 != this.f7697b.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.f7697b.getPackageName()) && C2487g.m7560a(this.f7697b) == -1) {
                HMSLog.m7715e(f7695d, "no network");
                return m7525a(ErrorEnum.ERROR_NO_NETWORK.toApiException());
            }
            Task doWrite = this.f7698c.doWrite(new SubscribeNotificationTask(this.f7696a, PushNaming.SUBSCRIBE_NOTIFICATION, m7527b(list), reportEntry));
            Tasks.await(doWrite);
            return doWrite;
        } catch (Exception e2) {
            if (!(e2.getCause() instanceof ApiException)) {
                PushBiUtil.reportExit(this.f7697b, PushNaming.SUBSCRIBE_NOTIFICATION, reportEntry, ErrorEnum.ERROR_INTERNAL_ERROR);
                return m7525a(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
            }
            ApiException apiException = (ApiException) e2.getCause();
            PushBiUtil.reportExit(this.f7697b, PushNaming.SUBSCRIBE_NOTIFICATION, reportEntry, apiException.getStatusCode());
            return m7525a(apiException);
        }
    }

    /* renamed from: b */
    private SubscribeNotificationReq m7527b(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        SubscribeNotificationReq subscribeNotificationReq = new SubscribeNotificationReq();
        subscribeNotificationReq.setEntityIds(jSONArray.toString());
        subscribeNotificationReq.setToken(BaseUtils.getLocalToken(this.f7697b, null));
        return subscribeNotificationReq;
    }

    public static NotificationSubscription getInstance(Activity activity) {
        return new NotificationSubscription(activity);
    }

    public static SubscribeResult getSubscribeResult(Intent intent) {
        String stringExtra;
        if (intent == null) {
            return null;
        }
        try {
            stringExtra = intent.getStringExtra("errorMsg");
        } catch (Throwable unused) {
            HMSLog.m7715e(f7695d, "get subscribe result occurs exception");
        }
        if (TextUtils.isEmpty(stringExtra)) {
            String stringExtra2 = intent.getStringExtra("subscribedItems");
            if (!TextUtils.isEmpty(stringExtra2)) {
                List<SubscribedItem> m7539a = C2482b.m7539a(stringExtra2);
                SubscribeResult subscribeResult = new SubscribeResult();
                subscribeResult.setSubscribedItems(m7539a);
                return subscribeResult;
            }
            return null;
        }
        SubscribeResult subscribeResult2 = new SubscribeResult();
        subscribeResult2.setErrorMsg(stringExtra);
        HMSLog.m7715e(f7695d, "get subscribe error msg:" + stringExtra);
        return subscribeResult2;
    }

    public Task<SubscribeResult> requestSubscribeNotification(List<String> list) {
        HMSLog.m7717i(f7695d, "invoke request subscribe notification");
        return m7526a(list);
    }

    /* renamed from: a */
    private Task<SubscribeResult> m7525a(Exception exc) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setException(exc);
        return taskCompletionSource.getTask();
    }
}
