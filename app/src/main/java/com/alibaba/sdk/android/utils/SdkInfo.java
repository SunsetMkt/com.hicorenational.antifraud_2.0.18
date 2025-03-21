package com.alibaba.sdk.android.utils;

import java.util.Map;

/* loaded from: classes.dex */
public class SdkInfo {

    /* renamed from: a */
    String f4031a;

    /* renamed from: b */
    String f4032b;

    /* renamed from: c */
    String f4033c;

    /* renamed from: c */
    Map<String, String> f4034c;

    public SdkInfo setAppKey(String str) {
        this.f4033c = str;
        return this;
    }

    public SdkInfo setExt(Map<String, String> map) {
        this.f4034c = map;
        return this;
    }

    public SdkInfo setSdkId(String str) {
        this.f4031a = str;
        return this;
    }

    public SdkInfo setSdkVersion(String str) {
        this.f4032b = str;
        return this;
    }
}
