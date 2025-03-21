package com.xiaomi.mipush.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4171ds;
import com.xiaomi.push.C4172dt;
import java.util.HashSet;
import java.util.Set;

@TargetApi(14)
/* renamed from: com.xiaomi.mipush.sdk.a */
/* loaded from: classes2.dex */
public class C4047a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    private Set<String> f14374a = new HashSet();

    /* renamed from: a */
    public static void m13474a(Context context) {
        m13473a((Application) context.getApplicationContext());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        try {
            Intent intent = activity.getIntent();
            if (intent == null) {
                return;
            }
            String stringExtra = intent.getStringExtra("messageId");
            int intExtra = intent.getIntExtra("eventMessageType", -1);
            if (!TextUtils.isEmpty(stringExtra) && intExtra > 0 && !this.f14374a.contains(stringExtra)) {
                this.f14374a.add(stringExtra);
                if (intExtra == 3000) {
                    C4172dt.m14529a(activity.getApplicationContext()).m14535a(activity.getPackageName(), C4171ds.m14522a(intExtra), stringExtra, 3008, null);
                } else if (intExtra == 1000) {
                    C4172dt.m14529a(activity.getApplicationContext()).m14535a(activity.getPackageName(), C4171ds.m14522a(intExtra), stringExtra, 1008, null);
                }
            }
        } catch (Throwable th) {
            AbstractC4022b.m13361d("An error occurred in onActivityResumed method: " + th);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    /* renamed from: a */
    private static void m13473a(Application application) {
        application.registerActivityLifecycleCallbacks(new C4047a());
    }
}
