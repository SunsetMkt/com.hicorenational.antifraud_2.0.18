package com.xiaomi.push.service;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.xiaomi.push.C0334r;
import com.xiaomi.push.g;
import com.xiaomi.push.service.ag;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final SparseArray<ag.a<String, String, String>> f13313a = new SparseArray<ag.a<String, String, String>>(6) { // from class: com.xiaomi.push.service.a.1
        {
            put(1, ag.f13331g);
            put(2, ag.f13330f);
            put(4, ag.f13329e);
            put(8, ag.f13326b);
            put(16, ag.f13327c);
            put(32, ag.f13332h);
        }
    };

    private static int a(String str, int i2) {
        return ag.a(C0334r.m636a(), str, null, f13313a.get(i2));
    }

    private static Bundle a(String str) {
        return ag.a(C0334r.m636a(), str, (String) null);
    }

    public static int a(Context context, String str) {
        int i2;
        int i3 = 0;
        if (context != null && !TextUtils.isEmpty(str)) {
            g.b a2 = com.xiaomi.push.g.a(context, str, true);
            if (a2 == g.b.ALLOWED) {
                i3 = 1;
            } else if (a2 == g.b.NOT_ALLOWED) {
                i3 = 2;
            }
            if (ag.a()) {
                Bundle a3 = a(str);
                if (a3.containsKey(ag.f13331g.f13335c)) {
                    i3 |= a3.getBoolean(ag.f13331g.f13335c) ? 4 : 8;
                }
                if (a3.containsKey(ag.f13329e.f13335c)) {
                    i3 |= a3.getBoolean(ag.f13329e.f13335c) ? 16 : 32;
                }
                if (a3.containsKey(ag.f13330f.f13335c)) {
                    i3 |= a3.getBoolean(ag.f13330f.f13335c) ? 64 : 128;
                }
                if (a3.containsKey(ag.f13326b.f13335c)) {
                    i3 |= a3.getBoolean(ag.f13326b.f13335c) ? 256 : 512;
                }
                if (a3.containsKey(ag.f13327c.f13335c)) {
                    i3 |= a3.getBoolean(ag.f13327c.f13335c) ? 1024 : 2048;
                }
                if (a3.containsKey(ag.f13332h.f13335c)) {
                    return i3 | (a3.getBoolean(ag.f13332h.f13335c) ? 4096 : 8192);
                }
                return i3;
            }
            int a4 = a(str, 1);
            if (a4 == 1) {
                i3 |= 4;
            } else if (a4 == 0) {
                i3 |= 8;
            }
            int a5 = a(str, 4);
            if (a5 == 1) {
                i3 |= 16;
            } else if (a5 == 0) {
                i3 |= 32;
            }
            int a6 = a(str, 2);
            if (a6 == 1) {
                i3 |= 64;
            } else if (a6 == 0) {
                i3 |= 128;
            }
            int a7 = a(str, 8);
            if (a7 == 1) {
                i3 |= 256;
            } else if (a7 == 0) {
                i3 |= 512;
            }
            int a8 = a(str, 16);
            if (a8 == 1) {
                i3 |= 1024;
            } else if (a8 == 0) {
                i3 |= 2048;
            }
            int a9 = a(str, 32);
            if (a9 == 1) {
                i2 = i3 | 4096;
            } else {
                if (a9 != 0) {
                    return i3;
                }
                i2 = i3 | 8192;
            }
            return i2;
        }
        com.xiaomi.channel.commonutils.logger.b.m50a("context | packageName must not be null");
        return 0;
    }
}
