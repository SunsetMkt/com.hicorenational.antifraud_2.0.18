package com.huawei.hms.aaid;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.opendevice.C2464b;
import com.huawei.hms.opendevice.C2469g;
import com.huawei.hms.opendevice.C2470h;
import com.huawei.hms.support.log.HMSLog;
import java.util.UUID;

@Deprecated
/* loaded from: classes.dex */
public class HmsInstanceIdEx {
    public static final String TAG = "HmsInstanceIdEx";

    /* renamed from: a */
    private Context f7007a;

    /* renamed from: b */
    private PushPreferences f7008b;

    /* renamed from: c */
    private HuaweiApi<Api.ApiOptions.NoOptions> f7009c;

    private HmsInstanceIdEx(Context context) {
        this.f7008b = null;
        this.f7007a = context;
        this.f7008b = new PushPreferences(context, "aaid");
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f7009c = new HuaweiApi<>((Activity) context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f7009c = new HuaweiApi<>(context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, new PushClientBuilder());
        }
        this.f7009c.setKitSdkVersion(61200300);
    }

    /* renamed from: a */
    private String m6503a(String str) {
        return "creationTime" + str;
    }

    public static HmsInstanceIdEx getInstance(Context context) {
        Preconditions.checkNotNull(context);
        return new HmsInstanceIdEx(context);
    }

    public void deleteAAID(String str) throws ApiException {
        if (str == null) {
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
        try {
            if (this.f7008b.containsKey(str)) {
                this.f7008b.removeKey(str);
                this.f7008b.removeKey(m6503a(str));
            }
        } catch (RuntimeException unused) {
            throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        } catch (Exception unused2) {
            throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
    }

    public String getAAId(String str) throws ApiException {
        if (str == null) {
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
        try {
            if (this.f7008b.containsKey(str)) {
                return this.f7008b.getString(str);
            }
            String uuid = UUID.randomUUID().toString();
            this.f7008b.saveString(str, uuid);
            this.f7008b.saveLong(m6503a(str), Long.valueOf(System.currentTimeMillis()));
            return uuid;
        } catch (RuntimeException unused) {
            throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        } catch (Exception unused2) {
            throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
    }

    public long getCreationTime(String str) throws ApiException {
        if (str == null) {
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
        try {
            if (!this.f7008b.containsKey(m6503a(str))) {
                getAAId(str);
            }
            return this.f7008b.getLong(m6503a(str));
        } catch (RuntimeException unused) {
            throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        } catch (Exception unused2) {
            throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
    }

    public Task<TokenResult> getToken() {
        if (ProxyCenter.getProxy() != null) {
            try {
                HMSLog.m7717i(TAG, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
                ProxyCenter.getProxy().getToken(this.f7007a, null, null);
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                taskCompletionSource.setResult(new TokenResult());
                return taskCompletionSource.getTask();
            } catch (ApiException e2) {
                return m6502a(e2);
            } catch (Exception unused) {
                return m6502a(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
            }
        }
        String m7465a = C2470h.m7465a(this.f7007a, "push.gettoken");
        try {
            TokenReq m7446b = C2464b.m7446b(this.f7007a, null, null);
            m7446b.setAaid(HmsInstanceId.getInstance(this.f7007a).getId());
            return this.f7009c.doWrite(new C2469g("push.gettoken", m7446b, this.f7007a, m7465a));
        } catch (RuntimeException unused2) {
            Context context = this.f7007a;
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            C2470h.m7468a(context, "push.gettoken", m7465a, errorEnum);
            return m6502a(errorEnum.toApiException());
        } catch (Exception unused3) {
            Context context2 = this.f7007a;
            ErrorEnum errorEnum2 = ErrorEnum.ERROR_INTERNAL_ERROR;
            C2470h.m7468a(context2, "push.gettoken", m7465a, errorEnum2);
            return m6502a(errorEnum2.toApiException());
        }
    }

    /* renamed from: a */
    private Task<TokenResult> m6502a(Exception exc) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setException(exc);
        return taskCompletionSource.getTask();
    }
}
