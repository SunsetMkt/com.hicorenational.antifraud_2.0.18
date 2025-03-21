package com.umeng.message.proguard;

import android.app.Activity;
import android.content.Intent;
import com.umeng.message.api.UPushMessageNotifyApi;
import com.umeng.message.common.UPLog;
import org.json.JSONObject;

/* renamed from: com.umeng.message.proguard.aj */
/* loaded from: classes2.dex */
public class C3561aj implements UPushMessageNotifyApi {

    /* renamed from: c */
    private static volatile C3561aj f13200c;

    /* renamed from: a */
    public final C3562ak f13201a = new C3562ak();

    /* renamed from: b */
    public volatile boolean f13202b;

    private C3561aj() {
    }

    /* renamed from: a */
    public static C3561aj m12251a() {
        if (f13200c == null) {
            synchronized (C3561aj.class) {
                if (f13200c == null) {
                    f13200c = new C3561aj();
                }
            }
        }
        return f13200c;
    }

    /* renamed from: b */
    public final void m12254b() {
        if (this.f13202b) {
            return;
        }
        this.f13202b = true;
        this.f13201a.m12257a();
    }

    @Override // com.umeng.message.api.UPushMessageNotifyApi
    public boolean isEnabled() {
        return this.f13201a.f13204b.m12263a();
    }

    @Override // com.umeng.message.api.UPushMessageNotifyApi
    public void setCallback(UPushMessageNotifyApi.Callback callback) {
        C3562ak c3562ak = this.f13201a;
        c3562ak.f13203a = callback;
        if (callback == null || !c3562ak.f13205c) {
            return;
        }
        try {
            callback.onNotified();
            c3562ak.f13205c = false;
        } catch (Throwable unused) {
        }
    }

    @Override // com.umeng.message.api.UPushMessageNotifyApi
    public void setEnable(final boolean z) {
        final C3562ak c3562ak = this.f13201a;
        if (c3562ak.f13204b.m12263a() != z) {
            c3562ak.f13204b.f13215a.m12287a("e_u", z);
            C3578b.m12325b(new Runnable() { // from class: com.umeng.message.proguard.ak.4
                @Override // java.lang.Runnable
                public final void run() {
                    C3562ak.this.f13204b.m12265b(true);
                    boolean z2 = false;
                    try {
                        if (C3584d.m12361h(C3604x.m12460a())) {
                            z2 = C3562ak.m12256a(z);
                        }
                    } catch (Throwable th) {
                        UPLog.m12143e("Notify", th);
                    }
                    C3562ak.this.f13204b.m12265b(!z2);
                }
            });
        }
    }

    /* renamed from: a */
    public final void m12253a(JSONObject jSONObject) {
        this.f13201a.m12259a(jSONObject);
    }

    /* renamed from: a */
    public final void m12252a(Activity activity, Intent intent) {
        this.f13201a.m12258a(activity, intent);
    }
}
