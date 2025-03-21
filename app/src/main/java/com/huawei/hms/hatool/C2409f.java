package com.huawei.hms.hatool;

import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.hatool.f */
/* loaded from: classes.dex */
public class C2409f implements InterfaceRunnableC2412g {

    /* renamed from: a */
    private byte[] f7496a;

    /* renamed from: b */
    private String f7497b;

    /* renamed from: c */
    private String f7498c;

    /* renamed from: d */
    private String f7499d;

    /* renamed from: e */
    private String f7500e;

    /* renamed from: f */
    private List<C2399b1> f7501f;

    public C2409f(byte[] bArr, String str, String str2, String str3, String str4, List<C2399b1> list) {
        this.f7496a = (byte[]) bArr.clone();
        this.f7497b = str;
        this.f7498c = str2;
        this.f7500e = str3;
        this.f7499d = str4;
        this.f7501f = list;
    }

    /* renamed from: a */
    private C2434n0 m7101a(Map<String, String> map) {
        return AbstractC2454w.m7392a(this.f7497b, this.f7496a, map);
    }

    /* renamed from: a */
    private Map<String, String> m7102a() {
        return C2424k.m7193b(this.f7498c, this.f7500e, this.f7499d);
    }

    /* renamed from: b */
    private void m7103b() {
        C2398b0.m7042c().m7043a(new C2405d1(this.f7501f, this.f7498c, this.f7499d, this.f7500e));
    }

    @Override // java.lang.Runnable
    public void run() {
        C2452v.m7385c("hmsSdk", "send data running");
        int m7249b = m7101a(m7102a()).m7249b();
        if (m7249b != 200) {
            m7103b();
            return;
        }
        C2452v.m7383b("hmsSdk", "events PostRequest sendevent TYPE : %s, TAG : %s, resultCode: %d ,reqID:" + this.f7499d, this.f7500e, this.f7498c, Integer.valueOf(m7249b));
    }
}
