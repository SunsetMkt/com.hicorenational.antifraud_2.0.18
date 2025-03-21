package com.huawei.hms.push.task;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.push.C2482b;
import com.huawei.hms.push.SubscribeResult;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.push.SubscribeNotificationReq;
import com.huawei.hms.support.api.entity.push.SubscribeNotificationResp;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

/* loaded from: classes.dex */
public class SubscribeNotificationTask extends TaskApiCall<PushClient, SubscribeResult> {

    /* renamed from: a */
    private Activity f7802a;

    public SubscribeNotificationTask(Activity activity, String str, SubscribeNotificationReq subscribeNotificationReq, String str2) {
        super(str, JsonUtil.createJsonString(subscribeNotificationReq), str2);
        this.f7802a = activity;
    }

    /* renamed from: a */
    private boolean m7642a(PushClient pushClient, ResponseErrorCode responseErrorCode) {
        Parcelable parcelable = responseErrorCode.getParcelable();
        if (!(parcelable instanceof Intent)) {
            HMSLog.m7715e("SubscribeNotificationTask", "not instance of intent");
            return false;
        }
        Intent intent = (Intent) parcelable;
        intent.putExtra("app_token", BaseUtils.getLocalToken(pushClient.getContext(), null));
        this.f7802a.startActivityForResult(intent, 1001);
        return true;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    public void doExecute(PushClient pushClient, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<SubscribeResult> taskCompletionSource) {
        if (responseErrorCode.getErrorCode() != 0) {
            HMSLog.m7715e("SubscribeNotificationTask", "Notification subscribe failed, error code: " + responseErrorCode.getErrorCode());
            m7641a(responseErrorCode, taskCompletionSource);
        } else {
            SubscribeNotificationResp subscribeNotificationResp = (SubscribeNotificationResp) JsonUtil.jsonToEntity(str, new SubscribeNotificationResp());
            ErrorEnum fromCode = ErrorEnum.fromCode(subscribeNotificationResp.getRetCode());
            if (fromCode != ErrorEnum.SUCCESS) {
                taskCompletionSource.setException(fromCode.toApiException());
                HMSLog.m7715e("PushLogSC3004", "Notification Subscription failed, StatusCode:" + fromCode.getExternalCode());
            } else if (!responseErrorCode.hasResolution()) {
                SubscribeResult subscribeResult = new SubscribeResult();
                subscribeResult.setSubscribedItems(C2482b.m7539a(subscribeNotificationResp.getSubscribeResults()));
                taskCompletionSource.setResult(subscribeResult);
            } else if (m7642a(pushClient, responseErrorCode)) {
                taskCompletionSource.setResult(new SubscribeResult());
            } else {
                taskCompletionSource.setException(ErrorEnum.ERROR_PUSH_INTERNAL_ERROR.toApiException());
            }
        }
        PushBiUtil.reportExit(pushClient.getContext(), getUri(), responseErrorCode);
    }

    /* renamed from: a */
    private void m7641a(ResponseErrorCode responseErrorCode, TaskCompletionSource<SubscribeResult> taskCompletionSource) {
        ErrorEnum fromCode = ErrorEnum.fromCode(responseErrorCode.getErrorCode());
        if (fromCode != ErrorEnum.ERROR_UNKNOWN) {
            taskCompletionSource.setException(fromCode.toApiException());
        } else {
            taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
        }
    }
}
