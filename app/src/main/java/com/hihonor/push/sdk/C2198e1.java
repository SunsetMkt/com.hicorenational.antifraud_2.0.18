package com.hihonor.push.sdk;

import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.entity.PushTokenResult;
import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;

/* renamed from: com.hihonor.push.sdk.e1 */
/* loaded from: classes.dex */
public class C2198e1 extends AbstractC2201f1<PushTokenResult> {
    public C2198e1(String str, IMessageEntity iMessageEntity) {
        super(str, iMessageEntity);
    }

    @Override // com.hihonor.push.sdk.AbstractC2201f1
    /* renamed from: a */
    public void mo6378a(ApiException apiException, Object obj) {
        if (apiException == null) {
            apiException = HonorPushErrorEnum.ERROR_UNKNOWN.toApiException();
        }
        if (apiException.getErrorCode() == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
            if (obj instanceof PushTokenResult) {
                PushTokenResult pushTokenResult = (PushTokenResult) obj;
                try {
                    C2193d.f6759b.m6380a(C2214l.f6798e.m6393a(), pushTokenResult.getPushToken());
                } catch (Exception unused) {
                }
                this.f6775a.m6397a((C2219n0<TResult>) pushTokenResult);
                return;
            }
            apiException = HonorPushErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
        String str = "task execute failed. error:" + apiException.getErrorCode();
        this.f6775a.m6396a((Exception) apiException);
    }
}
