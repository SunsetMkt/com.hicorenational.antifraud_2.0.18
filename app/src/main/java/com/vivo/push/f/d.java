package com.vivo.push.f;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.just.agentweb.DefaultWebClient;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;

/* JADX INFO: compiled from: NotifyInnerClientClickTask.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends aa {
    d(com.vivo.push.v vVar) {
        super(vVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00d8  */
    @Override // com.vivo.push.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void a(com.vivo.push.v vVar) {
        Intent intent;
        com.vivo.push.b.p pVar = (com.vivo.push.b.p) vVar;
        if (pVar == null) {
            com.vivo.push.util.u.d("NotifyInnerClientTask", "current onNotifyArrivedCommand is null");
            return;
        }
        InsideNotificationItem insideNotificationItemF = pVar.f();
        if (insideNotificationItemF == null) {
            com.vivo.push.util.u.d("NotifyInnerClientTask", "current notification item is null");
            return;
        }
        UPSNotificationMessage uPSNotificationMessageA = com.vivo.push.util.v.a(insideNotificationItemF);
        boolean zEquals = this.a.getPackageName().equals(pVar.d());
        if (zEquals) {
            NotifyAdapterUtil.cancelNotify(this.a);
        }
        if (!zEquals) {
            com.vivo.push.util.u.a("NotifyInnerClientTask", "notify is " + uPSNotificationMessageA + " ; isMatch is " + zEquals);
            return;
        }
        com.vivo.push.b.x xVar = new com.vivo.push.b.x(1030L);
        HashMap<String, String> map = new HashMap<>();
        map.put("type", "2");
        map.put(com.heytap.mcssdk.constant.b.f3893c, String.valueOf(pVar.e()));
        map.put("platform", this.a.getPackageName());
        String strA = com.vivo.push.restructure.a.a().e().a();
        if (!TextUtils.isEmpty(strA)) {
            map.put("remoteAppId", strA);
        }
        xVar.a(map);
        com.vivo.push.m.a().a(xVar);
        com.vivo.push.util.u.d("NotifyInnerClientTask", "notification is clicked by skip type[" + uPSNotificationMessageA.getSkipType() + "]");
        com.vivo.push.util.u.d("NotifyInnerClientTask", "notification is clicked by skip content[" + uPSNotificationMessageA.getSkipContent() + "]");
        try {
            if (uPSNotificationMessageA.getSkipType() == 2) {
                String skipContent = uPSNotificationMessageA.getSkipContent();
                if (!TextUtils.isEmpty(skipContent)) {
                    String lowerCase = skipContent.toLowerCase();
                    boolean z = lowerCase.startsWith(DefaultWebClient.HTTP_SCHEME) || lowerCase.startsWith(DefaultWebClient.HTTPS_SCHEME);
                    if (!z) {
                        return;
                    }
                    intent = new Intent("android.intent.action.VIEW", Uri.parse(skipContent));
                    intent.setFlags(CommonNetImpl.FLAG_AUTH);
                }
            } else {
                intent = new Intent(pVar.g());
                if (!TextUtils.isEmpty(pVar.h()) && !TextUtils.isEmpty(pVar.i())) {
                    intent.setComponent(new ComponentName(pVar.h(), pVar.i()));
                }
                String packageName = intent.getComponent() == null ? null : intent.getComponent().getPackageName();
                if (!TextUtils.isEmpty(packageName) && !this.a.getPackageName().equals(packageName)) {
                    com.vivo.push.util.u.a("NotifyInnerClientTask", "inner activity component error : local pkgName is " + this.a.getPackageName() + "; but remote pkgName is " + packageName);
                    return;
                }
                if (pVar.j() != null) {
                    intent.setData(pVar.j());
                }
                intent.setSelector(null);
                intent.setPackage(this.a.getPackageName());
                intent.addFlags(335544320);
                ActivityInfo activityInfoResolveActivityInfo = intent.resolveActivityInfo(this.a.getPackageManager(), 65536);
                if (activityInfoResolveActivityInfo != null && !activityInfoResolveActivityInfo.exported) {
                    com.vivo.push.util.u.d("NotifyInnerClientTask", "activity is not exported : " + activityInfoResolveActivityInfo.toString());
                }
            }
            intent.putExtras(pVar.k());
            this.a.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
