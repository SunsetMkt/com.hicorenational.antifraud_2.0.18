package com.huawei.hms.support.api.core;

import android.text.TextUtils;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolvePendingResult;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.InnerPendingResult;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.core.CheckConnectInfo;
import com.huawei.hms.support.api.entity.core.CheckConnectResp;
import com.huawei.hms.support.api.entity.core.ConnectInfo;
import com.huawei.hms.support.api.entity.core.ConnectResp;
import com.huawei.hms.support.api.entity.core.CoreNaming;
import com.huawei.hms.support.api.entity.core.DisconnectInfo;
import com.huawei.hms.support.api.entity.core.DisconnectResp;
import com.huawei.hms.support.api.entity.core.JosGetNoticeReq;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes.dex */
public final class ConnectService {

    /* renamed from: com.huawei.hms.support.api.core.ConnectService$a */
    class C2514a extends PendingResultImpl<ResolveResult<ConnectResp>, ConnectResp> {
        C2514a(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResolveResult<ConnectResp> onComplete(ConnectResp connectResp) {
            ResolveResult<ConnectResp> resolveResult = new ResolveResult<>(connectResp);
            resolveResult.setStatus(Status.SUCCESS);
            HMSLog.m7712d("connectservice", "connect - onComplete: success");
            return resolveResult;
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        protected boolean checkApiClient(ApiClient apiClient) {
            return apiClient != null;
        }
    }

    /* renamed from: com.huawei.hms.support.api.core.ConnectService$b */
    class C2515b extends PendingResultImpl<ResolveResult<ConnectResp>, ConnectResp> {
        C2515b(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResolveResult<ConnectResp> onComplete(ConnectResp connectResp) {
            ResolveResult<ConnectResp> resolveResult = new ResolveResult<>(connectResp);
            resolveResult.setStatus(Status.SUCCESS);
            HMSLog.m7712d("connectservice", "forceConnect - onComplete: success");
            return resolveResult;
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        protected boolean checkApiClient(ApiClient apiClient) {
            return apiClient != null;
        }
    }

    /* renamed from: com.huawei.hms.support.api.core.ConnectService$c */
    class C2516c extends PendingResultImpl<ResolveResult<JosGetNoticeResp>, JosGetNoticeResp> {
        C2516c(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResolveResult<JosGetNoticeResp> onComplete(JosGetNoticeResp josGetNoticeResp) {
            if (josGetNoticeResp == null) {
                HMSLog.m7715e("connectservice", "JosNoticeResp is null");
                return null;
            }
            HMSLog.m7717i("connectservice", "josNoticeResp status code :" + josGetNoticeResp.getStatusCode());
            ResolveResult<JosGetNoticeResp> resolveResult = new ResolveResult<>(josGetNoticeResp);
            resolveResult.setStatus(Status.SUCCESS);
            return resolveResult;
        }
    }

    private ConnectService() {
    }

    public static InnerPendingResult<ResolveResult<CheckConnectResp>> checkconnect(ApiClient apiClient, CheckConnectInfo checkConnectInfo) {
        return ResolvePendingResult.build(apiClient, CoreNaming.CHECKCONNECT, checkConnectInfo, CheckConnectResp.class);
    }

    public static PendingResult<ResolveResult<ConnectResp>> connect(ApiClient apiClient, ConnectInfo connectInfo) {
        return new C2514a(apiClient, CoreNaming.CONNECT, connectInfo);
    }

    public static ResolvePendingResult<DisconnectResp> disconnect(ApiClient apiClient, DisconnectInfo disconnectInfo) {
        return ResolvePendingResult.build(apiClient, CoreNaming.DISCONNECT, disconnectInfo, DisconnectResp.class);
    }

    public static PendingResult<ResolveResult<ConnectResp>> forceConnect(ApiClient apiClient, ConnectInfo connectInfo) {
        return new C2515b(apiClient, CoreNaming.FORECONNECT, connectInfo);
    }

    public static PendingResult<ResolveResult<JosGetNoticeResp>> getNotice(ApiClient apiClient, int i2, String str) {
        JosGetNoticeReq josGetNoticeReq = new JosGetNoticeReq();
        josGetNoticeReq.setNoticeType(i2);
        josGetNoticeReq.setHmsSdkVersionName(str);
        if (apiClient != null && !TextUtils.isEmpty(apiClient.getCpID())) {
            josGetNoticeReq.setCpID(apiClient.getCpID());
        }
        return new C2516c(apiClient, CoreNaming.GETNOTICE, josGetNoticeReq);
    }
}
