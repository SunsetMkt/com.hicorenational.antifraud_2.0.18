package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4265he;
import com.xiaomi.push.C4300j;
import com.xiaomi.push.C4309r;

/* renamed from: com.xiaomi.push.service.g */
/* loaded from: classes2.dex */
public class C4384g {

    /* renamed from: a */
    private static a f16706a;

    /* renamed from: a */
    private static b f16707a;

    /* renamed from: com.xiaomi.push.service.g$a */
    public interface a {
        /* renamed from: a */
        boolean m16097a(C4265he c4265he);
    }

    /* renamed from: com.xiaomi.push.service.g$b */
    public interface b {
    }

    /* renamed from: a */
    public static void m16095a(b bVar) {
        f16707a = bVar;
    }

    /* renamed from: a */
    public static boolean m16096a(C4265he c4265he) {
        if (f16706a == null || c4265he == null) {
            AbstractC4022b.m13347a("rc params is null, not cpra");
            return false;
        }
        if (C4300j.m15681a(C4309r.m15715a())) {
            return f16706a.m16097a(c4265he);
        }
        AbstractC4022b.m13347a("rc app not permission to cpra");
        return false;
    }
}
