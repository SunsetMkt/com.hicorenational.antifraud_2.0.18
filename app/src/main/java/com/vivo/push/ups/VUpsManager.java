package com.vivo.push.ups;

import android.content.Context;
import android.os.Bundle;
import com.vivo.push.PushClient;

/* loaded from: classes2.dex */
public class VUpsManager {

    /* renamed from: com.vivo.push.ups.VUpsManager$a */
    private static class C3977a {

        /* renamed from: a */
        private static VUpsManager f14201a = new VUpsManager();
    }

    public static VUpsManager getInstance() {
        return C3977a.f14201a;
    }

    public void onCommandResult(Context context, Bundle bundle) {
    }

    public void registerToken(Context context, String str, String str2, String str3, UPSRegisterCallback uPSRegisterCallback) {
        PushClient.getInstance(context).turnOnPush(new C3978a(this, uPSRegisterCallback));
    }

    public void turnOffPush(Context context, UPSTurnCallback uPSTurnCallback) {
        PushClient.getInstance(context).turnOffPush(new C3981d(this, uPSTurnCallback));
    }

    public void turnOnPush(Context context, UPSTurnCallback uPSTurnCallback) {
        PushClient.getInstance(context).turnOnPush(new C3980c(this, uPSTurnCallback));
    }

    public void unRegisterToken(Context context, UPSRegisterCallback uPSRegisterCallback) {
        PushClient.getInstance(context).turnOffPush(new C3979b(this, uPSRegisterCallback));
    }
}
