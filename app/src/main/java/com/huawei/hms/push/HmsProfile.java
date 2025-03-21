package com.huawei.hms.push;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
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
import com.huawei.hms.push.task.ProfileTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.ProfileReq;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.secure.android.common.encrypt.hash.SHA;

/* loaded from: classes.dex */
public class HmsProfile {
    public static final int CUSTOM_PROFILE = 2;
    public static final int HUAWEI_PROFILE = 1;

    /* renamed from: c */
    private static final String f7692c = "HmsProfile";

    /* renamed from: a */
    private Context f7693a;

    /* renamed from: b */
    private HuaweiApi<Api.ApiOptions.NoOptions> f7694b;

    private HmsProfile(Context context) {
        this.f7693a = null;
        Preconditions.checkNotNull(context);
        this.f7693a = context;
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f7694b = new HuaweiApi<>((Activity) context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f7694b = new HuaweiApi<>(context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, new PushClientBuilder());
        }
        this.f7694b.setKitSdkVersion(61200300);
    }

    /* renamed from: a */
    private Task<Void> m7522a(int i2, String str, int i3, String str2) {
        if (!isSupportProfile()) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.toApiException());
            return taskCompletionSource.getTask();
        }
        if (!TextUtils.isEmpty(str)) {
            String m7523a = m7523a(this.f7693a);
            if (TextUtils.isEmpty(m7523a)) {
                HMSLog.m7717i(f7692c, "agc connect services config missing project id.");
                TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
                taskCompletionSource2.setException(ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException());
                return taskCompletionSource2.getTask();
            }
            if (str.equals(m7523a)) {
                str = "";
            }
        }
        ProfileReq profileReq = new ProfileReq();
        if (i2 == 0) {
            profileReq.setOperation(0);
            profileReq.setType(i3);
        } else {
            profileReq.setOperation(1);
        }
        String reportEntry = PushBiUtil.reportEntry(this.f7693a, PushNaming.PUSH_PROFILE);
        try {
            profileReq.setSubjectId(str);
            profileReq.setProfileId(SHA.sha256Encrypt(str2));
            profileReq.setPkgName(this.f7693a.getPackageName());
            return this.f7694b.doWrite(new ProfileTask(PushNaming.PUSH_PROFILE, JsonUtil.createJsonString(profileReq), reportEntry));
        } catch (Exception e2) {
            if (!(e2.getCause() instanceof ApiException)) {
                TaskCompletionSource taskCompletionSource3 = new TaskCompletionSource();
                PushBiUtil.reportExit(this.f7693a, PushNaming.PUSH_PROFILE, reportEntry, ErrorEnum.ERROR_INTERNAL_ERROR);
                taskCompletionSource3.setException(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
                return taskCompletionSource3.getTask();
            }
            TaskCompletionSource taskCompletionSource4 = new TaskCompletionSource();
            ApiException apiException = (ApiException) e2.getCause();
            taskCompletionSource4.setException(apiException);
            PushBiUtil.reportExit(this.f7693a, PushNaming.PUSH_PROFILE, reportEntry, apiException.getStatusCode());
            return taskCompletionSource4.getTask();
        }
    }

    /* renamed from: b */
    private boolean m7524b(Context context) {
        return AbstractC2484d.m7546b(context) >= 110001400;
    }

    public static HmsProfile getInstance(Context context) {
        return new HmsProfile(context);
    }

    public Task<Void> addProfile(int i2, String str) {
        return addProfile("", i2, str);
    }

    public Task<Void> deleteProfile(String str) {
        return deleteProfile("", str);
    }

    public boolean isSupportProfile() {
        if (!AbstractC2484d.m7550d(this.f7693a)) {
            return true;
        }
        if (AbstractC2484d.m7549c()) {
            HMSLog.m7717i(f7692c, "current EMUI version below 9.1, not support profile operation.");
            return false;
        }
        if (m7524b(this.f7693a)) {
            return true;
        }
        HMSLog.m7717i(f7692c, "current HwPushService.apk version below 11.0.1.400,please upgrade your HwPushService.apk version.");
        return false;
    }

    public Task<Void> addProfile(String str, int i2, String str2) {
        if (i2 != 1 && i2 != 2) {
            HMSLog.m7717i(f7692c, "add profile type undefined.");
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
            return taskCompletionSource.getTask();
        }
        if (!TextUtils.isEmpty(str2)) {
            return m7522a(0, str, i2, str2);
        }
        HMSLog.m7717i(f7692c, "add profile params is empty.");
        TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        taskCompletionSource2.setException(ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
        return taskCompletionSource2.getTask();
    }

    public Task<Void> deleteProfile(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return m7522a(1, str, -1, str2);
        }
        HMSLog.m7715e(f7692c, "del profile params is empty.");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setException(ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
        return taskCompletionSource.getTask();
    }

    /* renamed from: a */
    private static String m7523a(Context context) {
        return AGConnectServicesConfig.fromContext(context).getString("client/project_id");
    }
}
