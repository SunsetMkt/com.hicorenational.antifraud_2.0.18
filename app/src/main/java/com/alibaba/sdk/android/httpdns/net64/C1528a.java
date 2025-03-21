package com.alibaba.sdk.android.httpdns.net64;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.alibaba.sdk.android.httpdns.net64.a */
/* loaded from: classes.dex */
public class C1528a implements Net64Service {

    /* renamed from: a */
    private C1529b f3960a;

    /* renamed from: a */
    private ConcurrentHashMap<String, List<String>> f3961a;

    /* renamed from: o */
    private boolean f3962o;

    /* renamed from: p */
    private volatile boolean f3963p;

    /* renamed from: com.alibaba.sdk.android.httpdns.net64.a$a */
    private static final class a {

        /* renamed from: a */
        private static final C1528a f3964a = new C1528a();
    }

    private C1528a() {
        this.f3960a = new C1529b();
        this.f3961a = new ConcurrentHashMap<>();
    }

    /* renamed from: a */
    public static C1528a m3551a() {
        return a.f3964a;
    }

    /* renamed from: a */
    public List<String> m3552a(String str) {
        return this.f3961a.get(str);
    }

    /* renamed from: a */
    public void m3553a(String str, List<String> list) {
        this.f3961a.put(str, list);
    }

    /* renamed from: a */
    public boolean m3554a() {
        return this.f3962o;
    }

    @Override // com.alibaba.sdk.android.httpdns.net64.Net64Service
    public void enableIPv6(boolean z) {
        this.f3962o = z;
    }

    @Override // com.alibaba.sdk.android.httpdns.net64.Net64Service
    public String getIPv6ByHostAsync(String str) {
        List<String> list;
        if (this.f3962o && (list = this.f3961a.get(str)) != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    /* renamed from: i */
    public boolean m3555i() {
        return this.f3963p;
    }
}
