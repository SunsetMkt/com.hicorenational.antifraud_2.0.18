package com.huawei.hms.push;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.task.ConsentTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.EnableConsentReq;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.utils.JsonUtil;

/* loaded from: classes.dex */
public class HmsConsent {

    /* renamed from: a */
    private HuaweiApi<Api.ApiOptions.NoOptions> f7682a;

    /* renamed from: b */
    private Context f7683b;

    private HmsConsent(Context context) {
        Preconditions.checkNotNull(context);
        this.f7683b = context;
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f7682a = new HuaweiApi<>((Activity) context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f7682a = new HuaweiApi<>(context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, new PushClientBuilder());
        }
        this.f7682a.setKitSdkVersion(61200300);
    }

    /* renamed from: a */
    private Task<Void> m7507a(boolean z) {
        TaskCompletionSource taskCompletionSource;
        int externalCode;
        String reportEntry = PushBiUtil.reportEntry(this.f7683b, PushNaming.PUSH_CONSENT);
        try {
            if (!AbstractC2484d.m7550d(this.f7683b)) {
                throw ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.toApiException();
            }
            EnableConsentReq enableConsentReq = new EnableConsentReq();
            enableConsentReq.setPackageName(this.f7683b.getPackageName());
            enableConsentReq.setEnable(z);
            return this.f7682a.doWrite(new ConsentTask(PushNaming.PUSH_CONSENT, JsonUtil.createJsonString(enableConsentReq), reportEntry));
        } catch (ApiException e2) {
            TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
            taskCompletionSource2.setException(e2);
            externalCode = e2.getStatusCode();
            taskCompletionSource = taskCompletionSource2;
            PushBiUtil.reportExit(this.f7683b, PushNaming.PUSH_CONSENT, reportEntry, externalCode);
            return taskCompletionSource.getTask();
        } catch (Exception unused) {
            taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
            externalCode = ErrorEnum.ERROR_INTERNAL_ERROR.getExternalCode();
            PushBiUtil.reportExit(this.f7683b, PushNaming.PUSH_CONSENT, reportEntry, externalCode);
            return taskCompletionSource.getTask();
        }
    }

    public static HmsConsent getInstance(Context context) {
        return new HmsConsent(context);
    }

    public Task<Void> consentOff() {
        return m7507a(false);
    }

    public Task<Void> consentOn() {
        return m7507a(true);
    }
}
