package com.huawei.hms.p182ui;

import android.os.Bundle;
import com.huawei.hms.base.p172ui.LogUtil;

/* loaded from: classes.dex */
public class SafeBundle {

    /* renamed from: a */
    private final Bundle f7903a;

    public SafeBundle() {
        this(new Bundle());
    }

    public boolean containsKey(String str) {
        try {
            return this.f7903a.containsKey(str);
        } catch (Throwable unused) {
            LogUtil.m6683e("SafeBundle", "containsKey exception. key:");
            return false;
        }
    }

    public Object get(String str) {
        try {
            return this.f7903a.get(str);
        } catch (Exception e2) {
            LogUtil.m6684e("SafeBundle", "get exception: " + e2.getMessage(), true);
            return null;
        }
    }

    public Bundle getBundle() {
        return this.f7903a;
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public String getString(String str) {
        try {
            return this.f7903a.getString(str);
        } catch (Throwable th) {
            LogUtil.m6684e("SafeBundle", "getString exception: " + th.getMessage(), true);
            return "";
        }
    }

    public boolean isEmpty() {
        try {
            return this.f7903a.isEmpty();
        } catch (Exception unused) {
            LogUtil.m6683e("SafeBundle", "isEmpty exception");
            return true;
        }
    }

    public int size() {
        try {
            return this.f7903a.size();
        } catch (Exception unused) {
            LogUtil.m6683e("SafeBundle", "size exception");
            return 0;
        }
    }

    public String toString() {
        return this.f7903a.toString();
    }

    public SafeBundle(Bundle bundle) {
        this.f7903a = bundle == null ? new Bundle() : bundle;
    }

    public int getInt(String str, int i2) {
        try {
            return this.f7903a.getInt(str, i2);
        } catch (Throwable th) {
            LogUtil.m6684e("SafeBundle", "getInt exception: " + th.getMessage(), true);
            return i2;
        }
    }

    public String getString(String str, String str2) {
        try {
            return this.f7903a.getString(str, str2);
        } catch (Exception e2) {
            LogUtil.m6684e("SafeBundle", "getString exception: " + e2.getMessage(), true);
            return str2;
        }
    }
}
