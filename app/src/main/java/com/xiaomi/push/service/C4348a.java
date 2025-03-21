package com.xiaomi.push.service;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4233g;
import com.xiaomi.push.C4309r;
import com.xiaomi.push.service.C4355ag;

/* renamed from: com.xiaomi.push.service.a */
/* loaded from: classes2.dex */
public class C4348a {

    /* renamed from: a */
    private static final SparseArray<C4355ag.a<String, String, String>> f16494a = new SparseArray<C4355ag.a<String, String, String>>(6) { // from class: com.xiaomi.push.service.a.1
        {
            put(1, C4355ag.f16526g);
            put(2, C4355ag.f16525f);
            put(4, C4355ag.f16524e);
            put(8, C4355ag.f16521b);
            put(16, C4355ag.f16522c);
            put(32, C4355ag.f16527h);
        }
    };

    /* renamed from: a */
    private static int m15820a(String str, int i2) {
        return C4355ag.m15901a(C4309r.m15715a(), str, null, f16494a.get(i2));
    }

    /* renamed from: a */
    private static Bundle m15821a(String str) {
        return C4355ag.m15902a(C4309r.m15715a(), str, (String) null);
    }

    /* renamed from: a */
    public static int m15819a(Context context, String str) {
        int i2;
        int i3 = 0;
        if (context != null && !TextUtils.isEmpty(str)) {
            C4233g.b m14929a = C4233g.m14929a(context, str, true);
            if (m14929a == C4233g.b.ALLOWED) {
                i3 = 1;
            } else if (m14929a == C4233g.b.NOT_ALLOWED) {
                i3 = 2;
            }
            if (C4355ag.m15914a()) {
                Bundle m15821a = m15821a(str);
                if (m15821a.containsKey(C4355ag.f16526g.f16530c)) {
                    i3 |= m15821a.getBoolean(C4355ag.f16526g.f16530c) ? 4 : 8;
                }
                if (m15821a.containsKey(C4355ag.f16524e.f16530c)) {
                    i3 |= m15821a.getBoolean(C4355ag.f16524e.f16530c) ? 16 : 32;
                }
                if (m15821a.containsKey(C4355ag.f16525f.f16530c)) {
                    i3 |= m15821a.getBoolean(C4355ag.f16525f.f16530c) ? 64 : 128;
                }
                if (m15821a.containsKey(C4355ag.f16521b.f16530c)) {
                    i3 |= m15821a.getBoolean(C4355ag.f16521b.f16530c) ? 256 : 512;
                }
                if (m15821a.containsKey(C4355ag.f16522c.f16530c)) {
                    i3 |= m15821a.getBoolean(C4355ag.f16522c.f16530c) ? 1024 : 2048;
                }
                if (m15821a.containsKey(C4355ag.f16527h.f16530c)) {
                    return i3 | (m15821a.getBoolean(C4355ag.f16527h.f16530c) ? 4096 : 8192);
                }
                return i3;
            }
            int m15820a = m15820a(str, 1);
            if (m15820a == 1) {
                i3 |= 4;
            } else if (m15820a == 0) {
                i3 |= 8;
            }
            int m15820a2 = m15820a(str, 4);
            if (m15820a2 == 1) {
                i3 |= 16;
            } else if (m15820a2 == 0) {
                i3 |= 32;
            }
            int m15820a3 = m15820a(str, 2);
            if (m15820a3 == 1) {
                i3 |= 64;
            } else if (m15820a3 == 0) {
                i3 |= 128;
            }
            int m15820a4 = m15820a(str, 8);
            if (m15820a4 == 1) {
                i3 |= 256;
            } else if (m15820a4 == 0) {
                i3 |= 512;
            }
            int m15820a5 = m15820a(str, 16);
            if (m15820a5 == 1) {
                i3 |= 1024;
            } else if (m15820a5 == 0) {
                i3 |= 2048;
            }
            int m15820a6 = m15820a(str, 32);
            if (m15820a6 == 1) {
                i2 = i3 | 4096;
            } else {
                if (m15820a6 != 0) {
                    return i3;
                }
                i2 = i3 | 8192;
            }
            return i2;
        }
        AbstractC4022b.m13347a("context | packageName must not be null");
        return 0;
    }
}
