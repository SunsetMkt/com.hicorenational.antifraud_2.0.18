package com.huawei.hms.activity.internal;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ForegroundBusResponseMgr {

    /* renamed from: b */
    private static final ForegroundBusResponseMgr f7034b = new ForegroundBusResponseMgr();

    /* renamed from: a */
    private final Map<String, BusResponseCallback> f7035a = new HashMap();

    public static ForegroundBusResponseMgr getInstance() {
        return f7034b;
    }

    public BusResponseCallback get(String str) {
        BusResponseCallback busResponseCallback;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f7035a) {
            busResponseCallback = this.f7035a.get(str);
        }
        return busResponseCallback;
    }

    public void registerObserver(String str, BusResponseCallback busResponseCallback) {
        if (TextUtils.isEmpty(str) || busResponseCallback == null) {
            return;
        }
        synchronized (this.f7035a) {
            if (!this.f7035a.containsKey(str)) {
                this.f7035a.put(str, busResponseCallback);
            }
        }
    }

    public void unRegisterObserver(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f7035a) {
            this.f7035a.remove(str);
        }
    }
}
