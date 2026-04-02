package com.huawei.hms.hatool;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class f implements g {
    private byte[] a;

    /* JADX INFO: renamed from: b */
    private String f4719b;

    /* JADX INFO: renamed from: c */
    private String f4720c;

    /* JADX INFO: renamed from: d */
    private String f4721d;

    /* JADX INFO: renamed from: e */
    private String f4722e;

    /* JADX INFO: renamed from: f */
    private List<b1> f4723f;

    public f(byte[] bArr, String str, String str2, String str3, String str4, List<b1> list) {
        this.a = (byte[]) bArr.clone();
        this.f4719b = str;
        this.f4720c = str2;
        this.f4722e = str3;
        this.f4721d = str4;
        this.f4723f = list;
    }

    private n0 a(Map<String, String> map) {
        return w.a(this.f4719b, this.a, map);
    }

    private Map<String, String> a() {
        return k.b(this.f4720c, this.f4722e, this.f4721d);
    }

    private void b() {
        b0.c().a(new d1(this.f4723f, this.f4720c, this.f4721d, this.f4722e));
    }

    @Override // java.lang.Runnable
    public void run() {
        v.c("hmsSdk", "send data running");
        int iB = a(a()).b();
        if (iB != 200) {
            b();
            return;
        }
        v.b("hmsSdk", "events PostRequest sendevent TYPE : %s, TAG : %s, resultCode: %d ,reqID:" + this.f4721d, this.f4722e, this.f4720c, Integer.valueOf(iB));
    }
}
