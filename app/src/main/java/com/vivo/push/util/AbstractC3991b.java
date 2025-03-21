package com.vivo.push.util;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2085b;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import com.vivo.push.p232b.C3844p;
import com.vivo.push.p236e.C3878b;
import com.vivo.push.restructure.C3932a;
import java.security.PublicKey;
import java.util.HashMap;

/* compiled from: BaseConvertMsgToIntent.java */
/* renamed from: com.vivo.push.util.b */
/* loaded from: classes2.dex */
public abstract class AbstractC3991b {

    /* renamed from: a */
    protected String f14235a;

    /* renamed from: b */
    protected long f14236b;

    /* renamed from: c */
    protected Context f14237c;

    /* renamed from: d */
    protected NotifyArriveCallbackByUser f14238d;

    /* renamed from: a */
    protected static void m13228a(Intent intent, Context context) {
        try {
            intent.putExtra("security_avoid_pull", C3983a.m13174a(context).m13177a("com.vivo.pushservice"));
            if (Build.VERSION.SDK_INT >= 18) {
                String mo12940a = C3878b.m12943a().m12944a(context).mo12940a("com.vivo.pushservice");
                PublicKey mo12941a = C3878b.m12943a().m12944a(context).mo12941a();
                if (TextUtils.isEmpty(mo12940a)) {
                    mo12940a = "com.vivo.pushservice";
                }
                intent.putExtra("security_avoid_pull_rsa", mo12940a);
                intent.putExtra("security_avoid_rsa_public_key", mo12941a == null ? "com.vivo.pushservice" : C3985ab.m13192a(mo12941a));
            }
        } catch (Exception e2) {
            C4010u.m13292a("BaseNotifyClickIntentParam", "pushNotificationBySystem encrypt ：" + e2.getMessage());
            intent.putExtra("security_avoid_pull_rsa", "com.vivo.pushservice");
            intent.putExtra("security_avoid_rsa_public_key", "com.vivo.pushservice");
        }
    }

    /* renamed from: a */
    protected abstract int mo13229a();

    /* renamed from: a */
    protected abstract PendingIntent mo13230a(Context context, Intent intent);

    /* renamed from: a */
    protected abstract Intent mo13231a(Context context, InsideNotificationItem insideNotificationItem, NotifyArriveCallbackByUser notifyArriveCallbackByUser);

    /* renamed from: b */
    public final long m13233b() {
        return this.f14236b;
    }

    /* renamed from: a */
    public final Intent m13232a(Context context, String str, long j2, InsideNotificationItem insideNotificationItem, NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        this.f14236b = j2;
        this.f14235a = str;
        this.f14237c = context;
        this.f14238d = notifyArriveCallbackByUser;
        Intent mo13231a = mo13231a(context, insideNotificationItem, notifyArriveCallbackByUser);
        int mo13229a = mo13229a();
        if (mo13229a <= 0) {
            return mo13231a;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(C2085b.f6162c, String.valueOf(this.f14236b));
        String mo13112a = C3932a.m13069a().m13074e().mo13112a();
        if (!TextUtils.isEmpty(mo13112a)) {
            hashMap.put("remoteAppId", mo13112a);
        }
        hashMap.put("ap", this.f14235a);
        hashMap.put("clientsdkver", String.valueOf(C3990ag.m13220c(this.f14237c, this.f14235a)));
        C3995f.m13249a(mo13229a, (HashMap<String, String>) hashMap);
        return null;
    }

    /* renamed from: a */
    public static Intent m13227a(Context context, String str, long j2, Intent intent, InsideNotificationItem insideNotificationItem) {
        Intent intent2 = new Intent("com.vivo.pushservice.action.RECEIVE");
        intent2.setPackage(context.getPackageName());
        intent2.setClassName(context.getPackageName(), "com.vivo.push.sdk.service.CommandService");
        intent2.putExtra("command_type", "reflect_receiver");
        intent2.putExtras(intent.getExtras());
        m13228a(intent2, context);
        C3844p c3844p = new C3844p(str, j2, insideNotificationItem);
        c3844p.m12863b(intent.getAction());
        if (intent.getComponent() != null) {
            c3844p.m12864c(intent.getComponent().getPackageName());
            c3844p.m12866d(intent.getComponent().getClassName());
        }
        if (intent.getData() != null) {
            c3844p.m12862a(intent.getData());
        }
        c3844p.m13326b(intent2);
        return intent2;
    }
}
