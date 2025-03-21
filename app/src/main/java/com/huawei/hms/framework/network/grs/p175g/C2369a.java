package com.huawei.hms.framework.network.grs.p175g;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.p173e.C2363c;
import java.util.concurrent.Callable;

/* renamed from: com.huawei.hms.framework.network.grs.g.a */
/* loaded from: classes.dex */
public class C2369a {

    /* renamed from: a */
    protected C2372d f7372a;

    /* renamed from: b */
    private final String f7373b;

    /* renamed from: c */
    private final C2371c f7374c;

    /* renamed from: d */
    private final int f7375d;

    /* renamed from: e */
    private final Context f7376e;

    /* renamed from: f */
    private final String f7377f;

    /* renamed from: g */
    private final GrsBaseInfo f7378g;

    /* renamed from: h */
    private final C2363c f7379h;

    public C2369a(String str, int i2, C2371c c2371c, Context context, String str2, GrsBaseInfo grsBaseInfo, C2363c c2363c) {
        this.f7373b = str;
        this.f7374c = c2371c;
        this.f7375d = i2;
        this.f7376e = context;
        this.f7377f = str2;
        this.f7378g = grsBaseInfo;
        this.f7379h = c2363c;
    }

    /* renamed from: a */
    public Context m6891a() {
        return this.f7376e;
    }

    /* renamed from: b */
    public C2371c m6892b() {
        return this.f7374c;
    }

    /* renamed from: c */
    public String m6893c() {
        return this.f7373b;
    }

    /* renamed from: d */
    public int m6894d() {
        return this.f7375d;
    }

    /* renamed from: e */
    public String m6895e() {
        return this.f7377f;
    }

    /* renamed from: f */
    public C2363c m6896f() {
        return this.f7379h;
    }

    /* renamed from: g */
    public Callable<C2372d> m6897g() {
        return new CallableC2374f(this.f7373b, this.f7375d, this.f7374c, this.f7376e, this.f7377f, this.f7378g, this.f7379h);
    }
}
