package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4096ay;
import com.xiaomi.push.C4260h;
import com.xiaomi.push.C4262hb;
import com.xiaomi.push.C4267hg;
import com.xiaomi.push.C4276hp;
import com.xiaomi.push.C4281hu;

/* renamed from: com.xiaomi.push.service.l */
/* loaded from: classes2.dex */
public class C4389l {
    /* renamed from: a */
    static void m16116a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("ext_fcm_container_buffer");
        String stringExtra2 = intent.getStringExtra("mipush_app_package");
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
            return;
        }
        try {
            byte[] m16119b = m16119b(Base64.decode(stringExtra, 2), context.getSharedPreferences("mipush_apps_scrt", 0).getString(stringExtra2, null));
            if (m16119b != null) {
                C4402x.m16304a(context, C4399u.m16236a(m16119b), m16119b);
            } else {
                AbstractC4022b.m13347a("notify fcm notification error ：dencrypt failed");
            }
        } catch (Throwable th) {
            AbstractC4022b.m13349a("notify fcm notification error ", th);
        }
    }

    /* renamed from: b */
    public static byte[] m16119b(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            AbstractC4022b.m13347a("secret is empty, return null");
            return null;
        }
        try {
            return C4260h.m15241a(C4096ay.m13840a(str), bArr);
        } catch (Exception e2) {
            AbstractC4022b.m13349a("dencryption error. ", e2);
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m16118a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            AbstractC4022b.m13347a("secret is empty, return null");
            return null;
        }
        try {
            return C4260h.m15242b(C4096ay.m13840a(str), bArr);
        } catch (Exception e2) {
            AbstractC4022b.m13349a("encryption error. ", e2);
            return null;
        }
    }

    /* renamed from: a */
    public static C4267hg m16115a(C4262hb c4262hb) {
        byte[] m15276a = c4262hb.m15276a();
        C4267hg c4267hg = new C4267hg();
        try {
            C4276hp.m15566a(c4267hg, m15276a);
            return c4267hg;
        } catch (C4281hu unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static void m16117a(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        context.getSharedPreferences("mipush_apps_scrt", 0).edit().putString(str, str2).apply();
    }
}
