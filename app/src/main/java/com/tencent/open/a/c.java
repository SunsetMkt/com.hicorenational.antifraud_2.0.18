package com.tencent.open.a;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes2.dex */
class c implements g {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f6802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f6803e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, List<String>> f6804f = new HashMap();

    public c(HttpURLConnection httpURLConnection, String str, int i2, int i3, int i4, String str2) {
        Map<String, List<String>> headerFields;
        this.a = "";
        this.f6800b = 0;
        this.f6801c = 0;
        this.f6802d = 0;
        this.f6803e = "";
        this.a = str;
        this.f6800b = i2;
        this.f6801c = i3;
        this.f6802d = i4;
        this.f6803e = str2;
        if (httpURLConnection == null || (headerFields = httpURLConnection.getHeaderFields()) == null) {
            return;
        }
        this.f6804f.putAll(headerFields);
    }

    @Override // com.tencent.open.a.g
    public String a() {
        return this.a;
    }

    @Override // com.tencent.open.a.g
    public int b() {
        return this.f6800b;
    }

    @Override // com.tencent.open.a.g
    public int c() {
        return this.f6801c;
    }

    @Override // com.tencent.open.a.g
    public int d() {
        return this.f6802d;
    }

    public String toString() {
        return c.class.getSimpleName() + '@' + hashCode() + "\ncontent = [" + this.a + "]\nresponseSize = " + this.f6800b + "\nrequestSize = " + this.f6801c + "\nresultCode = " + this.f6802d + "\nerrorMsg = " + this.f6803e;
    }
}
