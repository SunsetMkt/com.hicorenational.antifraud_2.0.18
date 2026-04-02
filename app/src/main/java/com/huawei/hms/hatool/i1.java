package com.huawei.hms.hatool;

import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class i1 {
    private String a;

    /* JADX INFO: renamed from: b */
    private String f4747b;

    /* JADX INFO: renamed from: c */
    private String f4748c;

    /* JADX INFO: renamed from: d */
    private String f4749d;

    /* JADX INFO: renamed from: e */
    private long f4750e;

    public i1(String str, String str2, String str3, String str4, long j2) {
        this.a = str;
        this.f4747b = str2;
        this.f4748c = str3;
        this.f4749d = str4;
        this.f4750e = j2;
    }

    public void a() {
        v.c("StreamEventHandler", "Begin to handle stream events...");
        b1 b1Var = new b1();
        b1Var.b(this.f4748c);
        b1Var.d(this.f4747b);
        b1Var.a(this.f4749d);
        b1Var.c(String.valueOf(this.f4750e));
        if ("oper".equals(this.f4747b) && z.i(this.a, "oper")) {
            p0 p0VarA = y.a().a(this.a, this.f4750e);
            String strA = p0VarA.a();
            Boolean boolValueOf = Boolean.valueOf(p0VarA.b());
            b1Var.f(strA);
            b1Var.e(String.valueOf(boolValueOf));
        }
        String strReplace = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
        ArrayList arrayList = new ArrayList();
        arrayList.add(b1Var);
        new l0(this.a, this.f4747b, q0.g(), arrayList, strReplace).a();
    }
}
