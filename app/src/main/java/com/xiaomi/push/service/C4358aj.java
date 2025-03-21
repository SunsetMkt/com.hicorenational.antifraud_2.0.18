package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4100bb;

/* renamed from: com.xiaomi.push.service.aj */
/* loaded from: classes2.dex */
public class C4358aj {

    /* renamed from: a */
    private static long f16537a = 0;

    /* renamed from: a */
    private static String f16538a = "";

    /* renamed from: a */
    public static String m15941a() {
        if (TextUtils.isEmpty(f16538a)) {
            f16538a = C4100bb.m13878a(4);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f16538a);
        long j2 = f16537a;
        f16537a = 1 + j2;
        sb.append(j2);
        return sb.toString();
    }

    /* renamed from: b */
    public static String m15943b() {
        return C4100bb.m13878a(32);
    }

    /* renamed from: a */
    public static String m15942a(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 32) {
            return str;
        }
        try {
            return "BlockId_" + str.substring(8);
        } catch (Exception e2) {
            AbstractC4022b.m13361d("Exception occurred when filtering registration packet id for log. " + e2);
            return "UnexpectedId";
        }
    }
}
