package com.alibaba.sdk.android.utils;

import android.app.Application;
import android.text.TextUtils;
import com.alibaba.sdk.android.utils.crashdefend.SDKMessageCallback;
import com.alibaba.sdk.android.utils.crashdefend.c;
import com.taobao.accs.common.Constants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AlicloudTrackerManager {
    private static AlicloudTrackerManager a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private a f42a = new a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.alibaba.sdk.android.utils.crashdefend.b f43a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, AlicloudTracker> f2624b;

    private AlicloudTrackerManager(Application application) {
        this.f43a = null;
        HashMap map = new HashMap(4);
        map.put("kVersion", "2.0.0");
        map.put(Constants.KEY_PACKAGE_NAME, application.getPackageName());
        this.f42a.a(application, map);
        this.f2624b = new HashMap();
        this.f43a = com.alibaba.sdk.android.utils.crashdefend.b.a(application, this.f42a);
    }

    public static synchronized AlicloudTrackerManager getInstance(Application application) {
        if (application == null) {
            return null;
        }
        if (a == null) {
            a = new AlicloudTrackerManager(application);
        }
        return a;
    }

    public AlicloudTracker getTracker(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + str2;
        if (this.f2624b.containsKey(str3)) {
            return this.f2624b.get(str3);
        }
        AlicloudTracker alicloudTracker = new AlicloudTracker(this.f42a, str, str2);
        this.f2624b.put(str3, alicloudTracker);
        return alicloudTracker;
    }

    public boolean registerCrashDefend(String str, String str2, int i2, int i3, SDKMessageCallback sDKMessageCallback) {
        if (this.f43a == null) {
            return false;
        }
        c cVar = new c();
        cVar.f52a = str;
        cVar.f54b = str2;
        cVar.a = i2;
        cVar.f2631b = i3;
        return this.f43a.m31a(cVar, sDKMessageCallback);
    }

    public void unregisterCrashDefend(String str, String str2) {
        this.f43a.b(str, str2);
    }
}
