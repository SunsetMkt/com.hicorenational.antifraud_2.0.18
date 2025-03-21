package com.huawei.hms.push;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.encrypt.PushEncrypter;
import com.huawei.hms.aaid.init.AutoInitHelper;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.task.BaseVoidTask;
import com.huawei.hms.push.task.IntentCallable;
import com.huawei.hms.push.task.SendUpStreamTask;
import com.huawei.hms.push.task.SubscribeTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.EnableNotifyReq;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.api.entity.push.SubscribeReq;
import com.huawei.hms.support.api.entity.push.UpSendMsgReq;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.NetWorkUtil;
import com.vivo.push.PushClientConstants;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class HmsMessaging {
    public static final String DEFAULT_TOKEN_SCOPE = "HCM";

    /* renamed from: c */
    private static final Pattern f7689c = Pattern.compile("[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");

    /* renamed from: a */
    private Context f7690a;

    /* renamed from: b */
    private HuaweiApi<Api.ApiOptions.NoOptions> f7691b;

    private HmsMessaging(Context context) {
        Preconditions.checkNotNull(context);
        this.f7690a = context;
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f7691b = new HuaweiApi<>((Activity) context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f7691b = new HuaweiApi<>(context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, new PushClientBuilder());
        }
        this.f7691b.setKitSdkVersion(61200300);
    }

    /* renamed from: a */
    private Task<Void> m7518a(String str, String str2) {
        String reportEntry = PushBiUtil.reportEntry(this.f7690a, PushNaming.SUBSCRIBE);
        if (str == null || !f7689c.matcher(str).matches()) {
            PushBiUtil.reportExit(this.f7690a, PushNaming.SUBSCRIBE, reportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
            HMSLog.m7715e("HmsMessaging", "Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
            throw new IllegalArgumentException("Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
        }
        if (ProxyCenter.getProxy() != null) {
            HMSLog.m7717i("HmsMessaging", "use proxy subscribe.");
            return TextUtils.equals(str2, "Sub") ? ProxyCenter.getProxy().subscribe(this.f7690a, str, reportEntry) : ProxyCenter.getProxy().unsubscribe(this.f7690a, str, reportEntry);
        }
        try {
            ErrorEnum m7654a = C2505v.m7654a(this.f7690a);
            if (m7654a != ErrorEnum.SUCCESS) {
                throw m7654a.toApiException();
            }
            if (NetWorkUtil.getNetworkType(this.f7690a) == 0) {
                HMSLog.m7715e("HmsMessaging", "no network");
                throw ErrorEnum.ERROR_NO_NETWORK.toApiException();
            }
            SubscribeReq subscribeReq = new SubscribeReq(this.f7690a, str2, str);
            subscribeReq.setToken(BaseUtils.getLocalToken(this.f7690a, null));
            return AbstractC2484d.m7547b() ? this.f7691b.doWrite(new BaseVoidTask(PushNaming.SUBSCRIBE, JsonUtil.createJsonString(subscribeReq), reportEntry)) : this.f7691b.doWrite(new SubscribeTask(PushNaming.SUBSCRIBE, JsonUtil.createJsonString(subscribeReq), reportEntry));
        } catch (ApiException e2) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(e2);
            PushBiUtil.reportExit(this.f7690a, PushNaming.SUBSCRIBE, reportEntry, e2.getStatusCode());
            return taskCompletionSource.getTask();
        } catch (Exception unused) {
            TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
            taskCompletionSource2.setException(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
            PushBiUtil.reportExit(this.f7690a, PushNaming.SUBSCRIBE, reportEntry, ErrorEnum.ERROR_INTERNAL_ERROR);
            return taskCompletionSource2.getTask();
        }
    }

    public static synchronized HmsMessaging getInstance(Context context) {
        HmsMessaging hmsMessaging;
        synchronized (HmsMessaging.class) {
            hmsMessaging = new HmsMessaging(context);
        }
        return hmsMessaging;
    }

    public boolean isAutoInitEnabled() {
        return AutoInitHelper.isAutoInitEnabled(this.f7690a);
    }

    public void send(RemoteMessage remoteMessage) {
        if (ProxyCenter.getProxy() != null) {
            HMSLog.m7715e("HmsMessaging", "Operation(send) unsupported");
            throw new UnsupportedOperationException("Operation(send) unsupported");
        }
        HMSLog.m7717i("HmsMessaging", "send upstream message");
        m7520a(remoteMessage);
    }

    public void setAutoInitEnabled(boolean z) {
        AutoInitHelper.setAutoInitEnabled(this.f7690a, z);
    }

    public Task<Void> subscribe(String str) {
        HMSLog.m7717i("HmsMessaging", "invoke subscribe");
        return m7518a(str, "Sub");
    }

    public Task<Void> turnOffPush() {
        if (ProxyCenter.getProxy() != null) {
            HMSLog.m7717i("HmsMessaging", "turn off for proxy");
            return ProxyCenter.getProxy().turnOff(this.f7690a, null);
        }
        HMSLog.m7717i("HmsMessaging", "invoke turnOffPush");
        return m7519a(false);
    }

    public Task<Void> turnOnPush() {
        if (ProxyCenter.getProxy() != null) {
            HMSLog.m7717i("HmsMessaging", "turn on for proxy");
            return ProxyCenter.getProxy().turnOn(this.f7690a, null);
        }
        HMSLog.m7717i("HmsMessaging", "invoke turnOnPush");
        return m7519a(true);
    }

    public Task<Void> unsubscribe(String str) {
        HMSLog.m7717i("HmsMessaging", "invoke unsubscribe");
        return m7518a(str, "UnSub");
    }

    /* renamed from: a */
    private void m7520a(RemoteMessage remoteMessage) {
        String reportEntry = PushBiUtil.reportEntry(this.f7690a, PushNaming.UPSEND_MSG);
        ErrorEnum m7654a = C2505v.m7654a(this.f7690a);
        if (m7654a == ErrorEnum.SUCCESS) {
            if (!TextUtils.isEmpty(remoteMessage.getTo())) {
                if (!TextUtils.isEmpty(remoteMessage.getMessageId())) {
                    if (!TextUtils.isEmpty(remoteMessage.getData())) {
                        UpSendMsgReq upSendMsgReq = new UpSendMsgReq();
                        upSendMsgReq.setPackageName(this.f7690a.getPackageName());
                        upSendMsgReq.setMessageId(remoteMessage.getMessageId());
                        upSendMsgReq.setTo(remoteMessage.getTo());
                        upSendMsgReq.setData(remoteMessage.getData());
                        upSendMsgReq.setMessageType(remoteMessage.getMessageType());
                        upSendMsgReq.setTtl(remoteMessage.getTtl());
                        upSendMsgReq.setCollapseKey(remoteMessage.getCollapseKey());
                        upSendMsgReq.setSendMode(remoteMessage.getSendMode());
                        upSendMsgReq.setReceiptMode(remoteMessage.getReceiptMode());
                        if (AbstractC2484d.m7547b()) {
                            this.f7691b.doWrite(new BaseVoidTask(PushNaming.UPSEND_MSG, JsonUtil.createJsonString(upSendMsgReq), reportEntry));
                            return;
                        } else {
                            m7521a(upSendMsgReq, reportEntry);
                            return;
                        }
                    }
                    HMSLog.m7715e("HmsMessaging", "Mandatory parameter 'data' missing");
                    PushBiUtil.reportExit(this.f7690a, PushNaming.UPSEND_MSG, reportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
                    throw new IllegalArgumentException("Mandatory parameter 'data' missing");
                }
                HMSLog.m7715e("HmsMessaging", "Mandatory parameter 'message_id' missing");
                PushBiUtil.reportExit(this.f7690a, PushNaming.UPSEND_MSG, reportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
                throw new IllegalArgumentException("Mandatory parameter 'message_id' missing");
            }
            HMSLog.m7715e("HmsMessaging", "Mandatory parameter 'to' missing");
            PushBiUtil.reportExit(this.f7690a, PushNaming.UPSEND_MSG, reportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
            throw new IllegalArgumentException("Mandatory parameter 'to' missing");
        }
        HMSLog.m7715e("HmsMessaging", "Message sent failed:" + m7654a.getExternalCode() + ':' + m7654a.getMessage());
        PushBiUtil.reportExit(this.f7690a, PushNaming.UPSEND_MSG, reportEntry, m7654a);
        throw new UnsupportedOperationException(m7654a.getMessage());
    }

    /* renamed from: a */
    private Task<Void> m7519a(boolean z) {
        String reportEntry = PushBiUtil.reportEntry(this.f7690a, PushNaming.SET_NOTIFY_FLAG);
        if (AbstractC2484d.m7550d(this.f7690a) && !AbstractC2484d.m7547b()) {
            if (HwBuildEx.VERSION.EMUI_SDK_INT < 12) {
                HMSLog.m7715e("HmsMessaging", "operation not available on Huawei device with EMUI lower than 5.1");
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                taskCompletionSource.setException(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.toApiException());
                PushBiUtil.reportExit(this.f7690a, PushNaming.SET_NOTIFY_FLAG, reportEntry, ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED);
                return taskCompletionSource.getTask();
            }
            if (AbstractC2484d.m7546b(this.f7690a) < 90101310) {
                HMSLog.m7717i("HmsMessaging", "turn on/off with broadcast v1");
                Intent putExtra = new Intent("com.huawei.intent.action.SELF_SHOW_FLAG").putExtra("enalbeFlag", PushEncrypter.encrypterOld(this.f7690a, this.f7690a.getPackageName() + "#" + z));
                putExtra.setPackage(DispatchConstants.ANDROID);
                return Tasks.callInBackground(new IntentCallable(this.f7690a, putExtra, reportEntry));
            }
            if (AbstractC2484d.m7546b(this.f7690a) < 110118300) {
                HMSLog.m7717i("HmsMessaging", "turn on/off with broadcast v2");
                new PushPreferences(this.f7690a, "push_notify_flag").saveBoolean("notify_msg_enable", !z);
                Uri parse = Uri.parse("content://" + this.f7690a.getPackageName() + ".huawei.push.provider/push_notify_flag.xml");
                Intent intent = new Intent("com.huawei.android.push.intent.SDK_COMMAND");
                intent.putExtra("type", "enalbeFlag");
                intent.putExtra(PushClientConstants.TAG_PKG_NAME, this.f7690a.getPackageName());
                intent.putExtra("url", parse);
                intent.setPackage(DispatchConstants.ANDROID);
                return Tasks.callInBackground(new IntentCallable(this.f7690a, intent, reportEntry));
            }
            HMSLog.m7717i("HmsMessaging", "turn on/off with broadcast v3");
            if (TextUtils.isEmpty(BaseUtils.getLocalToken(this.f7690a, null))) {
                TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
                taskCompletionSource2.setException(ErrorEnum.ERROR_NO_TOKEN.toApiException());
                return taskCompletionSource2.getTask();
            }
            new PushPreferences(this.f7690a, "push_notify_flag").saveBoolean("notify_msg_enable", !z);
            Intent intent2 = new Intent("com.huawei.intent.action.SELF_SHOW_FLAG");
            intent2.putExtra("enalbeFlag", z);
            intent2.putExtra(RemoteMessageConst.DEVICE_TOKEN, BaseUtils.getLocalToken(this.f7690a, null));
            intent2.putExtra(PushClientConstants.TAG_PKG_NAME, this.f7690a.getPackageName());
            intent2.putExtra("uid", this.f7690a.getApplicationInfo().uid);
            intent2.setPackage(DispatchConstants.ANDROID);
            return Tasks.callInBackground(new IntentCallable(this.f7690a, intent2, reportEntry));
        }
        HMSLog.m7717i("HmsMessaging", "turn on/off with AIDL");
        EnableNotifyReq enableNotifyReq = new EnableNotifyReq();
        enableNotifyReq.setPackageName(this.f7690a.getPackageName());
        enableNotifyReq.setEnable(z);
        return this.f7691b.doWrite(new BaseVoidTask(PushNaming.SET_NOTIFY_FLAG, JsonUtil.createJsonString(enableNotifyReq), reportEntry));
    }

    /* renamed from: a */
    private void m7521a(UpSendMsgReq upSendMsgReq, String str) {
        upSendMsgReq.setToken(BaseUtils.getLocalToken(this.f7690a, null));
        try {
            this.f7691b.doWrite(new SendUpStreamTask(PushNaming.UPSEND_MSG, JsonUtil.createJsonString(upSendMsgReq), str, upSendMsgReq.getPackageName(), upSendMsgReq.getMessageId()));
        } catch (Exception e2) {
            if (e2.getCause() instanceof ApiException) {
                PushBiUtil.reportExit(this.f7690a, PushNaming.UPSEND_MSG, str, ((ApiException) e2.getCause()).getStatusCode());
            } else {
                PushBiUtil.reportExit(this.f7690a, PushNaming.UPSEND_MSG, str, ErrorEnum.ERROR_INTERNAL_ERROR);
            }
        }
    }
}
