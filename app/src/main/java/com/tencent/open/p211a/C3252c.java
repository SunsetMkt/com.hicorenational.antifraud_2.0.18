package com.tencent.open.p211a;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.a.c */
/* loaded from: classes2.dex */
class C3252c implements InterfaceC3256g {

    /* renamed from: a */
    private String f11141a;

    /* renamed from: b */
    private int f11142b;

    /* renamed from: c */
    private int f11143c;

    /* renamed from: d */
    private int f11144d;

    /* renamed from: e */
    private String f11145e;

    /* renamed from: f */
    private Map<String, List<String>> f11146f = new HashMap();

    public C3252c(HttpURLConnection httpURLConnection, String str, int i2, int i3, int i4, String str2) {
        Map<String, List<String>> headerFields;
        this.f11141a = "";
        this.f11142b = 0;
        this.f11143c = 0;
        this.f11144d = 0;
        this.f11145e = "";
        this.f11141a = str;
        this.f11142b = i2;
        this.f11143c = i3;
        this.f11144d = i4;
        this.f11145e = str2;
        if (httpURLConnection == null || (headerFields = httpURLConnection.getHeaderFields()) == null) {
            return;
        }
        this.f11146f.putAll(headerFields);
    }

    @Override // com.tencent.open.p211a.InterfaceC3256g
    /* renamed from: a */
    public String mo10410a() {
        return this.f11141a;
    }

    @Override // com.tencent.open.p211a.InterfaceC3256g
    /* renamed from: b */
    public int mo10411b() {
        return this.f11142b;
    }

    @Override // com.tencent.open.p211a.InterfaceC3256g
    /* renamed from: c */
    public int mo10412c() {
        return this.f11143c;
    }

    @Override // com.tencent.open.p211a.InterfaceC3256g
    /* renamed from: d */
    public int mo10413d() {
        return this.f11144d;
    }

    public String toString() {
        return C3252c.class.getSimpleName() + '@' + hashCode() + "\ncontent = [" + this.f11141a + "]\nresponseSize = " + this.f11142b + "\nrequestSize = " + this.f11143c + "\nresultCode = " + this.f11144d + "\nerrorMsg = " + this.f11145e;
    }
}
