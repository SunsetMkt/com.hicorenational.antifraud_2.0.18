package com.umeng.analytics.pro;

import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: HttpPostDataThread.java */
/* renamed from: com.umeng.analytics.pro.an */
/* loaded from: classes2.dex */
public class RunnableC3330an implements Runnable {

    /* renamed from: a */
    public static final String f11463a = "https://aspect-upush.umeng.com/occa/v1/event/report";

    /* renamed from: b */
    private String f11464b;

    /* renamed from: c */
    private String f11465c;

    public RunnableC3330an(String str, JSONObject jSONObject) {
        this.f11464b = str;
        this.f11465c = jSONObject.toString();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (TextUtils.isEmpty(this.f11465c)) {
                return;
            }
            C3329am.m10853b(this.f11464b, this.f11465c.getBytes());
        } catch (Throwable unused) {
        }
    }
}
