package com.vivo.push.p237f;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2085b;
import com.vivo.push.AbstractRunnableC3971s;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import com.vivo.push.p232b.C3845q;
import com.vivo.push.restructure.C3932a;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.AsyncTaskC4005p;
import com.vivo.push.util.C3990ag;
import com.vivo.push.util.C3995f;
import com.vivo.push.util.C4010u;
import com.vivo.push.util.C4011v;
import com.vivo.push.util.C4013x;
import java.util.HashMap;

/* compiled from: OnNotificationArrivedReceiveTask.java */
/* renamed from: com.vivo.push.f.v */
/* loaded from: classes2.dex */
final class RunnableC3912v implements Runnable {

    /* renamed from: a */
    final /* synthetic */ InsideNotificationItem f14045a;

    /* renamed from: b */
    final /* synthetic */ C3845q f14046b;

    /* renamed from: c */
    final /* synthetic */ C3911u f14047c;

    RunnableC3912v(C3911u c3911u, InsideNotificationItem insideNotificationItem, C3845q c3845q) {
        this.f14047c = c3911u;
        this.f14045a = insideNotificationItem;
        this.f14046b = c3845q;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        char c2;
        Context context7;
        Context context8;
        Context context9;
        Context context10;
        C3911u c3911u = this.f14047c;
        PushMessageCallback pushMessageCallback = ((AbstractC3882aa) c3911u).f14009b;
        context = ((AbstractRunnableC3971s) c3911u).f14186a;
        NotifyArriveCallbackByUser onNotificationMessageArrived = pushMessageCallback.onNotificationMessageArrived(context, C4011v.m13312a(this.f14045a));
        int m12953a = this.f14047c.m12953a(onNotificationMessageArrived);
        if (m12953a > 0) {
            HashMap hashMap = new HashMap();
            hashMap.put(C2085b.f6162c, String.valueOf(this.f14046b.m12882f()));
            String mo13112a = C3932a.m13069a().m13074e().mo13112a();
            if (!TextUtils.isEmpty(mo13112a)) {
                hashMap.put("remoteAppId", mo13112a);
            }
            context9 = ((AbstractRunnableC3971s) this.f14047c).f14186a;
            context10 = ((AbstractRunnableC3971s) this.f14047c).f14186a;
            hashMap.put("clientsdkver", String.valueOf(C3990ag.m13220c(context9, context10.getPackageName())));
            C3995f.m13249a(m12953a, (HashMap<String, String>) hashMap);
            return;
        }
        int m12957b = this.f14047c.m12957b();
        if (m12957b > 0) {
            StringBuilder sb = new StringBuilder("pkg name : ");
            context7 = ((AbstractRunnableC3971s) this.f14047c).f14186a;
            sb.append(context7.getPackageName());
            sb.append(" notify channel switch is ");
            sb.append(m12957b);
            C4010u.m13301b("OnNotificationArrivedTask", sb.toString());
            context8 = ((AbstractRunnableC3971s) this.f14047c).f14186a;
            C4010u.m13303b(context8, "允许通知开关或者推送通知渠道开关关闭，导致通知无法展示，请到设置页打开应用通知开关 ".concat(String.valueOf(m12957b)));
            HashMap hashMap2 = new HashMap();
            hashMap2.put(C2085b.f6162c, String.valueOf(this.f14046b.m12882f()));
            String mo13112a2 = C3932a.m13069a().m13074e().mo13112a();
            if (!TextUtils.isEmpty(mo13112a2)) {
                hashMap2.put("remoteAppId", mo13112a2);
            }
            C3995f.m13249a(m12957b, (HashMap<String, String>) hashMap2);
            return;
        }
        context2 = ((AbstractRunnableC3971s) this.f14047c).f14186a;
        InsideNotificationItem insideNotificationItem = this.f14045a;
        long m12882f = this.f14046b.m12882f();
        C3911u c3911u2 = this.f14047c;
        PushMessageCallback pushMessageCallback2 = ((AbstractC3882aa) c3911u2).f14009b;
        context3 = ((AbstractRunnableC3971s) c3911u2).f14186a;
        AsyncTaskC4005p asyncTaskC4005p = new AsyncTaskC4005p(context2, insideNotificationItem, m12882f, pushMessageCallback2.isAllowNet(context3), new C3913w(this), onNotificationMessageArrived);
        boolean isShowBigPicOnMobileNet = this.f14045a.isShowBigPicOnMobileNet();
        String purePicUrl = this.f14045a.getPurePicUrl();
        if (TextUtils.isEmpty(purePicUrl)) {
            purePicUrl = this.f14045a.getCoverUrl();
        }
        if (!TextUtils.isEmpty(purePicUrl)) {
            C4010u.m13306c("OnNotificationArrivedTask", "showCode=".concat(String.valueOf(isShowBigPicOnMobileNet)));
            if (isShowBigPicOnMobileNet) {
                context4 = ((AbstractRunnableC3971s) this.f14047c).f14186a;
                C4010u.m13297a(context4, "mobile net show");
            } else {
                context5 = ((AbstractRunnableC3971s) this.f14047c).f14186a;
                C4010u.m13297a(context5, "mobile net unshow");
                context6 = ((AbstractRunnableC3971s) this.f14047c).f14186a;
                NetworkInfo m13315a = C4013x.m13315a(context6);
                if (m13315a != null && m13315a.getState() == NetworkInfo.State.CONNECTED) {
                    int type = m13315a.getType();
                    c2 = type == 1 ? (char) 2 : type == 0 ? (char) 1 : (char) 3;
                } else {
                    c2 = 0;
                }
                if (c2 == 1) {
                    purePicUrl = null;
                    this.f14045a.clearCoverUrl();
                    this.f14045a.clearPurePicUrl();
                }
            }
        }
        asyncTaskC4005p.execute(this.f14045a.getIconUrl(), purePicUrl);
    }
}
