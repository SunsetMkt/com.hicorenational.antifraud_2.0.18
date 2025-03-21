package com.umeng.p221ut.p222a.p224b;

import android.text.TextUtils;
import com.tencent.open.SocialOperation;
import com.umeng.p221ut.p222a.p225c.C3807b;
import com.umeng.p221ut.p222a.p225c.C3810e;
import com.umeng.p221ut.p226b.p227a.p228a.C3811a;

/* renamed from: com.umeng.ut.a.b.a */
/* loaded from: classes2.dex */
public class C3799a {

    /* renamed from: a */
    public int f13858a = -1;
    public long timestamp = 0;
    public String signature = "";
    public byte[] data = null;

    /* renamed from: b */
    public long f13859b = 0;

    /* renamed from: a */
    public static boolean m12764a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                C3810e.m12787b("", "result", str, SocialOperation.GAME_SIGNATURE, str2);
                if (str2.equals(C3811a.m12790a(C3807b.m12775c(str).getBytes(), 2))) {
                    C3810e.m12784a("", "signature is ok");
                    return true;
                }
                C3810e.m12784a("", "signature is error");
            }
        } catch (Exception e2) {
            C3810e.m12784a("", e2);
        }
        return false;
    }
}
