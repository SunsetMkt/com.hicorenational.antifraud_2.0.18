package com.xiaomi.push.service;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.xiaomi.push.g;
import com.xiaomi.push.service.ag;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static final SparseArray<ag.a<String, String, String>> a = new SparseArray<ag.a<String, String, String>>(6) { // from class: com.xiaomi.push.service.a.1
        {
            put(1, ag.f9351g);
            put(2, ag.f9350f);
            put(4, ag.f9349e);
            put(8, ag.f9346b);
            put(16, ag.f9347c);
            put(32, ag.f9352h);
        }
    };

    private static int a(String str, int i2) {
        return ag.a(com.xiaomi.push.r.m634a(), str, null, a.get(i2));
    }

    private static Bundle a(String str) {
        return ag.a(com.xiaomi.push.r.m634a(), str, (String) null);
    }

    public static int a(Context context, String str) {
        int i2;
        int i3 = 0;
        if (context != null && !TextUtils.isEmpty(str)) {
            g.b bVarA = com.xiaomi.push.g.a(context, str, true);
            if (bVarA == g.b.ALLOWED) {
                i3 = 1;
            } else if (bVarA == g.b.NOT_ALLOWED) {
                i3 = 2;
            }
            if (ag.a()) {
                Bundle bundleA = a(str);
                if (bundleA.containsKey(ag.f9351g.f9354c)) {
                    i3 |= bundleA.getBoolean(ag.f9351g.f9354c) ? 4 : 8;
                }
                if (bundleA.containsKey(ag.f9349e.f9354c)) {
                    i3 |= bundleA.getBoolean(ag.f9349e.f9354c) ? 16 : 32;
                }
                if (bundleA.containsKey(ag.f9350f.f9354c)) {
                    i3 |= bundleA.getBoolean(ag.f9350f.f9354c) ? 64 : 128;
                }
                if (bundleA.containsKey(ag.f9346b.f9354c)) {
                    i3 |= bundleA.getBoolean(ag.f9346b.f9354c) ? 256 : 512;
                }
                if (bundleA.containsKey(ag.f9347c.f9354c)) {
                    i3 |= bundleA.getBoolean(ag.f9347c.f9354c) ? 1024 : 2048;
                }
                if (bundleA.containsKey(ag.f9352h.f9354c)) {
                    return i3 | (bundleA.getBoolean(ag.f9352h.f9354c) ? 4096 : 8192);
                }
                return i3;
            }
            int iA = a(str, 1);
            if (iA == 1) {
                i3 |= 4;
            } else if (iA == 0) {
                i3 |= 8;
            }
            int iA2 = a(str, 4);
            if (iA2 == 1) {
                i3 |= 16;
            } else if (iA2 == 0) {
                i3 |= 32;
            }
            int iA3 = a(str, 2);
            if (iA3 == 1) {
                i3 |= 64;
            } else if (iA3 == 0) {
                i3 |= 128;
            }
            int iA4 = a(str, 8);
            if (iA4 == 1) {
                i3 |= 256;
            } else if (iA4 == 0) {
                i3 |= 512;
            }
            int iA5 = a(str, 16);
            if (iA5 == 1) {
                i3 |= 1024;
            } else if (iA5 == 0) {
                i3 |= 2048;
            }
            int iA6 = a(str, 32);
            if (iA6 == 1) {
                i2 = i3 | 4096;
            } else {
                if (iA6 != 0) {
                    return i3;
                }
                i2 = i3 | 8192;
            }
            return i2;
        }
        com.xiaomi.channel.commonutils.logger.b.m48a("context | packageName must not be null");
        return 0;
    }
}
