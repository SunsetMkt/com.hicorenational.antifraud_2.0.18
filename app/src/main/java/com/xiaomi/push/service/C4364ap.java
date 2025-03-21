package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import com.xiaomi.push.C4409x;

/* renamed from: com.xiaomi.push.service.ap */
/* loaded from: classes2.dex */
public class C4364ap {

    /* renamed from: a */
    private static C4364ap f16627a;

    /* renamed from: a */
    private int f16628a = 0;

    /* renamed from: a */
    private Context f16629a;

    private C4364ap(Context context) {
        this.f16629a = context.getApplicationContext();
    }

    /* renamed from: a */
    public static C4364ap m15985a(Context context) {
        if (f16627a == null) {
            f16627a = new C4364ap(context);
        }
        return f16627a;
    }

    /* renamed from: a */
    public boolean m15988a() {
        return C4409x.f16835a.contains("xmsf") || C4409x.f16835a.contains("xiaomi") || C4409x.f16835a.contains("miui");
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public int m15986a() {
        int i2 = this.f16628a;
        if (i2 != 0) {
            return i2;
        }
        try {
            this.f16628a = Settings.Global.getInt(this.f16629a.getContentResolver(), "device_provisioned", 0);
        } catch (Exception unused) {
        }
        return this.f16628a;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public Uri m15987a() {
        return Settings.Global.getUriFor("device_provisioned");
    }
}
