package com.huawei.hms.opendevice;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.DeleteTokenResp;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

/* compiled from: DeleteTokenTask.java */
/* renamed from: com.huawei.hms.opendevice.f */
/* loaded from: classes.dex */
public class C2468f extends TaskApiCall<PushClient, Void> {

    /* renamed from: a */
    private DeleteTokenReq f7659a;

    public C2468f(String str, DeleteTokenReq deleteTokenReq, String str2) {
        super(str, JsonUtil.createJsonString(deleteTokenReq), str2);
        this.f7659a = deleteTokenReq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(PushClient pushClient, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<Void> taskCompletionSource) {
        if (responseErrorCode.getErrorCode() == 0) {
            ErrorEnum fromCode = ErrorEnum.fromCode(((DeleteTokenResp) JsonUtil.jsonToEntity(str, new DeleteTokenResp())).getRetCode());
            if (fromCode != ErrorEnum.SUCCESS) {
                taskCompletionSource.setException(fromCode.toApiException());
                return;
            } else {
                taskCompletionSource.setResult(null);
                C2470h.m7466a(pushClient.getContext(), getUri(), responseErrorCode);
                return;
            }
        }
        HMSLog.m7715e(HmsInstanceId.TAG, "DeleteTokenTask failed, ErrorCode: " + responseErrorCode.getErrorCode());
        ErrorEnum fromCode2 = ErrorEnum.fromCode(responseErrorCode.getErrorCode());
        if (fromCode2 != ErrorEnum.ERROR_UNKNOWN) {
            taskCompletionSource.setException(fromCode2.toApiException());
        } else {
            taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return this.f7659a.isMultiSender() ? 50004300 : 30000000;
    }
}
