package com.hihonor.push.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.hihonor.push.framework.aidl.entity.PushTokenResult;
import com.hihonor.push.sdk.common.data.DownMsgType;
import com.hihonor.push.sdk.common.data.UpMsgType;
import java.util.concurrent.Callable;

/* renamed from: com.hihonor.push.sdk.m */
/* loaded from: classes.dex */
public class CallableC2216m implements Callable<String> {

    /* renamed from: a */
    public final /* synthetic */ boolean f6806a;

    /* renamed from: b */
    public final /* synthetic */ C2228s f6807b;

    public CallableC2216m(C2228s c2228s, boolean z) {
        this.f6807b = c2228s;
        this.f6806a = z;
    }

    @Override // java.util.concurrent.Callable
    public String call() throws Exception {
        this.f6807b.f6824b.getClass();
        try {
            C2198e1 c2198e1 = new C2198e1(UpMsgType.REQUEST_PUSH_TOKEN, null);
            c2198e1.f6779e = C2186b.m6359a();
            String pushToken = ((PushTokenResult) C2186b.m6363a(C2242z.f6856c.m6403a(c2198e1))).getPushToken();
            if (this.f6806a) {
                C2228s c2228s = this.f6807b;
                c2228s.getClass();
                if (!TextUtils.isEmpty(pushToken)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("event_type", DownMsgType.RECEIVE_TOKEN);
                    bundle.putString("push_token", pushToken);
                    ServiceConnectionC2203g0 serviceConnectionC2203g0 = new ServiceConnectionC2203g0();
                    Context context = c2228s.f6823a;
                    try {
                        Intent intent = new Intent();
                        intent.setPackage(context.getPackageName());
                        intent.setAction("com.hihonor.push.action.MESSAGING_EVENT");
                        Context applicationContext = context.getApplicationContext();
                        serviceConnectionC2203g0.f6784c = applicationContext;
                        serviceConnectionC2203g0.f6783b = bundle;
                        applicationContext.bindService(intent, serviceConnectionC2203g0, 1);
                    } catch (Exception e2) {
                        String str = "bind service failed." + e2.getMessage();
                    }
                }
            }
            return pushToken;
        } catch (Exception e3) {
            throw C2186b.m6362a(e3);
        }
    }
}
