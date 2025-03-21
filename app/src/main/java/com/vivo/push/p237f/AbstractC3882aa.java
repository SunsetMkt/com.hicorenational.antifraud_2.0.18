package com.vivo.push.p237f;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.AbstractC4016v;
import com.vivo.push.AbstractRunnableC3971s;
import com.vivo.push.C3924m;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.C3985ab;
import com.vivo.push.util.C4010u;
import com.vivo.push.util.NotifyAdapterUtil;
import java.security.PublicKey;

/* compiled from: OnReceiveTask.java */
/* renamed from: com.vivo.push.f.aa */
/* loaded from: classes2.dex */
public abstract class AbstractC3882aa extends AbstractRunnableC3971s {

    /* renamed from: b */
    protected PushMessageCallback f14009b;

    /* renamed from: c */
    private int f14010c;

    AbstractC3882aa(AbstractC4016v abstractC4016v) {
        super(abstractC4016v);
        this.f14010c = 0;
    }

    /* renamed from: a */
    public final void m12955a(PushMessageCallback pushMessageCallback) {
        this.f14009b = pushMessageCallback;
    }

    /* renamed from: b */
    public final int m12957b() {
        if (Build.VERSION.SDK_INT < 24) {
            return 0;
        }
        NotificationManager notificationManager = (NotificationManager) this.f14186a.getSystemService("notification");
        if (notificationManager != null && !notificationManager.areNotificationsEnabled()) {
            return 2104;
        }
        if (Build.VERSION.SDK_INT < 26 || notificationManager == null) {
            return 0;
        }
        try {
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(NotifyAdapterUtil.PRIMARY_CHANNEL);
            if (notificationChannel != null) {
                return notificationChannel.getImportance() == 0 ? 2121 : 0;
            }
            return 0;
        } catch (Exception unused) {
            C4010u.m13301b("OnVerifyCallBackCommand", "判断通知通道出现系统错误");
            return 0;
        }
    }

    /* renamed from: c */
    public final int m12958c() {
        return this.f14010c;
    }

    /* renamed from: a */
    public final boolean m12956a(PublicKey publicKey, String str, String str2) {
        if (!C3924m.m13016a().m13045d()) {
            C4010u.m13309d("OnVerifyCallBackCommand", "vertify is not support , vertify is ignore");
            return true;
        }
        if (publicKey == null) {
            C4010u.m13309d("OnVerifyCallBackCommand", "vertify key is null");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            C4010u.m13309d("OnVerifyCallBackCommand", "contentTag is null");
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            C4010u.m13309d("OnVerifyCallBackCommand", "vertify id is null");
            return false;
        }
        try {
            C4010u.m13309d("OnVerifyCallBackCommand", str.hashCode() + " = " + str2);
            if (C3985ab.m13194a(str.getBytes("UTF-8"), publicKey, Base64.decode(str2, 2))) {
                C4010u.m13309d("OnVerifyCallBackCommand", "vertify id is success");
                return true;
            }
            C4010u.m13309d("OnVerifyCallBackCommand", "vertify fail srcDigest is ".concat(String.valueOf(str)));
            C4010u.m13308c(this.f14186a, "vertify fail srcDigest is ".concat(String.valueOf(str)));
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            C4010u.m13309d("OnVerifyCallBackCommand", "vertify exception");
            return false;
        }
    }

    /* renamed from: a */
    public final int m12953a(NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        if (notifyArriveCallbackByUser == null) {
            C4010u.m13301b("OnVerifyCallBackCommand", "pkg name : " + this.f14186a.getPackageName() + " 应用到达回调返回值为空，不做处理");
            C4010u.m13303b(this.f14186a, "应用到达回调返回值异常，导致通知无法展示，如需打开请在onNotificationMessageArrived中返回正确的对象");
            return 2163;
        }
        if (!notifyArriveCallbackByUser.isIntercept()) {
            return 0;
        }
        C4010u.m13301b("OnVerifyCallBackCommand", "pkg name : " + this.f14186a.getPackageName() + " 应用主动拦截通知");
        C4010u.m13303b(this.f14186a, "应用主动拦截通知，导致通知无法展示，如需打开请在onNotificationMessageArrived中返回false");
        return 2120;
    }

    /* renamed from: a */
    public final void m12954a(int i2) {
        this.f14010c = i2;
    }
}
