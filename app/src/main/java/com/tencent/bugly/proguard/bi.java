package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public final class bi extends m {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static byte[] f6478i = new byte[1];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static Map<String, String> f6479j;
    public byte a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6480b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f6481c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f6482d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f6483e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f6484f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f6485g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, String> f6486h = null;

    static {
        f6478i[0] = 0;
        f6479j = new HashMap();
        f6479j.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.b(this.a, 0);
        lVar.a(this.f6480b, 1);
        byte[] bArr = this.f6481c;
        if (bArr != null) {
            lVar.a(bArr, 2);
        }
        String str = this.f6482d;
        if (str != null) {
            lVar.a(str, 3);
        }
        lVar.a(this.f6483e, 4);
        String str2 = this.f6484f;
        if (str2 != null) {
            lVar.a(str2, 5);
        }
        String str3 = this.f6485g;
        if (str3 != null) {
            lVar.a(str3, 6);
        }
        Map<String, String> map = this.f6486h;
        if (map != null) {
            lVar.a((Map) map, 7);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        this.a = kVar.a(this.a, 0, true);
        this.f6480b = kVar.a(this.f6480b, 1, true);
        this.f6481c = kVar.a(f6478i, 2, false);
        this.f6482d = kVar.a(3, false);
        this.f6483e = kVar.a(this.f6483e, 4, false);
        this.f6484f = kVar.a(5, false);
        this.f6485g = kVar.a(6, false);
        this.f6486h = (Map) kVar.a(f6479j, 7, false);
    }
}
