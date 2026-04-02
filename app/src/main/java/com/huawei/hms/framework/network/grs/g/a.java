package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class a {
    protected d a;

    /* JADX INFO: renamed from: b */
    private final String f4628b;

    /* JADX INFO: renamed from: c */
    private final c f4629c;

    /* JADX INFO: renamed from: d */
    private final int f4630d;

    /* JADX INFO: renamed from: e */
    private final Context f4631e;

    /* JADX INFO: renamed from: f */
    private final String f4632f;

    /* JADX INFO: renamed from: g */
    private final GrsBaseInfo f4633g;

    /* JADX INFO: renamed from: h */
    private final com.huawei.hms.framework.network.grs.e.c f4634h;

    public a(String str, int i2, c cVar, Context context, String str2, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.c cVar2) {
        this.f4628b = str;
        this.f4629c = cVar;
        this.f4630d = i2;
        this.f4631e = context;
        this.f4632f = str2;
        this.f4633g = grsBaseInfo;
        this.f4634h = cVar2;
    }

    public Context a() {
        return this.f4631e;
    }

    public c b() {
        return this.f4629c;
    }

    public String c() {
        return this.f4628b;
    }

    public int d() {
        return this.f4630d;
    }

    public String e() {
        return this.f4632f;
    }

    public com.huawei.hms.framework.network.grs.e.c f() {
        return this.f4634h;
    }

    public Callable<d> g() {
        return new f(this.f4628b, this.f4630d, this.f4629c, this.f4631e, this.f4632f, this.f4633g, this.f4634h);
    }
}
