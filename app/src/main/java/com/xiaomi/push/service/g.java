package com.xiaomi.push.service;

import com.xiaomi.push.he;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static a a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static b f1043a;

    public interface a {
        boolean a(he heVar);
    }

    public interface b {
    }

    public static void a(b bVar) {
        f1043a = bVar;
    }

    public static boolean a(he heVar) {
        if (a == null || heVar == null) {
            com.xiaomi.channel.commonutils.logger.b.m48a("rc params is null, not cpra");
            return false;
        }
        if (com.xiaomi.push.j.m625a(com.xiaomi.push.r.m634a())) {
            return a.a(heVar);
        }
        com.xiaomi.channel.commonutils.logger.b.m48a("rc app not permission to cpra");
        return false;
    }
}
