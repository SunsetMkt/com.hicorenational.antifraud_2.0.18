package com.huawei.hms.push.task;

import android.content.Intent;
import android.os.Bundle;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.push.C2498r;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes.dex */
public class SendUpStreamTask extends TaskApiCall<PushClient, BaseVoidTask> {

    /* renamed from: a */
    private String f7800a;

    /* renamed from: b */
    private String f7801b;

    public SendUpStreamTask(String str, String str2, String str3, String str4, String str5) {
        super(str, str2, str3);
        this.f7800a = str4;
        this.f7801b = str5;
    }

    /* renamed from: a */
    private void m7640a(PushClient pushClient, ResponseErrorCode responseErrorCode) {
        HMSLog.m7717i("SendUpStreamTask", "receive upstream, msgId :" + this.f7801b + " , packageName = " + this.f7800a + " , errorCode = " + responseErrorCode.getErrorCode());
        Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        intent.setPackage(this.f7800a);
        Bundle bundle = new Bundle();
        bundle.putString("message_id", this.f7801b);
        bundle.putInt("error", responseErrorCode.getErrorCode());
        if (ErrorEnum.SUCCESS.getInternalCode() == responseErrorCode.getErrorCode()) {
            bundle.putString("message_type", "sent_message");
        } else {
            bundle.putString("message_type", "send_error");
        }
        if (new C2498r().m7633a(pushClient.getContext(), bundle, intent)) {
            HMSLog.m7717i("SendUpStreamTask", "receive upstream, start service success");
            PushBiUtil.reportExit(pushClient.getContext(), getUri(), responseErrorCode);
        } else {
            HMSLog.m7718w("SendUpStreamTask", "receive upstream, start service failed");
            PushBiUtil.reportExit(pushClient.getContext(), getUri(), responseErrorCode.getTransactionId(), ErrorEnum.ERROR_BIND_SERVICE_SELF_MAPPING);
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 40003000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    public void doExecute(PushClient pushClient, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<BaseVoidTask> taskCompletionSource) {
        if (responseErrorCode.getErrorCode() == 0) {
            HMSLog.m7717i("SendUpStreamTask", "send up stream task,Operate succeed");
            taskCompletionSource.setResult(null);
        } else {
            HMSLog.m7715e("SendUpStreamTask", "send up stream task,Operate failed with ret=" + responseErrorCode.getErrorCode());
            ErrorEnum fromCode = ErrorEnum.fromCode(responseErrorCode.getErrorCode());
            if (fromCode != ErrorEnum.ERROR_UNKNOWN) {
                taskCompletionSource.setException(fromCode.toApiException());
            } else {
                taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            }
        }
        m7640a(pushClient, responseErrorCode);
    }
}
