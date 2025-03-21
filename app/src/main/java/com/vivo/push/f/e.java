package com.vivo.push.f;

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
import java.util.Map;

/* compiled from: NotifyOpenClientClickTask.java */
/* loaded from: classes2.dex */
public final class e extends aa {
    e(com.vivo.push.v vVar) {
        super(vVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Intent b(Intent intent, Map<String, String> map) {
        if (map != null && map.entrySet() != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && entry.getKey() != null) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
        }
        return intent;
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        Intent parseUri;
        String str;
        com.vivo.push.b.p pVar = (com.vivo.push.b.p) vVar;
        InsideNotificationItem f2 = pVar.f();
        if (f2 == null) {
            com.vivo.push.util.u.d("NotifyOpenClientTask", "current notification item is null");
            return;
        }
        UPSNotificationMessage a2 = com.vivo.push.util.v.a(f2);
        boolean equals = this.f12207a.getPackageName().equals(pVar.d());
        if (equals) {
            NotifyAdapterUtil.cancelNotify(this.f12207a);
        }
        if (equals) {
            com.vivo.push.b.x xVar = new com.vivo.push.b.x(1030L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("type", "2");
            hashMap.put(com.heytap.mcssdk.constant.b.f5825c, String.valueOf(pVar.e()));
            hashMap.put("platform", this.f12207a.getPackageName());
            String a3 = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(a3)) {
                hashMap.put("remoteAppId", a3);
            }
            xVar.a(hashMap);
            com.vivo.push.m.a().a(xVar);
            com.vivo.push.util.u.d("NotifyOpenClientTask", "notification is clicked by skip type[" + a2.getSkipType() + "]");
            int skipType = a2.getSkipType();
            boolean z = true;
            if (skipType == 1) {
                new Thread(new f(this, this.f12207a, a2.getParams())).start();
                a(a2);
                return;
            }
            if (skipType == 2) {
                String skipContent = a2.getSkipContent();
                if (!skipContent.startsWith(DefaultWebClient.HTTP_SCHEME) && !skipContent.startsWith(DefaultWebClient.HTTPS_SCHEME)) {
                    z = false;
                }
                if (z) {
                    Uri parse = Uri.parse(skipContent);
                    Intent intent = new Intent("android.intent.action.VIEW", parse);
                    intent.setFlags(CommonNetImpl.FLAG_AUTH);
                    b(intent, a2.getParams());
                    try {
                        this.f12207a.startActivity(intent);
                    } catch (Exception unused) {
                        com.vivo.push.util.u.a("NotifyOpenClientTask", "startActivity error : ".concat(String.valueOf(parse)));
                    }
                } else {
                    com.vivo.push.util.u.a("NotifyOpenClientTask", "url not legal");
                }
                a(a2);
                return;
            }
            if (skipType == 3) {
                a(a2);
                return;
            }
            if (skipType != 4) {
                com.vivo.push.util.u.a("NotifyOpenClientTask", "illegitmacy skip type error : " + a2.getSkipType());
                return;
            }
            String skipContent2 = a2.getSkipContent();
            try {
                parseUri = Intent.parseUri(skipContent2, 1);
                str = parseUri.getPackage();
            } catch (Exception e2) {
                com.vivo.push.util.u.a("NotifyOpenClientTask", "open activity error : ".concat(String.valueOf(skipContent2)), e2);
            }
            if (!TextUtils.isEmpty(str) && !this.f12207a.getPackageName().equals(str)) {
                com.vivo.push.util.u.a("NotifyOpenClientTask", "open activity error : local pkgName is " + this.f12207a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                return;
            }
            String packageName = parseUri.getComponent() == null ? null : parseUri.getComponent().getPackageName();
            if (!TextUtils.isEmpty(packageName) && !this.f12207a.getPackageName().equals(packageName)) {
                com.vivo.push.util.u.a("NotifyOpenClientTask", "open activity component error : local pkgName is " + this.f12207a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                return;
            }
            parseUri.setSelector(null);
            parseUri.setPackage(this.f12207a.getPackageName());
            parseUri.addFlags(335544320);
            b(parseUri, a2.getParams());
            ActivityInfo resolveActivityInfo = parseUri.resolveActivityInfo(this.f12207a.getPackageManager(), 65536);
            if (resolveActivityInfo != null && !resolveActivityInfo.exported) {
                com.vivo.push.util.u.a("NotifyOpenClientTask", "activity is not exported : " + resolveActivityInfo.toString());
                return;
            } else {
                this.f12207a.startActivity(parseUri);
                a(a2);
                return;
            }
        }
        com.vivo.push.util.u.a("NotifyOpenClientTask", "notify is " + a2 + " ; isMatch is " + equals);
    }

    private void a(UPSNotificationMessage uPSNotificationMessage) {
        com.vivo.push.t.c(new g(this, uPSNotificationMessage));
    }
}
