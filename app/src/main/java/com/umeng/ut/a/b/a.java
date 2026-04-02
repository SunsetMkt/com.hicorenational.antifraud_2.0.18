package com.umeng.ut.a.b;

import android.text.TextUtils;
import com.tencent.open.SocialOperation;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public int a = -1;
    public long timestamp = 0;
    public String signature = "";
    public byte[] data = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f8420b = 0;

    public static boolean a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                com.umeng.ut.a.c.e.b("", "result", str, SocialOperation.GAME_SIGNATURE, str2);
                if (str2.equals(com.umeng.ut.b.a.a.a.a(com.umeng.ut.a.c.b.c(str).getBytes(), 2))) {
                    com.umeng.ut.a.c.e.m42a("", "signature is ok");
                    return true;
                }
                com.umeng.ut.a.c.e.m42a("", "signature is error");
            }
        } catch (Exception e2) {
            com.umeng.ut.a.c.e.m42a("", e2);
        }
        return false;
    }
}
