package com.umeng.message.proguard;

import android.app.Activity;
import android.content.Intent;
import com.umeng.message.api.UPushMessageNotifyApi;
import com.umeng.message.common.UPLog;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class aj implements UPushMessageNotifyApi {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile aj f7983c;
    public final ak a = new ak();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f7984b;

    private aj() {
    }

    public static aj a() {
        if (f7983c == null) {
            synchronized (aj.class) {
                if (f7983c == null) {
                    f7983c = new aj();
                }
            }
        }
        return f7983c;
    }

    public final void b() {
        if (this.f7984b) {
            return;
        }
        this.f7984b = true;
        this.a.a();
    }

    @Override // com.umeng.message.api.UPushMessageNotifyApi
    public boolean isEnabled() {
        return this.a.f7985b.a();
    }

    @Override // com.umeng.message.api.UPushMessageNotifyApi
    public void setCallback(UPushMessageNotifyApi.Callback callback) {
        ak akVar = this.a;
        akVar.a = callback;
        if (callback == null || !akVar.f7986c) {
            return;
        }
        try {
            callback.onNotified();
            akVar.f7986c = false;
        } catch (Throwable unused) {
        }
    }

    @Override // com.umeng.message.api.UPushMessageNotifyApi
    public void setEnable(final boolean z) {
        final ak akVar = this.a;
        if (akVar.f7985b.a() != z) {
            akVar.f7985b.a.a("e_u", z);
            b.b(new Runnable() { // from class: com.umeng.message.proguard.ak.4
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.f7985b.b(true);
                    boolean zA = false;
                    try {
                        if (d.h(x.a())) {
                            zA = ak.a(z);
                        }
                    } catch (Throwable th) {
                        UPLog.e("Notify", th);
                    }
                    ak.this.f7985b.b(!zA);
                }
            });
        }
    }

    public final void a(JSONObject jSONObject) {
        this.a.a(jSONObject);
    }

    public final void a(Activity activity, Intent intent) {
        this.a.a(activity, intent);
    }
}
