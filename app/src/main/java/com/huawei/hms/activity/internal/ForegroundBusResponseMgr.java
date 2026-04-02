package com.huawei.hms.activity.internal;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ForegroundBusResponseMgr {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ForegroundBusResponseMgr f4410b = new ForegroundBusResponseMgr();
    private final Map<String, BusResponseCallback> a = new HashMap();

    public static ForegroundBusResponseMgr getInstance() {
        return f4410b;
    }

    public BusResponseCallback get(String str) {
        BusResponseCallback busResponseCallback;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.a) {
            busResponseCallback = this.a.get(str);
        }
        return busResponseCallback;
    }

    public void registerObserver(String str, BusResponseCallback busResponseCallback) {
        if (TextUtils.isEmpty(str) || busResponseCallback == null) {
            return;
        }
        synchronized (this.a) {
            if (!this.a.containsKey(str)) {
                this.a.put(str, busResponseCallback);
            }
        }
    }

    public void unRegisterObserver(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.a) {
            this.a.remove(str);
        }
    }
}
