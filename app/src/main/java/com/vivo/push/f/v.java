package com.vivo.push.f;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.util.HashMap;

/* JADX INFO: compiled from: OnNotificationArrivedReceiveTask.java */
/* JADX INFO: loaded from: classes2.dex */
final class v implements Runnable {
    final /* synthetic */ InsideNotificationItem a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.q f8532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ u f8533c;

    v(u uVar, InsideNotificationItem insideNotificationItem, com.vivo.push.b.q qVar) {
        this.f8533c = uVar;
        this.a = insideNotificationItem;
        this.f8532b = qVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        char c2;
        u uVar = this.f8533c;
        NotifyArriveCallbackByUser notifyArriveCallbackByUserOnNotificationMessageArrived = ((aa) uVar).f8506b.onNotificationMessageArrived(((com.vivo.push.s) uVar).a, com.vivo.push.util.v.a(this.a));
        int iA = this.f8533c.a(notifyArriveCallbackByUserOnNotificationMessageArrived);
        if (iA > 0) {
            HashMap map = new HashMap();
            map.put(com.heytap.mcssdk.constant.b.f3893c, String.valueOf(this.f8532b.f()));
            String strA = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(strA)) {
                map.put("remoteAppId", strA);
            }
            map.put("clientsdkver", String.valueOf(com.vivo.push.util.ag.c(((com.vivo.push.s) this.f8533c).a, ((com.vivo.push.s) this.f8533c).a.getPackageName())));
            com.vivo.push.util.f.a(iA, (HashMap<String, String>) map);
            return;
        }
        int iB = this.f8533c.b();
        if (iB > 0) {
            com.vivo.push.util.u.b("OnNotificationArrivedTask", "pkg name : " + ((com.vivo.push.s) this.f8533c).a.getPackageName() + " notify channel switch is " + iB);
            com.vivo.push.util.u.b(((com.vivo.push.s) this.f8533c).a, "\u5141\u8bb8\u901a\u77e5\u5f00\u5173\u6216\u8005\u63a8\u9001\u901a\u77e5\u6e20\u9053\u5f00\u5173\u5173\u95ed\uff0c\u5bfc\u81f4\u901a\u77e5\u65e0\u6cd5\u5c55\u793a\uff0c\u8bf7\u5230\u8bbe\u7f6e\u9875\u6253\u5f00\u5e94\u7528\u901a\u77e5\u5f00\u5173 ".concat(String.valueOf(iB)));
            HashMap map2 = new HashMap();
            map2.put(com.heytap.mcssdk.constant.b.f3893c, String.valueOf(this.f8532b.f()));
            String strA2 = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(strA2)) {
                map2.put("remoteAppId", strA2);
            }
            com.vivo.push.util.f.a(iB, (HashMap<String, String>) map2);
            return;
        }
        Context context = ((com.vivo.push.s) this.f8533c).a;
        InsideNotificationItem insideNotificationItem = this.a;
        long jF = this.f8532b.f();
        u uVar2 = this.f8533c;
        com.vivo.push.util.p pVar = new com.vivo.push.util.p(context, insideNotificationItem, jF, ((aa) uVar2).f8506b.isAllowNet(((com.vivo.push.s) uVar2).a), new w(this), notifyArriveCallbackByUserOnNotificationMessageArrived);
        boolean zIsShowBigPicOnMobileNet = this.a.isShowBigPicOnMobileNet();
        String purePicUrl = this.a.getPurePicUrl();
        if (TextUtils.isEmpty(purePicUrl)) {
            purePicUrl = this.a.getCoverUrl();
        }
        if (!TextUtils.isEmpty(purePicUrl)) {
            com.vivo.push.util.u.c("OnNotificationArrivedTask", "showCode=".concat(String.valueOf(zIsShowBigPicOnMobileNet)));
            if (zIsShowBigPicOnMobileNet) {
                com.vivo.push.util.u.a(((com.vivo.push.s) this.f8533c).a, "mobile net show");
            } else {
                com.vivo.push.util.u.a(((com.vivo.push.s) this.f8533c).a, "mobile net unshow");
                NetworkInfo networkInfoA = com.vivo.push.util.x.a(((com.vivo.push.s) this.f8533c).a);
                if (networkInfoA != null && networkInfoA.getState() == NetworkInfo.State.CONNECTED) {
                    int type = networkInfoA.getType();
                    c2 = type == 1 ? (char) 2 : type == 0 ? (char) 1 : (char) 3;
                } else {
                    c2 = 0;
                }
                if (c2 == 1) {
                    purePicUrl = null;
                    this.a.clearCoverUrl();
                    this.a.clearPurePicUrl();
                }
            }
        }
        pVar.execute(this.a.getIconUrl(), purePicUrl);
    }
}
