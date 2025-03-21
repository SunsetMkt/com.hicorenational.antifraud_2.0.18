package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResp;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.aaid.threads.AsyncExec;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

/* compiled from: GetTokenTask.java */
/* renamed from: com.huawei.hms.opendevice.g */
/* loaded from: classes.dex */
public class C2469g extends TaskApiCall<PushClient, TokenResult> {

    /* renamed from: a */
    private Context f7660a;

    /* renamed from: b */
    private TokenReq f7661b;

    /* compiled from: GetTokenTask.java */
    /* renamed from: com.huawei.hms.opendevice.g$a */
    class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f7662a;

        /* renamed from: b */
        final /* synthetic */ String f7663b;

        a(String str, String str2) {
            this.f7662a = str;
            this.f7663b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C2471i.m7469a(C2469g.this.f7660a).m7473b(this.f7662a).equals(this.f7663b)) {
                return;
            }
            HMSLog.m7717i(HmsInstanceId.TAG, "receive a new token, refresh the local token");
            C2471i.m7469a(C2469g.this.f7660a).m7474b(this.f7662a, this.f7663b);
        }
    }

    public C2469g(String str, TokenReq tokenReq, Context context, String str2) {
        super(str, JsonUtil.createJsonString(tokenReq), str2);
        this.f7660a = context;
        this.f7661b = tokenReq;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return this.f7661b.isMultiSender() ? 50004300 : 30000000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(PushClient pushClient, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<TokenResult> taskCompletionSource) {
        if (responseErrorCode.getErrorCode() != 0) {
            HMSLog.m7715e(HmsInstanceId.TAG, "TokenTask failed, ErrorCode:" + responseErrorCode.getErrorCode());
            m7462a(responseErrorCode, taskCompletionSource);
        } else {
            TokenResp tokenResp = (TokenResp) JsonUtil.jsonToEntity(str, new TokenResp());
            ErrorEnum fromCode = ErrorEnum.fromCode(tokenResp.getRetCode());
            if (fromCode != ErrorEnum.SUCCESS) {
                taskCompletionSource.setException(fromCode.toApiException());
                HMSLog.m7715e(HmsInstanceId.TAG, "TokenTask failed, StatusCode:" + fromCode.getExternalCode());
            } else {
                TokenResult tokenResult = new TokenResult();
                tokenResult.setToken(tokenResp.getToken());
                tokenResult.setBelongId(tokenResp.getBelongId());
                tokenResult.setRetCode(ErrorEnum.fromCode(tokenResp.getRetCode()).getExternalCode());
                taskCompletionSource.setResult(tokenResult);
                String token = tokenResp.getToken();
                if (TextUtils.isEmpty(token)) {
                    HMSLog.m7717i(HmsInstanceId.TAG, "GetTokenTask receive an empty token, please check onNewToken callback method.");
                    C2470h.m7466a(pushClient.getContext(), getUri(), responseErrorCode);
                    return;
                }
                m7463a(token, this.f7661b.getSubjectId());
            }
        }
        C2470h.m7466a(pushClient.getContext(), getUri(), responseErrorCode);
    }

    /* renamed from: a */
    private void m7462a(ResponseErrorCode responseErrorCode, TaskCompletionSource<TokenResult> taskCompletionSource) {
        ErrorEnum fromCode = ErrorEnum.fromCode(responseErrorCode.getErrorCode());
        if (fromCode != ErrorEnum.ERROR_UNKNOWN) {
            taskCompletionSource.setException(fromCode.toApiException());
        } else {
            taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
        }
    }

    /* renamed from: a */
    private void m7463a(String str, String str2) {
        AsyncExec.submitSeqIO(new a(str2, str));
    }
}
