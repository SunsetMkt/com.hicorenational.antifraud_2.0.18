package com.vivo.push.f;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.HashMap;

/* compiled from: OnNotificationArrivedReceiveTask.java */
/* loaded from: classes2.dex */
final class v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ InsideNotificationItem f12070a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.q f12071b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ u f12072c;

    v(u uVar, InsideNotificationItem insideNotificationItem, com.vivo.push.b.q qVar) {
        this.f12072c = uVar;
        this.f12070a = insideNotificationItem;
        this.f12071b = qVar;
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
        u uVar = this.f12072c;
        PushMessageCallback pushMessageCallback = ((aa) uVar).f12034b;
        context = ((com.vivo.push.s) uVar).f12207a;
        NotifyArriveCallbackByUser onNotificationMessageArrived = pushMessageCallback.onNotificationMessageArrived(context, com.vivo.push.util.v.a(this.f12070a));
        int a2 = this.f12072c.a(onNotificationMessageArrived);
        if (a2 > 0) {
            HashMap hashMap = new HashMap();
            hashMap.put(com.heytap.mcssdk.constant.b.f5825c, String.valueOf(this.f12071b.f()));
            String a3 = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(a3)) {
                hashMap.put("remoteAppId", a3);
            }
            context9 = ((com.vivo.push.s) this.f12072c).f12207a;
            context10 = ((com.vivo.push.s) this.f12072c).f12207a;
            hashMap.put("clientsdkver", String.valueOf(com.vivo.push.util.ag.c(context9, context10.getPackageName())));
            com.vivo.push.util.f.a(a2, (HashMap<String, String>) hashMap);
            return;
        }
        int b2 = this.f12072c.b();
        if (b2 > 0) {
            StringBuilder sb = new StringBuilder("pkg name : ");
            context7 = ((com.vivo.push.s) this.f12072c).f12207a;
            sb.append(context7.getPackageName());
            sb.append(" notify channel switch is ");
            sb.append(b2);
            com.vivo.push.util.u.b("OnNotificationArrivedTask", sb.toString());
            context8 = ((com.vivo.push.s) this.f12072c).f12207a;
            com.vivo.push.util.u.b(context8, "允许通知开关或者推送通知渠道开关关闭，导致通知无法展示，请到设置页打开应用通知开关 ".concat(String.valueOf(b2)));
            HashMap hashMap2 = new HashMap();
            hashMap2.put(com.heytap.mcssdk.constant.b.f5825c, String.valueOf(this.f12071b.f()));
            String a4 = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(a4)) {
                hashMap2.put("remoteAppId", a4);
            }
            com.vivo.push.util.f.a(b2, (HashMap<String, String>) hashMap2);
            return;
        }
        context2 = ((com.vivo.push.s) this.f12072c).f12207a;
        InsideNotificationItem insideNotificationItem = this.f12070a;
        long f2 = this.f12071b.f();
        u uVar2 = this.f12072c;
        PushMessageCallback pushMessageCallback2 = ((aa) uVar2).f12034b;
        context3 = ((com.vivo.push.s) uVar2).f12207a;
        com.vivo.push.util.p pVar = new com.vivo.push.util.p(context2, insideNotificationItem, f2, pushMessageCallback2.isAllowNet(context3), new w(this), onNotificationMessageArrived);
        boolean isShowBigPicOnMobileNet = this.f12070a.isShowBigPicOnMobileNet();
        String purePicUrl = this.f12070a.getPurePicUrl();
        if (TextUtils.isEmpty(purePicUrl)) {
            purePicUrl = this.f12070a.getCoverUrl();
        }
        if (!TextUtils.isEmpty(purePicUrl)) {
            com.vivo.push.util.u.c("OnNotificationArrivedTask", "showCode=".concat(String.valueOf(isShowBigPicOnMobileNet)));
            if (isShowBigPicOnMobileNet) {
                context4 = ((com.vivo.push.s) this.f12072c).f12207a;
                com.vivo.push.util.u.a(context4, "mobile net show");
            } else {
                context5 = ((com.vivo.push.s) this.f12072c).f12207a;
                com.vivo.push.util.u.a(context5, "mobile net unshow");
                context6 = ((com.vivo.push.s) this.f12072c).f12207a;
                NetworkInfo a5 = com.vivo.push.util.x.a(context6);
                if (a5 != null && a5.getState() == NetworkInfo.State.CONNECTED) {
                    int type = a5.getType();
                    c2 = type == 1 ? (char) 2 : type == 0 ? (char) 1 : (char) 3;
                } else {
                    c2 = 0;
                }
                if (c2 == 1) {
                    purePicUrl = null;
                    this.f12070a.clearCoverUrl();
                    this.f12070a.clearPurePicUrl();
                }
            }
        }
        pVar.execute(this.f12070a.getIconUrl(), purePicUrl);
    }
}
