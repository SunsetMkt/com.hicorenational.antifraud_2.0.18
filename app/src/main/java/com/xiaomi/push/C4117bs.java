package com.xiaomi.push;

import com.xiaomi.push.C4121bw;

/* renamed from: com.xiaomi.push.bs */
/* loaded from: classes2.dex */
public class C4117bs extends C4121bw.d {

    /* renamed from: a */
    protected String f14660a;

    public C4117bs(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr);
        this.f14660a = "MessageDeleteJob";
        this.f14660a = str3;
    }

    /* renamed from: a */
    public static C4117bs m13952a(String str) {
        return new C4117bs(str, "status = ?", new String[]{String.valueOf(2)}, "a job build to delete uploaded job");
    }
}
