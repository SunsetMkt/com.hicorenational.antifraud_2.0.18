package com.huawei.hms.push.ups;

import android.content.Context;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.AbstractC2484d;
import com.huawei.hms.push.HmsMessaging;
import com.huawei.hms.push.ups.entity.CodeResult;
import com.huawei.hms.push.ups.entity.TokenResult;
import com.huawei.hms.push.ups.entity.UPSRegisterCallBack;
import com.huawei.hms.push.ups.entity.UPSTurnCallBack;
import com.huawei.hms.push.ups.entity.UPSUnRegisterCallBack;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes.dex */
public final class UPSService {
    private UPSService() {
    }

    public static void registerToken(Context context, String str, String str2, String str3, UPSRegisterCallBack uPSRegisterCallBack) {
        HMSLog.m7717i("UPSService", "invoke registerToken");
        Preconditions.checkNotNull(uPSRegisterCallBack);
        if (!AbstractC2484d.m7547b()) {
            uPSRegisterCallBack.onResult(new TokenResult(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.getExternalCode()));
            return;
        }
        try {
            uPSRegisterCallBack.onResult(new TokenResult(HmsInstanceId.getInstance(context).getToken(str, null)));
        } catch (ApiException e2) {
            uPSRegisterCallBack.onResult(new TokenResult(e2.getStatusCode(), e2.getMessage()));
        }
    }

    public static void turnOffPush(Context context, final UPSTurnCallBack uPSTurnCallBack) {
        HMSLog.m7717i("UPSService", "invoke turnOffPush");
        Preconditions.checkNotNull(uPSTurnCallBack);
        if (AbstractC2484d.m7547b()) {
            HmsMessaging.getInstance(context).turnOffPush().addOnCompleteListener(new OnCompleteListener<Void>() { // from class: com.huawei.hms.push.ups.UPSService.2
                @Override // com.huawei.hmf.tasks.OnCompleteListener
                public void onComplete(Task<Void> task) {
                    if (task.isSuccessful()) {
                        UPSTurnCallBack.this.onResult(new CodeResult());
                    } else {
                        ApiException apiException = (ApiException) task.getException();
                        UPSTurnCallBack.this.onResult(new CodeResult(apiException.getStatusCode(), apiException.getMessage()));
                    }
                }
            });
        } else {
            uPSTurnCallBack.onResult(new TokenResult(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.getExternalCode()));
        }
    }

    public static void turnOnPush(Context context, final UPSTurnCallBack uPSTurnCallBack) {
        HMSLog.m7717i("UPSService", "invoke turnOnPush");
        Preconditions.checkNotNull(uPSTurnCallBack);
        if (AbstractC2484d.m7547b()) {
            HmsMessaging.getInstance(context).turnOnPush().addOnCompleteListener(new OnCompleteListener<Void>() { // from class: com.huawei.hms.push.ups.UPSService.1
                @Override // com.huawei.hmf.tasks.OnCompleteListener
                public void onComplete(Task<Void> task) {
                    if (task.isSuccessful()) {
                        UPSTurnCallBack.this.onResult(new CodeResult());
                    } else {
                        ApiException apiException = (ApiException) task.getException();
                        UPSTurnCallBack.this.onResult(new CodeResult(apiException.getStatusCode(), apiException.getMessage()));
                    }
                }
            });
        } else {
            uPSTurnCallBack.onResult(new TokenResult(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.getExternalCode()));
        }
    }

    public static void unRegisterToken(Context context, UPSUnRegisterCallBack uPSUnRegisterCallBack) {
        HMSLog.m7717i("UPSService", "invoke unRegisterToken");
        Preconditions.checkNotNull(uPSUnRegisterCallBack);
        if (!AbstractC2484d.m7547b()) {
            uPSUnRegisterCallBack.onResult(new TokenResult(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.getExternalCode()));
            return;
        }
        try {
            HmsInstanceId.getInstance(context).deleteToken(null, null);
            uPSUnRegisterCallBack.onResult(new TokenResult());
        } catch (ApiException e2) {
            uPSUnRegisterCallBack.onResult(new TokenResult(e2.getStatusCode(), e2.getMessage()));
        }
    }
}
