package com.alibaba.sdk.android.utils;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class SdkInfo {
    String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f2625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f2626c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    Map<String, String> f44c;

    public SdkInfo setAppKey(String str) {
        this.f2626c = str;
        return this;
    }

    public SdkInfo setExt(Map<String, String> map) {
        this.f44c = map;
        return this;
    }

    public SdkInfo setSdkId(String str) {
        this.a = str;
        return this;
    }

    public SdkInfo setSdkVersion(String str) {
        this.f2625b = str;
        return this;
    }
}
