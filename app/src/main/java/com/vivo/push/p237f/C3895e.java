package com.vivo.push.p237f;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2085b;
import com.just.agentweb.DefaultWebClient;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.vivo.push.AbstractC4016v;
import com.vivo.push.C3924m;
import com.vivo.push.C3975t;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.p232b.C3844p;
import com.vivo.push.p232b.C3852x;
import com.vivo.push.restructure.C3932a;
import com.vivo.push.util.C4010u;
import com.vivo.push.util.C4011v;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;
import java.util.Map;

/* compiled from: NotifyOpenClientClickTask.java */
/* renamed from: com.vivo.push.f.e */
/* loaded from: classes2.dex */
public final class C3895e extends AbstractC3882aa {
    C3895e(AbstractC4016v abstractC4016v) {
        super(abstractC4016v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static Intent m12967b(Intent intent, Map<String, String> map) {
        if (map != null && map.entrySet() != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && entry.getKey() != null) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
        }
        return intent;
    }

    @Override // com.vivo.push.AbstractRunnableC3971s
    /* renamed from: a */
    protected final void mo12952a(AbstractC4016v abstractC4016v) {
        Intent parseUri;
        String str;
        C3844p c3844p = (C3844p) abstractC4016v;
        InsideNotificationItem m12868f = c3844p.m12868f();
        if (m12868f == null) {
            C4010u.m13309d("NotifyOpenClientTask", "current notification item is null");
            return;
        }
        UPSNotificationMessage m13312a = C4011v.m13312a(m12868f);
        boolean equals = this.f14186a.getPackageName().equals(c3844p.m12865d());
        if (equals) {
            NotifyAdapterUtil.cancelNotify(this.f14186a);
        }
        if (equals) {
            C3852x c3852x = new C3852x(1030L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("type", "2");
            hashMap.put(C2085b.f6162c, String.valueOf(c3844p.m12867e()));
            hashMap.put("platform", this.f14186a.getPackageName());
            String mo13112a = C3932a.m13069a().m13074e().mo13112a();
            if (!TextUtils.isEmpty(mo13112a)) {
                hashMap.put("remoteAppId", mo13112a);
            }
            c3852x.m12886a(hashMap);
            C3924m.m13016a().m13032a(c3852x);
            C4010u.m13309d("NotifyOpenClientTask", "notification is clicked by skip type[" + m13312a.getSkipType() + "]");
            int skipType = m13312a.getSkipType();
            boolean z = true;
            if (skipType == 1) {
                new Thread(new RunnableC3896f(this, this.f14186a, m13312a.getParams())).start();
                m12966a(m13312a);
                return;
            }
            if (skipType == 2) {
                String skipContent = m13312a.getSkipContent();
                if (!skipContent.startsWith(DefaultWebClient.HTTP_SCHEME) && !skipContent.startsWith(DefaultWebClient.HTTPS_SCHEME)) {
                    z = false;
                }
                if (z) {
                    Uri parse = Uri.parse(skipContent);
                    Intent intent = new Intent("android.intent.action.VIEW", parse);
                    intent.setFlags(CommonNetImpl.FLAG_AUTH);
                    m12967b(intent, m13312a.getParams());
                    try {
                        this.f14186a.startActivity(intent);
                    } catch (Exception unused) {
                        C4010u.m13292a("NotifyOpenClientTask", "startActivity error : ".concat(String.valueOf(parse)));
                    }
                } else {
                    C4010u.m13292a("NotifyOpenClientTask", "url not legal");
                }
                m12966a(m13312a);
                return;
            }
            if (skipType == 3) {
                m12966a(m13312a);
                return;
            }
            if (skipType != 4) {
                C4010u.m13292a("NotifyOpenClientTask", "illegitmacy skip type error : " + m13312a.getSkipType());
                return;
            }
            String skipContent2 = m13312a.getSkipContent();
            try {
                parseUri = Intent.parseUri(skipContent2, 1);
                str = parseUri.getPackage();
            } catch (Exception e2) {
                C4010u.m13293a("NotifyOpenClientTask", "open activity error : ".concat(String.valueOf(skipContent2)), e2);
            }
            if (!TextUtils.isEmpty(str) && !this.f14186a.getPackageName().equals(str)) {
                C4010u.m13292a("NotifyOpenClientTask", "open activity error : local pkgName is " + this.f14186a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                return;
            }
            String packageName = parseUri.getComponent() == null ? null : parseUri.getComponent().getPackageName();
            if (!TextUtils.isEmpty(packageName) && !this.f14186a.getPackageName().equals(packageName)) {
                C4010u.m13292a("NotifyOpenClientTask", "open activity component error : local pkgName is " + this.f14186a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                return;
            }
            parseUri.setSelector(null);
            parseUri.setPackage(this.f14186a.getPackageName());
            parseUri.addFlags(335544320);
            m12967b(parseUri, m13312a.getParams());
            ActivityInfo resolveActivityInfo = parseUri.resolveActivityInfo(this.f14186a.getPackageManager(), 65536);
            if (resolveActivityInfo != null && !resolveActivityInfo.exported) {
                C4010u.m13292a("NotifyOpenClientTask", "activity is not exported : " + resolveActivityInfo.toString());
                return;
            } else {
                this.f14186a.startActivity(parseUri);
                m12966a(m13312a);
                return;
            }
        }
        C4010u.m13292a("NotifyOpenClientTask", "notify is " + m13312a + " ; isMatch is " + equals);
    }

    /* renamed from: a */
    private void m12966a(UPSNotificationMessage uPSNotificationMessage) {
        C3975t.m13171c(new RunnableC3897g(this, uPSNotificationMessage));
    }
}
