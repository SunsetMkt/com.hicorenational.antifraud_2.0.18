package com.hihonor.push.sdk;

import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.entity.BooleanResult;
import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;

/* renamed from: com.hihonor.push.sdk.c1 */
/* loaded from: classes.dex */
public class C2191c1 extends AbstractC2201f1<BooleanResult> {
    public C2191c1(String str, IMessageEntity iMessageEntity) {
        super(str, iMessageEntity);
    }

    @Override // com.hihonor.push.sdk.AbstractC2201f1
    /* renamed from: a */
    public void mo6378a(ApiException apiException, Object obj) {
        if (apiException == null) {
            apiException = HonorPushErrorEnum.ERROR_UNKNOWN.toApiException();
        }
        if (apiException.getErrorCode() == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
            if (obj instanceof BooleanResult) {
                this.f6775a.m6397a((C2219n0<TResult>) obj);
                return;
            }
            apiException = HonorPushErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
        String str = "task execute failed. error:" + apiException.getErrorCode();
        this.f6775a.m6396a((Exception) apiException);
    }
}
