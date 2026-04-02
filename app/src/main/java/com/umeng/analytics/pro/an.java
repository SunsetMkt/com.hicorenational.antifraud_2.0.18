package com.umeng.analytics.pro;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: HttpPostDataThread.java */
/* JADX INFO: loaded from: classes2.dex */
public class an implements Runnable {
    public static final String a = "https://aspect-upush.umeng.com/occa/v1/event/report";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f7002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f7003c;

    public an(String str, JSONObject jSONObject) {
        this.f7002b = str;
        this.f7003c = jSONObject.toString();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (TextUtils.isEmpty(this.f7003c)) {
                return;
            }
            am.b(this.f7002b, this.f7003c.getBytes());
        } catch (Throwable unused) {
        }
    }
}
