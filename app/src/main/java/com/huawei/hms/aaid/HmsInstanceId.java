package com.huawei.hms.aaid;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.opendevice.AbstractC2467e;
import com.huawei.hms.opendevice.AbstractC2474l;
import com.huawei.hms.opendevice.C2464b;
import com.huawei.hms.opendevice.C2468f;
import com.huawei.hms.opendevice.C2469g;
import com.huawei.hms.opendevice.C2470h;
import com.huawei.hms.opendevice.C2471i;
import com.huawei.hms.opendevice.CallableC2463a;
import com.huawei.hms.support.log.HMSLog;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes.dex */
public class HmsInstanceId {
    public static final String TAG = "HmsInstanceId";

    /* renamed from: a */
    private Context f7004a;

    /* renamed from: b */
    private PushPreferences f7005b;

    /* renamed from: c */
    private HuaweiApi<Api.ApiOptions.NoOptions> f7006c;

    private HmsInstanceId(Context context) {
        this.f7004a = context.getApplicationContext();
        this.f7005b = new PushPreferences(context, "aaid");
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f7006c = new HuaweiApi<>((Activity) context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f7006c = new HuaweiApi<>(context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, new PushClientBuilder());
        }
        this.f7006c.setKitSdkVersion(61200300);
    }

    /* renamed from: a */
    private void m6500a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!AbstractC2467e.m7459e(this.f7004a)) {
            C2471i.m7469a(this.f7004a).removeKey("subjectId");
            return;
        }
        String string = C2471i.m7469a(this.f7004a).getString("subjectId");
        if (TextUtils.isEmpty(string)) {
            C2471i.m7469a(this.f7004a).saveString("subjectId", str);
            return;
        }
        if (string.contains(str)) {
            return;
        }
        C2471i.m7469a(this.f7004a).saveString("subjectId", string + Constants.ACCEPT_TIME_SEPARATOR_SP + str);
    }

    /* renamed from: b */
    private void m6501b() throws ApiException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw ErrorEnum.ERROR_MAIN_THREAD.toApiException();
        }
    }

    public static HmsInstanceId getInstance(Context context) {
        Preconditions.checkNotNull(context);
        AbstractC2474l.m7493c(context);
        return new HmsInstanceId(context);
    }

    public void deleteAAID() throws ApiException {
        m6501b();
        try {
            if (this.f7005b.containsKey("aaid")) {
                this.f7005b.removeKey("aaid");
                this.f7005b.removeKey("creationTime");
                if (C2464b.m7450d(this.f7004a)) {
                    if (ProxyCenter.getProxy() != null) {
                        HMSLog.m7717i(TAG, "use proxy delete all token after delete AaId.");
                        ProxyCenter.getProxy().deleteAllToken(this.f7004a);
                        return;
                    }
                    DeleteTokenReq m7441a = C2464b.m7441a(this.f7004a);
                    m7441a.setDeleteType(1);
                    m7441a.setMultiSender(false);
                    m6499a(m7441a, 1);
                    BaseUtils.deleteAllTokenCache(this.f7004a);
                }
            }
        } catch (ApiException e2) {
            throw e2;
        } catch (Exception unused) {
            throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
    }

    public void deleteToken(String str, String str2) throws ApiException {
        m6501b();
        m6498a();
        DeleteTokenReq m7443a = C2464b.m7443a(this.f7004a, str, str2);
        m7443a.setMultiSender(false);
        m6499a(m7443a, 1);
    }

    public Task<AAIDResult> getAAID() {
        try {
            return Tasks.callInBackground(new CallableC2463a(this.f7004a.getApplicationContext()));
        } catch (Exception unused) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
            return taskCompletionSource.getTask();
        }
    }

    public long getCreationTime() {
        try {
            if (!this.f7005b.containsKey("creationTime")) {
                getAAID();
            }
            return this.f7005b.getLong("creationTime");
        } catch (Exception unused) {
            return 0L;
        }
    }

    public String getId() {
        return C2464b.m7448b(this.f7004a);
    }

    @Deprecated
    public String getToken() {
        try {
            return getToken(null, null);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getToken(String str, String str2) throws ApiException {
        m6501b();
        m6498a();
        TokenReq m7446b = C2464b.m7446b(this.f7004a, null, str2);
        m7446b.setAaid(getId());
        m7446b.setMultiSender(false);
        C2471i.m7469a(this.f7004a).saveString(this.f7004a.getPackageName(), "1");
        return m6497a(m7446b, 1);
    }

    public void deleteToken(String str) throws ApiException {
        m6501b();
        m6498a();
        if (!TextUtils.isEmpty(str)) {
            String m7449c = C2464b.m7449c(this.f7004a);
            if (!TextUtils.isEmpty(m7449c)) {
                if (str.equals(m7449c)) {
                    deleteToken(null, null);
                    return;
                }
                DeleteTokenReq m7442a = C2464b.m7442a(this.f7004a, str);
                m7442a.setMultiSender(true);
                m6499a(m7442a, 2);
                return;
            }
            throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }

    public String getToken(String str) throws ApiException {
        m6501b();
        m6498a();
        if (!TextUtils.isEmpty(str)) {
            String m7449c = C2464b.m7449c(this.f7004a);
            if (!TextUtils.isEmpty(m7449c)) {
                if (str.equals(m7449c)) {
                    return getToken(null, null);
                }
                TokenReq m7445b = C2464b.m7445b(this.f7004a, str);
                m7445b.setAaid(getId());
                m7445b.setMultiSender(true);
                return m6497a(m7445b, 2);
            }
            throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }

    /* renamed from: a */
    private String m6497a(TokenReq tokenReq, int i2) throws ApiException {
        if (ProxyCenter.getProxy() != null) {
            HMSLog.m7717i(TAG, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
            ProxyCenter.getProxy().getToken(this.f7004a, tokenReq.getSubjectId(), null);
            return null;
        }
        m6500a(tokenReq.getSubjectId());
        String m7465a = C2470h.m7465a(this.f7004a, "push.gettoken");
        try {
            HMSLog.m7712d(TAG, "getToken req :" + tokenReq.toString());
            C2469g c2469g = new C2469g("push.gettoken", tokenReq, this.f7004a, m7465a);
            c2469g.setApiLevel(i2);
            return ((TokenResult) Tasks.await(this.f7006c.doWrite(c2469g))).getToken();
        } catch (Exception e2) {
            if (e2.getCause() instanceof ApiException) {
                ApiException apiException = (ApiException) e2.getCause();
                C2470h.m7467a(this.f7004a, "push.gettoken", m7465a, apiException.getStatusCode());
                throw apiException;
            }
            Context context = this.f7004a;
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            C2470h.m7468a(context, "push.gettoken", m7465a, errorEnum);
            throw errorEnum.toApiException();
        }
    }

    /* renamed from: a */
    private void m6499a(DeleteTokenReq deleteTokenReq, int i2) throws ApiException {
        String subjectId = deleteTokenReq.getSubjectId();
        if (ProxyCenter.getProxy() != null) {
            HMSLog.m7717i(TAG, "use proxy delete token");
            ProxyCenter.getProxy().deleteToken(this.f7004a, subjectId, null);
            return;
        }
        String m7465a = C2470h.m7465a(this.f7004a, "push.deletetoken");
        try {
            String m7473b = C2471i.m7469a(this.f7004a).m7473b(subjectId);
            if (deleteTokenReq.isMultiSender() && (TextUtils.isEmpty(m7473b) || m7473b.equals(C2471i.m7469a(this.f7004a).m7473b(null)))) {
                C2471i.m7469a(this.f7004a).removeKey(subjectId);
                HMSLog.m7717i(TAG, "The local subject token is null");
                return;
            }
            deleteTokenReq.setToken(m7473b);
            C2468f c2468f = new C2468f("push.deletetoken", deleteTokenReq, m7465a);
            c2468f.setApiLevel(i2);
            Tasks.await(this.f7006c.doWrite(c2468f));
            C2471i.m7469a(this.f7004a).m7475c(subjectId);
        } catch (Exception e2) {
            if (e2.getCause() instanceof ApiException) {
                ApiException apiException = (ApiException) e2.getCause();
                C2470h.m7467a(this.f7004a, "push.deletetoken", m7465a, apiException.getStatusCode());
                throw apiException;
            }
            Context context = this.f7004a;
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            C2470h.m7468a(context, "push.deletetoken", m7465a, errorEnum);
            throw errorEnum.toApiException();
        }
    }

    /* renamed from: a */
    private void m6498a() throws ApiException {
        if (BaseUtils.getProxyInit(this.f7004a) && ProxyCenter.getProxy() == null && !BaseUtils.isMainProc(this.f7004a)) {
            HMSLog.m7715e(TAG, "Operations in child processes are not supported.");
            throw ErrorEnum.ERROR_OPER_IN_CHILD_PROCESS.toApiException();
        }
    }
}
