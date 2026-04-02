package com.hihonor.push.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.hihonor.push.framework.aidl.entity.PushTokenResult;
import com.hihonor.push.sdk.common.data.DownMsgType;
import com.hihonor.push.sdk.common.data.UpMsgType;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class m implements Callable<String> {
    public final /* synthetic */ boolean a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ s f4269b;

    public m(s sVar, boolean z) {
        this.f4269b = sVar;
        this.a = z;
    }

    @Override // java.util.concurrent.Callable
    public String call() throws Exception {
        this.f4269b.f4275b.getClass();
        try {
            e1 e1Var = new e1(UpMsgType.REQUEST_PUSH_TOKEN, null);
            e1Var.f4254e = b.a();
            String pushToken = ((PushTokenResult) b.a(z.f4293c.a(e1Var))).getPushToken();
            if (this.a) {
                s sVar = this.f4269b;
                sVar.getClass();
                if (!TextUtils.isEmpty(pushToken)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("event_type", DownMsgType.RECEIVE_TOKEN);
                    bundle.putString("push_token", pushToken);
                    g0 g0Var = new g0();
                    Context context = sVar.a;
                    try {
                        Intent intent = new Intent();
                        intent.setPackage(context.getPackageName());
                        intent.setAction("com.hihonor.push.action.MESSAGING_EVENT");
                        Context applicationContext = context.getApplicationContext();
                        g0Var.f4257c = applicationContext;
                        g0Var.f4256b = bundle;
                        applicationContext.bindService(intent, g0Var, 1);
                    } catch (Exception e2) {
                        String str = "bind service failed." + e2.getMessage();
                    }
                }
            }
            return pushToken;
        } catch (Exception e3) {
            throw b.a(e3);
        }
    }
}
